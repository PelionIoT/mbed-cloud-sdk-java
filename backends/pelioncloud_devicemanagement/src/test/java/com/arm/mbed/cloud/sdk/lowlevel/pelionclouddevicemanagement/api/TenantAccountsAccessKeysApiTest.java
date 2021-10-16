package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsAccessKeysApi
 */
public class TenantAccountsAccessKeysApiTest {

    private TenantAccountsAccessKeysApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsAccessKeysApi.class);
    }

    /**
     * Get access key.
     *
     * Retrieve details of an access key. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/access-keys/{access_key_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountAccessKeyTest() {
        String accountId = null;
        String accessKeyId = null;
        // AccessKey response = api.getAccountAccessKey(accountId, accessKeyId);

        // TODO: test validations
    }

    /**
     * Get all access keys.
     *
     * Retrieve an array of access keys. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/access-keys \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountAccessKeysTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        String applicationIdEq = null;
        // AccessKeyList response = api.getAllAccountAccessKeys(accountId, limit, after, order, include, statusEq,
        // applicationIdEq);

        // TODO: test validations
    }
}
