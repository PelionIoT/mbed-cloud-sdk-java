package com.arm.mbed.cloud.sdk.connect.subscription;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CallFeedback;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkLogger;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.NotificationCallback;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.adapters.AsynchronousResponseNotificationAdapter;
import com.arm.mbed.cloud.sdk.subscribe.adapters.DeviceStateNotificationAdapter;
import com.arm.mbed.cloud.sdk.subscribe.adapters.ResourceValueNotificationAdapter;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueNotification;
import com.arm.mbed.cloud.sdk.subscribe.store.SubscriptionObserversStore;

import retrofit2.Call;

@Preamble(description = "Internal store for notification handlers")
@Internal
public class NotificationHandlersStore implements Closeable {

    private static final int IDLE_TIME_BETWEEN_NOTIFICATION_PULL_CALLS = 50;

    private static final TimePeriod REQUEST_TIMEOUT = new TimePeriod(50);

    private final AbstractModule module;
    private final ExecutorService pullThreads;
    private Future<?> pullHandle;
    private final EndPoints endpoint;
    private final ExecutorService customSubscriptionHandlingExecutor;
    private final SubscriptionObserversStore observerStore;

    /**
     * Notification store constructor.
     *
     * @param module
     *            API module
     * @param pullingThread
     *            thread pool
     * @param endpoint
     *            endpoint
     * @param subscriptionHandlingExecutor
     *            subscription handling executor
     */
    public NotificationHandlersStore(AbstractModule module, ExecutorService pullingThread,
                                     ExecutorService subscriptionHandlingExecutor, EndPoints endpoint) {
        super();
        this.pullThreads = pullingThread;
        this.endpoint = createNotificationPull(endpoint);
        this.module = module;
        pullHandle = null;
        customSubscriptionHandlingExecutor = subscriptionHandlingExecutor;
        observerStore = new SubscriptionObserversStore((customSubscriptionHandlingExecutor == null) ? Schedulers.computation()
                                                                                                    : Schedulers.from(customSubscriptionHandlingExecutor),
                                                       new ResourceSubscriber(module, FirstValue.getDefault()),
                                                       new ResourceUnsubscriber(module, FirstValue.getDefault()));
    }

    private EndPoints createNotificationPull(EndPoints endpoint2) {
        if (endpoint2 == null) {
            return null;
        }
        final EndPoints clone = endpoint2.clone();
        clone.setRequestTimeout(REQUEST_TIMEOUT);
        return clone;
    }

    public CloudSubscriptionManager getSubscriptionManager() {
        return observerStore;
    }

