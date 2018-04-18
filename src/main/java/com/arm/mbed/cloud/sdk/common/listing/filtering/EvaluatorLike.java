package com.arm.mbed.cloud.sdk.common.listing.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Evaluates whether a value complies to a LIKE filter")
@Internal
public class EvaluatorLike implements FilterEvaluator {

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.LIKE) {
            return false;
        }
        final Object filterValue = filter.getValue();
        return verify(value, filterValue);
    }

    @SuppressWarnings({ "rawtypes" })
    protected static boolean verify(Object value, final Object filterValue) {
        if (EvaluatorEqual.verify(value, filterValue)) {
            return true;
        }
        if (value == null && filterValue != null || value != null && filterValue == null) {
            return false;
        }
        if (filterValue instanceof List) {
            return verifyList(value, (List) filterValue);
        }
        if (filterValue.getClass().isArray()) {
            return verifyArray(value, filterValue);
        }
        if (filterValue instanceof String || filterValue instanceof CharSequence) {
            final String pattern = String.valueOf(filterValue);
            final String valueString = String.valueOf(value).toLowerCase(Locale.getDefault());
            if (valueString.contains(pattern) || valueString.contains(pattern.toLowerCase(Locale.getDefault()))) {
                return true;
            }
            // If filterValue is a Java Regex.
            try {
                if (Pattern.matches(pattern, valueString)) {
                    return true;
                }
            } catch (PatternSyntaxException exception) {
                // Nothing to do
            }
            // If filterValue is a SQL like entry i.e.
            final String javaPattern = pattern.toLowerCase(Locale.getDefault()).replace(".", "\\.").replace("*", "\\*")
                    .replace("?", ".").replace("_", ".").replace("%", ".*");
            try {
                return Pattern.matches(javaPattern, valueString);
            } catch (PatternSyntaxException exception) {
                return false;
            }
        }
        // If not a string "like" is equivalent to equal
        return EvaluatorEqual.verify(value, filterValue);
    }

    @SuppressWarnings({ "unchecked", "boxing" })
    protected static boolean verifyArray(Object value, final Object filterValue) {
        if (filterValue instanceof String[]) {
            return verifyList(value, Arrays.asList((String[]) filterValue));
        }
        if (filterValue instanceof Object[]) {
            return verifyList(value, Arrays.asList(((Object[]) filterValue)));
        }
        @SuppressWarnings("rawtypes")
        List list = null;
        if (filterValue instanceof byte[]) {
            list = new ArrayList<>();
            for (final byte filterSubValue : (byte[]) filterValue) {
                list.add(filterSubValue);
            }
        }
        if (filterValue instanceof short[]) {
            list = new ArrayList<>();
            for (final short filterSubValue : (short[]) filterValue) {
                list.add(filterSubValue);
            }
        }
        if (filterValue instanceof int[]) {
            list = new ArrayList<>();
            for (final int filterSubValue : (int[]) filterValue) {
                list.add(filterSubValue);
            }
        }
        if (filterValue instanceof long[]) {
            list = new ArrayList<>();
            for (final long filterSubValue : (long[]) filterValue) {
                list.add(filterSubValue);
            }
        }
        if (filterValue instanceof float[]) {
            list = new ArrayList<>();
            for (final float filterSubValue : (float[]) filterValue) {
                list.add(filterSubValue);
            }
        }
        if (filterValue instanceof double[]) {

            list = new ArrayList<>();
            for (final double filterSubValue : (double[]) filterValue) {
                list.add(filterSubValue);
            }
        }
        if (filterValue instanceof boolean[]) {
            list = new ArrayList<>();
            for (final boolean filterSubValue : (boolean[]) filterValue) {
                list.add(filterSubValue);
            }

        }
        if (filterValue instanceof char[]) {
            list = new ArrayList<>();
            for (final char filterSubValue : (char[]) filterValue) {
                list.add(filterSubValue);
            }
        }

        return verifyList(value, list);
    }

    @SuppressWarnings("rawtypes")
    protected static boolean verifyList(Object value, final List filterValues) {
        if (filterValues == null) {
            return false;
        }
        for (final Object filterSubValue : filterValues) {
            if (verify(value, filterSubValue)) {
                return true;
            }
        }
        return false;
    }

}
