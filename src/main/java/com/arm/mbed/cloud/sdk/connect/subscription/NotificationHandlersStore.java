package com.arm.mbed.cloud.sdk.connect.subscription;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
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
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CallFeedback;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkLogger;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncIDResponse;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.NotificationCallback;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.adapters.DeviceStateNotificationAdapter;
import com.arm.mbed.cloud.sdk.subscribe.adapters.ResourceValueNotificationAdapter;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueNotification;
import com.arm.mbed.cloud.sdk.subscribe.store.SubscriptionObserversStore;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

import retrofit2.Call;

@Preamble(description = "Internal store for notification handlers")
@Internal
public class NotificationHandlersStore {

    private static final int IDLE_TIME_BETWEEN_NOTIFICATION_PULL_CALLS = 50;

    private static final TimePeriod REQUEST_TIMEOUT = new TimePeriod(50);

    private static final int STORE_INITIAL_CAPACITY = 10;

    private final AbstractApi api;
    private final ExecutorService pullThreads;
    private Future<?> pullHandle;
    private final EndPoints endpoint;
    private final ConcurrentHashMap<String, AsyncResponse> responseStore;
    private final SubscriptionObserversStore observerStore;

    /**
     * Notification store constructor.
     *
     * @param api
     *            API module
     * @param pullingThread
     *            thread pool
     * @param endpoint
     *            endpoint
     * @param subscriptionHandlingExecutor
     *            subscription handling executor
     */
    public NotificationHandlersStore(AbstractApi api, ExecutorService pullingThread,
                                     ExecutorService subscriptionHandlingExecutor, EndPoints endpoint) {
        super();
        this.pullThreads = pullingThread;
        this.endpoint = createNotificationPull(endpoint);
        this.api = api;
        pullHandle = null;
        responseStore = new ConcurrentHashMap<>(STORE_INITIAL_CAPACITY);
        observerStore = new SubscriptionObserversStore((subscriptionHandlingExecutor == null) ? Schedulers.computation()
                                                                                              : Schedulers.from(subscriptionHandlingExecutor),
                                                       new ResourceSubscriber(api, FirstValue.getDefault()),
                                                       new ResourceUnsubscriber(api, FirstValue.getDefault()));
    }

    private EndPoints createNotificationPull(EndPoints endpoint2) {
        if (endpoint2 == null) {
            return null;
        }
        final ConnectionOptions options = endpoint2.getConnectionOptions();
        options.setRequestTimeout(REQUEST_TIMEOUT);
        return new EndPoints(options);
    }

    public CloudSubscriptionManager getSubscriptionManager() {
        return observerStore;
    }

