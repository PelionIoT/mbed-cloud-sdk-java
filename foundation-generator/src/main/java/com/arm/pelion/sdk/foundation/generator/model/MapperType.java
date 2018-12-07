package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

public class MapperType extends ParameterType {

    private static final Class<?> MAPPER_CLASS = Mapper.class;
    private ParameterType from;
    private ParameterType to;

    public MapperType() {
        this(new ParameterType(), new ParameterType());
    }

    public MapperType(ParameterType fromType, ParameterType toType) {
        this.from = fromType;
        this.to = toType;
    }

    public ParameterType getFrom() {
        return from;
    }

    public ParameterType getTo() {
        return to;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#translate()
     */
    @Override
    public void translate() throws TranslationException {
        if (from == null || to == null) {
            throw new TranslationException("The type definition of the mapper is unknown ");
        }
        from.translate();
        to.translate();
        setTypeName(ParameterizedTypeName.get(ClassName.get(MAPPER_CLASS),
                                              from.hasClass() ? TypeName.get(from.getClazz()) : from.getTypeName(),
                                              to.hasClass() ? TypeName.get(to.getClazz()) : to.getTypeName()));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#getShortName()
     */
    @Override
    public String getShortName() {
        return MAPPER_CLASS.getSimpleName();
    }

    @Override
    public String toString() {
        return "MapperType [from=" + from + ", to=" + to + "]";
    }

}
