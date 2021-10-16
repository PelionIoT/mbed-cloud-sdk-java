package com.arm.mbed.cloud.sdk;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Daemon;
import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.Callback;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudRequest.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.DeliveryMethod;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.JsonSerialiser;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod.AsynchronousMethod;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.UuidGenerator;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.connect.adapters.EchoAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.MetricAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.ResourceAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.WebhookAdapter;
import com.arm.mbed.cloud.sdk.connect.model.AbstractMetricsListOptions;
import com.arm.mbed.cloud.sdk.connect.model.EchoDevice;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.connect.model.ResourceDao;
import com.arm.mbed.cloud.sdk.connect.model.Subscription;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;
import com.arm.mbed.cloud.sdk.connect.model.WebhookDao;
import com.arm.mbed.cloud.sdk.connect.subscription.NotificationHandlersStore;
import com.arm.mbed.cloud.sdk.connect.subscription.ResourceAction;
import com.arm.mbed.cloud.sdk.connect.subscription.ResourceActionParameters;
import com.arm.mbed.cloud.sdk.connect.subscription.ResourceValueType;
import com.arm.mbed.cloud.sdk.connect.subscription.adapters.ResourceActionAdapter;
import com.arm.mbed.cloud.sdk.devices.model.Device;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListDao;
import com.arm.mbed.cloud.sdk.devices.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devices.model.DeviceState;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.DeviceRequest;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.PresubscriptionArray;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.SuccessfulResponse;
import com.arm.mbed.cloud.sdk.notify.CloudNotificationManager;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.NotificationMessageValue;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseObserver;

import retrofit2.Call;

@Preamble(description = "Specifies Connect API")
@Module
/**
 * API exposing functionality for doing a range of device related actions:
 * <p>
 * 1) Listing connected devices
 * <p>
 * 2) Exploring and managing resources and resource values on said devices
 * <p>
 * 3) Setup resource subscriptions and webhooks for resource monitoring
 */
public class Connect extends AbstractModule {
    private static final String BUFFER = "BUFFER";
    private static final String TAG_VALUE_TYPE = "valueType";
    private static final String TAG_PRESUBSCRIPTION = "presubscription";
    private static final String TAG_ON_NOTIFICATION_CALLBACK = "on notification callback";
    private static final String TAG_WEBHOOK = "webhook";
    private static final String TAG_RESOURCE = "resource";
    private static final String TAG_RESOURCE_PATH = "resource path";
    private static final String TAG_METRIC_OPTIONS = "Metric options";
    private static final String TAG_DEVICE_ID = "Device Id";
    private static final String TAG_DEVICE = "Device";
    private final EndPoints endpoint;

    protected final NotificationHandlersStore handlersStore;
    protected final AtomicReference<DeliveryMethod> deliveryMethod;
    private final Object presubscriptionLock = new Object();
    private final Object webhookLock = new Object();

    @Internal
    protected Connect() {
        this(new ConnectionOptions());
    }

    /**
     * Connect module constructor.
     * <p>
     * This module spawns threads for retrieving notifications when daemon is started @see
     * {@link #startNotifications()}.
     * <p>
     * By default, the executor services in charge are defined and managed internally. It is however possible to specify
     * your own executors @see #Connect(ConnectionOptions, ExecutorService, ExecutorService).
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Connect(@NonNull ConnectionOptions options) {
        this(options, null, null);
    }

    /**
     * Constructor.
     * 
     * @param context
     *            SDK context
     */
    public Connect(SdkContext context) {
        this(context == null ? null : context.getConnectionOption());
    }

    /**
     * Connect module constructor.
     * <p>
     * As opposed to {@link #Connect(ConnectionOptions)} which uses default thread pools for retrieving notifications,
     * this constructor lets you the possibility to specify the executor services to use.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     *
     * @param notificationHandlingThreadPool
     *            Threads in charge of retrieving notifications for a specific resource. If null, a default thread pool
     *            will be created internally.
     * @param notificationListeningThreadPool
     *            Threads in charge of listening to notifications. The pool can either be a scheduled thread pool or a
     *            fixed thread pool depending on what best suits your system. If null, an internal timer will be created
     *            internally.
     */
    public Connect(@NonNull ConnectionOptions options, @Nullable ExecutorService notificationHandlingThreadPool,
                   @Nullable ExecutorService notificationListeningThreadPool) {
        super(options);
        deliveryMethod = new AtomicReference<DeliveryMethod>(DeliveryMethod.UNDEFINED);
        endpoint = new EndPoints(this.serviceRegistry);
        this.handlersStore = new NotificationHandlersStore(this, notificationListeningThreadPool,
                                                           notificationHandlingThreadPool, endpoint);

    }

    @SuppressWarnings("resource")
    @Override
    public Connect clone() {
        return new Connect(this).setDeliveryMethod(deliveryMethod.get());
    }

