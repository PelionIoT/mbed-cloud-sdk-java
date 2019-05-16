package com.arm.mbed.cloud.sdk.testserver.cache;

import java.util.LinkedList;
import java.util.List;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.SharedData;

import com.arm.mbed.cloud.sdk.testserver.internal.model.SdkDefinition;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItem;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemInstance;
import com.arm.mbed.cloud.sdk.testserver.internal.model.TestedItemType;

public class TestedItemRegistry {

    private static final String MODULES_MAP = "modules";
    private static final String FOUNDATION_MAP = "foundation";
    private static final String SDK_DEFINITION_REGISTRY = "sdk";
    private static final String MODULE_INSTANCES_REGISTRY = "module_instances";
    private static final String FOUNDATION_INSTANCES_REGISTRY = "foundation_instances";
    /**
     * 
     */
    private final SharedData cache;

    public TestedItemRegistry(Vertx vertx) {
        cache = vertx.sharedData();
    }

    public SdkDefinition fetchSDKDefinition() {
        JsonObject sdkJson = fetchSdkDefinitionCache().get(SDK_DEFINITION_REGISTRY);
        if (sdkJson == null) {
            return null;
        }
        return sdkJson.mapTo(SdkDefinition.class);
    }

    public void storeSDKDefinition(SdkDefinition sdk) throws ServerCacheException {
        if (sdk == null) {
            throw new ServerCacheException("SDK mapping has failed");
        }
        fetchSdkDefinitionCache().put(SDK_DEFINITION_REGISTRY, JsonObject.mapFrom(sdk));
    }

    public TestedItemInstance<?> fetchInstance(TestedItemType type, String itemName,
                                               String id) throws ServerCacheException {
        return fetchCache(type, itemName).fetchInstance(id);
    }

    public TestedItemInstance<?> fetchInstance(TestedItemType type, String id) throws ServerCacheException {
        String reference = fetchInstancesRegistry(type).get(id);
        if (reference == null) {
            throw new MissingInstanceException("No such instance [" + id + "] in cache");
        }
        return fetchInstance(type, reference, id);
    }

    public TestedItem fetchFromInstance(TestedItemType type, String instanceId) throws ServerCacheException,
                                                                                MissingInstanceException {
        String reference = fetchInstancesRegistry(type).get(instanceId);

        SdkDefinition sdk = fetchSDKDefinition();
        if (sdk == null) {
            throw new ServerCacheException("SDK mapping has failed");
        }
        if (reference == null) {
            throw new MissingInstanceException("Instance [" + instanceId + "] is invalid");
        }

        return sdk.getItem(type, reference);
    }

    public void storeInstance(TestedItemType type, TestedItemInstance<?> instance) throws ServerCacheException {
        if (type == null || instance == null || !instance.isValid()) {
            throw new ServerCacheException("Instance [" + instance + "] cannot be stored, as invalid");
        }
        fetchCache(type, instance.getReference()).storeInstance(instance);
        fetchInstancesCache(type).put(instance.getReference(), "");
        fetchInstancesRegistry(type).put(instance.getId(), instance.getReference());
    }

    public void deleteInstance(TestedItemType type, String id) throws ServerCacheException {
        String reference = fetchInstancesRegistry(type).get(id);
        deleteInstance(type, reference, id);
    }

    public void deleteInstance(TestedItemType type, String reference, String id) throws ServerCacheException {
        fetchCache(type, reference).deleteInstance(id);
        fetchInstancesRegistry(type).remove(id);
    }

    public void clearModuleCache(TestedItemType type, String reference) throws ServerCacheException {
        fetchCache(type, reference).clear();
        fetchInstancesCache(type).remove(reference);
    }

    public void clear() throws ServerCacheException {
        for (TestedItemType type : TestedItemType.values()) {
            clear(type);
        }
    }

    public void clear(TestedItemType type) throws ServerCacheException {
        for (Object reference : fetchInstancesCache(type).keySet()) {
            clearModuleCache(type, reference.toString());
        }
        fetchInstancesCache(type).clear();
        fetchInstancesRegistry(type).clear();
    }

    public List<TestedItemInstance<?>> listInstances(TestedItemType type, String itemName) throws ServerCacheException {
        return fetchCache(type, itemName).fetchAllInstances();
    }

    public List<TestedItemInstance<?>> listAllInstances(TestedItemType type) throws ServerCacheException {
        List<TestedItemInstance<?>> list = new LinkedList<>();
        for (Object reference : fetchInstancesCache(type).keySet()) {
            final List<TestedItemInstance<?>> sublist = listInstances(type, reference.toString());
            list.addAll(sublist);
        }
        return list;
    }

    private InstanceCache<?> fetchCache(TestedItemType type, String name) throws ServerCacheException {
        if (name == null || type == null) {
            throw new MissingInstanceException("A name or a type cannot be NULL");
        }
        switch (type) {
            case SDK:
            case ENTITY:
                return new FoundationCache(name, cache);
            case MODULE:
                return new ModuleCache(name, cache);
            default:
                return null;
        }
    }

    private LocalMap<Object, Object> fetchInstancesCache(TestedItemType type) {
        String id = null;
        switch (type) {
            case SDK:
            case ENTITY:
                id = FOUNDATION_MAP;
                break;
            case MODULE:
                id = MODULES_MAP;
                break;
            default:
                break;

        }
        return cache.getLocalMap(id);
    }

    private LocalMap<String, String> fetchInstancesRegistry(TestedItemType type) {
        String id = null;
        switch (type) {
            case SDK:
            case ENTITY:
                id = FOUNDATION_INSTANCES_REGISTRY;
                break;
            case MODULE:
                id = MODULE_INSTANCES_REGISTRY;
                break;
            default:
                break;

        }
        return cache.getLocalMap(id);
    }

    private LocalMap<Object, JsonObject> fetchSdkDefinitionCache() {
        return cache.getLocalMap(SDK_DEFINITION_REGISTRY);
    }

}
