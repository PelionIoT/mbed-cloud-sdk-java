package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.iam.ApiClient;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.UpdatedResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * An endpoint for adding API key to groups.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for creating a new API key.   **Example usage:** &#x60;curl -X POST https://api.us-east-1.mbedcloud.com/v3/api-keys -d &#39;{\&quot;name\&quot;: \&quot;MyKey1\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for deleting the API key.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteApiKeyTest() {
        String apiKey = null;
        // Void response = api.deleteApiKey(apiKey);

        // TODO: test validations
    }
    /**
     * Delete a trusted certificate by ID.
     *
     * An endpoint for deleting a trusted certificate.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for retrieving API keys in an array, optionally filtered by the owner.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for retrieving trusted certificates in an array.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/trusted-certificates -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
        String issuerLike = null;
        String subjectLike = null;
        // TrustedCertificateRespList response = api.getAllCertificates(limit, after, order, include, nameEq, serviceEq, expireEq, deviceExecutionModeEq, deviceExecutionModeNeq, ownerEq, enrollmentModeEq, issuerLike, subjectLike);

        // TODO: test validations
    }
    /**
     * Get all group information.
     *
     * An endpoint for retrieving all group information.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * Get API key details.
     *
     * An endpoint for retrieving API key details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getApiKeyTest() {
        String apiKey = null;
        // ApiKeyInfoResp response = api.getApiKey(apiKey);

        // TODO: test validations
    }
    /**
     * Get the API keys of a group.
     *
     * An endpoint for listing the API keys of the group with details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id}/api-keys -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getApiKeysOfGroupTest() {
        String groupID = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // ApiKeyInfoRespList response = api.getApiKeysOfGroup(groupID, limit, after, order, include);

        // TODO: test validations
    }
    /**
     * Get trusted certificate by ID.
     *
     * An endpoint for retrieving a trusted certificate by ID.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getCertificateTest() {
        String certId = null;
        // TrustedCertificateResp response = api.getCertificate(certId);

        // TODO: test validations
    }
    /**
     * Get group information.
     *
     * An endpoint for getting general information about the group.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id} -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getGroupSummaryTest() {
        String groupID = null;
        // GroupSummary response = api.getGroupSummary(groupID);

        // TODO: test validations
    }
    /**
     * Get groups of the API key.
     *
     * An endpoint for retrieving groups of the API key.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * Get account info.
     *
     * Returns detailed information about the account.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies -H &#39;Authorization: Bearer API_KEY&#39;&#x60;.
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
     * An endpoint for retrieving API key details.   **Example usage:** &#x60;curl https://api.us-east-1.mbedcloud.com/v3/api-keys/me -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void getMyApiKeyTest() {
        // ApiKeyInfoResp response = api.getMyApiKey();

        // TODO: test validations
    }
    /**
     * Remove API keys from a group.
     *
     * An endpoint for removing API keys from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/policy-groups/{group-id}/api-keys -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void removeApiKeysFromGroupTest() {
        String groupID = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeApiKeysFromGroup(groupID, body);

        // TODO: test validations
    }
    /**
     * Remove API key from groups.
     *
     * An endpoint for removing API key from groups.   **Example usage:** &#x60;curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/api-keys/me/groups -d &#39;[0162056a9a1586f30242590700000000,0117056a9a1586f30242590700000000]&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for updating API key details.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/api-keys/{apikey-id} -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateApiKeyTest() {
        String apiKey = null;
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateApiKey(apiKey, body);

        // TODO: test validations
    }
    /**
     * Update trusted certificate.
     *
     * An endpoint for updating existing trusted certificates.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/trusted-certificates/{cert-id} -d {\&quot;description\&quot;: \&quot;very important cert\&quot;} -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
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
     * An endpoint for updating API key details.   **Example usage:** &#x60;curl -X PUT https://api.us-east-1.mbedcloud.com/v3/api-keys/me -d &#39;{\&quot;name\&quot;: \&quot;TestApiKey25\&quot;}&#39; -H &#39;content-type: application/json&#39; -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void updateMyApiKeyTest() {
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateMyApiKey(body);

        // TODO: test validations
    }
}
