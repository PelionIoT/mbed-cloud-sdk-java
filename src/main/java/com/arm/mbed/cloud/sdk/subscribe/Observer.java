package com.arm.mbed.cloud.sdk.subscribe;

import java.util.concurrent.Future;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.TimePeriod;

import io.reactivex.Flowable;

/**
 * Object based on ReactiveX's <a href="http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Flowable.html">Flowable</a>
 * and attempting to provide a solution following the <a href="https://en.wikipedia.org/wiki/Observer_pattern">Observer
 * pattern</a> which reacts to Mbed Cloud notifications such as device state changes, sensor value changes, etc.
 *
 * @param <T>
 *            Type of the notification message value.
 */
@Preamble(description = "Cloud notification observer")
public interface Observer<T extends NotificationMessageValue> {
    /**
     * Gets Observer's unique identifier.
     *
     * @return a UUID.
     */
    String getId();

    /**
     * Adds a callback function to be executed every time a notification is received.
     * <p>
     * Note: use callbacks when you want to carry out single actions when notifications are received.
     * <p>
     * If you want to perform combined and complex actions in such events, please consider using {@link #flow()}
     * instead.
     *
     * @param callback
     *            callback to add.
     */
    void addCallback(NotificationCallback<T> callback);

    /**
     * Notifies a message to the observer.
     *
     * @param message
     *            a notification message.
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    void notify(NotificationMessage<T> message) throws MbedCloudException;

    /**
     * Notifies data change to the observer.
     *
     * @param data
     *            some data of interest
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    void notify(T data) throws MbedCloudException;

    /**
     * Removes all callbacks registered to the observer.
     */
    void removeCallback();

    /**
     * Unregister the observer from the system.
     * <p>
     * Note: the communication channel comprised within the observer will also be closed.
     * <p>
     * Hence, the observer should not be used after this action.
     *
     * @throws MbedCloudException
     *             if an error happened during the process
     */
    void unsubscribe() throws MbedCloudException;

    /**
     * Gets the RxJava
     * <a href="http://reactivex.io/RxJava/2.x/javadoc/io/reactivex/Flowable.html">Flowable</a>/communication channel
     * the observer is based on.
     * <p>
     * Such object can be considered as a stream of asynchronous events with the same sort of simple, composable
     * operations that you use for collections of data items like arrays.
     *
     * @see <a href="http://reactivex.io/intro.html">ReactiveX documentation</a>
     * @return underlying flowable.
     */
    Flowable<T> flow();

    /**
     * Gets a future for one notification.
     * <p>
     * The data will be returned when a notification has been emitted to the communication channel.
     *
     * @return a future.
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    Future<T> futureOne() throws MbedCloudException;

    /**
     * Gets a future for one notification.
     * <p>
     * Similar to {@link #futureOne()} but a timeout is set on the communication channel.
     *
     * @param timeout
     *            time before which a notification must be received.
     * @return a future.
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    Future<T> futureOne(@Nullable TimePeriod timeout) throws MbedCloudException;

    /**
     * Gets one notification data (the first one emitted to the communication channel).
     * <p>
     * Note: after the notification is received, the observer is unsubscribed and therefore will become unusable.
     *
     * @return notification data.
     * @throws MbedCloudException
     *             if a problem occurred during the process or the timeout was elapsed.
     */
    @Nullable
    T one() throws MbedCloudException;

    /**
     * Gets one notification data (the first one emitted to the communication channel).
     * <p>
     * Similar to {@link #futureOne()} but a timeout is set on the communication channel.
     *
     * @param timeout
     *            time before which a notification must be received.
     * @return notification data.
     * @throws MbedCloudException
     *             if a problem occurred during the process or the timeout was elapsed.
     */
    @Nullable
    T one(@Nullable TimePeriod timeout) throws MbedCloudException;

    /**
     * Gets the number of callbacks registered to this observer.
     *
     * @return the number of callbacks.
     */
    int numberOfCallbacks();

    /**
     * States whether the observer has been disposed or not.
     * <p>
     * If it is the case, no messages will be able to go through the communication channel it comprises.
     *
     * @return True if the observer has been disposed. False otherwise.
     */
    boolean isDisposed();

    /**
     * Gets the subscription type of the observer.
     *
     * @return type
     */
    SubscriptionType getSubscriptionType();
}
