package com.arm.pelion.sdk.foundation.generator.model;

import java.math.BigDecimal;
import java.util.Date;

import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.pelion.sdk.foundation.generator.Artifact;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.TypeName;

public class ParameterType implements Artifact {

    protected Import importPath;
    protected Class<?> clazz;
    protected TypeName typeName;
    protected String type;
    protected String format;

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

    public String getPackageName() {
        try {
            translate();
            return hasClazz() ? getClazz().getPackage().getName() : importPath.getPackageName();
        } catch (TranslationException exception) {
            return "";
        }
    }

    public boolean isDecimal() {
        if (!isNumber()) {
            return false;
        }
        return getClazz() == double.class || getClazz() == float.class || getClazz() == BigDecimal.class
               || getClazz() == Double.class || getClazz() == Float.class;
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

    public boolean isList() {
        return false;
    }

    public boolean isHashtable() {
        return false;
    }

    public boolean isString() {
        try {
            translate();
            return hasClazz() ? String.class.isAssignableFrom(getClazz()) : false;
        } catch (TranslationException exception) {
            return false;
        }
    }

    public boolean isCharacter() {
        try {
            translate();
            return hasClazz() ? Character.class.isAssignableFrom(getClazz()) || getClazz() == char.class : false;
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

    public boolean isPrimitive() {
        try {
            translate();
            return hasClazz() ? getClazz().isPrimitive() : false;
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

    public boolean isGeneric() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result + ((importPath == null) ? 0 : importPath.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ParameterType other = (ParameterType) obj;
        if (clazz == null) {
            if (other.clazz != null) {
                return false;
            }
        } else if (!clazz.equals(other.clazz)) {
            return false;
        }
        if (format == null) {
            if (other.format != null) {
                return false;
            }
        } else if (!format.equals(other.format)) {
            return false;
        }
        if (importPath == null) {
            if (other.importPath != null) {
                return false;
            }
        } else if (!importPath.equals(other.importPath)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ParameterType [importPath=" + importPath + ", clazz=" + clazz + ", typeName=" + typeName + ", type="
               + type + ", format=" + format + "]";
    }

}
