package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * API tests for TenantAccountsApiKeysApi
 */
public class TenantAccountsApiKeysApiTest {

    private TenantAccountsApiKeysApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsApiKeysApi.class);
    }

    /**
     * Add API key to a list of groups.
     *
     * Add API key to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addAccountApiKeyToGroupsTest() {
        String accountId = null;
        String apikeyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.addAccountApiKeyToGroups(accountId, apikeyId, body);

        // TODO: test validations
    }

    /**
     * Create a new API key.
     *
     * Create a new API key. There is no default value for the owner ID, and it must be from the same account where the
     * new API key is created. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;MyKey1\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createAccountApiKeyTest() {
        String accountId = null;
        ApiKeyInfoReq body = null;
        // ApiKeyInfoResp response = api.createAccountApiKey(accountId, body);

        // TODO: test validations
    }

    /**
     * Delete the API key.
     *
     * Delete an API key. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteAccountApiKeyTest() {
        String accountId = null;
        String apikeyId = null;
        // Void response = api.deleteAccountApiKey(accountId, apikeyId);

        // TODO: test validations
    }

    /**
     * Get API key details.
     *
     * Retrieve API key details. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountApiKeyTest() {
        String accountId = null;
        String apikeyId = null;
        // ApiKeyInfoResp response = api.getAccountApiKey(accountId, apikeyId);

        // TODO: test validations
    }

    /**
     * Get all API keys.
     *
     * Retrieve API keys in an array, optionally filtered by the owner. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountApiKeysTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String keyEq = null;
        String ownerEq = null;
        // ApiKeyInfoRespList response = api.getAllAccountApiKeys(accountId, limit, after, order, include, keyEq,
        // ownerEq);

        // TODO: test validations
    }

    /**
     * Get groups associated with the API key.
     *
     * Retrieve groups associated with the API key. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupsOfAccountApikeyTest() {
        String accountId = null;
        String apikeyId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfAccountApikey(accountId, apikeyId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Remove API key from groups.
     *
     * Remove API key from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeAccountApiKeyFromGroupsTest() {
        String accountId = null;
        String apikeyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.removeAccountApiKeyFromGroups(accountId, apikeyId, body);

        // TODO: test validations
    }

    /**
     * Reset the secret key.
     *
     * Reset the secret key of the API key. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void resetAccountApiKeySecretTest() {
        String accountId = null;
        String apikeyId = null;
        // ApiKeyInfoResp response = api.resetAccountApiKeySecret(accountId, apikeyId);

        // TODO: test validations
    }

    /**
     * Update API key details.
     *
     * Update API key details. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApiKey25\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateAccountApiKeyTest() {
        String accountId = null;
        String apikeyId = null;
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateAccountApiKey(accountId, apikeyId, body);

        // TODO: test validations
    }
}
