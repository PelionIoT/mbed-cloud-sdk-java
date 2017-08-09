package com.arm.mbed.cloud.sdk.common;

import java.util.Date;

import org.joda.time.DateTime;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Utilities for APIs")
@Internal
public class TranslationUtils {

    public static Date toDate(DateTime date) {
        return (date == null) ? null : date.toDate();
    }

    public static long toTimeStamp(Long time) {
        return (time == null) ? 0 : time.longValue();
    }

    public static long toLong(Long longE) {
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

}
