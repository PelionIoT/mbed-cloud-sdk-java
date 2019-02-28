package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountInfoList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateRootReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColorList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImageList;
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
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInvitationRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserUpdateReq;

import java.util.List;

public interface AggregatorAccountAdminApi {
    /**
     * Add API key to a list of groups. An endpoint for adding API key to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to be added to the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/api-keys/{apikey_id}/groups")
    Call<UpdatedResponse>
        addAccountApiKeyToGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                 @retrofit2.http.Body List<String> body);

    /**
     * Upload new trusted certificate. An endpoint for uploading new trusted certificates. **Example usage:** &#x60;curl
     * -X POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates -d {\&quot;name\&quot;:
     * \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;:
     * \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type:
     * application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            A trusted certificate object with attributes, signature is optional. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/trusted-certificates")
    Call<TrustedCertificateResp>
        addAccountCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                              @retrofit2.http.Body TrustedCertificateReq body);

    /**
     * Add user to a list of groups. An endpoint for adding user to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to be added to the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/users/{user_id}/groups")
    Call<UpdatedResponse>
        addAccountUserToGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                               @retrofit2.http.Body List<String> body);

    /**
     * Add members to a group. An endpoint for adding users and API keys to groups. **Example usage:** &#x60;curl -X
     * POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -d
     * &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param groupId
     *            The ID of the group to be updated. (required)
     * @param body
     *            A list of users and API keys to be added to the group. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/policy-groups/{group_id}")
    Call<UpdatedResponse>
        addSubjectsToAccountGroup(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                  @retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                  @retrofit2.http.Body SubjectList body);

    /**
     * Updates an array of branding colors in the dark theme. An endpoint for updating an array of branding colors in
     * the dark theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark &#39;[{
     * \&quot;reference\&quot;: \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/dark")
    Call<Void> bulkSetAccountDarkColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                        @retrofit2.http.Body List<BrandingColor> body);

    /**
     * Updates an array of branding colors in the light theme. An endpoint for updating an array of branding colors in
     * the light theme. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light &#39;[{
     * \&quot;reference\&quot;: \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/light")
    Call<Void> bulkSetAccountLightColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                         @retrofit2.http.Body List<BrandingColor> body);

    /**
     * Revert an image to default in the dark theme. An endpoint for reverting an account branding image to default in
     * the dark theme. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/clear -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/accounts/{account_id}/branding-images/dark/{reference}/clear")
    Call<Void> clearAccountDarkImage(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                     @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Revert an image to default in the light theme. An endpoint for reverting an account branding image to default in
     * the light theme. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/clear -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/accounts/{account_id}/branding-images/light/{reference}/clear")
    Call<Void> clearAccountLightImage(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Create a new account. An endpoint for creating a new account. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;,
     * \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;:
     * \&quot;example_admin@myaccount.info\&quot;, \&quot;country\&quot;: \&quot;United Kingdom\&quot;,
     * \&quot;end_market\&quot;: \&quot;Smart City\&quot;, \&quot;address_line1\&quot;: \&quot;110 Fulbourn Rd\&quot;,
     * \&quot;city\&quot;: \&quot;Cambridge\&quot;, \&quot;contact\&quot;: \&quot;J. Doe\&quot;, \&quot;company\&quot;:
     * \&quot;Arm\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param body
     *            Details of the account to be created. (required)
     * @param action
     *            Action, either &#39;create&#39; or &#39;enroll&#39;. &lt;ul&gt;&lt;li&gt;&#39;create&#39; creates the
     *            account where its admin user has ACTIVE status if admin_password was defined in the request, or RESET
     *            status if no admin_password was defined. If the user already exists, its status is not modified.
     *            &lt;/li&gt;&lt;li&gt;&#39;enroll&#39; creates the account where its admin user has ENROLLING status.
     *            If the user already exists, its status is not modified. Email to finish the enrollment or to notify
     *            the existing user about the new account is sent to the admin_email defined in the request.
     *            &lt;/li&gt;&lt;/ul&gt; (optional, default to create)
     * @return Call&lt;AccountInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts")
    Call<AccountInfo> createAccount(@retrofit2.http.Body AccountCreationReq body,
                                    @retrofit2.http.Query("action") String action);

    /**
     * Create a new API key. An endpoint for creating a new API key. There is no default value for the owner ID and it
     * must be from the same account where the new API key is created. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys -d &#39;{\&quot;name\&quot;:
     * \&quot;MyKey1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            Details of the API key to be created. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/api-keys")
    Call<ApiKeyInfoResp>
        createAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                            @retrofit2.http.Body ApiKeyInfoReq body);

    /**
     * Create a new group. An endpoint for creating a new group. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups -d &#39;{\&quot;name\&quot;:
     * \&quot;MyGroup1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            Details of the group to be created. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/policy-groups")
    Call<GroupSummary> createAccountGroup(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                          @retrofit2.http.Body GroupCreationInfo body);

    /**
     * Create a new identity provider. An endpoint for creating a new identity provider.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            Details of the identity provider to be created. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/identity-providers")
    Call<IdentityProviderInfo>
        createAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Body IdentityProviderCreationReq body);

    /**
     * Create a user invitation. An endpoint for inviting a new or an existing user to join the account. **Example
     * usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/accouns/{account_id}/user-invitations -d
     * {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            A user invitation object with attributes. (required)
     * @return Call&lt;UserInvitationResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/user-invitations")
    Call<UserInvitationResp>
        createAccountInvitation(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                @retrofit2.http.Body UserInvitationReq body);

    /**
     * Create a new user. An endpoint for creating or inviting a new user to the account. In case of invitation email
     * address is used only, other attributes are set in the 2nd step. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users -d {\&quot;email\&quot;:
     * \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            A user object with attributes. (required)
     * @param action
     *            Create or invite user. (optional, default to create)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/users")
    Call<UserInfoResp> createAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                         @retrofit2.http.Body UserInfoReq body,
                                         @retrofit2.http.Query("action") String action);

    /**
     * Delete the API key. An endpoint for deleting an API key. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/api-keys/{apikey_id}")
    Call<Void> deleteAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                   @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Delete trusted certificate by ID. An endpoint for deleting the trusted certificate. **Example usage:** &#x60;curl
     * -X DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param certId
     *            The ID of the trusted certificate to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/trusted-certificates/{cert_id}")
    Call<Void> deleteAccountCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                        @retrofit2.http.Path(value = "cert_id", encoded = true) String certId);

    /**
     * Delete a group. An endpoint for deleting a group. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param groupId
     *            The ID of the group to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/policy-groups/{group_id}")
    Call<Void> deleteAccountGroup(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                  @retrofit2.http.Path(value = "group_id", encoded = true) String groupId);

    /**
     * Delete an identity provider by ID. An endpoint for deleting an identity provider by ID.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/identity-providers/{identity_provider_id}")
    Call<Void>
        deleteAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "identity_provider_id",
                                                           encoded = true) String identityProviderId);

    /**
     * Delete a user invitation. An endpoint for deleting an active user invitation which has been sent for a new or an
     * existing user to join the account. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param invitationId
     *            The ID of the invitation to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/user-invitations/{invitation_id}")
    Call<Void>
        deleteAccountInvitation(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                @retrofit2.http.Path(value = "invitation_id", encoded = true) String invitationId);

    /**
     * Delete the service provider certificate. An endpoint for deleting the service provider certificate.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to which the certificate should be deleted. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/identity-providers/{identity_provider_id}/delete-sp-certificate")
    Call<IdentityProviderInfo>
        deleteAccountSpCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                   @retrofit2.http.Path(value = "identity_provider_id",
                                                        encoded = true) String identityProviderId);

    /**
     * Delete a user. An endpoint for deleting a user. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/users/{user_id}")
    Call<Void> deleteAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Generate a new service provider certificate. An endpoint for generating a new service provider certificate.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to which the certificate should be generated for. (required)
     * @param body
     *            Details of the service provider certificate to be generated. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts/{account_id}/identity-providers/{identity_provider_id}/generate-sp-certificate")
    Call<IdentityProviderInfo>
        generateAccountSpCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                     @retrofit2.http.Path(value = "identity_provider_id",
                                                          encoded = true) String identityProviderId,
                                     @retrofit2.http.Body CertificateGenerationReq body);

    /**
     * Get API key details. An endpoint for retrieving API key details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to be retrieved. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @GET("v3/accounts/{account_id}/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp> getAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                          @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Get trusted certificate by ID. An endpoint for retrieving a trusted certificate by ID. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param certId
     *            The ID of the trusted certificate to be retrieved. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @GET("v3/accounts/{account_id}/trusted-certificates/{cert_id}")
    Call<TrustedCertificateResp>
        getAccountCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                              @retrofit2.http.Path(value = "cert_id", encoded = true) String certId);

    /**
     * Get branding color of the dark theme. Returns the requested branding color of the dark theme. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/dark/{reference}")
    Call<BrandingColor> getAccountDarkColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                            @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get branding colors of the dark theme. Returns the branding colors of the dark theme. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/dark")
    Call<BrandingColorList>
        getAccountDarkColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get metadata of an image in the dark theme. An endpoint for getting metadata of one account branding image in the
     * dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("v3/accounts/{account_id}/branding-images/dark/{reference}")
    Call<BrandingImage>
        getAccountDarkImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get group information. An endpoint for getting general information about the group. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id} -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param groupId
     *            The ID of the group to be retrieved. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @GET("v3/accounts/{account_id}/policy-groups/{group_id}")
    Call<GroupSummary>
        getAccountGroupSummary(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "group_id", encoded = true) String groupId);

    /**
     * Get identity provider by ID. An endpoint for retrieving an identity provider by ID.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to be retrieved. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @GET("v3/accounts/{account_id}/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo>
        getAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                   @retrofit2.http.Path(value = "identity_provider_id",
                                                        encoded = true) String identityProviderId);

    /**
     * Get account info. Returns detailed information about the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.
     * 
     * @param accountId
     *            The ID of the account to be fetched. (required)
     * @param include
     *            Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
     *            (optional)
     * @param properties
     *            Property name to be returned from account specific properties. (optional)
     * @return Call&lt;AccountInfo&gt;
     */
    @GET("v3/accounts/{account_id}")
    Call<AccountInfo> getAccountInfo(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                     @retrofit2.http.Query("include") String include,
                                     @retrofit2.http.Query("properties") String properties);

