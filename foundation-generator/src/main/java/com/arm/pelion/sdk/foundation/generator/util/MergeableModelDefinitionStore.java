package com.arm.pelion.sdk.foundation.generator.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.arm.pelion.sdk.foundation.generator.model.Model;
import com.arm.pelion.sdk.foundation.generator.model.ModelMergeable;

public class MergeableModelDefinitionStore<T extends ModelMergeable> implements ModelDefinitionStore<T> {

    private final Map<String, List<T>> store;

    public MergeableModelDefinitionStore() {
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
        List<T> list = store.get(model.getIdentifier());
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(model);
        store.put(model.getIdentifier(), list);
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
        // return identifier == null ? null : store.get(identifier).stream().findFirst().get();
        return identifier == null ? null : Utils.merge(store.get(identifier));
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
        return store.values().stream().map(l -> Utils.merge(l)).filter(o -> o != null).collect(Collectors.toList());
    }
}
