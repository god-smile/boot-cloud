package com.zxcv.commom.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.util.StringUtils;


public class DateUtil {
	/**yyyy-MM-dd HH:mm:ss*/
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**yyyy-MM-dd*/
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    
    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    
    public static final String DATETIME = "HH:mm:ss";

    public static final String GLOBAL_BEGIN_TIME = "1970-01-01 00:00:00";
    public static final String GLOBAL_END_TIME = "2100-01-01 00:00:00";

    /**
     * 获取当前时间戳
     * 
     * @return
     * 
     */
    public static long getCurrentTimeMillis() {
        Timestamp time = getSysDate();
        return time.getTime();
    }

    /**
     * 获取系统时间
     * 
     * @return
     * 
     */
    public static Timestamp getSysDate() {
//        IDateSV sv = (IDateSV) ServiceFactory.getService(IDateSV.class);
//        try {
//            Timestamp time = sv.getSysDate();
//            return time;
//        } catch (Exception ex) {
//            throw new AppException(ex);
//        }
    	
    	//暂定方案
    	java.util.Date date = new java.util.Date();
    	Timestamp stamp = new Timestamp(date.getTime());
    	return stamp;
    }

    /**
     * 根据指定的格式输入时间字符串
     * 
     * @param pattern
     * @return
     * 
     */
    public static String getDateString(String pattern) {
        Timestamp time = getSysDate();
        DateFormat dfmt = new SimpleDateFormat(pattern);
        java.util.Date date = time;
        return dfmt.format(date);
    }

    /**
     * 获取时间字符串
     * 
     * @param time
     * @param pattern
     * @return
     * 
     */
    public static String getDateString(Timestamp time, String pattern) {
        DateFormat dfmt = new SimpleDateFormat(pattern);
        java.util.Date date = time;
        return date != null ? dfmt.format(date) : "";
    }

    /**
     * 获取指定时间的格式化串
     * 
     * @param date
     * @param pattern
     * @return
     * @author hanzf
     */
    public static String getDateString(java.util.Date date, String pattern) {
    	if(date==null){
    		return "";
    	}
        SimpleDateFormat sdfmt = new SimpleDateFormat(pattern);
        return date != null ? sdfmt.format(date) : "";
    }
    
    /**
     * 判断时间是否符合格式要求
     * 
     * @param str
     * @param fomat
     * @return
     * 
     */
    public static boolean isValidDate(String str, String fomat) {
        boolean flag = true;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(fomat);
            sdf.parse(str);
            flag = true;
        } catch (ParseException e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 字符串转日期（精确到日）
     * 
     * @param str
     * @return
     * 
     */
    public static Date str2Date(String str) {
        Date date = null;
        if (!StringUtils.isEmpty(str)) {
            date = DateUtil.to_date(str, DATE_FORMAT);
        }
        return date;
    }
    /**
     * 字符串转日期
     * 
     * @param str
     * @return
     * 
     */
    public static Date strDate(String str) {
        Date date = null;
        if (!StringUtils.isEmpty(str)) {
            date = DateUtil.to_date(str, DATETIME_FORMAT);
        }
        return date;

    }

    public static Timestamp getFutureTime() {
        Date d = str2Timestamp("2100-01-01 00:00:00");
        Timestamp beforeSecond = null;
        if (null != d) {
        	beforeSecond = getBeforeSecond(new Timestamp(d.getTime()));
        }
        return beforeSecond;
    }

    /**
     * 转换为时间
     * 
     * @param str
     * @return
     * 
     */
    public static Date str2Timestamp(String str) {
        Date date = null;
        if (!StringUtils.isEmpty(str)) {
            date = DateUtil.to_date(str, DATETIME_FORMAT);
        }
        return date;

    }

    /**
     * 按指定格式将字符串转换为日期对象
     * 
     * @param dateStr
     * @param format
     * @return
     * 
     */
    public static java.util.Date to_date(String dateStr, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            java.util.Date date = df.parse(dateStr);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("系统转换日期字符串["+dateStr+"]时出错！", e);
        }
    }

