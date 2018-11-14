package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing certificate issuer configs")
public class CertificateIssuerConfigListOptions extends ListOptions {
    public static final String CERTIFICATE_REFERENCE_FILTER = "reference";

    /**
     * Constructor.
     */
    public CertificateIssuerConfigListOptions() {
        super();
    }

    /**
     * Gets "equal" filter related to certificate reference.
     * 
     * @return the certificate reference equal filter.
     */
    public @Nullable Object getCertificateReferenceEqualFilter() {
        return fetchEqualFilterValue(CERTIFICATE_REFERENCE_FILTER);
    }

    /**
     * Sets "equal" filter related to certificate reference.
     * 
     * @param certificateReference
     *            the "equal" filter to set
     */
    public void setCertificateReferenceEqualFilter(@Nullable String certificateReference) {
        addEqualFilter(CERTIFICATE_REFERENCE_FILTER, certificateReference);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public CertificateIssuerConfigListOptions clone() {
        final CertificateIssuerConfigListOptions opt = new CertificateIssuerConfigListOptions();
        opt.setOptions(this);
        return opt;
    }
}
