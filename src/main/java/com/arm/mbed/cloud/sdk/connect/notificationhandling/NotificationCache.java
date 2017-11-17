package com.arm.mbed.cloud.sdk.connect.notificationhandling;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
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
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncIDResponse;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationData;
import com.arm.mbed.cloud.sdk.internal.mds.model.NotificationMessage;
import com.mbed.lwm2m.DecodingException;
import com.mbed.lwm2m.EncodingType;
import com.mbed.lwm2m.base64.Base64Decoder;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import retrofit2.Call;

@Preamble(description = "Internal cache for notifications")
@Internal
public class NotificationCache {

    private static final TimePeriod REQUEST_TIMEOUT = new TimePeriod(50);

    private static final int CACHE_INITIAL_CAPACITY = 10;

    private final AbstractApi api;
    private final ExecutorService pullThreads;
    private Future<?> pullHandle;
    private final EndPoints endpoint;
    private final ConcurrentHashMap<String, AsyncResponse> responseCache;
    private final DevicesSubscriptionCache subscriptionCache;

    /**
     * Notification cache constructor.
     * 
     * @param api
     *            API module
     * @param pullingThread
     *            thread pool
     * @param endpoint
     *            endpoint
     */
    public NotificationCache(AbstractApi api, ExecutorService pullingThread, EndPoints endpoint) {
        super();
        this.pullThreads = pullingThread;
        this.endpoint = createNotificationPull(endpoint);
        this.api = api;
        pullHandle = null;
        responseCache = new ConcurrentHashMap<>(CACHE_INITIAL_CAPACITY);
        subscriptionCache = new DevicesSubscriptionCache();
    }

