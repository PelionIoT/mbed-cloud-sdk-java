package com.arm.mbed.cloud.sdk.internal.updateservice.api;

import com.arm.mbed.cloud.sdk.internal.updateservice.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import java.io.File;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPatchRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface DefaultApi {
  /**
   * 
   * Create firmware image.
   * @param datafile The firmware image file to upload. (required)
   * @param name The name of the object. (required)
   * @param description The description of the object. (optional)
   * @return Call&lt;FirmwareImage&gt;
   */
  
  @retrofit2.http.Multipart
  @POST("v3/firmware-images/")
  Call<FirmwareImage> firmwareImageCreate(
    @retrofit2.http.Part("datafile\"; filename=\"datafile") RequestBody datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description
  );

  /**
   * 
   * Delete firmware image.
   * @param imageId The ID of the firmware image. (required)
   * @return Call&lt;Void&gt;
   */
  
  @DELETE("v3/firmware-images/{image_id}/")
  Call<Void> firmwareImageDestroy(
    @retrofit2.http.Path("image_id") String imageId
  );

  /**
   * 
   * List all firmware images
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page. (optional)
   * @param filter URL encoded query string parameter to filter returned data. The result will be paged into pages of 50.  ##### Filtering &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; The examples below show the queries in *unencoded* form.  ###### By firmware image properties (all properties are filterable): For example: &#x60;&#x60;&#x60;name&#x3D;{value}&#x60;&#x60;&#x60; ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter.  &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example &#x60;&#x60;&#x60;name&#x3D;MyName&amp;bootstrapped&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;  Encoded: &#x60;&#x60;&#x60;?filter&#x3D;name%3DMyName%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60; (optional)
   * @param include Comma separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;FirmwareImagePage&gt;
   */
  
  @GET("v3/firmware-images/")
  Call<FirmwareImagePage> firmwareImageList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * 
   * Retrieve firmware image.
   * @param imageId The ID of the firmware image. (required)
   * @return Call&lt;FirmwareImage&gt;
   */
  
  @GET("v3/firmware-images/{image_id}/")
  Call<FirmwareImage> firmwareImageRetrieve(
    @retrofit2.http.Path("image_id") String imageId
  );

  /**
   * 
   * Create firmware manifest.
   * @param datafile The manifest file to create. The size of the file is account specific and enforced by the api gateway. (required)
   * @param name The name of the object. (required)
   * @param description The description of the object. (optional)
   * @return Call&lt;FirmwareManifest&gt;
   */
  
  @retrofit2.http.Multipart
  @POST("v3/firmware-manifests/")
  Call<FirmwareManifest> firmwareManifestCreate(
    @retrofit2.http.Part("datafile\"; filename=\"datafile") RequestBody datafile, @retrofit2.http.Part("name") String name, @retrofit2.http.Part("description") String description
  );

  /**
   * 
   * Delete firmware manifest.
   * @param manifestId The ID of the firmware manifest. (required)
   * @return Call&lt;Void&gt;
   */
  
  @DELETE("v3/firmware-manifests/{manifest_id}/")
  Call<Void> firmwareManifestDestroy(
    @retrofit2.http.Path("manifest_id") String manifestId
  );

  /**
   * 
   * List all firmware manifests.
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page. (optional)
   * @param filter URL-encoded query string parameter to filter returned data.  ##### Filtering &#x60;&#x60;&#x60;?filter&#x3D;{URL-encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; The examples below show the queries in *unencoded* form.  ##### By manifest ID: &#x60;&#x60;&#x60;manifest_id&#x3D;{id}&#x60;&#x60;&#x60;  ##### By firmware manifest properties (all properties are filterable):  &#x60;&#x60;&#x60;device_class&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter.  &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example &#x60;&#x60;&#x60;device_class&#x3D;1234&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;  Encoded: &#x60;&#x60;&#x60;?filter&#x3D;device_class%3D1234%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60; (optional)
   * @param include Comma separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;FirmwareManifestPage&gt;
   */
  
  @GET("v3/firmware-manifests/")
  Call<FirmwareManifestPage> firmwareManifestList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * 
   * Retrieve firmware manifest.
   * @param manifestId The ID of the firmware manifest. (required)
   * @return Call&lt;FirmwareManifest&gt;
   */
  
  @GET("v3/firmware-manifests/{manifest_id}/")
  Call<FirmwareManifest> firmwareManifestRetrieve(
    @retrofit2.http.Path("manifest_id") String manifestId
  );

  /**
   * 
   * &lt;p&gt;The APIs for creating and manipulating update campaigns. Update campaigns are used to control firmware update to a list of devices specified by a filter.  &lt;/p&gt; &lt;p&gt;Create update campaign&lt;/p&gt;
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  
  @POST("v3/update-campaigns/")
  Call<UpdateCampaign> updateCampaignCreate(
    @retrofit2.http.Body UpdateCampaignPostRequest campaign
  );

  /**
   * 
   * &lt;p&gt;The APIs for creating and manipulating update campaigns. Update campaigns are used to control firmware update to a list of devices specified by a filter.  &lt;/p&gt; &lt;p&gt;Delete update campaign&lt;/p&gt;
   * @param campaignId The ID of the update campaign (required)
   * @return Call&lt;Void&gt;
   */
  
  @DELETE("v3/update-campaigns/{campaign_id}/")
  Call<Void> updateCampaignDestroy(
    @retrofit2.http.Path("campaign_id") String campaignId
  );

  /**
   * 
   * The APIs for creating and manipulating update campaigns.
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order ASC or DESC (optional)
   * @param after The ID of the the item after which to retrieve the next page. (optional)
   * @param filter URL encoded query string parameter to filter returned data.  ##### Filtering &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60; The examples below show the queries in *unencoded* form.  ###### By campaign properties (all properties are filterable): For example: &#x60;&#x60;&#x60;state&#x3D;[draft|scheduled|devicefectch|devicecopy|publishing|deploying|deployed|manifestremoved|expired]&#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;root_manifest_id&#x3D;43217771234242e594ddb433816c498a&#x60;&#x60;&#x60;  ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter.  &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example &#x60;&#x60;&#x60;state&#x3D;deployed&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60; Encoded: &#x60;&#x60;&#x60;?filter&#x3D;state%3Ddeployed%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60; (optional)
   * @param include Comma separated list of data fields to return. Currently supported: total_count (optional)
   * @return Call&lt;UpdateCampaignPage&gt;
   */
  
  @GET("v3/update-campaigns/")
  Call<UpdateCampaignPage> updateCampaignList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * 
   * &lt;p&gt;The APIs for creating and manipulating update campaigns. Update campaigns are used to control firmware update to a list of devices specified by a filter.  &lt;/p&gt; &lt;p&gt;Update campaign fields&lt;/p&gt;
   * @param campaignId  (required)
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  
  @PATCH("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignPartialUpdate(
    @retrofit2.http.Path("campaign_id") String campaignId, @retrofit2.http.Body UpdateCampaignPatchRequest campaign
  );

  /**
   * 
   * &lt;p&gt;The APIs for creating and manipulating update campaigns. Update campaigns are used to control firmware update to a list of devices specified by a filter.  &lt;/p&gt; &lt;p&gt;Retrieve campaign&lt;/p&gt;
   * @param campaignId The ID of the campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  
  @GET("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignRetrieve(
    @retrofit2.http.Path("campaign_id") String campaignId
  );

  /**
   * 
   * &lt;p&gt;The APIs for creating and manipulating update campaigns. Update campaigns are used to control firmware update to a list of devices specified by a filter.  &lt;/p&gt; &lt;p&gt;Update campaign&lt;/p&gt;
   * @param campaignId  (required)
   * @param campaign Update campaign (required)
   * @return Call&lt;UpdateCampaign&gt;
   */
  
  @PUT("v3/update-campaigns/{campaign_id}/")
  Call<UpdateCampaign> updateCampaignUpdate(
    @retrofit2.http.Path("campaign_id") String campaignId, @retrofit2.http.Body UpdateCampaignPutRequest campaign
  );

  /**
   * 
   * 
   * @param campaignDeviceMetadataId The id of the campaign device metadata (required)
   * @return Call&lt;CampaignDeviceMetadata&gt;
   */
  
  @GET("v3/campaign-device-metadata/{campaign_device_metadata_id}")
  Call<CampaignDeviceMetadata> v3CampaignDeviceMetadataCampaignDeviceMetadataIdGet(
    @retrofit2.http.Path("campaign_device_metadata_id") String campaignDeviceMetadataId
  );

  /**
   * 
   * 
   * @return Call&lt;CampaignDeviceMetadataPage&gt;
   */
  
  @GET("v3/campaign-device-metadata")
  Call<CampaignDeviceMetadataPage> v3CampaignDeviceMetadataGet();
    

}
