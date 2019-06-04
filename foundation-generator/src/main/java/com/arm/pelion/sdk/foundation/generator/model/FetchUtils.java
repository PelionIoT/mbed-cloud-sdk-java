package com.arm.pelion.sdk.foundation.generator.model;

public class FetchUtils {

    public FetchUtils() {
        // TODO Auto-generated constructor stub
    }

    // This is to ensure that if group id is null or incorrect the correct model is fetched
    public static Model getLatestModelDefinition(Model model, ModelAdapterFetcher fetcher) {
        if (fetcher == null || model == null) {
            return model;
        }
        try {
            model.toType().translate();
            if (model.toType().isModel()) {
                final Model latestModel = fetcher.fetchModel(model.toType());
                return latestModel == null ? model : latestModel;
            }
            return model;
        } catch (@SuppressWarnings("unused") Exception e) {
            // Nothing to do
            return model;
        }
    }
}
