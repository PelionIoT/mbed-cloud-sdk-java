package com.arm.mbed.cloud.sdk.security.model;

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
