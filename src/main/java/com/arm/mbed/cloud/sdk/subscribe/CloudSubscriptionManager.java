package com.arm.mbed.cloud.sdk.subscribe;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;

import io.reactivex.BackpressureStrategy;

public interface CloudSubscriptionManager extends SubscriptionManager {

    @Nullable
    DeviceStateObserver deviceState(DeviceStateFilterOptions filter, BackpressureStrategy strategy);
    // TODO the following
    // @Nullable
    // Object currentResourceValue(...)
    // Observer resourceValues();

}
