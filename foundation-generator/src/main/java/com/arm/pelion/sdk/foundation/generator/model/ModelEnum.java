package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.TypeSpec;

public class ModelEnum extends ModelPojo {

    private static final String UNKNOWN_ENUM = "UNKNOWN_ENUM";
    private final List<String> options;
    private final String defaultOption;
    private final String rawDefaultOption;

    public ModelEnum(String packageName, String attachedEntity, String name, String group, String longDescription,
                     List<String> options, String defaultOption) {
        super(packageName, generateName(attachedEntity, name), group,
              Utils.generateDescriptionFromName(generateName(attachedEntity, name)), longDescription, false, false,
              null);
        this.options = options == null ? new LinkedList<>() : options;
        this.rawDefaultOption = defaultOption;
        this.defaultOption = determineDefaultValue(defaultOption, options);
        addField(new Field(true, TypeFactory.stringType(), "string", "string representation", null, null, false, false,
                           true, true, generateConstantName(defaultOption), false));
    }

    public ModelEnum(String packageName, String name, String group) {
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
        return Utils.generateConstantName(null, value);
    }

    private static String generateName(String attachedEntity, String name) {
        String snakeName = ApiUtils.convertCamelToSnake(name);
        // Remove any reference to enum
        snakeName = snakeName == null ? null : snakeName.replace("enum", "");
        return Utils.combineNames(true, attachedEntity, snakeName);
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
        generateGetValueFromString();
        generateMerge();
    }

    protected void generateIsDefault() {
        overrideMethodIfExist(new Method(false, "isDefault", "States whether it is the default value",
                                         "@see SdkEnum#isDefault()", false, true, false, false, false, false, false,
                                         false).returnType(TypeFactory.getCorrespondingType(boolean.class))
                                               .returnDescription("true if this is the default value; false otherwise")
                                               .statement("return this == " + SdkEnum.METHOD_GET_DEFAULT + "()"));
    }

    protected void generateIsUnknownValue() {
        overrideMethodIfExist(new Method(false, "isUnknownValue",
                                         "States whether the value is unknown and an error happened during parsing",
                                         "@see SdkEnum#isUnknownValue()", false, true, false, false, false, false,
                                         false, false).returnType(TypeFactory.getCorrespondingType(boolean.class))
                                                      .returnDescription("true if this is an unknown value; false otherwise")
                                                      .statement("return this == " + SdkEnum.METHOD_GET_UNKNOWN_VALUE
                                                                 + "()"));
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
                                         false, false, false, false, false, true).returnType(TypeFactory.stringType())
                                                                                 .returnDescription("the string representation of this value")
                                                                                 .statement("return getString()"));
    }

    protected void generateGetDefault() {
        overrideMethodIfExist(new Method(false, SdkEnum.METHOD_GET_DEFAULT,
                                         "Gets default " + getDescriptionForDocumentation(), null, true, true, false,
                                         false, false, false, false, false)
                                                                           .returnType(new TypeParameter(new Import(name,
                                                                                                                    packageName)))
                                                                           .returnDescription("default "
                                                                                              + getDescriptionForDocumentation())
                                                                           .statement("return " + defaultOption));
    }

    protected void generateGetUnknownEnum() {
        overrideMethodIfExist(new Method(false, SdkEnum.METHOD_GET_UNKNOWN_VALUE,
                                         "Gets unknown " + getDescriptionForDocumentation()
                                                                                  + " value",
                                         null, true, true, false, false, false, false, false, false)
                                                                                                    .returnType(new TypeParameter(new Import(name,
                                                                                                                                             packageName)))
                                                                                                    .returnDescription("unknown "
                                                                                                                       + getDescriptionForDocumentation())
                                                                                                    .statement("return "
                                                                                                               + UNKNOWN_ENUM));
    }

    protected void generateGetValueFromString() {
        final Method method = new Method(false, SdkEnum.METHOD_GET_VALUE_FROM_STRING,
                                         "Gets " + getDescriptionForDocumentation() + " from its string representation",
                                         null, true, true, false, false, false, false, false, false)
                                                                                                    .returnType(new TypeParameter(new Import(name,
                                                                                                                                             packageName)))
                                                                                                    .returnDescription("corresponding "
                                                                                                                       + getDescriptionForDocumentation()
                                                                                                                       + "  or default "
                                                                                                                       + getDescriptionForDocumentation()
                                                                                                                       + " if not recognised. ");
        method.addParameter(new Parameter("value", "string", null, TypeFactory.stringType(), null, null));
        method.initialiseCodeBuilder();
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
                                                                                              .returnType(new TypeGenericParameter(SdkEnum.class))
                                                                                              .returnDescription("the merged enumerator");
        method.addParameter(new Parameter("obj1", "a " + getDescriptionForDocumentation(), null,
                                          new TypeGenericParameter(SdkEnum.class), null, null));
        method.addParameter(new Parameter("obj2", "a " + getDescriptionForDocumentation(), null,
                                          new TypeGenericParameter(SdkEnum.class), null, null));
        method.initialiseCodeBuilder();
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

    public List<String> getOptions() {
        return options;
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public String getRawDefaultOption() {
        return rawDefaultOption;
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
