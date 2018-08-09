package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.TypeVariableName;

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
            setTypeName(TypeVariableName.get("T", getClazz()));
        } else {
            setTypeName(TypeVariableName.get("T", getTypeName()));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.arm.pelion.sdk.foundation.generator.model.ParameterType#isGeneric()
     */
    @Override
    public boolean isGeneric() {
        return true;
    }

}
