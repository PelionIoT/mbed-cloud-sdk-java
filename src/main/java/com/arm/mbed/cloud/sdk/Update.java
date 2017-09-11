package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractAPI;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.update.adapters.CampaignAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.DataFileAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.DeviceStatusAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.FirmwareImageAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.FirmwareManifestAdapter;
import com.arm.mbed.cloud.sdk.update.model.Campaign;
import com.arm.mbed.cloud.sdk.update.model.CampaignDeviceStatus;
import com.arm.mbed.cloud.sdk.update.model.CampaignDevicesStatusesListOptions;
import com.arm.mbed.cloud.sdk.update.model.CampaignListOptions;
import com.arm.mbed.cloud.sdk.update.model.CampaignState;
import com.arm.mbed.cloud.sdk.update.model.EndPoints;
import com.arm.mbed.cloud.sdk.update.model.FirmwareImage;
import com.arm.mbed.cloud.sdk.update.model.FirmwareImageListOptions;
import com.arm.mbed.cloud.sdk.update.model.FirmwareManifest;
import com.arm.mbed.cloud.sdk.update.model.FirmwareManifestListOptions;

import retrofit2.Call;

@Preamble(description = "Specifies Update API")
@Module
/**
 * API exposing functionality for dealing with updates
 */
public class Update extends AbstractAPI {

    private static final String TAG_CAMPAIGN_ID = "campaign id";
    private static final String TAG_CAMPAIGN = "campaign";
    private static final String TAG_FIRMWARE_MANIFEST_ID = "firmwareManifestId";
    private static final String TAG_FIRMWARE_MANIFEST_NAME = "firmware manifest name";
    private static final String TAG_FIRMWARE_MANIFEST = "manifest";
    private static final String TAG_FIRMWARE_IMAGE_NAME = "firmware image name";
    private static final String TAG_FIRMWARE_IMAGE = "firmware image";
    private static final String TAG_FIRMWARE_IMAGE_ID = "firmwareImageId";
    private final EndPoints endpoint;

