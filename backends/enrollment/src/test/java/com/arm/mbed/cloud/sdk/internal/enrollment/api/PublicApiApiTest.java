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
     * Place an enrollment claim for one or several devices.
     *
     * When the device connects to the bootstrap server and provides the enrollment ID, it will be assigned to your account. 
     */
    @Test
    public void createDeviceEnrollmentTest() {
        EnrollmentId enrollmentIdentity = null;
        // EnrollmentIdentity response = api.createDeviceEnrollment(enrollmentIdentity);

        // TODO: test validations
    }
    /**
     * Delete an enrollment by ID.
     *
     * To free a device from your account you can delete the enrollment claim. To bypass the device ownership, you need to delete the enrollment and do a factory reset for the device. For more information on the ownership trasfer, see [https://github.com/ARMmbed/mbed_Cloud_Docs/blob/restructure/Docs/provisioning/generic_instructions/device-ownership.md#transferring-ownership-using-first-to-claim](TODO put the right link).
     */
    @Test
    public void deleteDeviceEnrollmentTest() {
        String id = null;
        // Void response = api.deleteDeviceEnrollment(id);

        // TODO: test validations
    }
    /**
     * Get details of an enrollment by ID.
     *
     * To check the enrollment info in detail, for example claming date and expiration date.
     */
    @Test
    public void getDeviceEnrollmentTest() {
        String id = null;
        // EnrollmentIdentity response = api.getDeviceEnrollment(id);

        // TODO: test validations
    }
    /**
     * Get enrollment list.
     *
     * Provides a list of pending and claimed enrollments. Example usage: 
     */
    @Test
    public void getDeviceEnrollmentsTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // EnrollmentIdentities response = api.getDeviceEnrollments(limit, after, order, include);

        // TODO: test validations
    }
}
