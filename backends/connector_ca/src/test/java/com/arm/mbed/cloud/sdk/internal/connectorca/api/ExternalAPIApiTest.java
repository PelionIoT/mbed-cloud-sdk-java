package com.arm.mbed.cloud.sdk.internal.connectorca.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ExternalAPIApi
 */
public class ExternalAPIApiTest {

    private ExternalAPIApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ExternalAPIApi.class);
    }

    
    /**
     * Fetch an existing developer certificate to connect to the bootstrap server.
     *
     * This REST API is intended to be used by customers to fetch an existing developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server). 
     */
    @Test
    public void v3DeveloperCertificatesMuuidGetTest() {
        String muuid = null;
        String authorization = null;
        // DeveloperCertificateResponseData response = api.v3DeveloperCertificatesMuuidGet(muuid, authorization);

        // TODO: test validations
    }
    
    /**
     * Create a new developer certificate to connect to the bootstrap server.
     *
     * This REST API is intended to be used by customers to get a developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server).  Limitations:    - One developer certificate allows up to 100 devices to connect to bootstrap server.   - Only 10 developer certificates are allowed per account. 
     */
    @Test
    public void v3DeveloperCertificatesPostTest() {
        String authorization = null;
        DeveloperCertificateRequestData body = null;
        // DeveloperCertificateResponseData response = api.v3DeveloperCertificatesPost(authorization, body);

        // TODO: test validations
    }
    
    /**
     * Fetch bootstrap server credentials.
     *
     * This REST API is intended to be used by customers to fetch bootstrap server credentials that they need to use with their clients to connect to bootstrap server. 
     */
    @Test
    public void v3ServerCredentialsBootstrapGetTest() {
        String authorization = null;
        // ServerCredentialsResponseData response = api.v3ServerCredentialsBootstrapGet(authorization);

        // TODO: test validations
    }
    
    /**
     * Fetch LWM2M server credentials.
     *
     * This REST API is intended to be used by customers to fetch LWM2M server credentials that they need to use with their clients to connect to LWM2M server. 
     */
    @Test
    public void v3ServerCredentialsLwm2mGetTest() {
        String authorization = null;
        // ServerCredentialsResponseData response = api.v3ServerCredentialsLwm2mGet(authorization);

        // TODO: test validations
    }
    
}
