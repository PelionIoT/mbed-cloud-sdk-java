// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.deviceupdate.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.deviceupdate.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaignPutRequest;
import java.util.List;

/**
 * Adapter for update campaigns.
 */
@Preamble(description = "Adapter for update campaigns.")
@Internal
@SuppressWarnings("checkstyle:LineLength")
public final class UpdateCampaignAdapter {
    /**
     * Constructor.
     */
    private UpdateCampaignAdapter() {
        super();
        // Nothing to do;
    }

    /**
     * Maps an update campaign into an update campaign.
     * 
     * @param toBeMapped
     *            an update campaign.
     * @return mapped an update campaign
     */
    @Internal
    public static UpdateCampaign
           map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final UpdateCampaign updateCampaign = new UpdateCampaign(toBeMapped.getAutostopReason(),
                                                                 TranslationUtils.toDate(toBeMapped.getCreatedAt()),
                                                                 TranslationUtils.toDate(toBeMapped.getFinished()),
                                                                 toBeMapped.getPhase(), toBeMapped.getRootManifestUrl(),
                                                                 TranslationUtils.toDate(toBeMapped.getStartedAt()),
                                                                 TranslationUtils.toDate(toBeMapped.getUpdatedAt()));
        updateCampaign.setDescription(toBeMapped.getDescription());
        updateCampaign.setDeviceFilter(toBeMapped.getDeviceFilter());
        // No field equivalent to deviceFilterHelper in UpdateCampaign was found in
        // com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign
        updateCampaign.setId(toBeMapped.getId());
        updateCampaign.setName(toBeMapped.getName());
        updateCampaign.setRootManifestId(toBeMapped.getRootManifestId());
        updateCampaign.setWhen(TranslationUtils.toDate(toBeMapped.getWhen()));
        return updateCampaign;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static
           GenericAdapter.Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign,
                                 UpdateCampaign>
           getMapper() {
        return new GenericAdapter.Mapper<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign,
                                         UpdateCampaign>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public UpdateCampaign
                   map(com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign toBeMapped) {
                return UpdateCampaignAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps an update campaign into an update campaign post request.
     * 
     * @param toBeMapped
     *            an update campaign.
     * @return mapped an update campaign post request
     */
    @Internal
    public static UpdateCampaignPostRequest reverseMapAddRequest(UpdateCampaign toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final UpdateCampaignPostRequest updateCampaignPostRequest = new UpdateCampaignPostRequest();
        updateCampaignPostRequest.setDescription(toBeMapped.getDescription());
        updateCampaignPostRequest.setDeviceFilter(toBeMapped.getDeviceFilter());
        updateCampaignPostRequest.setName(toBeMapped.getName());
        // No field equivalent to object in UpdateCampaignPostRequest was found in UpdateCampaign
        updateCampaignPostRequest.setRootManifestId(toBeMapped.getRootManifestId());
        // No field equivalent to state in UpdateCampaignPostRequest was found in UpdateCampaign
        updateCampaignPostRequest.setWhen(TranslationUtils.toDateTime(toBeMapped.getWhen()));
        return updateCampaignPostRequest;
    }

    /**
     * Maps an update campaign page into an update campaign.
     * 
     * @param toBeMapped
     *            an update campaign page.
     * @return mapped list response
     */
    @Internal
    public static ListResponse<UpdateCampaign> mapList(UpdateCampaignPage toBeMapped) {
        final UpdateCampaignPage finalList = toBeMapped;
        final GenericAdapter.RespList<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign> respList = new GenericAdapter.RespList<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign>() {
            /**
             * Executes getAfter.
             * 
             * @return something
             */
            @Override
            public String getAfter() {
                return (finalList == null) ? null : finalList.getAfter();
            }

            /**
             * Executes getContinuationMarker.
             * 
             * @return something
             */
            @Override
            public String getContinuationMarker() {
                return null;
            }

            /**
             * Executes getData.
             * 
             * @return something
             */
            @Override
            public List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.UpdateCampaign> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            /**
             * Executes getHasMore.
             * 
             * @return something
             */
            @Override
            public Boolean getHasMore() {
                return (finalList == null) ? null : finalList.isHasMore();
            }

            /**
             * Executes getLimit.
             * 
             * @return something
             */
            @Override
            public Integer getLimit() {
                return (finalList == null) ? null : finalList.getLimit();
            }

            /**
             * Executes getOrder.
             * 
             * @return something
             */
            @Override
            public String getOrder() {
                return (finalList == null) ? null : finalList.getOrder().toString();
            }

            /**
             * Executes getTotalCount.
             * 
             * @return something
             */
            @Override
            public Integer getTotalCount() {
                return (finalList == null) ? null : finalList.getTotalCount();
            }
        };
        return GenericAdapter.mapList(respList, UpdateCampaignAdapter.getMapper());
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<UpdateCampaignPage, ListResponse<UpdateCampaign>> getListMapper() {
        return new GenericAdapter.Mapper<UpdateCampaignPage, ListResponse<UpdateCampaign>>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public ListResponse<UpdateCampaign> map(UpdateCampaignPage toBeMapped) {
                return UpdateCampaignAdapter.mapList(toBeMapped);
            }
        };
    }

    /**
     * Maps an update campaign into an update campaign put request.
     * 
     * @param toBeMapped
     *            an update campaign.
     * @return mapped an update campaign put request
     */
    @Internal
    public static UpdateCampaignPutRequest reverseMapUpdateRequest(UpdateCampaign toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final UpdateCampaignPutRequest updateCampaignPutRequest = new UpdateCampaignPutRequest();
        updateCampaignPutRequest.setDescription(toBeMapped.getDescription());
        updateCampaignPutRequest.setDeviceFilter(toBeMapped.getDeviceFilter());
        updateCampaignPutRequest.setName(toBeMapped.getName());
        // No field equivalent to object in UpdateCampaignPutRequest was found in UpdateCampaign
        updateCampaignPutRequest.setRootManifestId(toBeMapped.getRootManifestId());
        // No field equivalent to state in UpdateCampaignPutRequest was found in UpdateCampaign
        updateCampaignPutRequest.setWhen(TranslationUtils.toDateTime(toBeMapped.getWhen()));
        return updateCampaignPutRequest;
    }
}