package com.arm.mbed.cloud.sdk.internal.connectorca.api;

import com.arm.mbed.cloud.sdk.internal.connectorca.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.connectorca.model.AllServerCredentialsResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ServerCredentialsApi {
  /**
   * Fetch all (Bootstrap and LWM2M) server credentials.
   * This REST API is intended to be used by customers to fetch all (Bootstrap and LWM2M) server credentials that they will need to use with their clients to connect to bootstrap or LWM2M server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;         
   * @param authorization Bearer {Access Token}.  (required)
   * @return Call&lt;AllServerCredentialsResponseData&gt;
   */
  @GET("v3/server-credentials")
  Call<AllServerCredentialsResponseData> getAllServerCredentials(
    @retrofit2.http.Header("Authorization") String authorization
  );

  /**
   * Fetch bootstrap server credentials.
   * This REST API is intended to be used by customers to fetch bootstrap server credentials that they will need to use with their clients to connect to bootstrap server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 
   * @param authorization Bearer {Access Token}.  (required)
   * @return Call&lt;ServerCredentialsResponseData&gt;
   */
  @GET("v3/server-credentials/bootstrap")
  Call<ServerCredentialsResponseData> getBootstrapServerCredentials(
    @retrofit2.http.Header("Authorization") String authorization
  );

  /**
   * Fetch LWM2M server credentials.
   * This REST API is intended to be used by customers to fetch LWM2M server credentials that they will need to use with their clients to connect to LWM2M server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 
   * @param authorization Bearer {Access Token}.  (required)
   * @return Call&lt;ServerCredentialsResponseData&gt;
   */
  @GET("v3/server-credentials/lwm2m")
  Call<ServerCredentialsResponseData> getL2M2MServerCredentials(
    @retrofit2.http.Header("Authorization") String authorization
  );

}