    /**
     * Starts notification pull.
     * <p>
     * If an external callback is not set up (using `update_webhook`) then calling this function is mandatory to get or
     * set resources. Unless {@link ConnectionOptions#setAutostartDaemon(boolean)} has been set to true or left as
     * default.
     *
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    @API
    @Daemon(task = "Listen to notification", start = true)
    public void startNotifications() throws MbedCloudException {
        logger.logInfo(getModuleName() + ": startNotifications()");
        if (handlersStore.isNotificationListenerActive()) {
            logger.logInfo("Notification listening daemon thread is already started");
            return;
        }
        setDeliveryMethod(true);
        checkConfiguration(getConnectionOption());
        if (deliveryMethod.get() == DeliveryMethod.SERVER_INITIATED) {
            logger.throwSdkException("The SDK has been set up to use a server initiated delivery method. No daemon thread listening to notifications can be started in this mode.");
        }
        if (isForceClear()) {
            logger.logWarn("Clearing any existing notification channel");
            clearAllNotificationChannels();
        }
        // TODO use delivery method check instead when available
        Webhook webhook = null;
        try {
            webhook = getWebhook();
        } catch (@SuppressWarnings("unused") MbedCloudException exception) {
            // Nothing to do
        }
        if (webhook != null) {
            logger.throwSdkException("A webhook is currently set up [" + webhook
                                     + "]. Client-initiated delivery method cannot be used at the same time. Please remove the webhook if you want to use this mechanism instead.");
        }
        handlersStore.startNotificationListener();
    }

    protected void autostartDaemonIfNeeded() throws MbedCloudException {
        setDeliveryMethod(true);
        checkConfiguration(getConnectionOption());
        if (deliveryMethod.get() != DeliveryMethod.CLIENT_INITIATED) {
            logger.logDebug("The SDK will not start automatically notification threads as its delivery method is "
                            + deliveryMethod.get());
            return;
        }
        if (!handlersStore.isNotificationListenerActive() && isAutostartDaemon()) {
            startNotifications();
        }
    }

    /**
     * Stops notification pull for notifications.
     * <p>
     *
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    @API
    @Daemon(task = "Notification listening", stop = true)
    public void stopNotifications() throws MbedCloudException {
        logger.logInfo(getModuleName() + ": stopNotifications()");
        if (deliveryMethod.get() == DeliveryMethod.CLIENT_INITIATED) {
            logger.logInfo("Delivery method was set to [" + deliveryMethod.get()
                           + "]. Stopping daemon notification listening threads.");
            handlersStore.stopNotificationListener();
        }
        if (isSkipCleanup()) {
            logger.logWarn("Notification channel and subscriptions are not cleaned up as skipCleanup mode was requested.");
        } else {
            clearAllNotificationChannels();
        }
    }

    private void deleteLongPollingChannel() throws MbedCloudException {
        CloudCaller.call(this, "clearLongPollingNotificationChannel()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getNotifications().deleteLongPollChannel();
            }
        });
    }

    private void deleteWebsocketChannel() throws MbedCloudException {
        CloudCaller.call(this, "clearWebsocketNotificationChannel()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getNotifications().deleteWebsocket();
            }
        });
    }

    /**
     * Shuts down all daemon services.
     */
    @API
    @Daemon(task = "Notification listening", shutdown = true)
    public void shutdownConnectService() {
        logger.logInfo(getModuleName() + ": shutdownConnectService()");
        handlersStore.shutdown();
        client.close();
    }

    @Override
    @API
    public void close() {
        super.close();
        try {
            stopNotifications();
        } catch (@SuppressWarnings("unused") MbedCloudException exception) {
            // Nothing to do
        }
        shutdownConnectService();
    }

