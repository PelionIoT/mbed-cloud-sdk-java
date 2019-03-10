package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleDefault extends MethodModuleCloudApi {

    public MethodModuleDefault(MethodModuleCloudApi methodBasedOn) {
        super(methodBasedOn.currentModel, methodBasedOn.adapterFetcher, methodBasedOn.getName(),
              methodBasedOn.description, Utils.generateDocumentationMethodLink(null, methodBasedOn),
              methodBasedOn.needsCustomCode(), methodBasedOn.endpoints, methodBasedOn.endpointVariableName,
              methodBasedOn.lowLevelModule, null, methodBasedOn.methodParameters, methodBasedOn.parameterRenames,
              methodBasedOn.lowLevelMethod, false);
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        return extendParameterList(allParameters);
    }

    public static List<Parameter> extendParameterList(List<Parameter> methodParameters) {
        return methodParameters == null ? null : methodParameters.stream().filter(p -> p.isSetAsNonNull())
                                                                 .map(p -> p.clone()).collect(Collectors.toList());
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
            builder.append("$L");
            if (method.methodParameters.stream().anyMatch(arg -> p.equals(arg))) {
                callElements.add(p.getName());
            } else {
                callElements.add(p.getJavaDefaultValue());
            }
        }
        builder.append(")");
        method.code.addStatement(builder.toString(), callElements.toArray());
    }

    @Override
    public String toString() {
        return "MethodModuleDefault ";
    }

}
