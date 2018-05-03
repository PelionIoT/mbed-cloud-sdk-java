package com.arm.mbed.cloud.sdk.internal.updateservice.api;

import com.arm.mbed.cloud.sdk.internal.updateservice.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignMetrics;
import java.io.File;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  /**
   * Create an image
   * Create a firmware image.
   * @param datafile The firmware image file to upload (required)
   * @param name The name of the firmware image (required)
   * @param description The description of the firmware image (optional)
   * @return Call&lt;FirmwareImage&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/firmware-images/")
  Call<FirmwareImage> firmwareImageCreate(
    @retrofit2.http.Part() MultipartBody.Part datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description
  );

  /**
   * Delete an image
   * Delete a firmware image.
   * @param imageId The firmware image ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/firmware-images/{image_id}/")
  Call<Void> firmwareImageDestroy(
    @retrofit2.http.Path(value = "image_id", encoded = true) String imageId
  );

  /**
   * List all images
   * List all firmware images.
   * @param limit How many firmware images to retrieve (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param createdAtEq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNeq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtIn Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNin Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtLte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtGte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param datafileEq Filter for datafile (optional)
   * @param datafileNeq Filter for datafile (optional)
   * @param datafileIn Filter for datafile (optional)
   * @param datafileNin Filter for datafile (optional)
   * @param datafileChecksumEq Filter for datafile_checksum (optional)
   * @param datafileChecksumNeq Filter for datafile_checksum (optional)
   * @param datafileChecksumIn Filter for datafile_checksum (optional)
   * @param datafileChecksumNin Filter for datafile_checksum (optional)
   * @param datafileSizeEq Filter for datafile_size (optional)
   * @param datafileSizeNeq Filter for datafile_size (optional)
   * @param datafileSizeIn Filter for datafile_size (optional)
   * @param datafileSizeNin Filter for datafile_size (optional)
   * @param descriptionEq Filter for description (optional)
   * @param descriptionNeq Filter for description (optional)
   * @param descriptionIn Filter for description (optional)
   * @param descriptionNin Filter for description (optional)
   * @param etagEq Filter for etag (optional)
   * @param etagNeq Filter for etag (optional)
   * @param etagIn Filter for etag (optional)
   * @param etagNin Filter for etag (optional)
   * @param etagLte Filter for etag (optional)
   * @param etagGte Filter for etag (optional)
   * @param idEq Filter for id (optional)
   * @param idNeq Filter for id (optional)
   * @param idIn Filter for id (optional)
   * @param idNin Filter for id (optional)
   * @param nameEq Filter for name (optional)
   * @param nameNeq Filter for name (optional)
   * @param nameIn Filter for name (optional)
   * @param nameNin Filter for name (optional)
   * @param timestampEq Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampNeq Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampIn Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampNin Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampLte Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampGte Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtEq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNeq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtIn Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNin Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtLte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtGte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;FirmwareImagePage&gt;
   */
  @GET("v3/firmware-images/")
  Call<FirmwareImagePage> firmwareImageList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("created_at__eq") String createdAtEq, @retrofit2.http.Query("created_at__neq") String createdAtNeq, @retrofit2.http.Query("created_at__in") String createdAtIn, @retrofit2.http.Query("created_at__nin") String createdAtNin, @retrofit2.http.Query("created_at__lte") String createdAtLte, @retrofit2.http.Query("created_at__gte") String createdAtGte, @retrofit2.http.Query("datafile__eq") String datafileEq, @retrofit2.http.Query("datafile__neq") String datafileNeq, @retrofit2.http.Query("datafile__in") String datafileIn, @retrofit2.http.Query("datafile__nin") String datafileNin, @retrofit2.http.Query("datafile_checksum__eq") String datafileChecksumEq, @retrofit2.http.Query("datafile_checksum__neq") String datafileChecksumNeq, @retrofit2.http.Query("datafile_checksum__in") String datafileChecksumIn, @retrofit2.http.Query("datafile_checksum__nin") String datafileChecksumNin, @retrofit2.http.Query("datafile_size__eq") String datafileSizeEq, @retrofit2.http.Query("datafile_size__neq") String datafileSizeNeq, @retrofit2.http.Query("datafile_size__in") String datafileSizeIn, @retrofit2.http.Query("datafile_size__nin") String datafileSizeNin, @retrofit2.http.Query("description__eq") String descriptionEq, @retrofit2.http.Query("description__neq") String descriptionNeq, @retrofit2.http.Query("description__in") String descriptionIn, @retrofit2.http.Query("description__nin") String descriptionNin, @retrofit2.http.Query("etag__eq") String etagEq, @retrofit2.http.Query("etag__neq") String etagNeq, @retrofit2.http.Query("etag__in") String etagIn, @retrofit2.http.Query("etag__nin") String etagNin, @retrofit2.http.Query("etag__lte") String etagLte, @retrofit2.http.Query("etag__gte") String etagGte, @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin, @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("name__neq") String nameNeq, @retrofit2.http.Query("name__in") String nameIn, @retrofit2.http.Query("name__nin") String nameNin, @retrofit2.http.Query("timestamp__eq") String timestampEq, @retrofit2.http.Query("timestamp__neq") String timestampNeq, @retrofit2.http.Query("timestamp__in") String timestampIn, @retrofit2.http.Query("timestamp__nin") String timestampNin, @retrofit2.http.Query("timestamp__lte") String timestampLte, @retrofit2.http.Query("timestamp__gte") String timestampGte, @retrofit2.http.Query("updated_at__eq") String updatedAtEq, @retrofit2.http.Query("updated_at__neq") String updatedAtNeq, @retrofit2.http.Query("updated_at__in") String updatedAtIn, @retrofit2.http.Query("updated_at__nin") String updatedAtNin, @retrofit2.http.Query("updated_at__lte") String updatedAtLte, @retrofit2.http.Query("updated_at__gte") String updatedAtGte, @retrofit2.http.Query("include") String include
  );

  /**
   * Get an image
   * Retrieve a firmware image.
   * @param imageId The firmware image ID (required)
   * @return Call&lt;FirmwareImage&gt;
   */
  @GET("v3/firmware-images/{image_id}/")
  Call<FirmwareImage> firmwareImageRetrieve(
    @retrofit2.http.Path(value = "image_id", encoded = true) String imageId
  );

  /**
   * Create a manifest
   * Create a firmware manifest.
   * @param datafile The manifest file to create. The API gateway enforces the account-specific file size. (required)
   * @param name The name of the firmware manifest (required)
   * @param description The description of the firmware manifest (optional)
   * @param keyTable The key table of pre-shared keys for devices (optional)
   * @return Call&lt;FirmwareManifest&gt;
   */
  @retrofit2.http.Multipart
  @POST("v3/firmware-manifests/")
  Call<FirmwareManifest> firmwareManifestCreate(
    @retrofit2.http.Part() MultipartBody.Part datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description, @retrofit2.http.Part() MultipartBody.Part keyTable
  );

  /**
   * Delete a manifest
   * Delete a firmware manifest.
   * @param manifestId The firmware manifest ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/firmware-manifests/{manifest_id}/")
  Call<Void> firmwareManifestDestroy(
    @retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId
  );

  /**
   * List manifests
   * List firmware manifests.
   * @param limit How many firmware manifests to retrieve (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param createdAtEq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNeq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtIn Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNin Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtLte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtGte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param datafileEq Filter for datafile (optional)
   * @param datafileNeq Filter for datafile (optional)
   * @param datafileIn Filter for datafile (optional)
   * @param datafileNin Filter for datafile (optional)
   * @param datafileSizeEq Filter for datafile_size (optional)
   * @param datafileSizeNeq Filter for datafile_size (optional)
   * @param datafileSizeIn Filter for datafile_size (optional)
   * @param datafileSizeNin Filter for datafile_size (optional)
   * @param descriptionEq Filter for description (optional)
   * @param descriptionNeq Filter for description (optional)
   * @param descriptionIn Filter for description (optional)
   * @param descriptionNin Filter for description (optional)
   * @param deviceClassEq Filter for device_class (optional)
   * @param deviceClassNeq Filter for device_class (optional)
   * @param deviceClassIn Filter for device_class (optional)
   * @param deviceClassNin Filter for device_class (optional)
   * @param etagEq Filter for etag (optional)
   * @param etagNeq Filter for etag (optional)
   * @param etagIn Filter for etag (optional)
   * @param etagNin Filter for etag (optional)
   * @param etagLte Filter for etag (optional)
   * @param etagGte Filter for etag (optional)
   * @param idEq Filter for id (optional)
   * @param idNeq Filter for id (optional)
   * @param idIn Filter for id (optional)
   * @param idNin Filter for id (optional)
   * @param nameEq Filter for name (optional)
   * @param nameNeq Filter for name (optional)
   * @param nameIn Filter for name (optional)
   * @param nameNin Filter for name (optional)
   * @param timestampEq Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampNeq Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampIn Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampNin Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampLte Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param timestampGte Filter for timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtEq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNeq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtIn Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNin Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtLte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtGte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;FirmwareManifestPage&gt;
   */
  @GET("v3/firmware-manifests/")
  Call<FirmwareManifestPage> firmwareManifestList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("created_at__eq") String createdAtEq, @retrofit2.http.Query("created_at__neq") String createdAtNeq, @retrofit2.http.Query("created_at__in") String createdAtIn, @retrofit2.http.Query("created_at__nin") String createdAtNin, @retrofit2.http.Query("created_at__lte") String createdAtLte, @retrofit2.http.Query("created_at__gte") String createdAtGte, @retrofit2.http.Query("datafile__eq") String datafileEq, @retrofit2.http.Query("datafile__neq") String datafileNeq, @retrofit2.http.Query("datafile__in") String datafileIn, @retrofit2.http.Query("datafile__nin") String datafileNin, @retrofit2.http.Query("datafile_size__eq") String datafileSizeEq, @retrofit2.http.Query("datafile_size__neq") String datafileSizeNeq, @retrofit2.http.Query("datafile_size__in") String datafileSizeIn, @retrofit2.http.Query("datafile_size__nin") String datafileSizeNin, @retrofit2.http.Query("description__eq") String descriptionEq, @retrofit2.http.Query("description__neq") String descriptionNeq, @retrofit2.http.Query("description__in") String descriptionIn, @retrofit2.http.Query("description__nin") String descriptionNin, @retrofit2.http.Query("device_class__eq") String deviceClassEq, @retrofit2.http.Query("device_class__neq") String deviceClassNeq, @retrofit2.http.Query("device_class__in") String deviceClassIn, @retrofit2.http.Query("device_class__nin") String deviceClassNin, @retrofit2.http.Query("etag__eq") String etagEq, @retrofit2.http.Query("etag__neq") String etagNeq, @retrofit2.http.Query("etag__in") String etagIn, @retrofit2.http.Query("etag__nin") String etagNin, @retrofit2.http.Query("etag__lte") String etagLte, @retrofit2.http.Query("etag__gte") String etagGte, @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin, @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("name__neq") String nameNeq, @retrofit2.http.Query("name__in") String nameIn, @retrofit2.http.Query("name__nin") String nameNin, @retrofit2.http.Query("timestamp__eq") String timestampEq, @retrofit2.http.Query("timestamp__neq") String timestampNeq, @retrofit2.http.Query("timestamp__in") String timestampIn, @retrofit2.http.Query("timestamp__nin") String timestampNin, @retrofit2.http.Query("timestamp__lte") String timestampLte, @retrofit2.http.Query("timestamp__gte") String timestampGte, @retrofit2.http.Query("updated_at__eq") String updatedAtEq, @retrofit2.http.Query("updated_at__neq") String updatedAtNeq, @retrofit2.http.Query("updated_at__in") String updatedAtIn, @retrofit2.http.Query("updated_at__nin") String updatedAtNin, @retrofit2.http.Query("updated_at__lte") String updatedAtLte, @retrofit2.http.Query("updated_at__gte") String updatedAtGte, @retrofit2.http.Query("include") String include
  );

  /**
   * Get a manifest
   * Retrieve a firmware manifest.
   * @param manifestId The firmware manifest ID (required)
   * @return Call&lt;FirmwareManifest&gt;
   */
  @GET("v3/firmware-manifests/{manifest_id}/")
  Call<FirmwareManifest> firmwareManifestRetrieve(
    @retrofit2.http.Path(value = "manifest_id", encoded = true) String manifestId
  );

  /**
   * Archive a campaign.
   * This command will archive a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/update-campaigns/{campaign_id}/archive")
  Call<Void> updateCampaignArchive(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Create a campaign
   * Create an update campaign.
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @POST("v3/update-campaigns/")
  Call<UpdateCampaign> updateCampaignCreate(
    @retrofit2.http.Body UpdateCampaignPostRequest campaign
  );

  /**
   * Delete a campaign
   * Delete an update campaign.
   * @param campaignId The ID of the update campaign (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/update-campaigns/{campaign_id}/")
  Call<Void> updateCampaignDestroy(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * List all campaigns
   * Get update campaigns for devices specified by a filter.
   * @param limit How many update campaigns to retrieve (optional)
   * @param order The order of the records. Acceptable values: ASC, DESC. Default: ASC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param createdAtEq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNeq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtIn Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNin Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtLte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtGte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param descriptionEq Filter for description (optional)
   * @param descriptionNeq Filter for description (optional)
   * @param descriptionIn Filter for description (optional)
   * @param descriptionNin Filter for description (optional)
   * @param deviceFilterEq Filter for device_filter (optional)
   * @param deviceFilterNeq Filter for device_filter (optional)
   * @param deviceFilterIn Filter for device_filter (optional)
   * @param deviceFilterNin Filter for device_filter (optional)
   * @param etagEq Filter for etag (optional)
   * @param etagNeq Filter for etag (optional)
   * @param etagIn Filter for etag (optional)
   * @param etagNin Filter for etag (optional)
   * @param etagLte Filter for etag (optional)
   * @param etagGte Filter for etag (optional)
   * @param finishedEq Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param finishedNeq Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param finishedIn Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param finishedNin Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param finishedLte Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param finishedGte Filter for finished. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param idEq Filter for id (optional)
   * @param idNeq Filter for id (optional)
   * @param idIn Filter for id (optional)
   * @param idNin Filter for id (optional)
   * @param nameEq Filter for name (optional)
   * @param nameNeq Filter for name (optional)
   * @param nameIn Filter for name (optional)
   * @param nameNin Filter for name (optional)
   * @param rootManifestIdEq Filter for root_manifest_id (optional)
   * @param rootManifestIdNeq Filter for root_manifest_id (optional)
   * @param rootManifestIdIn Filter for root_manifest_id (optional)
   * @param rootManifestIdNin Filter for root_manifest_id (optional)
   * @param startedAtEq Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param startedAtNeq Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param startedAtIn Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param startedAtNin Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param startedAtLte Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param startedAtGte Filter for started_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param stateEq Filter for state (optional)
   * @param stateNeq Filter for state (optional)
   * @param stateIn Filter for state (optional)
   * @param stateNin Filter for state (optional)
   * @param updatedAtEq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNeq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtIn Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNin Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtLte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtGte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param whenEq Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param whenNeq Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param whenIn Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param whenNin Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param whenLte Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param whenGte Filter for when. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;UpdateCampaignPage&gt;
   */
  @GET("v3/update-campaigns/")
  Call<UpdateCampaignPage> updateCampaignList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("created_at__eq") String createdAtEq, @retrofit2.http.Query("created_at__neq") String createdAtNeq, @retrofit2.http.Query("created_at__in") String createdAtIn, @retrofit2.http.Query("created_at__nin") String createdAtNin, @retrofit2.http.Query("created_at__lte") String createdAtLte, @retrofit2.http.Query("created_at__gte") String createdAtGte, @retrofit2.http.Query("description__eq") String descriptionEq, @retrofit2.http.Query("description__neq") String descriptionNeq, @retrofit2.http.Query("description__in") String descriptionIn, @retrofit2.http.Query("description__nin") String descriptionNin, @retrofit2.http.Query("device_filter__eq") String deviceFilterEq, @retrofit2.http.Query("device_filter__neq") String deviceFilterNeq, @retrofit2.http.Query("device_filter__in") String deviceFilterIn, @retrofit2.http.Query("device_filter__nin") String deviceFilterNin, @retrofit2.http.Query("etag__eq") String etagEq, @retrofit2.http.Query("etag__neq") String etagNeq, @retrofit2.http.Query("etag__in") String etagIn, @retrofit2.http.Query("etag__nin") String etagNin, @retrofit2.http.Query("etag__lte") String etagLte, @retrofit2.http.Query("etag__gte") String etagGte, @retrofit2.http.Query("finished__eq") String finishedEq, @retrofit2.http.Query("finished__neq") String finishedNeq, @retrofit2.http.Query("finished__in") String finishedIn, @retrofit2.http.Query("finished__nin") String finishedNin, @retrofit2.http.Query("finished__lte") String finishedLte, @retrofit2.http.Query("finished__gte") String finishedGte, @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin, @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("name__neq") String nameNeq, @retrofit2.http.Query("name__in") String nameIn, @retrofit2.http.Query("name__nin") String nameNin, @retrofit2.http.Query("root_manifest_id__eq") String rootManifestIdEq, @retrofit2.http.Query("root_manifest_id__neq") String rootManifestIdNeq, @retrofit2.http.Query("root_manifest_id__in") String rootManifestIdIn, @retrofit2.http.Query("root_manifest_id__nin") String rootManifestIdNin, @retrofit2.http.Query("started_at__eq") String startedAtEq, @retrofit2.http.Query("started_at__neq") String startedAtNeq, @retrofit2.http.Query("started_at__in") String startedAtIn, @retrofit2.http.Query("started_at__nin") String startedAtNin, @retrofit2.http.Query("started_at__lte") String startedAtLte, @retrofit2.http.Query("started_at__gte") String startedAtGte, @retrofit2.http.Query("state__eq") String stateEq, @retrofit2.http.Query("state__neq") String stateNeq, @retrofit2.http.Query("state__in") String stateIn, @retrofit2.http.Query("state__nin") String stateNin, @retrofit2.http.Query("updated_at__eq") String updatedAtEq, @retrofit2.http.Query("updated_at__neq") String updatedAtNeq, @retrofit2.http.Query("updated_at__in") String updatedAtIn, @retrofit2.http.Query("updated_at__nin") String updatedAtNin, @retrofit2.http.Query("updated_at__lte") String updatedAtLte, @retrofit2.http.Query("updated_at__gte") String updatedAtGte, @retrofit2.http.Query("when__eq") String whenEq, @retrofit2.http.Query("when__neq") String whenNeq, @retrofit2.http.Query("when__in") String whenIn, @retrofit2.http.Query("when__nin") String whenNin, @retrofit2.http.Query("when__lte") String whenLte, @retrofit2.http.Query("when__gte") String whenGte, @retrofit2.http.Query("include") String include
  );

  /**
   * List all campaign device metadata
   * Get campaign device metadata.
   * @param campaignId The update campaign ID (required)
   * @param limit How many objects to retrieve in the page (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page (optional)
   * @param include A comma-separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;CampaignDeviceMetadataPage&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/")
  Call<CampaignDeviceMetadataPage> updateCampaignMetadataList(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include
  );

  /**
   * Get a campaign device metadata
   * Get update campaign metadata.
   * @param campaignId The update campaign ID (required)
   * @param campaignDeviceMetadataId The campaign device metadata ID (required)
   * @return Call&lt;CampaignDeviceMetadata&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/")
  Call<CampaignDeviceMetadata> updateCampaignMetadataRetrieve(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Path(value = "campaign_device_metadata_id", encoded = true) String campaignDeviceMetadataId
  );

  /**
   * Get campaign metrics
   * Get detailed statistics of a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;CampaignMetrics&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/metrics")
  Call<CampaignMetrics> updateCampaignMetrics(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Get a campaign.
   * Get an update campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @GET("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignRetrieve(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Start a campaign.
   * This command will begin the process of starting a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/update-campaigns/{campaign_id}/start")
  Call<Void> updateCampaignStart(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Stop a campaign.
   * This command will begin the process of stopping a campaign.
   * @param campaignId The campaign ID (required)
   * @return Call&lt;Void&gt;
   */
  @POST("v3/update-campaigns/{campaign_id}/stop")
  Call<Void> updateCampaignStop(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId
  );

  /**
   * Modify a campaign
   * Modify an update campaign.
   * @param campaignId  (required)
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  @PUT("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignUpdate(
    @retrofit2.http.Path(value = "campaign_id", encoded = true) String campaignId, @retrofit2.http.Body UpdateCampaignPutRequest campaign
  );

}
