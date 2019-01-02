package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleFromEntity extends MethodModuleCloudApi {

    public MethodModuleFromEntity(MethodModuleCloudApi methodBasedOn, List<Parameter> methodParameters,
                                  boolean enforceModelValidity) {
        super(methodBasedOn.currentModel, methodBasedOn.adapterFetcher, methodBasedOn.getName(),
              methodBasedOn.description, Utils.generateDocumentationMethodLink(null, methodBasedOn),
              methodBasedOn.needsCustomCode(), methodBasedOn.endpoints, methodBasedOn.endpointVariableName,
              methodBasedOn.lowLevelModule, methodParameters, methodBasedOn.methodParameters,
              methodBasedOn.parameterRenames, methodBasedOn.lowLevelMethod, enforceModelValidity);
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        return extendParameterList(methodParameters, currentModel);
    }

    public static List<Parameter> extendParameterList(List<Parameter> methodParameters, Model currentModel) {
        final List<Parameter> clonedMethodParameters = new ArrayList<>(methodParameters.size());
        methodParameters.forEach(p -> clonedMethodParameters.add(p.clone()));
        final Parameter entityParameter = currentModel.toParameter().setAsNonNull(true);
        if (!doesParameterExist(clonedMethodParameters, entityParameter.getIdentifier())) {
            clonedMethodParameters.add(entityParameter);
        }
        return clonedMethodParameters;
    }

    @Override
    protected boolean mustParametersBeFinal() {
        return false;
    }

    @Override
    protected void generateMethodCode() throws TranslationException {
        generateMethodCode(this);
    }

    public static void generateMethodCode(MethodModuleCloudApi method) throws TranslationException {
        final String entityVariableName = method.generateFinalVariable(method.currentModel.toParameter().getName());
        final TypeParameter currentEntityType = method.currentModel.toType();
        try {
            currentEntityType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
        }
        final List<Object> callElements = new LinkedList<>();
        final StringBuilder builder = new StringBuilder();
        builder.append(method.hasReturn() ? "return " : "").append(" $L(");
        callElements.add(method.getName());
        boolean start = true;
        for (Parameter p : method.allParameters) {
            if (start) {
                start = false;
            } else {
                builder.append(", ");
            }
            if (method.methodParameters.stream().anyMatch(arg -> p.equals(arg))) {
                if (!entityVariableName.equals(p.getName()) || p.getType().equals(currentEntityType)) {
                    builder.append("$L");
                    callElements.add(method.generateFinalVariable(p.getName()));
                } else {
                    // Bit of a hack in case the Id is not called Id but called as the entity name
                    if (p.getType().isString()) {
                        builder.append("$L.$L()");
                        callElements.add(entityVariableName);
                        callElements.add(MethodGetter.getCorrespondingGetterMethodName(Field.IDENTIFIER_NAME, false,
                                                                                       false));
                    } else {
                        throw new TranslationException("Cannot determine what the following parameter is " + p);
                    }
                }
            } else if (p.getType().isModel() && p.getType().equals(currentEntityType)) {
                builder.append("$L");
                callElements.add(entityVariableName);
            } else {
                builder.append("$L.$L()");
                callElements.add(entityVariableName);
                callElements.add(MethodGetter.getCorrespondingGetterMethodName(p.getName(), p.getType().isBoolean(),
                                                                               false));
            }
        }
        builder.append(")");
        method.code.addStatement(builder.toString(), callElements.toArray());
    }

    @Override
    public String toString() {
        return "MethodModuleFromEntity ";
    }

}
