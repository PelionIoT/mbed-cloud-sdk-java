package com.arm.mbed.cloud.sdk.subscribe.store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Scheduler;

@Preamble(description = "Store of all subscription observers")
public class SubscriptionObserversStore implements CloudSubscriptionManager {
    private final Map<SubscriptionType, SubscriptionManager> store;
    private final Scheduler scheduler;

    /**
     * Constructor.
     *
     * @param scheduler
     *            scheduler {@link Scheduler} the observers should use.
     */
    public SubscriptionObserversStore(Scheduler scheduler) {
        super();
        this.scheduler = scheduler;
        store = new HashMap<>(3);
        store.put(SubscriptionType.DEVICE_STATE_CHANGE, new DeviceStateChangeSubscriptionObserverStore(this.scheduler));
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
        return list.isEmpty() ? null : list;

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

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#completeAll()
     */
    @Override
    public void completeAll() {
        for (final SubscriptionManager substore : store.values()) {
            substore.completeAll();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#completeAll(com.arm.mbed.cloud.sdk.subscribe.
     * SubscriptionType)
     */
    @Override
    public void completeAll(SubscriptionType type) {
        final SubscriptionManager substore = store.get(type);
        if (substore != null) {
            substore.completeAll(type);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#complete(com.arm.mbed.cloud.sdk.subscribe.SubscriptionType,
     * java.lang.String)
     */
    @Override
    public void complete(SubscriptionType type, String observerId) {
        final SubscriptionManager substore = store.get(type);
        if (substore != null) {
            substore.complete(type, observerId);
        }
    }

    @Override
    public Observer<?> createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy) {
        final SubscriptionManager substore = store.get(type);
        return (substore == null) ? null : substore.createObserver(type, filter, strategy);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#notify(com.arm.mbed.cloud.sdk.subscribe.SubscriptionType,
     * com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue)
     */
    @Override
    public <T extends NotificationMessageValue> void notify(SubscriptionType type, T value) throws MbedCloudException {
        notify(type, new NotificationMessage<>(value, null));
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

    @Override
    public boolean hasObservers() {
        for (final SubscriptionManager substore : store.values()) {
            if (substore.hasObservers()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasObservers(SubscriptionType type) {
        final SubscriptionManager substore = store.get(type);
        return (substore == null) ? false : substore.hasObservers(type);
    }

    @Override
    public boolean hasObserver(SubscriptionType type, String observerId) {
        final SubscriptionManager substore = store.get(type);
        return (substore == null) ? false : substore.hasObserver(type, observerId);
    }

    @Override
    public boolean hasObserver(Observer<?> observer) {
        return (observer == null) ? false : hasObserver(observer.getSubscriptionType(), observer.getId());
    }

    @Override
    public DeviceStateObserver deviceState(DeviceStateFilterOptions filter, BackpressureStrategy strategy) {
        return (DeviceStateObserver) createObserver(SubscriptionType.DEVICE_STATE_CHANGE, filter, strategy);
    }

}
