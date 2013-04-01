package com.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	private static final SimpleDateFormat shortsdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat longsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 时间格式化（到日期）
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		String newDate = "";
		if (date == null)
			return newDate;
		try {
			newDate = shortsdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newDate;
	}

	/**
	 * 时间格式化（到秒）
	 * 
	 * @param obj
	 * @return
	 */
	public static String formatTime(Date date) {
		String newDate = "";
		if (date == null)
			return newDate;
		try {
			newDate = longsdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newDate;
	}
	

    /**
     * 时间格式化（到秒）
     * 
     * @param ticks 时间刻度
     * @return
     */
    public static String formatTime(Long ticks) {
        String newDate = "";
        if (ticks == null)
            return newDate;
        try {
            Date date=new Date(ticks);
            newDate = longsdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDate;
    }

	public static String formatTimeMin(Date date) {
		String newDate = "";
		if (date == null)
			return newDate;
		try {
			newDate = shortsdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newDate;
	}

	public static Date string2Date(String s, int type) {
		if (s == null) {
			return null;
		}
		Calendar cal = null;
		String a[] = s.split("-| |:");
		try {
			if (a.length >= 3) {
				cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, Integer.valueOf(a[0]));
				cal.set(Calendar.MONTH, Integer.valueOf(a[1]) - 1);
				cal.set(Calendar.DATE, Integer.valueOf(a[2]));
			}
			if (type == 0) {
				if (a.length >= 5) {
					cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(a[3]));
					cal.set(Calendar.MINUTE, Integer.valueOf(a[4]));
					if (a.length == 6) {
						cal.set(Calendar.SECOND, Integer.valueOf(a[5]));
					}
				} else {
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
				}
			} else if (type == 1) {
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
			} else if (type == 2) {
				cal.set(Calendar.HOUR_OF_DAY, 23);
				cal.set(Calendar.MINUTE, 59);
				cal.set(Calendar.SECOND, 59);
			}
		} catch (Exception e) {

		}
		if (cal != null) {
			return cal.getTime();
		}
		return null;
	}

	public static Date stringDateMin(String s) {
		Date date = null;

		try {
			date = shortsdf.parse(s);
		} catch (ParseException e) {
		}
		return date;
	}

	public static Date stringDate(String s) {
		Date date = null;

		try {
			date = longsdf.parse(s);
		} catch (ParseException e) {
		}
		return date;
	}

	
	/**
	 * 以短格式格式化时间,实例：2010-09-19
	 * @param time 时间刻度
	 * @return 格式化后的时间
	 * @author zhengrunjin @ 2010-09-19
	 */
	public static String StringDateShortFormat(Long time){
		if (time != null) {
			return shortsdf.format(new Date(time));
		}
		return null;
	}
	
	public static String StringDate(Long l) {
		if (l != null) {
			return longsdf.format(new Date(l));
		}
		return null;
	}
	
	/**
	 * 返回于指定日期间隔一定天数的日期
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date getSpecDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - days);
		return calendar.getTime();
	}

	public static boolean after(Date date1, Date date2) {
		Calendar dc1 = Calendar.getInstance();
		dc1.setTime(date1);
		Calendar dc2 = Calendar.getInstance();
		dc2.setTime(date2);
		return dc1.after(dc2);
	}

	public static boolean before(Date date1, Date date2) {
		Calendar dc1 = Calendar.getInstance();
		dc1.setTime(date1);
		Calendar dc2 = Calendar.getInstance();
		dc2.setTime(date2);
		return dc1.before(dc2);
	}

	
	//日期转换
	public static java.sql.Date getBeforeAfterDate(String datestr, int day) {  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        java.sql.Date olddate = null;  
        try {  
            df.setLenient(false);  
            olddate = new java.sql.Date(df.parse(datestr).getTime());  
        } catch (ParseException e) {  
            throw new RuntimeException("日期转换错误");  
       }  
        Calendar cal = new GregorianCalendar();  
        cal.setTime(olddate);  
  
        int Year = cal.get(Calendar.YEAR);  
        int Month = cal.get(Calendar.MONTH);  
        int Day = cal.get(Calendar.DAY_OF_MONTH);  
  
        int NewDay = Day + day;  
  
        cal.set(Calendar.YEAR, Year);  
        cal.set(Calendar.MONTH, Month);  
        cal.set(Calendar.DAY_OF_MONTH, NewDay);  
 
        return new java.sql.Date(cal.getTimeInMillis());  
	}
	public static java.sql.Date getSqlDate(String datestr,String format) {  
        SimpleDateFormat df = new SimpleDateFormat(format);  //"yyyy-MM-dd"
        java.sql.Date olddate = null;  
        try {  
            df.setLenient(false);  
            olddate = new java.sql.Date(df.parse(datestr).getTime());  
        } catch (ParseException e) {  
            throw new RuntimeException("日期转换错误");  
       }  
        Calendar cal = new GregorianCalendar();  
        cal.setTime(olddate);  
  
        int Year = cal.get(Calendar.YEAR);  
        int Month = cal.get(Calendar.MONTH);  
        int Day = cal.get(Calendar.DAY_OF_MONTH);  
  
  
        cal.set(Calendar.YEAR, Year);  
        cal.set(Calendar.MONTH, Month);  
        cal.set(Calendar.DAY_OF_MONTH, Day);  
 
        return new java.sql.Date(cal.getTimeInMillis());  
	}
	
	public static java.sql.Timestamp getTimestamp(String datestr,String format) {  
        SimpleDateFormat df = new SimpleDateFormat(format);
        java.sql.Timestamp olddate = null;  
        try {  
            df.setLenient(false);  
            olddate = new java.sql.Timestamp(df.parse(datestr).getTime());  
        } catch (ParseException e) {  
            throw new RuntimeException("日期转换错误");  
       }  
        return olddate;  
	}

	
	//参数日期+小时数得到新日期
	//type：1=天数 ，2=小时数 3=月数
	public static Date getNewDate(Date d,int num,int type){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		switch (type) {
			case 1:
				calendar.add(Calendar.DAY_OF_YEAR, num);
				break;
			case 2:
				calendar.add(Calendar.HOUR_OF_DAY, num);
				break;
			case 3:
                calendar.add(Calendar.MONTH, num);
                break;
		}
		
		return calendar.getTime();
	}

	/**
	 * 两个日期相差的天数,只精确到天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Integer diffDays(Date date1, Date date2){
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		
		int days1 = calendar1.get(Calendar.DAY_OF_YEAR);
		int days2 = calendar2.get(Calendar.DAY_OF_YEAR);
		return Math.abs(days2 - days1);
	}
	/**
	 * 返回一天的结束时间
	 * @param d
	 * @return
	 */
	public String getEndTimeOfDays(String d) {
		return d.trim() + " 23:59:59";
	}
	/**
	 * 去掉日期的时间部分
	 * @param d
	 * @return
	 */
	public String formatDateStr(String d) {
		try {
			return shortsdf.format(longsdf.parse(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void main(String args[]){
		System.out.println(formatDate(getNewDate(new Date(),1 , 3)));
	}

	/**
	 * 获取过几分钟的时间
	 * @param d
	 * @param num
	 * @param type
	 * @return
	 */
	public static Date getDateAfterSomeMinutes(Date d,int minute){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	
	/**
     * 获得过几小时的时间
     * 
     * @param d 需要计算的时间类型
     * @param hours 小时数
     * @return
     */
    public static Date addHours(Date d,int hours){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }
    
    public static String formatDate(Date date,String format) {
        String newDate = "";
        if (date == null)
            return newDate;
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            newDate = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDate;
    }
    public static Timestamp getCurrentTime() {
    	Timestamp currentTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
    	return currentTime;
    }
}