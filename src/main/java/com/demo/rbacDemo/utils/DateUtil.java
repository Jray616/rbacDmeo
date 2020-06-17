package com.demo.rbacDemo.utils;

import cn.hutool.core.date.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil extends cn.hutool.core.date.DateUtil {


    /**
     * 获取指定时间的时间戳
     * @param data yyyy-MM-dd 格式
     * @return
     * @throws ParseException
     */
    public static long getMillis(String data) {


        long timestamp = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(data);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            timestamp = cal.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timestamp;


    }


    /**
     * 获取本周开始时间 时间戳
     * @return
     */
    public static long getWeek() throws ParseException {

        //本周开始时间
        DateTime weekEnd = beginOfWeek(new Date());
        long weekEndNum = DateUtil.getMillis(weekEnd.toDateStr());

        return weekEndNum;


    }


    /**
     * 获取上周开始时间 时间戳
     * @return
     */
    public static long getLastWeek() throws ParseException {
        //上周开始时间
        DateTime weekStart = DateUtil.beginOfWeek(DateUtil.lastWeek());
        long weekStartNum = DateUtil.getMillis(weekStart.toDateStr());
        return weekStartNum;
    }


    /**
     * 是否是今天
     * @param time 毫秒时间戳
     * @return
     */
    public static boolean isToDay(long time) {

        DateTime date = date(time);
        String dateBefore = formatDate(date);
        String today = today();

        if (today.equals(dateBefore)) {
            return true;
        }
        return false;
    }


    /**
     * 是否是本周
     * @return
     */
    public static boolean isWeek(long time) {
        DateTime date = date(time);
        int week = weekOfYear(date);
        int now = weekOfYear(new Date());

        if (week == now) {
            return true;
        }

        return false;

    }

    /**
     * 是否是本月
     * @param time
     * @return
     */
    public static boolean isMonth(long time) {

        DateTime date = date(time);
        String dateBefore = formatDate(date);
        String substringDateBefore = dateBefore.substring(7);

        String today = today();
        String substringAfter = today.substring(7);

        if (substringAfter.equals(substringDateBefore)) {
            return true;
        }
        return false;

    }



}
