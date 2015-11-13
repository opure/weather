package com.vanvalt.util.date;

/**
 * 提供所有与日期时间操作相关的公用函数
 */

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

public class DateUtils2 {
	public final static String FM_PATTERN_CN_MD_HM = "MM月dd日 HH:mm";

    public final static String FM_PATTERN_CN_MD_NO = "MM月dd日";

    public final static String FM_PATTERN_CN_YMD_HM = "yyyy年MM月dd日 HH:mm";

    public final static String FM_PATTERN_CN_YMD_NO = "yyyy年MM月dd日";

    public final static String FM_PATTERN_CN_YM_NO = "yyyy年MM月";

    public final static String FM_PATTERN_EN_MD_HM = "MM-dd HH:mm";

    public final static String FM_PATTERN_EN_MD_NO = "MM-dd";

    public final static String FM_PATTERN_EN_YMD_HM = "yyyy/MM/dd HH:mm";

    public final static String FM_PATTERN_EN_YMD_NO = "yyyy/MM/dd";

    public final static String FM_PATTERN_EN_YM_NO = "yyyy/MM";
    /**
     * 返回系统日期
     * @return
     */
    public static java.sql.Date getNowDate() {
        Calendar cal = Calendar.getInstance();
        return new java.sql.Date(cal.getTimeInMillis());
    }
    /**
     * 返回系统时间
     * @return 形式为2007-04-17 11:15:33.372
     */
    public static java.sql.Timestamp getNowTimestamp() {
        Calendar cal = Calendar.getInstance();
        return new java.sql.Timestamp(cal.getTimeInMillis());
        
    }

    public static long getNowDateTimeLong() {
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }
    /**
     * 返回系统时间
     * @return 形式为：2007-04-17 11:15
     */
    public static String getNowDateTimeString() {
        Calendar cal = Calendar.getInstance();
        long millis = cal.getTimeInMillis();
        return formatDateLong(millis);
    }

    public static Date getDate(long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        return cal.getTime();
    }

    public static java.sql.Date getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    public static java.sql.Date getDate(String dateString) {
        return java.sql.Date.valueOf(dateString);
    }

    public static String formatDateShort(long millis) {
        String pattern = "MM-dd HH:mm";
        String date = DateFormatUtils.format(millis, pattern);
        return date;
    }
    
    public static String formatDatetimeShort(long millis) {
        String pattern = "HH:mm";
        String date = DateFormatUtils.format(millis, pattern);
        return date;
    }

    public static String formatDateLong(long millis) {
        String pattern = "yyyy-MM-dd HH:mm";
        String date = DateFormatUtils.format(millis, pattern, Locale.CHINA);
        return date;
    }

    public static String formatDateChinese(long millis) {
        String pattern = "yyyy-MM-dd HH:mm";
        String date = DateFormatUtils.format(millis, pattern, Locale.CHINA);
        return date;
    }

    public static String fotmatDate1(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy年MM月dd日 HH时mm分ss秒");
        String strDate = formatter.format(myDate);
        return strDate;
    }

    public static String fotmatDate2(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        String strDate = formatter.format(myDate);
        return strDate;
    }

    public static String fotmatDate3(Date myDate) {
        String strDate = null;
        if (myDate == null)
            strDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        strDate = formatter.format(myDate);
        return strDate;
    }

    public static String fotmatDate4(Date myDate) {
        String strDate = null;
        if (myDate == null)
            strDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        strDate = formatter.format(myDate);
        return strDate;
    }

    public static String fotmatDate5(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = formatter.format(myDate);
        return strDate;
    }

    public static String fotmatDate6(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
        String strDate = formatter.format(myDate);
        return strDate;
    }

    public static String fotmatDate7(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String strDate = formatter.format(myDate);
        return strDate;
    }

    /**
     * 将java.sql.Date类对象转换为java.sql.Timestamp类对象， 时间部分为"00:00:00.000"
     * 
     * @param date java.sql.Date 要转换的Date型对象
     * @return java.sql.Timestamp 转换后的Timestamp型对象
     */
    public static Timestamp convertDateToTimestampMin(java.sql.Date date) {
        return Timestamp.valueOf(date.toString() + " 00:00:00.000");
        
    }

