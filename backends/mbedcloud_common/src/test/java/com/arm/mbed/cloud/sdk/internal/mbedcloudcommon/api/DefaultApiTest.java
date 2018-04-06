package com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.api;

import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.ApiClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DefaultApi.class);
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void testTest() {
        // Void response = api.test();

        // TODO: test validations
    }
}
