package com.arm.mbed.cloud.sdk.internal.certificaterenewal.api;

import com.arm.mbed.cloud.sdk.internal.certificaterenewal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollmentListResponse;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.ErrorObjectResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CertificateEnrollmentsApi
 */
public class CertificateEnrollmentsApiTest {

    private CertificateEnrollmentsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CertificateEnrollmentsApi.class);
    }

    /**
     * Get a certificate enrollment by ID.
     *
     * Get a certificate enrollment by ID.  **Example usage:**  &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments/01612df56f3b0a580a010fc700000000 &#x60;&#x60;&#x60; 
     */
    @Test
    public void getCertificateEnrollmentTest() {
        String certificateEnrollmentId = null;
        // CertificateEnrollment response = api.getCertificateEnrollment(certificateEnrollmentId);

        // TODO: test validations
    }
    /**
     * Get certificate enrollments list.
     *
     * Get certificate enrollments, optionally filtered by device ID.  **Example usage:**  &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments?device_id__eq&#x3D;01612df56f3b0a580a010fc700000000 &#x60;&#x60;&#x60; 
     */
    @Test
    public void getCertificateEnrollmentsTest() {
        String deviceIdEq = null;
        // CertificateEnrollmentListResponse response = api.getCertificateEnrollments(deviceIdEq);

        // TODO: test validations
    }
}
