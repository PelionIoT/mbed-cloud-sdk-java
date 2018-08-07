package com.arm.pelion.sdk.foundation.generator.model;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;

public class Field extends AbstractModelEntity implements Cloneable {
    private static final String IDENTIFIER_NAME = "id";
    private ParameterType type;
    private String pattern;
    private String defaultValue;
    private boolean isRequired;
    private FieldSpec.Builder specificationBuilder;

    /**
     *
     * @param isReadOnly
     * @param type
     * @param name
     * @param description
     * @param pattern
     * @param isStatic
     * @param needsCustomCode
     * @param isInternal
     * @param isRequired
     * @param defaultValue
     */
    public Field(boolean isReadOnly, ParameterType type, String name, String description, String longDescription,
                 String pattern, boolean isStatic, boolean needsCustomCode, boolean isInternal, boolean isRequired,
                 String defaultValue) {
        super(isReadOnly, name, description, longDescription, isStatic, false, false, false, needsCustomCode,
              isInternal);
        setPattern(pattern);
        setType(type);
        setRequired(isRequired);
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
        ensureIdentifiersAreCorrectlySet();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractModelEntity#setReadOnly(boolean)
     */
    @Override
    public void setReadOnly(boolean isReadOnly) {
        super.setReadOnly(isReadOnly);
        ensureIdentifiersAreCorrectlySet();
    }

    private void ensureIdentifiersAreCorrectlySet() {
        if (isIdentifier()) {
            super.setReadOnly(false);
        }
    }

    public boolean isIdentifier() {
        return name == null ? false : IDENTIFIER_NAME.equals(name.toLowerCase().trim());
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

    /**
     * @return the specificationBuilder
     */
    public FieldSpec.Builder getSpecificationBuilder() {
        return specificationBuilder;
    }

    /**
     * @param specificationBuilder
     *            the specificationBuilder to set
     */
    public void setSpecificationBuilder(FieldSpec.Builder specificationBuilder) {
        this.specificationBuilder = specificationBuilder;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern
     *            the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return the isRequired
     */
    public boolean isRequired() {
        return isRequired;
    }

    /**
     * @param isRequired
     *            the isRequired to set
     */
    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    protected void initialiseBuilder() throws TranslationException {
        if (specificationBuilder == null) {
            type.translate();
            specificationBuilder = type.hasClass() ? FieldSpec.builder(type.getClazz(), name,
                                                                       isAccessible ? Modifier.PROTECTED
                                                                                    : Modifier.PRIVATE)
                                                   : FieldSpec.builder(type.getTypeName(), name,
                                                                       isAccessible ? Modifier.PROTECTED
                                                                                    : Modifier.PRIVATE);
        }
    }

    protected void addModifiers() {
        if (isStatic) {
            specificationBuilder.addModifiers(Modifier.STATIC);
        }
        if (isReadOnly) {
            specificationBuilder.addModifiers(Modifier.FINAL);
        }
        if (hasDescription()) {
            specificationBuilder.addJavadoc(description);
            if (hasLongDescription()) {
                specificationBuilder.addJavadoc(System.lineSeparator() + "<p>" + System.lineSeparator()
                                                + longDescription);
            }
        }
        if (isInternal) {
            specificationBuilder.addAnnotation(Internal.class);
        }
        if (isRequired) {
            specificationBuilder.addAnnotation(Required.class);
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

    public Parameter toParameter() {
        return new Parameter(name, description, longDescription, type, defaultValue);
    }

    @Override
    public Field clone() {
        return new Field(isReadOnly, type, name, description, longDescription, pattern, isStatic, needsCustomCode,
                         isInternal, isRequired, defaultValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Field [type=" + type + ", pattern=" + pattern + ", defaultValue=" + defaultValue + ", isRequired="
               + isRequired + ", parent=" + super.toString() + "]";
    }

}
