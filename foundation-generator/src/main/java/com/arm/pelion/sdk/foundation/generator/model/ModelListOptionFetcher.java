package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;

public class ModelListOptionFetcher extends ArtifactFetcher<Model> {

    public ModelListOptionFetcher(ModelDefinitionStore<Model> store) {
        super(store);
    }

    public ModelListOption fetchFromAssociatedModel(TypeParameter associatedModel) {
        return (ModelListOption) store.get(ModelListOption.generateName(associatedModel.getShortName()));
    }

}
