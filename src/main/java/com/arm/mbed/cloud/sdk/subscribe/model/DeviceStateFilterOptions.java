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

@Preamble(description = "Options to filter device state changes")
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
     * Creates a new filter.
     *
     * @return a newly created filter.
     */
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

    /**
     * Creates a "Like" filter.
     *
     * @see #addLikeFilter(String, Object)
     * @param deviceIdlike
     *            like filter on device Id: it can be a substring, a Java Regex or an SQL like entry
     */
    public void addLikeDeviceFilter(@Nullable String deviceIdlike) {
        addLikeFilter(DEVICE_ID_FILTER, deviceIdlike == null ? null : deviceIdlike);
    }

    /**
     * Creates a "Like" filter.
     *
     * @see #addLikeFilter(String, Object)
     * @param deviceIdlike
     *            like filter on device Id: it can be a substring, a Java Regex or an SQL like entry
     * @return this filter
     */
    public DeviceStateFilterOptions likeDevice(@Nullable String deviceIdlike) {
        addLikeDeviceFilter(deviceIdlike);
        return this;
    }

    /**
     * Adds an "Equal" filter related to a device id.
     *
     * @param deviceId
     *            device id to consider.
     */
    public void addEqualDeviceFilter(@Nullable String deviceId) {
        addEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    /**
     * Adds an "Equal" filter related to a device.
     *
     * Similar to {@link #addEqualDeviceFilter(String)}
     *
     * @param device
     *            device to consider.
     */
    public void addEqualDeviceFilter(@Nullable Device device) {
        addEqualDeviceFilter(device == null ? null : device.getId());
    }

    /**
     * Creates an "Equal" filter related to a device.
     *
     * Similar to {@link #addEqualDeviceFilter(String)}
     *
     * @param deviceId
     *            device id to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions equalDevice(@Nullable String deviceId) {
        addEqualDeviceFilter(deviceId);
        return this;
    }

    /**
     * Creates an "Equal" filter related to a device.
     *
     * Similar to {@link #addEqualDeviceFilter(Device)}
     *
     * @param device
     *            device to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions equalDevice(@Nullable Device device) {
        addEqualDeviceFilter(device);
        return this;
    }

    /**
     * Adds a "Not equal" filter related to a device id.
     *
     * @param deviceId
     *            device id to consider.
     */
    public void addNotEqualDeviceFilter(@Nullable String deviceId) {
        addNotEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    /**
     * Adds a "Not equal" filter related to a device.
     *
     * Similar to {@link #addNotEqualDeviceFilter(String)}
     *
     * @param device
     *            device to consider.
     */
    public void addNotEqualDeviceFilter(@Nullable Device device) {
        addNotEqualDeviceFilter(device == null ? null : device.getId());
    }

    /**
     * Creates a "Not equal" filter related to a device.
     *
     * Similar to {@link #addNotEqualDeviceFilter(String)}
     *
     * @param deviceId
     *            device id to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions notEqualDevice(@Nullable String deviceId) {
        addNotEqualDeviceFilter(deviceId);
        return this;
    }

    /**
     * Creates a "Not equal" filter related to a device.
     *
     * Similar to {@link #addNotEqualDeviceFilter(Device)}
     *
     * @param device
     *            device to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions notEqualDevice(@Nullable Device device) {
        addNotEqualDeviceFilter(device);
        return this;
    }

    /**
     * Adds an "In" filter related to device ids.
     *
     * @param deviceIds
     *            device ids to consider.
     */
    public void addInDeviceIdsFilter(@NonNull List<String> deviceIds) {
        addInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    @Deprecated
    public void addInDeviceFilter(@NonNull List<String> deviceIds) {
        addInDeviceIdsFilter(deviceIds);
    }

    /**
     * Adds an "In" filter related to devices.
     *
     * @param devices
     *            devices to consider.
     */
    public void addInDevicesFilter(@NonNull List<Device> devices) {
        if (devices == null) {
            return;
        }
        final List<String> values = new LinkedList<>();
        for (final Device device : devices) {
            values.add(device.getId());
        }
        addInDeviceIdsFilter(values);
    }

    /**
     * Adds an "In" filter related to device ids.
     *
     * @param deviceIds
     *            comma separated list of device ids.
     */
    public void addInDevicesFilter(@NonNull String deviceIds) {
        addInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    @Deprecated
    public DeviceStateFilterOptions inDevice(@NonNull List<String> deviceIds) {
        return inDeviceIds(deviceIds);
    }

    /**
     * Creates an "In" filter related to device ids.
     * <p>
     * Similar to {@link #addInDeviceIdsFilter(List)}
     *
     * @param deviceIds
     *            device ids to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions inDeviceIds(@NonNull List<String> deviceIds) {
        addInDeviceIdsFilter(deviceIds);
        return this;
    }

    /**
     * Creates an "In" filter related to devices.
     * <p>
     * Similar to {@link #addInDevicesFilter(List)}
     *
     * @param devices
     *            devices to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions inDevices(@NonNull List<Device> devices) {
        addInDevicesFilter(devices);
        return this;
    }

    /**
     * Creates an "In" filter related to device ids.
     *
     * @see #addInDevicesFilter(String)
     *
     * @param deviceIds
     *            comma separated list of device ids.
     * @return this filter
     */
    public DeviceStateFilterOptions inDevices(@NonNull String deviceIds) {
        addInDevicesFilter(deviceIds);
        return this;
    }

    @Deprecated
    public void addNotInDeviceFilter(@NonNull List<String> deviceIds) {
        addNotInDeviceIdsFilter(deviceIds);
    }

    /**
     * Adds a "Not in" filter related to device ids.
     *
     * @param deviceIds
     *            device ids to consider.
     */
    public void addNotInDeviceIdsFilter(@NonNull List<String> deviceIds) {
        addNotInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    /**
     * Adds a "Not in" filter related to devices.
     *
     * @param devices
     *            devices to consider.
     */
    public void addNotInDevicesFilter(@NonNull List<Device> devices) {
        if (devices == null) {
            return;
        }
        final List<String> values = new LinkedList<>();
        for (final Device device : devices) {
            values.add(device.getId());
        }
        addNotInDeviceIdsFilter(values);
    }

    /**
     * Adds a "Not in" filter related to devices.
     *
     * @param deviceIds
     *            deviceIds comma separated list of device ids.
     */
    public void addNotInDevicesFilter(@NonNull String deviceIds) {
        addNotInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    @Deprecated
    public DeviceStateFilterOptions notInDevice(@NonNull List<String> deviceIds) {
        return notInDeviceIds(deviceIds);
    }

    /**
     * Creates a "Not in" filter related to device ids.
     * <p>
     * Similar to {@link #addNotInDeviceIdsFilter(List)}
     *
     * @param deviceIds
     *            device ids to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions notInDeviceIds(@NonNull List<String> deviceIds) {
        addNotInDeviceIdsFilter(deviceIds);
        return this;
    }

    /**
     * Creates a "Not in" filter related to devices.
     * <p>
     * Similar to {@link #addNotInDevicesFilter(List)}
     *
     * @param devices
     *            devices to consider.
     * @return this filter
     */
    public DeviceStateFilterOptions notInDevices(@NonNull List<Device> devices) {
        addNotInDevicesFilter(devices);
        return this;
    }

    /**
     * Creates a "Not in" filter related to devices.
     *
     * @see #addNotInDevicesFilter(String)
     *
     * @param deviceIds
     *            comma separated list of device ids.
     * @return this filter
     */
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

    /**
     * States whether the notification message verifies the filter created or not.
     *
     * @param notification
     *            a notification.
     * @return True if the filter is verified by this notification. False otherwise.
     */
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
