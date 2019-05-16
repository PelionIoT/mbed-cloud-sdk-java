package com.arm.pelion.sdk.foundation.generator.model;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.arm.mbed.cloud.sdk.common.Base64;
import com.arm.mbed.cloud.sdk.common.SdkEnum;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.dao.CloudDao;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.model.DataFile;
import com.arm.pelion.sdk.foundation.generator.lowlevelapis.LowLevelAPIMethodArgument;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.TypeName;

import okhttp3.MultipartBody;

public class TypeParameter implements Artifact {

    protected Import importPath;
    protected Class<?> clazz;
    protected TypeName typeName;
    protected String type;
    protected String format;

    protected TypeParameter(Import importPath, Class<?> clazz, TypeName typeName, String type, String format) {
        super();
        this.importPath = importPath;
        this.clazz = clazz;
        this.typeName = typeName;
        this.type = type;
        this.format = format;
    }

    /**
     *
     */
    public TypeParameter() {
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
    public TypeParameter(String type, String format) {
        this();
        setType(type);
        setFormat(format);
    }

    /**
     * @param clazz
     */
    public TypeParameter(Class<?> clazz) {
        this();
        setClazz(clazz);
    }

    /**
     * @param type
     * @param format
     */
    public TypeParameter(Import importPath) {
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
            clazz = TypePrimitive.getDataType(type, format);
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
            return hasClazz() ? getClassSimpleName() : importPath.getName();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return "";
        }
    }

    private String getClassSimpleName() {
        return (getClazz().isMemberClass() ? getClazz().getEnclosingClass().getSimpleName() + "_" : "")
               + getClazz().getSimpleName();
    }

    public String getFullyQualifiedName() {
        if (isPrimitiveOrWrapper()) {
            return getClassSimpleName();
        }
        try {
            translate();
            return hasClazz() ? getClazz().getName() : importPath.getFullyQualifiedName();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return "";
        }
    }

    public String getPackageName() {
        try {
            translate();
            return hasClazz() ? getClazz().getPackage().getName() : importPath.getPackageName();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
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

    public boolean isInteger() {
        if (!isNumber()) {
            return false;
        }
        return getClazz() == int.class || getClazz() == Integer.class;
    }

    public boolean isNumber() {
        try {
            translate();
            return hasClazz() ? Number.class.isAssignableFrom(getClazz()) || getClazz() == int.class
                                || getClazz() == long.class || getClazz() == float.class || getClazz() == double.class
                                || getClazz() == byte.class || getClazz() == short.class
                              : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isList() {
        return false;
    }

    public boolean isArray() {
        if (isBase64()) {
            return true;
        }
        try {
            translate();
            return hasClazz() ? getClazz().isArray() : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isBinary() {
        if (!isArray()) {
            return false;
        }
        try {
            translate();
            return hasClazz() ? byte[].class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isBase64() {
        try {
            translate();
            return hasClazz() ? Base64.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isHashtable() {
        return false;
    }

    public boolean isLowLevelModel() {
        try {
            translate();
            return hasClazz() ? LowLevelAPIMethodArgument.isOpenApiModel(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isModel() {
        try {
            translate();
            return hasClazz() ? SdkModel.class.isAssignableFrom(getClazz())
                              : importPath != null && !importPath.isEnum();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isModelDao() {
        try {
            translate();
            return hasClazz() ? CloudDao.class.isAssignableFrom(getClazz())
                              : importPath != null && importPath.isModelDao();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isModelListDao() {
        try {
            translate();
            return hasClazz() ? ModelListDao.class.isAssignableFrom(getClazz())
                              : importPath != null && importPath.isModelListDao();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isListOptions() {
        try {
            translate();
            return hasClazz() ? ListOptions.class.isAssignableFrom(getClazz())
                              : importPath != null && importPath.isListOptions();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isString() {
        try {
            translate();
            return hasClazz() ? String.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isCharacter() {
        try {
            translate();
            return hasClazz() ? Character.class.isAssignableFrom(getClazz()) || getClazz() == char.class : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isBoolean() {
        try {
            translate();
            return hasClazz() ? Boolean.class.isAssignableFrom(getClazz()) || getClazz() == boolean.class : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isFile() {
        try {
            translate();
            return hasClazz() ? File.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isDataFile() {
        try {
            translate();
            return hasClazz() ? DataFile.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isListResponse() {
        try {
            translate();
            return hasClazz() ? ListResponse.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isFormPart() {
        try {
            translate();
            return hasClazz() ? MultipartBody.Part.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isVoid() {
        try {
            translate();
            return hasClazz() ? Void.class.isAssignableFrom(getClazz()) || void.class.isAssignableFrom(getClazz())
                              : importPath == null;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isPrimitive() {
        try {
            translate();
            return hasClazz() ? getClazz().isPrimitive() : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public void transformIntoWrapper() {
        if (!isPrimitive()) {
            return;
        }
        setClazz(TypePrimitive.getWrapperEquivalent(getClazz()));
    }

    public boolean isPrimitiveOrWrapper() {
        if (isPrimitive()) {
            return true;
        }
        try {
            translate();
            if (!hasClazz()) {
                return false;
            }
            final Class<?> clazz = getClazz();
            return clazz == Double.class || clazz == Float.class || clazz == Long.class || clazz == Integer.class
                   || clazz == Short.class || clazz == Character.class || clazz == Byte.class || clazz == Boolean.class
                   || clazz == String.class || clazz == Void.class;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }

    }

    public boolean isUrl() {
        try {
            translate();
            return hasClazz() ? URL.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isDate() {
        try {
            translate();
            return hasClazz() ? TypePrimitive.SDK_DATE_CLASS.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isJodaDate() {
        try {
            translate();
            return hasClazz() ? LocalDate.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isJodaTime() {
        try {
            translate();
            return hasClazz() ? DateTime.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isCalendar() {
        try {
            translate();
            return hasClazz() ? Calendar.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isModelEnum() {
        try {
            translate();
            return hasClazz() ? SdkEnum.class.isAssignableFrom(getClazz())
                              : importPath == null ? false : importPath.isEnum();
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isEnum() {
        if (isModelEnum()) {
            return true;
        }
        try {
            translate();
            return hasClazz() ? getClazz().isEnum() || Enum.class.isAssignableFrom(getClazz()) : false;
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isGeneric() {
        return false;
    }

    public boolean isComposed() {
        return false;
    }

    public boolean isEquivalent(TypeParameter type) {
        if (type == null) {
            return false;
        }
        try {
            translate();
            type.translate();
            return equals(type);
        } catch (@SuppressWarnings("unused") TranslationException exception) {
            return false;
        }
    }

    public boolean isModel(Model model) {
        if (model == null || !isModel()) {
            return false;
        }
        return isEquivalent(model.toType());
    }

    public Class<?> getRawClass() {
        return hasClass() ? getClazz() : Object.class;
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
        final TypeParameter other = (TypeParameter) obj;
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

    @Override
    public TypeParameter clone() {
        return new TypeParameter(importPath == null ? null : importPath.clone(), clazz, typeName, type, format);
    }

}
