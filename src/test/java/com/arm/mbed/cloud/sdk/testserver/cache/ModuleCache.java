package com.arm.mbed.cloud.sdk.testserver.cache;

import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.APIModule;

public class ModuleCache extends AbstractInstanceCache<APIModule> {

    public ModuleCache(String module, SharedData cache) throws ServerCacheException {
        super(module, cache);
    }

}
