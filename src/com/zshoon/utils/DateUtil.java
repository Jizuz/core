package com.zshoon.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description: 日期帮助类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * 
 * <p>
 * Company: MyDecoration
 * </p>
 * 
 * @author qiu.pengfei
 * @version 1.0
 */
public class DateUtil {
	
	public static Date MAX_VALUE = offsetYear(getNowDate(), 100);

	public final static String DATE_FORMAT_1 = "yyyy-MM-dd";

	public final static String DATE_FORMAT_2 = "yyyyMMdd";

	public final static String DATETIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";

	public final static String DATETIME_FORMAT_3 = "yyyy-MM-dd HH-mm-ss";

	public final static String DATETIME_FORMAT_2 = "yyyyMMddHHmmss";

    public final static String DATETIME_FORMAT_4 = "yyyy/MM/dd HH:mm:ss";

    public final static String DATETIME_FORMAT_5 = "yyyy-MM-dd HH:mm:ss SSS";

    public final static String DATE_FORMAT_3 = "yyyy年MM月dd日";

	public final static int DIFFER_IN_SECOND = 0;

	public final static int DIFFER_IN_MINUTE = 1;

	public final static int DIFFER_IN_HOUR = 2;

	public final static int DIFFER_IN_DAYS = 3;

	public static String DEFAULT_DATE_FORMAT = DATE_FORMAT_1;

	public static String DEFAULT_TIME_FORMAT = DATETIME_FORMAT_1;

	public static String NAME_FILE_DATE_FORMAT = "yyyyMMdd_HHmmss";

	public final static String[] DATE_FORMAT_SUPPORT = { DATETIME_FORMAT_1,
			DATETIME_FORMAT_2, DATETIME_FORMAT_3, DATETIME_FORMAT_4,
			DATE_FORMAT_1, DATE_FORMAT_2, DATE_FORMAT_3 };

	public static SimpleDateFormat getDateFormat(String format) {
		return new SimpleDateFormat(format);
	}

	/*
	 * 获取当前时间，"yyyy-MM-dd"，不带时分秒
	 */
	public static String getCurrentDate() {
		Date date = new Date();
		return date2String(date, DEFAULT_DATE_FORMAT);
	}
	
	/*
	 * 日期类型转换成String型
	 */
	public static String date2String(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = getDateFormat(format);
		return sdf.format(date);
	}

	/*
	 * 日期类型转换成String型，默认"yyyy-MM-dd"，不带时分秒
	 */
	public static String date2String(Date date) {
		return date2String(date, DEFAULT_DATE_FORMAT);
	}

	/*
	 * 文件名时间命名，yyyyMMdd_HHmmss
	 */
	public static String getNameFileCurrentDate() {
		Date date = new Date();
		return date2String(date, NAME_FILE_DATE_FORMAT);
	}
	
	/*
	 * 时间比较
	 */
	public static int compareDate(Date date1, Date date2) {
		int ret = 1;
		long time1 = date1.getTime();
		long time2 = date2.getTime();

		if (time1 > time2) {
			ret = 2;
		}
		if (time1 == time2) {
			ret = 1;
		}
		if (time1 < time2) {
			ret = 0;
		}
		return ret;
	}
	
	/**
	 * 
	 * Description: Date to SqlDate<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @return <br>
	 */
	public static java.sql.Date dateToSqlDate(java.util.Date date) {
		if (date == null) {
			return null;
		} else if (date instanceof java.sql.Date) {
			return (java.sql.Date) date;
		} else {
			return new java.sql.Date(date.getTime());
		}
	}

	/**
	 * 
	 * Description: string to SqlDate<br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @return <br>
	 */
	public static java.sql.Date string2SQLDate(String date) {
		java.sql.Date ret = null;

		if (date == null || date.length() == 0) {
			return ret;
		}
		if (date.length() > 11) {
			if (date.indexOf('-') > 0) {

				if (date.indexOf(':') > 0) {
					ret = string2SQLDate(date, DATETIME_FORMAT_1);
				} else {
					ret = string2SQLDate(date, DATETIME_FORMAT_3);
				}
			} else if (date.indexOf('/') > 0) {
				ret = string2SQLDate(date, DATETIME_FORMAT_4);
			} else {
				ret = string2SQLDate(date, DATETIME_FORMAT_2);
			}
		} else {
			if (date.indexOf('-') > 0) {
				ret = string2SQLDate(date, DATE_FORMAT_1);
			} else if (date.length() == 8) {
				ret = string2SQLDate(date, DATE_FORMAT_2);
			} else {
				ret = string2SQLDate(date, DATE_FORMAT_3);
			}
		}
		return ret;
	}

