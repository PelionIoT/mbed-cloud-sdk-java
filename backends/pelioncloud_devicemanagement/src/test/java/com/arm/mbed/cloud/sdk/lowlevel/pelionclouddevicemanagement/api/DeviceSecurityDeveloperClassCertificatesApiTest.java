package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeveloperCertificateRequestData;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceSecurityDeveloperClassCertificatesApi
 */
public class DeviceSecurityDeveloperClassCertificatesApiTest {

    private DeviceSecurityDeveloperClassCertificatesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceSecurityDeveloperClassCertificatesApi.class);
    }

    /**
     * Create a new developer certificate to connect to the bootstrap server.
     *
     * Create a developer certificate (a certificate that can be flashed to multiple devices to connect to the bootstrap
     * server). **Note:** The number of developer certificates allowed per account is limited. Please see [Using your
     * own certificate authority](../provisioning-process/using-CA.html). **Example:** &#x60;&#x60;&#x60; curl -X POST
     * http://api.us-east-1.mbedcloud.com/v3/developer-certificates \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; \\ -H \&quot;content-type: application/json\&quot; \\ -d { \&quot;name\&quot;:
     * \&quot;&lt;certificate_name&gt;\&quot;, \&quot;description\&quot;: \&quot;&lt;certificate_description&gt;\&quot;
     * } &#x60;&#x60;&#x60;
     */
    @Test
    public void createDeveloperCertificateTest() {
        DeveloperCertificateRequestData body = null;
        // DeveloperCertificateResponseData response = api.createDeveloperCertificate(body);

        // TODO: test validations
    }

    /**
     * Fetch an existing developer certificate to connect to the bootstrap server.
     *
     * Return an existing developer certificate (a certificate that can be flashed to multiple devices to connect to
     * bootstrap server). **Example:** &#x60;&#x60;&#x60; curl -X GET
     * http://api.us-east-1.mbedcloud.com/v3/developer-certificates/THE_CERTIFICATE_ID \\ -H \&quot;Authorization:
     * Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     */
    @Test
    public void getDeveloperCertificateTest() {
        String developerCertificateId = null;
        // DeveloperCertificateResponseData response = api.getDeveloperCertificate(developerCertificateId);

        // TODO: test validations
    }
}
