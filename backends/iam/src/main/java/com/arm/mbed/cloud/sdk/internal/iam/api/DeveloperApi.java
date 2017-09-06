package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;



import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.MyUserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateResp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface DeveloperApi {
  /**
   * Create a new API key.
   * An endpoint for creating a new API key. Example usage: curl -X POST https://api.us-east-1.mbedcloud.com/v3/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;,\&quot;owner\&quot;: \&quot;ACCOUNT_ID\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer AUTH_TOKEN&#39;
   * @param body The details of the API key to be created. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v3/api-keys")
  Call<ApiKeyInfoResp> createApiKey(
    @retrofit2.http.Body ApiKeyInfoReq body
  );

  /**
   * Delete API key.
   * An endpoint for deleting the API key. Example usage: curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey-id} -H &#39;Authorization: Bearer AUTH_TOKEN&#39;
   * @param apiKey The ID of the API key to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/api-keys/{apiKey}")
  Call<Void> deleteApiKey(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey
  );

  /**
   * Delete a trusted certificate by ID.
   * An endpoint for deleting a trusted certificate.
   * @param certId The ID of the trusted certificate to be deleted. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/trusted-certificates/{cert-id}")
  Call<Void> deleteCertificate(
    @retrofit2.http.Path(value = "cert-id", encoded = true) String certId
  );

  /**
   * Get all API keys
   * An endpoint for retrieving API keys in an array, optionally filtered by the owner. Example usage: curl https://api.us-east-1.mbedcloud.com/v3/api-keys -H &#39;Authorization: Bearer AUTH_TOKEN&#39;
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param ownerEq Owner name filter. (optional)
   * @return Call&lt;ApiKeyInfoRespList&gt;
   */
  @GET("v3/api-keys")
  Call<ApiKeyInfoRespList> getAllApiKeys(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("owner__eq") String ownerEq
  );

  /**
   * Get all trusted certificates.
   * An endpoint for retrieving trusted certificates in an array.
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @param serviceEq Service filter, either lwm2m or bootstrap (optional)
   * @param expireEq Expire filter in days (optional)
   * @param deviceExecutionModeEq Device execution mode, as 1 for developer certificates or as another natural integer value (optional)
   * @param ownerEq Owner ID filter (optional)
   * @return Call&lt;TrustedCertificateRespList&gt;
   */
  @GET("v3/trusted-certificates")
  Call<TrustedCertificateRespList> getAllCertificates(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include, @retrofit2.http.Query("service__eq") String serviceEq, @retrofit2.http.Query("expire__eq") Integer expireEq, @retrofit2.http.Query("device_execution_mode__eq") Integer deviceExecutionModeEq, @retrofit2.http.Query("owner__eq") String ownerEq
  );

  /**
   * Get all group information.
   * An endpoint for retrieving all group information.
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;GroupSummaryList&gt;
   */
  @GET("v3/policy-groups")
  Call<GroupSummaryList> getAllGroups(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Get API key details.
   * An endpoint for retrieving API key details.
   * @param apiKey The ID of the API key to be retrieved. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @GET("v3/api-keys/{apiKey}")
  Call<ApiKeyInfoResp> getApiKey(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey
  );

  /**
   * Get the API keys of a group.
   * An endpoint for listing the API keys of the group with details.
   * @param groupID The ID of the group whose API keys are retrieved. (required)
   * @param limit The number of results to return (2-1000), default is 50. (optional, default to 50)
   * @param after The entity ID to fetch after the given one. (optional)
   * @param order The order of the records, ASC or DESC; by default ASC (optional, default to ASC)
   * @param include Comma separated additional data to return. Currently supported: total_count (optional)
   * @return Call&lt;ApiKeyInfoRespList&gt;
   */
  @GET("v3/policy-groups/{groupID}/api-keys")
  Call<ApiKeyInfoRespList> getApiKeysOfGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include
  );

  /**
   * Get trusted certificate by ID.
   * An endpoint for retrieving a trusted certificate by ID. Example usage: curl https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert-id} -H &#39;Authorization: Bearer AUTH_TOKEN&#39; 
   * @param certId The ID or name of the trusted certificate to be retrieved. (required)
   * @return Call&lt;TrustedCertificateResp&gt;
   */
  @GET("v3/trusted-certificates/{cert-id}")
  Call<TrustedCertificateResp> getCertificate(
    @retrofit2.http.Path(value = "cert-id", encoded = true) String certId
  );

  /**
   * Get group information.
   * An endpoint for getting general information about the group.
   * @param groupID The ID or name of the group to be retrieved. (required)
   * @return Call&lt;GroupSummary&gt;
   */
  @GET("v3/policy-groups/{groupID}")
  Call<GroupSummary> getGroupSummary(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID
  );

  /**
   * Get account info.
   * Returns detailed information about the account. Example usage: curl https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies -H &#39;Authorization: Bearer AUTH_TOKEN&#39; .
   * @param include Comma separated additional data to return. Currently supported: limits, policies, sub_accounts. (optional)
   * @return Call&lt;AccountInfo&gt;
   */
  @GET("v3/accounts/me")
  Call<AccountInfo> getMyAccountInfo(
    @retrofit2.http.Query("include") String include
  );

  /**
   * Get API key details.
   * An endpoint for retrieving API key details. Example usage: curl https://api.us-east-1.mbedcloud.com/v3/api-keys/me -H &#39;Authorization: Bearer AUTH_TOKEN&#39;
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @GET("v3/api-keys/me")
  Call<ApiKeyInfoResp> getMyApiKey();
    

  /**
   * Details of the current user.
   * An endpoint for retrieving the details of the logged in user. Example usage: curl https://api.us-east-1.mbedcloud.com/v3/users/me -H &#39;Authorization: Bearer AUTH_TOKEN&#39; 
   * @param scratchCodes Request to regenerate new emergency scratch codes. (optional)
   * @return Call&lt;MyUserInfoResp&gt;
   */
  @GET("v3/users/me")
  Call<MyUserInfoResp> getMyUser(
    @retrofit2.http.Query("scratch_codes") String scratchCodes
  );

  /**
   * Remove API keys from a group.
   * An endpoint for removing API keys from groups.
   * @param groupID The ID of the group whose API keys are removed. (required)
   * @param body A list of API keys to be removed from the group. (required)
   * @return Call&lt;UpdatedResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("v3/policy-groups/{groupID}/api-keys")
  Call<UpdatedResponse> removeApiKeysFromGroup(
    @retrofit2.http.Path(value = "groupID", encoded = true) String groupID, @retrofit2.http.Body SubjectList body
  );

  /**
   * Update API key details.
   * An endpoint for updating API key details.
   * @param apiKey The ID of the API key to be updated. (required)
   * @param body New API key attributes to be stored. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @PUT("v3/api-keys/{apiKey}")
  Call<ApiKeyInfoResp> updateApiKey(
    @retrofit2.http.Path(value = "apiKey", encoded = true) String apiKey, @retrofit2.http.Body ApiKeyUpdateReq body
  );

  /**
   * Update trusted certificate.
   * An endpoint for updating existing trusted certificates. Example usage: curl -X PUT https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert-id} -d {\&quot;description\&quot;: \&quot;very important cert\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer AUTH_TOKEN&#39; 
   * @param certId The ID of the trusted certificate to be updated. (required)
   * @param body A trusted certificate object with attributes. (required)
   * @return Call&lt;TrustedCertificateResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/trusted-certificates/{cert-id}")
  Call<TrustedCertificateResp> updateCertificate(
    @retrofit2.http.Path(value = "cert-id", encoded = true) String certId, @retrofit2.http.Body TrustedCertificateUpdateReq body
  );

  /**
   * Update API key details.
   * An endpoint for updating API key details. Example usage: curl -X PUT https://api.us-east-1.mbedcloud.com/v3/api-keys/me -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer AUTH_TOKEN&#39;
   * @param body New API key attributes to be stored. (required)
   * @return Call&lt;ApiKeyInfoResp&gt;
   */
  @PUT("v3/api-keys/me")
  Call<ApiKeyInfoResp> updateMyApiKey(
    @retrofit2.http.Body ApiKeyUpdateReq body
  );

  /**
   * Update user details.
   * An endpoint for updating the details of the logged in user. Example usage: curl -X PUT https://api.us-east-1.mbedcloud.com/v3/users/me -d &#39;{\&quot;address\&quot;: \&quot;1007 Mountain Drive\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer AUTH_TOKEN&#39; 
   * @param body New attributes for the logged in user. (required)
   * @return Call&lt;UserUpdateResp&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("v3/users/me")
  Call<UserUpdateResp> updateMyUser(
    @retrofit2.http.Body UserUpdateReq body
  );

}
