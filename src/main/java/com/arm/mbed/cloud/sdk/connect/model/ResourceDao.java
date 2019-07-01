// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.Connect;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.connect.subscription.ResourceValueType;

/**
 * Data Access Object (DAO) for resources.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for resources.")
public class ResourceDao extends AbstractModelDao<Resource> {
    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ResourceDao() throws MbedCloudException {
        super();
    }

    /**
     * Constructor.
     * 
     * @param client
     *            an api client wrapper.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ResourceDao(ApiClientWrapper client) throws MbedCloudException {
        super(client);
    }

    /**
     * Constructor.
     * 
     * @param options
     *            a connection options.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ResourceDao(ConnectionOptions options) throws MbedCloudException {
        super(options);
    }

    /**
     * Constructor.
     * 
     * @param sdkContext
     *            an sdk context.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ResourceDao(SdkContext sdkContext) throws MbedCloudException {
        super(sdkContext);
    }

    /**
     * Clones this instance.
     *
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    @SuppressWarnings({ "resource", "unused" })
    public ResourceDao clone() {
        try {
            return new ResourceDao().configureAndGet(getModuleOrThrow());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected Resource instantiateModel() {
        return new Resource();
    }

    /**
     * Instantiates modules.
     * 
     * @param client
     *            an api client wrapper.
     * @return instantiated module
     */
    @Override
    @Internal
    protected SdkContext instantiateModule(ApiClientWrapper client) {
        return new Connect(client == null ? null : client.getConnectionOptions());
    }

    /**
     * Instantiates modules.
     * 
     * @param options
     *            a connection options.
     * @return instantiated module
     */
    @Override
    @Internal
    protected SdkContext instantiateModule(ConnectionOptions options) {
        return new Connect(options);
    }

    /**
     * Instantiates modules.
     * 
     * @param context
     *            an sdk context.
     * @return instantiated module
     */
    @Override
    @Internal
    protected SdkContext instantiateModule(SdkContext context) {
        return new Connect(context);
    }

    /**
     * Gets the resource value.
     *
     * <p>
     * Note: uses internal data model
     * 
     * @param timeout
     *            Timeout for the request.
     * 
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Nullable
    public Object read(@Nullable TimePeriod timeout) throws MbedCloudException {
        return read(getModel(), timeout);
    }

    /**
     * Gets the resource value.
     * 
     * @param resource
     *            The resource to get the value from.
     * @param timeout
     *            Timeout for the request.
     * 
     * @return the resource value.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Nullable
    public Object read(@NonNull Resource resource, @Nullable TimePeriod timeout) throws MbedCloudException {
        final Object value = ((Connect) getModuleOrThrow()).getResourceValue(resource, timeout);
        setAndGetModel(resource);
        return value;
    }

    /**
     * Modifies the resource value.
     *
     * <p>
     * Note: uses internal data model
     * 
     * @param resourceValue
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @param timeout
     *            Timeout for the request.
     * @return the resource value.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Nullable
    public Object update(@Nullable Object resourceValue, @NonNull ResourceValueType valueType,
                         @Nullable TimePeriod timeout) throws MbedCloudException {
        return update(getModel(), resourceValue, valueType, timeout);
    }

    /**
     * Modifies the resource value.
     *
     * 
     * @param resource
     *            The resource to set the value of.
     * @param resourceValue
     *            value to set.
     * @param valueType
     *            type of the value to set.
     * @param timeout
     *            Timeout for the request.
     * @return the modified resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @Nullable
    public Object update(@NonNull Resource resource, @Nullable Object resourceValue,
                         @NonNull ResourceValueType valueType, @Nullable TimePeriod timeout) throws MbedCloudException {
        final Object value = ((Connect) getModuleOrThrow()).setResourceValue(resource, resourceValue, valueType,
                                                                             timeout);
        setAndGetModel(resource);
        return value;
    }

    /**
     * Executes the resource.
     *
     * <p>
     * Note: uses internal data model
     * 
     * @param functionName
     *            The function to trigger.
     * @param timeout
     *            Timeout for the request.
     * @return the executed resource value.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Nullable
    public Object execute(@Nullable String functionName, @Nullable TimePeriod timeout) throws MbedCloudException {
        return execute(getModel(), functionName, timeout);
    }

    /**
     * Executes the resource.
     *
     * 
     * @param resource
     *            The resource to execute.
     * @param functionName
     *            The function to trigger.
     * @param timeout
     *            Timeout for the request.
     * @return the executed resource value.
     * @throws MbedCloudException
     *             if a problem occurred during request processing.
     */
    @Nullable
    public Object execute(@NonNull Resource resource, @Nullable String functionName,
                          @Nullable TimePeriod timeout) throws MbedCloudException {
        final Object value = ((Connect) getModuleOrThrow()).executeResource(resource, functionName, timeout);
        setAndGetModel(resource);
        return value;
    }
}
