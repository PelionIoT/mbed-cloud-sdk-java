package com.arm.mbed.cloud.sdk.testserver.cache;

import java.util.List;

import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance;

public interface InstanceCache<T extends TestedItem> {

    TestedItemInstance<T> fetchInstance(String id) throws MissingInstanceException;

    String getReference();

    void clear();

    void deleteInstance(String id) throws MissingInstanceException;

    void storeInstance(TestedItemInstance<?> instance) throws ServerCacheException;

    List<TestedItemInstance<?>> fetchAllInstances();

}
