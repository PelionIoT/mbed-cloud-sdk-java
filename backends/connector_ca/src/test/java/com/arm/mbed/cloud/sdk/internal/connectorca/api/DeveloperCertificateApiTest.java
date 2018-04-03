package com.arm.mbed.cloud.sdk.internal.connectorca.api;

import com.arm.mbed.cloud.sdk.internal.connectorca.ApiClient;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateResponseData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DeveloperCertificateApi
 */
public class DeveloperCertificateApiTest {

    private DeveloperCertificateApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeveloperCertificateApi.class);
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
}
