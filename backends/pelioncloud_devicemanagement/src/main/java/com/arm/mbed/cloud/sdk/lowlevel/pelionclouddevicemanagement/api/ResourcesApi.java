package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AsyncID;

public interface ResourcesApi {
    /**
     * (DEPRECATED) Delete a resource path. (DEPRECATED) A request to delete a resource path must be handled by both
     * Device Management Client and Device Management Connect. All resource APIs are asynchronous. These APIs respond
     * only if the device is on and connected to Device Management Connect, and there is an active notification channel.
     * **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            A unique Device Management device ID for the endpoint. The ID must be an exact match. Do not use
     *            wildcards. (required)
     * @param resourcePath
     *            The resource URL. (required)
     * @param noResp
     *            If you make a request with &#x60;noResp&#x3D;true&#x60;, Device Management Connect makes a CoAP
     *            non-confirmable request to the device. Such requests are not guaranteed to arrive at the device, and
     *            do not return an async-response-id. If calls with this parameter enabled succeed, they return with the
     *            status code &#x60;204 No Content&#x60;. If the underlying protocol does not support non-confirmable
     *            requests, or if the endpoint is registered in queue mode, the response is status code &#x60;409
     *            Conflict&#x60;. (optional)
     * @return Call&lt;AsyncID&gt;
     */
    @DELETE("v2/endpoints/{device-id}/{resourcePath}")
    Call<AsyncID> deleteResourcePath(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId,
                                     @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath,
                                     @retrofit2.http.Query("noResp") Boolean noResp);

    /**
     * (DEPRECATED) Execute a function on a Resource or create new Object instance. (DEPRECATED) [Execute a
     * function](../connecting/handle-resource-webapp.html#the-execute-operation) on an existing resource and create a
     * new Object instance on the device. The resource path does not have to exist; you can set it with the call. The
     * maximum length of the resource path is 255 characters. All resource APIs are asynchronous. These APIs respond
     * only if the device is on and connected to Device Management Connect, and there is an active notification channel.
     * Supported content types depend on the device and its resource. Device Management translates HTTP to the
     * equivalent CoAP content type. **Example:** This example resets the min and max values of the [temperature
     * sensor](http://www.openmobilealliance.org/tech/profiles/lwm2m/3303.xml) instance 0 by executing Resource 5605
     * &#39;Reset Min and Max Measured Values&#39;. &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3303/0/5605 \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            A unique Device Management device ID for the endpoint. The ID must be an exact match. Do not use
     *            wildcards. (required)
     * @param resourcePath
     *            The resource URL. (required)
     * @param resourceFunction
     *            This value is not needed. Most of the time, resources do not accept a function but they have their own
     *            functions predefined. You can use this to trigger them. If a function is included, the body of this
     *            request is passed as a char* to the function in Device Management Client. (optional)
     * @param noResp
     *            If you make a request with &#x60;noResp&#x3D;true&#x60;, Device Management Connect makes a CoAP
     *            non-confirmable request to the device. Such requests are not guaranteed to arrive in the device, and
     *            you do not get back an async-response-id. If calls with this parameter enabled succeed, they return
     *            with the status code &#x60;204 No Content&#x60;. If the underlying protocol does not support
     *            non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code
     *            &#x60;409 Conflict&#x60;. (optional)
     * @return Call&lt;AsyncID&gt;
     */
    @Headers({ "Content-Type:application/vnd.oma.lwm2m+json" })
    @POST("v2/endpoints/{device-id}/{resourcePath}")
    Call<AsyncID>
        executeOrCreateResource(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId,
                                @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath,
                                @retrofit2.http.Body String resourceFunction,
                                @retrofit2.http.Query("noResp") Boolean noResp);

