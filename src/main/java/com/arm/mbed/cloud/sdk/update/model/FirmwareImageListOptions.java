package com.arm.mbed.cloud.sdk.update.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ListOptions;

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
    public @Nullable Object getNameFilter() {
        return fetchFilter(NAME_FILTER);
    }

    /**
     * @param nameFilter
     *            the name filter to set
     */
    public void setNameFilter(@Nullable String nameFilter) {
        addFilter(NAME_FILTER, nameFilter);
    }

    /**
     * @return the createdAt filter
     */
    public @Nullable Object getCreatedAtFilter() {
        return fetchFilter(CREATED_AT_FILTER);
    }

    /**
     * @param createdAtFilter
     *            the createdAt filter to set
     */
    public void setCreatedAtFilter(@Nullable Date createdAtFilter) {
        addFilter(CREATED_AT_FILTER, createdAtFilter);
    }

    /**
     * @return the updatedAt filter
     */
    public @Nullable Object getUpdatedAtFilter() {
        return fetchFilter(UPDATED_AT_FILTER);
    }

    /**
     * @param updatedAtFilter
     *            the updatedAt filter to set
     */
    public void setUpdatedFilter(@Nullable Date updatedAtFilter) {
        addFilter(UPDATED_AT_FILTER, updatedAtFilter);
    }

    /**
     * @return the dataFileChecksum filter
     */
    public @Nullable Object getDataFileChecksumFilter() {
        return fetchFilter(CHECKSUM_FILTER);
    }

    /**
     * @param dataFileChecksumFilter
     *            the data File Checksum filter to set
     */
    public void setDataFileChecksumFilter(@Nullable String dataFileChecksumFilter) {
        addFilter(CHECKSUM_FILTER, dataFileChecksumFilter);
    }

}
