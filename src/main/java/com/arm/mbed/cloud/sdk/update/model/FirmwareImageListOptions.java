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

    public static final String NAME_FILTER = "name";
    public static final String CREATED_AT_FILTER = "createdAt";
    public static final String UPDATED_AT_FILTER = "updatedAt";
    public static final String CHECKSUM_FILTER = "datafileChecksum";

    public FirmwareImageListOptions() {
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
    public @Nullable List<Filter> getCreatedAtFilters() {
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
     * 
     */
    public void addUpdatedFilter(@Nullable Date updatedAtFilter, FilterOperator operator) {
        addFilter(UPDATED_AT_FILTER, operator, updatedAtFilter);
    }

    /**
     * @return the dataFileChecksum filter
     */
    public @Nullable List<Filter> getDataFileChecksumFilters() {
        return fetchFilters(CHECKSUM_FILTER);
    }

    /**
     * @param dataFileChecksumFilter
     *            the data File Checksum filter to add
     * @param operator
     *            filter operator
     */
    public void addDataFileChecksumFilter(@Nullable String dataFileChecksumFilter, FilterOperator operator) {
        addFilter(CHECKSUM_FILTER, operator, dataFileChecksumFilter);
    }

}
