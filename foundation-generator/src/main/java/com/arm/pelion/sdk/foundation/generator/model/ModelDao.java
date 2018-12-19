package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.MbedCloudException;
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
    protected final List<Class<?>> superinterfaces;

    public ModelDao(Model currentModel, ModelModule module, boolean needsCustom) {
        super(currentModel.packageName, DaoProvider.getCorrespondingDaoName(currentModel.name), currentModel.group,
              generateDescription(currentModel), generateLongDescription(currentModel), currentModel.isAbstract,
              needsCustom, currentModel.containsCustomCode, currentModel.isInternal);
        correspondingModel = currentModel;
        correspondingModule = module;
        superinterfaces = new ArrayList<>(4);
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
        for (Class<?> i : superinterfaces) {
            final TypeParameter type = new TypeModelDao(i, correspondingModel.toType());
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

    @Override
    protected boolean hasSuperInterface() {
        return !superinterfaces.isEmpty();
    }

    private void checkSuperInterfaces() {
        if (Arrays.asList(CrudDao.class.getInterfaces()).stream()
                  .allMatch(i -> superinterfaces.stream().anyMatch(subi -> subi != null && subi.equals(i)))) {
            superinterfaces.clear();
            superinterfaces.add(CrudDao.class);
        }
    }

    @SuppressWarnings("incomplete-switch")
    public void addMethods(MethodAction action, String methodName, boolean needsCustomCode) {
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

        }
        if (!superinterfaces.contains(CrudDao.class)) {
            if (correspondingInterface != null) {
                superinterfaces.add(correspondingInterface);
            }
            checkSuperInterfaces();
        }
        if (correspondingInterface == null) {
            generateOtherMethod(action, methodName, needsCustomCode);
        } else {
            generateCrudMethods(action, daoMethodName, correspondingInterface, needsCustomCode);
        }

    }

    private void generateCrudMethods(MethodAction action, String daoMethodName, Class<?> correspondingInterface,
                                     boolean needsCustomCode) {
        if (!correspondingModule.hasMethods(correspondingModel, action)) {
            final AtomicInteger counter = new AtomicInteger();
            Arrays.asList(correspondingInterface.getDeclaredMethods())
                  .forEach(m -> addMethod(new MethodGeneric(m, String.valueOf(counter.incrementAndGet()))));
            return;
        }
        final List<Method> moduleMethods = correspondingModule.getAllMethods(correspondingModel, action);
        for (Method moduleMethod : moduleMethods) {
            final MethodOverloaded method = generateMethod(daoMethodName, needsCustomCode, null, moduleMethod);
            addMethod(method);
        }
        // Arrays.asList(correspondingInterface.getDeclaredMethods()).forEach(m -> {
        // final String suffix = MethodOverloaded.generateOverloadSuffix(m);
        // final String methodId = MethodOverloaded.generateIdentifier(m.getName(), suffix);
        // if(!hasSpecificMethod(methodId)) {
        // final List<Method>methods=fet
        // }
        // });
    }

    private void generateOtherMethod(MethodAction action, String methodName, boolean needsCustomCode) {
        if (!correspondingModule.hasMethod(correspondingModel, action, methodName)) {
            Method method = new MethodGeneric(methodName, null, null, null);
            addMethod(method);
            return;
        }
        final List<Method> moduleMethods = correspondingModule.getAllMethods(correspondingModel, action, methodName);
        for (Method moduleMethod : moduleMethods) {
            final MethodOverloaded method = generateMethod(methodName, needsCustomCode, null, moduleMethod);
            addMethod(method);
        }

    }

    private MethodOverloaded generateMethod(String methodName, boolean needsCustomCode, String suffix,
                                            Method moduleMethod) {
        final MethodOverloaded method = new MethodOverloaded(false, methodName, moduleMethod.getDescription(),
                                                             moduleMethod.getLongDescription(), false, true, false,
                                                             false, false, false, false, false, suffix);
        method.addException(MbedCloudException.class);
        method.setNeedsCustomCode(needsCustomCode);
        method.initialiseCodeBuilder();
        method.getCode().addStatement("$L()", AbstractModelDao.METHOD_CHECK_CONFIGURATION);
        StringBuilder codeFormat = new StringBuilder();
        List<Object> values = new LinkedList<>();
        boolean closeBracket = false;
        if (moduleMethod.hasReturn()) {
            if (moduleMethod.getReturnType().isModel(correspondingModel)) {
                closeBracket = true;
                codeFormat.append("$L(");
                values.add(AbstractModelDao.METHOD_SET_MODEL);

            } else {
                method.setReturnType(moduleMethod.getReturnType());
                method.setReturnDescription(moduleMethod.getReturnDescription());
                codeFormat.append("return ");
            }
        }
        codeFormat.append("$L.$L(");
        values.add(AbstractModelDao.FIELD_NAME_MODULE);
        values.add(moduleMethod.getName());
        if (moduleMethod.hasParameters()) {
            boolean start = true;
            for (Parameter p : moduleMethod.getParameters()) {
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
            codeFormat.append("");
        }
        method.getCode().addStatement(codeFormat.toString(), values.toArray());
        if (suffix == null) {
            method.generateSuffix();
        }
        return method;
    }

    @Override
    protected boolean isSerialisable() {
        return false;
    }

    @Override
    protected void generateHashCodeAndEquals() {
        // Do not generate anything
    }

    @Override
    protected void generateIsValid(Model theParent) {
        // Do not generate anything
    }

    @Override
    protected void generateClone(Model theParent) {
        // Do not generate anything
    }

    @Override
    protected List<java.lang.reflect.Method> fetchSuperInterfaceMethods() {
        final List<Class<?>> interfaces = new ArrayList<>(superinterfaces);
        if (interfaces.contains(CrudDao.class)) {
            interfaces.addAll(Arrays.asList(CrudDao.class.getInterfaces()));
        }
        return interfaces.stream().map(i -> i.getDeclaredMethods()).flatMap(x -> Arrays.stream(x))
                         .collect(Collectors.toList());
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodModelDaoConstructorEmpty(this, theParent));
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        generateModuleIntantiationMethods();
    }

    private void generateModuleIntantiationMethods() {
        TypeParameter moduleType = correspondingModule.toType();
        try {
            moduleType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        final AtomicInteger counter = new AtomicInteger();
        final List<Method> methods = Arrays.asList(AbstractCloudDao.class.getDeclaredMethods()).stream()
                                           .filter(m -> AbstractCloudDao.METHOD_INSTANTIATE_MODULE.equals(m.getName()))
                                           .map(m -> {
                                               Method method = new MethodOverloaded(m, "Instantiates modules", null,
                                                                                    true,
                                                                                    String.valueOf(counter.incrementAndGet()));
                                               method.setAbstract(false);
                                               method.setInternal(true);
                                               // method.setReturnDescription("");
                                               Arrays.asList(m.getParameters())
                                                     .forEach(p -> method.addParameter(new Parameter(p)));
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

    @Override
    protected Model generateEmptyChildModel() {
        final ModelDao model = new ModelDao(correspondingModel, correspondingModule, needsCustomCode);
        model.setContainsCustomCode(true);
        return model;
    }

    @Override
    protected Model generateEmptyAbstractModel() {
        final ModelDao model = new ModelDao(correspondingModel, correspondingModule, needsCustomCode);
        model.setAbstract(true);
        superinterfaces.forEach(i -> model.superinterfaces.add(i));
        return model;
    }

}
