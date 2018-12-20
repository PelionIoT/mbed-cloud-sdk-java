package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Locale;

import com.arm.mbed.cloud.sdk.common.dao.DaoProvider;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.squareup.javapoet.ClassName;

public class Import implements Artifact {

    private String name;
    private String packageName;
    private ClassName className;
    private boolean isEnum;

    /**
     *
     */
    public Import() {
        this(null, null);
    }

    /**
     * @param name
     * @param packageName
     */
    public Import(String name, String packageName) {
        super();
        this.name = name;
        this.packageName = packageName;
        setClassName(null);
        setEnum(false);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param packageName
     *            the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * @return the className
     */
    public ClassName getClassName() {
        return className;
    }

    /**
     * @param className
     *            the className to set
     */
    public void setClassName(ClassName className) {
        this.className = className;
    }

    public boolean isIncomplete() {
        return name == null || name.trim().isEmpty() || isPackageNameEmpty();
    }

    public boolean isPackageNameEmpty() {
        return packageName == null || packageName.trim().isEmpty();
    }

    /**
     * @return the isEnum
     */
    public boolean isEnum() {
        return isEnum;
    }

    public boolean isModelDao() {
        return isIncomplete() ? false
                              : name.toLowerCase(Locale.UK).contains(DaoProvider.DAO_SUFFIX.toLowerCase(Locale.UK));
    }

    public boolean isModelListDao() {
        return isIncomplete() ? false : name.toLowerCase(Locale.UK)
                                            .contains(DaoProvider.LIST_DAO_SUFFIX.toLowerCase(Locale.UK));
    }

    public boolean isListOptions() {
        return isIncomplete() ? false : name.toLowerCase(Locale.UK)
                                            .contains(ModelListOption.MODEL_NAME_SUFFIX.toLowerCase(Locale.UK));
    }

    /**
     * @param isEnum
     *            the isEnum to set
     */
    public void setEnum(boolean isEnum) {
        this.isEnum = isEnum;
    }

    public String getFullyQualifiedName() {
        return isPackageNameEmpty() ? name : packageName + "." + name;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Import [name=" + name + ", packageName=" + packageName + ", className=" + className + ", isEnum="
               + isEnum + "]";
    }

    @Override
    public void translate() throws TranslationException {
        if (isIncomplete()) {
            throw new TranslationException("The class to import could not be found: " + toString());
        }
        setClassName(ClassName.get(packageName, name));
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
        result = prime * result + ((className == null) ? 0 : className.hashCode());
        result = prime * result + (isEnum ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
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
        Import other = (Import) obj;
        if (className == null) {
            if (other.className != null) {
                return false;
            }
        } else if (!className.equals(other.className)) {
            return false;
        }
        if (isEnum != other.isEnum) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (packageName == null) {
            if (other.packageName != null) {
                return false;
            }
        } else if (!packageName.equals(other.packageName)) {
            return false;
        }
        return true;
    }

}
