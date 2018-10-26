package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.CampaignDeviceMetadataPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImagePage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifestPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.update.adapters.CampaignAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.CampaignDeviceStateAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.DataFileAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.FirmwareImageAdapter;
import com.arm.mbed.cloud.sdk.update.adapters.FirmwareManifestAdapter;
import com.arm.mbed.cloud.sdk.update.model.Campaign;
import com.arm.mbed.cloud.sdk.update.model.CampaignDeviceState;
import com.arm.mbed.cloud.sdk.update.model.CampaignDevicesStatesListOptions;
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
public class Update extends AbstractApi {

    private static final String KEY_TABLE_PARAMETER = "key_table";
    private static final String TAG_CAMPAIGN_ID = "campaign id";
    private static final String TAG_CAMPAIGN = "campaign";
    private static final String TAG_FIRMWARE_MANIFEST_ID = "firmwareManifestId";
    private static final String TAG_FIRMWARE_MANIFEST = "manifest";
    private static final String TAG_FIRMWARE_IMAGE = "firmware image";
    private static final String TAG_FIRMWARE_IMAGE_ID = "firmwareImageId";
    private final EndPoints endpoint;

    /**
     * Update module constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Update(@NonNull ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Lists all firmware images according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     FirmwareImageListOptions options = new FirmwareImageListOptions();
     *
     *     Calendar date = GregorianCalendar(2017,10,30,10,20,56);
     *     options.addCreatedAtFilter(date.getTime(), FilterOperator.GREATER_THAN);
     *
     *     options.addNameFilter("QuickstartImage", FilterOperator.EQUAL);
     *
     *     ListResponse<FirmwareImage> images = updateApi.listFirmwareImages(options);
     *     for (FirmwareImage image : images) {
     *         System.out.println("Image ID: " + image.getId());
     *         URL url = image.getUrl();
     *     }
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param options
     *            filter options.
     * @return The list of firmware images corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable ListResponse<FirmwareImage>
           listFirmwareImages(@Nullable FirmwareImageListOptions options) throws MbedCloudException {
        final FirmwareImageListOptions finalOptions = (options == null) ? new FirmwareImageListOptions() : options;

        return CloudCaller.call(this, "listFirmwareImages()", FirmwareImageAdapter.getListMapper(),
                                new CloudCall<FirmwareImagePage>() {

                                    @Override
                                    public Call<FirmwareImagePage> call() {
                                        return endpoint.getUpdate().firmwareImageList(finalOptions.getPageSize(),
                                                                                      finalOptions.getOrder()
                                                                                                  .toString(),
                                                                                      finalOptions.getAfter(),
                                                                                      new FilterMarshaller(null).encode(finalOptions.getFilter()),
                                                                                      finalOptions.encodeInclude());
                                    }
                                });
    }

    /**
     * Gets an iterator over all firmware images according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     FirmwareImageListOptions options = new FirmwareImageListOptions();
     *
     *     Calendar date = GregorianCalendar(2017,10,30,10,20,56);
     *     options.addCreatedAtFilter(date.getTime(), FilterOperator.GREATER_THAN);
     *
     *     options.addNameFilter("QuickstartImage", FilterOperator.EQUAL);
     *
     *     Paginator<FirmwareImage> images = updateApi.listAllFirmwareImages(options);
     *     while (images.hasNext()) {
     *         FirmwareImage image = images.next();
     *         System.out.println("FirmwareImage ID: " + image.getId());
     *     }
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of firmware images corresponding to filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<FirmwareImage>
           listAllFirmwareImages(@Nullable FirmwareImageListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new FirmwareImageListOptions() : options,
                               new PageRequester<FirmwareImage>() {

                                   @Override
                                   public ListResponse<FirmwareImage>
                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                       return listFirmwareImages((FirmwareImageListOptions) opt);
                                   }
                               });
    }

    /**
     * Gets details of a firmware image.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String firmwareImageId = "015f4ac587f500000000000100100249";
     *     FirmwareImage image = updateApi.getFirmwareImage(firmwareImageId);
     *     System.out.println("FirmwareImage name: " + image.getName());
     *     assert firmwareImageId == image.getId();
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param firmwareImageId
     *            the firmware image ID.
     * @return firmware image details.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FirmwareImage getFirmwareImage(@NonNull String firmwareImageId) throws MbedCloudException {
        checkNotNull(firmwareImageId, TAG_FIRMWARE_IMAGE_ID);
        final String finalId = firmwareImageId;
        return CloudCaller.call(this, "getFirmwareImage()", FirmwareImageAdapter.getMapper(),
                                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage>
                                           call() {
                                        return endpoint.getUpdate().firmwareImageRetrieve(finalId);
                                    }

                                });
    }

    /**
     * Adds a firmware image.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String fileName = "C:\\Users\\mbedUser\\mbed-cloud-client-example.bin";
     *     FirmwareImage image = new FirmwareImage();
     *     image.setDatafile(fileName);
     *     image.setDescription("Quick start image");
     *     image.setName(fileName.substring(0,fileName.indexOf(".")));
     *
     *     FirmwareImage newImage = updateApi.addFirmwareImage(image);
     *     System.out.println("FirmwareImage URL: " + newImage.getUrl());
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param image
     *            The image to add.
     * @return added image.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FirmwareImage addFirmwareImage(@NonNull FirmwareImage image) throws MbedCloudException {
        checkNotNull(image, TAG_FIRMWARE_IMAGE);
        checkModelValidity(image, TAG_FIRMWARE_IMAGE);
        final FirmwareImage finalImage = image;
        return CloudCaller.call(this, "addFirmwareImage()", FirmwareImageAdapter.getMapper(),
                                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareImage>
                                           call() {
                                        return endpoint.getUpdate().firmwareImageCreate(
                                                                                        DataFileAdapter.reverseMap(finalImage.getDataFile()),
                                                                                        finalImage.getName(),
                                                                                        finalImage.getDescription());
                                    }

                                });
    }

    /**
     * Deletes a firmware image.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String firmwareImageId = "015f4ac587f500000000000100100249";
     *     updateApi.deleteFirmwareImage(firmwareImageId);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param firmwareImageId
     *            The ID of the firmware image to delete.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
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
     * Deletes a firmware image.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     FirmwareImage firmwareImage = updateApi.getFirmwareImage("015f4ac587f500000000000100100249");
     *     updateApi.deleteFirmwareImage(firmwareImage);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param firmwareImage
     *            The firmware image to delete.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteFirmwareImage(@NonNull FirmwareImage firmwareImage) throws MbedCloudException {
        checkNotNull(firmwareImage, TAG_FIRMWARE_IMAGE);
        deleteFirmwareImage(firmwareImage.getId());
    }

    /**
     * Lists all firmware manifests according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     FirmwareManifestListOptions options = new FirmwareManifestListOptions();
     *
     *     Calendar date = GregorianCalendar(2017,10,30,10,20,56);
     *     options.addCreatedAtFilter(date.getTime(), FilterOperator.GREATER_THAN);
     *
     *     options.addNameFilter("QuickstartManifest", FilterOperator.EQUAL);
     *
     *     ListResponse<FirmwareManifest> manifests = updateApi.listFirmwareManifests(options);
     *     for (FirmwareManifest manifest : manifests) {
     *         System.out.println("Manifest ID: " + manifest.getId());
     *         URL url = manifest.getUrl();
     *     }
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param options
     *            filter options
     * @return The list of firmware manifests corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable ListResponse<FirmwareManifest>
           listFirmwareManifests(@Nullable FirmwareManifestListOptions options) throws MbedCloudException {
        final FirmwareManifestListOptions finalOptions = (options == null) ? new FirmwareManifestListOptions()
                                                                           : options;

        return CloudCaller.call(this, "listFirmwareManifests()", FirmwareManifestAdapter.getListMapper(),
                                new CloudCall<FirmwareManifestPage>() {

                                    @Override
                                    public Call<FirmwareManifestPage> call() {
                                        return endpoint.getUpdate().firmwareManifestList(finalOptions.getPageSize(),
                                                                                         finalOptions.getOrder()
                                                                                                     .toString(),
                                                                                         finalOptions.getAfter(),
                                                                                         new FilterMarshaller(null).encode(finalOptions.getFilter()),
                                                                                         finalOptions.encodeInclude());
                                    }
                                });
    }

    /**
     * Gets an iterator over all firmware manifests according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     FirmwareManifestListOptions options = new FirmwareManifestListOptions();
     *
     *     Calendar date = GregorianCalendar(2017,10,30,10,20,56);
     *     options.addCreatedAtFilter(date.getTime(), FilterOperator.GREATER_THAN);
     *
     *     options.addNameFilter("QuickstartManifest", FilterOperator.EQUAL);
     *
     *     Paginator<FirmwareManifest> manifests = updateApi.listAllFirmwareManifests(options);
     *     while (manifests.hasNext()) {
     *         FirmwareManifest image = manifests.next();
     *         System.out.println("FirmwareManifest ID: " + image.getId());
     *     }
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of firmware manifests corresponding to filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<FirmwareManifest>
           listAllFirmwareManifests(@Nullable FirmwareManifestListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new FirmwareManifestListOptions() : options,
                               new PageRequester<FirmwareManifest>() {

                                   @Override
                                   public ListResponse<FirmwareManifest>
                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                       return listFirmwareManifests((FirmwareManifestListOptions) opt);
                                   }
                               });
    }

    /**
     * Get details of a firmware manifest.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String firmwareManifestId = "015f4ac587f500000000000100100249";
     *     FirmwareManifest manifest = updateApi.getFirmwareManifest(firmwareManifestId);
     *     System.out.println("FirmwareManifest name: " + manifest.getName());
     *     assert firmwareManifestId == manifest.getId();
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param firmwareManifestId
     *            The firmware manifest ID.
     * @return corresponding firmware manifest.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FirmwareManifest
           getFirmwareManifest(@NonNull String firmwareManifestId) throws MbedCloudException {
        checkNotNull(firmwareManifestId, TAG_FIRMWARE_MANIFEST_ID);
        final String finalId = firmwareManifestId;
        return CloudCaller.call(this, "getFirmwareManifest()", FirmwareManifestAdapter.getMapper(),
                                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest>
                                           call() {
                                        return endpoint.getUpdate().firmwareManifestRetrieve(finalId);
                                    }

                                });
    }

    /**
     * Adds a firmware manifest.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String fileName = "C:\\Users\\mbedUser\\quickstart.manifest";
     *     FirmwareManifest manifest = new FirmwareManifest();
     *     manifest.setDatafile(fileName);
     *     manifest.setDescription("Quick start manifest");
     *     manifest.setName(manifest.getDatafile().getName());
     *
     *     FirmwareManifest newManifest = updateApi.addFirmwareManifest(manifest);
     *     System.out.println("FirmwareManifest URL: " + newManifest.getUrl());
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param manifest
     *            The manifest to add.
     * @return added manifest.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable FirmwareManifest
           addFirmwareManifest(@NonNull FirmwareManifest manifest) throws MbedCloudException {
        checkNotNull(manifest, TAG_FIRMWARE_MANIFEST);
        checkModelValidity(manifest, TAG_FIRMWARE_MANIFEST);
        final FirmwareManifest finalManifest = manifest;
        return CloudCaller.call(this, "addFirmwareManifest()", FirmwareManifestAdapter.getMapper(),
                                new CloudCall<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.internal.updateservice.model.FirmwareManifest>
                                           call() {
                                        return endpoint.getUpdate()
                                                       .firmwareManifestCreate(DataFileAdapter.reverseMap(finalManifest.getDataFile()),
                                                                               finalManifest.getName(),
                                                                               finalManifest.getDescription(),
                                                                               DataFileAdapter.reverseMap(KEY_TABLE_PARAMETER,
                                                                                                          finalManifest.getDecryptionKeysFile()));
                                    }

                                });
    }

    /**
     * Deletes a firmware manifest.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String firmwareManifestId = "015f4ac587f500000000000100100249";
     *     updateApi.deleteFirmwareManifest(firmwareManifestId);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param firmwareManifestId
     *            The ID of the firmware manifest to delete.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
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
     * Deletes a firmware manifest.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     FirmwareManifest firmwareManifest = updateApi.getFirmwareManifest("015f4ac587f500000000000100100249");
     *     updateApi.deleteFirmwareManifest(firmwareManifest);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param firmwareManifest
     *            The firmware manifest to delete.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteFirmwareManifest(@NonNull FirmwareManifest firmwareManifest) throws MbedCloudException {
        checkNotNull(firmwareManifest, TAG_FIRMWARE_MANIFEST);
        deleteFirmwareManifest(firmwareManifest.getId());
    }

    /**
     * Lists all update campaigns according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     CampaignListOptions options = new CampaignListOptions();
     *
     *     Calendar date = GregorianCalendar(2017,10,30,10,20,56);
     *     options.addCreatedAtFilter(date.getTime(), FilterOperator.GREATER_THAN);
     *
     *     options.addNameFilter("QuickstartCampaign", FilterOperator.EQUAL);
     *     options.addUpdatedFilter("deployed", FilterOperator.EQUAL);
     *
     *     ListResponse<Campaign> campaigns = updateApi.listCampaigns(options);
     *     for (Campaign campaign : campaigns) {
     *         System.out.println("Campaign ID: " + campaign.getId());
     *         System.out.println("Currently in state: " + campaign.getState());
     *     }
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param options
     *            filter options.
     * @return The list of update campaigns corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable ListResponse<Campaign>
           listCampaigns(@Nullable CampaignListOptions options) throws MbedCloudException {
        final CampaignListOptions finalOptions = (options == null) ? new CampaignListOptions() : options;

        return CloudCaller.call(this, "listCampaigns()", CampaignAdapter.getListMapper(),
                                new CloudCall<UpdateCampaignPage>() {

                                    @Override
                                    public Call<UpdateCampaignPage> call() {
                                        return endpoint.getUpdate().updateCampaignList(finalOptions.getPageSize(),
                                                                                       finalOptions.getOrder()
                                                                                                   .toString(),
                                                                                       finalOptions.getAfter(),
                                                                                       CampaignAdapter.FILTERS_MARSHALLER.encode(finalOptions.getFilter()),
                                                                                       finalOptions.encodeInclude());
                                    }
                                });
    }

    /**
     * Gets an iterator over all update campaigns according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     CampaignListOptions options = new CampaignListOptions();
     *
     *     Calendar date = GregorianCalendar(2017,10,30,10,20,56);
     *     options.addCreatedAtFilter(date.getTime(), FilterOperator.GREATER_THAN);
     *
     *     options.addNameFilter("QuickstartCampaign", FilterOperator.EQUAL);
     *     options.addUpdatedFilter("deployed", FilterOperator.EQUAL);
     *
     *     Paginator<Campaign> campaigns = updateApi.listAllCampaigns(options);
     *     while (campaigns.hasNext()) {
     *         Campaign campaign = campaigns.next();
     *         System.out.println("Campaign ID: " + campaign.getId());
     *         System.out.println("Currently in state: " + campaign.getState());
     *     }
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of update campaigns corresponding to filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<Campaign>
           listAllCampaigns(@Nullable CampaignListOptions options) throws MbedCloudException {
        return new Paginator<>((options == null) ? new CampaignListOptions() : options, new PageRequester<Campaign>() {

            @Override
            public ListResponse<Campaign> requestNewPage(ListOptions opt) throws MbedCloudException {
                return listCampaigns((CampaignListOptions) opt);
            }
        });
    }

    /**
     * Gets details of an update campaign.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String campaignId = "015f4ac587f500000000000100109294";
     *     Campaign campaign = updateApi.getCampaign(campaignId);
     *     System.out.println("Campaign name: " + campaign.getName());
     *     assert campaignId == campaign.getId();
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaignId
     *            The update campaign ID.
     * @return the update campaign.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
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
     * Adds an update campaign.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     Campaign campaign = new Campaign();
     *     campaign.setName("QuickstartCampaign");
     *     campaign.setDescription("Quick start campaign");
     *     campaign.setState(CampaignState.DRAFT);
     *
     *     Filters deviceFilter = new Filters();
     *     deviceFilter.add(new Filter("state", FilterOperator.EQUAL, "registered"));
     *     campaign.setDeviceFilter(deviceFilter);
     *
     *     String firmwareManifestId = "015f4ac587f500000000000100100249";
     *     campaign.setManifestId(firmwareManifestId);
     *
     *     Campaign newCampaign = updateApi.addCampaign(campaign);
     *     System.out.println("Campaign state: " + newCampaign.getState());
     *     System.out.println("Campaign ID: " + newCampaign.getId());
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaign
     *            The campaign to add.
     * @return added update campaign.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Campaign addCampaign(@NonNull Campaign campaign) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        checkModelValidity(campaign, TAG_CAMPAIGN);
        final Campaign finalCampaign = campaign;
        return CloudCaller.call(this, "addCampaign()", CampaignAdapter.getMapper(), new CloudCall<UpdateCampaign>() {

            @Override
            public Call<UpdateCampaign> call() {
                return endpoint.getUpdate().updateCampaignCreate(CampaignAdapter.reverseMapAdd(finalCampaign));
            }

        });
    }

    /**
     * Modifies an update campaign.
     *
     * @param campaign
     *            campaign to modify.
     * @param actionName
     *            name of the modification action.
     * @return modified campaign.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @Internal
    private Campaign modifyCampaign(Campaign campaign, String actionName) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        checkNotNull(campaign.getId(), TAG_CAMPAIGN_ID);
        checkModelValidity(campaign, TAG_CAMPAIGN);
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
     * Updates an update campaign.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     CampaignListOptions options = new CampaignListOptions();
     *
     *     Calendar date = GregorianCalendar(2017,10,30,10,20,56);
     *     options.addCreatedAtFilter(date.getTime(), FilterOperator.GREATER_THAN);
     *
     *     options.addNameFilter("QuickstartCampaign", FilterOperator.EQUAL);
     *     options.addUpdatedFilter("deployed", FilterOperator.EQUAL);
     *
     *     ListResponse<Campaign> campaigns = updateApi.listCampaigns(options);
     *     for (Campaign campaign : campaigns) {
     *         campaign.setDescription("Changed description!");
     *         Campaign updatedCampaign = updateApi.updateCampaign(campaign);
     *         System.out.println("Updated campaign in state: " + updatedCampaign.getState());
     *     }
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaign
     *            The campaign to update.
     * @return updated update campaign.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Campaign updateCampaign(@NonNull Campaign campaign) throws MbedCloudException {
        return modifyCampaign(campaign, "updateCampaign()");
    }

    /**
     * Deletes an update campaign.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String campaignId = "015f4ac587f500000000000100109294";
     *     updateApi.deleteCampaign(campaignId);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaignId
     *            The ID of the update campaign to delete.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
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
     * Deletes an update campaign.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     Campaign campaign = updateApi.getCampaign("015f4ac587f500000000000100109294");
     *     updateApi.deleteCampaign(campaign);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaign
     *            The update campaign to delete.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteCampaign(@NonNull Campaign campaign) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        deleteCampaign(campaign.getId());
    }

    /**
     * Starts an update campaign.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String campaignId = "015f4ac587f500000000000100109294";
     *     Campaign campaign = updateApi.startCampaign(updateApi.getCampaign(campaignId));
     *     System.out.println("Started campaign. State: " + campaign.getState());
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaign
     *            the update campaign to start.
     * @return the started campaign.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Campaign startCampaign(@NonNull Campaign campaign) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        campaign.setState(CampaignState.SCHEDULED);
        return modifyCampaign(campaign, "startCampaign()");
    }

    /**
     * Stops an update campaign.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String campaignId = "015f4ac587f500000000000100109294";
     *     Campaign campaign = updateApi.stopCampaign(updateApi.getCampaign(campaignId));
     *     System.out.println("Stopped campaign. State: " + campaign.getState());
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaign
     *            the update campaign to stop.
     * @return the stopped campaign.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Campaign stopCampaign(@NonNull Campaign campaign) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        campaign.setState(CampaignState.DRAFT);
        return modifyCampaign(campaign, "stopCampaign()");
    }

    /**
     * Lists campaign devices states.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String campaignId = "015f4ac587f500000000000100109294";
     *     CampaignDevicesStatesListOptions options = new CampaignDevicesStatesListOptions();
     *     options.setLimit(10);
     *
     *     ListResponse<CampaignDeviceState> states = updateApi.listCampaignDeviceStates(campaignId, options);
     *     for (CampaignDeviceState state : states) {
     *         System.out.println("Device ID: " + state.getId());
     *         System.out.println("Currently in state: " + state.getState());
     *     }
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaignId
     *            The ID of the update campaign.
     * @param options
     *            filter options.
     * @return The list of campaign device states corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable ListResponse<CampaignDeviceState>
           listCampaignDeviceStates(@NonNull String campaignId,
                                    @Nullable CampaignDevicesStatesListOptions options) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final String finalId = campaignId;
        final CampaignDevicesStatesListOptions finalOptions = (options == null) ? new CampaignDevicesStatesListOptions()
                                                                                : options;

        return CloudCaller.call(this, "listCampaignDeviceStates()", CampaignDeviceStateAdapter.getListMapper(),
                                new CloudCall<CampaignDeviceMetadataPage>() {

                                    @Override
                                    public Call<CampaignDeviceMetadataPage> call() {
                                        return endpoint.getUpdate()
                                                       .updateCampaignMetadataList(finalId, finalOptions.getPageSize(),
                                                                                   finalOptions.getOrder().toString(),
                                                                                   finalOptions.getAfter(),
                                                                                   finalOptions.encodeInclude());
                                    }
                                });
    }

    /**
     * Lists campaign devices states.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     Campaign campaign = updateApi.getCampaign("015f4ac587f500000000000100109294");
     *     CampaignDevicesStatesListOptions options = new CampaignDevicesStatesListOptions();
     *     options.setLimit(10);
     *
     *     ListResponse<CampaignDeviceState> states = updateApi.listCampaignDeviceStates(campaign, options);
     *     for (CampaignDeviceState state : states) {
     *         System.out.println("Device ID: " + state.getId());
     *         System.out.println("Currently in state: " + state.getState());
     *     }
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaign
     *            The update campaign.
     * @param options
     *            filter options.
     * @return The list of campaign device states corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable ListResponse<CampaignDeviceState>
           listCampaignDeviceStates(@NonNull Campaign campaign,
                                    @Nullable CampaignDevicesStatesListOptions options) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        return listCampaignDeviceStates(campaign.getId(), options);
    }

    /**
     * Gets an iterator over all campaign device states according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String campaignId = "015f4ac587f500000000000100109294";
     *     CampaignDevicesStatesListOptions options = new CampaignDevicesStatesListOptions();
     *     options.setLimit(10);
     *
     *     Paginator<CampaignDeviceState> states = updateApi.listAllCampaignDeviceStates(campaignId, options);
     *     while (states.hasNext()) {
     *         CampaignDeviceState deviceState = states.next();
     *         System.out.println("Device ID: " + deviceState.getId());
     *         System.out.println("Currently in state: " + deviceState.getState());
     *     }
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaignId
     *            The ID of the update campaign.
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of all campaign device states corresponding to filter
     *         options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<CampaignDeviceState>
           listAllCampaignDeviceStates(@NonNull String campaignId,
                                       @Nullable CampaignDevicesStatesListOptions options) throws MbedCloudException {
        checkNotNull(campaignId, TAG_CAMPAIGN_ID);
        final String finalId = campaignId;
        return new Paginator<>((options == null) ? new CampaignDevicesStatesListOptions() : options,
                               new PageRequester<CampaignDeviceState>() {

                                   @Override
                                   public ListResponse<CampaignDeviceState>
                                          requestNewPage(ListOptions opt) throws MbedCloudException {
                                       return listCampaignDeviceStates(finalId, (CampaignDevicesStatesListOptions) opt);
                                   }
                               });
    }

    /**
     * Gets an iterator over all campaign device states according to filter options.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     Campaign campaign =  updateApi.getCampaign("015f4ac587f500000000000100109294");
     *     CampaignDevicesStatesListOptions options = new CampaignDevicesStatesListOptions();
     *     options.setLimit(10);
     *
     *     Paginator<CampaignDeviceState> states = updateApi.listAllCampaignDeviceStates(campaign, options);
     *     for (CampaignDeviceState deviceState:states) {
     *         System.out.println("Device ID: " + deviceState.getId());
     *         System.out.println("Currently in state: " + deviceState.getState());
     *     }
     *
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param campaign
     *            The update campaign.
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of all campaign device states corresponding to filter
     *         options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<CampaignDeviceState>
           listAllCampaignDeviceStates(@NonNull Campaign campaign,
                                       @Nullable CampaignDevicesStatesListOptions options) throws MbedCloudException {
        checkNotNull(campaign, TAG_CAMPAIGN);
        return listAllCampaignDeviceStates(campaign.getId(), options);
    }

    /**
     * Retrieves module name.
     *
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Update";
    }
}
