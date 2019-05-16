package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateUpdateReq;

public interface DeviceSecurityCertificatesApi {
    /**
     * Upload a new trusted certificate. Upload new trusted certificates. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;name\&quot;: \&quot;myCert1\&quot;,
     * \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;:
     * \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} &#x60;&#x60;&#x60;
     * 
     * @param body
     *            A trusted certificate object with attributes. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/trusted-certificates")
    Call<TrustedCertificateResp> addCertificate(@retrofit2.http.Body TrustedCertificateReq body);

    /**
     * Delete a trusted certificate by ID. Delete a trusted certificate. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param certId
     *            The ID of the trusted certificate to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/trusted-certificates/{cert_id}")
    Call<Void> deleteCertificate(@retrofit2.http.Path(value = "cert_id", encoded = true) String certId);

    /**
     * Get all trusted certificates. Retrieve trusted certificates in an array. **Example:** &#x60;&#x60;&#x60; curl -X
     * GET https://api.us-east-1.mbedcloud.com/v3/trusted-certificates \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @param nameEq
     *            Filter for certificate name. (optional)
     * @param serviceEq
     *            Service filter, either LwM2M or bootstrap. (optional)
     * @param expireEq
     *            Expire filter in days. (optional)
     * @param deviceExecutionModeEq
     *            Device execution mode: 1 for developer certificates or another natural integer value. (optional)
     * @param deviceExecutionModeNeq
     *            Device execution mode &#x60;not_equals&#x60; filter. (optional)
     * @param ownerEq
     *            Owner name filter. (optional)
     * @param enrollmentModeEq
     *            Enrollment mode filter. (optional)
     * @param statusEq
     *            Filter for certificate status. (optional)
     * @param issuerLike
     *            Issuer filter. Finds all matches where the filter value is a case-insensitive substring of the result.
     *            Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. (optional)
     * @param subjectLike
     *            Subject filter. Finds all matches where the filter value is a case-insensitive substring of the
     *            result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. (optional)
     * @param validEq
     *            Filter for finding certificates by validity. True returns certificates which are not yet expired.
     *            False returns certificates which have expired. (optional)
     * @return Call&lt;TrustedCertificateRespList&gt;
     */
    @GET("v3/trusted-certificates")
    Call<TrustedCertificateRespList>
        getAllCertificates(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                           @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("name__eq") String nameEq,
                           @retrofit2.http.Query("service__eq") String serviceEq,
                           @retrofit2.http.Query("expire__eq") Integer expireEq,
                           @retrofit2.http.Query("device_execution_mode__eq") Integer deviceExecutionModeEq,
                           @retrofit2.http.Query("device_execution_mode__neq") Integer deviceExecutionModeNeq,
                           @retrofit2.http.Query("owner__eq") String ownerEq,
                           @retrofit2.http.Query("enrollment_mode__eq") Boolean enrollmentModeEq,
                           @retrofit2.http.Query("status__eq") String statusEq,
                           @retrofit2.http.Query("issuer__like") String issuerLike,
                           @retrofit2.http.Query("subject__like") String subjectLike,
                           @retrofit2.http.Query("valid__eq") Boolean validEq);

    /**
     * Get trusted certificate by ID. Retrieve a trusted certificate by ID. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param certId
     *            The ID of the trusted certificate to retrieve. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @GET("v3/trusted-certificates/{cert_id}")
    Call<TrustedCertificateResp> getCertificate(@retrofit2.http.Path(value = "cert_id", encoded = true) String certId);

    /**
     * Update trusted certificate. Update existing trusted certificates. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;description\&quot;: \&quot;very
     * important cert\&quot;} &#x60;&#x60;&#x60;
     * 
     * @param certId
     *            The ID of the trusted certificate to update. (required)
     * @param body
     *            A trusted certificate object with attributes. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/trusted-certificates/{cert_id}")
    Call<TrustedCertificateResp>
        updateCertificate(@retrofit2.http.Path(value = "cert_id", encoded = true) String certId,
                          @retrofit2.http.Body TrustedCertificateUpdateReq body);

}
