package com.arm.mbed.cloud.sdk.update.adapters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaign.StateEnum;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPage;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPostRequest;
import com.arm.mbed.cloud.sdk.internal.updateservice.model.UpdateCampaignPutRequest;
import com.arm.mbed.cloud.sdk.update.model.Campaign;
import com.arm.mbed.cloud.sdk.update.model.CampaignListOptions;
import com.arm.mbed.cloud.sdk.update.model.CampaignState;

@Preamble(description = "Adapter for campaign model")
@Internal
public final class CampaignAdapter {
    public static final FilterMarshaller FILTERS_MARSHALLER = getFilterMarshaller();

    private CampaignAdapter() {
        super();
    }

    private static FilterMarshaller getFilterMarshaller() {
        final Map<String, String> filterMapping = new HashMap<>(4);
        filterMapping.put(CampaignListOptions.FINISHED_AT_FILTER, "finished");
        filterMapping.put(CampaignListOptions.MANIFEST_ID_FILTER, "root_manifest_id");
        filterMapping.put(CampaignListOptions.MANIFEST_URL_FILTER, "root_manifest_url");
        filterMapping.put(CampaignListOptions.SCHEDULED_AT_FILTER, "when");
        return new FilterMarshaller(filterMapping);
    }

    /**
     * Maps campaign.
     * 
     * @param campaign
     *            campaign result
     * @return campaign
     */
    public static Campaign map(UpdateCampaign campaign) {
        if (campaign == null) {
            return null;
        }
        final Campaign updateCampaign = new Campaign(campaign.getId(),
                TranslationUtils.toUrl(campaign.getRootManifestUrl()), TranslationUtils.toDate(campaign.getCreatedAt()),
                TranslationUtils.toDate(campaign.getStartedAt()), TranslationUtils.toDate(campaign.getFinished()),
                TranslationUtils.toDate(campaign.getUpdatedAt()));
        updateCampaign.setDescription(campaign.getDescription());
        updateCampaign.setManifestId(campaign.getRootManifestId());
        updateCampaign.setName(campaign.getName());
        updateCampaign.setScheduledAt(TranslationUtils.toDate(campaign.getWhen()));
        updateCampaign.setState(toState(campaign.getState()));
        updateCampaign.setDeviceFilters(decodeFilters(campaign.getDeviceFilter()));
        return updateCampaign;
    }

