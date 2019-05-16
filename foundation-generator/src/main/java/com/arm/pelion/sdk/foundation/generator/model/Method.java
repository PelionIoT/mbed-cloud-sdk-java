package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.NotImplemented;
import com.arm.mbed.cloud.sdk.annotations.PerformsNoOperation;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.NotImplementedException;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeVariableName;

public class Method extends AbstractSdkArtifact {

    protected MethodSpec.Builder specificationBuilder;

    protected String statement;
    protected TypeParameter returnType;
    protected String returnDescription;
    protected final List<Parameter> parameters;
    protected CodeBlock.Builder code;
    protected boolean isRequired;
    protected boolean isAnOverride;
    protected boolean shouldTest;
    protected boolean doesNotPerformAnything;
    protected boolean isUnchecked;
    protected boolean needsToBeAtBottomLevel;
    protected boolean shouldUseVarargs;
    protected final List<Class<?>> exceptions;
    private boolean ignoreShortName;
    private boolean forcePrivate;
    private boolean ignoreResourceClosure;
    private boolean ignoreMethodLength;

    public Method(boolean isReadOnly, String name, String description, String longDescription, boolean isStatic,
                  boolean isAccessible, boolean isAbstract, boolean containsCustomCode, boolean needsCustomCode,
                  boolean isInternal, boolean isRequired, boolean isAnOverride) {
        super(isReadOnly, name, description, longDescription, isStatic, isAccessible, isAbstract, containsCustomCode,
              needsCustomCode, isInternal);
        parameters = new LinkedList<>();
        exceptions = new LinkedList<>();
        setStatement(null);
        setReturnType(null);
        setReturnDescription(null);
        setCode(null);
        setRequired(isRequired);
        setAsOverride(isAnOverride);
        shouldTest(false);
        setDoesNotPerformAnything(false);
        setUnchecked(false);
        setNeedsToBeAtBottomLevel(false);
        setIgnoreShortName(false);
        setForcePrivate(false);
        setIgnoreResourceClosure(false);
        shouldUseVarargs(false);
        setIgnoreMethodLength(false);
    }

    public Method(java.lang.reflect.Method method, String description, String longDescription, boolean isAnOverride,
                  boolean autodefineParameters) {
        this(java.lang.reflect.Modifier.isFinal(method.getModifiers()), method.getName(),
             description == null ? "Executes " + method.getName() : description, longDescription,
             java.lang.reflect.Modifier.isStatic(method.getModifiers()),
             java.lang.reflect.Modifier.isPublic(method.getModifiers()),
             java.lang.reflect.Modifier.isAbstract(method.getModifiers()), false, false,
             method.isAnnotationPresent(Internal.class), method.isAnnotationPresent(Required.class), isAnOverride);
        exceptions.addAll(Arrays.asList(method.getExceptionTypes()));
        if (returnsObjects(method)) {
            setReturnType(TypeFactory.getCorrespondingType(method.getReturnType(), method.getGenericReturnType()));
        }
        if (autodefineParameters) {
            if (method.getParameterCount() > 0) {
                Arrays.asList(method.getParameters()).forEach(arg -> addParameter(new Parameter(arg)));
            }
        }
    }

    private static boolean returnsObjects(java.lang.reflect.Method m) {
        return m.getReturnType() != Void.class && m.getReturnType() != void.class;
    }

