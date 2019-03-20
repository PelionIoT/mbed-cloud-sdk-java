package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Locale;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;

public class Field extends AbstractSdkArtifact implements Cloneable {
    public static final String IDENTIFIER_NAME = "id";
    private TypeParameter type;
    private String pattern;
    private String minimum;
    private String maximum;
    private String defaultValue;
    private String initialiser;
    private boolean isRequired;
    private boolean alreadyDefined;
    private boolean isIdentifier;
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
    public Field(boolean isReadOnly, TypeParameter type, String name, String description, String longDescription,
                 String pattern, String minimum, String maximum, boolean isStatic, boolean needsCustomCode,
                 boolean isInternal, boolean isRequired, String defaultValue, boolean alreadyDefined) {
        super(isReadOnly, name, determineDescription(type, description), longDescription, isStatic, false, false, false,
              needsCustomCode, isInternal);
        setMinimum(minimum);
        setMaximum(maximum);
        setPattern(pattern);
        setType(type);
        setRequired(isRequired);
        setDefaultValue(defaultValue);
        setInitialiser(null);
        setAlreadyDefined(alreadyDefined);
        setAsIdentifier(false);
        setDefaultValueIfMissing();
    }

    public Field(java.lang.reflect.Field field, boolean isInternal, boolean isRequired, String defaultValue,
                 boolean hasSetter) {
        this(isFieldReadOnly(field, hasSetter),
             TypeFactory.getCorrespondingType(field.getType(), field.getGenericType()), field.getName(), null, null,
             null, null, null, java.lang.reflect.Modifier.isStatic(field.getModifiers()), false, isInternal, isRequired,
             defaultValue, true);
    }

    public Field(java.lang.reflect.Field field, boolean hasSetter) {
        this(field, false, false, null, hasSetter);
    }

    public static Field defaultIdentifier() {
        return new Field(false, TypeFactory.getCorrespondingType(String.class), IDENTIFIER_NAME, IDENTIFIER_NAME, null,
                         null, null, null, false, false, true, false, null, false);
    }

    private static boolean isFieldReadOnly(java.lang.reflect.Field field, boolean hasSetter) {
        if (java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
            return true;
        }
        if (hasSetter) {
            return false;
        }
        return !java.lang.reflect.Modifier.isPublic(field.getModifiers());
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractModelEntity#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        super.setName(isStatic && isReadOnly ? Utils.generateConstantName(null, name)
                                             : ApiUtils.convertSnakeToCamel(name, false));
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
        if (isReadOnly) {
            setName(name);
        }
        ensureIdentifiersAreCorrectlySet();
    }

    @Override
    public void setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        if (isStatic) {
            setName(name);
        }
    }

    private void ensureIdentifiersAreCorrectlySet() {
        if (isIdentifier()) {
            super.setReadOnly(false);
            setRequired(false);
        }
    }

    private void setDefaultValueIfMissing() {
        // If no default value is specified but limits are, then consider one of these limits as default value
        if (!getType().isNumber()) {
            return;
        }
        if (!hasDefaultValue()) {
            if (hasMinimum()) {
                setDefaultValue(getMinimum());
            } else {
                if (hasMaximum()) {
                    setDefaultValue(getMaximum());
                }
            }
        }
    }

    public boolean isIdentifier() {
        return isIdentifier ? true : isUsualIdentifier();
    }

    public boolean isUsualIdentifier() {
        return name == null ? false : IDENTIFIER_NAME.equals(name.toLowerCase(Locale.UK).trim());
    }

    public boolean hasDefaultValue() {
        return has(defaultValue);
    }

    public String getJavaDefaultValue() {
        return ValueGenerator.getJavaDefaultValue(type, defaultValue);
    }

    public boolean getJavaDefaultBooleanValue() {
        if (type.isBoolean() && hasDefaultValue()) {
            return Boolean.valueOf(defaultValue).booleanValue();
        }
        return false;
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

    public void setAsIdentifier(boolean isIdentifier) {
        this.isIdentifier = isIdentifier;
        if (isIdentifier) {
            setRequired(false);
        }
    }

    /**
     * @return the type
     */
    public TypeParameter getType() {
        return type;
    }

    private static String determineDescription(TypeParameter type, String description) {
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
    public void setType(TypeParameter type) {
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

    public Field initialiser(String initialiserValue) {
        setInitialiser(initialiserValue);
        return this;
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

    public boolean hasMinimum() {
        return has(minimum) && !type.isDate();
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public boolean hasMaximum() {
        return has(maximum) && !type.isDate();
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
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
        return isRequired() || hasPattern() || hasMaximum() || hasMinimum();// TODO add more cases where validation is
                                                                            // needed.
    }

    /**
     * @param isRequired
     *            the isRequired to set
     */
    public void setRequired(boolean isRequired) {
        this.isRequired = isIdentifier() ? false : isRequired;
    }

    protected void initialiseBuilder() throws TranslationException {
        if (specificationBuilder == null) {
            type.translate();
            specificationBuilder = type.hasClass() ? FieldSpec.builder(type.getClazz(), name,
                                                                       isAccessible ? isStatic ? Modifier.PUBLIC
                                                                                               : Modifier.PROTECTED
                                                                                    : Modifier.PRIVATE)
                                                   : FieldSpec.builder(type.getTypeName(), name,
                                                                       isAccessible ? Modifier.PROTECTED
                                                                                    : Modifier.PRIVATE);
        }
    }

    protected void addDocumentation() {
        if (hasDescription()) {
            specificationBuilder.addJavadoc(description + System.lineSeparator());
            if (hasLongDescription()) {
                specificationBuilder.addJavadoc("<p>" + System.lineSeparator() + longDescription
                                                + System.lineSeparator());
            }
        }
        if (hasDeprecation()) {
            specificationBuilder.addJavadoc((hasDescription() ? "<p>" + System.lineSeparator() : "")
                                            + getDeprecation().getNotice());
        }
    }

    protected void addModifiers() {
        if (isStatic) {
            specificationBuilder.addModifiers(Modifier.STATIC);
        }
        if (isReadOnly) {
            specificationBuilder.addModifiers(Modifier.FINAL);
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
        if (hasDeprecation()) {
            specificationBuilder.addAnnotation(Deprecated.class);
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
            addDocumentation();
            addModifiers();
            addValue();
        } catch (TranslationException exception) {
            throw new TranslationException("Error in field definition: " + this, exception);
        }
    }

    public Parameter toParameter() {
        return new Parameter(name, description, longDescription, type, defaultValue, minimum, maximum);
    }

    @Override
    public Field clone() {
        Field field = new Field(isReadOnly, type, name, description, longDescription, pattern, minimum, maximum,
                                isStatic, needsCustomCode, isInternal, isRequired, defaultValue, alreadyDefined);
        field.setDeprecation(deprecation);
        return field;
    }

    @Override
    public String toString() {
        return "Field [type=" + type + ", pattern=" + pattern + ", minimum=" + minimum + ", maximum=" + maximum
               + ", defaultValue=" + defaultValue + ", initialiser=" + initialiser + ", isRequired=" + isRequired
               + ", alreadyDefined=" + alreadyDefined + ", isIdentifier=" + isIdentifier + ", specificationBuilder="
               + specificationBuilder + ", parent=" + super.toString() + "]";
    }

}