    /**
     * Details of a user invitation. An endpoint for retrieving the details of an active user invitation sent for a new
     * or an existing user to join the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations/{invitation_id} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param invitationId
     *            The ID of the invitation to be retrieved. (required)
     * @return Call&lt;UserInvitationResp&gt;
     */
    @GET("v3/accounts/{account_id}/user-invitations/{invitation_id}")
    Call<UserInvitationResp>
        getAccountInvitation(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                             @retrofit2.http.Path(value = "invitation_id", encoded = true) String invitationId);

    /**
     * Get branding color of the light theme. Returns the requested branding color of the light theme. **Example
     * usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/light/{reference}")
    Call<BrandingColor>
        getAccountLightColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                             @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get branding colors of the light theme. Returns the branding colors of the light theme. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/light")
    Call<BrandingColorList>
        getAccountLightColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get metadata of an image in the light theme. An endpoint for getting metadata of one account branding image in
     * the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("v3/accounts/{account_id}/branding-images/light/{reference}")
    Call<BrandingImage>
        getAccountLightImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get the notification events of an account. Endpoint for retrieving notifications.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @return Call&lt;NotificationEntryList&gt;
     */
    @GET("v3/accounts/{account_id}/notifications")
    Call<NotificationEntryList>
        getAccountNofificationEntries(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Query("limit") Integer limit,
                                      @retrofit2.http.Query("after") String after,
                                      @retrofit2.http.Query("order") String order);

