package com.arm.mbed.cloud.sdk.common.dao;

import java.security.InvalidParameterException;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
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

    private static final String PARAMETER_CLIENT = "client";
    private static final String PARAMETER_MODULE = "module";
    protected ApiModule module;

    /**
     * Constructor.
     */
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
            throw new MbedCloudException(new InvalidParameterException("The connection options set are invalid: "
                                                                       + configuration));
        }
        module = instantiateModule(options);
    }

    @Override
    public void configure(ApiClientWrapper client) throws MbedCloudException {
        ApiUtils.checkNotNull(SdkLogger.getLogger(), client, PARAMETER_CLIENT);
        module = instantiateModule(client);
    }

    @Override
    public void configure(ApiModule oneModule) throws MbedCloudException {
        ApiUtils.checkNotNull(SdkLogger.getLogger(), oneModule, PARAMETER_MODULE);
        this.module = oneModule;
    }

    @Override
    public DaoProvider getDaoProvider() {
        return module == null ? DaoProvider.newGlobalProvider() : new DaoProvider(module.getClient());
    }

    @Override
    public ApiModule getModule() throws MbedCloudException {
        return module;
    }

    protected abstract ApiModule instantiateModule(ConnectionOptions options);

    protected abstract ApiModule instantiateModule(ApiClientWrapper client);
}
