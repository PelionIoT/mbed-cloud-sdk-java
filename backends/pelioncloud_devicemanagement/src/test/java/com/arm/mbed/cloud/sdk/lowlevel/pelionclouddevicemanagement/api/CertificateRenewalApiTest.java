package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for CertificateRenewalApi
 */
public class CertificateRenewalApiTest {

    private CertificateRenewalApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CertificateRenewalApi.class);
    }

    /**
     * Request certificate renewal.
     *
     * Request a certificate renewal. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/devices/01612df56f3b0a580a010fc700000000/certificates/customer.dlms/renew
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-length: 0&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void requestCertificateRenewalTest() {
        String deviceId = null;
        String certificateName = null;
        // CertificateEnrollment response = api.requestCertificateRenewal(deviceId, certificateName);

        // TODO: test validations
    }
}
