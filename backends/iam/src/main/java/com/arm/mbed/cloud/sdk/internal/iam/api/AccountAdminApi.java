package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.iam.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupCreationInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupUpdateInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInvitationReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInvitationResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInvitationRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountAdminApi {
  /**
   * Add API key to a list of groups.
   * An endpoint for adding API key to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param apiKey The ID of the API key to be added to the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/api-keys/{apiKey}/groups")
  Call<UpdatedResponse> addApiKeyToGroups(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body List<String> body
  );

  /**
   * Upload a new trusted certificate.
   * An endpoint for uploading new trusted certificates.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -d {\&quot;name\&quot;: \&quot;myCert1\&quot;, \&quot;description\&quot;: \&quot;very important cert\&quot;, \&quot;certificate\&quot;: \&quot;certificate_data\&quot;, \&quot;service\&quot;: \&quot;lwm2m\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param body A trusted certificate object with attributes. (required)
   * @return Call&lt;TrustedCertificateResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/trusted-certificates")
  Call<TrustedCertificateResp> addCertificate(
    @retrofit2.http.Body TrustedCertificateReq body
  );

  /**
   * Add members to a group.
   * An endpoint for adding users and API keys to a group.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id} -d &#39;{\&quot;users\&quot;: [0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param groupID The ID of the group to be updated. (required)
   * @param body A list of users and API keys to be added to the group. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/policy-groups/{groupID}")
  Call<UpdatedResponse> addSubjectsToGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Add user to a list of groups.
   * An endpoint for adding user to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/users/{user-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param userId The ID of the user to be added to the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/users/{user-id}/groups")
  Call<UpdatedResponse> addUserToGroups(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body List<String> body
  );

  /**
   * Create a new group.
   * An endpoint for creating a new group.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/policy-groups -d &#39;{\&quot;name\&quot;: \&quot;MyGroup1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param body Details of the group to be created. (required)
   * @return Call&lt;GroupSummary&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/policy-groups")
  Call<GroupSummary> createGroup(
    @retrofit2.http.Body GroupCreationInfo body
  );

  /**
   * Create a user invitation.
   * An endpoint for inviting a new or an existing user to join the account.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/user-invitations -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param body A user invitation object with attributes. (required)
   * @return Call&lt;UserInvitationResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/user-invitations")
  Call<UserInvitationResp> createInvitation(
    @retrofit2.http.Body UserInvitationReq body
  );

  /**
   * Create a new user.
   * An endpoint for creating or inviting a new user to the account. In case of invitation email address is used only, other attributes are set in the 2nd step.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/users?action&#x3D;invite -d {\&quot;email\&quot;: \&quot;myemail@company.com\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param body A user object with attributes. (required)
   * @param action Action, either &#39;create&#39; or &#39;invite&#39;. (optional, default to create)
   * @return Call&lt;UserInfoResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/users")
  Call<UserInfoResp> createUser(
    @retrofit2.http.Body UserInfoReq body, @retrofit2.http.Query("action") String action
  );

  /**
   * Delete a group.
   * An endpoint for deleting a group.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param groupID The ID of the group to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/policy-groups/{groupID}")
  Call<Void> deleteGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID
  );

  /**
   * Delete a user invitation.
   * An endpoint for deleting an active user invitation which has been sent for a new or an existing user to join the account.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param invitationId The ID of the invitation to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/user-invitations/{invitation-id}")
  Call<Void> deleteInvitation(
    @retrofit2.http.Path(value = "invitation-id", encoded = true) String invitationId
  );

  /**
   * Delete a user.
   * An endpoint for deleting a user.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/users/{user-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param userId The ID of the user to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/users/{user-id}")
  Call<Void> deleteUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId
  );

  /**
   * Get the details of all the user invitations.
   * An endpoint for retrieving the details of all the active user invitations sent for new or existing users to join the account.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/user-invitations -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @return Call&lt;UserInvitationRespList&gt;
   */
  @GET("v3/user-invitations")
  Call<UserInvitationRespList> getAllInvitations(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order
  );

  /**
   * Get the details of all users.
   * An endpoint for retrieving the details of all users.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param emailEq Filter for email address (optional)
   * @param statusEq Filter for status, for example active or reset (optional)
   * @param statusIn An optional filter for getting users with a specified set of statuses. (optional)
   * @param statusNin An optional filter for excluding users with a specified set of statuses. (optional)
   * @return Call&lt;UserInfoRespList&gt;
   */
  @GET("v3/users")
  Call<UserInfoRespList> getAllUsers(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("email__eq") String emailEq, @retrofit2.http.Query("status__eq") String statusEq, @retrofit2.http.Query("status__in") String statusIn, @retrofit2.http.Query("status__nin") String statusNin
  );

  /**
   * Get groups of the API key.
   * An endpoint for retrieving groups of the API key.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey-id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param apiKey The ID of the API key whose details are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/api-keys/{apiKey}/groups")
  Call<GroupSummaryList> getGroupsOfApikey(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Get groups of the user.
   * An endpoint for retrieving groups of the user.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/users/{user-id}/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param userId The ID of the user whose details are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/users/{user-id}/groups")
  Call<GroupSummaryList> getGroupsOfUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Details of a user invitation.
   * An endpoint for retrieving the details of an active user invitation sent for a new or an existing user to join the account.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/user-invitations/{invitation-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param invitationId The ID of the invitation to be retrieved. (required)
   * @return Call&lt;UserInvitationResp&gt;
   */
  @GET("v3/user-invitations/{invitation-id}")
  Call<UserInvitationResp> getInvitation(
    @retrofit2.http.Path(value = "invitation-id", encoded = true) String invitationId
  );

  /**
   * Details of a user.
   * An endpoint for retrieving the details of a user.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/users/{user-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param userId The ID of the user whose details are retrieved. (required)
   * @return Call&lt;UserInfoResp&gt;
   */
  @GET("v3/users/{user-id}")
  Call<UserInfoResp> getUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId
  );

  /**
   * Get users of a group.
   * An endpoint for listing the users of a group with details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id}/users -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param groupID The ID of the group whose users are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records based on creation time, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param statusEq An optional filter for getting users by status. (optional)
   * @param statusIn An optional filter for getting users with a specified set of statuses. (optional)
   * @param statusNin An optional filter for excluding users with a specified set of statuses. (optional)
   * @return Call&lt;UserInfoRespList&gt;
   */
  @GET("v3/policy-groups/{groupID}/users")
  Call<UserInfoRespList> getUsersOfGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("status__eq") String statusEq, @retrofit2.http.Query("status__in") String statusIn, @retrofit2.http.Query("status__nin") String statusNin
  );

  /**
   * Remove API key from groups.
   * An endpoint for removing API key from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param apiKey The ID of the API key to be removed from the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/api-keys/{apiKey}/groups")
  Call<UpdatedResponse> removeApiKeyFromGroups(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body List<String> body
  );

  /**
   * Remove user from groups.
   * An endpoint for removing user from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/users/{user-id}/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param userId The ID of the user to be removed from the group. (required)
   * @param body A list of IDs of the groups to be updated. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/users/{user-id}/groups")
  Call<UpdatedResponse> removeUserFromGroups(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body List<String> body
  );

  /**
   * Remove users from a group.
   * An endpoint for removing users from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id}/users -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param groupID The ID of the group whose users are removed. (required)
   * @param body A list of users to be removed from the group. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/policy-groups/{groupID}/users")
  Call<UpdatedResponse> removeUsersFromGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Update the group name.
   * An endpoint for updating a group name.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id} -d &#39;{\&quot;name\&quot;: \&quot;TestGroup2\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param groupID The ID of the group to be updated. (required)
   * @param body Details of the group to be created. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/policy-groups/{groupID}")
  Call<UpdatedResponse> updateGroupName(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body GroupUpdateInfo body
  );

  /**
   * Updates attributes of the account.
   * An endpoint for updating the account.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/accounts/me -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param body Details of the account to be updated. (required)
   * @return Call&lt;AccountInfo&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/accounts/me")
  Call<AccountInfo> updateMyAccount(
    @retrofit2.http.Body AccountUpdateReq body
  );

  /**
   * Update user details.
   * An endpoint for updating user details.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/users/{user-id} -d &#39;{\&quot;username\&quot;: \&quot;myusername\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
   * @param userId The ID of the user whose details are updated. (required)
   * @param body A user object with attributes. (required)
   * @return Call&lt;UserInfoResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/users/{user-id}")
  Call<UserInfoResp> updateUser(
    @retrofit2.http.Path(value = "user-id", encoded = true) String userId, @retrofit2.http.Body UserUpdateReq body
  );

}
