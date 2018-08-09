package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.WildcardTypeName;

public class GenericParameterType extends ParameterType {

    /**
     *
     */
    public GenericParameterType() {
        super();
    }

    /**
     * @param clazz
     */
    public GenericParameterType(Class<?> clazz) {
        super(clazz);
    }

    /**
     * @param importPath
     */
    public GenericParameterType(Import importPath) {
        super(importPath);
    }

    /**
     * @param type
     * @param format
     */
    public GenericParameterType(String type, String format) {
        super(type, format);
    }

    @Override
    public boolean hasClass() {
        return false;
    }

    @Override
    public void translate() throws TranslationException {
        super.translate();
        if (super.hasClass()) {
            setTypeName(WildcardTypeName.subtypeOf(getClazz()));
        } else {
            setTypeName(WildcardTypeName.subtypeOf(getTypeName()));
        }
    }

}