    /**
     * Starts notification pull.
     */
    public void startNotificationPull() {
        if (isPullingActive()) {
            api.getLogger().logInfo("Notification pull is already working.");
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
        if (pullThreads != null) {
            pullThreads.shutdown();
        }
        clearStores();
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

    /**
     * Allows a notification to be injected into the notifications system.
     *
     * @param data
     *            The notification data to inject
     */
    public void notify(NotificationMessage data) {
        emitNotification(data);
    }

    /**
     * Fetches the response of an asynchronous request.
     *
     * @param executor
     *            "finder" thread pool
     * @param functionName
     *            name of the API.
     * @param caller
     *            caller
     * @return Future task
     * @throws MbedCloudException
     *             if an error occurred during the call.
     */
    public Future<Object> fetchAsyncResponse(ExecutorService executor, String functionName,
                                             CloudCall<AsyncID> caller) throws MbedCloudException {
        api.clearApiMetadata();
        if (!isPullingActive()) {
            api.getLogger()
               .throwSdkException("startNotifications() needs to be called before fetching any asynchronous response.");
        }
        final String asyncResponseId = CloudCaller.call(api, functionName, getResponseIdMapper(), caller);
        return fetchAsyncResponse(executor, asyncResponseId);
    }

    @SuppressWarnings("null")
    private Future<Object> fetchAsyncResponse(ExecutorService executor, String id) throws MbedCloudException {
        if (executor == null || id == null || id.isEmpty()) {
            api.getLogger().throwSdkException(new IllegalArgumentException());
        }
        final String responseId = id;
        return executor.submit(new Callable<Object>() {

            @Override
            public Object call() throws InterruptedException {
                while (!responseStore.containsKey(responseId)) {
                    Thread.sleep(10);
                }
                final AsyncResponse response = responseStore.get(responseId);
                responseStore.remove(responseId);
                if (response == null) {
                    return null;
                }
                if (response.statusCode != 200) {
                    return new com.arm.mbed.cloud.sdk.common.Error(response.statusCode, "Async error",
                                                                   response.errorMessage, responseId);
                }
                return response.payload;
            }

        });
    }

    private static Mapper<AsyncID, String> getResponseIdMapper() {
        return new Mapper<AsyncID, String>() {

            @Override
            public String map(AsyncID toBeMapped) {
                return toBeMapped == null ? null : toBeMapped.getAsyncResponseId();
            }

        };
    }

    private Runnable createPollingSingleAction() {
        return new Runnable() {
            private final ExponentialBackoff backoffPolicy = new ExponentialBackoff(api.getLogger());

            @Override
            public void run() {
                try {
                    final CallFeedback<NotificationMessage,
                                       NotificationMessage> feedback = CloudCaller.callWithFeedback(api,
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
                        api.getLogger().logInfo(
                                                "Notification pull did not receive any notification during last call. Call information: "
                                                + feedback.getMetadata());
                        return;
                    }
                    emitNotification(notificationMessage);
                } catch (MbedCloudException exception) {
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
        responseStore.clear();
        observerStore.unsubscribeAll();
    }

    private void emitNotification(NotificationMessage data) {
        if (data == null) {
            return;
        }
        storeResponses(data.getAsyncResponses());
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
        api.getLogger().logError("An error occurred while handling notifications", exception);
    }

    private void logPullError(Exception exception) {
        api.getLogger().logError("An error occurred during Notification pull", exception);
    }

    private void storeResponses(List<AsyncIDResponse> asyncResponses) {
        if (asyncResponses == null) {
            return;
        }
        for (final AsyncIDResponse response : asyncResponses) {
            if (response == null) {
                continue;
            }

            try {
                final AsyncResponse asyncResponse = new AsyncResponse(response);
                responseStore.put(asyncResponse.getKey(), asyncResponse);
            } catch (DecodingException exception) {
                logPullError(exception);
            }

        }
    }

    private static Object decodePayload(String payload, String ct) throws DecodingException {
        final EncodingType encodingType = EncodingType.getType(ct);
        if (encodingType == EncodingType.UNKNOWN) {
            return Base64Decoder.decodeToUtf8(payload);
        }
        final byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
        final ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return Base64Decoder.decodeBase64(buffer, encodingType);
    }

    /**
     * Defines Asynchronous responses.
     *
     */
    private static class AsyncResponse {
        private final String id;
        private final int statusCode;
        private final String errorMessage;
        private final Object payload;

        /**
         * Constructor.
         *
         * @param id
         *            response id
         * @param statusCode
         *            HTTP status code
         * @param errorMessage
         *            error message
         * @param payload
         *            response payload
         */
        public AsyncResponse(String id, int statusCode, String errorMessage, Object payload) {
            super();
            this.id = id;
            this.statusCode = statusCode;
            this.errorMessage = errorMessage;
            this.payload = payload;
        }

        public AsyncResponse(AsyncIDResponse response) throws DecodingException {
            this(response.getId(), TranslationUtils.toInt(response.getStatus(), 200), response.getError(),
                 decodePayload(response.getPayload(), response.getCt()));
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
            result = prime * result + ((payload == null) ? 0 : payload.hashCode());
            result = prime * result + statusCode;
            return result;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final AsyncResponse other = (AsyncResponse) obj;
            if (errorMessage == null) {
                if (other.errorMessage != null) {
                    return false;
                }
            } else if (!errorMessage.equals(other.errorMessage)) {
                return false;
            }
            if (payload == null) {
                if (other.payload != null) {
                    return false;
                }
            } else if (!payload.equals(other.payload)) {
                return false;
            }
            if (statusCode != other.statusCode) {
                return false;
            }
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "AsyncResponse [statusCode=" + statusCode + ", errorMessage=" + errorMessage + ", payload=" + payload
                   + "]";
        }

        public String getKey() {
            return id;
        }

    }

}
