package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsUserInvitationsApi
 */
public class TenantAccountsUserInvitationsApiTest {

    private TenantAccountsUserInvitationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsUserInvitationsApi.class);
    }

    /**
     * Create a user invitation.
     *
     * Invite a new or existing user. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accouns/{account_id}/user-invitations \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} &#x60;&#x60;&#x60;
     */
    @Test
    public void createAccountInvitationTest() {
        String accountId = null;
        UserInvitationReq body = null;
        // UserInvitationResp response = api.createAccountInvitation(accountId, body);

        // TODO: test validations
    }

    /**
     * Delete a user invitation.
     *
     * Delete an active user invitation sent to a new or existing user. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteAccountInvitationTest() {
        String accountId = null;
        String invitationId = null;
        // Void response = api.deleteAccountInvitation(accountId, invitationId);

        // TODO: test validations
    }

    /**
     * Details of a user invitation.
     *
     * Retrieve details of an active user invitation sent for a new or existing user. **Example:** &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountInvitationTest() {
        String accountId = null;
        String invitationId = null;
        // UserInvitationResp response = api.getAccountInvitation(accountId, invitationId);

        // TODO: test validations
    }

    /**
     * Get the details of all user invitations.
     *
     * Retrieve details of all active user invitations sent for new or existing users. **Example:** &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountInvitationsTest() {
        String accountId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String loginProfilesEq = null;
        // UserInvitationRespList response = api.getAllAccountInvitations(accountId, limit, after, order,
        // loginProfilesEq);

        // TODO: test validations
    }
}
