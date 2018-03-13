package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateNotification;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

public class DeviceStateSubscriptionHandlerStore<T extends DeviceStateNotification> {
    private static final int STORE_INITIAL_CAPACITY = 10;
    private final ConcurrentMap<String, NotificationEmitter> store = new ConcurrentHashMap<>(STORE_INITIAL_CAPACITY);

    public void handleNotification(DeviceStateNotification notification, Throwable throwable) {
        // if (deviceId == null) {
        // return;
        // }
        // final DeviceSubscriptionStore deviceStore = store.get(deviceId);
        // if (deviceStore != null) {
        // deviceStore.handleNotification(resourcePath, notification, throwable);
        // }
    }

    public Flowable<DeviceStateNotification> getOrCreateSubscriptionChannel(String id, BackpressureStrategy strategy) {
        if (id == null) {
            return null;
        }
        Flowable<DeviceStateNotification> channel = new DeviceSubscriptionStore();
        final Flowable<DeviceStateNotification> formerChannel = store.putIfAbsent(id, channel);
        if (formerChannel != null) {
            channel = formerChannel;
        }
        return channel;
    }

    public Flowable<DeviceStateNotification> fetchSubscriptionChannel(String id) {
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

    private static class NotificationEmitter<T> {

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

        public void emit(T notification, Throwable throwable) {
            if (throwable == null) {
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
