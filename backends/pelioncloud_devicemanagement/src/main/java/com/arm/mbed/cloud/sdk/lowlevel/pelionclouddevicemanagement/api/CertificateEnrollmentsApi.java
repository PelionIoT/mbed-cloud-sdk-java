package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateEnrollmentListResponse;
import org.joda.time.DateTime;

public interface CertificateEnrollmentsApi {
    /**
     * Get a certificate enrollment by ID. Get a certificate enrollment by ID. **Example usage:** &#x60;&#x60;&#x60;
     * curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39;
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments/01612df56f3b0a580a010fc700000000
     * &#x60;&#x60;&#x60;
     * 
     * @param certificateEnrollmentId
     *            The ID of the certificate enrollment. (required)
     * @return Call&lt;CertificateEnrollment&gt;
     */
    @GET("v3/certificate-enrollments/{certificate-enrollment-id}")
    Call<CertificateEnrollment>
        getCertificateEnrollment(@retrofit2.http.Path(value = "certificate-enrollment-id",
                                                      encoded = true) String certificateEnrollmentId);

    /**
     * Get certificate enrollments list. Get certificate enrollments list, optionally filtered. **Example usage:**
     * &#x60;&#x60;&#x60; curl -H &#39;authorization: Bearer &lt;valid access token&gt;&#39;
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl -H
     * &#39;authorization: Bearer &lt;valid access token&gt;&#39;
     * https://api.us-east-1.mbedcloud.com/v3/certificate-enrollments?device_id__eq&#x3D;01612df56f3b0a580a010fc700000000
     * &#x60;&#x60;&#x60;
     * 
     * @param deviceIdEq
     *            An optional filter for the device ID. (optional)
     * @param certificateNameEq
     *            An optional filter for a certificate. (optional)
     * @param limit
     *            The number of results to be returned. Between 2 and 1000, inclusive. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param order
     *            The order of results. (optional)
     * @param include
     *            a comma-separated list of data fields to return. (optional)
     * @param enrollStatusNeq
     *            An optional filter for the non-equal certificate enrollment status. (optional)
     * @param enrollStatusEq
     *            An optional filter for the certificate enrollment status. (optional)
     * @param enrollResultNeq
     *            An optional filter for the non-equal certificate enrollment result. (optional)
     * @param enrollResultEq
     *            An optional filter for the certificate enrollment result. (optional)
     * @param createdAtLte
     *            An optional filter for the date-time, less than or equal, of the certificate enrollment requests
     *            creation. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). (optional)
     * @param createdAtGte
     *            An optional filter for the date-time, greater than or equal, of the certificate enrollment requests
     *            creation. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). (optional)
     * @param updatedAtLte
     *            An optional filter for the date-time, less than or equal, of the certificate enrollment requests
     *            update. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). (optional)
     * @param updatedAtGte
     *            An optional filter for the date-time, greater than or equal, of the certificate enrollment requests
     *            update. Must be in RFC3339 format (for example, 2018-01-30T10:03:50.106Z). (optional)
     * @return Call&lt;CertificateEnrollmentListResponse&gt;
     */
    @GET("v3/certificate-enrollments")
    Call<CertificateEnrollmentListResponse>
        getCertificateEnrollments(@retrofit2.http.Query("device_id__eq") String deviceIdEq,
                                  @retrofit2.http.Query("certificate_name__eq") String certificateNameEq,
                                  @retrofit2.http.Query("limit") Integer limit,
                                  @retrofit2.http.Query("after") String after,
                                  @retrofit2.http.Query("order") String order,
                                  @retrofit2.http.Query("include") String include,
                                  @retrofit2.http.Query("enroll_status__neq") String enrollStatusNeq,
                                  @retrofit2.http.Query("enroll_status__eq") String enrollStatusEq,
                                  @retrofit2.http.Query("enroll_result__neq") String enrollResultNeq,
                                  @retrofit2.http.Query("enroll_result__eq") String enrollResultEq,
                                  @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                                  @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                                  @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                                  @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte);

}
