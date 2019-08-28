package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroup;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroupManipulation;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroupPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DevicePage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group1;
import org.joda.time.LocalDate;

public interface DeviceDirectoryGroupsApi {
    /**
     * Create a group. Create a group.
     * 
     * @param group
     *            Group (required)
     * @return Call&lt;DeviceGroup&gt;
     */
    @POST("v3/device-groups/")
    Call<DeviceGroup> groupCreate(@retrofit2.http.Body Group group);

    /**
     * Delete a group. Delete a group.
     * 
     * @param deviceGroupId
     *            The ID of the group. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/device-groups/{device-group-id}/")
    Call<Void> groupDelete(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId);

    /**
     * List all groups. List all groups.
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
     *            fields: The table lists all filterable fields: &lt;table&gt; &lt;thead&gt; &lt;tr&gt;
     *            &lt;th&gt;Field&lt;/th&gt; &lt;th&gt;&#x3D; / __eq / __neq&lt;/th&gt; &lt;th&gt;__in /
     *            __nin&lt;/th&gt; &lt;th&gt;__lte / __gte&lt;/th&gt; &lt;tr&gt; &lt;thead&gt; &lt;tbody&gt; &lt;tr&gt;
     *            &lt;td&gt;id&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;devices_count&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;name&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;custom_attributes&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;td&gt;&amp;nbsp;&lt;/td&gt; &lt;/tr&gt;
     *            &lt;tr&gt; &lt;td&gt;created_at&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt; &lt;td&gt;updated_at&lt;/td&gt;
     *            &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;/tr&gt; &lt;tr&gt;
     *            &lt;td&gt;etag&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt; &lt;td&gt;✓&lt;/td&gt;
     *            &lt;/tr&gt; &lt;/tbody&gt; &lt;/table&gt; &amp;nbsp; The examples below show the queries in
     *            *unencoded* form. ###### By device group properties: &#x60;name__eq&#x3D;mygroup&#x60; ###### On
     *            date-time fields: Date-time fields should be specified in UTC RFC3339 format
     *            &#x60;YYYY-MM-DDThh:mm:ss.msZ&#x60;. There are three permitted variations: * UTC RFC3339 with
     *            milliseconds, for example, 2016-11-30T16:25:12.1234Z. * UTC RFC3339 without milliseconds, for example,
     *            2016-11-30T16:25:12Z. * UTC RFC3339 shortened - without milliseconds and punctuation, for example,
     *            20161130T162512Z. Date-time filtering supports three operators: * Equality. * Greater than or equal to
     *            &amp;ndash; field name suffixed with &#x60;__gte&#x60;. * Less than or equal to &amp;ndash; field name
     *            suffixed with &#x60;__lte&#x60;. Lower and upper limits to a date-time range may be specified by
     *            including both the &#x60;__gte&#x60; and &#x60;__lte&#x60; forms in the filter: &#x60;{field
     *            name}[|__lte|__gte]&#x3D;{UTC RFC3339 date-time}&#x60; ###### By device group custom attributes:
     *            &#x60;custom_attributes__{param}&#x3D;{value}&#x60; &#x60;custom_attributes__tag&#x3D;TAG1&#x60; #####
     *            Multi-field example
     *            &#x60;name__eq&#x3D;mygroup&amp;created_at__gte&#x3D;2016-11-30T16:25:12.1234Z&amp;created_at__lte&#x3D;2016-12-30T00:00:00Z&#x60;
     *            Encoded:
     *            &#x60;?filter&#x3D;name__eq%3Dmygroup%26created_at__gte%3D2016-11-30T16%3A25%3A12.1234Z%26created_at__lte%3D2016-12-30T00%3A00%3A00Z&#x60;
     *            ##### Filtering with filter operators String field filtering supports the following operators: *
     *            Equality: &#x60;__eq&#x60;. * Non-equality: &#x60;__neq&#x60;. * In : &#x60;__in&#x60;. * Not in:
     *            &#x60;__nin&#x60;. For &#x60;__in&#x60; and &#x60;__nin&#x60; filters list of parameters must be
     *            comma-separated: &#x60;name__in&#x3D;group1,group2&#x60; (optional)
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param devicesCountEq
     *            eq filter for the \&quot;devices_count\&quot; field (optional)
     * @param devicesCountNeq
     *            neq filter for the \&quot;devices_count\&quot; field (optional)
     * @param devicesCountIn
     *            in filter for the \&quot;devices_count\&quot; field (optional)
     * @param devicesCountNin
     *            nin filter for the \&quot;devices_count\&quot; field (optional)
     * @param devicesCountLte
     *            lte filter for the \&quot;devices_count\&quot; field (optional)
     * @param devicesCountGte
     *            gte filter for the \&quot;devices_count\&quot; field (optional)
     * @param nameEq
     *            eq filter for the \&quot;name\&quot; field (optional)
     * @param nameNeq
     *            neq filter for the \&quot;name\&quot; field (optional)
     * @param nameIn
     *            in filter for the \&quot;name\&quot; field (optional)
     * @param nameNin
     *            nin filter for the \&quot;name\&quot; field (optional)
     * @param createdAtIn
     *            in filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtNin
     *            nin filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtLte
     *            lte filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtGte
     *            gte filter for the \&quot;created_at\&quot; field (optional)
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @return Call&lt;DeviceGroupPage&gt;
     */
    @GET("v3/device-groups/")
    Call<DeviceGroupPage>
        groupList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                  @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
                  @retrofit2.http.Query("filter") String filter, @retrofit2.http.Query("id__eq") String idEq,
                  @retrofit2.http.Query("id__neq") String idNeq, @retrofit2.http.Query("id__in") String idIn,
                  @retrofit2.http.Query("id__nin") String idNin,
                  @retrofit2.http.Query("devices_count__eq") Integer devicesCountEq,
                  @retrofit2.http.Query("devices_count__neq") Integer devicesCountNeq,
                  @retrofit2.http.Query("devices_count__in") String devicesCountIn,
                  @retrofit2.http.Query("devices_count__nin") String devicesCountNin,
                  @retrofit2.http.Query("devices_count__lte") Integer devicesCountLte,
                  @retrofit2.http.Query("devices_count__gte") Integer devicesCountGte,
                  @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("name__neq") String nameNeq,
                  @retrofit2.http.Query("name__in") String nameIn, @retrofit2.http.Query("name__nin") String nameNin,
                  @retrofit2.http.Query("created_at__in") String createdAtIn,
                  @retrofit2.http.Query("created_at__nin") String createdAtNin,
                  @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                  @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                  @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                  @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                  @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                  @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte);

    /**
     * Add a device to a group. Add one device to a group.
     * 
     * @param deviceGroupId
     *            The ID of the group. (required)
     * @param body
     *            Body of the request. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/device-groups/{device-group-id}/devices/add/")
    Call<Void> groupMembersAdd(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                               @retrofit2.http.Body DeviceGroupManipulation body);

    /**
     * Remove a device from a group. Remove one device from a group.
     * 
     * @param deviceGroupId
     *            The ID of the group. (required)
     * @param body
     *            Body of the request. (required)
     * @return Call&lt;Void&gt;
     */
    @POST("v3/device-groups/{device-group-id}/devices/remove/")
    Call<Void> groupMembersRemove(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                                  @retrofit2.http.Body DeviceGroupManipulation body);

    /**
     * Get a page of devices. Get a page of devices.
     * 
     * @param deviceGroupId
     *            (required)
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
     * @param lifecycleStatusEq
     *            eq filter for the \&quot;lifecycle_status\&quot; field (optional)
     * @param lifecycleStatusNeq
     *            neq filter for the \&quot;lifecycle_status\&quot; field (optional)
     * @param lifecycleStatusIn
     *            in filter for the \&quot;lifecycle_status\&quot; field (optional)
     * @param lifecycleStatusNin
     *            nin filter for the \&quot;lifecycle_status\&quot; field (optional)
     * @param operatorSuspendedEq
     *            eq filter for the \&quot;operator_suspended\&quot; field (optional)
     * @param operatorSuspendedNeq
     *            neq filter for the \&quot;operator_suspended\&quot; field (optional)
     * @param lastOperatorSuspendedCategoryEq
     *            eq filter for the \&quot;last_operator_suspended_category\&quot; field (optional)
     * @param lastOperatorSuspendedCategoryNeq
     *            neq filter for the \&quot;last_operator_suspended_category\&quot; field (optional)
     * @param lastOperatorSuspendedCategoryIn
     *            in filter for the \&quot;last_operator_suspended_category\&quot; field (optional)
     * @param lastOperatorSuspendedCategoryNin
     *            nin filter for the \&quot;last_operator_suspended_category\&quot; field (optional)
     * @param lastOperatorSuspendedUpdatedAtIn
     *            in filter for the \&quot;last_operator_suspended_updated_at\&quot; field (optional)
     * @param lastOperatorSuspendedUpdatedAtNin
     *            nin filter for the \&quot;last_operator_suspended_updated_at\&quot; field (optional)
     * @param lastOperatorSuspendedUpdatedAtLte
     *            lte filter for the \&quot;last_operator_suspended_updated_at\&quot; field (optional)
     * @param lastOperatorSuspendedUpdatedAtGte
     *            gte filter for the \&quot;last_operator_suspended_updated_at\&quot; field (optional)
     * @param systemSuspendedEq
     *            eq filter for the \&quot;system_suspended\&quot; field (optional)
     * @param systemSuspendedNeq
     *            neq filter for the \&quot;system_suspended\&quot; field (optional)
     * @param lastSystemSuspendedCategoryEq
     *            eq filter for the \&quot;last_system_suspended_category\&quot; field (optional)
     * @param lastSystemSuspendedCategoryNeq
     *            neq filter for the \&quot;last_system_suspended_category\&quot; field (optional)
     * @param lastSystemSuspendedCategoryIn
     *            in filter for the \&quot;last_system_suspended_category\&quot; field (optional)
     * @param lastSystemSuspendedCategoryNin
     *            nin filter for the \&quot;last_system_suspended_category\&quot; field (optional)
     * @param lastSystemSuspendedUpdatedAtIn
     *            in filter for the \&quot;last_system_suspended_updated_at\&quot; field (optional)
     * @param lastSystemSuspendedUpdatedAtNin
     *            nin filter for the \&quot;last_system_suspended_updated_at\&quot; field (optional)
     * @param lastSystemSuspendedUpdatedAtLte
     *            lte filter for the \&quot;last_system_suspended_updated_at\&quot; field (optional)
     * @param lastSystemSuspendedUpdatedAtGte
     *            gte filter for the \&quot;last_system_suspended_updated_at\&quot; field (optional)
     * @param accountIdEq
     *            eq filter for the \&quot;account_id\&quot; field (optional)
     * @param accountIdNeq
     *            neq filter for the \&quot;account_id\&quot; field (optional)
     * @param accountIdIn
     *            in filter for the \&quot;account_id\&quot; field (optional)
     * @param accountIdNin
     *            nin filter for the \&quot;account_id\&quot; field (optional)
     * @param autoUpdateEq
     *            eq filter for the \&quot;auto_update\&quot; field (optional)
     * @param autoUpdateNeq
     *            neq filter for the \&quot;auto_update\&quot; field (optional)
     * @param bootstrapExpirationDateIn
     *            in filter for the \&quot;bootstrap_expiration_date\&quot; field (optional)
     * @param bootstrapExpirationDateNin
     *            nin filter for the \&quot;bootstrap_expiration_date\&quot; field (optional)
     * @param bootstrapExpirationDateLte
     *            lte filter for the \&quot;bootstrap_expiration_date\&quot; field (optional)
     * @param bootstrapExpirationDateGte
     *            gte filter for the \&quot;bootstrap_expiration_date\&quot; field (optional)
     * @param bootstrappedTimestampIn
     *            in filter for the \&quot;bootstrapped_timestamp\&quot; field (optional)
     * @param bootstrappedTimestampNin
     *            nin filter for the \&quot;bootstrapped_timestamp\&quot; field (optional)
     * @param bootstrappedTimestampLte
     *            lte filter for the \&quot;bootstrapped_timestamp\&quot; field (optional)
     * @param bootstrappedTimestampGte
     *            gte filter for the \&quot;bootstrapped_timestamp\&quot; field (optional)
     * @param caIdEq
     *            eq filter for the \&quot;ca_id\&quot; field (optional)
     * @param caIdNeq
     *            neq filter for the \&quot;ca_id\&quot; field (optional)
     * @param caIdIn
     *            in filter for the \&quot;ca_id\&quot; field (optional)
     * @param caIdNin
     *            nin filter for the \&quot;ca_id\&quot; field (optional)
     * @param connectorExpirationDateIn
     *            in filter for the \&quot;connector_expiration_date\&quot; field (optional)
     * @param connectorExpirationDateNin
     *            nin filter for the \&quot;connector_expiration_date\&quot; field (optional)
     * @param connectorExpirationDateLte
     *            lte filter for the \&quot;connector_expiration_date\&quot; field (optional)
     * @param connectorExpirationDateGte
     *            gte filter for the \&quot;connector_expiration_date\&quot; field (optional)
     * @param createdAtIn
     *            in filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtNin
     *            nin filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtLte
     *            lte filter for the \&quot;created_at\&quot; field (optional)
     * @param createdAtGte
     *            gte filter for the \&quot;created_at\&quot; field (optional)
     * @param deployedStateEq
     *            eq filter for the \&quot;deployed_state\&quot; field (optional)
     * @param deployedStateNeq
     *            neq filter for the \&quot;deployed_state\&quot; field (optional)
     * @param deployedStateIn
     *            in filter for the \&quot;deployed_state\&quot; field (optional)
     * @param deployedStateNin
     *            nin filter for the \&quot;deployed_state\&quot; field (optional)
     * @param deploymentEq
     *            eq filter for the \&quot;deployment\&quot; field (optional)
     * @param deploymentNeq
     *            neq filter for the \&quot;deployment\&quot; field (optional)
     * @param deploymentIn
     *            in filter for the \&quot;deployment\&quot; field (optional)
     * @param deploymentNin
     *            nin filter for the \&quot;deployment\&quot; field (optional)
     * @param descriptionEq
     *            eq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNeq
     *            neq filter for the \&quot;description\&quot; field (optional)
     * @param descriptionIn
     *            in filter for the \&quot;description\&quot; field (optional)
     * @param descriptionNin
     *            nin filter for the \&quot;description\&quot; field (optional)
     * @param deviceClassEq
     *            eq filter for the \&quot;device_class\&quot; field (optional)
     * @param deviceClassNeq
     *            neq filter for the \&quot;device_class\&quot; field (optional)
     * @param deviceClassIn
     *            in filter for the \&quot;device_class\&quot; field (optional)
     * @param deviceClassNin
     *            nin filter for the \&quot;device_class\&quot; field (optional)
     * @param deviceExecutionModeEq
     *            eq filter for the \&quot;device_execution_mode\&quot; field (optional)
     * @param deviceExecutionModeNeq
     *            neq filter for the \&quot;device_execution_mode\&quot; field (optional)
     * @param deviceExecutionModeIn
     *            in filter for the \&quot;device_execution_mode\&quot; field (optional)
     * @param deviceExecutionModeNin
     *            nin filter for the \&quot;device_execution_mode\&quot; field (optional)
     * @param deviceKeyEq
     *            eq filter for the \&quot;device_key\&quot; field (optional)
     * @param deviceKeyNeq
     *            neq filter for the \&quot;device_key\&quot; field (optional)
     * @param deviceKeyIn
     *            in filter for the \&quot;device_key\&quot; field (optional)
     * @param deviceKeyNin
     *            nin filter for the \&quot;device_key\&quot; field (optional)
     * @param endpointNameEq
     *            eq filter for the \&quot;endpoint_name\&quot; field (optional)
     * @param endpointNameNeq
     *            neq filter for the \&quot;endpoint_name\&quot; field (optional)
     * @param endpointNameIn
     *            in filter for the \&quot;endpoint_name\&quot; field (optional)
     * @param endpointNameNin
     *            nin filter for the \&quot;endpoint_name\&quot; field (optional)
     * @param endpointTypeEq
     *            eq filter for the \&quot;endpoint_type\&quot; field (optional)
     * @param endpointTypeNeq
     *            neq filter for the \&quot;endpoint_type\&quot; field (optional)
     * @param endpointTypeIn
     *            in filter for the \&quot;endpoint_type\&quot; field (optional)
     * @param endpointTypeNin
     *            nin filter for the \&quot;endpoint_type\&quot; field (optional)
     * @param enrolmentListTimestampIn
     *            in filter for the \&quot;enrolment_list_timestamp\&quot; field (optional)
     * @param enrolmentListTimestampNin
     *            nin filter for the \&quot;enrolment_list_timestamp\&quot; field (optional)
     * @param enrolmentListTimestampLte
     *            lte filter for the \&quot;enrolment_list_timestamp\&quot; field (optional)
     * @param enrolmentListTimestampGte
     *            gte filter for the \&quot;enrolment_list_timestamp\&quot; field (optional)
     * @param firmwareChecksumEq
     *            eq filter for the \&quot;firmware_checksum\&quot; field (optional)
     * @param firmwareChecksumNeq
     *            neq filter for the \&quot;firmware_checksum\&quot; field (optional)
     * @param firmwareChecksumIn
     *            in filter for the \&quot;firmware_checksum\&quot; field (optional)
     * @param firmwareChecksumNin
     *            nin filter for the \&quot;firmware_checksum\&quot; field (optional)
     * @param hostGatewayEq
     *            eq filter for the \&quot;host_gateway\&quot; field (optional)
     * @param hostGatewayNeq
     *            neq filter for the \&quot;host_gateway\&quot; field (optional)
     * @param hostGatewayIn
     *            in filter for the \&quot;host_gateway\&quot; field (optional)
     * @param hostGatewayNin
     *            nin filter for the \&quot;host_gateway\&quot; field (optional)
     * @param idEq
     *            eq filter for the \&quot;id\&quot; field (optional)
     * @param idNeq
     *            neq filter for the \&quot;id\&quot; field (optional)
     * @param idIn
     *            in filter for the \&quot;id\&quot; field (optional)
     * @param idNin
     *            nin filter for the \&quot;id\&quot; field (optional)
     * @param manifestEq
     *            eq filter for the \&quot;manifest\&quot; field (optional)
     * @param manifestNeq
     *            neq filter for the \&quot;manifest\&quot; field (optional)
     * @param manifestIn
     *            in filter for the \&quot;manifest\&quot; field (optional)
     * @param manifestNin
     *            nin filter for the \&quot;manifest\&quot; field (optional)
     * @param manifestTimestampIn
     *            in filter for the \&quot;manifest_timestamp\&quot; field (optional)
     * @param manifestTimestampNin
     *            nin filter for the \&quot;manifest_timestamp\&quot; field (optional)
     * @param manifestTimestampLte
     *            lte filter for the \&quot;manifest_timestamp\&quot; field (optional)
     * @param manifestTimestampGte
     *            gte filter for the \&quot;manifest_timestamp\&quot; field (optional)
     * @param mechanismEq
     *            eq filter for the \&quot;mechanism\&quot; field (optional)
     * @param mechanismNeq
     *            neq filter for the \&quot;mechanism\&quot; field (optional)
     * @param mechanismIn
     *            in filter for the \&quot;mechanism\&quot; field (optional)
     * @param mechanismNin
     *            nin filter for the \&quot;mechanism\&quot; field (optional)
     * @param mechanismUrlEq
     *            eq filter for the \&quot;mechanism_url\&quot; field (optional)
     * @param mechanismUrlNeq
     *            neq filter for the \&quot;mechanism_url\&quot; field (optional)
     * @param mechanismUrlIn
     *            in filter for the \&quot;mechanism_url\&quot; field (optional)
     * @param mechanismUrlNin
     *            nin filter for the \&quot;mechanism_url\&quot; field (optional)
     * @param nameEq
     *            eq filter for the \&quot;name\&quot; field (optional)
     * @param nameNeq
     *            neq filter for the \&quot;name\&quot; field (optional)
     * @param nameIn
     *            in filter for the \&quot;name\&quot; field (optional)
     * @param nameNin
     *            nin filter for the \&quot;name\&quot; field (optional)
     * @param serialNumberEq
     *            eq filter for the \&quot;serial_number\&quot; field (optional)
     * @param serialNumberNeq
     *            neq filter for the \&quot;serial_number\&quot; field (optional)
     * @param serialNumberIn
     *            in filter for the \&quot;serial_number\&quot; field (optional)
     * @param serialNumberNin
     *            nin filter for the \&quot;serial_number\&quot; field (optional)
     * @param stateEq
     *            eq filter for the \&quot;state\&quot; field (optional)
     * @param stateNeq
     *            neq filter for the \&quot;state\&quot; field (optional)
     * @param stateIn
     *            in filter for the \&quot;state\&quot; field (optional)
     * @param stateNin
     *            nin filter for the \&quot;state\&quot; field (optional)
     * @param updatedAtIn
     *            in filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtNin
     *            nin filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtLte
     *            lte filter for the \&quot;updated_at\&quot; field (optional)
     * @param updatedAtGte
     *            gte filter for the \&quot;updated_at\&quot; field (optional)
     * @param vendorIdEq
     *            eq filter for the \&quot;vendor_id\&quot; field (optional)
     * @param vendorIdNeq
     *            neq filter for the \&quot;vendor_id\&quot; field (optional)
     * @param vendorIdIn
     *            in filter for the \&quot;vendor_id\&quot; field (optional)
     * @param vendorIdNin
     *            nin filter for the \&quot;vendor_id\&quot; field (optional)
     * @return Call&lt;DevicePage&gt;
     */
    @GET("v3/device-groups/{device-group-id}/devices/")
    Call<DevicePage>
        groupMembersRetrieve(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                             @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                             @retrofit2.http.Query("after") String after,
                             @retrofit2.http.Query("include") String include,
                             @retrofit2.http.Query("lifecycle_status__eq") String lifecycleStatusEq,
                             @retrofit2.http.Query("lifecycle_status__neq") String lifecycleStatusNeq,
                             @retrofit2.http.Query("lifecycle_status__in") String lifecycleStatusIn,
                             @retrofit2.http.Query("lifecycle_status__nin") String lifecycleStatusNin,
                             @retrofit2.http.Query("operator_suspended__eq") Boolean operatorSuspendedEq,
                             @retrofit2.http.Query("operator_suspended__neq") Boolean operatorSuspendedNeq,
                             @retrofit2.http.Query("last_operator_suspended_category__eq") String lastOperatorSuspendedCategoryEq,
                             @retrofit2.http.Query("last_operator_suspended_category__neq") String lastOperatorSuspendedCategoryNeq,
                             @retrofit2.http.Query("last_operator_suspended_category__in") String lastOperatorSuspendedCategoryIn,
                             @retrofit2.http.Query("last_operator_suspended_category__nin") String lastOperatorSuspendedCategoryNin,
                             @retrofit2.http.Query("last_operator_suspended_updated_at__in") String lastOperatorSuspendedUpdatedAtIn,
                             @retrofit2.http.Query("last_operator_suspended_updated_at__nin") String lastOperatorSuspendedUpdatedAtNin,
                             @retrofit2.http.Query("last_operator_suspended_updated_at__lte") DateTime lastOperatorSuspendedUpdatedAtLte,
                             @retrofit2.http.Query("last_operator_suspended_updated_at__gte") DateTime lastOperatorSuspendedUpdatedAtGte,
                             @retrofit2.http.Query("system_suspended__eq") Boolean systemSuspendedEq,
                             @retrofit2.http.Query("system_suspended__neq") Boolean systemSuspendedNeq,
                             @retrofit2.http.Query("last_system_suspended_category__eq") String lastSystemSuspendedCategoryEq,
                             @retrofit2.http.Query("last_system_suspended_category__neq") String lastSystemSuspendedCategoryNeq,
                             @retrofit2.http.Query("last_system_suspended_category__in") String lastSystemSuspendedCategoryIn,
                             @retrofit2.http.Query("last_system_suspended_category__nin") String lastSystemSuspendedCategoryNin,
                             @retrofit2.http.Query("last_system_suspended_updated_at__in") String lastSystemSuspendedUpdatedAtIn,
                             @retrofit2.http.Query("last_system_suspended_updated_at__nin") String lastSystemSuspendedUpdatedAtNin,
                             @retrofit2.http.Query("last_system_suspended_updated_at__lte") DateTime lastSystemSuspendedUpdatedAtLte,
                             @retrofit2.http.Query("last_system_suspended_updated_at__gte") DateTime lastSystemSuspendedUpdatedAtGte,
                             @retrofit2.http.Query("account_id__eq") String accountIdEq,
                             @retrofit2.http.Query("account_id__neq") String accountIdNeq,
                             @retrofit2.http.Query("account_id__in") String accountIdIn,
                             @retrofit2.http.Query("account_id__nin") String accountIdNin,
                             @retrofit2.http.Query("auto_update__eq") Boolean autoUpdateEq,
                             @retrofit2.http.Query("auto_update__neq") Boolean autoUpdateNeq,
                             @retrofit2.http.Query("bootstrap_expiration_date__in") String bootstrapExpirationDateIn,
                             @retrofit2.http.Query("bootstrap_expiration_date__nin") String bootstrapExpirationDateNin,
                             @retrofit2.http.Query("bootstrap_expiration_date__lte") LocalDate bootstrapExpirationDateLte,
                             @retrofit2.http.Query("bootstrap_expiration_date__gte") LocalDate bootstrapExpirationDateGte,
                             @retrofit2.http.Query("bootstrapped_timestamp__in") String bootstrappedTimestampIn,
                             @retrofit2.http.Query("bootstrapped_timestamp__nin") String bootstrappedTimestampNin,
                             @retrofit2.http.Query("bootstrapped_timestamp__lte") DateTime bootstrappedTimestampLte,
                             @retrofit2.http.Query("bootstrapped_timestamp__gte") DateTime bootstrappedTimestampGte,
                             @retrofit2.http.Query("ca_id__eq") String caIdEq,
                             @retrofit2.http.Query("ca_id__neq") String caIdNeq,
                             @retrofit2.http.Query("ca_id__in") String caIdIn,
                             @retrofit2.http.Query("ca_id__nin") String caIdNin,
                             @retrofit2.http.Query("connector_expiration_date__in") String connectorExpirationDateIn,
                             @retrofit2.http.Query("connector_expiration_date__nin") String connectorExpirationDateNin,
                             @retrofit2.http.Query("connector_expiration_date__lte") LocalDate connectorExpirationDateLte,
                             @retrofit2.http.Query("connector_expiration_date__gte") LocalDate connectorExpirationDateGte,
                             @retrofit2.http.Query("created_at__in") String createdAtIn,
                             @retrofit2.http.Query("created_at__nin") String createdAtNin,
                             @retrofit2.http.Query("created_at__lte") DateTime createdAtLte,
                             @retrofit2.http.Query("created_at__gte") DateTime createdAtGte,
                             @retrofit2.http.Query("deployed_state__eq") String deployedStateEq,
                             @retrofit2.http.Query("deployed_state__neq") String deployedStateNeq,
                             @retrofit2.http.Query("deployed_state__in") String deployedStateIn,
                             @retrofit2.http.Query("deployed_state__nin") String deployedStateNin,
                             @retrofit2.http.Query("deployment__eq") String deploymentEq,
                             @retrofit2.http.Query("deployment__neq") String deploymentNeq,
                             @retrofit2.http.Query("deployment__in") String deploymentIn,
                             @retrofit2.http.Query("deployment__nin") String deploymentNin,
                             @retrofit2.http.Query("description__eq") String descriptionEq,
                             @retrofit2.http.Query("description__neq") String descriptionNeq,
                             @retrofit2.http.Query("description__in") String descriptionIn,
                             @retrofit2.http.Query("description__nin") String descriptionNin,
                             @retrofit2.http.Query("device_class__eq") String deviceClassEq,
                             @retrofit2.http.Query("device_class__neq") String deviceClassNeq,
                             @retrofit2.http.Query("device_class__in") String deviceClassIn,
                             @retrofit2.http.Query("device_class__nin") String deviceClassNin,
                             @retrofit2.http.Query("device_execution_mode__eq") Integer deviceExecutionModeEq,
                             @retrofit2.http.Query("device_execution_mode__neq") Integer deviceExecutionModeNeq,
                             @retrofit2.http.Query("device_execution_mode__in") String deviceExecutionModeIn,
                             @retrofit2.http.Query("device_execution_mode__nin") String deviceExecutionModeNin,
                             @retrofit2.http.Query("device_key__eq") String deviceKeyEq,
                             @retrofit2.http.Query("device_key__neq") String deviceKeyNeq,
                             @retrofit2.http.Query("device_key__in") String deviceKeyIn,
                             @retrofit2.http.Query("device_key__nin") String deviceKeyNin,
                             @retrofit2.http.Query("endpoint_name__eq") String endpointNameEq,
                             @retrofit2.http.Query("endpoint_name__neq") String endpointNameNeq,
                             @retrofit2.http.Query("endpoint_name__in") String endpointNameIn,
                             @retrofit2.http.Query("endpoint_name__nin") String endpointNameNin,
                             @retrofit2.http.Query("endpoint_type__eq") String endpointTypeEq,
                             @retrofit2.http.Query("endpoint_type__neq") String endpointTypeNeq,
                             @retrofit2.http.Query("endpoint_type__in") String endpointTypeIn,
                             @retrofit2.http.Query("endpoint_type__nin") String endpointTypeNin,
                             @retrofit2.http.Query("enrolment_list_timestamp__in") String enrolmentListTimestampIn,
                             @retrofit2.http.Query("enrolment_list_timestamp__nin") String enrolmentListTimestampNin,
                             @retrofit2.http.Query("enrolment_list_timestamp__lte") DateTime enrolmentListTimestampLte,
                             @retrofit2.http.Query("enrolment_list_timestamp__gte") DateTime enrolmentListTimestampGte,
                             @retrofit2.http.Query("firmware_checksum__eq") String firmwareChecksumEq,
                             @retrofit2.http.Query("firmware_checksum__neq") String firmwareChecksumNeq,
                             @retrofit2.http.Query("firmware_checksum__in") String firmwareChecksumIn,
                             @retrofit2.http.Query("firmware_checksum__nin") String firmwareChecksumNin,
                             @retrofit2.http.Query("host_gateway__eq") String hostGatewayEq,
                             @retrofit2.http.Query("host_gateway__neq") String hostGatewayNeq,
                             @retrofit2.http.Query("host_gateway__in") String hostGatewayIn,
                             @retrofit2.http.Query("host_gateway__nin") String hostGatewayNin,
                             @retrofit2.http.Query("id__eq") String idEq, @retrofit2.http.Query("id__neq") String idNeq,
                             @retrofit2.http.Query("id__in") String idIn, @retrofit2.http.Query("id__nin") String idNin,
                             @retrofit2.http.Query("manifest__eq") String manifestEq,
                             @retrofit2.http.Query("manifest__neq") String manifestNeq,
                             @retrofit2.http.Query("manifest__in") String manifestIn,
                             @retrofit2.http.Query("manifest__nin") String manifestNin,
                             @retrofit2.http.Query("manifest_timestamp__in") String manifestTimestampIn,
                             @retrofit2.http.Query("manifest_timestamp__nin") String manifestTimestampNin,
                             @retrofit2.http.Query("manifest_timestamp__lte") DateTime manifestTimestampLte,
                             @retrofit2.http.Query("manifest_timestamp__gte") DateTime manifestTimestampGte,
                             @retrofit2.http.Query("mechanism__eq") String mechanismEq,
                             @retrofit2.http.Query("mechanism__neq") String mechanismNeq,
                             @retrofit2.http.Query("mechanism__in") String mechanismIn,
                             @retrofit2.http.Query("mechanism__nin") String mechanismNin,
                             @retrofit2.http.Query("mechanism_url__eq") String mechanismUrlEq,
                             @retrofit2.http.Query("mechanism_url__neq") String mechanismUrlNeq,
                             @retrofit2.http.Query("mechanism_url__in") String mechanismUrlIn,
                             @retrofit2.http.Query("mechanism_url__nin") String mechanismUrlNin,
                             @retrofit2.http.Query("name__eq") String nameEq,
                             @retrofit2.http.Query("name__neq") String nameNeq,
                             @retrofit2.http.Query("name__in") String nameIn,
                             @retrofit2.http.Query("name__nin") String nameNin,
                             @retrofit2.http.Query("serial_number__eq") String serialNumberEq,
                             @retrofit2.http.Query("serial_number__neq") String serialNumberNeq,
                             @retrofit2.http.Query("serial_number__in") String serialNumberIn,
                             @retrofit2.http.Query("serial_number__nin") String serialNumberNin,
                             @retrofit2.http.Query("state__eq") String stateEq,
                             @retrofit2.http.Query("state__neq") String stateNeq,
                             @retrofit2.http.Query("state__in") String stateIn,
                             @retrofit2.http.Query("state__nin") String stateNin,
                             @retrofit2.http.Query("updated_at__in") String updatedAtIn,
                             @retrofit2.http.Query("updated_at__nin") String updatedAtNin,
                             @retrofit2.http.Query("updated_at__lte") DateTime updatedAtLte,
                             @retrofit2.http.Query("updated_at__gte") DateTime updatedAtGte,
                             @retrofit2.http.Query("vendor_id__eq") String vendorIdEq,
                             @retrofit2.http.Query("vendor_id__neq") String vendorIdNeq,
                             @retrofit2.http.Query("vendor_id__in") String vendorIdIn,
                             @retrofit2.http.Query("vendor_id__nin") String vendorIdNin);

    /**
     * Get a group. Get a group.
     * 
     * @param deviceGroupId
     *            The group ID (required)
     * @return Call&lt;DeviceGroup&gt;
     */
    @GET("v3/device-groups/{device-group-id}/")
    Call<DeviceGroup>
        groupRetrieve(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId);

    /**
     * Modify the attributes of a group. Modify the attributes of a group.
     * 
     * @param deviceGroupId
     *            (required)
     * @param group
     *            Group (required)
     * @return Call&lt;DeviceGroup&gt;
     */
    @PUT("v3/device-groups/{device-group-id}/")
    Call<DeviceGroup> groupUpdate(@retrofit2.http.Path(value = "device-group-id", encoded = true) String deviceGroupId,
                                  @retrofit2.http.Body Group1 group);

}