    /**
     * Starts notification pull.
     */
    public void startNotificationPull() {
        if (isPullingActive()) {
            logInfo("Notification pull is already working.");
            return;
        }
        final Runnable pollingSingleAction = createPollingSingleAction();
        pullHandle = null;
        if (pullThreads instanceof ScheduledExecutorService) {
            pullHandle = ((ScheduledExecutorService) pullThreads).scheduleWithFixedDelay(pollingSingleAction, 0,
                                                                                         IDLE_TIME_BETWEEN_NOTIFICATION_PULL_CALLS,
                                                                                         TimeUnit.MILLISECONDS);
        } else {
            pullHandle = pullThreads.submit(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        pollingSingleAction.run();
                        try {
                            // Sleeping between calls
                            Thread.sleep(IDLE_TIME_BETWEEN_NOTIFICATION_PULL_CALLS);
                        } catch (InterruptedException exception) {
                            logPullError(exception);
                        }
                    }

                }
            });
        }

    }

    /**
     * Stops notification pull.
     */
    public void stopNotificationPull() {
        if (pullHandle != null && !(pullHandle.isDone() || pullHandle.isCancelled())) {
            pullHandle.cancel(true);
        }
        pullHandle = null;
    }

    /**
     * States whether pulling is currently on going.
     *
     * @return true if pulling is active. false otherwise.
     */
    public boolean isPullingActive() {
        return pullHandle != null;
    }

    /**
     * Shuts down the store and the thread pool it uses.
     */
    public void shutdown() {
        logDebug("Shutting down polling thread");
        if (pullThreads != null) {
            pullThreads.shutdown();
        }
        logDebug("Clearing notification handler store");
        try {
            clearStores();
        } catch (Exception exception) {
            logError("Failed clearing notification handler store", exception);
        }
        logDebug("Shutting down notification threads");
        if (customSubscriptionHandlingExecutor != null) {
            customSubscriptionHandlingExecutor.shutdown();
        }
        // shutting down schedulers can have side effects
        // logDebug("Shutting down notification schedulers");
        // try {
        // Schedulers.shutdown();
        // } catch (Exception exception) {
        // logError("Failed shutting down notification schedulers", exception);
        // }
    }

    protected void logDebug(String message) {
        final SdkLogger logger = module == null ? null : module.getLogger();
        if (logger != null) {
            logger.logDebug(message);
        }
    }

    protected void logError(String message, Exception exception) {
        final SdkLogger logger = module == null ? null : module.getLogger();
        if (logger != null) {
            logger.logError(message, exception);
        }
    }

    protected void logInfo(String message) {
        final SdkLogger logger = module == null ? null : module.getLogger();
        if (logger != null) {
            logger.logInfo(message);
        }
    }

    /**
     * Registers resource subscription callback.
     *
     * @param resource
     *            resource to register the callback for.
     * @param onNotification
     *            callback to execute on notification.
     * @param onFailure
     *            callback to execute on error.
     */
    public void registerSubscriptionCallback(Resource resource, Callback<Object> onNotification,
                                             Callback<Throwable> onFailure) {
        registerSubscriptionCallback(resource, onNotification, onFailure, FirstValue.getDefault());
    }

    /**
     * Registers resource subscription callback.
     *
     * @param resource
     *            resource to register the callback for.
     * @param onNotification
     *            callback to execute on notification.
     * @param triggerMode
     *            mode of getting the first resource value
     * @param onFailure
     *            callback to execute on error.
     */
    public void registerSubscriptionCallback(Resource resource, Callback<Object> onNotification,
                                             Callback<Throwable> onFailure, FirstValue triggerMode) {
        final Callback<Object> onNotificationCallBack = onNotification;
        observerStore.resourceValues(resource, BackpressureStrategy.BUFFER, triggerMode)
                     .addCallback(new NotificationCallback<>(new Callback<ResourceValueNotification>() {

                         @Override
                         public void execute(ResourceValueNotification notification) {
                             if (onNotificationCallBack != null && notification != null) {
                                 onNotificationCallBack.execute(notification.getPayload());
                             }

                         }

                     }, onFailure));
    }

    /**
     * Creates an observer for resource subscriptions.
     *
     * @param resource
     *            resource to register the callback for.
     * @param strategy
     *            backpressure strategy to apply @see {@link BackpressureStrategy}
     * @return Observable which can be subscribed to. @see {@link Flowable}
     */
    public @Nullable Flowable<NotificationMessageValue>
           createResourceSubscriptionObserver(Resource resource, BackpressureStrategy strategy) {
        return observerStore.resourceValues(resource, strategy).flow()
                            .map(new Function<ResourceValueNotification, NotificationMessageValue>() {

                                @Override
                                public NotificationMessageValue
                                       apply(ResourceValueNotification value) throws Exception {
                                    return value;
                                }
                            });
    }

    /**
     * Deregisters the subscription callback of a resource.
     *
     * @param resource
     *            resource to consider.
     */
    public void deregisterNotificationSubscriptionCallback(Resource resource) {
        removeResourceSubscriptionObserver(resource);
    }

    /**
     * Removes the subscription observer of a resource.
     *
     * @param resource
     *            resource to consider.
     */
    public void removeResourceSubscriptionObserver(Resource resource) {
        try {
            observerStore.unsubscribeResourceObserver(resource);
        } catch (MbedCloudException exception) {
            logNotificationError(exception);
        }

    }

    /**
     * Deregisters all subscription observers or callbacks.
     */
    public void deregisterAllResourceSubscriptionObserversOrCallbacks() {
        observerStore.unsubscribeAll(SubscriptionType.NOTIFICATION);
    }

    /**
     * Deregisters all subscription observers or callbacks for a device.
     *
     * @param deviceId
     *            device id of the device.
     */
    public void deregisterAllResourceSubscriptionObserversOrCallbacks(String deviceId) {
        try {
            observerStore.unsubscribeResourceObserver(new Resource(deviceId, null));
        } catch (MbedCloudException exception) {
            logNotificationError(exception);
        }
    }

    public AsynchronousResponseObserver createAsyncResponseObserver(Resource finalResource, String finalAsyncId,
                                                                    BackpressureStrategy finalStrategy,
                                                                    boolean notifyOtherObservers) {
        return observerStore.asynchronousResponse(finalAsyncId, finalResource, notifyOtherObservers, finalStrategy);
    }

    /**
     * Allows a notification to be injected into the notifications system.
     *
     * @param data
     *            The notification data to inject
     */
    public void notify(NotificationMessage data) {
        emitNotification(data);
    }

    private Runnable createPollingSingleAction() {
        return new Runnable() {
            private final ExponentialBackoff backoffPolicy = new ExponentialBackoff(module.getLogger());

            @Override
            public void run() {
                try {
                    final CallFeedback<NotificationMessage,
                                       NotificationMessage> feedback = CloudCaller.callWithFeedback(module,
                                                                                                    "NotificationPullGet()",
                                                                                                    GenericAdapter.identityMapper(NotificationMessage.class),
                                                                                                    new CloudCall<NotificationMessage>() {

                                                                                                        @Override
                                                                                                        public Call<NotificationMessage>
                                                                                                               call() {
                                                                                                            return endpoint.getNotifications()
                                                                                                                           .longPollNotifications();
                                                                                                        }
                                                                                                    }, false, true);
                    final NotificationMessage notificationMessage = feedback.getResult();
                    if (notificationMessage == null) {
                        logInfo("Notification pull did not receive any notification during last call. Call information: "
                                + feedback.getMetadata());
                        return;
                    }
                    emitNotification(notificationMessage);
                } catch (Exception exception) {
                    backoffPolicy.backoff();
                    logPullError(exception);
                }
            }

        };
    }

    /**
     * BackOff that increases the back off period for each retry attempt using a randomization function that grows
     * exponentially.
     *
     * @see https://developers.google.com/api-client-library/java/google-http-java-client/reference/1.20.0/com/google/api/client/util/ExponentialBackOff
     *
     */
    private static class ExponentialBackoff {
        private static final double RANDOMISATION_FACTOR = 0.5d;
        private static final double MULTIPLIER = 1.5d;
        private volatile int callIndex;
        private volatile double currentIntervalCentre;
        private final SdkLogger logger;

        public ExponentialBackoff(SdkLogger logger) {
            super();
            reset();
            this.logger = logger;
        }

        public void reset() {
            callIndex = 0;
            currentIntervalCentre = 500;
        }

        public void backoff() {
            if (callIndex == 0) {
                callIndex++;
                return;
            }
            if (callIndex > 10) {
                // Start over.
                reset();
            }
            final double delta = RANDOMISATION_FACTOR * currentIntervalCentre;
            final double minInterval = currentIntervalCentre - delta;
            final double maxInterval = currentIntervalCentre + delta;
            currentIntervalCentre *= MULTIPLIER;
            final long currentIdleTime = (long) (minInterval + Math.random() * (maxInterval - minInterval + 1));
            logger.logInfo("Backoff policy: Waiting [" + currentIdleTime + " ms] before next call");
            try {
                Thread.sleep(currentIdleTime);
            } catch (InterruptedException exception) {
                logger.logError("An error occurred during Notification pull", exception);
            }
            callIndex++;
        }

    }

    private void clearStores() {
        observerStore.unsubscribeAll();
    }

    private void emitNotification(NotificationMessage data) {
        if (data == null) {
            return;
        }
        handleAsynchronousResponse(data);
        handleResourceValueChanges(data);
        handleDeviceStateChanges(data);
    }

    private void handleDeviceStateChanges(NotificationMessage notificationMessage) {
        handleNotification(SubscriptionType.DEVICE_STATE_CHANGE, notificationMessage,
                           DeviceStateNotificationAdapter.getNotificationMessageMapper());
    }

    private void handleResourceValueChanges(NotificationMessage notificationMessage) {
        handleNotification(SubscriptionType.NOTIFICATION, notificationMessage,
                           ResourceValueNotificationAdapter.getNotificationMessageMapper());
    }

    private void handleAsynchronousResponse(NotificationMessage notificationMessage) {
        handleNotification(SubscriptionType.ASYNCHRONOUS_RESPONSE, notificationMessage,
                           AsynchronousResponseNotificationAdapter.getNotificationMessageMapper());
    }

    private <T extends NotificationMessageValue> void handleNotification(SubscriptionType type,
                                                                         NotificationMessage message,
                                                                         Mapper<NotificationMessage, List<T>> mapper) {
        if (message == null || mapper == null || type == null) {
            return;
        }
        final List<T> notifications = mapper.map(message);
        if (notifications == null) {
            return;
        }
        for (final T notification : notifications) {
            try {
                observerStore.notify(type, notification);
            } catch (MbedCloudException exception) {
                logNotificationError(exception);
            }
        }
    }

    private void logNotificationError(Exception exception) {
        logError("An error occurred while handling notifications", exception);
    }

    private void logPullError(Exception exception) {
        logError("An error occurred during Notification pull", exception);
    }

    @Override
    public void close() throws IOException {
        shutdown();
    }

}
