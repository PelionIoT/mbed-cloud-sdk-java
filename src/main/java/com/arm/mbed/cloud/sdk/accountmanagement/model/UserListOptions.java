package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing users")
public class UserListOptions extends ListOptions {

    public static final String STATUS_FILTER = "status";

    public UserListOptions() {
        super();
    }

    /**
     * @return the status filter
     */
    public @Nullable Object getStatusFilter() {
        return fetchEqualFilterValue(STATUS_FILTER);
    }

    /**
     * @param statusFilter
     *            the statusFilter to set
     */
    public void setStatusFilter(@Nullable Object statusFilter) {
        addEqualFilter(STATUS_FILTER, statusFilter);
    }

}
