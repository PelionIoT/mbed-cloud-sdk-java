package com.arm.mbed.cloud.sdk.subscribe.store;

import java.lang.ref.WeakReference;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.Observer;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotifications;
import com.arm.mbed.cloud.sdk.subscribe.model.AllNotificationsObserver;

@Preamble(description = "Store for all notification observers")
@Internal
public class AllNotificationObserverStore extends AbstractSubscriptionObserverStore<AllNotifications> {

    public AllNotificationObserverStore(Scheduler scheduler, WeakReference<SubscriptionManager> parent) {
        super(SubscriptionType.ALL, scheduler, parent);
    }

    @Override
    protected Observer<?> buildObserver(String channelId, Flowable<AllNotifications> flow, FilterOptions filter,
                                        CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                                        CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription,
                                        boolean notifyOtherObservers, Resource correspondingResource) {
        return new AllNotificationsObserver(this, channelId, flow);
    }

}
