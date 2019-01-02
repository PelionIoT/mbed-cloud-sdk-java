package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CreateCertificateIssuerConfig;
import org.junit.Before;
import org.junit.Test;

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
     * Create certificate issuer configuration.
     *
     * Configure the certificate issuer to be used when creating the device custom certificates. &lt;br&gt; **Example
     * usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H
     * &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -d &#39;{ \&quot;reference\&quot;:
     * \&quot;customer.dlms\&quot;, \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot;
     * }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createCertificateIssuerConfigTest() {
        CreateCertificateIssuerConfig createCertificateIssuerConfig = null;
        // CertificateIssuerConfigResponse response = api.createCertificateIssuerConfig(createCertificateIssuerConfig);

        // TODO: test validations
    }

    /**
     * Delete certificate issuer configuration.
     *
     * Delete the configured certificate issuer configuration. You can only delete the configurations of custom
     * certificates.
     */
    @Test
    public void deleteCertificateIssuerConfigByIDTest() {
        String certificateIssuerConfigurationId = null;
        // Void response = api.deleteCertificateIssuerConfigByID(certificateIssuerConfigurationId);

        // TODO: test validations
    }

    /**
     * Get certificate issuer configuration.
     *
     * Provides the configured certificate issuer to be used when creating device certificates for LwM2M
     * communication.&lt;br&gt;
     */
    @Test
    public void getCertificateIssuerConfigTest() {
        // CertificateIssuerConfigResponse response = api.getCertificateIssuerConfig();

        // TODO: test validations
    }

    /**
     * Get certificate issuer configuration.
     *
     * Provides the configured certificate issuer.
     */
    @Test
    public void getCertificateIssuerConfigByIDTest() {
        String certificateIssuerConfigurationId = null;
        // CertificateIssuerConfigResponse response =
        // api.getCertificateIssuerConfigByID(certificateIssuerConfigurationId);

        // TODO: test validations
    }

    /**
     * Get certificate issuer configurations.
     *
     * Get certificate issuer configurations, optionally filtered by reference. &lt;br&gt; **Example usage:**
     * &#x60;&#x60;&#x60; curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ &#x60;&#x60;&#x60; &#x60;&#x60;&#x60;
     * curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations?reference__eq&#x3D;dlms \\
     * &#x60;&#x60;&#x60; Note: This endpoint does not implement pagination and therefore, list control parameters such
     * as &#x60;limit&#x60; or &#x60;after&#x60; will be ignored by the system.
     */
    @Test
    public void getCertificateIssuerConfigsTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String referenceEq = null;
        // CertificateIssuerConfigListResponse response = api.getCertificateIssuerConfigs(limit, order, after, include,
        // referenceEq);

        // TODO: test validations
    }

    /**
     * Update certificate issuer configuration.
     *
     * Configure the certificate issuer to be used when creating device certificates for LwM2M communication. &lt;br&gt;
     * **Example usage:** &#x60;&#x60;&#x60; curl -X PUT \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H
     * &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -d &#39;{
     * \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateCertificateIssuerConfigTest() {
        CertificateIssuerConfigRequest certificateIssuerConfigRequest = null;
        // CertificateIssuerConfigResponse response = api.updateCertificateIssuerConfig(certificateIssuerConfigRequest);

        // TODO: test validations
    }

    /**
     * Update certificate issuer configuration.
     *
     * Update the configured certificate issuer configuration.
     */
    @Test
    public void updateCertificateIssuerConfigByIDTest() {
        CertificateIssuerConfigRequest certificateIssuerConfigRequest = null;
        String certificateIssuerConfigurationId = null;
        // CertificateIssuerConfigResponse response =
        // api.updateCertificateIssuerConfigByID(certificateIssuerConfigRequest, certificateIssuerConfigurationId);

        // TODO: test validations
    }
}
