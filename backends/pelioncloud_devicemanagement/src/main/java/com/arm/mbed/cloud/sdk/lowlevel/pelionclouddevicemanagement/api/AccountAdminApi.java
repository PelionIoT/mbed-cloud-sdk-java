package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateGenerationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummary;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.IdentityProviderUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationEntryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;

import java.util.List;

public interface AccountAdminApi {
    /**
     * Add API key to a list of groups. An endpoint for adding API key to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to be added to the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/{apikey_id}/groups")
    Call<UpdatedResponse> addApiKeyToGroups(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                            @retrofit2.http.Body List<String> body);

    /**
     * Upload a new trusted certificate. An endpoint for uploading new trusted certificates. **Example usage:**
     * &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -d {\&quot;name\&quot;:
     * \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;:
     * \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type:
     * application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            A trusted certificate object with attributes. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/trusted-certificates")
    Call<TrustedCertificateResp> addCertificate(@retrofit2.http.Body TrustedCertificateReq body);

    /**
     * Add members to a group. An endpoint for adding users and API keys to a group. **Example usage:** &#x60;curl -X
     * POST https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -d &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param groupId
     *            The ID of the group to be updated. (required)
     * @param body
     *            A list of users and API keys to be added to the group. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/policy-groups/{group_id}")
    Call<UpdatedResponse> addSubjectsToGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                             @retrofit2.http.Body SubjectList body);

    /**
     * Add user to a list of groups. An endpoint for adding user to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param userId
     *            The ID of the user to be added to the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/users/{user_id}/groups")
    Call<UpdatedResponse> addUserToGroups(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                          @retrofit2.http.Body List<String> body);

    /**
     * Updates an array of branding colors in the dark theme. An endpoint for updating an array of branding colors in
     * the dark theme. **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark
     * &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/dark")
    Call<Void> bulkSetDarkColors(@retrofit2.http.Body List<BrandingColor> body);

    /**
     * Updates an array of branding colors in the light theme. An endpoint for updating an array of branding colors in
     * the light theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; -H &#39;content-type:
     * application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/light")
    Call<Void> bulkSetLightColors(@retrofit2.http.Body List<BrandingColor> body);

    /**
     * Revert an image to default in the dark theme. An endpoint for reverting an account branding image to default in
     * the dark theme. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/clear -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/branding-images/dark/{reference}/clear")
    Call<Void> clearDarkImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Revert an image to default in the light theme. An endpoint for reverting an account branding image to default in
     * the light theme. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/clear -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/branding-images/light/{reference}/clear")
    Call<Void> clearLightImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Create a new group. An endpoint for creating a new group. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            Details of the group to be created. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/policy-groups")
    Call<GroupSummary> createGroup(@retrofit2.http.Body GroupCreationInfo body);

    /**
     * Create a new identity provider. An endpoint for creating a new identity provider.
     * 
     * @param body
     *            Details of the identity provider to be created. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/identity-providers")
    Call<IdentityProviderInfo> createIdentityProvider(@retrofit2.http.Body IdentityProviderCreationReq body);

    /**
     * Create a user invitation. An endpoint for inviting a new or an existing user to join the account. **Example
     * usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/user-invitations -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param body
     *            A user invitation object with attributes. (required)
     * @return Call&lt;UserInvitationResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/user-invitations")
    Call<UserInvitationResp> createInvitation(@retrofit2.http.Body UserInvitationReq body);

    /**
     * Create a new user. An endpoint for creating or inviting a new user to the account. In case of invitation email
     * address is used only, other attributes are set in the 2nd step. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/users?action&#x3D;invite -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param body
     *            A user object with attributes. (required)
     * @param action
     *            Action, either &#39;create&#39; or &#39;invite&#39;. (optional, default to create)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/users")
    Call<UserInfoResp> createUser(@retrofit2.http.Body UserInfoReq body, @retrofit2.http.Query("action") String action);

    /**
     * Delete a group. An endpoint for deleting a group. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param groupId
     *            The ID of the group to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/policy-groups/{group_id}")
    Call<Void> deleteGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId);

    /**
     * Delete an identity provider by ID. An endpoint for deleting an identity provider by ID.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/identity-providers/{identity_provider_id}")
    Call<Void> deleteIdentityProvider(@retrofit2.http.Path(value = "identity_provider_id",
                                                           encoded = true) String identityProviderId);

    /**
     * Delete a user invitation. An endpoint for deleting an active user invitation which has been sent for a new or an
     * existing user to join the account. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param invitationId
     *            The ID of the invitation to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/user-invitations/{invitation_id}")
    Call<Void> deleteInvitation(@retrofit2.http.Path(value = "invitation_id", encoded = true) String invitationId);

    /**
     * Delete the service provider certificate. An endpoint for deleting the service provider certificate.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to which the certificate should be deleted. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/identity-providers/{identity_provider_id}/delete-sp-certificate")
    Call<IdentityProviderInfo> deleteSpCertificate(@retrofit2.http.Path(value = "identity_provider_id",
                                                                        encoded = true) String identityProviderId);

    /**
     * Delete a user. An endpoint for deleting a user. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param userId
     *            The ID of the user to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/users/{user_id}")
    Call<Void> deleteUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Generate a new service provider certificate. An endpoint for generating a new service provider certificate.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to which the certificate should be generated for. (required)
     * @param body
     *            Details of the service provider certificate to be generated. (optional)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/identity-providers/{identity_provider_id}/generate-sp-certificate")
    Call<IdentityProviderInfo> generateSpCertificate(
                                                     @retrofit2.http.Path(value = "identity_provider_id",
                                                                          encoded = true) String identityProviderId,
                                                     @retrofit2.http.Body CertificateGenerationReq body);

    /**
     * Get all identity providers. An endpoint for retrieving identity providers in an array.
     * 
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; default ASC. (optional, default to ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count. (optional)
     * @return Call&lt;IdentityProviderList&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @GET("v3/identity-providers")
    Call<IdentityProviderList> getAllIdentityProviders(@retrofit2.http.Query("limit") Integer limit,
                                                       @retrofit2.http.Query("after") String after,
                                                       @retrofit2.http.Query("order") String order,
                                                       @retrofit2.http.Query("include") String include);

    /**
     * Get the details of all the user invitations. An endpoint for retrieving the details of all the active user
     * invitations sent for new or existing users to join the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param loginProfileEq
     *            Filter for getting user invitations by a specified login profile. (optional)
     * @return Call&lt;UserInvitationRespList&gt;
     */
    @GET("v3/user-invitations")
    Call<UserInvitationRespList> getAllInvitations(@retrofit2.http.Query("limit") Integer limit,
                                                   @retrofit2.http.Query("after") String after,
                                                   @retrofit2.http.Query("order") String order,
                                                   @retrofit2.http.Query("login_profile__eq") String loginProfileEq);

