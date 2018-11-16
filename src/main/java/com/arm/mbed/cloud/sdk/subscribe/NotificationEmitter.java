package com.arm.mbed.cloud.sdk.subscribe;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Notification emitter/publisher")
@Internal
public class NotificationEmitter<T extends NotificationMessageValue> {

    private final List<FlowableEmitter<T>> emitters = new LinkedList<>();

    /**
     * Constructor.
     */
    public NotificationEmitter() {
        super();
    }

    /**
     * Creates a communication channel for an observer.
     *
     * @param strategy
     *            backpressure strategy to apply.
     * @return a communication channel.
     */
    public Flowable<T> create(BackpressureStrategy strategy) {

        final FlowableOnSubscribe<T> source = new FlowableOnSubscribe<T>() {

            @Override
            public void subscribe(FlowableEmitter<T> emitter) {
                emitters.add(emitter);

            }
        };
        return Flowable.create(source, strategy);
    }

    /**
     * Completes the communication channel.
     */
    public void complete() {
        for (final FlowableEmitter<T> emitter : emitters) {
            try {
                if (!emitter.isCancelled()) {
                    emitter.onComplete();
                }
            } catch (Exception exception) {
                // Nothing to do
            }
        }
    }

    /**
     * Emits a notification onto the communication channel.
     *
     * @param notification
     *            notification to emit
     * @param throwable
     *            the exception to emit
     */
    public void emit(@Nullable T notification, @Nullable Throwable throwable) {
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
