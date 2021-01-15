package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateUpdateReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for SecurityAndIdentityCertificatesApi
 */
public class SecurityAndIdentityCertificatesApiTest {

    private SecurityAndIdentityCertificatesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SecurityAndIdentityCertificatesApi.class);
    }

    /**
     * Upload a new trusted certificate.
     *
     * Upload new trusted certificates. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/trusted-certificates \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * {\&quot;name\&quot;: \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;,
     * \&quot;certificate\&quot;: \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;}
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addCertificateTest() {
        TrustedCertificateReq body = null;
        // TrustedCertificateResp response = api.addCertificate(body);

        // TODO: test validations
    }

    /**
     * Delete a trusted certificate by ID.
     *
     * Delete a trusted certificate. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteCertificateTest() {
        String certId = null;
        // Void response = api.deleteCertificate(certId);

        // TODO: test validations
    }

    /**
     * Get all trusted certificates.
     *
     * Retrieve an array of trusted certificates. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllCertificatesTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        String serviceEq = null;
        Integer expireEq = null;
        Integer deviceExecutionModeEq = null;
        Integer deviceExecutionModeNeq = null;
        String ownerEq = null;
        Boolean enrollmentModeEq = null;
        String statusEq = null;
        String issuerLike = null;
        String subjectLike = null;
        String certificateFingerprintEq = null;
        Boolean validEq = null;
        // TrustedCertificateRespList response = api.getAllCertificates(limit, after, order, include, nameEq, serviceEq,
        // expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike,
        // subjectLike, certificateFingerprintEq, validEq);

        // TODO: test validations
    }

    /**
     * Get a trusted certificate.
     *
     * Retrieve a trusted certificate. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getCertificateTest() {
        String certId = null;
        // TrustedCertificateResp response = api.getCertificate(certId);

        // TODO: test validations
    }

    /**
     * Update trusted certificate.
     *
     * Update existing trusted certificates. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;description\&quot;:
     * \&quot;very important cert\&quot;} &#x60;&#x60;&#x60;
     */
    @Test
    public void updateCertificateTest() {
        String certId = null;
        TrustedCertificateUpdateReq body = null;
        // TrustedCertificateResp response = api.updateCertificate(certId, body);

        // TODO: test validations
    }
}
