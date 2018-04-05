package com.arm.mbed.cloud.sdk.internal.connectorbootstrap.api;

import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKey;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKeyWithoutSecret;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PreSharedKeysApi {
  /**
   * Remove a pre-shared key.
   * Remove a pre-shared key.
   * @param endpointName The endpoint name. A unique identifier of the pre-shared key. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v2/device-shared-keys/{endpoint_name}")
  Call<Void> deleteAPreSharedKey(
    @retrofit2.http.Path(value = "endpoint_name", encoded = true) String endpointName
  );

  /**
   * Get a pre-shared key.
   * Check if a pre-shared key for an endpoint exists or not. The response does not contain the secret itself. 
   * @param endpointName The endpoint name. A unique identifier of the pre-shared key. [Reserved characters](https://en.wikipedia.org/wiki/Percent-encoding#Percent-encoding_reserved_characters) must be percent-encoded. (required)
   * @return Call&lt;PreSharedKeyWithoutSecret&gt;
   */
  @GET("v2/device-shared-keys/{endpoint_name}")
  Call<PreSharedKeyWithoutSecret> getAPreSharedKey(
    @retrofit2.http.Path(value = "endpoint_name", encoded = true) String endpointName
  );

  /**
   * Upload a pre-shared key to Mbed Cloud.
   * Upload a pre-shared key (PSK) for an endpoint to allow it to bootstrap. The existing key will not be overwritten but needs to be deleted first in case of re-setting PSK for an endpoint.  **Note**: The PSK APIs are available only to accounts that have this feature enabled.  &#x60;&#x60;&#x60; Example payloads: {\&quot;endpoint_name\&quot;: \&quot;myEndpoint\&quot;, \&quot;secret_hex\&quot;: \&quot;4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; } {\&quot;endpoint_name\&quot;: \&quot;myEndpoint\&quot;, \&quot;secret_hex\&quot;: \&quot;0x4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a4a\&quot; } &#x60;&#x60;&#x60; 
   * @param body Pre-shared key to be uploaded. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("v2/device-shared-keys")
  Call<Void> uploadAPreSharedKey(
    @retrofit2.http.Body PreSharedKey body
  );

}
