package com.arm.mbed.cloud.sdk.common.listing;

import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.SdkUtils;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

@Preamble(description = "Options to use when listing objects")
public class ListOptions extends FilterOptions {
    public static final String FIELD_NAME_INCLUDE = "include";
    public static final String FIELD_NAME_FILTER = "filter";
    public static final String FIELD_NAME_PAGESIZE = "pageSize";
    public static final String FIELD_NAME_FORMER_PAGESIZE = "limit";
    public static final String FIELD_NAME_ORDER = "order";
    public static final String METHOD_INCLUDE_TO_STRING = "encodeInclude";
    public static final String METHOD_FILTER_TO_STRING = FilterOptions.METHOD_FILTER_TO_STRING;
    public static final String METHOD_FILTER_ENCODE_EQUAL = "encodeSingleEqualFilter";
    public static final String METHOD_FILTER_ENCODE_NOT_EQUAL = "encodeSingleNotEqualFilter";
    public static final String METHOD_FILTER_ENCODE_GREATER_THAN = "encodeSingleGreaterThanFilter";
    public static final String METHOD_FILTER_ENCODE_LESS_THAN = "encodeSingleLessThanFilter";
    public static final String METHOD_FILTER_ENCODE_LIKE = "encodeSingleLikeFilter";
    public static final String METHOD_FILTER_ENCODE_IN = "encodeSingleInFilter";
    public static final String METHOD_FILTER_ENCODE_NOT_IN = "encodeSingleNotInFilter";
    /**
     * how many objects to retrieve in the page.
     * <P>
     * This parameter is relevant to results pages {@link ListResponse}.
     * <p>
     * If set to null, the default page size will be used.
     */
    @DefaultValue(value = "null")
    protected Integer pageSize;
    /**
     * how many objects to retrieve in total.
     * <P>
     * This parameter is relevant to paginators {@link Paginator}.
     * <p>
     * If set to null, all results present in the dataset will be returned.
     */
    @DefaultValue(value = "null")
    protected Long maxResults;
    /**
     * Sorting order. ASC or DESC
     */
    @DefaultValue(value = "ASC")
    protected Order order;
    /**
     * the ID of the the item after which to retrieve the next page.
     */
    protected String after;
    /**
     * Optional fields to include.
     */
    protected List<IncludeField> include;

    /**
     * Constructor.
     */
    public ListOptions() {
        super();
        setDefault();
    }

    /**
     * Constructor.
     *
     * @param limit
     *            limit.
     * @param order
     *            order.
     * @param after
     *            after.
     * @param include
     *            include.
     * @param filter
     *            filter.
     */
    @Internal
    @Deprecated
    protected ListOptions(Integer limit, Order order, String after, List<IncludeField> include, Filters filter) {
        this(limit, null, order, after, include, filter);
    }

    /**
     * Constructor.
     *
     * @param pageSize
     *            pageSize.
     * @param maxResults
     *            maxResults.
     * @param order
     *            order.
     * @param after
     *            after.
     * @param include
     *            include.
     * @param filter
     *            filter.
     */
    @Internal
    public ListOptions(Integer pageSize, Long maxResults, Order order, String after, List<IncludeField> include,
                       Filters filter) {
        super();
        this.pageSize = pageSize;
        this.maxResults = maxResults;
        this.order = order;
        this.after = after;
        this.include = include;
        this.filter = filter;
    }

    /**
     * Gets the limit.
     * <p>
     * Note: Use {@link #getPageSize()} instead
     *
     * @return the limit
     */
    @Deprecated
    public Integer getLimit() {
        return getPageSize();
    }

    /**
     * Sets the limit.
     * <p>
     * Note: Use {@link #setPageSize(Integer)} instead
     *
     * @param limit
     *            the limit to set
     */
    @Deprecated
    public void setLimit(Integer limit) {
        setPageSize(limit);
    }

