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
   * @param dateTimeEq Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeNeq Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeIn Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeNin Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeLte Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeGte Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param descriptionEq Filter for description (optional)
   * @param descriptionNeq Filter for description (optional)
   * @param descriptionIn Filter for description (optional)
   * @param descriptionNin Filter for description (optional)
   * @param idEq Filter for id (optional)
   * @param idNeq Filter for id (optional)
   * @param idIn Filter for id (optional)
   * @param idNin Filter for id (optional)
   * @param deviceIdEq Filter for device_id (optional)
   * @param deviceIdNeq Filter for device_id (optional)
   * @param deviceIdIn Filter for device_id (optional)
   * @param deviceIdNin Filter for device_id (optional)
   * @param eventTypeEq Filter for event_type (optional)
   * @param eventTypeNeq Filter for event_type (optional)
   * @param eventTypeIn Filter for event_type (optional)
   * @param eventTypeNin Filter for event_type (optional)
   * @param stateChangeEq Filter for state_change (optional)
   * @param stateChangeNeq Filter for state_change (optional)
   * @param stateChangeIn Filter for state_change (optional)
   * @param stateChangeNin Filter for state_change (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60; (optional)
   * @return Call&lt;DeviceEventPage&gt;
   */
  @GET("v3/device-events/")
  Call<DeviceEventPage> deviceEventList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("date_time__eq") String dateTimeEq, @retrofit2.http.Query("date_time__neq") String dateTimeNeq, @retrofit2.http.Query("date_time__in") String dateTimeIn, @retrofit2.http.Query("date_time__nin") String dateTimeNin, @retrofit2.http.Query("date_time__lte") String dateTimeLte, @retrofit2.http.Query("date_time__gte") String dateTimeGte, @retrofit2.http.Query("description__eq") String descriptionEq, @retrofit2.http.Query("description__neq") String descriptionNeq, @retrofit2.http.Query("description__in") String descriptionIn, @retrofit2.http.Query("description__nin") String descriptionNin, @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin, @retrofit2.http.Query("device_id__eq") String deviceIdEq, @retrofit2.http.Query("device_id__neq") String deviceIdNeq, @retrofit2.http.Query("device_id__in") String deviceIdIn, @retrofit2.http.Query("device_id__nin") String deviceIdNin, @retrofit2.http.Query("event_type__eq") String eventTypeEq, @retrofit2.http.Query("event_type__neq") String eventTypeNeq, @retrofit2.http.Query("event_type__in") String eventTypeIn, @retrofit2.http.Query("event_type__nin") String eventTypeNin, @retrofit2.http.Query("state_change__eq") String stateChangeEq, @retrofit2.http.Query("state_change__neq") String stateChangeNeq, @retrofit2.http.Query("state_change__in") String stateChangeIn, @retrofit2.http.Query("state_change__nin") String stateChangeNin, @retrofit2.http.Query("include") String include
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
   * @param accountIdEq Filter for account_id (optional)
   * @param accountIdNeq Filter for account_id (optional)
   * @param accountIdIn Filter for account_id (optional)
   * @param accountIdNin Filter for account_id (optional)
   * @param autoUpdateEq Filter for auto_update (optional)
   * @param autoUpdateNeq Filter for auto_update (optional)
   * @param autoUpdateIn Filter for auto_update (optional)
   * @param autoUpdateNin Filter for auto_update (optional)
   * @param bootstrapExpirationDateEq Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrapExpirationDateNeq Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrapExpirationDateIn Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrapExpirationDateNin Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrapExpirationDateLte Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrapExpirationDateGte Filter for bootstrap_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrappedTimestampEq Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrappedTimestampNeq Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrappedTimestampIn Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrappedTimestampNin Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrappedTimestampLte Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param bootstrappedTimestampGte Filter for bootstrapped_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param caIdEq Filter for ca_id (optional)
   * @param caIdNeq Filter for ca_id (optional)
   * @param caIdIn Filter for ca_id (optional)
   * @param caIdNin Filter for ca_id (optional)
   * @param connectorExpirationDateEq Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param connectorExpirationDateNeq Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param connectorExpirationDateIn Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param connectorExpirationDateNin Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param connectorExpirationDateLte Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param connectorExpirationDateGte Filter for connector_expiration_date. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtEq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNeq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtIn Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNin Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtLte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtGte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param customAttributesEq Filter for custom_attributes (optional)
   * @param customAttributesNeq Filter for custom_attributes (optional)
   * @param customAttributesIn Filter for custom_attributes (optional)
   * @param customAttributesNin Filter for custom_attributes (optional)
   * @param deployedStateEq Filter for deployed_state (optional)
   * @param deployedStateNeq Filter for deployed_state (optional)
   * @param deployedStateIn Filter for deployed_state (optional)
   * @param deployedStateNin Filter for deployed_state (optional)
   * @param deploymentEq Filter for deployment (optional)
   * @param deploymentNeq Filter for deployment (optional)
   * @param deploymentIn Filter for deployment (optional)
   * @param deploymentNin Filter for deployment (optional)
   * @param descriptionEq Filter for description (optional)
   * @param descriptionNeq Filter for description (optional)
   * @param descriptionIn Filter for description (optional)
   * @param descriptionNin Filter for description (optional)
   * @param deviceClassEq Filter for device_class (optional)
   * @param deviceClassNeq Filter for device_class (optional)
   * @param deviceClassIn Filter for device_class (optional)
   * @param deviceClassNin Filter for device_class (optional)
   * @param deviceExecutionModeEq Filter for device_execution_mode (optional)
   * @param deviceExecutionModeNeq Filter for device_execution_mode (optional)
   * @param deviceExecutionModeIn Filter for device_execution_mode (optional)
   * @param deviceExecutionModeNin Filter for device_execution_mode (optional)
   * @param deviceKeyEq Filter for device_key (optional)
   * @param deviceKeyNeq Filter for device_key (optional)
   * @param deviceKeyIn Filter for device_key (optional)
   * @param deviceKeyNin Filter for device_key (optional)
   * @param endpointNameEq Filter for endpoint_name (optional)
   * @param endpointNameNeq Filter for endpoint_name (optional)
   * @param endpointNameIn Filter for endpoint_name (optional)
   * @param endpointNameNin Filter for endpoint_name (optional)
   * @param endpointTypeEq Filter for endpoint_type (optional)
   * @param endpointTypeNeq Filter for endpoint_type (optional)
   * @param endpointTypeIn Filter for endpoint_type (optional)
   * @param endpointTypeNin Filter for endpoint_type (optional)
   * @param enrolmentListTimestampEq Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param enrolmentListTimestampNeq Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param enrolmentListTimestampIn Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param enrolmentListTimestampNin Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param enrolmentListTimestampLte Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param enrolmentListTimestampGte Filter for enrolment_list_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param etagEq Filter for etag (optional)
   * @param etagNeq Filter for etag (optional)
   * @param etagIn Filter for etag (optional)
   * @param etagNin Filter for etag (optional)
   * @param etagLte Filter for etag (optional)
   * @param etagGte Filter for etag (optional)
   * @param firmwareChecksumEq Filter for firmware_checksum (optional)
   * @param firmwareChecksumNeq Filter for firmware_checksum (optional)
   * @param firmwareChecksumIn Filter for firmware_checksum (optional)
   * @param firmwareChecksumNin Filter for firmware_checksum (optional)
   * @param hostGatewayEq Filter for host_gateway (optional)
   * @param hostGatewayNeq Filter for host_gateway (optional)
   * @param hostGatewayIn Filter for host_gateway (optional)
   * @param hostGatewayNin Filter for host_gateway (optional)
   * @param idEq Filter for id (optional)
   * @param idNeq Filter for id (optional)
   * @param idIn Filter for id (optional)
   * @param idNin Filter for id (optional)
   * @param manifestEq Filter for manifest (optional)
   * @param manifestNeq Filter for manifest (optional)
   * @param manifestIn Filter for manifest (optional)
   * @param manifestNin Filter for manifest (optional)
   * @param manifestTimestampEq Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param manifestTimestampNeq Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param manifestTimestampIn Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param manifestTimestampNin Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param manifestTimestampLte Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param manifestTimestampGte Filter for manifest_timestamp. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param mechanismEq Filter for mechanism (optional)
   * @param mechanismNeq Filter for mechanism (optional)
   * @param mechanismIn Filter for mechanism (optional)
   * @param mechanismNin Filter for mechanism (optional)
   * @param mechanismUrlEq Filter for mechanism_url (optional)
   * @param mechanismUrlNeq Filter for mechanism_url (optional)
   * @param mechanismUrlIn Filter for mechanism_url (optional)
   * @param mechanismUrlNin Filter for mechanism_url (optional)
   * @param nameEq Filter for name (optional)
   * @param nameNeq Filter for name (optional)
   * @param nameIn Filter for name (optional)
   * @param nameNin Filter for name (optional)
   * @param serialNumberEq Filter for serial_number (optional)
   * @param serialNumberNeq Filter for serial_number (optional)
   * @param serialNumberIn Filter for serial_number (optional)
   * @param serialNumberNin Filter for serial_number (optional)
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
   * @param vendorIdEq Filter for vendor_id (optional)
   * @param vendorIdNeq Filter for vendor_id (optional)
   * @param vendorIdIn Filter for vendor_id (optional)
   * @param vendorIdNin Filter for vendor_id (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. (optional)
   * @return Call&lt;DevicePage&gt;
   */
  @GET("v3/devices/")
  Call<DevicePage> deviceList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("account_id__eq") String accountIdEq, @retrofit2.http.Query("account_id__neq") String accountIdNeq, @retrofit2.http.Query("account_id__in") String accountIdIn, @retrofit2.http.Query("account_id__nin") String accountIdNin, @retrofit2.http.Query("auto_update__eq") String autoUpdateEq, @retrofit2.http.Query("auto_update__neq") String autoUpdateNeq, @retrofit2.http.Query("auto_update__in") String autoUpdateIn, @retrofit2.http.Query("auto_update__nin") String autoUpdateNin, @retrofit2.http.Query("bootstrap_expiration_date__eq") String bootstrapExpirationDateEq, @retrofit2.http.Query("bootstrap_expiration_date__neq") String bootstrapExpirationDateNeq, @retrofit2.http.Query("bootstrap_expiration_date__in") String bootstrapExpirationDateIn, @retrofit2.http.Query("bootstrap_expiration_date__nin") String bootstrapExpirationDateNin, @retrofit2.http.Query("bootstrap_expiration_date__lte") String bootstrapExpirationDateLte, @retrofit2.http.Query("bootstrap_expiration_date__gte") String bootstrapExpirationDateGte, @retrofit2.http.Query("bootstrapped_timestamp__eq") String bootstrappedTimestampEq, @retrofit2.http.Query("bootstrapped_timestamp__neq") String bootstrappedTimestampNeq, @retrofit2.http.Query("bootstrapped_timestamp__in") String bootstrappedTimestampIn, @retrofit2.http.Query("bootstrapped_timestamp__nin") String bootstrappedTimestampNin, @retrofit2.http.Query("bootstrapped_timestamp__lte") String bootstrappedTimestampLte, @retrofit2.http.Query("bootstrapped_timestamp__gte") String bootstrappedTimestampGte, @retrofit2.http.Query("ca_id__eq") String caIdEq, @retrofit2.http.Query("ca_id__neq") String caIdNeq, @retrofit2.http.Query("ca_id__in") String caIdIn, @retrofit2.http.Query("ca_id__nin") String caIdNin, @retrofit2.http.Query("connector_expiration_date__eq") String connectorExpirationDateEq, @retrofit2.http.Query("connector_expiration_date__neq") String connectorExpirationDateNeq, @retrofit2.http.Query("connector_expiration_date__in") String connectorExpirationDateIn, @retrofit2.http.Query("connector_expiration_date__nin") String connectorExpirationDateNin, @retrofit2.http.Query("connector_expiration_date__lte") String connectorExpirationDateLte, @retrofit2.http.Query("connector_expiration_date__gte") String connectorExpirationDateGte, @retrofit2.http.Query("created_at__eq") String createdAtEq, @retrofit2.http.Query("created_at__neq") String createdAtNeq, @retrofit2.http.Query("created_at__in") String createdAtIn, @retrofit2.http.Query("created_at__nin") String createdAtNin, @retrofit2.http.Query("created_at__lte") String createdAtLte, @retrofit2.http.Query("created_at__gte") String createdAtGte, @retrofit2.http.Query("custom_attributes__eq") String customAttributesEq, @retrofit2.http.Query("custom_attributes__neq") String customAttributesNeq, @retrofit2.http.Query("custom_attributes__in") String customAttributesIn, @retrofit2.http.Query("custom_attributes__nin") String customAttributesNin, @retrofit2.http.Query("deployed_state__eq") String deployedStateEq, @retrofit2.http.Query("deployed_state__neq") String deployedStateNeq, @retrofit2.http.Query("deployed_state__in") String deployedStateIn, @retrofit2.http.Query("deployed_state__nin") String deployedStateNin, @retrofit2.http.Query("deployment__eq") String deploymentEq, @retrofit2.http.Query("deployment__neq") String deploymentNeq, @retrofit2.http.Query("deployment__in") String deploymentIn, @retrofit2.http.Query("deployment__nin") String deploymentNin, @retrofit2.http.Query("description__eq") String descriptionEq, @retrofit2.http.Query("description__neq") String descriptionNeq, @retrofit2.http.Query("description__in") String descriptionIn, @retrofit2.http.Query("description__nin") String descriptionNin, @retrofit2.http.Query("device_class__eq") String deviceClassEq, @retrofit2.http.Query("device_class__neq") String deviceClassNeq, @retrofit2.http.Query("device_class__in") String deviceClassIn, @retrofit2.http.Query("device_class__nin") String deviceClassNin, @retrofit2.http.Query("device_execution_mode__eq") String deviceExecutionModeEq, @retrofit2.http.Query("device_execution_mode__neq") String deviceExecutionModeNeq, @retrofit2.http.Query("device_execution_mode__in") String deviceExecutionModeIn, @retrofit2.http.Query("device_execution_mode__nin") String deviceExecutionModeNin, @retrofit2.http.Query("device_key__eq") String deviceKeyEq, @retrofit2.http.Query("device_key__neq") String deviceKeyNeq, @retrofit2.http.Query("device_key__in") String deviceKeyIn, @retrofit2.http.Query("device_key__nin") String deviceKeyNin, @retrofit2.http.Query("endpoint_name__eq") String endpointNameEq, @retrofit2.http.Query("endpoint_name__neq") String endpointNameNeq, @retrofit2.http.Query("endpoint_name__in") String endpointNameIn, @retrofit2.http.Query("endpoint_name__nin") String endpointNameNin, @retrofit2.http.Query("endpoint_type__eq") String endpointTypeEq, @retrofit2.http.Query("endpoint_type__neq") String endpointTypeNeq, @retrofit2.http.Query("endpoint_type__in") String endpointTypeIn, @retrofit2.http.Query("endpoint_type__nin") String endpointTypeNin, @retrofit2.http.Query("enrolment_list_timestamp__eq") String enrolmentListTimestampEq, @retrofit2.http.Query("enrolment_list_timestamp__neq") String enrolmentListTimestampNeq, @retrofit2.http.Query("enrolment_list_timestamp__in") String enrolmentListTimestampIn, @retrofit2.http.Query("enrolment_list_timestamp__nin") String enrolmentListTimestampNin, @retrofit2.http.Query("enrolment_list_timestamp__lte") String enrolmentListTimestampLte, @retrofit2.http.Query("enrolment_list_timestamp__gte") String enrolmentListTimestampGte, @retrofit2.http.Query("etag__eq") String etagEq, @retrofit2.http.Query("etag__neq") String etagNeq, @retrofit2.http.Query("etag__in") String etagIn, @retrofit2.http.Query("etag__nin") String etagNin, @retrofit2.http.Query("etag__lte") String etagLte, @retrofit2.http.Query("etag__gte") String etagGte, @retrofit2.http.Query("firmware_checksum__eq") String firmwareChecksumEq, @retrofit2.http.Query("firmware_checksum__neq") String firmwareChecksumNeq, @retrofit2.http.Query("firmware_checksum__in") String firmwareChecksumIn, @retrofit2.http.Query("firmware_checksum__nin") String firmwareChecksumNin, @retrofit2.http.Query("host_gateway__eq") String hostGatewayEq, @retrofit2.http.Query("host_gateway__neq") String hostGatewayNeq, @retrofit2.http.Query("host_gateway__in") String hostGatewayIn, @retrofit2.http.Query("host_gateway__nin") String hostGatewayNin, @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin, @retrofit2.http.Query("manifest__eq") String manifestEq, @retrofit2.http.Query("manifest__neq") String manifestNeq, @retrofit2.http.Query("manifest__in") String manifestIn, @retrofit2.http.Query("manifest__nin") String manifestNin, @retrofit2.http.Query("manifest_timestamp__eq") String manifestTimestampEq, @retrofit2.http.Query("manifest_timestamp__neq") String manifestTimestampNeq, @retrofit2.http.Query("manifest_timestamp__in") String manifestTimestampIn, @retrofit2.http.Query("manifest_timestamp__nin") String manifestTimestampNin, @retrofit2.http.Query("manifest_timestamp__lte") String manifestTimestampLte, @retrofit2.http.Query("manifest_timestamp__gte") String manifestTimestampGte, @retrofit2.http.Query("mechanism__eq") String mechanismEq, @retrofit2.http.Query("mechanism__neq") String mechanismNeq, @retrofit2.http.Query("mechanism__in") String mechanismIn, @retrofit2.http.Query("mechanism__nin") String mechanismNin, @retrofit2.http.Query("mechanism_url__eq") String mechanismUrlEq, @retrofit2.http.Query("mechanism_url__neq") String mechanismUrlNeq, @retrofit2.http.Query("mechanism_url__in") String mechanismUrlIn, @retrofit2.http.Query("mechanism_url__nin") String mechanismUrlNin, @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("name__neq") String nameNeq, @retrofit2.http.Query("name__in") String nameIn, @retrofit2.http.Query("name__nin") String nameNin, @retrofit2.http.Query("serial_number__eq") String serialNumberEq, @retrofit2.http.Query("serial_number__neq") String serialNumberNeq, @retrofit2.http.Query("serial_number__in") String serialNumberIn, @retrofit2.http.Query("serial_number__nin") String serialNumberNin, @retrofit2.http.Query("state__eq") String stateEq, @retrofit2.http.Query("state__neq") String stateNeq, @retrofit2.http.Query("state__in") String stateIn, @retrofit2.http.Query("state__nin") String stateNin, @retrofit2.http.Query("updated_at__eq") String updatedAtEq, @retrofit2.http.Query("updated_at__neq") String updatedAtNeq, @retrofit2.http.Query("updated_at__in") String updatedAtIn, @retrofit2.http.Query("updated_at__nin") String updatedAtNin, @retrofit2.http.Query("updated_at__lte") String updatedAtLte, @retrofit2.http.Query("updated_at__gte") String updatedAtGte, @retrofit2.http.Query("vendor_id__eq") String vendorIdEq, @retrofit2.http.Query("vendor_id__neq") String vendorIdNeq, @retrofit2.http.Query("vendor_id__in") String vendorIdIn, @retrofit2.http.Query("vendor_id__nin") String vendorIdNin, @retrofit2.http.Query("include") String include
  );

  /**
   * DEPRECATED: List all device events.
   * DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60; instead.
   * @param limit How many objects to retrieve in the page. (optional)
   * @param order The order of the records based on creation time, &#x60;ASC&#x60; or &#x60;DESC&#x60;; by default &#x60;ASC&#x60;. (optional)
   * @param after The ID of The item after which to retrieve the next page. (optional)
   * @param dateTimeEq Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeNeq Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeIn Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeNin Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeLte Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param dateTimeGte Filter for date_time. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param descriptionEq Filter for description (optional)
   * @param descriptionNeq Filter for description (optional)
   * @param descriptionIn Filter for description (optional)
   * @param descriptionNin Filter for description (optional)
   * @param idEq Filter for id (optional)
   * @param idNeq Filter for id (optional)
   * @param idIn Filter for id (optional)
   * @param idNin Filter for id (optional)
   * @param deviceIdEq Filter for device_id (optional)
   * @param deviceIdNeq Filter for device_id (optional)
   * @param deviceIdIn Filter for device_id (optional)
   * @param deviceIdNin Filter for device_id (optional)
   * @param eventTypeEq Filter for event_type (optional)
   * @param eventTypeNeq Filter for event_type (optional)
   * @param eventTypeIn Filter for event_type (optional)
   * @param eventTypeNin Filter for event_type (optional)
   * @param stateChangeEq Filter for state_change (optional)
   * @param stateChangeNeq Filter for state_change (optional)
   * @param stateChangeIn Filter for state_change (optional)
   * @param stateChangeNin Filter for state_change (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. (optional)
   * @return Call&lt;DeviceEventPage&gt;
   */
  @GET("v3/devicelog/")
  Call<DeviceEventPage> deviceLogList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("date_time__eq") String dateTimeEq, @retrofit2.http.Query("date_time__neq") String dateTimeNeq, @retrofit2.http.Query("date_time__in") String dateTimeIn, @retrofit2.http.Query("date_time__nin") String dateTimeNin, @retrofit2.http.Query("date_time__lte") String dateTimeLte, @retrofit2.http.Query("date_time__gte") String dateTimeGte, @retrofit2.http.Query("description__eq") String descriptionEq, @retrofit2.http.Query("description__neq") String descriptionNeq, @retrofit2.http.Query("description__in") String descriptionIn, @retrofit2.http.Query("description__nin") String descriptionNin, @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin, @retrofit2.http.Query("device_id__eq") String deviceIdEq, @retrofit2.http.Query("device_id__neq") String deviceIdNeq, @retrofit2.http.Query("device_id__in") String deviceIdIn, @retrofit2.http.Query("device_id__nin") String deviceIdNin, @retrofit2.http.Query("event_type__eq") String eventTypeEq, @retrofit2.http.Query("event_type__neq") String eventTypeNeq, @retrofit2.http.Query("event_type__in") String eventTypeIn, @retrofit2.http.Query("event_type__nin") String eventTypeNin, @retrofit2.http.Query("state_change__eq") String stateChangeEq, @retrofit2.http.Query("state_change__neq") String stateChangeNeq, @retrofit2.http.Query("state_change__in") String stateChangeIn, @retrofit2.http.Query("state_change__nin") String stateChangeNin, @retrofit2.http.Query("include") String include
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
   * @param createdAtEq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNeq Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtIn Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtNin Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtLte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param createdAtGte Filter for created_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
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
   * @param idLte Filter for id (optional)
   * @param idGte Filter for id (optional)
   * @param nameEq Filter for name (optional)
   * @param nameNeq Filter for name (optional)
   * @param nameIn Filter for name (optional)
   * @param nameNin Filter for name (optional)
   * @param nameLte Filter for name (optional)
   * @param nameGte Filter for name (optional)
   * @param queryEq Filter for query (optional)
   * @param queryNeq Filter for query (optional)
   * @param queryIn Filter for query (optional)
   * @param queryNin Filter for query (optional)
   * @param queryLte Filter for query (optional)
   * @param queryGte Filter for query (optional)
   * @param updatedAtEq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNeq Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtIn Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtNin Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtLte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param updatedAtGte Filter for updated_at. Date-time fields should be specified in UTC RFC3339 format, YYYY-MM-DDThh:mm:ss.msZ. There are three permitted variations:  UTC RFC3339 with milliseconds. Example: 2016-11-30T16:25:12.1234Z UTC RFC3339 without milliseconds. Example: 2016-11-30T16:25:12Z UTC RFC3339 shortened without milliseconds and punctuation. Example: 20161130T162512Z (optional)
   * @param include Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;. (optional)
   * @return Call&lt;DeviceQueryPage&gt;
   */
  @GET("v3/device-queries/")
  Call<DeviceQueryPage> deviceQueryList(
    @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("created_at__eq") String createdAtEq, @retrofit2.http.Query("created_at__neq") String createdAtNeq, @retrofit2.http.Query("created_at__in") String createdAtIn, @retrofit2.http.Query("created_at__nin") String createdAtNin, @retrofit2.http.Query("created_at__lte") String createdAtLte, @retrofit2.http.Query("created_at__gte") String createdAtGte, @retrofit2.http.Query("etag__eq") String etagEq, @retrofit2.http.Query("etag__neq") String etagNeq, @retrofit2.http.Query("etag__in") String etagIn, @retrofit2.http.Query("etag__nin") String etagNin, @retrofit2.http.Query("etag__lte") String etagLte, @retrofit2.http.Query("etag__gte") String etagGte, @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin, @retrofit2.http.Query("id__lte") String idLte, @retrofit2.http.Query("id__gte") String idGte, @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("name__neq") String nameNeq, @retrofit2.http.Query("name__in") String nameIn, @retrofit2.http.Query("name__nin") String nameNin, @retrofit2.http.Query("name__lte") String nameLte, @retrofit2.http.Query("name__gte") String nameGte, @retrofit2.http.Query("query__eq") String queryEq, @retrofit2.http.Query("query__neq") String queryNeq, @retrofit2.http.Query("query__in") String queryIn, @retrofit2.http.Query("query__nin") String queryNin, @retrofit2.http.Query("query__lte") String queryLte, @retrofit2.http.Query("query__gte") String queryGte, @retrofit2.http.Query("updated_at__eq") String updatedAtEq, @retrofit2.http.Query("updated_at__neq") String updatedAtNeq, @retrofit2.http.Query("updated_at__in") String updatedAtIn, @retrofit2.http.Query("updated_at__nin") String updatedAtNin, @retrofit2.http.Query("updated_at__lte") String updatedAtLte, @retrofit2.http.Query("updated_at__gte") String updatedAtGte, @retrofit2.http.Query("include") String include
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
