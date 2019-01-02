package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeveloperCertificateResponseData;

public interface DeveloperCertificateApi {
    /**
     * Create a new developer certificate to connect to the bootstrap server. This REST API is intended to be used by
     * customers to get a developer certificate (a certificate that can be flashed into multiple devices to connect to
     * bootstrap server). **Note:** The number of developer certificates allowed per account is limited. Please see
     * [Using your own certificate
     * authority](/docs/current/mbed-cloud-deploy/instructions-for-factory-setup-and-device-provision.html#using-your-own-certificate-authority-with-mbed-cloud).
     * **Example usage:** curl -X POST \&quot;http://api.us-east-1.mbedcloud.com/v3/developer-certificates\&quot; -H
     * \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; -H
     * \&quot;content-type: application/json\&quot; -d \&quot;{ \\\&quot;name\\\&quot;:
     * \\\&quot;THE_CERTIFICATE_NAME\\\&quot;, \\\&quot;description\\\&quot;:
     * \\\&quot;THE_CERTIFICATE_DESCRIPTION\\\&quot;}\&quot;
     * 
     * @param body
     *            (required)
     * @return Call&lt;DeveloperCertificateResponseData&gt;
     */
    @POST("v3/developer-certificates")
    Call<DeveloperCertificateResponseData>
        createDeveloperCertificate(@retrofit2.http.Body DeveloperCertificateRequestData body);

    /**
     * Fetch an existing developer certificate to connect to the bootstrap server. This REST API is intended to be used
     * by customers to fetch an existing developer certificate (a certificate that can be flashed into multiple devices
     * to connect to bootstrap server). **Example usage:** curl -X GET
     * \&quot;http://api.us-east-1.mbedcloud.com/v3/developer-certificates/THE_CERTIFICATE_ID\&quot; -H \&quot;accept:
     * application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;
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
