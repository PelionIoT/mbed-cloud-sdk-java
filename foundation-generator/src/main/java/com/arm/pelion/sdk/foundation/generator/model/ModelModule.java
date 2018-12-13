package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.AnnotationSpec;

public class ModelModule extends ModelMergeable {

    public static final String ENDPOINTS_FIELD_NAME = "endpoints";
    private final ModelEndpointsFetcher endpointFetcher;

    public ModelModule(Model model, String packageName, String description, ModelEndpointsFetcher fetcher) {
        super(packageName, generateName(model.getGroup()), model.getGroup(),
              generateDescription(model.getGroup(), description),
              generateLongDescription(model.getGroup(), description), false, true);
        setSuperClassType(TypeFactory.getCorrespondingType(AbstractApi.class));
        endpointFetcher = fetcher;
        addEndpointField();
    }

    private void addEndpointField() {
        ModelEndpoints endpoints = endpointFetcher.fetch(getGroup());
        if (endpoints == null) {
            return;
        }
        addField(new Field(true, endpoints.toType(), ENDPOINTS_FIELD_NAME, "module endpoints", null, null, false, false,
                           true, false, null, false));

    }

    @Override
    protected void translateFields() throws TranslationException {
        addEndpointField();
        super.translateFields();
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
        specificationBuilder.addAnnotation(AnnotationSpec.builder(com.arm.mbed.cloud.sdk.annotations.Module.class)
                                                         .build());
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

}
