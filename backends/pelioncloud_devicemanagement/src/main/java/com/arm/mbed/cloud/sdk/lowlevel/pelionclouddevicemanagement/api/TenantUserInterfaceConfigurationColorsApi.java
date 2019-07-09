package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColorList;

import java.util.List;

public interface TenantUserInterfaceConfigurationColorsApi {
    /**
     * Updates an array of dark theme branding colors. Update an array of dark theme branding colors of a tenant
     * account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/dark")
    Call<Void> bulkSetAccountDarkColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                        @retrofit2.http.Body List<BrandingColor> body);

    /**
     * Updates an array of light theme branding colors. Update an array of light theme branding colors of a tenant
     * account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/light")
    Call<Void> bulkSetAccountLightColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                         @retrofit2.http.Body List<BrandingColor> body);

    /**
     * Get dark theme branding color. Retrieve the requested dark theme branding color. **Example:** &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/dark/{reference}")
    Call<BrandingColor> getAccountDarkColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                            @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get dark theme branding colors. Retrieve dark theme branding colors for an account. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/dark")
    Call<BrandingColorList>
        getAccountDarkColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Get light theme branding color. Retrieve the requested light theme branding color. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/light/{reference}")
    Call<BrandingColor>
        getAccountLightColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                             @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get light theme branding colors. Retrieve light theme branding colors for an account. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/accounts/{account_id}/branding-colors/light")
    Call<BrandingColorList>
        getAccountLightColors(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId);

    /**
     * Reset branding color to default. Resets the branding color of a tenant account to its dark theme default.
     * **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/branding-colors/dark/{reference}")
    Call<Void> resetAccountDarkColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                     @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Reset branding color to default. Resets the branding color of a tenant account to its light theme default.
     * **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/accounts/{account_id}/branding-colors/light/{reference}")
    Call<Void> resetAccountLightColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                      @retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Updates a dark theme branding color. Update a dark theme branding color of a tenant account. **Example:**
     * &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark/primary \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{
     * \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/dark/{reference}")
    Call<BrandingColor> setAccountDarkColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                                            @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                            @retrofit2.http.Body BrandingColor body);

    /**
     * Updates light theme branding color. Update a light theme branding color of a tenant account. **Example:**
     * &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light/primary \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{
     * \&quot;color\&quot;: \&quot;purple\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param accountId
     *            Account ID. (required)
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/accounts/{account_id}/branding-colors/light/{reference}")
    Call<BrandingColor>
        setAccountLightColor(@retrofit2.http.Path(value = "account_id", encoded = true) String accountId,
                             @retrofit2.http.Path(value = "reference", encoded = true) String reference,
                             @retrofit2.http.Body BrandingColor body);

}