    /**
     * 将java.sql.Date类对象转换为java.sql.Timestamp类对象， 时间部分为"23:59:59.999"
     * 
     * @param date java.sql.Date 要转换的Date型对象
     * @return java.sql.Timestamp 转换后的Timestamp型对象
     */
    public static Timestamp convertDateToTimestampMax(java.sql.Date date) {
        return Timestamp.valueOf(date.toString() + " 23:59:59.999");
    }

    /**
     * 功能：用于获取指定日期该月的所有日期
     * 
     * @param date java.sql.Date 要获取的月日期列表的指定日期
     * @return Date[] java.sql.Date 返回的日期列表
     */
    public static java.sql.Date[] getMonthDays(java.sql.Date date) {

        Calendar cale = Calendar.getInstance();
        cale.setTime(date);

        int today = cale.get(Calendar.DAY_OF_MONTH);
        int days = cale.getActualMaximum(Calendar.DAY_OF_MONTH);
        long millis = cale.getTimeInMillis();

        java.sql.Date dates[] = new java.sql.Date[days];
        for (int i = 1; i <= days; i++) {
            long sub = (today - i) * 24 * 60 * 60 * 1000L;
            dates[i - 1] = new java.sql.Date(millis - sub);
        }

        cale = null;
        return dates;
    }

    /**
     * 功能：用于获取指定日期该周的所有日期
     * 
     * @param date java.sql.Date 要获取的周日期列表的指定日期
     * @return Date[] java.sql.Date 返回的日期列表
     */
    public static java.sql.Date[] getWeekDays(java.sql.Date date) {
    	//System.out.println(date.toString());
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.setFirstDayOfWeek(Calendar.SUNDAY);
        int days = 8;
        int today = cale.get(Calendar.DAY_OF_WEEK);
        long millis = cale.getTimeInMillis();

        java.sql.Date dates[] = new java.sql.Date[days];
        for (int i = 1; i <= days; i++) {
            long sub = (today - i) * 24 * 60 * 60 * 1000L;
            dates[i-1] = new java.sql.Date(millis - sub);
        }

        cale = null;
        return dates;
    }
    /**
     * 根据开始时间和结束时间返回相应的时间段字符串，如果开始时间和结束时间在同一天，
     * 则返回的格式为“X点X分-X点X分”，如果不在同一天，返回的格式为“X月X日-X月X日”
     * 
     * @param startTime 开始时间
     * 
     * @param endTime 结束时间
     * 
     * @return 返回的时间段字符串
     */
    public static String getTimeSlice(Timestamp startTime, Timestamp endTime) {

        String rtn = "";

        Calendar caleStart = Calendar.getInstance();
        Calendar caleEnd = Calendar.getInstance();
        caleStart.setTimeInMillis(startTime.getTime());
        caleEnd.setTimeInMillis(endTime.getTime());

        String dayStart = caleStart.get(Calendar.YEAR) + "年"
                + (caleStart.get(Calendar.MONTH) + 1) + "月"
                + caleStart.get(Calendar.DAY_OF_MONTH) + "日";
        String dayEnd = caleEnd.get(Calendar.YEAR) + "年"
                + (caleEnd.get(Calendar.MONTH) + 1) + "月"
                + caleEnd.get(Calendar.DAY_OF_MONTH) + "日";

        if (dayStart.equals(dayEnd)) {
            //同一天
            rtn = caleStart.get(Calendar.HOUR_OF_DAY) + "点"
                    + caleStart.get(Calendar.MINUTE) + "分-"
                    + caleEnd.get(Calendar.HOUR_OF_DAY) + "点"
                    + caleEnd.get(Calendar.MINUTE) + "分";
        } else {
            //不在同一天
            rtn = (caleStart.get(Calendar.MONTH) + 1) + "月"
                    + caleStart.get(Calendar.DAY_OF_MONTH) + "日" + "-"
                    + (caleEnd.get(Calendar.MONTH) + 1) + "月"
                    + caleEnd.get(Calendar.DAY_OF_MONTH) + "日";
        }

        caleStart = null;
        caleEnd = null;
        return rtn;
    }

