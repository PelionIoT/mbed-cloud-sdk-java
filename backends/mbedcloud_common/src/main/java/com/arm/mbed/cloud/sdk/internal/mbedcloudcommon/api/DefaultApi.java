package com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.api;

import com.arm.mbed.cloud.sdk.internal.mbedcloudcommon.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

public interface DefaultApi {
    /**
     * 
     * 
     * @return Call&lt;Void&gt;
     */
    @GET("")
    Call<Void> test();

}
