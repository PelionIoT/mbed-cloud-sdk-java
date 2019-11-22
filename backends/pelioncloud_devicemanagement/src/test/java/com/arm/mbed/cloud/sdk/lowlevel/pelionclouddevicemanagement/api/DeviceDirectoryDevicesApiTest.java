package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPutRequest;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceDirectoryDevicesApi
 */
public class DeviceDirectoryDevicesApiTest {

    private DeviceDirectoryDevicesApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceDirectoryDevicesApi.class);
    }

    /**
     * Create a device.
     *
     * Create a new device.
     */
    @Test
    public void deviceCreateTest() {
        DeviceDataPostRequest device = null;
        // DeviceData response = api.deviceCreate(device);

        // TODO: test validations
    }

    /**
     * Delete a device.
     *
     * Delete device. Only available for devices with a developer certificate. Attempting to delete a device with a
     * production certicate returns a 400 response.
     */
    @Test
    public void deviceDestroyTest() {
        String id = null;
        // Void response = api.deviceDestroy(id);

        // TODO: test validations
    }

    /**
     * List all devices.
     *
     * List all devices. **Example:** Following example filters devices according to state field and returns only
     * devices in &#39;registered&#39; state: &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/devices?filter&#x3D;state%3Dregistered \\ -H &#39;Authorization: Bearer
     * &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deviceListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String lifecycleStatusEq = null;
        String lifecycleStatusNeq = null;
        String lifecycleStatusIn = null;
        String lifecycleStatusNin = null;
        Boolean operatorSuspendedEq = null;
        Boolean operatorSuspendedNeq = null;
        String lastOperatorSuspendedCategoryEq = null;
        String lastOperatorSuspendedCategoryNeq = null;
        String lastOperatorSuspendedCategoryIn = null;
        String lastOperatorSuspendedCategoryNin = null;
        String lastOperatorSuspendedUpdatedAtIn = null;
        String lastOperatorSuspendedUpdatedAtNin = null;
        DateTime lastOperatorSuspendedUpdatedAtLte = null;
        DateTime lastOperatorSuspendedUpdatedAtGte = null;
        Boolean systemSuspendedEq = null;
        Boolean systemSuspendedNeq = null;
        String lastSystemSuspendedCategoryEq = null;
        String lastSystemSuspendedCategoryNeq = null;
        String lastSystemSuspendedCategoryIn = null;
        String lastSystemSuspendedCategoryNin = null;
        String lastSystemSuspendedUpdatedAtIn = null;
        String lastSystemSuspendedUpdatedAtNin = null;
        DateTime lastSystemSuspendedUpdatedAtLte = null;
        DateTime lastSystemSuspendedUpdatedAtGte = null;
        String accountIdEq = null;
        String accountIdNeq = null;
        String accountIdIn = null;
        String accountIdNin = null;
        Boolean autoUpdateEq = null;
        Boolean autoUpdateNeq = null;
        String bootstrapExpirationDateIn = null;
        String bootstrapExpirationDateNin = null;
        LocalDate bootstrapExpirationDateLte = null;
        LocalDate bootstrapExpirationDateGte = null;
        String bootstrappedTimestampIn = null;
        String bootstrappedTimestampNin = null;
        DateTime bootstrappedTimestampLte = null;
        DateTime bootstrappedTimestampGte = null;
        String caIdEq = null;
        String caIdNeq = null;
        String caIdIn = null;
        String caIdNin = null;
        String connectorExpirationDateIn = null;
        String connectorExpirationDateNin = null;
        LocalDate connectorExpirationDateLte = null;
        LocalDate connectorExpirationDateGte = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String deployedStateEq = null;
        String deployedStateNeq = null;
        String deployedStateIn = null;
        String deployedStateNin = null;
        String deploymentEq = null;
        String deploymentNeq = null;
        String deploymentIn = null;
        String deploymentNin = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String deviceClassEq = null;
        String deviceClassNeq = null;
        String deviceClassIn = null;
        String deviceClassNin = null;
        Integer deviceExecutionModeEq = null;
        Integer deviceExecutionModeNeq = null;
        String deviceExecutionModeIn = null;
        String deviceExecutionModeNin = null;
        String deviceKeyEq = null;
        String deviceKeyNeq = null;
        String deviceKeyIn = null;
        String deviceKeyNin = null;
        String endpointNameEq = null;
        String endpointNameNeq = null;
        String endpointNameIn = null;
        String endpointNameNin = null;
        String endpointTypeEq = null;
        String endpointTypeNeq = null;
        String endpointTypeIn = null;
        String endpointTypeNin = null;
        String enrolmentListTimestampIn = null;
        String enrolmentListTimestampNin = null;
        DateTime enrolmentListTimestampLte = null;
        DateTime enrolmentListTimestampGte = null;
        String firmwareChecksumEq = null;
        String firmwareChecksumNeq = null;
        String firmwareChecksumIn = null;
        String firmwareChecksumNin = null;
        String hostGatewayEq = null;
        String hostGatewayNeq = null;
        String hostGatewayIn = null;
        String hostGatewayNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String manifestEq = null;
        String manifestNeq = null;
        String manifestIn = null;
        String manifestNin = null;
        String manifestTimestampIn = null;
        String manifestTimestampNin = null;
        DateTime manifestTimestampLte = null;
        DateTime manifestTimestampGte = null;
        String mechanismEq = null;
        String mechanismNeq = null;
        String mechanismIn = null;
        String mechanismNin = null;
        String mechanismUrlEq = null;
        String mechanismUrlNeq = null;
        String mechanismUrlIn = null;
        String mechanismUrlNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String serialNumberEq = null;
        String serialNumberNeq = null;
        String serialNumberIn = null;
        String serialNumberNin = null;
        String stateEq = null;
        String stateNeq = null;
        String stateIn = null;
        String stateNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        String vendorIdEq = null;
        String vendorIdNeq = null;
        String vendorIdIn = null;
        String vendorIdNin = null;
        // DevicePage response = api.deviceList(limit, order, after, include, lifecycleStatusEq, lifecycleStatusNeq,
        // lifecycleStatusIn, lifecycleStatusNin, operatorSuspendedEq, operatorSuspendedNeq,
        // lastOperatorSuspendedCategoryEq, lastOperatorSuspendedCategoryNeq, lastOperatorSuspendedCategoryIn,
        // lastOperatorSuspendedCategoryNin, lastOperatorSuspendedUpdatedAtIn, lastOperatorSuspendedUpdatedAtNin,
        // lastOperatorSuspendedUpdatedAtLte, lastOperatorSuspendedUpdatedAtGte, systemSuspendedEq, systemSuspendedNeq,
        // lastSystemSuspendedCategoryEq, lastSystemSuspendedCategoryNeq, lastSystemSuspendedCategoryIn,
        // lastSystemSuspendedCategoryNin, lastSystemSuspendedUpdatedAtIn, lastSystemSuspendedUpdatedAtNin,
        // lastSystemSuspendedUpdatedAtLte, lastSystemSuspendedUpdatedAtGte, accountIdEq, accountIdNeq, accountIdIn,
        // accountIdNin, autoUpdateEq, autoUpdateNeq, bootstrapExpirationDateIn, bootstrapExpirationDateNin,
        // bootstrapExpirationDateLte, bootstrapExpirationDateGte, bootstrappedTimestampIn, bootstrappedTimestampNin,
        // bootstrappedTimestampLte, bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn, caIdNin,
        // connectorExpirationDateIn, connectorExpirationDateNin, connectorExpirationDateLte,
        // connectorExpirationDateGte, createdAtIn, createdAtNin, createdAtLte, createdAtGte, deployedStateEq,
        // deployedStateNeq, deployedStateIn, deployedStateNin, deploymentEq, deploymentNeq, deploymentIn,
        // deploymentNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq,
        // deviceClassIn, deviceClassNin, deviceExecutionModeEq, deviceExecutionModeNeq, deviceExecutionModeIn,
        // deviceExecutionModeNin, deviceKeyEq, deviceKeyNeq, deviceKeyIn, deviceKeyNin, endpointNameEq,
        // endpointNameNeq, endpointNameIn, endpointNameNin, endpointTypeEq, endpointTypeNeq, endpointTypeIn,
        // endpointTypeNin, enrolmentListTimestampIn, enrolmentListTimestampNin, enrolmentListTimestampLte,
        // enrolmentListTimestampGte, firmwareChecksumEq, firmwareChecksumNeq, firmwareChecksumIn, firmwareChecksumNin,
        // hostGatewayEq, hostGatewayNeq, hostGatewayIn, hostGatewayNin, idEq, idNeq, idIn, idNin, manifestEq,
        // manifestNeq, manifestIn, manifestNin, manifestTimestampIn, manifestTimestampNin, manifestTimestampLte,
        // manifestTimestampGte, mechanismEq, mechanismNeq, mechanismIn, mechanismNin, mechanismUrlEq, mechanismUrlNeq,
        // mechanismUrlIn, mechanismUrlNin, nameEq, nameNeq, nameIn, nameNin, serialNumberEq, serialNumberNeq,
        // serialNumberIn, serialNumberNin, stateEq, stateNeq, stateIn, stateNin, updatedAtIn, updatedAtNin,
        // updatedAtLte, updatedAtGte, vendorIdEq, vendorIdNeq, vendorIdIn, vendorIdNin);

        // TODO: test validations
    }

    /**
     * Get a device.
     *
     * Retrieve information about a specific device. **Example:** Following example must be updated with the
     * device&#39;s ID to the URL. The id is from of \&quot;01667c6e992c00000000000100100370\&quot; &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_ID&gt; \\ -H &#39;Authorization: Bearer
     * &lt;API key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deviceRetrieveTest() {
        String id = null;
        // DeviceData response = api.deviceRetrieve(id);

        // TODO: test validations
    }

    /**
     * Update a device.
     *
     * Update a specific device. **Example:** Following example will update the specific devices description field to
     * contain \&quot;Testing description field\&quot;. &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/devices/&lt;device_ID&gt; \\ -H &#39;Authorization: Bearer &lt;API
     * key&gt;&#39; \\ -H &#39;content-type: application/json&#39; \\ -d &#39;{\&quot;description\&quot;: \&quot;Testing
     * description field\&quot;}&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void deviceUpdateTest() {
        String id = null;
        DeviceDataPutRequest device = null;
        // DeviceData response = api.deviceUpdate(id, device);

        // TODO: test validations
    }
}
