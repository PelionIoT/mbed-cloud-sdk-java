package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for TenantUserInterfaceConfigurationImagesApi
 */
public class TenantUserInterfaceConfigurationImagesApiTest {

    private TenantUserInterfaceConfigurationImagesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantUserInterfaceConfigurationImagesApi.class);
    }

    /**
     * Revert an image to dark theme default.
     *
     * Revert an account branding image to dark theme default. **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/clear \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void clearAccountDarkImageTest() {
        String accountId = null;
        String reference = null;
        // Void response = api.clearAccountDarkImage(accountId, reference);

        // TODO: test validations
    }

    /**
     * Revert an image to light theme default.
     *
     * Revert an account branding image to light theme default. **Example:** &#x60;&#x60;&#x60;curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/clear \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void clearAccountLightImageTest() {
        String accountId = null;
        String reference = null;
        // Void response = api.clearAccountLightImage(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get metadata of a dark theme image.
     *
     * Retrieve metadata of one account dark theme branding image. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountDarkImageDataTest() {
        String accountId = null;
        String reference = null;
        // BrandingImage response = api.getAccountDarkImageData(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get metadata of a light theme image.
     *
     * Retrieve metadata for one account light theme branding image. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAccountLightImageDataTest() {
        String accountId = null;
        String reference = null;
        // BrandingImage response = api.getAccountLightImageData(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get metadata of all dark theme images.
     *
     * Retrieve the metadata of all dark theme branding images. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountDarkImageDataTest() {
        String accountId = null;
        // BrandingImageList response = api.getAllAccountDarkImageData(accountId);

        // TODO: test validations
    }

    /**
     * Get metadata of all light theme images.
     *
     * Retrieve the metadata of all light theme branding images. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getAllAccountLightImageDataTest() {
        String accountId = null;
        // BrandingImageList response = api.getAllAccountLightImageData(accountId);

        // TODO: test validations
    }

    /**
     * Upload a dark theme image.
     *
     * Upload a new account dark theme branding image in PNG or JPEG format. **Example:** &#x60;&#x60;&#x60; curl -X
     * POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/dark/{reference}/upload \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; -H &#39;content-type: image/png&#39; --data-binary
     * &#39;@myimage.png&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadAccountDarkImageTest() {
        String accountId = null;
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadAccountDarkImage(accountId, reference, body);

        // TODO: test validations
    }

    /**
     * Upload a dark theme image.
     *
     * Upload a new account dark theme branding image as form data in PNG or JPEG format.
     */
    @Test
    public void uploadAccountDarkImageMultipartTest() {
        String accountId = null;
        String reference = null;
        File image = null;
        // BrandingImage response = api.uploadAccountDarkImageMultipart(accountId, reference, image);

        // TODO: test validations
    }

    /**
     * Upload a light theme image.
     *
     * Upload a new account light theme branding image in PNG or JPEG format. **Example:** &#x60;&#x60;&#x60; curl -X
     * POST https://api.us-east-1.mbedcloud.com/v3/accounts/{account_id}/branding-images/light/{reference}/upload \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: image/png&#39; --data-binary
     * &#39;@myimage.png&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void uploadAccountLightImageTest() {
        String accountId = null;
        String reference = null;
        String body = null;
        // BrandingImage response = api.uploadAccountLightImage(accountId, reference, body);

        // TODO: test validations
    }

    /**
     * Upload a light theme image.
     *
     * Upload a new account branding image as form data in PNG or JPEG format.
     */
    @Test
    public void uploadAccountLightImageMultipartTest() {
        String accountId = null;
        String reference = null;
        File image = null;
        // BrandingImage response = api.uploadAccountLightImageMultipart(accountId, reference, image);

        // TODO: test validations
    }
}
