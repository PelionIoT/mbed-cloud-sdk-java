package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountPolicyGroupsApi
 */
public class AccountPolicyGroupsApiTest {

    private AccountPolicyGroupsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountPolicyGroupsApi.class);
    }

    /**
     * Add API keys to the group.
     *
     * Add API keys to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addApiKeysToGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addApiKeysToGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Add API Keys to the group.
     *
     * Add API keys to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addListedApiKeysToGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addListedApiKeysToGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Add users to the group.
     *
     * Add users to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users/add \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addListedUsersToGroup_Test() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addListedUsersToGroup_(groupId, body);

        // TODO: test validations
    }

    /**
     * Add members to a group.
     *
     * Add users and API keys to a group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addSubjectsToGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addSubjectsToGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Add users to the group.
     *
     * Add users to the group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void addUsersToGroup_Test() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.addUsersToGroup_(groupId, body);

        // TODO: test validations
    }

    /**
     * Create a new group.
     *
     * Create a new group. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void createGroupTest() {
        GroupCreationInfo body = null;
        // GroupSummary response = api.createGroup(body);

        // TODO: test validations
    }

    /**
     * Delete a group.
     *
     * Delete a group. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteGroupTest() {
        String groupId = null;
        // Void response = api.deleteGroup(groupId);

        // TODO: test validations
    }

    /**
     * Get all group information.
     *
     * Retrieve all group information. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllGroupsTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        // GroupSummaryList response = api.getAllGroups(limit, after, order, include, nameEq);

        // TODO: test validations
    }

    /**
     * Get the API keys of a group.
     *
     * Manage policy groups. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getApiKeysOfGroupTest() {
        String groupId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // ApiKeyInfoRespList response = api.getApiKeysOfGroup(groupId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get group information.
     *
     * Retrieve general information about a group. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupSummaryTest() {
        String groupId = null;
        // GroupSummary response = api.getGroupSummary(groupId);

        // TODO: test validations
    }

    /**
     * Get users of a group.
     *
     * Retrieve users of a group with details. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getUsersOfGroupTest() {
        String groupId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        // UserInfoRespList response = api.getUsersOfGroup(groupId, limit, after, order, include, statusEq, statusIn,
        // statusNin);

        // TODO: test validations
    }

    /**
     * Remove API keys from a group.
     *
     * Remove API keys from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeApiKeysFromGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeApiKeysFromGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Remove API keys from a group.
     *
     * Remove API keys from groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys/remove \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeListedApiKeysFromGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeListedApiKeysFromGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Remove users from a group.
     *
     * Manage policy groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users/remove \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeListedUsersFromGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeListedUsersFromGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Remove users from a group.
     *
     * Manage policy groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeUsersFromGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // GroupSummary response = api.removeUsersFromGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Update the group name.
     *
     * Update a group name. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;name\&quot;:
     * \&quot;TestGroup2\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateGroupNameTest() {
        String groupId = null;
        GroupUpdateInfo body = null;
        // GroupSummary response = api.updateGroupName(groupId, body);

        // TODO: test validations
    }
}