    /**
     * Details of the user. An endpoint for retrieving details of the user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to be retrieved. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @GET("v3/accounts/{account_id}/users/{user_id}")
    Call<UserInfoResp> getAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "user_id", encoded = true) String userId);

    /**
     * Get all API keys. An endpoint for retrieving the API keys in an array, optionally filtered by the owner.
     * **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @param keyEq
     *            API key filter. Do not include the private part of the API key (the last 32 characters). (optional)
     * @param ownerEq
     *            Owner name filter. (optional)
     * @return Call&lt;ApiKeyInfoRespList&gt;
     */
    @GET("v3/accounts/{account_id}/api-keys")
    Call<ApiKeyInfoRespList>
        getAllAccountApiKeys(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                             @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                             @retrofit2.http.Query("order") String order,
                             @retrofit2.http.Query("include") String include,
                             @retrofit2.http.Query("key__eq") String keyEq,
                             @retrofit2.http.Query("owner__eq") String ownerEq);

    /**
     * Get all trusted certificates. An endpoint for retrieving trusted certificates in an array. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @param nameEq
     *            Filter for certificate name (optional)
     * @param serviceEq
     *            Filter for service (optional)
     * @param expireEq
     *            Filter for expire (optional)
     * @param deviceExecutionModeEq
     *            Filter for developer certificates (optional)
     * @param deviceExecutionModeNeq
     *            Filter for not developer certificates (optional)
     * @param ownerEq
     *            Owner name filter (optional)
     * @param enrollmentModeEq
     *            Enrollment mode filter (optional)
     * @param statusEq
     *            Filter for certificate status (optional)
     * @param issuerLike
     *            Filter for issuer. Finds all matches where the filter value is a case insensitive substring of the
     *            result. Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. (optional)
     * @param subjectLike
     *            Filter for subject. Finds all matches where the filter value is a case insensitive substring of the
     *            result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. (optional)
     * @param validEq
     *            Filter for finding certificates by validity. True returns certificates which are not yet expired.
     *            False returns certificates which have expired. (optional)
     * @return Call&lt;TrustedCertificateRespList&gt;
     */
    @GET("v3/accounts/{account_id}/trusted-certificates")
    Call<TrustedCertificateRespList>
        getAllAccountCertificates(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                  @retrofit2.http.Query("limit") Integer limit,
                                  @retrofit2.http.Query("after") String after,
                                  @retrofit2.http.Query("order") String order,
                                  @retrofit2.http.Query("include") String include,
                                  @retrofit2.http.Query("name__eq") String nameEq,
                                  @retrofit2.http.Query("service__eq") String serviceEq,
                                  @retrofit2.http.Query("expire__eq") Integer expireEq,
                                  @retrofit2.http.Query("device_execution_mode__eq") Integer deviceExecutionModeEq,
                                  @retrofit2.http.Query("device_execution_mode__neq") Integer deviceExecutionModeNeq,
                                  @retrofit2.http.Query("owner__eq") String ownerEq,
                                  @retrofit2.http.Query("enrollment_mode__eq") Boolean enrollmentModeEq,
                                  @retrofit2.http.Query("status__eq") String statusEq,
                                  @retrofit2.http.Query("issuer__like") String issuerLike,
                                  @retrofit2.http.Query("subject__like") String subjectLike,
                                  @retrofit2.http.Query("valid__eq") Boolean validEq);

