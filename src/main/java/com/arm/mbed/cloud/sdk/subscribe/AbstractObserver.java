package com.arm.mbed.cloud.sdk.subscribe;

import java.util.Iterator;
import java.util.concurrent.Future;

import io.reactivex.Flowable;

public class AbstractObserver<T> implements Observer<T> {

    private final Flowable<T> flow;

    // private final

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Future<T> next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Future<T>> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addCallback(NotificationCallback<T> callback) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeCallback() {
        // TODO Auto-generated method stub

    }

    @Override
    public void unsubscribe() {
        // TODO Auto-generated method stub

    }

    @Override
    public Flowable<T> flow() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T one() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isCancelled() {
        // TODO Auto-generated method stub
        return false;
    }

}
