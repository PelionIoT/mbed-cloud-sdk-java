package com.arm.pelion.sdk.foundation.generator.model;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ParameterSpec;

public class Parameter extends AbstractSdkArtifact {

    private ParameterSpec.Builder specificationBuilder;
    private ParameterType type;
    private String defaultValue;

    public Parameter(String name, String description, String longDescription, ParameterType type, String defaultValue) {
        super(false, name, description, longDescription, false, true, false, false, false, false);
        setSpecification(null);
        setType(type);
        setDefaultValue(defaultValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractModelEntity#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        super.setName(ApiUtils.convertSnakeToCamel(name, false));
    }

    public boolean hasDefaultValue() {
        return has(defaultValue);
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue
     *            the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @return the specification
     */
    public ParameterSpec.Builder getSpecification() {
        return specificationBuilder;
    }

    /**
     * @param specification
     *            the specification to set
     */
    public void setSpecification(ParameterSpec.Builder specification) {
        this.specificationBuilder = specification;
    }

    /**
     * @return the type
     */
    public ParameterType getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(ParameterType type) {
        this.type = type;
    }

    public String getJavadocDescription() {
        return "@param " + name + " " + description + String.valueOf(hasLongDescription() ? " " + longDescription : "");
    }

    protected void initialiseBuilder() throws TranslationException {
        if (specificationBuilder == null) {
            type.translate();
            specificationBuilder = type.hasClass() ? ParameterSpec.builder(type.getClazz(), name)
                                                   : ParameterSpec.builder(type.getTypeName(), name);
        }
    }

    protected void addModifiers() {
        if (isReadOnly) {
            specificationBuilder.addModifiers(Modifier.FINAL);
        }
        if (hasDefaultValue()) {
            specificationBuilder.addAnnotation(AnnotationSpec.builder(DefaultValue.class)
                                                             .addMember("value", "\"" + defaultValue + "\"").build());
        }

    }

    @Override
    public void translate() throws TranslationException {
        initialiseBuilder();
        addModifiers();
    }

}
