package com.arm.mbed.cloud.sdk.internal.connectorca.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ServerCredentialsApi {
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
