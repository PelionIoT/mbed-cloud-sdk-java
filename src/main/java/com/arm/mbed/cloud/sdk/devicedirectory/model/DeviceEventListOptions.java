package com.arm.mbed.cloud.sdk.devicedirectory.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;

@Preamble(description = "Options to use when listing device events")
public class DeviceEventListOptions extends ListOptions {
    /**
     * Tag of filter by event date.
     */
    public static final String FILTER_EVENT_DATE = "eventDate";
    /**
     * Tag of filter by type.
     */
    public static final String FILTER_TYPE = "type";
    /**
     * Tag of filter by device id.
     */
    public static final String FILTER_DEVICE_ID = "deviceId";

    public DeviceEventListOptions() {
        super();
    }

    /**
     * Adds a device event filter based on device ID field.
     * 
     * @param deviceId
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addDeviceIdFilter(String deviceId, FilterOperator operator) {
        addFilter(FILTER_DEVICE_ID, operator, deviceId);
    }

    /**
     * Adds a device event based on type field.
     * 
     * @param type
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addTypeFilter(String type, FilterOperator operator) {
        addFilter(FILTER_TYPE, operator, type);
    }

    /**
     * Adds a device event based on event date field.
     * 
     * @param eventDate
     *            filter to apply
     * @param operator
     *            filter operator
     */
    public void addEventDateFilter(Date eventDate, FilterOperator operator) {
        addFilter(FILTER_EVENT_DATE, operator, eventDate);
    }
}
