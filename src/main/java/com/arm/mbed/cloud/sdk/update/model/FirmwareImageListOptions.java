package com.arm.mbed.cloud.sdk.update.model;

import java.util.Date;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

@Preamble(description = "Options to use when listing firmware images")
public class FirmwareImageListOptions extends ListOptions {
    /**
     * Tag of filter by name.
     */
    public static final String NAME_FILTER = "name";
    /**
     * Tag of filter by creation date.
     */
    public static final String CREATED_AT_FILTER = "createdAt";
    /**
     * Tag of filter by last update date.
     */
    public static final String UPDATED_AT_FILTER = "updatedAt";
    /**
     * Tag of filter by file checksum.
     */
    public static final String CHECKSUM_FILTER = "datafileChecksum";

    /**
     * Constructor.
     */
    public FirmwareImageListOptions() {
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
    public @Nullable List<Filter> getCreatedAtFilters() {
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
     * 
     */
    public void addUpdatedFilter(@Nullable Date updatedAtFilter, FilterOperator operator) {
        addFilter(UPDATED_AT_FILTER, operator, updatedAtFilter);
    }

    /**
     * Gets device filter based on file checksum field.
     * 
     * @return the dataFileChecksum filter
     */
    public @Nullable List<Filter> getDataFileChecksumFilters() {
        return fetchFilters(CHECKSUM_FILTER);
    }

    /**
     * Adds a device filter based on file checksum field.
     * 
     * @param dataFileChecksumFilter
     *            the data File Checksum filter to add
     * @param operator
     *            filter operator
     */
    public void addDataFileChecksumFilter(@Nullable String dataFileChecksumFilter, FilterOperator operator) {
        addFilter(CHECKSUM_FILTER, operator, dataFileChecksumFilter);
    }

}
