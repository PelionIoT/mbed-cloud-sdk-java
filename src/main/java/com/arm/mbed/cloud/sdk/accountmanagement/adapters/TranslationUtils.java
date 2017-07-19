package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.Date;

import org.joda.time.DateTime;

class TranslationUtils {

	public static Date toDate(DateTime date) {
		return (date == null) ? null : date.toDate();
	}

	public static long toTimeStamp(Long time) {
		return (time == null) ? 0 : time;
	}

	public static int toInt(Integer integer) {
		return (integer == null) ? 0 : integer;
	}

	public static boolean toBool(Boolean bool, boolean defaultB) {
		return (bool == null) ? defaultB : bool;
	}
}
