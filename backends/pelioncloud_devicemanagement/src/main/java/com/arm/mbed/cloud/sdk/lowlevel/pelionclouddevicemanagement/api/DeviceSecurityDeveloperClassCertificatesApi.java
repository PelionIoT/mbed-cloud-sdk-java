package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeveloperCertificateResponseData;

public interface DeviceSecurityDeveloperClassCertificatesApi {
    /**
     * Create a new developer certificate to connect to the bootstrap server. Create a developer certificate (a
     * certificate that can be flashed to multiple devices to connect to the bootstrap server). **Note:** The number of
     * developer certificates allowed per account is limited. Please see [Using your own certificate
     * authority](../provisioning-process/using-CA.html). **Example:** &#x60;&#x60;&#x60; curl -X POST
     * http://api.us-east-1.mbedcloud.com/v3/developer-certificates \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; \\ -H \&quot;content-type: application/json\&quot; \\ -d { \&quot;name\&quot;:
     * \&quot;&lt;certificate_name&gt;\&quot;, \&quot;description\&quot;: \&quot;&lt;certificate_description&gt;\&quot;
     * } &#x60;&#x60;&#x60;
     * 
     * @param body
     *            (required)
     * @return Call&lt;DeveloperCertificateResponseData&gt;
     */
    @POST("v3/developer-certificates")
    Call<DeveloperCertificateResponseData>
        createDeveloperCertificate(@retrofit2.http.Body DeveloperCertificateRequestData body);

    /**
     * Fetch an existing developer certificate to connect to the bootstrap server. Return an existing developer
     * certificate (a certificate that can be flashed to multiple devices to connect to bootstrap server). **Example:**
     * &#x60;&#x60;&#x60; curl -X GET http://api.us-east-1.mbedcloud.com/v3/developer-certificates/THE_CERTIFICATE_ID \\
     * -H \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     * 
     * @param developerCertificateId
     *            A unique identifier for the developer certificate. (required)
     * @return Call&lt;DeveloperCertificateResponseData&gt;
     */
    @GET("v3/developer-certificates/{developerCertificateId}")
    Call<DeveloperCertificateResponseData>
        getDeveloperCertificate(@retrofit2.http.Path(value = "developerCertificateId",
                                                     encoded = true) String developerCertificateId);

}
