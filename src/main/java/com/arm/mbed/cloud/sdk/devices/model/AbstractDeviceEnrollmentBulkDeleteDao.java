// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated abstract class. Do not modify its contents.
// Code customisation should happen in the child class [DeviceEnrollmentBulkDeleteDao]
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
import com.arm.mbed.cloud.sdk.common.dao.DeleteDao;
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;
import com.arm.mbed.cloud.sdk.common.model.DataFile;

/**
 * Data Access Object (DAO) for device enrollment bulk deletes.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for device enrollment bulk deletes.")
public abstract class AbstractDeviceEnrollmentBulkDeleteDao extends AbstractModelDao<DeviceEnrollmentBulkDelete>
                                                            implements DeleteDao<DeviceEnrollmentBulkDelete>,
                                                            ReadDao<DeviceEnrollmentBulkDelete> {
    /**
     * Constructor.
     */
    public AbstractDeviceEnrollmentBulkDeleteDao() throws MbedCloudException {
        super();
    }

    /**
     * Deletes a device enrollment bulk delete.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.devices.model.DeviceEnrollmentBulkDelete#deleteDeviceEnrollmentBulkDelete(DataFile)}
     * 
     * @param enrollmentIdentities
     *            The `CSV` file containing the enrollment IDs. The maximum file size is 10MB.
     */
    public void delete(@NonNull DataFile enrollmentIdentities) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Devices) module).deleteDeviceEnrollmentBulkDelete(enrollmentIdentities));
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected DeviceEnrollmentBulkDelete instantiateModel() {
        return new DeviceEnrollmentBulkDelete();
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
     * Gets a device enrollment bulk delete.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.devices.model.DeviceEnrollmentBulkDelete#getDeviceEnrollmentBulkDelete(DeviceEnrollmentBulkDelete)}
     */
    @Override
    public void read() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Devices) module).getDeviceEnrollmentBulkDelete(getModel()));
    }

    /**
     * Gets a device enrollment bulk delete.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.devices.model.DeviceEnrollmentBulkDelete#getDeviceEnrollmentBulkDelete(String)}
     * 
     * @param id
     *            Bulk ID.
     */
    @Override
    public void read(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Devices) module).getDeviceEnrollmentBulkDelete(id));
    }
}
