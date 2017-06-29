package com.arm.mbed.cloud.sdk.internal.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.model.Webhook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface DefaultApi {
  /**
   * Delete callback URL
   * Deletes the callback URL.
   * @return Call&lt;Void&gt;
   */
  
  @DELETE("v2/notification/callback")
  Call<Void> v2NotificationCallbackDelete();
    

  /**
   * Check callback URL
   * Shows the current callback URL if it exists.
   * @return Call&lt;Webhook&gt;
   */
  
  @GET("v2/notification/callback")
  Call<Webhook> v2NotificationCallbackGet();
    

}
