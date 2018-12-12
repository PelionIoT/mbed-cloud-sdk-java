package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.ServiceStore;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.internal.mds.api.DeviceRequestsApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.EndpointsApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.NotificationsApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.ResourcesApi;
import com.arm.mbed.cloud.sdk.internal.mds.api.SubscriptionsApi;
import com.arm.mbed.cloud.sdk.internal.statistics.api.AccountApi;
import com.arm.mbed.cloud.sdk.internal.statistics.api.StatisticsApi;

@Preamble(description = "Endpoint for Connect API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DeviceRequestsApi async;
    private final EndpointsApi endpoint;
    private final NotificationsApi notifications;
    private final ResourcesApi resources;
    private final SubscriptionsApi subscriptions;
    private final AccountApi account;
    private final StatisticsApi statistic;
    private boolean forceClear;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceStore}.
     * 
     */
    public EndPoints(ServiceStore services) {
        super(services);
        this.async = initialiseService(DeviceRequestsApi.class);
        this.endpoint = initialiseService(EndpointsApi.class);
        this.notifications = initialiseService(NotificationsApi.class);
        this.resources = initialiseService(ResourcesApi.class);
        this.subscriptions = initialiseService(SubscriptionsApi.class);
        this.account = initialiseService(AccountApi.class);
        this.statistic = initialiseService(StatisticsApi.class);
        forceClear = false;
    }

    public DeviceRequestsApi getAsync() {
        return async;
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

    /**
     * States whether notification daemon will start automatically when needed.
     * 
     * @return true if daemon will be started automatically. False otherwise.
     */
    public boolean isAutostartDaemon() {
        final ConnectionOptions config = getConfiguration();
        return config == null ? false : config.isAutostartDaemon();
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

    /**
     * Sets a HTTP client request timeout different from default setting.
     * <p>
     * See {@link ConnectionOptions#setRequestTimeout(TimePeriod)}
     *
     * @param requestTimeout
     *            the requestTimeout to set
     */
    public void setRequestTimeout(TimePeriod requestTimeout) {
        final ConnectionOptions config = getConfiguration();
        if (config != null) {
            config.setRequestTimeout(requestTimeout);
        }
    }

    @Override
    public EndPoints clone() {
        return new EndPoints(getServicesClone());
    }

}
