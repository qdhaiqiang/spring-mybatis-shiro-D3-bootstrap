package com.eliteams.quick4j.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-3
 * Time: 下午5:13
 * To change this template use File | Settings | File Templates.
 */
public class DateUtil {

    /**
     * 当前时间往后几天的日期，days为负值表示往前数几天
     * @param days
     * @return
     */
    public static Date addDaysToCurrent(int days){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 根据持续毫秒值，获取时分秒
     * @param millis
     * @return
     */
    public static String getLastTime(long millis){
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d", hour, minute, second);
        return time;
    }

    /**
     * String类型的时间，转为Date
     * @param dateStr
     * @return
     */
    public static Date stringToDate(String dateStr){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 返回 yyyy-MM-dd
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(date).toString();
        return dateStr;
    }

    /**
     * 计算日期之间的天数
     * @param from
     * @param to
     * @return
     */
    public static int daysBetween(String from,String to){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(from));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        long time1 = cal.getTimeInMillis();
        try {
            cal.setTime(sdf.parse(to));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取两个日期之间所有的日期
     * @param from
     * @param to
     * @return
     */
    public static ArrayList days(String from, String to) {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);

        ArrayList L = new ArrayList();
        L.add(from);
        if (from.equals(to)) {
            System.out.println("两个日期相等!");
            return L;
        }

        String tmp;
        if (from.compareTo(to) > 0) { // 确保 date1的日期不晚于date2
            tmp = from;
            from = to;
            to = tmp;
        }

        tmp = format.format(str2Date(from).getTime() + 3600 * 24 * 1000);

        int num = 0;
        while (tmp.compareTo(to) < 0) {
            L.add(tmp);
            num++;
            tmp = format.format(str2Date(tmp).getTime() + 3600 * 24 * 1000);
        }

        if (num == 0)
            System.out.println("两个日期相邻!");

        L.add(to);
        return L;
    }

    private static Date str2Date(String str) {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);

        if (str == null)
            return null;

        try {
            return format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    /**
     * 一个月有几天
     *
     * @param year
     * @param month
     * @return
     */
    public static int dayInMonth(int year, int month) {
        boolean yearleap = isLeapYear(year);
        int day;
        if (yearleap && month == 2) {
            day = 29;
        } else if (!yearleap && month == 2) {
            day = 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
        } else {
            day = 31;
        }
        return day;
    }
}
