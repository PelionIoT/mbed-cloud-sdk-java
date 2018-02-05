package com.arm.mbed.cloud.sdk.internal.updateservice.api;

import com.arm.mbed.cloud.sdk.internal.ApiClient;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import java.io.File;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;
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
     * 
     *
     * Create an update campaign.
     */
    @Test
    public void campaignCreateTest() {
        UpdateCampaignPostRequest campaign = null;
        // UpdateCampaign response = api.campaignCreate(campaign);

        // TODO: test validations
    }
    /**
     * 
     *
     * DEPRECATED (use /v3/campaigns/{campaign_id}/ instead) Delete an update campaign.
     */
    @Test
    public void campaignDestroyTest() {
        String campaignId = null;
        // Void response = api.campaignDestroy(campaignId);

        // TODO: test validations
    }
    /**
     * 
     *
     * Get update campaigns for devices specified by a filter.
     */
    @Test
    public void campaignListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // UpdateCampaignPage response = api.campaignList(limit, order, after, filter, include);

        // TODO: test validations
    }
    /**
     * 
     *
     * DEPRECATED (use /v3/campaigns/{campaign_id}/ instead) Get an update campaign.
     */
    @Test
    public void campaignRetrieveTest() {
        String campaignId = null;
        // UpdateCampaign response = api.campaignRetrieve(campaignId);

        // TODO: test validations
    }
    /**
     * 
     *
     * DEPRECATED (use /v3/campaigns/{campaign_id}/ instead) Modify an update campaign.
     */
    @Test
    public void campaignUpdateTest() {
        String campaignId = null;
        UpdateCampaignPutRequest campaign = null;
        // UpdateCampaign response = api.campaignUpdate(campaignId, campaign);

        // TODO: test validations
    }
    /**
     * 
     *
     * Create firmware image.
     */
    @Test
    public void firmwareImageCreateTest() {
        File datafile = null;
        String name = null;
        String description = null;
        // FirmwareImage response = api.firmwareImageCreate(datafile, name, description);

        // TODO: test validations
    }
    /**
     * 
     *
     * Delete firmware image.
     */
    @Test
    public void firmwareImageDestroyTest() {
        String imageId = null;
        // Void response = api.firmwareImageDestroy(imageId);

        // TODO: test validations
    }
    /**
     * 
     *
     * List all firmware images.
     */
    @Test
    public void firmwareImageListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // FirmwareImagePage response = api.firmwareImageList(limit, order, after, filter, include);

        // TODO: test validations
    }
    /**
     * 
     *
     * Retrieve firmware image.
     */
    @Test
    public void firmwareImageRetrieveTest() {
        String imageId = null;
        // FirmwareImage response = api.firmwareImageRetrieve(imageId);

        // TODO: test validations
    }
    /**
     * 
     *
     * Create firmware manifest.
     */
    @Test
    public void firmwareManifestCreateTest() {
        File datafile = null;
        String name = null;
        String description = null;
        // FirmwareManifest response = api.firmwareManifestCreate(datafile, name, description);

        // TODO: test validations
    }
    /**
     * 
     *
     * Delete firmware manifest.
     */
    @Test
    public void firmwareManifestDestroyTest() {
        String manifestId = null;
        // Void response = api.firmwareManifestDestroy(manifestId);

        // TODO: test validations
    }
    /**
     * 
     *
     * List firmware manifests.
     */
    @Test
    public void firmwareManifestListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // FirmwareManifestPage response = api.firmwareManifestList(limit, order, after, filter, include);

        // TODO: test validations
    }
    /**
     * 
     *
     * Retrieve firmware manifest.
     */
    @Test
    public void firmwareManifestRetrieveTest() {
        String manifestId = null;
        // FirmwareManifest response = api.firmwareManifestRetrieve(manifestId);

        // TODO: test validations
    }
    /**
     * 
     *
     * DEPRECATED (use /v3/campaigns/ instead) Create an update campaign.
     */
    @Test
    public void updateCampaignCreateTest() {
        UpdateCampaignPostRequest campaign = null;
        // UpdateCampaign response = api.updateCampaignCreate(campaign);

        // TODO: test validations
    }
    /**
     * 
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
     * 
     *
     * DEPRECATED (use /v3/campaigns/ instead) Get update campaigns for devices specified by a filter.
     */
    @Test
    public void updateCampaignListTest() {
        Integer limit = null;
        String order = null;
        String after = null;
        String filter = null;
        String include = null;
        // UpdateCampaignPage response = api.updateCampaignList(limit, order, after, filter, include);

        // TODO: test validations
    }
    /**
     * 
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
        // CampaignDeviceMetadataPage response = api.updateCampaignMetadataList(campaignId, limit, order, after, include);

        // TODO: test validations
    }
    /**
     * 
     *
     * Get update campaign metadata.
     */
    @Test
    public void updateCampaignMetadataRetreiveTest() {
        String campaignId = null;
        String campaignDeviceMetadataId = null;
        // CampaignDeviceMetadata response = api.updateCampaignMetadataRetreive(campaignId, campaignDeviceMetadataId);

        // TODO: test validations
    }
    /**
     * 
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
     * 
     *
     * Stop a running update campaign.
     */
    @Test
    public void updateCampaignStopTest() {
        String campaignId = null;
        // UpdateCampaign response = api.updateCampaignStop(campaignId);

        // TODO: test validations
    }
    /**
     * 
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
     * 
     *
     * DEPRECATED (use /v3/campaigns/{campaign_id}/campaign-device-metadata/{campaign_device_metadata_id}/ instead) Get update campaign metadata.
     */
    @Test
    public void v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGetTest() {
        String campaignId = null;
        String campaignDeviceMetadataId = null;
        // CampaignDeviceMetadata response = api.v3UpdateCampaignsCampaignIdCampaignDeviceMetadataCampaignDeviceMetadataIdGet(campaignId, campaignDeviceMetadataId);

        // TODO: test validations
    }
    /**
     * 
     *
     * DEPRECATED (use /v3/campaigns/{campaign_id}/campaign-device-metadata/ instead) Get campaign device metadata.
     */
    @Test
    public void v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGetTest() {
        String campaignId = null;
        Integer limit = null;
        String order = null;
        String after = null;
        String include = null;
        // CampaignDeviceMetadataPage response = api.v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet(campaignId, limit, order, after, include);

        // TODO: test validations
    }
}
