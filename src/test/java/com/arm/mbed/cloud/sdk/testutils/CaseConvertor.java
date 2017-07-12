package com.arm.mbed.cloud.sdk.testutils;

public class CaseConvertor {

	public static String convertSnakeToCamel(String stringToConvert, boolean capitalAtStart) {
		if (stringToConvert == null || stringToConvert.isEmpty()) {
			return stringToConvert;
		}
		StringBuffer sb = new StringBuffer();
		boolean start = true;
		for (String s : stringToConvert.split("_")) {
			if (start) {
				sb.append((capitalAtStart) ? Character.toUpperCase(s.charAt(0)) : Character.toLowerCase(s.charAt(0)));
				start = false;
			} else {
				sb.append(Character.toUpperCase(s.charAt(0)));
			}
			if (s.length() > 1) {
				sb.append(s.substring(1, s.length()).toLowerCase());
			}
		}
		return sb.toString();
	}

	public static String convertCamelToSnake(String stringToConvert) {
		if (stringToConvert == null || stringToConvert.isEmpty()) {
			return stringToConvert;
		}
		return stringToConvert.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
	}

}
