package com.arm.mbed.cloud.sdk.internal.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.model.Endpoint;
import com.arm.mbed.cloud.sdk.internal.model.Resource;
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
     * The list of resources is cached by mbed Cloud Connect, so this call does not create a message to the device. 
     */
    @Test
    public void v2EndpointsDeviceIdGetTest() {
        String deviceId = null;
        // List<Resource> response = api.v2EndpointsDeviceIdGet(deviceId);

        // TODO: test validations
    }
    
    /**
     * List endpoints. The number of endpoints is currently limited to 200.
     *
     * Endpoints are physical devices running mbed Cloud Client. 
     */
    @Test
    public void v2EndpointsGetTest() {
        String type = null;
        // List<Endpoint> response = api.v2EndpointsGet(type);

        // TODO: test validations
    }
    
}
