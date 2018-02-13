package com.arm.mbed.cloud.sdk.internal.enrollment.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentId;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentities;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentity;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.ErrorResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PublicApiApi
 */
public class PublicApiApiTest {

    private PublicApiApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(PublicApiApi.class);
    }

    /**
     * Get enrollment list.
     *
     * Provides a list of pending and claimed enrollments. Example usage: 
     */
    @Test
    public void v3DeviceEnrollmentsGetTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        // EnrollmentIdentities response = api.v3DeviceEnrollmentsGet(limit, after, order);

        // TODO: test validations
    }
    /**
     * Place an enrollment claim for one or several devices.
     *
     * When the device connects to the bootstrap server and provides the enrollment ID, it will be assigned to your account. 
     */
    @Test
    public void v3DeviceEnrollmentsPostTest() {
        EnrollmentId enrollmentIdentity = null;
        // EnrollmentIdentity response = api.v3DeviceEnrollmentsPost(enrollmentIdentity);

        // TODO: test validations
    }
    /**
     * Delete an enrollment by ID.
     *
     * To free a device from your account you can delete the enrollment claim. To bypass the device ownership, you need to delete the enrollment and do a factory reset for the device. For more information on the ownership trasfer, see [https://github.com/ARMmbed/mbed_Cloud_Docs/blob/restructure/Docs/provisioning/generic_instructions/device-ownership.md#transferring-ownership-using-first-to-claim](TODO put the right link).
     */
    @Test
    public void v3DeviceEnrollmentsidDeleteTest() {
        // Void response = api.v3DeviceEnrollmentsidDelete();

        // TODO: test validations
    }
    /**
     * Get details of an enrollment by ID.
     *
     * To check the enrollment info in detail, for example claming date and expiration date.
     */
    @Test
    public void v3DeviceEnrollmentsidGetTest() {
        // EnrollmentIdentity response = api.v3DeviceEnrollmentsidGet();

        // TODO: test validations
    }
}
