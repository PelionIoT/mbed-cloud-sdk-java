package com.arm.mbed.cloud.sdk.internal.enrollment.api;

import com.arm.mbed.cloud.sdk.internal.enrollment.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.enrollment.model.BulkResponse;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentId;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentities;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.EnrollmentIdentity;
import com.arm.mbed.cloud.sdk.internal.enrollment.model.ErrorResponse;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PublicApiApi {
  /**
   * Bulk upload
   * With bulk upload, you can upload a &#x60;CSV&#x60; file containing a number of enrollment IDs.  **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -F &#39;enrollment_identities&#x3D;@/path/to/enrollments/enrollments.csv&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-uploads  &#x60;&#x60;&#x60; **An example &#x60;CSV&#x60; file:** 1. The first line is assumed to be the header. The content of the header is not validated. 2. Each line can contain comma-separated values, where the first value is always assumed to be the Enrollment ID. 3. Only one enrollment ID is expected per line. 4. Valid enrollments begin with A followed by a - and 95 characters in the format as below. 5. Valid enrollment identities may be enclosed within quotes. 6. UTF-8 encoding is expected.  &#x60;&#x60;&#x60; \&quot;enrollment_identity\&quot; \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12\&quot;, \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12\&quot;,  &#x60;&#x60;&#x60; 
   * @param enrollmentIdentities The &#x60;CSV&#x60; file containing the enrollment IDs. The maximum file size is 10MB.  (required)
   * @return Call&lt;BulkResponse&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/device-enrollments-bulk-uploads")
  Call<BulkResponse> createBulkDeviceEnrollment(
    @retrofit2.http.Part() MultipartBody.Part enrollmentIdentities
  );

  /**
   * Place an enrollment claim for one or several devices.
   * When the device connects to the bootstrap server and provides the enrollment ID, it will be assigned to your account. &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments \\ -d &#39;{\&quot;enrollment_identity\&quot;: \&quot;A-35:e7:72:8a:07:50:3b:3d:75:96:57:52:72:41:0d:78:cc:c6:e5:53:48:c6:65:58:5b:fa:af:4d:2d:73:95:c5\&quot;}&#39; &#x60;&#x60;&#x60; 
   * @param enrollmentIdentity  (required)
   * @return Call&lt;EnrollmentIdentity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/device-enrollments")
  Call<EnrollmentIdentity> createDeviceEnrollment(
    @retrofit2.http.Body EnrollmentId enrollmentIdentity
  );

  /**
   * Bulk delete
   * With bulk delete, you can upload a &#x60;CSV&#x60; file containing a number of enrollment IDs to be deleted.  **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ -F &#39;enrollment_identities&#x3D;@/path/to/enrollments/enrollments.csv&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-deletes  &#x60;&#x60;&#x60; **An example &#x60;CSV&#x60; file:** 1. The first line is assumed to be the header. The content of the header is not validated. 2. Each line can contain comma-separated values, where the first value is always assumed to be the Enrollment ID. 3. Only one enrollment ID is expected per line. 4. Valid enrollments begin with A followed by a - and 95 characters in the format as below. 5. Valid enrollment identities may be enclosed within quotes. 6. UTF-8 encoding is expected.  &#x60;&#x60;&#x60; \&quot;enrollment_identity\&quot; \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:44:71:93:23:22:15:43:23:12\&quot;, \&quot;A-4E:63:2D:AE:14:BC:D1:09:77:21:95:44:ED:34:06:57:1E:03:B1:EF:0E:F2:59:25:48:44:71:22:15:43:23:12\&quot;,  &#x60;&#x60;&#x60; 
   * @param enrollmentIdentities The &#x60;CSV&#x60; file containing the enrollment IDs. The maximum file size is 10MB.  (required)
   * @return Call&lt;BulkResponse&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/device-enrollments-bulk-deletes")
  Call<BulkResponse> deleteBulkDeviceEnrollment(
    @retrofit2.http.Part() MultipartBody.Part enrollmentIdentities
  );

  /**
   * Delete an enrollment by ID.
   * To free a device from your account you can delete the enrollment claim. To bypass the device ownership, you need to delete the enrollment and do a factory reset for the device. For more information, see [Transferring the ownership using First-to-Claim](/docs/current/connecting/device-ownership.html). &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X DELETE \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments/{id} &#x60;&#x60;&#x60; 
   * @param id Enrollment identity. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/device-enrollments/{id}")
  Call<Void> deleteDeviceEnrollment(
    @retrofit2.http.Path(value = "id", encoded = true) String id
  );

  /**
   * Get bulk upload entity
   * Provides information on bulk upload for the given ID. For example, the bulk status and the number of processed enrollment identities. Also links to the bulk upload reports are provided. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-uploads/{id} &#x60;&#x60;&#x60; 
   * @param id Bulk create task entity ID (required)
   * @return Call&lt;BulkResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("v3/device-enrollments-bulk-uploads/{id}")
  Call<BulkResponse> getBulkDeviceEnrollment(
    @retrofit2.http.Path(value = "id", encoded = true) String id
  );

  /**
   * Get bulk delete entity
   * Provides information on bulk delete for the given ID. For example, the bulk status and the number of processed enrollment identities. Also links to the bulk delete reports are provided. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments-bulk-deletes/{id} &#x60;&#x60;&#x60; 
   * @param id Bulk delete task entity ID (required)
   * @return Call&lt;BulkResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("v3/device-enrollments-bulk-deletes/{id}")
  Call<BulkResponse> getBulkDeviceEnrollmentDelete(
    @retrofit2.http.Path(value = "id", encoded = true) String id
  );

  /**
   * Get details of an enrollment by ID.
   * To check the enrollment info in detail, for example date of claim and expiration date. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments/{id} &#x60;&#x60;&#x60; 
   * @param id Enrollment identity. (required)
   * @return Call&lt;EnrollmentIdentity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("v3/device-enrollments/{id}")
  Call<EnrollmentIdentity> getDeviceEnrollment(
    @retrofit2.http.Path(value = "id", encoded = true) String id
  );

  /**
   * Get enrollment list.
   * Provides a list of pending and claimed enrollments. **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollments &#x60;&#x60;&#x60; With query parameters: &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\ &#39;https://api.us-east-1.mbedcloud.com/v3/device-enrollments?limit&#x3D;10&#39; &#x60;&#x60;&#x60; 
   * @param limit Number of results to be returned. Between 2 and 1000, inclusive. (optional)
   * @param after Entity ID to fetch after. (optional)
   * @param order ASC or DESC (optional, default to ASC)
   * @param include Comma-separated additional data to return. Currently supported: total_count. (optional)
   * @return Call&lt;EnrollmentIdentities&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("v3/device-enrollments")
  Call<EnrollmentIdentities> getDeviceEnrollments(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

}
