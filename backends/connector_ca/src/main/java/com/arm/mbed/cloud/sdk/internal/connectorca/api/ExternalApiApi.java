package com.arm.mbed.cloud.sdk.internal.connectorca.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ExternalApiApi {
  /**
   * Fetch an existing developer certificate to connect to the bootstrap server.
   * This REST API is intended to be used by customers to fetch an existing developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server). 
   * @param muuid A unique identifier for the developer certificate.  (required)
   * @param authorization Bearer {Access Token}.  (required)
   * @return Call&lt;DeveloperCertificateResponseData&gt;
   */
  @GET("v3/developer-certificates/{muuid}")
  Call<DeveloperCertificateResponseData> v3DeveloperCertificatesMuuidGet(
    @retrofit2.http.Path(value = "muuid", encoded = true) String muuid, @retrofit2.http.Header("Authorization") String authorization
  );

  /**
   * Create a new developer certificate to connect to the bootstrap server.
   * This REST API is intended to be used by customers to get a developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server).  Limitations:    - One developer certificate allows up to 100 devices to connect to bootstrap server.   - Only 10 developer certificates are allowed per account. 
   * @param authorization Bearer {Access Token}.  (required)
   * @param body  (required)
   * @return Call&lt;DeveloperCertificateResponseData&gt;
   */
  @POST("v3/developer-certificates")
  Call<DeveloperCertificateResponseData> v3DeveloperCertificatesPost(
    @retrofit2.http.Header("Authorization") String authorization, @retrofit2.http.Body DeveloperCertificateRequestData body
  );

  /**
   * Fetch bootstrap server credentials.
   * This REST API is intended to be used by customers to fetch bootstrap server credentials that they need to use with their clients to connect to bootstrap server. 
   * @param authorization Bearer {Access Token}.  (required)
   * @return Call&lt;ServerCredentialsResponseData&gt;
   */
  @GET("v3/server-credentials/bootstrap")
  Call<ServerCredentialsResponseData> v3ServerCredentialsBootstrapGet(
    @retrofit2.http.Header("Authorization") String authorization
  );

  /**
   * Fetch LWM2M server credentials.
   * This REST API is intended to be used by customers to fetch LWM2M server credentials that they need to use with their clients to connect to LWM2M server. 
   * @param authorization Bearer {Access Token}.  (required)
   * @return Call&lt;ServerCredentialsResponseData&gt;
   */
  @GET("v3/server-credentials/lwm2m")
  Call<ServerCredentialsResponseData> v3ServerCredentialsLwm2mGet(
    @retrofit2.http.Header("Authorization") String authorization
  );

}
