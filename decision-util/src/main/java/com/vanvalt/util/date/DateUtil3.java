package com.vanvalt.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtil3 {

	/**
	 * yyyy-MM-dd短日期格式
	 */
	public final static String		SHORT_DATE_FORMAT	= "yyyy-MM-dd";
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public final static String		LONG2_DATE_FORMAT	= "yyyy-MM-dd HH:mm";
	
	/**
	 * 根据日期获得星期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };
		String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysCode[intWeek];
	}
	
	public static String getWeekNameOfDate(Date date) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };
		String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];
	}
	
	public static String getWeekCodeOfDate(Date date) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };
		String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysCode[intWeek];
	}

	/**
	 * 获得周一的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonday(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(SHORT_DATE_FORMAT);

		return dateFormat.format(calendar.getTime());

	}

	/**
	 * 获得周三的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWednesday(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);

		SimpleDateFormat dateFormat = new SimpleDateFormat(SHORT_DATE_FORMAT);
		
		return dateFormat.format(calendar.getTime());

	}

	/**
	 * 获得周五的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getFriday(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(SHORT_DATE_FORMAT);
		
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 当前日期前几天或者后几天的日期
	 * 
	 * @param n
	 * @return
	 */
	public static String afterNDay(int n) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());

		calendar.add(Calendar.DATE, n);

		Date date = calendar.getTime();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(SHORT_DATE_FORMAT);
		
		String s = dateFormat.format(date);

		return s;

	}

	/**
	 * 判断两个日期是否在同一周
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}
	
	/**
	 * 将日期字符串转换为Date类型
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date strToDate(String dateStr, String format){
		
		if(StringUtils.isEmpty(format)){
			format = SHORT_DATE_FORMAT;
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			if(StringUtils.isNotEmpty(dateStr)){
				date = dateFormat.parse(dateStr);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dateStr = "2015-04-30";
		Date date = strToDate(dateStr, SHORT_DATE_FORMAT);
		String week = getWeekNameOfDate(date);
		
		System.out.println("Week: "+week);
	}

}
