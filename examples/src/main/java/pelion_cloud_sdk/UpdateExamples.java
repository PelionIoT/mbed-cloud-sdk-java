package pelion_cloud_sdk;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.UUID;

import com.arm.mbed.cloud.sdk.DeviceDirectory;
import com.arm.mbed.cloud.sdk.Update;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Query;
import com.arm.mbed.cloud.sdk.devicedirectory.model.QueryListOptions;
import com.arm.mbed.cloud.sdk.update.model.Campaign;
import com.arm.mbed.cloud.sdk.update.model.CampaignDeviceState;
import com.arm.mbed.cloud.sdk.update.model.CampaignDevicesStatesListOptions;
import com.arm.mbed.cloud.sdk.update.model.CampaignListOptions;
import com.arm.mbed.cloud.sdk.update.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.update.model.FirmwareImageListOptions;
import com.arm.mbed.cloud.sdk.update.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.update.model.FirmwareManifestListOptions;

import utils.AbstractExample;
import utils.Configuration;
import utils.Example;

public class UpdateExamples extends AbstractExample {
    /**
     * Lists the first 5 update campaigns.
     */
    @Example
    public void manageCampaigns() {
        ConnectionOptions config = Configuration.get();
        Update api = new Update(config);
        try (DeviceDirectory api2 = new DeviceDirectory(config)) {
            String campaignId = null;
            try {
                // Getting a manifest file.
                FirmwareManifestListOptions options = new FirmwareManifestListOptions();
                options.setPageSize(Integer.valueOf(1));
                FirmwareManifest manifest = null;
                Paginator<FirmwareManifest> manifests = api.listAllFirmwareManifests(options);
                if (!manifests.hasNext()) {
                    fail("Could not get any manifest files from Mbed Cloud");
                }
                manifest = manifests.next();
                log("Campaign manifest", manifest);
                // Getting a query.
                QueryListOptions options2 = new QueryListOptions();
                options.setPageSize(Integer.valueOf(1));
                options.setOrder(Order.DESC);
                Query query = null;
                Paginator<Query> queries = api2.listAllQueries(options2);
                if (!queries.hasNext()) {
                    fail("Could not fetch any queries from Mbed Cloud");
                }
                query = queries.first();
                log("Campaign query", query);
                // Creating an update campaign.
                String campaignName = "campaign-" + UUID.randomUUID().toString();
                log("Campaign name", campaignName);
                Campaign myCampaign = new Campaign(campaignName, manifest, query);
                myCampaign.setScheduledAt(new Date());
                myCampaign = api.addCampaign(myCampaign);
                log("Created campaign", myCampaign);
                campaignId = myCampaign.getId();
                // Updating campaign.
                campaignName = "campaign-" + UUID.randomUUID().toString();
                log("Updated campaign name", campaignName);
                myCampaign.setName(campaignName);
                myCampaign = api.updateCampaign(myCampaign);
                log("Updated campaign", myCampaign);
                campaignId = myCampaign.getId();
                // Starting the campaign.
                myCampaign = api.startCampaign(myCampaign);
                log("Started campaign", myCampaign);
                campaignId = myCampaign.getId();
                // Printing device states
                CampaignDevicesStatesListOptions deviceStateOptions = new CampaignDevicesStatesListOptions();
                deviceStateOptions.setPageSize(Integer.valueOf(20));
                for (int countdown = 10; countdown >= 0; countdown--) {
                    log("Device states at countdown", Integer.valueOf(countdown));
                    Paginator<CampaignDeviceState> states = api.listAllCampaignDeviceStates(campaignId,
                                                                                            deviceStateOptions);
                    while (states.hasNext()) {
                        CampaignDeviceState state = states.next();
                        log("Device " + state.getDeviceId() + " state", state.getState());
                    }
                }
                // Stopping campaign.
                myCampaign = api.stopCampaign(myCampaign);
                log("Stopped campaign", myCampaign);
                campaignId = myCampaign.getId();
                // Deleting campaign.
                deleteCreatedCampaign(campaignId, api);
            } catch (Exception e) {
                logError("last API Metadata", api.getLastApiMetadata());
                deleteCreatedCampaign(campaignId, api);
                fail(e.getMessage());
            }
        }
    }

    private void deleteCreatedCampaign(String campaignId, Update api) {
        try {
            if (campaignId != null) {
                api.deleteCampaign(campaignId);
            }
        } catch (MbedCloudException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Lists the first five update campaigns.
     */
    @Example
    public void listCampaigns() {
        ConnectionOptions config = Configuration.get();
        try (Update api = new Update(config)) {
            // Defining query options.
            CampaignListOptions options = new CampaignListOptions();
            options.setPageSize(Integer.valueOf(5));
            // Listing campaigns.
            Paginator<Campaign> campaigns = api.listAllCampaigns(options);
            for (Campaign campaign : campaigns) {
                log("Update campaign", campaign);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Lists the first five firmware manifests.
     */
    @Example
    public void listFirmwareManifests() {
        ConnectionOptions config = Configuration.get();
        try (Update api = new Update(config)) {
            // Defining query options.
            FirmwareManifestListOptions options = new FirmwareManifestListOptions();
            options.setPageSize(Integer.valueOf(5));
            // Listing firmware manifests.
            Paginator<FirmwareManifest> manifests = api.listAllFirmwareManifests(options);
            for (FirmwareManifest manifest : manifests) {
                log("Firmware manifest", manifest);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Lists the first five firmware images.
     */
    @Example
    public void listFirmwareImages() {
        ConnectionOptions config = Configuration.get();
        try (Update api = new Update(config)) {
            // Defining query options.
            FirmwareImageListOptions options = new FirmwareImageListOptions();
            options.setPageSize(Integer.valueOf(5));
            // Listing firmware images.
            Paginator<FirmwareImage> images = api.listAllFirmwareImages(options);
            String imageId = null;
            for (FirmwareImage image : images) {
                log("Firmware image", image);
                imageId = image.getId();
            }
            // Getting a specific image
            FirmwareImage image = api.getFirmwareImage(imageId);
            log("Specific firmware image", image);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
