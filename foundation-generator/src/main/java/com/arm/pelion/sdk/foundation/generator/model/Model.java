package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

public class Model extends AbstractModelEntity {
    private static final String ABSTRACT_CLASS_PREFIX = "Abstract";
    private String packageName;
    private String parent;
    private String group;
    private final List<Method> methods;
    private final List<Field> fields;
    private TypeSpec.Builder specificationBuilder;

    /**
     *
     */
    public Model() {
        this(null, null, null, null, null, false, false, false, false);
    }

    public Model(String packageName, String name, String group, String description, String longDescription,
                 boolean isAbstract, boolean needsCustomCode, boolean containsCustomCode, boolean isInternal) {
        super(false, name, description, longDescription, false, true, isAbstract, containsCustomCode, needsCustomCode,
              isInternal);
        methods = new LinkedList<>();
        fields = new LinkedList<>();
        setPackageName(packageName);
        setGroup(group);
    }

    public Model(String packageName, String name, String group, String description, String longDescription,
                 boolean needsCustomCode, boolean isInternal) {
        this(packageName, name, group, description, longDescription, false, needsCustomCode, false, isInternal);
    }

    /**
     * @param packageName
     *            the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
    }

    public boolean hasPackageName() {
        return has(packageName);
    }

    public Model field(Field field) {
        addField(field);
        return this;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public String getFullName() {
        return hasPackageName() ? getPackageName() + "." + getName() : getName();
    }

    /**
     * @return the parent
     */
    public String getParent() {
        return parent;
    }

    public boolean hasMethods() {
        return !methods.isEmpty();
    }

    /**
     * @return the methods
     */
    public List<Method> getMethods() {
        return methods;
    }

    public void addMethod(Method method) {
        if (method == null) {
            return;
        }
        methods.add(method);
    }

    /**
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group
     *            the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @param name
     *            the name to set
     */
    @Override
    public void setName(String name) {
        super.setName(ApiUtils.convertSnakeToCamel(name, true));
        ensureAbstractClassNameFollowsConvention();
    }

    /**
     * @param parent
     *            the parent to set
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * @param isAbstract
     *            the isAbstract to set
     */
    @Override
    public void setAbstract(boolean isAbstract) {
        super.setAbstract(isAbstract);
        ensureAbstractClassNameFollowsConvention();
    }

    private void ensureAbstractClassNameFollowsConvention() {
        if (!hasName()) {
            return;
        }
        if (isAbstract) {
            super.setName(generateParentClassName());
        }
    }

    private String generateParentClassName() {
        return name.startsWith(ABSTRACT_CLASS_PREFIX) ? ApiUtils.convertSnakeToCamel(name, true)
                                                      : ABSTRACT_CLASS_PREFIX
                                                        + ApiUtils.convertSnakeToCamel(name, true);
    }

    public String getChildClassName() {
        return hasName() ? ApiUtils.convertSnakeToCamel(getName().replace(ABSTRACT_CLASS_PREFIX, ""), true) : null;
    }

    /**
     * @return the specificationBuilder
     */
    public TypeSpec.Builder getSpecificationBuilder() {
        return specificationBuilder;
    }

    /**
     * @param specificationBuilder
     *            the specificationBuilder to set
     */
    public void setSpecificationBuilder(TypeSpec.Builder specificationBuilder) {
        this.specificationBuilder = specificationBuilder;
    }

    private void initialiseBuilder() {
        if (specificationBuilder == null) {
            specificationBuilder = TypeSpec.classBuilder(name).addModifiers(Modifier.PUBLIC);
            if (isAbstract) {
                specificationBuilder.addModifiers(Modifier.ABSTRACT);
            }
            specificationBuilder.addAnnotation(AnnotationSpec.builder(Preamble.class)
                                                             .addMember("description", "\"" + description + "\"")
                                                             .build());
            specificationBuilder.addJavadoc(generateClassJavadocComment(hasDescription(), description,
                                                                        hasLongDescription(), longDescription));
            specificationBuilder.addSuperinterface(SdkModel.class);
            if (hasParent()) {
                specificationBuilder.superclass(ClassName.get(packageName, parent));
            }
        }
    }

    private boolean needsCustomisation() {
        return needsCustomCode() || fields.stream().filter(f -> f.needsCustomCode()).count() > 0
               || methods.stream().filter(m -> m.needsCustomCode()).count() > 0;
    }

