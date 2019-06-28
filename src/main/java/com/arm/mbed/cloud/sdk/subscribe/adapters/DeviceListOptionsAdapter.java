package com.arm.mbed.cloud.sdk.subscribe.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devices.model.DeviceState;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Adapter for device list options")
@Internal
public final class DeviceListOptionsAdapter {

    private DeviceListOptionsAdapter() {
        super();
    }

    /**
     * Maps subscription options into device list options.
     *
     * @param filters
     *            subscription filter
     * @return corresponding device list options
     */
    public static DeviceListOptions mapSubscriptionOptions(SubscriptionFilterOptions filters) {
        final DeviceListOptions listOptions = new DeviceListOptions();
        listOptions.equalToState(DeviceState.REGISTERED);
        if (filters == null || !filters.hasFilters(SubscriptionFilterOptions.DEVICE_ID_FILTER)) {
            return listOptions;
        }

        if (filters.hasFilter(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.EQUAL)) {
            listOptions.equalToId((String) filters.fetchSpecificFilterValue(SubscriptionFilterOptions.DEVICE_ID_FILTER,
                                                                            FilterOperator.EQUAL));
        }
        if (filters.hasFilter(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.NOT_EQUAL)) {
            listOptions.equalToId((String) filters.fetchSpecificFilterValue(SubscriptionFilterOptions.DEVICE_ID_FILTER,
                                                                            FilterOperator.NOT_EQUAL));
        }
        // TODO do other filters when implemented

        return listOptions;

    }

}
