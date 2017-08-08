package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Utilities for APIs")
@Internal
public class ApiUtils {

    public static void checkNotNull(Object arg, String argName) throws MbedCloudException {
        if (arg == null) {
            throw new MbedCloudException(new IllegalArgumentException("Argument [" + argName + "] cannot be Null"));
        }
    }

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
        return stringToConvert.replaceAll("(.)(\\p{Upper})", "$1_$2").replaceAll("(\\p{Upper})(\\p{Upper})", "$1_$2")
                .toLowerCase();
    }

    public interface CaseConverter {
        String convert(String strToConvert, boolean capitalAtStart);
    }

    public enum CaseConversion {
        SNAKE_TO_CAMEL, CAMEL_TO_SNAKE
    }

    public static CaseConverter getCaseConverter(CaseConversion conversion) {
        CaseConverter converter = null;
        switch (conversion) {
            case CAMEL_TO_SNAKE:
                converter = new CaseConverter() {

                    @Override
                    public String convert(String strToConvert, boolean capitalAtStart) {
                        return convertCamelToSnake(strToConvert);
                    }
                };
                break;
            case SNAKE_TO_CAMEL:
                converter = new CaseConverter() {

                    @Override
                    public String convert(String strToConvert, boolean capitalAtStart) {
                        return convertSnakeToCamel(strToConvert, capitalAtStart);
                    }
                };
                break;
            default:
                break;

        }
        return converter;
    }

    public static String normalisePath(String path) {
        if (path != null && path.startsWith("/")) {
            return path.substring(1);
        }
        return path;
    }
}
