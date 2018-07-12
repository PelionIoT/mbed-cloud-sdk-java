package com.arm.mbed.cloud.sdk.subscribe;

import java.util.concurrent.Future;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;

@Preamble(description = "Abstract subscription observer")
@Internal
public abstract class AbstractObserver<T extends NotificationMessageValue> implements Observer<T> {

    private final Flowable<T> flow;
    protected final SubscriptionManager manager;
    protected final FilterOptions filter;
    private final CompositeDisposable composite;
    private final String id;
    private final CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription;
    private final CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription;
    private volatile boolean isDisposed;
    private volatile boolean hasExecutedActionOnFirstSubscription;

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
     * @param actionOnSubscription
     *            action to perform on subscription
     * @param actionOnUnsubscription
     *            action to perform on unsubscription
     */
    @SuppressWarnings("unchecked")
    public AbstractObserver(SubscriptionManager manager, String id, Flowable<T> flow, FilterOptions filter,
                            boolean unsubscribeOnCompletion,
                            CallbackWithException<? extends FilterOptions, MbedCloudException> actionOnSubscription,
                            CallbackWithException<? extends FilterOptions, MbedCloudException> actionOnUnsubscription) {
        super();
        isDisposed = false;
        hasExecutedActionOnFirstSubscription = false;
        this.filter = filter;
        this.composite = new CompositeDisposable();
        this.id = id;
        final boolean mustUnsubscribeOnCompletion = unsubscribeOnCompletion;
        this.actionOnSubscription = (CallbackWithException<FilterOptions, MbedCloudException>) actionOnSubscription;
        this.actionOnUnsubscription = (CallbackWithException<FilterOptions, MbedCloudException>) actionOnUnsubscription;
        this.flow = flow.observeOn(manager.getObservedOnExecutor()).filter(new Predicate<T>() {

            @Override
            public boolean test(T value) throws Exception {
                return verifiesFilter(value);
            }

        }).doOnSubscribe(createOnSubscriptionAction()).doFinally(createTerminationAction(mustUnsubscribeOnCompletion));
        this.manager = manager;

    }

    private Consumer<? super Subscription> createOnSubscriptionAction() {
        return new Consumer<Subscription>() {

            @Override
            public void accept(Subscription subscription) throws Exception {
                if (actionOnSubscription != null && !hasExecutedActionOnFirstSubscription) {
                    actionOnSubscription.execute(filter);
                    hasExecutedActionOnFirstSubscription = true;
                }

            }

        };
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
    public void unsubscribe() throws MbedCloudException {
        if (actionOnUnsubscription != null) {
            actionOnUnsubscription.execute(this.filter);
        }
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
        return singleNotification(timeout).toFuture();
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
            final T value = singleNotification(timeout).blockingGet();
            unsubscribe();
            return value;
        } catch (Exception exception) {
            throw new MbedCloudException("The value could not be retrieved", exception);
        }
    }

    @Override
    public Single<T> singleNotification(TimePeriod timeout) throws MbedCloudException {
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Observer [id=" + id + ", type=" + getSubscriptionType() + ", filter=" + filter + ", isDisposed="
               + isDisposed + "]";
    }

    /**
     * Tests whether the value complies with the filter or not.
     *
     * @param value
     *            notification values
     * @return true if the notification value verifies the filter. False otherwise.
     */
    protected abstract boolean verifiesFilter(T value);

    @Override
    public abstract SubscriptionType getSubscriptionType();

}
