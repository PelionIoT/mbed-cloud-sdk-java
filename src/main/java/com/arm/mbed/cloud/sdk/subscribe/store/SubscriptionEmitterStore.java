package com.arm.mbed.cloud.sdk.subscribe.store;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.subscribe.NotificationEmitter;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;

@Preamble(description = "Store containing notification publishers")
@Internal
public class SubscriptionEmitterStore<T extends NotificationMessageValue> {
    private static final int STORE_INITIAL_CAPACITY = 10;
    private final ConcurrentMap<String, NotificationEmitter<T>> store = new ConcurrentHashMap<>(STORE_INITIAL_CAPACITY);

    /**
     * Constructor.
     */
    public SubscriptionEmitterStore() {
        super();
    }

    /**
     * Notifies a change to observers.
     *
     * @param notification
     *            notification.
     * @param throwable
     *            exception which may have happened.
     */
    public void handleNotification(T notification, Throwable throwable) {
        for (final NotificationEmitter<T> emitter : store.values()) {
            try {
                @SuppressWarnings("unchecked")
                final T notificationClone = (notification == null) ? null : (T) notification.clone();
                emitter.emit(notificationClone, throwable);
            } catch (Exception exception) {
                // exception.printStackTrace();
            }

        }
    }

    /**
     * Notifies a change to a specific observer.
     *
     * @param id
     *            identifier of the observer to consider.
     * @param notification
     *            notification.
     * @param throwable
     *            exception which may have happened.
     */
    public void handleNotification(String id, T notification, Throwable throwable) {
        final NotificationEmitter<T> emitter = fetchSubscriptionChannel(id);
        if (emitter != null) {
            emitter.emit(notification, throwable);
        }
    }

    /**
     * Completes an observer.
     *
     * @param id
     *            identifier of the observer to complete.
     */
    public void complete(String id) {
        final NotificationEmitter<T> emitter = fetchSubscriptionChannel(id);
        if (emitter != null) {
            emitter.complete();
        }
    }

    /**
     * Completes all observers.
     *
     */
    public void completeAll() {
        for (final NotificationEmitter<T> emitter : store.values()) {
            emitter.complete();
        }
    }

    /**
     * Creates a subscription channel and stores it for the corresponding id.
     * <p>
     * Note: if a flowable is already registered for this id, no new channel is created and it is returned.
     *
     * @param id
     *            identifier to consider.
     * @param strategy
     *            Backpressure strategy to apply.
     * @return a flowable registered in the store at this id.
     */
    public @Nullable Flowable<T> createSubscriptionChannel(String id, BackpressureStrategy strategy) {
        if (id == null) {
            return null;
        }
        NotificationEmitter<T> channel = new NotificationEmitter<>();
        final NotificationEmitter<T> formerChannel = store.putIfAbsent(id, channel);
        if (formerChannel != null) {
            channel = formerChannel;
        }
        return channel.create(strategy);
    }

    /**
     * Fetches the subscription channel registered at a specific id.
     *
     * @param id
     *            identifier of the channel to consider.
     * @return corresponding channel.
     */
    protected @Nullable NotificationEmitter<T> fetchSubscriptionChannel(String id) {
        if (id == null) {
            return null;
        }
        return store.get(id);
    }

    /**
     * Remove a specific emitter from the store.
     *
     * @param id
     *            identifier of the observer to consider.
     */
    public void removeSubscriptionChannel(String id) {
        if (id == null) {
            return;
        }
        store.remove(id);
    }

    /**
     * Clears the store.
     */
    public void clear() {
        store.clear();
    }

}
