package com.arm.mbed.cloud.sdk.internal.devicedirectory.api;

import com.arm.mbed.cloud.sdk.internal.devicedirectory.ApiClient;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DevicePage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPostPutRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DefaultApi.class);
    }

    /**
     * Create a device
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
     * Delete device. Only available for devices with a developer certificate. Attempts to delete a device with a production certicate will return a 400 response.
     */
    @Test
    public void deviceDestroyTest() {
        String id = null;
        // Void response = api.deviceDestroy(id);

        // TODO: test validations
    }
    /**
     * List all device events.
     *
     * List all device events for an account.
     */
    @Test
    public void deviceEventListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String dateTimeEq = null;
        String dateTimeNeq = null;
        String dateTimeIn = null;
        String dateTimeNin = null;
        String dateTimeLte = null;
        String dateTimeGte = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String deviceIdEq = null;
        String deviceIdNeq = null;
        String deviceIdIn = null;
        String deviceIdNin = null;
        String eventTypeEq = null;
        String eventTypeNeq = null;
        String eventTypeIn = null;
        String eventTypeNin = null;
        String stateChangeEq = null;
        String stateChangeNeq = null;
        String stateChangeIn = null;
        String stateChangeNin = null;
        String include = null;
        // DeviceEventPage response = api.deviceEventList(limit, order, after, dateTimeEq, dateTimeNeq, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin, include);

        // TODO: test validations
    }
    /**
     * Retrieve a device event.
     *
     * Retrieve a specific device event.
     */
    @Test
    public void deviceEventRetrieveTest() {
        String deviceEventId = null;
        // DeviceEventData response = api.deviceEventRetrieve(deviceEventId);

        // TODO: test validations
    }
    /**
     * List all devices.
     *
     * List all devices.
     */
    @Test
    public void deviceListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String accountIdEq = null;
        String accountIdNeq = null;
        String accountIdIn = null;
        String accountIdNin = null;
        String autoUpdateEq = null;
        String autoUpdateNeq = null;
        String autoUpdateIn = null;
        String autoUpdateNin = null;
        String bootstrapExpirationDateEq = null;
        String bootstrapExpirationDateNeq = null;
        String bootstrapExpirationDateIn = null;
        String bootstrapExpirationDateNin = null;
        String bootstrapExpirationDateLte = null;
        String bootstrapExpirationDateGte = null;
        String bootstrappedTimestampEq = null;
        String bootstrappedTimestampNeq = null;
        String bootstrappedTimestampIn = null;
        String bootstrappedTimestampNin = null;
        String bootstrappedTimestampLte = null;
        String bootstrappedTimestampGte = null;
        String caIdEq = null;
        String caIdNeq = null;
        String caIdIn = null;
        String caIdNin = null;
        String connectorExpirationDateEq = null;
        String connectorExpirationDateNeq = null;
        String connectorExpirationDateIn = null;
        String connectorExpirationDateNin = null;
        String connectorExpirationDateLte = null;
        String connectorExpirationDateGte = null;
        String createdAtEq = null;
        String createdAtNeq = null;
        String createdAtIn = null;
        String createdAtNin = null;
        String createdAtLte = null;
        String createdAtGte = null;
        String customAttributesEq = null;
        String customAttributesNeq = null;
        String customAttributesIn = null;
        String customAttributesNin = null;
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
        String deviceExecutionModeEq = null;
        String deviceExecutionModeNeq = null;
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
        String enrolmentListTimestampEq = null;
        String enrolmentListTimestampNeq = null;
        String enrolmentListTimestampIn = null;
        String enrolmentListTimestampNin = null;
        String enrolmentListTimestampLte = null;
        String enrolmentListTimestampGte = null;
        String etagEq = null;
        String etagNeq = null;
        String etagIn = null;
        String etagNin = null;
        String etagLte = null;
        String etagGte = null;
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
        String manifestTimestampEq = null;
        String manifestTimestampNeq = null;
        String manifestTimestampIn = null;
        String manifestTimestampNin = null;
        String manifestTimestampLte = null;
        String manifestTimestampGte = null;
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
        String updatedAtEq = null;
        String updatedAtNeq = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        String updatedAtLte = null;
        String updatedAtGte = null;
        String vendorIdEq = null;
        String vendorIdNeq = null;
        String vendorIdIn = null;
        String vendorIdNin = null;
        String include = null;
        // DevicePage response = api.deviceList(limit, order, after, accountIdEq, accountIdNeq, accountIdIn, accountIdNin, autoUpdateEq, autoUpdateNeq, autoUpdateIn, autoUpdateNin, bootstrapExpirationDateEq, bootstrapExpirationDateNeq, bootstrapExpirationDateIn, bootstrapExpirationDateNin, bootstrapExpirationDateLte, bootstrapExpirationDateGte, bootstrappedTimestampEq, bootstrappedTimestampNeq, bootstrappedTimestampIn, bootstrappedTimestampNin, bootstrappedTimestampLte, bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn, caIdNin, connectorExpirationDateEq, connectorExpirationDateNeq, connectorExpirationDateIn, connectorExpirationDateNin, connectorExpirationDateLte, connectorExpirationDateGte, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, customAttributesEq, customAttributesNeq, customAttributesIn, customAttributesNin, deployedStateEq, deployedStateNeq, deployedStateIn, deployedStateNin, deploymentEq, deploymentNeq, deploymentIn, deploymentNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, deviceExecutionModeEq, deviceExecutionModeNeq, deviceExecutionModeIn, deviceExecutionModeNin, deviceKeyEq, deviceKeyNeq, deviceKeyIn, deviceKeyNin, endpointNameEq, endpointNameNeq, endpointNameIn, endpointNameNin, endpointTypeEq, endpointTypeNeq, endpointTypeIn, endpointTypeNin, enrolmentListTimestampEq, enrolmentListTimestampNeq, enrolmentListTimestampIn, enrolmentListTimestampNin, enrolmentListTimestampLte, enrolmentListTimestampGte, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, firmwareChecksumEq, firmwareChecksumNeq, firmwareChecksumIn, firmwareChecksumNin, hostGatewayEq, hostGatewayNeq, hostGatewayIn, hostGatewayNin, idEq, idNeq, idIn, idNin, manifestEq, manifestNeq, manifestIn, manifestNin, manifestTimestampEq, manifestTimestampNeq, manifestTimestampIn, manifestTimestampNin, manifestTimestampLte, manifestTimestampGte, mechanismEq, mechanismNeq, mechanismIn, mechanismNin, mechanismUrlEq, mechanismUrlNeq, mechanismUrlIn, mechanismUrlNin, nameEq, nameNeq, nameIn, nameNin, serialNumberEq, serialNumberNeq, serialNumberIn, serialNumberNin, stateEq, stateNeq, stateIn, stateNin, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, vendorIdEq, vendorIdNeq, vendorIdIn, vendorIdNin, include);

        // TODO: test validations
    }
    /**
     * DEPRECATED: List all device events.
     *
     * DEPRECATED: List all device events. Use &#x60;/v3/device-events/&#x60; instead.
     */
    @Test
    public void deviceLogListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String dateTimeEq = null;
        String dateTimeNeq = null;
        String dateTimeIn = null;
        String dateTimeNin = null;
        String dateTimeLte = null;
        String dateTimeGte = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String deviceIdEq = null;
        String deviceIdNeq = null;
        String deviceIdIn = null;
        String deviceIdNin = null;
        String eventTypeEq = null;
        String eventTypeNeq = null;
        String eventTypeIn = null;
        String eventTypeNin = null;
        String stateChangeEq = null;
        String stateChangeNeq = null;
        String stateChangeIn = null;
        String stateChangeNin = null;
        String include = null;
        // DeviceEventPage response = api.deviceLogList(limit, order, after, dateTimeEq, dateTimeNeq, dateTimeIn, dateTimeNin, dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn, idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn, eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin, include);

        // TODO: test validations
    }
    /**
     * DEPRECATED: Retrieve a device event.
     *
     * Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/ instead)
     */
    @Test
    public void deviceLogRetrieveTest() {
        String deviceEventId = null;
        // DeviceEventData response = api.deviceLogRetrieve(deviceEventId);

        // TODO: test validations
    }
    /**
     * Create a device query
     *
     * Create a new device query.
     */
    @Test
    public void deviceQueryCreateTest() {
        DeviceQueryPostPutRequest device = null;
        // DeviceQuery response = api.deviceQueryCreate(device);

        // TODO: test validations
    }
    /**
     * Delete a device query
     *
     * Delete a device query.
     */
    @Test
    public void deviceQueryDestroyTest() {
        String queryId = null;
        // Void response = api.deviceQueryDestroy(queryId);

        // TODO: test validations
    }
    /**
     * List device queries.
     *
     * List all device queries. The result will be paged into pages of 100.
     */
    @Test
    public void deviceQueryListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String createdAtEq = null;
        String createdAtNeq = null;
        String createdAtIn = null;
        String createdAtNin = null;
        String createdAtLte = null;
        String createdAtGte = null;
        String etagEq = null;
        String etagNeq = null;
        String etagIn = null;
        String etagNin = null;
        String etagLte = null;
        String etagGte = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String idLte = null;
        String idGte = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String nameLte = null;
        String nameGte = null;
        String queryEq = null;
        String queryNeq = null;
        String queryIn = null;
        String queryNin = null;
        String queryLte = null;
        String queryGte = null;
        String updatedAtEq = null;
        String updatedAtNeq = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        String updatedAtLte = null;
        String updatedAtGte = null;
        String include = null;
        // DeviceQueryPage response = api.deviceQueryList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, idLte, idGte, nameEq, nameNeq, nameIn, nameNin, nameLte, nameGte, queryEq, queryNeq, queryIn, queryNin, queryLte, queryGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include);

        // TODO: test validations
    }
    /**
     * Retrieve a device query.
     *
     * Retrieve a specific device query.
     */
    @Test
    public void deviceQueryRetrieveTest() {
        String queryId = null;
        // DeviceQuery response = api.deviceQueryRetrieve(queryId);

        // TODO: test validations
    }
    /**
     * Update a device query
     *
     * Update a specifc device query.
     */
    @Test
    public void deviceQueryUpdateTest() {
        String queryId = null;
        DeviceQueryPostPutRequest body = null;
        // DeviceQuery response = api.deviceQueryUpdate(queryId, body);

        // TODO: test validations
    }
    /**
     * Get a devices
     *
     * Retrieve information about a specific device.
     */
    @Test
    public void deviceRetrieveTest() {
        String id = null;
        // DeviceData response = api.deviceRetrieve(id);

        // TODO: test validations
    }
    /**
     * Update a device
     *
     * Update a specific device.
     */
    @Test
    public void deviceUpdateTest() {
        String id = null;
        DeviceDataPutRequest device = null;
        // DeviceData response = api.deviceUpdate(id, device);

        // TODO: test validations
    }
}
