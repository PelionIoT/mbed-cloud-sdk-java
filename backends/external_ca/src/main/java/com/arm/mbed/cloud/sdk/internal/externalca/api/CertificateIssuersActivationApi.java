package com.arm.mbed.cloud.sdk.internal.externalca.api;

import com.arm.mbed.cloud.sdk.internal.externalca.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CreateCertificateIssuerConfig;
import com.arm.mbed.cloud.sdk.internal.externalca.model.ErrorObjectResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CertificateIssuersActivationApi {
  /**
   * Create certificate issuer configuration.
   * Configure the certificate issuer to be used when creating the device custom certificates. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X POST \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ -d &#39;{   \&quot;reference\&quot;: \&quot;customer.dlms\&quot;,   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60; 
   * @param createCertificateIssuerConfig Certificate issuer configuration request (required)
   * @return Call&lt;CertificateIssuerConfigResponse&gt;
   */
  @Headers({
    "Content-Type:application/json; charset=utf-8"
  })
  @POST("v3/certificate-issuer-configurations")
  Call<CertificateIssuerConfigResponse> createCertificateIssuerConfig(
    @retrofit2.http.Body CreateCertificateIssuerConfig createCertificateIssuerConfig
  );

  /**
   * Delete certificate issuer configuration.
   * Delete the configured certificate issuer configuration. You can only delete the configurations of custom certificates. 
   * @param certificateIssuerConfigurationId The ID of the certificate issuer configuration.  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json; charset=utf-8"
  })
  @DELETE("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
  Call<Void> deleteCertificateIssuerConfigByID(
    @retrofit2.http.Path(value = "certificate-issuer-configuration-id", encoded = true) String certificateIssuerConfigurationId
  );

  /**
   * Get certificate issuer configuration.
   * Provides the configured certificate issuer to be used when creating device certificates for LwM2M communication.&lt;br&gt; 
   * @return Call&lt;CertificateIssuerConfigResponse&gt;
   */
  @Headers({
    "Content-Type:application/json; charset=utf-8"
  })
  @GET("v3/certificate-issuer-configurations/lwm2m")
  Call<CertificateIssuerConfigResponse> getCertificateIssuerConfig();
    

  /**
   * Get certificate issuer configuration.
   * Provides the configured certificate issuer. 
   * @param certificateIssuerConfigurationId The ID of the certificate issuer configuration.  (required)
   * @return Call&lt;CertificateIssuerConfigResponse&gt;
   */
  @Headers({
    "Content-Type:application/json; charset=utf-8"
  })
  @GET("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
  Call<CertificateIssuerConfigResponse> getCertificateIssuerConfigByID(
    @retrofit2.http.Path(value = "certificate-issuer-configuration-id", encoded = true) String certificateIssuerConfigurationId
  );

  /**
   * Get certificate issuer configurations.
   * Get certificate issuer configurations, optionally filtered by reference. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations \\ &#x60;&#x60;&#x60; &#x60;&#x60;&#x60; curl \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations?reference__eq&#x3D;dlms \\ &#x60;&#x60;&#x60; 
   * @param referenceEq The certificate name to which the certificate issuer configuration applies. (optional)
   * @return Call&lt;CertificateIssuerConfigListResponse&gt;
   */
  @Headers({
    "Content-Type:application/json; charset=utf-8"
  })
  @GET("v3/certificate-issuer-configurations")
  Call<CertificateIssuerConfigListResponse> getCertificateIssuerConfigs(
    @retrofit2.http.Query("reference__eq") String referenceEq
  );

  /**
   * Update certificate issuer configuration.
   * Configure the certificate issuer to be used when creating device certificates for LwM2M communication. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X PUT \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -d &#39;{   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60; 
   * @param certificateIssuerConfigRequest Certificate Issuer Configuration Request (required)
   * @return Call&lt;CertificateIssuerConfigResponse&gt;
   */
  @Headers({
    "Content-Type:application/json; charset=utf-8"
  })
  @PUT("v3/certificate-issuer-configurations/lwm2m")
  Call<CertificateIssuerConfigResponse> updateCertificateIssuerConfig(
    @retrofit2.http.Body CertificateIssuerConfigRequest certificateIssuerConfigRequest
  );

  /**
   * Update certificate issuer configuration.
   * Update the configured certificate issuer configuration. 
   * @param certificateIssuerConfigurationId The ID of the certificate issuer configuration.  (required)
   * @param certificateIssuerConfigRequest Certificate issuer configuration request (required)
   * @return Call&lt;CertificateIssuerConfigResponse&gt;
   */
  @Headers({
    "Content-Type:application/json; charset=utf-8"
  })
  @PUT("v3/certificate-issuer-configurations/{certificate-issuer-configuration-id}")
  Call<CertificateIssuerConfigResponse> updateCertificateIssuerConfigByID(
    @retrofit2.http.Path(value = "certificate-issuer-configuration-id", encoded = true) String certificateIssuerConfigurationId, @retrofit2.http.Body CertificateIssuerConfigRequest certificateIssuerConfigRequest
  );

}
