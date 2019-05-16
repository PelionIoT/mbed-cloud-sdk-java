package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceSecurityDeviceCertificateRenewalsApi
 */
public class DeviceSecurityDeviceCertificateRenewalsApiTest {

    private DeviceSecurityDeviceCertificateRenewalsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceSecurityDeviceCertificateRenewalsApi.class);
    }

    /**
     * Get a certificate enrollment by ID.
     *
     * Get a certificate enrollment by ID. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments/01612df56f3b0a580a010fc700000000 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get certificate enrollments list, optionally filtered. **Examples:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments?device_id__eq&#x3D;01612df56f3b0a580a010fc700000000
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
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
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // CertificateEnrollmentListResponse response = api.getCertificateEnrollments(deviceIdEq, certificateNameEq,
        // limit, after, order, include, enrollStatusNeq, enrollStatusEq, enrollResultNeq, enrollResultEq, createdAtLte,
        // createdAtGte, updatedAtLte, updatedAtGte);

        // TODO: test validations
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
