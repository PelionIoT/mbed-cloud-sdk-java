package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CreateCertificateIssuerConfig;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for SecurityAndIdentityCertificateIssuerConfigurationsApi
 */
public class SecurityAndIdentityCertificateIssuerConfigurationsApiTest {

    private SecurityAndIdentityCertificateIssuerConfigurationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SecurityAndIdentityCertificateIssuerConfigurationsApi.class);
    }

    /**
     * Create certificate issuer configuration.
     *
     * Configure the certificate issuer to use when creating device custom certificates. &lt;br&gt; **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;reference\&quot;: \&quot;customer.dlms\&quot;,
     * \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60;
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
     * Delete certificate issuer configuration. You can only delete custom certificate configurations.
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
     * Provides the configured certificate issuer used when creating device certificates for LwM2M.
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
     * Get certificate issuer configurations, optionally filtered by reference. &lt;br&gt; **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\ &#x60;&#x60;&#x60; &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations?reference__eq&#x3D;dlms \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\ &#x60;&#x60;&#x60; **Note:** This endpoint does not implement
     * pagination, and therefore ignores list control parameters such as &#x60;limit&#x60; or &#x60;after&#x60;.
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
     * Configure the certificate issuer used when creating device certificates for LwM2M. &lt;br&gt; **Example:**
     * &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\
     * -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;certificate_issuer_id\&quot;:
     * \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60;
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
     * Update certificate issuer configuration.
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
