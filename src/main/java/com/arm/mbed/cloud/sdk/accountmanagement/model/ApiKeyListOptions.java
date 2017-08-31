package com.arm.mbed.cloud.sdk.accountmanagement.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing api keys")
public class ApiKeyListOptions extends ListOptions {

    public static final String OWNER_ID_FILTER = "ownerId";

    public ApiKeyListOptions() {
        super();
    }

    /**
     * @return the ownerIdFilter
     */
    public @Nullable Object getOwnerIdFilter() {
        return fetchEqualFilterValue(OWNER_ID_FILTER);
    }

    /**
     * @param ownerIdFilter
     *            the ownerIdFilter to set
     */
    public void setOwnerIdFilter(@Nullable String ownerIdFilter) {
        addEqualFilter(OWNER_ID_FILTER, ownerIdFilter);
    }

}