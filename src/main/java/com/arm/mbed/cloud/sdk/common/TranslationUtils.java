package com.arm.mbed.cloud.sdk.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Utilities for APIs")
@Internal
public final class TranslationUtils {

    private static final SimpleDateFormat RFC3339_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",
            Locale.getDefault());

    private TranslationUtils() {
        super();
    }

    public static Date toDate(DateTime date) {
        return (date == null) ? null : date.toDate();
    }

    public static Date toDate(Number timestamp, TimeUnit unit) {
        if (timestamp == null || unit == null) {
            return null;
        }
        long time = toLong(timestamp);
        switch (unit) {
            case DAYS:
                time = time * 86400000;
                break;
            case HOURS:
                time = time * 3600000;
                break;
            case MICROSECONDS:
                time = time / 1000;
                break;
            case MINUTES:
                time = time * 60000;
                break;
            case NANOSECONDS:
                time = time / 1000000;
                break;
            case SECONDS:
                time = time * 1000;
                break;
            case MILLISECONDS:
            default:
                break;

        }
        return new Date(time);
    }

    public static DateTime toDateTime(Date date) {
        return (date == null) ? null : new DateTime(date);
    }

    public static LocalDate toLocalDate(Date date) {
        return (date == null) ? null : new LocalDate(date);
    }

    public static long toTimeStamp(Long time) {
        return (time == null) ? 0 : time.longValue();
    }

    public static long toLong(Number longE) {
        return (longE == null) ? 0 : longE.longValue();
    }

    public static int toInt(Integer integer) {
        return toInt(integer, 0);
    }

    public static int toInt(Integer integer, int defaultV) {
        return (integer == null) ? defaultV : integer.intValue();
    }

    public static boolean toBool(Boolean bool, boolean defaultB) {
        return (bool == null) ? defaultB : bool.booleanValue();
    }

    public static synchronized Date convertTimestamp(String timestamp) throws MbedCloudException {
        return convertTimestamp(timestamp, DateFormat.getDateTimeInstance());
    }

    public static synchronized Date convertRFC3339Timestamp(String timestamp) throws MbedCloudException {
        return convertTimestamp(timestamp, RFC3339_DATE_FORMAT);
    }

    public static synchronized String toDefaultTimestamp(Date date) {
        return toTimestamp(date, DateFormat.getDateTimeInstance());
    }

    public static synchronized String toRFC3339Timestamp(Date date) {
        return toTimestamp(date, RFC3339_DATE_FORMAT);
    }

    public static synchronized Date convertTimestamp(String timestamp, Date defaultDate) {
        try {
            return TranslationUtils.convertTimestamp(timestamp);
        } catch (Exception e) {
            return defaultToDefaultDate(timestamp, defaultDate, e);
        }
    }

    public static synchronized Date convertRFC3339Timestamp(String timestamp, Date defaultDate) {
        try {
            return TranslationUtils.convertRFC3339Timestamp(timestamp);
        } catch (Exception e) {
            return defaultToDefaultDate(timestamp, defaultDate, e);
        }
    }

    public static synchronized Date convertTimestamp(String timestamp, DateFormat format, Date defaultDate) {
        try {
            return TranslationUtils.convertTimestamp(timestamp, format);
        } catch (Exception e) {
            return defaultToDefaultDate(timestamp, defaultDate, e);
        }
    }

    private static Date defaultToDefaultDate(String timestamp, Date defaultDate, Exception e) {
        SdkLogger.getLogger()
                .logError("Error occurred when parsing timestamp [" + timestamp + "]. Defaulting to " + defaultDate, e);
        return defaultDate;
    }

    public static URL toUrl(String url) {
        try {
            return url == null || url.isEmpty() ? null : new URL(url);
        } catch (MalformedURLException e) {
            SdkLogger.getLogger().logError("Error occurred when parsing URL [" + url + "]. Defaulting to null", e);
        }
        return null;
    }

    public static String toString(URL url) {
        return (url == null) ? null : url.toString();
    }

    public static Integer convertToInteger(String value, Integer defaultV) {
        if (value == null) {
            return defaultV;
        }
        try {
            return Integer.decode(value);
        } catch (NumberFormatException e) {
            return defaultV;
        }
    }

    public static synchronized Date convertTimestamp(String timestamp, DateFormat format) throws MbedCloudException {
        if (timestamp == null || timestamp.isEmpty() || format == null) {
            return null;
        }
        try {
            return format.parse(timestamp);
        } catch (ParseException e) {
            throw new MbedCloudException("Error occurred when parsing timestamp [" + timestamp + "].", e);
        }
    }

    public static String toTimestamp(Date date, DateFormat format) {
        if (date == null || format == null) {
            return null;
        }
        return format.format(date);
    }
}
