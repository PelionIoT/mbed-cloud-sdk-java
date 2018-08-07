package com.arm.pelion.sdk.foundation.generator.model;

public abstract class AbstractModelEntity implements ModelEntity {

    protected boolean isReadOnly;
    protected String name;
    protected String description;
    protected String longDescription;
    protected boolean isStatic;
    protected boolean isAccessible;
    protected boolean isAbstract;
    protected boolean isInternal;
    /**
     * Specifies whether this instance contains custom code. i.e. code edited manually. If it exists, it must not be
     * overwritten.
     */
    protected boolean containsCustomCode;
    /**
     * Specifies if this instance needs to be split in two parts: an auto-generated part and a part which can be
     * added/edited manually.
     */
    protected boolean needsCustomCode;

    /**
     *
     * @param isReadOnly
     * @param name
     * @param description
     * @param isStatic
     * @param isAccessible
     * @param isAbstract
     * @param containsCustomCode
     * @param needsCustomCode
     * @param isInternal
     */
    public AbstractModelEntity(boolean isReadOnly, String name, String description, String longDescription,
                               boolean isStatic, boolean isAccessible, boolean isAbstract, boolean containsCustomCode,
                               boolean needsCustomCode, boolean isInternal) {
        super();
        setReadOnly(isReadOnly);
        setName(name);
        setDescription(description);
        setLongDescription(longDescription);
        setStatic(isStatic);
        setAccessible(isAccessible);
        setAbstract(isAbstract);
        setContainsCustomCode(containsCustomCode);
        setNeedsCustomCode(needsCustomCode);
        setInternal(isInternal);
    }

    /**
     * @return the isAccessible
     */
    @Override
    public boolean isAccessible() {
        return isAccessible;
    }

    /**
     * @param isAccessible
     *            the isAccessible to set
     */
    @Override
    public void setAccessible(boolean isAccessible) {
        this.isAccessible = isAccessible;
    }

    /**
     * @return the isReadOnly
     */
    @Override
    public boolean isReadOnly() {
        return isReadOnly;
    }

    /**
     * @return the value
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the isStatic
     */
    @Override
    public boolean isStatic() {
        return isStatic;
    }

    /**
     * @param isReadOnly
     *            the isReadOnly to set
     */
    @Override
    public void setReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    /**
     * @param name
     *            the value to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param isStatic
     *            the isStatic to set
     */
    @Override
    public void setStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    /**
     * @return the description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean hasDescription() {
        return has(description);
    }

    /**
     * @return the needsCustomCode
     */
    @Override
    public boolean needsCustomCode() {
        return needsCustomCode;
    }

    /**
     * @param needsCustomCode
     *            the needsCustomCode to set
     */
    @Override
    public void setNeedsCustomCode(boolean needsCustomCode) {
        this.needsCustomCode = needsCustomCode;
    }

    @Override
    public <T extends ModelEntity> T needsCustomCode(boolean needsCustomCode) {
        setNeedsCustomCode(needsCustomCode);
        return (T) this;
    }

    @Override
    public void setContainsCustomCode(boolean containsCustomCode) {
        this.containsCustomCode = containsCustomCode;
    }

    @Override
    public boolean containsCustomCode() {
        return containsCustomCode;
    }

    protected static boolean has(String value) {
        return value != null && !value.isEmpty();
    }

    @Override
    public boolean hasName() {
        return has(name);
    }

    @Override
    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;

    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    /**
     * @return the isInternal
     */
    @Override
    public boolean isInternal() {
        return isInternal;
    }

    /**
     * @param isInternal
     *            the isInternal to set
     */
    @Override
    public void setInternal(boolean isInternal) {
        this.isInternal = isInternal;
    }

    /**
     * @return the longDescription
     */
    @Override
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * @param longDescription
     *            the longDescription to set
     */
    @Override
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean hasLongDescription() {
        return has(longDescription);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AbstractModelEntity [isReadOnly=" + isReadOnly + ", name=" + name + ", description=" + description
               + ", longDescription=" + longDescription + ", isStatic=" + isStatic + ", isAccessible=" + isAccessible
               + ", isAbstract=" + isAbstract + ", isInternal=" + isInternal + ", containsCustomCode="
               + containsCustomCode + ", needsCustomCode=" + needsCustomCode + "]";
    }

}
