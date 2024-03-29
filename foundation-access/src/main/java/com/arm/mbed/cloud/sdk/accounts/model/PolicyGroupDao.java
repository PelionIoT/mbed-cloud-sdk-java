// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.model;

import com.arm.mbed.cloud.sdk.Accounts;
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
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

/**
 * Data Access Object (DAO) for policy groups.
 * <p>
 * 
 * @see <a href="http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm">Core J2EE Patterns - Data Access
 *      Object</a>
 */
@Preamble(description = "Data Access Object (DAO) for policy groups.")
public class PolicyGroupDao extends AbstractModelDao<PolicyGroup> implements CrudDao<PolicyGroup> {
    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public PolicyGroupDao() throws MbedCloudException {
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
    public PolicyGroupDao(ApiClientWrapper client) throws MbedCloudException {
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
    public PolicyGroupDao(ConnectionOptions options) throws MbedCloudException {
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
    public PolicyGroupDao(SdkContext sdkContext) throws MbedCloudException {
        super(sdkContext);
    }

    /**
     * Creates a {@link Paginator} for the list of api keys matching filter options.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#allApiKeys(com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @return paginator over the list of api keys
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public Paginator<ApiKey> allApiKeys(@Nullable ApiKeyListOptions options) throws MbedCloudException {
        return allApiKeys(options, getModel());
    }

    /**
     * Creates a {@link Paginator} for the list of api keys matching filter options.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#allApiKeys(com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @param policyGroup
     *            a policy group.
     * @return paginator over the list of api keys
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public Paginator<ApiKey> allApiKeys(@Nullable ApiKeyListOptions options,
                                        @NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).allApiKeys(options, policyGroup);
    }

    /**
     * Creates a {@link Paginator} for the list of api keys matching filter options.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#allApiKeys(String, com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListOptions)}
     * 
     * @param id
     *            The ID of the group.
     * @param options
     *            list options.
     * @return paginator over the list of api keys
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public Paginator<ApiKey> allApiKeys(@NonNull String id,
                                        @Nullable ApiKeyListOptions options) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).allApiKeys(id, options);
    }

    /**
     * Creates a {@link Paginator} for the list of users matching filter options.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#allUsers(String, com.arm.mbed.cloud.sdk.accounts.model.UserListOptions)}
     * 
     * @param id
     *            The ID of the group.
     * @param options
     *            list options.
     * @return paginator over the list of users
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public Paginator<User> allUsers(@NonNull String id, @Nullable UserListOptions options) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).allUsers(id, options);
    }

    /**
     * Creates a {@link Paginator} for the list of users matching filter options.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#allUsers(com.arm.mbed.cloud.sdk.accounts.model.UserListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @return paginator over the list of users
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public Paginator<User> allUsers(@Nullable UserListOptions options) throws MbedCloudException {
        return allUsers(options, getModel());
    }

    /**
     * Creates a {@link Paginator} for the list of users matching filter options.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#allUsers(com.arm.mbed.cloud.sdk.accounts.model.UserListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @param policyGroup
     *            a policy group.
     * @return paginator over the list of users
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public Paginator<User> allUsers(@Nullable UserListOptions options,
                                    @NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).allUsers(options, policyGroup);
    }

    /**
     * Get the API keys of a group.
     * 
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#apiKeys(com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @return the list of api keys corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ListResponse<ApiKey> apiKeys(@Nullable ApiKeyListOptions options) throws MbedCloudException {
        return apiKeys(options, getModel());
    }

    /**
     * Get the API keys of a group.
     * 
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#apiKeys(com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @param policyGroup
     *            a policy group.
     * @return the list of api keys corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ListResponse<ApiKey> apiKeys(@Nullable ApiKeyListOptions options,
                                        @NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).apiKeys(options, policyGroup);
    }

    /**
     * Get the API keys of a group.
     * 
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#apiKeys(String, com.arm.mbed.cloud.sdk.accounts.model.ApiKeyListOptions)}
     * 
     * @param id
     *            The ID of the group.
     * @param options
     *            list options.
     * @return the list of api keys corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ListResponse<ApiKey> apiKeys(@NonNull String id,
                                        @Nullable ApiKeyListOptions options) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).apiKeys(id, options);
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
    public PolicyGroupDao clone() {
        try {
            return new PolicyGroupDao().configureAndGet(getModuleOrThrow() == null ? null : getModuleOrThrow().clone());
        } catch (MbedCloudException exception) {
            return null;
        }
    }

    /**
     * Adds a policy group.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#create(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @return an added policy group
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public PolicyGroup create() throws MbedCloudException {
        return create(getModel());
    }

    /**
     * Adds a policy group.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#create(java.lang.Object, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param members
     *            Represents arrays of user and API key IDs.
     * @return an added policy group
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public PolicyGroup create(@Nullable Object members) throws MbedCloudException {
        return create(members, getModel());
    }

    /**
     * Adds a policy group.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#createPolicyGroup(java.lang.Object, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param members
     *            Represents arrays of user and API key IDs.
     * @param policyGroup
     *            a policy group.
     * @return an added policy group
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public PolicyGroup create(@Nullable Object members, @NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).createPolicyGroup(members, policyGroup));
    }

    /**
     * Adds a policy group.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#createPolicyGroup(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param policyGroup
     *            a policy group.
     * @return an added policy group
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public PolicyGroup create(@NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).createPolicyGroup(policyGroup));
    }

    /**
     * Deletes a policy group.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#delete(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public void delete() throws MbedCloudException {
        delete(getModel());
    }

    /**
     * Deletes a policy group.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#deletePolicyGroup(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param policyGroup
     *            a policy group.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public void delete(@NonNull PolicyGroup policyGroup) throws MbedCloudException {
        ((Accounts) getModuleOrThrow()).deletePolicyGroup(policyGroup);
    }

    /**
     * Deletes a policy group.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Accounts#deletePolicyGroup(String)}
     * 
     * @param id
     *            The ID of the group to delete.
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public void delete(@NonNull String id) throws MbedCloudException {
        ((Accounts) getModuleOrThrow()).deletePolicyGroup(id);
    }

    /**
     * Instantiates model.
     * 
     * @return instantiated model
     */
    @Override
    @Internal
    protected PolicyGroup instantiateModel() {
        return new PolicyGroup();
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
     * Gets a policy group.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#read(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public PolicyGroup read() throws MbedCloudException {
        return read(getModel());
    }

    /**
     * Gets a policy group.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#readPolicyGroup(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param policyGroup
     *            a policy group.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public PolicyGroup read(@NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).readPolicyGroup(policyGroup));
    }

    /**
     * Gets a policy group.
     * 
     * <p>
     * Similar to {@link com.arm.mbed.cloud.sdk.Accounts#readPolicyGroup(String)}
     * 
     * @param id
     *            The ID of the group.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public PolicyGroup read(@NonNull String id) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).readPolicyGroup(id));
    }

    /**
     * Modifies a policy group.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#update(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public PolicyGroup update() throws MbedCloudException {
        return update(getModel());
    }

    /**
     * Modifies a policy group.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#updatePolicyGroup(com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param policyGroup
     *            a policy group.
     * @return something
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    @Override
    public PolicyGroup update(@NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).updatePolicyGroup(policyGroup));
    }

    /**
     * Modifies a policy group.
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#update(String, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param id
     *            The ID of the group.
     * @return an updated policy group
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public PolicyGroup update(@NonNull String id) throws MbedCloudException {
        return update(id, getModel());
    }

    /**
     * Modifies a policy group.
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#updatePolicyGroup(String, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param id
     *            The ID of the group.
     * @param policyGroup
     *            a policy group.
     * @return an updated policy group
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public PolicyGroup update(@NonNull String id, @NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return setAndGetModel(((Accounts) getModuleOrThrow()).updatePolicyGroup(id, policyGroup));
    }

    /**
     * Get users of a group.
     * 
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#users(String, com.arm.mbed.cloud.sdk.accounts.model.UserListOptions)}
     * 
     * @param id
     *            The ID of the group.
     * @param options
     *            list options.
     * @return the list of users corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ListResponse<User> users(@NonNull String id, @Nullable UserListOptions options) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).users(id, options);
    }

    /**
     * Get users of a group.
     * 
     * 
     * <p>
     * Note: uses internal data model
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.accounts.model.PolicyGroupDao#users(com.arm.mbed.cloud.sdk.accounts.model.UserListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @return the list of users corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ListResponse<User> users(@Nullable UserListOptions options) throws MbedCloudException {
        return users(options, getModel());
    }

    /**
     * Get users of a group.
     * 
     * 
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.Accounts#users(com.arm.mbed.cloud.sdk.accounts.model.UserListOptions, com.arm.mbed.cloud.sdk.accounts.model.PolicyGroup)}
     * 
     * @param options
     *            list options.
     * @param policyGroup
     *            a policy group.
     * @return the list of users corresponding to filter options (One page).
     * @throws MbedCloudException
     *             if an error occurs during the process.
     */
    public ListResponse<User> users(@Nullable UserListOptions options,
                                    @NonNull PolicyGroup policyGroup) throws MbedCloudException {
        return ((Accounts) getModuleOrThrow()).users(options, policyGroup);
    }
}
