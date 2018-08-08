package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    private static final String UNKOWN_NAME = "Unkown";
    private static final String ABSTRACT_CLASS_PREFIX = "Abstract";
    private String packageName;
    private String parent;
    private String group;
    private final Map<String, Method> methods;
    private final Map<String, Field> fields;
    private TypeSpec.Builder specificationBuilder;
    private static final Map<String, Integer> LOOKUP_TABLE = new HashMap<>(26);
    static {
        LOOKUP_TABLE.put("a", Integer.valueOf(1));
        LOOKUP_TABLE.put("b", Integer.valueOf(2));
        LOOKUP_TABLE.put("c", Integer.valueOf(3));
        LOOKUP_TABLE.put("d", Integer.valueOf(4));
        LOOKUP_TABLE.put("e", Integer.valueOf(5));
        LOOKUP_TABLE.put("f", Integer.valueOf(6));
        LOOKUP_TABLE.put("g", Integer.valueOf(7));
        LOOKUP_TABLE.put("h", Integer.valueOf(8));
        LOOKUP_TABLE.put("i", Integer.valueOf(9));
        LOOKUP_TABLE.put("j", Integer.valueOf(10));
        LOOKUP_TABLE.put("k", Integer.valueOf(11));
        LOOKUP_TABLE.put("l", Integer.valueOf(12));
        LOOKUP_TABLE.put("m", Integer.valueOf(13));
        LOOKUP_TABLE.put("n", Integer.valueOf(14));
        LOOKUP_TABLE.put("o", Integer.valueOf(15));
        LOOKUP_TABLE.put("p", Integer.valueOf(16));
        LOOKUP_TABLE.put("q", Integer.valueOf(17));
        LOOKUP_TABLE.put("r", Integer.valueOf(18));
        LOOKUP_TABLE.put("s", Integer.valueOf(19));
        LOOKUP_TABLE.put("t", Integer.valueOf(20));
        LOOKUP_TABLE.put("u", Integer.valueOf(21));
        LOOKUP_TABLE.put("v", Integer.valueOf(22));
        LOOKUP_TABLE.put("w", Integer.valueOf(23));
        LOOKUP_TABLE.put("x", Integer.valueOf(24));
        LOOKUP_TABLE.put("y", Integer.valueOf(25));
        LOOKUP_TABLE.put("z", Integer.valueOf(26));
    }

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
        methods = new LinkedHashMap<>();
        fields = new LinkedHashMap<>();
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
        if (!hasField(field)) {
            overrideFieldIfExists(field);
        }
    }

    public void overrideFieldIfExists(Field field) {
        if (field == null) {
            return;
        }
        fields.put(field.getIdentifier(), field);
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

    public boolean hasFields() {
        return !fields.isEmpty();
    }

    /**
     * @return the methods
     */
    public List<Method> getMethodList() {
        return new ArrayList<>(methods.values());
    }

    public boolean hasMethod(Method method) {
        return method == null ? false : methods.containsKey(method.getIdentifier());
    }

    public boolean hasField(Field field) {
        return field == null ? false : fields.containsKey(field.getIdentifier());
    }

    public void addMethod(Method method) {
        if (!hasMethod(method)) {
            overrideMethodIfExist(method);
        }
    }

    public void overrideMethodIfExist(Method method) {
        if (method == null) {
            return;
        }
        methods.put(method.getIdentifier(), method);
    }

    /**
     * @return the fields
     */
    public List<Field> getFieldList() {
        return new ArrayList<>(fields.values());
    }

    /**
     * @return the methods
     */
    public Map<String, Method> getMethods() {
        return methods;
    }

    /**
     * @return the fields
     */
    public Map<String, Field> getFields() {
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

    public boolean needsCustomisation() {
        return needsCustomCode() || needsFieldCustomisation() || needsMethodCustomisation();
    }

    public boolean needsMethodCustomisation() {
        return getMethodList().stream().filter(m -> m.needsCustomCode()).count() > 0;
    }

    public boolean needsFieldCustomisation() {
        return getFieldList().stream().filter(f -> f.needsCustomCode()).count() > 0;
    }

    private Model generateAbstractModel() {
        final Model abstractModel = new Model(packageName, name, group, description, longDescription, true, false,
                                              false, isInternal);
        getFieldList().stream().filter(f -> !f.needsCustomCode()).forEach(f -> {
            f.setAccessible(true);
            abstractModel.addField(f);
        });
        getMethodList().stream().filter(m -> !m.needsCustomCode()).forEach(m -> abstractModel.addMethod(m));
        abstractModel.generateMethodsNecessaryAtEachLevel();
        return abstractModel;
    }

    private Model generateChildModel() {
        final Model child = new Model(packageName, name, group, description, longDescription, false, false, true,
                                      isInternal);
        child.setParent(generateParentClassName());
        getFieldList().stream().filter(f -> f.needsCustomCode()).forEach(f -> {
            f.setContainsCustomCode(true);
            child.addField(f);
        });
        getMethodList().stream().filter(m -> m.needsCustomCode()).forEach(m -> {
            m.setContainsCustomCode(true);
            child.addMethod(m);
        });
        child.generateMethodsNecessaryAtEachLevel();
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
            final Stream<Method> filtered = getMethodList().stream().filter(m -> m.getName() == key);
            final boolean success = filtered.count() > 0;
            filtered.forEach(m -> m.setNeedsCustomCode(true));
            return success;
        }
        if (Field.class.isAssignableFrom(type)) {
            final Stream<Field> filtered = getFieldList().stream().filter(f -> f.getName() == key);
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
        generateMethodsNecessaryAtEachLevel();
        // TODO do more e.g. add constructors

    }

    protected void generateSettersAndGetters() {
        getFieldList().stream().forEach(f -> {
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
                if (f.needsValidation()) {
                    addMethod(new MethodIsFieldValid(f, false));
                }
            }
        });
    }

    protected void generateMethodsNecessaryAtEachLevel() {
        generateHashCodeAndEquals();
        generateMethodsDependingOnParents(null);
    }

    protected void generateMethodsDependingOnParents(Model theParent) {
        generateToString(theParent);
        generateIsValid(theParent);
    }

    protected void generateHashCodeAndEquals() {
        addMethod(new MethodHashCode(this, null));
        addMethod(new MethodEquals(this, null));
    }

    protected void generateToString(Model theParent) {
        overrideMethodIfExist(new MethodToString(this, theParent));
    }

    protected void generateIsValid(Model theParent) {
        overrideMethodIfExist(new MethodIsValid(this, theParent));
    }

    public List<Model> getProcessedModels() {
        List<Model> models = new ArrayList<>(2);
        if (needsCustomisation()) {
            final Model abstractModel = generateAbstractModel();
            models.add(abstractModel);
            final Model childModel = generateChildModel();
            childModel.generateMethodsDependingOnParents(abstractModel);
            models.add(childModel);
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

    protected String generateSerialisationId() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        StringBuilder builder = new StringBuilder();
        builder.append(result);
        for (final char character : name.trim().toLowerCase().toCharArray()) {
            final Integer value = LOOKUP_TABLE.get(String.valueOf(character));
            if (value != null) {
                builder.append(value.intValue());
            }
        }
        return builder.toString();
    }

    protected void translateSerialisation() throws TranslationException {
        if (isAbstract) {
            return;
        }
        final Field serialVersionUID = new Field(true, new ParameterType(long.class), "serialVersionUID",
                                                 "Serialisation Id.", null, null, true, false, false, false, null);
        serialVersionUID.setInitialiser(generateSerialisationId() + "L");
        serialVersionUID.translate();
        specificationBuilder.addField(serialVersionUID.getSpecificationBuilder().build());
    }

    protected void translateFields() throws TranslationException {
        for (final Field f : getFieldList()) {
            if (!f.needsCustomCode()) {
                f.translate();
                specificationBuilder.addField(f.getSpecificationBuilder().build());
            }
        }
    }

    protected void translateMethods() throws TranslationException {
        for (final Method m : getMethodList()) {
            m.translate();
            specificationBuilder.addMethod(m.getSpecificationBuilder().build());
        }
    }

    public String getListOfFieldsToDefineManually() {
        StringBuilder builder = new StringBuilder();
        getFieldList().forEach(f -> {
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
        translateSerialisation();
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
