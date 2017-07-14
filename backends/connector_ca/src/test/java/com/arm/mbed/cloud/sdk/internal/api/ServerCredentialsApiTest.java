package com.arm.mbed.cloud.sdk.internal.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.model.ServerCredentialsResponseData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServerCredentialsApi
 */
public class ServerCredentialsApiTest {

    private ServerCredentialsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ServerCredentialsApi.class);
    }

    
    /**
     * Fetch bootstrap server credentials.
     *
     * This REST API is intended to be used by customers to fetch bootstrap server credentials that they need to use with their clients to connect to bootstrap server. 
     */
    @Test
    public void v3ServerCredentialsBootstrapGetTest() {
        String authorization = null;
        // ServerCredentialsResponseData response = api.v3ServerCredentialsBootstrapGet(authorization);

        // TODO: test validations
    }
    
    /**
     * Fetch LWM2M server credentials.
     *
     * This REST API is intended to be used by customers to fetch LWM2M server credentials that they need to use with their clients to connect to LWM2M server. 
     */
    @Test
    public void v3ServerCredentialsLwm2mGetTest() {
        String authorization = null;
        // ServerCredentialsResponseData response = api.v3ServerCredentialsLwm2mGet(authorization);

        // TODO: test validations
    }
    
}
