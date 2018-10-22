package com.arm.mbed.cloud.sdk.internal.certificaterenewal.api;

import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.ErrorObjectResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Request a certificate renewal.  **Example usage:**  &#x60;&#x60;&#x60; curl -X POST -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; -H &#39;content-length: 0&#39; https://api.us-east-1.mbedcloud.com/v3/devices/01612df56f3b0a580a010fc700000000/certificates/customer.dlms/renew &#x60;&#x60;&#x60; 
     */
    @Test
    public void requestCertificateRenewalTest() {
        String deviceId = null;
        String certificateName = null;
        // CertificateEnrollment response = api.requestCertificateRenewal(deviceId, certificateName);

        // TODO: test validations
    }
}
