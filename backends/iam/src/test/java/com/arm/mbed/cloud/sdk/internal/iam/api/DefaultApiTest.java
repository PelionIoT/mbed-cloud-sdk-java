package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DefaultApi.class);
    }

    
    /**
     * Download agreement as a document.
     *
     * Endpoint for download limits by account ID.
     */
    @Test
    public void downloadAgreementTest() {
        String agreementId = null;
        // Void response = api.downloadAgreement(agreementId);

        // TODO: test validations
    }
    
    /**
     * The heartbeat method for this API.
     *
     * 
     */
    @Test
    public void headDownloadsTest() {
        // Void response = api.headDownloads();

        // TODO: test validations
    }
    
    /**
     * Get alive status
     *
     * 
     */
    @Test
    public void isAliveTest() {
        Boolean deepalive = null;
        // Void response = api.isAlive(deepalive);

        // TODO: test validations
    }
    
}
