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
import com.arm.mbed.cloud.sdk.update.model.CampaignState;

@Preamble(description = "Adapter for campaign model")
@Internal
public class CampaignAdapter {
    public static final FilterMarshaller FILTERS_MARSHALLER = getFilterMarshaller();

    private static FilterMarshaller getFilterMarshaller() {
        Map<String, String> filterMapping = new HashMap<>(4);
        filterMapping.put("finishedAt", "finished");
        filterMapping.put("manifestId", "root_manifest_id");
        filterMapping.put("manifestUrl", "root_manifest_url");
        filterMapping.put("scheduledAt", "when");
        return new FilterMarshaller(filterMapping);
    }

    public static Campaign map(UpdateCampaign campaign) {
        if (campaign == null) {
            return null;
        }
        Campaign updateCampaign = new Campaign(campaign.getId(), TranslationUtils.toUrl(campaign.getRootManifestUrl()),
                TranslationUtils.toDate(campaign.getCreatedAt()), TranslationUtils.toDate(campaign.getStartedAt()),
                TranslationUtils.toDate(campaign.getFinished()));
        updateCampaign.setDescription(campaign.getDescription());
        updateCampaign.setManifestId(campaign.getRootManifestId());
        updateCampaign.setName(campaign.getName());
        updateCampaign.setScheduledAt(TranslationUtils.toDate(campaign.getFinished()));
        updateCampaign.setState(toState(campaign.getState()));
        updateCampaign.setDeviceFilter(decodeFilters(campaign.getDeviceFilter()));
        return updateCampaign;
    }

    public static Mapper<UpdateCampaign, Campaign> getMapper() {
        return new Mapper<UpdateCampaign, Campaign>() {

            @Override
            public Campaign map(UpdateCampaign toBeMapped) {
                return CampaignAdapter.map(toBeMapped);
            }

        };
    }

    public static UpdateCampaignPostRequest reverseMapAdd(Campaign campaign) {
        if (campaign == null) {
            return null;
        }
        UpdateCampaignPostRequest addRequest = new UpdateCampaignPostRequest();
        addRequest.setDescription(campaign.getDescription());
        addRequest.setDeviceFilter(encodeFilters(campaign.getFilter()));
        addRequest.setName(campaign.getName());
        addRequest.setRootManifestId(campaign.getManifestId());
        addRequest.setState(toPostStateEnum(campaign.getState()));
        addRequest.setWhen(TranslationUtils.toRFC3339Timestamp(campaign.getScheduledAt()));
        return addRequest;
    }

    public static UpdateCampaignPutRequest reverseMapUpdate(Campaign campaign) {
        if (campaign == null) {
            return null;
        }
        UpdateCampaignPutRequest updateRequest = new UpdateCampaignPutRequest();
        updateRequest.setDescription(campaign.getDescription());
        updateRequest.setDeviceFilter(encodeFilters(campaign.getFilter()));
        updateRequest.setName(campaign.getName());
        updateRequest.setRootManifestId(campaign.getManifestId());
        updateRequest.setState(toPutStateEnum(campaign.getState()));
        updateRequest.setWhen(TranslationUtils.toRFC3339Timestamp(campaign.getScheduledAt()));
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
            return CampaignState.getDefault();
        }
        switch (state) {
            case DEPLOYED:
                return CampaignState.DEPLOYED;
            case DEPLOYING:
                return CampaignState.DEPLOYING;
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
            default:
                break;

        }
        return CampaignState.getDefault();
    }

    private static UpdateCampaignPostRequest.StateEnum toPostStateEnum(CampaignState state) {
        if (state == null) {
            return null;
        }
        switch (state) {
            case DEPLOYED:
                return UpdateCampaignPostRequest.StateEnum.DEPLOYED;
            case DEPLOYING:
                return UpdateCampaignPostRequest.StateEnum.DEPLOYING;
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
            case DEPLOYED:
                return UpdateCampaignPutRequest.StateEnum.DEPLOYED;
            case DEPLOYING:
                return UpdateCampaignPutRequest.StateEnum.DEPLOYING;
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
            default:
                break;

        }
        return null;
    }

    public static ListResponse<Campaign> mapList(UpdateCampaignPage list) {

        final UpdateCampaignPage campaignList = list;
        RespList<UpdateCampaign> respList = new RespList<UpdateCampaign>() {

            @Override
            public Boolean getHasMore() {
                return (campaignList == null) ? null : campaignList.getHasMore();
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

    public static Mapper<UpdateCampaignPage, ListResponse<Campaign>> getListMapper() {
        return new Mapper<UpdateCampaignPage, ListResponse<Campaign>>() {

            @Override
            public ListResponse<Campaign> map(UpdateCampaignPage toBeMapped) {
                return CampaignAdapter.mapList(toBeMapped);
            }

        };
    }

}
