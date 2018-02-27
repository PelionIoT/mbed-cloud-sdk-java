package com.arm.mbed.cloud.sdk.subscribe;

import java.util.List;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.connect.model.Resource;

import io.reactivex.Scheduler;

public interface SubscriptionManager {

    List<Observer<?>> listAll();

    Object getCurrentResourceValue(Resource resource);

    void unsubscribeAll();

    void unsubscribe(Observer<?> observer);

    void notify(Object notification) throws MbedCloudException;

    void notify(String channelId, Object notification) throws MbedCloudException;

    Scheduler getObservedOnExecutor();
}
