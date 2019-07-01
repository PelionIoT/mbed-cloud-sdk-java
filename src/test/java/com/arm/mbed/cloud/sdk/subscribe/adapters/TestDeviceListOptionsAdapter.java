package com.arm.mbed.cloud.sdk.subscribe.adapters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

public class TestDeviceListOptionsAdapter {

    @Test
    public void testMapSubscriptionOptions() {
        SubscriptionFilterOptions opt = SubscriptionFilterOptions.newFilter().equalDevice("testa")
                                                                 .notEqualDevice("testb");
        DeviceListOptions deviceOpt = DeviceListOptionsAdapter.mapSubscriptionOptions(opt);
        assertNotNull(deviceOpt);
        assertEquals("testa",
                     deviceOpt.fetchSpecificFilterValue(DeviceListOptions.TAG_FILTER_BY_ID, FilterOperator.EQUAL));
        assertEquals("testb",
                     deviceOpt.fetchSpecificFilterValue(DeviceListOptions.TAG_FILTER_BY_ID, FilterOperator.NOT_EQUAL));
        // TODO implement other filters when implemented
        assertNull(deviceOpt.fetchSpecificFilterValue(DeviceListOptions.TAG_FILTER_BY_ID, FilterOperator.LIKE));
        assertNull(deviceOpt.fetchSpecificFilterValue(DeviceListOptions.TAG_FILTER_BY_ID, FilterOperator.IN));

    }

}
