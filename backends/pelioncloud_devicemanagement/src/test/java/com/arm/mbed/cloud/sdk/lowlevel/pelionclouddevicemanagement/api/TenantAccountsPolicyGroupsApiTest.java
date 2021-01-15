package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsPolicyGroupsApi
 */
public class TenantAccountsPolicyGroupsApiTest {

    private TenantAccountsPolicyGroupsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsPolicyGroupsApi.class);
    }

    /**
     * Add API keys to Account group.
     *
     * Add API keys to account groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addApiKeysToAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addApiKeysToAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Add API keys to account group.
     *
     * Add API keys to account groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys/add \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;apikeys\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addListedApiKeysToAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addListedApiKeysToAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Add applications to account group.
     *
     * Add applications to account groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/applications/add \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;applications\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addListedApplicationsToAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addListedApplicationsToAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Add users to account group.
     *
     * Add users to account group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users/add \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addListedUsersToAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addListedUsersToAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Add members to a group.
     *
     * Add users and API keys to groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addSubjectsToAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addSubjectsToAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Add users to account group.
     *
     * Add users to account group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addUsersToAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addUsersToAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Create a new group.
     *
     * Create a new group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createAccountGroupTest() {
        String accountId = null;
        GroupCreationInfo body = null;
        // GroupSummary response = api.createAccountGroup(accountId, body);

        // TODO: test validations
    }

    /**
     * Delete a group.
     *
     * Delete a group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        // Void response = api.deleteAccountGroup(accountId, groupId);

        // TODO: test validations
    }

    /**
     * Get policy group.
     *
     * Retrieve policy group details. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountGroupSummaryTest() {
        String accountId = null;
        String groupId = null;
        // GroupSummary response = api.getAccountGroupSummary(accountId, groupId);

        // TODO: test validations
    }

    /**
     * Get policy groups.
     *
     * Retrieve an array of policy groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountGroupsTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        // GroupSummaryList response = api.getAllAccountGroups(accountId, limit, after, order, include, nameEq);

        // TODO: test validations
    }

    /**
     * Get API keys in a group.
     *
     * Retrieve an array of API keys associated with a policy group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is
     * restricted to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getApiKeysOfAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // ApiKeyInfoRespList response = api.getApiKeysOfAccountGroup(accountId, groupId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get applications in a group.
     *
     * Retrieve an array of applications associated with a policy group. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/applications \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getApplicationsOfAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // ApplicationList response = api.getApplicationsOfAccountGroup(accountId, groupId, limit, after, order,
        // include);

        // TODO: test validations
    }

    /**
     * Get users in a policy group.
     *
     * Retrieve an array of users associated with a policy group. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted
     * to administrators. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getUsersOfAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        // UserInfoRespList response = api.getUsersOfAccountGroup(accountId, groupId, limit, after, order, include,
        // statusEq, statusIn, statusNin);

        // TODO: test validations
    }

    /**
     * Remove API keys from a group.
     *
     * Remove API keys from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;apikeys\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeApiKeysFromAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeApiKeysFromAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Remove API keys from a group.
     *
     * Remove API keys from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys/remove \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;apikeys\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeListedApiKeysFromAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeListedApiKeysFromAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Remove applications from a group.
     *
     * Remove applications from groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/applications/remove \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;applications\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeListedApplicationsFromAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeListedApplicationsFromAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Remove users from a group.
     *
     * Remove users from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users/remove \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeListedUsersFromAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeListedUsersFromAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Remove users from a group.
     *
     * Remove users from groups. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeUsersFromAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeUsersFromAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Update the group name.
     *
     * Update a group name. &lt;b&gt;Note:&lt;/b&gt; This endpoint is restricted to administrators. **Example:**
     * &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/ \\ -H &#39;Authorization:
     * Bearer &lt;access_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestGroup2\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateAccountGroupNameTest() {
        String accountId = null;
        String groupId = null;
        GroupUpdateInfo body = null;
        // GroupSummary response = api.updateAccountGroupName(accountId, groupId, body);

        // TODO: test validations
    }
}