    public void initialiseCodeBuilder() {
        setCode(CodeBlock.builder());
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

    public boolean doesNotPerformAnything() {
        return doesNotPerformAnything;
    }

    public void setDoesNotPerformAnything(boolean doesNotPerformAnything) {
        this.doesNotPerformAnything = doesNotPerformAnything;
    }

    public boolean ignoreShortName() {
        return ignoreShortName;
    }

    public void setIgnoreShortName(boolean ignoreShortName) {
        this.ignoreShortName = ignoreShortName;
    }

    public boolean isIgnoreResourceClosure() {
        return ignoreResourceClosure;
    }

    public boolean isConstructor() {
        return false;
    }

    public void setIgnoreResourceClosure(boolean ignoreResourceClosure) {
        this.ignoreResourceClosure = ignoreResourceClosure;
    }

    public boolean isIgnoreMethodLength() {
        return ignoreMethodLength;
    }

    public void setIgnoreMethodLength(boolean ignoreMethodLength) {
        this.ignoreMethodLength = ignoreMethodLength;
    }

    public boolean isForcePrivate() {
        return forcePrivate;
    }

    public void setForcePrivate(boolean forcePrivate) {
        this.forcePrivate = forcePrivate;
    }

    public boolean isShouldUseVarargs() {
        return shouldUseVarargs;
    }

    public void shouldUseVarargs(boolean shouldUseVarargs) {
        this.shouldUseVarargs = shouldUseVarargs;
    }

    @SuppressWarnings("unchecked")
    public <T extends Method> T forcePrivate() {
        setForcePrivate(true);
        return (T) this;
    }

    /**
     * @return the specificationBuilder
     */
    public MethodSpec.Builder getSpecificationBuilder() {
        return specificationBuilder;
    }

    /**
     * @param specificationBuilder
     *            the specificationBuilder to set
     */
    public void setSpecificationBuilder(MethodSpec.Builder specificationBuilder) {
        this.specificationBuilder = specificationBuilder;
    }

    public boolean hasStatement() {
        return has(statement);
    }

    public boolean hasReturnDescription() {
        return has(returnDescription);
    }

    /**
     * @return the isAnOverride
     */
    public boolean isAnOverride() {
        return isAnOverride;
    }

    /**
     * @param isAnOverride
     *            the isAnOverride to set
     */
    public void setAsOverride(boolean isAnOverride) {
        this.isAnOverride = isAnOverride;
    }

    /**
     * @return the shouldTest
     */
    public boolean isShouldTest() {
        return shouldTest;
    }

    public boolean isUnchecked() {
        return isUnchecked;
    }

    public void setUnchecked(boolean isUnchecked) {
        this.isUnchecked = isUnchecked;
    }

    /**
     * @param shouldTest
     *            the shouldTest to set
     */
    public void shouldTest(boolean shouldTest) {
        this.shouldTest = shouldTest;
    }

    public boolean needsToBeAtBottomLevel() {
        return needsToBeAtBottomLevel;
    }

    public void setNeedsToBeAtBottomLevel(boolean needsToBeAtBottomLevel) {
        this.needsToBeAtBottomLevel = needsToBeAtBottomLevel;
    }

    /**
     * @return the returnDescription
     */
    public String getReturnDescription() {
        return returnDescription;
    }

    /**
     * @param returnDescription
     *            the returnDescription to set
     */
    public void setReturnDescription(String returnDescription) {
        this.returnDescription = returnDescription;
    }

    @SuppressWarnings("unchecked")
    public <T extends Method> T returnDescription(String returnDesc) {
        setReturnDescription(returnDesc);
        return (T) this;
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

    public boolean hasCode() {
        return code != null;
    }

    public boolean hasParameters() {
        return !parameters.isEmpty();
    }

    public boolean hasParameterOfType(TypeParameter type) {
        return type == null ? false : parameters.stream().anyMatch(p -> p.getType().isEquivalent(type));
    }

    public int getParameterCount() {
        return parameters.size();
    }

    /**
     * @return the statement
     */
    public String getStatement() {
        return statement;
    }

    public boolean hasReturn() {
        return returnType != null;
    }

    /**
     * @return the returnType
     */
    public TypeParameter getReturnType() {
        return returnType;
    }

    /**
     * @return the parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    public void addParameter(Parameter parameter) {
        if (parameter == null) {
            return;
        }
        parameters.add(parameter);
    }

    /**
     * @return the code
     */
    public CodeBlock.Builder getCode() {
        return code;
    }

    /**
     * @param statement
     *            the statement to set
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    @SuppressWarnings("unchecked")
    public <T extends Method> T statement(String aStatement) {
        setStatement(aStatement);
        return (T) this;
    }

    public <T extends Exception> void addException(Class<T> exception) {
        exceptions.add(exception);
    }

    /**
     * @param returnType
     *            the returnType to set
     */
    public void setReturnType(TypeParameter returnType) {
        this.returnType = returnType;
    }

    @SuppressWarnings("unchecked")
    public <T extends Method> T returnType(TypeParameter theReturnType) {
        setReturnType(theReturnType);
        return (T) this;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(CodeBlock.Builder code) {
        this.code = code;
    }

    protected void initialiseBuilder() {
        if (specificationBuilder == null) {
            specificationBuilder = MethodSpec.methodBuilder(name);
        }
    }

    protected void addModifiers() {
        if (needsModifier) {
            specificationBuilder.addModifiers(isAccessible ? Modifier.PUBLIC
                                                           : forcePrivate ? Modifier.PRIVATE : Modifier.PROTECTED);
        }
        if (isStatic) {
            specificationBuilder.addModifiers(Modifier.STATIC);
        }
        if (isReadOnly) {
            specificationBuilder.addModifiers(Modifier.FINAL);
        }
        if (isAbstract) {
            specificationBuilder.addModifiers(Modifier.ABSTRACT);
        }
        addAnnotations();
    }

    public boolean throwsExceptions() {
        return !exceptions.isEmpty();
    }

    protected void addAnnotations() {
        if (isAnOverride) {
            specificationBuilder.addAnnotation(Override.class);
        }
        if (isInternal) {
            specificationBuilder.addAnnotation(Internal.class);
        }
        if (isRequired) {
            specificationBuilder.addAnnotation(Required.class);
        }
        if (doesNotPerformAnything) {
            specificationBuilder.addAnnotation(PerformsNoOperation.class);
        }
        if (ignoreShortName) {
            if (getName() != null && getName().length() < 3) {
                annotationRegistry.ignoreShortMethodName();
            }
        }
        if (isUnchecked) {
            annotationRegistry.setAsUnchecked();
        }
        if (ignoreResourceClosure) {
            annotationRegistry.ignoreResourceClosure();
        }
        if (ignoreMethodLength) {
            annotationRegistry.ignoreExcessiveMethodLength();
        }
        if (hasDeprecation()) {
            specificationBuilder.addAnnotation(Deprecated.class);
        }
        addStaticAnalysisAnnotations();
    }

    @Override
    protected void addStaticAnalysisAnnotations() {
        if (annotationRegistry.hasAnnotations()) {
            specificationBuilder.addAnnotation(annotationRegistry.generateAnnotation());
        }
    }

    protected void defineMethod() throws TranslationException {
        final Map<TypeParameter, Boolean> definedTypes = new HashMap<>();
        if (hasDescription()) {
            specificationBuilder.addJavadoc(description + System.lineSeparator());
            if (hasLongDescription()) {
                specificationBuilder.addJavadoc(Utils.generateNewDocumentationLine() + longDescription
                                                + System.lineSeparator());
            }
        }
        if (hasDeprecation()) {
            specificationBuilder.addJavadoc((hasDescription() ? Utils.generateNewDocumentationLine() : "")
                                            + getDeprecation().getNotice() + System.lineSeparator());
        }
        if (hasParameters()) {
            for (final Parameter parameter : parameters) {
                parameter.translate();
                if (parameter.getType().isGeneric()) {
                    if (!definedTypes.containsKey(parameter.getType())) {
                        specificationBuilder.addTypeVariable((TypeVariableName) parameter.getType().getTypeName());
                        definedTypes.put(parameter.getType(), Boolean.TRUE);
                    }
                }
                specificationBuilder.addParameter(parameter.getSpecification().build());
                specificationBuilder.addJavadoc(parameter.getJavadocDescription() + System.lineSeparator());
            }
            if (shouldUseVarargs) {
                specificationBuilder.varargs();
            }
        }

        if (hasReturn()) {
            returnType.translate();
            if (returnType.isGeneric()) {
                if (!definedTypes.containsKey(returnType)) {
                    specificationBuilder.addTypeVariable((TypeVariableName) returnType.getTypeName());
                }
            }
            if (returnType.hasClass()) {
                specificationBuilder.returns(returnType.getClazz());
            } else {
                specificationBuilder.returns(returnType.getTypeName());
            }
            specificationBuilder.addJavadoc("@return "
                                            + String.valueOf(hasReturnDescription() ? returnDescription : "something")
                                            + System.lineSeparator());
        }
        if (throwsExceptions()) {
            exceptions.forEach(e -> {
                specificationBuilder.addException(e);
                specificationBuilder.addJavadoc("@throws " + e.getSimpleName()
                                                + " if an error occurs during the process." + System.lineSeparator());
            });

        }

    }

    @SuppressWarnings("unused")
    protected void translateCode() throws TranslationException {
        // TODO Implement
    }

    protected void addCode() throws TranslationException {
        if (isAbstract) {
            return;
        }
        if (containsCustomCode) {
            specificationBuilder.addAnnotation(NotImplemented.class);
            specificationBuilder.addStatement("// TODO Auto-generated method stub.");
            specificationBuilder.addStatement("throw new $T()", NotImplementedException.class);
            specificationBuilder.addException(NotImplementedException.class);
            if (hasCode()) {
                translateCode();
                specificationBuilder.addComment("The following code is auto-generated and can be used if carrying out what $L() intends/is meant to do.",
                                                getName());
                specificationBuilder.addCode(System.lineSeparator() + "/*");
                specificationBuilder.addCode(code.build());
                specificationBuilder.addCode("*/" + System.lineSeparator());
            }
            // TODO put back if needed
            // if (!hasCode() && hasReturn()) {
            // if (returnType.isNumber()) {
            // specificationBuilder.addStatement("return 0");
            // } else if (returnType.isBoolean()) {
            // specificationBuilder.addStatement("return false");
            // } else {
            // specificationBuilder.addStatement("return null");
            // }
            // }
            return;
        }
        if (hasStatement()) {
            if (hasParameters()) {
                Map<String,
                    ?> parametersMap = parameters.stream()
                                                 .collect(Collectors.toMap(Parameter::getName,
                                                                           p -> p.getType()
                                                                                 .hasClass() ? p.getType().getClazz()
                                                                                             : p.getType()
                                                                                                .getTypeName()));
                specificationBuilder.addNamedCode(statement, parametersMap);
            } else {
                specificationBuilder.addStatement(statement);
            }
        }
        if (hasCode() && !hasStatement()) {
            translateCode();
            specificationBuilder.addCode(code.build());
        }
    }

    @Override
    public void translate() throws TranslationException {
        initialiseBuilder();
        defineMethod();
        addModifiers();
        addCode();
    }

    public String generateSignatureForDocumentation() {
        return Utils.generateSignatureForDocumentation(name, parameters);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Method [statement=" + statement + ", returnType=" + returnType + ", returnDescription="
               + returnDescription + ", parameters=" + parameters + ", code=" + code + ", isRequired=" + isRequired
               + ", parent=" + super.toString() + "]";
    }

}
