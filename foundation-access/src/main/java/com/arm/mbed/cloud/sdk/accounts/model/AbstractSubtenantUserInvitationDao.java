// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated abstract class. Do not modify its contents.
// Code customisation should happen in the child class [SubtenantUserInvitationDao]
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
import com.arm.mbed.cloud.sdk.common.dao.CreateDao;
import com.arm.mbed.cloud.sdk.common.dao.DeleteDao;
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;

/**
 * Data Access Object (DAO) for subtenant user invitations.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for subtenant user invitations.")
public abstract class AbstractSubtenantUserInvitationDao extends AbstractModelDao<SubtenantUserInvitation>
                                                         implements CreateDao<SubtenantUserInvitation>,
                                                         DeleteDao<SubtenantUserInvitation>,
                                                         ReadDao<SubtenantUserInvitation> {
    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public AbstractSubtenantUserInvitationDao() throws MbedCloudException {
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
    public AbstractSubtenantUserInvitationDao(ApiClientWrapper client) throws MbedCloudException {
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
    public AbstractSubtenantUserInvitationDao(ConnectionOptions options) throws MbedCloudException {
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
    public AbstractSubtenantUserInvitationDao(SdkContext sdkContext) throws MbedCloudException {
        super(sdkContext);
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitationDao#create(com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public SubtenantUserInvitation create() throws MbedCloudException {
        return create(getModel());
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#createSubtenantUserInvitation(com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param subtenantUserInvitation
     *            a subtenant user invitation.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public SubtenantUserInvitation
           create(@NonNull SubtenantUserInvitation subtenantUserInvitation) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).createSubtenantUserInvitation(subtenantUserInvitation));
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitationDao#create(String, com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param accountId
     *            The ID of the account the user is invited to.
     * @return an added subtenant user invitation
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation create(@NonNull String accountId) throws MbedCloudException {
        return create(accountId, getModel());
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#createSubtenantUserInvitation(String, com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param accountId
     *            The ID of the account the user is invited to.
     * @param subtenantUserInvitation
     *            a subtenant user invitation.
     * @return an added subtenant user invitation
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation
           create(@NonNull String accountId,
                  @NonNull SubtenantUserInvitation subtenantUserInvitation) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).createSubtenantUserInvitation(accountId,
                                                                                            subtenantUserInvitation));
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitationDao#create(int, com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param validForDays
     *            Specifies how many days the invitation will be valid for.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation create(@Nullable @DefaultValue("30") int validForDays) throws MbedCloudException {
        return create(validForDays, getModel());
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitationDao#create(int, String, com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param validForDays
     *            Specifies how many days the invitation will be valid for.
     * @param accountId
     *            The ID of the account the user is invited to.
     * @return an added subtenant user invitation
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation create(@Nullable @DefaultValue("30") int validForDays,
                                          @NonNull String accountId) throws MbedCloudException {
        return create(validForDays, accountId, getModel());
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#createSubtenantUserInvitation(int, String, com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param validForDays
     *            Specifies how many days the invitation will be valid for.
     * @param accountId
     *            The ID of the account the user is invited to.
     * @param subtenantUserInvitation
     *            a subtenant user invitation.
     * @return an added subtenant user invitation
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation
           create(@Nullable @DefaultValue("30") int validForDays, @NonNull String accountId,
                  @NonNull SubtenantUserInvitation subtenantUserInvitation) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).createSubtenantUserInvitation(validForDays, accountId,
                                                                                            subtenantUserInvitation));
    }

    /**
     * Adds a subtenant user invitation.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#createSubtenantUserInvitation(int, com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param validForDays
     *            Specifies how many days the invitation will be valid for.
     * @param subtenantUserInvitation
     *            a subtenant user invitation.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation
           create(@Nullable @DefaultValue("30") int validForDays,
                  @NonNull SubtenantUserInvitation subtenantUserInvitation) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).createSubtenantUserInvitation(validForDays,
                                                                                            subtenantUserInvitation));
    }

    /**
     * Deletes a subtenant user invitation.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitationDao#delete(com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public void delete() throws MbedCloudException {
        delete(getModel());
    }

    /**
     * Deletes a subtenant user invitation.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#deleteSubtenantUserInvitation(com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param subtenantUserInvitation
     *            a subtenant user invitation.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public void delete(@NonNull SubtenantUserInvitation subtenantUserInvitation) throws MbedCloudException {
        ((Accounts) getModuleOrThrow()).deleteSubtenantUserInvitation(subtenantUserInvitation);
    }

    /**
     * Deletes a subtenant user invitation.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Accounts#deleteSubtenantUserInvitation(String, String)}
     * 
     * @param accountId
     *            Account ID.
     * @param id
     *            The ID of the invitation to delete.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public void delete(@NonNull String accountId, @NonNull String id) throws MbedCloudException {
        ((Accounts) getModuleOrThrow()).deleteSubtenantUserInvitation(accountId, id);
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected SubtenantUserInvitation instantiateModel() {
        return new SubtenantUserInvitation();
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
     * Gets a subtenant user invitation.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitationDao#read(com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public SubtenantUserInvitation read() throws MbedCloudException {
        return read(getModel());
    }

    /**
     * Gets a subtenant user invitation.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#readSubtenantUserInvitation(com.arm.mbed.cloud.sdk.accounts.model.SubtenantUserInvitation)}
     * 
     * @param subtenantUserInvitation
     *            a subtenant user invitation.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation
           read(@NonNull SubtenantUserInvitation subtenantUserInvitation) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).readSubtenantUserInvitation(subtenantUserInvitation));
    }

    /**
     * Gets a subtenant user invitation.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Accounts#readSubtenantUserInvitation(String, String)}
     * 
     * @param accountId
     *            The ID of the account the user is invited to.
     * @param id
     *            The ID of the invitation.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public SubtenantUserInvitation read(@NonNull String accountId, @NonNull String id) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).readSubtenantUserInvitation(accountId, id));
    }
}
