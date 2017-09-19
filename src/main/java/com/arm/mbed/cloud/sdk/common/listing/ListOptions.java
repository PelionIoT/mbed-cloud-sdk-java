package com.arm.mbed.cloud.sdk.common.listing;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.filtering.CustomFilter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

@Preamble(description = "Options to use when listing objects")
public class ListOptions {

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
        setLimit(null);
        setOrder(Order.ASC);
        setAfter(null);
        setInclude(null);
        setFilter(null);
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
     * Adds an include field to consider.
     * 
     * @param includeField
     *            field
     */
    public void addInclude(IncludeField includeField) {
        if (includeField == null) {
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
     * Gets the filter.
     * 
     * @return the filters
     */
    public Filters getFilter() {
        return filter;
    }

    /**
     * Sets the filter.
     * 
     * @param filter
     *            the filters to set
     */
    public void setFilter(Filters filter) {
        this.filter = filter;
    }

    /**
     * Sets the filter from a Json string.
     * 
     * @see FilterMarshaller#fromJson(String) for more information regarding Json accepted format
     * @param jsonString
     *            Json string defining filters
     */
    public void setFiltersFromJson(String jsonString) {
        setFilter(FilterMarshaller.fromJson(jsonString));
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

    protected void addFilter(Filter subfilter) {
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

    protected Object fetchEqualFilterValue(@Nullable String fieldName) {
        if (fieldName == null || filter == null) {
            return null;
        }
        final List<Filter> list = filter.get(fieldName, FilterOperator.EQUAL);
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
        return (filterObj == null) ? null : filterObj.toString();
    }

}
