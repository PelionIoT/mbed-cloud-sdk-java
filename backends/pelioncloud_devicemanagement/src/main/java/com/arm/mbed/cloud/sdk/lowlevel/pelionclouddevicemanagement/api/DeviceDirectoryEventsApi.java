package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceEventPage;

public interface DeviceDirectoryEventsApi {
    /**
     * List all device events. List all device events for an account. **Example:** Following example gets device-events
     * limiting returned results to max 5 events &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/device-events?limit&#x3D;5 \\ -H &#39;Authorization: Bearer &lt;API
     * key&gt;&#39; &#x60;&#x60;&#x60; or to get events for certain device filter based on device_id: &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-events?device_id&#x3D;&lt;device_id&gt; \\ -H
     * &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param limit
     *            How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the
     *            closest limit. (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. Default: ASC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data. ##### Filtering &#x60;?filter&#x3D;{URL
     *            encoded query string}&#x60; The query string is made up of key/value pairs separated by ampersands. So
     *            for a query of &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;, this would be
     *            encoded as &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;. ###### Filterable
     *            fields: The below table lists all filterable fields: &lt;table&gt; &lt;thead&gt; &lt;tr&gt;
     *            &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt; &lt;th&gt;__in /
     *            __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt;
     *            &lt;td&gt;date_time&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;description&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;device_id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;event_type&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;state_change&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The examples below show the queries in *unencoded* form.
     *            ###### By id: &#x60;id&#x3D;{id}&#x60; ###### By state change:
     *            &#x60;state_change&#x3D;[True|False]&#x60; ###### By event type: &#x60;event_type&#x3D;{value}&#x60;
     *            ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format:
     *            &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations: * UTC RFC3339 with
     *            milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example,
     *            2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example,
     *            20161130T162512Z. Date-time filtering supports three operators: * Equality. * Greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name
     *            suffixed with &#x60;__lte&#x60;. Lower and upper limits to a date-time range may be specified by
     *            including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter: &#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60; ##### Multi-field example
     *            &#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;
     *            Encoded:
     *            &#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in:
     *            &#x60;__nin&#x60;. For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated:
     *            &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60; (optional)
     * @param dateTimeIn
     *            in filter for the \&quot;date_time\&quot; field (optional)
     * @param dateTimeNin
     *            nin filter for the \&quot;date_time\&quot; field (optional)
     * @param dateTimeLte
     *            lte filter for the \&quot;date_time\&quot; field (optional)
     * @param dateTimeGte
     *            gte filter for the \&quot;date_time\&quot; field (optional)
     * @param descriptionEq
     *            eq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNeq
     *            neq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionIn
     *            in filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNin
     *            nin filter for the \&quot;description\&quot; field (optional)
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param deviceIdEq
     *            eq filter for the \&quot;device_id\&quot; field (optional)
     * @param deviceIdNeq
     *            neq filter for the \&quot;device_id\&quot; field (optional)
     * @param deviceIdIn
     *            in filter for the \&quot;device_id\&quot; field (optional)
     * @param deviceIdNin
     *            nin filter for the \&quot;device_id\&quot; field (optional)
     * @param eventTypeEq
     *            eq filter for the \&quot;event_type\&quot; field (optional)
     * @param eventTypeNeq
     *            neq filter for the \&quot;event_type\&quot; field (optional)
     * @param eventTypeIn
     *            in filter for the \&quot;event_type\&quot; field (optional)
     * @param eventTypeNin
     *            nin filter for the \&quot;event_type\&quot; field (optional)
     * @param stateChangeEq
     *            eq filter for the \&quot;state_change\&quot; field (optional)
     * @param stateChangeNeq
     *            neq filter for the \&quot;state_change\&quot; field (optional)
     * @return Call&lt;DeviceEventPage&gt;
     */
    @GET("v3/device-events/")
    Call<DeviceEventPage>
        deviceEventList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                        @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                        @retrofit2.http.Query("filter") String filter,
                        @retrofit2.http.Query("date_time__in") String dateTimeIn,
                        @retrofit2.http.Query("date_time__nin") String dateTimeNin,
                        @retrofit2.http.Query("date_time__lte") DateTime dateTimeLte,
                        @retrofit2.http.Query("date_time__gte") DateTime dateTimeGte,
                        @retrofit2.http.Query("description__eq") String descriptionEq,
                        @retrofit2.http.Query("description__neq") String descriptionNeq,
                        @retrofit2.http.Query("description__in") String descriptionIn,
                        @retrofit2.http.Query("description__nin") String descriptionNin,
                        @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                        @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                        @retrofit2.http.Query("device_id__eq") String deviceIdEq,
                        @retrofit2.http.Query("device_id__neq") String deviceIdNeq,
                        @retrofit2.http.Query("device_id__in") String deviceIdIn,
                        @retrofit2.http.Query("device_id__nin") String deviceIdNin,
                        @retrofit2.http.Query("event_type__eq") String eventTypeEq,
                        @retrofit2.http.Query("event_type__neq") String eventTypeNeq,
                        @retrofit2.http.Query("event_type__in") String eventTypeIn,
                        @retrofit2.http.Query("event_type__nin") String eventTypeNin,
                        @retrofit2.http.Query("state_change__eq") Boolean stateChangeEq,
                        @retrofit2.http.Query("state_change__neq") Boolean stateChangeNeq);

    /**
     * Retrieve a device event. Retrieve a specific device event. **Example:** To fetch a specific event you can use the
     * &#39;id&#39; field form the &#39;/v3/device-events&#39;. Form of &#39;016c03d40a4e000000000001001003b4&#39;
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/device-events/&lt;device_event_id&gt; \\ -H
     * &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param deviceEventId
     *            (required)
     * @return Call&lt;DeviceEventData&gt;
     */
    @GET("v3/device-events/{device_event_id}/")
    Call<DeviceEventData>
        deviceEventRetrieve(@retrofit2.http.Path(value = "device_event_id", encoded = true) String deviceEventId);

    /**
     * DEPRECATED: List all device events. DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60;
     * instead.
     * 
     * @param limit
     *            How many objects to retrieve in the page (2-1000). Limit values outside of this range are set to the
     *            closest limit. (optional)
     * @param order
     *            Record order. Acceptable values: ASC, DESC. Default: ASC. (optional)
     * @param after
     *            The ID of the item after which to retrieve the next page. (optional)
     * @param include
     *            Comma-separated list of data fields to return. Currently supported: &#x60;total_count&#x60;.
     *            (optional)
     * @param filter
     *            URL-encoded query string parameter to filter returned data. ##### Filtering &#x60;?filter&#x3D;{URL
     *            encoded query string}&#x60; The query string is made up of key/value pairs separated by ampersands. So
     *            for a query of &#x60;key1&#x3D;value1&amp;key2&#x3D;value2&amp;key3&#x3D;value3&#x60;, this would be
     *            encoded as &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;. ###### Filterable
     *            fields: The below table lists all filterable fields: &lt;table&gt; &lt;thead&gt; &lt;tr&gt;
     *            &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt; &lt;th&gt;__in /
     *            __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt;
     *            &lt;td&gt;date_time&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;description&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;device_id&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;event_type&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;state_change&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The examples below show the queries in *unencoded* form.
     *            ###### By id: &#x60;id&#x3D;{id}&#x60; ###### By state change:
     *            &#x60;state_change&#x3D;[True|False]&#x60; ###### By event type: &#x60;event_type&#x3D;{value}&#x60;
     *            ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format
     *            &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations: * UTC RFC3339 with
     *            milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example,
     *            2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example,
     *            20161130T162512Z. Date-time filtering supports three operators: * Equality. * Greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name
     *            suffixed with &#x60;__lte&#x60;. Lower and upper limits to a date-time range may be specified by
     *            including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter: &#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60; ##### Multi-field example
     *            &#x60;id&#x3D;0158d38771f70000000000010010038c&amp;state_change&#x3D;True&amp;date_time__gte&#x3D;2016-11-30T16:25:12.1234Z&#x60;
     *            Encoded:
     *            &#x60;?filter&#x3D;id%3D0158d38771f70000000000010010038c%26state_change%3DTrue%26date_time__gte%3D2016-11-30T16%3A25%3A12.1234Z&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in:
     *            &#x60;__nin&#x60;. For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated:
     *            &#x60;event_type__in&#x3D;update.device.device-created,update.device.device-updated&#x60;. (optional)
     * @param dateTimeIn
     *            in filter for the \&quot;date_time\&quot; field (optional)
     * @param dateTimeNin
     *            nin filter for the \&quot;date_time\&quot; field (optional)
     * @param dateTimeLte
     *            lte filter for the \&quot;date_time\&quot; field (optional)
     * @param dateTimeGte
     *            gte filter for the \&quot;date_time\&quot; field (optional)
     * @param descriptionEq
     *            eq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNeq
     *            neq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionIn
     *            in filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNin
     *            nin filter for the \&quot;description\&quot; field (optional)
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param deviceIdEq
     *            eq filter for the \&quot;device_id\&quot; field (optional)
     * @param deviceIdNeq
     *            neq filter for the \&quot;device_id\&quot; field (optional)
     * @param deviceIdIn
     *            in filter for the \&quot;device_id\&quot; field (optional)
     * @param deviceIdNin
     *            nin filter for the \&quot;device_id\&quot; field (optional)
     * @param eventTypeEq
     *            eq filter for the \&quot;event_type\&quot; field (optional)
     * @param eventTypeNeq
     *            neq filter for the \&quot;event_type\&quot; field (optional)
     * @param eventTypeIn
     *            in filter for the \&quot;event_type\&quot; field (optional)
     * @param eventTypeNin
     *            nin filter for the \&quot;event_type\&quot; field (optional)
     * @param stateChangeEq
     *            eq filter for the \&quot;state_change\&quot; field (optional)
     * @param stateChangeNeq
     *            neq filter for the \&quot;state_change\&quot; field (optional)
     * @param stateChangeIn
     *            in filter for the \&quot;state_change\&quot; field (optional)
     * @param stateChangeNin
     *            nin filter for the \&quot;state_change\&quot; field (optional)
     * @return Call&lt;DeviceEventPage&gt;
     */
    @GET("v3/devicelog/")
    Call<DeviceEventPage>
        deviceLogList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                      @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                      @retrofit2.http.Query("filter") String filter,
                      @retrofit2.http.Query("date_time__in") String dateTimeIn,
                      @retrofit2.http.Query("date_time__nin") String dateTimeNin,
                      @retrofit2.http.Query("date_time__lte") DateTime dateTimeLte,
                      @retrofit2.http.Query("date_time__gte") DateTime dateTimeGte,
                      @retrofit2.http.Query("description__eq") String descriptionEq,
                      @retrofit2.http.Query("description__neq") String descriptionNeq,
                      @retrofit2.http.Query("description__in") String descriptionIn,
                      @retrofit2.http.Query("description__nin") String descriptionNin,
                      @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                      @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                      @retrofit2.http.Query("device_id__eq") String deviceIdEq,
                      @retrofit2.http.Query("device_id__neq") String deviceIdNeq,
                      @retrofit2.http.Query("device_id__in") String deviceIdIn,
                      @retrofit2.http.Query("device_id__nin") String deviceIdNin,
                      @retrofit2.http.Query("event_type__eq") String eventTypeEq,
                      @retrofit2.http.Query("event_type__neq") String eventTypeNeq,
                      @retrofit2.http.Query("event_type__in") String eventTypeIn,
                      @retrofit2.http.Query("event_type__nin") String eventTypeNin,
                      @retrofit2.http.Query("state_change__eq") Boolean stateChangeEq,
                      @retrofit2.http.Query("state_change__neq") Boolean stateChangeNeq,
                      @retrofit2.http.Query("state_change__in") String stateChangeIn,
                      @retrofit2.http.Query("state_change__nin") String stateChangeNin);

    /**
     * DEPRECATED: Retrieve a device event. Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/
     * instead).
     * 
     * @param deviceEventId
     *            (required)
     * @return Call&lt;DeviceEventData&gt;
     */
    @GET("v3/devicelog/{device_event_id}/")
    Call<DeviceEventData>
        deviceLogRetrieve(@retrofit2.http.Path(value = "device_event_id", encoded = true) String deviceEventId);

}
