package com.arm.mbed.cloud.sdk.common.listing;

import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.SdkUtils;
import com.arm.mbed.cloud.sdk.common.listing.filtering.CustomFilter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

@Preamble(description = "Options to use when filtering objects")
public class FilterOptions implements Cloneable {

    public static final String METHOD_FILTER_TO_STRING = "retrieveFilterAsJson";
    public static final String METHOD_FILTER_ADD_EQUAL = "addEqualFilter";
    public static final String METHOD_FILTER_ADD_NOT_EQUAL = "addNotEqualFilter";
    public static final String METHOD_FILTER_ADD_GREATER_THAN = "addGreaterThanFilter";
    public static final String METHOD_FILTER_ADD_LESS_THAN = "addLessThanFilter";
    public static final String METHOD_FILTER_ADD_IN = "addInFilter";
    public static final String METHOD_FILTER_ADD_NOT_IN = "addNotInFilter";
    public static final String METHOD_FILTER_ADD_LIKE = "addLikeFilter";
    public static final String METHOD_FILTER_FETCH = "fetchFilters";
    /**
     * Optional filters.
     */
    protected Filters filter;

    public FilterOptions() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param filter
     *            to set
     */
    @Internal
    protected FilterOptions(@Nullable Filters filter) {
        super();
        this.filter = filter;
    }

    /**
     * Gets the filter.
     *
     * @return the filters
     */
    public Filters getFilter() {
        return filter;
    }

    /**
     * Sets the filters.
     *
     * @param filters
     *            the filters to set
     */
    public void setFilters(Filters filters) {
        this.filter = filters;
    }

    /**
     * Sets the filters.
     * <p>
     * Prefer using {@link #setFilters(Filters)} or {@link #setFiltersFromJson(String)} to set filters.
     *
     * @param filter
     *            filters expressed as a Json hashtable (key,value)
     */
    @Internal
    public void setFilter(Map<String, Object> filter) {
        setFilters(FilterMarshaller.fromJsonObject(filter));
    }

    /**
     * Sets the filter from a Json string.
     *
     * @see FilterMarshaller#fromJson(String) for more information regarding Json accepted format
     * @param jsonString
     *            Json string defining filters
     */
    public void setFiltersFromJson(String jsonString) {
        setFilters(FilterMarshaller.fromJson(jsonString));
    }

    /**
     * Gets the filter as Json String.
     *
     * @see FilterMarshaller#toJson(Filters) for more information regarding Json filter format
     * @return the filter as a Json string
     */
    public String retrieveFilterAsJson() {
        return FilterMarshaller.toJson(getFilter());
    }

    /**
     * Adds a filter to the query.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param operator
     *            the filter operator to apply
     * @param value
     *            the value of the filter
     */
    public void addFilter(@Nullable String fieldName, FilterOperator operator, @Nullable Object value) {
        addFilter(new Filter(fieldName, operator, value));
    }

    /**
     * Adds a filter to the query.
     *
     * @param subfilter
     *            filter to apply.
     */
    public void addFilter(Filter subfilter) {
        if (subfilter == null || !subfilter.isValid()) {
            return;
        }
        if (filter == null) {
            filter = new Filters();
        }
        filter.add(subfilter);
    }

    /**
     * Adds a custom filter to the query.
     *
     * @param customAttribute
     *            custom attribute to apply the filter on
     * @param operator
     *            the filter operator to apply
     * @param value
     *            the value of the filter
     */
    public void addCustomFilter(@Nullable String customAttribute, FilterOperator operator, @Nullable Object value) {
        addFilter(new CustomFilter(customAttribute, operator, value));
    }

    /**
     * Determines whether a filter has been set or not.
     *
     * @param fieldName
     *            field the filter applies to
     * @param operator
     *            filter operator to consider
     * @return True if there is a filter defined. False otherwise.
     */
    public boolean hasFilter(String fieldName, FilterOperator operator) {
        return fetchSpecificFilterValue(fieldName, operator) != null;
    }

    /**
     * Determines whether filters have been set or not.
     *
     * @return True if there is a filter defined. False otherwise.
     */
    public boolean hasFilters() {
        return filter != null && !filter.isEmpty();
    }

    /**
     * Determines whether filters have been set or not.
     *
     * @param fieldName
     *            field the filter applies to
     * @return True if there is a filter defined. False otherwise.
     */
    public boolean hasFilters(String fieldName) {
        final List<Filter> filterList = fetchFilters(fieldName);
        return filterList != null && !filterList.isEmpty();
    }

