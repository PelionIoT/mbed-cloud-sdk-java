package com.arm.mbed.cloud.sdk.internal.externalca.api;

import com.arm.mbed.cloud.sdk.internal.externalca.ApiClient;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.ErrorObjectResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CertificateIssuersActivationApi
 */
public class CertificateIssuersActivationApiTest {

    private CertificateIssuersActivationApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CertificateIssuersActivationApi.class);
    }

    /**
     * Get certificate issuer configuration.
     *
     * Provides the configured certificate issuer to be used when creating device certificates for LwM2M communication.&lt;br&gt; 
     */
    @Test
    public void getCertificateIssuerConfigUsingGETTest() {
        String authorization = null;
        // CertificateIssuerConfigResponse response = api.getCertificateIssuerConfigUsingGET(authorization);

        // TODO: test validations
    }
    /**
     * Update certificate issuer configuration.
     *
     * Configure the certificate issuer to be used when creating device certificates for LwM2M communication. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X PUT \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -d &#39;{   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60; 
     */
    @Test
    public void updateCertificateIssuerConfigUsingPUTTest() {
        String authorization = null;
        CertificateIssuerConfigRequest certificateIssuerConfigRequest = null;
        // CertificateIssuerConfigResponse response = api.updateCertificateIssuerConfigUsingPUT(authorization, certificateIssuerConfigRequest);

        // TODO: test validations
    }
}
