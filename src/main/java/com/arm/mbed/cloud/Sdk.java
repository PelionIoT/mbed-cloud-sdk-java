package com.arm.mbed.cloud;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.BackpressureStrategy;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.ModuleFactory;
import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Daemon;
import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Experimental;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractModule;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.GenericClient;
import com.arm.mbed.cloud.sdk.common.JsonSerialiser;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.CloudDao;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.connect.model.ResourceDao;
import com.arm.mbed.cloud.sdk.connect.subscription.ResourceValueType;
import com.arm.mbed.cloud.sdk.foundation.DaoFactory;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.NotificationMessage;
import com.arm.mbed.cloud.sdk.notify.CloudNotificationManager;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotificationsObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Entry point for using the SDK")
@Module
@Experimental
/**
 * Entry point for using the SDK.
 */
public class Sdk extends AbstractModule {

    private static final String BUFFER = "BUFFER";
    private final Connect connectApi;
    private final DaoFactory daoFactory;
    private final ModuleFactory moduleFactory;
    private final GenericClient genericClient;

    /**
     * Pelion Cloud SDK constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Sdk(ConnectionOptions options) {
        super(options, extendUserAgent());
        connectApi = new Connect(this);
        moduleFactory = new ModuleFactory(this, connectApi);
        daoFactory = new DaoFactory(this);
        genericClient = new GenericClient(this);
    }

    /**
     * Constructor.
     * 
     * @param context
     *            SDK context
     * 
     */
    public Sdk(SdkContext context) {
        this(context == null ? null : context.getConnectionOption());
    }

    /**
     * Creates a new Pelion Cloud SDK instance.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     * @return an instance of the SDK.
     */
    public static Sdk createSdk(ConnectionOptions options) {
        return new Sdk(options);
    }

    private static Map<String, String> extendUserAgent() {
        final Map<String, String> extension = new HashMap<>(1);
        extension.put("HLA", "1.0.0-experimental");
        return extension;
    }

    /**
     * Gets a factory for all the DAOs available in the system.
     * <p>
     * 
     * Note: See {@link CloudDao}
     * 
     * @return a DAO factory.
     */
    @API
    public DaoFactory foundation() {
        return daoFactory;
    }

    /**
     * Gets a factory for all the low-level REST modules available in the system.
     * <p>
     * Note: See {@link Module}
     * 
     * @return a Module Factory
     */
    @API
    public ModuleFactory lowLevelRest() {
        return moduleFactory;
    }

    /**
     * Gets a generic client in case it is needed to call REST APIs directly.
     * <p>
     * 
     * @see GenericClient
     * @return underlying generic client;
     */
    @API
    public GenericClient genericClient() {
        return genericClient;
    }

