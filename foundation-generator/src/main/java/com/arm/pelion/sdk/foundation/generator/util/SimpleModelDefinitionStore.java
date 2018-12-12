package com.arm.pelion.sdk.foundation.generator.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.model.Model;

public class SimpleModelDefinitionStore<T extends Model> implements ModelDefinitionStore<T> {

    private final Map<String, T> store;

    public SimpleModelDefinitionStore() {
        store = new LinkedHashMap<>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.pelion.sdk.foundation.generator.util.IModelDefinitionStore#store(T)
     */
    @Override
    public Model store(T model) {
        if (model == null || model.getIdentifier() == null) {
            return null;
        }
        store.put(model.getIdentifier(), model);
        return model;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.pelion.sdk.foundation.generator.util.IModelDefinitionStore#clear()
     */
    @Override
    public void clear() {
        store.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.pelion.sdk.foundation.generator.util.IModelDefinitionStore#has(java.lang.String)
     */
    @Override
    public boolean has(String identifier) {
        return identifier == null ? false : store.containsKey(identifier);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.arm.pelion.sdk.foundation.generator.util.IModelDefinitionStore#has(com.arm.pelion.sdk.foundation.generator.
     * model.Model)
     */
    @Override
    public boolean has(Model model) {
        return model == null ? false : has(model.getIdentifier());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.pelion.sdk.foundation.generator.util.IModelDefinitionStore#get(java.lang.String)
     */
    @Override
    public T get(String identifier) {
        return identifier == null ? null : store.get(identifier);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.arm.pelion.sdk.foundation.generator.util.IModelDefinitionStore#get(com.arm.pelion.sdk.foundation.generator.
     * model.Model)
     */
    @Override
    public T get(Model model) {
        return model == null ? null : get(model.getIdentifier());
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.pelion.sdk.foundation.generator.util.IModelDefinitionStore#getModels()
     */
    @Override
    public List<T> getModels() {
        return new ArrayList<>(store.values());
    }
}
