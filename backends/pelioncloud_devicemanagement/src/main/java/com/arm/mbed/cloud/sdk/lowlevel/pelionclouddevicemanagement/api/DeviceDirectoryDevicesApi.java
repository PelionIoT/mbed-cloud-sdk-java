package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceData;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DevicePage;
import org.joda.time.LocalDate;

public interface DeviceDirectoryDevicesApi {
    /**
     * Create a device. Create a new device.
     * 
     * @param device
     *            (required)
     * @return Call&lt;DeviceData&gt;
     */
    @POST("v3/devices/")
    Call<DeviceData> deviceCreate(@retrofit2.http.Body DeviceDataPostRequest device);

    /**
     * Delete a device. Delete device. Only available for devices with a developer certificate. Attempting to delete a
     * device with a production certicate returns a 400 response.
     * 
     * @param id
     *            The ID of the device. (required)
     * @return Call&lt;Void&gt;
     */
    @DELETE("v3/devices/{id}/")
    Call<Void> deviceDestroy(@retrofit2.http.Path(value = "id", encoded = true) String id);

    /**
     * List all devices. List all devices. **Example:** Following example filters devices according to state field and
     * returns only devices in &#39;registered&#39; state: &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/devices?filter&#x3D;state%3Dregistered \\ -H &#39;Authorization: Bearer
     * &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
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
    @GET("v3/devices/")
    Call<DevicePage>
        deviceList(@retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("order") String order,
                   @retrofit2.http.Query("after") String after, @retrofit2.http.Query("include") String include,
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
                   @retrofit2.http.Query("ca_id__eq") String caIdEq, @retrofit2.http.Query("ca_id__neq") String caIdNeq,
                   @retrofit2.http.Query("ca_id__in") String caIdIn, @retrofit2.http.Query("ca_id__nin") String caIdNin,
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
                   @retrofit2.http.Query("name__eq") String nameEq, @retrofit2.http.Query("name__neq") String nameNeq,
                   @retrofit2.http.Query("name__in") String nameIn, @retrofit2.http.Query("name__nin") String nameNin,
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
     * Get a device. Retrieve information about a specific device. **Example:** Following example must be updated with
     * the device&#39;s ID to the URL. The id is from of \&quot;01667c6e992c00000000000100100370\&quot;
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_ID&gt; \\ -H
     * &#39;Authorization: Bearer &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @param id
     *            The ID of the device. (required)
     * @return Call&lt;DeviceData&gt;
     */
    @GET("v3/devices/{id}/")
    Call<DeviceData> deviceRetrieve(@retrofit2.http.Path(value = "id", encoded = true) String id);

    /**
     * Update a device. Update a specific device. **Example:** Following example will update the specific devices
     * description field to contain \&quot;Testing description field\&quot;. &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_ID&gt; \\ -H &#39;Authorization: Bearer &lt;API
     * key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;description\&quot;: \&quot;Testing
     * description field\&quot;}&#39; &#x60;&#x60;&#x60;
     * 
     * @param id
     *            The ID of the device. (required)
     * @param device
     *            (required)
     * @return Call&lt;DeviceData&gt;
     */
    @PUT("v3/devices/{id}/")
    Call<DeviceData> deviceUpdate(@retrofit2.http.Path(value = "id", encoded = true) String id,
                                  @retrofit2.http.Body DeviceDataPutRequest device);

}
