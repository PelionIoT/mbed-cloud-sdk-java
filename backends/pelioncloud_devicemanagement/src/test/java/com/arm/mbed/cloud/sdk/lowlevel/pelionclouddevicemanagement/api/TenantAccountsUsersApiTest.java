package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupIdList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * API tests for TenantAccountsUsersApi
 */
public class TenantAccountsUsersApiTest {

    private TenantAccountsUsersApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsUsersApi.class);
    }

    /**
     * Add user to a list of groups.
     *
     * Add user to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addAccountUserToGroupsTest() {
        String accountId = null;
        String userId = null;
        List<String> body = null;
        // UserInfoResp response = api.addAccountUserToGroups(accountId, userId, body);

        // TODO: test validations
    }

    /**
     * Add user to a list of groups.
     *
     * Add a user to groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups/add \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void addAccountUserToListedGroupsTest() {
        String accountId = null;
        String userId = null;
        GroupIdList body = null;
        // UserInfoResp response = api.addAccountUserToListedGroups(accountId, userId, body);

        // TODO: test validations
    }

    /**
     * Create a new user.
     *
     * Create or invite a new user to the account. Only email address is used; other attributes are set in the second
     * step. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} &#x60;&#x60;&#x60;
     */
    @Test
    public void createAccountUserTest() {
        String accountId = null;
        UserInfoReq body = null;
        String action = null;
        // UserInfoResp response = api.createAccountUser(accountId, body, action);

        // TODO: test validations
    }

    /**
     * Delete a user.
     *
     * Delete a user. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteAccountUserTest() {
        String accountId = null;
        String userId = null;
        // Void response = api.deleteAccountUser(accountId, userId);

        // TODO: test validations
    }

    /**
     * Details of the user.
     *
     * Retrieve user details. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountUserTest() {
        String accountId = null;
        String userId = null;
        // UserInfoResp response = api.getAccountUser(accountId, userId);

        // TODO: test validations
    }

    /**
     * Get the details of all users.
     *
     * Retrieve details of all users. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountUsersTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String emailEq = null;
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        String loginProfilesEq = null;
        // UserInfoRespList response = api.getAllAccountUsers(accountId, limit, after, order, include, emailEq,
        // statusEq, statusIn, statusNin, loginProfilesEq);

        // TODO: test validations
    }

    /**
     * Get user&#39;s groups.
     *
     * Retrieve user&#39;s groups. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getGroupsOfAccountUserTest() {
        String accountId = null;
        String userId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfAccountUser(accountId, userId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Remove user from groups.
     *
     * Remove user from groups. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeAccountUserFromGroupsTest() {
        String accountId = null;
        String userId = null;
        List<String> body = null;
        // UserInfoResp response = api.removeAccountUserFromGroups(accountId, userId, body);

        // TODO: test validations
    }

    /**
     * Remove user from groups.
     *
     * Remove a user from groups. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups/remove \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void removeAccountUserFromListedGroupsTest() {
        String accountId = null;
        String userId = null;
        GroupIdList body = null;
        // UserInfoResp response = api.removeAccountUserFromListedGroups(accountId, userId, body);

        // TODO: test validations
    }

    /**
     * Update user details.
     *
     * Update user details. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;username\&quot;:
     * \&quot;myusername\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateAccountUserTest() {
        String accountId = null;
        String userId = null;
        UserUpdateReq body = null;
        // UserInfoResp response = api.updateAccountUser(accountId, userId, body);

        // TODO: test validations
    }

    /**
     * Validate the user email.
     *
     * Validate user email. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/validate-email \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void validateAccountUserEmailTest() {
        String accountId = null;
        String userId = null;
        // Void response = api.validateAccountUserEmail(accountId, userId);

        // TODO: test validations
    }
}
