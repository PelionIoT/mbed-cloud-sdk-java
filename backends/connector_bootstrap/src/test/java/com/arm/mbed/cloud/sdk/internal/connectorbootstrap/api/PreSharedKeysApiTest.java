package com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api;

import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.ApiClient;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKeyWithoutSecret;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PreSharedKeysApi
 */
public class PreSharedKeysApiTest {

    private PreSharedKeysApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(PreSharedKeysApi.class);
    }

    /**
     * Remove a pre-shared key.
     *
     * Remove a pre-shared key.
     */
    @Test
    public void deletePreSharedKeyTest() {
        String endpointName = null;
        // Void response = api.deletePreSharedKey(endpointName);

        // TODO: test validations
    }
    /**
     * Get a pre-shared key.
     *
     * Check if a pre-shared key for an endpoint exists or not. The response does not contain the secret itself. 
     */
    @Test
    public void getPreSharedKeyTest() {
        String endpointName = null;
        // PreSharedKeyWithoutSecret response = api.getPreSharedKey(endpointName);

        // TODO: test validations
    }
    /**
     * Upload a pre-shared key to Mbed Cloud.
     *
     * Upload a pre-shared key (PSK) for an endpoint to allow it to bootstrap. The existing key will not be overwritten but needs to be deleted first in case of re-setting PSK for an endpoint.  **Note**: The PSK APIs are available only to accounts that have this feature enabled.  &#x60;&#x60;&#x60; Example payloads: {\&quot;endpoint_name\&quot;: \&quot;myEndpoint.host.com\&quot;, \&quot;secret_hex\&quot;: \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; } {\&quot;endpoint_name\&quot;: \&quot;myEndpoint.host.com\&quot;, \&quot;secret_hex\&quot;: \&quot;0x4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; } &#x60;&#x60;&#x60; 
     */
    @Test
    public void uploadPreSharedKeyTest() {
        PreSharedKey body = null;
        // Void response = api.uploadPreSharedKey(body);

        // TODO: test validations
    }
}
