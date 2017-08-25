package com.arm.mbed.cloud.sdk.update.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

@Preamble(description = "Options to use when listing firmware manifest")
public class FirmwareManifestListOptions extends ListOptions {
    private static final String TIMESTAMP_FILTER = "timestamp";
    private static final String DEVICE_CLASS_FILTER = "deviceClass";
    public static final String CREATED_AT_FILTER = "createdAt";
    public static final String UPDATED_AT_FILTER = "updatedAt";
    public static final String NAME_FILTER = "name";

    public FirmwareManifestListOptions() {
        super();
    }

    /**
     * @return the name filter
     */
    public @Nullable List<Filter> getNameFilters() {
        return fetchFilters(NAME_FILTER);
    }

    /**
     * @param nameFilter
     *            the name filter to add
     * @param operator
     *            filter operator
     */
    public void addNameFilter(@Nullable String nameFilter, FilterOperator operator) {
        addFilter(NAME_FILTER, operator, nameFilter);
    }

    /**
     * @return the createdAt filter
     */
    public @Nullable List<Filter> getCreatedAtFilter() {
        return fetchFilters(CREATED_AT_FILTER);
    }

    /**
     * @param createdAtFilter
     *            the createdAt filter to add
     * @param operator
     *            filter operator
     */
    public void addCreatedAtFilter(@Nullable Date createdAtFilter, FilterOperator operator) {
        addFilter(CREATED_AT_FILTER, operator, createdAtFilter);
    }

    /**
     * @return the updatedAt filter
     */
    public @Nullable List<Filter> getUpdatedAtFilters() {
        return fetchFilters(UPDATED_AT_FILTER);
    }

    /**
     * @param updatedAtFilter
     *            the updatedAt filter to add
     * @param operator
     *            filter operator
     */
    public void addUpdatedFilter(@Nullable Date updatedAtFilter, FilterOperator operator) {
        addFilter(UPDATED_AT_FILTER, operator, updatedAtFilter);
    }

    /**
     * @return the timestamp filter
     */
    public @Nullable List<Filter> getTimestampFilters() {
        return fetchFilters(TIMESTAMP_FILTER);
    }

    /**
     * @param timestamp
     *            the timestamp filter to add
     * @param operator
     *            filter operator
     */
    public void addTimestampFilter(@Nullable Date timestamp, FilterOperator operator) {
        addFilter(TIMESTAMP_FILTER, operator, timestamp);
    }

    /**
     * @return the device class filter
     */
    public @Nullable List<Filter> getDeviceClassFilter() {
        return fetchFilters(DEVICE_CLASS_FILTER);
    }

    /**
     * @param deviceClassFilter
     *            the device class filter to add
     * @param operator
     *            filter operator
     */
    public void addDeviceClassFilter(@Nullable String deviceClassFilter, FilterOperator operator) {
        addFilter(DEVICE_CLASS_FILTER, operator, deviceClassFilter);
    }
}
