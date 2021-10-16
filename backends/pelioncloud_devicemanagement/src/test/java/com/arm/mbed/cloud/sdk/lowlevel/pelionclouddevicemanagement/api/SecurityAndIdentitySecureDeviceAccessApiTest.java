package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CreateTrustAnchorRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TokenRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateTrustAnchorRequest;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for SecurityAndIdentitySecureDeviceAccessApi
 */
public class SecurityAndIdentitySecureDeviceAccessApiTest {

    private SecurityAndIdentitySecureDeviceAccessApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SecurityAndIdentitySecureDeviceAccessApi.class);
    }

    /**
     * Get an access token to use with a device.
     *
     * Generate a signed CWT (CBOR Web Token). The SDA Android SDK uses this API to gain access to perform actions on
     * the devices specified in the audience (aud). &lt;br&gt; Authorized for roles: Service, ServiceAdministrator
     * &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/ace-auth/token
     * \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; \\ -H &#39;content-type:
     * application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;grant_type\&quot;:\&quot;client_credentials\&quot;,
     * \&quot;aud\&quot;:[\&quot;id:f90b1017e52f4c70ad92684e802c9249\&quot;,\&quot;ep:dev1\&quot;],
     * \&quot;scope\&quot;:\&quot;turn-led-on\&quot;, \&quot;cnf\&quot;:\&quot;-----BEGIN PUBLIC
     * KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ...XwIDAQAB-----END PUBLIC KEY-----\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createAceAuthTokenTest() {
        TokenRequest body = null;
        // TokenResponse response = api.createAceAuthToken(body);

        // TODO: test validations
    }

    /**
     * Create a new trust anchor for the account.
     *
     * Create a trust anchor key pair and return the public key and creation time. Each account can have one trust
     * anchor only. This API fails if a trust anchor already exists for the account. &lt;br&gt; Authorized for roles:
     * Service, ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/trust-anchors \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39; \\ -H
     * &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;description\&quot;: \&quot;Trust
     * anchor for room lighting controller.\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createTrustAnchorTest() {
        CreateTrustAnchorRequest body = null;
        // CreateTrustAnchorResponse response = api.createTrustAnchor(body);

        // TODO: test validations
    }

    /**
     * Delete a trust anchor.
     *
     * Delete the specified trust anchor. Unrecoverable. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator
     * &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/trust-anchors/8e0a9494cc95b750ec6c81464eb06725 \\ -H &#39;Authorization:
     * &lt;valid JWT&gt;&#39; \\ &#x60;&#x60;&#x60;
     */
    @Test
    public void deleteTrustAnchorTest() {
        String trustAnchorId = null;
        // Void response = api.deleteTrustAnchor(trustAnchorId);

        // TODO: test validations
    }

    /**
     * Get the account&#39;s trust anchor used to sign the access token.
     *
     * Get all trust anchors that match the account ID specified in the JWT. &lt;br&gt; Authorized for roles: Service,
     * ServiceAdministrator &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/trust-anchors \\ -H &#39;Authorization: &lt;valid JWT&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getTrustAnchorsTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        // GetTrustAnchorsResponse response = api.getTrustAnchors(limit, order, after, include);

        // TODO: test validations
    }

    /**
     * Update trust anchor attributes (description).
     *
     * Updates a trust anchor description attribute. &lt;br&gt; Authorized for roles: Service, ServiceAdministrator
     * &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/trust-anchors/8e0a9494cc95b750ec6c81464eb06725 \\ -H &#39;Authorization:
     * &lt;valid JWT&gt;&#39; \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{
     * \&quot;description\&quot;: \&quot;Trust anchor for ambient light module\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateTrustAnchorTest() {
        String trustAnchorId = null;
        UpdateTrustAnchorRequest body = null;
        // UpdateTrustAnchorResponse response = api.updateTrustAnchor(trustAnchorId, body);

        // TODO: test validations
    }
}
