package com.jeanboy.webapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by Next on 2016/11/18.
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class TestDate {

    @Test
    public void testDate() {
//        System.out.println(stampToDate(System.currentTimeMillis() / 1000));

//        TimeZone timeZone = null;
//        String[] ids = TimeZone.getAvailableIDs();
//        for (String id : ids) {
//            if (id.contains("Atikokan")) {
//                timeZone = TimeZone.getTimeZone(id);
//                break;
//            }
//        }
//        long time = getTomorrowHourTime(timeZone, 8);
//        long time = getHourTime(timeZone, 1480582800L * 1000L, 0, 8);
//        long time1 = getHourTime(timeZone, 1480597200L * 1000L, 0, 8);
//        System.out.println(time);
//        System.out.println(stampToDate(1481047200000L));
//        System.out.println(stampToDate(1480827600000L));
//        System.out.println(stampToDate(1480896000000L));
//        System.out.println(stampToDate(1482422400000L));

//        String text = "https://play.google.com/store/apps/details?id=com.fotoable.solitaire";
//
//        String mark="details?id=";
//        if (text.contains(mark)) {
//            text = text.substring(text.indexOf(mark)+mark.length(), text.length());
//            System.out.println(text);
//        }

//        String MARKET_FLAG = "details?id=";
//        String URL_FLAG = "http";
//
//        String actionUrl = "";
//        String packageName = "";
//
//        String url = "market://details?id=com.fotoable.game";
//
//        if (url.contains(MARKET_FLAG)) {//市场连接
//            packageName = url.substring(url.indexOf(MARKET_FLAG) + MARKET_FLAG.length(), url.length());
//            if (url.contains(URL_FLAG)) {//http连接
//                actionUrl = url;
//            } else {
//                actionUrl = "https://play.google.com/store/apps/details?id=" + packageName;
//            }
//        } else {
//            if (url.contains(URL_FLAG)) {//http连接
//                actionUrl = url;
//            } else {
//                packageName = url;
//            }
//        }
//
//        if (!isEmpty(packageName)) {//market链接
//            System.out.println("==market链接=actionUrl=" + actionUrl + "====packageName==" + packageName);
//        } else if (!isEmpty(actionUrl)) {//不是market链接，通过浏览器打开
//
//            System.out.println("==不是market链接=actionUrl=" + actionUrl + "====packageName==" + packageName);
//        }
//
//        System.out.println("===actionUrl=" + actionUrl + "=========packageName============" + packageName);


        for (int i = 0; i < 10; i++) {
            System.out.println("========" + getRandomNumber(6, 0));
        }
    }

    private int getRandomNumber(int max, int min) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }


    public boolean isEmpty(String text) {
        return null == text || "".equals(text);
    }


    public String stampToDate(long s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a E");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("a");
//        String[] ids = TimeZone.getAvailableIDs();
//        for (String id : ids) {
//            if (id.contains("Atikokan")) {
//                dateFormat.setTimeZone(TimeZone.getTimeZone(id));
//                break;
//            }
//        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return dateFormat.format(calendar.getTime());
    }

    public int getStampHour(long s) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public long getTomorrowHourTime(TimeZone timeZone, int hour24) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if (timeZone != null) {
            calendar.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, hour24);
        return calendar.getTimeInMillis();
    }

    public static long getHourTime(TimeZone timeZone, long timestamp, int addDay, int hour24) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        if (timeZone != null) {
            calendar.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, addDay);
        calendar.set(Calendar.HOUR_OF_DAY, hour24);
        return calendar.getTimeInMillis();
    }

}
