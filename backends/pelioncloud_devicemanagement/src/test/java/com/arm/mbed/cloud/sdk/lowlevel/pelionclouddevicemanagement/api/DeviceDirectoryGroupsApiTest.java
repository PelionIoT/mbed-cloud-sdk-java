package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroupManipulation;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group1;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceDirectoryGroupsApi
 */
public class DeviceDirectoryGroupsApiTest {

    private DeviceDirectoryGroupsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceDirectoryGroupsApi.class);
    }

    /**
     * Create a group.
     *
     * Create a group.
     */
    @Test
    public void groupCreateTest() {
        Group group = null;
        // DeviceGroup response = api.groupCreate(group);

        // TODO: test validations
    }

    /**
     * Delete a group.
     *
     * Delete a group.
     */
    @Test
    public void groupDeleteTest() {
        String deviceGroupId = null;
        // Void response = api.groupDelete(deviceGroupId);

        // TODO: test validations
    }

    /**
     * List all groups.
     *
     * List all groups.
     */
    @Test
    public void groupListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        Integer devicesCountEq = null;
        Integer devicesCountNeq = null;
        String devicesCountIn = null;
        String devicesCountNin = null;
        Integer devicesCountLte = null;
        Integer devicesCountGte = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // DeviceGroupPage response = api.groupList(limit, order, after, include, filter, idEq, idNeq, idIn, idNin,
        // devicesCountEq, devicesCountNeq, devicesCountIn, devicesCountNin, devicesCountLte, devicesCountGte, nameEq,
        // nameNeq, nameIn, nameNin, createdAtIn, createdAtNin, createdAtLte, createdAtGte, updatedAtIn, updatedAtNin,
        // updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Add a device to a group.
     *
     * Add one device to a group.
     */
    @Test
    public void groupMembersAddTest() {
        String deviceGroupId = null;
        DeviceGroupManipulation body = null;
        // Void response = api.groupMembersAdd(deviceGroupId, body);

        // TODO: test validations
    }

    /**
     * Remove a device from a group.
     *
     * Remove one device from a group.
     */
    @Test
    public void groupMembersRemoveTest() {
        String deviceGroupId = null;
        DeviceGroupManipulation body = null;
        // Void response = api.groupMembersRemove(deviceGroupId, body);

        // TODO: test validations
    }

    /**
     * Get a page of devices.
     *
     * Get a page of devices.
     */
    @Test
    public void groupMembersRetrieveTest() {
        String deviceGroupId = null;
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
        // DevicePage response = api.groupMembersRetrieve(deviceGroupId, limit, order, after, include,
        // lifecycleStatusEq, lifecycleStatusNeq, lifecycleStatusIn, lifecycleStatusNin, operatorSuspendedEq,
        // operatorSuspendedNeq, lastOperatorSuspendedCategoryEq, lastOperatorSuspendedCategoryNeq,
        // lastOperatorSuspendedCategoryIn, lastOperatorSuspendedCategoryNin, lastOperatorSuspendedUpdatedAtIn,
        // lastOperatorSuspendedUpdatedAtNin, lastOperatorSuspendedUpdatedAtLte, lastOperatorSuspendedUpdatedAtGte,
        // systemSuspendedEq, systemSuspendedNeq, lastSystemSuspendedCategoryEq, lastSystemSuspendedCategoryNeq,
        // lastSystemSuspendedCategoryIn, lastSystemSuspendedCategoryNin, lastSystemSuspendedUpdatedAtIn,
        // lastSystemSuspendedUpdatedAtNin, lastSystemSuspendedUpdatedAtLte, lastSystemSuspendedUpdatedAtGte,
        // accountIdEq, accountIdNeq, accountIdIn, accountIdNin, autoUpdateEq, autoUpdateNeq, bootstrapExpirationDateIn,
        // bootstrapExpirationDateNin, bootstrapExpirationDateLte, bootstrapExpirationDateGte, bootstrappedTimestampIn,
        // bootstrappedTimestampNin, bootstrappedTimestampLte, bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn,
        // caIdNin, connectorExpirationDateIn, connectorExpirationDateNin, connectorExpirationDateLte,
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
     * Get a group.
     *
     * Get a group.
     */
    @Test
    public void groupRetrieveTest() {
        String deviceGroupId = null;
        // DeviceGroup response = api.groupRetrieve(deviceGroupId);

        // TODO: test validations
    }

    /**
     * Modify the attributes of a group.
     *
     * Modify the attributes of a group.
     */
    @Test
    public void groupUpdateTest() {
        String deviceGroupId = null;
        Group1 group = null;
        // DeviceGroup response = api.groupUpdate(deviceGroupId, group);

        // TODO: test validations
    }
}
