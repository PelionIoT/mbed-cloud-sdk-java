package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColor;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingColorList;

import java.util.List;

public interface UserInterfaceConfigurationColorsApi {
    /**
     * Updates an array of dark theme branding colors. Update an array of dark theme branding colors. **Example:**
     * &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{
     * \&quot;reference\&quot;: \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;#f3f93e\&quot; }]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/dark")
    Call<Void> bulkSetDarkColors(@retrofit2.http.Body List<BrandingColor> body);

    /**
     * Updates an array of light theme branding colors. Update an array of light theme branding colors. **Example:**
     * &#x60;&#x60;&#x60; curl -X PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/light \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ &#39;[{
     * \&quot;reference\&quot;: \&quot;primary\&quot;, \&quot;color\&quot;: \&quot;purple\&quot; }]&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param body
     *            List of branding colors. (required)
     * @return Call&lt;Void&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/light")
    Call<Void> bulkSetLightColors(@retrofit2.http.Body List<BrandingColor> body);

    /**
     * Delete all colors. Delete account branding colors for all themes. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-colors -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-colors")
    Call<Void> deleteAllColors();

    /**
     * Delete colors in the dark theme. Delete account dark theme branding colors. **Example usage:** &#x60;curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-colors/dark")
    Call<Void> deleteAllDarkColors();

    /**
     * Delete colors in the light theme. Delete account light theme branding colors. **Example usage:** &#x60;curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-colors/light")
    Call<Void> deleteAllLightColors();

    /**
     * Get dark theme branding color. Retrieve the requested dark theme branding color. **Example:** &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/{reference} \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/branding-colors/dark/{reference}")
    Call<BrandingColor> getDarkColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get dark theme branding colors. Retrieve the dark theme branding colors. **Example:** &#x60;&#x60;&#x60; curl -X
     * GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/branding-colors/dark")
    Call<BrandingColorList> getDarkColors();

    /**
     * Get light theme branding color. Retrieve the requested light theme branding color. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @GET("v3/branding-colors/light/{reference}")
    Call<BrandingColor> getLightColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get light theme branding colors. Retrieve the light theme branding colors. **Example:** &#x60;&#x60;&#x60; curl
     * -X GET https://api.us-east-1.mbedcloud.com/v3/branding-colors/light \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;BrandingColorList&gt;
     */
    @GET("v3/branding-colors/light")
    Call<BrandingColorList> getLightColors();

    /**
     * Reset branding color to default. Resets the branding color to its dark theme default. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-colors/dark/{reference}")
    Call<Void> resetDarkColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Reset branding color to default. Resets the branding color to its light theme default. **Example:**
     * &#x60;&#x60;&#x60; curl -X DELETE https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-colors/light/{reference}")
    Call<Void> resetLightColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Updates a dark theme branding color. Update a dark theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X
     * PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/dark/primary \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;:
     * \&quot;#f3f93e\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/dark/{reference}")
    Call<BrandingColor> setDarkColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                     @retrofit2.http.Body BrandingColor body);

    /**
     * Updates light theme branding color. Update light theme branding color. **Example:** &#x60;&#x60;&#x60; curl -X
     * PUT https://api.us-east-1.mbedcloud.com/v3/branding-colors/light/primary \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{ \&quot;color\&quot;:
     * \&quot;purple\&quot; }&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            The name of the branding color. (required)
     * @param body
     *            The branding color. (required)
     * @return Call&lt;BrandingColor&gt;
     */
    @Headers({ "Content-Type:application/json" })
    @PUT("v3/branding-colors/light/{reference}")
    Call<BrandingColor> setLightColor(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                      @retrofit2.http.Body BrandingColor body);

}
