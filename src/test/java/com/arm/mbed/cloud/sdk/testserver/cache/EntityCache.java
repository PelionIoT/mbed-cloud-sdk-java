package com.arm.mbed.cloud.sdk.testserver.cache;

import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.EntityInstance;

public class EntityCache extends InstanceCache<EntityInstance> {

    public EntityCache(String entity, SharedData cache) throws ServerCacheException {
        super(entity, cache);
    }

}