    /**
     * Lists connected devices (One page).
     * <p>
     * 
     * @deprecated Use {@link DeviceListDao} instead
     * @param options
     *            filter options
     * @return the list of connected devices (One page).
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    @Deprecated
    public @Nullable ListResponse<Device> listConnectedDevices(DeviceListOptions options) throws MbedCloudException {
        try (DeviceListDao dao = new DeviceListDao(this)) {
            return dao.onePage(new DeviceListOptions().equalToState(DeviceState.REGISTERED));
        } catch (IOException exception) {
            throw new MbedCloudException(exception);
        }
    }

    /**
     * Gets an iterator over all connected devices according to filter options.
     * <p>
     * 
     * @deprecated Use {@link DeviceListDao} instead
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of devices corresponding to filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    @Deprecated
    public @Nullable Paginator<Device>
           listAllConnectedDevices(@Nullable DeviceListOptions options) throws MbedCloudException {
        try (DeviceListDao dao = new DeviceListDao(this)) {
            return dao.paginator(new DeviceListOptions().equalToState(DeviceState.REGISTERED));
        } catch (IOException exception) {
            throw new MbedCloudException(exception);
        }
    }

    /**
     * Lists device's resources.
     * <p>
     *
     * @param device
     *            Device.
     * @return list of resources present on a device.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable List<Resource> listResources(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        final String finalDeviceId = device.getId();

        return CloudCaller.call(this, "listResources()", ResourceAdapter.getListMapper(finalDeviceId),
                                new CloudCall<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Resource>>() {

                                    @Override
                                    public Call<List<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Resource>>
                                           call() {
                                        return endpoint.getEndpoints().getEndpointResources(finalDeviceId);
                                    }
                                });
    }

    /**
     * Lists device's observable resources.
     *
     * @see Resource#isObservable()
     *      <p>
     *
     * @param device
     *            Device.
     * @return list of observable resources present on a device.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable List<Resource> listObservableResources(@NonNull Device device) throws MbedCloudException {
        final List<Resource> resources = listResources(device);
        if (resources == null || resources.isEmpty()) {
            return null;
        }
        final List<Resource> observableResources = new LinkedList<>();
        for (final Resource resource : resources) {
            if (resource.isObservable()) {
                observableResources.add(resource);
            }
        }
        return observableResources.isEmpty() ? null : observableResources;
    }

    /**
     * Gets device's resource.
     * <p>
     *
     * @param device
     *            Device.
     * @param resourcePath
     *            Path of the resource to get
     * @return resource present on the device.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Resource getResource(@NonNull Device device,
                                          @NonNull String resourcePath) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        final List<Resource> resources = listResources(device);
        if (resources == null || resources.isEmpty()) {
            return null;
        }
        for (final Resource resource : resources) {
            if (ApiUtils.comparePaths(resourcePath, resource.getPath())) {
                return resource;
            }
        }
        return null;
    }

    /**
     * Lists a device's subscriptions.
     * <p>
     *
     * @param device
     *            Device.
     * @return list of subscriptions
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable List<String> listDeviceSubscriptions(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        final String finalDeviceId = device.getId();

        return CloudCaller.call(this, "listDeviceSubscriptions()", PresubscriptionAdapter.getResourcePathListMapper(),
                                new CloudCall<String>() {

                                    @Override
                                    public Call<String> call() {
                                        return endpoint.getSubscriptions().getEndpointSubscriptions(finalDeviceId);
                                    }
                                });
    }

    /**
     * Gets the subscribe manager.
     *
     * @return subscribe manager.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public CloudSubscriptionManager subscribe() throws MbedCloudException {
        autostartDaemonIfNeeded();
        return this.handlersStore.getSubscriptionManager();
    }

    /**
     * Lists metrics.
     * <p>
     *
     * @param options
     *            metrics options.
     * @param <T>
     *            Type of metrics list options
     * @return list of metrics for the corresponding options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable <T extends AbstractMetricsListOptions> ListResponse<Metric>
           listMetrics(@NonNull T options) throws MbedCloudException {
        checkNotNull(options, TAG_METRIC_OPTIONS);
        final T finalOptions = options;
        final Date finalStart = options instanceof MetricsStartEndListOptions ? ((MetricsStartEndListOptions) options).getStart()
                                                                              : null;
        final Date finalEnd = options instanceof MetricsStartEndListOptions ? ((MetricsStartEndListOptions) options).getEnd()
                                                                            : null;
        final String finalPeriod = options instanceof MetricsPeriodListOptions ? ((MetricsPeriodListOptions) options).getPeriod()
                                                                                                                     .toString()
                                                                               : null;

        return CloudCaller.call(this, "listMetrics()", MetricAdapter.getListMapper(),
                                new CloudCall<SuccessfulResponse>() {

                                    @Override
                                    public Call<SuccessfulResponse> call() {
                                        return endpoint.getStatistic()
                                                       .getMetrics(MetricAdapter.mapIncludes(finalOptions.getInclude()),
                                                                   finalOptions.getInterval().toString(),
                                                                   TranslationUtils.toLocalDate(finalStart),
                                                                   TranslationUtils.toLocalDate(finalEnd), finalPeriod,
                                                                   finalOptions.getPageSize(), finalOptions.getAfter(),
                                                                   finalOptions.getOrder().toString());
                                    }
                                });

    }

    /**
     * Gets an iterator over all metrics according to filter options.
     * <p>
     *
     * @param options
     *            filter options.
     * @param <T>
     *            Type of metrics list options
     * @return paginator @see {@link Paginator} for the list of metrics corresponding to filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable <T extends AbstractMetricsListOptions> Paginator<Metric>
           listAllMetrics(@NonNull T options) throws MbedCloudException {
        checkNotNull(options, TAG_METRIC_OPTIONS);
        return new Paginator<>(options, new PageRequester<Metric>() {

            @SuppressWarnings("unchecked")
            @Override
            public ListResponse<Metric> requestNewPage(ListOptions opt) throws MbedCloudException {
                return listMetrics((T) opt);
            }
        });
    }

    /**
     * Creates a observer to obtain resource current value.
     * <p>
     * See {@link Observer}
     * 
     * @param resource
     *            resource of interest.
     * @param strategy
     *            backpressure strategy.
     * @return corresponding observer.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    public @Nullable AsynchronousResponseObserver
           createCurrentResourceValueObserver(@NonNull Resource resource,
                                              @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy) throws MbedCloudException {

        return createResourceActionObserver(createResourceAction("getResourceValueAsync()",
                                                                 ResourceActionAdapter.getGetResourceValueMapper()),
                                            resource, strategy, null, null, true);
    }

    /**
     * Creates a observer to set a resource value.
     * <p>
     * See {@link Observer}
     * 
     * @param resource
     *            resource of interest.
     * @param strategy
     *            backpressure strategy.
     * @param value
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @return corresponding observer.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    public @Nullable AsynchronousResponseObserver
           createSetResourceValueObserver(@NonNull Resource resource,
                                          @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy,
                                          @Nullable Object value,
                                          @NonNull ResourceValueType valueType) throws MbedCloudException {

        return createResourceActionObserver(createResourceAction("setResourceValueAsync()",
                                                                 ResourceActionAdapter.getSetResourceValueMapper()),
                                            resource, strategy, value, valueType, true);
    }

    /**
     * Creates a observer to execute a resource.
     * <p>
     * See {@link Observer}
     * 
     * @param resource
     *            resource of interest.
     * @param strategy
     *            backpressure strategy.
     * @param value
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @return corresponding observer.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    public @Nullable AsynchronousResponseObserver
           createExecuteResourceValueObserver(@NonNull Resource resource,
                                              @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy,
                                              @Nullable Object value,
                                              @NonNull ResourceValueType valueType) throws MbedCloudException {
        return createResourceActionObserver(createResourceAction("executeResourceAsync()",
                                                                 ResourceActionAdapter.getExecuteResourceValueMapper()),
                                            resource, strategy, value, valueType, false);
    }

    @SuppressWarnings("resource")
    protected ResourceAction createResourceAction(String functionName,
                                                  Mapper<ResourceActionParameters, DeviceRequest> requestMapper) {
        final AbstractModule module = this;
        final String function = functionName;
        final Mapper<ResourceActionParameters, DeviceRequest> finalMapper = requestMapper;
        return new ResourceAction() {

            @Override
            public void execute(ResourceActionParameters arg) throws MbedCloudException {
                final ResourceActionParameters finalArgs = arg;
                CloudCaller.call(module, function, null, new CloudCall<Void>() {

                    @Override
                    public Call<Void> call() {
                        return endpoint.getAsync()
                                       .createAsyncRequest(finalArgs.getResource().getDeviceId(),
                                                           finalArgs.getAsyncId(), finalMapper.map(finalArgs),
                                                           finalArgs.getRetries(), finalArgs.getExpirySeconds());
                    }
                });

            }

        };
    }

    protected AsynchronousResponseObserver
              createResourceActionObserver(ResourceAction action, Resource resource, BackpressureStrategy strategy,
                                           Object value, ResourceValueType type,
                                           boolean notifyOtherObservers) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        autostartDaemonIfNeeded();
        final ResourceActionParameters parameters = new ResourceActionParameters(UuidGenerator.generate(), resource,
                                                                                 value, type);
        final BackpressureStrategy finalStrategy = (strategy == null) ? BackpressureStrategy.BUFFER : strategy;
        final AsynchronousResponseObserver observer = handlersStore.createAsyncResponseObserver(parameters.getResource(),
                                                                                                parameters.getAsyncId(),
                                                                                                finalStrategy,
                                                                                                notifyOtherObservers);

        try {
            action.execute(parameters);
        } catch (MbedCloudException exception) {
            observer.unsubscribe();
            throw exception;
        }
        return observer;
    }

    protected Future<Object> convertObserverToFuture(AsynchronousResponseObserver observer) throws MbedCloudException {
        try {
            final Flowable<Object> newFlow = observer.flow()
                                                     .map(new Function<AsynchronousResponseNotification, Object>() {

                                                         @Override
                                                         public Object
                                                                apply(AsynchronousResponseNotification notification) throws Exception {
                                                             if (notification.reportsFailure()) {
                                                                 return notification.toError();
                                                             }
                                                             return notification.getPayload();
                                                         }
                                                     }).take(1);
            return newFlow.toFuture();

        } catch (Exception exception) {
            throw new MbedCloudException(exception);
        }
    }

    /**
     * Gets a resource value for a given device id and resource path.
     * <p>
     * 
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @return A Future from which it is possible to obtain resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object> getResourceValueAsync(@NonNull String deviceId,
                                                          @NonNull String resourcePath) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        return getResourceValueAsync(new Resource(deviceId, resourcePath));
    }

    /**
     * Gets a resource value for a given device id and resource path.
     * <p>
     * 
     * @param resource
     *            The resource to get the value of.
     * @return A Future from which it is possible to obtain resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object> getResourceValueAsync(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        return convertObserverToFuture(createCurrentResourceValueObserver(resource, BackpressureStrategy.BUFFER));

    }

    /**
     * Gets a resource value for a given device id and resource path.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     String deviceId = "015f4ac587f500000000000100100249";
     *     String resourcePath = "/3201/0/5853";
     *     String ledPattern = String.valueOf(connectApi.getResourceValue(deviceId, resourcePath,  new TimePeriod(5)));
     *     System.out.println("LED pattern from device: " + ledPattern);
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param timeout
     *            Timeout for the request.
     * @return resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object getResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
                                             @Nullable TimePeriod timeout) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        return getResourceValue(new Resource(deviceId, resourcePath), timeout);
    }

    /**
     * Gets a resource value for a given device id and resource path.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     *
     * @param resource
     *            The resource path to get the value of.
     * @param timeout
     *            Timeout for the request.
     * @return resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object getResourceValue(@NonNull Resource resource,
                                             @Nullable TimePeriod timeout) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        final Resource finalResource = resource;
        try {
            return SynchronousMethod.waitForCompletion(this, "getResourceValue()", new AsynchronousMethod<Object>() {

                @Override
                public Future<Object> submit() throws MbedCloudException {
                    return getResourceValueAsync(finalResource);
                }
            }, timeout);
        } catch (MbedCloudException exception) {
            logger.throwSdkException(exception);
        }
        return null;
    }

    /**
     * Sets the value of a resource.
     * 
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param resourceValue
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @return A Future from which it is possible to set the value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object>
           setResourceValueAsync(@NonNull String deviceId, @NonNull String resourcePath, @Nullable Object resourceValue,
                                 @NonNull ResourceValueType valueType) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        return setResourceValueAsync(new Resource(deviceId, resourcePath), resourceValue, valueType);
    }

    /**
     * Sets the value of a resource.
     * 
     * @param resource
     *            The resource to set the value of.
     * @param resourceValue
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @return A Future from which it is possible to set the value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object>
           setResourceValueAsync(@NonNull Resource resource, @Nullable Object resourceValue,
                                 @NonNull ResourceValueType valueType) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        checkNotNull(valueType, TAG_VALUE_TYPE);
        return convertObserverToFuture(createSetResourceValueObserver(resource, BackpressureStrategy.BUFFER,
                                                                      resourceValue, valueType));
    }

    /**
     * Sets the value of a resource.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     *
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param resourceValue
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @param timeout
     *            Timeout for the request.
     * @return The value of the new resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object setResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
                                             @Nullable Object resourceValue, @NonNull ResourceValueType valueType,
                                             @Nullable TimePeriod timeout) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        return setResourceValue(new Resource(deviceId, resourcePath), resourceValue, valueType, timeout);
    }

    /**
     * Sets the value of a resource.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     *
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param resourceValue
     *            value to set.
     * @param timeout
     *            Timeout for the request.
     * @return The value of the new resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object setResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
                                             @Nullable String resourceValue,
                                             @Nullable TimePeriod timeout) throws MbedCloudException {

        return setResourceValue(deviceId, resourcePath, resourceValue, ResourceValueType.STRING, timeout);
    }

    /**
     * Sets the value of a resource.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     * 
     * @param resource
     *            The resource to set the value of.
     * @param resourceValue
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @param timeout
     *            Timeout for the request.
     * @return The value of the new resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object setResourceValue(@NonNull Resource resource, @Nullable Object resourceValue,
                                             @NonNull ResourceValueType valueType,
                                             @Nullable TimePeriod timeout) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        final Resource finalResouce = resource;
        final Object value = resourceValue;
        final ResourceValueType type = valueType;
        try {
            return SynchronousMethod.waitForCompletion(this, "setResourceValue()", new AsynchronousMethod<Object>() {

                @Override
                public Future<Object> submit() throws MbedCloudException {
                    return setResourceValueAsync(finalResouce, value, type);
                }
            }, timeout);
        } catch (MbedCloudException exception) {
            logger.throwSdkException(exception);
        }
        return null;
    }

    /**
     * Sets the value of a resource.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     * <p>
     * 
     * @param resource
     *            The resource to set the value of.
     * @param resourceValue
     *            value to set.
     * @param timeout
     *            Timeout for the request.
     * @return The value of the new resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object setResourceValue(@NonNull Resource resource, @Nullable String resourceValue,
                                             @Nullable TimePeriod timeout) throws MbedCloudException {
        return setResourceValue(resource, resourceValue, ResourceValueType.STRING, timeout);
    }

    /**
     * Executes a function on a resource.
     * 
     * @param resource
     *            The resource to execute the function on.
     * @param functionName
     *            The function to trigger.
     * @return A Future from which it is possible to get the value returned from the function executed on the resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object> executeResourceAsync(@NonNull Resource resource,
                                                         @Nullable String functionName) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        return convertObserverToFuture(createExecuteResourceValueObserver(resource, BackpressureStrategy.BUFFER,
                                                                          functionName, ResourceValueType.STRING));
    }

    /**
     * Executes a function on a resource.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     *
     * @param resource
     *            The resource path to execute the function on.
     * @param functionName
     *            The function to trigger.
     * @param timeout
     *            Timeout for the request.
     * @return the value returned from the function executed on the resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object executeResource(@NonNull Resource resource, @Nullable String functionName,
                                            @Nullable TimePeriod timeout) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        final Resource finalResource = resource;
        final String function = functionName;
        try {
            return SynchronousMethod.waitForCompletion(this, "executeResource()", new AsynchronousMethod<Object>() {

                @Override
                public Future<Object> submit() throws MbedCloudException {
                    return executeResourceAsync(finalResource, function);
                }
            }, timeout);
        } catch (MbedCloudException exception) {
            logger.throwSdkException(exception);
        }
        return null;
    }

    protected GenericAdapter.MappedObjectRegistry<Presubscription>
              getCurrentPresubscriptionRegistry(String methodName) throws MbedCloudException {
        return CloudCaller.call(this, methodName, PresubscriptionAdapter.getListToRegistryMapper(),
                                new CloudCall<PresubscriptionArray>() {

                                    @Override
                                    public Call<PresubscriptionArray> call() {
                                        return endpoint.getSubscriptions().getPreSubscriptions();
                                    }
                                });
    }

    /**
     * Lists pre-subscription data.
     * <p>
     *
     * @return the list of pre-subscription data.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable List<Presubscription> listPresubscriptions() throws MbedCloudException {
        final GenericAdapter.MappedObjectRegistry<Presubscription> presubscriptionRegistry = getCurrentPresubscriptionRegistry("listPresubscriptions()");
        return (presubscriptionRegistry == null) ? null : presubscriptionRegistry.getEntries();
    }

    /**
     * Updates all pre-subscription data.
     * <p>
     * 
     * @param presubscriptions
     *            The pre-subscription list to update.
     *            <p>
     *            If you send an empty/null array, the pre-subscription data will be removed @see
     *            {@link #deletePresubscriptions()} for similar action.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void updatePresubscriptions(@Nullable List<Presubscription> presubscriptions) throws MbedCloudException {
        final PresubscriptionArray array = PresubscriptionAdapter.reverseMapList(presubscriptions);
        synchronized (presubscriptionLock) {
            CloudCaller.call(this, "updatePresubscriptions()", null, new CloudCall<Void>() {

                @Override
                public Call<Void> call() {
                    return endpoint.getSubscriptions().updatePreSubscriptions(array);
                }
            });
        }
    }

    /**
     * Adds a pre-subscription.
     * <p>
     * Note: for more information about pre-subscriptions, have a look at @link {@link Presubscription} or
     * <a href="https://cloud.mbed.com/docs/current/connecting/presubscriptions.html">corresponding Pelion Cloud
     * documentation</a>
     *
     * @param presubscription
     *            pre-subscription to add
     * @throws MbedCloudException
     *             if an error happened during the process
     */
    @API
    public void addPresubscription(@Nullable Presubscription presubscription) throws MbedCloudException {
        if (presubscription == null) {
            return;
        }
        checkModelValidity(presubscription, TAG_PRESUBSCRIPTION);
        synchronized (presubscriptionLock) {
            GenericAdapter.MappedObjectRegistry<Presubscription> presubscriptionRegistry = getCurrentPresubscriptionRegistry("addPresubscription()");
            if (presubscriptionRegistry != null && presubscriptionRegistry.contains(presubscription)) {
                return;
            }
            if (presubscriptionRegistry == null) {
                presubscriptionRegistry = new GenericAdapter.MappedObjectRegistry<>();
            }
            presubscriptionRegistry.addNewEnty(presubscription);
            updatePresubscriptions(presubscriptionRegistry.getEntries());
        }
    }