    /**
     * Gets mapper.
     * 
     * @return a mapper
     */
    public static Mapper<UpdateCampaign, Campaign> getMapper() {
        return new Mapper<UpdateCampaign, Campaign>() {

            @Override
            public Campaign map(UpdateCampaign toBeMapped) {
                return CampaignAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Reverses mapping of a new campaign.
     * 
     * @param campaign
     *            new campaign
     * @return new campaign request
     */
    public static UpdateCampaignPostRequest reverseMapAdd(Campaign campaign) {
        if (campaign == null) {
            return null;
        }
        final UpdateCampaignPostRequest addRequest = new UpdateCampaignPostRequest();
        addRequest.setDescription(campaign.getDescription());
        addRequest.setDeviceFilter(encodeFilters(campaign.getFilter()));
        addRequest.setName(campaign.getName());
        addRequest.setRootManifestId(campaign.getManifestId());
        addRequest.setState(toPostStateEnum(campaign.getState()));
        addRequest.setWhen(TranslationUtils.moveToUtc(campaign.getScheduledAt()));
        return addRequest;
    }

    /**
     * Reverses mapping of an updated campaign.
     * 
     * @param campaign
     *            an updated campaign
     * @return campaign update request
     */
    public static UpdateCampaignPutRequest reverseMapUpdate(Campaign campaign) {
        if (campaign == null) {
            return null;
        }
        final UpdateCampaignPutRequest updateRequest = new UpdateCampaignPutRequest();
        updateRequest.setDescription(campaign.getDescription());
        updateRequest.setDeviceFilter(encodeFilters(campaign.getFilter()));
        updateRequest.setName(campaign.getName());
        updateRequest.setRootManifestId(campaign.getManifestId());
        updateRequest.setState(toPutStateEnum(campaign.getState()));
        updateRequest.setWhen(TranslationUtils.moveToUtc(campaign.getScheduledAt()));
        return updateRequest;
    }

    private static String encodeFilters(Filters filters) {
        return FILTERS_MARSHALLER.encode(filters);
    }

    private static Filters decodeFilters(String filters) {
        return FILTERS_MARSHALLER.decode(filters);
    }

    private static CampaignState toState(StateEnum state) {
        if (state == null) {
            return CampaignState.getUnknownEnum();
        }
        switch (state) {
            case ALLOCATEDQUOTA:
                return CampaignState.ALLOCATED_QUOTA;
            case ALLOCATINGQUOTA:
                return CampaignState.ALLOCATING_QUOTA;
            case QUOTAALLOCATIONFAILED:
                return CampaignState.ALLOCATING_QUOTA_FAILED;
            case AUTOSTOPPED:
                return CampaignState.AUTO_STOPPED;
            case CHECKEDMANIFEST:
                return CampaignState.CHECKED_MANIFEST;
            case CHECKINGMANIFEST:
                return CampaignState.CHECKING_MANIFEST;
            case CONFLICT:
                return CampaignState.CONFLICT;
            case DEPLOYED:
                return CampaignState.DEPLOYED;
            case DEPLOYING:
                return CampaignState.DEPLOYING;
            case DEVICECHECK:
                return CampaignState.DEVICE_CHECK;
            case DEVICECOPY:
                return CampaignState.DEVICE_COPY;
            case DEVICEFETCH:
                return CampaignState.DEVICE_FETCH;
            case DRAFT:
                return CampaignState.DRAFT;
            case EXPIRED:
                return CampaignState.EXPIRED;
            case MANIFESTREMOVED:
                return CampaignState.MANIFEST_REMOVED;
            case PUBLISHING:
                return CampaignState.PUBLISHING;
            case SCHEDULED:
                return CampaignState.SCHEDULED;
            case STOPPING:
                return CampaignState.STOPPING;
            case USERSTOPPED:
                return CampaignState.USER_STOPPED;
            default:
                break;
        }
        return CampaignState.getUnknownEnum();
    }

    private static UpdateCampaignPostRequest.StateEnum toPostStateEnum(CampaignState state) {
        if (state == null) {
            return null;
        }
        switch (state) {
            case ALLOCATED_QUOTA:
                return UpdateCampaignPostRequest.StateEnum.ALLOCATEDQUOTA;
            case ALLOCATING_QUOTA:
                return UpdateCampaignPostRequest.StateEnum.ALLOCATINGQUOTA;
            case ALLOCATING_QUOTA_FAILED:
                return UpdateCampaignPostRequest.StateEnum.QUOTAALLOCATIONFAILED;
            case AUTO_STOPPED:
                return UpdateCampaignPostRequest.StateEnum.AUTOSTOPPED;
            case CHECKED_MANIFEST:
                return UpdateCampaignPostRequest.StateEnum.CHECKEDMANIFEST;
            case CHECKING_MANIFEST:
                return UpdateCampaignPostRequest.StateEnum.CHECKINGMANIFEST;
            case CONFLICT:
                return UpdateCampaignPostRequest.StateEnum.CONFLICT;
            case DEPLOYED:
                return UpdateCampaignPostRequest.StateEnum.DEPLOYED;
            case DEPLOYING:
                return UpdateCampaignPostRequest.StateEnum.DEPLOYING;
            case DEVICE_CHECK:
                return UpdateCampaignPostRequest.StateEnum.DEVICECHECK;
            case DEVICE_COPY:
                return UpdateCampaignPostRequest.StateEnum.DEVICECOPY;
            case DEVICE_FETCH:
                return UpdateCampaignPostRequest.StateEnum.DEVICEFETCH;
            case DRAFT:
                return UpdateCampaignPostRequest.StateEnum.DRAFT;
            case EXPIRED:
                return UpdateCampaignPostRequest.StateEnum.EXPIRED;
            case MANIFEST_REMOVED:
                return UpdateCampaignPostRequest.StateEnum.MANIFESTREMOVED;
            case PUBLISHING:
                return UpdateCampaignPostRequest.StateEnum.PUBLISHING;
            case SCHEDULED:
                return UpdateCampaignPostRequest.StateEnum.SCHEDULED;
            case STOPPING:
                return UpdateCampaignPostRequest.StateEnum.STOPPING;
            case UNKNOWN_ENUM:
                break;
            case USER_STOPPED:
                return UpdateCampaignPostRequest.StateEnum.USERSTOPPED;
            default:
                break;

        }
        return null;
    }

    private static UpdateCampaignPutRequest.StateEnum toPutStateEnum(CampaignState state) {
        if (state == null) {
            return null;
        }
        switch (state) {
            case ALLOCATED_QUOTA:
                return UpdateCampaignPutRequest.StateEnum.ALLOCATEDQUOTA;
            case ALLOCATING_QUOTA:
                return UpdateCampaignPutRequest.StateEnum.ALLOCATINGQUOTA;
            case ALLOCATING_QUOTA_FAILED:
                return UpdateCampaignPutRequest.StateEnum.QUOTAALLOCATIONFAILED;
            case AUTO_STOPPED:
                return UpdateCampaignPutRequest.StateEnum.AUTOSTOPPED;
            case CHECKED_MANIFEST:
                return UpdateCampaignPutRequest.StateEnum.CHECKEDMANIFEST;
            case CHECKING_MANIFEST:
                return UpdateCampaignPutRequest.StateEnum.CHECKINGMANIFEST;
            case CONFLICT:
                return UpdateCampaignPutRequest.StateEnum.CONFLICT;
            case DEPLOYED:
                return UpdateCampaignPutRequest.StateEnum.DEPLOYED;
            case DEPLOYING:
                return UpdateCampaignPutRequest.StateEnum.DEPLOYING;
            case DEVICE_CHECK:
                return UpdateCampaignPutRequest.StateEnum.DEVICECHECK;
            case DEVICE_COPY:
                return UpdateCampaignPutRequest.StateEnum.DEVICECOPY;
            case DEVICE_FETCH:
                return UpdateCampaignPutRequest.StateEnum.DEVICEFETCH;
            case DRAFT:
                return UpdateCampaignPutRequest.StateEnum.DRAFT;
            case EXPIRED:
                return UpdateCampaignPutRequest.StateEnum.EXPIRED;
            case MANIFEST_REMOVED:
                return UpdateCampaignPutRequest.StateEnum.MANIFESTREMOVED;
            case PUBLISHING:
                return UpdateCampaignPutRequest.StateEnum.PUBLISHING;
            case SCHEDULED:
                return UpdateCampaignPutRequest.StateEnum.SCHEDULED;
            case STOPPING:
                return UpdateCampaignPutRequest.StateEnum.STOPPING;
            case UNKNOWN_ENUM:
                break;
            case USER_STOPPED:
                return UpdateCampaignPutRequest.StateEnum.USERSTOPPED;
            default:
                break;

        }
        return null;
    }

    /**
     * Maps a list of campaigns.
     * 
     * @param list
     *            campaign page.
     * @return a list of campaigns
     */
    public static ListResponse<Campaign> mapList(UpdateCampaignPage list) {

        final UpdateCampaignPage campaignList = list;
        final RespList<UpdateCampaign> respList = new RespList<UpdateCampaign>() {

            @Override
            public Boolean getHasMore() {
                return (campaignList == null) ? null : campaignList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (campaignList == null) ? null : campaignList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (campaignList == null) ? null : campaignList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (campaignList == null) ? null : campaignList.getLimit();
            }

            @Override
            public String getOrder() {
                return (campaignList == null) ? null : campaignList.getOrder().toString();
            }

            @Override
            public List<UpdateCampaign> getData() {
                return (campaignList == null) ? null : campaignList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    /**
     * Gets list mapper.
     * 
     * @return list mapper
     */
    public static Mapper<UpdateCampaignPage, ListResponse<Campaign>> getListMapper() {
        return new Mapper<UpdateCampaignPage, ListResponse<Campaign>>() {

            @Override
            public ListResponse<Campaign> map(UpdateCampaignPage toBeMapped) {
                return CampaignAdapter.mapList(toBeMapped);
            }

        };
    }

}
