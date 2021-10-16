package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountAccessKeysApi
 */
public class AccountAccessKeysApiTest {

    private AccountAccessKeysApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountAccessKeysApi.class);
    }

    /**
     * Get access key.
     *
     * Retrieve details of an access key. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/access-keys/{access_key_id} \\
     * -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccessKeyTest() {
        String accessKeyId = null;
        // AccessKey response = api.getAccessKey(accessKeyId);

        // TODO: test validations
    }

    /**
     * Get all access keys.
     *
     * Retrieve an array of access keys. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/access-keys \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccessKeysTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        String applicationIdEq = null;
        // AccessKeyList response = api.getAllAccessKeys(limit, after, order, include, statusEq, applicationIdEq);

        // TODO: test validations
    }
}
