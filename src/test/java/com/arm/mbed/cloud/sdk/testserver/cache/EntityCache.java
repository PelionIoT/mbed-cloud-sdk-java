package com.arm.mbed.cloud.sdk.testserver.cache;

import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.Entity;

public class EntityCache extends AbstractInstanceCache<Entity> {

    public EntityCache(String entity, SharedData cache) throws ServerCacheException {
        super(entity, cache);
    }

}