    /**
     * 按指定格式将字符串转换为 java.sql.Timestamp
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static Timestamp to_timestamp(String dateStr, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            java.util.Date date = df.parse(dateStr);
            Timestamp d = new Timestamp(date.getTime());
            return d;
        } catch (Exception e) {
            throw new RuntimeException("系统转换日期字符串时出错！", e);
        }
    }

    /**
     * 获取日期 格式：yyyy-MM-dd
     * 
     * @return
     * 
     */
    public static Date getDate() {
        String s = getDateString(DATETIME_FORMAT);
        Date a = DateUtil.str2Date(s);
        return a;
    }
    
    /**
     * 获取日期 格式：yyyy-MM-dd HH:mm:ss
     * 
     * @return
     * 
     */
    public static Date getDateTime() {
        String s = getDateString(DATETIME_FORMAT);
        Date a = DateUtil.strDate(s);
        return a;
    }

    /**
     * 获取某个时间点所代表的日期
     * 
     * @param sysDate
     * @return
     * 
     */
    public static Date getTheDayDate(Timestamp sysDate) {
        DateFormat dfmt = new SimpleDateFormat(DATETIME_FORMAT);
        java.util.Date date = sysDate;
        String dateString = dfmt.format(date);
        Date a = DateUtil.str2Date(dateString);
        return a;
    }

    /**
     * 获取指定时间点偏移天数后的日期
     * 
     * @param sysDate
     * @param offsetDays
     * @return
     * 
     */
    public static Date getOffsetDaysDate(Timestamp sysDate, int offsetDays) {
        Timestamp t = getOffsetDaysTime(sysDate, offsetDays);
        Date d = getTheDayDate(t);
        return d;
    }