    /**
     * (DEPRECATED) Read from a resource. (DEPRECATED) Requests the resource value either from the device or cache. If
     * the value is not in the cache, the request goes all the way to the device. When the response is available, an
     * &#x60;AsyncIDResponse&#x60; JSON object is received in the notification channel. The resource values can be also
     * in cache based on &#x60;max_age&#x60; defined by the device side. The value found from the cache is returned
     * immediately in the response. The preferred way to get resource values is to use the **subscribe** and
     * **callback** methods. All resource APIs are asynchronous. These APIs only respond if the device is on and
     * connected to Device Management. See also how [resource
     * caching](../connecting/device-guidelines.html#resource-cache) works. Please refer to [Lightweight Machine to
     * Machine Technical
     * specification](http://www.openmobilealliance.org/release/LightweightM2M/V1_0-20170208-A/OMA-TS-LightweightM2M-V1_0-20170208-A.pdf)
     * for more inforamtion. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/{resourcePath} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            Unique Device Management device ID for the endpoint. The ID must be an exact match. Do not use
     *            wildcards. (required)
     * @param resourcePath
     *            The resource URL. (required)
     * @param cacheOnly
     *            If true, the response comes only from the cache. Default: false. Device Management Connect caches the
     *            received resource values for the time of [max_age](../connecting/working-with-the-resources.html)
     *            defined in the client side. (optional)
     * @param noResp
     *            If a request is made with &#x60;noResp&#x3D;true&#x60;, Device Management Connect makes a CoAP
     *            non-confirmable request to the device. Such requests are not guaranteed to arrive on the device, and
     *            no &#x60;async-response-id&#x60; returns. Successful calls return with the status code &#x60;204 No
     *            Content&#x60;. If the underlying protocol does not support non-confirmable requests, or if the
     *            endpoint is registered in queue mode, the response is status code &#x60;409 Conflict&#x60;. (optional)
     * @return Call&lt;Void&gt;
     */
    @GET("v2/endpoints/{device-id}/{resourcePath}")
    Call<Void> getResourceValue(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId,
                                @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath,
                                @retrofit2.http.Query("cacheOnly") Boolean cacheOnly,
                                @retrofit2.http.Query("noResp") Boolean noResp);

    /**
     * (DEPRECATED) Write to a Resource or use write-attributes (notification rules) for a Resource. (DEPRECATED) With
     * this API, you can [write a new value to existing Resources](../connecting/handle-resource-webapp.html) or use the
     * **write** attribute to set [notification rules](../connecting/resource-change-webapp.html#notification-rules) for
     * the Resources. The notification rules only work on the device client side and may not be supported by all
     * clients. This API can also be used to transfer files to the device. Device Management Connect LwM2M server
     * implements Option 1 from RFC7959. The maximum block size is 1024 bytes. Note block size versus transferred file
     * size in low-quality networks. The customer application needs to know what type of file is transferred (for
     * example, TXT) and the customer can encrypt the payload. The maximum payload size is 1048576 bytes. All resource
     * APIs are asynchronous. These APIs respond only if the device is on and connected to Device Management Connect,
     * and there is an active notification channel. Supported content types depend on the device and its resource.
     * Device Management translates HTTP to equivalent CoAP content type. **Example:** This example sets the alarm on a
     * buzzer. The command writes the [Buzzer](http://www.openmobilealliance.org/tech/profiles/lwm2m/3338.xml) instance
     * 0, \&quot;On/Off\&quot; boolean resource to &#39;1&#39;. &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id}/3338/0/5850 \\ -H \&quot;content-type:
     * text/plain\&quot; \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -d &#39;1&#39; &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            A unique Device Management device ID for the endpoint. The ID must be an exact match. Do not use
     *            wildcards. (required)
     * @param resourcePath
     *            Resource URL. (required)
     * @param resourceValue
     *            The value to set to the resource. (required)
     * @param noResp
     *            If you make a request with &#x60;noResp&#x3D;true&#x60;, Device Management Connect makes a CoAP
     *            non-confirmable request to the device. Such requests are not guaranteed to arrive to the device, and
     *            do not return an &#x60;async_response_id&#x60;. If a call with this parameter enabled succeeds, it
     *            return status code &#x60;204 No Content&#x60;. If the underlying protocol does not support
     *            non-confirmable requests, or if the endpoint is registered in queue mode, the response is status code
     *            &#x60;409 Conflict&#x60;. (optional)
     * @return Call&lt;AsyncID&gt;
     */
    @Headers({ "Content-Type:application/vnd.oma.lwm2m+json" })
    @PUT("v2/endpoints/{device-id}/{resourcePath}")
    Call<AsyncID> updateResourceValue(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId,
                                      @retrofit2.http.Path(value = "resourcePath", encoded = true) String resourcePath,
                                      @retrofit2.http.Body String resourceValue,
                                      @retrofit2.http.Query("noResp") Boolean noResp);

}
