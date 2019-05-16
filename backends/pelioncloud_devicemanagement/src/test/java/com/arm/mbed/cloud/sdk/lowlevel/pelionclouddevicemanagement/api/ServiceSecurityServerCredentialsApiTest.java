package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for ServiceSecurityServerCredentialsApi
 */
public class ServiceSecurityServerCredentialsApiTest {

    private ServiceSecurityServerCredentialsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ServiceSecurityServerCredentialsApi.class);
    }

    /**
     * Fetch all (Bootstrap and LwM2M) server credentials.
     *
     * Return all (bootstrap and LwM2M) server credentials for client to connect to bootstrap or LwM2M server.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET http://api.us-east-1.mbedcloud.com/v3/server-credentials \\ -H
     * \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllServerCredentialsTest() {
        // AllServerCredentialsResponseData response = api.getAllServerCredentials();

        // TODO: test validations
    }

    /**
     * Fetch bootstrap server credentials.
     *
     * Return bootstrap server credentials for client to connect to bootstrap server. **Example:** &#x60;&#x60;&#x60;
     * curl -X GET http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     */
    @Test
    public void getBootstrapServerCredentialsTest() {
        // ServerCredentialsResponseData response = api.getBootstrapServerCredentials();

        // TODO: test validations
    }

    /**
     * Fetch LwM2M server credentials.
     *
     * Return LwM2M server credentials for client to connect to LwM2M server. **Example:** &#x60;&#x60;&#x60; curl -X
     * GET http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     */
    @Test
    public void getL2M2MServerCredentialsTest() {
        // ServerCredentialsResponseData response = api.getL2M2MServerCredentials();

        // TODO: test validations
    }
}
