package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.internal.mds.api.DefaultApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.EndpointsApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.NotificationsApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.ResourcesApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.SubscriptionsApi;
import com.arm.mbed.cloud.sdk.internal.statistics.api.AccountApi;
import com.arm.mbed.cloud.sdk.internal.statistics.api.StatisticsApi;

@Preamble(description = "Endpoint for Connect API")
@Internal
public class EndPoints {

    private final DefaultApi webhooks;
    private final EndpointsApi endpoint;
    private final NotificationsApi notifications;
    private final ResourcesApi resources;
    private final SubscriptionsApi subscriptions;
    private final AccountApi account;
    private final StatisticsApi statistic;
    private final ConnectionOptions connectionOptions;
    private final boolean autostartDaemon;
    private boolean forceClear;

    /**
     * Constructor.
     * 
     * @param wrapper
     *            API client {@link ApiClientWrapper}.
     *
     * @param autostartNotificationDaemon
     *            States whether notification daemon should be started automatically.
     */

    public EndPoints(ApiClientWrapper wrapper, boolean autostartNotificationDaemon) {
        super();
        this.connectionOptions = wrapper.getConnectionOptions();
        this.webhooks = initialiseWebhook(wrapper);
        this.endpoint = initialiseEndpoint(wrapper);
        this.notifications = initialiseNotification(wrapper);
        this.resources = initialiseResource(wrapper);
        this.subscriptions = initialiseSubscription(wrapper);
        this.account = initialiseAccount(wrapper);
        this.statistic = initialiseStatistic(wrapper);
        this.autostartDaemon = autostartNotificationDaemon;
        forceClear = false;
    }

    /**
     * Constructor.
     * 
     * @param options
     *            connection options {@link ConnectionOptions}.
     */
    public EndPoints(ConnectionOptions options) {
        this(new ApiClientWrapper(options), options.isAutostartDaemon());

    }

    private DefaultApi initialiseWebhook(ApiClientWrapper wrapper) {
        return wrapper.createService(DefaultApi.class);
    }

    private EndpointsApi initialiseEndpoint(ApiClientWrapper wrapper) {
        return wrapper.createService(EndpointsApi.class);
    }

    private NotificationsApi initialiseNotification(ApiClientWrapper wrapper) {
        return wrapper.createService(NotificationsApi.class);
    }

    private ResourcesApi initialiseResource(ApiClientWrapper wrapper) {
        return wrapper.createService(ResourcesApi.class);
    }

    private AccountApi initialiseAccount(ApiClientWrapper wrapper) {
        return wrapper.createService(AccountApi.class);
    }

    private StatisticsApi initialiseStatistic(ApiClientWrapper wrapper) {
        return wrapper.createService(StatisticsApi.class);
    }

    private SubscriptionsApi initialiseSubscription(ApiClientWrapper wrapper) {
        return wrapper.createService(SubscriptionsApi.class);
    }

    public DefaultApi getWebhooks() {
        return webhooks;
    }

    public EndpointsApi getEndpoints() {
        return endpoint;
    }

    public NotificationsApi getNotifications() {
        return notifications;
    }

    public ResourcesApi getResources() {
        return resources;
    }

    public SubscriptionsApi getSubscriptions() {
        return subscriptions;
    }

    public AccountApi getAccount() {
        return account;
    }

    public StatisticsApi getStatistic() {
        return statistic;
    }

    public ConnectionOptions getConnectionOptions() {
        return connectionOptions;
    }

    /**
     * States whether notification daemon will start automatically when needed.
     * 
     * @return true if daemon will be started automatically. False otherwise.
     */
    public boolean isAutostartDaemon() {
        return autostartDaemon;
    }

    /**
     * States whether any existing notification channel should be cleared before a new one is created.
     * 
     * @return True if the channel will be cleared. False otherwise.
     */
    public boolean isForceClear() {
        return forceClear;
    }

    /**
     * Sets whether any existing notification channel should be cleared before a new one is created.
     * 
     * @param forceClear
     *            True if the channel will be cleared. False otherwise.
     */
    public void setForceClear(boolean forceClear) {
        this.forceClear = forceClear;
    }

}
