// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import com.arm.mbed.cloud.sdk.Devices;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;

/**
 * Data Access Object (DAO) for device events.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for device events.")
public class DeviceEventsDao extends AbstractModelDao<DeviceEvents> implements ReadDao<DeviceEvents> {
    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public DeviceEventsDao() throws MbedCloudException {
        super();
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    @SuppressWarnings({ "unused", "resource" })
    public DeviceEventsDao clone() {
        try {
            return new DeviceEventsDao().configureAndGet(getModuleOrThrow() == null ? null
                                                                                    : getModuleOrThrow().clone());
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
    protected DeviceEvents instantiateModel() {
        return new DeviceEvents();
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
        return new Devices(client);
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
        return new Devices(options);
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
        return new Devices(context);
    }

    /**
     * Gets a device events.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Devices#readDeviceEvents(com.arm.mbed.cloud.sdk.devices.model.DeviceEvents)}
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     * @return something
     */
    @Override
    public DeviceEvents read() throws MbedCloudException {
        setModel(((Devices) getModuleOrThrow()).readDeviceEvents(getModel()));
        return getModel();
    }

    /**
     * Gets a device events.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Devices#readDeviceEvents(String)}
     * 
     * @param id
     *            null
     * @throws MbedCloudException
     *             if an error occurs during the process.
     * @return something
     */
    @Override
    public DeviceEvents read(@NonNull String id) throws MbedCloudException {
        setModel(((Devices) getModuleOrThrow()).readDeviceEvents(id));
        return getModel();
    }
}
