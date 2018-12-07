package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;

import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.TypeSpec;

public class MethodListMapper extends MethodMapper {
    private final String getMapperMethodName;
    private final Model adapterModel;
    private final Model fromToContent;

    public MethodListMapper(String name, String getMapperMethodName, boolean isAccessible, Model currentModel,
                            Model fromTo, Model fromToContent, Model adapterModel) {
        super(name, isAccessible, currentModel, fromTo, false, null, null);
        this.adapterModel = adapterModel;
        this.getMapperMethodName = getMapperMethodName;
        this.fromToContent = fromToContent;
    }

    @Override
    protected void setReturn(Model currentModel, Model fromTo, boolean isFromModel) {
        setReturnType(new ListResponseType(currentModel.toType()));
        setReturnDescription("mapped list response");
    }

    @Override
    protected void translateCode() throws TranslationException {
        final ParameterType adapterType = adapterModel.toType();
        final ParameterType fromType = fromTo.toType();
        final ParameterType toType = currentModel.toType();
        final ParameterType tempType = new ListResponseType(fromToContent.toType()).respList();
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
        for (java.lang.reflect.Method m : Arrays.asList(RespList.class.getDeclaredMethods())) {
            // Use for loop for exception reason
            final Method method = generateMethod(m, fromType.getClazz(), fromToContent.toType(), localVariable2);
            if (method != null) {
                method.translate();
                respListDef.addMethod(method.getSpecificationBuilder().build());
            }
        }

        code.addStatement("final $T $L = $T", tempType.hasClass() ? tempType.getClazz() : tempType.getTypeName(),
                          localVariable1, respListDef.build());
        code.addStatement("return $T.$L($L,$T.$L()", GenericAdapter.class, GenericAdapter.MAP_LIST_FUNCTION_NAME,
                          localVariable1, adapterType.getTypeName(), getMapperMethodName);
    }

    private static Method generateMethod(java.lang.reflect.Method methodOfInterest, Class<?> sourceClass,
                                         ParameterType componentType,
                                         String localVariableFrom) throws TranslationException {
        if (methodOfInterest == null) {
            return null;
        }
        final Method method = new Method(methodOfInterest, null, null, true);
        final ParameterType returnType = TypeFactory.getCorrespondingType(methodOfInterest.getReturnType());
        if (returnType.isList()) {
            ((ListType) returnType).setContentType(componentType);
        }
        final boolean isBoolean = returnType.isBoolean();
        method.setReturnType(returnType);
        method.initialiseCodeBuilder();

        final String fieldName = MethodGetter.getCorrespondingFieldName(methodOfInterest);
        try {
            final java.lang.reflect.Method correspondingMethod = sourceClass == null ? null
                                                                                     : sourceClass.getDeclaredMethod(MethodGetter.getCorrespondingGetterMethodName(fieldName,
                                                                                                                                                                   isBoolean));
            method.getCode().addStatement("($L == null) ? null : $L.$L()", localVariableFrom, localVariableFrom,
                                          correspondingMethod.getName());
        } catch (NoSuchMethodException | SecurityException | NullPointerException exception) {
            if (isBoolean) {
                method.getCode().addStatement("return false");
            } else {
                method.getCode().addStatement("return null");
            }
        }
        return method;
    }

}