    /**
     * Gets how many objects will be retrieved per page.
     *
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Gets how many objects are requested in total.
     *
     * @return the maximum number of results returned.
     */
    public Long getMaxResults() {
        return maxResults;
    }

    /**
     * States whether the maximum number of expected results has been set or not.
     *
     * @return true if the number has been set. False otherwise.
     */
    public boolean hasMaxResults() {
        return maxResults != null;
    }

    /**
     * Sets how many objects to retrieve in the page.
     * <P>
     * This parameter is relevant to results pages {@link ListResponse}.
     * <p>
     * If set to null, the default page size will be used.
     *
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Sets how many objects to retrieve in the page.
     * <P>
     * Note: Similar to {@link #setPageSize(Integer)}
     *
     * @param enforcedPageSize
     *            the pageSize to set
     * @param <T>
     *            this type
     * @return this
     */
    @SuppressWarnings("unchecked")
    public <T extends ListOptions> T pageSize(int enforcedPageSize) {
        setPageSize(Integer.valueOf(enforcedPageSize));
        return (T) this;
    }

    /**
     * Sets how many objects to retrieve in total.
     * <P>
     * This parameter is relevant to paginators {@link Paginator}.
     * <p>
     * If set to null, all results present in the dataset will be returned.
     *
     * @param maxResults
     *            the number of results to request
     */
    public void setMaxResults(Long maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * Sets how many objects to retrieve in total.
     * <p>
     * Note: Similar to {@link #setMaxResults(Long)}
     *
     * @param requestedMaxResults
     *            the number of results to request
     * @param <T>
     *            this type
     * @return this
     */
    @SuppressWarnings("unchecked")
    public <T extends ListOptions> T maxResults(long requestedMaxResults) {
        setMaxResults(Long.valueOf(requestedMaxResults));
        return (T) this;
    }

    /**
     * Gets the sorting order.
     *
     * @see Order
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the sorting order.
     *
     * @see Order
     * @param order
     *            the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Sets the sorting order.
     * <p>
     * Note: Similar to {@link #setOrder(Order)}
     *
     * @param listOrder
     *            the order to set
     * @param <T>
     *            this type
     * @return this
     */
    @SuppressWarnings("unchecked")
    public <T extends ListOptions> T order(Order listOrder) {
        setOrder(listOrder);
        return (T) this;
    }

    /**
     * Gets after (ID of the the item after which to retrieve the next page).
     *
     * @return the after
     */
    public String getAfter() {
        return after;
    }

    /**
     * Sets after (ID of the the item after which to retrieve the next page).
     *
     * @param after
     *            the after to set
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * Gets include fields.
     *
     * @see IncludeField
     * @return the include fields
     */
    public List<IncludeField> getInclude() {
        return include;
    }

    /**
     * Gets a string comprising all include fields in Snake case.
     *
     * @return string
     */
    public @Nullable String encodeInclude() {
        if (include == null || include.isEmpty()) {
            return null;
        }
        boolean start = true;
        final StringBuilder builder = new StringBuilder();
        for (final IncludeField includeField : include) {
            if (!start) {
                builder.append(',');
            }
            builder.append(includeField.encode());
            start = false;
        }
        return builder.toString();
    }

    /**
     * Appends an include field.
     *
     * @param includeField
     *            include field to append.
     */
    public void addInclude(IncludeField includeField) {
        if (includeField == null) {
            return;
        }
        if (containsIncludeField(includeField)) {
            return;
        }
        if (include == null) {
            setInclude(new LinkedList<IncludeField>());
        }
        include.add(includeField);
    }

    /**
     * Sets include fields.
     *
     * @see IncludeField
     * @param include
     *            the include to set
     */
    public void setInclude(List<IncludeField> include) {
        this.include = include;
    }

    /**
     * Determines whether an include field has already been set.
     *
     * @param field
     *            include field.
     * @return True if the field is already present. False otherwise.
     */
    public boolean containsIncludeField(IncludeField field) {
        if (include == null || field == null) {
            return false;
        }
        return include.contains(field);
    }

    /**
     * Determines whether 'total count' include field has already been set.
     *
     * @return True if the 'total count' field is already present. False otherwise.
     */
    public boolean constainsTotalCountInclude() {
        return containsIncludeField(IncludeField.TOTAL_COUNT);
    }

    /**
     * Includes 'total count' field so that the total number of records appears in the response.
     */
    public void includeTotalCount() {
        addInclude(IncludeField.TOTAL_COUNT);
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
     * @return encoded filter
     */
    public @Nullable <T> T encodeSingleEqualFilter(@Nullable String fieldName, Class<T> type) {
        final Object filterObj = fetchEqualFilterValue(fieldName);
        return encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing an "equal" filter.
     *
     * @param fieldName
     *            filter key
     * @return encoded string filter
     */
    public @Nullable String encodeSingleEqualFilter(@Nullable String fieldName) {
        return encodeSingleEqualFilter(fieldName, String.class);
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
     * @return encoded filter
     */
    public @Nullable <T> T encodeSingleNotEqualFilter(@Nullable String fieldName, Class<T> type) {
        final Object filterObj = fetchNotEqualFilterValue(fieldName);
        return encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "not equal" filter.
     * 
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleNotEqualFilter(@Nullable String fieldName) {
        return encodeSingleNotEqualFilter(fieldName, String.class);
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
     * @return encoded filter
     */
    public @Nullable <T> T encodeSingleGreaterThanFilter(@Nullable String fieldName, Class<T> type) {
        final Object filterObj = fetchGreaterThanFilterValue(fieldName);
        return encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "greater than" filter.
     * 
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleGreaterThanFilter(@Nullable String fieldName) {
        return encodeSingleGreaterThanFilter(fieldName, String.class);
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
     * @return encoded filter
     */
    public @Nullable <T> T encodeSingleLessThanFilter(@Nullable String fieldName, Class<T> type) {
        final Object filterObj = fetchLessThanFilterValue(fieldName);
        return encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "less than" filter.
     * 
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleLessThanFilter(@Nullable String fieldName) {
        return encodeSingleLessThanFilter(fieldName, String.class);
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
     * @return encoded filter
     */
    public @Nullable <T> T encodeSingleLikeFilter(@Nullable String fieldName, Class<T> type) {
        final Object filterObj = fetchLikeFilterValue(fieldName);
        return encodeSingleFilter(filterObj, type);
    }

    /**
     * Gets a string describing a "like" filter.
     *
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleLikeFilter(@Nullable String fieldName) {
        return encodeSingleLikeFilter(fieldName, String.class);

    }

    /**
     * Encodes an "In" filter.
     *
     * @param fieldName
     *            filter key
     * @param fieldName
     *            filter key
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @return encoded filter
     */
    public @Nullable <T> T encodeSingleInFilter(@Nullable String fieldName, Class<T> type) {
        final Object filterObj = fetchInFilterValue(fieldName);
        return encodeMultipleFilters(filterObj, type);
    }

    /**
     * Gets a string describing an "In" filter.
     *
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleInFilter(@Nullable String fieldName) {
        return encodeSingleInFilter(fieldName, String.class);
    }

    /**
     * Encodes a "Not In" filter.
     *
     * @param fieldName
     *            filter key
     * @param fieldName
     *            filter key
     * @param type
     *            type of the filter value
     * @param <T>
     *            type type of the filter value
     * @return encoded filter
     */
    public @Nullable <T> T encodeSingleNotInFilter(@Nullable String fieldName, Class<T> type) {
        final Object filterObj = fetchNotInFilterValue(fieldName);
        return encodeMultipleFilters(filterObj, type);
    }

    /**
     * Gets a string describing a "Not In" filter.
     *
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleNotInFilter(@Nullable String fieldName) {
        return encodeSingleNotInFilter(fieldName, String.class);
    }

    @SuppressWarnings({ "unchecked", "PMD.CyclomaticComplexity" })
    private <T> T encodeSingleFilter(final Object filterObj, Class<T> type) {
        if (filterObj == null || type == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) filterObj;
            }
            if (filterObj instanceof Boolean) {
                return (T) ((Boolean) filterObj).toString();
            }
            if (filterObj instanceof SdkEnum) {
                return (T) ((SdkEnum) filterObj).getString();
            }
            if (filterObj instanceof SdkModel) {
                return (T) ((SdkModel) filterObj).getId();
            }
            if (filterObj instanceof Date) {
                return (T) TranslationUtils.toUtcTimestamp((Date) filterObj);
            }
            if (filterObj instanceof Calendar) {
                return (T) TranslationUtils.toUtcTimestamp(TranslationUtils.toDate((Calendar) filterObj));
            }
            if (filterObj instanceof URL) {
                return (T) ((URL) filterObj).toString();
            }
            return (T) filterObj.toString();
        }
        if (DateTime.class.isAssignableFrom(type)) {
            if (filterObj instanceof DateTime) {
                return (T) filterObj;
            }
            if (filterObj instanceof LocalDate) {
                return (T) TranslationUtils.toDateTime(TranslationUtils.toDate((LocalDate) filterObj));
            }
            if (filterObj instanceof String) {
                try {
                    return (T) TranslationUtils.toDateTime(TranslationUtils.convertStringToDate((String) filterObj));
                } catch (@SuppressWarnings("unused") MbedCloudException exception) {
                    // Nothing to do.
                    return null;
                }
            }
            if (filterObj instanceof Date) {
                return (T) TranslationUtils.toDateTime((Date) filterObj);
            }
            if (filterObj instanceof Number) {
                return (T) TranslationUtils.toDateTime(TranslationUtils.toDate((Number) filterObj));
            }
            return null;
        }
        if (LocalDate.class.isAssignableFrom(type)) {
            if (filterObj instanceof LocalDate) {
                return (T) filterObj;
            }
            if (filterObj instanceof DateTime) {
                return (T) TranslationUtils.toLocalDate(TranslationUtils.toDate((DateTime) filterObj));
            }
            if (filterObj instanceof String) {
                try {
                    return (T) TranslationUtils.toLocalDate(TranslationUtils.convertStringToDate((String) filterObj));
                } catch (@SuppressWarnings("unused") MbedCloudException exception) {
                    // Nothing to do.
                    return null;
                }
            }
            if (filterObj instanceof Date) {
                return (T) TranslationUtils.toLocalDate((Date) filterObj);
            }
            if (filterObj instanceof Number) {
                return (T) TranslationUtils.toLocalDate(TranslationUtils.toDate((Number) filterObj));
            }
            return null;
        }
        if (Boolean.class.isAssignableFrom(type) || boolean.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) new Boolean(TranslationUtils.toBool((String) filterObj));
            }
            if (filterObj instanceof Boolean) {
                return (T) filterObj;
            }
            return null;
        }
        if (Integer.class.isAssignableFrom(type) || int.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) new Integer(TranslationUtils.toInt((String) filterObj));
            }
            if (filterObj instanceof Number) {
                return (T) new Integer(TranslationUtils.toInt((Number) filterObj));
            }
            return null;
        }
        if (Long.class.isAssignableFrom(type) || long.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) new Long(TranslationUtils.toLong((String) filterObj));
            }
            if (filterObj instanceof Number) {
                return (T) new Long(TranslationUtils.toLong((Number) filterObj));
            }
            if (filterObj instanceof Date) {
                return (T) new Long(TranslationUtils.toLong((Date) filterObj));
            }
            return null;
        }
        if (Double.class.isAssignableFrom(type) || double.class.isAssignableFrom(type)) {
            if (filterObj instanceof String) {
                return (T) new Double(TranslationUtils.toDouble((String) filterObj));
            }
            if (filterObj instanceof Number) {
                return (T) new Double(TranslationUtils.toDouble((Number) filterObj));
            }
        }

        return null;
    }

    @SuppressWarnings("rawtypes")
    private <T> T encodeMultipleFilters(final Object filterObj, Class<T> type) {
        if (filterObj == null) {
            return null;
        }
        if (filterObj instanceof List) {
            return encodeList((List) filterObj, type);
        }
        if (filterObj.getClass().isArray()) {
            return encodeArray(filterObj, type);
        }
        return encodeSingleFilter(filterObj, type);
    }

    private <T> T encodeArray(Object filterObj, Class<T> type) {
        if (filterObj instanceof String[]) {
            return encodeList(Arrays.asList((String[]) filterObj), type);
        }
        if (filterObj instanceof Object[]) {
            return encodeList(Arrays.asList(((Object[]) filterObj)), type);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private <T> T encodeList(List<?> filterObj, Class<T> type) {
        if (String.class.isAssignableFrom(type)) {
            return (T) SdkUtils.joinList(filterObj, ",");
        }
        if (List.class.isAssignableFrom(type)) {
            if (filterObj.getClass().isArray()) {
                return (T) Arrays.asList(filterObj);
            }
            return (T) filterObj;
        }
        if (type.isArray()) {
            return (T) filterObj.toArray();
        }
        return null;
    }

    /**
     * Overrides option parameters.
     *
     * @param options
     *            parameters to set.
     * @param <T>
     *            type of options
     */
    protected <T extends ListOptions> void setOptions(T options) {
        final ListOptions overridingOptions = (options == null) ? new ListOptions() : options;
        setAfter(overridingOptions.getAfter());
        setFilters(overridingOptions.getFilter());
        setInclude(overridingOptions.getInclude());
        setPageSize(overridingOptions.getPageSize());
        setMaxResults(overridingOptions.getMaxResults());
        setOrder(overridingOptions.getOrder());
    }

    /**
     * Sets options to default.
     */
    protected void setDefault() {
        setAfter(null);
        setFilters(null);
        setInclude(null);
        setPageSize(null);
        setMaxResults(null);
        setOrder(Order.ASC);
    }

    /**
     * Clones the options.
     *
     * @return a clone.
     */
    @Override
    public ListOptions clone() {
        return new ListOptions(pageSize, maxResults, order, after, (include == null) ? null : new LinkedList<>(include),
                               (filter == null) ? null : filter.clone());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((after == null) ? 0 : after.hashCode());
        result = prime * result + ((include == null) ? 0 : include.hashCode());
        result = prime * result + ((maxResults == null) ? 0 : maxResults.hashCode());
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof ListOptions)) {
            return false;
        }
        final ListOptions other = (ListOptions) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (after == null) {
            if (other.after != null) {
                return false;
            }
        } else if (!after.equals(other.after)) {
            return false;
        }
        if (include == null) {
            if (other.include != null) {
                return false;
            }
        } else if (!include.equals(other.include)) {
            return false;
        }
        if (maxResults == null) {
            if (other.maxResults != null) {
                return false;
            }
        } else if (!maxResults.equals(other.maxResults)) {
            return false;
        }
        if (order != other.order) {
            return false;
        }
        if (pageSize == null) {
            if (other.pageSize != null) {
                return false;
            }
        } else if (!pageSize.equals(other.pageSize)) {
            return false;
        }
        return true;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     *
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise
     */
    @Override
    protected boolean canEqual(Object other) {
        return other instanceof ListOptions;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ListOptions [pageSize=" + pageSize + ", maxResults=" + maxResults + ", order=" + order + ", after="
               + after + ", include=" + encodeInclude() + ", filter=" + retrieveFilterAsJson() + "]";
    }

}
