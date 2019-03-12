package com.arm.mbed.cloud.sdk.common;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.junit.Test;

public class TestTranslationUtils {

    @Test
    public void testToDateDateTime() {
        DateTime time = new DateTime(1000);
        assertEquals(new Date(1000), TranslationUtils.toDate(time));
    }

    @SuppressWarnings("boxing")
    @Test
    public void testToDateNumberTimeUnit() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(1971, 0, 1, 0, 0, 0);
        assertEquals(calendar.getTime(), TranslationUtils.toDate(365, TimeUnit.DAYS));
        calendar.set(1970, 0, 1, 0, 0, 0);
        assertEquals(calendar.getTime(), TranslationUtils.toDate(0, TimeUnit.DAYS));
        calendar.set(1970, 0, 1, 0, 0, 1);
        assertEquals(calendar.getTime(), TranslationUtils.toDate(1000, TimeUnit.MILLISECONDS));
        calendar.set(2069, 11, 7, 0, 0, 0);
        assertEquals(calendar.getTime(), TranslationUtils.toDate(36500, TimeUnit.DAYS));
    }

    @Test
    public void testToDateTime() {
        DateTime time = new DateTime(1000);
        assertEquals(time, TranslationUtils.toDateTime(new Date(1000)));
    }
    // Test only passing when run in the UK
    // @Test
    // public void testToDefaultTimestamp() {
    // String timestamp = "11-Aug-2017 18:33:35";
    // Calendar calendar = Calendar.getInstance(Locale.getDefault());
    // calendar.set(2017, 7, 11, 18, 33, 35);
    // calendar.set(Calendar.MILLISECOND, 0);
    // assertEquals(timestamp, TranslationUtils.toDefaultTimestamp(calendar.getTime()));
    // }

    @Test
    public void testToRFC3339Timestamp() {
        String timestamp1 = "2017-08-11T18:33:35+0100";
        String timestamp2 = "2017-08-11T17:33:35+0000";
        String timestamp3 = "2017-08-11T17:33:35Z";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("CET"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        Date datetime = TranslationUtils.moveDateTimeToUtc(calendar.getTime());
        String obtainedTimestamp = TranslationUtils.toRfc3339Timestamp(datetime);
        assertThat(obtainedTimestamp, anyOf(is(timestamp1), is(timestamp2), is(timestamp3)));

    }

    @Test
    public void testToRFC3339TimestampUsingJodaImplementation() {
        String timestamp = "2017-08-11T17:33:35.000Z";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("CET"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        Date datetime = calendar.getTime();
        assertEquals(timestamp, TranslationUtils.toUtcTimestamp(datetime));
    }

    @Test
    public void testConvertTimestampStringDate() {
        String timestamp = "2017-08-11T19:33:35+0000";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        try {
            assertEquals(calendar.getTime(), TranslationUtils.convertRfc3339Timestamp(timestamp));
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConvertTimestampStringDateUsingJodaImplementation() {
        String timestamp = "2017-08-11T19:33:35Z";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        try {
            assertEquals(calendar.getTime(), TranslationUtils.convertStringToDate(timestamp));
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testToLongConversion() {
        long longValue = 156433465;
        String longString = String.valueOf(longValue);
        assertEquals(longValue, TranslationUtils.toLong(longString, 0));
        longValue = Long.MAX_VALUE;
        longString = String.valueOf(longValue);
        assertEquals(longValue, TranslationUtils.toLong(longString, 0));
        assertEquals(0, TranslationUtils.toLong("454.4554", 0));
        assertEquals(10, TranslationUtils.toLong("fsdlfsfkls", 10));
        assertEquals(1000, TranslationUtils.toLong(new Date(1000)));
    }

    @SuppressWarnings("boxing")
    @Test
    public void testToBoolConversion() {
        boolean bool = true;
        String boolString = String.valueOf(bool);
        assertEquals(bool, TranslationUtils.toBool(boolString, false));
        assertEquals(false, TranslationUtils.toBool("454.4554", false));
        assertEquals(true, TranslationUtils.toBool("fsdlfsfkls", true));
    }

    @Test
    public void testToDoubleConversion() {
        double doubleValue = 156433465.45464564;
        String doubleString = String.valueOf(doubleValue);
        assertEquals(doubleValue, TranslationUtils.toDouble(doubleString, 0), 0);
        doubleValue = Double.MAX_VALUE;
        doubleString = String.valueOf(doubleValue);
        assertEquals(doubleValue, TranslationUtils.toDouble(doubleString, 0), 0);
        assertEquals(10.0, TranslationUtils.toDouble(new Integer(10)), 0);
        assertEquals(10, TranslationUtils.toDouble("fsdlfsfkls", 10), 0);
        assertEquals(0.0, TranslationUtils.toDouble("fsdlfsfkls"), 0);
    }

    @Test
    public void testAllDateManipulations() {
        String timestamp = "1971-12-08T01:04:45+12:45";
        String timestampInUtc = "1971-12-07T12:19:45.000Z";
        try {
            Date dateInNZ = TranslationUtils.convertStringToDate(timestamp);
            Date dateInUTC = TranslationUtils.convertStringToDate(timestampInUtc);
            assertEquals(dateInUTC, dateInNZ);
            assertEquals(timestampInUtc, TranslationUtils.toUtcTimestamp(dateInNZ));

        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testConvertRFC3339TimestampStringDate() {
        String timestamp = "Fri, 11 Aug 2017 19:33:35 GMT"; // timestamp not following RFC
        Date now = new Date();
        Date date = TranslationUtils.convertRfc3339Timestamp(timestamp, now);
        assertEquals(now, date);
        timestamp = "2017-08-11T19:33:35+0000";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), TranslationUtils.convertRfc3339Timestamp(timestamp, now));
    }

    @Test
    public void testConvertTimestampStringDateFormatDate() {
        String timestamp = "Fri, 11 Aug 2017 19:33:35 GMT";
        Date now = new Date();
        Date date = TranslationUtils.convertTimestamp(timestamp, new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z"),
                                                      now);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), date);
        date = TranslationUtils.convertTimestamp("Fri 11 Aug 2017 19:33:35",
                                                 new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z"), now);
        assertEquals(now, date);
    }

    @Test
    public void testToUrl() {
        URL url = null;
        try {
            url = new URL("http://localhost:80/");
        } catch (MalformedURLException e) {
            fail(e.getMessage());
        }
        assertEquals(url, TranslationUtils.toUrl("http://localhost:80/"));
        assertEquals(null, TranslationUtils.toUrl("a+1"));
    }

    @Test
    public void testToStringURL() {
        URL url = null;
        try {
            url = new URL("http://localhost:80/");
        } catch (MalformedURLException e) {
            fail(e.getMessage());
        }
        assertEquals("http://localhost:80/", TranslationUtils.toString(url));
    }

    @Test
    public void testConvertToInteger() {
        assertEquals(1234, TranslationUtils.toInt(" 1234 ", 0));
        assertEquals(0, TranslationUtils.toInt(" 1p234 ", 0));
    }

    @Test
    public final void testConvertTimestampStringDateFormat() {
        String timestamp = "Fri, 11 Aug 2017 19:33:35 GMT";
        Date date = null;
        try {
            date = TranslationUtils.convertTimestamp(timestamp, new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z"));
        } catch (@SuppressWarnings("unused") Exception e) {
            fail("Could not convert date");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), date);
    }

    @Test
    public void testToTimestamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(2017, 7, 11, 19, 33, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        assertEquals("Fri, 11 Aug 2017 19:33:35 GMT", TranslationUtils.toTimestamp(calendar.getTime(), format));
    }

    @Test
    public void testParseList() {
        String entry = "/3/0/13\n/3/0/18\n/3/0/21";
        List<String> list = TranslationUtils.parseList(entry, "\n");
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals("/3/0/13", list.get(0));
        assertEquals("/3/0/18", list.get(1));
        assertEquals("/3/0/21", list.get(2));
        entry = "/3/0/13";
        list = TranslationUtils.parseList(entry, "\n");
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals("/3/0/13", list.get(0));
    }

}
