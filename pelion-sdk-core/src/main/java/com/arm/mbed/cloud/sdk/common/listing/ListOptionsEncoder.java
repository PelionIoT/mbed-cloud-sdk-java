package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;

@Preamble(description = "Utility to encode listOptions")
@Internal
public final class ListOptionsEncoder {
    public static final String METHOD_INCLUDE_TO_STRING = "encodeInclude";
    public static final String METHOD_FILTER_ENCODE_EQUAL = "encodeSingleEqualFilter";
    public static final String METHOD_FILTER_ENCODE_NOT_EQUAL = "encodeSingleNotEqualFilter";
    public static final String METHOD_FILTER_ENCODE_GREATER_THAN = "encodeSingleGreaterThanFilter";
    public static final String METHOD_FILTER_ENCODE_LESS_THAN = "encodeSingleLessThanFilter";
    public static final String METHOD_FILTER_ENCODE_LIKE = "encodeSingleLikeFilter";
    public static final String METHOD_FILTER_ENCODE_IN = "encodeSingleInFilter";
    public static final String METHOD_FILTER_ENCODE_NOT_IN = "encodeSingleNotInFilter";

    private ListOptionsEncoder() {
        // Nothing to do
    }

    /**
     * Encodes an "equal" filter.
     *
     * @param fieldName
     *            filter key
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @param options
     *            listOptions to consider
     * @return encoded filter
     */
    public static @Nullable <T> T encodeSingleEqualFilter(@Nullable String fieldName, Class<T> type,
                                                          ListOptions options) {
        if (options == null) {
            return null;
        }
        final Object filterObj = options.fetchEqualFilterValue(fieldName);
        return FilterMarshaller.encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing an "equal" filter.
     *
     * @param fieldName
     *            filter key
     * @param options
     *            listOptions to consider
     * @return encoded string filter
     */
    public static @Nullable String encodeSingleEqualFilter(@Nullable String fieldName, ListOptions options) {
        return encodeSingleEqualFilter(fieldName, String.class, options);
    }

    /**
     * Encodes a "not equal" filter.
     * 
     * @param fieldName
     *            filter key
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @param options
     *            listOptions to consider
     * @return encoded filter
     */
    public static @Nullable <T> T encodeSingleNotEqualFilter(@Nullable String fieldName, Class<T> type,
                                                             ListOptions options) {
        if (options == null) {
            return null;
        }
        final Object filterObj = options.fetchNotEqualFilterValue(fieldName);
        return FilterMarshaller.encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "not equal" filter.
     * 
     * @param fieldName
     *            filter key
     * @param options
     *            listOptions to consider
     * @return string encoded filter
     */
    public static @Nullable String encodeSingleNotEqualFilter(@Nullable String fieldName, ListOptions options) {
        return encodeSingleNotEqualFilter(fieldName, String.class, options);
    }

    /**
     * Encodes a "greater than" filter.
     * 
     * @param fieldName
     *            filter key
     * 
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @param options
     *            listOptions to consider
     * @return encoded filter
     */
    public static @Nullable <T> T encodeSingleGreaterThanFilter(@Nullable String fieldName, Class<T> type,
                                                                ListOptions options) {
        if (options == null) {
            return null;
        }
        final Object filterObj = options.fetchGreaterThanFilterValue(fieldName);
        return FilterMarshaller.encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "greater than" filter.
     * 
     * @param fieldName
     *            filter key
     * @param options
     *            listOptions to consider
     * @return string encoded filter
     */
    public static @Nullable String encodeSingleGreaterThanFilter(@Nullable String fieldName, ListOptions options) {
        return encodeSingleGreaterThanFilter(fieldName, String.class, options);
    }

    /**
     * Encodes a "less than" filter.
     * 
     * @param fieldName
     *            filter key
     * 
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @param options
     *            listOptions to consider
     * @return encoded filter
     */
    public static @Nullable <T> T encodeSingleLessThanFilter(@Nullable String fieldName, Class<T> type,
                                                             ListOptions options) {
        if (options == null) {
            return null;
        }
        final Object filterObj = options.fetchLessThanFilterValue(fieldName);
        return FilterMarshaller.encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "less than" filter.
     * 
     * @param fieldName
     *            filter key
     * @param options
     *            listOptions to consider
     * @return string encoded filter
     */
    public @Nullable static String encodeSingleLessThanFilter(@Nullable String fieldName, ListOptions options) {
        return encodeSingleLessThanFilter(fieldName, String.class, options);
    }

    /**
     * Encodes a "like" filter.
     *
     * @param fieldName
     *            filter key
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @param options
     *            listOptions to consider
     * @return encoded filter
     */
    public static @Nullable <T> T encodeSingleLikeFilter(@Nullable String fieldName, Class<T> type,
                                                         ListOptions options) {
        if (options == null) {
            return null;
        }
        final Object filterObj = options.fetchLikeFilterValue(fieldName);
        return FilterMarshaller.encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "like" filter.
     *
     * @param fieldName
     *            filter key
     * @param options
     *            listOptions to consider
     * @return string encoded filter
     */
    public static @Nullable String encodeSingleLikeFilter(@Nullable String fieldName, ListOptions options) {
        return encodeSingleLikeFilter(fieldName, String.class, options);

    }

    /**
     * Encodes an "In" filter.
     *
     * @param fieldName
     *            filter key
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @param options
     *            listOptions to consider
     * @return encoded filter
     */
    public static @Nullable <T> T encodeSingleInFilter(@Nullable String fieldName, Class<T> type, ListOptions options) {
        if (options == null) {
            return null;
        }
        final Object filterObj = options.fetchInFilterValue(fieldName);
        return FilterMarshaller.encodeMultipleFilters(filterObj, type);
    }

    /**
     * Gets a string describing an "In" filter.
     *
     * @param fieldName
     *            filter key
     * @param options
     *            listOptions to consider
     * @return string encoded filter
     */
    public static @Nullable String encodeSingleInFilter(@Nullable String fieldName, ListOptions options) {
        return encodeSingleInFilter(fieldName, String.class, options);
    }

    /**
     * Encodes a "Not In" filter.
     *
     * @param fieldName
     *            filter key
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @param options
     *            listOptions to consider
     * @return encoded filter
     */
    public static @Nullable <T> T encodeSingleNotInFilter(@Nullable String fieldName, Class<T> type,
                                                          ListOptions options) {
        if (options == null) {
            return null;
        }
        final Object filterObj = options.fetchNotInFilterValue(fieldName);
        return FilterMarshaller.encodeMultipleFilters(filterObj, type);
    }

    /**
     * Gets a string describing a "Not In" filter.
     *
     * @param fieldName
     *            filter key
     * @param options
     *            listOptions to consider
     * @return string encoded filter
     */
    public static @Nullable String encodeSingleNotInFilter(@Nullable String fieldName, ListOptions options) {
        return encodeSingleNotInFilter(fieldName, String.class, options);
    }

    /**
     * Gets a string comprising all include fields in Snake case.
     * 
     * @param options
     *            listOptions to consider
     * @return string
     */
    public static @Nullable String encodeInclude(ListOptions options) {
        if (options == null || options.getInclude() == null || options.getInclude().isEmpty()) {
            return null;
        }
        boolean start = true;
        final StringBuilder builder = new StringBuilder();
        for (final IncludeField includeField : options.getInclude()) {
            if (!start) {
                builder.append(',');
            }
            builder.append(includeField.encode());
            start = false;
        }
        return builder.toString();
    }
}
