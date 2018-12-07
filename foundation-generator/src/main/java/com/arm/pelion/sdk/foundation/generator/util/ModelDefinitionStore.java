package com.arm.pelion.sdk.foundation.generator.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.model.Model;

public class ModelDefinitionStore<T extends Model> {

    private final Map<String, T> store;

    public ModelDefinitionStore() {
        store = new LinkedHashMap<>();
    }

    public Model store(T model) {
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

    public T get(String identifier) {
        return identifier == null ? null : store.get(identifier);
    }

    public T get(Model model) {
        return model == null ? null : store.get(model.getIdentifier());
    }

    public List<T> getModels() {
        return new ArrayList<>(store.values());
    }
}
