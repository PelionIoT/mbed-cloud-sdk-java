package com.arm.mbed.cloud.sdk.internal.updateservice.api;

import com.arm.mbed.cloud.sdk.internal.updateservice.ApiClient;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadata;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignMetrics;
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
     * Create an image
     *
     * Create a firmware image.
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
     * Create a manifest
     *
     * Create a firmware manifest.
     */
    @Test
    public void firmwareManifestCreateTest() {
        File datafile = null;
        String name = null;
        String description = null;
        File keyTable = null;
        // FirmwareManifest response = api.firmwareManifestCreate(datafile, name, description, keyTable);

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
        // CampaignDeviceMetadataPage response = api.updateCampaignMetadataList(campaignId, limit, order, after, include);

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
}
