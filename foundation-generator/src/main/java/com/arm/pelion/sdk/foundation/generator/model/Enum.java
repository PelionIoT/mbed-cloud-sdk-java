package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.TypeSpec;

public class Enum extends Model {

    private static final String UNKNOWN_ENUM = "UNKNOWN_ENUM";
    private final List<String> options;
    private final String defaultOption;

    public Enum(String packageName, String attachedEntity, String name, String group, String longDescription,
                List<String> options, String defaultOption) {
        super(packageName, generateName(attachedEntity, name), group,
              generateDescriptionFromName(generateName(attachedEntity, name)), longDescription, false, false);
        this.options = options == null ? new LinkedList<>() : options;
        this.defaultOption = determineDefaultValue(defaultOption, options);
        addField(new Field(true, new ParameterType(String.class), "string", "string representation", null, null, false,
                           false, true, true, generateConstantName(defaultOption)));
    }

    public Enum(String packageName, String name, String group) {
        this(packageName, null, name, group, null, null, null);
    }

    private String determineDefaultValue(String theDefaultOption, List<String> theOptions) {
        if (theOptions == null || theOptions.isEmpty()) {
            return theDefaultOption;
        }
        if (theDefaultOption == null) {
            return generateConstantName(theOptions.iterator().next());
        }
        for (final String value : theOptions) {
            if (value.trim().toLowerCase().equals(theDefaultOption.trim().toLowerCase())) {
                return generateConstantName(value);
            }
        }
        return generateConstantName(theOptions.iterator().next());
    }

    private String generateConstantName(String value) {
        return value == null ? null : value.toUpperCase(Locale.UK)
                                           .equals(value) ? value : ApiUtils.convertCamelToSnake(value).toUpperCase();
    }

    private static String generateName(String attachedEntity, String name) {
        String snakeName = (attachedEntity == null ? "" : ApiUtils.convertCamelToSnake(attachedEntity) + "_")
                           + ApiUtils.convertCamelToSnake(name);
        // Remove any reference to enum
        snakeName = snakeName == null ? null : snakeName.replace("enum", "");
        return ApiUtils.convertSnakeToCamel(snakeName, true);
    }

