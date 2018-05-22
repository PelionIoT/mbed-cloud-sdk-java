package com.arm.mbed.cloud.sdk.devicedirectory.adapters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

public class TestDeviceAdapter {

    @Test
    public void testMapSubscriptionOptions() {
        SubscriptionFilterOptions opt = SubscriptionFilterOptions.newFilter().equalDevice("testa")
                .notEqualDevice("testb");
        DeviceListOptions deviceOpt = DeviceAdapter.mapSubscriptionOptions(opt);
        assertNotNull(deviceOpt);
        assertEquals("testa", deviceOpt.fetchSpecificFilterValue(DeviceListOptions.FILTER_ID, FilterOperator.EQUAL));
        assertEquals("testb",
                deviceOpt.fetchSpecificFilterValue(DeviceListOptions.FILTER_ID, FilterOperator.NOT_EQUAL));
        // TODO implement other filters when implemented
        assertNull(deviceOpt.fetchSpecificFilterValue(DeviceListOptions.FILTER_ID, FilterOperator.LIKE));
        assertNull(deviceOpt.fetchSpecificFilterValue(DeviceListOptions.FILTER_ID, FilterOperator.IN));

    }

}
