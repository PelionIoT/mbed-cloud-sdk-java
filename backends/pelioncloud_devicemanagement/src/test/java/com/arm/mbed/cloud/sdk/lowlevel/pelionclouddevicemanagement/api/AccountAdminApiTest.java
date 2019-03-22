package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateGenerationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
     * Add API key to a list of groups.
     *
     * An endpoint for adding API key to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addApiKeyToGroupsTest() {
        String apikeyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.addApiKeyToGroups(apikeyId, body);

        // TODO: test validations
    }

    /**
     * Upload a new trusted certificate.
     *
     * An endpoint for uploading new trusted certificates. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -d {\&quot;name\&quot;: \&quot;myCert1\&quot;,
     * \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;:
     * \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type:
     * application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for adding users and API keys to a group. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -d &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addSubjectsToGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // UpdatedResponse response = api.addSubjectsToGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Add user to a list of groups.
     *
     * An endpoint for adding user to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addUserToGroupsTest() {
        String userId = null;
        List<String> body = null;
        // UpdatedResponse response = api.addUserToGroups(userId, body);

        // TODO: test validations
    }

    /**
     * Updates an array of branding colors in the dark theme.
     *
     * An endpoint for updating an array of branding colors in the dark theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; -H &#39;content-type:
     * application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void bulkSetDarkColorsTest() {
        List<BrandingColor> body = null;
        // Void response = api.bulkSetDarkColors(body);

        // TODO: test validations
    }

    /**
     * Updates an array of branding colors in the light theme.
     *
     * An endpoint for updating an array of branding colors in the light theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; -H &#39;content-type:
     * application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void bulkSetLightColorsTest() {
        List<BrandingColor> body = null;
        // Void response = api.bulkSetLightColors(body);

        // TODO: test validations
    }

    /**
     * Revert an image to default in the dark theme.
     *
     * An endpoint for reverting an account branding image to default in the dark theme. **Example usage:** &#x60;curl
     * -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/clear -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void clearDarkImageTest() {
        String reference = null;
        // Void response = api.clearDarkImage(reference);

        // TODO: test validations
    }

    /**
     * Revert an image to default in the light theme.
     *
     * An endpoint for reverting an account branding image to default in the light theme. **Example usage:** &#x60;curl
     * -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/clear -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void clearLightImageTest() {
        String reference = null;
        // Void response = api.clearLightImage(reference);

        // TODO: test validations
    }

    /**
     * Create a new group.
     *
     * An endpoint for creating a new group. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void createGroupTest() {
        GroupCreationInfo body = null;
        // GroupSummary response = api.createGroup(body);

        // TODO: test validations
    }

    /**
     * Create a new identity provider.
     *
     * An endpoint for creating a new identity provider.
     */
    @Test
    public void createIdentityProviderTest() {
        IdentityProviderCreationReq body = null;
        // IdentityProviderInfo response = api.createIdentityProvider(body);

        // TODO: test validations
    }

    /**
     * Create a user invitation.
     *
     * An endpoint for inviting a new or an existing user to join the account. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void createInvitationTest() {
        UserInvitationReq body = null;
        // UserInvitationResp response = api.createInvitation(body);

        // TODO: test validations
    }

    /**
     * Create a new user.
     *
     * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only,
     * other attributes are set in the 2nd step. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users?action&#x3D;invite -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void createUserTest() {
        UserInfoReq body = null;
        String action = null;
        // UserInfoResp response = api.createUser(body, action);

        // TODO: test validations
    }

    /**
     * Delete a group.
     *
     * An endpoint for deleting a group. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteGroupTest() {
        String groupId = null;
        // Void response = api.deleteGroup(groupId);

        // TODO: test validations
    }

    /**
     * Delete an identity provider by ID.
     *
     * An endpoint for deleting an identity provider by ID.
     */
    @Test
    public void deleteIdentityProviderTest() {
        String identityProviderId = null;
        // Void response = api.deleteIdentityProvider(identityProviderId);

        // TODO: test validations
    }

    /**
     * Delete a user invitation.
     *
     * An endpoint for deleting an active user invitation which has been sent for a new or an existing user to join the
     * account. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void deleteInvitationTest() {
        String invitationId = null;
        // Void response = api.deleteInvitation(invitationId);

        // TODO: test validations
    }

    /**
     * Delete the service provider certificate.
     *
     * An endpoint for deleting the service provider certificate.
     */
    @Test
    public void deleteSpCertificateTest() {
        String identityProviderId = null;
        // IdentityProviderInfo response = api.deleteSpCertificate(identityProviderId);

        // TODO: test validations
    }

    /**
     * Delete a user.
     *
     * An endpoint for deleting a user. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteUserTest() {
        String userId = null;
        // Void response = api.deleteUser(userId);

        // TODO: test validations
    }

    /**
     * Generate a new service provider certificate.
     *
     * An endpoint for generating a new service provider certificate.
     */
    @Test
    public void generateSpCertificateTest() {
        String identityProviderId = null;
        CertificateGenerationReq body = null;
        // IdentityProviderInfo response = api.generateSpCertificate(identityProviderId, body);

        // TODO: test validations
    }

    /**
     * Get all identity providers.
     *
     * An endpoint for retrieving identity providers in an array.
     */
    @Test
    public void getAllIdentityProvidersTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // IdentityProviderList response = api.getAllIdentityProviders(limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get the details of all the user invitations.
     *
     * An endpoint for retrieving the details of all the active user invitations sent for new or existing users to join
     * the account. **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/user-invitations -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllInvitationsTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String loginProfileEq = null;
        // UserInvitationRespList response = api.getAllInvitations(limit, after, order, loginProfileEq);

        // TODO: test validations
    }

    /**
     * Get the details of all users.
     *
     * An endpoint for retrieving the details of all users. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
        String loginProfileEq = null;
        // UserInfoRespList response = api.getAllUsers(limit, after, order, include, emailEq, statusEq, statusIn,
        // statusNin, loginProfileEq);

        // TODO: test validations
    }

    /**
     * Get groups of the API key.
     *
     * An endpoint for retrieving groups of the API key. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * Get groups of the user.
     *
     * An endpoint for retrieving groups of the user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * Get identity provider by ID.
     *
     * An endpoint for retrieving an identity provider by ID.
     */
    @Test
    public void getIdentityProviderTest() {
        String identityProviderId = null;
        // IdentityProviderInfo response = api.getIdentityProvider(identityProviderId);

        // TODO: test validations
    }

    /**
     * Details of a user invitation.
     *
     * An endpoint for retrieving the details of an active user invitation sent for a new or an existing user to join
     * the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getInvitationTest() {
        String invitationId = null;
        // UserInvitationResp response = api.getInvitation(invitationId);

        // TODO: test validations
    }

    /**
     * Get the notification events of an account.
     *
     * Endpoint for retrieving notifications.
     */
    @Test
    public void getNofificationEntriesTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        // NotificationEntryList response = api.getNofificationEntries(limit, after, order);

        // TODO: test validations
    }

    /**
     * Details of a user.
     *
     * An endpoint for retrieving the details of a user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for listing the users of a group with details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * Remove API key from groups.
     *
     * An endpoint for removing API key from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeApiKeyFromGroupsTest() {
        String apikeyId = null;
        List<String> body = null;
        // UpdatedResponse response = api.removeApiKeyFromGroups(apikeyId, body);

        // TODO: test validations
    }

    /**
     * Remove user from groups.
     *
     * An endpoint for removing user from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeUserFromGroupsTest() {
        String userId = null;
        List<String> body = null;
        // UpdatedResponse response = api.removeUserFromGroups(userId, body);

        // TODO: test validations
    }

    /**
     * Remove users from a group.
     *
     * An endpoint for removing users from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeUsersFromGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeUsersFromGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color to its default in the dark theme. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void resetDarkColorTest() {
        String reference = null;
        // BrandingColor response = api.resetDarkColor(reference);

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color to its default in the light theme. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void resetLightColorTest() {
        String reference = null;
        // BrandingColor response = api.resetLightColor(reference);

        // TODO: test validations
    }

    /**
     * Updates a branding color in the dark theme.
     *
     * An endpoint for updating a branding color in the dark theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/primary -d &#39;{ \&quot;color\&quot;:
     * \&quot;#f3f93e\&quot; }&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void setDarkColorTest() {
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setDarkColor(reference, body);

        // TODO: test validations
    }

    /**
     * Updates a branding color in the light theme.
     *
     * An endpoint for updating a branding color in the light theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/primary -d &#39;{ \&quot;color\&quot;:
     * \&quot;purple\&quot; }&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void setLightColorTest() {
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setLightColor(reference, body);

        // TODO: test validations
    }

    /**
     * Update the group name.
     *
     * An endpoint for updating a group name. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -d &#39;{\&quot;name\&quot;:
     * \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void updateGroupNameTest() {
        String groupId = null;
        GroupUpdateInfo body = null;
        // UpdatedResponse response = api.updateGroupName(groupId, body);

        // TODO: test validations
    }

    /**
     * Update an existing identity provider.
     *
     * An endpoint for updating an existing identity provider.
     */
    @Test
    public void updateIdentityProviderTest() {
        String identityProviderId = null;
        IdentityProviderUpdateReq body = null;
        // IdentityProviderInfo response = api.updateIdentityProvider(identityProviderId, body);

        // TODO: test validations
    }

    /**
     * Updates attributes of the account.
     *
     * An endpoint for updating the account. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me -d &#39;{\&quot;phone_number\&quot;:
     * \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * An endpoint for updating user details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -d &#39;{\&quot;username\&quot;:
     * \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void updateUserTest() {
        String userId = null;
        UserUpdateReq body = null;
        // UserInfoResp response = api.updateUser(userId, body);

        // TODO: test validations
    }

    /**
     * Upload an image in the dark theme.
     *
     * An endpoint for uploading a new account branding image in the dark theme in PNG or JPEG format. **Example
     * usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/upload -H
     * &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary
     * &#39;myimage.png&#39;&#x60;
     */
    @Test
    public void uploadDarkImageTest() {
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadDarkImage(reference, body);

        // TODO: test validations
    }

    /**
     * Upload an image in the light theme.
     *
     * An endpoint for uploading a new account branding image in the light theme in PNG or JPEG format. **Example
     * usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/upload -H
     * &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary
     * &#39;myimage.png&#39;&#x60;
     */
    @Test
    public void uploadLightImageTest() {
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadLightImage(reference, body);

        // TODO: test validations
    }
}
