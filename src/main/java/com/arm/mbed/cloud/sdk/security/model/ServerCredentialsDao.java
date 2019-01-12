// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.Security;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;

/**
 * Data Access Object (DAO) for server credentials.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for server credentials.")
public class ServerCredentialsDao extends AbstractModelDao<ServerCredentials> {
    /**
     * Constructor.
     */
    public ServerCredentialsDao() throws MbedCloudException {
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
    public ServerCredentialsDao clone() {
        try {
            return new ServerCredentialsDao().configureAndGet(module == null ? null : module.clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Fetch bootstrap server credentials.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.security.model.ServerCredentials#getBootstrap()}
     */
    public void getBootstrap() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getBootstrap());
    }

    /**
     * Fetch LwM2M server credentials.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.security.model.ServerCredentials#getLwm2m()}
     */
    public void getLwm2m() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Security) module).getLwm2m());
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected ServerCredentials instantiateModel() {
        return new ServerCredentials();
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
        return new Security(context);
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
        return new Security(options);
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
        return new Security(client);
    }
}
