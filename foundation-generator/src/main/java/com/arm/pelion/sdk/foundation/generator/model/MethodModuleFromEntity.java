package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModuleFromEntity extends MethodModuleCloudApi {

    public static final String METHOD_ID_PREFIX = "overloaded";

    public MethodModuleFromEntity(MethodModuleCloudApi methodBasedOn, List<Parameter> methodParameters,
                                  boolean enforceModelValidity) {
        super(methodBasedOn.currentModel, methodBasedOn.adapterFetcher, methodBasedOn.getName(),
              methodBasedOn.description,
              generateLongDescription(methodBasedOn.getName(), methodBasedOn.methodParameters),
              methodBasedOn.needsCustomCode(), methodBasedOn.endpoints, methodBasedOn.endpointVariableName,
              methodBasedOn.lowLevelModule, methodParameters, methodBasedOn.methodParameters,
              methodBasedOn.parameterRenames, methodBasedOn.lowLevelMethod, enforceModelValidity);
    }

    private static String generateLongDescription(String name, List<Parameter> methodParameters) {
        final StringBuilder builder = new StringBuilder("Similar to  {@link #").append(name).append("(");
        boolean start = true;
        for (Parameter p : methodParameters) {
            if (start) {
                start = false;
            } else {
                builder.append(", ");
            }
            builder.append(p.getType().getShortName());
        }
        builder.append(")}");
        return builder.toString();
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        final List<Parameter> clonedMethodParameters = new ArrayList<>(methodParameters.size());
        methodParameters.forEach(p -> clonedMethodParameters.add(p.clone()));
        final Parameter entityParameter = currentModel.toParameter().setAsNonNull(true);
        if (!clonedMethodParameters.stream().anyMatch(p -> entityParameter.getIdentifier().equals(p.getIdentifier()))) {
            clonedMethodParameters.add(entityParameter);
        }
        return clonedMethodParameters;
    }

    @Override
    public String getIdentifier() {
        return generateIdentifier(super.getIdentifier());
    }

    public static String generateIdentifier(String methodIdentifier) {
        return METHOD_ID_PREFIX + methodIdentifier;
    }

    @Override
    protected void generateMethodCode() throws TranslationException {
        final String entityVariableName = generateFinalVariable(currentModel.toParameter().getName());
        final List<Object> callElements = new LinkedList<>();
        final StringBuilder builder = new StringBuilder();
        builder.append(hasReturn() ? "return " : "").append(" $L(");
        callElements.add(getName());
        boolean start = true;
        for (Parameter p : allParameters) {
            if (start) {
                start = false;
            } else {
                builder.append(", ");
            }
            if (methodParameters.stream().anyMatch(arg -> p.equals(arg))) {
                builder.append("$L");
                callElements.add(generateFinalVariable(p.getName()));
            } else {
                builder.append("$L.$L()");
                callElements.add(entityVariableName);
                callElements.add(MethodGetter.getCorrespondingGetterMethodName(p.getName(), p.getType().isBoolean()));
            }
        }
        builder.append(")");
        code.addStatement(builder.toString(), callElements.toArray());
    }

    @Override
    public String toString() {
        return "MethodModuleFromEntity ";
    }

}
