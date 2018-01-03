package com.arm.mbed.cloud.sdk.common;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "SDK Model Utilities")
public final class SdkModelUtils {

    private SdkModelUtils() {
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
        final Pattern pattern = Pattern.compile("\\[([\'\"][\\w-\\s\\S]*[\'\"],?)*\\]");
        final Matcher matcher = pattern.matcher(listString);
        String[] array = null;
        if (matcher.matches()) { // it is a JSON array
            final String aliasArray = matcher.group(1);
            array = aliasArray.replaceAll("[\'\"]", "").split(",");
        } else { // it must be a CSV string
            array = listString.split(",");
        }
        return Arrays.asList(array);
    }

}
