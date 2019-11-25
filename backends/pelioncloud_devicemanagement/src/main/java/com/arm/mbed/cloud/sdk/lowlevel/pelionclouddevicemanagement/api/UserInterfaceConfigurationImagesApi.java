package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImageList;

public interface UserInterfaceConfigurationImagesApi {
    /**
     * Revert an image to dark theme default. Revert an account branding image to dark theme default. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/clear \\
     * -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/branding-images/dark/{reference}/clear")
    Call<Void> clearDarkImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Revert an image to light theme default. Revert an account branding image to light theme default. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/clear \\
     * -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/branding-images/light/{reference}/clear")
    Call<Void> clearLightImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Delete images in the dark theme. Delete account dark theme branding images. **Example usage:** &#x60;curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/branding-images/dark -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-images/dark")
    Call<Void> deleteAllDarkImages();

    /**
     * Delete all images. Delete account branding images for all themes. **Example usage:** &#x60;curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/branding-images -H &#39;Authorization: Bearer API_KEY&#39;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-images")
    Call<Void> deleteAllImages();

    /**
     * Delete images in the light theme. Delete account light theme branding images. **Example usage:** &#x60;curl -X
     * DELETE https://api.us-east-1.mbedcloud.com/v3/branding-images/light -H &#39;Authorization: Bearer
     * API_KEY&#39;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/branding-images/light")
    Call<Void> deleteAllLightImages();

    /**
     * Get metadata of all dark theme images. Retrieve metadata for all dark theme branding images. **Example:**
     * &#x60;curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/dark \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("v3/branding-images/dark")
    Call<BrandingImageList> getAllDarkImageData();

    /**
     * Get metadata of all light theme images. Retrieve the metadata of all light theme branding images. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/light \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;BrandingImageList&gt;
     */
    @GET("v3/branding-images/light")
    Call<BrandingImageList> getAllLightImageData();

    /**
     * Get metadata of a dark theme image. Retrieve metadata for one account dark theme branding image. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("v3/branding-images/dark/{reference}")
    Call<BrandingImage> getDarkImageData(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Get metadata of a light theme image. Retrieve metadata for one account light theme branding image. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference} \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @GET("v3/branding-images/light/{reference}")
    Call<BrandingImage> getLightImageData(@retrofit2.http.Path(value = "reference", encoded = true) String reference);

    /**
     * Upload a dark theme image. Upload a new account branding image in the dark theme in PNG or JPEG format.
     * **Example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/branding-images/dark/{reference}/upload \\ -H &#39;Authorization: Bearer
     * &lt;api_key&gt;&#39; \\ -H &#39;content-type: image/png&#39; --data-binary &#39;@myimage.png&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param body
     *            The image in PNG or JPEG format. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @Headers({ "Content-Type:image/png" })
    @POST("v3/branding-images/dark/{reference}/upload")
    Call<BrandingImage> uploadDarkImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                        @retrofit2.http.Body String body);

    /**
     * Upload a dark theme image. Upload a new account branding image as form data in the dark theme in PNG or JPEG
     * format.
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param image
     *            The image in PNG or JPEG format as multipart form data. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/branding-images/dark/{reference}/upload-multipart")
    Call<BrandingImage>
        uploadDarkImageMultipart(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                 @retrofit2.http.Part() MultipartBody.Part image);

    /**
     * Upload a light theme image. Upload a new account light theme branding image in PNG or JPEG format. **Example:**
     * &#x60;&#x60;&#x60; curl -X POST https://api.us-east-1.mbedcloud.com/v3/branding-images/light/{reference}/upload
     * \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39; \\ -H &#39;content-type: image/png&#39; --data-binary
     * &#39;@myimage.png&#39; &#x60;&#x60;&#x60;
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param body
     *            The image in PNG or JPEG format. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @Headers({ "Content-Type:image/png" })
    @POST("v3/branding-images/light/{reference}/upload")
    Call<BrandingImage> uploadLightImage(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                         @retrofit2.http.Body String body);

    /**
     * Upload a light theme image. Upload a new account branding image as form data in the light theme in PNG or JPEG
     * format.
     * 
     * @param reference
     *            Name of the branding images (icon or picture). (required)
     * @param image
     *            The image in PNG or JPEG format as multipart form data. (required)
     * @return Call&lt;BrandingImage&gt;
     */
    @retrofit2.http.Multipart
    @POST("v3/branding-images/light/{reference}/upload-multipart")
    Call<BrandingImage>
        uploadLightImageMultipart(@retrofit2.http.Path(value = "reference", encoded = true) String reference,
                                  @retrofit2.http.Part() MultipartBody.Part image);

}