    private EndPoints createNotificationPull(EndPoints endpoint2) {
        final ConnectionOptions options = endpoint2.getConnectionOptions();
        options.setRequestTimeout(REQUEST_TIMEOUT);
        return new EndPoints(options);
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
            pullHandle = ((ScheduledExecutorService) pullThreads).scheduleWithFixedDelay(cachingSingleAction, 0, 50,
                    TimeUnit.MILLISECONDS);
        } else {
            pullHandle = pullThreads.submit(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        cachingSingleAction.run();
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
        clearCaches();
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
     * Shuts down the cache and the thread pool it uses.
     */
    public void shutdown() {
        if (pullThreads != null) {
            pullThreads.shutdown();
        }
        clearCaches();
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
        subscriptionCache.registerNotificationSubscriptionCallback(resource, onNotification, onFailure);
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
    public @Nullable Flowable<Object> createResourceSubscriptionObserver(Resource resource,
            BackpressureStrategy strategy) {
        return subscriptionCache.createResourceSubscriptionEmitter(resource, strategy);
    }

    /**
     * Deregisters the subscription callback of a resource.
     * 
     * @param resource
     *            resource to consider.
     */
    public void deregisterNotificationSubscriptionCallback(Resource resource) {
        subscriptionCache.deregisterNotificationSubscriptionCallback(resource);
    }

    /**
     * Removes the subscription observer of a resource.
     * 
     * @param resource
     *            resource to consider.
     */
    public void removeResourceSubscriptionObserver(Resource resource) {
        subscriptionCache.removeResourceSubscriptionEmitter(resource);

    }

    /**
     * Deregisters all subscription observers or callbacks.
     */
    public void deregisterAllResourceSubscriptionObserversOrCallbacks() {
        subscriptionCache.clear();
    }

    /**
     * Deregisters all subscription observers or callbacks for a device.
     * 
     * @param deviceId
     *            device id of the device.
     */
    public void deregisterAllResourceSubscriptionObserversOrCallbacks(String deviceId) {
        subscriptionCache.removeDeviceCache(deviceId);
    }

    /**
     * Fetchs the response of an asynchronous request.
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
                while (!responseCache.containsKey(responseId)) {
                    Thread.sleep(10);
                }
                final AsyncResponse response = responseCache.get(responseId);
                responseCache.remove(responseId);
                if (response == null) {
                    return null;
                }
                if (response.statusCode != 200) {
                    final String errorMessage = response.errorMessage;
                    return errorMessage == null
                            ? "Async error (" + responseId + "). Status code: " + response.statusCode : errorMessage;
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
            @Override
            public void run() {
                try {
                    final CallFeedback<NotificationMessage> feedback = CloudCaller.callWithFeedback(api,
                            "NotificationPullGet()", getIdentityMapper(), new CloudCall<NotificationMessage>() {

                                @Override
                                public Call<NotificationMessage> call() {
                                    return endpoint.getNotifications().v2NotificationPullGet();
                                }
                            }, false);
                    final NotificationMessage notificationMessage = feedback.getResult();
                    if (notificationMessage == null) {
                        api.getLogger().logInfo(
                                "Notification pull did not receive any notification during last call. Call information: "
                                        + feedback.getMetadata());
                        return;
                    }
                    cacheResponses(notificationMessage.getAsyncResponses());
                    handleSubscriptions(notificationMessage.getNotifications());

                } catch (MbedCloudException exception) {
                    logPullError(exception);
                }
            }
        };
    }

    private void clearCaches() {
        responseCache.clear();
        subscriptionCache.clear();
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
                logPullError(exception);
                throwable = exception;
            }
            subscriptionCache.handleNotification(notification.getEp(), notification.getPath(), value, throwable);
        }
    }

    private void logPullError(Exception exception) {
        api.getLogger().logError("An error occurred during Notification pull", exception);
    }

    private void cacheResponses(List<AsyncIDResponse> asyncResponses) {
        if (asyncResponses == null) {
            return;
        }
        for (final AsyncIDResponse response : asyncResponses) {
            if (response == null) {
                continue;
            }

            try {
                final AsyncResponse asyncResponse = new AsyncResponse(response);
                responseCache.put(asyncResponse.getKey(), asyncResponse);
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

    private static class NotificationEmitter {

        private final List<FlowableEmitter<Object>> emitters = new LinkedList<>();

        public Flowable<Object> create(BackpressureStrategy strategy) {

            final FlowableOnSubscribe<Object> source = new FlowableOnSubscribe<Object>() {

                @Override
                public void subscribe(FlowableEmitter<Object> emitter) {
                    emitters.add(emitter);

                }
            };
            return Flowable.create(source, strategy);
        }

        public void emit(Object notification, Throwable throwable) {
            if (throwable == null) {
                for (final FlowableEmitter<Object> emitter : emitters) {
                    emitter.onNext(notification);
                }
            } else {
                for (final FlowableEmitter<Object> emitter : emitters) {
                    emitter.onError(throwable);
                }
            }
        }
    }

    private static class NotificationHandler {
        private NotificationCallBack callback;
        private NotificationEmitter emitter;

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

        public Flowable<Object> createResourceSubscriptionEmitter(BackpressureStrategy strategy) {
            emitter = new NotificationEmitter();
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
                    emitter.emit(notification, throwable);
                }
            }
        }

        public synchronized boolean hasHandlers() {
            return emitter != null || callback != null;
        }

    }

    private static class DeviceSubscriptionCache {
        private final ConcurrentMap<String, NotificationHandler> cache = new ConcurrentHashMap<>();

        public void handleNotification(String resourcePath, Object notification, Throwable throwable) {
            if (resourcePath == null) {
                return;
            }
            final NotificationHandler handler = cache.get(resourcePath);
            if (handler != null) {
                handler.handleNotification(notification, throwable);
            }
        }

        public NotificationHandler getHandlerOrCreate(String resourcePath) {
            if (resourcePath == null) {
                return null;
            }
            NotificationHandler handler = new NotificationHandler();
            final NotificationHandler formerHandler = cache.putIfAbsent(resourcePath, handler);
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

        public Flowable<Object> createResourceSubscriptionEmitter(String resourcePath, BackpressureStrategy strategy) {
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
            cache.remove(resourcePath);
        }

        public void removeAllNotificationHandlers() {
            cache.clear();
        }
    }

    private static class DevicesSubscriptionCache {
        private final ConcurrentMap<String, DeviceSubscriptionCache> cache = new ConcurrentHashMap<>(
                CACHE_INITIAL_CAPACITY);

        public void handleNotification(String deviceId, String resourcePath, Object notification, Throwable throwable) {
            if (deviceId == null) {
                return;
            }
            final DeviceSubscriptionCache deviceCache = cache.get(deviceId);
            if (deviceCache != null) {
                deviceCache.handleNotification(resourcePath, notification, throwable);
            }
        }

        public DeviceSubscriptionCache getDeviceHandlerOrCreate(String deviceId) {
            if (deviceId == null) {
                return null;
            }
            DeviceSubscriptionCache deviceCache = new DeviceSubscriptionCache();
            final DeviceSubscriptionCache formerCache = cache.putIfAbsent(deviceId, deviceCache);
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
            final DeviceSubscriptionCache deviceCache = getDeviceHandlerOrCreate(resource.getDeviceId());
            deviceCache.registerNotificationSubscriptionCallback(resource.getPath(), onNotification, onFailure);

        }

        public Flowable<Object> createResourceSubscriptionEmitter(Resource resource, BackpressureStrategy strategy) {
            if (resource == null || !resource.isValid()) {
                return null;
            }
            final DeviceSubscriptionCache deviceCache = getDeviceHandlerOrCreate(resource.getDeviceId());
            return deviceCache.createResourceSubscriptionEmitter(resource.getPath(), strategy);
        }

        public void deregisterNotificationSubscriptionCallback(Resource resource) {
            if (resource == null || !resource.isValid()) {
                return;
            }
            final DeviceSubscriptionCache deviceCache = cache.get(resource.getDeviceId());
            if (deviceCache == null) {
                return;
            }
            deviceCache.deregisterNotificationSubscriptionCallback(resource.getPath());
        }

        public void removeResourceSubscriptionEmitter(Resource resource) {
            if (resource == null || !resource.isValid()) {
                return;
            }
            final DeviceSubscriptionCache deviceCache = cache.get(resource.getDeviceId());
            if (deviceCache == null) {
                return;
            }
            deviceCache.removeResourceSubscriptionEmitter(resource.getPath());
        }

        public void removeDeviceCache(String deviceId) {
            if (deviceId == null) {
                return;
            }
            cache.remove(deviceId);
        }

        public void clear() {
            cache.clear();
        }
    }
}
