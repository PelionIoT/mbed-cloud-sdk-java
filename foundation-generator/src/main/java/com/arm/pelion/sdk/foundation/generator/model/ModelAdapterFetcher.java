package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;

public class ModelAdapterFetcher extends ArtifactFetcher<ModelAdapter> {

    private final ArtifactFetcher<Model> modelFetcher;

    public ModelAdapterFetcher(ModelDefinitionStore<ModelAdapter> store, ArtifactFetcher<Model> modelFetcher) {
        super(store);
        this.modelFetcher = modelFetcher;
    }

    public ModelAdapter fetch(TypeParameter fromFieldType, TypeParameter toFieldType) {
        try {
            fromFieldType.translate();
        } catch (Exception exception) {
            // Nothing to do;
        }

        try {
            toFieldType.translate();
        } catch (Exception exception) {
            // Nothing to do;
        }
        if (fromFieldType.isModel()) {
            final ModelAdapter adapter = fetchAdapter(fromFieldType.getShortName());
            if (adapter == null) {
                return null;
            }
            adapter.addDefaultConversion(fetchModel(fromFieldType),
                                         toFieldType.isModel() ? fetchModel(toFieldType)
                                                               : new Model(toFieldType.getClazz()));
            return adapter;
        }
        if (toFieldType.isModel()) {
            final ModelAdapter adapter = fetchAdapter(toFieldType.getShortName());
            if (adapter == null) {
                return null;
            }
            adapter.addDefaultConversion(new Model(fromFieldType.getClazz()), fetchModel(toFieldType));
            return adapter;
        }
        return null;
    }

    protected Model fetchModel(TypeParameter modelType) {
        return modelFetcher.fetch(modelType);
    }

    protected ModelAdapter fetchAdapter(String correspondingModelIdentifier) {
        return store.get(ModelAdapter.generateName(correspondingModelIdentifier));
    }

}