    /**
     * Get the details of all users. An endpoint for retrieving the details of all users. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @param emailEq
     *            Filter for email address (optional)
     * @param statusEq
     *            Filter for status, for example active or reset (optional)
     * @param statusIn
     *            An optional filter for getting users with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter for excluding users with a specified set of statuses. (optional)
     * @param loginProfileEq
     *            An optional filter for getting users with a specified login profile. (optional)
     * @return Call&lt;UserInfoRespList&gt;
     */
    @GET("v3/users")
    Call<UserInfoRespList>
        getAllUsers(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                    @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                    @retrofit2.http.Query("email__eq") String emailEq,
                    @retrofit2.http.Query("status__eq") String statusEq,
                    @retrofit2.http.Query("status__in") String statusIn,
                    @retrofit2.http.Query("status__nin") String statusNin,
                    @retrofit2.http.Query("login_profile__eq") String loginProfileEq);

    /**
     * Get groups of the API key. An endpoint for retrieving groups of the API key. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key whose details are retrieved. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/api-keys/{apikey_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfApikey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                          @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                          @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include);

    /**
     * Get groups of the user. An endpoint for retrieving groups of the user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param userId
     *            The ID of the user whose details are retrieved. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/users/{user_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                        @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                        @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include);

    /**
     * Get identity provider by ID. An endpoint for retrieving an identity provider by ID.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to be retrieved. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @GET("v3/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo> getIdentityProvider(@retrofit2.http.Path(value = "identity_provider_id",
                                                                        encoded = true) String identityProviderId);

    /**
     * Details of a user invitation. An endpoint for retrieving the details of an active user invitation sent for a new
     * or an existing user to join the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param invitationId
     *            The ID of the invitation to be retrieved. (required)
     * @return Call&lt;UserInvitationResp&gt;
     */
    @GET("v3/user-invitations/{invitation_id}")
    Call<UserInvitationResp>
        getInvitation(@retrofit2.http.Path(value = "invitation_id", encoded = true) String invitationId);

    /**
     * Get the notification events of an account. Endpoint for retrieving notifications.
     * 
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @return Call&lt;NotificationEntryList&gt;
     */
    @GET("v3/accounts/me/notifications")
    Call<NotificationEntryList> getNofificationEntries(@retrofit2.http.Query("limit") Integer limit,
                                                       @retrofit2.http.Query("after") String after,
                                                       @retrofit2.http.Query("order") String order);

