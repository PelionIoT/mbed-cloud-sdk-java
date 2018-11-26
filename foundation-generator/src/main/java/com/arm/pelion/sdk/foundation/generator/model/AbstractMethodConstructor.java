package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;

public abstract class AbstractMethodConstructor extends AbstractMethodBasedOnModel {

    protected boolean isNecessary;

    public AbstractMethodConstructor(Model currentModel, Model parentModel, String description, String longDescription,
                                     boolean isInternal) {
        super(currentModel, parentModel, false, null, generateDescription(description, isInternal),
              generateLongDescription(currentModel == null ? "Unknown" : currentModel.getName(), longDescription,
                                      isInternal),
              false, true, false, false, false, isInternal, false, false);
        addConstructorParameters();
        setCode(CodeBlock.builder());
        setNecessary(true);
    }

    public abstract List<String> getSignature();

    public boolean hasSameSignature(AbstractMethodConstructor constructor) {
        if (constructor == null) {
            return false;
        }
        return getSignature().equals(constructor.getSignature());
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractMethodConstructor> T ignoreModifier() {
        setNeedsModifier(false);
        return (T) this;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.AbstractMethodConstructor#getIdentifier()
     */
    @Override
    public String getIdentifier() {
        return getClass().getSimpleName();
    }

    protected abstract void addConstructorParameters();

    @Override
    protected abstract void translateCode();

    private static String generateDescription(String description, boolean isInternal) {
        return has(description) ? description : isInternal ? "Internal constructor" : "Constructor";
    }

    public List<Field> getFieldList(boolean readOnly, boolean required, boolean all, boolean justIdentifiers) {
        final List<Field> fieldsList = new LinkedList<>();
        if (hasCurrentModel()) {
            fieldsList.addAll(currentModel.getFieldList());
        }
        if (hasParentModel()) {
            fieldsList.addAll(parentModel.getFieldList());
        }
        return fieldsList.stream().filter(f -> {
            if (all) {
                return true;
            }
            if (justIdentifiers) {
                return f.isIdentifier();
            }
            if (readOnly && required) {
                return f.isReadOnly() && f.isRequired();
            }
            if (!readOnly && required) {
                return !f.isReadOnly() && f.isRequired();
            }
            if (readOnly && !required) {
                return f.isReadOnly() && !f.isRequired();
            }
            return !f.isReadOnly() && !f.isRequired();
        }).collect(Collectors.toList());
    }

    private static String generateLongDescription(String name, String longDescription, boolean isInternal) {
        StringBuilder builder = new StringBuilder();
        if (has(longDescription)) {
            builder.append(longDescription);
            if (isInternal) {
                builder.append(System.lineSeparator()).append("<p>").append(System.lineSeparator());
            }
        }
        if (isInternal) {
            builder.append("Note: Should not be used. Use {@link #").append(name).append("()} instead.");
        }
        return builder.toString();
    }

    @Override
    protected void initialiseBuilder() {
        if (specificationBuilder == null) {
            specificationBuilder = MethodSpec.constructorBuilder();
        }
    }

    /**
     * @return the isNecessary
     */
    public boolean isNecessary() {
        return isNecessary;
    }

    /**
     * @param isNecessary
     *            the isNecessary to set
     */
    public void setNecessary(boolean isNecessary) {
        this.isNecessary = isNecessary;
    }

}
