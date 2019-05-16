package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class MethodModuleFromEntity extends MethodModuleCloudApi {

    private static final String TRANSLATION_TEMPLATE = "$T.$L($L.$L())";
    private static final String GETTER_TEMPLATE = "$L.$L()";

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
        final Model entity = method.currentModel;
        final String entityVariableName = method.generateFinalVariable(entity.toParameter().getName());
        final TypeParameter currentEntityType = entity.toType();
        try {
            currentEntityType.translate();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            // Nothing to do
        }
        final List<Object> callElements = new LinkedList<>();
        final StringBuilder builder = new StringBuilder();
        builder.append(method.hasReturn() ? "return " : "").append(" $L(");
        callElements.add(method.getName());
        boolean start = true;
        for (Parameter p : method.allParameters) {
            final String parameterName = p.getName();
            final Field entityField = entity.fetchField(parameterName);
            final TypeParameter entityFieldType = entityField == null ? null : entityField.getType();
            final TypeParameter parameterType = p.getType();
            if (start) {
                start = false;
            } else {
                builder.append(", ");
            }
            if (method.methodParameters.stream().anyMatch(arg -> p.equals(arg))) {
                if (!entityVariableName.equals(parameterName) || parameterType.equals(currentEntityType)) {
                    builder.append("$L");
                    callElements.add(method.generateFinalVariable(parameterName));
                } else {
                    // Bit of a hack in case the Id is not called Id but called as the entity name
                    if (parameterType.isString()) {
                        builder.append(GETTER_TEMPLATE);
                        callElements.add(entityVariableName);
                        callElements.add(MethodGetter.getCorrespondingGetterMethodName(Field.IDENTIFIER_NAME, false,
                                                                                       false));
                    } else {
                        throw new TranslationException("Cannot determine what the following parameter is " + p);
                    }
                }
            } else if (parameterType.isModel() && parameterType.equals(currentEntityType)) {
                builder.append("$L");
                callElements.add(entityVariableName);
            } else {
                if (entityField.isIdentifier()) {
                    if (parameterType.isEnum()) {
                        builder.append(TRANSLATION_TEMPLATE);
                        callElements.add(parameterType.hasClass() ? parameterType.getClazz()
                                                                  : parameterType.getTypeName());
                        callElements.add(SdkEnum.METHOD_GET_VALUE_FROM_STRING);
                    } else if (parameterType.isNumber()) {
                        builder.append(TRANSLATION_TEMPLATE);
                        callElements.add(TranslationUtils.class);
                        if (parameterType.isDecimal()) {
                            callElements.add(TranslationUtils.METHOD_CONVERT_NUMBER_TO_DOUBLE);
                        } else if (parameterType.isInteger()) {
                            callElements.add(TranslationUtils.METHOD_CONVERT_NUMBER_TO_INT);
                        } else {
                            callElements.add(TranslationUtils.METHOD_CONVERT_NUMBER_TO_LONG);
                        }
                    } else if (parameterType.isBoolean()) {
                        builder.append(TRANSLATION_TEMPLATE);
                        callElements.add(TranslationUtils.class);
                        callElements.add(TranslationUtils.METHOD_CONVERT_BOOL_TO_BOOL);
                    } else if (parameterType.isBinary()) {
                        builder.append(TRANSLATION_TEMPLATE);
                        callElements.add(TranslationUtils.class);
                        callElements.add(TranslationUtils.METHOD_CONVERT_ANY_TO_BYTE_ARRAY);
                    } else if (parameterType.isBase64()) {
                        builder.append(TRANSLATION_TEMPLATE);
                        callElements.add(TranslationUtils.class);
                        callElements.add(TranslationUtils.METHOD_CONVERT_ANY_TO_BASE64);
                    } else {
                        builder.append(GETTER_TEMPLATE);
                    }
                } else {
                    if (TypeUtils.areSame(entityFieldType, parameterType)) {
                        builder.append(GETTER_TEMPLATE);
                    } else {
                        if (parameterType.isEnum()) {
                            builder.append(TRANSLATION_TEMPLATE);
                            callElements.add(parameterType.hasClass() ? parameterType.getClazz()
                                                                      : parameterType.getTypeName());
                            callElements.add(SdkEnum.METHOD_GET_VALUE_FROM_STRING);
                        } else if (parameterType.isString()) {
                            builder.append(TRANSLATION_TEMPLATE);
                            callElements.add(TranslationUtils.class);
                            callElements.add(TranslationUtils.METHOD_CONVERT_ANY_TO_STRING);
                        } else {
                            builder.append(GETTER_TEMPLATE);
                        }
                    }
                }

                callElements.add(entityVariableName);
                callElements.add(MethodGetter.getCorrespondingGetterMethodName(parameterName, parameterType.isBoolean(),
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
