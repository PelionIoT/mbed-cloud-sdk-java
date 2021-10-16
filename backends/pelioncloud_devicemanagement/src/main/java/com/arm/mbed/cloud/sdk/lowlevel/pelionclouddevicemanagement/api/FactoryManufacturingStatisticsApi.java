package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.StatisticsReportListResponse;

public interface FactoryManufacturingStatisticsApi {
    /**
     * Retrieve provisioning statistics for devices in your factories. Get manufacturing statistics report. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/manufacturing/statistics?start&#x3D;2020-06-23T21:00:00.000Z&amp;end&#x3D;2020-07-01T20:59:59.999Z
     * --header &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param start
     *            The start date and time for the report. (required)
     * @param end
     *            The end date and time for the report. The default value is the current date-time. (optional)
     * @return Call&lt;StatisticsReportListResponse&gt;
     */
    @GET("v3/manufacturing/statistics")
    Call<StatisticsReportListResponse> manufacturingStatisticsReport(@retrofit2.http.Query("start") DateTime start,
                                                                     @retrofit2.http.Query("end") DateTime end);

}
