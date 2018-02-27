package com.arm.mbed.cloud.sdk.subscribe.model;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FiltersEvaluator;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;

@Preamble(description = "Options to filter device state subscription")
public class DeviceStateFilterOptions extends FilterOptions {
    /**
     * Tag of filter by device id.
     */
    public static final String DEVICE_ID_FILTER = "deviceId";
    /**
     * Tag of filter by device state.
     */
    public static final String DEVICE_STATE_FILTER = "deviceState";

    /**
     * Constructor.
     */
    public DeviceStateFilterOptions() {
        this(null);
    }

    /**
     * Constructor.
     * 
     * @param filter
     *            the filter to set
     */
    public DeviceStateFilterOptions(Filters filter) {
        super();
        this.filter = filter;
    }

    public void addLikeDeviceFilter(@Nullable String deviceIdlike) {
        addLikeFilter(DEVICE_ID_FILTER, deviceIdlike == null ? null : deviceIdlike);
    }

    public void addEqualDeviceFilter(@Nullable String deviceId) {
        addEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    public void addEqualDeviceFilter(@Nullable Device value) {
        addEqualDeviceFilter(value == null ? null : value.getId());
    }

    public void addNotEqualDeviceFilter(@Nullable String deviceId) {
        addNotEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    public void addNotEqualDeviceFilter(@Nullable Device value) {
        addNotEqualDeviceFilter(value == null ? null : value.getId());
    }

    public void addInDeviceFilter(@NonNull List<String> deviceIds) {
        addInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    public void addInDevicesFilter(@NonNull List<Device> devices) {
        if (devices == null) {
            return;
        }
        final List<String> values = new LinkedList<>();
        for (Device device : devices) {
            values.add(device.getId());
        }
        addInDeviceFilter(values);
    }

    public void addInDeviceFilter(@NonNull String deviceIds) {
        addInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    public void addNotInDeviceFilter(@NonNull List<String> deviceIds) {
        addNotInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    public void addNotInDevicesFilter(@NonNull List<Device> devices) {
        if (devices == null) {
            return;
        }
        final List<String> values = new LinkedList<>();
        for (Device device : devices) {
            values.add(device.getId());
        }
        addNotInDeviceFilter(values);
    }

    public void addNotInDeviceFilter(@NonNull String deviceIds) {
        addNotInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    public void addEqualDeviceStateFilter(@NonNull DeviceState state) {
        addEqualFilter(DEVICE_STATE_FILTER, state);
    }

    public void addNotEqualDeviceStateFilter(@NonNull DeviceState state) {
        addNotEqualFilter(DEVICE_STATE_FILTER, state);
    }

    public void addInDeviceStateFilter(@NonNull List<DeviceState> states) {
        addInFilter(DEVICE_STATE_FILTER, states);
    }

    public void addNotInDeviceStateFilter(@NonNull List<DeviceState> states) {
        addNotInFilter(DEVICE_STATE_FILTER, states);
    }

    public boolean isVerified(DeviceStateNotification notification) {
        if (notification == null) {
            return false;
        }
        return evaluateDeviceId(notification.getDeviceId()) && evaluateDeviceState(notification.getState());
    }

    private boolean evaluateDeviceId(String deviceId) {
        return FiltersEvaluator.isVerified(filter, DEVICE_ID_FILTER, deviceId);
    }

    private boolean evaluateDeviceState(DeviceState state) {
        return FiltersEvaluator.isVerified(filter, DEVICE_STATE_FILTER, state);
    }

}
