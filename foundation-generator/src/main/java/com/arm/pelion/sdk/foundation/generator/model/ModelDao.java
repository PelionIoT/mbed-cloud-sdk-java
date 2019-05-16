package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.dao.AbstractCloudDao;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.CreateDao;
import com.arm.mbed.cloud.sdk.common.dao.CrudDao;
import com.arm.mbed.cloud.sdk.common.dao.DaoProvider;
import com.arm.mbed.cloud.sdk.common.dao.DeleteDao;
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;
import com.arm.mbed.cloud.sdk.common.dao.UpdateDao;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelDao extends Model {
    protected final Model correspondingModel;
    protected final ModelModule correspondingModule;
    private final MethodRegistry methodRegistry;
    private final Map<String, Class<?>> superinterfaces;

    public ModelDao(Model currentModel, ModelModule module, boolean needsCustom) {
        super(currentModel.packageName, DaoProvider.getCorrespondingDaoName(currentModel.name), currentModel.group,
              generateDescription(currentModel), generateLongDescription(currentModel), currentModel.isAbstract,
              needsCustom, currentModel.containsCustomCode, currentModel.isInternal);
        methodRegistry = new MethodRegistry();
        methodRegistry.clear();
        correspondingModel = currentModel;
        correspondingModule = module;
        superinterfaces = new HashMap<>(4);
        setSuperClass(currentModel);
        setShouldBeSorted(true);
    }

    protected void setSuperClass(Model currentModel) {
        setSuperClassType(((TypeCompose) TypeFactory.getCorrespondingType(com.arm.mbed.cloud.sdk.common.dao.ModelDao.class,
                                                                          currentModel.toType())).concreteImplementation(true));
    }

    private static String generateDescription(Model currentModel) {
        return "Data Access Object (DAO) for " + Utils.generateDocumentationString(currentModel.getName(), true);
    }

    private static String generateLongDescription(Model currentModel) {
        return "@see <a  href=\"http://www.corej2eepatterns.com/Patterns/DataAccessObject.htm\">Core J2EE Patterns - Data Access Object</a>";
    }

    @Override
    protected void generateSuperInterface() {
        for (Class<?> i : superinterfaces.values()) {
            final TypeParameter type = generateSuperInterfaceType(i);
            try {
                type.translate();
                if (type.hasClass()) {
                    specificationBuilder.addSuperinterface(type.getClazz());
                } else {
                    specificationBuilder.addSuperinterface(type.getTypeName());
                }
            } catch (Exception e) {
                // nothing to do
                e.printStackTrace();
            }
        }
    }

    protected TypeParameter generateSuperInterfaceType(Class<?> i) {
        return new TypeModelDao(i, correspondingModel.toType());
    }

    @Override
    protected boolean hasSuperInterface() {
        return !superinterfaces.isEmpty();
    }

    private void checkSuperInterfaces() {
        if (Arrays.asList(CrudDao.class.getInterfaces()).stream()
                  .allMatch(i -> superinterfaces.values().stream().anyMatch(subi -> subi != null && subi.equals(i)))) {
            superinterfaces.clear();
            addSuperInterface(CrudDao.class);
        }
    }

    @SuppressWarnings("incomplete-switch")
    public void addMethods(MethodAction action, String methodName, String description, String longDescription,
                           boolean needsCustomCode) {
        Class<?> correspondingInterface = null;
        String daoMethodName = null;
        switch (action) {
            case CREATE:
                correspondingInterface = CreateDao.class;
                daoMethodName = CreateDao.METHOD_NAME_CREATE;
                break;
            case DELETE:
                correspondingInterface = DeleteDao.class;
                daoMethodName = DeleteDao.METHOD_NAME_DELETE;
                break;
            case READ:
                correspondingInterface = ReadDao.class;
                daoMethodName = ReadDao.METHOD_NAME_READ;
                break;
            case UPDATE:
                correspondingInterface = UpdateDao.class;
                daoMethodName = UpdateDao.METHOD_NAME_UPDATE;
                break;
            case ME:
                daoMethodName = ReadDao.METHOD_NAME_ME;
                break;

        }
        if (!superinterfaces.containsKey(CrudDao.class.getName())) {
            addSuperInterface(correspondingInterface);
            checkSuperInterfaces();
        }
        registerMethod(action, methodName, description, longDescription, needsCustomCode, correspondingInterface,
                       daoMethodName);
    }

    protected void registerMethod(MethodAction action, String methodName, String description, String longDescription,
                                  boolean needsCustomCode, Class<?> correspondingInterface, String daoMethodName) {
        methodRegistry.addRecord(new MethodRecord(action, methodName, description, longDescription, needsCustomCode,
                                                  correspondingInterface, daoMethodName));
    }

    protected void addSuperInterface(Class<?> correspondingInterface) {
        if (correspondingInterface != null) {
            superinterfaces.put(correspondingInterface.getName(), correspondingInterface);
        }
    }

    protected void generateCrudMethods(MethodAction action, String daoMethodName, Class<?> correspondingInterface,
                                       boolean needsCustomCode, boolean isPublic) {
        if (!correspondingModule.hasMethods(correspondingModel, action)) {
            final AtomicInteger counter = new AtomicInteger();
            Arrays.asList(correspondingInterface.getDeclaredMethods())
                  .forEach(m -> addMethod(new MethodGeneric(m, String.valueOf(counter.incrementAndGet()))));
            return;
        }
        final List<Method> moduleMethods = correspondingModule.getAllMethods(correspondingModel, action);
        for (Method moduleMethod : moduleMethods) {
            final MethodOverloaded method = generateMethod(daoMethodName, needsCustomCode, isPublic, null, moduleMethod,
                                                           correspondingModule.toType());
            addMethodAndMethodWithInternalModel(method);
        }
    }

    private void addMethodAndMethodWithInternalModel(final MethodOverloaded method) {
        if (method.hasParameterOfType(correspondingModel.toType())) {
            addMethod(generateMethodWithInternalModel(method, null));
            if (method.getParameterCount() == 1) {
                method.setOverloadingSuffix(MethodOverloaded.generateOverloadSuffix(Arrays.asList(new Parameter("model",
                                                                                                                SdkModel.class))));
            }
        }
        addMethod(method);
    }

    private void generateOtherMethod(MethodAction action, String methodName, String daoMethodName, String description,
                                     String longDescription, boolean needsCustomCode, boolean isPublic) {
        if (!correspondingModule.hasMethod(correspondingModel, action, methodName)) {
            Method method = new MethodGeneric(daoMethodName == null || daoMethodName.isEmpty() ? methodName
                                                                                               : daoMethodName,
                                              description, longDescription, null);
            method.setAsOverride(false);
            addMethod(method);
            return;
        }
        final List<Method> moduleMethods = correspondingModule.getAllMethods(correspondingModel, action, methodName);
        for (Method moduleMethod : moduleMethods) {
            addOtherMethod(methodName, daoMethodName, needsCustomCode, isPublic, moduleMethod);
            if (moduleMethod instanceof MethodModuleListApiUnself) {
                final List<Method> modulePaginatorMethods = correspondingModule.getAllMethods(correspondingModel,
                                                                                              MethodAction.PAGINATION_OTHER,
                                                                                              MethodModulePaginationApi.generatePaginatorName((MethodModuleCloudApi) moduleMethod));
                for (Method modulePaginatorMethod : modulePaginatorMethods) {
                    addOtherMethod(MethodModulePaginationApi.generatePaginatorName(methodName),
                                   MethodModulePaginationApi.generatePaginatorName(daoMethodName), needsCustomCode,
                                   isPublic, modulePaginatorMethod);
                }

            }
        }

    }

    private void addOtherMethod(String methodName, String daoMethodName, boolean needsCustomCode, boolean isPublic,
                                Method moduleMethod) {
        final MethodOverloaded method = generateMethod(daoMethodName == null || daoMethodName.isEmpty() ? methodName
                                                                                                        : daoMethodName,
                                                       needsCustomCode, isPublic, null, moduleMethod,
                                                       correspondingModule.toType());
        addMethodAndMethodWithInternalModel(method);
    }

    private MethodOverloaded generateMethod(String methodName, boolean needsCustomCode, boolean isPublic, String suffix,
                                            Method moduleMethod, TypeParameter moduleType) {
        final MethodOverloaded method = new MethodOverloaded(false, methodName, moduleMethod.getDescription(),
                                                             Utils.generateDocumentationMethodLink(correspondingModule,
                                                                                                   moduleMethod),
                                                             false, isPublic, false, false, false, false, false, false,
                                                             suffix);
        method.setIgnoreShortName(true);
        method.addException(MbedCloudException.class);
        method.setNeedsCustomCode(needsCustomCode || moduleMethod.isInternal());
        method.setDeprecation(moduleMethod.getDeprecation());
        method.initialiseCodeBuilder();
        generateMethodCodeAndReturnType(moduleMethod, method, moduleType, false);
        return method;
    }

    private MethodOverloaded generateMethodWithInternalModel(MethodOverloaded methodToUse, String suffix) {
        final String longDescription = "Note: uses internal data model" + Utils.generateNewDocumentationLine()
                                       + Utils.generateDocumentationMethodLink(this, methodToUse);
        final MethodOverloaded method = new MethodOverloaded(false, methodToUse.getName(), methodToUse.getDescription(),
                                                             longDescription, false, methodToUse.isAccessible, false,
                                                             false, false, false, false, false, suffix);
        method.setIgnoreShortName(true);
        method.addException(MbedCloudException.class);
        method.setDeprecation(methodToUse.getDeprecation());
        method.initialiseCodeBuilder();
        generateMethodCodeAndReturnTypeUsingInternalModel(methodToUse, method);
        return method;
    }

    private void generateMethodCodeAndReturnTypeUsingInternalModel(Method methodToUse, final MethodOverloaded method) {
        StringBuilder codeFormat = new StringBuilder();
        List<Object> values = new LinkedList<>();
        boolean closeBracket = false;
        if (methodToUse.hasReturn()) {
            method.setReturnType(methodToUse.getReturnType());
            method.setReturnDescription(methodToUse.getReturnDescription());

            codeFormat.append("return ");
        }
        codeFormat.append("$L(");
        values.add(methodToUse.getName());
        if (methodToUse.hasParameters()) {
            boolean start = true;
            for (Parameter p : methodToUse.getParameters()) {
                if (start) {
                    start = false;
                } else {
                    codeFormat.append(", ");
                }
                if (p.getType().isModel(correspondingModel)) {
                    codeFormat.append("$L()");
                    values.add(AbstractModelDao.METHOD_GET_MODEL);
                } else {
                    method.addParameter(p);
                    codeFormat.append("$L");
                    values.add(p.getName());
                }
            }
        }
        codeFormat.append(")");
        if (closeBracket) {
            codeFormat.append(")");
        }
        method.getCode().addStatement(codeFormat.toString(), values.toArray());
    }

    protected void generateMethodCodeAndReturnType(Method moduleMethod, final MethodOverloaded method,
                                                   TypeParameter moduleType, boolean useInternalModel) {
        StringBuilder codeFormat = new StringBuilder();
        List<Object> values = new LinkedList<>();
        boolean closeBracket = false;
        if (moduleMethod.hasReturn()) {
            method.setReturnType(moduleMethod.getReturnType());
            method.setReturnDescription(moduleMethod.getReturnDescription());
            if (moduleMethod.getReturnType().isModel(correspondingModel)) {
                closeBracket = true;
                codeFormat.append("return $L(");
                values.add(AbstractModelDao.METHOD_SET_AND_GET_MODEL);
            } else {
                codeFormat.append("return ");
            }
        }
        codeFormat.append("(($T)$L()).$L(");
        try {
            moduleType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        values.add(moduleType.hasClass() ? moduleType.getClazz() : moduleType.getTypeName());
        values.add(AbstractModelDao.METHOD_GETTER_MODULE);
        values.add(moduleMethod.getName());
        if (moduleMethod.hasParameters()) {
            boolean start = true;
            for (Parameter p : moduleMethod.getParameters()) {
                if (start) {
                    start = false;
                } else {
                    codeFormat.append(", ");
                }
                if (useInternalModel && p.getType().isModel(correspondingModel)) {
                    codeFormat.append("$L()");
                    values.add(AbstractModelDao.METHOD_GET_MODEL);
                } else {
                    method.addParameter(p);
                    codeFormat.append("$L");
                    values.add(p.getName());
                }
            }
        }
        codeFormat.append(")");
        if (closeBracket) {
            codeFormat.append(")");
        }
        method.getCode().addStatement(codeFormat.toString(), values.toArray());
    }

    @Override
    protected MethodGeneric createMissingInterfaceMethod(java.lang.reflect.Method m, String suffix) {
        final MethodGeneric missingMethod = super.createMissingInterfaceMethod(m, suffix);
        missingMethod.getParameters().stream().filter(p -> p.getType().isModel())
                     .forEach(p -> p.setType(correspondingModel.toType()));
        if (missingMethod.hasReturn() && missingMethod.getReturnType().isModel()) {
            missingMethod.setReturnType(correspondingModel.toType());
        }
        return missingMethod;

    }

    @Override
    protected boolean isSerialisable() {
        return false;
    }

    @Override
    protected void generateHashCodeAndEquals(Model theParent) {
        // Do not generate anything
    }

    @Override
    protected void generateIsValid(Model theParent) {
        // Do not generate anything
    }

    @Override
    protected MethodClone instantiateCloneMethod(Model theParent) {
        return new MethodCloneDao(this, theParent);
    }

    @Override
    protected List<java.lang.reflect.Method> fetchSuperInterfaceMethods() {
        final List<Class<?>> interfaces = new ArrayList<>(superinterfaces.values());
        if (interfaces.contains(CrudDao.class)) {
            interfaces.addAll(Arrays.asList(CrudDao.class.getInterfaces()));
        }
        return interfaces.stream().map(i -> i.getDeclaredMethods()).flatMap(x -> Arrays.stream(x))
                         .collect(Collectors.toList());
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        generateConstructors(theParent);
        generateClone(theParent);
    }

    @Override
    protected void generateConstructors(Model theParent) {
        if (hasSuperClass() && (superClassType.hasClass() || superClassType instanceof TypeCompose)) {
            final Class<?> parentClass = superClassType.hasClass() ? superClassType.getClazz()
                                                                   : ((TypeCompose) superClassType).getRawClass();

            Arrays.asList(parentClass.getConstructors()).stream()
                  .forEach(c -> addConstructor(new MethodConstructorFromParent(c, this)));
        }
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        generateModuleIntantiationMethods();
        generateOtherIntantiationMethods();
        generateAllDaoMethods();
    }

    protected void generateAllDaoMethods() {
        retrieveMethodRecords().forEach(r -> {
            if (r.hasCorrespondingInterface()) {
                generateCrudMethods(r.getAction(), r.getDaoMethodName(), r.getCorrespondingInterface(),
                                    r.isNeedsCustomCode(), true);
            } else {
                generateOtherMethod(r.getAction(), r.getMethodName(), r.getDaoMethodName(), r.getDescription(),
                                    r.getLongDescription(), r.isNeedsCustomCode(), true);
            }
        });

    }

    protected Set<MethodRecord> retrieveMethodRecords() {
        return methodRegistry.getRecords();
    }

    private void generateModuleIntantiationMethods() {
        final TypeParameter moduleType = correspondingModule.toType();
        try {
            moduleType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        final AtomicInteger counter = new AtomicInteger();
        final List<Method> methods = Arrays.asList(AbstractCloudDao.class.getDeclaredMethods()).stream()
                                           .filter(m -> AbstractCloudDao.METHOD_INSTANTIATE_MODULE.equals(m.getName()))
                                           .sorted(Comparator.comparing(java.lang.reflect.Method::toGenericString))
                                           .map(m -> {
                                               Method method = new MethodOverloaded(m, "Instantiates modules", null,
                                                                                    true, true,
                                                                                    String.valueOf(counter.incrementAndGet()));
                                               method.setAbstract(false);
                                               method.setInternal(true);
                                               method.setReturnDescription("instantiated module");

                                               return method;
                                           }).collect(Collectors.toList());
        for (Method m : methods) {
            m.initialiseCodeBuilder();
            m.getCode().addStatement("return new $T($L)",
                                     moduleType.hasClass() ? moduleType.getClass() : moduleType.getTypeName(),
                                     m.getParameters().stream().findFirst().get().getName());
            addMethod(m);
        }

    }

    protected void generateOtherIntantiationMethods() {
        TypeParameter modelType = correspondingModel.toType();
        try {
            modelType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        final List<Method> methods = getModelInstantiationMethods().stream().map(m -> {
            MethodOverloaded method = new MethodOverloaded(m, "Instantiates model", null, true, true, null);
            method.setAbstract(false);
            method.setInternal(true);
            return method;
        }).collect(Collectors.toList());
        for (Method m : methods) {
            if (m.hasReturn() && m.getReturnType().isModel()) {
                m.setReturnType(modelType);
                m.setReturnDescription("instantiated model");
            }
            m.initialiseCodeBuilder();
            m.getCode().addStatement("return new $T()",
                                     modelType.hasClass() ? modelType.getClass() : modelType.getTypeName());
            addMethod(m);
        }

    }

    private List<java.lang.reflect.Method> getModelInstantiationMethods() {
        return Arrays.asList(AbstractModelDao.class.getDeclaredMethods()).stream()
                     .filter(m -> AbstractModelDao.METHOD_INSTANTIATE_MODEL.equals(m.getName()))
                     .sorted(Comparator.comparing(java.lang.reflect.Method::toGenericString))
                     .collect(java.util.stream.Collectors.toList());
    }

    @Override
    protected Model generateEmptyChildModel() {
        final ModelDao model = instantiateDaoModel();
        model.setContainsCustomCode(true);
        return model;
    }

    @Override
    protected Model generateEmptyAbstractModel() {
        final ModelDao model = instantiateDaoModel();
        model.setAbstract(true);
        superinterfaces.values().forEach(i -> model.addSuperInterface(i));
        return model;
    }

    protected ModelDao instantiateDaoModel() {
        return new ModelDao(correspondingModel, correspondingModule, needsCustomCode);
    }

    private static class MethodRegistry {
        private final Set<MethodRecord> records;

        public MethodRegistry() {
            super();
            records = new LinkedHashSet<>();
        }

        public Set<MethodRecord> getRecords() {
            return records;
        }

        public void clear() {
            records.clear();
        }

        public void addRecord(MethodRecord record) {
            if (record != null) {
                records.add(record);
            }
        }

    }

    protected static class MethodRecord {
        private final MethodAction action;
        private final String methodName;
        private final String description;
        private final String longDescription;
        private final boolean needsCustomCode;
        private final Class<?> correspondingInterface;
        private final String daoMethodName;

        public MethodRecord(MethodAction action, String methodName, String description, String longDescription,
                            boolean needsCustomCode, Class<?> correspondingInterface, String daoMethodName) {
            super();
            this.action = action;
            this.methodName = methodName;
            this.description = description;
            this.longDescription = longDescription;
            this.needsCustomCode = needsCustomCode;
            this.correspondingInterface = correspondingInterface;
            this.daoMethodName = daoMethodName;
        }

        @SuppressWarnings("boxing")
        @Override
        public int hashCode() {
            return Objects.hash(action, correspondingInterface, daoMethodName, description, longDescription, methodName,
                                needsCustomCode);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof MethodRecord)) {
                return false;
            }
            final MethodRecord other = (MethodRecord) obj;
            return action == other.action && Objects.equals(correspondingInterface, other.correspondingInterface)
                   && Objects.equals(daoMethodName, other.daoMethodName)
                   && Objects.equals(description, other.description)
                   && Objects.equals(longDescription, other.longDescription)
                   && Objects.equals(methodName, other.methodName) && needsCustomCode == other.needsCustomCode;
        }

        public MethodAction getAction() {
            return action;
        }

        public String getMethodName() {
            return methodName;
        }

        public String getDescription() {
            return description;
        }

        public String getLongDescription() {
            return longDescription;
        }

        public boolean isNeedsCustomCode() {
            return needsCustomCode;
        }

        public Class<?> getCorrespondingInterface() {
            return correspondingInterface;
        }

        public boolean hasCorrespondingInterface() {
            return correspondingInterface != null;
        }

        public String getDaoMethodName() {
            return daoMethodName;
        }

    }

}
