package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface DefaultApi {
  /**
   * Get alive status
   * 
   * @param deepalive An optional parameter for getting deep aliveness. Must be true or false. (optional)
   * @return Call&lt;Void&gt;
   */
  
  @GET("alive")
  Call<Void> isAlive(
    @retrofit2.http.Query("deepalive") Boolean deepalive
  );

}
