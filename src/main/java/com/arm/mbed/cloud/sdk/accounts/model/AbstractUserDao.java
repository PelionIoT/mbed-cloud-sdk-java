// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated abstract class. Do not modify its contents.
// Code customisation should happen in the child class [UserDao]
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.Accounts;
import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.CrudDao;

/**
 * Data Access Object (DAO) for users.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for users.")
public abstract class AbstractUserDao extends AbstractModelDao<User> implements CrudDao<User> {
    /**
     * Constructor.
     */
    public AbstractUserDao() throws MbedCloudException {
        super();
    }

    /**
     * Adds a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#createUser(String,User)}
     * 
     * @param action
     *            Action, either 'create' or 'invite'.
     */
    public void create(@Nullable @DefaultValue("create") String action) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).createUser(action, getModel()));
    }

    /**
     * Deletes a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#deleteUser(User)}
     */
    @Override
    public void delete() throws MbedCloudException {
        checkDaoConfiguration();
        ((Accounts) module).deleteUser(getModel());
    }

    /**
     * Deletes a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#deleteUser(User)}
     * 
     * @param user
     *            a user.
     */
    @Override
    public void delete(@NonNull User user) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(user);
        delete();
    }

    /**
     * Deletes a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#deleteUser(String)}
     * 
     * @param id
     *            The ID of the user to be deleted.
     */
    @Override
    public void delete(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        ((Accounts) module).deleteUser(id);
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected User instantiateModel() {
        return new User();
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
     * Gets a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#getUser(User)}
     */
    @Override
    public void read() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).getUser(getModel()));
    }

    /**
     * Gets a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#getUser(String)}
     * 
     * @param id
     *            The ID of the user.
     */
    @Override
    public void read(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).getUser(id));
    }

    /**
     * Modifies a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#updateUser(User)}
     */
    @Override
    public void update() throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).updateUser(getModel()));
    }

    /**
     * Modifies a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#updateUser(User)}
     * 
     * @param user
     *            a user.
     */
    @Override
    public void update(@NonNull User user) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(user);
        update();
    }

    /**
     * Modifies a user.
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.accounts.model.User#updateUser(String,User)}
     * 
     * @param id
     *            The ID of the user.
     */
    public void update(@NonNull String id) throws MbedCloudException {
        checkDaoConfiguration();
        setModel(((Accounts) module).updateUser(id, getModel()));
    }
}