    /**
     * Adds some pre-subscriptions.
     * <p>
     * Note: for more information about pre-subscriptions, have a look at @link {@link Presubscription} or
     * <a href="https://cloud.mbed.com/docs/current/connecting/presubscriptions.html">corresponding Pelion Cloud
     * documentation</a>
     *
     * @param presubscriptions
     *            pre-subscriptions to add
     * @throws MbedCloudException
     *             if an error happened during the process
     */
    @API
    public void addSomePresubscriptions(@Nullable List<Presubscription> presubscriptions) throws MbedCloudException {
        if (presubscriptions == null) {
            return;
        }
        synchronized (presubscriptionLock) {
            GenericAdapter.MappedObjectRegistry<Presubscription> presubscriptionRegistry = getCurrentPresubscriptionRegistry("addSomePresubscriptions()");
            if (presubscriptionRegistry == null) {
                presubscriptionRegistry = new GenericAdapter.MappedObjectRegistry<>();
            }
            boolean requireAddition = false;
            for (final Presubscription presubscription : presubscriptions) {
                checkModelValidity(presubscription, TAG_PRESUBSCRIPTION);
                if (!presubscriptionRegistry.contains(presubscription)) {
                    requireAddition = true;
                    presubscriptionRegistry.addNewEnty(presubscription);
                }
            }
            if (requireAddition) {
                updatePresubscriptions(presubscriptionRegistry.getEntries());
            }
        }
    }

