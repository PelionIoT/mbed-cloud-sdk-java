package com.arm.mbed.cloud.sdk.subscribe;

import java.util.Iterator;
import java.util.concurrent.Future;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

import io.reactivex.Flowable;

@Preamble(description = "SDK Model object") // extends Serializable, Cloneable
public interface Observer<T> extends Iterator<Future<T>>, Iterable<Future<T>> {

    void addCallback(NotificationCallback<T> callback);

    void removeCallback();

    void unsubscribe();

    Flowable<T> flow();

    T one();

    boolean isCancelled();

}
