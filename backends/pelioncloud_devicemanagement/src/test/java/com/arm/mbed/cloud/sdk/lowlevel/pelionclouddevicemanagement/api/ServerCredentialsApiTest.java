package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for ServerCredentialsApi
 */
public class ServerCredentialsApiTest {

    private ServerCredentialsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ServerCredentialsApi.class);
    }

    /**
     * Fetch all (Bootstrap and LwM2M) server credentials.
     *
     * This REST API is intended to be used by customers to fetch all (Bootstrap and LwM2M) server credentials that they
     * will need to use with their clients to connect to bootstrap or LwM2M server. **Example usage:** curl -X GET
     * \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials\&quot; -H \&quot;accept: application/json\&quot;
     * -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;
     */
    @Test
    public void getAllServerCredentialsTest() {
        // AllServerCredentialsResponseData response = api.getAllServerCredentials();

        // TODO: test validations
    }

    /**
     * Fetch bootstrap server credentials.
     *
     * This REST API is intended to be used by customers to fetch bootstrap server credentials that they will need to
     * use with their clients to connect to bootstrap server. **Example usage:** curl -X GET
     * \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap\&quot; -H \&quot;accept:
     * application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;
     */
    @Test
    public void getBootstrapServerCredentialsTest() {
        // ServerCredentialsResponseData response = api.getBootstrapServerCredentials();

        // TODO: test validations
    }

    /**
     * Fetch LwM2M server credentials.
     *
     * This REST API is intended to be used by customers to fetch LwM2M server credentials that they will need to use
     * with their clients to connect to LwM2M server. **Example usage:** curl -X GET
     * \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m\&quot; -H \&quot;accept:
     * application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;
     */
    @Test
    public void getL2M2MServerCredentialsTest() {
        // ServerCredentialsResponseData response = api.getL2M2MServerCredentials();

        // TODO: test validations
    }
}
