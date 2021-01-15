package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Log;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.LogsPage;

public interface GatewayLogsPublicApiApi {
    /**
     * Retrieve a device log by ID. Retrieve a device log from a device by log ID. **Example usage:** &#x60;&#x60;&#x60;
     * curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/device-logs/(device_log_id) &#x60;&#x60;&#x60;
     * 
     * @param deviceLogId
     *            The ID of the device log. (required)
     * @return Call&lt;Log&gt;
     */
    @GET("v3/device-logs/{device_log_id}")
    Call<Log>
        getDeviceLogBasedOnLogID(@retrofit2.http.Path(value = "device_log_id", encoded = true) String deviceLogId);

    /**
     * List all device logs based on filters List logs for all devices based on a combination of filters. **Example
     * usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access token&gt;&#39; \\
     * https://api.us-east-1.mbedcloud.com/v3/device-logs &#x60;&#x60;&#x60;
     * 
     * @param deviceIdIn
     *            The device ID for which to retrieve logs. (optional)
     * @param limit
     *            Limit the number of returned results. The default value is 100. (optional, default to 100)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. (optional, default to DESC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count (optional)
     * @param timestampLte
     *            RFC 3339 UTC timestamp range upper limit. (optional)
     * @param timestampGte
     *            RFC 3339 UTC timestamp range lower limit. (optional)
     * @param appNameEq
     *            Name of the application on a device that generated logs. (optional)
     * @param typeEq
     *            Device log type filter. (optional)
     * @param messageEq
     *            Device log message filter. (optional)
     * @param levelGte
     *            Minimum severity level of logs to retrieve. (optional)
     * @return Call&lt;LogsPage&gt;
     */
    @GET("v3/device-logs")
    Call<LogsPage> listGatewayDeviceLogs(@retrofit2.http.Query("device_id__in") String deviceIdIn,
                                         @retrofit2.http.Query("limit") Integer limit,
                                         @retrofit2.http.Query("after") String after,
                                         @retrofit2.http.Query("order") String order,
                                         @retrofit2.http.Query("include") String include,
                                         @retrofit2.http.Query("timestamp__lte") DateTime timestampLte,
                                         @retrofit2.http.Query("timestamp__gte") DateTime timestampGte,
                                         @retrofit2.http.Query("app_name__eq") String appNameEq,
                                         @retrofit2.http.Query("type__eq") String typeEq,
                                         @retrofit2.http.Query("message__eq") String messageEq,
                                         @retrofit2.http.Query("level__gte") String levelGte);

    /**
     * Return the logs for a specific device. Retrieve logs for a given device based on a combination of filters.
     * **Example usage:** &#x60;&#x60;&#x60; curl -X GET \\ -H &#39;Authorization: Bearer &lt;valid access
     * token&gt;&#39; \\ https://api.us-east-1.mbedcloud.com/v3/devices/{device_id}/logs &#x60;&#x60;&#x60;
     * 
     * @param deviceId
     *            The id of the device (required)
     * @param limit
     *            Limit the number of returned results. The default value is 100. (optional, default to 100)
     * @param after
     *            The entity ID to fetch after the given one. (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. (optional, default to DESC)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count (optional)
     * @param timestampLte
     *            RFC 3339 UTC timestamp range upper limit. (optional)
     * @param timestampGte
     *            RFC 3339 UTC timestamp range lower limit. (optional)
     * @param appNameEq
     *            Name of the application on a device that generated logs. (optional)
     * @param typeEq
     *            Device log type filter. (optional)
     * @param messageEq
     *            Device log message filter. (optional)
     * @param levelGte
     *            Minimum severity level of logs to retrieve. (optional)
     * @return Call&lt;LogsPage&gt;
     */
    @GET("v3/devices/{device_id}/logs")
    Call<LogsPage>
        listSingleGatewayDeviceLogs(@retrofit2.http.Path(value = "device_id", encoded = true) String deviceId,
                                    @retrofit2.http.Query("limit") Integer limit,
                                    @retrofit2.http.Query("after") String after,
                                    @retrofit2.http.Query("order") String order,
                                    @retrofit2.http.Query("include") String include,
                                    @retrofit2.http.Query("timestamp__lte") DateTime timestampLte,
                                    @retrofit2.http.Query("timestamp__gte") DateTime timestampGte,
                                    @retrofit2.http.Query("app_name__eq") String appNameEq,
                                    @retrofit2.http.Query("type__eq") String typeEq,
                                    @retrofit2.http.Query("message__eq") String messageEq,
                                    @retrofit2.http.Query("level__gte") String levelGte);

}
