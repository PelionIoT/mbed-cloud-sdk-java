package com.arm.mbed.cloud.sdk.billing.adapters;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.billing.model.QuotaHistory;
import com.arm.mbed.cloud.sdk.billing.model.Reservation;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackage;
import com.arm.mbed.cloud.sdk.billing.model.ServicePackageState;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ActiveServicePackage;
import com.arm.mbed.cloud.sdk.internal.billing.model.PendingServicePackage;
import com.arm.mbed.cloud.sdk.internal.billing.model.PreviousServicePackage;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryItem;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryReservation;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryResponse;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackageQuotaHistoryServicePackage;
import com.arm.mbed.cloud.sdk.internal.billing.model.ServicePackagesResponse;

@Preamble(description = "Adapter for Billing entities")
@Internal
public final class BillingEntityAdapter {

    private BillingEntityAdapter() {
        super();
    }

    /**
     * Maps service package.
     *
     * @param toBeMapped
     *            package response from Mbed Cloud.
     * @return corresponding service package.
     */
    public static <T extends Object> ServicePackage map(T toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        if (toBeMapped instanceof ActiveServicePackage) {
            final ActiveServicePackage raw = (ActiveServicePackage) toBeMapped;
            return new ServicePackage(raw.getId(), TranslationUtils.toDate(raw.getCreated()),
                    TranslationUtils.toDate(raw.getStartTime()), TranslationUtils.toDate(raw.getExpires()), null,
                    TranslationUtils.toDate(raw.getModified()), TranslationUtils.toBool(raw.isGracePeriod(), false),
                    TranslationUtils.toLong(raw.getFirmwareUpdateCount()), raw.getPreviousId(), raw.getNextId(), null,
                    ServicePackageState.ACTIVE);
        } else if (toBeMapped instanceof PendingServicePackage) {
            final PendingServicePackage raw = (PendingServicePackage) toBeMapped;
            return new ServicePackage(raw.getId(), TranslationUtils.toDate(raw.getCreated()),
                    TranslationUtils.toDate(raw.getStartTime()), TranslationUtils.toDate(raw.getExpires()), null,
                    TranslationUtils.toDate(raw.getModified()), false,
                    TranslationUtils.toLong(raw.getFirmwareUpdateCount()), raw.getPreviousId(), null, null,
                    ServicePackageState.PENDING);
        } else if (toBeMapped instanceof PreviousServicePackage) {
            final PreviousServicePackage raw = (PreviousServicePackage) toBeMapped;
            return new ServicePackage(raw.getId(), TranslationUtils.toDate(raw.getCreated()),
                    TranslationUtils.toDate(raw.getStartTime()), TranslationUtils.toDate(raw.getExpires()),
                    TranslationUtils.toDate(raw.getEndTime()), TranslationUtils.toDate(raw.getModified()), false,
                    TranslationUtils.toLong(raw.getFirmwareUpdateCount()), raw.getPreviousId(), raw.getNextId(),
                    raw.getReason() == null ? null : raw.getReason().toString(), ServicePackageState.PREVIOUS);
        } else if (toBeMapped instanceof ServicePackageQuotaHistoryServicePackage) {
            final ServicePackageQuotaHistoryServicePackage raw = (ServicePackageQuotaHistoryServicePackage) toBeMapped;
            return new ServicePackage(raw.getId(), null, TranslationUtils.toDate(raw.getStartTime()),
                    TranslationUtils.toDate(raw.getExpires()), null, null, false,
                    TranslationUtils.toLong(raw.getFirmwareUpdateCount()), raw.getPreviousId(), null, null,
                    ServicePackageState.PREVIOUS);
        }
        return null;
    }

