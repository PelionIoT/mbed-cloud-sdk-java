package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

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
     * Get a certificate enrollment by ID. **Example usage:** &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer
     * &lt;valid access token&gt;&#39;
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments/01612df56f3b0a580a010fc700000000
     * &#x60;&#x60;&#x60;
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
     * Get certificate enrollments list, optionally filtered. **Example usage:** &#x60;&#x60;&#x60; curl -H
     * &#39;authorization: Bearer &lt;valid access token&gt;&#39;
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl -H
     * &#39;authorization: Bearer &lt;valid access token&gt;&#39;
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments?device_id__eq&#x3D;01612df56f3b0a580a010fc700000000
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getCertificateEnrollmentsTest() {
        String deviceIdEq = null;
        String certificateNameEq = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String enrollStatusNeq = null;
        String enrollStatusEq = null;
        String enrollResultNeq = null;
        String enrollResultEq = null;
        String createdAtLte = null;
        String createdAtGte = null;
        String updatedAtLte = null;
        String updatedAtGte = null;
        // CertificateEnrollmentListResponse response = api.getCertificateEnrollments(deviceIdEq, certificateNameEq,
        // limit, after, order, include, enrollStatusNeq, enrollStatusEq, enrollResultNeq, enrollResultEq, createdAtLte,
        // createdAtGte, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }
}
