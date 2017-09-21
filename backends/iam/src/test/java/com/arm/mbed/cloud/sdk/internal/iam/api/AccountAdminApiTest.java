package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AccountAdminApi
 */
public class AccountAdminApiTest {

    private AccountAdminApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountAdminApi.class);
    }

    
    /**
     * Upload a new trusted certificate.
     *
     * An endpoint for uploading new trusted certificates.
     */
    @Test
    public void addCertificateTest() {
        TrustedCertificateReq body = null;
        // TrustedCertificateResp response = api.addCertificate(body);

        // TODO: test validations
    }
    
    /**
     * Add members to a group.
     *
     * An endpoint for adding users and API keys to groups.
     */
    @Test
    public void addSubjectsToGroupTest() {
        String groupID = null;
        SubjectList body = null;
        // UpdatedResponse response = api.addSubjectsToGroup(groupID, body);

        // TODO: test validations
    }
    
    /**
     * Create a new user.
     *
     * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.
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
     * An endpoint for deleting a user.
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
     * An endpoint for retrieving the details of all users.
     */
    @Test
    public void getAllUsersTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        // UserInfoRespList response = api.getAllUsers(limit, after, order, include, statusEq);

        // TODO: test validations
    }
    
    /**
     * Details of a user.
     *
     * An endpoint for retrieving the details of a user.
     */
    @Test
    public void getUserTest() {
        String userId = null;
        // UserInfoResp response = api.getUser(userId);

        // TODO: test validations
    }
    
    /**
     * Get users of a group.
     *
     * An endpoint for listing the users of a group with details.
     */
    @Test
    public void getUsersOfGroupTest() {
        String groupID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // UserInfoRespList response = api.getUsersOfGroup(groupID, limit, after, order, include);

        // TODO: test validations
    }
    
    /**
     * Remove users from a group.
     *
     * An endpoint for removing users from groups.
     */
    @Test
    public void removeUsersFromGroupTest() {
        String groupID = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeUsersFromGroup(groupID, body);

        // TODO: test validations
    }
    
    /**
     * Updates attributes of the account.
     *
     * An endpoint for updating the account.   **Example usage:** curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/me -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer AUTH_TOKEN&#39;
     */
    @Test
    public void updateMyAccountTest() {
        AccountUpdateReq body = null;
        // AccountInfo response = api.updateMyAccount(body);

        // TODO: test validations
    }
    
    /**
     * Update user details.
     *
     * An endpoint for updating user details.
     */
    @Test
    public void updateUserTest() {
        String userId = null;
        UserUpdateReq body = null;
        // UserInfoResp response = api.updateUser(userId, body);

        // TODO: test validations
    }
    
}
