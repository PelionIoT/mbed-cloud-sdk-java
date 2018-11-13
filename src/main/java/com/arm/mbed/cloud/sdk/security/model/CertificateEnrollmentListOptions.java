package com.arm.mbed.cloud.sdk.security.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing certificate enrollments")
public class CertificateEnrollmentListOptions extends ListOptions {
    public static final String DEVICE_ID_FILTER = "deviceId";
    public static final String CERTIFICATE_NAME_FILTER = "certificateName";
    public static final String ENROLL_STATUS_FILTER = "enrollStatus";
    public static final String ENROLL_RESULT_FILTER = "enrollResult";
    public static final String CREATED_AT_FILTER = "createdAt";
    public static final String UPDATED_AT_FILTER = "updatedAt";

    /**
     * Constructor.
     */
    public CertificateEnrollmentListOptions() {
        super();
    }

    /**
     * Gets "equal" filter related to device id.
     * 
     * @return the device equal filter.
     */
    public @Nullable Object getDeviceIdEqualFilter() {
        return fetchEqualFilterValue(DEVICE_ID_FILTER);
    }

    /**
     * Sets "equal" filter related to related to device id.
     * 
     * @param deviceId
     *            the "equal" filter to set
     */
    public void setCertificateReferenceEqualFilter(@Nullable String deviceId) {
        addEqualFilter(DEVICE_ID_FILTER, deviceId);
    }

    /**
     * Gets "equal" filter related to certificate name.
     * 
     * @return the certificate name equal filter.
     */
    public @Nullable Object getCertificateNameEqualFilter() {
        return fetchEqualFilterValue(CERTIFICATE_NAME_FILTER);
    }

    /**
     * Sets "equal" filter related to related to certificate name.
     * 
     * @param certificateName
     *            the "equal" filter to set
     */
    public void setCertificateNameEqualFilter(@Nullable String certificateName) {
        addEqualFilter(CERTIFICATE_NAME_FILTER, certificateName);
    }

    /**
     * Gets "equal" filter related to certificate enrolment status.
     * 
     * @return the certificate enrolment status equal filter.
     */
    public @Nullable Object getCertificateEnrollmentStatusEqualFilter() {
        return fetchEqualFilterValue(ENROLL_STATUS_FILTER);
    }

    /**
     * Sets "equal" filter related to related to certificate enrolment status.
     * 
     * @param certificateEnrollmentStatus
     *            the "equal" filter to set
     */
    public void
           setCertificateEnrollmentStatusEqualFilter(@Nullable CertificateEnrollmentEnrollStatus certificateEnrollmentStatus) {
        addEqualFilter(ENROLL_STATUS_FILTER, certificateEnrollmentStatus);
    }

    /**
     * Gets "not equal" filter related to certificate enrolment status.
     * 
     * @return the certificate enrolment status not_equal filter.
     */
    public @Nullable Object getCertificateEnrollmentStatusNotEqualFilter() {
        return fetchNotEqualFilterValue(ENROLL_STATUS_FILTER);
    }

    /**
     * Sets "not equal" filter related to related to certificate enrolment status.
     * 
     * @param certificateEnrollmentStatus
     *            the "not equal" filter to set
     */
    public void
           setCertificateEnrollmentStatusNotEqualFilter(@Nullable CertificateEnrollmentEnrollStatus certificateEnrollmentStatus) {
        addNotEqualFilter(ENROLL_STATUS_FILTER, certificateEnrollmentStatus);
    }

    /**
     * Gets "equal" filter related to certificate enrolment result.
     * 
     * @return the certificate enrolment result equal filter.
     */
    public @Nullable Object getCertificateEnrollmentResultEqualFilter() {
        return fetchEqualFilterValue(ENROLL_RESULT_FILTER);
    }

    /**
     * Sets "equal" filter related to related to certificate enrolment result.
     * 
     * @param certificateEnrollmentResult
     *            the "equal" filter to set
     */
    public void
           setCertificateEnrollmentResultEqualFilter(@Nullable CertificateEnrollmentEnrollResult certificateEnrollmentResult) {
        addEqualFilter(ENROLL_RESULT_FILTER, certificateEnrollmentResult);
    }

    /**
     * Gets "not equal" filter related to certificate enrolment result.
     * 
     * @return the certificate enrolment result not_equal filter.
     */
    public @Nullable Object getCertificateEnrollmentResultNotEqualFilter() {
        return fetchNotEqualFilterValue(ENROLL_RESULT_FILTER);
    }

    /**
     * Sets "not equal" filter related to related to certificate enrolment result.
     * 
     * @param certificateEnrollmentResult
     *            the "not equal" filter to set
     */
    public void
           setCertificateEnrollmentResultNotEqualFilter(@Nullable CertificateEnrollmentEnrollResult certificateEnrollmentResult) {
        addNotEqualFilter(ENROLL_RESULT_FILTER, certificateEnrollmentResult);
    }

    /**
     * Gets "greater than" filter related to creation date.
     * 
     * @return the creation date greater_than filter.
     */
    public @Nullable Object getCreatedAtGreaterThanFilter() {
        return fetchGreaterThanFilterValue(CREATED_AT_FILTER);
    }

    /**
     * Sets "greater than" filter related to related to creation date.
     * 
     * @param creationDate
     *            the "greater than" filter to set
     */
    public void setCreatedAtGreaterThanFilter(@Nullable Date creationDate) {
        addGreaterThanFilter(CREATED_AT_FILTER, creationDate);
    }

    /**
     * Gets "less than" filter related to creation date.
     * 
     * @return the creation date less_than filter.
     */
    public @Nullable Object getCreatedAtLessThanFilter() {
        return fetchLessThanFilterValue(CREATED_AT_FILTER);
    }

    /**
     * Sets "less than" filter related to related to creation date.
     * 
     * @param creationDate
     *            the "greater than" filter to set
     */
    public void setCreatedAtLessThanFilter(@Nullable Date creationDate) {
        addLessThanFilter(CREATED_AT_FILTER, creationDate);
    }

    /**
     * Gets "greater than" filter related to update date.
     * 
     * @return the update date greater_than filter.
     */
    public @Nullable Object getUpdatedAtGreaterThanFilter() {
        return fetchGreaterThanFilterValue(UPDATED_AT_FILTER);
    }

    /**
     * Sets "greater than" filter related to related to update date.
     * 
     * @param updateDate
     *            the "greater than" filter to set
     */
    public void setUpdatedAtGreaterThanFilter(@Nullable Date updateDate) {
        addGreaterThanFilter(UPDATED_AT_FILTER, updateDate);
    }

    /**
     * Gets "less than" filter related to update date.
     * 
     * @return the update date less_than filter.
     */
    public @Nullable Object getUpdatedAtLessThanFilter() {
        return fetchLessThanFilterValue(UPDATED_AT_FILTER);
    }

    /**
     * Sets "less than" filter related to related to update date.
     * 
     * @param updateDate
     *            the "less than" filter to set
     */
    public void setUpdatedAtLessThanFilter(@Nullable Date updateDate) {
        addLessThanFilter(UPDATED_AT_FILTER, updateDate);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public CertificateEnrollmentListOptions clone() {
        final CertificateEnrollmentListOptions opt = new CertificateEnrollmentListOptions();
        opt.setOptions(this);
        return opt;
    }

}
