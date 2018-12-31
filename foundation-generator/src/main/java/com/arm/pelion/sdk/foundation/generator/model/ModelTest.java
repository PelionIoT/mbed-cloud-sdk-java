package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeSpec;

public class ModelTest extends AbstractSdkArtifact {
    private Model modelUnderTest;
    protected TypeSpec.Builder specificationBuilder;
    private final Map<String, Method> tests;

    public ModelTest(Model modelUndertest) {
        super(false, generateTestName(modelUndertest), generateDescription(modelUndertest), null, false, true, false,
              containsCustomCode(modelUndertest), false, false);
        this.modelUnderTest = modelUndertest;
        tests = new HashMap<>();
    }

    private static String generateDescription(Model modelUndertest) {
        return modelUndertest == null ? null : "Unit tests for Model " + modelUndertest.getName();
    }

    private static String generateTestName(Model modelUndertest) {
        return modelUndertest == null ? null
                                      : ApiUtils.convertSnakeToCamel("test_"
                                                                     + ApiUtils.convertCamelToSnake(modelUndertest.getName()),
                                                                     true);
    }

    private static boolean containsCustomCode(Model modelUndertest) {
        return modelUndertest == null ? false : modelUndertest.containsCustomCode();
    }

    public List<Method> getTestList() {
        return new ArrayList<>(tests.values());
    }

    public boolean hasTest(Method test) {
        return hasTest(test.getIdentifier());
    }

    public boolean hasTest(String identifier) {
        return identifier == null ? false : tests.containsKey(identifier);
    }

    public void addTest(Method test) {
        if (!hasTest(test)) {
            overrideTestIfExist(test);
        }
    }

    public void overrideTestIfExist(Method test) {
        if (test == null) {
            return;
        }
        tests.put(test.getIdentifier(), test);
    }

    public void generateTests() {
        tests.clear();
        generateCloneTest();
        generateEqualsTest();
        generateHashCodeTest();
        generateGetValueTest();
        // FIXME better handle tests depending on the type of model
        if (!(modelUnderTest instanceof ModelListOption)) {
            generateIsValid();
        }
    }

    private void addExceptionHandlingStart(final MethodTest test) {
        test.getCode().beginControlFlow("try");
    }

    private void addExceptionHandlingEnd(final MethodTest test) {
        final String exceptionVariable = "exception";
        test.getCode().endControlFlow();
        test.getCode().beginControlFlow("catch(Exception $L)", exceptionVariable);
        test.getCode().addStatement("fail($L.getMessage())", exceptionVariable);
        test.getCode().endControlFlow();
    }

    private void generateCloneTest() {
        final Method method = modelUnderTest.fetchMethod(MethodClone.IDENTIFIER);
        if (method == null) {
            return;
        }
        final MethodTest test = new MethodTest(MethodClone.IDENTIFIER,
                                               method.containsCustomCode() || modelUnderTest.needsFieldCustomisation());

        final String variable = modelUnderTest.getName().toLowerCase().replace(" ", "").trim();
        final String fieldValues = String.join("," + System.lineSeparator(),
                                               ValueGenerator.generateModelFieldValues(modelUnderTest));
        addExceptionHandlingStart(test);
        test.getCode().addStatement("$L " + variable + "1 = new $L(" + fieldValues + ")", modelUnderTest.getName(),
                                    modelUnderTest.getName());
        test.getCode().addStatement("$L " + variable + "2 = " + variable + "1.clone()", modelUnderTest.getName());
        test.getCode().addStatement("assertNotNull(" + variable + "1)");
        test.getCode().addStatement("assertNotNull(" + variable + "2)");
        test.getCode().addStatement("assertNotSame(" + variable + "2, " + variable + "1)");
        test.getCode().addStatement("assertEquals(" + variable + "2, " + variable + "1)");
        addExceptionHandlingEnd(test);
        addTest(test);
    }

