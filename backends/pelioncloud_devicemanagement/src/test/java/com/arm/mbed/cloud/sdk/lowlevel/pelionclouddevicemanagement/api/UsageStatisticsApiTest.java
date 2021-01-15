package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for UsageStatisticsApi
 */
public class UsageStatisticsApiTest {

    private UsageStatisticsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UsageStatisticsApi.class);
    }

    /**
     * Get statistics view of Device Management usage.
     *
     * Fetch the statistics view of Device Management usage in time series for the currently authenticated commercial
     * account. The response contains the additional counters below, if the account business model is set to &#x60;API
     * calls&#x60; by the account administrator: - device_to_pelion_messages - pelion_to_device_messages -
     * pelion_to_webapp_notifications - rest_api_requests_with_api_key_token - rest_api_requests_with_user_token The
     * return data is retrieved during a defined time window and grouped by defined interval. The time window for data
     * retrieval is defined as a range, that can be either absolute (for instance, using timestamps) or relative
     * (referring to the &#39;period&#39; parameter). Range start is inclusive, while range end is exclusive. The
     * specified range must be equal to or greater than the specified interval. Returned data does not include any
     * tenant usage. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-statistics?start&#x3D;2019-11-01T00:00:00.000Z&amp;end&#x3D;2019-12-01T00:00:00.000Z&amp;interval&#x3D;1d
     * \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getStatisticsViewTest() {
        String interval = null;
        DateTime start = null;
        DateTime end = null;
        String period = null;
        Integer limit = null;
        String after = null;
        String order = null;
        String include = null;
        // StatisticsViewResponse response = api.getStatisticsView(interval, start, end, period, limit, after, order,
        // include);

        // TODO: test validations
    }
}
