package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.ApiClient;
import org.joda.time.DateTime;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPutRequest;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for DeviceUpdateCampaignsApi
 */
public class DeviceUpdateCampaignsApiTest {

    private DeviceUpdateCampaignsApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DeviceUpdateCampaignsApi.class);
    }

    /**
     * Archive a campaign.
     *
     * Archive a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/archive \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Create an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns \\ -H &#39;Authorization: &lt;valid access token&gt;&#39;
     * \\ -H &#39;content-type: application/json;charset&#x3D;UTF-8&#39; \\ -d &#39;{ \&quot;campaign_strategy\&quot;:
     * \&quot;one-shot\&quot;, \&quot;description\&quot;: \&quot;Campaign is for ...\&quot;,
     * \&quot;device_filter\&quot;: \&quot;id__eq&#x3D;123400000000000000000000000ae45\&quot;, \&quot;name\&quot;:
     * \&quot;campaign\&quot;, \&quot;root_manifest_id\&quot;: \&quot;5678000000000000000000000000bd98\&quot;, }&#39;
     * &#x60;&#x60;&#x60;
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
     * Delete an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X DELETE
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get a list of events grouped by summary. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/12345678901234567890123456789012/event_types
     * \\ -H &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get the count for a specific event type; for example, succeeded, failed, or skipped. &lt;br&gt; **Usage
     * example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/12345678901234567890123456789012/event_types/12345678901234567890123456789012
     * \\ -H &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get update campaigns for devices specified by a filter. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X
     * GET https://api.us-east-1.mbedcloud.com/v3/update-campaigns \\ -H &#39;Authorization: &lt;valid access
     * token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get metadata for all devices in a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/campaign-device-metadata
     * \\ -H &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get update campaign metadata for a specific device. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/campaign-device-metadata/12345678901234567890123456789012
     * \\ -H &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get
     * [information](https://www.pelion.com/docs/device-management/current/updating-firmware/campaign-metrics-in-portal.html)
     * for a campaign based on **SUCCESS**, **FAIL**, or **SKIPPED** criteria for each device. &lt;br&gt; **Usage
     * example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/metrics \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Get an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Start a campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/start \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateCampaignStartTest() {
        String campaignId = null;
        // Void response = api.updateCampaignStart(campaignId);

        // TODO: test validations
    }

    /**
     * Get statistics for a campaign
     *
     * Get a list of statistics for a campaign, including the number of devices reporting specific event codes.
     * &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateCampaignStatisticsListTest() {
        String campaignId = null;
        // EventTypeSummaryList response = api.updateCampaignStatisticsList(campaignId);

        // TODO: test validations
    }

    /**
     * Get a status summary
     *
     * Get the count of successfully updated, skipped, and failed devices. &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/statistics/12345678901234567890123456789012
     * \\ -H &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Stop a campaign. Stopping is a process that requires the campaign go through several
     * [phases](../updating-firmware/running-update-campaigns.html#stopping). &lt;br&gt; **Usage example:**
     * &#x60;&#x60;&#x60; curl -X POST
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012/stop \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; &#x60;&#x60;&#x60;
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
     * Modify an update campaign. &lt;br&gt; **Usage example:** &#x60;&#x60;&#x60; curl -X PUT
     * https://api.us-east-1.mbedcloud.com/v3/update-campaigns/12345678901234567890123456789012 \\ -H
     * &#39;Authorization: &lt;valid access token&gt;&#39; \\ d &#39;{ \&quot;description\&quot;: \&quot;Campaign is for
     * ...\&quot;, \&quot;device_filter\&quot;: \&quot;id__eq&#x3D;123400000000000000000000000ae45\&quot;,
     * \&quot;name\&quot;: \&quot;campaign\&quot;, \&quot;root_manifest_id\&quot;:
     * \&quot;5678000000000000000000000000bd98\&quot;, }&#39; &#x60;&#x60;&#x60;
     */
    @Test
    public void updateCampaignUpdateTest() {
        String campaignId = null;
        UpdateCampaignPutRequest campaign = null;
        // UpdateCampaign response = api.updateCampaignUpdate(campaignId, campaign);

        // TODO: test validations
    }
}
