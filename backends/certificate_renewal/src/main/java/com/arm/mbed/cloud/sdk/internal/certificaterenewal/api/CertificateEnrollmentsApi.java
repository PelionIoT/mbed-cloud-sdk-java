package com.arm.mbed.cloud.sdk.internal.certificaterenewal.api;

import com.arm.mbed.cloud.sdk.internal.certificaterenewal.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollmentListResponse;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.ErrorObjectResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CertificateEnrollmentsApi {
  /**
   * Get a certificate enrollment by ID.
   * Get a certificate enrollment by ID.  **Example usage:**  &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments/01612df56f3b0a580a010fc700000000 &#x60;&#x60;&#x60; 
   * @param certificateEnrollmentId The ID of the certificate enrollment.  (required)
   * @return Call&lt;CertificateEnrollment&gt;
   */
  @GET("v3/certificate-enrollments/{certificate-enrollment-id}")
  Call<CertificateEnrollment> getCertificateEnrollment(
    @retrofit2.http.Path(value = "certificate-enrollment-id", encoded = true) String certificateEnrollmentId
  );

  /**
   * Get certificate enrollments list.
   * Get certificate enrollments, optionally filtered by device ID.  **Example usage:**  &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments?device_id__eq&#x3D;01612df56f3b0a580a010fc700000000 &#x60;&#x60;&#x60; 
   * @param deviceIdEq The device ID.  (optional)
   * @return Call&lt;CertificateEnrollmentListResponse&gt;
   */
  @GET("v3/certificate-enrollments")
  Call<CertificateEnrollmentListResponse> getCertificateEnrollments(
    @retrofit2.http.Query("device_id__eq") String deviceIdEq
  );

}
