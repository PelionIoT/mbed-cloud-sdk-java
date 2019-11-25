package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * API tests for UserInterfaceConfigurationColorsApi
 */
public class UserInterfaceConfigurationColorsApiTest {

    private UserInterfaceConfigurationColorsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UserInterfaceConfigurationColorsApi.class);
    }

    /**
     * Updates an array of dark theme branding colors.
     *
     * Update an array of dark theme branding colors. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;: \&quot;primary\&quot;,
     * \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void bulkSetDarkColorsTest() {
        List<BrandingColor> body = null;
        // Void response = api.bulkSetDarkColors(body);

        // TODO: test validations
    }

    /**
     * Updates an array of light theme branding colors.
     *
     * Update an array of light theme branding colors. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{ \&quot;reference\&quot;:
     * \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void bulkSetLightColorsTest() {
        List<BrandingColor> body = null;
        // Void response = api.bulkSetLightColors(body);

        // TODO: test validations
    }

    /**
     * Delete all colors.
     *
     * Delete account branding colors for all themes. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAllColorsTest() {
        // Void response = api.deleteAllColors();

        // TODO: test validations
    }

    /**
     * Delete colors in the dark theme.
     *
     * Delete account dark theme branding colors. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAllDarkColorsTest() {
        // Void response = api.deleteAllDarkColors();

        // TODO: test validations
    }

    /**
     * Delete colors in the light theme.
     *
     * Delete account light theme branding colors. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     */
    @Test
    public void deleteAllLightColorsTest() {
        // Void response = api.deleteAllLightColors();

        // TODO: test validations
    }

    /**
     * Get dark theme branding color.
     *
     * Retrieve the requested dark theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/{reference} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getDarkColorTest() {
        String reference = null;
        // BrandingColor response = api.getDarkColor(reference);

        // TODO: test validations
    }

    /**
     * Get dark theme branding colors.
     *
     * Retrieve the dark theme branding colors. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getDarkColorsTest() {
        // BrandingColorList response = api.getDarkColors();

        // TODO: test validations
    }

    /**
     * Get light theme branding color.
     *
     * Retrieve the requested light theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getLightColorTest() {
        String reference = null;
        // BrandingColor response = api.getLightColor(reference);

        // TODO: test validations
    }

    /**
     * Get light theme branding colors.
     *
     * Retrieve the light theme branding colors. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getLightColorsTest() {
        // BrandingColorList response = api.getLightColors();

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color to its dark theme default. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void resetDarkColorTest() {
        String reference = null;
        // Void response = api.resetDarkColor(reference);

        // TODO: test validations
    }

    /**
     * Reset branding color to default.
     *
     * Resets the branding color to its light theme default. **Example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void resetLightColorTest() {
        String reference = null;
        // Void response = api.resetLightColor(reference);

        // TODO: test validations
    }

    /**
     * Updates a dark theme branding color.
     *
     * Update a dark theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/primary \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;:
     * \&quot;#f3f93e\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void setDarkColorTest() {
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setDarkColor(reference, body);

        // TODO: test validations
    }

    /**
     * Updates light theme branding color.
     *
     * Update light theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/primary \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;:
     * \&quot;purple\&quot; }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void setLightColorTest() {
        String reference = null;
        BrandingColor body = null;
        // BrandingColor response = api.setLightColor(reference, body);

        // TODO: test validations
    }
}
