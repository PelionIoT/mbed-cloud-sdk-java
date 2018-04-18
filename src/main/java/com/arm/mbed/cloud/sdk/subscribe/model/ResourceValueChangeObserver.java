package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.subscribe.AbstractObserver;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;

import io.reactivex.Flowable;

@Preamble(description = "Resource value change observer")
public class ResourceValueChangeObserver extends AbstractObserver<ResourceValueChangeNotification> {

    /**
     * Constructor.
     *
     * @param manager
     *            manager
     * @param id
     *            observer id
     * @param flow
     *            flow
     * @param filter
     *            filter
     */
    public ResourceValueChangeObserver(SubscriptionManager manager, String id,
            Flowable<ResourceValueChangeNotification> flow, SubscriptionFilterOptions filter) {
        super(manager, id, flow, filter, true);
    }

    @Override
    protected boolean verifiesFilter(ResourceValueChangeNotification notification) {
        if (filter == null) {
            return true;
        }
        return ((SubscriptionFilterOptions) filter).isVerified(notification);
    }

    @Override
    public SubscriptionType getSubscriptionType() {
        return SubscriptionType.NOTIFICATION;
    }
}
