package com.arm.mbed.cloud.sdk.connect.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.common.TimePeriod;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceEchoApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DeviceRequestsApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.EndpointsApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.NotificationsApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.ResourcesApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.StatisticsApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.SubscriptionsApi;

@Preamble(description = "Endpoint for Connect API")
@Internal
public class EndPoints extends AbstractEndpoints {

    private final DeviceRequestsApi async;
    private final EndpointsApi endpoint;
    private final NotificationsApi notifications;
    private final ResourcesApi resources;
    private final SubscriptionsApi subscriptions;
    private final StatisticsApi statistic;
    private final DeviceEchoApi deviceEcho;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     * 
     */
    public EndPoints(ServiceRegistry services) {
        super(services);
        this.async = initialiseService(DeviceRequestsApi.class);
        this.endpoint = initialiseService(EndpointsApi.class);
        this.notifications = initialiseService(NotificationsApi.class);
        this.resources = initialiseService(ResourcesApi.class);
        this.subscriptions = initialiseService(SubscriptionsApi.class);
        this.statistic = initialiseService(StatisticsApi.class);
        this.deviceEcho = initialiseService(DeviceEchoApi.class);
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

    public StatisticsApi getStatistic() {
        return statistic;
    }

    public DeviceEchoApi getDeviceEcho() {
        return deviceEcho;
    }

    public ConnectionOptions getConnectionConfiguration() {
        return getConfiguration();
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
        return new EndPoints(getRegistryClone());
    }

}
