package com.arm.mbed.cloud.sdk.subscribe;

import java.util.UUID;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public abstract class AbstractObserver<T> implements Observer<T> {

    private final Flowable<T> flow;
    private final SubscriptionManager manager;
    private final Filters filter;
    private final CompositeDisposable composite = new CompositeDisposable();
    private final String id = UUID.randomUUID().toString();
    private boolean isDisposed = false;

    public AbstractObserver(Flowable<T> flow, SubscriptionManager manager, Filters filter) {
        super();
        this.filter = filter;
        this.flow = flow.observeOn(manager.getObservedOnExecutor()).filter(new Predicate<T>() {

            @Override
            public boolean test(T t) throws Exception {
                return verifiesFilter(t);
            }

        });
        this.manager = manager;

    }

    protected abstract boolean verifiesFilter(T t);

    @Override
    public void addCallback(NotificationCallback<T> callback) {
        if (callback != null) {
            composite.add(flow.subscribe(new Consumer<T>() {

                @Override
                public void accept(T value) throws Exception {
                    callback.callBack(value);

                }
            }, new Consumer<Throwable>() {

                @Override
                public void accept(Throwable throwable) throws Exception {
                    callback.callBack(throwable);

                }
            }));
        }
    }

    @Override
    public void removeCallback() {
        composite.clear();
    }

    @Override
    public void unsubscribe() {
        removeCallback();
        manager.unsubscribe(this);
        isDisposed = true;
    }

    @Override
    public Flowable<T> flow() {
        return flow;
    }

    @Override
    public T one() throws MbedCloudException {
        return one(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.subscribe.Observer#one(com.arm.mbed.cloud.sdk.common.TimePeriod)
     */
    @Override
    public T one(TimePeriod timeout) throws MbedCloudException {
        try {
            Flowable<T> oneItemFlow = (timeout == null) ? flow : flow.timeout(timeout.getDuration(), timeout.getUnit());
            return oneItemFlow.lastOrError().blockingGet();
        } catch (Exception exception) {
            throw new MbedCloudException("The value could not be retrieved", exception);
        }
    }

    @Override
    public boolean isDisposed() {
        return isDisposed;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int numberOfCallbacks() {
        return composite.size();
    }

}
