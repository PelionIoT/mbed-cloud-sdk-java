package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Utilities for APIs")
@Internal
public class ApiUtils {

    private ApiUtils() {
        super();
    }

    /**
     * Ensures that a field is not null.
     * 
     * @param logger
     *            logger to report an error if any
     * @param arg
     *            value of the argument
     * @param argName
     *            name of the argument
     * @throws MbedCloudException
     *             if the field is null
     */
    public static void checkNotNull(SdkLogger logger, Object arg, String argName) throws MbedCloudException {
        if (arg == null) {
            logger.throwSdkException(new IllegalArgumentException("Argument [" + argName + "] cannot be Null"));
        }
    }

    /**
     * Converts strings from snake to camel case.
     * 
     * @param stringToConvert
     *            string to convert
     * @param capitalAtStart
     *            should the first letter be a uppercase or not.
     * @return camel case string.
     */
    public static String convertSnakeToCamel(String stringToConvert, boolean capitalAtStart) {
        if (stringToConvert == null || stringToConvert.isEmpty()) {
            return stringToConvert;
        }
        final StringBuffer sb = new StringBuffer();
        boolean start = true;
        for (final String s : stringToConvert.split("_")) {
            if (start) {
                sb.append(capitalAtStart ? Character.toUpperCase(s.charAt(0)) : Character.toLowerCase(s.charAt(0)));
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

    /**
     * Converts strings from camel to snake case.
     * 
     * @param stringToConvert
     *            string to convert
     * @return snake case string.
     */
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

    /**
     * Case conversion types.
     *
     */
    public enum CaseConversion {
        SNAKE_TO_CAMEL, CAMEL_TO_SNAKE
    }

    /**
     * Case converter factory.
     * <p>
     * Gets a case converter from a type.
     * 
     * @param conversion
     *            conversion type
     * @return case converter
     */
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

    /**
     * Normalises URL path.
     * 
     * @param path
     *            path string
     * @return normalised path
     */
    public static String normalisePath(String path) {
        if (path != null && !path.isEmpty() && path.charAt(0) == '/') {
            return path.substring(1);
        }
        return path;
    }
}
