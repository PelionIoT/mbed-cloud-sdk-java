package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AllServerCredentialsResponseData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ServerCredentialsResponseData;

public interface ServiceSecurityServerCredentialsApi {
    /**
     * Fetch all (Bootstrap and LwM2M) server credentials. Return all (bootstrap and LwM2M) server credentials for
     * client to connect to bootstrap or LwM2M server. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * http://api.us-east-1.mbedcloud.com/v3/server-credentials \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;AllServerCredentialsResponseData&gt;
     */
    @GET("v3/server-credentials")
    Call<AllServerCredentialsResponseData> getAllServerCredentials();

    /**
     * Fetch bootstrap server credentials. Return bootstrap server credentials for client to connect to bootstrap
     * server. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * http://api.us-east-1.mbedcloud.com/v3/server-credentials/bootstrap \\ -H \&quot;Authorization: Bearer
     * &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServerCredentialsResponseData&gt;
     */
    @GET("v3/server-credentials/bootstrap")
    Call<ServerCredentialsResponseData> getBootstrapServerCredentials();

    /**
     * Fetch LwM2M server credentials. Return LwM2M server credentials for client to connect to LwM2M server.
     * **Example:** &#x60;&#x60;&#x60; curl -X GET http://api.us-east-1.mbedcloud.com/v3/server-credentials/lwm2m \\ -H
     * \&quot;Authorization: Bearer &lt;api_key&gt;\&quot; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ServerCredentialsResponseData&gt;
     */
    @GET("v3/server-credentials/lwm2m")
    Call<ServerCredentialsResponseData> getL2M2MServerCredentials();

}
