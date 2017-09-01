package com.arm.mbed.cloud.sdk.internal.iam.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.iam.model.ErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface DefaultApi {
  /**
   * Download agreement as a document.
   * Endpoint for download limits by account ID.
   * @param agreementId The ID of the agreement to be returned. (required)
   * @return Call&lt;Void&gt;
   */
  
  @GET("downloads/agreements/{agreement-id}")
  Call<Void> downloadAgreement(
    @retrofit2.http.Path("agreement-id") String agreementId
  );

  /**
   * The heartbeat method for this API.
   * 
   * @return Call&lt;Void&gt;
   */
  
  @HEAD("downloads/agreements")
  Call<Void> headDownloads();
    

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
