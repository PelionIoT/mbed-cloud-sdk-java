package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.subscribe.AbstractObserver;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;

import io.reactivex.Flowable;

public class DeviceStateObserver extends AbstractObserver<DeviceStateNotification> {

    public DeviceStateObserver(SubscriptionManager manager, String id, Flowable<DeviceStateNotification> flow,
            DeviceStateFilterOptions filter) {
        super(manager, id, flow, filter, true);
    }

    @Override
    protected boolean verifiesFilter(DeviceStateNotification notification) {
        if (filter == null) {
            return true;
        }
        return ((DeviceStateFilterOptions) filter).isVerified(notification);
    }

    @Override
    public SubscriptionType getSubscriptionType() {
        return SubscriptionType.DEVICE_STATE_CHANGE;
    }
}