    private Model generateAbstractModel() {
        final Model abstractModel = new Model(packageName, name, group, description, longDescription, true, false,
                                              false, isInternal);
        fields.stream().filter(f -> !f.needsCustomCode()).forEach(f -> {
            f.setAccessible(true);
            abstractModel.addField(f);
        });
        methods.stream().filter(m -> !m.needsCustomCode()).forEach(m -> abstractModel.addMethod(m));
        return abstractModel;
    }

    private Model generateChildModel() {
        final Model child = new Model(packageName, name, group, description, longDescription, false, false, true,
                                      isInternal);
        child.setParent(generateParentClassName());
        fields.stream().filter(f -> f.needsCustomCode()).forEach(f -> {
            f.setContainsCustomCode(true);
            child.addField(f);
        });
        methods.stream().filter(m -> m.needsCustomCode()).forEach(m -> {
            m.setContainsCustomCode(true);
            child.addMethod(m);
        });

        return child;
    }

    public <T extends ModelEntity> boolean requestCustomCode(Class<T> type, String key) {
        if (type == null || Model.class.isAssignableFrom(type)) {
            setNeedsCustomCode(true);
            return true;
        }
        if (key == null) {
            return false;
        }
        if (Method.class.isAssignableFrom(type)) {
            final Stream<Method> filtered = methods.stream().filter(m -> m.getName() == key);
            final boolean success = filtered.count() > 0;
            filtered.forEach(m -> m.setNeedsCustomCode(true));
            return success;
        }
        if (Field.class.isAssignableFrom(type)) {
            final Stream<Field> filtered = fields.stream().filter(f -> f.getName() == key);
            final boolean success = filtered.count() > 0;
            filtered.forEach(f -> f.setNeedsCustomCode(true));
            return success;
        }
        return false;
    }

    public void generateMethods() {
        methods.clear();
        // Adding getters and setters
        generateSettersAndGetters();

        // TODO do more e.g. add constructors

    }

    protected void generateSettersAndGetters() {
        fields.stream().forEach(f -> {
            addMethod(new MethodGetter(f, null, false));
            if (!f.isReadOnly()) {
                final MethodSetter setter = new MethodSetter(f, null, false);
                addMethod(setter);
                if (f.isIdentifier()) {
                    final Field equivalentF = f.clone();
                    equivalentF.setName(name + "_" + ApiUtils.convertCamelToSnake(f.getName()));// model name + field
                                                                                                // name e.g. ApiKeyId
                    Method equivalentSetter = new MethodSetter(equivalentF,
                                                               "Similar to {@link #" + setter.generateSignature()
                                                                            + "}.",
                                                               true).statement(setter.getCallStatement(equivalentF.toParameter())
                                                                               + System.lineSeparator());
                    addMethod(equivalentSetter);
                }
            }
        });
    }

    public List<Model> getProcessedModels() {
        List<Model> models = new ArrayList<>(2);
        if (needsCustomisation()) {
            models.add(generateAbstractModel());
            models.add(generateChildModel());
        } else {
            models.add(this);
        }
        return models;
    }

    public boolean hasParent() {
        return has(parent);
    }

    private static String generateClassJavadocComment(boolean hasDescription, String description,
                                                      boolean hasLongDescription, String longDescription) {
        StringBuilder builder = new StringBuilder();
        if (hasDescription) {
            builder.append(description);
        }
        if (hasLongDescription) {
            builder.append(System.lineSeparator()).append("<p>").append(System.lineSeparator());
            builder.append(longDescription);
        }
        return builder.toString();
    }

    protected void translateFields() throws TranslationException {
        for (final Field f : fields) {
            if (!f.needsCustomCode()) {
                f.translate();
                specificationBuilder.addField(f.getSpecificationBuilder().build());
            }
        }
    }

    protected void translateMethods() throws TranslationException {
        for (final Method m : methods) {
            m.translate();
            specificationBuilder.addMethod(m.getSpecificationBuilder().build());
        }
    }

    public String getListOfFieldsToDefineManually() {
        StringBuilder builder = new StringBuilder();
        fields.forEach(f -> {
            if (f.needsCustomCode()) {
                builder.append("- " + f.getName()).append(System.lineSeparator());
            }
        });
        return builder.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Entity#translate()
     */
    @Override
    public void translate() throws TranslationException {
        initialiseBuilder();
        translateFields();
        translateMethods();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Entity#toString()
     */
    @Override
    public String toString() {
        return "Model [packageName=" + packageName + ", name=" + name + "]";
    }

}
