package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.LinkedHashMap;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.model.Model;

public class ModelDefinitionStore {

    private final Map<String, Model> store;

    public static ModelDefinitionStore get() {
        return ModelDefinitionStoreHolder.INSTANCE;
    }

    private static class ModelDefinitionStoreHolder {
        public static final ModelDefinitionStore INSTANCE = new ModelDefinitionStore();

    }

    private ModelDefinitionStore() {
        store = new LinkedHashMap<>();
    }

    public Model store(Model model) {
        if (model == null) {
            return null;
        }
        store.put(model.getIdentifier(), model);
        return model;
    }

    public void clear() {
        store.clear();
    }

    public boolean has(String identifier) {
        return identifier == null ? false : store.containsKey(identifier);
    }

    public boolean has(Model model) {
        return model == null ? false : has(model.getIdentifier());
    }

    public Model get(String identifier) {
        return identifier == null ? null : store.get(identifier);
    }

    public Model get(Model model) {
        return model == null ? null : store.get(model.getIdentifier());
    }

}