	public synchronized static java.sql.Date string2SQLDate(String date,
			String format) {
		boolean isSucc = true;
		Exception operateException = null;
		if (!ValidateUtil.validateNotEmpty(format)) {
			isSucc = false;
			operateException = new IllegalArgumentException(
					"the date format string is null!");
		}
		SimpleDateFormat sdf = getDateFormat(format);
		if (!ValidateUtil.validateNotNull(sdf)) {
			isSucc = false;
			operateException = new IllegalArgumentException(
					"the date format string is not matching available format object");
		}
		java.util.Date tmpDate = null;
		try {
			if (isSucc) {
				tmpDate = sdf.parse(date);
				String tmpDateStr = sdf.format(tmpDate);
				if (!tmpDateStr.equals(date)) {
					isSucc = false;
					operateException = new IllegalArgumentException(
							"the date string " + date
									+ " is not matching format: " + format);
				}
			}
		} catch (Exception e) {
			isSucc = false;
			operateException = e;
		}

		if (!isSucc) {
			throw new IllegalArgumentException("the date string " + date
					+ " is not matching format: " + format + ".\n cause by :"
					+ operateException);
		} else {
			return new java.sql.Date(tmpDate.getTime());
		}

	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getStandardNowTime() {
		SimpleDateFormat sdf = getDateFormat(DEFAULT_TIME_FORMAT);
		return sdf.format(new java.util.Date());
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @return <br>
	 */
	public static java.sql.Date getNowDate() {
		return new java.sql.Date(new java.util.Date().getTime());
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @param seconds
	 * @return <br>
	 */
	public static java.sql.Date offsetSecond(java.sql.Date date, long seconds) {
		if (date == null) {
			return null;
		}

		long time = date.getTime();
		time = time + (seconds * 1000);
		return new java.sql.Date(time);
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @param minutes
	 * @return <br>
	 */
	public static java.sql.Date offsetMinute(java.sql.Date date, long minutes) {
		return offsetSecond(date, 60 * minutes);
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @param hours
	 * @return <br>
	 */
	public static java.sql.Date offsetHour(java.sql.Date date, long hours) {
		return offsetMinute(date, 60 * hours);
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @param days
	 * @return <br>
	 */
	public static java.sql.Date offsetDay(java.sql.Date date, int days) {
		return offsetHour(date, 24 * days);
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @param weeks
	 * @return <br>
	 */
	public static java.sql.Date offsetWeek(java.sql.Date date, int weeks) {
		return offsetDay(date, 7 * weeks);
	}

	/**
	 * @param date
	 *            Date
	 * @return Date
	 */
	public static java.sql.Date getLastDayOfMonth(java.sql.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, maxDay);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		date.setTime(calendar.getTimeInMillis());
		return date;
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param date
	 * @return <br>
	 */
	public static java.sql.Date getBeginDayOfMonth(java.sql.Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		date.setTime(calendar.getTimeInMillis());
		return date;
	}

	/**
	 * 
	 * @param date1
	 * @param months
	 * @return
	 */
	public static java.sql.Date offsetMonth(java.sql.Date date1, int months) {
		if (date1 == null) {
			return null;
		}

		java.sql.Date date = new java.sql.Date(date1.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int curDay = calendar.get(Calendar.DAY_OF_MONTH);
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, months);

		int newMaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (curDay == maxDay) {
			calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);

		} else {
			if (curDay > newMaxDay) {
				calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);
			} else {
				calendar.set(Calendar.DAY_OF_MONTH, curDay);
			}
		}

		date.setTime(calendar.getTimeInMillis());
		return date;
	}

	/**
	 * @param date
	 *            origrinal date
	 * @param years
	 *            offset years
	 * @return offset date
	 */
	public static java.sql.Date offsetYear(java.sql.Date date, int years) {
		if (date == null) {
			return null;
		}

		java.sql.Date newdate = (java.sql.Date) date.clone();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newdate);
		calendar.add(Calendar.YEAR, years);
		newdate.setTime(calendar.getTimeInMillis());
		return newdate;
	}

	/**
	 * 
	 * Description: <br> 
	 *  
	 * @author qiu.pengfei<br>
	 * @param beginDate
	 * @param endDate
	 * @param returnType
	 * @return <br>
	 */
	public static long differDateInDays(java.sql.Date beginDate,
			java.sql.Date endDate, int returnType) {
		long begin = beginDate.getTime();
		long end = endDate.getTime();
		long surplus = begin - end;
		long ret = 0;
		switch (returnType) {
		case 0:
			ret = surplus / 1000;
			break;
		case 1:
			ret = surplus / 1000 / 60;
			break;
		case 2:
			ret = surplus / 1000 / 60 / 60;
			break;
		case 3:
			ret = surplus / 1000 / 60 / 60 / 24;
			break;
		default:
			break;
		}

		return ret;
	}
}
