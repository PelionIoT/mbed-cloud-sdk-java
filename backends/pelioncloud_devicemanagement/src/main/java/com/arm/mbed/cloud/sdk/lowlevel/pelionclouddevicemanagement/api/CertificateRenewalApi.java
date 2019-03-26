package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.CertificateEnrollment;

public interface CertificateRenewalApi {
    /**
     * Request certificate renewal. Request a certificate renewal. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/devices/01612df56f3b0a580a010fc700000000/certificates/customer.dlms/renew
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-length: 0&#39; &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            The device ID. (required)
     * @param certificateName
     *            The certificate name. (required)
     * @return Call&lt;CertificateEnrollment&gt;
     */
    @POST("v3/devices/{device-id}/certificates/{certificate-name}/renew")
    Call<CertificateEnrollment>
        requestCertificateRenewal(@retrofit2.http.Path(value = "device-id", encoded = true) String deviceId,
                                  @retrofit2.http.Path(value = "certificate-name",
                                                       encoded = true) String certificateName);

}
