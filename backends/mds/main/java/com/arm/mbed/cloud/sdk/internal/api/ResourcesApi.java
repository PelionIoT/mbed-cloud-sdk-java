package com.arm.mbed.cloud.sdk.internal.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.model.AsyncID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ResourcesApi {
  /**
   * Delete a resource
   * A request to delete a resource must be handled by both mbed Cloud Client and mbed Cloud Connect. The resource is not deleted from mbed Cloud Connect until the delete is handled by mbed Cloud Client.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to mbed Cloud Connect. 
   * @param deviceId A unique mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath The URL of the resource.  (required)
   * @param noResp **Non-confirmable requests**  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code 204 No Content. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code 409 Conflict.  (optional)
   * @return Call&lt;AsyncID&gt;
   */
  
  @DELETE("v2/endpoints/{device-id}/{resourcePath}")
  Call<AsyncID> v2EndpointsDeviceIdResourcePathDelete(
    @retrofit2.http.Path("device-id") String deviceId, @retrofit2.http.Path("resourcePath") String resourcePath, @retrofit2.http.Query("noResp") Boolean noResp
  );

  /**
   * Read from a resource
   * Requests the resource value and when the response is available, a json AsycResponse  object (AsyncIDResponse object) is received in the notification channel. Note that you can also  receive notifications when a resource changes. The preferred way to get resource values is to use subscribe  and callback methods.  All resource APIs are asynchronous. These APIs will only respond  if the device is turned on and connected to mbed Cloud Connect. 
   * @param deviceId Unique mbed Cloud device ID for the endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath The URL of the resource.  (required)
   * @param cacheOnly If true, the response comes only from the cache. Default: false.  (optional)
   * @param noResp **Non-confirmable requests**   All resource APIs have the parameter &#x60;noResp&#x60;. If a request is made with &#x60;noResp&#x3D;true&#x60;, mbed Cloud Connect makes a CoAP  non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back  an async-response-id.  If calls with this parameter enabled succeed, they return with the status code 204 No Content. If the underlying protocol  does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code  409 Conflict.  (optional)
   * @return Call&lt;AsyncID&gt;
   */
  
  @GET("v2/endpoints/{device-id}/{resourcePath}")
  Call<AsyncID> v2EndpointsDeviceIdResourcePathGet(
    @retrofit2.http.Path("device-id") String deviceId, @retrofit2.http.Path("resourcePath") String resourcePath, @retrofit2.http.Query("cacheOnly") Boolean cacheOnly, @retrofit2.http.Query("noResp") Boolean noResp
  );

  /**
   * Execute a function on a resource
   * With this API, you can execute a function on an existing resource.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to mbed Cloud Connect. 
   * @param deviceId A unique mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath The URL of the resource. (required)
   * @param resourceFunction This value is not needed. Most of the time resources do not accept a function but they have their own functions predefined. You can use this to trigger them.  If a function is included, the body of this request is passed as a char* to the function in mbed Cloud Client.  (optional)
   * @param noResp **Non-confirmable requests**  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code 204 No Content. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code 409 Conflict.  (optional)
   * @return Call&lt;AsyncID&gt;
   */
  
  @Headers({
  	"Content-Type:application/vnd.oma.lwm2m+json" 
  })
  @POST("v2/endpoints/{device-id}/{resourcePath}")
  Call<AsyncID> v2EndpointsDeviceIdResourcePathPost(
    @retrofit2.http.Path("device-id") String deviceId, @retrofit2.http.Path("resourcePath") String resourcePath, @retrofit2.http.Body String resourceFunction, @retrofit2.http.Query("noResp") Boolean noResp
  );

  /**
   * Write to a resource
   * With this API, you can write new values to existing resources, or create new  resources on the device. The resource-path does not have to exist - it can be  created by the call. The maximum length of resource-path is 255 characters.  This API can also be used to transfer files to the device. mbed Cloud Connect LWM2M server implements the Option 1 from RFC7959. The maximum block size is 1024 bytes. The block size versus transferred file size is something to note in low quality networks. The customer application needs to know what type of file is transferred (for example txt) and the payload can be encrypted by the customer. The maximum size of payload is 1048576 bytes.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to mbed Cloud Connect. 
   * @param deviceId A unique mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath Resource URL. (required)
   * @param resourceValue The value to be set to the resource. (Check accceptable content-types)  (required)
   * @param noResp **Non-confirmable requests**  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code 204 No Content. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code 409 Conflict.  (optional)
   * @return Call&lt;AsyncID&gt;
   */
  
  @Headers({
  	"Content-Type:application/vnd.oma.lwm2m+json" 
  })
  @PUT("v2/endpoints/{device-id}/{resourcePath}")
  Call<AsyncID> v2EndpointsDeviceIdResourcePathPut(
    @retrofit2.http.Path("device-id") String deviceId, @retrofit2.http.Path("resourcePath") String resourcePath, @retrofit2.http.Body String resourceValue, @retrofit2.http.Query("noResp") Boolean noResp
  );

}
