package com.arm.mbed.cloud.sdk.subscribe.model;

import io.reactivex.Flowable;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.subscribe.AbstractObserver;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;

@Preamble(description = "Master observer: observer for all notifications from Pelion")
public class AllNotificationsObserver extends AbstractObserver<AllNotifications> {

    /**
     * Constructor.
     *
     * @param manager
     *            manager
     * @param id
     *            observer id
     * @param flow
     *            flow
     */
    public AllNotificationsObserver(SubscriptionManager manager, String id, Flowable<AllNotifications> flow) {
        super(manager, id, flow, null, true, null, null);
    }

    @Override
    protected boolean verifiesFilter(AllNotifications notification) {
        return true;
    }

    @Override
    public SubscriptionType getSubscriptionType() {
        return SubscriptionType.ALL;
    }
}
