package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * API tests for TenantUserInterfaceConfigurationColorsApi
 */
public class TenantUserInterfaceConfigurationColorsApiTest {

    private TenantUserInterfaceConfigurationColorsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantUserInterfaceConfigurationColorsApi.class);
    }

    /**
     * Updates an array of dark theme branding colors.
     *
     * Update an array of dark theme branding colors of a tenant account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void bulkSetAccountDarkColorsTest() {
        String accountId = null;
        List<BrandingColor> body = null;
        // Void response = api.bulkSetAccountDarkColors(accountId, body);

        // TODO: test validations
    }

    /**
     * Updates an array of light theme branding colors.
     *
     * Update an array of light theme branding colors of a tenant account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void bulkSetAccountLightColorsTest() {
        String accountId = null;
        List<BrandingColor> body = null;
        // Void response = api.bulkSetAccountLightColors(accountId, body);

        // TODO: test validations
    }

    /**
     * Delete all colors.
     *
     * Delete account branding colors for all themes. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAllAccountColorsTest() {
        String accountId = null;
        // Void response = api.deleteAllAccountColors(accountId);

        // TODO: test validations
    }

    /**
     * Delete colors in the dark theme.
     *
     * Delete account dark theme branding colors. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAllAccountDarkColorsTest() {
        String accountId = null;
        // Void response = api.deleteAllAccountDarkColors(accountId);

        // TODO: test validations
    }

    /**
     * Delete colors in the light theme.
     *
     * Delete account light theme branding colors. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAllAccountLightColorsTest() {
        String accountId = null;
        // Void response = api.deleteAllAccountLightColors(accountId);

        // TODO: test validations
    }

    /**
     * Get dark theme branding color.
     *
     * Retrieve the requested dark theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountDarkColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.getAccountDarkColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get dark theme branding colors.
     *
     * Retrieve dark theme branding colors for an account. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountDarkColorsTest() {
        String accountId = null;
        // BrandingColorList response = api.getAccountDarkColors(accountId);

        // TODO: test validations
    }

    /**
     * Get light theme branding color.
     *
     * Retrieve the requested light theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountLightColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.getAccountLightColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get light theme branding colors.
     *
     * Retrieve light theme branding colors for an account. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountLightColorsTest() {
        String accountId = null;
        // BrandingColorList response = api.getAccountLightColors(accountId);

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color of a tenant account to its dark theme default. **Example:** &#x60;&#x60;&#x60; curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/dark/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void resetAccountDarkColorTest() {
        String accountId = null;
        String reference = null;
        // Void response = api.resetAccountDarkColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color of a tenant account to its light theme default. **Example:** &#x60;&#x60;&#x60; curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-colors/light/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void resetAccountLightColorTest() {
        String accountId = null;
        String reference = null;
        // Void response = api.resetAccountLightColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Updates a dark theme branding color.
     *
     * Update a dark theme branding color of a tenant account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/dark/primary \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{
     * \&quot;color\&quot;: \&quot;#f3f93e\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void setAccountDarkColorTest() {
        String accountId = null;
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setAccountDarkColor(accountId, reference, body);

        // TODO: test validations
    }

    /**
     * Updates light theme branding color.
     *
     * Update a light theme branding color of a tenant account. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id)/branding-colors/light/primary \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{
     * \&quot;color\&quot;: \&quot;purple\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void setAccountLightColorTest() {
        String accountId = null;
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setAccountLightColor(accountId, reference, body);

        // TODO: test validations
    }
}
