package com.arm.mbed.cloud.sdk.subscribe;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;

import io.reactivex.Flowable;

@Preamble(description = "SDK Model object") // extends Serializable, Cloneable
public interface Observer<T> {// extends Iterator<Future<T>>, Iterable<Future<T>> {
    String getId();

    void addCallback(NotificationCallback<T> callback);

    void removeCallback();

    void unsubscribe();

    Flowable<T> flow();

    T one() throws MbedCloudException;

    T one(@Nullable TimePeriod timeout) throws MbedCloudException;

    int numberOfCallbacks();

    boolean isDisposed();

}
