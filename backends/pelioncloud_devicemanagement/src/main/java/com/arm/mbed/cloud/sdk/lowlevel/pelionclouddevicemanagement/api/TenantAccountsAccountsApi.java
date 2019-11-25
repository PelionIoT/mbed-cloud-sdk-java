package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountCreationReq;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountInfo;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountInfoList;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.AccountUpdateRootReq;

public interface TenantAccountsAccountsApi {
    /**
     * Create a new account. Create a new account. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H
     * &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;display_name\&quot;: \&quot;MyAccount1\&quot;,
     * \&quot;admin_name\&quot;: \&quot;accountAdmin1\&quot;, \&quot;email\&quot;:
     * \&quot;example_admin@myaccount.info\&quot;, \&quot;country\&quot;: \&quot;United Kingdom\&quot;,
     * \&quot;end_market\&quot;: \&quot;Smart City\&quot;, \&quot;address_line1\&quot;: \&quot;110 Fulbourn Rd\&quot;,
     * \&quot;city\&quot;: \&quot;Cambridge\&quot;, \&quot;contact\&quot;: \&quot;J. Doe\&quot;, \&quot;company\&quot;:
     * \&quot;Arm\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param body
     *            Details of the account to create. (required)
     * @param action
     *            Action, either &#x60;create&#x60; or &#x60;enroll&#x60;. &lt;ul&gt; &lt;li&gt;&#x60;create&#x60;
     *            creates the account where its admin user has ACTIVE status if &#x60;admin_password&#x60; was defined
     *            in the request, or RESET status if no &#x60;admin_password&#x60; was defined. If the user already
     *            exists, its status is not modified. &lt;/li&gt; &lt;li&gt;&#x60;enroll&#x60; creates the account where
     *            its admin user has ENROLLING status. If the user already exists, its status is not modified. Email to
     *            finish enrollment or notify the existing user about the new account is sent to the
     *            &#x60;admin_email&#x60; defined in the request. &lt;/li&gt;&lt;/ul&gt; (optional, default to create)
     * @return Call&lt;AccountInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @POST("v3/accounts")
    Call<AccountInfo> createAccount(@retrofit2.http.Body AccountCreationReq body,
                                    @retrofit2.http.Query("action") String action);

    /**
     * Get account info. Retrieve detailed information about an account. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            The ID of the account to fetch. (required)
     * @param include
     *            Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts,
     *            history. (optional)
     * @param properties
     *            Property name to return from account-specific properties. (optional)
     * @return Call&lt;AccountInfo&gt;
     */
    @GET("v3/accounts/{account_id}")
    Call<AccountInfo> getAccountInfo(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                     @retrofit2.http.Query("include") String include,
                                     @retrofit2.http.Query("properties") String properties);

    /**
     * Get all accounts. Returns an array of account objects, optionally filtered by status and tier level. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param statusEq
     *            An optional filter for account status, ENROLLING, ACTIVE, RESTRICTED, or SUSPENDED. (optional)
     * @param statusIn
     *            An optional filter to retrieve accounts with a specified set of statuses. (optional)
     * @param statusNin
     *            An optional filter to exclude accounts with a specified set of statuses. (optional)
     * @param tierEq
     *            An optional filter for tier level. Must be 0, 1, 2, 98, 99, or omitted. (optional)
     * @param parentEq
     *            An optional filter for parent account ID. (optional)
     * @param endMarketEq
     *            An optional filter for account end market. (optional)
     * @param countryLike
     *            An optional filter for account country. Finds all matches where the filter value is a case-insensitive
     *            substring of the result. Example: country__like&#x3D;LAND matches Ireland. (optional)
     * @param limit
     *            The number of results to return (2-1000). Default 1000. (optional, default to 1000)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. Default: ASC. (optional, default to ASC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: limits, policies, sub_accounts,
     *            history. (optional)
     * @param format
     *            Format information for the query response. Supported: format&#x3D;breakdown. (optional)
     * @param properties
     *            Property name returned from account-specific properties. (optional)
     * @return Call&lt;AccountInfoList&gt;
     */
    @GET("v3/accounts")
    Call<AccountInfoList>
        getAllAccounts(@retrofit2.http.Query("status__eq") String statusEq,
                       @retrofit2.http.Query("status__in") String statusIn,
                       @retrofit2.http.Query("status__nin") String statusNin,
                       @retrofit2.http.Query("tier__eq") String tierEq,
                       @retrofit2.http.Query("parent__eq") String parentEq,
                       @retrofit2.http.Query("end_market__eq") String endMarketEq,
                       @retrofit2.http.Query("country__like") String countryLike,
                       @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after,
                       @retrofit2.http.Query("order") String order, @retrofit2.http.Query("include") String include,
                       @retrofit2.http.Query("format") String format,
                       @retrofit2.http.Query("properties") String properties);

    /**
     * Update attributes of an existing account. Update an account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;phone_number\&quot;:
     * \&quot;12345678\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            The ID of the account to update. (required)
     * @param body
     *            Details of the account to update. (required)
     * @return Call&lt;AccountInfo&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}")
    Call<AccountInfo> updateAccount(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                    @retrofit2.http.Body AccountUpdateRootReq body);

}
