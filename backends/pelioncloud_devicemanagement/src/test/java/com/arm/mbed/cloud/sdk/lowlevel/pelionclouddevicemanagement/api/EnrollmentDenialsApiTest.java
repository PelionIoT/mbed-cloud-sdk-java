package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for EnrollmentDenialsApi
 */
public class EnrollmentDenialsApiTest {

    private EnrollmentDenialsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(EnrollmentDenialsApi.class);
    }

    /**
     * Query for a single device by ID
     *
     * Query for a single attempt to bootstrap with a blacklisted certificate by ID. **Example usage:**
     * &#x60;&#x60;&#x60; curl -X GET -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/device-enrollment-denials/{device_enrollment_denial_id} &#x60;&#x60;&#x60;
     */
    @Test
    public void getEnrollmentDenialAttemptTest() {
        String deviceEnrollmentDenialId = null;
        // BlackListedDeviceData response = api.getEnrollmentDenialAttempt(deviceEnrollmentDenialId);

        // TODO: test validations
    }

    /**
     * Return list of devices which were denied to bootstrap due to being subjected to blacklisting.
     *
     * This produces a list of failed attempts to bootstrap using a particular certificate which is blacklisted
     * (trusted_certificate). Returned list can be filtered by endpoint name. Trusted certificate ID filter is required.
     * **Example usage:** &#x60;&#x60;&#x60; curl -X GET -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39;
     * \\
     * https://api.us-east-1.mbedcloud.com/v3/device-enrollment-denials?trusted_certificate_id__eq&#x3D;{cert-id}&amp;endpoint_name__eq&#x3D;{endpoint_name}
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void listEnrollmentDenialAttemptsTest() {
        String trustedCertificateIdEq = null;
        String endpointNameEq = null;
        String after = null;
        String order = null;
        Integer limit = null;
        // DenialAttemptsResponse response = api.listEnrollmentDenialAttempts(trustedCertificateIdEq, endpointNameEq,
        // after, order, limit);

        // TODO: test validations
    }
}
