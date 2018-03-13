package com.arm.mbed.cloud.sdk.subscribe;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Scheduler;

public interface SubscriptionManager {
    @Nullable
    List<Observer<?>> listAll();

    @Nullable
    List<Observer<?>> listAll(@NonNull SubscriptionType type);

    void unsubscribeAll();

    void unsubscribeAll(SubscriptionType type);

    void unsubscribe(SubscriptionType type, String observerId);

    void unsubscribe(Observer<?> observer);

    @Nullable
    Observer<?> createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy);

    <T extends NotificationMessageValue> void notify(SubscriptionType type, NotificationMessage<T> message)
            throws MbedCloudException;

    <T extends NotificationMessageValue> void notify(SubscriptionType type, String channelId,
            NotificationMessage<T> message) throws MbedCloudException;

    Scheduler getObservedOnExecutor();
}
