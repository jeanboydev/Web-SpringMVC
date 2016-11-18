package com.jeanboy.webapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Next on 2016/11/18.
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class TestDate {

    @Test
    public void testDate() {
        System.out.print(stampToDate(1479330539));
    }


    public String stampToDate(long s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s*1000l);
        return dateFormat.format(calendar.getTime());
    }
}
