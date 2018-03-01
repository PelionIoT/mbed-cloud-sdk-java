package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountCreationReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountCreationResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfoList;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateRootReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.AdminUserUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.MyUserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.PolicyCreationReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.PolicyInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.PolicyInfoList;
import com.arm.mbed.cloud.sdk.internal.iam.model.PolicyUpdateReq;
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
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateResp;
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
     * An endpoint for adding API key to groups.
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
     * An endpoint for uploading new trusted certificates.
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
     * An endpoint for adding user to groups.
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
     * An endpoint for adding users and API keys to groups.
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
     * Attach a policy to API keys.
     *
     * An endpoint for attaching policy to API keys.
     */
    @Test
    public void attachAccountPolicyToApikeysTest() {
        String accountID = null;
        String policyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.attachAccountPolicyToApikeys(accountID, policyId, body);

        // TODO: test validations
    }
    /**
     * Attach a policy to groups.
     *
     * An endpoint for attaching policy to groups.
     */
    @Test
    public void attachAccountPolicyToGroupTest() {
        String accountID = null;
        String policyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.attachAccountPolicyToGroup(accountID, policyId, body);

        // TODO: test validations
    }
    /**
     * Attach a policy to users.
     *
     * An endpoint for attaching policy to users.
     */
    @Test
    public void attachAccountPolicyToUsersTest() {
        String accountID = null;
        String policyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.attachAccountPolicyToUsers(accountID, policyId, body);

        // TODO: test validations
    }
    /**
     * Check the API key.
     *
     * An endpoint for checking API key.
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
     * An endpoint for creating a new account.
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
     * An endpoint for creating a new API key. There is no default value for the owner ID and it must be from the same account where the new API key is created.
     */
    @Test
    public void createAccountApiKeyTest() {
        String accountID = null;
        ApiKeyInfoReq body = null;
        // ApiKeyInfoResp response = api.createAccountApiKey(accountID, body);

        // TODO: test validations
    }
    /**
     * Create a policy.
     *
     * An endpoint for creating a new policy.
     */
    @Test
    public void createAccountPolicyTest() {
        String accountID = null;
        PolicyCreationReq body = null;
        // PolicyInfo response = api.createAccountPolicy(accountID, body);

        // TODO: test validations
    }
    /**
     * Create a new user.
     *
     * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.
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
     * An endpoint for deleting an API key.
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
     * An endpoint for deleting the trusted certificate.
     */
    @Test
    public void deleteAccountCertificateTest() {
        String accountID = null;
        String certId = null;
        // Void response = api.deleteAccountCertificate(accountID, certId);

        // TODO: test validations
    }
    /**
     * Delete policy.
     *
     * An endpoint for deleting a policy.
     */
    @Test
    public void deleteAccountPolicyTest() {
        String accountID = null;
        String policyId = null;
        // Void response = api.deleteAccountPolicy(accountID, policyId);

        // TODO: test validations
    }
    /**
     * Delete a user.
     *
     * An endpoint for deleting a user.
     */
    @Test
    public void deleteAccountUserTest() {
        String accountID = null;
        String userId = null;
        // Void response = api.deleteAccountUser(accountID, userId);

        // TODO: test validations
    }
    /**
     * Detach a policy from API keys.
     *
     * An endpoint for detaching policy from API keys.
     */
    @Test
    public void detachAccountPolicyFromApikeysTest() {
        String accountID = null;
        String policyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.detachAccountPolicyFromApikeys(accountID, policyId, body);

        // TODO: test validations
    }
    /**
     * Detach a policy from users.
     *
     * An endpoint for detaching policy from users.
     */
    @Test
    public void detachAccountPolicyFromUsersTest() {
        String accountID = null;
        String policyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.detachAccountPolicyFromUsers(accountID, policyId, body);

        // TODO: test validations
    }
    /**
     * Detach a policy to groups.
     *
     * An endpoint for detaching policy to groups.
     */
    @Test
    public void detachAccountPolicyToGroupTest() {
        String accountID = null;
        String policyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.detachAccountPolicyToGroup(accountID, policyId, body);

        // TODO: test validations
    }
    /**
     * Get API key details.
     *
     * An endpoint for retrieving API key details.
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
     * An endpoint for retrieving a trusted certificate by ID.
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
     * An endpoint for getting general information about the group.
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
     * Returns detailed information about the account.
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
     * Get policy by ID.
     *
     * An endpoint for retrieving a policy by ID.
     */
    @Test
    public void getAccountPolicyTest() {
        String accountID = null;
        String policyId = null;
        // PolicyInfo response = api.getAccountPolicy(accountID, policyId);

        // TODO: test validations
    }
    /**
     * Fetch details of policy&#39;s API keys.
     *
     * An endpoint for fetching detailed information about API keys this policy is attached to.
     */
    @Test
    public void getAccountPolicyApikeysTest() {
        String accountID = null;
        String policyId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // ApiKeyInfoRespList response = api.getAccountPolicyApikeys(accountID, policyId, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Fetch details of policy&#39;s groups.
     *
     * An endpoint for fetching detailed information about groups this policy is attached to.
     */
    @Test
    public void getAccountPolicyGroupsTest() {
        String accountID = null;
        String policyId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getAccountPolicyGroups(accountID, policyId, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Fetch details of policy&#39;s users.
     *
     * An endpoint for fetching detailed information about users this policy is attached to.
     */
    @Test
    public void getAccountPolicyUsersTest() {
        String accountID = null;
        String policyId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // UserInfoRespList response = api.getAccountPolicyUsers(accountID, policyId, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Details of the user.
     *
     * An endpoint for retrieving details of the user.
     */
    @Test
    public void getAccountUserTest() {
        String accountID = null;
        String userId = null;
        String scratchCodes = null;
        String properties = null;
        // MyUserInfoResp response = api.getAccountUser(accountID, userId, scratchCodes, properties);

        // TODO: test validations
    }
    /**
     * Get all API keys.
     *
     * An endpoint for retrieving the API keys in an array, optionally filtered by the owner.
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
     * An endpoint for retrieving trusted certificates in an array.
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
     * An endpoint for retrieving all group information.
     */
    @Test
    public void getAllAccountGroupsTest() {
        String accountID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        // List<GroupSummary> response = api.getAllAccountGroups(accountID, limit, after, order, include, nameEq);

        // TODO: test validations
    }
    /**
     * Get all policies.
     *
     * An endpoint for retrieving all policies in the account.
     */
    @Test
    public void getAllAccountPoliciesTest() {
        String accountID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String nameEq = null;
        String statusEq = null;
        String tagEq = null;
        String userIdEq = null;
        String apikeyIdEq = null;
        String groupIdEq = null;
        String unbounded = null;
        // PolicyInfoList response = api.getAllAccountPolicies(accountID, limit, after, order, nameEq, statusEq, tagEq, userIdEq, apikeyIdEq, groupIdEq, unbounded);

        // TODO: test validations
    }
    /**
     * Get all user details.
     *
     * An endpoint for retrieving details of all users.
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
        // UserInfoRespList response = api.getAllAccountUsers(accountID, limit, after, order, include, emailEq, statusEq);

        // TODO: test validations
    }
    /**
     * Get all accounts.
     *
     * Returns an array of account objects, optionally filtered by status and tier level.
     */
    @Test
    public void getAllAccountsTest() {
        String statusEq = null;
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
        // AccountInfoList response = api.getAllAccounts(statusEq, tierEq, parentEq, endMarketEq, countryLike, limit, after, order, include, format, properties);

        // TODO: test validations
    }
    /**
     * Get API keys of a group.
     *
     * An endpoint for listing the API keys of the group with details.
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
     * An endpoint for retrieving groups of the API key.
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
     * An endpoint for retrieving groups of the user.
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
     * An endpoint for listing users of the group with details.
     */
    @Test
    public void getUsersOfAccountGroupTest() {
        String accountID = null;
        String groupID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // UserInfoRespList response = api.getUsersOfAccountGroup(accountID, groupID, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Remove API key from groups.
     *
     * An endpoint for removing API key from groups.
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
     * An endpoint for removing user from groups.
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
     * An endpoint for removing API keys from groups.
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
     * An endpoint for removing users from groups.
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
     * An endpoint for resetting the secret key of the API key.
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
     * An endpoint for updating an account.
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
     * An endpoint for updating API key details.
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
     * Update a policy.
     *
     * An endpoint for updating a policy.
     */
    @Test
    public void updateAccountPolicyTest() {
        String accountID = null;
        String policyId = null;
        PolicyUpdateReq body = null;
        // PolicyInfo response = api.updateAccountPolicy(accountID, policyId, body);

        // TODO: test validations
    }
    /**
     * Update user details.
     *
     * An endpoint for updating user details.
     */
    @Test
    public void updateAccountUserTest() {
        String accountID = null;
        String userId = null;
        AdminUserUpdateReq body = null;
        // UserUpdateResp response = api.updateAccountUser(accountID, userId, body);

        // TODO: test validations
    }
    /**
     * Validate the user email.
     *
     * An endpoint for validating the user email.
     */
    @Test
    public void validateAccountUserEmailTest() {
        String accountID = null;
        String userId = null;
        // Void response = api.validateAccountUserEmail(accountID, userId);

        // TODO: test validations
    }
}
