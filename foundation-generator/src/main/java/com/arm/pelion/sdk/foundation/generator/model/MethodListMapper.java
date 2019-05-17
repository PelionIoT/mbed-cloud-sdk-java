package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeSpec;

public class MethodListMapper extends MethodMapper {
    private final String getMapperMethodName;
    private final Model adapterModel;
    private final Model fromToContent;

    public MethodListMapper(String name, String getMapperMethodName, boolean isAccessible, Model currentModel,
                            Model fromTo, Model fromToContent, Model adapterModel) {
        super(name, MethodAction.LIST, isAccessible, currentModel, fromTo, false, null, null);
        this.adapterModel = adapterModel;
        this.getMapperMethodName = getMapperMethodName;
        this.fromToContent = fromToContent;
    }

    @Override
    protected void setReturn(Model currentModel, Model fromTo, boolean isFromModel) {
        setReturnType(new TypeListResponse(currentModel.toType()));
        setReturnDescription("mapped list response");
    }

    @Override
    protected void translateCode() throws TranslationException {
        final TypeParameter adapterType = adapterModel.toType();
        final TypeParameter fromType = fromTo.toType();
        final TypeParameter toType = currentModel.toType();
        final TypeParameter tempType = new TypeListResponse(fromToContent.toType()).respList();
        adapterType.translate();
        fromType.translate();
        toType.translate();
        tempType.translate();
        final String localVariable1 = "respList";
        final String localVariable2 = "finalList";
        code.addStatement("final $T $L = $L", fromType.hasClass() ? fromType.getClazz() : fromType.getTypeName(),
                          localVariable2, PARAMETER_NAME);
        final TypeSpec.Builder respListDef = TypeSpec.anonymousClassBuilder("");
        if (tempType.hasClass()) {
            respListDef.addSuperinterface(tempType.getClazz());
        } else {
            respListDef.addSuperinterface(tempType.getTypeName());
        }
        for (java.lang.reflect.Method m : getRespMethodList()) {
            // Use for loop for exception reason
            final Method method = generateMethod(m, fromType.getClazz(), fromToContent.toType(), localVariable2);
            if (method != null) {
                method.translate();
                respListDef.addMethod(method.getSpecificationBuilder().build());
            }
        }
        code.addStatement("final $T $L = $L", tempType.hasClass() ? tempType.getClazz() : tempType.getTypeName(),
                          localVariable1, respListDef.build());
        code.addStatement("return $T.$L($L,$T.$L())", GenericAdapter.class, GenericAdapter.MAP_LIST_FUNCTION_NAME,
                          localVariable1, adapterType.getTypeName(), getMapperMethodName);
    }

    private List<java.lang.reflect.Method> getRespMethodList() {
        return Arrays.asList(RespList.class.getDeclaredMethods()).stream()
                     .sorted(Comparator.comparing(java.lang.reflect.Method::getName))
                     .collect(java.util.stream.Collectors.toList());
    }

    private static Method generateMethod(java.lang.reflect.Method methodOfInterest, Class<?> sourceClass,
                                         TypeParameter componentType,
                                         String localVariableFrom) throws TranslationException {
        if (methodOfInterest == null) {
            return null;
        }
        final Method method = new Method(methodOfInterest, null, null, true, false);
        method.setAbstract(false);
        final TypeParameter returnType = TypeFactory.getCorrespondingType(methodOfInterest.getReturnType(),
                                                                          componentType);
        final boolean isBoolean = returnType.isBoolean();
        method.setReturnType(returnType);
        method.initialiseCodeBuilder();

        final String fieldName = MethodGetter.getCorrespondingFieldName(methodOfInterest);
        try {
            final java.lang.reflect.Method correspondingMethod = sourceClass == null ? null
                                                                                     : sourceClass.getDeclaredMethod(MethodGetter.getCorrespondingGetterMethodName(fieldName,
                                                                                                                                                                   isBoolean,
                                                                                                                                                                   false));
            final TypeParameter lowLevelReturnType = TypeFactory.getCorrespondingType(correspondingMethod.getReturnType());
            lowLevelReturnType.translate();
            if (!lowLevelReturnType.equals(returnType) && !lowLevelReturnType.isComposed()) {
                if (returnType.isString()) {
                    method.getCode().addStatement("return ($L == null) ? null : $L.$L().toString()", localVariableFrom,
                                                  localVariableFrom, correspondingMethod.getName());
                } else {
                    throw new TranslationException("Mapper error: Cannot convert " + lowLevelReturnType + " into "
                                                   + returnType);
                }
            } else {
                method.getCode().addStatement("return ($L == null) ? null : $L.$L()", localVariableFrom,
                                              localVariableFrom, correspondingMethod.getName());
            }
        } catch (@SuppressWarnings("unused") NoSuchMethodException | SecurityException
                                             | NullPointerException exception) {
            if (isBoolean) {
                method.getCode().addStatement("return false");
            } else {
                method.getCode().addStatement("return null");
            }
        }
        return method;
    }

}
