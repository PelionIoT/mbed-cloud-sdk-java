package com.arm.mbed.cloud.sdk.common;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

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

}
