package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.ModelPojo;
import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;
import com.arm.pelion.sdk.foundation.generator.util.SimpleModelDefinitionStore;

public class PelionModelDefinitionStore implements ModelDefinitionStore<ModelPojo> {

    private final ModelDefinitionStore<ModelPojo> store;
    private final GroupStore groupStore;

    public static PelionModelDefinitionStore get() {
        return ModelDefinitionStoreHolder.INSTANCE;
    }

    private static class ModelDefinitionStoreHolder {
        public static final PelionModelDefinitionStore INSTANCE = new PelionModelDefinitionStore();

    }

    private PelionModelDefinitionStore() {
        store = new SimpleModelDefinitionStore<>();
        groupStore = new GroupStore();
    }

    @Override
    public ModelPojo store(ModelPojo model) {
        return store.store(model);
    }

    @Override
    public void clear() {
        store.clear();
        groupStore.clear();
    }

    @Override
    public boolean has(String identifier) {
        return store.has(identifier);
    }

    @Override
    public boolean has(Model model) {
        return store.has(model);
    }

    @Override
    public ModelPojo get(String identifier) {
        return store.get(identifier);
    }

    @Override
    public ModelPojo get(Model model) {
        return store.get(model);
    }

    @Override
    public List<ModelPojo> getModels() {
        return store.getModels();
    }

    public boolean hasRelatedGroup(String identifier) {
        return groupStore.has(identifier);
    }

    public boolean hasRelatedGroup(Model model) {
        return groupStore.has(model);
    }

    public List<String> getRelatedGroup(String identifier) {
        return groupStore.get(identifier);
    }

    public List<String> getRelatedGroup(Model model) {
        return groupStore.get(model);
    }

    public void storeGroup(List<String> groupId, List<String> identifiers) {
        groupStore.store(groupId, identifiers);
    }

    public List<List<String>> getGroups() {
        return groupStore.getGroups();
    }

    public List<String> availableModels() {
        return groupStore.availableModels();
    }

    private static class GroupStore {

        private final Map<String, List<String>> store;

        public GroupStore() {
            super();
            store = new LinkedHashMap<>();
        }

        public void store(List<String> groupId, List<String> identifiers) {
            if (groupId == null || groupId.isEmpty() || identifiers == null || identifiers.isEmpty()) {
                return;
            }
            identifiers.forEach(id -> store.put(id, groupId));
        }

        public void clear() {
            store.clear();
        }

        public boolean has(String identifier) {
            return store.containsKey(identifier);
        }

        public boolean has(Model model) {
            return model == null ? false : has(model.getIdentifier());
        }

        public List<String> get(String identifier) {
            return store.get(identifier);
        }

        public List<String> get(Model model) {
            return model == null ? null : get(model.getIdentifier());
        }

        public List<List<String>> getGroups() {
            return new ArrayList<>(store.values());
        }

        public List<String> availableModels() {
            return new ArrayList<>(store.keySet());
        }
    }

}
