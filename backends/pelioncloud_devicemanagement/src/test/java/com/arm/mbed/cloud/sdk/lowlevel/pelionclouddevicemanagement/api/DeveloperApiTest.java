package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SubjectList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.TrustedCertificateUpdateReq;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * API tests for DeveloperApi
 */
public class DeveloperApiTest {

    private DeveloperApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeveloperApi.class);
    }

    /**
     * Add API key to a list of groups.
     *
     * An endpoint for adding API key to groups. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void addMyApiKeyToGroupsTest() {
        List<String> body = null;
        // UpdatedResponse response = api.addMyApiKeyToGroups(body);

        // TODO: test validations
    }

    /**
     * Create a new API key.
     *
     * An endpoint for creating a new API key. **Example usage:** &#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void createApiKeyTest() {
        ApiKeyInfoReq body = null;
        // ApiKeyInfoResp response = api.createApiKey(body);

        // TODO: test validations
    }

    /**
     * Delete API key.
     *
     * An endpoint for deleting the API key. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteApiKeyTest() {
        String apikeyId = null;
        // Void response = api.deleteApiKey(apikeyId);

        // TODO: test validations
    }

    /**
     * Delete a trusted certificate by ID.
     *
     * An endpoint for deleting a trusted certificate. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void deleteCertificateTest() {
        String certId = null;
        // Void response = api.deleteCertificate(certId);

        // TODO: test validations
    }

    /**
     * Get all API keys
     *
     * An endpoint for retrieving API keys in an array, optionally filtered by the owner. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllApiKeysTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String keyEq = null;
        String ownerEq = null;
        // ApiKeyInfoRespList response = api.getAllApiKeys(limit, after, order, include, keyEq, ownerEq);

        // TODO: test validations
    }

    /**
     * Get all trusted certificates.
     *
     * An endpoint for retrieving trusted certificates in an array. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllCertificatesTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        String serviceEq = null;
        Integer expireEq = null;
        Integer deviceExecutionModeEq = null;
        Integer deviceExecutionModeNeq = null;
        String ownerEq = null;
        Boolean enrollmentModeEq = null;
        String statusEq = null;
        String issuerLike = null;
        String subjectLike = null;
        Boolean validEq = null;
        // TrustedCertificateRespList response = api.getAllCertificates(limit, after, order, include, nameEq, serviceEq,
        // expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, statusEq, issuerLike,
        // subjectLike, validEq);

        // TODO: test validations
    }

    /**
     * Get metadata of all images in the dark theme.
     *
     * Returns the metadata of all branding images in the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllDarkImageDataTest() {
        // BrandingImageList response = api.getAllDarkImageData();

        // TODO: test validations
    }

    /**
     * Get all group information.
     *
     * An endpoint for retrieving all group information. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllGroupsTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String nameEq = null;
        // GroupSummaryList response = api.getAllGroups(limit, after, order, include, nameEq);

        // TODO: test validations
    }

    /**
     * Get metadata of all images in the light theme.
     *
     * Returns the metadata of all branding images in the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getAllLightImageDataTest() {
        // BrandingImageList response = api.getAllLightImageData();

        // TODO: test validations
    }

    /**
     * Get API key details.
     *
     * An endpoint for retrieving API key details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getApiKeyTest() {
        String apikeyId = null;
        // ApiKeyInfoResp response = api.getApiKey(apikeyId);

        // TODO: test validations
    }

    /**
     * Get the API keys of a group.
     *
     * An endpoint for listing the API keys of the group with details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getApiKeysOfGroupTest() {
        String groupId = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // ApiKeyInfoRespList response = api.getApiKeysOfGroup(groupId, limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get trusted certificate by ID.
     *
     * An endpoint for retrieving a trusted certificate by ID. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getCertificateTest() {
        String certId = null;
        // TrustedCertificateResp response = api.getCertificate(certId);

        // TODO: test validations
    }

    /**
     * Get branding color of the dark theme.
     *
     * Returns the requested branding color of the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getDarkColorTest() {
        String reference = null;
        // BrandingColor response = api.getDarkColor(reference);

        // TODO: test validations
    }

    /**
     * Get branding colors of the dark theme.
     *
     * Returns the branding colors of the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getDarkColorsTest() {
        // BrandingColorList response = api.getDarkColors();

        // TODO: test validations
    }

    /**
     * Get metadata of an image in the dark theme.
     *
     * An endpoint for getting metadata of one account branding image in the dark theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getDarkImageDataTest() {
        String reference = null;
        // BrandingImage response = api.getDarkImageData(reference);

        // TODO: test validations
    }

    /**
     * Get group information.
     *
     * An endpoint for getting general information about the group. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getGroupSummaryTest() {
        String groupId = null;
        // GroupSummary response = api.getGroupSummary(groupId);

        // TODO: test validations
    }

    /**
     * Get groups of the API key.
     *
     * An endpoint for retrieving groups of the API key. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getGroupsOfMyApiKeyTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getGroupsOfMyApiKey(limit, after, order, include);

        // TODO: test validations
    }

    /**
     * Get branding color of the light theme.
     *
     * Returns the requested branding color of the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getLightColorTest() {
        String reference = null;
        // BrandingColor response = api.getLightColor(reference);

        // TODO: test validations
    }

    /**
     * Get branding colors of the light theme.
     *
     * Returns the branding colors of the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getLightColorsTest() {
        // BrandingColorList response = api.getLightColors();

        // TODO: test validations
    }

    /**
     * Get metadata of an image in the light theme.
     *
     * An endpoint for getting metadata of one account branding image in the light theme. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference} -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void getLightImageDataTest() {
        String reference = null;
        // BrandingImage response = api.getLightImageData(reference);

        // TODO: test validations
    }

    /**
     * Get account info.
     *
     * Returns detailed information about the account. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;.
     */
    @Test
    public void getMyAccountInfoTest() {
        String include = null;
        String properties = null;
        // AccountInfo response = api.getMyAccountInfo(include, properties);

        // TODO: test validations
    }

    /**
     * Get API key details.
     *
     * An endpoint for retrieving API key details. **Example usage:** &#x60;curl
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getMyApiKeyTest() {
        // ApiKeyInfoResp response = api.getMyApiKey();

        // TODO: test validations
    }

    /**
     * Details of the current user.
     *
     * An endpoint for retrieving the details of the logged in user.
     */
    @Test
    public void getMyUserTest() {
        String scratchCodes = null;
        String properties = null;
        String include = null;
        // UserInfoResp response = api.getMyUser(scratchCodes, properties, include);

        // TODO: test validations
    }

    /**
     * Remove API keys from a group.
     *
     * An endpoint for removing API keys from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group_id}/api-keys -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeApiKeysFromGroupTest() {
        String groupId = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeApiKeysFromGroup(groupId, body);

        // TODO: test validations
    }

    /**
     * Remove API key from groups.
     *
     * An endpoint for removing API key from groups. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d
     * &#39;[\&quot;0162056a9a1586f30242590700000000\&quot;,\&quot;0117056a9a1586f30242590700000000\&quot;]&#39; -H
     * &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeMyApiKeyFromGroupsTest() {
        List<String> body = null;
        // UpdatedResponse response = api.removeMyApiKeyFromGroups(body);

        // TODO: test validations
    }

    /**
     * Update API key details.
     *
     * An endpoint for updating API key details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey_id} -d &#39;{\&quot;name\&quot;:
     * \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void updateApiKeyTest() {
        String apikeyId = null;
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateApiKey(apikeyId, body);

        // TODO: test validations
    }

    /**
     * Update trusted certificate.
     *
     * An endpoint for updating existing trusted certificates. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert_id} -d {\&quot;description\&quot;: \&quot;very
     * important cert\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void updateCertificateTest() {
        String certId = null;
        TrustedCertificateUpdateReq body = null;
        // TrustedCertificateResp response = api.updateCertificate(certId, body);

        // TODO: test validations
    }

    /**
     * Update API key details.
     *
     * An endpoint for updating API key details. **Example usage:** &#x60;curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/api-keys/me -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39;
     * -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateMyApiKeyTest() {
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateMyApiKey(body);

        // TODO: test validations
    }
}
