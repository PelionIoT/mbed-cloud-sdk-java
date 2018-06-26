package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountCreationReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountCreationResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfoList;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateRootReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateInternalResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateInternalRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRootReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateUpdateReq;
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
 * API tests for AggregatorAccountAdminApi
 */
public class AggregatorAccountAdminApiTest {

    private AggregatorAccountAdminApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AggregatorAccountAdminApi.class);
    }

    /**
     * Add API key to a list of groups.
     *
     * An endpoint for adding API key to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apikey}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addAccountApiKeyToGroupsTest() {
        String accountID = null;
        String apiKey = null;
        List<String> body = null;
        // UpdatedResponse response = api.addAccountApiKeyToGroups(accountID, apiKey, body);

        // TODO: test validations
    }
    /**
     * Upload new trusted certificate.
     *
     * An endpoint for uploading new trusted certificates.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates -d {\&quot;name\&quot;: \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;: \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addAccountCertificateTest() {
        String accountID = null;
        TrustedCertificateRootReq body = null;
        // TrustedCertificateResp response = api.addAccountCertificate(accountID, body);

        // TODO: test validations
    }
    /**
     * Add user to a list of groups.
     *
     * An endpoint for adding user to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addAccountUserToGroupsTest() {
        String accountID = null;
        String userId = null;
        List<String> body = null;
        // UpdatedResponse response = api.addAccountUserToGroups(accountID, userId, body);

        // TODO: test validations
    }
    /**
     * Add members to a group.
     *
     * An endpoint for adding users and API keys to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID} -d &#39;{\&quot;users\&quot;: [0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addSubjectsToAccountGroupTest() {
        String accountID = null;
        String groupID = null;
        SubjectList body = null;
        // UpdatedResponse response = api.addSubjectsToAccountGroup(accountID, groupID, body);

        // TODO: test validations
    }
    /**
     * Check the API key.
     *
     * An endpoint for checking API key.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void checkAccountApiKeyTest() {
        String accountID = null;
        String apiKey = null;
        // Void response = api.checkAccountApiKey(accountID, apiKey);

        // TODO: test validations
    }
    /**
     * Create a new account.
     *
     * An endpoint for creating a new account.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;, \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;: \&quot;example_admin@myaccount.info\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountTest() {
        AccountCreationReq body = null;
        String action = null;
        // AccountCreationResp response = api.createAccount(body, action);

        // TODO: test validations
    }
    /**
     * Create a new API key.
     *
     * An endpoint for creating a new API key. There is no default value for the owner ID and it must be from the same account where the new API key is created.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountApiKeyTest() {
        String accountID = null;
        ApiKeyInfoReq body = null;
        // ApiKeyInfoResp response = api.createAccountApiKey(accountID, body);

        // TODO: test validations
    }
    /**
     * Create a new group.
     *
     * An endpoint for creating a new group.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountGroupTest() {
        String accountID = null;
        GroupCreationInfo body = null;
        // GroupSummary response = api.createAccountGroup(accountID, body);

        // TODO: test validations
    }
    /**
     * Create a new user.
     *
     * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountUserTest() {
        String accountID = null;
        UserInfoReq body = null;
        String action = null;
        // UserInfoResp response = api.createAccountUser(accountID, body, action);

        // TODO: test validations
    }
    /**
     * Delete the API key.
     *
     * An endpoint for deleting an API key.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apikey} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountApiKeyTest() {
        String accountID = null;
        String apiKey = null;
        // Void response = api.deleteAccountApiKey(accountID, apiKey);

        // TODO: test validations
    }
    /**
     * Delete trusted certificate by ID.
     *
     * An endpoint for deleting the trusted certificate.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates/{cert-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountCertificateTest() {
        String accountID = null;
        String certId = null;
        // Void response = api.deleteAccountCertificate(accountID, certId);

        // TODO: test validations
    }
    /**
     * Delete a group.
     *
     * An endpoint for deleting a group.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountGroupTest() {
        String accountID = null;
        String groupID = null;
        // Void response = api.deleteAccountGroup(accountID, groupID);

        // TODO: test validations
    }
    /**
     * Delete a user.
     *
     * An endpoint for deleting a user.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountUserTest() {
        String accountID = null;
        String userId = null;
        // Void response = api.deleteAccountUser(accountID, userId);

        // TODO: test validations
    }
    /**
     * Get API key details.
     *
     * An endpoint for retrieving API key details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountApiKeyTest() {
        String accountID = null;
        String apiKey = null;
        // ApiKeyInfoResp response = api.getAccountApiKey(accountID, apiKey);

        // TODO: test validations
    }
    /**
     * Get trusted certificate by ID.
     *
     * An endpoint for retrieving a trusted certificate by ID.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates/{cert-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountCertificateTest() {
        String accountID = null;
        String certId = null;
        // TrustedCertificateInternalResp response = api.getAccountCertificate(accountID, certId);

        // TODO: test validations
    }
    /**
     * Get group information.
     *
     * An endpoint for getting general information about the group.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountGroupSummaryTest() {
        String accountID = null;
        String groupID = null;
        // GroupSummary response = api.getAccountGroupSummary(accountID, groupID);

        // TODO: test validations
    }
    /**
     * Get account info.
     *
     * Returns detailed information about the account.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.
     */
    @Test
    public void getAccountInfoTest() {
        String accountID = null;
        String include = null;
        String properties = null;
        // AccountInfo response = api.getAccountInfo(accountID, include, properties);

        // TODO: test validations
    }
    /**
     * Details of the user.
     *
     * An endpoint for retrieving details of the user.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{userID} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountUserTest() {
        String accountID = null;
        String userId = null;
        // UserInfoResp response = api.getAccountUser(accountID, userId);

        // TODO: test validations
    }
    /**
     * Get all API keys.
     *
     * An endpoint for retrieving the API keys in an array, optionally filtered by the owner.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountApiKeysTest() {
        String accountID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String keyEq = null;
        String ownerEq = null;
        // ApiKeyInfoRespList response = api.getAllAccountApiKeys(accountID, limit, after, order, include, keyEq, ownerEq);

        // TODO: test validations
    }
    /**
     * Get all trusted certificates.
     *
     * An endpoint for retrieving trusted certificates in an array.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/trusted-certificates -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountCertificatesTest() {
        String accountID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        String serviceEq = null;
        Integer expireEq = null;
        Integer deviceExecutionModeEq = null;
        Integer deviceExecutionModeNeq = null;
        String ownerEq = null;
        Boolean enrollmentModeEq = null;
        String issuerLike = null;
        String subjectLike = null;
        // TrustedCertificateInternalRespList response = api.getAllAccountCertificates(accountID, limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, issuerLike, subjectLike);

        // TODO: test validations
    }
    /**
     * Get all group information.
     *
     * An endpoint for retrieving all group information.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountGroupsTest() {
        String accountID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        // GroupSummaryList response = api.getAllAccountGroups(accountID, limit, after, order, include, nameEq);

        // TODO: test validations
    }
    /**
     * Get all user details.
     *
     * An endpoint for retrieving details of all users.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountUsersTest() {
        String accountID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String emailEq = null;
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        // UserInfoRespList response = api.getAllAccountUsers(accountID, limit, after, order, include, emailEq, statusEq, statusIn, statusNin);

        // TODO: test validations
    }
    /**
     * Get all accounts.
     *
     * Returns an array of account objects, optionally filtered by status and tier level.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.
     */
    @Test
    public void getAllAccountsTest() {
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        String tierEq = null;
        String parentEq = null;
        String endMarketEq = null;
        String countryLike = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String format = null;
        String properties = null;
        // AccountInfoList response = api.getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties);

        // TODO: test validations
    }
    /**
     * Get API keys of a group.
     *
     * An endpoint for listing the API keys of the group with details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getApiKeysOfAccountGroupTest() {
        String accountID = null;
        String groupID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // ApiKeyInfoRespList response = api.getApiKeysOfAccountGroup(accountID, groupID, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Get groups of the API key.
     *
     * An endpoint for retrieving groups of the API key.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getGroupsOfAccountApikeyTest() {
        String accountID = null;
        String apiKey = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfAccountApikey(accountID, apiKey, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Get groups of the user.
     *
     * An endpoint for retrieving groups of the user.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getGroupsOfAccountUserTest() {
        String accountID = null;
        String userId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfAccountUser(accountID, userId, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Get users of a group.
     *
     * An endpoint for listing users of the group with details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getUsersOfAccountGroupTest() {
        String accountID = null;
        String groupID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        // UserInfoRespList response = api.getUsersOfAccountGroup(accountID, groupID, limit, after, order, include, statusEq, statusIn, statusNin);

        // TODO: test validations
    }
    /**
     * Remove API key from groups.
     *
     * An endpoint for removing API key from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeAccountApiKeyFromGroupsTest() {
        String accountID = null;
        String apiKey = null;
        List<String> body = null;
        // UpdatedResponse response = api.removeAccountApiKeyFromGroups(accountID, apiKey, body);

        // TODO: test validations
    }
    /**
     * Remove user from groups.
     *
     * An endpoint for removing user from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeAccountUserFromGroupsTest() {
        String accountID = null;
        String userId = null;
        List<String> body = null;
        // UpdatedResponse response = api.removeAccountUserFromGroups(accountID, userId, body);

        // TODO: test validations
    }
    /**
     * Remove API keys from a group.
     *
     * An endpoint for removing API keys from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/api-keys -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeApiKeysFromAccountGroupTest() {
        String accountID = null;
        String groupID = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeApiKeysFromAccountGroup(accountID, groupID, body);

        // TODO: test validations
    }
    /**
     * Remove users from a group.
     *
     * An endpoint for removing users from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/users -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeUsersFromAccountGroupTest() {
        String accountID = null;
        String groupID = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeUsersFromAccountGroup(accountID, groupID, body);

        // TODO: test validations
    }
    /**
     * Reset the secret key.
     *
     * An endpoint for resetting the secret key of the API key.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey}/reset-secret -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void resetAccountApiKeySecretTest() {
        String accountID = null;
        String apiKey = null;
        // ApiKeyInfoResp response = api.resetAccountApiKeySecret(accountID, apiKey);

        // TODO: test validations
    }
    /**
     * Update attributes of an existing account.
     *
     * An endpoint for updating an account.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account-id} -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountTest() {
        String accountID = null;
        AccountUpdateRootReq body = null;
        // AccountInfo response = api.updateAccount(accountID, body);

        // TODO: test validations
    }
    /**
     * Update API key details.
     *
     * An endpoint for updating API key details.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/api-keys/{apiKey} -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountApiKeyTest() {
        String accountID = null;
        String apiKey = null;
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateAccountApiKey(accountID, apiKey, body);

        // TODO: test validations
    }
    /**
     * Update trusted certificate.
     *
     * An endpoint for updating existing trusted certificates.
     */
    @Test
    public void updateAccountCertificateTest() {
        String accountID = null;
        String certId = null;
        TrustedCertificateUpdateReq body = null;
        // TrustedCertificateInternalResp response = api.updateAccountCertificate(accountID, certId, body);

        // TODO: test validations
    }
    /**
     * Update the group name.
     *
     * An endpoint for updating a group name.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/policy-groups/{groupID}/ -d &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountGroupNameTest() {
        String accountID = null;
        String groupID = null;
        GroupUpdateInfo body = null;
        // UpdatedResponse response = api.updateAccountGroupName(accountID, groupID, body);

        // TODO: test validations
    }
    /**
     * Update user details.
     *
     * An endpoint for updating user details.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id} -d &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountUserTest() {
        String accountID = null;
        String userId = null;
        UserUpdateReq body = null;
        // UserInfoResp response = api.updateAccountUser(accountID, userId, body);

        // TODO: test validations
    }
    /**
     * Validate the user email.
     *
     * An endpoint for validating the user email.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{accountID}/users/{user-id}/validate-email -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void validateAccountUserEmailTest() {
        String accountID = null;
        String userId = null;
        // Void response = api.validateAccountUserEmail(accountID, userId);

        // TODO: test validations
    }
}
