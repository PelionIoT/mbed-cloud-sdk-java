package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

@Preamble(description = "Options to use when listing queries")
public class QueryListOptions extends ListOptions {
    /**
     * Tag of filter by name.
     */
    public static final String FILTER_NAME = "name";
    /**
     * Tag of filter by creation date.
     */
    public static final String FILTER_CREATED_AT = "createdAt";
    /**
     * Tag of filter by last update date.
     */
    public static final String FILTER_UPDATED_AT = "updatedAt";

    public QueryListOptions() {
        super();
    }

    /**
     * Adds a query filter based on last update date.
     * 
     * @param updatedAt
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addUpdatedAtFilter(Date updatedAt, FilterOperator operator) {
        addFilter(FILTER_UPDATED_AT, operator, updatedAt);
    }

    /**
     * Adds a query filter based on creation date.
     * 
     * @param createdAt
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addCreatedAtFilter(Date createdAt, FilterOperator operator) {
        addFilter(FILTER_CREATED_AT, operator, createdAt);
    }

    /**
     * Adds a query filter based on name field.
     * 
     * @param name
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addNameFilter(String name, FilterOperator operator) {
        addFilter(FILTER_NAME, operator, name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public QueryListOptions clone() {
        final QueryListOptions opt = new QueryListOptions();
        opt.setOptions(this);
        return opt;
    }
}
