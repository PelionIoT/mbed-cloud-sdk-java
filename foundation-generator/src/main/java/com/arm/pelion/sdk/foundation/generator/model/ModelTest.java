package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.TypeSpec;

public class ModelTest extends AbstractModelEntity {
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
        // generateCloneTest();
        // generateEqualsTest();
        // generateHashCodeTest();
        // generateIsValid();
    }

    // private void generateCloneTest() {
    // final MethodTest test = new MethodTest("testClone", "Tests the clone method",
    // modelUnderTest.fetchMethod(identifier))
    //
    // }

    public String getFullName() {
        return modelUnderTest.hasPackageName() ? modelUnderTest.getPackageName() + "." + getName() : getName();
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
