package com.arm.mbed.cloud.sdk.devicedirectory.adapters;

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
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceEvent;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventPage;

@Preamble(description = "Adapter for device event model")
@Internal
public final class DeviceEventAdapter {
    public static final FilterMarshaller FILTERS_MARSHALLER = getFilterMarshaller();

    private DeviceEventAdapter() {
        super();
    }

    private static FilterMarshaller getFilterMarshaller() {
        final Map<String, String> filterMapping = new HashMap<>(4);
        filterMapping.put("eventDate", "date_time");
        filterMapping.put("type", "event_type");
        return new FilterMarshaller(filterMapping);
    }

    public static DeviceEvent map(DeviceEventData deviceEventData) {
        if (deviceEventData == null) {
            return null;
        }
        final DeviceEvent event = new DeviceEvent(deviceEventData.getId(), deviceEventData.getDeviceId(),
                TranslationUtils.toDate(deviceEventData.getDateTime()),
                TranslationUtils.toBool(deviceEventData.getStateChange(), false), deviceEventData.getDescription(),
                deviceEventData.getChanges(), deviceEventData.getEventTypeDescription(), deviceEventData.getEventType(),
                deviceEventData.getData());
        return event;

    }

    public static Mapper<DeviceEventData, DeviceEvent> getMapper() {
        return new Mapper<DeviceEventData, DeviceEvent>() {

            @Override
            public DeviceEvent map(DeviceEventData toBeMapped) {
                return DeviceEventAdapter.map(toBeMapped);
            }

        };
    }

    public static ListResponse<DeviceEvent> mapList(DeviceEventPage list) {
        final DeviceEventPage eventList = list;
        final RespList<DeviceEventData> respList = new RespList<DeviceEventData>() {

            @Override
            public Boolean getHasMore() {
                return (eventList == null) ? null : eventList.getHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (eventList == null) ? null : eventList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (eventList == null) ? null : eventList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (eventList == null) ? null : eventList.getLimit();
            }

            @Override
            public String getOrder() {
                return (eventList == null) ? null : eventList.getOrder().toString();
            }

            @Override
            public List<DeviceEventData> getData() {
                return (eventList == null) ? null : eventList.getData();
            }
        };
        return GenericAdapter.mapList(respList, getMapper());
    }

    public static Mapper<DeviceEventPage, ListResponse<DeviceEvent>> getListMapper() {
        return new Mapper<DeviceEventPage, ListResponse<DeviceEvent>>() {

            @Override
            public ListResponse<DeviceEvent> map(DeviceEventPage toBeMapped) {
                return DeviceEventAdapter.mapList(toBeMapped);
            }

        };
    }

}