    /**
     * 根据日期获得日期星期几格式的字符串，如“2004-07-28 星期三”
     * 
     * @param date 指定的日期
     * 
     * @return 返回的日期星期几格式的字符串
     */
    public static String getDayWeek(java.sql.Date date) {

        String days[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.setFirstDayOfWeek(Calendar.SUNDAY);

        return date.toString() + " " + days[cale.get(Calendar.DAY_OF_WEEK) - 1];
    }
    
    
    public static String getDayWeek2(java.sql.Date date) {

        String days[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.setFirstDayOfWeek(Calendar.SUNDAY);

        return  days[cale.get(Calendar.DAY_OF_WEEK) - 1];
    }
    
    

    /**
     * 获得指定日期所在月最小时间，时间部分为“00:00:00.000” 例如：param:2004-08-20 return:2004-08-01
     * 00.00.00.000
     * 
     * @param date 指定的日期
     * @return 指定日期所在月的最小时间
     */
    public static Timestamp getMinDayInMonth(java.sql.Date date) {

        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, cale
                .getActualMinimum(Calendar.DAY_OF_MONTH));
        java.sql.Date newDate = new java.sql.Date(cale.getTimeInMillis());

        cale = null;
        return Timestamp.valueOf(newDate.toString() + " 00:00:00.000");

    }
    /*
     * param:2004-08-20 return:2004-08-01
     */
    public static String getMinDayInMonth2(java.sql.Date date) {

        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, cale
                .getActualMinimum(Calendar.DAY_OF_MONTH));
        java.sql.Date newDate = new java.sql.Date(cale.getTimeInMillis());

        cale = null;
        return newDate.toString() + "";

    }

    /**
     * 获得指定日期所在月的最大时间，时间部分为“23.59.59.999” 例如：param:2004-08-20,return:2004-08-31
     * 23.59.59.999
     * 
     * @param date
     * @return
     */
    public static Timestamp getMaxDayInMonth(java.sql.Date date) {

        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, cale
                .getActualMaximum(Calendar.DAY_OF_MONTH));
        java.sql.Date newDate = new java.sql.Date(cale.getTimeInMillis());

