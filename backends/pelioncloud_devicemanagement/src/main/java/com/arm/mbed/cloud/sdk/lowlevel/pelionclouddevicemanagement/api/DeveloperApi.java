package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColorList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImageList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummary;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateRespList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UserInfoResp;

import java.util.List;

public interface DeveloperApi {
    /**
     * Add API key to a list of groups. An endpoint for adding API key to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys/me/groups")
    Call<UpdatedResponse> addMyApiKeyToGroups(@retrofit2.http.Body List<String> body);

    /**
     * Create a new API key. An endpoint for creating a new API key. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            The details of the API key to be created. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/api-keys")
    Call<ApiKeyInfoResp> createApiKey(@retrofit2.http.Body ApiKeyInfoReq body);

    /**
     * Delete API key. An endpoint for deleting the API key. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/api-keys/{apikey_id}")
    Call<Void> deleteApiKey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Delete a trusted certificate by ID. An endpoint for deleting a trusted certificate. **Example usage:** &#x60;curl
     * -X DELETE https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param certId
     *            The ID of the trusted certificate to be deleted. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/trusted-certificates/{cert_id}")
    Call<Void> deleteCertificate(@retrofit2.http.Path(value = "cert_id", encoded = true) String certId);

    /**
     * Get all API keys An endpoint for retrieving API keys in an array, optionally filtered by the owner. **Example
     * usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * @param keyEq
     *            API key filter. Do not include the private part of the API key (the last 32 characters). (optional)
     * @param ownerEq
     *            Owner name filter. (optional)
     * @return Call&lt;ApiKeyInfoRespList&gt;
     */
    @GET("v3/api-keys")
    Call<ApiKeyInfoRespList>
        getAllApiKeys(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                      @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                      @retrofit2.http.Query("key__eq") String keyEq, @retrofit2.http.Query("owner__eq") String ownerEq);

