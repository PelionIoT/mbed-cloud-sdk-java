package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyUpdateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.SubjectList;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateReq;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.TrustedCertificateRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UpdatedResponse;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserUpdateReq;
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
     * Create a new API key.
     *
     * An endpoint for creating a new API key.
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
     * An endpoint for deleting the API key.
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
     * An endpoint for deleting a trusted certificate.
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
     * An endpoint for retrieving API keys in an array, optionally filtered by the owner.
     */
    @Test
    public void getAllApiKeysTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String ownerEq = null;
        // ApiKeyInfoRespList response = api.getAllApiKeys(limit, after, order, include, ownerEq);

        // TODO: test validations
    }
    
    /**
     * Get all trusted certificates.
     *
     * An endpoint for retrieving trusted certificates in an array.
     */
    @Test
    public void getAllCertificatesTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String serviceEq = null;
        Integer expireEq = null;
        Integer deviceExecutionModeEq = null;
        String ownerEq = null;
        // TrustedCertificateRespList response = api.getAllCertificates(limit, after, order, include, serviceEq, expireEq, deviceExecutionModeEq, ownerEq);

        // TODO: test validations
    }
    
    /**
     * Get all group information.
     *
     * An endpoint for retrieving all group information.
     */
    @Test
    public void getAllGroupsTest() {
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // GroupSummaryList response = api.getAllGroups(limit, after, order, include);

        // TODO: test validations
    }
    
    /**
     * Get API key details.
     *
     * An endpoint for retrieving API key details.
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
     * An endpoint for listing the API keys of the group with details.
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
     * An endpoint for retrieving a trusted certificate by ID.
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
     * An endpoint for getting general information about the group.
     */
    @Test
    public void getGroupSummaryTest() {
        String groupID = null;
        // GroupSummary response = api.getGroupSummary(groupID);

        // TODO: test validations
    }
    
    /**
     * Get account info.
     *
     * Returns detailed information about the account.
     */
    @Test
    public void getMyAccountInfoTest() {
        String include = null;
        // AccountInfo response = api.getMyAccountInfo(include);

        // TODO: test validations
    }
    
    /**
     * Get API key details.
     *
     * An endpoint for retrieving API key details.
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
        // UserInfoResp response = api.getMyUser();

        // TODO: test validations
    }
    
    /**
     * Remove API keys from a group.
     *
     * An endpoint for removing API keys from groups.
     */
    @Test
    public void removeApiKeysFromGroupTest() {
        String groupID = null;
        SubjectList body = null;
        // UpdatedResponse response = api.removeApiKeysFromGroup(groupID, body);

        // TODO: test validations
    }
    
    /**
     * Update API key details.
     *
     * An endpoint for updating API key details.
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
     * An endpoint for updating existing trusted certificates.
     */
    @Test
    public void updateCertificateTest() {
        String certId = null;
        TrustedCertificateReq body = null;
        // TrustedCertificateResp response = api.updateCertificate(certId, body);

        // TODO: test validations
    }
    
    /**
     * Update API key details.
     *
     * An endpoint for updating API key details.
     */
    @Test
    public void updateMyApiKeyTest() {
        ApiKeyUpdateReq body = null;
        // ApiKeyInfoResp response = api.updateMyApiKey(body);

        // TODO: test validations
    }
    
    /**
     * Update user details.
     *
     * An endpoint for updating the details of the logged in user.
     */
    @Test
    public void updateMyUserTest() {
        UserUpdateReq body = null;
        // UserInfoResp response = api.updateMyUser(body);

        // TODO: test validations
    }
    
}
