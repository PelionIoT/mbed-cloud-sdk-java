package com.arm.mbed.cloud.sdk.common.listing;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

@Preamble(description = "Options to use when listing objects")
public class ListOptions {

    /**
     * how many objects to retrieve in the page
     */
    @DefaultValue(value = "default")
    private Integer limit;
    /**
     * ASC or DESC
     */
    @DefaultValue(value = "ASC")
    private Order order;
    /**
     * the ID of the the item after which to retrieve the next page
     */
    private String after;
    /**
     * Optional fields to include
     */
    private List<IncludeField> include;

    /**
     * Optional filters
     */
    private Filters filter;

    public ListOptions() {
        super();
        setLimit(null);
        setOrder(Order.ASC);
        setAfter(null);
        setInclude(null);
        setFilter(null);
    }

    /**
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit
     *            the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order
     *            the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @return the after
     */
    public String getAfter() {
        return after;
    }

    /**
     * @param after
     *            the after to set
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * @return the include
     */
    public List<IncludeField> getInclude() {
        return include;
    }

    /**
     * Gets a string comprising all include fields in Snake case
     * 
     * @return string
     */
    public @Nullable String encodeInclude() {
        if (include == null || include.isEmpty()) {
            return null;
        }
        boolean start = true;
        StringBuilder builder = new StringBuilder();
        for (IncludeField includeField : include) {
            if (!start) {
                builder.append(",");
            }
            builder.append(includeField.encode());
            start = false;
        }
        return builder.toString();
    }

    /**
     * @param include
     *            the include to set
     */
    public void setInclude(List<IncludeField> include) {
        this.include = include;
    }

    /**
     * @return the filters
     */
    public Filters getFilter() {
        return filter;
    }

    /**
     * @param filter
     *            the filters to set
     */
    public void setFilter(Filters filter) {
        this.filter = filter;
    }

    /**
     * @param jsonString
     *            Json string defining filters
     */
    public void setFiltersFromJson(String jsonString) {
        setFilter(FilterMarshaller.fromJson(jsonString));
    }

    /**
     * Adds a filter to the query
     * 
     * @param fieldName
     *            field name to apply the filter on
     * @param operator
     *            the filter operator to apply
     * @param value
     *            the value of the filter
     */
    public void addFilter(@Nullable String fieldName, FilterOperator operator, @Nullable Object value) {
        if (value == null || fieldName == null) {
            return;
        }
        if (filter == null) {
            filter = new Filters();
        }
        Filter subfilter = new Filter(fieldName, operator, value);
        filter.add(subfilter);
    }

    /**
     * Adds an "equal" filter
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
        List<Filter> list = filter.get(fieldName, FilterOperator.EQUAL);
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
     * Gets a string describing an "equal" filter
     *
     * @param fieldName
     *            filter key
     * @return string encoded filter
     */
    public @Nullable String encodeSingleEqualFilter(@Nullable String fieldName) {
        Object filterObj = fetchEqualFilterValue(fieldName);
        return (filterObj == null) ? null : filterObj.toString();
    }

}