    /**
     * Gets the subscription manager.
     *
     * @return the subscription manager.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    public CloudSubscriptionManager subscribe() throws MbedCloudException {
        return connectApi.subscribe();
    }

    /**
     * Gets the notification manager.
     * 
     * @return the notification manager.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    public CloudNotificationManager notifications() throws MbedCloudException {
        return connectApi.notifications();
    }

    /**
     * Gets the corresponding resource DAO.
     * 
     * @param resource
     *            resource of interest.
     * @return the corresponding entity.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    public ResourceDao resource(@NonNull Resource resource) throws MbedCloudException {
        return connectApi.resource(resource);
    }

    /**
     * Subscribes to all notifications from Pelion Cloud.
     * 
     * 
     * @return a registered observer which listens to all notifications from Pelion.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    @Nullable
    public AllNotificationsObserver subscribe(@NonNull BackpressureStrategy strategy) throws MbedCloudException {
        return subscribe().allNotifications(strategy);
    }

    /**
     * Subscribes to device state changes.
     *
     * @param filter
     *            filter to apply.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return a registered observer which listens to some device state changes.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    @Nullable
    public DeviceStateObserver subscribe(@NonNull DeviceStateFilterOptions filter,
                                         @NonNull BackpressureStrategy strategy) throws MbedCloudException {
        return subscribe().deviceStateChanges(filter, strategy);
    }

    /**
     * Subscribes to resource value changes.
     *
     * @param filter
     *            filter to apply.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     *
     * @return a registered observer which listens to some resource value changes.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    public ResourceValueObserver subscribe(@NonNull SubscriptionFilterOptions filter,
                                           @NonNull BackpressureStrategy strategy) throws MbedCloudException {
        return subscribe().resourceValues(filter, strategy);
    }

    /**
     * Subscribes to resource value changes.
     *
     * @param filter
     *            filter to apply.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @param triggerMode
     *            mode describing when the first value should be retrieved
     * @return a registered observer which listens to some resource value changes.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    public ResourceValueObserver subscribe(@NonNull SubscriptionFilterOptions filter,
                                           @NonNull BackpressureStrategy strategy,
                                           FirstValue triggerMode) throws MbedCloudException {
        return subscribe().resourceValues(filter, strategy, triggerMode);
    }

    /**
     * Subscribes to value changes of a specific resource.
     *
     * @param resource
     *            resource to subscribe to.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return a registered observer which listens to some resource value changes.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    public ResourceValueObserver subscribe(@NonNull Resource resource,
                                           @NonNull BackpressureStrategy strategy) throws MbedCloudException {
        return subscribe().resourceValues(resource, strategy);
    }

    /**
     * Subscribes to value changes of a specific resource.
     *
     * @param resource
     *            resource to subscribe to.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @param triggerMode
     *            mode describing when the first value should be retrieved
     * @return a registered observer which listens to some resource value changes.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    public ResourceValueObserver subscribe(@NonNull Resource resource, @NonNull BackpressureStrategy strategy,
                                           FirstValue triggerMode) throws MbedCloudException {
        return subscribe().resourceValues(resource, strategy, triggerMode);
    }

    /**
     * Fetches resource current value.
     * <p>
     * See {@link AsynchronousResponseObserver}
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
           fetch(@NonNull Resource resource,
                 @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy) throws MbedCloudException {

        return connectApi.createCurrentResourceValueObserver(resource, strategy);
    }

    /**
     * Sets a resource value.
     * <p>
     * See {@link AsynchronousResponseObserver}
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
           set(@NonNull Resource resource, @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy,
               @Nullable Object value, @NonNull ResourceValueType valueType) throws MbedCloudException {

        return connectApi.createSetResourceValueObserver(resource, strategy, value, valueType);
    }

    /**
     * Executes an action on a resource.
     * <p>
     * See {@link AsynchronousResponseObserver}
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
           execute(@NonNull Resource resource, @Nullable @DefaultValue(BUFFER) BackpressureStrategy strategy,
                   @Nullable Object value, @NonNull ResourceValueType valueType) throws MbedCloudException {
        return connectApi.createExecuteResourceValueObserver(resource, strategy, value, valueType);
    }

    /**
     * Allows notifications (received from a Webhook) to be injected into the notifications system.
     *
     * @param data
     *            The notification data to inject
     */
    @API
    public void notify(@Nullable NotificationMessage data) {
        connectApi.notify(data);
    }

    /**
     * Allows notifications expressed as a JSON string to be injected into the notifications system.
     *
     * @param dataAsJson
     *            The notification data to inject as JSON String.
     */
    @API
    public void notify(@Nullable String dataAsJson) {
        connectApi.notify(dataAsJson);
    }

    /**
     * Allows a notification to be injected into the notifications system.
     *
     * @param deserialiser
     *            JSON deserialiser to use.
     * @param dataAsJson
     *            The notification data to inject as JSON String.
     */
    @API
    public void notify(@Nullable JsonSerialiser deserialiser, @Nullable String dataAsJson) {
        connectApi.notify(deserialiser, dataAsJson);
    }

    /**
     * Unsubscribes all observers contained in the system.
     * <p>
     * Note: this removes any subscriptions registered server side.
     * 
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    public void unsubscribeAll() throws MbedCloudException {
        subscribe().unsubscribeAll();
    }

    /**
     * Stops any running daemon process/thread.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    @Daemon(stop = true)
    public void stop() throws MbedCloudException {
        connectApi.stopNotifications();
    }

    /**
     * Shuts down all daemon services.
     * <p>
     * This method should be called when quitting the SDK.
     * <p>
     * It does not stop the JVM though.
     *
     */
    @API
    @Daemon(shutdown = true)
    public void quit() {
        connectApi.close();
        client.close();
    }

    /**
     * Similar to {@link #quit()}.
     */
    @Override
    @API
    public void close() {
        super.close();
        quit();
    }

    @Override
    public Sdk clone() {
        return new Sdk(this);

    }

    @Override
    public String getModuleName() {
        return "SDK entry point";
    }

}
