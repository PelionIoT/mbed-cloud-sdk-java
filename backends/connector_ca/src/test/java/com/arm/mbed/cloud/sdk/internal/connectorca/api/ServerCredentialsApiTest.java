package com.arm.mbed.cloud.sdk.internal.connectorca.api;

import com.arm.mbed.cloud.sdk.internal.connectorca.ApiClient;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.AllServerCredentialsResponseData;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.connectorca.model.ServerCredentialsResponseData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * This REST API is intended to be used by customers to fetch all (Bootstrap and LwM2M) server credentials that they will need to use with their clients to connect to bootstrap or LwM2M server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 
     */
    @Test
    public void getAllServerCredentialsTest() {
        String authorization = null;
        // AllServerCredentialsResponseData response = api.getAllServerCredentials(authorization);

        // TODO: test validations
    }
    /**
     * Fetch bootstrap server credentials.
     *
     * This REST API is intended to be used by customers to fetch bootstrap server credentials that they will need to use with their clients to connect to bootstrap server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 
     */
    @Test
    public void getBootstrapServerCredentialsTest() {
        String authorization = null;
        // ServerCredentialsResponseData response = api.getBootstrapServerCredentials(authorization);

        // TODO: test validations
    }
    /**
     * Fetch LwM2M server credentials.
     *
     * This REST API is intended to be used by customers to fetch LwM2M server credentials that they will need to use with their clients to connect to LwM2M server.  **Example usage:** curl -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m\&quot; -H \&quot;accept: application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot; 
     */
    @Test
    public void getL2M2MServerCredentialsTest() {
        String authorization = null;
        // ServerCredentialsResponseData response = api.getL2M2MServerCredentials(authorization);

        // TODO: test validations
    }
}
