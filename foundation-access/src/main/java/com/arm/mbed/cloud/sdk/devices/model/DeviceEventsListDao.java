// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import com.arm.mbed.cloud.sdk.Devices;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelListDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;

/**
 * Data Access Object (DAO) for listing device events.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for listing device events.")
public class DeviceEventsListDao extends AbstractModelListDao<DeviceEvents, DeviceEventsListOptions>
                                 implements ModelListDao<DeviceEvents, DeviceEventsListOptions> {
    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public DeviceEventsListDao() throws MbedCloudException {
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
    public DeviceEventsListDao(ApiClientWrapper client) throws MbedCloudException {
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
    public DeviceEventsListDao(ConnectionOptions options) throws MbedCloudException {
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
    public DeviceEventsListDao(SdkContext sdkContext) throws MbedCloudException {
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
    public DeviceEventsListDao clone() {
        try {
            return new DeviceEventsListDao().configureAndGet(getModuleOrThrow() == null ? null
                                                                                        : getModuleOrThrow().clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * a device events dao class.
     * 
     * @return a device events dao class
     */
    @Override
    @Internal
    @SuppressWarnings("unchecked")
    public Class<DeviceEventsDao> getModelDaoClass() {
        return DeviceEventsDao.class;
    }

    /**
     * a device events dao.
     * 
     * @return a device events dao
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    @Internal
    @SuppressWarnings("unchecked")
    public DeviceEventsDao getNewModelDao() throws MbedCloudException {
        return new DeviceEventsDao().configureAndGet(getModuleOrThrow());
    }

    /**
     * a device events list options.
     * 
     * @return a device events list options
     */
    @Override
    @Internal
    protected DeviceEventsListOptions instantiateListOptions() {
        return new DeviceEventsListOptions();
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
     * Lists device events matching filter options.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Devices#listDeviceEventss(com.arm.mbed.cloud.sdk.devices.model.DeviceEventsListOptions)}
     * 
     * @param options
     *            list options.
     * @return one page of device events
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    protected ListResponse<DeviceEvents> requestOnePage(DeviceEventsListOptions options) throws MbedCloudException {
        return ((Devices) getModuleOrThrow()).listDeviceEventss(options);
    }
}
