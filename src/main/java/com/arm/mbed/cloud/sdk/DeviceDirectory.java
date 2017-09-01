package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractAPI;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterMarshaller;
import com.arm.mbed.cloud.sdk.devicedirectory.adapters.DeviceAdapter;
import com.arm.mbed.cloud.sdk.devicedirectory.adapters.DeviceEventAdapter;
import com.arm.mbed.cloud.sdk.devicedirectory.adapters.QueryAdapter;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceEvent;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceEventListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.DeviceListOptions;
import com.arm.mbed.cloud.sdk.devicedirectory.model.EndPoints;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Query;
import com.arm.mbed.cloud.sdk.devicedirectory.model.QueryListOptions;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventData;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceEventPage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DevicePage;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQuery;
import com.arm.mbed.cloud.sdk.internal.devicedirectory.model.DeviceQueryPage;

import retrofit2.Call;

@Preamble(description = "Specifies Device directory API")
@Module
/**
 * API exposing functionality for dealing with devices
 */
public class DeviceDirectory extends AbstractAPI {

    private static final String TAG_DEVICE_EVENT_ID = "deviceEventId";
    private static final String TAG_QUERY = "query";
    private static final String TAG_QUERY_ID = "queryId";
    private static final String TAG_DEVICE_ID = "deviceId";
    private static final String TAG_DEVICE = "device";
    private final EndPoints endpoint;

