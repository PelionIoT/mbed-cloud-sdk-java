package com.arm.mbed.cloud.sdk;

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
import com.arm.mbed.cloud.sdk.common.AbstractAPI;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod.AsynchronousMethod;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.connect.adapters.ConnectedDeviceAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.MetricAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.ResourceAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.WebhookAdapter;
import com.arm.mbed.cloud.sdk.connect.model.ConnectedDevice;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.connect.model.MetricsListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.connect.model.Webhook;
import com.arm.mbed.cloud.sdk.connect.notificationhandling.NotificationCache;
import com.arm.mbed.cloud.sdk.internal.mds.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.mds.model.Endpoint;
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
public class Connect extends AbstractAPI {
    private static final String TAG_FUNCTION_NAME = "function name";
    private static final String TAG_RESOURCE_PATH = "resource path";
    private static final String TAG_METRIC_OPTIONS = "Metric options";
    private static final String TAG_DEVICE_ID = "Device Id";
    private final EndPoints endpoint;
    private final ExecutorService threadPool;
    private final NotificationCache cache;

    /**
     * 
     * @param options
     *            connection options
     */
    public Connect(ConnectionOptions options) {
        this(options, null, null);
    }

    /**
     * TODO
     * 
     * @param options
     *            connection options
     * @param notificationHandlingThreadPool
     * @param notificationPullingThreadPool
     */
    public Connect(ConnectionOptions options, ExecutorService notificationHandlingThreadPool,
            ExecutorService notificationPullingThreadPool) {
        super(options);
        endpoint = new EndPoints(options);
        this.threadPool = (notificationHandlingThreadPool != null) ? notificationHandlingThreadPool
                : Executors.newFixedThreadPool(4);
        this.cache = new NotificationCache(this, (notificationPullingThreadPool != null) ? notificationPullingThreadPool
                : Executors.newScheduledThreadPool(1), endpoint);
    }

    /**
     * Starts notification pull for notifications
     * <p>
     * If not an external callback is set up (using `update_webhook`) then calling this function is mandatory to get or
     * set resource.
     */
    @API
    @Daemon(task = "Notification pull", start = true)
    public void startNotifications() {
        cache.startNotificationPull();
    }

    /**
     * Stops notification pull for notifications
     */
    @API
    @Daemon(task = "Notification pull", stop = true)
    public void stopNotifications() {
        cache.stopNotificationPull();
    }

    /**
     * Shuts down all daemon services
     */
    @API
    @Daemon(task = "Notification pull", shutdown = true)
    public void shutdownConnectService() {
        cache.shutdown();
        threadPool.shutdown();
    }

