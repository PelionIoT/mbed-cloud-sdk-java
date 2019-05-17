package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateReq;

public interface AccountProfileApi {
    /**
     * Get account info. Retrieve detailed information about the account. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param include
     *            Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts.
     *            (optional)
     * @param properties
     *            Property name to return from account-specific properties. (optional)
     * @return Call&lt;AccountInfo&gt;
     */
    @GET("v3/accounts/me")
    Call<AccountInfo> getMyAccountInfo(@retrofit2.http.Query("include") String include,
                                       @retrofit2.http.Query("properties") String properties);

    /**
     * Updates attributes of the account. Update the account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            Details of the account to update. (required)
     * @return Call&lt;AccountInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/me")
    Call<AccountInfo> updateMyAccount(@retrofit2.http.Body AccountUpdateReq body);

}
