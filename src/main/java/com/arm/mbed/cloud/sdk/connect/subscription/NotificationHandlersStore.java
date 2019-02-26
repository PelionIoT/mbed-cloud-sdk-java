package com.arm.mbed.cloud.sdk.connect.subscription;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.JsonSerialiser;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.NotificationListener;
import com.arm.mbed.cloud.sdk.common.SdkLogger;
import com.arm.mbed.cloud.sdk.common.WebsocketClient;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.WebsocketChannel;
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

    private final AbstractModule module;
    private final ExecutorService listeningThreads;
    private Future<?> listenerHandle;
    private final EndPoints endpoint;
    private final ExecutorService customSubscriptionHandlingExecutor;
    private final SubscriptionObserversStore observerStore;

    /**
     * Notification store constructor.
     *
     * @param module
     *            API module
     * @param listeningThread
     *            thread pool
     * @param endpoint
     *            endpoint
     * @param subscriptionHandlingExecutor
     *            subscription handling executor
     */
    public NotificationHandlersStore(AbstractModule module, ExecutorService listeningThread,
                                     ExecutorService subscriptionHandlingExecutor, EndPoints endpoint) {
        super();
        this.listeningThreads = listeningThread == null ? createDefaultDaemonThreadPool() : listeningThread;
        this.endpoint = createNotificationPull(endpoint);
        this.module = module;
        listenerHandle = null;
        customSubscriptionHandlingExecutor = subscriptionHandlingExecutor;
        final boolean unsubscribeOnExit = module == null ? false
                                                         : module.getConnectionOption() == null ? true
                                                                                                : !module.getConnectionOption()
                                                                                                         .isSkipCleanup();
        observerStore = new SubscriptionObserversStore((customSubscriptionHandlingExecutor == null) ? Schedulers.computation()
                                                                                                    : Schedulers.from(customSubscriptionHandlingExecutor),
                                                       new ResourceSubscriber(module, FirstValue.getDefault()),
                                                       new ResourceUnsubscriber(module, FirstValue.getDefault()),
                                                       unsubscribeOnExit ? new ResourceUnsubscriberAll(module,
                                                                                                       FirstValue.getDefault())
                                                                         : null);
    }

    /**
     * Creates a default thread pool in case none was specified.
     *
     * @return thread pool
     */
    private static ScheduledExecutorService createDefaultDaemonThreadPool() {
        return Executors.newScheduledThreadPool(1, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable runable) {
                final Thread thread = new Thread(runable);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    private EndPoints createNotificationPull(EndPoints endpoint2) {
        if (endpoint2 == null) {
            return null;
        }
        return endpoint2.clone();
    }

    public CloudSubscriptionManager getSubscriptionManager() {
        return observerStore;
    }

    /**
     * Starts notification listener.
     */
    public void startNotificationListener() {
        if (isNotificationListenerActive()) {
            logInfo("Notification listener is already working.");
            return;
        }
        listenerHandle = listeningThreads.submit(createNotificationListeningTask());
    }

    /**
     * Stops notification listener.
     */
    public void stopNotificationListener() {
        if (listenerHandle != null && !(listenerHandle.isDone() || listenerHandle.isCancelled())) {
            listenerHandle.cancel(true);
        }
        listenerHandle = null;
    }

    /**
     * States whether notification listener is currently running.
     *
     * @return true if notification producer is active. false otherwise.
     */
    public boolean isNotificationListenerActive() {
        return listenerHandle != null;
    }

    /**
     * Shuts down the store and the thread pool it uses.
     */
    public void shutdown() {
        logDebug("Shutting down notification listening thread");
        if (listeningThreads != null) {
            listeningThreads.shutdown();
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

    private Runnable createNotificationListeningTask() {
        return new Runnable() {
            private final JsonSerialiser jsonSerialiser = new JsonSerialiser();

            private NotificationMessage convert(String message) {
                return message == null ? null : jsonSerialiser.fromJson(message, NotificationMessage.class);
            }

            @Override
            public void run() {
                try (WebSocketNotificationStateMachine machine = new WebSocketNotificationStateMachine(module, endpoint,
                                                                                                       new Callback<String>() {

                                                                                                           @Override
                                                                                                           public void
                                                                                                                  execute(String arg) {
                                                                                                               emitNotification(convert(arg));
                                                                                                           }
                                                                                                       })) {
                    machine.start();
                } catch (MbedCloudException exception) {
                    logError("An exception occurred while listening to notifications", exception);
                }
            }
        };
    }

    /**
     * Websocket notification state machine.
     */
    @Internal
    private static class WebSocketNotificationStateMachine implements Closeable {

        private static final String WEBSOCKET_CONNECTION_ENDPOINT = "v2/notification/websocket-connect";
        private static final int RETRIES_NUMBER_PER_CALL = 2;
        private final WebsocketClient ws;
        private final AbstractModule module;
        private final EndPoints endpoint;
        private final SdkLogger logger;
        private final AtomicReference<WebsocketClient.StatusCode> status;
        private final AtomicReference<State> currentState;
        private final AtomicBoolean needsToStop;

        private enum State {
            START,
            END,
            LISTEN_TO_NOTIFICATIONS,
            GET_CHANNEL,
            REGISTER_CHANNEL,
            CHECK_CLOSURE_STATUS,
            DELETE_CHANNEL,
            CLEAR_ALL_CHANNELS,
            CLOSE_SOCKET,
            LOG_ERROR,
        }

        public WebSocketNotificationStateMachine(AbstractModule module, EndPoints endpoint,
                                                 Callback<String> notificationEmitter) throws MbedCloudException {
            super();
            this.module = module;
            this.endpoint = endpoint;
            status = new AtomicReference<WebsocketClient.StatusCode>(WebsocketClient.StatusCode.UNKNOWN);
            currentState = new AtomicReference<>(State.START);
            needsToStop = new AtomicBoolean(false);
            logger = module == null || module.getLogger() == null ? SdkLogger.getLogger() : module.getLogger();
            ws = module.getClient().getNewWebsocketClient(WEBSOCKET_CONNECTION_ENDPOINT,
                                                          new NotificationListener(module.getLogger(),
                                                                                   notificationEmitter, null,
                                                                                   new Callback<Integer>() {

                                                                                       @Override
                                                                                       public void
                                                                                              execute(Integer code) {
                                                                                           status.set(WebsocketClient.StatusCode.getStatus(code));
                                                                                       }
                                                                                   }, null),
                                                          module.getLogger());
        }

        @Override
        public void close() {
            needsToStop.set(true);
            if (isEnded()) {
                return;
            }
            currentState.set(State.DELETE_CHANNEL);
            runStateMachine();
        }

        public void start() {
            needsToStop.set(false);
            currentState.set(State.START);
            runStateMachine();
        }

        private void runStateMachine() {
            while (!isEnded()) {
                logger.logInfo("notification machine state: " + currentState.get());
                try {
                    switch (currentState.get()) {
                        case CLEAR_ALL_CHANNELS:
                            clearAllChannels();
                            currentState.set(State.REGISTER_CHANNEL);
                            break;
                        case CLOSE_SOCKET:
                            closeSocket();
                            currentState.set(State.END);
                            break;
                        case DELETE_CHANNEL:
                            deleteWebsocketChannel();
                            currentState.set(State.CLOSE_SOCKET);
                            break;
                        case CHECK_CLOSURE_STATUS:
                            switch (status.get()) {
                                case ABNORMAL_CLOSURE:
                                    currentState.set(State.LISTEN_TO_NOTIFICATIONS);
                                    break;
                                case NORMAL_CLOSURE:
                                    currentState.set(State.DELETE_CHANNEL);
                                    break;
                                case GOING_AWAY:
                                case SERVER_INTERNAL_ERROR:
                                    currentState.set(State.REGISTER_CHANNEL);
                                    break;
                                case POLICY_VIOLATION:
                                case UNKNOWN:
                                default:
                                    currentState.set(State.LOG_ERROR);
                                    break;
                            }
                            break;
                        case GET_CHANNEL:
                            if (checkWebsocketChannel()) {
                                currentState.set(State.LISTEN_TO_NOTIFICATIONS);
                            } else {
                                currentState.set(State.REGISTER_CHANNEL);
                            }
                            break;
                        case LISTEN_TO_NOTIFICATIONS:
                            runWebsocket();
                            if (needsToStop.get()) {
                                currentState.set(State.DELETE_CHANNEL);
                            } else {
                                currentState.set(State.CHECK_CLOSURE_STATUS);
                            }
                            break;
                        case LOG_ERROR:
                            logErrorBeforeShutdown();
                            currentState.set(State.DELETE_CHANNEL);
                            break;
                        case REGISTER_CHANNEL:
                            if (registerWebsocketChannel()) {
                                currentState.set(State.GET_CHANNEL);
                            } else {
                                final ConnectionOptions opt = module.getConnectionOption();
                                if (opt != null && opt.isForceClear()) {
                                    currentState.set(State.CLEAR_ALL_CHANNELS);
                                } else {
                                    currentState.set(State.LOG_ERROR);
                                }
                            }
                            break;
                        case START:
                            currentState.set(State.REGISTER_CHANNEL);
                            break;
                        case END:
                        default:
                            currentState.set(State.END);
                            break;
                    }
                } catch (InterruptedException exception) {
                    logger.logWarn("The websocket communication was interrupted", exception);
                    currentState.set(State.DELETE_CHANNEL);
                    needsToStop.set(true);
                }
            }
        }

        private boolean isEnded() {
            return currentState.get() == State.END;
        }

        private boolean runWebsocket() throws InterruptedException {
            logger.logDebug("Starting the websocket connection");
            try {
                ws.start();
                while (ws.isRunning() && !needsToStop.get()) {
                    Thread.sleep(10);
                }
            } catch (MbedCloudException exception) {
                logger.logError("An error occurred during websocket communication", exception);
            }
            return false;
        }

        private boolean deleteWebsocketChannel() {
            logger.logDebug("Deleting the websocket channel.");
            try {
                callDeleteWebsocketChannel();
                return true;
            } catch (MbedCloudException exception) {
                logger.logError("Could not delete websocket channel", exception);
                return false;
            }
        }

        private void callDeleteWebsocketChannel() throws MbedCloudException {
            call("deleteWebsocketChannel()", new CloudCall<Void>() {

                @Override
                public Call<Void> call() {
                    return endpoint.getWebsocket().deleteWebsocket();
                }
            }, false);
        }

        private boolean clearAllChannels() {
            logger.logDebug("Clearing all notification channels.");
            try {
                callDeleteWebsocketChannel();
            } catch (MbedCloudException exception) {
                logger.logError("Could not clear the websocket channel", exception);
            }
            try {
                call("deleteWebhook()", new CloudCall<Void>() {

                    @Override
                    public Call<Void> call() {
                        return endpoint.getNotifications().deregisterWebhook();
                    }
                }, false);
            } catch (MbedCloudException exception) {
                logger.logError("Could not delete the webhook", exception);
            }
            try {
                call("deleteLongPollingChannel()", new CloudCall<Void>() {

                    @Override
                    public Call<Void> call() {
                        return endpoint.getNotifications().deleteLongPollChannel();
                    }
                }, false);
            } catch (MbedCloudException exception) {
                logger.logError("Could not clear the long polling channel", exception);
            }
            return true;
        }

        private boolean registerWebsocketChannel() {
            logger.logDebug("Registering the websocket.");
            try {
                call("registerWebsocketChannel()", new CloudCall<WebsocketChannel>() {

                    @Override
                    public Call<WebsocketChannel> call() {
                        return endpoint.getWebsocket().registerWebsocket();
                    }
                });
                return true;
            } catch (MbedCloudException exception) {
                logger.logError("Could not register websocket channel", exception);
                return false;
            }
        }

        private boolean checkWebsocketChannel() {
            logger.logDebug("Checking if the websocket is registered");
            try {
                call("getWebsocketChannel()", new CloudCall<WebsocketChannel>() {

                    @Override
                    public Call<WebsocketChannel> call() {
                        return endpoint.getWebsocket().getWebsocket();
                    }
                });
                return true;
            } catch (MbedCloudException exception) {
                logger.logError("Could not get the current websocket channel", exception);
                return false;
            }
        }

        private boolean logErrorBeforeShutdown() {
            logger.logError("An error happened in the notification channel. Closing.");
            return true;
        }

        private boolean closeSocket() {
            logger.logInfo("Closing websocket channel.");
            ws.close();
            return true;
        }

        private void call(String functionName, CloudCall<?> caller, boolean throwOn404) throws MbedCloudException {
            CloudCaller.call(module, functionName, null, caller, false, throwOn404, RETRIES_NUMBER_PER_CALL);
        }

        private void call(String functionName, CloudCall<?> caller) throws MbedCloudException {
            call(functionName, caller, true);
        }
    }

    private void clearStores() throws MbedCloudException {
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

    @Override
    public void close() throws IOException {
        shutdown();
    }

}
