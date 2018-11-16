package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.api.CertificateEnrollmentsApi;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.api.CertificateRenewalApi;
import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersActivationApi;
import com.arm.mbed.cloud.sdk.internal.externalca.api.CertificateIssuersApi;

@Preamble(description = "Endpoint for Security API module")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final CertificateEnrollmentsApi certificateEnrollment;
    private final CertificateRenewalApi certificateRenewal;
    private final CertificateIssuersActivationApi certificateIssuersActivation;
    private final CertificateIssuersApi certificateIssuers;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     */
    public EndPoints(ApiClientWrapper wrapper) {
        super(wrapper);

        certificateEnrollment = wrapper.createService(CertificateEnrollmentsApi.class);
        certificateRenewal = wrapper.createService(CertificateRenewalApi.class);
        certificateIssuersActivation = wrapper.createService(CertificateIssuersActivationApi.class);
        certificateIssuers = wrapper.createService(CertificateIssuersApi.class);
    }

    /**
     * Constructor.
     * 
     * @param options
     *            connection options {@link ConnectionOptions}.
     */
    public EndPoints(ConnectionOptions options) {
        this(new ApiClientWrapper(options));

    }

    public CertificateEnrollmentsApi getCertificateEnrollment() {
        return certificateEnrollment;
    }

    public CertificateRenewalApi getCertificateRenewal() {
        return certificateRenewal;
    }

    public CertificateIssuersActivationApi getCertificateIssuersActivation() {
        return certificateIssuersActivation;
    }

    public CertificateIssuersApi getCertificateIssuers() {
        return certificateIssuers;
    }

}
