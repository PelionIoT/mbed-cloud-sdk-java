package com.arm.mbed.cloud.sdk;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Daemon;
import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod.AsynchronousMethod;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.connect.adapters.MetricAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.PresubscriptionAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.ResourceAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.WebhookAdapter;
import com.arm.mbed.cloud.sdk.connect.model.AbstractMetricsListOptions;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;
import com.arm.mbed.cloud.sdk.connect.notificationhandling.NotificationCache;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.PresubscriptionArray;
import com.arm.mbed.cloud.sdk.internal.statistics.model.SuccessfulResponse;

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
public class Connect extends AbstractApi {
    private static final Filter CONNECTED_DEVICES_FILTER = new Filter("state", FilterOperator.EQUAL, "registered");
    private static final String TAG_RESOURCE = "resource";
    private static final String FALSE = "false";
    private static final String TAG_RESOURCE_PATH = "resource path";
    private static final String TAG_METRIC_OPTIONS = "Metric options";
    private static final String TAG_DEVICE_ID = "Device Id";
    private static final String TAG_DEVICE = "Device";
    private final EndPoints endpoint;
    private final DeviceDirectory deviceDirectory;
    private final ExecutorService threadPool;
    private final NotificationCache cache;

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
     * @param notificationPullingThreadPool
     *            Threads in charge of listening to notifications. The pool can either be a scheduled thread pool or a
     *            fixed thread pool depending on what best suits your system. If null, an internal timer will be created
     *            internally.
     */
    public Connect(@NonNull ConnectionOptions options, @Nullable ExecutorService notificationHandlingThreadPool,
            @Nullable ExecutorService notificationPullingThreadPool) {
        super(options);
        endpoint = new EndPoints(options);
        deviceDirectory = new DeviceDirectory(options);
        this.threadPool = (notificationHandlingThreadPool == null) ? Executors.newFixedThreadPool(4)
                : notificationHandlingThreadPool;
        this.cache = new NotificationCache(this, (notificationPullingThreadPool == null)
                ? Executors.newScheduledThreadPool(1) : notificationPullingThreadPool, endpoint);

    }

    /**
     * Starts notification pull for notifications.
     * <p>
     * If not an external callback is set up (using `update_webhook`) then calling this function is mandatory to get or
     * set resources.
     */
    @API
    @Daemon(task = "Notification pull", start = true)
    public void startNotifications() {
        cache.startNotificationPull();
    }

    /**
     * Stops notification pull for notifications.
     */
    @API
    @Daemon(task = "Notification pull", stop = true)
    public void stopNotifications() {
        cache.stopNotificationPull();
    }

    /**
     * Shuts down all daemon services.
     */
    @API
    @Daemon(task = "Notification pull", shutdown = true)
    public void shutdownConnectService() {
        cache.shutdown();
        threadPool.shutdown();
    }

