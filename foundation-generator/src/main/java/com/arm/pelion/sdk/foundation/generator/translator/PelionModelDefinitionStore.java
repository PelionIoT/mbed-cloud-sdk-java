package com.arm.pelion.sdk.foundation.generator.translator;

import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;

public class PelionModelDefinitionStore {

    private final ModelDefinitionStore<Model> store;

    public static PelionModelDefinitionStore get() {
        return ModelDefinitionStoreHolder.INSTANCE;
    }

    private static class ModelDefinitionStoreHolder {
        public static final PelionModelDefinitionStore INSTANCE = new PelionModelDefinitionStore();

    }

    private PelionModelDefinitionStore() {
        store = new ModelDefinitionStore<>();
    }

    public Model store(Model model) {
        return store.store(model);
    }

    public void clear() {
        store.clear();
    }

    public boolean has(String identifier) {
        return store.has(identifier);
    }

    public boolean has(Model model) {
        return store.has(model);
    }

    public Model get(String identifier) {
        return store.get(identifier);
    }

    public Model get(Model model) {
        return store.get(model);
    }

}