    /**
     * Maps reservation.
     *
     * @param toBeMapped
     *            reservation from Mbed Cloud.
     * @return corresponding reservation.
     */
    public static Reservation mapReservation(ServicePackageQuotaHistoryReservation toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        return new Reservation(toBeMapped.getId(), toBeMapped.getCampaignName(), toBeMapped.getAccountId());
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper.
     */
    public static <T extends Object> Mapper<T, ServicePackage> getMapper() {

        return new Mapper<T, ServicePackage>() {

            @Override
            public ServicePackage map(T toBeMapped) {
                return BillingEntityAdapter.map(toBeMapped);
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
    public static List<ServicePackage> mapList(ServicePackagesResponse list) {
        if (list == null) {
            return null;
        }
        final List<ServicePackage> mappedList = new LinkedList<>();
        final ServicePackage pendingPackage = BillingEntityAdapter.map(list.getPending());
        final ServicePackage activePackage = BillingEntityAdapter.map(list.getActive());
        final List<ServicePackage> previousList = GenericAdapter.mapList(list.getPrevious(),
                BillingEntityAdapter.getMapper());
        if (pendingPackage != null) {
            mappedList.add(pendingPackage);
        }
        if (activePackage != null) {
            mappedList.add(activePackage);
        }
        if (previousList != null) {
            mappedList.addAll(previousList);
        }
        return mappedList.isEmpty() ? null : mappedList;
    }

    /**
     * Gets a list mapper.
     *
     * @return a list mapper.
     */
    public static Mapper<ServicePackagesResponse, List<ServicePackage>> getListMapper() {
        return new Mapper<ServicePackagesResponse, List<ServicePackage>>() {

            @Override
            public List<ServicePackage> map(ServicePackagesResponse toBeMapped) {
                return BillingEntityAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Maps service package quota history.
     *
     * @param toBeMapped
     *            quotahistory
     * @return corresponding service package.
     */
    public static QuotaHistory mapQuotaHistory(ServicePackageQuotaHistoryItem toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        return new QuotaHistory(toBeMapped.getId(), TranslationUtils.toDate(toBeMapped.getAdded()),
                TranslationUtils.toLong(toBeMapped.getAmount()),
                toBeMapped.getReason() == null ? null : toBeMapped.getReason().toString(),
                toBeMapped.getServicePackage() == null
                        ? BillingEntityAdapter.mapReservation(toBeMapped.getReservation())
                        : BillingEntityAdapter.map(toBeMapped.getServicePackage()));
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper.
     */
    public static Mapper<ServicePackageQuotaHistoryItem, QuotaHistory> getHistoryQuotaMapper() {

        return new Mapper<ServicePackageQuotaHistoryItem, QuotaHistory>() {

            @Override
            public QuotaHistory map(ServicePackageQuotaHistoryItem toBeMapped) {
                return BillingEntityAdapter.mapQuotaHistory(toBeMapped);
            }
        };
    }

    /**
     * Maps list of service package quota history.
     *
     * @param list
     *            quotahistory list
     * @return corresponding service package.
     */
    public static ListResponse<QuotaHistory> mapQuotaHistoryList(ServicePackageQuotaHistoryResponse list) {
        final ServicePackageQuotaHistoryResponse finalList = list;
        final RespList<ServicePackageQuotaHistoryItem> respList = new RespList<ServicePackageQuotaHistoryItem>() {

            @Override
            public Boolean getHasMore() {
                return (finalList == null) ? null : finalList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (finalList == null) ? null : finalList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (finalList == null) ? null : finalList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (finalList == null) ? null : finalList.getLimit();
            }

            @Override
            public String getOrder() {
                return null;
            }

            @Override
            public List<ServicePackageQuotaHistoryItem> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

        };
        return GenericAdapter.mapList(respList, getHistoryQuotaMapper());
    }

    /**
     * Gets a mapper.
     *
     * @return a mapper.
     */
    public static Mapper<ServicePackageQuotaHistoryResponse, ListResponse<QuotaHistory>> getHistoryQuotaListMapper() {

        return new Mapper<ServicePackageQuotaHistoryResponse, ListResponse<QuotaHistory>>() {

            @Override
            public ListResponse<QuotaHistory> map(ServicePackageQuotaHistoryResponse toBeMapped) {
                return BillingEntityAdapter.mapQuotaHistoryList(toBeMapped);
            }
        };
    }
}
