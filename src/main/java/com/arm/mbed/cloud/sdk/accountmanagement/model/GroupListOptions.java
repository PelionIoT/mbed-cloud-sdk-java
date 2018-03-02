package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing groups")
public class GroupListOptions extends ListOptions {

    /**
     * Tag of filter by name.
     */
    public static final String NAME_FILTER = "name";

    /**
     * Constructor.
     */
    public GroupListOptions() {
        super();
    }

    /**
     * Gets filter related to name.
     * 
     * @return the nameFilter.
     */
    public @Nullable String getNameFilter() {
        final Object value = fetchEqualFilterValue(NAME_FILTER);
        return (value == null) ? null : value.toString();
    }

    /**
     * Sets filter related to name.
     * 
     * @param nameFilter
     *            the nameFilter to set
     */
    public void setOwnerIdFilter(@Nullable String nameFilter) {
        addEqualFilter(NAME_FILTER, nameFilter);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public GroupListOptions clone() {
        final GroupListOptions opt = new GroupListOptions();
        opt.setOptions(this);
        return opt;
    }

}
