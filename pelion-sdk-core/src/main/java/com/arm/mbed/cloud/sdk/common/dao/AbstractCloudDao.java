package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiModule;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkLogger;

/**
 *
 * Abstract definition of a Cloud Data Access Object.
 *
 */
@Preamble(description = "Abstract Cloud DAO")
@Internal
public abstract class AbstractCloudDao implements CloudDao {

    private static final String PARAMETER_MODULE = "module";
    protected ApiModule module;

    public AbstractCloudDao() {
        module = null;
        try {
            configure(ConnectionOptions.newConfiguration(), false);
        } catch (MbedCloudException exception) {
            // Nothing to do
        }
    }

    @Override
    public void configure() throws MbedCloudException {
        configure(ConnectionOptions.newConfiguration());
    }

    @Override
    public void configure(ConnectionOptions options) throws MbedCloudException {
        configure(options, true);
    }

    private void configure(ConnectionOptions options, boolean throwExceptionIfInvalid) throws MbedCloudException {
        final ConnectionOptions configuration = options == null ? ConnectionOptions.newConfiguration() : options;
        if (!configuration.isValid() && throwExceptionIfInvalid) {
            throw new MbedCloudException("The connection options set are invalid: " + configuration);
        }
        module = instantiateModule(options);
    }

    @Override
    public void configure(ApiModule aModule) throws MbedCloudException {
        ApiUtils.checkNotNull(SdkLogger.getLogger(), aModule, PARAMETER_MODULE);
        this.module = aModule;
    }

    @Override
    public ApiModule getModule() throws MbedCloudException {
        return module;
    }

    protected abstract ApiModule instantiateModule(ConnectionOptions options);
}
