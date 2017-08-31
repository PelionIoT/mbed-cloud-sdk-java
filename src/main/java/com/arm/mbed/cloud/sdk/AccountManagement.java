package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.accountmanagement.adapters.AccountAdapter;
import com.arm.mbed.cloud.sdk.accountmanagement.adapters.ApiKeyAdapter;
import com.arm.mbed.cloud.sdk.accountmanagement.adapters.GroupAdapter;
import com.arm.mbed.cloud.sdk.accountmanagement.adapters.UserAdapter;
import com.arm.mbed.cloud.sdk.accountmanagement.model.Account;
import com.arm.mbed.cloud.sdk.accountmanagement.model.ApiKey;
import com.arm.mbed.cloud.sdk.accountmanagement.model.ApiKeyListOptions;
import com.arm.mbed.cloud.sdk.accountmanagement.model.EndPoints;
import com.arm.mbed.cloud.sdk.accountmanagement.model.Group;
import com.arm.mbed.cloud.sdk.accountmanagement.model.User;
import com.arm.mbed.cloud.sdk.accountmanagement.model.UserListOptions;
import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractAPI;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.internal.iam.model.AccountInfo;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.ApiKeyInfoRespList;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummary;
import com.arm.mbed.cloud.sdk.internal.iam.model.GroupSummaryList;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoResp;
import com.arm.mbed.cloud.sdk.internal.iam.model.UserInfoRespList;

import retrofit2.Call;

@Preamble(description = "Specifies account management API")
@Module
/**
 * API exposing functionality for creating and managing accounts, users, groups and API keys in the organisation.
 */
public class AccountManagement extends AbstractAPI {

    private static final String TAG_USER_UUID = "user UUID";
    private static final String TAG_API_KEY_UUID = "apiKey UUID";
    private static final String TAG_API_KEY = "apiKey";
    private static final String TAG_ACCOUNT = "account";
    private static final String TAG_API_KEY_ID = "apiKeyId";
    private static final String TAG_USER_ID = "userId";
    private static final String TAG_USER = "user";
    private static final String TAG_GROUP_ID = "groupId";
    private final EndPoints endpoint;