    public Update(ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Lists all firmware images according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of firmware images corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<FirmwareImage> listFirmwareImages(@Nullable FirmwareImageListOptions options)
            throws MbedCloudException {
        final FirmwareImageListOptions finalOptions = (options == null) ? new FirmwareImageListOptions() : options;

        return CloudCaller.call(this, "listFirmwareImages()", FirmwareImageAdapter.getListMapper(),
                new CloudCall<FirmwareImagePage>() {

                    @Override
                    public Call<FirmwareImagePage> call() {
                        return endpoint.getUpdate().firmwareImageList(finalOptions.getLimit(),
                                finalOptions.getOrder().toString(), finalOptions.getAfter(),
                                new FilterMarshaller(null).encode(finalOptions.getFilter()),
                                finalOptions.encodeInclude());
                    }
                });
    }

    /**
     * Gets an iterator over all firmware images according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of firmware images corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<FirmwareImage> listAllFirmwareImages(@Nullable FirmwareImageListOptions options)
            throws MbedCloudException {
        final FirmwareImageListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<FirmwareImage>() {

            @Override
            public ListResponse<FirmwareImage> requestNewPage() throws MbedCloudException {
                return listFirmwareImages(finalOptions);
            }
        });
    }

    /**
     * Gets details of a firmware image
     * 
     * @param firmwareImageId
     *            the firmware image ID
     * @return firmware image details
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable FirmwareImage getFirmwareImage(@NonNull String firmwareImageId) throws MbedCloudException {
        checkNotNull(firmwareImageId, TAG_FIRMWARE_IMAGE_ID);
        final String finalId = firmwareImageId;
        return CloudCaller.call(this, "getFirmwareImage()", FirmwareImageAdapter.getMapper(),
                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage>() {

                    @Override
                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage> call() {
                        return endpoint.getUpdate().firmwareImageRetrieve(finalId);
                    }

                });
    }

    /**
     * Adds a firmware image
     * 
     * @param image
     *            The image to add
     * @return added image
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable FirmwareImage addFirmwareImage(@NonNull FirmwareImage image) throws MbedCloudException {
        checkNotNull(image, TAG_FIRMWARE_IMAGE);
        checkNotNull(image.getName(), TAG_FIRMWARE_IMAGE_NAME);
        final FirmwareImage finalImage = image;
        return CloudCaller.call(this, "addFirmwareImage()", FirmwareImageAdapter.getMapper(),
                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage>() {

                    @Override
                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage> call() {
                        return endpoint.getUpdate().firmwareImageCreate(
                                DataFileAdapter.reverseMap(finalImage.getDataFile()), finalImage.getName(),
                                finalImage.getDescription());
                    }

                });
    }

    /**
     * Deletes a firmware image
     * 
     * @param firmwareImageId
     *            The ID of the firmware image to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteFirmwareImage(@NonNull String firmwareImageId) throws MbedCloudException {
        checkNotNull(firmwareImageId, TAG_FIRMWARE_IMAGE_ID);
        final String finalId = firmwareImageId;
        CloudCaller.call(this, "deleteFirmwareImage()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getUpdate().firmwareImageDestroy(finalId);
            }

        });
    }

    /**
     * Lists all firmware manifests according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of firmware manifests corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<FirmwareManifest> listFirmwareManifests(@Nullable FirmwareManifestListOptions options)
            throws MbedCloudException {
        final FirmwareManifestListOptions finalOptions = (options == null) ? new FirmwareManifestListOptions()
                : options;

        return CloudCaller.call(this, "listFirmwareManifests()", FirmwareManifestAdapter.getListMapper(),
                new CloudCall<FirmwareManifestPage>() {

                    @Override
                    public Call<FirmwareManifestPage> call() {
                        return endpoint.getUpdate().firmwareManifestList(finalOptions.getLimit(),
                                finalOptions.getOrder().toString(), finalOptions.getAfter(),
                                new FilterMarshaller(null).encode(finalOptions.getFilter()),
                                finalOptions.encodeInclude());
                    }
                });
    }

    /**
     * Gets an iterator over all firmware manifests according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of firmware manifests corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<FirmwareManifest> listAllFirmwareManifests(@Nullable FirmwareManifestListOptions options)
            throws MbedCloudException {
        final FirmwareManifestListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<FirmwareManifest>() {

            @Override
            public ListResponse<FirmwareManifest> requestNewPage() throws MbedCloudException {
                return listFirmwareManifests(finalOptions);
            }
        });
    }

    /**
     * Get details of a firmware manifest
     * 
     * @param firmwareManifestId
     *            The firmware manifest ID
     * @return corresponding firmware manifest
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable FirmwareManifest getFirmwareManifest(@NonNull String firmwareManifestId)
            throws MbedCloudException {
        checkNotNull(firmwareManifestId, TAG_FIRMWARE_MANIFEST_ID);
        final String finalId = firmwareManifestId;
        return CloudCaller.call(this, "getFirmwareManifest()", FirmwareManifestAdapter.getMapper(),
                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest>() {

                    @Override
                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest> call() {
                        return endpoint.getUpdate().firmwareManifestRetrieve(finalId);
                    }

                });
    }

    /**
     * Adds a firmware manifest
     * 
     * @param manifest
     *            The manifest to add
     * @return added manifest
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable FirmwareManifest addFirmwareManifest(@NonNull FirmwareManifest manifest)
            throws MbedCloudException {
        checkNotNull(manifest, TAG_FIRMWARE_MANIFEST);
        checkNotNull(manifest.getName(), TAG_FIRMWARE_MANIFEST_NAME);
        final FirmwareManifest finalManifest = manifest;
        return CloudCaller.call(this, "addFirmwareManifest()", FirmwareManifestAdapter.getMapper(),
                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest>() {

                    @Override
                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest> call() {
                        return endpoint.getUpdate().firmwareManifestCreate(
                                DataFileAdapter.reverseMap(finalManifest.getDataFile()), finalManifest.getName(),
                                finalManifest.getDescription());
                    }

                });
    }

    /**
     * Deletes a firmware manifest
     * 
     * @param firmwareManifestId
     *            The ID of the firmware manifest to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteFirmwareManifest(@NonNull String firmwareManifestId) throws MbedCloudException {
        checkNotNull(firmwareManifestId, TAG_FIRMWARE_MANIFEST_ID);
        final String finalId = firmwareManifestId;
        CloudCaller.call(this, "deleteFirmwareManifest()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getUpdate().firmwareManifestDestroy(finalId);
            }

        });
    }

    /**
     * Lists all update campaigns according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of update campaigns corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<Campaign> listCampaigns(@Nullable CampaignListOptions options)
            throws MbedCloudException {
        final CampaignListOptions finalOptions = (options == null) ? new CampaignListOptions() : options;

        return CloudCaller.call(this, "listCampaigns()", CampaignAdapter.getListMapper(),
                new CloudCall<UpdateCampaignPage>() {

                    @Override
                    public Call<UpdateCampaignPage> call() {
                        return endpoint.getUpdate().updateCampaignList(finalOptions.getLimit(),
                                finalOptions.getOrder().toString(), finalOptions.getAfter(),
                                CampaignAdapter.FILTERS_MARSHALLER.encode(finalOptions.getFilter()),
                                finalOptions.encodeInclude());
                    }
                });
    }

    /**
     * Gets an iterator over all update campaigns according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of update campaigns corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<Campaign> listAllCampaigns(@Nullable CampaignListOptions options)
            throws MbedCloudException {
        final CampaignListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<Campaign>() {

            @Override
            public ListResponse<Campaign> requestNewPage() throws MbedCloudException {
                return listCampaigns(finalOptions);
            }
        });
    }

    /**
     * Gets details of an update campaign
     * 
     * @param campaignId
     *            The update campaign ID
     * @return the update campaign
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Campaign getCampaign(@NonNull String campaignId) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final String finalId = campaignId;
        return CloudCaller.call(this, "getCampaign()", CampaignAdapter.getMapper(), new CloudCall<UpdateCampaign>() {

            @Override
            public Call<UpdateCampaign> call() {
                return endpoint.getUpdate().updateCampaignRetrieve(finalId);
            }

        });
    }

    /**
     * Adds an update campaign
     * 
     * @param campaign
     *            The campaign to add
     * @return added update campaign
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Campaign addCampaign(@NonNull Campaign campaign) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        final Campaign finalCampaign = campaign;
        return CloudCaller.call(this, "addCampaign()", CampaignAdapter.getMapper(), new CloudCall<UpdateCampaign>() {

            @Override
            public Call<UpdateCampaign> call() {
                return endpoint.getUpdate().updateCampaignCreate(CampaignAdapter.reverseMapAdd(finalCampaign));
            }

        });
    }

    /**
     * Modifies an update campaign
     * 
     * @param campaign
     *            campaign to modify
     * @param actionName
     *            name of the modification action
     * @return modified campaign
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @Internal
    private Campaign modifyCampaign(Campaign campaign, String actionName) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        checkNotNull(campaign.getId(), TAG_CAMPAIGN_ID);
        final Campaign finalCampaign = campaign;
        return CloudCaller.call(this, actionName, CampaignAdapter.getMapper(), new CloudCall<UpdateCampaign>() {

            @Override
            public Call<UpdateCampaign> call() {
                return endpoint.getUpdate().updateCampaignUpdate(finalCampaign.getId(),
                        CampaignAdapter.reverseMapUpdate(finalCampaign));
            }

        });
    }

    /**
     * Updates an update campaign
     * 
     * @param campaign
     *            The campaign to update
     * @return updated update campaign
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Campaign updateCampaign(@NonNull Campaign campaign) throws MbedCloudException {
        return modifyCampaign(campaign, "updateCampaign()");
    }

    /**
     * Deletes an update campaign
     * 
     * @param campaignId
     *            The ID of the update campaign to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteCampaign(@NonNull String campaignId) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final String finalId = campaignId;
        CloudCaller.call(this, "deleteCampaign()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getUpdate().updateCampaignDestroy(finalId);
            }

        });
    }

    /**
     * Starts an update campaign
     * 
     * @param campaignId
     *            The ID of the update campaign to start
     * @return the started campaign
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Campaign startCampaign(@NonNull String campaignId) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final Campaign campaign = new Campaign(campaignId);
        campaign.setState(CampaignState.SCHEDULED);
        return modifyCampaign(campaign, "startCampaign()");
    }

    /**
     * Stops an update campaign
     * 
     * @param campaignId
     *            The ID of the update campaign to stop
     * @return the stopped campaign
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Campaign stopCampaign(@NonNull String campaignId) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final Campaign campaign = new Campaign(campaignId);
        campaign.setState(CampaignState.DRAFT);
        return modifyCampaign(campaign, "stopCampaign()");
    }

    /**
     * Lists campaign devices statuses
     * 
     * @param campaignId
     *            The ID of the update campaign
     * @param options
     *            filter options
     * @return The list of campaign device statuses corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<CampaignDeviceStatus> listCampaignDeviceStatus(@NonNull String campaignId,
            @Nullable CampaignDevicesStatusesListOptions options) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final String finalId = campaignId;
        final CampaignDevicesStatusesListOptions finalOptions = (options == null)
                ? new CampaignDevicesStatusesListOptions() : options;

        return CloudCaller.call(this, "listCampaignDeviceStatus ()", DeviceStatusAdapter.getListMapper(),
                new CloudCall<CampaignDeviceMetadataPage>() {

                    @Override
                    public Call<CampaignDeviceMetadataPage> call() {
                        return endpoint.getUpdate().v3UpdateCampaignsCampaignIdCampaignDeviceMetadataGet(finalId,
                                finalOptions.getLimit(), finalOptions.getOrder().toString(), finalOptions.getAfter(),
                                finalOptions.encodeInclude());
                    }
                });
    }

    /**
     * Gets an iterator over all campaign device statuses according to filter options
     * 
     * @param campaignId
     *            The ID of the update campaign
     * @param options
     *            filter options
     * @return paginator for the list of all campaign device statuses corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<CampaignDeviceStatus> listAllCampaignDeviceStatus(@NonNull String campaignId,
            @Nullable CampaignDevicesStatusesListOptions options) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final String finalId = campaignId;
        final CampaignDevicesStatusesListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<CampaignDeviceStatus>() {

            @Override
            public ListResponse<CampaignDeviceStatus> requestNewPage() throws MbedCloudException {
                return listCampaignDeviceStatus(finalId, finalOptions);
            }
        });
    }

    /**
     * Retrieves module name
     * 
     * @return module name
     */
    @Override
    public String getModuleName() {
        return "Update";
    }
}
