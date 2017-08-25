package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing certificates")
public class CertificateListOptions extends ListOptions {

    public static final String OWNER_ID_FILTER = "ownerId";
    public static final String EXPIRES_FILTER = "expires";
    public static final String TYPE_FILTER = "type";

    public CertificateListOptions() {
        super();
    }

    /**
     * @return the Owner Id Filter
     */
    public @Nullable Object getOwnerIdFilter() {
        return fetchEqualFilterValue(OWNER_ID_FILTER);
    }

    /**
     * @return the Type Filter
     */
    public @Nullable Object getTypeFilter() {
        return fetchEqualFilterValue(TYPE_FILTER);
    }

    /**
     * @return the Expires Filter
     */
    public @Nullable Object getExpiresFilter() {
        return fetchEqualFilterValue(EXPIRES_FILTER);
    }

    /**
     * @param ownerIdFilter
     *            the ownerIdFilter to set
     */
    public void setOwnerIdFilter(String ownerIdFilter) {
        addEqualFilter(OWNER_ID_FILTER, ownerIdFilter);
    }

    /**
     * @param typeFilter
     *            the typeFiler to set
     */
    public void setTypeFilter(CertificateType typeFilter) {
        addEqualFilter(TYPE_FILTER, typeFilter);
    }

    /**
     * @param expiresfilter
     *            the expiresfilter (in days) to set
     */
    @SuppressWarnings("boxing")
    public void setExpiresFilter(int expiresfilter) {
        addEqualFilter(EXPIRES_FILTER, expiresfilter);
    }

    @SuppressWarnings("boxing")
    public Integer getExecutionModeFilter() {
        CertificateType type = (CertificateType) fetchEqualFilterValue(TYPE_FILTER);
        if (type == null) {
            return null;
        }
        return (type == CertificateType.DEVELOPER) ? 1 : 0;
    }

}
