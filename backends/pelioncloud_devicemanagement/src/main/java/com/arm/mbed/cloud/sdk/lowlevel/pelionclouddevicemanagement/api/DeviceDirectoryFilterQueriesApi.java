package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQueryPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQueryPostPutRequest;

public interface DeviceDirectoryFilterQueriesApi {
    /**
     * Create a device query. Create a new device query.
     * 
     * @param device
     *            (required)
     * @return Call&lt;DeviceQuery&gt;
     */
    @POST("v3/device-queries/")
    Call<DeviceQuery> deviceQueryCreate(@retrofit2.http.Body DeviceQueryPostPutRequest device);

    /**
     * Delete a device query. Delete a device query.
     * 
     * @param queryId
     *            (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/device-queries/{query_id}/")
    Call<Void> deviceQueryDestroy(@retrofit2.http.Path(value = "query_id", encoded = true) String queryId);

    /**
     * List device queries. List all device queries.
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
     *            encoded as: &#x60;?filter&#x3D;key1%3Dvalue1%26key2%3Dvalue2%26key3%3Dvalue3&#x60;. The below table
     *            lists all filterable fields: &lt;table&gt; &lt;thead&gt; &lt;tr&gt; &lt;th&gt;Field&lt;/th&gt;
     *            &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt; &lt;th&gt;__in / __nin&lt;/th&gt; &lt;th&gt;__lte /
     *            __gte&lt;/th&gt; &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;name&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;query&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;updated_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;/tbody&gt;
     *            &lt;/table&gt; &amp;nbsp; The examples below show the queries in *unencoded* form. ###### By device
     *            query properties (all properties are filterable): For example: &#x60;description&#x3D;{value}&#x60;
     *            ###### On date-time fields: Date-time fields should be specified in UTC RFC3339 format
     *            &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations: * UTC RFC3339 with
     *            milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example,
     *            2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example,
     *            20161130T162512Z. Date-time filtering supports three operators: * Equality. * Greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name
     *            suffixed with &#x60;__lte&#x60;. Lower and upper limits to a date-time range may be specified by
     *            including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter: &#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60;. ##### Multi-field example
     *            &#x60;query_id&#x3D;0158d38771f70000000000010010038c&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            Encoded:
     *            &#x60;filter&#x3D;query_id%3D0158d38771f70000000000010010038c%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-11-30T00%3A00%3A00Z&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in:
     *            &#x60;__nin&#x60;. For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__nin&#x3D;query1,query2&#x60; (optional)
     * @param createdAtIn
     *            in filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtNin
     *            nin filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtLte
     *            lte filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtGte
     *            gte filter for the \&quot;created_at\&quot; field (optional)
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param nameEq
     *            eq filter for the \&quot;name\&quot; field (optional)
     * @param nameNeq
     *            neq filter for the \&quot;name\&quot; field (optional)
     * @param nameIn
     *            in filter for the \&quot;name\&quot; field (optional)
     * @param nameNin
     *            nin filter for the \&quot;name\&quot; field (optional)
     * @param queryEq
     *            eq filter for the \&quot;query\&quot; field (optional)
     * @param queryNeq
     *            neq filter for the \&quot;query\&quot; field (optional)
     * @param queryIn
     *            in filter for the \&quot;query\&quot; field (optional)
     * @param queryNin
     *            nin filter for the \&quot;query\&quot; field (optional)
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @return Call&lt;DeviceQueryPage&gt;
     */
    @GET("v3/device-queries/")
    Call<DeviceQueryPage>
        deviceQueryList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                        @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                        @retrofit2.http.Query("filter") String filter,
                        @retrofit2.http.Query("created_at__in") String createdAtIn,
                        @retrofit2.http.Query("created_at__nin") String createdAtNin,
                        @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                        @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                        @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                        @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                        @retrofit2.http.Query("name__eq") String nameEq,
                        @retrofit2.http.Query("name__neq") String nameNeq,
                        @retrofit2.http.Query("name__in") String nameIn,
                        @retrofit2.http.Query("name__nin") String nameNin,
                        @retrofit2.http.Query("query__eq") String queryEq,
                        @retrofit2.http.Query("query__neq") String queryNeq,
                        @retrofit2.http.Query("query__in") String queryIn,
                        @retrofit2.http.Query("query__nin") String queryNin,
                        @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                        @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                        @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                        @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte);

    /**
     * Retrieve a device query. Retrieve a specific device query.
     * 
     * @param queryId
     *            (required)
     * @return Call&lt;DeviceQuery&gt;
     */
    @GET("v3/device-queries/{query_id}/")
    Call<DeviceQuery> deviceQueryRetrieve(@retrofit2.http.Path(value = "query_id", encoded = true) String queryId);

    /**
     * Update a device query. Update a specifc device query.
     * 
     * @param queryId
     *            (required)
     * @param body
     *            Device query update object. (required)
     * @return Call&lt;DeviceQuery&gt;
     */
    @PUT("v3/device-queries/{query_id}/")
    Call<DeviceQuery> deviceQueryUpdate(@retrofit2.http.Path(value = "query_id", encoded = true) String queryId,
                                        @retrofit2.http.Body DeviceQueryPostPutRequest body);

}
