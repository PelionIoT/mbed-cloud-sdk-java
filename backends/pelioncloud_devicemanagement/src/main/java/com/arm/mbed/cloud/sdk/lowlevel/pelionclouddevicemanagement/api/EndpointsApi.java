package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Endpoint;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Resource;

import java.util.List;

public interface EndpointsApi {
    /**
     * (DEPRECATED) List registered endpoints. The number of returned endpoints is currently limited to 200. Endpoints
     * are physical devices having valid registration to Device Management. All devices regardless of registration
     * status can be requested from Device Directory API
     * [&#39;/v3/devices/&#x60;](/docs/current/service-api-references/device-directory.html). **Note:** This endpoint is
     * deprecated and will be removed 1Q/18. You should use the Device Directory API
     * [&#x60;/v3/devices/&#x60;](/docs/current/service-api-references/device-directory.html). To list only the
     * registered devices, use filter &#x60;/v3/devices/?filter&#x3D;state%3Dregistered&#x60;. **Example usage:** curl
     * -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints -H &#39;authorization: Bearer {api-key}&#39;
     * 
     * @param type
     *            Filter endpoints by endpoint-type. (optional)
     * @return Call&lt;List&lt;Endpoint&gt;&gt;
     */
    @GET("v2/endpoints")
    Call<List<Endpoint>> getConnectedEndpoints(@retrofit2.http.Query("type") String type);

    /**
     * List the resources on an endpoint The list of resources is cached by Device Management Connect, so this call does
     * not create a message to the device. **Example usage:** curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} -H &#39;authorization: Bearer {api-key}&#39;
     * 
     * @param deviceId
     *            A unique device ID for an endpoint. Note that the ID needs to be an exact match. You cannot use
     *            wildcards here. (required)
     * @return Call&lt;List&lt;Resource&gt;&gt;
     */
    @GET("v2/endpoints/{device-id}")
    Call<List<Resource>>
        getEndpointResources(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId);

}