    private static String generateDescriptionFromName(String name) {
        return name == null ? null
                            : ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(name).replace("_", "+"), true)
                                      .replace("+", " ");
    }

    @Override
    protected void initialiseBuilder() {
        if (specificationBuilder == null) {
            specificationBuilder = TypeSpec.enumBuilder(name).addModifiers(Modifier.PUBLIC);
            generateDocumentation();
            specificationBuilder.addSuperinterface(getSuperInterface());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Model#getSuperInterface()
     */
    @Override
    protected Class<?> getSuperInterface() {
        return SdkEnum.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Model#generateMethodsNecessaryAtEachLevel()
     */
    @Override
    protected void generateMethodsNecessaryAtEachLevel() {
        generateToString(null);
        overrideMethodIfExist((new MethodConstructorAllFields(this, null)).callSuperConstructor(false).ignoreModifier()
                                                                          .longDescription(null));
        generateIsDefault();
        generateIsUnknownValue();
        generateGetDefault();
        generateGetUnknownEnum();
        generateGetStateFromString();
        generateMerge();
    }

    protected void generateIsDefault() {
        overrideMethodIfExist(new Method(false, "isDefault", "States whether it is the default value",
                                         "@see SdkEnum#isDefault()", false, true, false, false, false, false, false,
                                         false).returnType(new ParameterType(boolean.class))
                                               .returnDescription("true if this is the default value; false otherwise")
                                               .statement("return this == getDefault()"));
    }

    protected void generateIsUnknownValue() {
        overrideMethodIfExist(new Method(false, "isUnknownValue",
                                         "States whether the value is unknown and an error happened during parsing",
                                         "@see SdkEnum#isUnknownValue()", false, true, false, false, false, false,
                                         false, false).returnType(new ParameterType(boolean.class))
                                                      .returnDescription("true if this is an unknown value; false otherwise")
                                                      .statement("return this == getUnknownEnum()"));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.arm.pelion.sdk.foundation.generator.model.Model#generateToString(com.arm.pelion.sdk.foundation.generator.
     * model.Model)
     */
    @Override
    protected void generateToString(Model theParent) {
        overrideMethodIfExist(new Method(false, "toString", "toString", "@see java.lang.Enum#toString()", false, true,
                                         false, false, false, false, false, true)
                                                                                 .returnType(new ParameterType(String.class))
                                                                                 .returnDescription("the string representation of this value")
                                                                                 .statement("return getString()"));
    }

    protected void generateGetDefault() {
        overrideMethodIfExist(new Method(false, "getDefault", "Gets default "
                                                              + getDescriptionForDocumentation(),
                                         null, true, true, false, false, false, false, false, false)
                                                                                                    .returnType(new ParameterType(new Import(name,
                                                                                                                                             packageName)))
                                                                                                    .returnDescription("default "
                                                                                                                       + getDescriptionForDocumentation())
                                                                                                    .statement("return "
                                                                                                               + defaultOption));
    }

    protected void generateGetUnknownEnum() {
        overrideMethodIfExist(new Method(false, "getUnknownEnum",
                                         "Gets unknown " + getDescriptionForDocumentation()
                                                                  + " value",
                                         null, true, true, false, false, false, false, false, false)
                                                                                                    .returnType(new ParameterType(new Import(name,
                                                                                                                                             packageName)))
                                                                                                    .returnDescription("unknown "
                                                                                                                       + getDescriptionForDocumentation())
                                                                                                    .statement("return "
                                                                                                               + UNKNOWN_ENUM));
    }

    protected void generateGetStateFromString() {
        final Method method = new Method(false, "getState",
                                         "Gets " + getDescriptionForDocumentation()
                                                            + " from its string representation",
                                         null, true, true, false, false, false, false, false, false)
                                                                                                    .returnType(new ParameterType(new Import(name,
                                                                                                                                             packageName)))
                                                                                                    .returnDescription("corresponding "
                                                                                                                       + getDescriptionForDocumentation()
                                                                                                                       + "  or default "
                                                                                                                       + getDescriptionForDocumentation()
                                                                                                                       + " if not recognised. ");
        method.addParameter(new Parameter("value", "string", null, new ParameterType(String.class), null));
        method.setCode(CodeBlock.builder());
        method.getCode().beginControlFlow("if (value == null)");
        method.getCode().addStatement("return getDefault()");
        method.getCode().endControlFlow();
        method.getCode().addStatement("final String trimmedValue = value.trim()");
        method.getCode().beginControlFlow("for (final " + name + " option : values())");
        method.getCode().beginControlFlow("if (option.getString().equalsIgnoreCase(trimmedValue))");
        method.getCode().addStatement("return option");
        method.getCode().endControlFlow();
        method.getCode().endControlFlow();
        method.getCode().addStatement("return getDefault()");
        overrideMethodIfExist(method);
    }

    protected void generateMerge() {
        final Method method = new Method(false, "merge", "Merges two states", "@see SdkEnum#merge(SdkEnum, SdkEnum)",
                                         false, true, false, false, false, false, false, true)
                                                                                              .returnType(new GenericParameterType(SdkEnum.class))
                                                                                              .returnDescription("the merged enumerator");
        method.addParameter(new Parameter("obj1", "a " + getDescriptionForDocumentation(), null,
                                          new GenericParameterType(SdkEnum.class), null));
        method.addParameter(new Parameter("obj2", "a " + getDescriptionForDocumentation(), null,
                                          new GenericParameterType(SdkEnum.class), null));
        method.setCode(CodeBlock.builder());
        method.getCode().beginControlFlow("if (obj1 == null)");
        method.getCode().addStatement("return obj2");
        method.getCode().endControlFlow();
        method.getCode().beginControlFlow("if (obj2 == null)");
        method.getCode().addStatement("return obj1");
        method.getCode().endControlFlow();
        method.getCode().beginControlFlow("if (obj1.isDefault())");
        method.getCode().addStatement("return obj2");
        method.getCode().endControlFlow();
        method.getCode().beginControlFlow("if (obj2.isDefault())");
        method.getCode().addStatement("return obj1");
        method.getCode().endControlFlow();
        method.getCode().addStatement("return obj2");
        overrideMethodIfExist(method);
    }

    private String getDescriptionForDocumentation() {
        return description == null ? null : description.toLowerCase().replace(".", "");
    }

    @Override
    protected Import toImport() {
        final Import importPath = super.toImport();
        importPath.setEnum(true);
        return importPath;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Model#translate()
     */
    @Override
    public void translate() throws TranslationException {
        super.translate();
        translateEnumValues();
    }

    @Override
    public List<Model> getProcessedModels() {
        return Arrays.asList(this);
    }

    private void translateEnumValues() {
        options.forEach(v -> specificationBuilder.addEnumConstant(generateConstantName(v),
                                                                  TypeSpec.anonymousClassBuilder("$S", v).build()));
        specificationBuilder.addEnumConstant(UNKNOWN_ENUM,
                                             TypeSpec.anonymousClassBuilder("SDK_UNKNOWN_ENUM_VALUE").build());
    }

}
