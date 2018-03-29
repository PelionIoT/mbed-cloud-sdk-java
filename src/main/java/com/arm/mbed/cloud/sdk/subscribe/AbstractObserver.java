package com.arm.mbed.cloud.sdk.subscribe;

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
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

@Preamble(description = "Abstract subscription observer")
@Internal
public abstract class AbstractObserver<T extends NotificationMessageValue> implements Observer<T> {

    private final Flowable<T> flow;
    private final SubscriptionManager manager;
    protected final FilterOptions filter;
    private final CompositeDisposable composite;
    private final String id;
    private volatile boolean isDisposed;

    /**
     * Constructor.
     *
     * @param manager
     *            subscription manager.
     * @param id
     *            observer id.
     * @param flow
     *            communication channel. @see
     *            <a href="http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Flowable.html">RxJava Flowable</a>
     * @param filter
     *            filter to apply
     * @param unsubscribeOnCompletion
     *            states whether the manager should unsubscribe the observer when the communication channel is closed.
     */
    public AbstractObserver(SubscriptionManager manager, String id, Flowable<T> flow, FilterOptions filter,
            boolean unsubscribeOnCompletion) {
        super();
        isDisposed = false;
        this.filter = filter;
        this.composite = new CompositeDisposable();
        this.id = id;
        final boolean mustUnsubscribeOnCompletion = unsubscribeOnCompletion;
        this.flow = flow.observeOn(manager.getObservedOnExecutor()).filter(new Predicate<T>() {

            @Override
            public boolean test(T value) throws Exception {
                return verifiesFilter(value);
            }

        }).doOnTerminate(createTerminationAction(mustUnsubscribeOnCompletion));
        this.manager = manager;

    }

    private Action createTerminationAction(final boolean mustUnsubscribeOnCompletion) {
        return new Action() {

            @Override
            public void run() throws Exception {
                if (mustUnsubscribeOnCompletion) {
                    unsubscribe();
                }
            }
        };
    }

    @Override
    public void notify(@NonNull T data) throws MbedCloudException {
        final NotificationMessage<T> message = new NotificationMessage<>(data, null);
        notify(message);
    }

    @Override
    public void notify(@NonNull NotificationMessage<T> message) throws MbedCloudException {
        if (isDisposed) {
            throw new MbedCloudException("The subscription channel has been disposed");
        }
        if (message != null) {
            manager.notify(getSubscriptionType(), getId(), message);
        }
    }

    @Override
    public void addCallback(NotificationCallback<T> callback) {
        if (callback != null) {
            final NotificationCallback<T> immutableCallback = callback;
            composite.add(flow.subscribe(new Consumer<T>() {

                @Override
                public void accept(T value) throws Exception {
                    immutableCallback.callBack(value);

                }
            }, new Consumer<Throwable>() {

                @Override
                public void accept(Throwable throwable) throws Exception {
                    immutableCallback.callBack(throwable);

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
            final T value = fetchSingle(timeout).blockingGet();
            unsubscribe();
            return value;
        } catch (Exception exception) {
            throw new MbedCloudException("The value could not be retrieved", exception);
        }
    }

    protected Single<T> fetchSingle(TimePeriod timeout) throws MbedCloudException {
        try {
            final Flowable<T> oneItemFlow = (timeout == null) ? flow
                    : flow.timeout(timeout.getDuration(), timeout.getUnit());
            return oneItemFlow.firstOrError();
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
     * Gets the filter applied to this channel.
     *
     * @return the filter
     */
    public FilterOptions getFilter() {
        return filter;
    }

    /**
     * Gets the callbacks applied to this channel.
     *
     * @return callbacks
     */
    public CompositeDisposable getCallbacks() {
        return composite;
    }

    /**
     * Tests whether the value complies with the filter or not.
     *
     * @param value
     *            notification values
     * @return true if the notification value verifies the filter. False otherwise.
     */
    protected abstract boolean verifiesFilter(T value);

}
