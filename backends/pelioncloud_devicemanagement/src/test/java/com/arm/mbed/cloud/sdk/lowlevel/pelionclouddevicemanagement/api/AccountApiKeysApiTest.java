package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * API tests for AccountApiKeysApi
 */
public class AccountApiKeysApiTest {

    private AccountApiKeysApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountApiKeysApi.class);
    }

    /**
     * Add API key to a list of groups.
     *
     * Add API key to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addApiKeyToGroupsTest() {
        String apikeyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.addApiKeyToGroups(apikeyId, body);

        // TODO: test validations
    }

    /**
     * Add API key to a list of groups.
     *
     * Add API key to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addMyApiKeyToGroupsTest() {
        List<String> body = null;
        // UpdatedResponse response = api.addMyApiKeyToGroups(body);

        // TODO: test validations
    }

    /**
     * Create a new API key.
     *
     * Create a new API key. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createApiKeyTest() {
        ApiKeyInfoReq body = null;
        // ApiKeyInfoResp response = api.createApiKey(body);

        // TODO: test validations
    }

    /**
     * Delete API key.
     *
     * Delete the API key. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteApiKeyTest() {
        String apikeyId = null;
        // Void response = api.deleteApiKey(apikeyId);

        // TODO: test validations
    }

    /**
     * Get all API keys.
     *
     * Retrieve API keys in an array, optionally filtered by the owner. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/api-keys \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllApiKeysTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String keyEq = null;
        String ownerEq = null;
        // ApiKeyInfoRespList response = api.getAllApiKeys(limit, after, order, include, keyEq, ownerEq);

        // TODO: test validations
    }

    /**
     * Get API key details.
     *
     * Retrieve API key details. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getApiKeyTest() {
        String apikeyId = null;
        // ApiKeyInfoResp response = api.getApiKey(apikeyId);

        // TODO: test validations
    }

    /**
     * Get groups of the API key.
     *
     * Retrieve groups associated with the API key. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupsOfApikeyTest() {
        String apikeyId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfApikey(apikeyId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get groups of the API key.
     *
     * Retrieve groups associated with the API key. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupsOfMyApiKeyTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfMyApiKey(limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get API key details.
     *
     * Retrieve API key details. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getMyApiKeyTest() {
        // ApiKeyInfoResp response = api.getMyApiKey();

        // TODO: test validations
    }

    /**
     * Remove API key from groups.
     *
     * Remove API key from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeApiKeyFromGroupsTest() {
        String apikeyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.removeApiKeyFromGroups(apikeyId, body);

        // TODO: test validations
    }

    /**
     * Remove API key from groups.
     *
     * Remove API key from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeMyApiKeyFromGroupsTest() {
        List<String> body = null;
        // UpdatedResponse response = api.removeMyApiKeyFromGroups(body);

        // TODO: test validations
    }

    /**
     * Update API key details.
     *
     * Update API key details. **Example:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void updateApiKeyTest() {
        String apikeyId = null;
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateApiKey(apikeyId, body);

        // TODO: test validations
    }

    /**
     * Update API key details.
     *
     * Update API key details. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void updateMyApiKeyTest() {
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateMyApiKey(body);

        // TODO: test validations
    }
}
