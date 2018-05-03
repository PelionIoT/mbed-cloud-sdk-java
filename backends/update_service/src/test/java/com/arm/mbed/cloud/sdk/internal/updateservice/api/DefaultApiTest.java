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
        String createdAtEq = null;
        String createdAtNeq = null;
        String createdAtIn = null;
        String createdAtNin = null;
        String createdAtLte = null;
        String createdAtGte = null;
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
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String timestampEq = null;
        String timestampNeq = null;
        String timestampIn = null;
        String timestampNin = null;
        String timestampLte = null;
        String timestampGte = null;
        String updatedAtEq = null;
        String updatedAtNeq = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        String updatedAtLte = null;
        String updatedAtGte = null;
        String include = null;
        // FirmwareImagePage response = api.firmwareImageList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileChecksumEq, datafileChecksumNeq, datafileChecksumIn, datafileChecksumNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampEq, timestampNeq, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include);

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
        String createdAtEq = null;
        String createdAtNeq = null;
        String createdAtIn = null;
        String createdAtNin = null;
        String createdAtLte = null;
        String createdAtGte = null;
        String datafileEq = null;
        String datafileNeq = null;
        String datafileIn = null;
        String datafileNin = null;
        String datafileSizeEq = null;
        String datafileSizeNeq = null;
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
        String nameEq = null;
        String nameNeq = null;
        String nameIn = null;
        String nameNin = null;
        String timestampEq = null;
        String timestampNeq = null;
        String timestampIn = null;
        String timestampNin = null;
        String timestampLte = null;
        String timestampGte = null;
        String updatedAtEq = null;
        String updatedAtNeq = null;
        String updatedAtIn = null;
        String updatedAtNin = null;
        String updatedAtLte = null;
        String updatedAtGte = null;
        String include = null;
        // FirmwareManifestPage response = api.firmwareManifestList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, datafileEq, datafileNeq, datafileIn, datafileNin, datafileSizeEq, datafileSizeNeq, datafileSizeIn, datafileSizeNin, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceClassEq, deviceClassNeq, deviceClassIn, deviceClassNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, timestampEq, timestampNeq, timestampIn, timestampNin, timestampLte, timestampGte, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, include);

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
        String createdAtEq = null;
        String createdAtNeq = null;
        String createdAtIn = null;
        String createdAtNin = null;
        String createdAtLte = null;
        String createdAtGte = null;
        String descriptionEq = null;
        String descriptionNeq = null;
        String descriptionIn = null;
        String descriptionNin = null;
        String deviceFilterEq = null;
        String deviceFilterNeq = null;
        String deviceFilterIn = null;
        String deviceFilterNin = null;
        String etagEq = null;
        String etagNeq = null;
        String etagIn = null;
        String etagNin = null;
        String etagLte = null;
        String etagGte = null;
        String finishedEq = null;
        String finishedNeq = null;
        String finishedIn = null;
        String finishedNin = null;
        String finishedLte = null;
        String finishedGte = null;
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
        String startedAtEq = null;
        String startedAtNeq = null;
        String startedAtIn = null;
        String startedAtNin = null;
        String startedAtLte = null;
        String startedAtGte = null;
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
        String whenEq = null;
        String whenNeq = null;
        String whenIn = null;
        String whenNin = null;
        String whenLte = null;
        String whenGte = null;
        String include = null;
        // UpdateCampaignPage response = api.updateCampaignList(limit, order, after, createdAtEq, createdAtNeq, createdAtIn, createdAtNin, createdAtLte, createdAtGte, descriptionEq, descriptionNeq, descriptionIn, descriptionNin, deviceFilterEq, deviceFilterNeq, deviceFilterIn, deviceFilterNin, etagEq, etagNeq, etagIn, etagNin, etagLte, etagGte, finishedEq, finishedNeq, finishedIn, finishedNin, finishedLte, finishedGte, idEq, idNeq, idIn, idNin, nameEq, nameNeq, nameIn, nameNin, rootManifestIdEq, rootManifestIdNeq, rootManifestIdIn, rootManifestIdNin, startedAtEq, startedAtNeq, startedAtIn, startedAtNin, startedAtLte, startedAtGte, stateEq, stateNeq, stateIn, stateNin, updatedAtEq, updatedAtNeq, updatedAtIn, updatedAtNin, updatedAtLte, updatedAtGte, whenEq, whenNeq, whenIn, whenNin, whenLte, whenGte, include);

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
