package com.arm.mbed.cloud.sdk.internal.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.model.AsyncID;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ResourcesApi
 */
public class ResourcesApiTest {

    private ResourcesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ResourcesApi.class);
    }

    
    /**
     * Delete a resource
     *
     * A request to delete a resource must be handled by both mbed Cloud Client and mbed Cloud Connect. The resource is not deleted from mbed Cloud Connect until the delete is handled by mbed Cloud Client.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to mbed Cloud Connect. 
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathDeleteTest() {
        String deviceId = null;
        String resourcePath = null;
        Boolean noResp = null;
        // AsyncID response = api.v2EndpointsDeviceIdResourcePathDelete(deviceId, resourcePath, noResp);

        // TODO: test validations
    }
    
    /**
     * Read from a resource
     *
     * Requests the resource value and when the response is available, a json AsycResponse  object (AsyncIDResponse object) is received in the notification channel. Note that you can also  receive notifications when a resource changes. The preferred way to get resource values is to use subscribe  and callback methods.  All resource APIs are asynchronous. These APIs will only respond  if the device is turned on and connected to mbed Cloud Connect. 
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathGetTest() {
        String deviceId = null;
        String resourcePath = null;
        Boolean cacheOnly = null;
        Boolean noResp = null;
        // AsyncID response = api.v2EndpointsDeviceIdResourcePathGet(deviceId, resourcePath, cacheOnly, noResp);

        // TODO: test validations
    }
    
    /**
     * Execute a function on a resource
     *
     * With this API, you can execute a function on an existing resource.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to mbed Cloud Connect. 
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathPostTest() {
        String deviceId = null;
        String resourcePath = null;
        String resourceFunction = null;
        Boolean noResp = null;
        // AsyncID response = api.v2EndpointsDeviceIdResourcePathPost(deviceId, resourcePath, resourceFunction, noResp);

        // TODO: test validations
    }
    
    /**
     * Write to a resource
     *
     * With this API, you can write new values to existing resources, or create new  resources on the device. The resource-path does not have to exist - it can be  created by the call. The maximum length of resource-path is 255 characters.  This API can also be used to transfer files to the device. mbed Cloud Connect LWM2M server implements the Option 1 from RFC7959. The maximum block size is 1024 bytes. The block size versus transferred file size is something to note in low quality networks. The customer application needs to know what type of file is transferred (for example txt) and the payload can be encrypted by the customer. The maximum size of payload is 1048576 bytes.  All resource APIs are asynchronous. These APIs respond only if the device is turned on and connected to mbed Cloud Connect. 
     */
    @Test
    public void v2EndpointsDeviceIdResourcePathPutTest() {
        String deviceId = null;
        String resourcePath = null;
        String resourceValue = null;
        Boolean noResp = null;
        // AsyncID response = api.v2EndpointsDeviceIdResourcePathPut(deviceId, resourcePath, resourceValue, noResp);

        // TODO: test validations
    }
    
}
