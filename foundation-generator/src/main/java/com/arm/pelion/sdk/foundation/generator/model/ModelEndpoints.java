package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ApiUtils;

public class ModelEndpoints extends Model implements MergeableArtifact {

    public ModelEndpoints(Model model, String description, boolean needsCustomCode) {
        super(model.getPackageName(), generateName(model.getGroup()), model.getGroup(),
              generateDescription(model.getGroup(), description), null, false, true);
        setSuperClassType(TypeFactory.getCorrespondingType(AbstractEndpoints.class));
    }

    private static String generateDescription(String group, String description) {
        return description == null ? "Endpoints for " + group + " API module" : description;
    }

    private static String generateName(String group) {
        return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(group) + "_endpoints", true);
    }

    @Override
    protected boolean hasSuperInterface() {
        return false;
    }

    @Override
    protected boolean isSerialisable() {
        return false;
    }

    @Override
    protected void generateHashCodeAndEquals() {
        // Do not generate anything
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodEndpointsConstructorFromClient(this, theParent));
        overrideMethodIfExist(new MethodEndpointsClone(this, theParent));
    }

    public void addModule(Class<?> moduleClazz) {
        if (moduleClazz != null) {
            addField(new Field(true, TypeFactory.getCorrespondingType(moduleClazz), moduleClazz.getSimpleName(),
                               "Low level endpoints for " + ApiUtils.convertCamelToSnake(moduleClazz.getSimpleName())
                                                                    .replaceAll("_", " "),
                               null, null, isStatic, false, true, false, null, false));
        }

    }

    @Override
    public <T extends MergeableArtifact> void merge(T otherArtifact) {
        if (otherArtifact == null || this == otherArtifact || !(otherArtifact instanceof ModelEndpoints)) {
            return;
        }
        final ModelEndpoints otherEndpoints = (ModelEndpoints) otherArtifact;
        if (otherEndpoints.methods != null) {
            otherEndpoints.methods.values().forEach(m -> addMethod(m));
        }
        if (otherEndpoints.fields != null) {
            otherEndpoints.fields.values().forEach(f -> addField(f));
        }
        // TODO do more if needed
    }

}
