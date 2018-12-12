package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.squareup.javapoet.AnnotationSpec;

public class ModelModule extends Model implements MergeableArtifact {

    public ModelModule(Model model, String packageName, String description, boolean needsCustomCode) {
        super(packageName, generateName(model.getGroup()), model.getGroup(),
              generateDescription(model.getGroup(), description),
              generateLongDescription(model.getGroup(), description), false, true);
        setSuperClassType(TypeFactory.getCorrespondingType(AbstractApi.class));
    }

    private static String generateDescription(String group, String description) {
        return description == null ? "Specifies " + group + " APIs" : description;
    }

    private static String generateLongDescription(String group, String description) {
        return description == null ? " API definitions exposing functionality for dealing with "
                                     + ApiUtils.convertCamelToSnake(group).replace("_", " ")
                                   : description;
    }

    @Override
    public void generateAnnotations() {
        super.generateAnnotations();
        specificationBuilder.addAnnotation(AnnotationSpec.builder(Module.class).build());
    }

    private static String generateName(String group) {
        return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(group), true);
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
        // TODO
        // addConstructor(new MethodEndpointsConstructorFromClient(this, theParent));
        // overrideMethodIfExist(new MethodEndpointsClone(this, theParent));
    }

    @Override
    public <T extends MergeableArtifact> void merge(T otherArtifact) {
        if (otherArtifact == null || this == otherArtifact || !(otherArtifact instanceof ModelModule)) {
            return;
        }
        final ModelModule otherModule = (ModelModule) otherArtifact;
        if (otherModule.methods != null) {
            otherModule.methods.values().forEach(m -> addMethod(m));
        }
        if (otherModule.fields != null) {
            otherModule.fields.values().forEach(f -> addField(f));
        }
        // TODO do more if needed
    }

}
