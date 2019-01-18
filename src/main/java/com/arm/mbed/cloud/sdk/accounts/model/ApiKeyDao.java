// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.Accounts;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.CrudDao;

/**
 * Data Access Object (DAO) for api keys.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for api keys.")
public class ApiKeyDao extends AbstractModelDao<ApiKey> implements CrudDao<ApiKey> {
    /**
     * Constructor.
     */
    public ApiKeyDao() throws MbedCloudException {
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
    public ApiKeyDao clone() {
        try {
            return new ApiKeyDao().configureAndGet(module == null ? null : module.clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Adds an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#createApiKey(ApiKey)}
     */
    @Override
    public void create() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).createApiKey(getModel()));
    }

    /**
     * Adds an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#createApiKey(ApiKey)}
     * 
     * @param apiKey
     *            an api key.
     */
    @Override
    public void create(@NonNull ApiKey apiKey) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(apiKey);
        create();
    }

    /**
     * Deletes an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#deleteApiKey(ApiKey)}
     */
    @Override
    public void delete() throws MbedCloudException {
        checkDaoConfiguration();
        ((Accounts) module).deleteApiKey(getModel());
    }

    /**
     * Deletes an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#deleteApiKey(ApiKey)}
     * 
     * @param apiKey
     *            an api key.
     */
    @Override
    public void delete(@NonNull ApiKey apiKey) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(apiKey);
        delete();
    }

    /**
     * Deletes an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#deleteApiKey(String)}
     * 
     * @param id
     *            The ID of the API key to be deleted.
     */
    @Override
    public void delete(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        ((Accounts) module).deleteApiKey(id);
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected ApiKey instantiateModel() {
        return new ApiKey();
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
        return new Accounts(client);
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
        return new Accounts(context);
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
        return new Accounts(options);
    }

    /**
     * Gets my api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#myApiKey()}
     */
    @SuppressWarnings("PMD.ShortMethodName")
    public void me() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).myApiKey());
    }

    /**
     * Gets an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#getApiKey(ApiKey)}
     */
    @Override
    public void read() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).getApiKey(getModel()));
    }

    /**
     * Gets an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#getApiKey(String)}
     * 
     * @param id
     *            The ID of the API key.
     */
    @Override
    public void read(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).getApiKey(id));
    }

    /**
     * Modifies an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#updateApiKey(ApiKey)}
     */
    @Override
    public void update() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).updateApiKey(getModel()));
    }

    /**
     * Modifies an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#updateApiKey(ApiKey)}
     * 
     * @param apiKey
     *            an api key.
     */
    @Override
    public void update(@NonNull ApiKey apiKey) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(apiKey);
        update();
    }

    /**
     * Modifies an api key.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.ApiKey#updateApiKey(String,ApiKey)}
     * 
     * @param id
     *            The ID of the API key.
     */
    public void update(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).updateApiKey(id, getModel()));
    }
}
