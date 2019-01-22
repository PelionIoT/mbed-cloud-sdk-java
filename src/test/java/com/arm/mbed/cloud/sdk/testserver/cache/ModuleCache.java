package com.arm.mbed.cloud.sdk.testserver.cache;

import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.ModuleInstance;

public class ModuleCache extends InstanceCache<ModuleInstance> {

    public ModuleCache(String module, SharedData cache) throws ServerCacheException {
        super(module, cache);
    }

}
