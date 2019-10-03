package com.arm.mbed.cloud.sdk.subscribe;

import io.reactivex.BackpressureStrategy;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotificationsObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.FirstValue;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Definition of the subscription manager for Pelion Cloud")
public interface CloudSubscriptionManager extends SubscriptionManager {

    String DEFAULT_BACKPRESSURE_STRATEGY = "BUFFER";

    /**
     * Creates an observer {@link Observer } which listens to device state changes that verify the filter.
     * <p>
     * Use {@link #deviceStateChanges(DeviceStateFilterOptions, BackpressureStrategy)} instead.
     *
     * @param filter
     *            filter to apply for this channel.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return a registered observer which listens to some device state changes.
     */
    @Deprecated
    @Nullable
    DeviceStateObserver deviceState(@Nullable DeviceStateFilterOptions filter,
                                    @NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy);

    /**
     * Creates an observer {@link Observer } which listens to device state changes that verify the filter.
     *
     * @param filter
     *            filter to apply for this channel.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return a registered observer which listens to some device state changes.
     */
    @Nullable
    DeviceStateObserver deviceStateChanges(@Nullable DeviceStateFilterOptions filter,
                                           @NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy);

    /**
     * Creates an observer {@link Observer } which listens to resource values of resources that match the filter.
     *
     * @param filter
     *            filter to apply for this channel.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return a registered observer which listens to some resource values.
     */
    @Nullable
    ResourceValueObserver resourceValues(@Nullable SubscriptionFilterOptions filter,
                                         @NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy);

    /**
     * Creates an observer {@link Observer } which listens to resource values of resources that match the filter.
     *
     * @param filter
     *            filter to apply for this channel.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @param triggerMode
     *            mode describing when the first value should be retrieved
     * @return a registered observer which listens to some resource values.
     */
    @Nullable
    ResourceValueObserver resourceValues(@Nullable SubscriptionFilterOptions filter,
                                         @NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy,
                                         FirstValue triggerMode);

    /**
     * Creates an observer {@link Observer } which listens to values of a resource
     *
     * @param resource
     *            resource to subscribe to.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @param triggerMode
     *            mode describing when the first value should be retrieved
     * @return a registered observer which listens to values of a resource.
     */
    @Nullable
    ResourceValueObserver resourceValues(@Nullable Resource resource,
                                         @NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy,
                                         FirstValue triggerMode);

    /**
     * Creates an observer {@link Observer } which listens to values of a resource
     *
     * @param resource
     *            resource to subscribe to.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return a registered observer which listens to values of a resource.
     */
    @Nullable
    ResourceValueObserver resourceValues(@Nullable Resource resource,
                                         @NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy);

    /**
     * Creates an observer {@link Observer } which listens to asynchronous responses.
     *
     * @param requestId
     *            Identifier of the request
     * @param resource
     *            resource the request targeted.
     * @param notifyOtherObservers
     *            States whether this observer should notify other observers on response.
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return a registered observer which listens to values of a resource.
     */
    @Nullable
    AsynchronousResponseObserver asynchronousResponse(@Nullable String requestId, @Nullable Resource resource,
                                                      boolean notifyOtherObservers,
                                                      @NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy);

    /**
     * Creates an observer {@link Observer } which listens to all notifications from the Cloud.
     * 
     * @param strategy
     *            backpressure strategy to apply to underlying communication channel. @see {@link BackpressureStrategy}
     * @return registered observer which listens to all notifications from the Cloud.
     */
    @Nullable
    AllNotificationsObserver allNotifications(@NonNull @DefaultValue(DEFAULT_BACKPRESSURE_STRATEGY) BackpressureStrategy strategy);
    // TODO the following
    // @Nullable
    // Object currentResourceValue(...)

}