    /**
     * Gets a pre-subscription.
     *
     * @param presubscriptionId
     *            pre-subscription id
     * @return corresponding pre-subscription
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    @API
    public @Nullable Presubscription getPresubscription(@Nullable String presubscriptionId) throws MbedCloudException {
        if (presubscriptionId == null) {
            return null;
        }
        final GenericAdapter.MappedObjectRegistry<Presubscription> presubscriptionRegistry = getCurrentPresubscriptionRegistry("getPresubscription()");
        return presubscriptionRegistry == null
               || presubscriptionRegistry.isEmpty() ? null : presubscriptionRegistry.getEntry(presubscriptionId);
    }

    /**
     * Deletes a pre-subscription.
     *
     * @param presubscriptionId
     *            pre-subscription id of the pre-subscription to delete
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    @API
    public void deletePresubscription(@Nullable String presubscriptionId) throws MbedCloudException {
        if (presubscriptionId == null) {
            return;
        }
        synchronized (presubscriptionLock) {
            final GenericAdapter.MappedObjectRegistry<Presubscription> presubscriptionRegistry = getCurrentPresubscriptionRegistry("deletePresubscription()");
            if (presubscriptionRegistry == null || presubscriptionRegistry.isEmpty()
                || !presubscriptionRegistry.contains(presubscriptionId)) {
                return;
            }
            presubscriptionRegistry.removeEntry(presubscriptionId);
            updatePresubscriptions(presubscriptionRegistry.getEntries());
        }
    }

    /**
     * Deletes a pre-subscription.
     *
     * @param presubscription
     *            pre-subscription to delete
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    @API
    public void deletePresubscription(@Nullable Presubscription presubscription) throws MbedCloudException {
        if (presubscription == null) {
            return;
        }
        deletePresubscription(presubscription.getId());
    }

    /**
     * Deletes some pre-subscriptions.
     *
     * @param presubscriptions
     *            pre-subscriptions to delete
     * @throws MbedCloudException
     *             if a problem occurred during the process.
     */
    @API
    public void deleteSomePresubscriptions(@Nullable List<Presubscription> presubscriptions) throws MbedCloudException {
        if (presubscriptions == null) {
            return;
        }
        synchronized (presubscriptionLock) {
            final GenericAdapter.MappedObjectRegistry<Presubscription> presubscriptionRegistry = getCurrentPresubscriptionRegistry("deleteSomePresubscriptions()");

            if (presubscriptionRegistry == null || presubscriptionRegistry.isEmpty()) {
                return;
            }
            boolean requireDeletion = false;
            for (final Presubscription presubscription : presubscriptions) {
                if (presubscriptionRegistry.contains(presubscription.getId())) {
                    requireDeletion = true;
                }
                presubscriptionRegistry.removeEntry(presubscription.getId());

            }
            if (requireDeletion) {
                updatePresubscriptions(presubscriptionRegistry.getEntries());
            }
        }
    }

