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
    /**
     * Tag of filter by timestamp.
     */
    private static final String TIMESTAMP_FILTER = "timestamp";
    /**
     * Tag of filter by device class.
     */
    private static final String DEVICE_CLASS_FILTER = "deviceClass";
    /**
     * Tag of filter by creation date.
     */
    public static final String CREATED_AT_FILTER = "createdAt";
    /**
     * Tag of filter by last update date.
     */
    public static final String UPDATED_AT_FILTER = "updatedAt";
    /**
     * Tag of filter by name.
     */
    public static final String NAME_FILTER = "name";

    /**
     * Constructor.
     */
    public FirmwareManifestListOptions() {
        super();
    }

    /**
     * Gets device filter based on name field.
     * 
     * @return the name filter
     */
    public @Nullable List<Filter> getNameFilters() {
        return fetchFilters(NAME_FILTER);
    }

    /**
     * Adds a device filter based on name field.
     * 
     * @param nameFilter
     *            the name filter to add
     * @param operator
     *            filter operator
     */
    public void addNameFilter(@Nullable String nameFilter, FilterOperator operator) {
        addFilter(NAME_FILTER, operator, nameFilter);
    }

    /**
     * Gets device filter based on createdAt field.
     * 
     * @return the createdAt filter
     */
    public @Nullable List<Filter> getCreatedAtFilter() {
        return fetchFilters(CREATED_AT_FILTER);
    }

    /**
     * Adds a device filter based on createdAt field.
     * 
     * @param createdAtFilter
     *            the createdAt filter to add
     * @param operator
     *            filter operator
     */
    public void addCreatedAtFilter(@Nullable Date createdAtFilter, FilterOperator operator) {
        addFilter(CREATED_AT_FILTER, operator, createdAtFilter);
    }

    /**
     * Gets device filter based on updatedAt field.
     * 
     * @return the updatedAt filter
     */
    public @Nullable List<Filter> getUpdatedAtFilters() {
        return fetchFilters(UPDATED_AT_FILTER);
    }

    /**
     * Adds a device filter based on updatedAt field.
     * 
     * @param updatedAtFilter
     *            the updatedAt filter to add
     * @param operator
     *            filter operator
     */
    public void addUpdatedFilter(@Nullable Date updatedAtFilter, FilterOperator operator) {
        addFilter(UPDATED_AT_FILTER, operator, updatedAtFilter);
    }

    /**
     * Gets device filter based on timestamp field.
     * 
     * @return the timestamp filter
     */
    public @Nullable List<Filter> getTimestampFilters() {
        return fetchFilters(TIMESTAMP_FILTER);
    }

    /**
     * Adds a device filter based on timestamp field.
     * 
     * @param timestamp
     *            the timestamp filter to add
     * @param operator
     *            filter operator
     */
    public void addTimestampFilter(@Nullable Date timestamp, FilterOperator operator) {
        addFilter(TIMESTAMP_FILTER, operator, timestamp);
    }

    /**
     * Gets device filter based on device class field.
     * 
     * @return the device class filter
     */
    public @Nullable List<Filter> getDeviceClassFilter() {
        return fetchFilters(DEVICE_CLASS_FILTER);
    }

    /**
     * Adds a device filter based on device class field.
     *
     * @param deviceClassFilter
     *            the device class filter to add
     * @param operator
     *            filter operator
     */
    public void addDeviceClassFilter(@Nullable String deviceClassFilter, FilterOperator operator) {
        addFilter(DEVICE_CLASS_FILTER, operator, deviceClassFilter);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public FirmwareManifestListOptions clone() {
        final FirmwareManifestListOptions opt = new FirmwareManifestListOptions();
        opt.setOptions(this);
        return opt;
    }
}
