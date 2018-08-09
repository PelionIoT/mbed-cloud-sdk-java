package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Date;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.pelion.sdk.foundation.generator.Entity;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.TypeName;

public class ParameterType implements Entity {

    private Import importPath;
    private Class<?> clazz;
    private TypeName typeName;
    private String type;
    private String format;

    /**
     *
     */
    public ParameterType() {
        super();
        setImportPath(null);
        setClazz(null);
        setTypeName(null);
        setType(null);
        setFormat(null);
    }

    /**
     * @param type
     * @param format
     */
    public ParameterType(String type, String format) {
        this();
        setType(type);
        setFormat(format);
    }

    /**
     * @param clazz
     */
    public ParameterType(Class<?> clazz) {
        this();
        setClazz(clazz);
    }

    /**
     * @param type
     * @param format
     */
    public ParameterType(Import importPath) {
        this();
        setImportPath(importPath);
    }

    /**
     * @return the importPath
     */
    public Import getImportPath() {
        return importPath;
    }

    /**
     * @param importPath
     *            the importPath to set
     */
    public void setImportPath(Import importPath) {
        this.importPath = importPath;
    }

    /**
     * @return the clazz
     */
    public Class<?> getClazz() {
        return clazz;
    }

    /**
     * @param clazz
     *            the clazz to set
     */
    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    /**
     * @return the typeName
     */
    public TypeName getTypeName() {
        return typeName;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param format
     *            the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @param typeName
     *            the typeName to set
     */
    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    public boolean hasClass() {
        return hasClazz();
    }

    protected boolean hasClazz() {
        return clazz != null;
    }

    @Override
    public void translate() throws TranslationException {
        if (!hasClazz()) {
            clazz = PrimitiveDataTypes.getDataType(type, format);
        }
        if (!hasClazz()) {
            if (importPath == null || importPath.isIncomplete()) {
                throw new TranslationException("The type definition is incomplete: " + importPath);
            }
            importPath.translate();
            typeName = importPath.getClassName();
        }
    }

    public String getShortName() {
        try {
            translate();
            return hasClazz() ? getClazz().getSimpleName() : importPath.getName();
        } catch (TranslationException exception) {
            return "";
        }
    }

    public boolean isNumber() {
        try {
            translate();
            return hasClazz() ? Number.class.isAssignableFrom(getClazz()) || getClazz() == int.class
                                || getClazz() == long.class || getClazz() == float.class || getClazz() == double.class
                                || getClazz() == byte.class || getClazz() == short.class
                              : false;
        } catch (TranslationException exception) {
            return false;
        }
    }

    public boolean isString() {
        try {
            translate();
            return hasClazz() ? String.class.isAssignableFrom(getClazz()) : false;
        } catch (TranslationException exception) {
            return false;
        }
    }

    public boolean isBoolean() {
        try {
            translate();
            return hasClazz() ? Boolean.class.isAssignableFrom(getClazz()) || getClazz() == boolean.class : false;
        } catch (TranslationException exception) {
            return false;
        }
    }

    public boolean isDate() {
        try {
            translate();
            return hasClazz() ? Date.class.isAssignableFrom(getClazz()) : false;
        } catch (TranslationException exception) {
            return false;
        }
    }

    public boolean isEnum() {
        try {
            translate();
            return hasClazz() ? SdkEnum.class.isAssignableFrom(getClazz())
                              : importPath == null ? false : importPath.isEnum();
        } catch (TranslationException exception) {
            return false;
        }
    }
}
