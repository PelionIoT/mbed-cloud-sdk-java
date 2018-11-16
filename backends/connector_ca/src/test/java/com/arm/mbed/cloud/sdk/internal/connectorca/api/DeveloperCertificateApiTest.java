package com.arm.mbed.cloud.sdk.internal.connectorca.api;

import com.arm.mbed.cloud.sdk.internal.connectorca.ApiClient;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateRequestData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.DeveloperCertificateResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ErrorResponse;
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
     * Create a new developer certificate to connect to the bootstrap server.
     *
     * This REST API is intended to be used by customers to get a developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server).  **Note:** The number of developer certificates allowed per account is limited. Please see [Using your own certificate authority](/docs/current/mbed-cloud-deploy/instructions-for-factory-setup-and-device-provision.html#using-your-own-certificate-authority-with-mbed-cloud).  **Example usage:** curl -X POST \&quot;http://api.us-east-1.mbedcloud.com/v3/developer-certificates\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; -H \&quot;content-type: application/json\&quot; -d \&quot;{ \\\&quot;name\\\&quot;: \\\&quot;THE_CERTIFICATE_NAME\\\&quot;, \\\&quot;description\\\&quot;: \\\&quot;THE_CERTIFICATE_DESCRIPTION\\\&quot;}\&quot; 
     */
    @Test
    public void createDeveloperCertificateTest() {
        DeveloperCertificateRequestData body = null;
        // DeveloperCertificateResponseData response = api.createDeveloperCertificate(body);

        // TODO: test validations
    }
    /**
     * Fetch an existing developer certificate to connect to the bootstrap server.
     *
     * This REST API is intended to be used by customers to fetch an existing developer certificate (a certificate that can be flashed into multiple devices to connect to bootstrap server).  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/developer-certificates/THE_CERTIFICATE_ID\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 
     */
    @Test
    public void getDeveloperCertificateTest() {
        String developerCertificateId = null;
        // DeveloperCertificateResponseData response = api.getDeveloperCertificate(developerCertificateId);

        // TODO: test validations
    }
}
