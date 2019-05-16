package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountUserInvitationsApi
 */
public class AccountUserInvitationsApiTest {

    private AccountUserInvitationsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountUserInvitationsApi.class);
    }

    /**
     * Create a user invitation.
     *
     * Invite a new or existing user. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\
     * -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;}
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void createInvitationTest() {
        UserInvitationReq body = null;
        // UserInvitationResp response = api.createInvitation(body);

        // TODO: test validations
    }

    /**
     * Delete a user invitation.
     *
     * Delete an active user invitation sent to a new or existing user. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteInvitationTest() {
        String invitationId = null;
        // Void response = api.deleteInvitation(invitationId);

        // TODO: test validations
    }

    /**
     * Get the details of all user invitations.
     *
     * Retrieve details for all the active user invitations. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllInvitationsTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String loginProfilesEq = null;
        // UserInvitationRespList response = api.getAllInvitations(limit, after, order, loginProfilesEq);

        // TODO: test validations
    }

    /**
     * Details of a user invitation.
     *
     * Retrieve the details of an active user invitation. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getInvitationTest() {
        String invitationId = null;
        // UserInvitationResp response = api.getInvitation(invitationId);

        // TODO: test validations
    }
}