    /**
     * Lists connected devices.
     * 
     * @param options
     *            filter options
     * @return the list of connected devices.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable ListResponse<Device> listConnectedDevices(DeviceListOptions options) throws MbedCloudException {
        return deviceDirectory.listConnectedDevices("listConnectedDevices()", options, CONNECTED_DEVICES_FILTER);
    }

    /**
     * Gets an iterator over all connected devices according to filter options.
     * 
     * @param options
     *            filter options.
     * @return paginator @see {@link Paginator} for the list of devices corresponding to filter options.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Paginator<Device> listAllDevices(@Nullable DeviceListOptions options) throws MbedCloudException {
        final DeviceListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<Device>() {

            @Override
            public ListResponse<Device> requestNewPage() throws MbedCloudException {
                return listConnectedDevices(finalOptions);
            }
        });
    }

    /**
     * Lists device's resources.
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
                new CloudCall<List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource>>() {

                    @Override
                    public Call<List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource>> call() {
                        return endpoint.getEndpoints().v2EndpointsDeviceIdGet(finalDeviceId);
                    }
                });
    }

    /**
     * Gets device's resource.
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
    public @Nullable Resource getResource(@NonNull Device device, @NonNull String resourcePath)
            throws MbedCloudException {
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
                        return endpoint.getSubscriptions().v2SubscriptionsDeviceIdGet(finalDeviceId);
                    }
                });
    }

    /**
     * Lists metrics.
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
    public @Nullable <T extends AbstractMetricsListOptions> List<Metric> listMetrics(@NonNull T options)
            throws MbedCloudException {
        checkNotNull(options, TAG_METRIC_OPTIONS);
        final T finalOptions = options;
        final Date finalStart = options instanceof MetricsStartEndListOptions
                ? ((MetricsStartEndListOptions) options).getStart() : null;
        final Date finalEnd = options instanceof MetricsStartEndListOptions
                ? ((MetricsStartEndListOptions) options).getEnd() : null;
        final String finalPeriod = options instanceof MetricsPeriodListOptions
                ? ((MetricsPeriodListOptions) options).getPeriod().toString() : null;

        return CloudCaller.call(this, "listMetrics()", MetricAdapter.getListMapper(),
                new CloudCall<SuccessfulResponse>() {

                    @Override
                    public Call<SuccessfulResponse> call() {
                        return endpoint.getStatistic().v3MetricsGet(
                                MetricAdapter.mapIncludes(finalOptions.getInclude()),
                                finalOptions.getInterval().toString(), TranslationUtils.toLocalDate(finalStart),
                                TranslationUtils.toLocalDate(finalEnd), finalPeriod, finalOptions.getLimit(),
                                finalOptions.getAfter(), finalOptions.getOrder().toString());
                    }
                });

    }

    /**
     * Gets a resource value for a given device id and resource path.
     * 
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param cacheOnly
     *            If true, the response will come only from the cache.
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response.
     * @return A Future from which it is possible to obtain resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object> getResourceValueAsync(@NonNull String deviceId, @NonNull String resourcePath,
            @DefaultValue(value = FALSE) boolean cacheOnly, @DefaultValue(value = FALSE) boolean noResponse)
            throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        final String finalDeviceId = deviceId;
        final String finalResourcePath = resourcePath;
        final boolean finalCacheOnly = cacheOnly;
        final boolean finalNoResponse = noResponse;
        return cache.fetchAsyncResponse(threadPool, "getResourceValueAsync()", new CloudCall<AsyncID>() {

            @SuppressWarnings("boxing")
            @Override
            public Call<AsyncID> call() {
                return endpoint.getResources().v2EndpointsDeviceIdResourcePathGet(finalDeviceId,
                        ApiUtils.normalisePath(finalResourcePath), finalCacheOnly, finalNoResponse);
            }
        });

    }

    /**
     * Gets a resource value for a given device id and resource path.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     * 
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param cacheOnly
     *            If true, the response will come only from the cache.
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response.
     * @param timeout
     *            Timeout for the request.
     * @return resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object getResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
            @DefaultValue(value = FALSE) boolean cacheOnly, @DefaultValue(value = FALSE) boolean noResponse,
            @Nullable TimePeriod timeout) throws MbedCloudException {
        final String id = deviceId;
        final String path = resourcePath;
        final boolean fromCache = cacheOnly;
        final boolean waitForResponse = noResponse;
        try {
            return SynchronousMethod.waitForCompletion(new AsynchronousMethod<Object>() {

                @Override
                public Future<Object> submit() throws MbedCloudException {
                    return getResourceValueAsync(id, path, fromCache, waitForResponse);
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
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response.
     * @return A Future from which it is possible to set the value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object> setResourceValueAsync(@NonNull String deviceId, @NonNull String resourcePath,
            @Nullable String resourceValue, @DefaultValue(value = FALSE) boolean noResponse) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        final String finalDeviceId = deviceId;
        final String finalResourcePath = resourcePath;
        final String finalResourceValue = (resourceValue == null) ? null : resourceValue;
        final boolean finalNoResponse = noResponse;
        return cache.fetchAsyncResponse(threadPool, "setResourceValueAsync()", new CloudCall<AsyncID>() {

            @SuppressWarnings("boxing")
            @Override
            public Call<AsyncID> call() {
                return endpoint.getResources().v2EndpointsDeviceIdResourcePathPut(finalDeviceId,
                        ApiUtils.normalisePath(finalResourcePath), finalResourceValue, finalNoResponse);
            }
        });
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
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response.
     * @param timeout
     *            Timeout for the request.
     * @return The value of the new resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object setResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
            @Nullable String resourceValue, @DefaultValue(value = FALSE) boolean noResponse,
            @Nullable TimePeriod timeout) throws MbedCloudException {
        final String id = deviceId;
        final String path = resourcePath;
        final String value = resourceValue;
        final boolean waitForResponse = noResponse;
        try {
            return SynchronousMethod.waitForCompletion(new AsynchronousMethod<Object>() {

                @Override
                public Future<Object> submit() throws MbedCloudException {
                    return setResourceValueAsync(id, path, value, waitForResponse);
                }
            }, timeout);
        } catch (MbedCloudException exception) {
            logger.throwSdkException(exception);
        }
        return null;
    }

    /**
     * Executes a function on a resource.
     * 
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param functionName
     *            The function to trigger.
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response.
     * @return A Future from which it is possible to get the value returned from the function executed on the resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Future<Object> executeResourceAsync(@NonNull String deviceId, @NonNull String resourcePath,
            @Nullable String functionName, @DefaultValue(value = FALSE) boolean noResponse) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        final String finalDeviceId = deviceId;
        final String finalResourcePath = resourcePath;
        final String finalFunctionName = functionName;
        final boolean finalNoResponse = noResponse;
        return cache.fetchAsyncResponse(threadPool, "executeResourceAsync()", new CloudCall<AsyncID>() {

            @SuppressWarnings("boxing")
            @Override
            public Call<AsyncID> call() {
                return endpoint.getResources().v2EndpointsDeviceIdResourcePathPost(finalDeviceId, finalResourcePath,
                        finalFunctionName, finalNoResponse);
            }
        });
    }

    /**
     * Executes a function on a resource.
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     * 
     * @param deviceId
     *            The name/id of the device.
     * @param resourcePath
     *            The resource path to get.
     * @param functionName
     *            The function to trigger.
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response.
     * @param timeout
     *            Timeout for the request.
     * @return the value returned from the function executed on the resource.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable Object executeResource(@NonNull String deviceId, @NonNull String resourcePath,
            @NonNull String functionName, @DefaultValue(value = FALSE) boolean noResponse, @Nullable TimePeriod timeout)
            throws MbedCloudException {
        final String id = deviceId;
        final String path = resourcePath;
        final String function = functionName;
        final boolean waitForResponse = noResponse;
        try {
            return SynchronousMethod.waitForCompletion(new AsynchronousMethod<Object>() {

                @Override
                public Future<Object> submit() throws MbedCloudException {
                    return executeResourceAsync(id, path, function, waitForResponse);
                }
            }, timeout);
        } catch (MbedCloudException exception) {
            logger.throwSdkException(exception);
        }
        return null;
    }

    /**
     * Deletes a resource.
     * 
     * @param resource
     *            The resource to delete.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteResource(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource, TAG_RESOURCE);
        checkNotNull(resource.getDeviceId(), TAG_DEVICE_ID);
        checkNotNull(resource.getPath(), TAG_RESOURCE_PATH);

        final Resource finalResource = resource;
        CloudCaller.call(this, "deleteResource()", null, new CloudCall<AsyncID>() {

            @Override
            public Call<AsyncID> call() {
                return endpoint.getResources().v2EndpointsDeviceIdResourcePathDelete(finalResource.getDeviceId(),
                        finalResource.getPath(), null);
            }
        });

    }

    /**
     * Lists pre-subscription data.
     * 
     * @return the list of pre-subscription data.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public @Nullable List<Presubscription> listPresubscriptions() throws MbedCloudException {
        return CloudCaller.call(this, "listPresubscriptions()", PresubscriptionAdapter.getListMapper(),
                new CloudCall<PresubscriptionArray>() {

                    @Override
                    public Call<PresubscriptionArray> call() {
                        return endpoint.getSubscriptions().v2SubscriptionsGet();
                    }
                });
    }

    /**
     * Updates pre-subscription data.
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
        final List<Presubscription> finalList = presubscriptions;
        final PresubscriptionArray array = PresubscriptionAdapter.reverseMapList(finalList);
        CloudCaller.call(this, "updatePresubscriptions()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().v2SubscriptionsPut(array);
            }
        });
    }

    /**
     * Deletes pre-subscription data.
     * 
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deletePresubscriptions() throws MbedCloudException {
        CloudCaller.call(this, "deletePresubscriptions()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().v2SubscriptionsPut(PresubscriptionAdapter.reverseMapList(null));
            }
        });
    }

    /**
     * Removes all subscriptions.
     * 
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteSubscriptions() throws MbedCloudException {
        CloudCaller.call(this, "deleteSubscriptions()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().v2SubscriptionsDelete();
            }
        });
    }

    /**
     * Deletes a device's subscriptions.
     * 
     * @param deviceId
     *            Device ID.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteDeviceSubscriptions(@NonNull String deviceId) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        final String finalDeviceId = deviceId;
        CloudCaller.call(this, "deletePresubscriptions()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().v2SubscriptionsDeviceIdDelete(finalDeviceId);
            }
        });
    }

    /**
     * Gets the status of a resource's subscription.
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
        checkNotNull(resource.getDeviceId(), TAG_DEVICE_ID);
        checkNotNull(resource.getPath(), TAG_RESOURCE_PATH);
        final Resource finalResource = resource;
        try {
            CloudCaller.call(this, "getResourceSubscription()", null, new CloudCall<Void>() {

                @Override
                public Call<Void> call() {
                    return endpoint.getSubscriptions().v2SubscriptionsDeviceIdResourcePathGet(
                            finalResource.getDeviceId(), ApiUtils.normalisePath(finalResource.getPath()));
                }
            });
            return true;
        } catch (MbedCloudException exception) {
            return false;
        }
    }

    /**
     * Subscribes to a resource.
     *
     * @param resource
     *            resource to subscribe to.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void addResourceSubscription(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource.getDeviceId(), TAG_DEVICE_ID);
        checkNotNull(resource.getPath(), TAG_RESOURCE_PATH);
        final Resource finalResource = resource;
        CloudCaller.call(this, "addResourceSubscription()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().v2SubscriptionsDeviceIdResourcePathPut(finalResource.getDeviceId(),
                        ApiUtils.normalisePath(finalResource.getPath()));
            }
        });
    }

    /**
     * Deletes a resource's subscription.
     *
     * @param resource
     *            resource to subscribe to.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @API
    public void deleteResourceSubscription(@NonNull Resource resource) throws MbedCloudException {
        checkNotNull(resource.getDeviceId(), TAG_DEVICE_ID);
        checkNotNull(resource.getPath(), TAG_RESOURCE_PATH);
        final Resource finalResource = resource;
        CloudCaller.call(this, "deleteResourceSubscription()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getSubscriptions().v2SubscriptionsDeviceIdResourcePathDelete(
                        finalResource.getDeviceId(), ApiUtils.normalisePath(finalResource.getPath()));
            }
        });
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
                new CloudCall<com.arm.mbed.cloud.sdk.internal.mds.model.Webhook>() {

                    @Override
                    public Call<com.arm.mbed.cloud.sdk.internal.mds.model.Webhook> call() {
                        return endpoint.getWebhooks().v2NotificationCallbackGet();
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
    public void updateWebhook(Webhook webhook) throws MbedCloudException {
        final Webhook finalWebhook = webhook;
        CloudCaller.call(this, "updateWebhook()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getNotifications().v2NotificationCallbackPut(WebhookAdapter.reverseMap(finalWebhook));
            }
        });
    }

    /**
     * Deletes the callback data (effectively stopping Arm Mbed Cloud Connect from putting notifications).
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
                return endpoint.getWebhooks().v2NotificationCallbackDelete();
            }
        });
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
}
