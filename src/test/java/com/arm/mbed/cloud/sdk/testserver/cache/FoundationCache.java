package com.arm.mbed.cloud.sdk.testserver.cache;

import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.Foundation;

public class FoundationCache extends AbstractInstanceCache<Foundation> {

    public FoundationCache(String id, SharedData cache) throws ServerCacheException {
        super(id, cache);
    }

}
