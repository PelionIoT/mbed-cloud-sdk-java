package com.arm.mbed.cloud.sdk.certificates.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing certificates")
public class CertificateListOptions extends ListOptions {
    /**
     * Tag of filter by owner id.
     */
    public static final String OWNER_ID_FILTER = "ownerId";
    /**
     * Tag of filter by expiry date.
     */
    public static final String EXPIRES_FILTER = "expires";
    /**
     * Tag of filter by type.
     */
    public static final String TYPE_FILTER = "type";

    /**
     * Constructor.
     */
    public CertificateListOptions() {
        super();
    }

    /**
     * Gets the filter related to the certificate owner id.
     * 
     * @return the Owner Id filter
     */
    public @Nullable Object getOwnerIdFilter() {
        return fetchEqualFilterValue(OWNER_ID_FILTER);
    }

    /**
     * Gets the filter related to the certificate type.
     * 
     * @return the type filter
     */
    public @Nullable Object getTypeFilter() {
        return fetchEqualFilterValue(TYPE_FILTER);
    }

    /**
     * Gets the filter related to the certificate expiry date.
     * 
     * @return the expiry date filter
     */
    public @Nullable Object getExpiresFilter() {
        return fetchEqualFilterValue(EXPIRES_FILTER);
    }

    /**
     * Sets the filter related to the certificate owner id.
     * 
     * @param ownerIdFilter
     *            the ownerIdFilter to set
     */
    public void setOwnerIdFilter(String ownerIdFilter) {
        addEqualFilter(OWNER_ID_FILTER, ownerIdFilter);
    }

    /**
     * Sets the filter related to the certificate type.
     * 
     * @param typeFilter
     *            the typeFiler to set
     */
    public void setTypeFilter(CertificateType typeFilter) {
        addEqualFilter(TYPE_FILTER, typeFilter);
    }

    /**
     * Sets the filter related to the certificate expiry date.
     * 
     * @param expiresfilter
     *            the expiresfilter (in days) to set
     */
    @SuppressWarnings("boxing")
    public void setExpiresFilter(int expiresfilter) {
        addEqualFilter(EXPIRES_FILTER, expiresfilter);
    }

    /**
     * Gets the filter related to execution mode.
     * 
     * @return execution mode filter.
     */
    @SuppressWarnings("boxing")
    public Integer getExecutionModeFilter() {
        final CertificateType type = (CertificateType) fetchEqualFilterValue(TYPE_FILTER);
        if (type == null) {
            return null;
        }
        return (type == CertificateType.DEVELOPER) ? 1 : 0;
    }

}
