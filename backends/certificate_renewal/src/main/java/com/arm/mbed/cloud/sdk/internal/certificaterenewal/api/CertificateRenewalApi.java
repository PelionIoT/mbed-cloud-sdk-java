package com.arm.mbed.cloud.sdk.internal.certificaterenewal.api;

import com.arm.mbed.cloud.sdk.internal.certificaterenewal.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.CertificateEnrollment;
import com.arm.mbed.cloud.sdk.internal.certificaterenewal.model.ErrorObjectResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CertificateRenewalApi {
  /**
   * Request certificate renewal.
   * Request a certificate renewal.  **Example usage:**  &#x60;&#x60;&#x60; curl -X POST -H &#39;authorization: Bearer &lt;valid access token&gt;&#39; -H &#39;content-length: 0&#39; https://api.us-east-1.mbedcloud.com/v3/devices/01612df56f3b0a580a010fc700000000/certificates/customer.dlms/renew &#x60;&#x60;&#x60; 
   * @param deviceId The device ID. (required)
   * @param certificateName The certificate name. (required)
   * @return Call&lt;CertificateEnrollment&gt;
   */
  @POST("v3/devices/{device-id}/certificates/{certificate-name}/renew")
  Call<CertificateEnrollment> requestCertificateRenewal(
    @retrofit2.http.Path(value = "device-id", encoded = true) String deviceId, @retrofit2.http.Path(value = "certificate-name", encoded = true) String certificateName
  );

}
