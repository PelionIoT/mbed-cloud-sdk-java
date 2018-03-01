package com.arm.mbed.cloud.sdk.common.listing;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.filtering.CustomFilter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

@Preamble(description = "Options to use when listing objects")
public class ListOptions implements Cloneable {

    /**
     * how many objects to retrieve in the page.
     */
    @DefaultValue(value = "default")
    private Integer limit;
    /**
     * Sorting order. ASC or DESC
     */
    @DefaultValue(value = "ASC")
    private Order order;
    /**
     * the ID of the the item after which to retrieve the next page.
     */
    private String after;
    /**
     * Optional fields to include.
     */
    private List<IncludeField> include;

    /**
     * Optional filters.
     */
    private Filters filter;

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
    protected ListOptions(Integer limit, Order order, String after, List<IncludeField> include, Filters filter) {
        super();
        this.limit = limit;
        this.order = order;
        this.after = after;
        this.include = include;
        this.filter = filter;
    }

    /**
     * Gets the limit.
     * 
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     * 
     * @param limit
     *            the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
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

    /**
     * Adds an "like" filter.
     * 
     * @param fieldName
     *            field name to apply the filter on
     * @param value
     *            the value of the filter
     */
    public void addLikeFilter(@Nullable String fieldName, @Nullable Object value) {
        addFilter(fieldName, FilterOperator.LIKE, value);
    }

    protected Object fetchEqualFilterValue(@Nullable String fieldName) {
        return fetchSpecificFilterValue(fieldName, FilterOperator.EQUAL);
    }

    protected Object fetchLikeFilterValue(@Nullable String fieldName) {
        // If no like filter was entered but an equal filter was, equal filter is considered.
        final Object specificLike = fetchSpecificFilterValue(fieldName, FilterOperator.LIKE);
        return (specificLike == null) ? fetchEqualFilterValue(fieldName) : specificLike;
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
     * Gets a string describing an "equal" filter.
     *
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleEqualFilter(@Nullable String fieldName) {
        final Object filterObj = fetchEqualFilterValue(fieldName);
        return encodeSingleFilter(filterObj);
    }

    /**
     * Gets a string describing a "like" filter.
     *
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleLikeFilter(@Nullable String fieldName) {
        final Object filterObj = fetchLikeFilterValue(fieldName);
        return encodeSingleFilter(filterObj);
    }

    private String encodeSingleFilter(final Object filterObj) {
        return (filterObj == null) ? null : filterObj.toString();
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
        setLimit(overridingOptions.getLimit());
        setOrder(overridingOptions.getOrder());
    }

    /**
     * Sets options to default.
     */
    protected void setDefault() {
        setAfter(null);
        setFilters(null);
        setInclude(null);
        setLimit(null);
        setOrder(Order.ASC);
    }

    /**
     * Clones the options.
     * 
     * @return a clone.
     */
    @Override
    public ListOptions clone() {
        return new ListOptions(limit, order, after, (include == null) ? null : new LinkedList<>(include),
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
        int result = 1;
        result = prime * result + ((after == null) ? 0 : after.hashCode());
        result = prime * result + ((filter == null) ? 0 : filter.hashCode());
        result = prime * result + ((include == null) ? 0 : include.hashCode());
        result = prime * result + ((limit == null) ? 0 : limit.hashCode());
        result = prime * result + ((order == null) ? 0 : order.hashCode());
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
        final ListOptions other = (ListOptions) obj;
        if (after == null) {
            if (other.after != null) {
                return false;
            }
        } else if (!after.equals(other.after)) {
            return false;
        }
        if (filter == null) {
            if (other.filter != null) {
                return false;
            }
        } else if (!filter.equals(other.filter)) {
            return false;
        }
        if (include == null) {
            if (other.include != null) {
                return false;
            }
        } else if (!include.equals(other.include)) {
            return false;
        }
        if (limit == null) {
            if (other.limit != null) {
                return false;
            }
        } else if (!limit.equals(other.limit)) {
            return false;
        }
        if (order != other.order) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ListOptions [limit=" + limit + ", order=" + order + ", after=" + after + ", include=" + encodeInclude()
                + ", filter=" + retrieveFilterAsJson() + "]";
    }

}
