package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceStore;
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
     * @param services
     *            created services {@link ServiceStore}.
     */
    public EndPoints(ServiceStore services) {
        super(services);
        certificateEnrollment = initialiseService(CertificateEnrollmentsApi.class);
        certificateRenewal = initialiseService(CertificateRenewalApi.class);
        certificateIssuersActivation = initialiseService(CertificateIssuersActivationApi.class);
        certificateIssuers = initialiseService(CertificateIssuersApi.class);
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

    @Override
    public EndPoints clone() {
        return new EndPoints(getServicesClone());
    }
}
