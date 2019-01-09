package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigListResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CreateCertificateIssuerConfig;

public interface CertificateIssuersActivationApi {
    /**
     * Create certificate issuer configuration. Configure the certificate issuer to be used when creating the device
     * custom certificates. &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;authorization:
     * &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -d &#39;{ \&quot;reference\&quot;:
     * \&quot;customer.dlms\&quot;, \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot;
     * }&#39; &#x60;&#x60;&#x60;
     * 
     * @param createCertificateIssuerConfig
     *            Certificate issuer configuration request (required)
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @POST("v3/certificate-issuer-configurations")
    Call<CertificateIssuerConfigResponse>
        createCertificateIssuerConfig(@retrofit2.http.Body CreateCertificateIssuerConfig createCertificateIssuerConfig);

    /**
     * Delete certificate issuer configuration. Delete the configured certificate issuer configuration. You can only
     * delete the configurations of custom certificates.
     * 
     * @param certificateIssuerConfigurationId
     *            The ID of the certificate issuer configuration. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
    Call<Void>
        deleteCertificateIssuerConfigByID(@retrofit2.http.Path(value = "certificate-issuer-configuration-id",
                                                               encoded = true) String certificateIssuerConfigurationId);

    /**
     * Get certificate issuer configuration. Provides the configured certificate issuer to be used when creating device
     * certificates for LwM2M communication.&lt;br&gt;
     * 
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @GET("v3/certificate-issuer-configurations/lwm2m")
    Call<CertificateIssuerConfigResponse> getCertificateIssuerConfig();

    /**
     * Get certificate issuer configuration. Provides the configured certificate issuer.
     * 
     * @param certificateIssuerConfigurationId
     *            The ID of the certificate issuer configuration. (required)
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @GET("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
    Call<CertificateIssuerConfigResponse>
        getCertificateIssuerConfigByID(@retrofit2.http.Path(value = "certificate-issuer-configuration-id",
                                                            encoded = true) String certificateIssuerConfigurationId);

    /**
     * Get certificate issuer configurations. Get certificate issuer configurations, optionally filtered by reference.
     * &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39;
     * \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ &#x60;&#x60;&#x60; &#x60;&#x60;&#x60;
     * curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations?reference__eq&#x3D;dlms \\
     * &#x60;&#x60;&#x60; Note: This endpoint does not implement pagination and therefore, list control parameters such
     * as &#x60;limit&#x60; or &#x60;after&#x60; will be ignored by the system.
     * 
     * @param limit
     *            How many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000. Limit values
     *            outside of this range are set to the closest limit. (optional)
     * @param order
     *            The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default
     *            &#x60;ASC&#x60;. (optional)
     * @param after
     *            The ID of The item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60; (optional)
     * @param referenceEq
     *            The certificate name to which the certificate issuer configuration applies. (optional)
     * @return Call&lt;CertificateIssuerConfigListResponse&gt;
     */
    @GET("v3/certificate-issuer-configurations")
    Call<CertificateIssuerConfigListResponse>
        getCertificateIssuerConfigs(@retrofit2.http.Query("limit") Integer limit,
                                    @retrofit2.http.Query("order") String order,
                                    @retrofit2.http.Query("after") String after,
                                    @retrofit2.http.Query("include") String include,
                                    @retrofit2.http.Query("reference__eq") String referenceEq);

    /**
     * Update certificate issuer configuration. Configure the certificate issuer to be used when creating device
     * certificates for LwM2M communication. &lt;br&gt; **Example usage:** &#x60;&#x60;&#x60; curl -X PUT \\ -H
     * &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -d &#39;{
     * \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param certificateIssuerConfigRequest
     *            Certificate Issuer Configuration Request (required)
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @PUT("v3/certificate-issuer-configurations/lwm2m")
    Call<CertificateIssuerConfigResponse>
        updateCertificateIssuerConfig(@retrofit2.http.Body CertificateIssuerConfigRequest certificateIssuerConfigRequest);

    /**
     * Update certificate issuer configuration. Update the configured certificate issuer configuration.
     * 
     * @param certificateIssuerConfigRequest
     *            Certificate issuer configuration request (required)
     * @param certificateIssuerConfigurationId
     *            The ID of the certificate issuer configuration. (required)
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @PUT("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
    Call<CertificateIssuerConfigResponse>
        updateCertificateIssuerConfigByID(@retrofit2.http.Body CertificateIssuerConfigRequest certificateIssuerConfigRequest,
                                          @retrofit2.http.Path(value = "certificate-issuer-configuration-id",
                                                               encoded = true) String certificateIssuerConfigurationId);

}
