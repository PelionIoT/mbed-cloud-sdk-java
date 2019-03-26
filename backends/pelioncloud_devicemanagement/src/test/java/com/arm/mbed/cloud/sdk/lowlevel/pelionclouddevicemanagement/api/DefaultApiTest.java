package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroupManipulation;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQueryPostPutRequest;
import java.io.File;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group1;
import org.joda.time.LocalDate;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UploadJob1;
import org.junit.Before;
import org.junit.Test;

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
     * Delete device. Only available for devices with a developer certificate. Attempts to delete a device with a
     * production certicate will return a 400 response.
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
        String include = null;
        String filter = null;
        String dateTimeIn = null;
        String dateTimeNin = null;
        DateTime dateTimeLte = null;
        DateTime dateTimeGte = null;
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
        Boolean stateChangeEq = null;
        Boolean stateChangeNeq = null;
        String stateChangeIn = null;
        String stateChangeNin = null;
        // DeviceEventPage response = api.deviceEventList(limit, order, after, include, filter, dateTimeIn, dateTimeNin,
        // dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn,
        // idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn,
        // eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin);

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
        String include = null;
        String filter = null;
        String accountIdEq = null;
        String accountIdNeq = null;
        String accountIdIn = null;
        String accountIdNin = null;
        Boolean autoUpdateEq = null;
        Boolean autoUpdateNeq = null;
        String autoUpdateIn = null;
        String autoUpdateNin = null;
        String bootstrappedExpirationDateIn = null;
        String bootstrappedExpirationDateNin = null;
        String bootstrappedExpirationDateLte = null;
        String bootstrappedExpirationDateGte = null;
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
        String customAttributesEq = null;
        String customAttributesNeq = null;
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
        String enrollmentListTimestampIn = null;
        String enrollmentListTimestampNin = null;
        String enrollmentListTimestampLte = null;
        String enrollmentListTimestampGte = null;
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
        // DevicePage response = api.deviceList(limit, order, after, include, filter, accountIdEq, accountIdNeq,
        // accountIdIn, accountIdNin, autoUpdateEq, autoUpdateNeq, autoUpdateIn, autoUpdateNin,
        // bootstrappedExpirationDateIn, bootstrappedExpirationDateNin, bootstrappedExpirationDateLte,
        // bootstrappedExpirationDateGte, bootstrappedTimestampIn, bootstrappedTimestampNin, bootstrappedTimestampLte,
        // bootstrappedTimestampGte, caIdEq, caIdNeq, caIdIn, caIdNin, connectorExpirationDateIn,
        // connectorExpirationDateNin, connectorExpirationDateLte, connectorExpirationDateGte, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, customAttributesEq, customAttributesNeq, deployedStateEq,
        // deployedStateNeq, deployedStateIn, deployedStateNin, deploymentEq, deploymentNeq, deploymentIn,
        // deploymentNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq,
        // deviceClassIn, deviceClassNin, deviceExecutionModeEq, deviceExecutionModeNeq, deviceExecutionModeIn,
        // deviceExecutionModeNin, deviceKeyEq, deviceKeyNeq, deviceKeyIn, deviceKeyNin, endpointNameEq,
        // endpointNameNeq, endpointNameIn, endpointNameNin, endpointTypeEq, endpointTypeNeq, endpointTypeIn,
        // endpointTypeNin, enrollmentListTimestampIn, enrollmentListTimestampNin, enrollmentListTimestampLte,
        // enrollmentListTimestampGte, firmwareChecksumEq, firmwareChecksumNeq, firmwareChecksumIn, firmwareChecksumNin,
        // hostGatewayEq, hostGatewayNeq, hostGatewayIn, hostGatewayNin, idEq, idNeq, idIn, idNin, manifestEq,
        // manifestNeq, manifestIn, manifestNin, manifestTimestampIn, manifestTimestampNin, manifestTimestampLte,
        // manifestTimestampGte, mechanismEq, mechanismNeq, mechanismIn, mechanismNin, mechanismUrlEq, mechanismUrlNeq,
        // mechanismUrlIn, mechanismUrlNin, nameEq, nameNeq, nameIn, nameNin, serialNumberEq, serialNumberNeq,
        // serialNumberIn, serialNumberNin, stateEq, stateNeq, stateIn, stateNin, updatedAtIn, updatedAtNin,
        // updatedAtLte, updatedAtGte, vendorIdEq, vendorIdNeq, vendorIdIn, vendorIdNin);

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
        String include = null;
        String filter = null;
        String dateTimeIn = null;
        String dateTimeNin = null;
        DateTime dateTimeLte = null;
        DateTime dateTimeGte = null;
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
        Boolean stateChangeEq = null;
        Boolean stateChangeNeq = null;
        String stateChangeIn = null;
        String stateChangeNin = null;
        // DeviceEventPage response = api.deviceLogList(limit, order, after, include, filter, dateTimeIn, dateTimeNin,
        // dateTimeLte, dateTimeGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq, idIn,
        // idNin, deviceIdEq, deviceIdNeq, deviceIdIn, deviceIdNin, eventTypeEq, eventTypeNeq, eventTypeIn,
        // eventTypeNin, stateChangeEq, stateChangeNeq, stateChangeIn, stateChangeNin);

        // TODO: test validations
    }

    /**
     * DEPRECATED: Retrieve a device event.
     *
     * Retrieve device event (deprecated, use /v3/device-events/{device_event_id}/ instead).
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
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String queryEq = null;
        String queryNeq = null;
        String queryIn = null;
        String queryNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // DeviceQueryPage response = api.deviceQueryList(limit, order, after, include, filter, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin,
        // queryEq, queryNeq, queryIn, queryNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);

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
     * Get a device
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

    /**
     * Create an image
     *
     * Create a firmware image.
     */
    @Test
    public void firmwareImageCreateTest() {
        File datafile = null;
        String description = null;
        String name = null;
        // FirmwareImage response = api.firmwareImageCreate(datafile, description, name);

        // TODO: test validations
    }

    /**
     * Delete an image
     *
     * Delete a firmware image.
     */
    @Test
    public void firmwareImageDestroyTest() {
        String imageId = null;
        // Void response = api.firmwareImageDestroy(imageId);

        // TODO: test validations
    }

    /**
     * List all images
     *
     * List all firmware images.
     */
    @Test
    public void firmwareImageListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String datafileEq = null;
        String datafileNeq = null;
        String datafileIn = null;
        String datafileNin = null;
        String datafileChecksumEq = null;
        String datafileChecksumNeq = null;
        String datafileChecksumIn = null;
        String datafileChecksumNin = null;
        Long datafileSizeEq = null;
        Long datafileSizeNeq = null;
        String datafileSizeIn = null;
        String datafileSizeNin = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String timestampIn = null;
        String timestampNin = null;
        String timestampLte = null;
        String timestampGte = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // FirmwareImagePage response = api.firmwareImageList(limit, order, after, include, filter, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin,
        // datafileChecksumEq, datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq,
        // datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn,
        // descriptionNin, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampIn, timestampNin,
        // timestampLte, timestampGte, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Get an image
     *
     * Retrieve a firmware image.
     */
    @Test
    public void firmwareImageRetrieveTest() {
        String imageId = null;
        // FirmwareImage response = api.firmwareImageRetrieve(imageId);

        // TODO: test validations
    }

    /**
     * Upload a manifest
     *
     * Upload a firmware manifest. The API enforces a maximum size of manifests of 2 KB.
     */
    @Test
    public void firmwareManifestCreateTest() {
        File datafile = null;
        String description = null;
        File keyTable = null;
        String name = null;
        // FirmwareManifest response = api.firmwareManifestCreate(datafile, description, keyTable, name);

        // TODO: test validations
    }

    /**
     * Delete a manifest
     *
     * Delete a firmware manifest.
     */
    @Test
    public void firmwareManifestDestroyTest() {
        String manifestId = null;
        // Void response = api.firmwareManifestDestroy(manifestId);

        // TODO: test validations
    }

    /**
     * List manifests
     *
     * List firmware manifests.
     */
    @Test
    public void firmwareManifestListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String datafileEq = null;
        String datafileNeq = null;
        String datafileIn = null;
        String datafileNin = null;
        Long datafileSizeEq = null;
        Long datafileSizeNeq = null;
        String datafileSizeIn = null;
        String datafileSizeNin = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String deviceClassEq = null;
        String deviceClassNeq = null;
        String deviceClassIn = null;
        String deviceClassNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String timestampIn = null;
        String timestampNin = null;
        DateTime timestampLte = null;
        DateTime timestampGte = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // FirmwareManifestPage response = api.firmwareManifestList(limit, order, after, include, filter, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileSizeEq,
        // datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn,
        // descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, idEq, idNeq, idIn, idNin,
        // nameEq, nameNeq, nameIn, nameNin, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtIn,
        // updatedAtNin, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Get a manifest
     *
     * Retrieve a firmware manifest.
     */
    @Test
    public void firmwareManifestRetrieveTest() {
        String manifestId = null;
        // FirmwareManifest response = api.firmwareManifestRetrieve(manifestId);

        // TODO: test validations
    }

    /**
     * Get billing report.
     *
     * Fetch the billing report generated for the currently authenticated commercial non-subtenant account. Billing
     * reports for subtenant accounts are included in their aggregator&#39;s billing report response. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getBillingReportTest() {
        String month = null;
        // ReportResponse response = api.getBillingReport(month);

        // TODO: test validations
    }

    /**
     * Get raw billing data of the active devices for the month.
     *
     * Fetch raw billing data for active devices for the currently authenticated commercial non-subtenant account. This
     * is supplementary data for the billing report. The raw billing data of the active devices for subtenant accounts
     * are included in their aggregator&#39;s raw billing data of the active devices. The endpoint returns the URL to
     * download the gzipped CSV file. The first line is the header providing information on active devices, for example,
     * the ID of an active device. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 \\ -H &#39;Authorization:
     * Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getBillingReportActiveDevicesTest() {
        String month = null;
        // BillingReportRawDataResponse response = api.getBillingReportActiveDevices(month);

        // TODO: test validations
    }

    /**
     * Get raw billing data of the firmware updates for the month.
     *
     * Fetch raw billing data for firmware updates for the currently authenticated commercial non-subtenant account.
     * This is supplementary data for the billing report. The raw billing data of the firmware updates for subtenant
     * accounts are included in their aggregator&#39;s raw billing data of the firmware updates. The endpoint returns
     * the URL to download the gzipped CSV file. The first line is the header providing information on the firmware
     * updates. For example, the ID of an firmware update. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getBillingReportFirmwareUpdatesTest() {
        String month = null;
        // BillingReportRawDataResponse response = api.getBillingReportFirmwareUpdates(month);

        // TODO: test validations
    }

    /**
     * Service package quota.
     *
     * Get the available firmware update quota for the current authenticated commercial account. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getServicePackageQuotaTest() {
        // ServicePackageQuota response = api.getServicePackageQuota();

        // TODO: test validations
    }

    /**
     * Service package quota history.
     *
     * Get your quota usage history. This API is available only for commercial accounts. Aggregator accounts can see
     * their own and subtenant quota usage data. Data is in ascending order based on the added timestamp. **Example:**
     * &#x60;&#x60;&#x60; curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history \\ -H
     * &#39;Authorization: Bearer &lt;api_key&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void getServicePackageQuotaHistoryTest() {
        Integer limit = null;
        String after = null;
        // ServicePackageQuotaHistoryResponse response = api.getServicePackageQuotaHistory(limit, after);

        // TODO: test validations
    }

    /**
     * Get all service packages.
     *
     * Get information for all service packages for the current authenticated commercial account. The response is
     * returned in descending order by service package created timestamp: first the pending service package, then the
     * active service package, then the previous service packages. **Example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/service-packages \\ -H &#39;Authorization: Bearer &lt;api_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     */
    @Test
    public void getServicePackagesTest() {
        // ServicePackagesResponse response = api.getServicePackages();

        // TODO: test validations
    }

    /**
     * Create a group
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
     * Delete a group
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
        String customAttributesEq = null;
        String customAttributesNeq = null;
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
        // nameNeq, nameIn, nameNin, customAttributesEq, customAttributesNeq, createdAtIn, createdAtNin, createdAtLte,
        // createdAtGte, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Add a device to a group
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
     * Remove a device from a group
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
     * Get a page of devices
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
        String filter = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String devicesCountEq = null;
        String devicesCountNeq = null;
        String devicesCountIn = null;
        String devicesCountNin = null;
        String devicesCountLte = null;
        String devicesCountGte = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String customAttributesEq = null;
        String customAttributesNeq = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // DevicePage response = api.groupMembersRetrieve(deviceGroupId, limit, order, after, include, filter, idEq,
        // idNeq, idIn, idNin, devicesCountEq, devicesCountNeq, devicesCountIn, devicesCountNin, devicesCountLte,
        // devicesCountGte, nameEq, nameNeq, nameIn, nameNin, descriptionEq, descriptionNeq, descriptionIn,
        // descriptionNin, customAttributesEq, customAttributesNeq, createdAtIn, createdAtNin, createdAtLte,
        // createdAtGte, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);

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

    /**
     * Archive a campaign.
     *
     * This command will archive a campaign.
     */
    @Test
    public void updateCampaignArchiveTest() {
        String campaignId = null;
        // Void response = api.updateCampaignArchive(campaignId);

        // TODO: test validations
    }

    /**
     * Create a campaign
     *
     * Create an update campaign.
     */
    @Test
    public void updateCampaignCreateTest() {
        UpdateCampaignPostRequest campaign = null;
        // UpdateCampaign response = api.updateCampaignCreate(campaign);

        // TODO: test validations
    }

    /**
     * Delete a campaign
     *
     * Delete an update campaign.
     */
    @Test
    public void updateCampaignDestroyTest() {
        String campaignId = null;
        // Void response = api.updateCampaignDestroy(campaignId);

        // TODO: test validations
    }

    /**
     * Get a list of events grouped by summary
     *
     * Get a list of events grouped by summary
     */
    @Test
    public void updateCampaignEventTypesListTest() {
        String campaignId = null;
        String summaryStatusId = null;
        // EventTypeList response = api.updateCampaignEventTypesList(campaignId, summaryStatusId);

        // TODO: test validations
    }

    /**
     * Get an event type for a campaign
     *
     * Get an event type for a campaign
     */
    @Test
    public void updateCampaignEventTypesRetrieveTest() {
        String campaignId = null;
        String summaryStatusId = null;
        String eventTypeId = null;
        // EventType response = api.updateCampaignEventTypesRetrieve(campaignId, summaryStatusId, eventTypeId);

        // TODO: test validations
    }

    /**
     * List all campaigns
     *
     * Get update campaigns for devices specified by a filter.
     */
    @Test
    public void updateCampaignListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String deviceFilterEq = null;
        String deviceFilterNeq = null;
        String deviceFilterIn = null;
        String deviceFilterNin = null;
        String finishedIn = null;
        String finishedNin = null;
        DateTime finishedLte = null;
        DateTime finishedGte = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String rootManifestIdEq = null;
        String rootManifestIdNeq = null;
        String rootManifestIdIn = null;
        String rootManifestIdNin = null;
        String startedAtIn = null;
        String startedAtNin = null;
        DateTime startedAtLte = null;
        DateTime startedAtGte = null;
        String stateEq = null;
        String stateNeq = null;
        String stateIn = null;
        String stateNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        String whenIn = null;
        String whenNin = null;
        DateTime whenLte = null;
        DateTime whenGte = null;
        // UpdateCampaignPage response = api.updateCampaignList(limit, order, after, include, filter, createdAtIn,
        // createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin,
        // deviceFilterEq, deviceFilterNeq, deviceFilterIn, deviceFilterNin, finishedIn, finishedNin, finishedLte,
        // finishedGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, rootManifestIdEq, rootManifestIdNeq,
        // rootManifestIdIn, rootManifestIdNin, startedAtIn, startedAtNin, startedAtLte, startedAtGte, stateEq,
        // stateNeq, stateIn, stateNin, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, whenIn, whenNin, whenLte,
        // whenGte);

        // TODO: test validations
    }

    /**
     * List all campaign device metadata
     *
     * Get campaign device metadata.
     */
    @Test
    public void updateCampaignMetadataListTest() {
        String campaignId = null;
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        // CampaignDeviceMetadataPage response = api.updateCampaignMetadataList(campaignId, limit, order, after,
        // include);

        // TODO: test validations
    }

    /**
     * Get a campaign device metadata
     *
     * Get update campaign metadata.
     */
    @Test
    public void updateCampaignMetadataRetrieveTest() {
        String campaignId = null;
        String campaignDeviceMetadataId = null;
        // CampaignDeviceMetadata response = api.updateCampaignMetadataRetrieve(campaignId, campaignDeviceMetadataId);

        // TODO: test validations
    }

    /**
     * Get campaign metrics
     *
     * Get detailed statistics of a campaign.
     */
    @Test
    public void updateCampaignMetricsTest() {
        String campaignId = null;
        // CampaignMetrics response = api.updateCampaignMetrics(campaignId);

        // TODO: test validations
    }

    /**
     * Get a campaign.
     *
     * Get an update campaign.
     */
    @Test
    public void updateCampaignRetrieveTest() {
        String campaignId = null;
        // UpdateCampaign response = api.updateCampaignRetrieve(campaignId);

        // TODO: test validations
    }

    /**
     * Start a campaign.
     *
     * This command will begin the process of starting a campaign.
     */
    @Test
    public void updateCampaignStartTest() {
        String campaignId = null;
        // Void response = api.updateCampaignStart(campaignId);

        // TODO: test validations
    }

    /**
     * Get a list of statistics for a campaign
     *
     * Get a list of statistics for a campaign
     */
    @Test
    public void updateCampaignStatisticsListTest() {
        String campaignId = null;
        // EventTypeSummaryList response = api.updateCampaignStatisticsList(campaignId);

        // TODO: test validations
    }

    /**
     * Get a summary status
     *
     * Get a summary status
     */
    @Test
    public void updateCampaignStatisticsRetrieveTest() {
        String campaignId = null;
        String summaryStatusId = null;
        // EventTypeSummary response = api.updateCampaignStatisticsRetrieve(campaignId, summaryStatusId);

        // TODO: test validations
    }

    /**
     * Stop a campaign.
     *
     * This command will begin the process of stopping a campaign.
     */
    @Test
    public void updateCampaignStopTest() {
        String campaignId = null;
        // Void response = api.updateCampaignStop(campaignId);

        // TODO: test validations
    }

    /**
     * Modify a campaign
     *
     * Modify an update campaign.
     */
    @Test
    public void updateCampaignUpdateTest() {
        String campaignId = null;
        UpdateCampaignPutRequest campaign = null;
        // UpdateCampaign response = api.updateCampaignUpdate(campaignId, campaign);

        // TODO: test validations
    }

    /**
     * Append a chunks to an upload job
     *
     * Append a chunks to an upload job. To finish a job upload a zero-length chunk.
     */
    @Test
    public void uploadJobChunkCreateTest() {
        String contentMD5 = null;
        Integer contentLength = null;
        String uploadJobId = null;
        byte[] chunk = null;
        // UploadChunkInfo response = api.uploadJobChunkCreate(contentMD5, contentLength, uploadJobId, chunk);

        // TODO: test validations
    }

    /**
     * List all metadata for uploaded chunks
     *
     * List all metadata for uploaded chunks
     */
    @Test
    public void uploadJobChunkListTest() {
        String uploadJobId = null;
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        Integer idEq = null;
        Integer idNeq = null;
        String idIn = null;
        String idNin = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        String hashEq = null;
        String hashNeq = null;
        String hashIn = null;
        String hashNin = null;
        Integer lengthEq = null;
        Integer lengthNeq = null;
        String lengthIn = null;
        String lengthNin = null;
        Integer lengthLte = null;
        Integer lengthGte = null;
        // UploadChunkInfoPage response = api.uploadJobChunkList(uploadJobId, limit, order, after, include, filter,
        // createdAtIn, createdAtNin, createdAtLte, createdAtGte, idEq, idNeq, idIn, idNin, updatedAtIn, updatedAtNin,
        // updatedAtLte, updatedAtGte, hashEq, hashNeq, hashIn, hashNin, lengthEq, lengthNeq, lengthIn, lengthNin,
        // lengthLte, lengthGte);

        // TODO: test validations
    }

    /**
     * Get metadata about a chunk
     *
     * Get metadata about a chunk
     */
    @Test
    public void uploadJobChunkRetreiveTest() {
        String uploadJobId = null;
        String chunkId = null;
        // UploadChunkInfo response = api.uploadJobChunkRetreive(uploadJobId, chunkId);

        // TODO: test validations
    }

    /**
     * Create a new upload job
     *
     * Create a new upload job
     */
    @Test
    public void uploadJobCreateTest() {
        UploadJob uploadJob = null;
        // UploadJob response = api.uploadJobCreate(uploadJob);

        // TODO: test validations
    }

    /**
     * Delete an upload job
     *
     * Delete an upload job
     */
    @Test
    public void uploadJobDeleteTest() {
        String uploadJobId = null;
        // Void response = api.uploadJobDelete(uploadJobId);

        // TODO: test validations
    }

    /**
     * Get all upload jobs
     *
     * Get all upload jobs
     */
    @Test
    public void uploadJobListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        String filter = null;
        String createdAtIn = null;
        String createdAtNin = null;
        DateTime createdAtLte = null;
        DateTime createdAtGte = null;
        String datafileEq = null;
        String datafileNeq = null;
        String datafileIn = null;
        String datafileNin = null;
        String datafileChecksumEq = null;
        String datafileChecksumNeq = null;
        String datafileChecksumIn = null;
        String datafileChecksumNin = null;
        String datafileSizeEq = null;
        String datafileSizeNeq = null;
        String datafileSizeIn = null;
        String datafileSizeNin = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String idEq = null;
        String idNeq = null;
        String idIn = null;
        String idNin = null;
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String timestampIn = null;
        String timestampNin = null;
        String timestampLte = null;
        String timestampGte = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        DateTime updatedAtLte = null;
        DateTime updatedAtGte = null;
        // UploadJobPage response = api.uploadJobList(limit, order, after, include, filter, createdAtIn, createdAtNin,
        // createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileChecksumEq,
        // datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq, datafileSizeNeq,
        // datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, idEq, idNeq,
        // idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampIn, timestampNin, timestampLte, timestampGte,
        // updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte);

        // TODO: test validations
    }

    /**
     * Get an upload job
     *
     * Get an upload job
     */
    @Test
    public void uploadJobRetrieveTest() {
        String uploadJobId = null;
        // UploadJob response = api.uploadJobRetrieve(uploadJobId);

        // TODO: test validations
    }

    /**
     * Update an upload job
     *
     * Update an upload job
     */
    @Test
    public void uploadJobUpdateTest() {
        String uploadJobId = null;
        UploadJob1 uploadJob = null;
        // UploadJob response = api.uploadJobUpdate(uploadJobId, uploadJob);

        // TODO: test validations
    }
}
