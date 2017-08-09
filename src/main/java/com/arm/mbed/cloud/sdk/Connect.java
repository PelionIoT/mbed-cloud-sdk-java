package com.arm.mbed.cloud.sdk;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Daemon;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractAPI;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod;
import com.arm.mbed.cloud.sdk.common.SynchronousMethod.AsynchronousMethod;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.connect.adapters.ConnectedDeviceAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.MetricAdapter;
import com.arm.mbed.cloud.sdk.connect.adapters.ResourceAdapter;
import com.arm.mbed.cloud.sdk.connect.model.ConnectedDevice;
import com.arm.mbed.cloud.sdk.connect.model.EndPoints;
import com.arm.mbed.cloud.sdk.connect.model.Metric;
import com.arm.mbed.cloud.sdk.connect.model.MetricsListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsPeriodListOptions;
import com.arm.mbed.cloud.sdk.connect.model.MetricsStartEndListOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.connect.notificationhandling.NotificationCache;
import com.arm.mbed.cloud.sdk.internal.model.AsyncID;
import com.arm.mbed.cloud.sdk.internal.model.Endpoint;
import com.arm.mbed.cloud.sdk.internal.model.SuccessfulResponse;

import retrofit2.Response;

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
     * @param threadPollingThreadPool
     */
    public Connect(ConnectionOptions options, ExecutorService notificationHandlingThreadPool,
            ExecutorService threadPollingThreadPool) {
        super(options);
        endpoint = new EndPoints(options);
        this.threadPool = (notificationHandlingThreadPool != null) ? notificationHandlingThreadPool
                : Executors.newFixedThreadPool(4);
        this.cache = new NotificationCache(logger,
                (threadPollingThreadPool != null) ? threadPollingThreadPool : Executors.newScheduledThreadPool(1),
                endpoint);
    }

    /**
     * Starts long polling for notifications
     * <p>
     * If not an external callback is set up (using `update_webhook`) then calling this function is mandatory to get or
     * set resource.
     */
    @Daemon(task = "Long polling", start = true)
    public void startNotifications() {
        cache.startPolling();
    }

    /**
     * Stops long polling for notifications
     */
    @Daemon(task = "Long polling", stop = true)
    public void stopNotifications() {
        cache.stopPolling();
    }

    /**
     * Shuts down all daemon services
     */
    @Daemon(task = "Long polling", shutdown = true)
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
        try {
            Response<List<Endpoint>> response = endpoint.getEndpoints().v2EndpointsGet(type).execute();
            return (response == null) ? null : ConnectedDeviceAdapter.mapList(response.body());
        } catch (IOException e) {
            throwSDKException(e);
        }
        return null;
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
        ApiUtils.checkNotNull(deviceId, TAG_DEVICE_ID);
        try {
            Response<List<com.arm.mbed.cloud.sdk.internal.model.Resource>> response = endpoint.getEndpoints()
                    .v2EndpointsDeviceIdGet(deviceId).execute();
            return (response == null) ? null : ResourceAdapter.mapList(deviceId, response.body());
        } catch (IOException e) {
            throwSDKException(e);
        }
        return null;
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
        ApiUtils.checkNotNull(options, TAG_METRIC_OPTIONS);
        try {
            String start = null;
            String end = null;
            String period = null;
            if (options instanceof MetricsPeriodListOptions) {
                MetricsPeriodListOptions opt = (MetricsPeriodListOptions) options;
                period = opt.getPeriod().toString();
            }
            if (options instanceof MetricsStartEndListOptions) {
                MetricsStartEndListOptions opt = (MetricsStartEndListOptions) options;
                start = opt.getStart().toString();
                end = opt.getEnd().toString();
            }
            Response<SuccessfulResponse> response = endpoint.getStatistic()
                    .v3MetricsGet(MetricAdapter.mapIncludes(options.getInclude()), options.getInterval().toString(), "",
                            start, end, period, options.getLimit(), options.getAfter(), options.getOrder().toString())
                    .execute();
            return (response == null || response.body() == null) ? null
                    : MetricAdapter.mapList(response.body().getData());
        } catch (IOException e) {
            throwSDKException(e);
        }
        return null;
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
            boolean cacheOnly, boolean noResponse) throws MbedCloudException {
        ApiUtils.checkNotNull(deviceId, TAG_DEVICE_ID);
        ApiUtils.checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        try {
            if (!cache.isPollingActive()) {
                throw new MbedCloudException("startNotifications() needs to be called before getting resource value.");
            }
            @SuppressWarnings("boxing")
            Response<AsyncID> response = endpoint.getResources().v2EndpointsDeviceIdResourcePathGet(deviceId,
                    ApiUtils.normalisePath(resourcePath), cacheOnly, noResponse).execute();
            return (response == null || response.body() == null) ? null
                    : cache.fetchAsyncResponse(threadPool, response.body().getAsyncResponseId());
        } catch (Exception e) {
            throwSDKException(e);
        }
        return null;
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
    public @Nullable Object getResourceValue(@NonNull String deviceId, @NonNull String resourcePath, boolean cacheOnly,
            boolean noResponse, @Nullable TimePeriod timeout) throws MbedCloudException {
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
            throwSDKException(e);
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
    @API
    public @Nullable Future<Object> setResourceValueAsync(@NonNull String deviceId, @NonNull String resourcePath,
            @Nullable String resourceValue, boolean noResponse) throws MbedCloudException {
        ApiUtils.checkNotNull(deviceId, TAG_DEVICE_ID);
        ApiUtils.checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        try {
            if (!cache.isPollingActive()) {
                throw new MbedCloudException("startNotifications() needs to be called before setting resource value.");
            }
            @SuppressWarnings("boxing")
            Response<AsyncID> response = endpoint.getResources().v2EndpointsDeviceIdResourcePathPut(deviceId,
                    ApiUtils.normalisePath(resourcePath), resourceValue, noResponse).execute();

            return (response == null || response.body() == null) ? null
                    : cache.fetchAsyncResponse(threadPool, response.body().getAsyncResponseId());
        } catch (Exception e) {
            throwSDKException(e);
        }
        return null;
    }

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
    @API
    public @Nullable Object setResourceValue(@NonNull String deviceId, @NonNull String resourcePath,
            @Nullable String resourceValue, boolean noResponse, @Nullable TimePeriod timeout)
            throws MbedCloudException {
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
        } catch (MbedCloudException e) {
            throwSDKException(e);
        }
        return null;
    }

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
    @API
    public @Nullable Future<Object> executeResourceAsync(@NonNull String deviceId, @NonNull String resourcePath,
            @NonNull String functionName, boolean noResponse) throws MbedCloudException {
        ApiUtils.checkNotNull(deviceId, TAG_DEVICE_ID);
        ApiUtils.checkNotNull(resourcePath, TAG_RESOURCE_PATH);
        ApiUtils.checkNotNull(functionName, TAG_FUNCTION_NAME);
        try {
            if (!cache.isPollingActive()) {
                throw new MbedCloudException(
                        "startNotifications() needs to be called before executing a function on a resource.");
            }
            @SuppressWarnings("boxing")
            Response<AsyncID> response = endpoint.getResources()
                    .v2EndpointsDeviceIdResourcePathPost(deviceId, resourcePath, functionName, noResponse).execute();

            return (response == null || response.body() == null) ? null
                    : cache.fetchAsyncResponse(threadPool, response.body().getAsyncResponseId());
        } catch (Exception e) {
            throwSDKException(e);
        }
        return null;
    }

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
    @API
    public @Nullable Object executeResource(@NonNull String deviceId, @NonNull String resourcePath,
            @NonNull String functionName, boolean noResponse, @Nullable TimePeriod timeout) throws MbedCloudException {
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
        } catch (MbedCloudException e) {
            throwSDKException(e);
        }
        return null;
    }

}