    /**
     * Get all trusted certificates. An endpoint for retrieving trusted certificates in an array. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
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
     * @param nameEq
     *            Filter for certificate name (optional)
     * @param serviceEq
     *            Service filter, either lwm2m or bootstrap (optional)
     * @param expireEq
     *            Expire filter in days (optional)
     * @param deviceExecutionModeEq
     *            Device execution mode, as 1 for developer certificates or as another natural integer value (optional)
     * @param deviceExecutionModeNeq
     *            Device execution mode not equals filter (optional)
     * @param ownerEq
     *            Owner name filter (optional)
     * @param enrollmentModeEq
     *            Enrollment mode filter (optional)
     * @param statusEq
     *            Filter for certificate status (optional)
     * @param issuerLike
     *            Issuer filter. Finds all matches where the filter value is a case insensitive substring of the result.
     *            Example: issuer__like&#x3D;cn&#x3D;iss matches CN&#x3D;issuer. (optional)
     * @param subjectLike
     *            Subject filter. Finds all matches where the filter value is a case insensitive substring of the
     *            result. Example: subject__like&#x3D;cn&#x3D;su matches CN&#x3D;subject. (optional)
     * @param validEq
     *            Filter for finding certificates by validity. True returns certificates which are not yet expired.
     *            False returns certificates which have expired. (optional)
     * @return Call&lt;TrustedCertificateRespList&gt;
     */
    @GET("v3/trusted-certificates")
    Call<TrustedCertificateRespList>
        getAllCertificates(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                           @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
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
     * **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-images/dark -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     * 
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("v3/branding-images/dark")
    Call<BrandingImageList> getAllDarkImageData();

    /**
     * Get all group information. An endpoint for retrieving all group information. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * @param nameEq
     *            Filter for group name (optional)
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/policy-groups")
    Call<GroupSummaryList>
        getAllGroups(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                     @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                     @retrofit2.http.Query("name__eq") String nameEq);

    /**
     * Get metadata of all images in the light theme. Returns the metadata of all branding images in the light theme.
     * **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-images/light -H &#39;Authorization:
     * Bearer API_KEY&#39;&#x60;
     * 
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("v3/branding-images/light")
    Call<BrandingImageList> getAllLightImageData();

    /**
     * Get API key details. An endpoint for retrieving API key details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to be retrieved. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @GET("v3/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp> getApiKey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId);

    /**
     * Get the API keys of a group. An endpoint for listing the API keys of the group with details. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
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
    @GET("v3/policy-groups/{group_id}/api-keys")
    Call<ApiKeyInfoRespList>
        getApiKeysOfGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                          @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                          @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include);

    /**
     * Get trusted certificate by ID. An endpoint for retrieving a trusted certificate by ID. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param certId
     *            The ID of the trusted certificate to be retrieved. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @GET("v3/trusted-certificates/{cert_id}")
    Call<TrustedCertificateResp> getCertificate(@retrofit2.http.Path(value = "cert_id", encoded = true) String certId);

    /**
     * Get branding color of the dark theme. Returns the requested branding color of the dark theme. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/branding-colors/dark/{reference}")
    Call<BrandingColor> getDarkColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get branding colors of the dark theme. Returns the branding colors of the dark theme. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/branding-colors/dark")
    Call<BrandingColorList> getDarkColors();

    /**
     * Get metadata of an image in the dark theme. An endpoint for getting metadata of one account branding image in the
     * dark theme. **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}
     * -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("v3/branding-images/dark/{reference}")
    Call<BrandingImage> getDarkImageData(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get group information. An endpoint for getting general information about the group. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param groupId
     *            The ID of the group to be retrieved. (required)
     * @return Call&lt;GroupSummary&gt;
     */
    @GET("v3/policy-groups/{group_id}")
    Call<GroupSummary> getGroupSummary(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId);

    /**
     * Get groups of the API key. An endpoint for retrieving groups of the API key. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * @return Call&lt;GroupSummaryList&gt;
     */
    @GET("v3/api-keys/me/groups")
    Call<GroupSummaryList> getGroupsOfMyApiKey(@retrofit2.http.Query("limit") Integer limit,
                                               @retrofit2.http.Query("after") String after,
                                               @retrofit2.http.Query("order") String order,
                                               @retrofit2.http.Query("include") String include);

    /**
     * Get branding color of the light theme. Returns the requested branding color of the light theme. **Example
     * usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/branding-colors/light/{reference}")
    Call<BrandingColor> getLightColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get branding colors of the light theme. Returns the branding colors of the light theme. **Example usage:**
     * &#x60;curl https://api.us-east-1.mbedcloud.com/v3/branding-colors/light -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/branding-colors/light")
    Call<BrandingColorList> getLightColors();

    /**
     * Get metadata of an image in the light theme. An endpoint for getting metadata of one account branding image in
     * the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("v3/branding-images/light/{reference}")
    Call<BrandingImage> getLightImageData(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get account info. Returns detailed information about the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;.
     * 
     * @param include
     *            Comma separated additional data to return. Currently supported: limits, policies, sub_accounts.
     *            (optional)
     * @param properties
     *            Property name to be returned from account specific properties. (optional)
     * @return Call&lt;AccountInfo&gt;
     */
    @GET("v3/accounts/me")
    Call<AccountInfo> getMyAccountInfo(@retrofit2.http.Query("include") String include,
                                       @retrofit2.http.Query("properties") String properties);

    /**
     * Get API key details. An endpoint for retrieving API key details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @GET("v3/api-keys/me")
    Call<ApiKeyInfoResp> getMyApiKey();

    /**
     * Details of the current user. An endpoint for retrieving the details of the logged in user.
     * 
     * @param scratchCodes
     *            Request to regenerate new emergency scratch codes. (optional)
     * @param properties
     *            Request to return account specific user property values according to the given property name.
     *            (optional)
     * @param include
     *            Comma separated additional data to return. Currently supported: active_sessions (optional)
     * @return Call&lt;UserInfoResp&gt;
     */
    @GET("v3/users/me")
    Call<UserInfoResp> getMyUser(@retrofit2.http.Query("scratch_codes") String scratchCodes,
                                 @retrofit2.http.Query("properties") String properties,
                                 @retrofit2.http.Query("include") String include);

    /**
     * Remove API keys from a group. An endpoint for removing API keys from groups. **Example usage:** &#x60;curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param groupId
     *            The ID of the group whose API keys are removed. (required)
     * @param body
     *            A list of API keys to be removed from the group. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/policy-groups/{group_id}/api-keys")
    Call<UpdatedResponse>
        removeApiKeysFromGroup(@retrofit2.http.Path(value = "group_id", encoded = true) String groupId,
                               @retrofit2.http.Body SubjectList body);

    /**
     * Remove API key from groups. An endpoint for removing API key from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            A list of IDs of the groups to be updated. (required)
     * @return Call&lt;UpdatedResponse&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @DELETE("v3/api-keys/me/groups")
    Call<UpdatedResponse> removeMyApiKeyFromGroups(@retrofit2.http.Body List<String> body);

    /**
     * Update API key details. An endpoint for updating API key details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param apikeyId
     *            The ID of the API key to be updated. (required)
     * @param body
     *            New API key attributes to be stored. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @PUT("v3/api-keys/{apikey_id}")
    Call<ApiKeyInfoResp> updateApiKey(@retrofit2.http.Path(value = "apikey_id", encoded = true) String apikeyId,
                                      @retrofit2.http.Body ApiKeyUpdateReq body);

    /**
     * Update trusted certificate. An endpoint for updating existing trusted certificates. **Example usage:** &#x60;curl
     * -X PUT https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -d {\&quot;description\&quot;:
     * \&quot;very important cert\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @param certId
     *            The ID of the trusted certificate to be updated. (required)
     * @param body
     *            A trusted certificate object with attributes. (required)
     * @return Call&lt;TrustedCertificateResp&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/trusted-certificates/{cert_id}")
    Call<TrustedCertificateResp>
        updateCertificate(@retrofit2.http.Path(value = "cert_id", encoded = true) String certId,
                          @retrofit2.http.Body TrustedCertificateUpdateReq body);

    /**
     * Update API key details. An endpoint for updating API key details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39;
     * -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @param body
     *            New API key attributes to be stored. (required)
     * @return Call&lt;ApiKeyInfoResp&gt;
     */
    @PUT("v3/api-keys/me")
    Call<ApiKeyInfoResp> updateMyApiKey(@retrofit2.http.Body ApiKeyUpdateReq body);

}
