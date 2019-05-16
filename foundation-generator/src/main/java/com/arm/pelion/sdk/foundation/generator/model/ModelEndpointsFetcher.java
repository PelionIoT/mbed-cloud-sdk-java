package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;

public class ModelEndpointsFetcher extends ArtifactFetcher<ModelEndpoints> {

    public ModelEndpointsFetcher(ModelDefinitionStore<ModelEndpoints> store) {
        super(store);
    }

    public ModelEndpoints fetch(String group) {
        return store.get(ModelEndpoints.generateName(group));
    }

}
