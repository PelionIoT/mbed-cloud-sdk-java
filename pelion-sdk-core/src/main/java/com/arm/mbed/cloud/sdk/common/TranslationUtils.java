package com.arm.mbed.cloud.sdk.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Utilities for Adapters")
@Internal
public final class TranslationUtils {

    private static final SimpleDateFormat RFC3339_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",
            Locale.getDefault());
    private static final DateTimeFormatter DATE_ISO_PARSER = ISODateTimeFormat.dateTimeParser();
    private static final DateTimeFormatter DATE_ISO_PRINTER = ISODateTimeFormat.dateTime();

    private TranslationUtils() {
        super();
    }

    /**
     * Converts datetime to date.
     *
     * @param date
     *            datetime
     * @return corresponding date
     */
    public static Date toDate(DateTime date) {
        return (date == null) ? null : date.toDate();
    }

    /**
     * Converts calendar to date.
     *
     * @param date
     *            calendar
     * @return corresponding date
     */
    public static Date toDate(Calendar date) {
        return (date == null) ? null : date.getTime();
    }

    /**
     * Converts timestamp into a date.
     *
     * @param timestamp
     *            timestamp
     * @param unit
     *            time unit
     * @return corresponding date.
     */
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

    /**
     * Converts to datetime.
     *
     * @param date
     *            date
     * @return corresponding datetime.
     */
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

    /**
     * Converts string to a long value.
     *
     * @param stringContainingANumber
     *            string containing a number
     * @param defaultValue
     *            default long value to consider if string parsing failed
     * @return long contained in string or default value if parsing failed
     */
    public static long toLong(String stringContainingANumber, long defaultValue) {
        if (stringContainingANumber == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(stringContainingANumber);
        } catch (NumberFormatException exception) {
            SdkLogger.getLogger().logError("Error occurred when parsing the string containing a long number ["
                    + stringContainingANumber + "]. Defaulting to " + defaultValue, exception);
            return defaultValue;
        }
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

    /**
     * Converts timestamp to date.
     *
     * @param timestamp
     *            string representing a date.
     * @return corresponding date or default date
     *
     * @throws MbedCloudException
     *             if timestamp is not recognised
     */
    public static synchronized Date convertTimestamp(String timestamp) throws MbedCloudException {
        return convertTimestamp(timestamp, DateFormat.getDateTimeInstance());
    }

    /**
     * Converts timestamp into dates.
     *
     * @param timestamp
     *            string representing a date
     * @param defaultDate
     *            default date if date is not recognised
     * @return corresponding date or default date
     */
    public static synchronized Date convertTimestamp(String timestamp, Date defaultDate) {
        try {
            return TranslationUtils.convertTimestamp(timestamp);
        } catch (Exception exception) {
            return defaultToDefaultDate(timestamp, defaultDate, exception);
        }
    }

    /**
     * Converts timestamp to date.
     *
     * @param timestamp
     *            string representing a date.
     * @param format
     *            date format of the string.
     * @param defaultDate
     *            default date if date is not recognised
     * @return corresponding date or default date
     */
    public static synchronized Date convertTimestamp(String timestamp, DateFormat format, Date defaultDate) {
        try {
            return TranslationUtils.convertTimestamp(timestamp, format);
        } catch (Exception exception) {
            return defaultToDefaultDate(timestamp, defaultDate, exception);
        }
    }

    /**
     * Parses a timestamp string.
     *
     * @param timestamp
     *            string representing a date
     * @param format
     *            date format the string abides by
     * @return corresponding date
     * @throws MbedCloudException
     *             if string is not recognised as a valid date (i.e. abiding by the format)
     */
    public static synchronized Date convertTimestamp(String timestamp, DateFormat format) throws MbedCloudException {
        if (timestamp == null || timestamp.isEmpty() || format == null) {
            return null;
        }
        try {
            return format.parse(timestamp);
        } catch (ParseException exception) {
            throw new MbedCloudException("Error occurred when parsing timestamp [" + timestamp + "].", exception);
        }
    }

    /**
     *
     * Converts timestamp following RFC3339 into dates.
     *
     * @param timestamp
     *            string representing a date and following RFC3339
     * @return corresponding date
     * @throws MbedCloudException
     *             if timestamp does not follow RFC3339
     */
    public static synchronized Date convertRfc3339Timestamp(String timestamp) throws MbedCloudException {
        return convertTimestamp(timestamp, RFC3339_DATE_FORMAT);
    }

    /**
     * Converts timestamp following RFC3339 into dates.
     *
     * @param timestamp
     *            string representing a date and following RFC3339
     * @param defaultDate
     *            default date if date is not recognised
     * @return corresponding date or default date
     */
    public static synchronized Date convertRfc3339Timestamp(String timestamp, Date defaultDate) {
        try {
            return TranslationUtils.convertRfc3339Timestamp(timestamp);
        } catch (Exception exception) {
            return defaultToDefaultDate(timestamp, defaultDate, exception);
        }
    }

    /**
     * Gets default string representation of a date.
     *
     * @param date
     *            date
     * @return string representation
     */
    public static synchronized String toDefaultTimestamp(Date date) {
        return toTimestamp(date, DateFormat.getDateTimeInstance());
    }

    /**
     * Gets RFC3339 string representation of a date.
     *
     * @param date
     *            date
     * @return string representation
     */
    public static synchronized String toRfc3339Timestamp(Date date) {
        return toTimestamp(date, RFC3339_DATE_FORMAT);
    }

    private static Date defaultToDefaultDate(String timestamp, Date defaultDate, Exception exception) {
        SdkLogger.getLogger().logError(
                "Error occurred when parsing timestamp [" + timestamp + "]. Defaulting to " + defaultDate, exception);
        return defaultDate;
    }

    /**
     * Converts string to URL.
     *
     * @param url
     *            string
     * @return corresponding URL or null if incorrect.
     */
    public static URL toUrl(String url) {
        try {
            return url == null || url.isEmpty() ? null : new URL(url);
        } catch (MalformedURLException exception) {
            SdkLogger.getLogger().logError("Error occurred when parsing URL [" + url + "]. Defaulting to null",
                    exception);
        }
        return null;
    }

    /**
     * Converts URL to string.
     *
     * @param url
     *            a URL
     * @return corresponding string
     */
    public static String toString(URL url) {
        return (url == null) ? null : url.toString();
    }

    /**
     * Converts a string to an integer.
     *
     * @param value
     *            string containing an integer.
     * @param defaultV
     *            default value to consider if string not recognised as an integer representation
     * @return corresponding integer or default value if not recognised
     */
    public static Integer convertToInteger(String value, Integer defaultV) {
        if (value == null) {
            return defaultV;
        }
        try {
            return Integer.decode(value.trim());
        } catch (NumberFormatException exception) {
            SdkLogger.getLogger().logError(
                    "Error occurred when parsing integer [" + value + "]. Defaulting to " + defaultV, exception);
            return defaultV;
        }
    }

    /**
     * Converts date into a timestamp string.
     *
     * @param date
     *            date to convert
     * @param format
     *            date string format.
     * @return string representation
     */
    public static String toTimestamp(Date date, DateFormat format) {
        if (date == null || format == null) {
            return null;
        }
        return format.format(date);
    }

    /**
     * Extracts a list of strings from a string.
     *
     * @param string
     *            string containing a list of string elements
     * @param separator
     *            string used as element separator
     * @return list of string elements
     */
    public static List<String> parseList(String string, String separator) {
        if (string == null || separator == null) {
            return null;
        }
        return Arrays.asList(string.split(separator));
    }

    /**
     * Moves dates to UTC time zone.
     *
     * @param date
     *            date/time
     * @return date/time in UTC
     */
    public static DateTime moveToUtc(Date date) {
        return (date == null) ? null : new DateTime(date).toDateTime(DateTimeZone.UTC);
    }

    /**
     * Moves dates to UTC time zone.
     *
     * @param date
     *            date/time
     * @return date/time in UTC
     */
    public static Date moveDateTimeToUtc(Date date) {
        final DateTime time = moveToUtc(date);
        return (time == null) ? null : time.toDate();
    }

    /**
     * Converts date into a UTC timestamp string.
     *
     * @param date
     *            date/time
     * @return timestamp in UTC (RFC3339)
     */
    public static String toUtcTimestamp(Date date) {
        // Moving dates/Times to UTC and formatting them according to rfc3339
        return (date == null) ? null : DATE_ISO_PRINTER.print(moveToUtc(date));
    }

    /**
     *
     * Converts string following RFC3339 into dates.
     * <p>
     * Similar to {@link #convertRfc3339Timestamp(String)} but using Joda time implementation.
     *
     * @see DateTimeFormatter#parseDateTime(String)
     *
     * @param valueStr
     *            string representing a date and following RFC3339
     * @return corresponding date
     * @throws MbedCloudException
     *             if string does not follow RFC3339
     */
    public static Date convertStringToDate(String valueStr) throws MbedCloudException {
        try {
            return DATE_ISO_PARSER.parseDateTime(valueStr).toDate();
        } catch (Exception exception) {
            throw new MbedCloudException(exception);
        }
    }
}
