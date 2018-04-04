package com.arm.mbed.cloud.sdk;

import java.util.HashMap;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Experimental;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.subscribe.CloudSubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.DeviceStateObserver;

import io.reactivex.BackpressureStrategy;

@Preamble(description = "Entry point for using the SDK")
@Module
@Experimental
/**
 * Entry point for using the SDK.
 */
public class MbedCloud extends AbstractApi {

    private final Connect connectApi;

    /**
     * Mbed Cloud SDK constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public MbedCloud(ConnectionOptions options) {
        super(options, extendUserAgent());
        connectApi = new Connect(options);
    }

    /**
     * Creates a new Mbed Cloud SDK instance.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     * @return an instance of the SDK.
     */
    public static MbedCloud createSdk(ConnectionOptions options) {
        return new MbedCloud(options);
    }

    private static Map<String, String> extendUserAgent() {
        Map<String, String> extension = new HashMap<>(1);
        extension.put("HLA", "1.0.0-experimental");
        return extension;
    }

    /**
     * Gets subscription manager.
     *
     * @return subscription manager.
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    public CloudSubscriptionManager subscribe() throws MbedCloudException {
        return connectApi.subscribe();
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
        return subscribe().deviceState(filter, strategy);
    }

    /**
     * Stops any running daemon process/thread.
     *
     * @throws MbedCloudException
     *             if a problem occurs during the process.
     */
    @API
    public void stop() throws MbedCloudException {
        connectApi.stopNotifications();
    }

    @Override
    public String getModuleName() {
        return "SDK entry point";
    }
}
