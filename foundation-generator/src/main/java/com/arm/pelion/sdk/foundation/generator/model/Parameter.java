package com.arm.pelion.sdk.foundation.generator.model;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ParameterSpec;

public class Parameter extends AbstractSdkArtifact implements Cloneable {

    private ParameterSpec.Builder specificationBuilder;
    private TypeParameter type;
    private String defaultValue;
    private Validation validation;
    private boolean setAsNullable;
    private boolean setAsNonNull;

    public Parameter(String name, String description, String longDescription, TypeParameter type, String defaultValue,
                     Validation validation) {
        super(false, name, description, longDescription, false, true, false, false, false, false);
        setValidation(validation);
        setSpecification(null);
        setType(type);
        if (hasValidation()) {
            validation.setForDate(type.isDate());
        }
        setDefaultValue(defaultValue);
        setSetAsNonNull(false);
        setSetAsNullable(false);
        setDefaultValueIfMissing();
    }

    public Parameter(String name, Class<?> elementClass) {
        this(name == null ? ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(elementClass.getSimpleName()),
                                                         false)
                          : name,
             Utils.generateDocumentationString(elementClass.getSimpleName()), null,
             TypeFactory.getCorrespondingType(elementClass), null, null);
    }

    public Parameter(java.lang.reflect.Parameter parameter) {
        this(parameter.getName(), parameter.getType());
    }

    @Override
    public Parameter clone() {
        final Parameter clone = new Parameter(name, description, longDescription, type, defaultValue,
                                              hasValidation() ? validation.clone() : validation);
        clone.setSetAsNonNull(setAsNonNull);
        clone.setSetAsNullable(setAsNullable);
        return clone;
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

    public boolean isSetAsNullable() {
        return setAsNullable;
    }

    public Parameter setAsNullable(boolean setAsNullable) {
        setSetAsNullable(setAsNullable);
        return this;
    }

    public void setSetAsNullable(boolean setAsNullable) {
        this.setAsNullable = setAsNullable;
        if (setAsNullable) {
            setSetAsNonNull(false);
            if (hasValidation()) {
                validation.setNullable(true);
            }
        }
    }

    public boolean isSetAsNonNull() {
        return setAsNonNull;
    }

    public Parameter setAsNonNull(boolean setAsNonNull) {
        setSetAsNonNull(setAsNonNull);
        return this;
    }

    public void setSetAsNonNull(boolean setAsNonNull) {
        this.setAsNonNull = setAsNonNull;
        if (setAsNonNull) {
            setSetAsNullable(false);
            if (hasValidation()) {
                validation.setNullable(false);
            }
        }
    }

    public boolean hasValidation() {
        return validation != null;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    private void setDefaultValueIfMissing() {
        // If no default value is specified but limits are, then consider one of these limits as default value
        if (!getType().isNumber() || !hasValidation()) {
            return;
        }
        if (!hasDefaultValue()) {
            if (validation.hasMinimum()) {
                setDefaultValue(validation.getMinimum());
            } else {
                if (validation.hasMaximum()) {
                    setDefaultValue(validation.getMaximum());
                }
            }
        }
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
    public TypeParameter getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(TypeParameter type) {
        this.type = type;
    }

    public String getJavadocDescription() {
        return "@param " + name + " "
               + (hasDescription() ? description : Utils.generateDocumentationString(type.getShortName(), false))
               + (hasLongDescription() && !longDescription.equals(description) ? " " + longDescription : "");
    }

    protected void initialiseBuilder() throws TranslationException {
        type.translate();
        specificationBuilder = type.hasClass() ? ParameterSpec.builder(type.getClazz(), name)
                                               : ParameterSpec.builder(type.getTypeName(), name);
    }

    public boolean hasSameType(Parameter other) {
        if (other == null) {
            return false;
        }
        try {
            type.translate();
            other.getType().translate();
            return type.equals(other.getType());
        } catch (@SuppressWarnings("unused") Exception exception) {
            return false;
        }
    }

    protected void addModifiers() {
        if (isReadOnly) {
            specificationBuilder.addModifiers(Modifier.FINAL);
        }
        if (setAsNonNull) {
            specificationBuilder.addAnnotation(NonNull.class);
        }
        if (setAsNullable) {
            specificationBuilder.addAnnotation(Nullable.class);
        }
        if (hasDefaultValue()) {
            specificationBuilder.addAnnotation(AnnotationSpec.builder(DefaultValue.class)
                                                             .addMember("value", "\"" + defaultValue + "\"").build());
        }

    }

    public String getJavaDefaultValue() {
        return ValueGenerator.getJavaDefaultValue(type, defaultValue);
    }

    @Override
    public void translate() throws TranslationException {
        initialiseBuilder();
        addModifiers();
    }

    @Override
    protected void addStaticAnalysisAnnotations() {
        // Nothing to do
    }

}
