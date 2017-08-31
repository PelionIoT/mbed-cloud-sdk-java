package com.arm.mbed.cloud.sdk.devicedirectory.adapters;

import java.util.HashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceEvent;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventPage;

@Preamble(description = "Adapter for device event model")
@Internal
public class DeviceEventAdapter {
    public static final FilterMarshaller FILTERS_MARSHALLER = getFilterMarshaller();

    private static FilterMarshaller getFilterMarshaller() {
        Map<String, String> filterMapping = new HashMap<>(4);
        filterMapping.put("eventDate", "date_time");
        filterMapping.put("type", "event_type");
        return new FilterMarshaller(filterMapping);
    }

    public DeviceEventAdapter() {
        // TODO Auto-generated constructor stub
    }

    public static Mapper<DeviceEventPage, ListResponse<DeviceEvent>> getListMapper() {
        // TODO Auto-generated method stub
        return null;
    }

    public static Mapper<DeviceEventData, DeviceEvent> getMapper() {
        // TODO Auto-generated method stub
        return null;
    }

}