        cale = null;
        return Timestamp.valueOf(newDate.toString() + " 23:59:59.999");
    }

    /*
     * 
     */
    public static String getMaxDayInMonth2(java.sql.Date date) {

        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, cale
                .getActualMaximum(Calendar.DAY_OF_MONTH));
        java.sql.Date newDate = new java.sql.Date(cale.getTimeInMillis());

        cale = null;
        return newDate.toString() + "";
    }
    public static String strNowtime() {
        String dateString = "";
        try {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
                    "yyyy-MM-dd-hh-mm-ss");
            java.util.Date currentTime_1 = new java.util.Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }
    
    public static String strNowtimeS() {
        String dateString = "";
        try {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
                    "yyyy-MM-dd-hh-mm-ss-S");
            java.util.Date currentTime_1 = new java.util.Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }
    /*
     * 获取当前年月 返回 201012
     */
    public static String getNowYearMonth() {
        String dateString = "";
        try {
       
        	dateString=getThisYear()+getThisMonth()+"";
        	
        	
        } catch (Exception e) {
        }
        return dateString;
    }
    
    
    /*
     * 获取当前的小时数
     */
    public static int getHour(){
    	
    	Calendar c=Calendar.getInstance();
    	Date date=c.getTime();
    	return date.getHours();
    	
    }
    
   /*
    * 获取当前分钟
    */ 
    public static int getMinute(){
    	Calendar c=Calendar.getInstance();
    	Date date=c.getTime();
    	return date.getMinutes();
    	
    }
    
    

    /**
     * 得到当前年-月
     * @return
     */

    public static String GetPath() {
        String dateString = "";
        try {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
                    "yyyy-MM");
            java.util.Date currentTime_1 = new java.util.Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }

    /**
     * 得到当前年 2011
     * @return String
     */

    public static String getThisYear() {
        String dateString = "";
        try {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
                    "yyyy");
            java.util.Date currentTime_1 = new java.util.Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }
    /**
     * 得到当前日
     * @return String
     */

    public static String getThisDay() {
        String dateString = "";
        try {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
                    "dd");
            java.util.Date currentTime_1 = new java.util.Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }
    /**
     * 得到当前月
     * @return String
     */

    public static String getThisMonth() {
        String dateString = "";
        try {
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
                    "MM");
            java.util.Date currentTime_1 = new java.util.Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception e) {
        }
        return dateString;
    }

   
    // 得到当前季度
    
    public static String getThisQuarter() {
        String quarter = "";
        String month = getThisMonth();
        if (month.equals("01") || month.equals("02") || month.equals("03")) {
            quarter = "第一季度";
        } else if (month.equals("04") || month.equals("05")
                || month.equals("06")) {
            quarter = "第二季度";
        } else if (month.equals("07") || month.equals("08")
                || month.equals("09")) {
            quarter = "第三季度";
        } else {
            quarter = "第四季度";
        }
        return quarter;
    }
    
    //判断是不是润年
    public static boolean SmoothYear(){
    	boolean smoothYear=true;
    	int year=Integer.parseInt(getThisYear());
    	if(year%4==0&&year%100==0){
    		if(year%400==0){
    			smoothYear=false;
    		}
    		
    	}else{
    		smoothYear=false;
    	}
    	return smoothYear;

    }
    //判断每个月最多有多少天
    public static String getMaxDays(){
    	
    	String maxDays="";
    	int month=Integer.parseInt(getThisMonth());
    	switch(month){
    	  case 1:maxDays="31";break;
    	  case 2:if(SmoothYear())maxDays="29";else maxDays="28";break;
    	  case 3:maxDays="31";break;
    	  case 4:maxDays="30";break;
    	  case 5:maxDays="31";break;
    	  case 6:maxDays="30";break;
    	  case 7:maxDays="31";break;
    	  case 8:maxDays="31";break;
    	  case 9:maxDays="30";break;
    	  case 10:maxDays="31";break;
    	  case 11:maxDays="30";break;
    	  case 12:maxDays="31";break;	  
    	
    	
    	
    	}
    	return maxDays;
    	
    }
    //判断每个月最多有多少天
    public static String getMaxDays(String Month){
    	
    	String maxDays="";
    	int month=Integer.parseInt(Month);
    	switch(month){
    	  case 1:maxDays="31";break;
    	  case 2:if(SmoothYear())maxDays="29";else maxDays="28";break;
    	  case 3:maxDays="31";break;
    	  case 4:maxDays="30";break;
    	  case 5:maxDays="31";break;
    	  case 6:maxDays="30";break;
    	  case 7:maxDays="31";break;
    	  case 8:maxDays="31";break;
    	  case 9:maxDays="30";break;
    	  case 10:maxDays="31";break;
    	  case 11:maxDays="30";break;
    	  case 12:maxDays="31";break;	  
    	
    	
    	
    	}
    	return maxDays;
    	
    }   
    //判断每个月的第一天是星期几
    
    public static String getWeekDay(){
    	
    	String weekDay="";
    	String thisyear=getThisYear();
    	String thismonth=getThisMonth();
    	String date=thisyear+"-"+thismonth+"-"+"01";
    	Date da=getDate(date);
    	weekDay=Integer.toString(da.getDay());
    	return weekDay;
    	
    }
    
    /**
     * 根据stringdate--->Timestamp
     * @param dateString
     * @param seperator
     * @return
     */
    public static Timestamp stringParseTimestamp(String dateString,
			char seperator) {
		if ("".equals(dateString) || null == dateString)
			return null;
		DateFormat format = new SimpleDateFormat("yyyy" + seperator + "MM"
				+ seperator + "dd" + " hh:mm");
		Date now = null;
		try {
			now = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		return new Timestamp(cal.getTimeInMillis());
	}
    
    
//  日期与年龄的转化
	/**
	 * 根据生日算出现在的年龄
	 */
    public static String getAgeNum(String birthday) {
        String stempyear="";
        String stempmonth="";
        int itemp=0;
        int imonth;
        if (birthday!=null) {
            
            String[] birthdays = StringUtils.split(birthday,'-');
            stempyear = birthdays[0];
            stempmonth = birthdays[1];
            imonth=Calendar.getInstance().get(Calendar.MONTH)+1;
            if (Integer.parseInt(stempmonth)<imonth) {
                 itemp=Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(stempyear);
                
            } else {
                 itemp=Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(stempyear)-1;
            }
           
            if (itemp<=0) {
                itemp=1;
            }
            
        }
        
        return itemp+"";
    }
    
	/**
	 * 根据参数获取系统时间的前N天或者后N天
	 * @param day    当day为正时:代表获取系统时间的后day天  当day为负时:代表获取系统时间的前day天
	 * @return
	 */
	public static String getTimeSegment(int day) {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(DateUtils2.getThisYear()));
		cal.set(Calendar.MONTH, Integer.parseInt(DateUtils2.getThisMonth())-1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(DateUtils2.getThisDay()));
		Date date=cal.getTime();
		cal.add(Calendar.DATE, day);
		date=cal.getTime();
		return df.format(date);
	}
    
	/**
	 * 根据参数获取系统时间的前N天或者后N天
	 * @param day    当day为正时:代表获取系统时间的后day天  当day为负时:代表获取系统时间的前day天
	 * @return
	 */
	public static String getFullTimeSegment(int day) {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(DateUtils2.getThisYear()));
		cal.set(Calendar.MONTH, Integer.parseInt(DateUtils2.getThisMonth())-1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(DateUtils2.getThisDay()));
		Date date=cal.getTime();
		cal.add(Calendar.DATE, day);
		date=cal.getTime();
		return df.format(date);
	}
    
    /**
     * 转换负数  Double
     * @param birthday
     * @return
     */
   // public static String getNegative(String num) {
    	//return Double.toString(MathUtils.sub(Double.parseDouble(num),Double.parseDouble(num)*2));
   // }
    /**
     * 转换负数  int
     * @param birthday
     * @return
     */
    public static String getNegativeInt(String num) {
    	return String.valueOf(Integer.parseInt(num)-Integer.parseInt(num)*2);
    }
    
    /**   
     * @param date1 需要比较的时间 不能为空(null),需要正确的日期格式   
     * @param date2 被比较的时间  为空(null)则为当前时间   
     * @param stype 返回值类型   0为多少天，1为多少个月，2为多少年   
     * @return   
     */  
    public static int compareDate(String date1,String date2,int stype){   
        int n = 0;   
           
        String[] u = {"天","月","年"};   
        String formatStyle = stype==1?"yyyy-MM":"yyyy-MM-dd";   
           
        date2 = date2==null?DateUtils2.getCurrentDate():date2;   
           
        DateFormat df = new SimpleDateFormat(formatStyle);   
        Calendar c1 = Calendar.getInstance();   
        Calendar c2 = Calendar.getInstance();   
        try {   
            c1.setTime(df.parse(date1));   
            c2.setTime(df.parse(date2));   
        } catch (Exception e3) {   
            System.out.println("wrong occured");   
        }   
        //List list = new ArrayList();   
        while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果   
            //list.add(df.format(c1.getTime()));    // 这里可以把间隔的日期存到数组中 打印出来   
            n++;   
            if(stype==1){   
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1   
            }   
            else{   
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1   
            }   
        }   
           
        //n = n-1;   
           
        if(stype==2){   
            n = (int)n/365;   
        }      
           
       // System.out.println(date1+" -- "+date2+" 相差多少"+u[stype]+":"+n);         
        return n;   
    }   
       
    /**   
     * 得到当前日期   
     * @return   
     */  
    public static String getCurrentDate() {   
        Calendar c = Calendar.getInstance();   
        Date date = c.getTime();   
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");   
        return simple.format(date);   

    }     
  
    
    /**
     * 传入某个日期，返回指定日期的前几天或后几天
     * format:指定格式 date:参照日期 num:天数(正数向前计算，负数退后计算)
     * @return
     */
    public static String getDateAddOrMin(String format,String date,int num){
    	if(null==format||"".equals(format)){
    		format = "yyyy-MM-dd";
    	}
    	SimpleDateFormat sf = new SimpleDateFormat(format);
    	Calendar cale = Calendar.getInstance();
		try {
				Date d = sf.parse(date);
		        cale.setTime(d);
		        cale.add(Calendar.DATE,num);
		        cale.getTime();
		       
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return sf.format(cale.getTime());
    }
    
    //获取当月最大天数
    public static int getEndDateTime() {

        Calendar a=Calendar.getInstance();

        a.set(Calendar.DATE, 1);     //把日期设置为当月第一天

        a.roll(Calendar.DATE, -1);   //日期回滚一天，也就是最后一天

        int MaxDate=a.get(Calendar.DATE);

        return MaxDate;

      }
    
}
