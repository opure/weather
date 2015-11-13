package com.vanvalt.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConver {
	// 默认类型（年月日时分秒）
    public static final String format_type = "yyyy-MM-dd HH:mm:ss";
    // 日期类型
    public static final String format_type_date = "yyyy-MM-dd";
     
    private static SimpleDateFormat format = null;
 
    public TimeConver() {
        // TODO Auto-generated constructor stub
        format = new SimpleDateFormat(format_type);
    }
 
    public TimeConver(String format_type) {
        format = new SimpleDateFormat(format_type);
    }
 
    /**
     * 
     * @方法描述 ：将当前时间转化为String类型 <br>
     * @创建者 ：Andy.wang <br>
     * @return
     * @throws ParseException
     * <br>
     * @返回类型 ：String <br>
     */
    public String getCurrentTime() {
        return format.format(new Date());
    }
 
    /**
     * 
     * @方法名 ：turnDate<br>
     * @方法描述 ：将字符串转化为时间类型<br>
     * @创建者 ：Andy.wang<br>
     * @创建时间 ：2014-3-2下午07:34:47 <br>
     * @param source ：时间字符串
     * @return
     * @throws ParseException
     * 返回类型 ：Date
     */
    public Date turnDate(String source) throws ParseException {
        return format.parse(source);
    }
 
    /**
     * 
     * @方法名 ：turnTimestamp<br>
     * @方法描述 ：将String类型转化为Timestamp类型<br>
     * @创建者 ：Andy.wang<br>
     * @创建时间 ：2014-3-2下午07:37:11 <br>
     * @param source ：时间字符串
     * @return
     * @throws ParseException
     * 返回类型 ：Timestamp
     */
    public Timestamp turnTimestamp(String source) throws ParseException {
        return new Timestamp(turnDate(source).getTime());
    }
}
