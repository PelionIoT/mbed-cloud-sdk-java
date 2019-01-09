package com.arm.pelion.sdk.foundation.generator.model;

public class AbstractMethodBasedOnModel extends Method {

    protected Model parentModel;
    protected Model currentModel;

    public AbstractMethodBasedOnModel(Model currentModel, Model parentModel, boolean isReadOnly, String name,
                                      String description, String longDescription, boolean isStatic,
                                      boolean isAccessible, boolean isAbstract, boolean containsCustomCode,
                                      boolean needsCustomCode, boolean isInternal, boolean isRequired,
                                      boolean isAnOverride) {
        super(isReadOnly, name, description, longDescription, isStatic, isAccessible, isAbstract, containsCustomCode,
              needsCustomCode, isInternal, isRequired, isAnOverride);
        setCurrentModel(currentModel);
        setParentModel(parentModel);
    }

    public boolean hasParentModel() {
        return parentModel != null;
    }

    public boolean hasCurrentModel() {
        return currentModel != null;
    }

    /**
     * @return the parentModel
     */
    public Model getParentModel() {
        return parentModel;
    }

    /**
     * @return the currentModel
     */
    public Model getCurrentModel() {
        return currentModel;
    }

    /**
     * @param parentModel
     *            the parentModel to set
     */
    public void setParentModel(Model parentModel) {
        this.parentModel = parentModel;
    }

    /**
     * @param currentModel
     *            the currentModel to set
     */
    public void setCurrentModel(Model currentModel) {
        this.currentModel = currentModel;
    }

}
