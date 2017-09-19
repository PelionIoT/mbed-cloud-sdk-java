package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.mds.model.Endpoint;
import com.arm.mbed.cloud.sdk.internal.mds.model.Resource;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EndpointsApi
 */
public class EndpointsApiTest {

    private EndpointsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(EndpointsApi.class);
    }

    
    /**
     * List the resources on an endpoint
     *
     * The list of resources is cached by mbed Cloud Connect, so this call does not create a message to the device.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void v2EndpointsDeviceIdGetTest() {
        String deviceId = null;
        // List<Resource> response = api.v2EndpointsDeviceIdGet(deviceId);

        // TODO: test validations
    }
    
    /**
     * List registered endpoints. The number of returned endpoints is currently limited to 200.
     *
     * Endpoints are physical devices having valid registration to mbed Cloud Connect. All devices regardless of registration status can be requested from Device Directory API [&#39;/v3/devices/&#x60;](/docs/v1.2/api-references/device-directory-api.html#v3-devices).  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void v2EndpointsGetTest() {
        String type = null;
        // List<Endpoint> response = api.v2EndpointsGet(type);

        // TODO: test validations
    }
    
}