    /**
     * Deletes all pre-subscription data.
     * <p>
     * Note: this method will deregister all subscription callbacks or observers if any.
     * <p>
     * Example:
     *
     * <pre>
     * {@code
     * try {
     *     connectApi.deletePresubscriptions();
     * } catch (MbedCloudException e) {
     *     e.printStackTrace();
     * }
     * }
     * </pre>
     *
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deletePresubscriptions() throws MbedCloudException {
        CloudCaller.call(this, "deletePresubscriptions()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().updatePreSubscriptions(PresubscriptionAdapter.reverseMapList(null));
            }
        });
        deregisterAllResourceSubscriptionObserversOrCallbacks();
    }

    /**
     * Removes all subscriptions.
     * <p>
     * Note: this method will deregister all subscription callbacks or observers if any.
     * <p>
     * Warning: Please note that this operation is potentially really expensive and hence, use wisely.
     * <p>
     * It could be slow for large numbers of connected devices. If possible, explicitly delete subscriptions known to
     * have been created.
     *
     * 
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteSubscriptions() throws MbedCloudException {
        // The following is a workaround until there is a Pelion Cloud endpoint providing such an action.
        logger.logWarn("deleteSubscriptions() could be slow for large numbers of connected devices. "
                       + "If possible, explicitly delete subscriptions known to have been created.");
        try (DeviceListDao dao = new DeviceListDao(this)) {
            final Paginator<Device> connectedDevices = dao.list(new DeviceListOptions().equalToState(DeviceState.REGISTERED));
            if (connectedDevices != null) {
                for (final Device connectedDevice : connectedDevices) {
                    deleteDeviceSubscriptions(connectedDevice);
                }
            }
        } catch (IOException exception) {
            throw new MbedCloudException(exception);
        }
        // When such an endpoint is created, use some code similar to below.
        // CloudCaller.call(this, "deleteSubscriptions()", null, new CloudCall<Void>() {
        //
        // @Override
        // public Call<Void> call() {
        // return endpoint.getSubscriptions().v2SubscriptionsDelete();
        // }
        // });
        // deregisterAllResourceSubscriptionObserversOrCallbacks();
    }

    /**
     * Lists all subscriptions.
     * <p>
     * Warning: Please note that this operation is potentially really expensive and hence, use wisely.
     * <p>
     * It could be slow for large numbers of connected devices.
     * <p>
     *
     * @return list of subscriptions
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable List<Subscription> listSubscriptions() throws MbedCloudException {
        logger.logWarn("listSubscriptions() could be slow for large numbers of connected devices.");
        final List<Subscription> subscriptions = new LinkedList<>();
        // The following is a workaround until there is a Pelion Cloud endpoint providing such an action.
        try (DeviceListDao dao = new DeviceListDao(this)) {
            final Paginator<Device> connectedDevices = dao.list(new DeviceListOptions().equalToState(DeviceState.REGISTERED));
            if (connectedDevices != null) {
                for (final Device connectedDevice : connectedDevices) {
                    final List<String> deviceSubscriptions = listDeviceSubscriptions(connectedDevice);
                    if (deviceSubscriptions != null) {
                        subscriptions.add(new Subscription(connectedDevice.getId(), deviceSubscriptions));
                    }
                }
            }
            return subscriptions.isEmpty() ? null : subscriptions;
        } catch (IOException exception) {
            throw new MbedCloudException(exception);
        }
    }

    /**
     * Deletes a device's subscriptions.
     * <p>
     * Note: this method will deregister all subscription callbacks or observers for this device if any.
     * <p>
     *
     * @param device
     *            Device to consider.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteDeviceSubscriptions(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        final String finalDeviceId = device.getId();
        CloudCaller.call(this, "deleteDeviceSubscriptions()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().deleteEndpointSubscriptions(finalDeviceId);
            }
        });
        deregisterAllResourceSubscriptionObserversOrCallbacks(device);
    }

    /**
     * Gets the status of a resource's subscription.
     * <p>
     *
     * @param resource
     *            resource
     * @return true if resource is subscribed. false otherwise.
     * @throws MbedCloudException
     *             if a parameter is incorrect
     *
     *
     */
    @API
    public boolean getResourceSubscription(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        final Resource finalResource = resource;
        try {
            CloudCaller.call(this, "getResourceSubscription()", null, new CloudCall<Void>() {

                @Override
                public Call<Void> call() {
                    return endpoint.getSubscriptions()
                                   .checkResourceSubscription(finalResource.getDeviceId(),
                                                              ApiUtils.normalisePath(finalResource.getPath()));
                }
            }, true);
            return true;
        } catch (@SuppressWarnings("unused") MbedCloudException exception) {
            return false;
        }
    }

    /**
     * Allows notifications (received from a Webhook) to be injected into the notifications system.
     *
     * @param data
     *            The notification data to inject
     */
    @API
    public void notify(@Nullable NotificationMessage data) {
        handlersStore.notify(data);
    }

    /**
     * Allows notifications expressed as a JSON string to be injected into the notifications system.
     * <p>
     *
     * @param dataAsJson
     *            The notification data to inject as JSON String.
     */
    @API
    public void notify(@Nullable String dataAsJson) {
        notify(null, dataAsJson);
    }

    /**
     * Allows a notification to be injected into the notifications system.
     * <p>
     *
     * @param deserialiser
     *            JSON deserialiser to use.
     * @param dataAsJson
     *            The notification data to inject as JSON String.
     */
    @API
    public void notify(@Nullable JsonSerialiser deserialiser, @Nullable String dataAsJson) {
        final JsonSerialiser jsonEngine = (deserialiser == null) ? new JsonSerialiser() : deserialiser;
        notify(jsonEngine.fromJson(dataAsJson, NotificationMessage.class));
    }

    /**
     * Subscribes to a list of resources.
     * <p>
     * Note: in case a subscription fails, it will continue subscribing to the rest of the resources present in the
     * list.
     *
     * @param resources
     *            resources to subscribe to.
     */
    @API
    public void addResourcesSubscription(@Nullable List<Resource> resources) {
        if (resources == null) {
            return;
        }
        for (final Resource resource : resources) {
            try {
                addResourceSubscription(resource);
            } catch (MbedCloudException exception) {
                logger.logError("Could not subscribe to resource: " + resource, exception);
            }
        }
    }