    public DeviceDirectory(ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Lists all devices according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of devices corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<Device> listDevices(@Nullable DeviceListOptions options) throws MbedCloudException {
        final DeviceListOptions finalOptions = (options == null) ? new DeviceListOptions() : options;

        return CloudCaller.call(this, "listDevices()", DeviceAdapter.getListMapper(), new CloudCall<DevicePage>() {

            @Override
            public Call<DevicePage> call() {
                return endpoint.getDirectory().deviceList(finalOptions.getLimit(), finalOptions.getOrder().toString(),
                        finalOptions.getAfter(), DeviceAdapter.FILTERS_MARSHALLER.encode(finalOptions.getFilters()),
                        finalOptions.encodeInclude());
            }
        });
    }

    /**
     * Gets an iterator over all devices according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of devices corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<Device> listAllDevices(@Nullable DeviceListOptions options) throws MbedCloudException {
        final DeviceListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<Device>() {

            @Override
            public ListResponse<Device> requestNewPage() throws MbedCloudException {
                return listDevices(finalOptions);
            }
        });
    }

    /**
     * Gets details of a device
     * 
     * @param deviceId
     *            Device ID
     * @return device corresponding to the device id or null if not found
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Device getDevice(@NonNull String deviceId) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        final String id = deviceId;
        return CloudCaller.call(this, "getDevice()", DeviceAdapter.getMapper(), new CloudCall<DeviceData>() {

            @Override
            public Call<DeviceData> call() {
                return endpoint.getDirectory().deviceRetrieve(id);
            }
        });
    }

    /**
     * Adds a device
     * 
     * @param device
     *            Device details
     * @return added device
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Device addDevice(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        final Device finalDevice = device;
        return CloudCaller.call(this, "addDevice()", DeviceAdapter.getMapper(), new CloudCall<DeviceData>() {

            @Override
            public Call<DeviceData> call() {
                return endpoint.getDirectory().deviceCreate(DeviceAdapter.reverseMapAdd(finalDevice));
            }
        });
    }

    /**
     * Updates a device
     * 
     * @param device
     *            Device details
     * @return updated device
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Device updateDevice(@NonNull Device device) throws MbedCloudException {
        checkNotNull(device, TAG_DEVICE);
        checkNotNull(device.getId(), TAG_DEVICE_ID);
        final Device finalDevice = device;
        return CloudCaller.call(this, "updateDevice()", DeviceAdapter.getMapper(), new CloudCall<DeviceData>() {

            @Override
            public Call<DeviceData> call() {
                return endpoint.getDirectory().devicePartialUpdate(finalDevice.getId(),
                        DeviceAdapter.reverseMapUpdate(finalDevice));
            }
        });
    }

    /**
     * Deletes a device
     * 
     * @param deviceId
     *            Device ID of the device to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteDevice(@NonNull String deviceId) throws MbedCloudException {
        checkNotNull(deviceId, TAG_DEVICE_ID);
        final String finalId = deviceId;
        CloudCaller.call(this, "deleteDevice()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getDirectory().deviceDestroy(finalId);
            }

        });
    }

    /**
     * Lists all queries according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of queries corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<Query> listQueries(@Nullable QueryListOptions options) throws MbedCloudException {
        final QueryListOptions finalOptions = (options == null) ? new QueryListOptions() : options;

        return CloudCaller.call(this, "listQueries()", QueryAdapter.getListMapper(), new CloudCall<DeviceQueryPage>() {

            @Override
            public Call<DeviceQueryPage> call() {
                return endpoint.getDirectory().deviceQueryList(finalOptions.getLimit(),
                        finalOptions.getOrder().toString(), finalOptions.getAfter(),
                        new FilterMarshaller(null).encode(finalOptions.getFilters()), finalOptions.encodeInclude());
            }
        });
    }

    /**
     * Gets an iterator over all queries according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of queries corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<Query> listAllQueries(@Nullable QueryListOptions options) throws MbedCloudException {
        final QueryListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<Query>() {

            @Override
            public ListResponse<Query> requestNewPage() throws MbedCloudException {
                return listQueries(finalOptions);
            }
        });
    }

    /**
     * Gets a query
     * 
     * @param queryId
     *            Query ID
     * @return query corresponding to the device id or null if not found
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Query getQuery(@NonNull String queryId) throws MbedCloudException {
        checkNotNull(queryId, TAG_QUERY_ID);
        final String finalId = queryId;
        return CloudCaller.call(this, "getQuery()", QueryAdapter.getMapper(), new CloudCall<DeviceQuery>() {

            @Override
            public Call<DeviceQuery> call() {
                return endpoint.getDirectory().deviceQueryRetrieve(finalId);
            }
        });
    }

    /**
     * Adds a query
     * 
     * @param query
     *            the query to add
     * @return added query
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Query addQuery(@NonNull Query query) throws MbedCloudException {
        checkNotNull(query, TAG_QUERY);
        final Query finalQuery = query;
        return CloudCaller.call(this, "addQuery()", QueryAdapter.getMapper(), new CloudCall<DeviceQuery>() {

            @Override
            public Call<DeviceQuery> call() {
                return endpoint.getDirectory().deviceQueryCreate(QueryAdapter.reverseMapAdd(finalQuery));
            }
        });
    }

    /**
     * Updates a query
     * 
     * @param query
     *            The query to update
     * @return updated query
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Query updateQuery(@NonNull Query query) throws MbedCloudException {
        checkNotNull(query, TAG_QUERY);
        checkNotNull(query.getId(), TAG_QUERY_ID);
        final Query finalQuery = query;
        return CloudCaller.call(this, "updateQuery()", QueryAdapter.getMapper(), new CloudCall<DeviceQuery>() {

            @Override
            public Call<DeviceQuery> call() {
                return endpoint.getDirectory().deviceQueryPartialUpdate(finalQuery.getId(),
                        QueryAdapter.reverseMapUpdate(finalQuery));
            }
        });
    }

    /**
     * Deletes a query
     * 
     * @param queryId
     *            query ID of the query to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteQuery(@NonNull String queryId) throws MbedCloudException {
        checkNotNull(queryId, TAG_QUERY_ID);
        final String finalId = queryId;
        CloudCaller.call(this, "deleteQuery()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getDirectory().deviceQueryDestroy(finalId);
            }

        });
    }

    /**
     * Lists all device events according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of device events corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<DeviceEvent> listDeviceEvents(@Nullable DeviceEventListOptions options)
            throws MbedCloudException {
        final DeviceEventListOptions finalOptions = (options == null) ? new DeviceEventListOptions() : options;

        return CloudCaller.call(this, "listDeviceEvents()", DeviceEventAdapter.getListMapper(),
                new CloudCall<DeviceEventPage>() {

                    @Override
                    public Call<DeviceEventPage> call() {
                        return endpoint.getDirectory().deviceLogList(finalOptions.getLimit(),
                                finalOptions.getOrder().toString(), finalOptions.getAfter(),
                                DeviceEventAdapter.FILTERS_MARSHALLER.encode(finalOptions.getFilters()),
                                finalOptions.encodeInclude());
                    }
                });
    }

    /**
     * Gets an iterator over all device events according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of device events corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<DeviceEvent> listAllDeviceEvents(@Nullable DeviceEventListOptions options)
            throws MbedCloudException {
        final DeviceEventListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<DeviceEvent>() {

            @Override
            public ListResponse<DeviceEvent> requestNewPage() throws MbedCloudException {
                return listDeviceEvents(finalOptions);
            }
        });
    }

    /**
     * Gets a single device event
     * 
     * @param deviceEventId
     *            Device event ID
     * @return device event corresponding to the device event id or null if not found
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable DeviceEvent getDeviceEvent(@NonNull String deviceEventId) throws MbedCloudException {
        checkNotNull(deviceEventId, TAG_DEVICE_EVENT_ID);
        final String finalId = deviceEventId;
        return CloudCaller.call(this, "getDeviceEvent()", DeviceEventAdapter.getMapper(),
                new CloudCall<DeviceEventData>() {

                    @Override
                    public Call<DeviceEventData> call() {
                        return endpoint.getDirectory().deviceLogRetrieve(finalId);
                    }
                });
    }
}
