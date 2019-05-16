package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BlackListedDeviceData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DenialAttemptsResponse;

public interface EnrollmentDenialsApi {
    /**
     * Query for a single device by ID Query for a single attempt to bootstrap with a blacklisted certificate by ID.
     * **Example usage:** &#x60;&#x60;&#x60; curl -X GET -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39;
     * \\ https://api.us-east-1.mbedcloud.com/v3/device-enrollment-denials/{device_enrollment_denial_id}
     * &#x60;&#x60;&#x60;
     * 
     * @param deviceEnrollmentDenialId
     *            id of the recorded failed bootstrap attempt (required)
     * @return Call&lt;BlackListedDeviceData&gt;
     */
    @GET("v3/device-enrollment-denials/{device_enrollment_denial_id}")
    Call<BlackListedDeviceData>
        getEnrollmentDenialAttempt(@retrofit2.http.Path(value = "device_enrollment_denial_id",
                                                        encoded = true) String deviceEnrollmentDenialId);

    /**
     * Return list of devices which were denied to bootstrap due to being subjected to blacklisting. This produces a
     * list of failed attempts to bootstrap using a particular certificate which is blacklisted (trusted_certificate).
     * Returned list can be filtered by endpoint name. Trusted certificate ID filter is required. **Example usage:**
     * &#x60;&#x60;&#x60; curl -X GET -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/device-enrollment-denials?trusted_certificate_id__eq&#x3D;{cert-id}&amp;endpoint_name__eq&#x3D;{endpoint_name}
     * &#x60;&#x60;&#x60;
     * 
     * @param trustedCertificateIdEq
     *            filtering based on trusted certificate id (required)
     * @param endpointNameEq
     *            filtering based on endpoint name (optional)
     * @param after
     *            Optional parameter for pagination. Denied device ID. (optional)
     * @param order
     *            Optional parameter for pagination. (optional)
     * @param limit
     *            Optional parameter for pagination. (optional)
     * @return Call&lt;DenialAttemptsResponse&gt;
     */
    @GET("v3/device-enrollment-denials")
    Call<DenialAttemptsResponse>
        listEnrollmentDenialAttempts(@retrofit2.http.Query("trusted_certificate_id__eq") String trustedCertificateIdEq,
                                     @retrofit2.http.Query("endpoint_name__eq") String endpointNameEq,
                                     @retrofit2.http.Query("after") String after,
                                     @retrofit2.http.Query("order") String order,
                                     @retrofit2.http.Query("limit") Integer limit);

}
