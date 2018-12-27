package com.arm.pelion.sdk.foundation.generator.util;

import java.util.List;

import com.arm.pelion.sdk.foundation.generator.model.Model;

public interface ModelDefinitionStore<T extends Model> {

    T store(T model);

    void clear();

    boolean has(String identifier);

    boolean has(Model model);

    T get(String identifier);

    T get(Model model);

    List<T> getModels();

}
