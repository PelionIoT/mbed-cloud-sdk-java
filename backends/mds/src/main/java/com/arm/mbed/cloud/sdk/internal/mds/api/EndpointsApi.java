package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;



import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.mds.model.Endpoint;
import com.arm.mbed.cloud.sdk.internal.mds.model.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface EndpointsApi {
  /**
   * List the resources on an endpoint
   * The list of resources is cached by Mbed Cloud Connect, so this call does not create a message to the device.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} -H &#39;authorization: Bearer {api-key}&#39;      
   * @param deviceId A unique Mbed Cloud device ID for an endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here.  (required)
   * @return Call&lt;List&lt;Resource&gt;&gt;
   */
  @GET("v2/endpoints/{device-id}")
  Call<List<Resource>> v2EndpointsDeviceIdGet(
    @retrofit2.http.Path(value = "device-id", encoded = true) String deviceId
  );

  /**
   * (DEPRECATED) List registered endpoints. The number of returned endpoints is currently limited to 200.
   * Endpoints are physical devices having valid registration to Mbed Cloud Connect. All devices regardless of registration status can be requested from Device Directory API [&#39;/v3/devices/&#x60;](/docs/v1.2/service-api-references/device-directory-api.html#v3-devices).  **Note:** This endpoint is deprecated and will be removed 1Q/18. You should use the Device Directory API [&#x60;/v3/devices/&#x60;](/docs/v1.2/service-api-references/device-directory-api.html#v3-devices). To list only the registered devices, use filter &#x60;/v3/devices/?filter&#x3D;state%3Dregistered&#x60;.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints -H &#39;authorization: Bearer {api-key}&#39;      
   * @param type Filter endpoints by endpoint-type. (optional)
   * @return Call&lt;List&lt;Endpoint&gt;&gt;
   */
  @GET("v2/endpoints")
  Call<List<Endpoint>> v2EndpointsGet(
    @retrofit2.http.Query("type") String type
  );

}