    /**
     * List connected devices
     * 
     * @param type
     *            Filter devices by device type
     * @return the list of connected devices
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable List<ConnectedDevice> listConnectedDevices(@Nullable String type) throws MbedCloudException {
        final String finalType = type;
        return CloudCaller.call(this, "listConnectedDevices()", ConnectedDeviceAdapter.getListMapper(),
                new CloudCall<List<Endpoint>>() {

                    @Override
                    public Call<List<Endpoint>> call() {
                        return endpoint.getEndpoints().v2EndpointsGet(finalType);
                    }
                });
    }

    /**
     * List device's resources
     * 
     * @param deviceId
     *            Device ID
     * @return list of resources present on a device
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public List<Resource> listResources(String deviceId) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        final String finalDeviceId = deviceId;

        return CloudCaller.call(this, "listResources()", ResourceAdapter.getListMapper(finalDeviceId),
                new CloudCall<List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource>>() {

                    @Override
                    public Call<List<com.arm.mbed.cloud.sdk.internal.mds.model.Resource>> call() {
                        return endpoint.getEndpoints().v2EndpointsDeviceIdGet(finalDeviceId);
                    }
                });
    }

    /**
     * List metrics
     * 
     * @param options
     *            metrics options
     * @param <T>
     *            Type of metrics list options
     * @return list of metrics for the corresponding options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable <T extends MetricsListOptions> List<Metric> listMetrics(@NonNull T options)
            throws MbedCloudException {
        checkNotNull(options, TAG_METRIC_OPTIONS);
        final T finalOptions = options;
        final String finalStart = (options instanceof MetricsStartEndListOptions)
                ? ((MetricsStartEndListOptions) options).getStart().toString() : null;
        final String finalEnd = (options instanceof MetricsStartEndListOptions)
                ? ((MetricsStartEndListOptions) options).getEnd().toString() : null;
        final String finalPeriod = (options instanceof MetricsPeriodListOptions)
                ? ((MetricsPeriodListOptions) options).getPeriod().toString() : null;

        return CloudCaller.call(this, "listMetrics()", MetricAdapter.getListMapper(),
                new CloudCall<SuccessfulResponse>() {

                    @Override
                    public Call<SuccessfulResponse> call() {
                        return endpoint.getStatistic().v3MetricsGet(
                                MetricAdapter.mapIncludes(finalOptions.getInclude()),
                                finalOptions.getInterval().toString(), null, finalStart, finalEnd, finalPeriod,
                                finalOptions.getLimit(), finalOptions.getAfter(), finalOptions.getOrder().toString());
                    }
                });

    }

    /**
     * Gets a resource value for a given device id and resource path.
     * 
     * @param deviceId
     *            The name/id of the device
     * @param resourcePath
     *            The resource path to get
     * @param cacheOnly
     *            If true, the response will come only from the cache
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response
     * @return A Future from which it is possible to obtain resource value
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Future<Object> getResourceValueAsync(@NonNull String deviceId, @NonNull String resourcePath,
            @DefaultValue(value = "false") boolean cacheOnly, @DefaultValue(value = "false") boolean noResponse)
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
     *            The name/id of the device
     * @param resourcePath
     *            The resource path to get
     * @param cacheOnly
     *            If true, the response will come only from the cache
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response
     * @param timeout
     *            Timeout for the request
     * @return resource value
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Object getResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
            @DefaultValue(value = "false") boolean cacheOnly, @DefaultValue(value = "false") boolean noResponse,
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
        } catch (MbedCloudException e) {
            logger.throwSDKException(e);
        }
        return null;
    }

    /**
     * Sets the value of a resource
     * 
     * @param deviceId
     *            The name/id of the device
     * @param resourcePath
     *            The resource path to get
     * @param resourceValue
     *            value to set
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response
     * @return A Future from which it is possible to set the value
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    // @API
    // public @Nullable Future<Object> setResourceValueAsync(@NonNull String deviceId, @NonNull String resourcePath,
    // @Nullable String resourceValue, @DefaultValue(value = "false") boolean noResponse)
    // throws MbedCloudException {
    // checkNotNull(deviceId, TAG_DEVICE_ID);
    // checkNotNull(resourcePath, TAG_RESOURCE_PATH);
    // final String finalDeviceId = deviceId;
    // final String finalResourcePath = resourcePath;
    // final String finalResourceValue = resourceValue;
    // final boolean finalNoResponse = noResponse;
    // return cache.fetchAsyncResponse(threadPool, "setResourceValueAsync()", new CloudCall<AsyncID>() {
    //
    // @SuppressWarnings("boxing")
    // @Override
    // public Call<AsyncID> call() {
    // return endpoint.getResources().v2EndpointsDeviceIdResourcePathPut(finalDeviceId,
    // ApiUtils.normalisePath(finalResourcePath), finalResourceValue, finalNoResponse);
    // }
    // });
    // }

    /**
     * Sets the value of a resource
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     * 
     * @param deviceId
     *            The name/id of the device
     * @param resourcePath
     *            The resource path to get
     * @param resourceValue
     *            value to set
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response
     * @param timeout
     *            Timeout for the request
     * @return The value of the new resource
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    // @API
    // public @Nullable Object setResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
    // @Nullable String resourceValue, @DefaultValue(value = "false") boolean noResponse,
    // @Nullable TimePeriod timeout) throws MbedCloudException {
    // final String id = deviceId;
    // final String path = resourcePath;
    // final String value = resourceValue;
    // final boolean waitForResponse = noResponse;
    // try {
    // return SynchronousMethod.waitForCompletion(new AsynchronousMethod<Object>() {
    //
    // @Override
    // public Future<Object> submit() throws MbedCloudException {
    // return setResourceValueAsync(id, path, value, waitForResponse);
    // }
    // }, timeout);
    // } catch (MbedCloudException e) {
    // logger.throwSDKException(e);
    // }
    // return null;
    // }

    /**
     * Executes a function on a resource.
     * 
     * @param deviceId
     *            The name/id of the device
     * @param resourcePath
     *            The resource path to get
     * @param functionName
     *            The function to trigger
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response
     * @return A Future from which it is possible to get the value returned from the function executed on the resource
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    // @API
    // public @Nullable Future<Object> executeResourceAsync(@NonNull String deviceId, @NonNull String resourcePath,
    // @NonNull String functionName, @DefaultValue(value = "false") boolean noResponse) throws MbedCloudException {
    // checkNotNull(deviceId, TAG_DEVICE_ID);
    // checkNotNull(resourcePath, TAG_RESOURCE_PATH);
    // checkNotNull(functionName, TAG_FUNCTION_NAME);
    // final String finalDeviceId = deviceId;
    // final String finalResourcePath = resourcePath;
    // final String finalFunctionName = functionName;
    // final boolean finalNoResponse = noResponse;
    // return cache.fetchAsyncResponse(threadPool, "executeResourceAsync()", new CloudCall<AsyncID>() {
    //
    // @SuppressWarnings("boxing")
    // @Override
    // public Call<AsyncID> call() {
    // return endpoint.getResources().v2EndpointsDeviceIdResourcePathPost(finalDeviceId, finalResourcePath,
    // finalFunctionName, finalNoResponse);
    // }
    // });
    // }

    /**
     * Executes a function on a resource
     * <p>
     * Note: Waits if necessary for the computation to complete, and then retrieves its result.
     * 
     * @param deviceId
     *            The name/id of the device
     * @param resourcePath
     *            The resource path to get
     * @param functionName
     *            The function to trigger
     * @param noResponse
     *            If true, mbed Device Connector will not wait for a response
     * @param timeout
     *            Timeout for the request
     * @return the value returned from the function executed on the resource
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    // @API
    // public @Nullable Object executeResource(@NonNull String deviceId, @NonNull String resourcePath,
    // @NonNull String functionName, @DefaultValue(value = "false") boolean noResponse,
    // @Nullable TimePeriod timeout) throws MbedCloudException {
    // final String id = deviceId;
    // final String path = resourcePath;
    // final String function = functionName;
    // final boolean waitForResponse = noResponse;
    // try {
    // return SynchronousMethod.waitForCompletion(new AsynchronousMethod<Object>() {
    //
    // @Override
    // public Future<Object> submit() throws MbedCloudException {
    // return executeResourceAsync(id, path, function, waitForResponse);
    // }
    // }, timeout);
    // } catch (MbedCloudException e) {
    // logger.throwSDKException(e);
    // }
    // return null;
    // }

    // TODO subscriptions

    /**
     * Gets the current callback URL if it exists
     * 
     * @return the webhook
     * @throws MbedCloudException
     *             if a problem occurred during request processing
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
     *            Webhook to set
     * @throws MbedCloudException
     *             if a problem occurred during request processing
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
     * Deletes the callback data (effectively stopping Arm Mbed Cloud Connect from putting notifications)
     * 
     * If no webhook is registered, an exception (404) will be raised.
     * 
     * Note that every registered subscription will be deleted as part of deregistering a webhook.
     * 
     * @throws MbedCloudException
     *             if a problem occurred during request processing
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

}
