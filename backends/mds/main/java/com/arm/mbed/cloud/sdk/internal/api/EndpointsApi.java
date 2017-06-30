package com.arm.mbed.cloud.sdk.internal.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.model.Endpoint;
import com.arm.mbed.cloud.sdk.internal.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface EndpointsApi {
  /**
   * List the resources on an endpoint
   * The list of resources is cached by mbed Cloud Connect, so this call does not create a message to the device. 
   * @param deviceId A unique mbed Cloud device ID for an endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here.  (required)
   * @return Call&lt;List&lt;Resource&gt;&gt;
   */
  
  @GET("v2/endpoints/{device-id}")
  Call<List<Resource>> v2EndpointsDeviceIdGet(
    @retrofit2.http.Path("device-id") String deviceId
  );

  /**
   * List endpoints. The number of endpoints is currently limited to 200.
   * Endpoints are physical devices running mbed Cloud Client. 
   * @param type Filter endpoints by endpoint-type. (optional)
   * @return Call&lt;List&lt;Endpoint&gt;&gt;
   */
  
  @GET("v2/endpoints")
  Call<List<Endpoint>> v2EndpointsGet(
    @retrofit2.http.Query("type") String type
  );

}
