package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing users")
public class UserListOptions extends ListOptions {
    /**
     * Tag of filter by status.
     */
    public static final String STATUS_FILTER = "status";

    /**
     * Constructor.
     */
    public UserListOptions() {
        super();
    }

    /**
     * Gets the filter related to the user status.
     * 
     * @return the status filter.
     */
    public @Nullable UserStatus getStatusFilter() {
        return (UserStatus) fetchEqualFilterValue(STATUS_FILTER);
    }

    /**
     * Sets the filter related to the user status.
     * 
     * @param statusFilter
     *            the statusFilter to set.
     */
    public void setStatusFilter(@Nullable UserStatus statusFilter) {
        addEqualFilter(STATUS_FILTER, statusFilter);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public UserListOptions clone() {
        final UserListOptions opt = new UserListOptions();
        opt.setOptions(this);
        return opt;
    }
}
