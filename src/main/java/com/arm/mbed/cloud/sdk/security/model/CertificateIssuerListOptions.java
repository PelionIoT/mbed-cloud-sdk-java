package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Options to use when listing certificate issuers")
public class CertificateIssuerListOptions extends ListOptions {

    /**
     * Constructor.
     */
    public CertificateIssuerListOptions() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.common.listing.ListOptions#clone()
     */
    @Override
    public CertificateIssuerListOptions clone() {
        final CertificateIssuerListOptions opt = new CertificateIssuerListOptions();
        opt.setOptions(this);
        return opt;
    }
}
