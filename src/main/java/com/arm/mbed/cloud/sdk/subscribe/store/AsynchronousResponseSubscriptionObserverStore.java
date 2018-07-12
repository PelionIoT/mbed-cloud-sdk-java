package com.arm.mbed.cloud.sdk.subscribe.store;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseFilterOptions;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseNotification;
import com.arm.mbed.cloud.sdk.subscribe.model.AsynchronousResponseObserver;

@Preamble(description = "Store for asynchronous response observers")
@Internal
public class AsynchronousResponseSubscriptionObserverStore extends
                                                           AbstractSubscriptionObserverStore<AsynchronousResponseNotification> {

    public AsynchronousResponseSubscriptionObserverStore(Scheduler scheduler) {
        super(SubscriptionType.ASYNCHRONOUS_RESPONSE, scheduler);
    }

    @Override
    protected Observer<?> buildObserver(String channelId, Flowable<AsynchronousResponseNotification> flow,
                                        FilterOptions filter,
                                        CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                                        CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription,
                                        boolean notifyOtherObservers, Resource correspondingResource) {
        return new AsynchronousResponseObserver(this, channelId, flow, (AsynchronousResponseFilterOptions) filter,
                                                actionOnSubscription, actionOnUnsubscription, notifyOtherObservers,
                                                correspondingResource);
    }

}
