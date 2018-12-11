package com.arm.pelion.sdk.foundation.generator.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;

public class MethodMapperEnum extends Method {

    private static final String PARAMETER_NAME = "toBeMapped";

    private boolean isFromModel;
    private Class<?> fromTo;
    private ModelEnum enumModel;

    public MethodMapperEnum(ModelEnum enumModel, Class<?> fromTo, boolean isFromModel) {
        super(false, generateName(enumModel, fromTo, isFromModel), "Maps the enum value", null, true, false, false,
              false, false, true, false, false);
        setReturnType(isFromModel ? fromTo == null ? null : new ParameterType(fromTo.getClass())
                                  : enumModel == null ? null : enumModel.toType());
        setReturnDescription("mapped enum value");
        defineParameter(enumModel, fromTo, isFromModel);
        initialiseCodeBuilder();
        this.isFromModel = isFromModel;
        this.fromTo = fromTo;
        this.enumModel = enumModel;
    }

    public static String generateName(ModelEnum enumModel2, Class<?> fromTo2, boolean isFromModel2) {
        return generateName(isFromModel2 ? fromTo2.getName() : enumModel2.getName(), isFromModel2);
    }

    protected static String generateName(String toName, boolean isLowLevel) {
        return ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake("translate_to_"
                                                                         + (isLowLevel ? toName.replace(".", "_")
                                                                                               .replace("$", "_")
                                                                                               .toLowerCase(Locale.UK)
                                                                                       : toName)),
                                            false);
    }

    public static String generateName(Field fieldModel, Field fieldLowLevel, boolean isFromModel) {

        return generateName(isFromModel ? fieldLowLevel.getType().getClazz().getName()
                                        : fieldModel.getType().getShortName(),
                            isFromModel);
    }

    protected void defineParameter(ModelEnum enumModel, Class<?> fromTo, boolean isFromModel) {
        if (enumModel == null || fromTo == null) {
            return;
        }
        addParameter(isFromModel ? enumModel.toParameter(PARAMETER_NAME) : new Parameter(PARAMETER_NAME, fromTo));
    }

    protected void translateCode() throws TranslationException {
        code.beginControlFlow("if($L == null)", PARAMETER_NAME);
        final ParameterType enumType = enumModel.toType();
        if (isFromModel) {
            code.addStatement("return null");
        } else {
            code.add("return $T.$L()", enumType.hasClass() ? enumType.getClazz() : enumType.getTypeName(),
                     "getUnknownEnum");
        }
        code.endControlFlow();
        code.beginControlFlow("switch($L)", PARAMETER_NAME);
        for (Object c : fromTo.getEnumConstants()) {
            code.add("case $L:\n", invokeEnumName(c));
            code.addStatement("return $T.$L",
                              isFromModel ? fromTo.getClass()
                                          : enumType.hasClass() ? enumType.getClazz() : enumType.getTypeName(),
                              invokeEnumName(c));
        }
        code.add("default:\n");
        if (isFromModel) {
            code.addStatement("return null");
        } else {
            code.add("return $T.$L()", enumType.hasClass() ? enumType.getClazz() : enumType.getTypeName(),
                     "getUnknownEnum");
        }
        code.endControlFlow();

    }

    protected String invokeEnumName(Object c) throws TranslationException {
        try {
            final java.lang.reflect.Method m = c.getClass().getMethod("name");
            return (String) m.invoke(c);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException
                 | NoSuchMethodException | SecurityException exception) {
            throw new TranslationException(exception);
        }
    }

}
