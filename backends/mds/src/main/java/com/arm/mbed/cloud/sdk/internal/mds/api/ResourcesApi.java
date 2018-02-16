package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ResourcesApi {
  /**
   * Delete a resource
   * A request to delete a resource must be handled by both Mbed Cloud Client and Mbed Cloud Connect. The resource is not deleted from Mbed Cloud Connect until the request is handled by Mbed Cloud Client.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**      curl -X DELETE \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39; 
   * @param deviceId A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath The URL of the resource.  (required)
   * @param noResp &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code &#x60;409 Conflict&#x60;.  (optional)
   * @return Call&lt;AsyncID&gt;
   */
  @DELETE("v2/endpoints/{device-id}/{resourcePath}")
  Call<AsyncID> v2EndpointsDeviceIdResourcePathDelete(
    @retrofit2.http.Path(value = "device-id", encoded = true) String deviceId, @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath, @retrofit2.http.Query("noResp") Boolean noResp
  );

  /**
   * Read from a resource
   * Requests the resource value and when the response is available, an &#x60;AsyncIDResponse&#x60; json object is received in the notification channel. The preferred way to get resource values is to use [subscribe](/docs/v1.2/service-api-references/connect-api.html#v2-notification-callback) and [callback](/docs/v1.2/service-api-references/connect-api.html#v2-notification-callback) methods. See more about [reading from a resource](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-read-operation).  All resource APIs are asynchronous. These APIs only respond if the device is turned on and connected to Mbed Cloud Connect.  Please refer to [Lightweigth Machine to Machine Technical specification](http://www.openmobilealliance.org/release/LightweightM2M/V1_0-20170208-A/OMA-TS-LightweightM2M-V1_0-20170208-A.pdf) for more inforamtion.  **Example usage:**      curl -X GET \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\       -H &#39;authorization: Bearer {api-key}&#39;        
   * @param deviceId Unique Mbed Cloud device ID for the endpoint. Note that the ID needs to be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath The URL of the resource.  (required)
   * @param cacheOnly If true, the response comes only from the cache. Default: false. Mbed Cloud Connect caches the received resource values for the time of [max_age](/docs/v1.2/collecting/working-with-the-resources.html#working-with-the-server-cache) defined in the client side.  (optional)
   * @param noResp &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter &#x60;noResp&#x60;. If a request is made with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP  non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back  an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol  does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code  &#x60;409 Conflict&#x60;.  (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("v2/endpoints/{device-id}/{resourcePath}")
  Call<Void> v2EndpointsDeviceIdResourcePathGet(
    @retrofit2.http.Path(value = "device-id", encoded = true) String deviceId, @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath, @retrofit2.http.Query("cacheOnly") Boolean cacheOnly, @retrofit2.http.Query("noResp") Boolean noResp
  );

  /**
   * Execute a function on a Resource or create new Object instance
   * With this API, you can [execute a function](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-execute-operation)  on an existing resource and create new Object instance to the device. The resource-path does not have to exist - it can be  created by the call. The maximum length of resource-path is 255 characters.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**  This example resets the min and max values of the [temperature sensor](http://www.openmobilealliance.org/tech/profiles/lwm2m/3303.xml) instance 0 by executing the Resource 5605 &#39;Reset Min and Max Measured Values&#39;.          curl -X POST \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3303/0/5605 \\       -H &#39;authorization: Bearer {api-key}&#39; 
   * @param deviceId A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath The URL of the resource. (required)
   * @param resourceFunction This value is not needed. Most of the time resources do not accept a function but they have their own functions predefined. You can use this to trigger them.  If a function is included, the body of this request is passed as a char* to the function in Mbed Cloud Client.  (optional)
   * @param noResp &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code &#x60;409 Conflict&#x60;.  (optional)
   * @return Call&lt;AsyncID&gt;
   */
  @Headers({
    "Content-Type:application/vnd.oma.lwm2m+json"
  })
  @POST("v2/endpoints/{device-id}/{resourcePath}")
  Call<AsyncID> v2EndpointsDeviceIdResourcePathPost(
    @retrofit2.http.Path(value = "device-id", encoded = true) String deviceId, @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath, @retrofit2.http.Body String resourceFunction, @retrofit2.http.Query("noResp") Boolean noResp
  );

  /**
   * Write to a resource or use write-attributes for a resource
   * With this API, you can [write a new value to existing resources](/docs/v1.2/collecting/handling-resources-from-a-web-application.html#the-write-operation) or [use the write-attributes](/docs/v1.2/collecting/subscribing-to-resource-changes-from-a-web-application.html#notification-rules) for a resource.  This API can also be used to transfer files to the device. Mbed Cloud Connect LwM2M server implements the Option 1 from RFC7959. The maximum block size is 1024 bytes. The block size versus transferred file size is something to note in low quality networks. The customer application needs to know what type of file is transferred (for example txt) and the payload can be encrypted by the customer. The maximum size of payload is 1048576 bytes.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to Mbed Cloud Connect and there is an active notification channel.  **Example usage:**  This example sets the alarm on a buzzer. The command writes the [Buzzer](http://www.openmobilealliance.org/tech/profiles/lwm2m/3338.xml) instance 0, \&quot;On/Off\&quot; boolean resource to &#39;1&#39;.      curl -X PUT \\       https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3338/0/5850 -H \&quot;content-type: text/plain\&quot; \\       -H &#39;authorization: Bearer {api-key}&#39; -d &#39;1&#39; 
   * @param deviceId A unique Mbed Cloud device ID for the endpoint. Note that the ID must be an exact match. You cannot use wildcards here.  (required)
   * @param resourcePath Resource URL. (required)
   * @param resourceValue The value to be set to the resource.  (required)
   * @param noResp &lt;br/&gt;&lt;br/&gt;&lt;b&gt;Non-confirmable requests&lt;/b&gt;&lt;br/&gt;  All resource APIs have the parameter noResp. If you make a request with &#x60;noResp&#x3D;true&#x60;, Mbed Cloud Connect makes a CoAP non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and you do not get back an async-response-id.  If calls with this parameter enabled succeed, they return with the status code &#x60;204 No Content&#x60;. If the underlying protocol does not support non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code &#x60;409 Conflict&#x60;.  (optional)
   * @return Call&lt;AsyncID&gt;
   */
  @Headers({
    "Content-Type:application/vnd.oma.lwm2m+json"
  })
  @PUT("v2/endpoints/{device-id}/{resourcePath}")
  Call<AsyncID> v2EndpointsDeviceIdResourcePathPut(
    @retrofit2.http.Path(value = "device-id", encoded = true) String deviceId, @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath, @retrofit2.http.Body String resourceValue, @retrofit2.http.Query("noResp") Boolean noResp
  );

}
