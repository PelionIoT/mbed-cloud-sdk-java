package com.arm.mbed.cloud.sdk.subscribe.store;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueChangeNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.ResourceValueChangeObserver;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

@Preamble(description = "Store for resource value changes observers")
@Internal
public class ResourceValueChangeSubscriptionObserverStore
        extends AbstractSubscriptionObserverStore<ResourceValueChangeNotification> {

    public ResourceValueChangeSubscriptionObserverStore(Scheduler scheduler) {
        super(SubscriptionType.NOTIFICATION, scheduler);
    }

    @Override
    protected Observer<?> buildObserver(String channelId, Flowable<ResourceValueChangeNotification> flow,
            FilterOptions filter) {
        return new ResourceValueChangeObserver(this, channelId, flow, (SubscriptionFilterOptions) filter);
    }

}
