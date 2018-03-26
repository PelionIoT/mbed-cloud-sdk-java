package com.arm.mbed.cloud.sdk.subscribe;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Scheduler;

@Preamble(description = "Manager of notification observers")
public interface SubscriptionManager {
    /**
     * Lists all the observer registered in the system.
     *
     * @return a list of observers.
     */
    @Nullable
    List<Observer<?>> listAll();

    /**
     * List all the observer registered in the system corresponding to a specific subscription type.
     *
     * @param type
     *            type of subscription to consider.
     * @return a list of observers.
     */
    @Nullable
    List<Observer<?>> listAll(@NonNull SubscriptionType type);

    /**
     * States whether the system comprises registered observers.
     *
     * @return True if there are observers registered. False otherwise.
     */
    boolean hasObservers();

    /**
     * States whether the system comprises registered observers for a specific subscription type.
     *
     * @param type
     *            type of subscription to consider.
     *
     * @return True if there are observers registered. False otherwise.
     */
    boolean hasObservers(@NonNull SubscriptionType type);

    /**
     * States whether the system comprises a specific observer.
     *
     * @param type
     *            type of subscription to consider.
     *
     * @param observerId
     *            identifier of the observer to consider.
     *
     * @return True if the observer is registered. False otherwise.
     */
    boolean hasObserver(@NonNull SubscriptionType type, String observerId);

    /**
     * States whether the system comprises a specific observer.
     *
     * @param observer
     *            the observer to consider.
     *
     * @return True if the observer is registered. False otherwise.
     */
    boolean hasObserver(Observer<?> observer);

    /**
     * Closes all communication channels (i.e. observers).
     * <p>
     * Note: All observers will be completed but not unsubscribed. The notification channel will not be stopped.
     */
    void completeAll();

    /**
     * Closes all communication channels (i.e. observers) of a certain type.
     * <p>
     * Note: All observers will be completed but not unsubscribed. The notification channel will not be stopped.
     *
     * @param type
     *            type of subscription to consider.
     *
     */
    void completeAll(SubscriptionType type);

    /**
     * Unsubscribes all observers contained in the system.
     */
    void unsubscribeAll();

    /**
     * Unsubscribes all observers of a certain type contained in the system.
     *
     * @param type
     *            type of subscription to consider.
     *
     */
    void unsubscribeAll(SubscriptionType type);

    /**
     * Closes a specific observer.
     * <p>
     * The underlying channel will be completed.
     *
     * @param type
     *            subscription type.
     * @param observerId
     *            identifier of the observer to complete.
     */
    void complete(SubscriptionType type, String observerId);

    /**
     * Unsubscribes a specific observer.
     *
     * @param observer
     *            to unsubscribe.
     */
    void unsubscribe(Observer<?> observer);

    /**
     * Unsubscribes a specific observer.
     *
     * @param type
     *            subscription type.
     * @param observerId
     *            identifier of the observer to unsubscribe.
     */
    void unsubscribe(SubscriptionType type, String observerId);

    /**
     * Creates an observer and registers it.
     *
     * @param type
     *            type of subscription to consider.
     * @param filter
     *            filter to apply.
     * @param strategy
     *            backpressure strategy to apply for underlying communication channel.
     * @return newly created observer
     */
    @Nullable
    Observer<?> createObserver(SubscriptionType type, FilterOptions filter, @NonNull BackpressureStrategy strategy);

    /**
     * Notifies a raw value change to observers of a certain type.
     *
     * @param type
     *            subscription type.
     * @param value
     *            raw value to send to the observers.
     * @param <T>
     *            Type of the notification message value.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    <T extends NotificationMessageValue> void notify(SubscriptionType type, @NonNull T value) throws MbedCloudException;

    /**
     * Notifies a message to observers of a certain type.
     *
     * @param type
     *            subscription type.
     * @param message
     *            message to send to the observers.
     * @param <T>
     *            Type of the notification message value.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    <T extends NotificationMessageValue> void notify(SubscriptionType type, NotificationMessage<T> message)
            throws MbedCloudException;

    /**
     * Notifies a message to a specific observer.
     *
     * @param type
     *            subscription type.
     * @param channelId
     *            identifier of the observer to notify.
     * @param message
     *            message to send to the observer.
     * @param <T>
     *            Type of the notification message value.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    <T extends NotificationMessageValue> void notify(SubscriptionType type, String channelId,
            NotificationMessage<T> message) throws MbedCloudException;

    /**
     * Gets the scheduler (similar to Executor) @see {@link Scheduler} the observation/subscription will be carried out
     * on.
     *
     * @return the scheduler.
     */
    Scheduler getObservedOnExecutor();
}
