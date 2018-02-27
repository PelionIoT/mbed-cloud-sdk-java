package com.arm.mbed.cloud.sdk.subscribe;

import java.util.UUID;
import java.util.concurrent.Future;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

@Preamble(description = "Abstract subscription observer")
@Internal
public abstract class AbstractObserver<T> implements Observer<T> {

    private final Flowable<T> flow;
    private final SubscriptionManager manager;
    protected final FilterOptions filter;
    private final CompositeDisposable composite;
    private final String id;
    private volatile boolean isDisposed;

    public AbstractObserver(Flowable<T> flow, SubscriptionManager manager, FilterOptions filter) {
        super();
        isDisposed = false;
        this.filter = filter;
        this.composite = new CompositeDisposable();
        this.id = UUID.randomUUID().toString(); // TODO use the internal generator
        this.flow = flow.observeOn(manager.getObservedOnExecutor()).filter(new Predicate<T>() {

            @Override
            public boolean test(T t) throws Exception {
                return verifiesFilter(t);
            }

        });
        this.manager = manager;

    }

    protected abstract boolean verifiesFilter(T t);

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.subscribe.Observer#notify(java.lang.Object)
     */
    @Override
    public void notify(@NonNull T data) throws MbedCloudException {
        if (isDisposed) {
            throw new MbedCloudException("The subscription channel has been disposed");
        }
        if (data != null) {
            manager.notify(getId(), data);
        }
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.subscribe.Observer#futureOne()
     */
    @Override
    public Future<T> futureOne() throws MbedCloudException {
        return futureOne(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.mbed.cloud.sdk.subscribe.Observer#futureOne(com.arm.mbed.cloud.sdk.common.TimePeriod)
     */
    @Override
    public Future<T> futureOne(@Nullable TimePeriod timeout) throws MbedCloudException {
        return fetchSingle(timeout).toFuture();
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
    public T one(@Nullable TimePeriod timeout) throws MbedCloudException {
        try {
            return fetchSingle(timeout).blockingGet();
        } catch (Exception exception) {
            throw new MbedCloudException("The value could not be retrieved", exception);
        }
    }

    protected Single<T> fetchSingle(TimePeriod timeout) throws MbedCloudException {
        try {
            Flowable<T> oneItemFlow = (timeout == null) ? flow : flow.timeout(timeout.getDuration(), timeout.getUnit());
            return oneItemFlow.lastOrError();
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

    /**
     * @return the filter
     */
    public FilterOptions getFilter() {
        return filter;
    }

    /**
     * @return callbacks
     */
    public CompositeDisposable getCallbacks() {
        return composite;
    }

}
