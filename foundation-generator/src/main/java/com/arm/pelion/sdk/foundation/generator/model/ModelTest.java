package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListOptionsEncoder;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.pelion.sdk.foundation.generator.model.ValueGenerator.Values;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
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
        return modelUndertest == null ? null : Utils.combineNames(true, "test", modelUndertest.getName());
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
        generateFilterTest();
        // FIXME better handle tests depending on the type of model
        if (!(modelUnderTest instanceof ModelListOption)) {
            generateIsValid();
        }
    }

    private void initialiseVariable(final MethodTest test, final int variableNumber, final List<Object> values,
                                    final String fieldValues) {
        test.getCode()
            .addStatement("$L $L" + variableNumber + " = new $L("
                          + (ValueGenerator.DEFAULT_VALUE.equals(fieldValues) ? "(" + modelUnderTest.getName() + ")"
                                                                              : "")
                          + fieldValues + ")", values.toArray());
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
        final Values values = new Values();
        values.getValues().add(modelUnderTest.getName());
        values.getValues().add(variable);
        values.getValues().add(modelUnderTest.getName());
        ValueGenerator.generateModelFieldValues(modelUnderTest, values);
        final String fieldValues = String.join("," + System.lineSeparator(), values.getFormats());
        addExceptionHandlingStart(test);
        initialiseVariable(test, 1, values.getValues(), fieldValues);
        test.getCode().addStatement("$L $L2 = $L1.clone()", modelUnderTest.getName(), variable, variable);
        test.getCode().addStatement("assertNotNull($L1)", variable);
        test.getCode().addStatement("assertNotNull($L2)", variable);
        test.getCode().addStatement("assertNotSame($L2, $L1)", variable, variable);
        test.getCode().addStatement("assertEquals($L2, $L1)", variable, variable);
        addExceptionHandlingEnd(test);
        addTest(test);
    }

    @SuppressWarnings("incomplete-switch")
    private void generateFilterTest() {
        if (!(modelUnderTest instanceof ModelListOption) || !((ModelListOption) modelUnderTest).hasFilters()) {
            return;
        }
        final MethodTest test = new MethodTest("filters", false);
        addExceptionHandlingStart(test);
        List<Filter> filters = ((ModelListOption) modelUnderTest).getFilters();
        Values values = new Values();
        Map<String, Values> testValues = new LinkedHashMap<>();

        String variable = "option";
        values.addToFormat("$L $L = new $L()");
        values.addValue(modelUnderTest.getName());
        values.addValue(variable);
        values.addValue(modelUnderTest.getName());
        for (Filter filter : filters) {
            values.addToFormat(".$L(");
            values.addValue(MethodFilterSetFluent.generateFluentName(filter, filter.canHaveMultipleInputTypes()));
            Values filterValues = new Values();
            TypeParameter type = filter.getFieldType();
            try {
                type.translate();
            } catch (TranslationException exception) {
                exception.printStackTrace();
                continue;
            }
            type.transformIntoWrapper();
            int numberOfElements = filter.canHaveMultipleInputTypes() ? 1 + (int) (Math.random() * 9.0) : 1;
            while (numberOfElements > 0) {
                ValueGenerator.addGenerateFieldValue(type, null, filterValues);
                numberOfElements--;
            }
            if (filter.canHaveMultipleInputTypes()) {
                filterValues.setFormat("$T.asList(" + String.join(",", filterValues.getFormats()) + ")");
                List<Object> filterValue = new LinkedList<>();
                filterValue.add(Arrays.class);
                filterValue.addAll(filterValues.getValues());
                filterValues.setValues(filterValue);
            }

            testValues.put(filter.getIdentifier(), filterValues);
            values.add(filterValues);
            values.addToFormat(")");

        }
        test.getCode().addStatement(String.join("", values.getFormats()), values.getValues().toArray());
        test.getCode().addStatement("assertTrue($L.$L())", variable, FilterOptions.METHOD_HAS_FILTERS);
        for (Filter filter : filters) {
            final TypeParameter type = filter.getFieldType();
            String encodingMethod = null;
            switch (filter.getOperator()) {
                case EQUAL:
                    encodingMethod = ListOptionsEncoder.METHOD_FILTER_ENCODE_EQUAL;
                    break;
                case GREATER_THAN:
                    encodingMethod = ListOptionsEncoder.METHOD_FILTER_ENCODE_GREATER_THAN;
                    break;
                case IN:
                    encodingMethod = ListOptionsEncoder.METHOD_FILTER_ENCODE_IN;
                    break;
                case LESS_THAN:
                    encodingMethod = ListOptionsEncoder.METHOD_FILTER_ENCODE_LESS_THAN;
                    break;
                case LIKE:
                    encodingMethod = ListOptionsEncoder.METHOD_FILTER_ENCODE_LIKE;
                    break;
                case NOT_EQUAL:
                    encodingMethod = ListOptionsEncoder.METHOD_FILTER_ENCODE_NOT_EQUAL;
                    break;
                case NOT_IN:
                    encodingMethod = ListOptionsEncoder.METHOD_FILTER_ENCODE_NOT_IN;
                    break;
            }
            try {
                type.translate();
            } catch (TranslationException exception) {
                exception.printStackTrace();
                continue;
            }
            final String tagName = filter.getTag().getName();
            test.getCode().addStatement("assertTrue($L.$L($L.$L))", variable, FilterOptions.METHOD_HAS_FILTERS,
                                        modelUnderTest.getName(), tagName);
            test.getCode().addStatement("assertTrue($L.$L($L.$L,$T.$L))", variable, FilterOptions.METHOD_HAS_FILTER,
                                        modelUnderTest.getName(), tagName, FilterOperator.class,
                                        filter.getOperator().name());
            test.getCode().addStatement("assertNotNull($L.$L())", variable, MethodFilterGet.generateName(filter));
            Values assertValues = new Values();
            assertValues.addToFormat("assertEquals(");
            assertValues.add(testValues.get(filter.getIdentifier()));
            assertValues.addToFormat(", $T.$L($L.$L,$T.class,$L)");
            assertValues.addValue(Arrays.asList(ListOptionsEncoder.class, encodingMethod, modelUnderTest.getName(),
                                                tagName,
                                                filter.canHaveMultipleInputTypes() ? List.class
                                                                                   : type.hasClass() ? type.getClazz()
                                                                                                     : type.getTypeName(),
                                                variable));
            assertValues.addToFormat(")");
            test.getCode().addStatement(String.join("", assertValues.getFormats()), assertValues.getValues().toArray());

        }

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
        final String variable = modelUnderTest.getName().toLowerCase().replace(" ", "").trim();
        final Values values1 = new Values();
        final Values values2 = new Values();
        values1.addValue(modelUnderTest.getName());
        values1.addValue(variable);
        values1.addValue(modelUnderTest.getName());
        values2.addValue(modelUnderTest.getName());
        values2.addValue(variable);
        values2.addValue(modelUnderTest.getName());
        ValueGenerator.generateModelFieldValues(modelUnderTest, values1);
        ValueGenerator.generateModelFieldValues(modelUnderTest, values2);
        final String fieldValues = String.join("," + System.lineSeparator(), values1.getFormats());
        addExceptionHandlingStart(test);
        initialiseVariable(test, 1, values1.getValues(), fieldValues);
        initialiseVariable(test, 2, values1.getValues(), fieldValues);
        if (shouldCompareToDifferentInstance(values1.getFormats(), values1.getValues(), values2.getValues())) {
            initialiseVariable(test, 3, values2.getValues(), fieldValues);
        }

        test.getCode().addStatement("assertNotNull($L1)", variable);
        test.getCode().addStatement("assertNotNull($L2)", variable);
        if (shouldCompareToDifferentInstance(values1.getFormats(), values1.getValues(), values2.getValues())) {
            test.getCode().addStatement("assertNotNull($L3)", variable);
        }
        test.getCode().addStatement("assertNotSame($L2, $L1)", variable, variable);
        if (shouldCompareToDifferentInstance(values1.getFormats(), values1.getValues(), values2.getValues())) {
            test.getCode().addStatement("assertNotSame($L3, $L1)", variable, variable);
        }
        test.getCode().addStatement("assertEquals($L2, $L1)", variable, variable);
        test.getCode().addStatement("assertEquals($L2, $L1)", variable, variable);
        test.getCode().addStatement("assertEquals($L1, $L2)", variable, variable);
        test.getCode().addStatement("assertEquals($L1, $L1)", variable, variable);
        test.getCode().addStatement("assertFalse($L1.equals(null))", variable);
        if (shouldCompareToDifferentInstance(values1.getFormats(), values1.getValues(), values2.getValues())) {
            test.getCode().addStatement("assertNotEquals($L3, $L1)", variable, variable);
        }
        addExceptionHandlingEnd(test);
        addTest(test);
    }

    private boolean shouldCompareToDifferentInstance(List<String> formats, List<Object> values1, List<Object> values2) {
        if (formats.isEmpty()) {
            return false;
        }
        if (values1 == null) {
            return values2 != null;
        }
        return !values1.equals(values2);
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

        final String variable = modelUnderTest.getName().toLowerCase().replace(" ", "").trim();
        final Values values = new Values();
        values.getValues().add(modelUnderTest.getName());
        values.getValues().add(variable);
        values.getValues().add(modelUnderTest.getName());
        ValueGenerator.generateModelFieldValues(modelUnderTest, values);
        final String fieldValues = String.join("," + System.lineSeparator(), values.getFormats());
        addExceptionHandlingStart(test);
        initialiseVariable(test, 1, values.getValues(), fieldValues);
        initialiseVariable(test, 2, values.getValues(), fieldValues);
        test.getCode().addStatement("assertNotNull($L1)", variable);
        test.getCode().addStatement("assertNotNull($L2)", variable);
        test.getCode().addStatement("assertNotSame($L2, $L1)", variable, variable);
        test.getCode().addStatement("assertEquals($L2, $L1)", variable, variable);
        test.getCode().addStatement("assertEquals($L2.hashCode(), $L1.hashCode())", variable, variable);
        test.getCode().addStatement("int hashCode =  $L1.hashCode()", variable);
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
        final Values values = new Values();
        values.clear();
        values.getValues().add(modelUnderTest.getName());
        values.getValues().add(variable);
        values.getValues().add(modelUnderTest.getName());
        ValueGenerator.generateModelFieldValues(modelUnderTest, values);
        String fieldValues = String.join("," + System.lineSeparator(), values.getFormats());
        test.getCode().addStatement("$L $L = new $L(" + fieldValues + ")", values.getValues().toArray());
        test.getCode().addStatement("assertTrue($L.$L())", variable, MethodIsValid.IDENTIFIER);
        values.clear();
        values.getValues().add(modelUnderTest.getName());
        values.getValues().add(variable + "Invalid");
        values.getValues().add(modelUnderTest.getName());
        ValueGenerator.generateModelFieldWithInvalidValues(modelUnderTest, values);
        if (values.hasFormat() && modelUnderTest.hasFieldsNeedingValidation()) {
            fieldValues = String.join("," + System.lineSeparator(), values.getFormats());
            test.getCode().addStatement("$L $L = new $L(" + fieldValues + ")", values.getValues().toArray());
            test.getCode().addStatement("assertFalse($L.$L())", variable + "Invalid", MethodIsValid.IDENTIFIER);
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
        addStaticAnalysisAnnotations();
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
            builder.append(Utils.generateNewDocumentationLine());
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

    @Override
    protected void addStaticAnalysisAnnotations() {
        annotationRegistry.ignoreAvoidDuplicateLiterals();
        if (annotationRegistry.hasAnnotations()) {
            specificationBuilder.addAnnotation(annotationRegistry.generateAnnotation());
        }

    }

}
