package com.arm.mbed.cloud.sdk.internal.common.api;

import com.arm.mbed.cloud.sdk.internal.common.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  /**
   * 
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("")
  Call<Void> test();
    

}
