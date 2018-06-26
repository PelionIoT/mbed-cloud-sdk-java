package com.arm.mbed.cloud.sdk.internal.enrollment.api;

import com.arm.mbed.cloud.sdk.internal.enrollment.ApiClient;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.BulkCreateResponse;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentId;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentities;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentity;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.ErrorResponse;
import java.io.File;
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
     * Bulk upload
     *
     * With bulk upload you can upload a CSV file containing a number of enrollment IDs.  First line of the CSV is read as a header and not as a enrollment identity. **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -F &#39;enrollments&#x3D;@/path/to/enrollments/enrollments.csv&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-uploads &#x60;&#x60;&#x60; 
     */
    @Test
    public void createBulkDeviceEnrollmentTest() {
        File enrollmentIdentities = null;
        // BulkCreateResponse response = api.createBulkDeviceEnrollment(enrollmentIdentities);

        // TODO: test validations
    }
    /**
     * Place an enrollment claim for one or several devices.
     *
     * When the device connects to the bootstrap server and provides the enrollment ID, it will be assigned to your account. &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments \\ -d &#39;{\&quot;enrollment_identity\&quot;: \&quot;A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5\&quot;}&#39; &#x60;&#x60;&#x60; 
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
     * To free a device from your account you can delete the enrollment claim. To bypass the device ownership, you need to delete the enrollment and do a factory reset for the device. For more information, see [Transferring the ownership using First-to-Claim](/docs/current/connecting/device-ownership.html). &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X DELETE \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments/{id} &#x60;&#x60;&#x60; 
     */
    @Test
    public void deleteDeviceEnrollmentTest() {
        String id = null;
        // Void response = api.deleteDeviceEnrollment(id);

        // TODO: test validations
    }
    /**
     * Get bulk upload entity
     *
     * Provides info about bulk upload for the given ID. For example bulk status and processed count of enrollment identities. Info includes also links for the bulk upload reports. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-uploads/{id} &#x60;&#x60;&#x60; 
     */
    @Test
    public void getBulkDeviceEnrollmentTest() {
        String id = null;
        // BulkCreateResponse response = api.getBulkDeviceEnrollment(id);

        // TODO: test validations
    }
    /**
     * Get details of an enrollment by ID.
     *
     * To check the enrollment info in detail, for example date of claim and expiration date. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments/{id} &#x60;&#x60;&#x60; 
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
     * Provides a list of pending and claimed enrollments. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments &#x60;&#x60;&#x60; With query parameters: &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ &#39;https://api.us-east-1.mbedcloud.com/v3/device-enrollments?limit&#x3D;10&#39; &#x60;&#x60;&#x60; 
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
