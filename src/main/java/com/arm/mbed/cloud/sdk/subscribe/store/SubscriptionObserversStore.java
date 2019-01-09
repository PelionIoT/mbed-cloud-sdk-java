package com.arm.mbed.cloud.sdk.subscribe.store;

import java.lang.ref.WeakReference;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Scheduler;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Store of all subscription observers")
public class SubscriptionObserversStore implements CloudSubscriptionManager {
    private static final int STORE_INITIAL_CAPACITY = 10;
    private final Map<SubscriptionType, SubscriptionManager> store;
    private final ConcurrentHashMap<Integer, WeakReference<Observer<?>>> resourceToObserverStore;
    private final Scheduler scheduler;
    private final SubscriptionAction resourceSubscriber;
    private final SubscriptionAction resourceUnsubscriber;
    private final SubscriptionAction resourceUnsubscriberAll;

    /**
     * Constructor.
     *
     * @param scheduler
     *            scheduler {@link Scheduler} the observers should use.
     * @param resourceSubscriber
     *            action to perform on subscription
     * @param resourceUnsubscriber
     *            action to perform on unsubscription
     */
    public SubscriptionObserversStore(Scheduler scheduler, SubscriptionAction resourceSubscriber,
                                      SubscriptionAction resourceUnsubscriber,
                                      SubscriptionAction resourceUnsubscriberAll) {
        super();
        this.scheduler = scheduler;
        store = new EnumMap<>(SubscriptionType.class);
        store.put(SubscriptionType.DEVICE_STATE_CHANGE,
                  new DeviceStateChangeSubscriptionObserverStore(this.scheduler, getManagerReference()));
        store.put(SubscriptionType.NOTIFICATION,
                  new ResourceValueSubscriptionObserverStore(this.scheduler, getManagerReference()));
        store.put(SubscriptionType.ASYNCHRONOUS_RESPONSE,
                  new AsynchronousResponseSubscriptionObserverStore(this.scheduler, getManagerReference()));
        this.resourceSubscriber = resourceSubscriber;
        this.resourceUnsubscriber = resourceUnsubscriber;
        this.resourceUnsubscriberAll = resourceUnsubscriberAll;
        resourceToObserverStore = new ConcurrentHashMap<>(STORE_INITIAL_CAPACITY);
    }

