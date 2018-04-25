package com.arm.mbed.cloud.sdk.internal.externalca.api;

import com.arm.mbed.cloud.sdk.internal.externalca.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.ErrorObjectResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CertificateIssuersActivationApi {
  /**
   * Get certificate issuer configuration.
   * Provides the configured certificate issuer to be used when creating device certificates for LwM2M communication.&lt;br&gt; 
   * @param authorization Bearer {token} (required)
   * @return Call&lt;CertificateIssuerConfigResponse&gt;
   */
  @Headers({
    "Content-Type:application/json;charset=UTF-8"
  })
  @GET("v3/certificate-issuer-configurations/lwm2m")
  Call<CertificateIssuerConfigResponse> getCertificateIssuerConfigUsingGET(
    @retrofit2.http.Header("Authorization") String authorization
  );

  /**
   * Update certificate issuer configuration.
   * Configure the certificate issuer to be used when creating device certificates for LwM2M communication. &lt;br&gt; **Example usage:**  &#x60;&#x60;&#x60; curl -X PUT \\ -H &#39;authorization: &lt;valid access token&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ https://api.us-east-1.mbedcloud.com/v3/certificate-issuer-configurations/lwm2m \\ -d &#39;{   \&quot;certificate_issuer_id\&quot;: \&quot;01621a36719d507b9d48a91b00000000\&quot; }&#39; &#x60;&#x60;&#x60; 
   * @param authorization Bearer {token} (required)
   * @param certificateIssuerConfigRequest Certificate Issuer Configuration Request (required)
   * @return Call&lt;CertificateIssuerConfigResponse&gt;
   */
  @Headers({
    "Content-Type:application/json;charset=UTF-8"
  })
  @PUT("v3/certificate-issuer-configurations/lwm2m")
  Call<CertificateIssuerConfigResponse> updateCertificateIssuerConfigUsingPUT(
    @retrofit2.http.Header("Authorization") String authorization, @retrofit2.http.Body CertificateIssuerConfigRequest certificateIssuerConfigRequest
  );

}
