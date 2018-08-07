package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Required;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;

public class Method extends AbstractModelEntity {

    private MethodSpec.Builder specificationBuilder;

    private String statement;
    private ParameterType returnType;
    private String returnDescription;
    private final List<Parameter> parameters;
    private CodeBlock.Builder code;
    private boolean isRequired;

    public Method(boolean isReadOnly, String name, String description, String longDescription, boolean isStatic,
                  boolean isAccessible, boolean isAbstract, boolean containsCustomCode, boolean needsCustomCode,
                  boolean isInternal, boolean isRequired) {
        super(isReadOnly, name, description, longDescription, isStatic, isAccessible, isAbstract, containsCustomCode,
              needsCustomCode, isInternal);
        parameters = new LinkedList<>();
        setStatement(null);
        setReturnType(null);
        setCode(null);
        setRequired(isRequired);
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
    public ParameterType getReturnType() {
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

    public <T extends Method> T statement(String aStatement) {
        setStatement(aStatement);
        return (T) this;
    }

    /**
     * @param returnType
     *            the returnType to set
     */
    public void setReturnType(ParameterType returnType) {
        this.returnType = returnType;
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
        specificationBuilder.addModifiers(isAccessible ? Modifier.PUBLIC : Modifier.PROTECTED);
        if (isStatic) {
            specificationBuilder.addModifiers(Modifier.STATIC);
        }
        if (isAbstract) {
            specificationBuilder.addModifiers(Modifier.ABSTRACT);
        }
        if (containsCustomCode) {
            specificationBuilder.addAnnotation(Override.class);
        }
        if (isInternal) {
            specificationBuilder.addAnnotation(Internal.class);
        }
        if (isRequired) {
            specificationBuilder.addAnnotation(Required.class);
        }
    }

    protected void addParameters() throws TranslationException {
        if (hasDescription()) {
            specificationBuilder.addJavadoc(description + System.lineSeparator());
            if (hasLongDescription()) {
                specificationBuilder.addJavadoc("<p>" + System.lineSeparator() + longDescription
                                                + System.lineSeparator());
            }
        }
        if (hasParameters()) {
            for (final Parameter parameter : parameters) {
                parameter.translate();
                specificationBuilder.addParameter(parameter.getSpecification().build());
                specificationBuilder.addJavadoc("@param " + parameter.getName() + " " + parameter.getDescription()
                                                + System.lineSeparator());
            }
        }
        if (hasReturn()) {
            returnType.translate();
            if (returnType.hasClass()) {
                specificationBuilder.returns(returnType.getClazz());
            } else {
                specificationBuilder.returns(returnType.getTypeName());
            }
            specificationBuilder.addJavadoc(" @return "
                                            + String.valueOf(hasReturnDescription() ? returnDescription : "something")
                                            + System.lineSeparator());
        }

    }

    protected void translateCode() {
        // TODO Implement
    }

    protected void addCode() {
        if (isAbstract) {
            return;
        }
        if (containsCustomCode) {
            specificationBuilder.addStatement("// TODO Auto-generated method stub.");
            if (hasReturn()) {
                specificationBuilder.addStatement("return null");
            }
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
        if (hasCode()) {
            translateCode();
            specificationBuilder.addCode(code.build());
        }
    }

    @Override
    public void translate() throws TranslationException {
        initialiseBuilder();
        addParameters();
        addModifiers();
        addCode();
    }

    public String generateSignature() {
        return name + "("
               + String.join(",", parameters.stream().map(p -> p.getType().getShortName()).collect(Collectors.toList()))
               + ")";
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