    protected WeakReference<SubscriptionManager> getManagerReference() {
        return new WeakReference<>((SubscriptionManager) this);
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

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#getTopManager()
     */
    @Override
    public SubscriptionManager getTopManager() {
        return null;
    }

    @Override
    public void unsubscribeAll() throws MbedCloudException {
        resourceToObserverStore.clear();
        for (final SubscriptionManager substore : store.values()) {
            try {
                substore.unsubscribeAll();
            } catch (MbedCloudException exception) {
                // Continue
            }
        }
        if (resourceUnsubscriberAll != null) {
            resourceUnsubscriberAll.execute(null);
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
        return createObserver(type, filter, strategy, null, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#createObserver(com.arm.mbed.cloud.sdk.subscribe.
     * SubscriptionType, com.arm.mbed.cloud.sdk.common.listing.FilterOptions, io.reactivex.BackpressureStrategy,
     * com.arm.mbed.cloud.sdk.common.Callback, com.arm.mbed.cloud.sdk.common.Callback)
     */
    @Override
    public Observer<?> createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy,
                                      CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                                      CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription) {
        final SubscriptionManager substore = store.get(type);
        return (substore == null) ? null : substore.createObserver(type, filter, strategy, actionOnSubscription,
                                                                   actionOnUnsubscription);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager#createObserver(com.arm.mbed.cloud.sdk.subscribe.
     * SubscriptionType, com.arm.mbed.cloud.sdk.common.listing.FilterOptions, io.reactivex.BackpressureStrategy,
     * com.arm.mbed.cloud.sdk.common.CallbackWithException, com.arm.mbed.cloud.sdk.common.CallbackWithException,
     * boolean, com.arm.mbed.cloud.sdk.connect.model.Resource)
     */
    @Override
    public Observer<?> createObserver(SubscriptionType type, FilterOptions filter, BackpressureStrategy strategy,
                                      CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                                      CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription,
                                      boolean notifyOtherObservers, Resource correspondingResource) {
        final SubscriptionManager substore = store.get(type);
        return (substore == null) ? null
                                  : substore.createObserver(type, filter, strategy, actionOnSubscription,
                                                            actionOnUnsubscription, notifyOtherObservers,
                                                            correspondingResource);
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
    public <T extends NotificationMessageValue> void notify(SubscriptionType type,
                                                            NotificationMessage<T> message) throws MbedCloudException {
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

    @Deprecated
    @Override
    public DeviceStateObserver deviceState(DeviceStateFilterOptions filter, BackpressureStrategy strategy) {
        return deviceStateChanges(filter, strategy);
    }

    @Override
    public DeviceStateObserver deviceStateChanges(DeviceStateFilterOptions filter, BackpressureStrategy strategy) {
        return (DeviceStateObserver) createObserver(SubscriptionType.DEVICE_STATE_CHANGE, filter, strategy);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager#asynchronousResponse(java.lang.String,
     * com.arm.mbed.cloud.sdk.connect.model.Resource, io.reactivex.BackpressureStrategy)
     */
    @Override
    public AsynchronousResponseObserver asynchronousResponse(String requestId, Resource resource,
                                                             boolean notifyOtherObservers,
                                                             BackpressureStrategy strategy) {
        return (AsynchronousResponseObserver) createObserver(SubscriptionType.ASYNCHRONOUS_RESPONSE,
                                                             AsynchronousResponseFilterOptions.newFilter()
                                                                                              .equalAsynchronousResponseId(requestId),
                                                             strategy, null, null, notifyOtherObservers, resource);
    }

    @Override
    public ResourceValueObserver resourceValues(SubscriptionFilterOptions filter, BackpressureStrategy strategy) {
        // TODO determine FirstValue from Global Power values
        return (ResourceValueObserver) createObserver(SubscriptionType.NOTIFICATION, filter, strategy,
                                                      resourceSubscriber, resourceUnsubscriber);
    }

    @Override
    public ResourceValueObserver resourceValues(SubscriptionFilterOptions filter, BackpressureStrategy strategy,
                                                FirstValue triggerMode) {
        return (ResourceValueObserver) createObserver(SubscriptionType.NOTIFICATION, filter, strategy,
                                                      resourceSubscriber.clone().mode(triggerMode),
                                                      resourceUnsubscriber.clone().mode(triggerMode));
    }

    @Override
    public ResourceValueObserver resourceValues(Resource resource, BackpressureStrategy strategy,
                                                FirstValue triggerMode) {
        final ResourceValueObserver observer = resourceValues(SubscriptionFilterOptions.newFilter()
                                                                                       .equalResource(resource),
                                                              strategy, triggerMode);
        attachObserverToResource(resource, observer);
        return observer;

    }

    @Override
    public ResourceValueObserver resourceValues(Resource resource, BackpressureStrategy strategy) {
        final ResourceValueObserver observer = resourceValues(SubscriptionFilterOptions.newFilter()
                                                                                       .equalResource(resource),
                                                              strategy);
        attachObserverToResource(resource, observer);
        return observer;
    }

    /**
     * Attaches an observer to a specific resource.
     *
     * @param resource
     *            resource to subscribe to.
     * @param observer
     *            Observer to attach to the resource.
     */
    public void attachObserverToResource(Resource resource, Observer<?> observer) {
        if (resource == null || observer == null) {
            return;
        }
        resourceToObserverStore.put(Integer.valueOf(resource.hashCode()), new WeakReference<Observer<?>>(observer));
    }

    /**
     * Unsubscribes a resource observer.
     *
     * @param resource
     *            resource to unsubscribe from.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    public void unsubscribeResourceObserver(Resource resource) throws MbedCloudException {
        if (resource == null || !resourceToObserverStore.containsKey(Integer.valueOf(resource.hashCode()))) {
            return;
        }
        final int resourceHash = resource.hashCode();
        final WeakReference<Observer<?>> observerRef = resourceToObserverStore.get(Integer.valueOf(resourceHash));
        final Observer<?> observer = observerRef.get();
        if (observer != null) {
            observer.unsubscribe();
        }
        resourceToObserverStore.remove(Integer.valueOf(resourceHash));
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SubscriptionObserversStore [" + super.toString() + "]";
    }

}
