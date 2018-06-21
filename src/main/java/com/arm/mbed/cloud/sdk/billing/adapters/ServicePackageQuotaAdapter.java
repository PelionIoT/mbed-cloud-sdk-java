package com.arm.mbed.cloud.sdk.billing.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackageQuota;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryItem;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryResponse;

@Preamble(description = "Adapter for Service Package Quota")
@Internal
public final class ServicePackageQuotaAdapter {

    private ServicePackageQuotaAdapter() {
        super();
    }

    /**
     * Maps service quota.
     *
     * @param serviceQuota
     *            response from Mbed Cloud.
     * @return corresponding service quota.
     */
    public static ServicePackageQuota map(
            com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota serviceQuota) {
        if (serviceQuota == null) {
            return null;
        }
        return new ServicePackageQuota(TranslationUtils.toLong(serviceQuota.getQuota()));

    }

    /**
     * Maps service quota.
     *
     * @param serviceQuota
     *            response from Mbed Cloud.
     * @return corresponding service quota.
     */
    public static ServicePackageQuota mapHistoricalQuota(ServicePackageQuotaHistoryItem serviceQuota) {
        if (serviceQuota == null) {
            return null;
        }
        return new ServicePackageQuota(serviceQuota.getId(), TranslationUtils.toDate(serviceQuota.getAdded()),
                TranslationUtils.toLong(serviceQuota.getAmount()));

    }

    /**
     * Gets a mapper.
     *
     * @return a mapper.
     */
    public static Mapper<ServicePackageQuotaHistoryItem, ServicePackageQuota> getHistoricalServicePackageQuotaMapper() {
        return new Mapper<ServicePackageQuotaHistoryItem, ServicePackageQuota>() {

            @Override
            public ServicePackageQuota map(ServicePackageQuotaHistoryItem toBeMapped) {
                return ServicePackageQuotaAdapter.mapHistoricalQuota(toBeMapped);
            }

        };
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper.
     */
    public static Mapper<com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota, ServicePackageQuota> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota, ServicePackageQuota>() {

            @Override
            public ServicePackageQuota map(
                    com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuota toBeMapped) {
                return ServicePackageQuotaAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Maps list of service package quota.
     *
     * @param list
     *            service package quota list to map.
     * @return a list of mapped service package quotas.
     */
    public static ListResponse<ServicePackageQuota> mapList(ServicePackageQuotaHistoryResponse list) {

        final ServicePackageQuotaHistoryResponse servicePackageQuotaList = list;
        final RespList<ServicePackageQuotaHistoryItem> respList = new RespList<ServicePackageQuotaHistoryItem>() {

            @Override
            public Boolean getHasMore() {
                return (servicePackageQuotaList == null) ? null : servicePackageQuotaList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (servicePackageQuotaList == null) ? null : servicePackageQuotaList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (servicePackageQuotaList == null) ? null : servicePackageQuotaList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (servicePackageQuotaList == null) ? null : servicePackageQuotaList.getLimit();
            }

            @Override
            public String getOrder() {
                return null;
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

            @Override
            public List<ServicePackageQuotaHistoryItem> getData() {
                return (servicePackageQuotaList == null) ? null : servicePackageQuotaList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getHistoricalServicePackageQuotaMapper());
    }

    /**
     * Gets a list mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<ServicePackageQuotaHistoryResponse, ListResponse<ServicePackageQuota>> getListMapper() {
        return new Mapper<ServicePackageQuotaHistoryResponse, ListResponse<ServicePackageQuota>>() {

            @Override
            public ListResponse<ServicePackageQuota> map(ServicePackageQuotaHistoryResponse toBeMapped) {
                return ServicePackageQuotaAdapter.mapList(toBeMapped);
            }

        };
    }

}
