package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

public class TypeMapper extends TypeParameter {

    private TypeParameter from;
    private TypeParameter to;

    public TypeMapper() {
        this(new TypeParameter(), new TypeParameter());
    }

    public TypeMapper(TypeParameter fromType, TypeParameter toType) {
        this.from = fromType;
        this.to = toType;
    }

    public TypeParameter getFrom() {
        return from;
    }

    public TypeParameter getTo() {
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
        setTypeName(ParameterizedTypeName.get(ClassName.get(getRawClass()),
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
        return getRawClass().getSimpleName();
    }

    @Override
    public Class<?> getRawClass() {
        return Mapper.class;
    }

    @Override
    public String toString() {
        return "MapperType [from=" + from + ", to=" + to + "]";
    }

}
