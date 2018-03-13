package com.arm.mbed.cloud.sdk.subscribe.store;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

public class SubscriptionEmitterStore<T extends NotificationMessageValue> {
    private static final int STORE_INITIAL_CAPACITY = 10;
    private final ConcurrentMap<String, NotificationEmitter<T>> store = new ConcurrentHashMap<>(STORE_INITIAL_CAPACITY);

    public void handleNotification(T notification, Throwable throwable) {
        for (final NotificationEmitter<T> emitter : store.values()) {
            @SuppressWarnings("unchecked")
            final T notificationClone = (notification == null) ? null : (T) notification.clone();
            emitter.emit(notificationClone, throwable);
        }
    }

    public void handleNotification(String id, T notification, Throwable throwable) {
        final NotificationEmitter<T> emitter = fetchSubscriptionChannel(id);
        if (emitter != null) {
            emitter.emit(notification, throwable);
        }
    }

    public void complete(String id) {
        final NotificationEmitter<T> emitter = fetchSubscriptionChannel(id);
        if (emitter != null) {
            emitter.complete();
        }
    }

    public void completeAll() {
        for (final NotificationEmitter<T> emitter : store.values()) {
            emitter.complete();
        }
    }

    public Flowable<T> createSubscriptionChannel(String id, BackpressureStrategy strategy) {
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

    protected NotificationEmitter<T> fetchSubscriptionChannel(String id) {
        if (id == null) {
            return null;
        }
        return store.get(id);
    }

    public void removeSubscriptionChannel(String id) {
        if (id == null) {
            return;
        }
        store.remove(id);
    }

    public void clear() {
        store.clear();
    }

    private static class NotificationEmitter<T extends NotificationMessageValue> {

        private final List<FlowableEmitter<T>> emitters = new LinkedList<>();

        public Flowable<T> create(BackpressureStrategy strategy) {

            final FlowableOnSubscribe<T> source = new FlowableOnSubscribe<T>() {

                @Override
                public void subscribe(FlowableEmitter<T> emitter) {
                    emitters.add(emitter);

                }
            };
            return Flowable.create(source, strategy);
        }

        public void complete() {
            for (final FlowableEmitter<T> emitter : emitters) {
                emitter.onComplete();
            }
        }

        public void emit(T notification, Throwable throwable) {
            if (throwable == null) {
                if (notification == null) {
                    return;
                }
                for (final FlowableEmitter<T> emitter : emitters) {
                    emitter.onNext(notification);
                }
            } else {
                for (final FlowableEmitter<T> emitter : emitters) {
                    emitter.onError(throwable);
                }
            }
        }
    }
}
