package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.dao.AbstractCloudDao;
import com.arm.mbed.cloud.sdk.common.dao.CreateDao;
import com.arm.mbed.cloud.sdk.common.dao.CrudDao;
import com.arm.mbed.cloud.sdk.common.dao.DaoProvider;
import com.arm.mbed.cloud.sdk.common.dao.DeleteDao;
import com.arm.mbed.cloud.sdk.common.dao.ReadDao;
import com.arm.mbed.cloud.sdk.common.dao.UpdateDao;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

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
        // setSuperClassType(((TypeCompose)
        // TypeFactory.getCorrespondingType(com.arm.mbed.cloud.sdk.common.dao.ModelDao.class,
        // currentModel.toType())).concreteImplementation(true));
    }

    private static String generateDescription(Model currentModel) {
        // TODO Auto-generated method stub
        return null;
    }

    private static String generateLongDescription(Model currentModel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void generateSuperInterface() {
        superinterfaces.forEach(i -> specificationBuilder.addSuperinterface(i));
    }

    private void checkSuperInterfaces() {
        if (Arrays.asList(CrudDao.class.getInterfaces()).stream()
                  .allMatch(i -> superinterfaces.stream().anyMatch(subi -> subi != null && subi.equals(i)))) {
            superinterfaces.clear();
            superinterfaces.add(CrudDao.class);
        }
    }

    @SuppressWarnings("incomplete-switch")
    public void addMethods(MethodAction action, String methodName) {
        Class<?> correspondingInterface = null;
        switch (action) {
            case CREATE:
                correspondingInterface = CreateDao.class;
                break;
            case DELETE:
                correspondingInterface = DeleteDao.class;
                break;
            case READ:
                correspondingInterface = ReadDao.class;
                break;
            case UPDATE:
                correspondingInterface = UpdateDao.class;
                break;

        }
        if (!superinterfaces.contains(CrudDao.class)) {
            superinterfaces.add(correspondingInterface);
            checkSuperInterfaces();
        }
        // TODO something
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
    protected void generateMethodsDependingOnParents(Model theParent) {
        addConstructor(new MethodModelDaoConstructorEmpty(this, theParent));
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        generateModuleIntantiationMethods();

        // private final Map<String, CloudCall> cloudCalls;
        // cloudCalls.values().forEach(c -> c.addMethod(this));
    }

    private void generateModuleIntantiationMethods() {
        TypeParameter moduleType = correspondingModule.toType();
        try {
            moduleType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        List<Method> methods = Arrays.asList(AbstractCloudDao.class.getDeclaredMethods()).stream()
                                     .filter(m -> AbstractCloudDao.METHOD_INSTANTIATE_MODULE.equals(m.getName()))
                                     .map(m -> {
                                         Method method = new Method(m, "Instantiates modules", null, true);
                                         method.setAbstract(false);
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
}
