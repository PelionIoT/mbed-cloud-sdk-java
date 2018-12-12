package com.arm.pelion.sdk.foundation.generator.translator;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;
import com.arm.pelion.sdk.foundation.generator.util.SimpleModelDefinitionStore;

public class PelionModelDefinitionStore implements ModelDefinitionStore<Model> {

    private final ModelDefinitionStore<Model> store;

    public static PelionModelDefinitionStore get() {
        return ModelDefinitionStoreHolder.INSTANCE;
    }

    private static class ModelDefinitionStoreHolder {
        public static final PelionModelDefinitionStore INSTANCE = new PelionModelDefinitionStore();

    }

    private PelionModelDefinitionStore() {
        store = new SimpleModelDefinitionStore<>();
    }

    @Override
    public Model store(Model model) {
        return store.store(model);
    }

    @Override
    public void clear() {
        store.clear();
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
    public Model get(String identifier) {
        return store.get(identifier);
    }

    @Override
    public Model get(Model model) {
        return store.get(model);
    }

    @Override
    public List<Model> getModels() {
        return store.getModels();
    }

}
