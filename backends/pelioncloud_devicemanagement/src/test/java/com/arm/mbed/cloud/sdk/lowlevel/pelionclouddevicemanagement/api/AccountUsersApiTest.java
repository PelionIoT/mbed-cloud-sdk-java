package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupIdList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * API tests for AccountUsersApi
 */
public class AccountUsersApiTest {

    private AccountUsersApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountUsersApi.class);
    }

    /**
     * Add user to a list of groups.
     *
     * Add user to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addUserToGroupsTest() {
        String userId = null;
        List<String> body = null;
        // UserInfoResp response = api.addUserToGroups(userId, body);

        // TODO: test validations
    }

    /**
     * Add user to a list of groups.
     *
     * Add user to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups/add \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addUserToListedGroupsTest() {
        String userId = null;
        GroupIdList body = null;
        // UserInfoResp response = api.addUserToListedGroups(userId, body);

        // TODO: test validations
    }

    /**
     * Create a new user.
     *
     * Create or invite a new user to the account. Only email address is used; other attributes are set in the second
     * step. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users?action&#x3D;invite \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} &#x60;&#x60;&#x60;
     */
    @Test
    public void createUserTest() {
        UserInfoReq body = null;
        String action = null;
        // UserInfoResp response = api.createUser(body, action);

        // TODO: test validations
    }

    /**
     * Delete a user.
     *
     * Delete a user. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteUserTest() {
        String userId = null;
        // Void response = api.deleteUser(userId);

        // TODO: test validations
    }

    /**
     * Get the details of all users.
     *
     * Retrieve the details of all users. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/users \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllUsersTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String emailEq = null;
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        String loginProfilesEq = null;
        // UserInfoRespList response = api.getAllUsers(limit, after, order, include, emailEq, statusEq, statusIn,
        // statusNin, loginProfilesEq);

        // TODO: test validations
    }

    /**
     * Get groups of the user.
     *
     * Retrieve groups of the user. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupsOfUserTest() {
        String userId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfUser(userId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Details of the current user.
     *
     * Retrieve the details of the logged-in user.
     */
    @Test
    public void getMyUserTest() {
        String scratchCodes = null;
        String properties = null;
        String include = null;
        // UserInfoResp response = api.getMyUser(scratchCodes, properties, include);

        // TODO: test validations
    }

    /**
     * Details of a user.
     *
     * Retrieve the details of a user. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getUserTest() {
        String userId = null;
        // UserInfoResp response = api.getUser(userId);

        // TODO: test validations
    }

    /**
     * Remove user from groups.
     *
     * Remove user from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeUserFromGroupsTest() {
        String userId = null;
        List<String> body = null;
        // UserInfoResp response = api.removeUserFromGroups(userId, body);

        // TODO: test validations
    }

    /**
     * Remove user from groups.
     *
     * Remove user from groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups/remove \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeUserFromListedGroupsTest() {
        String userId = null;
        GroupIdList body = null;
        // UserInfoResp response = api.removeUserFromListedGroups(userId, body);

        // TODO: test validations
    }

    /**
     * Update user details.
     *
     * Update user details. **Example:** &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/users/me
     * \\ -H &#39;Authorization: Bearer &lt;token&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;{\&quot;full_name\&quot;: \&quot;fullname\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateMyUserTest() {
        UserUpdateReq body = null;
        // UserInfoResp response = api.updateMyUser(body);

        // TODO: test validations
    }

    /**
     * Update user details.
     *
     * Update user details **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\
     * -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void updateUserTest() {
        String userId = null;
        UserUpdateReq body = null;
        // UserInfoResp response = api.updateUser(userId, body);

        // TODO: test validations
    }
}
