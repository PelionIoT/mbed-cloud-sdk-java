package com.arm.mbed.cloud.sdk;

import java.util.concurrent.ExecutorService;

import com.arm.mbed.cloud.sdk.annotations.Experimental;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

@Preamble(description = "Specifies Subscribe API")
@Module
/**
 * API exposing functionality for dealing with subscription
 */
@Experimental
public class Subscribe extends AbstractApi {

    private final Connect connect;

    /**
     * Subscribe module constructor.
     * 
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Subscribe(@NonNull ConnectionOptions options) {
        super(options);
        connect = new Connect(options);
    }

    /**
     * Subscribe module constructor.
     * <p>
     * As opposed to {@link #Subscribe(ConnectionOptions)} which uses default thread pools for retrieving notifications,
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
    public Subscribe(@NonNull ConnectionOptions options, @Nullable ExecutorService notificationHandlingThreadPool,
            @Nullable ExecutorService notificationPullingThreadPool) {
        super(options);
        connect = new Connect(options, notificationHandlingThreadPool, notificationPullingThreadPool);
    }

    /**
     * Gets the connect module.
     * 
     * @return the connect module
     */
    public Connect getConnect() {
        return connect;
    }

    /**
     * Retrieves module name.
     * 
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Subscribe";
    }
}
