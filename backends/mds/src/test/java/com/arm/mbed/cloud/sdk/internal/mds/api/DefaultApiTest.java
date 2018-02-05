package com.arm.mbed.cloud.sdk.internal.mds.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.mds.model.Webhook;
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
     * Delete callback URL
     *
     * Deletes the callback URL.  **Example usage:**      curl -X DELETE https://api.us-east-1.mbedcloud.com/v2/notification/callback -H &#39;authorization: Bearer {api-key}&#39;      
     */
    @Test
    public void v2NotificationCallbackDeleteTest() {
        // Void response = api.v2NotificationCallbackDelete();

        // TODO: test validations
    }
    /**
     * Check callback URL
     *
     * Shows the current callback URL if it exists.  **Example usage:**      curl -X GET https://api.us-east-1.mbedcloud.com/v2/notification/callback -H &#39;authorization: Bearer {api-key}&#39;      
     */
    @Test
    public void v2NotificationCallbackGetTest() {
        // Webhook response = api.v2NotificationCallbackGet();

        // TODO: test validations
    }
}