    public static Date getOffsetDaysDate(Date date, int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, offsetDays);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 获取一天的第一秒 如：2011-11-11 00:00:00
     * 
     * @param sysDate
     * @return
     * 
     */
    public static Timestamp getTheDayFirstSecond(Timestamp sysDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取一天的最后一秒 如：2011-11-11 23:59:59
     * 
     * @param sysDate
     * @return
     * 
     */
    public static Timestamp getTheDayLastSecond(Timestamp sysDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, -1);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取指定时间的偏移天数后的时间
     * 
     * @param sysDate
     * @param offsetDays
     * @return
     * 
     */
    public static Timestamp getOffsetDaysTime(Timestamp sysDate, int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.add(Calendar.DAY_OF_MONTH, offsetDays);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取指定时间的偏移月份后的时间
     * 
     * @param sysDate
     * @param offsetDays
     * @return
     * @author yangpy
     */
    public static Timestamp getOffsetMonthsTime(Timestamp sysDate, int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.add(Calendar.MONTH, offsetDays);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取指定时间的偏移年份后的时间
     * 
     * @param sysDate
     * @param offsetDays
     * @return
     * @author zhangxianwei
     */
    public static Timestamp getOffsetYearsTime(Timestamp sysDate, int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.add(Calendar.YEAR, offsetDays);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取本月最后一秒
     * 
     * @param sysDate
     * @return
     * 
     */
    public static Timestamp getTimeThisMonthLastSec(Timestamp sysDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, -1);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取本月第一秒
     * 
     * @param sysDate
     * @return
     * 
     */
    public static Timestamp getTimeThisMonthFirstSec(Timestamp sysDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取下月第一秒
     * 
     * @param sysDate
     * @return
     * 
     */
    public static Timestamp getTimeNextMonthFirstSec(Timestamp sysDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.SECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取当月总的天数
     * 
     * @return
     * 
     */
    public static int getDaysOfThisMonth() {
        Timestamp currTimestamp = DateUtil.getSysDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currTimestamp);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 从yyyyMM格式中获取月
     * 
     * @param yyyyMM
     * @return
     * 
     */
    public static String getMonth(String yyyyMM) {
        if (StringUtils.isEmpty(yyyyMM) || yyyyMM.length() != 6) {
            throw new RuntimeException("格式出错，无法获取月");
        }
        String month = yyyyMM.substring(4, 6);
        return month;
    }

    /**
     * 验证日期格式 yyyyMM、yyyyMMdd、yyyyMMddHHmmss
     * 
     * @param str
     * @return
     */
    public static boolean isDateType(String str) {
        String withYYYYMMDDHHSSRegax = "^\\d{4}([1-9]|(1[0-2])|(0[1-9]))([1-9]|([12]\\d)|(3[01])|(0[1-9]))(([0-1][0-9])|([2][0-3]))([0-5][0-9])([0-5][0-9])$";
        String withYYYYMMDDRegax = "^\\d{4}([1-9]|(1[0-2])|(0[1-9]))([1-9]|([12]\\d)|(3[01])|(0[1-9]))$";
        String withYYYYMMRegax = "^\\d{4}((1[0-2])|(0[1-9]))$";
        if (StringUtils.isEmpty(str))
            return false;
        if (str.length() == 6)
            return str.matches(withYYYYMMRegax);

        if (str.length() == 8)
            return str.matches(withYYYYMMDDRegax);

        if (str.length() == 14)
            return str.matches(withYYYYMMDDHHSSRegax);

        return false;
    }
    
    public static boolean isDate(String str,String pattern){
    	boolean flg =false;
    	if (StringUtils.isEmpty(str)){
            return false;
    	}
    	SimpleDateFormat format = new SimpleDateFormat(pattern);
    	try{
    		format.parse(str);
    		flg=true;
    	}catch (Exception e) {
			return flg;
		}
    	return flg;
    }

    /**
     * 计算两个日期的时间差(天)
     * 
     * @param formatTime1
     * @param formatTime2
     * @return
     */
    public static long getTimeDifference(Timestamp formatTime1, Timestamp formatTime2) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = 0L;
        long t2 = 0L;
        try {
            t1 = timeformat.parse(getTimeStampNumberFormat(formatTime1)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            t2 = timeformat.parse(getTimeStampNumberFormat(formatTime2)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 毫秒ms
        long diff = t1 - t2;
        /*
         * long diffSeconds = diff / 1000 % 60; long diffMinutes = diff / (60 * 1000) % 60; long
         * diffHours = diff / (60 * 60 * 1000) % 24;
         */
        long diffDays = diff / (24 * 60 * 60 * 1000);
        return diffDays;
    }

    /**
     * 两个日期相差月份
     * 
     * @param beginDate
     *            yyyyMM
     * @param endDate
     *            yyyyMM
     * @return
     */
    public static int getTimeDifference(String beginDate, String endDate) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyyMM");

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        try {
            cal1.setTime(timeformat.parse(endDate));
            cal2.setTime(timeformat.parse(beginDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int c = (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12 + cal1.get(Calendar.MONTH)
                - cal2.get(Calendar.MONTH);
        return c;
    }

    /**
     * 获取今天是本月第几天
     * 
     * @return
     */
    public static int getDates() {
        Timestamp currTimestamp = DateUtil.getSysDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currTimestamp);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 计算两个日期之间相差天数
     * 
     * @param beginDate
     *            yyyyMM
     * @param endDate
     *            yyyyMM
     * @return
     */
    public static int getDaysBetween(String beginDate, String endDate) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        long between_days = 0;
        try {
            cal.setTime(timeformat.parse(beginDate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(timeformat.parse(endDate));
            long time2 = cal.getTimeInMillis();
            between_days = (time2 - time1) / (1000 * 3600 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * 获取指定月份的偏移月数所在的月
     * @param date yyyyMM
     * @param offsetMonth（正数：以后，负数：以前）
     * @return
     */
    public static String getOffsetMonth(String date,int offsetMonth){
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyyMM");

        Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(timeformat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.MONTH, offsetMonth);
        return timeformat.format(cal.getTime());
    }


    /**
     * 计算两个日期的时间差(分钟)
     * 
     * @param formatTime1
     * @param formatTime2
     * @return
     */
    public static long getMinuteDif(Timestamp formatTime1, Timestamp formatTime2) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = 0L;
        long t2 = 0L;
        try {
            t1 = timeformat.parse(getTimeStampNumberFormat(formatTime1)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            t2 = timeformat.parse(getTimeStampNumberFormat(formatTime2)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 毫秒ms
        long diff = t1 - t2;
        long diffMins = diff / (60 * 1000);
        return diffMins;
    }

    public static long getMinuteDif(String date1, String date2) {
        long t1 = 0L;
        long t2 = 0L;
            t1 = DateUtil.to_date(date1, YYYYMMDDHHMM).getTime();
            t2 = DateUtil.to_date(date1, YYYYMMDDHHMM).getTime();
        // 毫秒ms
        long diff = t1 - t2;
        long diffMins = diff / (60 * 1000);
        return diffMins;
    }
    
    /**
     * 格式化时间 Locale是设置语言敏感操作
     * 
     * @param formatTime
     * @return
     */
    public static String getTimeStampNumberFormat(Timestamp formatTime) {
        SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", new Locale("zh",
                "cn"));
        return m_format.format(formatTime);
    }

    public static int getMillis() {
        Timestamp currTimestamp = DateUtil.getSysDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currTimestamp);
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * 当前时间前一秒
     * 
     * @param currentDate
     * @return
     */
    public static Timestamp getBeforeSecond(Timestamp currentDate) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(currentDate);
        calender.add(Calendar.SECOND, -1);
        return new Timestamp(calender.getTimeInMillis());
    }

    /**
     * 当前时间后一秒
     * 
     * @param currentDate
     * @return
     */
    public static Timestamp getAfterSecond(Timestamp currentDate) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(currentDate);
        calender.add(Calendar.SECOND, 1);
        return new Timestamp(calender.getTimeInMillis());
    }

    public static Timestamp getTimestamp(String time) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Timestamp ts = null;
        try {
            ts = new Timestamp(format.parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 将指定格式的日期字符串转成Timestamp
     * 
     * @param time
     * @param pattern
     * @return
     */
    public static Timestamp getTimestamp(String time, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        format.setLenient(false);
        Timestamp ts = null;
        try {
            ts = new Timestamp(format.parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 计算两个日期的时间差(月)
     * 
     * @param formatTime1
     * @param formatTime2
     * @return
     */
    public static int getTimeDifferenceMonth(Timestamp formatTime1, Timestamp formatTime2) {

        Calendar calendarTime1 = Calendar.getInstance();
        calendarTime1.setTime(formatTime1);
        int yearTime1 = calendarTime1.get(Calendar.YEAR);
        int monthTime1 = calendarTime1.get(Calendar.MONTH);
        int dayTime1 = calendarTime1.get(Calendar.DAY_OF_MONTH);

        Calendar calendarTime2 = Calendar.getInstance();
        calendarTime2.setTime(formatTime2);
        int yearTime2 = calendarTime2.get(Calendar.YEAR);
        int monthTime2 = calendarTime2.get(Calendar.MONTH);
        int dayTime2 = calendarTime2.get(Calendar.DAY_OF_MONTH);

        int y = yearTime2 - yearTime1;// 年差
        int m = monthTime2 - monthTime1;// 月差
        int d = dayTime2 - dayTime1;// 天差

        if (d > 0) {
            // 如果天数差大于零
            return (y * 12 + m + 1);
        } else {
            return (y * 12 + m);
        }
    }

    /**
     * 时间转换成中文
     * 
     * @param time
     * @return
     * 
     */
    public static String trans2CnTime(Timestamp time) {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return df.format(time);
    }

    /**
     * 时间转换成中文
     * 
     * @param time
     * @return
     * 
     */
    public static String trans2CnDate(Timestamp time) {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        return df.format(time);
    }

    /**
     * Timestamp类型时间加一天
     * 
     * @param date
     * @return
     * 
     */
    public static Timestamp getTimeNextDay(Timestamp date) {
        long time = date.getTime();
        time = time + 24 * 60 * 60 * 1000;
        return new Timestamp(time);
    }

    /**
     * Timestamp类型时间减一天
     * 
     * @param date
     * @return
     * 
     */
    public static Timestamp getTimeBeforeDay(Timestamp date) {
        long time = date.getTime();
        time = time - 24 * 60 * 60 * 1000;
        return new Timestamp(time);
    }

    /**
     * 当前时间(currentDate)前一月
     * 
     * @param currentDate
     * @return
     */
    public static Timestamp getBeforeMonth(Timestamp currentDate) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(currentDate);
        calender.add(Calendar.MONTH, -1);
        return new Timestamp(calender.getTimeInMillis());
    }
    
    /**
     * 获取下月第一天
     * @param currentDate
     * @return
     * 
     */
    public static Timestamp getAfterMonth(Timestamp currentDate) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(currentDate);
        calender.add(Calendar.MONTH, 1);
        return new Timestamp(calender.getTimeInMillis());
    }
    
    public static String nowEns(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
   }
    
    /**
     * 计算两个日期的时间差(秒)
     * 
     * @param formatTime1
     * @param formatTime2
     * @return
     */
    public static long getTimeDifferenceSecond(Timestamp formatTime1, Timestamp formatTime2) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = 0L;
        long t2 = 0L;
        try {
            t1 = timeformat.parse(getTimeStampNumberFormat(formatTime1)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            t2 = timeformat.parse(getTimeStampNumberFormat(formatTime2)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 毫秒ms
        long diff = t2 - t1;
        /*
         * long diffSeconds = diff / 1000 % 60; long diffMinutes = diff / (60 * 1000) % 60; long
         * diffHours = diff / (60 * 60 * 1000) % 24;
         */
        long diffSeconds = diff / (1000);
        return diffSeconds;
    }
    
    /**
	   * 将总的秒数转换为时分秒的格式
	   * @param totalSecond
	   *      总的秒数
	   * @return
	   *      时分秒时间格式
	   * @author: zuowg
	   * Create On:2014年5月13日 上午11:48:37
	   * Modify On:
	   * @Description
	   */
	  public final static String secondToTime(long totalSecond){
	      String timeStr = null;  
	      long date = 0;
	      long hour = 0;  
	      long minute = 0;  
	      long second = 0;  
	      if (totalSecond <= 0)  
	          return "0秒";  
	      else if (totalSecond <60)
	    	  return totalSecond+"秒";
	      else {  
	          minute = totalSecond / 60;  
	          if (minute < 60) {  
	              second = totalSecond % 60;  
	              timeStr = unitFormat(minute) + "分钟"+ unitFormat(second) + "秒";  
	          } else {  
	              hour = minute / 60;  
	              if (hour < 24)  {
	                  hour = hour % 24;
	                  minute = minute % 60;  
	                  second = totalSecond - hour * 3600 - minute * 60;  
	                  timeStr = unitFormat(hour) + "小时" + unitFormat(minute) + "分钟" + unitFormat(second) + "秒";  
	              } else {
	                  date = hour / 24;
	                  hour = hour % 24;
	                  minute = minute % 60;
	                  second = totalSecond - date * 24*3600 - hour * 3600 - minute * 60;
	                  timeStr = unitFormat(hour) + "天" + unitFormat(hour) + "小时" + unitFormat(minute) + "分钟" + unitFormat(second) + "秒";  
	              }
	          }  
	      }  
	      return timeStr;
	
	  }
	  
	  private static String unitFormat(long time) {
	      String retStr = null;  
	      /*if (time >= 0 && time < 10)  
	          retStr = "0" + Long.toString(time);  
	      else  */
	        retStr = "" + time;  
	      return retStr;  
	
	  }
	  
	  /*public static void main(String[] args) {
		System.out.println(DateUtil.secondToTime(188886));
	}*/
    
    /**
     * 获取指定时间的偏移分钟数后的时间
     * 
     * @param sysDate
     * @param offsetDays
     * @return
     * 
     */
    public static Timestamp getOffsetMinutesTime(Timestamp sysDate, int offsetMinutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sysDate);
        calendar.add(Calendar.MINUTE, offsetMinutes);
        return new Timestamp(calendar.getTimeInMillis());
        
       
    }
    /**
     * 获取2个日期之间的所有日期.<br/>
     * @param start
     * @param end
     * @return
     */
    public  static List<Date> getBetweenDates(Date start, Date end) {
	    List<Date> result = new ArrayList<Date>();
	    result.add(start);
	    Calendar tempStart = Calendar.getInstance();
	    tempStart.setTime(start);
	    tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    
	    Calendar tempEnd = Calendar.getInstance();
	    tempEnd.setTime(end);
	    while (tempStart.before(tempEnd)) {
	        result.add(tempStart.getTime());
	        tempStart.add(Calendar.DAY_OF_YEAR, 1);
	    }
	    
	    result.add(end);
	    return result;
	}
    
    public static Date getTheBeforeDayDate(Date date) {
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -1);  
        date = calendar.getTime(); 
        return date;
    }
    
    /** 
	 * 判断某一时间是否在一个区间内 
	 *  
	 * @param sourceTime 
	 *            时间区间,半闭合,如[10:00-20:00) 
	 * @param curTime 
	 *            需要判断的时间 如10:00 
	 * @return  
	 * @throws IllegalArgumentException 
	 */  
	public static boolean isInTime(Date curTime,Date beginTime, Date endTime) {  
	    if (beginTime == null || endTime == null) {  
	        throw new IllegalArgumentException("Illegal Argument arg:");  
	    }  
	    
	    
	    try {  
	        long now = curTime.getTime();  
	        long start = beginTime.getTime();  
	        long end =endTime.getTime();  
	         
	        if (end < start) {  
	            if (now >= end && now < start) {  
	                return false;  
	            } else {  
	                return true;  
	            }  
	        }   
	        else {  
	            if (now >= start && now < end) {  
	                return true;  
	            } else {  
	                return false;  
	            }  
	        }  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        throw new IllegalArgumentException("Illegal Argument arg:");  
	    }  
	  
	}

    /**
     * 取两个时间之间的所有天数
     * @param start
     * @param end
     * @return
     */
    @SuppressWarnings("unused")
	private static List<String> getBetweenDates(String start, String end) {

        List<String> result = new ArrayList<String>();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date start_date = sdf.parse(start);

            Date end_date = sdf.parse(end);

            Calendar tempStart = Calendar.getInstance();

            tempStart.setTime(start_date);

            Calendar tempEnd = Calendar.getInstance();

            tempEnd.setTime(end_date);

            while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {

                result.add(sdf.format(tempStart.getTime()));

                tempStart.add(Calendar.DAY_OF_YEAR, 1);

            }

        } catch (ParseException e) {

            e.printStackTrace();

        }
        Collections.reverse(result);

        return result;
    }

    /**
     * 获取全局的有效时间 beginTime
     */
    public static Date getGlobalBeginTime() {
        return strDate(GLOBAL_BEGIN_TIME);
    }

    /**
     * 获取全局的有效时间 endTime
     */
    public static Date getGlobalEndTime() {
        return strDate(GLOBAL_END_TIME);
    }
}
