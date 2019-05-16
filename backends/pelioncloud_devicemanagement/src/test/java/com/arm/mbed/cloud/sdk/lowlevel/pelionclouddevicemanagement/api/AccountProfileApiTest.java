package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for AccountProfileApi
 */
public class AccountProfileApiTest {

    private AccountProfileApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AccountProfileApi.class);
    }

    /**
     * Get account info.
     *
     * Retrieve detailed information about the account. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me?include&#x3D;policies \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getMyAccountInfoTest() {
        String include = null;
        String properties = null;
        // AccountInfo response = api.getMyAccountInfo(include, properties);

        // TODO: test validations
    }

    /**
     * Updates attributes of the account.
     *
     * Update the account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/me \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;phone_number\&quot;: \&quot;12345678\&quot;}&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void updateMyAccountTest() {
        AccountUpdateReq body = null;
        // AccountInfo response = api.updateMyAccount(body);

        // TODO: test validations
    }
}
