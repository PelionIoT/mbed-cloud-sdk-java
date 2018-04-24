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

    protected Object fetchSpecificFilterValue(String fieldName, FilterOperator operator) {
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FilterOptions other = (FilterOptions) obj;
        if (filter == null) {
            if (other.filter != null) {
                return false;
            }
        } else if (!filter.equals(other.filter)) {
            return false;
        }
        return true;
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

}
