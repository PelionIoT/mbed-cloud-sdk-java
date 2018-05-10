package com.arm.mbed.cloud.sdk.subscribe.model;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.AbstractObserver;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;

import io.reactivex.Flowable;

@Preamble(description = "Resource value observer")
public class ResourceValueObserver extends AbstractObserver<ResourceValueNotification> {

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
     * @param actionOnSubscription
     *            action on subscription
     * @param actionOnUnsubscription
     *            action on
     */
    public ResourceValueObserver(SubscriptionManager manager, String id, Flowable<ResourceValueNotification> flow,
            SubscriptionFilterOptions filter,
            CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
            CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription) {
        super(manager, id, flow, filter, true, actionOnSubscription, actionOnUnsubscription);
    }

    @Override
    protected boolean verifiesFilter(ResourceValueNotification notification) {
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
