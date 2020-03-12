package com.example.bangbangxia.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 获取当前日期字符串
     * @return yyyy-mm-dd
     */
    public static String getDateStr(){
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.YEAR)+"-";
        date+= calendar.get(Calendar.MONTH)+1<10?"0"+(calendar.get(Calendar.MONTH)+1)+"-":(calendar.get(Calendar.MONTH)+1)+"-";
        date+=calendar.get(Calendar.DATE)<10?"0"+calendar.get(Calendar.DATE):calendar.get(Calendar.DATE);
        return date;
    }

    /**
     * 获取当前时间字符串
     * @param needSecond  是否需要秒
     * @return hh:mm:ss
     */
    public static String getTimeStr(boolean needSecond){
        Calendar calendar = Calendar.getInstance();
        String time = calendar.get(Calendar.HOUR)<10?"0"+calendar.get(Calendar.HOUR)+":":calendar.get(Calendar.HOUR)+":";
        time+=calendar.get(Calendar.MINUTE)<10?"0"+calendar.get(Calendar.MINUTE):calendar.get(Calendar.MINUTE);
        if(needSecond){
            time+=calendar.get(Calendar.SECOND)<10?":0"+calendar.get(Calendar.SECOND):":"+calendar.get(Calendar.SECOND);
        }
        return time;
    }

    /**
     * 获取当前日期时间字符串
     * @param needSecond 是否需要秒
     * @return yyyy-mm-dd hh:mm:ss
     */
    public static String getDateTimStr(boolean needSecond){
        return getDateStr()+" "+getTimeStr(needSecond);
    }

    /**
     * 将字符串按指定格式转化为日期
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date strToDate(String dateStr, String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 将日期按指定格式转化为日期
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStr(Date date, String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String dateStr = null;
        dateStr = dateFormat.format(date);
        return dateStr;
    }
    public static long getTime(String dateStr,String pattern){
        Date date = strToDate(dateStr,pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }
    public static long getTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }
    public static void main(String[] args){
        System.out.println(DateUtils.getDateTimStr(true));
    }
}
