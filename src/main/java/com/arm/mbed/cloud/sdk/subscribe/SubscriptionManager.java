package com.arm.mbed.cloud.sdk.subscribe;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;

import io.reactivex.Scheduler;

public interface SubscriptionManager {
    void unsubscribe(Observer<?> observer);

    void notify(Object notification) throws MbedCloudException;

    void notify(String channelId, Object notification) throws MbedCloudException;

    Scheduler getObservedOnExecutor();
}
