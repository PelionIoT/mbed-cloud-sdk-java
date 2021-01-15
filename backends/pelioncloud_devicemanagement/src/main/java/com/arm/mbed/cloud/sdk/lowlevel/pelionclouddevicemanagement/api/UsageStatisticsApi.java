package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.StatisticsViewResponse;

public interface UsageStatisticsApi {
    /**
     * Get statistics view of Device Management usage. Fetch the statistics view of Device Management usage in time
     * series for the currently authenticated commercial account. The response contains the additional counters below,
     * if the account business model is set to &#x60;API calls&#x60; by the account administrator: -
     * device_to_pelion_messages - pelion_to_device_messages - pelion_to_webapp_notifications -
     * rest_api_requests_with_api_key_token - rest_api_requests_with_user_token The return data is retrieved during a
     * defined time window and grouped by defined interval. The time window for data retrieval is defined as a range,
     * that can be either absolute (for instance, using timestamps) or relative (referring to the &#39;period&#39;
     * parameter). Range start is inclusive, while range end is exclusive. The specified range must be equal to or
     * greater than the specified interval. Returned data does not include any tenant usage. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-statistics?start&#x3D;2019-11-01T00:00:00.000Z&amp;end&#x3D;2019-12-01T00:00:00.000Z&amp;interval&#x3D;1d
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param interval
     *            Group the data by this interval in minutes, hours, days, weeks or months. One week is normalized to 7
     *            days. Sample values: 5m, 2h, 3d, 4w, 1mo, 3mo. Minimum supported interval is 5 minutes. The specified
     *            interval must not be greater than the specified range. (required)
     * @param start
     *            Start time of the statistics view in RFC3339 date-time format, with millisecond accuracy and UTC time
     *            zone. The parameter is mandatory if the period is not specified. Do not set the parameter if you have
     *            specified the period. Fetch data with timestamp greater than or equal to this value. Sample value:
     *            2017-02-07T09:20:56.990Z. The specified range must be equal to or greater than 5 minutes. Maximum
     *            supported range is 98 days when using timestamps to specify the range. (optional)
     * @param end
     *            End time of the statistics view in RFC3339 date-time format with millisecond accuracy and UTC time
     *            zone. The parameter is mandatory if the period is not specified. Do not set the parameter if you have
     *            specified the period. Fetch the data with timestamp less than this value. Sample value:
     *            2017-02-07T09:20:56.990Z. The specified range must be equal to or greater than 5 minutes. Maximum
     *            supported range is 98 days when using timestamps to specify the range. (optional)
     * @param period
     *            Period. Alternative for specifying the range if not using start and end parameters. The parameter is
     *            mandatory if the start and end parameters are not specified. Do not set the parameter if you have
     *            specified the start and end parameters. Fetch the data for the period in minutes, hours, days, weeks
     *            or months. One week is normalized to 7 days. Sample values: 5m, 2h, 3d, 4w, 1mo, 3mo. The allowed
     *            periods (inclusive) are 5m-141120m/1h-2352h/1d-98d/1w-14w/1mo-3mo. (optional)
     * @param limit
     *            Maximum number of statistics view records in one paginated response. (optional, default to 50)
     * @param after
     *            Results after specified record ID. (optional)
     * @param order
     *            Record order. Acceptable values (case insensitive): ASC, DESC. Default: ASC. (optional)
     * @param include
     *            Comma-separated additional data to return. Currently supported: total_count. (optional)
     * @return Call&lt;StatisticsViewResponse&gt;
     */
    @GET("v3/billing-statistics")
    Call<StatisticsViewResponse>
        getStatisticsView(@retrofit2.http.Query("interval") String interval,
                          @retrofit2.http.Query("start") DateTime start, @retrofit2.http.Query("end") DateTime end,
                          @retrofit2.http.Query("period") String period, @retrofit2.http.Query("limit") Integer limit,
                          @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order,
                          @retrofit2.http.Query("include") String include);

}
