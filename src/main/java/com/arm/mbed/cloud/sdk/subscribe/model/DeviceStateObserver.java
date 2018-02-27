package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.subscribe.AbstractObserver;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;

import io.reactivex.Flowable;

public class DeviceStateObserver extends AbstractObserver<DeviceStateNotification> {

    public DeviceStateObserver(Flowable<DeviceStateNotification> flow, SubscriptionManager manager,
            DeviceStateFilterOptions filter) {
        super(flow, manager, filter);
    }

    @Override
    protected boolean verifiesFilter(DeviceStateNotification notification) {
        if (filter == null) {
            return true;
        }
        return ((DeviceStateFilterOptions) filter).isVerified(notification);
    }
}