    /**
     * Subscribes to a resource.
     * <p>
     *
     * @param resource
     *            resource to subscribe to.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void addResourceSubscription(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        final Resource finalResource = resource;
        CloudCaller.call(this, "addResourceSubscription()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions()
                               .addResourceSubscription(finalResource.getDeviceId(),
                                                        ApiUtils.normalisePath(finalResource.getPath()));
            }
        });
    }

    /**
     * Subscribes to a resource and associates callbacks.
     * <p>
     *
     * @param resource
     *            resource to subscribe to.
     * @param onNotification
     *            callback to execute on notification.
     * @param onFailure
     *            callback to execute on error.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void addResourceSubscription(@NonNull Resource resource, @NonNull Callback<Object> onNotification,
                                        @Nullable Callback<Throwable> onFailure) throws MbedCloudException {
        registerResourceSubscriptionCallback(resource, onNotification, onFailure);
        addResourceSubscription(resource);
    }

    /**
     * Subscribes to a resource and creates a related observer.
     * <p>
     * Note: for more information about observers @see <a href="http://reactivex.io/">Reactive X</a> or
     * <a href="https://github.com/ReactiveX/RxJava">RxJava</a> *
     *
     * @param resource
     *            resource to subscribe to.
     * @param strategy
     *            backpressure strategy to apply @see {@link BackpressureStrategy}
     * @return Observable which can be subscribed to. @see {@link Flowable}
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Flowable<NotificationMessageValue>
           addResourceSubscription(@NonNull Resource resource,
                                   @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy) throws MbedCloudException {
        try {
            final Flowable<NotificationMessageValue> observer = createResourceSubscriptionObserver(resource, strategy);
            addResourceSubscription(resource);
            return observer;
        } catch (MbedCloudException exception) {
            handlersStore.removeResourceSubscriptionObserver(resource);
            throw exception;
        }

    }

    /**
     * Registers a subscription callback for a resource.
     * <p>
     *
     * @param resource
     *            resource to register the callback for.
     * @param onNotification
     *            callback to execute on notification.
     * @param onFailure
     *            callback to execute on error.
     * @throws MbedCloudException
     *             if an error occurred in the process.
     */
    @API
    public void
           registerResourceSubscriptionCallback(@NonNull Resource resource, @NonNull Callback<Object> onNotification,
                                                @Nullable Callback<Throwable> onFailure) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        checkNotNull(onNotification, TAG_ON_NOTIFICATION_CALLBACK);
        handlersStore.registerSubscriptionCallback(resource, onNotification, onFailure);
    }

    /**
     * Deregisters the subscription callback of a resource.
     * <p>
     *
     * @param resource
     *            resource to consider.
     * @throws MbedCloudException
     *             if an error occurred in the process.
     */
    @API
    public void deregisterResourceSubscriptionCallback(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        handlersStore.deregisterNotificationSubscriptionCallback(resource);
    }

    /**
     * Creates an observer for resource subscriptions.
     * <p>
     * Note: for more information about observers @see <a href="http://reactivex.io/">Reactive X</a> or
     * <a href="https://github.com/ReactiveX/RxJava">RxJava</a> *
     *
     * @param resource
     *            resource to subscribe to.
     * @param strategy
     *            backpressure strategy to apply @see {@link BackpressureStrategy}
     * @return Observable which can be subscribed to. @see {@link Flowable}
     * @throws MbedCloudException
     *             if an error occurred in the process.
     */
    @API
    public @Nullable Flowable<NotificationMessageValue>
           createResourceSubscriptionObserver(@NonNull Resource resource,
                                              @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        final BackpressureStrategy finalStrategy = (strategy == null) ? BackpressureStrategy.BUFFER : strategy;
        return handlersStore.createResourceSubscriptionObserver(resource, finalStrategy);
    }

    /**
     * Removes the subscription observer of a resource.
     * <p>
     *
     * @param resource
     *            resource to consider.
     * @throws MbedCloudException
     *             if an error occurred in the process.
     */
    @API
    public void removeResourceSubscriptionObserver(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        handlersStore.removeResourceSubscriptionObserver(resource);
    }

    /**
     * Deregisters all subscription observers or callbacks for a device.
     * <p>
     *
     * 
     * @param device
     *            device to consider.
     * @throws MbedCloudException
     *             if an error occurred in the process.
     */
    @API
    public void
           deregisterAllResourceSubscriptionObserversOrCallbacks(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        handlersStore.deregisterAllResourceSubscriptionObserversOrCallbacks(device.getId());
    }

    /**
     * Deregisters all subscription observers or callbacks.
     */
    @API
    public void deregisterAllResourceSubscriptionObserversOrCallbacks() {
        handlersStore.deregisterAllResourceSubscriptionObserversOrCallbacks();
    }

    /**
     * Deletes a resource's subscription.
     * <p>
     * Note: this method will deregister all subscription callbacks or observers for this resource if any.
     * <p>
     *
     * @param resource
     *            resource to subscribe to.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteResourceSubscription(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkModelValidity(resource, TAG_RESOURCE);
        final Resource finalResource = resource;
        CloudCaller.call(this, "deleteResourceSubscription()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions()
                               .deleteResourceSubscription(finalResource.getDeviceId(),
                                                           ApiUtils.normalisePath(finalResource.getPath()));
            }
        });
        deregisterResourceSubscriptionCallback(finalResource);
        removeResourceSubscriptionObserver(finalResource);
    }

    /**
     * Gets the current callback URL if it exists.
     *
     * @return the webhook.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public Webhook getWebhook() throws MbedCloudException {
        return CloudCaller.call(this, "getWebhook()", WebhookAdapter.getMapper(),
                                new CloudCall<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.Webhook>
                                           call() {
                                        return endpoint.getNotifications().getWebhook();
                                    }
                                });
    }

    /**
     * Registers new webhook for incoming subscriptions.
     * 
     * @param webhook
     *            Webhook to set.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void updateWebhook(@NonNull Webhook webhook) throws MbedCloudException {
        setDeliveryMethod(false);
        checkConfiguration(getConnectionOption());
        if (deliveryMethod.get() == DeliveryMethod.CLIENT_INITIATED) {
            logger.throwSdkException("This SDK instance has been set up to use the client-initiated notification mode. The server-initiated notification mode that this method requires cannot be used at the same time.");
        }
        checkNotNull(webhook, TAG_WEBHOOK);
        checkModelValidity(webhook, TAG_WEBHOOK);
        synchronized (webhookLock) {
            try {
                final Webhook alreadySetupWebhook = getWebhook();
                if (webhook.equals(alreadySetupWebhook)) {
                    logger.logInfo("The webhook is alread set up: " + alreadySetupWebhook);
                    return;
                }
            } catch (@SuppressWarnings("unused") MbedCloudException exception) {
                // Nothing to do
            }
            if (isForceClear()) {
                logger.logWarn("Clearing any existing notification channel");
                clearAllNotificationChannels();
            }
            final Webhook finalWebhook = webhook;
            CloudCaller.call(this, "updateWebhook()", null, new CloudCall<Void>() {

                @Override
                public Call<Void> call() {
                    return endpoint.getNotifications().registerWebhook(WebhookAdapter.reverseMap(finalWebhook));
                }
            });
        }
    }

    /**
     * Deletes the callback data (effectively stopping Arm Pelion Cloud Connect from putting notifications).
     * <p>
     * If no webhook is registered, an exception (404) will be raised.
     * <p>
     * Note that every registered subscription will be deleted as part of deregistering a webhook.
     * 
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteWebhook() throws MbedCloudException {
        CloudCaller.call(this, "deleteWebhook()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getNotifications().deregisterWebhook();
            }
        });
    }

    /**
     * Deletes any notification channel currently in use.
     * 
     */
    @API
    public void clearAllNotificationChannels() {
        try {
            deleteWebhook();
        } catch (MbedCloudException exception) {
            logger.logWarn("Clearing webhook", exception);
        }
        try {
            deleteLongPollingChannel();
        } catch (MbedCloudException exception) {
            logger.logWarn("Clearing long polling channel", exception);
        }
        try {
            deleteWebsocketChannel();
        } catch (MbedCloudException exception) {
            logger.logWarn("Clearing websocket channel", exception);
        }
    }

    /**
     * States whether any existing notification channel should be cleared before a new one is created.
     * <p>
     * Note: for more information, see {@link ConnectionOptions#isForceClear()}
     * 
     * @return True if the channel will be cleared. False otherwise.
     */
    public boolean isForceClear() {
        final ConnectionOptions config = getConnectionOption();
        return config == null ? false : config.isForceClear();
    }

    /**
     * States whether any existing notification channel and subscriptions will not be cleared on SDK exit.
     * <p>
     * Note: for more information, see {@link ConnectionOptions#isSkipCleanup()}
     * 
     * @return True if the clean-up will be skipped. False otherwise.
     */
    public boolean isSkipCleanup() {
        final ConnectionOptions config = getConnectionOption();
        return config == null ? false : config.isSkipCleanup();
    }

    /**
     * States whether notification daemon will start automatically when needed.
     * <p>
     * Note: to change this behaviour, use {@link ConnectionOptions#setAutostartDaemon(boolean)} when initialising this
     * API.
     *
     * @return true if daemon will be started automatically. False otherwise.
     */
    public boolean isAutostartDaemon() {
        final ConnectionOptions config = getConnectionOption();
        return config == null ? true : config.isAutostartDaemon();
    }

    /**
     * Retrieves module name.
     *
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Connect";
    }

    private void checkConfiguration(ConnectionOptions options) throws MbedCloudException {
        if (options == null) {
            return;
        }
        if (options.isAutostartDaemon() && deliveryMethod.get() == DeliveryMethod.SERVER_INITIATED) {
            logger.throwSdkException("The delivery method has been set to " + deliveryMethod.get()
                                     + ", which is not compatible with the autostartDaemon mode. This mode is only available for "
                                     + DeliveryMethod.CLIENT_INITIATED + " delivery method.");
        }
    }

    private Connect setDeliveryMethod(DeliveryMethod deliveryMethod2) {
        deliveryMethod.getAndSet(deliveryMethod2);
        return this;
    }

    /**
     * Sets the delivery method of notifications.
     * 
     * @param isClient
     *            if True, a client-initiated connection is established. Otherwise, a server-initiated connection is
     *            expected.
     */
    public void setDeliveryMethod(boolean isClient) {
        if (deliveryMethod.get() == DeliveryMethod.UNDEFINED) {
            deliveryMethod.compareAndSet(DeliveryMethod.UNDEFINED,
                                         isClient ? DeliveryMethod.CLIENT_INITIATED : DeliveryMethod.SERVER_INITIATED);
            logger.logInfo("Setting notification delivery method to [" + deliveryMethod.get() + "]");
        }
    }

    /**
     * Gets the notification manager.
     *
     * @return subscribe manager.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public CloudNotificationManager notifications() throws MbedCloudException {
        return new NotificationManager(this);
    }

    /**
     * Get the Device Echo object.
     * <p>
     *
     * @param device
     *            Device.
     * @return the Device Echo object.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable EchoDevice getDeviceEcho(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        final String finalDeviceId = device.getId();

        return CloudCaller.call(this, "getDeviceEcho()", EchoAdapter.getMapper(finalDeviceId),
                                new CloudCall<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice>() {

                                    @Override
                                    public Call<com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.EchoDevice>
                                           call() {
                                        return endpoint.getDeviceEcho().getDeviceEchoObject(finalDeviceId);
                                    }
                                });
    }

    /**
     * Delete the Device Echo object.
     * <p>
     *
     * @param device
     *            Device.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable void deleteDeviceEcho(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        final String finalDeviceId = device.getId();

        CloudCaller.call(this, "deleteDeviceEcho()", null, new CloudCall<Void>() {
            @Override
            public Call<Void> call() {
                return endpoint.getDeviceEcho().deleteDeviceEchoObject(finalDeviceId);
            }
        });
    }

    /**
     * 
     * Implementation of the notification manager.
     *
     */
    private static class NotificationManager implements CloudNotificationManager {
        private final Connect api;
        private final WebhookDao webhookDao;

        /**
         * Constructor.
         * 
         * @param api
         *            connect API.
         * @throws MbedCloudException
         *             if a problem occurred during request processing.
         */
        public NotificationManager(Connect api) throws MbedCloudException {
            super();
            this.api = api;
            webhookDao = new WebhookDao(api);
        }

        @Override
        public void notify(NotificationMessage data) {
            api.notify(data);
        }

        @Override
        public void notify(String dataAsJson) {
            api.notify(dataAsJson);

        }

        @Override
        public void start() throws MbedCloudException {
            api.startNotifications();
        }

        @Override
        public void stop() throws MbedCloudException {
            api.stopNotifications();

        }

        @Override
        public WebhookDao webhook() {
            return webhookDao;
        }

    }

    /**
     * Gets a resource entity.
     * 
     * @param resource
     *            resource of interest.
     * @return the corresponding resource entity.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    public ResourceDao resource(Resource resource) throws MbedCloudException {
        final ResourceDao dao = new ResourceDao(this);
        dao.setModel(resource);
        return dao;
    }
}