    private void generateGetValueTest() {
        if (!(modelUnderTest instanceof ModelEnum)) {
            return;
        }
        final Method method = modelUnderTest.fetchMethod(SdkEnum.METHOD_GET_VALUE_FROM_STRING);
        if (method == null) {
            return;
        }
        final MethodTest test = new MethodTest(SdkEnum.METHOD_GET_VALUE_FROM_STRING,
                                               method.containsCustomCode() || modelUnderTest.needsFieldCustomisation());
        final ModelEnum enumModel = (ModelEnum) modelUnderTest;
        final String variable = modelUnderTest.getName().toLowerCase().replace(" ", "").trim();
        addExceptionHandlingStart(test);
        test.getCode().addStatement("$L $L = $L.$L($L)", enumModel.getName(), variable, enumModel.getName(),
                                    SdkEnum.METHOD_GET_VALUE_FROM_STRING, null);
        test.getCode().addStatement("assertNotNull($L)", variable);
        test.getCode().addStatement("assertTrue($L.$L())", variable, SdkEnum.METHOD_IS_DEFAULT);
        test.getCode().addStatement("$L = $L.$L($L.$L().$L())", variable, enumModel.getName(),
                                    SdkEnum.METHOD_GET_VALUE_FROM_STRING, enumModel.getName(),
                                    SdkEnum.METHOD_GET_DEFAULT, SdkEnum.METHOD_GET_STRING);
        test.getCode().addStatement("assertNotNull($L)", variable);
        test.getCode().addStatement("assertTrue($L.$L())", variable, SdkEnum.METHOD_IS_DEFAULT);
        test.getCode().addStatement("$L = $L.$L($S)", variable, enumModel.getName(),
                                    SdkEnum.METHOD_GET_VALUE_FROM_STRING, enumModel.getDefaultOption());
        test.getCode().addStatement("assertNotNull($L)", variable);
        test.getCode().addStatement("assertTrue($L.$L())", variable, SdkEnum.METHOD_IS_DEFAULT);
        if (enumModel.getOptions().size() > 1) {
            String option = enumModel.getOptions().stream().filter(o -> !o.equals(enumModel.getRawDefaultOption()))
                                     .findFirst().orElse(null);
            test.getCode().addStatement("$L = $L.$L($S)", variable, enumModel.getName(),
                                        SdkEnum.METHOD_GET_VALUE_FROM_STRING, option);
            test.getCode().addStatement("assertNotNull($L)", variable);
            test.getCode().addStatement("assertFalse($L.$L())", variable, SdkEnum.METHOD_IS_DEFAULT);
        }
        test.getCode().addStatement("$L = $L.$L($S)", variable, enumModel.getName(),
                                    SdkEnum.METHOD_GET_VALUE_FROM_STRING, ValueGenerator.generateRandomString());
        test.getCode().addStatement("assertNotNull($L)", variable);
        test.getCode().addStatement("assertTrue($L.$L())", variable, SdkEnum.METHOD_IS_DEFAULT);
        addExceptionHandlingEnd(test);
        addTest(test);
    }

    private void generateEqualsTest() {
        final Method method = modelUnderTest.fetchMethod(MethodEquals.IDENTIFIER);
        if (method == null) {
            return;
        }
        final MethodTest test = new MethodTest(MethodEquals.IDENTIFIER,
                                               method.containsCustomCode() || modelUnderTest.needsFieldCustomisation());

        final List<String> values1 = ValueGenerator.generateModelFieldValues(modelUnderTest);
        final List<String> values2 = ValueGenerator.generateModelFieldValues(modelUnderTest);
        final String variable = modelUnderTest.getName().toLowerCase().replace(" ", "").trim();
        final String fieldValues1 = String.join("," + System.lineSeparator(), values1);
        final String fieldValues2 = String.join("," + System.lineSeparator(), values2);
        addExceptionHandlingStart(test);
        test.getCode().addStatement("$L " + variable + "1 = new $L(" + fieldValues1 + ")", modelUnderTest.getName(),
                                    modelUnderTest.getName());
        test.getCode().addStatement("$L " + variable + "2 = new $L(" + fieldValues1 + ")", modelUnderTest.getName(),
                                    modelUnderTest.getName());
        test.getCode().addStatement("$L " + variable + "3 = new $L(" + fieldValues2 + ")", modelUnderTest.getName(),
                                    modelUnderTest.getName());
        test.getCode().addStatement("assertNotNull(" + variable + "1)");
        test.getCode().addStatement("assertNotNull(" + variable + "2)");
        test.getCode().addStatement("assertNotNull(" + variable + "3)");
        test.getCode().addStatement("assertNotSame(" + variable + "2, " + variable + "1)");
        test.getCode().addStatement("assertNotSame(" + variable + "3, " + variable + "1)");
        test.getCode().addStatement("assertEquals(" + variable + "2, " + variable + "1)");
        test.getCode().addStatement("assertEquals(" + variable + "2, " + variable + "1)");
        test.getCode().addStatement("assertEquals(" + variable + "1, " + variable + "2)");
        test.getCode().addStatement("assertEquals(" + variable + "1, " + variable + "1)");
        test.getCode().addStatement("assertFalse(" + variable + "1.equals(null))");
        test.getCode().addStatement("assertNotEquals(" + variable + "3, " + variable + "1)");
        addExceptionHandlingEnd(test);
        addTest(test);
    }

