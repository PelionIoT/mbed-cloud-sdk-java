package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationRespList;

public interface AccountUserInvitationsApi {
    /**
     * Create a user invitation. Invite a new or existing user. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\
     * -H &#39;content-type: application/json&#39; \\ -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;}
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            A user invitation object with attributes. (required)
     * @return Call&lt;UserInvitationResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/user-invitations")
    Call<UserInvitationResp> createInvitation(@retrofit2.http.Body UserInvitationReq body);

    /**
     * Delete a user invitation. Delete an active user invitation sent to a new or existing user. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param invitationId
     *            The ID of the invitation to delete. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/user-invitations/{invitation_id}")
    Call<Void> deleteInvitation(@retrofit2.http.Path(value = "invitation_id", encoded = true) String invitationId);

    /**
     * Get the details of all user invitations. Retrieve details for all the active user invitations. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/user-invitations \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            The number of results to return (2-1000). Default 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order based on creation time. Acceptable values: ASC, DESC. Default: ASC. (optional, default to
     *            ASC)
     * @param loginProfilesEq
     *            Filter to retrieve user invitations by a specified login profile. (optional)
     * @return Call&lt;UserInvitationRespList&gt;
     */
    @GET("v3/user-invitations")
    Call<UserInvitationRespList> getAllInvitations(@retrofit2.http.Query("limit") Integer limit,
                                                   @retrofit2.http.Query("after") String after,
                                                   @retrofit2.http.Query("order") String order,
                                                   @retrofit2.http.Query("login_profiles__eq") String loginProfilesEq);

    /**
     * Details of a user invitation. Retrieve the details of an active user invitation. **Example:** &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param invitationId
     *            The ID of the invitation to retrieve. (required)
     * @return Call&lt;UserInvitationResp&gt;
     */
    @GET("v3/user-invitations/{invitation_id}")
    Call<UserInvitationResp>
        getInvitation(@retrofit2.http.Path(value = "invitation_id", encoded = true) String invitationId);

}