    /**
     * Get metadata of all images in the dark theme. Returns the metadata of all branding images in the dark theme.
     * **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark
     * -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("v3/accounts/{account_id}/branding-images/dark")
    Call<BrandingImageList>
        getAllAccountDarkImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get all group information. An endpoint for retrieving all group information. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @param nameEq
     *            Filter for group name (optional)
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/accounts/{account_id}/policy-groups")
    Call<GroupSummaryList>
        getAllAccountGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                            @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                            @retrofit2.http.Query("order") String order,
                            @retrofit2.http.Query("include") String include,
                            @retrofit2.http.Query("name__eq") String nameEq);

    /**
     * Get all identity providers. An endpoint for retrieving identity providers in an array.
     * 
     * @param accountId
     *            Account ID. (required)
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
    @GET("v3/accounts/{account_id}/identity-providers")
    Call<IdentityProviderList>
        getAllAccountIdentityProviders(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                       @retrofit2.http.Query("limit") Integer limit,
                                       @retrofit2.http.Query("after") String after,
                                       @retrofit2.http.Query("order") String order,
                                       @retrofit2.http.Query("include") String include);

    /**
     * Get the details of all the user invitations. An endpoint for retrieving the details of all the active user
     * invitations sent for new or existing users to join the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/user-invitations -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
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
    @GET("v3/accounts/{account_id}/user-invitations")
    Call<UserInvitationRespList>
        getAllAccountInvitations(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Query("limit") Integer limit,
                                 @retrofit2.http.Query("after") String after,
                                 @retrofit2.http.Query("order") String order,
                                 @retrofit2.http.Query("login_profile__eq") String loginProfileEq);

    /**
     * Get metadata of all images in the light theme. Returns the metadata of all branding images in the light theme.
     * **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light
     * -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("v3/accounts/{account_id}/branding-images/light")
    Call<BrandingImageList>
        getAllAccountLightImageData(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get all user details. An endpoint for retrieving details of all users. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
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
     *            Filter for status (optional)
     * @param statusIn
     *            An optional filter for getting users with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter for excluding users with a specified set of statuses. (optional)
     * @param loginProfileEq
     *            An optional filter for getting users with a specified login profile. (optional)
     * @return Call&lt;UserInfoRespList&gt;
     */
    @GET("v3/accounts/{account_id}/users")
    Call<UserInfoRespList>
        getAllAccountUsers(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                           @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                           @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                           @retrofit2.http.Query("email__eq") String emailEq,
                           @retrofit2.http.Query("status__eq") String statusEq,
                           @retrofit2.http.Query("status__in") String statusIn,
                           @retrofit2.http.Query("status__nin") String statusNin,
                           @retrofit2.http.Query("login_profile__eq") String loginProfileEq);

