package com.arm.mbed.cloud.sdk.internal.statistics.api;

import com.arm.mbed.cloud.sdk.internal.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.arm.mbed.cloud.sdk.internal.statistics.model.ErrorResponse;
import com.arm.mbed.cloud.sdk.internal.statistics.model.SuccessfulResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface AccountApi {
  /**
   * Provides account-specific statistics for other cloud services.
   * This REST API is used to get account-specific statistics.
   * @param include A comma-separated list of requested metrics and total_count (if included, the response will contain total_count to specify the total number of records available). Supported values are:  - &#x60;transactions&#x60; - &#x60;registered_devices&#x60; - &#x60;bootstraps_successful&#x60; - &#x60;bootstraps_failed&#x60; - &#x60;bootstraps_pending&#x60; - &#x60;handshakes_successful&#x60; - &#x60;device_server_rest_api_success&#x60; - &#x60;device_server_rest_api_error&#x60; - &#x60;total_count&#x60;  (required)
   * @param interval Group the data by this interval in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The maximum interval cannot exceed one year (365 days). The allowed ranges are 5m-525600m/1h-8760h/1d-365d/1w-53w.  (required)
   * @param authorization Bearer {Access Token}. A valid API Gateway access token. The token is validated and the associated account identifier is used to retrieve account-specific statistics.  (required)
   * @param start UTC time/year/date in RFC3339 format. Fetch the data with timestamp greater than or equal to this value. Sample values: 20170207T092056990Z / 2017-02-07T09:20:56.990Z / 2017 / 20170207. The maximum time between start and end parameters cannot exceed more than one year (365 days). The parameter is not mandatory, if the period is specified.  (optional)
   * @param end UTC time/year/date in RFC3339 format. Fetch the data with timestamp less than this value.Sample values: 20170207T092056990Z / 2017-02-07T09:20:56.990Z / 2017 / 20170207. The maximum time between start and end parameters cannot exceed more than one year ( 365 days ). The parameter is not mandatory, if the period is specified.  (optional)
   * @param period Period. Fetch the data for the period in minutes, hours, days or weeks. Sample values: 5m, 2h, 3d, 4w. The parameter is not mandatory, if the start and end time are specified. The maximum period cannot exceed one year (365 days). The allowed ranges are 5m-525600m/1h-8760h/1d-365d/1w-53w.  (optional)
   * @param limit The number of results to return. The default value is 50, minimum 2 and maximum 1000.  (optional)
   * @param after The metric ID after which to start fetching.  (optional)
   * @param order The order of the records to return. Available values are ASC and DESC. The default value is ASC.  (optional)
   * @return Call&lt;SuccessfulResponse&gt;
   */
  
  @GET("v3/metrics")
  Call<SuccessfulResponse> v3MetricsGet(
    @retrofit2.http.Query("include") String include, @retrofit2.http.Query("interval") String interval, @retrofit2.http.Header("Authorization") String authorization, @retrofit2.http.Query("start") String start, @retrofit2.http.Query("end") String end, @retrofit2.http.Query("period") String period, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("after") String after, @retrofit2.http.Query("order") String order
  );

}
