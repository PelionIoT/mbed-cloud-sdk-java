package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigListResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CreateCertificateIssuerConfig;

public interface SecurityAndIdentityCertificateIssuerConfigurationsApi {
    /**
     * Create certificate issuer configuration. Configure the certificate issuer to use when creating device custom
     * certificates. &lt;br&gt; **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{
     * \&quot;reference\&quot;: \&quot;customer.dlms\&quot;, \&quot;certificate_issuer_id\&quot;:
     * \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param createCertificateIssuerConfig
     *            Certificate issuer configuration request. (required)
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @POST("v3/certificate-issuer-configurations")
    Call<CertificateIssuerConfigResponse>
        createCertificateIssuerConfig(@retrofit2.http.Body CreateCertificateIssuerConfig createCertificateIssuerConfig);

    /**
     * Delete certificate issuer configuration. Delete certificate issuer configuration. You can only delete custom
     * certificate configurations.
     * 
     * @param certificateIssuerConfigurationId
     *            Certificate issuer ID configuration. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
    Call<Void>
        deleteCertificateIssuerConfigByID(@retrofit2.http.Path(value = "certificate-issuer-configuration-id",
                                                               encoded = true) String certificateIssuerConfigurationId);

    /**
     * Get certificate issuer configuration. Provides the configured certificate issuer used when creating device
     * certificates for LwM2M.
     * 
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @GET("v3/certificate-issuer-configurations/lwm2m")
    Call<CertificateIssuerConfigResponse> getCertificateIssuerConfig();

    /**
     * Get certificate issuer configuration. Provides the configured certificate issuer.
     * 
     * @param certificateIssuerConfigurationId
     *            Certificate issuer ID configuration. (required)
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @GET("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
    Call<CertificateIssuerConfigResponse>
        getCertificateIssuerConfigByID(@retrofit2.http.Path(value = "certificate-issuer-configuration-id",
                                                            encoded = true) String certificateIssuerConfigurationId);

    /**
     * Get certificate issuer configurations. Get certificate issuer configurations, optionally filtered by reference.
     * &lt;br&gt; **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ &#x60;&#x60;&#x60;
     * &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations?reference__eq&#x3D;dlms \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\ &#x60;&#x60;&#x60; **Note:** This endpoint does not implement
     * pagination, and therefore ignores list control parameters such as &#x60;limit&#x60; or &#x60;after&#x60;.
     * 
     * @param limit
     *            The number of results to return (2-1000). Values outside of this range are set to the closest limit.
     *            (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. Default: ASC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
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
     * Update certificate issuer configuration. Configure the certificate issuer used when creating device certificates
     * for LwM2M. &lt;br&gt; **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{
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
     * Update certificate issuer configuration. Update certificate issuer configuration.
     * 
     * @param certificateIssuerConfigRequest
     *            Certificate issuer configuration request. (required)
     * @param certificateIssuerConfigurationId
     *            Certificate issuer ID configuration. (required)
     * @return Call&lt;CertificateIssuerConfigResponse&gt;
     */
    @PUT("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
    Call<CertificateIssuerConfigResponse>
        updateCertificateIssuerConfigByID(@retrofit2.http.Body CertificateIssuerConfigRequest certificateIssuerConfigRequest,
                                          @retrofit2.http.Path(value = "certificate-issuer-configuration-id",
                                                               encoded = true) String certificateIssuerConfigurationId);

}
