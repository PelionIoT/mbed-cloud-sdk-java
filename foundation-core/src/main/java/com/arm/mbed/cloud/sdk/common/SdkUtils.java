package com.arm.mbed.cloud.sdk.common;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Hex;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.annotations.Required;

@Preamble(description = "SDK Utilities")
public final class SdkUtils {

    private static final Pattern JSON_ARRAY_PATTERN = Pattern.compile("\\[([\'\"][\\w-\\s\\S]*[\'\"],?)*\\]");

    private SdkUtils() {
        super();
    }

    /**
     * Parses a string containing a list of elements and returning corresponding Java List.
     *
     * @param listString
     *            String containing a list on elements, either a JSON array or a CSV String.
     * @return list of elements
     */
    public static List<String> parseListString(String listString) {
        if (listString == null) {
            return null;
        }
        if (listString.isEmpty()) {
            return new ArrayList<>();
        }
        final Matcher matcher = JSON_ARRAY_PATTERN.matcher(listString);
        String[] array = null;
        if (matcher.matches()) { // it is a JSON array
            final String aliasArray = matcher.group(1);
            array = aliasArray.replaceAll("[\'\"]", "").split(",");
        } else { // it must be a CSV string
            array = listString.split(",");
        }
        return Arrays.asList(array);
    }

    /**
     * Generates a new String composed of copies of the list elements joined together with a copy of the separator.
     *
     * @param list
     *            list of elements to join
     * @param separator
     *            separator between elements
     * @return corresponding string of joined elements separated by the separator.
     */
    public static String joinList(List<?> list, String separator) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        final StringBuilder buffer = new StringBuilder();
        boolean start = true;
        for (final Object element : list) {
            if (!start) {
                buffer.append(separator);
            }
            buffer.append(element.toString().trim());
            start = false;
        }
        return buffer.toString();
    }

    /**
     * Checks whether two URLs are equal.
     *
     * @param url1
     *            one URL
     * @param url2
     *            another URL
     * @return true if the URLs are equal; false otherwise
     */
    public static boolean urlEquals(URL url1, URL url2) {
        if (url1 == null && url2 == null) {
            return true;
        }
        if (url1 == null || url2 == null) {
            return false;
        }
        if (url1.toString() == null) {
            return url2.toString() == null;
        }
        return url1.toString().equals(url2.toString());
    }

    /**
     * Calculates the hashcode of a URL.
     *
     * @param url
     *            a url.
     * @return corresponding hashcode
     */
    public static int urlHashcode(URL url) {
        if (url == null || url.toString() == null) {
            return 0;
        }
        return url.toString().hashCode();
    }

    /**
     * Converts byte array to String.
     * 
     * @param value
     *            byte array
     * @return corresponding hexadecimal string
     */
    public static String toHex(byte[] value) {
        if (value == null) {
            return null;
        }
        return Hex.encodeHexString(value);
    }

    public static StringBuilder generateInvalidModelInstanceErrorMessage(SdkModel model, String argName) {
        final StringBuilder errorBuilder = new StringBuilder(200);
        errorBuilder.append("Parameter [");
        errorBuilder.append(argName);
        errorBuilder.append("] is an invalid instance of ").append(model.getClass().getSimpleName())
                    .append(" model. Please ensure all its fields are valid.");
        return errorBuilder;
    }

    public static StringBuilder generateModelInstanceWithMissingFieldsErrorMessage(SdkModel model,
                                                                                   List<String> missingFields,
                                                                                   String argName) {
        final List<String> setters = new LinkedList<>();
        final Method[] modelMethods = model.getClass().getDeclaredMethods();
        for (final Method modelMethod : modelMethods) {
            if (modelMethod.isAnnotationPresent(Required.class)) {
                for (final String missingField : missingFields) {
                    if (modelMethod.getName().toLowerCase(Locale.UK).contains(missingField.toLowerCase(Locale.UK))) {
                        setters.add(modelMethod.getName());
                        break;
                    }
                }
            }
            if (setters.size() == missingFields.size()) {
                break;
            }
        }
        final StringBuilder errorBuilder = new StringBuilder(200);
        boolean start = true;
        errorBuilder.append("Fields [");
        for (final String missingField : missingFields) {
            if (!start) {
                errorBuilder.append(", ");
            }
            errorBuilder.append(missingField);
            start = false;
        }
        errorBuilder.append("] of parameter [");
        errorBuilder.append(argName);
        errorBuilder.append("] are required. Please ensure they get set using the following setters: ");
        start = true;
        for (final String setter : setters) {
            if (!start) {
                errorBuilder.append(", ");
            }
            errorBuilder.append(setter);
            start = false;
        }
        errorBuilder.append('.');
        return errorBuilder;
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
        final String[] stringElements = stringToConvert.split("_");
        final int numberOfElements = stringElements.length;
        for (final String s : stringElements) {
            if (start) {
                sb.append(capitalAtStart ? Character.toUpperCase(s.charAt(0)) : Character.toLowerCase(s.charAt(0)));
                start = false;
            } else {
                sb.append(Character.toUpperCase(s.charAt(0)));
            }
            if (s.length() > 1) {
                String subString = s.substring(1, s.length());
                if (numberOfElements > 1) {
                    subString = subString.toLowerCase(Locale.getDefault());
                }
                sb.append(subString);
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
                              .replace("__", "_").toLowerCase(Locale.UK).trim();
    }

    public interface CaseConverter {
        String convert(String strToConvert, boolean capitalAtStart);
    }

    /**
     * Case conversion types.
     *
     */
    public enum CaseConversion {
        SNAKE_TO_CAMEL,
        CAMEL_TO_SNAKE
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

}
