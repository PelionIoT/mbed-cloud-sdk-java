package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CallFeedback;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkLogger;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncIDResponse;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationData;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.NotificationEmitter;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.adapters.DeviceStateNotificationAdapter;
import com.arm.mbed.cloud.sdk.subscribe.store.SubscriptionObserversStore;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
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
    private final DevicesSubscriptionHandlers subscriptionHandlers;
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
        subscriptionHandlers = new DevicesSubscriptionHandlers();
        observerStore = new SubscriptionObserversStore((subscriptionHandlingExecutor == null) ? Schedulers.computation()
                : Schedulers.from(subscriptionHandlingExecutor));
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
        final Runnable cachingSingleAction = createCachingSingleAction();
        pullHandle = null;
        if (pullThreads instanceof ScheduledExecutorService) {
            pullHandle = ((ScheduledExecutorService) pullThreads).scheduleWithFixedDelay(cachingSingleAction, 0,
                    IDLE_TIME_BETWEEN_NOTIFICATION_PULL_CALLS, TimeUnit.MILLISECONDS);
        } else {
            pullHandle = pullThreads.submit(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        cachingSingleAction.run();
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
        subscriptionHandlers.registerNotificationSubscriptionCallback(resource, onNotification, onFailure);
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
    public @Nullable Flowable<NotificationMessageValue> createResourceSubscriptionObserver(Resource resource,
            BackpressureStrategy strategy) {
        return subscriptionHandlers.createResourceSubscriptionEmitter(resource, strategy);
    }

    /**
     * Deregisters the subscription callback of a resource.
     *
     * @param resource
     *            resource to consider.
     */
    public void deregisterNotificationSubscriptionCallback(Resource resource) {
        subscriptionHandlers.deregisterNotificationSubscriptionCallback(resource);
    }

    /**
     * Removes the subscription observer of a resource.
     *
     * @param resource
     *            resource to consider.
     */
    public void removeResourceSubscriptionObserver(Resource resource) {
        subscriptionHandlers.removeResourceSubscriptionEmitter(resource);

    }

    /**
     * Deregisters all subscription observers or callbacks.
     */
    public void deregisterAllResourceSubscriptionObserversOrCallbacks() {
        subscriptionHandlers.clear();
    }

    /**
     * Deregisters all subscription observers or callbacks for a device.
     *
     * @param deviceId
     *            device id of the device.
     */
    public void deregisterAllResourceSubscriptionObserversOrCallbacks(String deviceId) {
        subscriptionHandlers.removeDeviceStore(deviceId);
    }

    /**
     * Allows a notification to be injected into the notifications system.
     *
     * @param data
     *            The notification data to inject
     */
    public void notify(NotificationMessage data) {
        if (data == null) {
            return;
        }
        storeResponses(data.getAsyncResponses());
        handleSubscriptions(data.getNotifications());
        handleDeviceStateChanges(data);
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
    public Future<Object> fetchAsyncResponse(ExecutorService executor, String functionName, CloudCall<AsyncID> caller)
            throws MbedCloudException {
        api.clearApiMetadata();
        if (!isPullingActive()) {
            api.getLogger().throwSdkException(
                    "startNotifications() needs to be called before fetching any asynchronous response.");
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
                return toBeMapped.getAsyncResponseId();
            }

        };
    }

    private static Mapper<NotificationMessage, NotificationMessage> getIdentityMapper() {
        return new Mapper<NotificationMessage, NotificationMessage>() {

            @Override
            public NotificationMessage map(NotificationMessage toBeMapped) {
                return toBeMapped;
            }
        };
    }

    private Runnable createCachingSingleAction() {
        return new Runnable() {
            private final ExponentialBackoff backoffPolicy = new ExponentialBackoff(api.getLogger());

            @Override
            public void run() {
                try {
                    final CallFeedback<NotificationMessage> feedback = CloudCaller.callWithFeedback(api,
                            "NotificationPullGet()", getIdentityMapper(), new CloudCall<NotificationMessage>() {

                                @Override
                                public Call<NotificationMessage> call() {
                                    return endpoint.getNotifications().v2NotificationPullGet();
                                }
                            }, false, true);
                    final NotificationMessage notificationMessage = feedback.getResult();
                    if (notificationMessage == null) {
                        api.getLogger().logInfo(
                                "Notification pull did not receive any notification during last call. Call information: "
                                        + feedback.getMetadata());
                        return;
                    }
                    storeResponses(notificationMessage.getAsyncResponses());
                    handleSubscriptions(notificationMessage.getNotifications());
                    handleDeviceStateChanges(notificationMessage);

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
        private volatile int i;
        private volatile double currentIntervalCentre;
        private final SdkLogger logger;

        public ExponentialBackoff(SdkLogger logger) {
            super();
            reset();
            this.logger = logger;
        }

        public void reset() {
            i = 0;
            currentIntervalCentre = 500;
        }

        public void backoff() {
            if (i == 0) {
                i++;
                return;
            }
            if (i > 10) {
                // Start over.
                reset();
            }
            double delta = RANDOMISATION_FACTOR * currentIntervalCentre;
            double minInterval = currentIntervalCentre - delta;
            double maxInterval = currentIntervalCentre + delta;
            currentIntervalCentre *= MULTIPLIER;
            long currentIdleTime = (long) (minInterval + (Math.random() * (maxInterval - minInterval + 1)));
            logger.logInfo("Backoff policy: Waiting [" + currentIdleTime + " ms] before next call");
            try {
                Thread.sleep(currentIdleTime);
            } catch (InterruptedException exception) {
                logger.logError("An error occurred during Notification pull", exception);
            }
            i++;
        }

    }

    private void clearStores() {
        responseStore.clear();
        subscriptionHandlers.clear();
    }

    private void handleDeviceStateChanges(NotificationMessage notificationMessage) {
        handleNotification(SubscriptionType.DEVICE_STATE_CHANGE, notificationMessage,
                DeviceStateNotificationAdapter.getNotificationMessageMapper());
    }

    private <T extends NotificationMessageValue> void handleNotification(SubscriptionType type,
            NotificationMessage message, Mapper<NotificationMessage, List<T>> mapper) {
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

    private void handleSubscriptions(List<NotificationData> notifications) {
        if (notifications == null) {
            return;
        }
        for (final NotificationData notification : notifications) {
            if (notification == null) {
                continue;
            }
            Object value = null;
            Throwable throwable = null;
            try {
                value = decodePayload(notification.getPayload(), notification.getCt());
            } catch (DecodingException exception) {
                logNotificationError(exception);
                throwable = exception;
            }
            subscriptionHandlers.handleNotification(notification.getEp(), notification.getPath(), value, throwable);
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

    private static class NotificationCallBack {
        private final Callback<Object> onSuccess;
        private final Callback<Throwable> onFailure;

        public NotificationCallBack(Callback<Object> onSuccess, Callback<Throwable> onFailure) {
            super();
            this.onSuccess = onSuccess;
            this.onFailure = onFailure;
        }

        public void callBack(Object notification, Throwable throwable) {
            if (throwable == null) {
                if (onSuccess != null) {
                    onSuccess.execute(notification);
                }
            } else {
                if (onFailure != null) {
                    onFailure.execute(throwable);
                }
            }
        }

    }

    private static class NotificationHandler {
        private NotificationCallBack callback;
        private NotificationEmitter<NotificationMessageValue> emitter;

        public NotificationHandler() {
            super();
            callback = null;
            emitter = null;
        }

        public void registerNotificationSubscriptionCallback(Callback<Object> onNotification,
                Callback<Throwable> onFailure) {
            callback = new NotificationCallBack(onNotification, onFailure);
        }

        public void deregisterNotificationSubscriptionCallback() {
            callback = null;
        }

        public Flowable<NotificationMessageValue> createResourceSubscriptionEmitter(BackpressureStrategy strategy) {
            emitter = new NotificationEmitter<>();
            return emitter.create(strategy);
        }

        public void removeResourceSubscriptionEmitter() {
            emitter = null;
        }

        public void handleNotification(Object notification, Throwable throwable) {
            synchronized (this) {
                if (callback != null) {
                    callback.callBack(notification, throwable);
                }
            }
            synchronized (this) {
                if (emitter != null) {
                    emitter.emit(new NotificationValue(notification), throwable);
                }
            }
        }

        public synchronized boolean hasHandlers() {
            return emitter != null || callback != null;
        }

    }

    private static class DeviceSubscriptionStore {
        private final ConcurrentMap<String, NotificationHandler> store = new ConcurrentHashMap<>();

        public void handleNotification(String resourcePath, Object notification, Throwable throwable) {
            if (resourcePath == null) {
                return;
            }
            final NotificationHandler handler = store.get(resourcePath);
            if (handler != null) {
                handler.handleNotification(notification, throwable);
            }
        }

        public NotificationHandler getHandlerOrCreate(String resourcePath) {
            if (resourcePath == null) {
                return null;
            }
            NotificationHandler handler = new NotificationHandler();
            final NotificationHandler formerHandler = store.putIfAbsent(resourcePath, handler);
            if (formerHandler != null) {
                handler = formerHandler;
            }
            return handler;
        }

        public void registerNotificationSubscriptionCallback(String resourcePath, Callback<Object> onNotification,
                Callback<Throwable> onFailure) {
            if (resourcePath == null) {
                return;
            }
            final NotificationHandler handler = getHandlerOrCreate(resourcePath);
            handler.registerNotificationSubscriptionCallback(onNotification, onFailure);

        }

        public Flowable<NotificationMessageValue> createResourceSubscriptionEmitter(String resourcePath,
                BackpressureStrategy strategy) {
            if (resourcePath == null) {
                return null;
            }
            final NotificationHandler handler = getHandlerOrCreate(resourcePath);
            return handler.createResourceSubscriptionEmitter(strategy);
        }

        public void deregisterNotificationSubscriptionCallback(String resourcePath) {
            if (resourcePath == null) {
                return;
            }
            final NotificationHandler handler = getHandlerOrCreate(resourcePath);
            if (handler == null) {
                return;
            }
            handler.deregisterNotificationSubscriptionCallback();
            if (!handler.hasHandlers()) {
                removeNotificationHandler(resourcePath);
            }

        }

        public void removeResourceSubscriptionEmitter(String resourcePath) {
            if (resourcePath == null) {
                return;
            }
            final NotificationHandler handler = getHandlerOrCreate(resourcePath);
            if (handler == null) {
                return;
            }
            handler.removeResourceSubscriptionEmitter();
            if (!handler.hasHandlers()) {
                removeNotificationHandler(resourcePath);
            }
        }

        public void removeNotificationHandler(String resourcePath) {
            if (resourcePath == null) {
                return;
            }
            store.remove(resourcePath);
        }

        public void removeAllNotificationHandlers() {
            store.clear();
        }
    }

    private static class DevicesSubscriptionHandlers {
        private final ConcurrentMap<String, DeviceSubscriptionStore> store = new ConcurrentHashMap<>(
                STORE_INITIAL_CAPACITY);

        public void handleNotification(String deviceId, String resourcePath, Object notification, Throwable throwable) {
            if (deviceId == null) {
                return;
            }
            final DeviceSubscriptionStore deviceStore = store.get(deviceId);
            if (deviceStore != null) {
                deviceStore.handleNotification(resourcePath, notification, throwable);
            }
        }

        public DeviceSubscriptionStore getDeviceHandlerOrCreate(String deviceId) {
            if (deviceId == null) {
                return null;
            }
            DeviceSubscriptionStore deviceCache = new DeviceSubscriptionStore();
            final DeviceSubscriptionStore formerCache = store.putIfAbsent(deviceId, deviceCache);
            if (formerCache != null) {
                deviceCache = formerCache;
            }
            return deviceCache;
        }

        public void registerNotificationSubscriptionCallback(Resource resource, Callback<Object> onNotification,
                Callback<Throwable> onFailure) {
            if (resource == null || !resource.isValid()) {
                return;
            }
            final DeviceSubscriptionStore deviceCache = getDeviceHandlerOrCreate(resource.getDeviceId());
            deviceCache.registerNotificationSubscriptionCallback(resource.getPath(), onNotification, onFailure);

        }

        public Flowable<NotificationMessageValue> createResourceSubscriptionEmitter(Resource resource,
                BackpressureStrategy strategy) {
            if (resource == null || !resource.isValid()) {
                return null;
            }
            final DeviceSubscriptionStore deviceCache = getDeviceHandlerOrCreate(resource.getDeviceId());
            return deviceCache.createResourceSubscriptionEmitter(resource.getPath(), strategy);
        }

        public void deregisterNotificationSubscriptionCallback(Resource resource) {
            if (resource == null || !resource.isValid()) {
                return;
            }
            final DeviceSubscriptionStore deviceCache = store.get(resource.getDeviceId());
            if (deviceCache == null) {
                return;
            }
            deviceCache.deregisterNotificationSubscriptionCallback(resource.getPath());
        }

        public void removeResourceSubscriptionEmitter(Resource resource) {
            if (resource == null || !resource.isValid()) {
                return;
            }
            final DeviceSubscriptionStore deviceCache = store.get(resource.getDeviceId());
            if (deviceCache == null) {
                return;
            }
            deviceCache.removeResourceSubscriptionEmitter(resource.getPath());
        }

        public void removeDeviceStore(String deviceId) {
            if (deviceId == null) {
                return;
            }
            store.remove(deviceId);
        }

        public void clear() {
            store.clear();
        }
    }

}
