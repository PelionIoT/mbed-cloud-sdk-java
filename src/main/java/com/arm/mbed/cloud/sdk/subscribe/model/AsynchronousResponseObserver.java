package com.arm.mbed.cloud.sdk.subscribe.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.CallbackWithException;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.subscribe.AbstractObserver;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionManager;
import com.arm.mbed.cloud.sdk.subscribe.SubscriptionType;
import com.arm.mbed.cloud.sdk.subscribe.adapters.AsynchronousResponseNotificationAdapter;

@Preamble(description = "Asynchronous response observer")
public class AsynchronousResponseObserver extends AbstractObserver<AsynchronousResponseNotification> {
    private final Resource correspondingResource;

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
     * @param notifyResourceValueObservers
     *            notifyResourceValueObservers
     * @param correspondingResource
     *            correspondingResource
     */
    public AsynchronousResponseObserver(SubscriptionManager manager, String id,
                                        Flowable<AsynchronousResponseNotification> flow,
                                        AsynchronousResponseFilterOptions filter,
                                        CallbackWithException<FilterOptions, MbedCloudException> actionOnSubscription,
                                        CallbackWithException<FilterOptions, MbedCloudException> actionOnUnsubscription,
                                        boolean notifyResourceValueObservers, Resource correspondingResource) {
        super(manager, id, flow, filter, true, actionOnSubscription, actionOnUnsubscription);
        this.correspondingResource = correspondingResource;
        if (notifyResourceValueObservers && correspondingResource != null) {
            notifyResourceValueObservers();
        }
    }

    @Override
    protected boolean verifiesFilter(AsynchronousResponseNotification notification) {
        if (filter == null) {
            return true;
        }
        return ((AsynchronousResponseFilterOptions) filter).isVerified(notification);
    }

    private void notifyResourceValueObservers() {
        flow().subscribe(new Consumer<AsynchronousResponseNotification>() {

            @Override
            public void accept(AsynchronousResponseNotification notification) throws Exception {
                manager.notify(SubscriptionType.NOTIFICATION,
                               AsynchronousResponseNotificationAdapter.mapToResourceValueNotification(correspondingResource,
                                                                                                      notification));
            }
        });
    }

    /**
     * Gets the resource corresponding to this observer.
     *
     * @return the correspondingResource
     */
    public Resource getCorrespondingResource() {
        return correspondingResource;
    }

    @Override
    public SubscriptionType getSubscriptionType() {
        return SubscriptionType.ASYNCHRONOUS_RESPONSE;
    }
}
