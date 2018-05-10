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

    private static final String BOXING = "boxing";
    private static final String UNCHECKED = "unchecked";
    private static final String RAWTYPES = "rawtypes";

    @Override
    public boolean isVerified(Filter filter, Object value) {
        if (filter == null || filter.getOperator() != FilterOperator.LIKE) {
            return false;
        }
        final Object filterValue = filter.getValue();
        return verify(value, filterValue);
    }

    @SuppressWarnings({ RAWTYPES })
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
            return verifyStringLike(value, filterValue);
        }
        // If not a string "like" is equivalent to equal
        return EvaluatorEqual.verify(value, filterValue);
    }

    private static boolean verifyStringLike(Object value, final Object filterValue) {
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

    protected static boolean verifyArray(Object value, final Object filterValue) {
        if (filterValue instanceof String[]) {
            return verifyList(value, Arrays.asList((String[]) filterValue));
        }
        if (filterValue instanceof Object[]) {
            return verifyList(value, Arrays.asList(((Object[]) filterValue)));
        }
        @SuppressWarnings(RAWTYPES)
        final List list = new ArrayList<>();
        handleByteArray(filterValue, list);
        handleShortArray(filterValue, list);
        handleIntegerArray(filterValue, list);
        handleLongArray(filterValue, list);
        handleFloatArray(filterValue, list);
        handleDoubleArray(filterValue, list);
        handleBooleanArray(filterValue, list);
        handleCharacterArray(filterValue, list);

        return verifyList(value, list);
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleByteArray(final Object filterValue, List list) {
        if (filterValue instanceof byte[]) {
            for (final byte filterSubValue : (byte[]) filterValue) {
                list.add(filterSubValue);
            }
        }
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleShortArray(final Object filterValue, List list) {
        if (filterValue instanceof short[]) {
            for (final short filterSubValue : (short[]) filterValue) {
                list.add(filterSubValue);
            }
        }
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleIntegerArray(final Object filterValue, List list) {
        if (filterValue instanceof int[]) {
            for (final int filterSubValue : (int[]) filterValue) {
                list.add(filterSubValue);
            }
        }
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleLongArray(final Object filterValue, List list) {
        if (filterValue instanceof long[]) {
            for (final long filterSubValue : (long[]) filterValue) {
                list.add(filterSubValue);
            }
        }
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleFloatArray(final Object filterValue, List list) {
        if (filterValue instanceof float[]) {
            for (final float filterSubValue : (float[]) filterValue) {
                list.add(filterSubValue);
            }
        }
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleDoubleArray(final Object filterValue, List list) {
        if (filterValue instanceof double[]) {
            for (final double filterSubValue : (double[]) filterValue) {
                list.add(filterSubValue);
            }
        }
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleBooleanArray(final Object filterValue, List list) {
        if (filterValue instanceof boolean[]) {
            for (final boolean filterSubValue : (boolean[]) filterValue) {
                list.add(filterSubValue);
            }

        }
    }

    @SuppressWarnings({ RAWTYPES, UNCHECKED, BOXING })
    private static void handleCharacterArray(final Object filterValue, List list) {
        if (filterValue instanceof char[]) {
            for (final char filterSubValue : (char[]) filterValue) {
                list.add(filterSubValue);
            }
        }
    }

    @SuppressWarnings(RAWTYPES)
    protected static boolean verifyList(Object value, final List filterValues) {
        if (filterValues == null || filterValues.isEmpty()) {
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
