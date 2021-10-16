package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateUpdateReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantSecurityAndIdentityCertificatesApi
 */
public class TenantSecurityAndIdentityCertificatesApiTest {

    private TenantSecurityAndIdentityCertificatesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantSecurityAndIdentityCertificatesApi.class);
    }

    /**
     * Upload new trusted certificate.
     *
     * Upload new trusted certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;name\&quot;:
     * \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;:
     * \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} &#x60;&#x60;&#x60;
     */
    @Test
    public void addAccountCertificateTest() {
        String accountId = null;
        TrustedCertificateReq body = null;
        // TrustedCertificateResp response = api.addAccountCertificate(accountId, body);

        // TODO: test validations
    }

    /**
     * Delete a trusted certificate by ID.
     *
     * Delete a trusted certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteAccountCertificateTest() {
        String accountId = null;
        String certId = null;
        // Void response = api.deleteAccountCertificate(accountId, certId);

        // TODO: test validations
    }

    /**
     * Get a trusted certificate.
     *
     * Retrieve a trusted certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountCertificateTest() {
        String accountId = null;
        String certId = null;
        // TrustedCertificateResp response = api.getAccountCertificate(accountId, certId);

        // TODO: test validations
    }

    /**
     * Get trusted certificates.
     *
     * Retrieve an array of trusted certificates. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountCertificatesTest() {
        String accountId = null;
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
        // TrustedCertificateRespList response = api.getAllAccountCertificates(accountId, limit, after, order, include,
        // nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq,
        // statusEq, issuerLike, subjectLike, certificateFingerprintEq, validEq);

        // TODO: test validations
    }

    /**
     * Update trusted certificate.
     *
     * Update a trusted certificate. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * {\&quot;description\&quot;: \&quot;very important cert\&quot;} &#x60;&#x60;&#x60;
     */
    @Test
    public void updateAccountCertificateTest() {
        String accountId = null;
        String certId = null;
        TrustedCertificateUpdateReq body = null;
        // TrustedCertificateResp response = api.updateAccountCertificate(accountId, certId, body);

        // TODO: test validations
    }
}