    /**
     * Get all accounts. Returns an array of account objects, optionally filtered by status and tier level. **Example
     * usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;.
     * 
     * @param statusEq
     *            An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED or SUSPENDED. (optional)
     * @param statusIn
     *            An optional filter for getting accounts with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter for excluding accounts with a specified set of statuses. (optional)
     * @param tierEq
     *            An optional filter for tier level, must be 0, 1, 2, 98, 99 or omitted. (optional)
     * @param parentEq
     *            An optional filter for parent account ID. (optional)
     * @param endMarketEq
     *            An optional filter for account end market. (optional)
     * @param countryLike
     *            An optional filter for account country. Finds all matches where the filter value is a case insensitive
     *            substring of the result. Example: country__like&#x3D;LAND matches Ireland. (optional)
     * @param limit
     *            The number of results to return (2-1000), default is 1000. (optional, default to 1000)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC. Default value is ASC (optional, default
     *            to ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: limits, policies, sub_accounts
     *            (optional)
     * @param format
     *            Format information for the response to the query, supported: format&#x3D;breakdown. (optional)
     * @param properties
     *            Property name to be returned from account specific properties. (optional)
     * @return Call&lt;AccountInfoList&gt;
     */
    @GET("v3/accounts")
    Call<AccountInfoList>
        getAllAccounts(@retrofit2.http.Query("status__eq") String statusEq,
                       @retrofit2.http.Query("status__in") String statusIn,
                       @retrofit2.http.Query("status__nin") String statusNin,
                       @retrofit2.http.Query("tier__eq") String tierEq,
                       @retrofit2.http.Query("parent__eq") String parentEq,
                       @retrofit2.http.Query("end_market__eq") String endMarketEq,
                       @retrofit2.http.Query("country__like") String countryLike,
                       @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                       @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                       @retrofit2.http.Query("format") String format,
                       @retrofit2.http.Query("properties") String properties);

    /**
     * Get API keys of a group. An endpoint for listing the API keys of the group with details. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param groupId
     *            The ID of the group whose API keys are retrieved. (required)
     * @param limit
     *            The number of results to return (2-1000), default is 50. (optional, default to 50)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to
     *            ASC)
     * @param include
     *            Comma separated additional data to return. Currently supported: total_count (optional)
     * @return Call&lt;ApiKeyInfoRespList&gt;
     */
    @GET("v3/accounts/{account_id}/policy-groups/{group_id}/api-keys")
    Call<ApiKeyInfoRespList>
        getApiKeysOfAccountGroup(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                 @retrofit2.http.Query("limit") Integer limit,
                                 @retrofit2.http.Query("after") String after,
                                 @retrofit2.http.Query("order") String order,
                                 @retrofit2.http.Query("include") String include);

