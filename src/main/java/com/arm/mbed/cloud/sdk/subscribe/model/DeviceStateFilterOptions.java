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

    public static DeviceStateFilterOptions newFilter() {
        return new DeviceStateFilterOptions();
    }

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
        super(filter);
    }

    public void addLikeDeviceFilter(@Nullable String deviceIdlike) {
        addLikeFilter(DEVICE_ID_FILTER, deviceIdlike == null ? null : deviceIdlike);
    }

    public DeviceStateFilterOptions likeDevice(@Nullable String deviceIdlike) {
        addLikeDeviceFilter(deviceIdlike);
        return this;
    }

    public void addEqualDeviceFilter(@Nullable String deviceId) {
        addEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    public void addEqualDeviceFilter(@Nullable Device value) {
        addEqualDeviceFilter(value == null ? null : value.getId());
    }

    public DeviceStateFilterOptions equalDevice(@Nullable String deviceId) {
        addEqualDeviceFilter(deviceId);
        return this;
    }

    public DeviceStateFilterOptions equalDevice(@Nullable Device value) {
        addEqualDeviceFilter(value);
        return this;
    }

    public void addNotEqualDeviceFilter(@Nullable String deviceId) {
        addNotEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    public void addNotEqualDeviceFilter(@Nullable Device value) {
        addNotEqualDeviceFilter(value == null ? null : value.getId());
    }

    public DeviceStateFilterOptions notEqualDevice(@Nullable String deviceId) {
        addNotEqualDeviceFilter(deviceId);
        return this;
    }

    public DeviceStateFilterOptions notEqualDevice(@Nullable Device value) {
        addNotEqualDeviceFilter(value);
        return this;
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

    public void addInDevicesFilter(@NonNull String deviceIds) {
        addInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    public DeviceStateFilterOptions inDevice(@NonNull List<String> deviceIds) {
        addInDeviceFilter(deviceIds);
        return this;
    }

    public DeviceStateFilterOptions inDevices(@NonNull List<Device> devices) {
        addInDevicesFilter(devices);
        return this;
    }

    public DeviceStateFilterOptions inDevices(@NonNull String deviceIds) {
        addInDevicesFilter(deviceIds);
        return this;
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

    public void addNotInDevicesFilter(@NonNull String deviceIds) {
        addNotInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    public DeviceStateFilterOptions notInDevice(@NonNull List<String> deviceIds) {
        addNotInDeviceFilter(deviceIds);
        return this;
    }

    public DeviceStateFilterOptions notInDevices(@NonNull List<Device> devices) {
        addNotInDevicesFilter(devices);
        return this;
    }

    public DeviceStateFilterOptions notInDevices(@NonNull String deviceIds) {
        addNotInDevicesFilter(deviceIds);
        return this;
    }

    public void addEqualDeviceStateFilter(@NonNull DeviceState state) {
        addEqualFilter(DEVICE_STATE_FILTER, state);
    }

    public DeviceStateFilterOptions equalDeviceState(@NonNull DeviceState state) {
        addEqualDeviceStateFilter(state);
        return this;
    }

    public void addNotEqualDeviceStateFilter(@NonNull DeviceState state) {
        addNotEqualFilter(DEVICE_STATE_FILTER, state);
    }

    public DeviceStateFilterOptions notEqualDeviceState(@NonNull DeviceState state) {
        addNotEqualDeviceStateFilter(state);
        return this;
    }

    public void addInDeviceStatesFilter(@NonNull List<DeviceState> states) {
        addInFilter(DEVICE_STATE_FILTER, states);
    }

    public DeviceStateFilterOptions inDeviceStates(@NonNull List<DeviceState> states) {
        addInDeviceStatesFilter(states);
        return this;
    }

    public void addNotInDeviceStatesFilter(@NonNull List<DeviceState> states) {
        addNotInFilter(DEVICE_STATE_FILTER, states);
    }

    public DeviceStateFilterOptions notInDeviceStates(@NonNull List<DeviceState> states) {
        addNotInDeviceStatesFilter(states);
        return this;
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
