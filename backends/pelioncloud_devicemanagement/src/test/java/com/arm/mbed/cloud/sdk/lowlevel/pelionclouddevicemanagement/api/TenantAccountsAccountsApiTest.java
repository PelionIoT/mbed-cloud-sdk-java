package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateRootReq;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantAccountsAccountsApi
 */
public class TenantAccountsAccountsApiTest {

    private TenantAccountsAccountsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantAccountsAccountsApi.class);
    }

    /**
     * Create a new account.
     *
     * Create a new account. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;,
     * \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;:
     * \&quot;example_admin@myaccount.info\&quot;, \&quot;country\&quot;: \&quot;United Kingdom\&quot;,
     * \&quot;end_market\&quot;: \&quot;Smart City\&quot;, \&quot;address_line1\&quot;: \&quot;110 Fulbourn Rd\&quot;,
     * \&quot;city\&quot;: \&quot;Cambridge\&quot;, \&quot;contact\&quot;: \&quot;J. Doe\&quot;, \&quot;company\&quot;:
     * \&quot;Arm\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void createAccountTest() {
        AccountCreationReq body = null;
        String action = null;
        // AccountInfo response = api.createAccount(body, action);

        // TODO: test validations
    }

    /**
     * Get account info.
     *
     * Retrieve detailed information about an account. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountInfoTest() {
        String accountId = null;
        String include = null;
        String properties = null;
        // AccountInfo response = api.getAccountInfo(accountId, include, properties);

        // TODO: test validations
    }

    /**
     * Get all accounts.
     *
     * Returns an array of account objects, optionally filtered by status and tier level. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountsTest() {
        String statusEq = null;
        String statusIn = null;
        String statusNin = null;
        String tierEq = null;
        String parentEq = null;
        String endMarketEq = null;
        String countryLike = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        String format = null;
        String properties = null;
        // AccountInfoList response = api.getAllAccounts(statusEq, statusIn, statusNin, tierEq, parentEq, endMarketEq,
        // countryLike, limit, after, order, include, format, properties);

        // TODO: test validations
    }

    /**
     * Update attributes of an existing account.
     *
     * Update an account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;phone_number\&quot;:
     * \&quot;12345678\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateAccountTest() {
        String accountId = null;
        AccountUpdateRootReq body = null;
        // AccountInfo response = api.updateAccount(accountId, body);

        // TODO: test validations
    }
}