    /**
     * Generating a test for the hashCode method.
     * <p>
     * See <a href=
     * "https://www.javabrahman.com/corejava/understanding-equals-and-hashcode-contract-when-using-collections-in-java/">Tests
     * hash code contract</a>
     * <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()">Official specification</a>
     */
    private void generateHashCodeTest() {
        final Method method = modelUnderTest.fetchMethod(MethodHashCode.IDENTIFIER);
        if (method == null) {
            return;
        }
        final MethodTest test = new MethodTest(MethodHashCode.IDENTIFIER, methodUnderTestContainsCustomCode()
                                                                          || modelUnderTest.needsFieldCustomisation());

        final List<String> values = ValueGenerator.generateModelFieldValues(modelUnderTest);
        final String variable = modelUnderTest.getName().toLowerCase().replace(" ", "").trim();
        final String fieldValues = String.join("," + System.lineSeparator(), values);
        addExceptionHandlingStart(test);
        test.getCode().addStatement("$L " + variable + "1 = new $L(" + fieldValues + ")", modelUnderTest.getName(),
                                    modelUnderTest.getName());
        test.getCode().addStatement("$L " + variable + "2 = new $L(" + fieldValues + ")", modelUnderTest.getName(),
                                    modelUnderTest.getName());
        test.getCode().addStatement("assertNotNull(" + variable + "1)");
        test.getCode().addStatement("assertNotNull(" + variable + "2)");
        test.getCode().addStatement("assertNotSame(" + variable + "2, " + variable + "1)");
        test.getCode().addStatement("assertEquals(" + variable + "2, " + variable + "1)");
        test.getCode().addStatement("assertEquals(" + variable + "2.hashCode(), " + variable + "1.hashCode())");
        test.getCode().addStatement("int hashCode = " + variable + "1.hashCode()");
        test.getCode().beginControlFlow("for (int i = 0; i < $L ; i++)", Integer.valueOf(5));
        test.getCode().addStatement("assertEquals(hashCode, " + variable + "1.hashCode())");
        test.getCode().endControlFlow();
        addExceptionHandlingEnd(test);
        addTest(test);
    }

    protected boolean methodUnderTestContainsCustomCode() {
        final Method m = modelUnderTest.fetchMethod(MethodHashCode.IDENTIFIER);
        return m == null ? false : m.containsCustomCode();
    }

    private void generateIsValid() {
        final Method method = modelUnderTest.fetchMethod(MethodIsValid.IDENTIFIER);
        if (method == null) {
            return;
        }
        final MethodTest test = new MethodTest(MethodIsValid.IDENTIFIER,
                                               method.containsCustomCode() || modelUnderTest.needsFieldCustomisation());

        final String variable = modelUnderTest.getName().toLowerCase().replace(" ", "").trim();
        final String fieldValues = String.join("," + System.lineSeparator(),
                                               ValueGenerator.generateModelFieldValues(modelUnderTest));
        test.getCode().addStatement("$L " + variable + " = new $L(" + fieldValues + ")", modelUnderTest.getName(),
                                    modelUnderTest.getName());
        test.getCode().addStatement("assertTrue(" + variable + "." + MethodIsValid.IDENTIFIER + "())");
        final List<String> incorrectValues = ValueGenerator.generateModelFieldWithInvalidValues(modelUnderTest);
        if (incorrectValues != null) {

            test.getCode()
                .addStatement("$L " + variable + "Invalid = new $L("
                              + String.join("," + System.lineSeparator(), incorrectValues) + ")",
                              modelUnderTest.getName(), modelUnderTest.getName());
            test.getCode().addStatement("assertFalse(" + variable + "Invalid." + MethodIsValid.IDENTIFIER + "())");
        }
        addTest(test);
    }

    public String getFullName() {
        return modelUnderTest.hasPackageName() ? modelUnderTest.getPackageName() + "." + getName() : getName();
    }

    public Model getModelUnderTest() {
        return modelUnderTest;
    }

    /**
     * @return the specificationBuilder
     */
    public TypeSpec.Builder getSpecificationBuilder() {
        return specificationBuilder;
    }

    /**
     * @param specificationBuilder
     *            the specificationBuilder to set
     */
    public void setSpecificationBuilder(TypeSpec.Builder specificationBuilder) {
        this.specificationBuilder = specificationBuilder;
    }

    protected void initialiseBuilder() {
        if (specificationBuilder == null) {
            specificationBuilder = TypeSpec.classBuilder(name).addModifiers(Modifier.PUBLIC);
            generateDocumentation();
        }
    }

    protected void generateDocumentation() {
        specificationBuilder.addJavadoc(generateClassJavadocComment(hasDescription(), description, hasLongDescription(),
                                                                    longDescription));
    }

    public String getPackageName() {
        return modelUnderTest.getPackageName();
    }

    private static String generateClassJavadocComment(boolean hasDescription, String description,
                                                      boolean hasLongDescription, String longDescription) {
        StringBuilder builder = new StringBuilder();
        if (hasDescription) {
            builder.append(description);
        }
        if (hasLongDescription) {
            builder.append(System.lineSeparator()).append("<p>").append(System.lineSeparator());
            builder.append(longDescription);
        }
        return builder.toString();
    }

    protected void translateTests() throws TranslationException {
        for (final Method m : getTestList()) {
            m.translate();
            specificationBuilder.addMethod(m.getSpecificationBuilder().build());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Entity#translate()
     */
    @Override
    public void translate() throws TranslationException {
        if (modelUnderTest == null) {
            throw new TranslationException("The model under test was not specified");
        }
        initialiseBuilder();
        translateTests();
    }

}
