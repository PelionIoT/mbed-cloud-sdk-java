package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class ArtifactFetcher<T extends Model> {
    protected final ModelDefinitionStore<T> store;

    public ArtifactFetcher(ModelDefinitionStore<T> store) {
        super();
        this.store = store;
    }

    public boolean has(TypeParameter modelType) {
        if (modelType == null) {
            return false;
        }
        try {
            modelType.translate();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
        return store.has(modelType.getShortName());
    }

    public T fetch(TypeParameter modelType) {
        if (modelType == null) {
            return null;
        }
        try {
            modelType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
            exception.printStackTrace();
            return null;
        }
        return store.get(modelType.getShortName());
    }

}
