package com.arm.mbed.cloud.sdk.subscribe;

import io.reactivex.Scheduler;

public interface SubscriptionManager {
    void unsubscribe(Observer<?> observer);

    Scheduler getObservedOnExecutor();
}
