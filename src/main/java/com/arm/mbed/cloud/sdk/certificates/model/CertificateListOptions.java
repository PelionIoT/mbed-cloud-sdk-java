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
     * Tag of filter by enrolment mode.
     */
    public static final String ENROLLMENT_MODE_FILTER = "enrollment_mode";
    /**
     * Tag of filter by name.
     */
    public static final String NAME_FILTER = "name";
    /**
     * Tag of filter by subject.
     */
    public static final String SUBJECT_FILTER = "subject";
    /**
     * Tag of filter by issuer.
     */
    public static final String ISSUER_FILTER = "issuer";
    /**
     * Tag of filter by status.
     */
    public static final String STATUS_FILTER = "status";
    /**
     * Tag of filter by valid.
     */
    public static final String VALID_FILTER = "valid";

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
     * Gets the filter related to certificate name.
     * 
     * @return the name filter
     */
    public @Nullable Object getNameFilter() {
        return fetchEqualFilterValue(NAME_FILTER);
    }

    /**
     * Gets the filter related to subject.
     * 
     * @return the subject filter
     */
    public @Nullable Object getSubjectFilter() {
        return fetchLikeFilterValue(SUBJECT_FILTER);
    }

    /**
     * Gets the filter related to issuer.
     * 
     * @return the issuer filter
     */
    public @Nullable Object getIssuerFilter() {
        return fetchLikeFilterValue(ISSUER_FILTER);
    }

    /**
     * Gets the filter related to enrolment mode.
     * 
     * @return enrolment mode filter
     */
    public @Nullable Boolean getEnrollmentFilter() {
        final Object value = fetchEqualFilterValue(ENROLLMENT_MODE_FILTER);
        return (value == null) ? null : (Boolean) value;
    }

    /**
     * Gets the filter related to the certificate type.
     * 
     * @return the type filter
     */
    public @Nullable CertificateType getTypeFilter() {
        final Object typeFilterValue = fetchEqualFilterValue(TYPE_FILTER);
        if (typeFilterValue == null) {
            return null;
        }
        if (typeFilterValue instanceof CertificateType) {
            return (CertificateType) typeFilterValue;
        }
        return CertificateType.getType(typeFilterValue.toString());
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
     * Sets the filter related to certificate name.
     * 
     * @param nameFilter
     *            the nameFilter to set
     */
    public void setNameFilter(String nameFilter) {
        addEqualFilter(NAME_FILTER, nameFilter);
    }

    /**
     * Sets the filter related to subject.
     * 
     * @param subjectFilter
     *            the subjectFilter to set
     */
    public void setSubjectFilter(String subjectFilter) {
        addLikeFilter(SUBJECT_FILTER, subjectFilter);
    }

    /**
     * Sets the filter related to issuer.
     * 
     * @param issuerFilter
     *            the issuerFilter to set
     */
    public void setIssuerFilter(String issuerFilter) {
        addLikeFilter(ISSUER_FILTER, issuerFilter);
    }

    /**
     * Sets the filter related to enrolment mode.
     * 
     * @param enrollmentFilter
     *            the enrollmentFilter to set
     */
    public void setEnrollmentFilter(boolean enrollmentFilter) {
        addEqualFilter(ENROLLMENT_MODE_FILTER, Boolean.valueOf(enrollmentFilter));
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
    public void setExpiresFilter(int expiresfilter) {
        addEqualFilter(EXPIRES_FILTER, Integer.valueOf(expiresfilter));
    }

    /**
     * Gets the filter related to execution mode (equal).
     * 
     * @return execution mode filter (equal).
     */
    public Integer getExecutionModeFilter() {
        final CertificateType type = getTypeFilter();
        if (type == null) {
            return null;
        }
        return (type == CertificateType.DEVELOPER) ? Integer.valueOf(1) : null;
    }

    /**
     * Gets the filter related to execution mode (not equal).
     * 
     * @return execution mode filter (not equal).
     */
    public Integer getExecutionModeNotEqualFilter() {
        final CertificateType type = getTypeFilter();
        if (type == null) {
            return null;
        }
        return (type == CertificateType.DEVELOPER) ? null : Integer.valueOf(1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public CertificateListOptions clone() {
        final CertificateListOptions opt = new CertificateListOptions();
        opt.setOptions(this);
        return opt;
    }
}
