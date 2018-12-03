package com.arm.pelion.sdk.foundation.generator.model;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;

public class Field extends AbstractSdkArtifact implements Cloneable {
    private static final String IDENTIFIER_NAME = "id";
    private ParameterType type;
    private String pattern;
    private String defaultValue;
    private String initialiser;
    private boolean isRequired;
    private boolean alreadyDefined;
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
                 String defaultValue, boolean alreadyDefined) {
        super(isReadOnly, name, determineDescription(type, description), longDescription, isStatic, false, false, false,
              needsCustomCode, isInternal);
        setPattern(pattern);
        setType(type);
        setRequired(isRequired);
        setDefaultValue(defaultValue);
        setInitialiser(null);
        setAlreadyDefined(alreadyDefined);
    }

    public Field(java.lang.reflect.Field field, boolean isInternal, boolean isRequired, String defaultValue) {
        this(java.lang.reflect.Modifier.isFinal(field.getModifiers()), new ParameterType(field.getType()),
             field.getName(), null, null, null, java.lang.reflect.Modifier.isStatic(field.getModifiers()), false,
             isInternal, isRequired, defaultValue, true);
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

    public String getJavaDefaultValue() {
        if (type.isBoolean()) {
            return hasDefaultValue() ? defaultValue : "false";
        }
        if (type.isEnum()) {// TODO ensure the method for getting default type is always valid
            return hasDefaultValue() ? defaultValue : type.getShortName() + ".getDefault()";
        }
        if (type.isNumber()) {
            return hasDefaultValue() ? defaultValue : "0";
        }
        if (type.isDate()) {// TODO ensure the default date value is called now
            return hasDefaultValue() ? defaultValue.contains("now") ? "new java.util.Date()" : defaultValue
                                     : "new java.util.Date()";
        }
        if (type.isString()) {
            return hasDefaultValue() ? "\"" + defaultValue + "\"" : "null";
        }
        return hasDefaultValue() ? defaultValue : "null";
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

    private static String determineDescription(ParameterType type, String description) {
        if (description != null) {
            return description;
        }
        if (type != null) {
            return type.isEnum() ? "enumerator value" : "value";
        }
        return null;
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

    public boolean hasInitialiser() {
        return has(initialiser);
    }

    /**
     * @return the initialiser
     */
    public String getInitialiser() {
        return initialiser;
    }

    /**
     * @param initialiser
     *            the initialiser to set
     */
    public void setInitialiser(String initialiser) {
        this.initialiser = initialiser;
    }

    /**
     * @param specificationBuilder
     *            the specificationBuilder to set
     */
    public void setSpecificationBuilder(FieldSpec.Builder specificationBuilder) {
        this.specificationBuilder = specificationBuilder;
    }

    public boolean hasPattern() {
        return has(pattern) && !type.isDate();
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

    public boolean isAlreadyDefined() {
        return alreadyDefined;
    }

    public void setAlreadyDefined(boolean alreadyDefined) {
        this.alreadyDefined = alreadyDefined;
    }

    public boolean needsValidation() {
        return isRequired() || hasPattern();// TODO add more cases where validation is needed.
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

    protected void addValue() {
        if (hasInitialiser()) {
            specificationBuilder.initializer(initialiser);
        }
    }

    @Override
    public void translate() throws TranslationException {
        if (alreadyDefined) {
            return;
        }
        try {
            initialiseBuilder();
            addModifiers();
            addValue();
        } catch (TranslationException exception) {
            throw new TranslationException("Error in field definition: " + this, exception);
        }
    }

    public Parameter toParameter() {
        return new Parameter(name, description, longDescription, type, defaultValue);
    }

    @Override
    public Field clone() {
        return new Field(isReadOnly, type, name, description, longDescription, pattern, isStatic, needsCustomCode,
                         isInternal, isRequired, defaultValue, alreadyDefined);
    }

    @Override
    public String toString() {
        return "Field [type=" + type + ", pattern=" + pattern + ", defaultValue=" + defaultValue + ", initialiser="
               + initialiser + ", isRequired=" + isRequired + ", alreadyDefined=" + alreadyDefined
               + ", specificationBuilder=" + specificationBuilder + ", parent=" + super.toString() + "]";
    }

}
