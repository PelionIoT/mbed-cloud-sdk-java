package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccessKey;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Application;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupIdList;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsApplicationsApi
 */
public class TenantAccountsApplicationsApiTest {

    private TenantAccountsApplicationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsApplicationsApi.class);
    }

    /**
     * Add application to a list of groups.
     *
     * Add application to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/groups/add \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addAccountApplicationToGroupsTest() {
        String accountId = null;
        String applicationId = null;
        GroupIdList body = null;
        // Void response = api.addAccountApplicationToGroups(accountId, applicationId, body);

        // TODO: test validations
    }

    /**
     * Create a new application.
     *
     * Create a new application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications -d
     * &#39;{\&quot;name\&quot;: \&quot;MyApplication1\&quot;}&#39; \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createAccountApplicationTest() {
        String accountId = null;
        Application body = null;
        // Application response = api.createAccountApplication(accountId, body);

        // TODO: test validations
    }

    /**
     * Create a new application access key.
     *
     * Create a new access key for the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys -d
     * &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\
     * -H &#39;content-type: application/json&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createAccountApplicationAccessKeyTest() {
        String accountId = null;
        String applicationId = null;
        AccessKey body = null;
        // AccessKey response = api.createAccountApplicationAccessKey(accountId, applicationId, body);

        // TODO: test validations
    }

    /**
     * Delete application.
     *
     * Delete the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteAccountApplicationTest() {
        String accountId = null;
        String applicationId = null;
        // Void response = api.deleteAccountApplication(accountId, applicationId);

        // TODO: test validations
    }

    /**
     * Delete access key associated with the application.
     *
     * Delete the access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to
     * administrators. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id}
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteAccountApplicationAccessKeyTest() {
        String accountId = null;
        String applicationId = null;
        String accessKeyId = null;
        // Void response = api.deleteAccountApplicationAccessKey(accountId, applicationId, accessKeyId);

        // TODO: test validations
    }

    /**
     * Get application.
     *
     * Retrieve details of an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id} \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountApplicationTest() {
        String accountId = null;
        String applicationId = null;
        // Application response = api.getAccountApplication(accountId, applicationId);

        // TODO: test validations
    }

    /**
     * Get access key.
     *
     * Retrieve details of an access key associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id}
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountApplicationAccessKeyTest() {
        String accountId = null;
        String applicationId = null;
        String accessKeyId = null;
        // AccessKey response = api.getAccountApplicationAccessKey(accountId, applicationId, accessKeyId);

        // TODO: test validations
    }

    /**
     * Get all access keys associated with the application.
     *
     * Retrieve an array of access keys associated with the application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountApplicationAccessKeysTest() {
        String accountId = null;
        String applicationId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        // AccessKeyList response = api.getAllAccountApplicationAccessKeys(accountId, applicationId, limit, after,
        // order, include, statusEq);

        // TODO: test validations
    }

    /**
     * Get all applications.
     *
     * Retrieve an array of applications. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountApplicationsTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        // ApplicationList response = api.getAllAccountApplications(accountId, limit, after, order, include, statusEq);

        // TODO: test validations
    }

    /**
     * Get policy groups of an application.
     *
     * Retrieve an array of policy groups associated with an application. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/groups \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupsOfAccountApplicationTest() {
        String accountId = null;
        String applicationId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfAccountApplication(accountId, applicationId, limit, after, order,
        // include);

        // TODO: test validations
    }

    /**
     * Remove application from groups.
     *
     * Remove application from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/groups/remove \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeAccountApplicationFromGroupsTest() {
        String accountId = null;
        String applicationId = null;
        GroupIdList body = null;
        // Void response = api.removeAccountApplicationFromGroups(accountId, applicationId, body);

        // TODO: test validations
    }

    /**
     * Update application details.
     *
     * Update application details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id} \\
     * -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;name\&quot;: \&quot;TestApplication25\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateAccountApplicationTest() {
        String accountId = null;
        String applicationId = null;
        Application body = null;
        // ApiKeyInfoResp response = api.updateAccountApplication(accountId, applicationId, body);

        // TODO: test validations
    }

    /**
     * Update access key details.
     *
     * Update access key details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/applications/{application_id}/access-keys/{access_key_id}
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;name\&quot;: \&quot;TestAccessKey\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateAccountApplicationAccessKeyTest() {
        String accountId = null;
        String applicationId = null;
        String accessKeyId = null;
        AccessKey body = null;
        // AccessKey response = api.updateAccountApplicationAccessKey(accountId, applicationId, accessKeyId, body);

        // TODO: test validations
    }
}
