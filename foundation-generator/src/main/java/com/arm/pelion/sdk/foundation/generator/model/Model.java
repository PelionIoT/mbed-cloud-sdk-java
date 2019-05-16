package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.element.Modifier;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

public class Model extends AbstractSdkArtifact {
    private static final int MAX_LONG_LENGTH = 18 - 2;
    private static final String ABSTRACT_CLASS_PREFIX = "Abstract";
    protected String packageName;
    private boolean hasCyclomaticComplexity;
    private String abstractParent;
    protected String group;
    protected final TypeParameter concreteType;
    protected final List<String> contructorsName;
    protected final Map<String, Method> methods;
    protected final Map<String, Field> fields;
    protected final Map<String, Field> constants;
    protected Map<String, Field> superClassFields;
    protected Map<String, Method> superClassMethods;
    protected TypeParameter superClassType;
    protected TypeSpec.Builder specificationBuilder;

    private boolean shouldBeSorted;
    private boolean mayHaveLongLines;
    private boolean isFinal;
    private boolean ignoreLiteralDuplicate;
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

    private Model(String packageName, String name, String group, String description, String longDescription,
                  boolean isAbstract, boolean needsCustomCode, boolean containsCustomCode, boolean isInternal,
                  TypeParameter concreteType) {
        super(false, name, generateDescription(name, description), longDescription, false, true, isAbstract,
              containsCustomCode, needsCustomCode, isInternal);
        methods = new LinkedHashMap<>();
        fields = new LinkedHashMap<>();
        constants = new LinkedHashMap<>();
        contructorsName = new LinkedList<>();
        abstractParent = null;
        setPackageName(packageName);
        setGroup(group);
        setSuperClassType(null);
        this.concreteType = concreteType;
        setHasCyclomaticComplexity(false);
        setShouldBeSorted(false);
        setMayHaveLongLines(false);
        setFinal(false);
        setIgnoreLiteralDuplicate(false);
    }

    public Model() {
        this(null, null, null, null, null, false, false, false, false);
    }

    public Model(String packageName, String name, String group, String description, String longDescription,
                 boolean isAbstract, boolean needsCustomCode, boolean containsCustomCode, boolean isInternal) {
        this(packageName, name, group, description, longDescription, isAbstract, needsCustomCode, containsCustomCode,
             isInternal, null);
    }

    public Model(String packageName, String name, String group, String description, String longDescription,
                 boolean needsCustomCode, boolean isInternal) {
        this(packageName, name, group, description, longDescription, false, needsCustomCode, false, isInternal);
    }

    public Model(String packageName, String name, String group) {
        this(packageName, name, group, null, null, false, true);
    }

    public Model(Class<?> clazz) {
        this(clazz, TypeFactory.getCorrespondingType(clazz));
    }

    public Model(Class<?> clazz, TypeParameter genericType) {
        this(clazz == null ? null : clazz.getPackage().getName(), genericType.getShortName(), null, null, null,
             clazz == null ? false : java.lang.reflect.Modifier.isAbstract(clazz.getModifiers()), false, false, false,
             genericType);
        if (clazz != null) {
            Arrays.asList(clazz.getDeclaredFields()).stream().filter(f -> shouldConsiderField(f))
                  .forEach(f -> addField(new Field(f, hasASetter(clazz, f))));
        }
    }

    private boolean hasASetter(Class<?> clazz, java.lang.reflect.Field f) {
        if (clazz == null) {
            return false;
        }
        return Arrays.asList(clazz.getMethods()).stream()
                     .anyMatch(m -> (m.getName().equals(MethodSetter.getCorrespondingSetterMethodName(f.getName()))
                                     && m.getReturnType().equals(Void.class) && m.getParameterCount() == 1)
                                    || (m.getName()
                                         .equals(MethodSetter.getCorrespondingSetterMethodName(f.getName(), true))
                                        && !m.getReturnType().equals(Void.class)));
    }

    private boolean shouldConsiderField(java.lang.reflect.Field f) {
        return !java.lang.reflect.Modifier.isStatic(f.getModifiers())
               || !java.lang.reflect.Modifier.isFinal(f.getModifiers());
    }

