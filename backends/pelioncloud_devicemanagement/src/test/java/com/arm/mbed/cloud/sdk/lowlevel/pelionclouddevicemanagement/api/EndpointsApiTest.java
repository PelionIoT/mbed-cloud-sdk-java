package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

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
     * List the resources on an endpoint.
     *
     * Retrieves resources cached by Device Management Connect. This call does not formulate a message to the device.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v2/endpoints/{device-id} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getEndpointResourcesTest() {
        String deviceId = null;
        // List<Resource> response = api.getEndpointResources(deviceId);

        // TODO: test validations
    }
}
