package com.arm.mbed.cloud.sdk.internal.devicedirectory.api;

import com.arm.mbed.cloud.sdk.internal.devicedirectory.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DevicePage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPostPutRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  /**
   * Create a device
   * Create a new device.
   * @param device  (required)
   * @return Call&lt;DeviceData&gt;
   */
  @POST("v3/devices/")
  Call<DeviceData> deviceCreate(
    @retrofit2.http.Body DeviceDataPostRequest device
  );

  /**
   * Delete a device.
   * Delete device. Only available for devices with a developer certificate. Attempts to delete a device with a production certicate will return a 400 response.
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/devices/{id}/")
  Call<Void> deviceDestroy(
    @retrofit2.http.Path(value = "id", encoded = true) String id
  );

  /**
   * List all device events.
   * List all device events for an account.
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. (optional)
   * @param after The ID of The item after which to retrieve the next page. (optional)
   * @param filter URL encoded query string parameter to filter returned data.  ##### Filtering &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;date_time&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;event_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state_change&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By id: &#x60;&#x60;&#x60;id&#x3D;{id}&#x60;&#x60;&#x60;  ###### By state change: &#x60;&#x60;&#x60;state_change&#x3D;[True|False]&#x60;&#x60;&#x60;  ###### By event type: &#x60;&#x60;&#x60;event_type&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter.  &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example  &#x60;&#x60;&#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60; (optional)
   * @return Call&lt;DeviceEventPage&gt;
   */
  @GET("v3/device-events/")
  Call<DeviceEventPage> deviceEventList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * Retrieve a device event.
   * Retrieve a specific device event.
   * @param deviceEventId  (required)
   * @return Call&lt;DeviceEventData&gt;
   */
  @GET("v3/device-events/{device_event_id}/")
  Call<DeviceEventData> deviceEventRetrieve(
    @retrofit2.http.Path(value = "device_event_id", encoded = true) String deviceEventId
  );

  /**
   * List all devices.
   * List all devices.
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. (optional)
   * @param after The ID of The item after which to retrieve the next page. (optional)
   * @param filter URL encoded query string parameter to filter returned data.  ##### Filtering &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;account_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;auto_update&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;bootstrap_expiration_date&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;bootstrapped_timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;ca_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;connector_expiration_date&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;custom_attributes&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;deployed_state&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;deployment&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_class&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_execution_mode&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_key&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;endpoint_name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;endpoint_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;enrolment_list_timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;firmware_checksum&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;host_gateway&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;manifest&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;manifest_timestamp&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;mechanism&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;mechanism_url&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;serial_number&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;vendor_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By device properties (all properties are filterable): &#x60;&#x60;&#x60;state&#x3D;[unenrolled|cloud_enrolling|bootstrapped|registered]&#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;device_class&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter.  &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ###### On device custom attributes:  &#x60;&#x60;&#x60;custom_attributes__{param}&#x3D;{value}&#x60;&#x60;&#x60; &#x60;&#x60;&#x60;custom_attributes__tag&#x3D;TAG1&#x60;&#x60;&#x60;  ##### Multi-field example  &#x60;&#x60;&#x60;state&#x3D;bootstrapped&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;?filter&#x3D;state%3Dbootstrapped%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;state__nin&#x3D;unenrolled,dergistered&#x60; (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. (optional)
   * @return Call&lt;DevicePage&gt;
   */
  @GET("v3/devices/")
  Call<DevicePage> deviceList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * DEPRECATED: List all device events.
   * DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60; instead.
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. (optional)
   * @param after The ID of The item after which to retrieve the next page. (optional)
   * @param filter URL encoded query string parameter to filter returned data.  ##### Filtering &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  ###### Filterable fields:  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;date_time&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;description&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;device_id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;event_type&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;state_change&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By id: &#x60;&#x60;&#x60;id&#x3D;{id}&#x60;&#x60;&#x60;  ###### By state change: &#x60;&#x60;&#x60;state_change&#x3D;[True|False]&#x60;&#x60;&#x60;  ###### By event type: &#x60;&#x60;&#x60;event_type&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter.  &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example  &#x60;&#x60;&#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. (optional)
   * @return Call&lt;DeviceEventPage&gt;
   */
  @GET("v3/devicelog/")
  Call<DeviceEventPage> deviceLogList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * DEPRECATED: Retrieve a device event.
   * Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/ instead)
   * @param deviceEventId  (required)
   * @return Call&lt;DeviceEventData&gt;
   */
  @GET("v3/devicelog/{device_event_id}/")
  Call<DeviceEventData> deviceLogRetrieve(
    @retrofit2.http.Path(value = "device_event_id", encoded = true) String deviceEventId
  );

  /**
   * Create a device query
   * Create a new device query.
   * @param device  (required)
   * @return Call&lt;DeviceQuery&gt;
   */
  @POST("v3/device-queries/")
  Call<DeviceQuery> deviceQueryCreate(
    @retrofit2.http.Body DeviceQueryPostPutRequest device
  );

  /**
   * Delete a device query
   * Delete a device query.
   * @param queryId  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("v3/device-queries/{query_id}/")
  Call<Void> deviceQueryDestroy(
    @retrofit2.http.Path(value = "query_id", encoded = true) String queryId
  );

  /**
   * List device queries.
   * List all device queries. The result will be paged into pages of 100.
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. (optional)
   * @param after The ID of The item after which to retrieve the next page. (optional)
   * @param filter URL encoded query string parameter to filter returned data.  ##### Filtering &#x60;&#x60;&#x60;?filter&#x3D;{URL encoded query string}&#x60;&#x60;&#x60;  The query string is made up of key/value pairs separated by ampersands. So for a query of &#x60;&#x60;&#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;&#x60;&#x60; this would be encoded as follows: &#x60;&#x60;&#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;&#x60;&#x60;  The below table lists all the fields that can be filtered on with certain filters:  &lt;table&gt;   &lt;thead&gt;     &lt;tr&gt;       &lt;th&gt;Field&lt;/th&gt;       &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt;       &lt;th&gt;__in /  __nin&lt;/th&gt;       &lt;th&gt;__lte / __gte&lt;/th&gt;     &lt;tr&gt;   &lt;thead&gt;   &lt;tbody&gt;     &lt;tr&gt;       &lt;td&gt;created_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;etag&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;id&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;name&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;query&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;&amp;nbsp;&lt;/td&gt;     &lt;/tr&gt;     &lt;tr&gt;       &lt;td&gt;updated_at&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;       &lt;td&gt;✓&lt;/td&gt;     &lt;/tr&gt;   &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp;  The examples below show the queries in *unencoded* form.  ###### By device query properties (all properties are filterable): For example: &#x60;&#x60;&#x60;description&#x3D;{value}&#x60;&#x60;&#x60;  ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format &#x60;&#x60;&#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;&#x60;&#x60;. There are three permitted variations:  * UTC RFC3339 with milliseconds e.g. 2016-11-30T16:25:12.1234Z * UTC RFC3339 without milliseconds e.g. 2016-11-30T16:25:12Z * UTC RFC3339 shortened - without milliseconds and punctuation e.g. 20161130T162512Z  Date-time filtering supports three operators:  * equality * greater than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; * less than or equal to &amp;ndash; field name suffixed with &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60;  Lower and upper limits to a date-time range may be specified by including both the &#x60;&#x60;&#x60;__gte&#x60;&#x60;&#x60; and &#x60;&#x60;&#x60;__lte&#x60;&#x60;&#x60; forms in the filter.  &#x60;&#x60;&#x60;{field name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;&#x60;&#x60;  ##### Multi-field example  &#x60;&#x60;&#x60;query_id&#x3D;0158d38771f70000000000010010038c&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;&#x60;&#x60;  Encoded:  &#x60;&#x60;&#x60;filter&#x3D;query_id%3D0158d38771f70000000000010010038c%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;&#x60;&#x60;  ##### Filtering with filter operators  String field filtering supports the following operators:  * equality: &#x60;__eq&#x60; * non-equality: &#x60;__neq&#x60; * in : &#x60;__in&#x60; * not in: &#x60;__nin&#x60;  For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be comma-separated:  &#x60;name__nin&#x3D;query1,query2&#x60; (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. (optional)
   * @return Call&lt;DeviceQueryPage&gt;
   */
  @GET("v3/device-queries/")
  Call<DeviceQueryPage> deviceQueryList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("include") String include
  );

  /**
   * Retrieve a device query.
   * Retrieve a specific device query.
   * @param queryId  (required)
   * @return Call&lt;DeviceQuery&gt;
   */
  @GET("v3/device-queries/{query_id}/")
  Call<DeviceQuery> deviceQueryRetrieve(
    @retrofit2.http.Path(value = "query_id", encoded = true) String queryId
  );

  /**
   * Update a device query
   * Update a specifc device query.
   * @param queryId  (required)
   * @param body Device query update object. (required)
   * @return Call&lt;DeviceQuery&gt;
   */
  @PUT("v3/device-queries/{query_id}/")
  Call<DeviceQuery> deviceQueryUpdate(
    @retrofit2.http.Path(value = "query_id", encoded = true) String queryId, @retrofit2.http.Body DeviceQueryPostPutRequest body
  );

  /**
   * Get a devices
   * Retrieve information about a specific device.
   * @param id  (required)
   * @return Call&lt;DeviceData&gt;
   */
  @GET("v3/devices/{id}/")
  Call<DeviceData> deviceRetrieve(
    @retrofit2.http.Path(value = "id", encoded = true) String id
  );

  /**
   * Update a device
   * Update a specific device.
   * @param id The ID of the device. (required)
   * @param device  (required)
   * @return Call&lt;DeviceData&gt;
   */
  @PUT("v3/devices/{id}/")
  Call<DeviceData> deviceUpdate(
    @retrofit2.http.Path(value = "id", encoded = true) String id, @retrofit2.http.Body DeviceDataPutRequest device
  );

}
