package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

public class TestTranslationUtils {

    @Test
    public final void testConvertTimestampStringDateFormat() {
        String timestamp = "Fri, 11 Aug 2017 19:33:35 GMT";
        Date date = null;
        try {
            date = TranslationUtils.convertTimestamp(timestamp, new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z"));
        } catch (Exception e) {
            fail("Could not convert date");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), date);
    }

}
