package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeSpec;

public class MethodGetMapper extends Method {

    private static final String PARAMETER_NAME = "toBeMapped";
    private final Model adapter;
    private final TypeMapper type;
    private final String mapMethod;

    public MethodGetMapper(String name, boolean isAccessible, Model adapter, Model currentModel, Model fromTo,
                           boolean isFromModel, String mapMethod) {
        this(name, isAccessible, adapter, currentModel == null ? null : currentModel.toType(),
             fromTo == null ? null : fromTo.toType(), isFromModel, mapMethod);
    }

    public MethodGetMapper(String name, boolean isAccessible, Model adapter, TypeParameter currentModel,
                           TypeParameter fromTo, boolean isFromModel, String mapMethod) {
        super(false, name, "Gets a mapper.", null, true, isAccessible, false, false, false, true, false, false);

        type = new TypeMapper(isFromModel ? fromTo == null ? null : currentModel : currentModel == null ? null : fromTo,
                              isFromModel ? fromTo == null ? null : fromTo
                                          : currentModel == null ? null : currentModel);

        this.mapMethod = mapMethod;
        this.adapter = adapter;
        setReturnType(type);
        setReturnDescription("a mapper");
        initialiseCodeBuilder();
    }

    @Override
    protected void translateCode() throws TranslationException {
        type.translate();
        final TypeParameter adapterType = adapter.toType();
        adapterType.translate();

        Method map = new Method(false, Mapper.MAP_FUNCTION_NAME, "Maps.", null, false, true, false, false, false, false,
                                false, true);
        map.setReturnDescription("a mapped object");
        map.setReturnType(type.getTo());
        map.addParameter(new Parameter(PARAMETER_NAME, "model to be mapped.", null, type.getFrom(), null));
        map.initialiseCodeBuilder();
        map.getCode().addStatement("return $T.$L($N)",
                                   adapterType.hasClass() ? adapterType.getClazz() : adapterType.getTypeName(),
                                   mapMethod, PARAMETER_NAME);
        map.translate();

        TypeSpec mapper = TypeSpec.anonymousClassBuilder("").addSuperinterface(type.getTypeName())
                                  .addMethod(map.getSpecificationBuilder().build()).build();
        code.addStatement("return $L", mapper);
    }

}
