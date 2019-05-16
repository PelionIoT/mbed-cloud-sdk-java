package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeVariableName;

public class TypeGenericParameter extends TypeParameter {

    /**
     *
     */
    public TypeGenericParameter() {
        super();
    }

    /**
     * @param clazz
     */
    public TypeGenericParameter(Class<?> clazz) {
        super(clazz);
    }

    /**
     * @param importPath
     */
    public TypeGenericParameter(Import importPath) {
        super(importPath);
    }

    /**
     * @param type
     * @param format
     */
    public TypeGenericParameter(String type, String format) {
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
