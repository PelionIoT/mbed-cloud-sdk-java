package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for UserInterfaceConfigurationImagesApi
 */
public class UserInterfaceConfigurationImagesApiTest {

    private UserInterfaceConfigurationImagesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UserInterfaceConfigurationImagesApi.class);
    }

    /**
     * Revert an image to dark theme default.
     *
     * Revert an account branding image to dark theme default. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/clear \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void clearDarkImageTest() {
        String reference = null;
        // Void response = api.clearDarkImage(reference);

        // TODO: test validations
    }

    /**
     * Revert an image to light theme default.
     *
     * Revert an account branding image to light theme default. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/clear \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void clearLightImageTest() {
        String reference = null;
        // Void response = api.clearLightImage(reference);

        // TODO: test validations
    }

    /**
     * Get metadata of all dark theme images.
     *
     * Retrieve metadata for all dark theme branding images. **Example:** &#x60;curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllDarkImageDataTest() {
        // BrandingImageList response = api.getAllDarkImageData();

        // TODO: test validations
    }

    /**
     * Get metadata of all light theme images.
     *
     * Retrieve the metadata of all light theme branding images. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllLightImageDataTest() {
        // BrandingImageList response = api.getAllLightImageData();

        // TODO: test validations
    }

    /**
     * Get metadata of a dark theme image.
     *
     * Retrieve metadata for one account dark theme branding image. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getDarkImageDataTest() {
        String reference = null;
        // BrandingImage response = api.getDarkImageData(reference);

        // TODO: test validations
    }

    /**
     * Get metadata of a light theme image.
     *
     * Retrieve metadata for one account light theme branding image. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference} \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getLightImageDataTest() {
        String reference = null;
        // BrandingImage response = api.getLightImageData(reference);

        // TODO: test validations
    }

    /**
     * Upload a dark theme image.
     *
     * Upload a new account branding image in the dark theme in PNG or JPEG format. **Example:** &#x60;&#x60;&#x60; curl
     * -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/upload \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: image/png&#39; --data-binary &#39;@myimage.png&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadDarkImageTest() {
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadDarkImage(reference, body);

        // TODO: test validations
    }

    /**
     * Upload a dark theme image.
     *
     * Upload a new account branding image as form data in the dark theme in PNG or JPEG format.
     */
    @Test
    public void uploadDarkImageMultipartTest() {
        String reference = null;
        File image = null;
        // BrandingImage response = api.uploadDarkImageMultipart(reference, image);

        // TODO: test validations
    }

    /**
     * Upload a light theme image.
     *
     * Upload a new account light theme branding image in PNG or JPEG format. **Example:** &#x60;&#x60;&#x60; curl -X
     * POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/upload \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: image/png&#39; --data-binary &#39;@myimage.png&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadLightImageTest() {
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadLightImage(reference, body);

        // TODO: test validations
    }

    /**
     * Upload a light theme image.
     *
     * Upload a new account branding image as form data in the light theme in PNG or JPEG format.
     */
    @Test
    public void uploadLightImageMultipartTest() {
        String reference = null;
        File image = null;
        // BrandingImage response = api.uploadLightImageMultipart(reference, image);

        // TODO: test validations
    }
}
