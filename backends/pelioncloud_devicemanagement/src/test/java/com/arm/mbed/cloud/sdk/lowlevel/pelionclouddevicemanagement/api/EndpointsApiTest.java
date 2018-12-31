package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Endpoint;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Resource;
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
     * (DEPRECATED) List registered endpoints. The number of returned endpoints is currently limited to 200.
     *
     * Endpoints are physical devices having valid registration to Device Management. All devices regardless of registration status can be requested from Device Directory API [&#39;/v3/devices/&#x60;](/docs/current/service-api-references/device-directory.html).  **Note:** This endpoint is deprecated and will be removed 1Q/18. You should use the Device Directory API [&#x60;/v3/devices/&#x60;](/docs/current/service-api-references/device-directory.html). To list only the registered devices, use filter &#x60;/v3/devices/?filter&#x3D;state%3Dregistered&#x60;.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void getConnectedEndpointsTest() {
        String type = null;
        // List<Endpoint> response = api.getConnectedEndpoints(type);

        // TODO: test validations
    }
    /**
     * List the resources on an endpoint
     *
     * The list of resources is cached by Device Management Connect, so this call does not create a message to the device.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} -H &#39;authorization: Bearer {api-key}&#39; 
     */
    @Test
    public void getEndpointResourcesTest() {
        String deviceId = null;
        // List<Resource> response = api.getEndpointResources(deviceId);

        // TODO: test validations
    }
}