    /**
     * 
     * @param options
     *            connection options
     */
    public AccountManagement(ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Gets details of account associated with current API key
     * 
     * @return account details
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Account getAccount() throws MbedCloudException {
        return CloudCaller.call(this, "getAccount()", AccountAdapter.getMapper(), new CloudCall<AccountInfo>() {

            @Override
            public Call<AccountInfo> call() {
                return endpoint.getDeveloper().getMyAccountInfo("limits, policies");
            }
        });
    }

    /**
     * Updates details of account associated with current API key
     * 
     * @param account
     *            The account object to update
     * @return updated account
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Account updateAccount(@NonNull Account account) throws MbedCloudException {
        checkNotNull(account, TAG_ACCOUNT);
        final Account finalAccount = account;
        return CloudCaller.call(this, "updateAccount()", AccountAdapter.getMapper(), new CloudCall<AccountInfo>() {

            @Override
            public Call<AccountInfo> call() {
                return endpoint.getAdmin().updateMyAccount(AccountAdapter.reverseMap(finalAccount));
            }
        });
    }

    /**
     * Lists all API keys according to filter options
     * 
     * @param options
     *            filter options
     * @return The list of API keys corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<ApiKey> listApiKeys(@Nullable ApiKeyListOptions options) throws MbedCloudException {
        final ApiKeyListOptions finalOptions = (options == null) ? new ApiKeyListOptions() : options;

        return CloudCaller.call(this, "listApiKeys()", ApiKeyAdapter.getListMapper(),
                new CloudCall<ApiKeyInfoRespList>() {

                    @Override
                    public Call<ApiKeyInfoRespList> call() {
                        return endpoint.getDeveloper().getAllApiKeys(finalOptions.getLimit(), finalOptions.getAfter(),
                                finalOptions.getOrder().toString(), finalOptions.encodeInclude(),
                                finalOptions.encodeSingleEqualFilter(ApiKeyListOptions.OWNER_ID_FILTER));
                    }
                });
    }

    /**
     * Gets an iterator over all API keys according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of API keys corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<ApiKey> listAllApiKeys(@Nullable ApiKeyListOptions options) throws MbedCloudException {
        final ApiKeyListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<ApiKey>() {

            @Override
            public ListResponse<ApiKey> requestNewPage() throws MbedCloudException {
                return listApiKeys(finalOptions);
            }
        });
    }

    /**
     * Get details of an API key
     * 
     * @param apiKeyId
     *            The API key ID (if not specified, returns current API key)
     * @return the API key
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ApiKey getApiKey(@NonNull String apiKeyId) throws MbedCloudException {
        checkNotNull(apiKeyId, TAG_API_KEY_ID);
        final String finalApiKeyId = apiKeyId;
        return CloudCaller.call(this, "getApiKey()", ApiKeyAdapter.getMapper(), new CloudCall<ApiKeyInfoResp>() {

            @Override
            public Call<ApiKeyInfoResp> call() {
                return (finalApiKeyId == null || finalApiKeyId.isEmpty()) ? endpoint.getDeveloper().getMyApiKey()
                        : endpoint.getDeveloper().getApiKey(finalApiKeyId);
            }
        });
    }

    /**
     * Adds an API key
     * 
     * @param apiKey
     *            The API key to add
     * @return added API Key
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @NonNull ApiKey addApiKey(@NonNull ApiKey apiKey) throws MbedCloudException {
        checkNotNull(apiKey, TAG_API_KEY);
        final ApiKey finalApiKey = apiKey;
        return CloudCaller.call(this, "addApiKey()", ApiKeyAdapter.getMapper(), new CloudCall<ApiKeyInfoResp>() {

            @Override
            public Call<ApiKeyInfoResp> call() {
                return endpoint.getDeveloper().createApiKey(ApiKeyAdapter.reverseMapAdd(finalApiKey));
            }
        });
    }

    /**
     * Updates an API key
     * 
     * @param apiKey
     *            The API key to update
     * @return updated API key
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ApiKey updateApiKey(@NonNull ApiKey apiKey) throws MbedCloudException {
        checkNotNull(apiKey, TAG_API_KEY);
        checkNotNull(apiKey.getId(), TAG_API_KEY_UUID);
        final ApiKey finalApiKey = apiKey;
        return CloudCaller.call(this, "updateApiKey()", ApiKeyAdapter.getMapper(), new CloudCall<ApiKeyInfoResp>() {

            @Override
            public Call<ApiKeyInfoResp> call() {
                return endpoint.getDeveloper().updateApiKey(finalApiKey.getId(), ApiKeyAdapter.reverseMapUpdate(finalApiKey));
            }
        });
    }

    /**
     * Deletes an API key
     * 
     * @param apiKeyId
     *            The API key ID
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteApiKey(@NonNull String apiKeyId) throws MbedCloudException {
        checkNotNull(apiKeyId, TAG_API_KEY_ID);
        final String finalApiKeyId = apiKeyId;
        CloudCaller.call(this, "deleteApiKey()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getDeveloper().deleteApiKey(finalApiKeyId);
            }
        });
    }

    /**
     * Lists users according to filter options
     * 
     * @param options
     *            filter options
     * @return list of users (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<User> listUsers(@Nullable UserListOptions options) throws MbedCloudException {
        final UserListOptions finalOptions = (options == null) ? new UserListOptions() : options;
        return CloudCaller.call(this, "listUsers()", UserAdapter.getListMapper(), new CloudCall<UserInfoRespList>() {

            @Override
            public Call<UserInfoRespList> call() {
                return endpoint.getAdmin().getAllUsers(finalOptions.getLimit(), finalOptions.getAfter(),
                        finalOptions.getOrder().toString(), finalOptions.encodeInclude(),
                        finalOptions.encodeSingleEqualFilter(UserListOptions.STATUS_FILTER));
            }
        });
    }

    /**
     * Gets an iterator over all users according to filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the list of users corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<User> listAllApiKeys(@Nullable UserListOptions options) throws MbedCloudException {
        final UserListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<User>() {

            @Override
            public ListResponse<User> requestNewPage() throws MbedCloudException {
                return listUsers(finalOptions);
            }
        });
    }

    /**
     * Gets details about a user
     * 
     * @param userId
     *            The user ID
     * @return a user
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable User getUser(@NonNull String userId) throws MbedCloudException {
        checkNotNull(userId, TAG_USER_ID);
        final String finalUserId = userId;
        return CloudCaller.call(this, "getUser()", UserAdapter.getMapper(), new CloudCall<UserInfoResp>() {

            @Override
            public Call<UserInfoResp> call() {
                return endpoint.getAdmin().getUser(finalUserId);
            }
        });
    }

    /**
     * Adds a user
     * 
     * @param user
     *            User to add
     * @return added user
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @NonNull User addUser(@NonNull User user) throws MbedCloudException {
        checkNotNull(user, TAG_USER);
        final User finalUser = user;
        return CloudCaller.call(this, "addUser()", UserAdapter.getMapper(), new CloudCall<UserInfoResp>() {

            @Override
            public Call<UserInfoResp> call() {
                return endpoint.getAdmin().createUser(UserAdapter.reverseMapAdd(finalUser), "create");
            }
        });
    }

    /**
     * Updates a user
     * 
     * @param user
     *            User to update
     * @return updated user
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable User updateUser(@NonNull User user) throws MbedCloudException {
        checkNotNull(user, TAG_USER);
        checkNotNull(user.getId(), TAG_USER_UUID);
        final User finalUser = user;
        return CloudCaller.call(this, "updateUser()", UserAdapter.getMapper(), new CloudCall<UserInfoResp>() {

            @Override
            public Call<UserInfoResp> call() {
                return endpoint.getAdmin().updateUser(finalUser.getId(), UserAdapter.reverseMapUpdate(finalUser));
            }
        });
    }

    /**
     * Deletes a user
     * 
     * @param userId
     *            The user ID of the user to delete
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public void deleteUser(@NonNull String userId) throws MbedCloudException {
        checkNotNull(userId, TAG_USER_ID);
        final String finalUserId = userId;
        CloudCaller.call(this, "deleteUser()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getAdmin().deleteUser(finalUserId);
            }
        });
    }

    /**
     * Lists available groups depending on filter options
     * 
     * @param options
     *            filter options
     * @return The list of groups corresponding to filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<Group> listGroups(@Nullable ListOptions options) throws MbedCloudException {
        final ListOptions finalOptions = (options == null) ? new ListOptions() : options;
        return CloudCaller.call(this, "listGroups()", GroupAdapter.getListMapper(), new CloudCall<GroupSummaryList>() {

            @Override
            public Call<GroupSummaryList> call() {
                return endpoint.getDeveloper().getAllGroups(finalOptions.getLimit(), finalOptions.getAfter(),
                        finalOptions.getOrder().toString(), finalOptions.encodeInclude());
            }
        });
    }

    /**
     * Gets an iterator over all available groups depending on filter options
     * 
     * @param options
     *            filter options
     * @return paginator for the groups corresponding to filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<Group> listAllGroups(@Nullable ListOptions options) throws MbedCloudException {
        final ListOptions finalOptions = options;
        return new Paginator<>(new PageRequester<Group>() {

            @Override
            public ListResponse<Group> requestNewPage() throws MbedCloudException {
                return listGroups(finalOptions);
            }
        });
    }

    /**
     * Get details of a group
     * 
     * @param groupId
     *            The group ID to look for
     * @return corresponding group
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Group getGroup(@NonNull String groupId) throws MbedCloudException {
        checkNotNull(groupId, TAG_GROUP_ID);
        final String finalGroupId = groupId;
        return CloudCaller.call(this, "getGroup()", GroupAdapter.getMapper(), new CloudCall<GroupSummary>() {

            @Override
            public Call<GroupSummary> call() {
                return endpoint.getDeveloper().getGroupSummary(finalGroupId);
            }
        });
    }

    /**
     * Lists users of a group
     *
     * @param groupId
     *            The group ID
     * @param options
     *            filter options
     * @return The list of users corresponding to groupId and filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<User> listGroupUsers(@NonNull String groupId, @Nullable ListOptions options)
            throws MbedCloudException {
        checkNotNull(groupId, TAG_GROUP_ID);
        final ListOptions finalOptions = (options == null) ? new ListOptions() : options;
        final String finalGroupId = groupId;
        return CloudCaller.call(this, "listGroupUsers()", UserAdapter.getListMapper(),
                new CloudCall<UserInfoRespList>() {

                    @Override
                    public Call<UserInfoRespList> call() {
                        return endpoint.getAdmin().getUsersOfGroup(finalGroupId, finalOptions.getLimit(),
                                finalOptions.getAfter(), finalOptions.getOrder().toString(),
                                finalOptions.encodeInclude());
                    }
                });
    }

    /**
     * Gets an iterator over all users of a group
     *
     * @param groupId
     *            The group ID of the group
     * @param options
     *            filter options
     * @return paginator for the list of users corresponding to groupId and filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<User> listAllGroupUsers(@NonNull String groupId, @Nullable ListOptions options)
            throws MbedCloudException {
        final ListOptions finalOptions = options;
        final String finalGroupId = groupId;
        return new Paginator<>(new PageRequester<User>() {

            @Override
            public ListResponse<User> requestNewPage() throws MbedCloudException {
                return listGroupUsers(finalGroupId, finalOptions);
            }
        });
    }

    /**
     * Lists API keys of a group
     * 
     * @param groupId
     *            The group ID of the group
     * @param options
     *            filter options
     * @return The list of API keys corresponding to groupId and filter options (One page)
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable ListResponse<ApiKey> listGroupApiKeys(@NonNull String groupId, @Nullable ListOptions options)
            throws MbedCloudException {
        checkNotNull(groupId, TAG_GROUP_ID);
        final ListOptions finalOptions = (options == null) ? new ListOptions() : options;
        final String finalGroupId = groupId;
        return CloudCaller.call(this, "listGroupApiKeys()", ApiKeyAdapter.getListMapper(),
                new CloudCall<ApiKeyInfoRespList>() {

                    @Override
                    public Call<ApiKeyInfoRespList> call() {
                        return endpoint.getDeveloper().getApiKeysOfGroup(finalGroupId, finalOptions.getLimit(),
                                finalOptions.getAfter(), finalOptions.getOrder().toString(),
                                finalOptions.encodeInclude());
                    }
                });
    }

    /**
     * Gets an iterator over all API keys of a group
     *
     * @param groupId
     *            The group ID of the group
     * @param options
     *            filter options
     * @return paginator for the list of API keys corresponding to groupId and filter options
     * @throws MbedCloudException
     *             if a problem occurred during request processing
     */
    @API
    public @Nullable Paginator<ApiKey> listAllGroupApiKeys(@NonNull String groupId, @Nullable ListOptions options)
            throws MbedCloudException {
        final ListOptions finalOptions = options;
        final String finalGroupId = groupId;
        return new Paginator<>(new PageRequester<ApiKey>() {

            @Override
            public ListResponse<ApiKey> requestNewPage() throws MbedCloudException {
                return listGroupApiKeys(finalGroupId, finalOptions);
            }
        });
    }

}
