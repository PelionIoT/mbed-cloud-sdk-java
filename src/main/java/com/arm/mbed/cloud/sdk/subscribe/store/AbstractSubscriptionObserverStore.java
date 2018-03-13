package com.arm.mbed.cloud.sdk.subscribe.store;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public abstract class AbstractSubscriptionObserverStore<T extends NotificationMessageValue>
        implements SubscriptionManager {
    private final SubscriptionEmitterStore<T> emitterStore;
    private static final int STORE_INITIAL_CAPACITY = 10;
    private final ConcurrentMap<String, Observer<T>> observerStore;
    private final SubscriptionType type;
    private final Scheduler scheduler;

    public AbstractSubscriptionObserverStore(SubscriptionType type, Scheduler scheduler) {
        super();
        this.type = type;
        emitterStore = new SubscriptionEmitterStore<>();
        observerStore = new ConcurrentHashMap<>(STORE_INITIAL_CAPACITY);
        this.scheduler = scheduler;
    }

    @Override
    public @Nullable List<Observer<?>> listAll() {
        return (observerStore.isEmpty()) ? null : new ArrayList<>(observerStore.values());
    }

    @Override
    public @Nullable List<Observer<?>> listAll(@NonNull SubscriptionType subscriptionType) {
        if (subscriptionType == null || subscriptionType != this.type) {
            return null;
        }
        return listAll();
    }

    @Override
    public void unsubscribeAll() {
        emitterStore.completeAll();
        emitterStore.clear();
        observerStore.clear();
    }

    @Override
    public void unsubscribeAll(SubscriptionType subscriptionType) {
        if (subscriptionType == null || subscriptionType != this.type) {
            return;
        }
        unsubscribeAll();
    }

    @Override
    public void unsubscribe(SubscriptionType subscriptionType, String observerId) {
        if (subscriptionType == null || subscriptionType != this.type || observerId == null) {
            return;
        }
        emitterStore.complete(observerId);
        emitterStore.removeSubscriptionChannel(observerId);
        observerStore.remove(observerId);
    }

    @Override
    public void unsubscribe(Observer<?> observer) {
        if (observer == null) {
            return;
        }
        unsubscribe(observer.getSubscriptionType(), observer.getId());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U extends NotificationMessageValue> void notify(SubscriptionType subscriptionType, String channelId,
            NotificationMessage<U> message) throws MbedCloudException {
        if (subscriptionType == null || subscriptionType != this.type || message == null) {
            return;
        }
        try {
            emitterStore.handleNotification(channelId, (T) message.getValue(), message.getException());
        } catch (ClassCastException exception) {
            // Nothing to do;
        }
    }

    @Override
    public Scheduler getObservedOnExecutor() {
        return scheduler;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <U extends NotificationMessageValue> void notify(SubscriptionType subscriptionType,
            NotificationMessage<U> message) throws MbedCloudException {
        if (subscriptionType == null || subscriptionType != this.type) {
            return;
        }
        try {
            emitterStore.handleNotification((T) message.getValue(), message.getException());
        } catch (ClassCastException exception) {
            // Nothing to do;
        }
    }

    @Override
    public @Nullable Observer<?> createObserver(SubscriptionType subscriptionType, FilterOptions filter,
            BackpressureStrategy strategy) {
        if (subscriptionType == null || subscriptionType != this.type) {
            return null;
        }
        final String channelId = this.type.toString() + UuidGenerator.generate();
        final Flowable<T> flow = emitterStore.createSubscriptionChannel(channelId, strategy);
        return buildObserver(channelId, flow, filter);
    }

    protected abstract Observer<?> buildObserver(String channelId, Flowable<T> flow, FilterOptions filter);

}