    /**
     * Details of a user. An endpoint for retrieving the details of a user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param userId
     *            The ID of the user whose details are retrieved. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @GET("v3/users/{user_id}")
    Call<UserInfoResp> getUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Get users of a group. An endpoint for listing the users of a group with details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param groupId
     *            The ID of the group whose users are retrieved. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @param statusEq
     *            An optional filter for getting users by status. (optional)
     * @param statusIn
     *            An optional filter for getting users with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter for excluding users with a specified set of statuses. (optional)
     * @return Call&lt;UserInfoRespList&gt;
     */
    @GET("v3/policy-groups/{group_id}/users")
    Call<UserInfoRespList>
        getUsersOfGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                        @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                        @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                        @retrofit2.http.Query("status__eq") String statusEq,
                        @retrofit2.http.Query("status__in") String statusIn,
                        @retrofit2.http.Query("status__nin") String statusNin);

    /**
     * Remove API key from groups. An endpoint for removing API key from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to be removed from the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/api-keys/{apikey_id}/groups")
    Call<UpdatedResponse>
        removeApiKeyFromGroups(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                               @retrofit2.http.Body List<String> body);

    /**
     * Remove user from groups. An endpoint for removing user from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param userId
     *            The ID of the user to be removed from the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/users/{user_id}/groups")
    Call<UpdatedResponse> removeUserFromGroups(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                               @retrofit2.http.Body List<String> body);

    /**
     * Remove users from a group. An endpoint for removing users from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/users -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param groupId
     *            The ID of the group whose users are removed. (required)
     * @param body
     *            A list of users to be removed from the group. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/policy-groups/{group_id}/users")
    Call<UpdatedResponse> removeUsersFromGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                               @retrofit2.http.Body SubjectList body);

    /**
     * Reset branding color to default. Resets the branding color to its default in the dark theme. **Example usage:**
     * &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @DELETE("v3/branding-colors/dark/{reference}")
    Call<BrandingColor> resetDarkColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Reset branding color to default. Resets the branding color to its default in the light theme. **Example usage:**
     * &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @DELETE("v3/branding-colors/light/{reference}")
    Call<BrandingColor> resetLightColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Updates a branding color in the dark theme. An endpoint for updating a branding color in the dark theme.
     * **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/primary -d
     * &#39;{ \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/dark/{reference}")
    Call<BrandingColor> setDarkColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                     @retrofit2.http.Body BrandingColor body);

    /**
     * Updates a branding color in the light theme. An endpoint for updating a branding color in the light theme.
     * **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/primary -d
     * &#39;{ \&quot;color\&quot;: \&quot;purple\&quot; }&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/light/{reference}")
    Call<BrandingColor> setLightColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                      @retrofit2.http.Body BrandingColor body);

    /**
     * Update the group name. An endpoint for updating a group name. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -d &#39;{\&quot;name\&quot;:
     * \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param groupId
     *            The ID of the group to be updated. (required)
     * @param body
     *            Details of the group to be created. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/policy-groups/{group_id}")
    Call<UpdatedResponse> updateGroupName(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                          @retrofit2.http.Body GroupUpdateInfo body);

    /**
     * Update an existing identity provider. An endpoint for updating an existing identity provider.
     * 
     * @param identityProviderId
     *            The ID of the identity provider to be updated. (required)
     * @param body
     *            Details of the identity provider to be updated. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo> updateIdentityProvider(
                                                      @retrofit2.http.Path(value = "identity_provider_id",
                                                                           encoded = true) String identityProviderId,
                                                      @retrofit2.http.Body IdentityProviderUpdateReq body);

    /**
     * Updates attributes of the account. An endpoint for updating the account. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me -d &#39;{\&quot;phone_number\&quot;:
     * \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param body
     *            Details of the account to be updated. (required)
     * @return Call&lt;AccountInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/me")
    Call<AccountInfo> updateMyAccount(@retrofit2.http.Body AccountUpdateReq body);

    /**
     * Update user details. An endpoint for updating user details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/users/{user_id} -d &#39;{\&quot;username\&quot;:
     * \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param userId
     *            The ID of the user whose details are updated. (required)
     * @param body
     *            A user object with attributes. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/users/{user_id}")
    Call<UserInfoResp> updateUser(@retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                  @retrofit2.http.Body UserUpdateReq body);

    /**
     * Upload an image in the dark theme. An endpoint for uploading a new account branding image in the dark theme in
     * PNG or JPEG format. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/upload -H &#39;content-type:
     * image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary &#39;myimage.png&#39;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param body
     *            The image in PNG or JPEG format. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @Headers({ "Content-Type:image/png" })
    @POST("v3/branding-images/dark/{reference}/upload")
    Call<BrandingImage> uploadDarkImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                        @retrofit2.http.Body String body);

    /**
     * Upload an image in the dark theme. An endpoint for uploading a new account branding image as form data in the
     * dark theme in PNG or JPEG format.
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param image
     *            The image in PNG or JPEG format as multipart form data. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/branding-images/dark/{reference}/upload-multipart")
    Call<BrandingImage>
        uploadDarkImageMultipart(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                 @retrofit2.http.Part() MultipartBody.Part image);

    /**
     * Upload an image in the light theme. An endpoint for uploading a new account branding image in the light theme in
     * PNG or JPEG format. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/upload -H &#39;content-type:
     * image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary &#39;myimage.png&#39;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param body
     *            The image in PNG or JPEG format. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @Headers({ "Content-Type:image/png" })
    @POST("v3/branding-images/light/{reference}/upload")
    Call<BrandingImage> uploadLightImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                         @retrofit2.http.Body String body);

    /**
     * Upload an image in the light theme. An endpoint for uploading a new account branding image as form data in the
     * light theme in PNG or JPEG format.
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param image
     *            The image in PNG or JPEG format as multipart form data. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/branding-images/light/{reference}/upload-multipart")
    Call<BrandingImage>
        uploadLightImageMultipart(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                  @retrofit2.http.Part() MultipartBody.Part image);

}