    /**
     * Fetches a specific filter value.
     *
     * @param fieldName
     *            field the filter applies to
     * @param operator
     *            filter operator to consider
     * @return the corresponding filter value
     */
    public Object fetchSpecificFilterValue(String fieldName, FilterOperator operator) {
        if (fieldName == null || filter == null) {
            return null;
        }
        final List<Filter> list = filter.get(fieldName, operator);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0).getValue();
    }

    protected List<Filter> fetchFilters(@Nullable String fieldName) {
        if (fieldName == null || filter == null) {
            return null;
        }
        return filter.get(fieldName);
    }

    /**
     * Clones the options.
     *
     * @return a clone.
     */
    @Override
    public FilterOptions clone() {
        return new FilterOptions((filter == null) ? null : filter.clone());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FilterOptions [filter=" + retrieveFilterAsJson() + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filter == null) ? 0 : filter.hashCode());
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
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FilterOptions)) {
            return false;
        }
        final FilterOptions other = (FilterOptions) obj;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!equalsFilter(other)) {
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
    protected boolean canEqual(Object other) {
        return other instanceof FilterOptions;
    }

    /**
     * Checks whether two option objects have equal filters.
     *
     * @param other
     *            an option object
     * @param <T>
     *            filter option type
     * @return true if the filters are equal; false otherwise.
     */
    public <T extends FilterOptions> boolean equalsFilter(T other) {
        if (other == null) {
            return false;
        }
        return filter == null ? other.filter == null : filter.equals(other.filter);
    }

    /**
     * Adds a "like" filter.
     * <p>
     * Note:
     * <p>
     * - if the value is not a String or a list/array, then the "like" filter behaves like the "equal" filter. Similar
     * to {@link #addEqualFilter(String, Object)}
     * <p>
     * - if the value is a String, it can be either a substring, a Java Regex or an
     * <a href="https://www.w3schools.com/sql/sql_like.asp">SQL like entry</a>
     * <p>
     * - if the value is a list/array, the filter checks if any element of the list is verified (equivalent of an OR of
     * LIKE filters).
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param value
     *            the value of the filter
     *
     */
    public void addLikeFilter(@Nullable String fieldName, @Nullable Object value) {
        addFilter(fieldName, FilterOperator.LIKE, value);
    }

    /**
     * Adds a "not equal" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param value
     *            the value of the filter
     */
    public void addNotEqualFilter(@Nullable String fieldName, @Nullable Object value) {
        addFilter(fieldName, FilterOperator.NOT_EQUAL, value);
    }

    /**
     * Adds a "greater than" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param value
     *            the value of the filter
     */
    public void addGreaterThanFilter(@Nullable String fieldName, @Nullable Object value) {
        addFilter(fieldName, FilterOperator.GREATER_THAN, value);
    }

    /**
     * Adds a "less than" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param value
     *            the value of the filter
     */
    public void addLessThanFilter(@Nullable String fieldName, @Nullable Object value) {
        addFilter(fieldName, FilterOperator.LESS_THAN, value);
    }

    /**
     * Adds an "in" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param values
     *            the list values of the filter
     * @param <T>
     *            type of the filter values
     */
    public <T> void addInFilter(@Nullable String fieldName, @NonNull List<T> values) {
        addFilter(fieldName, FilterOperator.IN, values);
    }

    /**
     * Adds an "in" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param values
     *            the list values of the filter
     * @param <T>
     *            type of the filter values
     */
    public <T> void addInFilter(@Nullable String fieldName, @NonNull T[] values) {
        addFilter(fieldName, FilterOperator.IN, values);
    }

    /**
     * Adds an "in" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param values
     *            a JSON array or a comma-separated list of values for the filter
     */
    public void addInFilter(@Nullable String fieldName, @NonNull String values) {
        addInFilter(fieldName, SdkUtils.parseListString(values));
    }

    /**
     * Adds a "not in" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param values
     *            the list values of the filter
     * @param <T>
     *            type of the filter values
     */
    public <T> void addNotInFilter(@Nullable String fieldName, @NonNull List<T> values) {
        addFilter(fieldName, FilterOperator.NOT_IN, values);
    }

    /**
     * Adds a "not in" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param values
     *            the list values of the filter
     * @param <T>
     *            type of the filter values
     */
    public <T> void addNotInFilter(@Nullable String fieldName, @NonNull T[] values) {
        addFilter(fieldName, FilterOperator.NOT_IN, values);
    }

    /**
     * Adds a "not in" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param values
     *            a JSON array or a comma-separated list of values for the filter
     */
    public void addNotInFilter(@Nullable String fieldName, @NonNull String values) {
        addNotInFilter(fieldName, SdkUtils.parseListString(values));
    }

    /**
     * Adds an "equal" filter.
     *
     * @param fieldName
     *            field name to apply the filter on
     * @param value
     *            the value of the filter
     */
    public void addEqualFilter(@Nullable String fieldName, @Nullable Object value) {
        addFilter(fieldName, FilterOperator.EQUAL, value);
    }

    protected Object fetchEqualFilterValue(@Nullable String fieldName) {
        return fetchSpecificFilterValue(fieldName, FilterOperator.EQUAL);
    }

    protected Object fetchNotEqualFilterValue(@Nullable String fieldName) {
        return fetchSpecificFilterValue(fieldName, FilterOperator.NOT_EQUAL);
    }

    protected Object fetchLikeFilterValue(@Nullable String fieldName) {
        // If no like filter was entered but an equal filter was, equal filter is considered.
        final Object specificLike = fetchSpecificFilterValue(fieldName, FilterOperator.LIKE);
        return (specificLike == null) ? fetchEqualFilterValue(fieldName) : specificLike;
    }

    protected Object fetchInFilterValue(@Nullable String fieldName) {
        return fetchSpecificFilterValue(fieldName, FilterOperator.IN);
    }

    protected Object fetchNotInFilterValue(@Nullable String fieldName) {
        return fetchSpecificFilterValue(fieldName, FilterOperator.NOT_IN);
    }

    protected Object fetchGreaterThanFilterValue(@Nullable String fieldName) {
        return fetchSpecificFilterValue(fieldName, FilterOperator.GREATER_THAN);
    }

    protected Object fetchLessThanFilterValue(@Nullable String fieldName) {
        return fetchSpecificFilterValue(fieldName, FilterOperator.LESS_THAN);
    }
}
