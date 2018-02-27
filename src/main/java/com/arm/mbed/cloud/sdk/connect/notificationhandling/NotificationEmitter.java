package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

public class NotificationEmitter<T> {

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
