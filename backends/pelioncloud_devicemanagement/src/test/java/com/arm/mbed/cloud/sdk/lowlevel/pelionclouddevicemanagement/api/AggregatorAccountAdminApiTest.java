package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateRootReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateGenerationReq;
import java.io.File;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
     * An endpoint for adding API key to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * Upload new trusted certificate.
     *
     * An endpoint for uploading new trusted certificates. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates -d {\&quot;name\&quot;:
     * \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;:
     * \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type:
     * application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addAccountCertificateTest() {
        String accountId = null;
        TrustedCertificateReq body = null;
        // TrustedCertificateResp response = api.addAccountCertificate(accountId, body);

        // TODO: test validations
    }

    /**
     * Add user to a list of groups.
     *
     * An endpoint for adding user to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addAccountUserToGroupsTest() {
        String accountId = null;
        String userId = null;
        List<String> body = null;
        // UpdatedResponse response = api.addAccountUserToGroups(accountId, userId, body);

        // TODO: test validations
    }

    /**
     * Add members to a group.
     *
     * An endpoint for adding users and API keys to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -d
     * &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addSubjectsToAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // UpdatedResponse response = api.addSubjectsToAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Updates an array of branding colors in the dark theme.
     *
     * An endpoint for updating an array of branding colors in the dark theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark &#39;[{
     * \&quot;reference\&quot;: \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void bulkSetAccountDarkColorsTest() {
        String accountId = null;
        List<BrandingColor> body = null;
        // Void response = api.bulkSetAccountDarkColors(accountId, body);

        // TODO: test validations
    }

    /**
     * Updates an array of branding colors in the light theme.
     *
     * An endpoint for updating an array of branding colors in the light theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light &#39;[{
     * \&quot;reference\&quot;: \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void bulkSetAccountLightColorsTest() {
        String accountId = null;
        List<BrandingColor> body = null;
        // Void response = api.bulkSetAccountLightColors(accountId, body);

        // TODO: test validations
    }

    /**
     * Revert an image to default in the dark theme.
     *
     * An endpoint for reverting an account branding image to default in the dark theme. **Example usage:** &#x60;curl
     * -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/clear -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void clearAccountDarkImageTest() {
        String accountId = null;
        String reference = null;
        // Void response = api.clearAccountDarkImage(accountId, reference);

        // TODO: test validations
    }

    /**
     * Revert an image to default in the light theme.
     *
     * An endpoint for reverting an account branding image to default in the light theme. **Example usage:** &#x60;curl
     * -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/clear -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void clearAccountLightImageTest() {
        String accountId = null;
        String reference = null;
        // Void response = api.clearAccountLightImage(accountId, reference);

        // TODO: test validations
    }

    /**
     * Create a new account.
     *
     * An endpoint for creating a new account. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;,
     * \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;:
     * \&quot;example_admin@myaccount.info\&quot;, \&quot;country\&quot;: \&quot;United Kingdom\&quot;,
     * \&quot;end_market\&quot;: \&quot;Smart City\&quot;, \&quot;address_line1\&quot;: \&quot;110 Fulbourn Rd\&quot;,
     * \&quot;city\&quot;: \&quot;Cambridge\&quot;, \&quot;contact\&quot;: \&quot;J. Doe\&quot;, \&quot;company\&quot;:
     * \&quot;Arm\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountTest() {
        AccountCreationReq body = null;
        String action = null;
        // AccountInfo response = api.createAccount(body, action);

        // TODO: test validations
    }

    /**
     * Create a new API key.
     *
     * An endpoint for creating a new API key. There is no default value for the owner ID and it must be from the same
     * account where the new API key is created. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys -d &#39;{\&quot;name\&quot;:
     * \&quot;MyKey1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountApiKeyTest() {
        String accountId = null;
        ApiKeyInfoReq body = null;
        // ApiKeyInfoResp response = api.createAccountApiKey(accountId, body);

        // TODO: test validations
    }

    /**
     * Create a new group.
     *
     * An endpoint for creating a new group. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups -d &#39;{\&quot;name\&quot;:
     * \&quot;MyGroup1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountGroupTest() {
        String accountId = null;
        GroupCreationInfo body = null;
        // GroupSummary response = api.createAccountGroup(accountId, body);

        // TODO: test validations
    }

    /**
     * Create a new identity provider.
     *
     * An endpoint for creating a new identity provider.
     */
    @Test
    public void createAccountIdentityProviderTest() {
        String accountId = null;
        IdentityProviderCreationReq body = null;
        // IdentityProviderInfo response = api.createAccountIdentityProvider(accountId, body);

        // TODO: test validations
    }

    /**
     * Create a user invitation.
     *
     * An endpoint for inviting a new or an existing user to join the account. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accouns/{account_id}/user-invitations -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void createAccountInvitationTest() {
        String accountId = null;
        UserInvitationReq body = null;
        // UserInvitationResp response = api.createAccountInvitation(accountId, body);

        // TODO: test validations
    }

    /**
     * Create a new user.
     *
     * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only,
     * other attributes are set in the 2nd step. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * Delete the API key.
     *
     * An endpoint for deleting an API key. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountApiKeyTest() {
        String accountId = null;
        String apikeyId = null;
        // Void response = api.deleteAccountApiKey(accountId, apikeyId);

        // TODO: test validations
    }

    /**
     * Delete trusted certificate by ID.
     *
     * An endpoint for deleting the trusted certificate. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountCertificateTest() {
        String accountId = null;
        String certId = null;
        // Void response = api.deleteAccountCertificate(accountId, certId);

        // TODO: test validations
    }

    /**
     * Delete a group.
     *
     * An endpoint for deleting a group. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        // Void response = api.deleteAccountGroup(accountId, groupId);

        // TODO: test validations
    }

    /**
     * Delete an identity provider by ID.
     *
     * An endpoint for deleting an identity provider by ID.
     */
    @Test
    public void deleteAccountIdentityProviderTest() {
        String accountId = null;
        String identityProviderId = null;
        // Void response = api.deleteAccountIdentityProvider(accountId, identityProviderId);

        // TODO: test validations
    }

    /**
     * Delete a user invitation.
     *
     * An endpoint for deleting an active user invitation which has been sent for a new or an existing user to join the
     * account. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountInvitationTest() {
        String accountId = null;
        String invitationId = null;
        // Void response = api.deleteAccountInvitation(accountId, invitationId);

        // TODO: test validations
    }

    /**
     * Delete the service provider certificate.
     *
     * An endpoint for deleting the service provider certificate.
     */
    @Test
    public void deleteAccountSpCertificateTest() {
        String accountId = null;
        String identityProviderId = null;
        // IdentityProviderInfo response = api.deleteAccountSpCertificate(accountId, identityProviderId);

        // TODO: test validations
    }

    /**
     * Delete a user.
     *
     * An endpoint for deleting a user. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAccountUserTest() {
        String accountId = null;
        String userId = null;
        // Void response = api.deleteAccountUser(accountId, userId);

        // TODO: test validations
    }

    /**
     * Generate a new service provider certificate.
     *
     * An endpoint for generating a new service provider certificate.
     */
    @Test
    public void generateAccountSpCertificateTest() {
        String accountId = null;
        String identityProviderId = null;
        CertificateGenerationReq body = null;
        // IdentityProviderInfo response = api.generateAccountSpCertificate(accountId, identityProviderId, body);

        // TODO: test validations
    }

    /**
     * Get API key details.
     *
     * An endpoint for retrieving API key details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountApiKeyTest() {
        String accountId = null;
        String apikeyId = null;
        // ApiKeyInfoResp response = api.getAccountApiKey(accountId, apikeyId);

        // TODO: test validations
    }

    /**
     * Get trusted certificate by ID.
     *
     * An endpoint for retrieving a trusted certificate by ID. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountCertificateTest() {
        String accountId = null;
        String certId = null;
        // TrustedCertificateResp response = api.getAccountCertificate(accountId, certId);

        // TODO: test validations
    }

    /**
     * Get branding color of the dark theme.
     *
     * Returns the requested branding color of the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountDarkColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.getAccountDarkColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get branding colors of the dark theme.
     *
     * Returns the branding colors of the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountDarkColorsTest() {
        String accountId = null;
        // BrandingColorList response = api.getAccountDarkColors(accountId);

        // TODO: test validations
    }

    /**
     * Get metadata of an image in the dark theme.
     *
     * An endpoint for getting metadata of one account branding image in the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountDarkImageDataTest() {
        String accountId = null;
        String reference = null;
        // BrandingImage response = api.getAccountDarkImageData(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get group information.
     *
     * An endpoint for getting general information about the group. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountGroupSummaryTest() {
        String accountId = null;
        String groupId = null;
        // GroupSummary response = api.getAccountGroupSummary(accountId, groupId);

        // TODO: test validations
    }

    /**
     * Get identity provider by ID.
     *
     * An endpoint for retrieving an identity provider by ID.
     */
    @Test
    public void getAccountIdentityProviderTest() {
        String accountId = null;
        String identityProviderId = null;
        // IdentityProviderInfo response = api.getAccountIdentityProvider(accountId, identityProviderId);

        // TODO: test validations
    }

    /**
     * Get account info.
     *
     * Returns detailed information about the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.
     */
    @Test
    public void getAccountInfoTest() {
        String accountId = null;
        String include = null;
        String properties = null;
        // AccountInfo response = api.getAccountInfo(accountId, include, properties);

        // TODO: test validations
    }

    /**
     * Details of a user invitation.
     *
     * An endpoint for retrieving the details of an active user invitation sent for a new or an existing user to join
     * the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountInvitationTest() {
        String accountId = null;
        String invitationId = null;
        // UserInvitationResp response = api.getAccountInvitation(accountId, invitationId);

        // TODO: test validations
    }

    /**
     * Get branding color of the light theme.
     *
     * Returns the requested branding color of the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountLightColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.getAccountLightColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get branding colors of the light theme.
     *
     * Returns the branding colors of the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountLightColorsTest() {
        String accountId = null;
        // BrandingColorList response = api.getAccountLightColors(accountId);

        // TODO: test validations
    }

    /**
     * Get metadata of an image in the light theme.
     *
     * An endpoint for getting metadata of one account branding image in the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountLightImageDataTest() {
        String accountId = null;
        String reference = null;
        // BrandingImage response = api.getAccountLightImageData(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get the notification events of an account.
     *
     * Endpoint for retrieving notifications.
     */
    @Test
    public void getAccountNofificationEntriesTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        // NotificationEntryList response = api.getAccountNofificationEntries(accountId, limit, after, order);

        // TODO: test validations
    }

    /**
     * Details of the user.
     *
     * An endpoint for retrieving details of the user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAccountUserTest() {
        String accountId = null;
        String userId = null;
        // UserInfoResp response = api.getAccountUser(accountId, userId);

        // TODO: test validations
    }

    /**
     * Get all API keys.
     *
     * An endpoint for retrieving the API keys in an array, optionally filtered by the owner. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * Get all trusted certificates.
     *
     * An endpoint for retrieving trusted certificates in an array. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountCertificatesTest() {
        String accountId = null;
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
        String statusEq = null;
        String issuerLike = null;
        String subjectLike = null;
        Boolean validEq = null;
        // TrustedCertificateRespList response = api.getAllAccountCertificates(accountId, limit, after, order, include,
        // nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq,
        // statusEq, issuerLike, subjectLike, validEq);

        // TODO: test validations
    }

    /**
     * Get metadata of all images in the dark theme.
     *
     * Returns the metadata of all branding images in the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountDarkImageDataTest() {
        String accountId = null;
        // BrandingImageList response = api.getAllAccountDarkImageData(accountId);

        // TODO: test validations
    }

    /**
     * Get all group information.
     *
     * An endpoint for retrieving all group information. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * Get all identity providers.
     *
     * An endpoint for retrieving identity providers in an array.
     */
    @Test
    public void getAllAccountIdentityProvidersTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // IdentityProviderList response = api.getAllAccountIdentityProviders(accountId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get the details of all the user invitations.
     *
     * An endpoint for retrieving the details of all the active user invitations sent for new or existing users to join
     * the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountInvitationsTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String loginProfileEq = null;
        // UserInvitationRespList response = api.getAllAccountInvitations(accountId, limit, after, order,
        // loginProfileEq);

        // TODO: test validations
    }

    /**
     * Get metadata of all images in the light theme.
     *
     * Returns the metadata of all branding images in the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getAllAccountLightImageDataTest() {
        String accountId = null;
        // BrandingImageList response = api.getAllAccountLightImageData(accountId);

        // TODO: test validations
    }

    /**
     * Get all user details.
     *
     * An endpoint for retrieving details of all users. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
        String loginProfileEq = null;
        // UserInfoRespList response = api.getAllAccountUsers(accountId, limit, after, order, include, emailEq,
        // statusEq, statusIn, statusNin, loginProfileEq);

        // TODO: test validations
    }

    /**
     * Get all accounts.
     *
     * Returns an array of account objects, optionally filtered by status and tier level. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.
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
        // AccountInfoList response = api.getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq,
        // countryLike, limit, after, order, include, format, properties);

        // TODO: test validations
    }

    /**
     * Get API keys of a group.
     *
     * An endpoint for listing the API keys of the group with details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * Get groups of the API key.
     *
     * An endpoint for retrieving groups of the API key. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
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
     * Get groups of the user.
     *
     * An endpoint for retrieving groups of the user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * Get users of a group.
     *
     * An endpoint for listing users of the group with details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * Remove API key from groups.
     *
     * An endpoint for removing API key from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * Remove user from groups.
     *
     * An endpoint for removing user from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeAccountUserFromGroupsTest() {
        String accountId = null;
        String userId = null;
        List<String> body = null;
        // UpdatedResponse response = api.removeAccountUserFromGroups(accountId, userId, body);

        // TODO: test validations
    }

    /**
     * Remove API keys from a group.
     *
     * An endpoint for removing API keys from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys -d
     * &#39;{\&quot;apikeys\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeApiKeysFromAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeApiKeysFromAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Remove users from a group.
     *
     * An endpoint for removing users from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users -d
     * &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeUsersFromAccountGroupTest() {
        String accountId = null;
        String groupId = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeUsersFromAccountGroup(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Reset the secret key.
     *
     * An endpoint for resetting the secret key of the API key. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void resetAccountApiKeySecretTest() {
        String accountId = null;
        String apikeyId = null;
        // ApiKeyInfoResp response = api.resetAccountApiKeySecret(accountId, apikeyId);

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color to its default in the dark theme. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void resetAccountDarkColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.resetAccountDarkColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color to its default in the light theme. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void resetAccountLightColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.resetAccountLightColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Updates a branding color in the dark theme.
     *
     * An endpoint for updating a branding color in the dark theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark/primary -d &#39;{
     * \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void setAccountDarkColorTest() {
        String accountId = null;
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setAccountDarkColor(accountId, reference, body);

        // TODO: test validations
    }

    /**
     * Updates a branding color in the light theme.
     *
     * An endpoint for updating a branding color in the light theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light/primary -d &#39;{
     * \&quot;color\&quot;: \&quot;purple\&quot; }&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void setAccountLightColorTest() {
        String accountId = null;
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setAccountLightColor(accountId, reference, body);

        // TODO: test validations
    }

    /**
     * Update attributes of an existing account.
     *
     * An endpoint for updating an account. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} -d &#39;{\&quot;phone_number\&quot;:
     * \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountTest() {
        String accountId = null;
        AccountUpdateRootReq body = null;
        // AccountInfo response = api.updateAccount(accountId, body);

        // TODO: test validations
    }

    /**
     * Update API key details.
     *
     * An endpoint for updating API key details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountApiKeyTest() {
        String accountId = null;
        String apikeyId = null;
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateAccountApiKey(accountId, apikeyId, body);

        // TODO: test validations
    }

    /**
     * Update trusted certificate.
     *
     * An endpoint for updating existing trusted certificates. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -d
     * {\&quot;description\&quot;: \&quot;very important cert\&quot;} -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountCertificateTest() {
        String accountId = null;
        String certId = null;
        TrustedCertificateUpdateReq body = null;
        // TrustedCertificateResp response = api.updateAccountCertificate(accountId, certId, body);

        // TODO: test validations
    }

    /**
     * Update the group name.
     *
     * An endpoint for updating a group name. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/ -d
     * &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateAccountGroupNameTest() {
        String accountId = null;
        String groupId = null;
        GroupUpdateInfo body = null;
        // UpdatedResponse response = api.updateAccountGroupName(accountId, groupId, body);

        // TODO: test validations
    }

    /**
     * Update an existing identity provider.
     *
     * An endpoint for updating an existing identity provider.
     */
    @Test
    public void updateAccountIdentityProviderTest() {
        String accountId = null;
        String identityProviderId = null;
        IdentityProviderUpdateReq body = null;
        // IdentityProviderInfo response = api.updateAccountIdentityProvider(accountId, identityProviderId, body);

        // TODO: test validations
    }

    /**
     * Update user details.
     *
     * An endpoint for updating user details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -d &#39;{\&quot;username\&quot;:
     * \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * Upload an image in the dark theme.
     *
     * An endpoint for uploading a new account branding image in the dark theme in PNG or JPEG format. **Example
     * usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/upload -H
     * &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary
     * &#39;@myimage.png&#39;&#x60;
     */
    @Test
    public void uploadAccountDarkImageTest() {
        String accountId = null;
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadAccountDarkImage(accountId, reference, body);

        // TODO: test validations
    }

    /**
     * Upload an image in the dark theme.
     *
     * An endpoint for uploading a new account branding image as form data in the dark theme in PNG or JPEG format.
     */
    @Test
    public void uploadAccountDarkImageMultipartTest() {
        String accountId = null;
        String reference = null;
        File image = null;
        // BrandingImage response = api.uploadAccountDarkImageMultipart(accountId, reference, image);

        // TODO: test validations
    }

    /**
     * Upload an image in the light theme.
     *
     * An endpoint for uploading a new account branding image in the light theme in PNG or JPEG format. **Example
     * usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/upload -H
     * &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary
     * &#39;@myimage.png&#39;&#x60;
     */
    @Test
    public void uploadAccountLightImageTest() {
        String accountId = null;
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadAccountLightImage(accountId, reference, body);

        // TODO: test validations
    }

    /**
     * Upload an image in the light theme.
     *
     * An endpoint for uploading a new account branding image as form data in the light theme in PNG or JPEG format.
     */
    @Test
    public void uploadAccountLightImageMultipartTest() {
        String accountId = null;
        String reference = null;
        File image = null;
        // BrandingImage response = api.uploadAccountLightImageMultipart(accountId, reference, image);

        // TODO: test validations
    }

    /**
     * Validate the user email.
     *
     * An endpoint for validating the user email. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/validate-email -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void validateAccountUserEmailTest() {
        String accountId = null;
        String userId = null;
        // Void response = api.validateAccountUserEmail(accountId, userId);

        // TODO: test validations
    }
}
