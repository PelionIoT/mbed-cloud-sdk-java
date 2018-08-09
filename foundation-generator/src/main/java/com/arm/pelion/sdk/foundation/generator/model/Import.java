package com.arm.pelion.sdk.foundation.generator.model;

import com.arm.pelion.sdk.foundation.generator.Entity;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.ClassName;

public class Import implements Entity {

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
        return name == null || name.isEmpty() || packageName == null || packageName.isEmpty();
    }

    /**
     * @return the isEnum
     */
    public boolean isEnum() {
        return isEnum;
    }

    /**
     * @param isEnum
     *            the isEnum to set
     */
    public void setEnum(boolean isEnum) {
        this.isEnum = isEnum;
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
}
