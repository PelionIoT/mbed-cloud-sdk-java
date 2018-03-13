package com.arm.mbed.cloud.sdk.subscribe.store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Scheduler;

public class SubscriptionObserversStore implements SubscriptionManager {
    private final Map<SubscriptionType, SubscriptionManager> store;
    private final Scheduler scheduler;

    private SubscriptionObserversStore(Scheduler scheduler) {
        super();
        this.scheduler = scheduler;
        store = new HashMap<>(3);
        store.put(SubscriptionType.DEVICE_STATE_CHANGE, new DeviceStateChangeSubscriptionObserverStore(scheduler));
    }

    @Override
    public @Nullable List<Observer<?>> listAll() {
        final List<Observer<?>> list = new LinkedList<>();
        for (final SubscriptionManager substore : store.values()) {
            final List<Observer<?>> sublist = substore.listAll();
            if (sublist != null) {
                list.addAll(sublist);
            }
        }
        return (list.isEmpty()) ? null : list;

    }

    @Override
    public List<Observer<?>> listAll(SubscriptionType type) {
        final SubscriptionManager substore = store.get(type);
        return (substore == null) ? null : substore.listAll(type);
    }

    @Override
    public void unsubscribeAll() {
        for (final SubscriptionManager substore : store.values()) {
            substore.unsubscribeAll();
        }
    }

    @Override
    public void unsubscribeAll(SubscriptionType type) {
        final SubscriptionManager substore = store.get(type);
        if (substore != null) {
            substore.unsubscribeAll(type);
        }
    }

    @Override
    public void unsubscribe(SubscriptionType type, String observerId) {
        final SubscriptionManager substore = store.get(type);
        if (substore != null) {
            substore.unsubscribe(type, observerId);
        }
    }

    @Override
    public void unsubscribe(Observer<?> observer) {
        if (observer == null) {
            return;
        }
        unsubscribe(observer.getSubscriptionType(), observer.getId());
    }

    @Override
    public Observer<?> createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy) {
        final SubscriptionManager substore = store.get(type);
        return (substore == null) ? null : substore.createObserver(type, filter, strategy);
    }

    @Override
    public <T extends NotificationMessageValue> void notify(SubscriptionType type, NotificationMessage<T> message)
            throws MbedCloudException {
        final SubscriptionManager substore = store.get(type);
        if (substore != null) {
            substore.notify(type, message);
        }
    }

    @Override
    public <T extends NotificationMessageValue> void notify(SubscriptionType type, String channelId,
            NotificationMessage<T> message) throws MbedCloudException {
        final SubscriptionManager substore = store.get(type);
        if (substore != null) {
            substore.notify(type, channelId, message);
        }
    }

    @Override
    public Scheduler getObservedOnExecutor() {
        return scheduler;
    }

}
