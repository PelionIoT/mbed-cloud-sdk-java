package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceDataPutRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceGroupManipulation;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceQueryPostPutRequest;
import java.io.File;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Group1;
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
        // DeviceEventPage response = api.deviceEventList(limit, order, after, include, filter);

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
        // DevicePage response = api.deviceList(limit, order, after, include, filter);

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
        // DeviceEventPage response = api.deviceLogList(limit, order, after, include, filter);

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
        // DeviceQueryPage response = api.deviceQueryList(limit, order, after, include, filter);

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
        // FirmwareImagePage response = api.firmwareImageList(limit, order, after, include, filter);

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
        // FirmwareManifestPage response = api.firmwareManifestList(limit, order, after, include, filter);

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
     * reports for subtenant accounts are included in their aggregator&#39;s billing report response. **Example usage:**
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/billing-report?month&#x3D;2018-07 -H &#39;authorization:
     * Bearer {api-key}&#39;
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
     * Fetch the raw billing data of the active devices for the currently authenticated commercial non-subtenant
     * account. This is supplementary data for the billing report. The raw billing data of the active devices for
     * subtenant accounts are included in their aggregator&#39;s raw billing data of the active devices. The endpoint
     * returns the URL to download the gzipped CSV file. The first line is the header providing information on the
     * active devices. For example, the ID of an active device. **Example usage:** curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-active-devices?month&#x3D;2018-07 -H &#39;authorization:
     * Bearer {api-key}&#39;
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
     * Fetch raw billing data of the firmware updates for the currently authenticated commercial non-subtenant account.
     * This is supplementary data for the billing report. The raw billing data of the firmware updates for subtenant
     * accounts are included in their aggregator&#39;s raw billing data of the firmware updates. The endpoint returns
     * the URL to download the gzipped CSV file. The first line is the header providing information on the firmware
     * updates. For example, the ID of an firmware update. **Example usage:** curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/billing-report-firmware-updates?month&#x3D;2018-07 -H &#39;authorization:
     * Bearer {api-key}&#39;
     */
    @Test
    public void getBillingReportFirmwareUpdatesTest() {
        String month = null;
        // BillingReportRawDataResponse response = api.getBillingReportFirmwareUpdates(month);

        // TODO: test validations
    }

    /**
     * Get branding colors of the dark theme.
     *
     * Returns the branding colors of the dark theme.
     */
    @Test
    public void getLoginPageAllDarkColorsTest() {
        String accountId = null;
        // BrandingColorList response = api.getLoginPageAllDarkColors(accountId);

        // TODO: test validations
    }

    /**
     * Get metadata of all images of the dark theme.
     *
     * Returns the metadata of all branding images of the dark theme.
     */
    @Test
    public void getLoginPageAllDarkImageDataTest() {
        String accountId = null;
        // BrandingImageList response = api.getLoginPageAllDarkImageData(accountId);

        // TODO: test validations
    }

    /**
     * Get branding colors of the light theme.
     *
     * Returns the branding colors of the light theme.
     */
    @Test
    public void getLoginPageAllLightColorsTest() {
        String accountId = null;
        // BrandingColorList response = api.getLoginPageAllLightColors(accountId);

        // TODO: test validations
    }

    /**
     * Get metadata of all images of the light theme.
     *
     * Returns the metadata of all branding images of the light theme.
     */
    @Test
    public void getLoginPageAllLightImageDataTest() {
        String accountId = null;
        // BrandingImageList response = api.getLoginPageAllLightImageData(accountId);

        // TODO: test validations
    }

    /**
     * Get branding color of the dark theme.
     *
     * Returns the requested branding color of the dark theme.
     */
    @Test
    public void getLoginPageDarkColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.getLoginPageDarkColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get metadata of an image of the dark theme.
     *
     * An endpoint for getting metadata of one account branding image of the dark theme.
     */
    @Test
    public void getLoginPageDarkImageDataTest() {
        String accountId = null;
        String reference = null;
        // BrandingImage response = api.getLoginPageDarkImageData(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get branding color of the light theme.
     *
     * Returns the requested branding color of the light theme.
     */
    @Test
    public void getLoginPageLightColorTest() {
        String accountId = null;
        String reference = null;
        // BrandingColor response = api.getLoginPageLightColor(accountId, reference);

        // TODO: test validations
    }

    /**
     * Get metadata of an image of the light theme.
     *
     * An endpoint for getting metadata of one account branding image of the light theme.
     */
    @Test
    public void getLoginPageLightImageDataTest() {
        String accountId = null;
        String reference = null;
        // BrandingImage response = api.getLoginPageLightImageData(accountId, reference);

        // TODO: test validations
    }

    /**
     * Service package quota.
     *
     * Get the available firmware update quota for the currently authenticated commercial account. **Example usage:**
     * curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota -H &#39;authorization: Bearer
     * {api-key}&#39;
     */
    @Test
    public void getServicePackageQuotaTest() {
        // ServicePackageQuota response = api.getServicePackageQuota();

        // TODO: test validations
    }

    /**
     * Service package quota history.
     *
     * Get your quota usage history. This API is available for commercial accounts. Aggregator accounts can see own and
     * subtenant quota usage data. History data is ordered in ascending order based on the added timestamp. **Example
     * usage:** curl -X GET https://api.us-east-1.mbedcloud.com/v3/service-packages-quota-history -H &#39;authorization:
     * Bearer {api-key}&#39;
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
     * Get information of all service packages for the currently authenticated commercial account. The response is
     * returned in descending order by service package created timestamp, listing first the pending service package,
     * then the active service package and finally the previous service packages. **Example usage:** curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/service-packages -H &#39;authorization: Bearer {api-key}&#39;
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
        // DeviceGroupPage response = api.groupList(limit, order, after, include, filter);

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
        // DevicePage response = api.groupMembersRetrieve(deviceGroupId, limit, order, after, include, filter);

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
        // UpdateCampaignPage response = api.updateCampaignList(limit, order, after, include, filter);

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
        // UploadChunkInfoPage response = api.uploadJobChunkList(uploadJobId, limit, order, after, include, filter);

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
        // UploadJobPage response = api.uploadJobList(limit, order, after, include, filter);

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
