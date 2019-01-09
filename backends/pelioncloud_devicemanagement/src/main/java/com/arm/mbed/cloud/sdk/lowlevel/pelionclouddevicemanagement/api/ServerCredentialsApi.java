package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AllServerCredentialsResponseData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServerCredentialsResponseData;

public interface ServerCredentialsApi {
    /**
     * Fetch all (Bootstrap and LwM2M) server credentials. This REST API is intended to be used by customers to fetch
     * all (Bootstrap and LwM2M) server credentials that they will need to use with their clients to connect to
     * bootstrap or LwM2M server. **Example usage:** curl -X GET
     * \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials\&quot; -H \&quot;accept: application/json\&quot;
     * -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;
     * 
     * @return Call&lt;AllServerCredentialsResponseData&gt;
     */
    @GET("v3/server-credentials")
    Call<AllServerCredentialsResponseData> getAllServerCredentials();

    /**
     * Fetch bootstrap server credentials. This REST API is intended to be used by customers to fetch bootstrap server
     * credentials that they will need to use with their clients to connect to bootstrap server. **Example usage:** curl
     * -X GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap\&quot; -H \&quot;accept:
     * application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;
     * 
     * @return Call&lt;ServerCredentialsResponseData&gt;
     */
    @GET("v3/server-credentials/bootstrap")
    Call<ServerCredentialsResponseData> getBootstrapServerCredentials();

    /**
     * Fetch LwM2M server credentials. This REST API is intended to be used by customers to fetch LwM2M server
     * credentials that they will need to use with their clients to connect to LwM2M server. **Example usage:** curl -X
     * GET \&quot;http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m\&quot; -H \&quot;accept:
     * application/json\&quot; -H \&quot;Authorization: Bearer THE_ACCESS_TOKEN\&quot;
     * 
     * @return Call&lt;ServerCredentialsResponseData&gt;
     */
    @GET("v3/server-credentials/lwm2m")
    Call<ServerCredentialsResponseData> getL2M2MServerCredentials();

}
