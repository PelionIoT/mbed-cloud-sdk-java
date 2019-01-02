package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PreSharedKey;
import org.junit.Before;
import org.junit.Test;

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
     * Remove a pre-shared key. **Example usage:** &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer
     * ${API_TOKEN}\&quot; -X DELETE https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001
     * &#x60;&#x60;&#x60;
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
     * **Example usage:** &#x60;&#x60;&#x60; curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot;
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys/my-endpoint-0001 &#x60;&#x60;&#x60;
     */
    @Test
    public void getPreSharedKeyTest() {
        String endpointName = null;
        // PreSharedKeyWithoutSecret response = api.getPreSharedKey(endpointName);

        // TODO: test validations
    }

    /**
     * List pre-shared keys.
     *
     * List pre-shared keys with pagination and default page size of 50 entries. **Example usage:** &#x60;&#x60;&#x60;
     * curl -H \&quot;authorization: Bearer ${API_TOKEN}\&quot;
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys &#x60;&#x60;&#x60;
     */
    @Test
    public void listPreSharedKeysTest() {
        Integer limit = null;
        String after = null;
        // ListOfPreSharedKeysWithoutSecret response = api.listPreSharedKeys(limit, after);

        // TODO: test validations
    }

    /**
     * Upload a pre-shared key to Pelion Device Management.
     *
     * Upload a pre-shared key (PSK) for an endpoint to allow it to bootstrap. The existing key will not be overwritten
     * but needs to be deleted first in case of re-setting PSK for an endpoint. **Note**: The PSK APIs are available
     * only to accounts that have this feature enabled. **Example usage:** &#x60;&#x60;&#x60; curl -H
     * \&quot;authorization: Bearer ${API_TOKEN}\&quot; -H \&quot;content-type: application/json\&quot; -X POST
     * https://api.us-east-1.mbedcloud.com/v2/device-shared-keys \\ -d &#39;{\&quot;endpoint_name\&quot;:
     * \&quot;my-endpoint-0001\&quot;, \&quot;secret_hex\&quot;: \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; }&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadPreSharedKeyTest() {
        PreSharedKey body = null;
        // Void response = api.uploadPreSharedKey(body);

        // TODO: test validations
    }
}
