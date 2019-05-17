package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Resource;

import java.util.List;

public interface EndpointsApi {
    /**
     * List the resources on an endpoint. Retrieves resources cached by Device Management Connect. This call does not
     * formulate a message to the device. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            A unique device ID for an endpoint. The ID must be an exact match. Do not use wildcards. (required)
     * @return Call&lt;List&lt;Resource&gt;&gt;
     */
    @GET("v2/endpoints/{device-id}")
    Call<List<Resource>>
        getEndpointResources(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId);

}