    /**
     * Get groups of the API key. An endpoint for retrieving groups of the API key. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
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
    @GET("v3/accounts/{account_id}/api-keys/{apikey_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfAccountApikey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                 @retrofit2.http.Query("limit") Integer limit,
                                 @retrofit2.http.Query("after") String after,
                                 @retrofit2.http.Query("order") String order,
                                 @retrofit2.http.Query("include") String include);

    /**
     * Get groups of the user. An endpoint for retrieving groups of the user. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
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
    @GET("v3/accounts/{account_id}/users/{user_id}/groups")
    Call<GroupSummaryList>
        getGroupsOfAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                               @retrofit2.http.Query("limit") Integer limit,
                               @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order,
                               @retrofit2.http.Query("include") String include);

    /**
     * Get users of a group. An endpoint for listing users of the group with details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
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
    @GET("v3/accounts/{account_id}/policy-groups/{group_id}/users")
    Call<UserInfoRespList>
        getUsersOfAccountGroup(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                               @retrofit2.http.Query("limit") Integer limit,
                               @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order,
                               @retrofit2.http.Query("include") String include,
                               @retrofit2.http.Query("status__eq") String statusEq,
                               @retrofit2.http.Query("status__in") String statusIn,
                               @retrofit2.http.Query("status__nin") String statusNin);

    /**
     * Remove API key from groups. An endpoint for removing API key from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to be removed from the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/accounts/{account_id}/api-keys/{apikey_id}/groups")
    Call<UpdatedResponse>
        removeAccountApiKeyFromGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                      @retrofit2.http.Body List<String> body);

    /**
     * Remove user from groups. An endpoint for removing user from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to be removed from the group. (required)
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/accounts/{account_id}/users/{user_id}/groups")
    Call<UpdatedResponse>
        removeAccountUserFromGroups(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                    @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                    @retrofit2.http.Body List<String> body);

    /**
     * Remove API keys from a group. An endpoint for removing API keys from groups. **Example usage:** &#x60;curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/api-keys -d
     * &#39;{\&quot;apikeys\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param groupId
     *            The ID of the group from which the API keys are to be removed. (required)
     * @param body
     *            A list of API keys to be removed from the group. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/accounts/{account_id}/policy-groups/{group_id}/api-keys")
    Call<UpdatedResponse>
        removeApiKeysFromAccountGroup(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                      @retrofit2.http.Body SubjectList body);

    /**
     * Remove users from a group. An endpoint for removing users from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/users -d
     * &#39;{\&quot;users\&quot;:
     * [\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param groupId
     *            The ID of the group from which the users are to be removed. (required)
     * @param body
     *            A list of users to be removed from the group. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/accounts/{account_id}/policy-groups/{group_id}/users")
    Call<UpdatedResponse>
        removeUsersFromAccountGroup(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                    @retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                                    @retrofit2.http.Body SubjectList body);

    /**
     * Reset the secret key. An endpoint for resetting the secret key of the API key. **Example usage:** &#x60;curl -X
     * POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to be reset. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @POST("v3/accounts/{account_id}/api-keys/{apikey_id}/reset-secret")
    Call<ApiKeyInfoResp>
        resetAccountApiKeySecret(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Reset branding color to default. Resets the branding color to its default in the dark theme. **Example usage:**
     * &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @DELETE("v3/accounts/{account_id}/branding-colors/dark/{reference}")
    Call<BrandingColor>
        resetAccountDarkColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                              @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Reset branding color to default. Resets the branding color to its default in the light theme. **Example usage:**
     * &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @DELETE("v3/accounts/{account_id}/branding-colors/light/{reference}")
    Call<BrandingColor>
        resetAccountLightColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Updates a branding color in the dark theme. An endpoint for updating a branding color in the dark theme.
     * **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark/primary -d &#39;{
     * \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/dark/{reference}")
    Call<BrandingColor> setAccountDarkColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                            @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                            @retrofit2.http.Body BrandingColor body);

    /**
     * Updates a branding color in the light theme. An endpoint for updating a branding color in the light theme.
     * **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light/primary -d &#39;{
     * \&quot;color\&quot;: \&quot;purple\&quot; }&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/light/{reference}")
    Call<BrandingColor>
        setAccountLightColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                             @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                             @retrofit2.http.Body BrandingColor body);

    /**
     * Update attributes of an existing account. An endpoint for updating an account. **Example usage:** &#x60;curl -X
     * PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} -d &#39;{\&quot;phone_number\&quot;:
     * \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            The ID of the account to be updated. (required)
     * @param body
     *            Details of the account to be updated. (required)
     * @return Call&lt;AccountInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}")
    Call<AccountInfo> updateAccount(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                    @retrofit2.http.Body AccountUpdateRootReq body);

    /**
     * Update API key details. An endpoint for updating API key details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/api-keys/{apikey_id} -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param apikeyId
     *            The ID of the API key to be updated. (required)
     * @param body
     *            New API key attributes to be stored. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @PUT("v3/accounts/{account_id}/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp>
        updateAccountApiKey(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                            @retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                            @retrofit2.http.Body ApiKeyUpdateReq body);

    /**
     * Update trusted certificate. An endpoint for updating existing trusted certificates. **Example usage:** &#x60;curl
     * -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/trusted-certificates/{cert_id} -d
     * {\&quot;description\&quot;: \&quot;very important cert\&quot;} -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param certId
     *            The ID of the trusted certificate to be updated. (required)
     * @param body
     *            A trusted certificate object with attributes. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/trusted-certificates/{cert_id}")
    Call<TrustedCertificateResp>
        updateAccountCertificate(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                 @retrofit2.http.Path(value = "cert_id", encoded = true) String certId,
                                 @retrofit2.http.Body TrustedCertificateUpdateReq body);

    /**
     * Update the group name. An endpoint for updating a group name. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/policy-groups/{group_id}/ -d
     * &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param groupId
     *            The ID of the group to be updated. (required)
     * @param body
     *            Details of the group to be created. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/policy-groups/{group_id}")
    Call<UpdatedResponse>
        updateAccountGroupName(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                               @retrofit2.http.Body GroupUpdateInfo body);

    /**
     * Update an existing identity provider. An endpoint for updating an existing identity provider.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param identityProviderId
     *            The ID of the identity provider to be updated. (required)
     * @param body
     *            Details of the identity provider to be updated. (required)
     * @return Call&lt;IdentityProviderInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/identity-providers/{identity_provider_id}")
    Call<IdentityProviderInfo>
        updateAccountIdentityProvider(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "identity_provider_id",
                                                           encoded = true) String identityProviderId,
                                      @retrofit2.http.Body IdentityProviderUpdateReq body);

    /**
     * Update user details. An endpoint for updating user details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id} -d &#39;{\&quot;username\&quot;:
     * \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user to be updated. (required)
     * @param body
     *            A user object with attributes. (required)
     * @return Call&lt;UserInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/users/{user_id}")
    Call<UserInfoResp> updateAccountUser(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                         @retrofit2.http.Path(value = "user_id", encoded = true) String userId,
                                         @retrofit2.http.Body UserUpdateReq body);

    /**
     * Upload an image in the dark theme. An endpoint for uploading a new account branding image in the dark theme in
     * PNG or JPEG format. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/upload -H
     * &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary
     * &#39;myimage.png&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param body
     *            The image in PNG or JPEG format. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @Headers({ "Content-Type:image/png" })
    @POST("v3/accounts/{account_id}/branding-images/dark/{reference}/upload")
    Call<BrandingImage>
        uploadAccountDarkImage(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                               @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                               @retrofit2.http.Body String body);

    /**
     * Upload an image in the dark theme. An endpoint for uploading a new account branding image as form data in the
     * dark theme in PNG or JPEG format.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param image
     *            The image in PNG or JPEG format as multipart form data. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/accounts/{account_id}/branding-images/dark/{reference}/upload-multipart")
    Call<BrandingImage>
        uploadAccountDarkImageMultipart(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                        @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                        @retrofit2.http.Part() MultipartBody.Part image);

    /**
     * Upload an image in the light theme. An endpoint for uploading a new account branding image in the light theme in
     * PNG or JPEG format. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/upload -H
     * &#39;content-type: image/png&#39; -H &#39;Authorization: Bearer API_KEY&#39; --data-binary
     * &#39;myimage.png&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param body
     *            The image in PNG or JPEG format. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @Headers({ "Content-Type:image/png" })
    @POST("v3/accounts/{account_id}/branding-images/light/{reference}/upload")
    Call<BrandingImage>
        uploadAccountLightImage(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                @retrofit2.http.Body String body);

    /**
     * Upload an image in the light theme. An endpoint for uploading a new account branding image as form data in the
     * light theme in PNG or JPEG format.
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param image
     *            The image in PNG or JPEG format as multipart form data. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/accounts/{account_id}/branding-images/light/{reference}/upload-multipart")
    Call<BrandingImage>
        uploadAccountLightImageMultipart(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                         @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                         @retrofit2.http.Part() MultipartBody.Part image);

    /**
     * Validate the user email. An endpoint for validating the user email. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/users/{user_id}/validate-email -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param userId
     *            The ID of the user whose email is validated. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/accounts/{account_id}/users/{user_id}/validate-email")
    Call<Void> validateAccountUserEmail(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                        @retrofit2.http.Path(value = "user_id", encoded = true) String userId);

}
