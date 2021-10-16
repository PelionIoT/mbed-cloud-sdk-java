package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CreateTrustAnchorRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CreateTrustAnchorResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.GetTrustAnchorsResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TokenRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TokenResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateTrustAnchorRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateTrustAnchorResponse;

public interface SecurityAndIdentitySecureDeviceAccessApi {
    /**
     * Get an access token to use with a device. Generate a signed CWT (CBOR Web Token). The SDA Android SDK uses this
     * API to gain access to perform actions on the devices specified in the audience (aud). &lt;br&gt; Authorized for
     * roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/ace-auth/token \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; \\ -H
     * &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{
     * \&quot;grant_type\&quot;:\&quot;client_credentials\&quot;,
     * \&quot;aud\&quot;:[\&quot;id:f90b1017e52f4c70ad92684e802c9249\&quot;,\&quot;ep:dev1\&quot;],
     * \&quot;scope\&quot;:\&quot;turn-led-on\&quot;, \&quot;cnf\&quot;:\&quot;-----BEGIN PUBLIC
     * KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ...XwIDAQAB-----END PUBLIC KEY-----\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param body
     *            Create access token request. (required)
     * @return Call&lt;TokenResponse&gt;
     */
    @POST("/ace-auth/token")
    Call<TokenResponse> createAceAuthToken(@retrofit2.http.Body TokenRequest body);

    /**
     * Create a new trust anchor for the account. Create a trust anchor key pair and return the public key and creation
     * time. Each account can have one trust anchor only. This API fails if a trust anchor already exists for the
     * account. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/trust-anchors \\ -H &#39;Authorization:
     * &lt;valid JWT&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{
     * \&quot;description\&quot;: \&quot;Trust anchor for room lighting controller.\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param body
     *            Request a new trust anchor. (required)
     * @return Call&lt;CreateTrustAnchorResponse&gt;
     */
    @POST("/v3/trust-anchors")
    Call<CreateTrustAnchorResponse> createTrustAnchor(@retrofit2.http.Body CreateTrustAnchorRequest body);

    /**
     * Delete a trust anchor. Delete the specified trust anchor. Unrecoverable. &lt;br&gt; Authorized for roles:
     * Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/trust-anchors/8e0a9494cc95b750ec6c81464eb06725 \\ -H &#39;Authorization:
     * &lt;valid JWT&gt;&#39; \\ &#x60;&#x60;&#x60;
     * 
     * @param trustAnchorId
     *            The id of the trust anchor to be deleted (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("/v3/trust-anchors/{trust_anchor_id}")
    Call<Void> deleteTrustAnchor(@retrofit2.http.Path(value = "trust_anchor_id", encoded = true) String trustAnchorId);

    /**
     * Get the account&#39;s trust anchor used to sign the access token. Get all trust anchors that match the account ID
     * specified in the JWT. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator &lt;br&gt; **Usage
     * example:** &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/trust-anchors \\ -H
     * &#39;Authorization: &lt;valid JWT&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            Indicates how many objects to retrieve in the page. The minimum limit is 2 and the maximum is 1000.
     *            Limit values outside of this range are set to the closest limit. (optional)
     * @param order
     *            Indicates how to order the entries based on when they were created. &#x60;ASC&#x60; by default.
     *            (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @return Call&lt;GetTrustAnchorsResponse&gt;
     */
    @GET("/v3/trust-anchors")
    Call<GetTrustAnchorsResponse>
        getTrustAnchors(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                        @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include);

    /**
     * Update trust anchor attributes (description). Updates a trust anchor description attribute. &lt;br&gt; Authorized
     * for roles: Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/trust-anchors/8e0a9494cc95b750ec6c81464eb06725 \\ -H &#39;Authorization:
     * &lt;valid JWT&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{
     * \&quot;description\&quot;: \&quot;Trust anchor for ambient light module\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param trustAnchorId
     *            The id of the trust anchor to be updated (required)
     * @param body
     *            Update trust anchor request. (required)
     * @return Call&lt;UpdateTrustAnchorResponse&gt;
     */
    @PUT("/v3/trust-anchors/{trust_anchor_id}")
    Call<UpdateTrustAnchorResponse>
        updateTrustAnchor(@retrofit2.http.Path(value = "trust_anchor_id", encoded = true) String trustAnchorId,
                          @retrofit2.http.Body UpdateTrustAnchorRequest body);

}