    private static String generateDescription(String name, String description) {
        return description == null || description.isEmpty() ? "Model for " + Utils.generateDocumentationString(name)
                                                            : description;
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

    public boolean mayHaveLongLines() {
        return mayHaveLongLines;
    }

    public void setMayHaveLongLines(boolean mayHaveLongLines) {
        this.mayHaveLongLines = mayHaveLongLines;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public boolean hasPackageName() {
        return has(packageName);
    }

    public boolean hasSuperClass() {
        return superClassType != null;
    }

    public TypeParameter getSuperClassType() {
        return superClassType;
    }

    public boolean isIgnoreLiteralDuplicate() {
        return ignoreLiteralDuplicate;
    }

    public void setIgnoreLiteralDuplicate(boolean ignoreLiteralDuplicate) {
        this.ignoreLiteralDuplicate = ignoreLiteralDuplicate;
    }

    public boolean shouldBeSorted() {
        return shouldBeSorted;
    }

    public void setShouldBeSorted(boolean shouldBeSorted) {
        this.shouldBeSorted = shouldBeSorted;
    }

    public void setSuperClassType(TypeParameter superClassType) {
        this.superClassType = superClassType;
        if (this.superClassType != null) {
            try {
                this.superClassType.translate();
            } catch (TranslationException exception) {
                // Nothing to do
                exception.printStackTrace();
            }
        }
        this.superClassFields = getSuperClassFields();
        this.superClassMethods = getSuperClassMethods();
    }

    public Model field(Field field) {
        addField(field);
        return this;
    }

    public void addFields(Collection<Field> fields) {
        if (fields == null) {
            return;
        }
        fields.forEach(f -> addField(f));
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

    public Model constant(Field field) {
        addConstant(field);
        return this;
    }

    public void addConstants(Collection<Field> fields) {
        if (fields == null) {
            return;
        }
        fields.forEach(f -> addConstant(f));
    }

    public void addConstant(Field field) {
        if (!hasConstant(field)) {
            overrideConstantIfExists(field);
        }
    }

    public void overrideConstantIfExists(Field field) {
        if (field == null) {
            return;
        }
        constants.put(field.getIdentifier(), field);
    }

    public String getFullName() {
        return hasPackageName() ? getPackageName() + "." + getName() : getName();
    }

    /**
     * @return the parent
     */
    public String getAbstractParent() {
        return abstractParent;
    }

    public boolean hasMethods() {
        return !methods.isEmpty();
    }

    public boolean hasFields() {
        return !fields.isEmpty();
    }

    public boolean hasConstants() {
        return !constants.isEmpty();
    }

    public boolean hasFieldsWithDefaultValues() {
        return hasFields() && fields.values().stream().anyMatch(f -> f.hasDefaultValue());
    }

    public boolean hasFieldsNeedingValidation() {
        return hasFields() && fields.values().stream().anyMatch(f -> f.needsValidation() && !f.isReadOnly());
    }

    /**
     * @return the methods
     */
    public List<Method> getMethodList() {
        return getMethodList(false);
    }

    private List<Method> getMethodList(boolean shouldBeSorted) {
        final List<Method> list = new ArrayList<>(methods.values());
        if (shouldBeSorted) {
            return list.stream().sorted(Comparator.comparing(Method::getIdentifier)).collect(Collectors.toList());
        }
        return list;
    }

    public boolean hasMethod(Method method) {
        return method == null ? false : hasMethod(method.getIdentifier());
    }

    private List<String> fetchAllOverloadedMethods(String rawIdentifier) {
        if (rawIdentifier == null || rawIdentifier.isEmpty()) {
            return new ArrayList<>();
        }
        final List<String> methodIds = new ArrayList<>(methods.keySet());
        if (hasSuperClass()) {
            methodIds.addAll(superClassMethods.keySet());
        }
        return methodIds.stream()
                        .filter(m -> rawIdentifier.equals(m)
                                     || rawIdentifier.equals(MethodOverloaded.fetchMethodRawIdentifier(m)))
                        .collect(Collectors.toList());
    }

    protected boolean hasSpecificMethod(String identifier) {
        if (identifier == null) {
            return false;
        }
        if (hasSpecificMethodRegisteredAsIs(identifier)) {
            return true;
        }
        final String suffix = MethodOverloaded.fetchMethodIdentifierSuffix(identifier);
        if (suffix == null || suffix.isEmpty()) {
            return false;
        }
        return fetchAllMethods(identifier).stream()
                                          .anyMatch(m -> suffix.equals(MethodOverloaded.generateOverloadSuffix(m)));
    }

    protected Method getSpecificMethod(String identifier) {
        if (identifier == null) {
            return null;
        }
        final Method method = getSpecificMethodRegisteredAsIs(identifier);
        if (method != null) {
            return method;
        }
        final String suffix = MethodOverloaded.fetchMethodIdentifierSuffix(identifier);
        if (suffix == null || suffix.isEmpty()) {
            return null;
        }
        return fetchAllMethods(identifier).stream()
                                          .filter(m -> suffix.equals(MethodOverloaded.generateOverloadSuffix(m)))
                                          .findFirst().orElse(null);
    }

    private boolean hasSpecificMethodRegisteredAsIs(String identifier) {
        return methods.containsKey(identifier) || (hasSuperClass() && superClassMethods.containsKey(identifier));
    }

    private Method getSpecificMethodRegisteredAsIs(String identifier) {
        final Method method = methods.get(identifier);
        if (method != null) {
            return method;
        }
        return hasSuperClass() ? superClassMethods.get(identifier) : null;
    }

    private List<Method> fetchAllMethods(String identifier) {
        final String rawId = MethodOverloaded.isOverloadedMethod(identifier) ? MethodOverloaded.fetchMethodRawIdentifier(identifier)
                                                                             : identifier;
        return fetchAllOverloadedMethods(rawId).stream().map(id -> getSpecificMethod(id)).collect(Collectors.toList());
    }

    private boolean hasAnyMethod(String identifier) {
        if (hasSpecificMethod(identifier)) {
            return true;
        }
        final String rawId = MethodOverloaded.isOverloadedMethod(identifier) ? MethodOverloaded.fetchMethodRawIdentifier(identifier)
                                                                             : identifier;
        return !fetchAllOverloadedMethods(rawId).isEmpty();
    }

    private Method fetchAnyMethod(String identifier) {
        final Method method = getSpecificMethod(identifier);
        if (method != null) {
            return method;
        }
        final String rawId = MethodOverloaded.isOverloadedMethod(identifier) ? MethodOverloaded.fetchMethodRawIdentifier(identifier)
                                                                             : identifier;
        final String id = fetchAllOverloadedMethods(rawId).stream().findFirst().orElse(null);
        return id == null ? null : getSpecificMethod(id);
    }

    public boolean hasMethod(String identifier) {
        return identifier == null || identifier.isEmpty() ? false : hasAnyMethod(identifier.trim());
    }

    public void addMethod(Method method) {
        if (method != null && method instanceof MethodOverloaded) {
            ((MethodOverloaded) method).generateSuffix();
        }
        if (!hasMethod(method) || MethodOverloaded.isOverloadedMethod(method)) {
            overrideMethodIfExist(method);
        }
    }

    public Method fetchMethod(String identifier) {
        return identifier == null || identifier.isEmpty() ? null : fetchAnyMethod(identifier.trim());
    }

    public boolean hasField(Field field) {
        return field == null ? false : hasField(field.getIdentifier());
    }

    public boolean hasIdentifierField() {
        return fields.values().stream().anyMatch(f -> f.isIdentifier());
    }

    public Field getIdentifierField() {
        return fields.values().stream().filter(f -> f.isIdentifier()).findFirst().orElse(null);
    }

    public boolean hasField(String identifier) {
        if (identifier == null) {
            return false;
        }
        final boolean hasField = fields.containsKey(identifier);
        if (hasField) {
            return true;
        }
        if (Field.isUsualIdentifier(identifier)) {
            return hasIdentifierField();
        }
        return false;
    }

    public boolean hasConstant(Field constant) {
        return constant == null ? false : hasConstant(constant.getIdentifier());
    }

    public boolean hasConstant(String identifier) {
        return identifier == null ? false : constants.containsKey(identifier);
    }

    public boolean hasFieldInSuperclass(String identifier) {
        return hasSuperClass() && superClassFields.containsKey(identifier);
    }

    public boolean hasFieldInHierachy(String identifier) {
        return hasField(identifier) || hasFieldInSuperclass(identifier);
    }

    public Field fetchField(String identifier) {
        if (hasField(identifier)) {
            final Field value = fields.get(identifier);
            if (value == null && Field.isUsualIdentifier(identifier)) {
                return getIdentifierField();
            }
            return value;
        }
        return null;
    }

    public void overrideMethodIfExist(Method method) {
        if (method == null) {
            return;
        }
        methods.put(method.getIdentifier(), method);
    }

    public void removeMethodIfExist(Method method) {
        if (method == null) {
            return;
        }
        methods.remove(method.getIdentifier());
    }

    /**
     * @return the fields
     */
    public List<Field> getFieldList() {
        final List<Field> allfields = new ArrayList<>(fields.values());
        allfields.addAll(superClassFields.values());
        return allfields;
    }

    public List<Field> getConstantList() {
        return new ArrayList<>(constants.values()).stream().sorted(Comparator.comparing(Field::getIdentifier))
                                                  .collect(Collectors.toList());
    }

    public List<Field> getSettableFields() {
        return getFieldList().stream().filter(f -> !f.isReadOnly()).collect(Collectors.toList());
    }

    public List<Field> getFieldsNeedingValidation() {
        return getFieldList().stream().filter(f -> f.needsValidation() && !f.isReadOnly()).collect(Collectors.toList());
    }

    public boolean hasReadOnlyFields() {
        return getFieldList().stream().anyMatch(f -> f.isReadOnly() && !f.isStatic());
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
    public void setAbstractParent(String parent) {
        this.abstractParent = parent;
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

    public String generateParentClassName() {
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

    protected void initialiseBuilder() throws TranslationException {
        if (specificationBuilder == null) {
            specificationBuilder = TypeSpec.classBuilder(name).addModifiers(Modifier.PUBLIC);
            if (isAbstract) {
                specificationBuilder.addModifiers(Modifier.ABSTRACT);
            }
            if (isFinal) {
                specificationBuilder.addModifiers(Modifier.FINAL);
            }
            generateDocumentation();
            generateAnnotations();
            if (hasSuperInterface() && !hasAbstractParent()) {
                generateSuperInterface();
            }
            if (hasParent()) {
                if (hasAbstractParent()) {
                    specificationBuilder.superclass(ClassName.get(packageName, abstractParent));
                } else {
                    superClassType.translate();
                    if (superClassType.hasClass()) {
                        specificationBuilder.superclass(superClassType.getClazz());
                    } else {
                        specificationBuilder.superclass(superClassType.getTypeName());
                    }
                }
            }
        }
    }

    protected void generateSuperInterface() {
        specificationBuilder.addSuperinterface(getSuperInterface());
    }

    public void generateAnnotations() {
        if (isInternal) {
            specificationBuilder.addAnnotation(AnnotationSpec.builder(Internal.class).build());
        }
        if (hasCyclomaticComplexity()) {
            annotationRegistry.ignoreCyclomaticComplexity();
        }
        if (hasFieldsWithDefaultValues() || isIgnoreLiteralDuplicate()) {
            annotationRegistry.ignoreAvoidDuplicateLiterals();
        }
        if (mayHaveLongLines()) {
            annotationRegistry.ignoreLongLines();
        }
        addStaticAnalysisAnnotations();
    }

    @Override
    protected void addStaticAnalysisAnnotations() {
        if (annotationRegistry.hasAnnotations()) {
            specificationBuilder.addAnnotation(annotationRegistry.generateAnnotation());
        }
    }

    protected void generateDocumentation() {
        specificationBuilder.addAnnotation(AnnotationSpec.builder(Preamble.class)
                                                         .addMember("description", "\"" + description + "\"").build());
        specificationBuilder.addJavadoc(generateClassJavadocComment(hasDescription(), description, hasLongDescription(),
                                                                    longDescription));
    }

    public boolean needsCustomisation() {
        return needsCustomCode() || needsFieldCustomisation() || needsMethodCustomisation();
    }

    public boolean needsMethodCustomisation() {
        return getMethodList().stream().anyMatch(m -> m.needsCustomCode());
    }

    public boolean needsFieldCustomisation() {
        return getFieldList().stream().anyMatch(f -> f.needsCustomCode());
    }

    public boolean hasCyclomaticComplexity() {
        return hasCyclomaticComplexity
               || fields != null && fields.values().stream().filter(f -> !f.isStatic() || !f.isReadOnly())
                                          .count() > StaticAnalysisUtils.FIELD_LIMIT_FOR_IGNORING_WARNINGS;
    }

    public void setHasCyclomaticComplexity(boolean hasCyclomaticComplexity) {
        this.hasCyclomaticComplexity = hasCyclomaticComplexity;
    }

    public Map<String, Field> getSuperClassFields() {
        if (!hasSuperClass() || !superClassType.hasClazz()) {
            return new Hashtable<>();
        }
        final Map<String, Field> map = new LinkedHashMap<>();
        Class<?> clazz = superClassType.getClazz();
        while (clazz != null) {
            final Class<?> currentClazz = clazz;
            final java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            if (fields != null) {
                Arrays.asList(fields).stream()
                      .filter(f -> shouldConsiderField(f)
                                   && (java.lang.reflect.Modifier.isPublic(f.getModifiers())
                                       || java.lang.reflect.Modifier.isProtected(f.getModifiers())))
                      .forEach(f -> {
                          final Field field = new Field(f, true, false, null, hasASetter(currentClazz, f));
                          map.put(field.getName(), field);
                      });
            }
            clazz = clazz.getSuperclass();
        }
        return map;
    }

    public Map<String, Method> getSuperClassMethods() {
        if (!hasSuperClass()) {
            return new Hashtable<>();
        }
        final Map<String, Method> map = new LinkedHashMap<>();
        Class<?> clazz = superClassType.getRawClass();
        while (clazz != null) {
            final java.lang.reflect.Method[] methods = clazz.getDeclaredMethods();
            if (methods != null) {
                Arrays.asList(methods).stream()
                      .filter(m -> (!java.lang.reflect.Modifier.isAbstract(m.getModifiers()))
                                   && (java.lang.reflect.Modifier.isPublic(m.getModifiers())
                                       || java.lang.reflect.Modifier.isProtected(m.getModifiers())))
                      .forEach(m -> {
                          final MethodOverloaded method = new MethodOverloaded(m, null, null,
                                                                               m.isAnnotationPresent(Override.class),
                                                                               true, null);
                          method.generateSuffix();
                          map.put(method.getIdentifier(), method);
                      });
            }
            clazz = clazz.getSuperclass();
        }
        return map;
    }

    private Model generateParentModel() {
        final Model parentModel = new Model(superClassType.getPackageName(), superClassType.getShortName(), null, null,
                                            null, true, false, false, true);
        parentModel.addFields(superClassFields.values());
        parentModel.generateMethodsNecessaryAtEachLevel();
        return parentModel;
    }

    private Model generateAbstractModel() {
        final Model abstractModel = generateEmptyAbstractModel();
        if (hasSuperClass()) {
            abstractModel.setSuperClassType(superClassType);
        }
        getFieldList().stream().filter(f -> !f.needsCustomCode() && !f.isAlreadyDefined()).forEach(f -> {
            f.setAccessible(true);
            abstractModel.addField(f);
        });
        getMethodList().stream().filter(m -> !m.isConstructor() && !m.needsCustomCode() && !m.needsToBeAtBottomLevel())
                       .forEach(m -> abstractModel.addMethod(m));
        addSpecificAbstractMethods(abstractModel);
        abstractModel.generateMethodsNecessaryAtEachLevel();
        abstractModel.ensureInterfaceMethodsHaveOverrideAnnotation();
        return abstractModel;
    }

    protected void addSpecificAbstractMethods(final Model abstractModel) {
        // Nothing to do
    }

    private Model generateChildModel() {
        final Model child = generateEmptyChildModel();
        child.setAbstractParent(generateParentClassName());
        getFieldList().stream().filter(f -> f.needsCustomCode()).forEach(f -> {
            f.setContainsCustomCode(true);
            child.addField(f);
        });
        getMethodList().stream().filter(m -> !m.isConstructor() && (m.needsCustomCode() || m.needsToBeAtBottomLevel()))
                       .forEach(m -> {
                           modifyChildMethod(m);
                           child.addMethod(m);
                       });
        child.generateMethodsNecessaryAtEachLevel();
        child.ensureInterfaceMethodsHaveOverrideAnnotation();
        return child;
    }

    protected void modifyChildMethod(Method m) {
        m.setContainsCustomCode(true);
    }

    protected Model generateEmptyChildModel() {
        return new Model(packageName, name, group, description, longDescription, false, false, true, isInternal);
    }

    protected Model generateEmptyAbstractModel() {
        return new Model(packageName, name, group, description, longDescription, true, false, false, isInternal);
    }

    public <T extends SdkArtifact> boolean requestCustomCode(Class<T> type, String key) {
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

    /**
     * @return the contructorsName
     */
    public List<String> getContructorIdentifiers() {
        return contructorsName;
    }

    public boolean hasConstructor(String identifier) {
        return identifier == null || contructorsName.isEmpty() ? false : contructorsName.contains(identifier);
    }

    public void generateMethods() {
        // methods.clear();
        // Adding getters and setters
        generateSettersAndGettersAndValidators();
        generateOtherMethods();
        generateMethodsNecessaryAtEachLevel();
        generateInterfaceMethods();
    }

    protected void generateOtherMethods() {
        // Nothing to do

    }

    protected void generateSettersAndGettersAndValidators() {
        getFieldList().stream().filter(f -> !f.isAlreadyDefined()).forEach(f -> {
            final MethodGetter getter = new MethodGetter(f, null, false, f.isIdentifier() && !f.getType().isString());
            getter.setDeprecation(f.getDeprecation());
            getter.setInternal(f.isInternal());
            addMethod(getter);
            if (!f.isReadOnly()) {
                final MethodSetter setter = new MethodSetter(f, null, false, false);
                setter.setDeprecation(f.getDeprecation());
                setter.setInternal(f.isInternal());
                addMethod(setter);
                if (f.isIdentifier()) {
                    boolean notStringId = !f.getType().isString();
                    final Field equivalentF = f.clone();
                    Method equivalentGetter = null;
                    if (f.isUsualIdentifier()) {
                        equivalentF.setName(Utils.combineNames(false, name, Field.IDENTIFIER_NAME));// model name + id
                        // e.g. ApiKeyId
                    } else {
                        equivalentF.setName(Field.IDENTIFIER_NAME);// Have a setId/getId methods
                        // a getId method needs to also be added
                        equivalentGetter = new MethodGetter(equivalentF, Utils.generateDocumentationMethodLink(null,
                                                                                                               getter),
                                                            true, notStringId).statement(
                                                                                         getter.getCallStatement()
                                                                                         + System.lineSeparator());

                    }
                    if (notStringId) {
                        final MethodSetter NotStringSetter = new MethodSetter(f.isUsualIdentifier() ? f : equivalentF,
                                                                              null, false, true);
                        NotStringSetter.setDeprecation(f.getDeprecation());
                        NotStringSetter.setInternal(f.isInternal());
                        addMethod(NotStringSetter);
                        final Field equivalentF2 = (f.isUsualIdentifier() ? equivalentF : f).clone();
                        equivalentF2.setType(TypeFactory.stringType());
                        final Method NotStringSetter2 = new MethodSetter(equivalentF2,
                                                                         Utils.generateDocumentationMethodLink(null,
                                                                                                               NotStringSetter),
                                                                         true, false).statement(
                                                                                                NotStringSetter.getCallStatement(equivalentF2.toParameter())
                                                                                                + System.lineSeparator());
                        addMethod(NotStringSetter2);

                    }
                    Method equivalentSetter = new MethodSetter(equivalentF,
                                                               Utils.generateDocumentationMethodLink(null,
                                                                                                     setter),
                                                               true, false).statement(
                                                                                      setter.getCallStatement(equivalentF.toParameter())
                                                                                      + System.lineSeparator());
                    equivalentSetter.setDeprecation(f.getDeprecation());
                    addMethod(equivalentSetter);
                    if (equivalentGetter != null) {
                        equivalentGetter.setDeprecation(f.getDeprecation());
                        addMethod(equivalentGetter);
                    }

                }
                // Ensures it is possible to set an enumerator from its String representation
                if (f.getType().isModelEnum()) {
                    Method equivalentSetter = new MethodSetter(f, Utils.generateDocumentationMethodLink(null, setter),
                                                               true, true);
                    equivalentSetter.setDeprecation(f.getDeprecation());
                    addMethod(equivalentSetter);
                }
                if (f.needsValidation()) {
                    addMethod(new MethodIsFieldValid(f, false));
                }
            }
        });
        if (hasFieldsNeedingValidation()) {
            setIgnoreLiteralDuplicate(true);
        }
    }

    public void addNoIdentifierGetterAndSetter() {
        final Method setter = new MethodSetter(Field.defaultIdentifier());
        setter.setStatement("// Nothing to do" + System.lineSeparator());
        setter.setDoesNotPerformAnything(true);
        setter.setInternal(true);
        addMethod(setter);
        final Method getter = new MethodGetter(Field.defaultIdentifier(),
                                               "Warning: " + name + " model does not have any ID field. This always returns {@code null}.",
                                               true, false);
        getter.setStatement("return null");
        addMethod(getter);
    }

    protected void generateMethodsNecessaryAtEachLevel() {
        generateMethodsDependingOnParents(null);
    }

    protected void generateMethodsDependingOnParents(Model theParent) {
        generateToString(theParent);
        generateHashCodeAndEquals(theParent);
        generateIsValid(theParent);
        generateConstructors(theParent);
        generateClone(theParent);
    }

    private void generateInterfaceMethods() {
        checkInterfaceMethodsState(true);
    }

    private void ensureInterfaceMethodsHaveOverrideAnnotation() {
        checkInterfaceMethodsState(false);
    }

    private void checkInterfaceMethodsState(boolean createIfMissing) {
        fetchSuperInterfaceMethods().forEach(m -> {
            final String suffix = MethodOverloaded.generateOverloadSuffix(m);
            final String methodId = MethodOverloaded.generateIdentifier(m.getName(), suffix);
            if (hasSpecificMethod(methodId)) {
                getSpecificMethod(methodId).setAsOverride(true);
            } else {
                if (createIfMissing) {
                    addMethod(createMissingInterfaceMethod(m, suffix));
                }
            }
        });
    }

    protected MethodGeneric createMissingInterfaceMethod(java.lang.reflect.Method m, final String suffix) {
        return new MethodGeneric(m, suffix);
    }

    protected List<java.lang.reflect.Method> fetchSuperInterfaceMethods() {
        return hasSuperInterface() ? Arrays.asList(getSuperInterface().getMethods()) : new ArrayList<>();
    }

    protected Class<?> getSuperInterface() {
        return SdkModel.class;
    }

    protected boolean hasSuperInterface() {
        return true;
    }

    protected boolean isSerialisable() {
        return true;
    }

    protected void generateHashCodeAndEquals(Model theParent) {
        if (hasFields()) {
            generateHashCode(theParent);
        }
        overrideMethodIfExist(new MethodCanEqual(this, theParent));
        Method equal = new MethodEquals(this, theParent);
        if (theParent == null) {
            addMethod(equal);
        } else {
            overrideMethodIfExist(equal);
        }
    }

    protected void generateHashCode(Model theParent) {
        Method hashCode = new MethodHashCode(this, theParent);
        if (theParent == null) {
            addMethod(hashCode);
        } else {
            overrideMethodIfExist(hashCode);
        }
    }

    protected void generateConstructors(Model theParent) {
        ConstructorList constructors = new ConstructorList();
        contructorsName.clear();
        constructors.add(new MethodConstructorAllFields(this, theParent));
        constructors.add(new MethodConstructorFromObject(this, theParent));
        constructors.add(new MethodConstructorEmpty(this, theParent));
        constructors.add(new MethodConstructorIdentifiers(this, theParent));
        constructors.add(new MethodConstructorReadOnly(this, theParent));
        constructors.add(new MethodConstructorRequired(this, theParent));
        constructors.getRefinedList().forEach(c -> addConstructor(c));
    }

    protected void addConstructor(AbstractMethodConstructor constructor) {
        contructorsName.add(constructor.getIdentifier());
        overrideMethodIfExist(constructor);
    }

    protected void generateToString(Model theParent) {
        overrideMethodIfExist(new MethodToString(this, theParent));
    }

    protected void generateIsValid(Model theParent) {
        overrideMethodIfExist(new MethodIsValid(this, theParent));
    }

    protected void generateClone(Model theParent) {
        final MethodClone cloneMethod = instantiateCloneMethod(theParent);
        if (!this.isAbstract()) {
            overrideMethodIfExist(cloneMethod);
        } else {
            removeMethodIfExist(cloneMethod);
        }
    }

    protected MethodClone instantiateCloneMethod(Model theParent) {
        return new MethodClone(this, theParent);
    }

    public List<Model> getProcessedModels() {
        List<Model> models = new ArrayList<>(2);
        if (needsCustomisation()) {
            final Model abstractModel = generateAbstractModel();
            if (hasSuperClass()) {
                final Model parentModel = generateParentModel();
                abstractModel.generateMethodsDependingOnParents(parentModel);
            }
            abstractModel.setHasCyclomaticComplexity(hasCyclomaticComplexity());
            models.add(abstractModel);
            final Model childModel = generateChildModel();
            childModel.generateMethodsDependingOnParents(abstractModel);
            childModel.setHasCyclomaticComplexity(hasCyclomaticComplexity());
            models.add(childModel);
        } else {
            if (hasSuperClass()) {
                final Model parentModel = generateParentModel();
                generateMethodsDependingOnParents(parentModel);
            }
            models.add(this);
        }
        return models;
    }

    public boolean hasParent() {
        return hasAbstractParent() || hasSuperClass();
    }

    protected boolean hasAbstractParent() {
        return has(abstractParent);
    }

    private static String generateClassJavadocComment(boolean hasDescription, String description,
                                                      boolean hasLongDescription, String longDescription) {
        StringBuilder builder = new StringBuilder();
        if (hasDescription) {
            builder.append(description);
        }
        if (hasLongDescription) {
            builder.append(Utils.generateNewDocumentationLine());
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
        final String serialisationString = builder.toString();
        return serialisationString.length() > MAX_LONG_LENGTH ? serialisationString.substring(0, MAX_LONG_LENGTH)
                                                              : serialisationString;
    }

    protected void addSerialisationId() {
        if (!isSerialisable()) {// isAbstract ||
            return;
        }
        final Field serialVersionUID = new Field(true, TypeFactory.getCorrespondingType(long.class),
                                                 Utils.SERIALISATION_UUID, "Serialisation Id.", null, null, true, false,
                                                 false, false, null, false);
        serialVersionUID.setInitialiser(generateSerialisationId() + "L");
        addConstant(serialVersionUID);
    }

    protected void translateConstants() throws TranslationException {
        addSerialisationId();
        if (!hasConstants()) {
            return;
        }
        for (final Field f : getConstantList()) {
            f.translate();
            specificationBuilder.addField(f.getSpecificationBuilder().build());
        }
    }

    protected void translateFields() throws TranslationException {
        for (final Field f : getFieldList()) {
            if (!f.needsCustomCode() && !f.isAlreadyDefined()) {
                f.translate();
                specificationBuilder.addField(f.getSpecificationBuilder().build());
            }
        }
    }

    protected void translateMethods() throws TranslationException {
        for (final Method m : getMethodList(shouldBeSorted)) {
            m.translate();
            specificationBuilder.addMethod(m.getSpecificationBuilder().build());
        }
    }

    public String getListOfFieldsToDefineManually() {
        StringBuilder builder = new StringBuilder();
        getFieldList().stream().filter(f -> f.needsCustomCode)
                      .forEach(f -> builder.append("- " + f.getName()).append(System.lineSeparator()));
        return builder.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.model.Entity#translate()
     */
    @Override
    public void translate() throws TranslationException {
        try {
            initialiseBuilder();
            translateConstants();
            translateFields();
            translateMethods();
        } catch (TranslationException exception) {
            throw new TranslationException("Error in model definition: " + this, exception);
        }
    }

    public TypeParameter toType() {
        return concreteType == null ? new TypeParameter(toImport()) : concreteType;
    }

    protected Import toImport() {
        return new Import(name, packageName);
    }

    public Parameter toParameter(String parameterName) {
        final String finalParameterName = ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(parameterName == null ? name
                                                                                                                          : parameterName),
                                                                       false);
        return new Parameter(finalParameterName, Utils.generateDocumentationString(name), null, toType(), null, null);
    }

    public Parameter toParameter() {
        return toParameter(null);
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

    private static class ConstructorList {
        final List<AbstractMethodConstructor> constructors = new LinkedList<>();

        public ConstructorList() {
            super();
        }

        public void add(AbstractMethodConstructor constructor) {
            if (constructor == null) {
                return;
            }
            if (!constructors.stream().anyMatch(c -> c.hasSameSignature(constructor))) {
                constructors.add(constructor);
            }
        }

        public List<AbstractMethodConstructor> getRefinedList() {
            return constructors.stream().filter(c -> c.isNecessary()).collect(Collectors.toList());
        }
    }

}
