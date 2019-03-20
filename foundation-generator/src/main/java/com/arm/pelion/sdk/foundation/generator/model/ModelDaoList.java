package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.dao.AbstractModelDao;
import com.arm.mbed.cloud.sdk.common.dao.AbstractModelListDao;
import com.arm.mbed.cloud.sdk.common.dao.DaoProvider;
import com.arm.mbed.cloud.sdk.common.dao.ModelListDao;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelDaoList extends ModelDao {

    private final ModelListOption listOptions;
    private final ModelDao correspondingDao;

    public ModelDaoList(Model currentModel, ModelModule module, ModelDao correspondingDao, ModelListOption listOptions,
                        boolean needsCustom) {
        super(currentModel, module, needsCustom);
        this.listOptions = listOptions;
        this.correspondingDao = correspondingDao;
        setName(DaoProvider.getCorrespondingListDaoName(currentModel.getName()));
        setDescription(generateDescription(currentModel));
        addSuperInterface(ModelListDao.class);
        setSuperClass(currentModel);
    }

    @Override
    protected void setSuperClass(Model currentModel) {
        setSuperClassType(new TypeModelDaoList(listOptions == null ? null : listOptions.toType(),
                                               currentModel.toType()).concreteImplementation(true));
    }

    private static String generateDescription(Model currentModel) {
        return "Data Access Object (DAO) for listing "
               + Utils.generateDocumentationString(currentModel.getName(), true);
    }

    @SuppressWarnings("incomplete-switch")
    public void addMethods(MethodAction action, String methodName, boolean needsCustomCode) {
        Class<?> correspondingInterface = null;
        String daoMethodName = null;
        switch (action) {
            case LIST:
                correspondingInterface = AbstractModelListDao.class;
                daoMethodName = AbstractModelListDao.METHOD_REQUEST_ONE_PAGE;
                break;
        }
        if (correspondingInterface == null) {
            Method method = new MethodGeneric(methodName, null, null, null);
            addMethod(method);
        } else {
            generateCrudMethods(action, daoMethodName, correspondingInterface, needsCustomCode, false);
        }
    }

    @Override
    protected void generateMethodCodeAndReturnType(Method moduleMethod, MethodOverloaded method,
                                                   TypeParameter moduleType) {
        StringBuilder codeFormat = new StringBuilder();
        List<Object> values = new LinkedList<>();

        if (moduleMethod.getReturnType().isListResponse()) {
            method.setReturnType(TypeFactory.getCorrespondingType(ListResponse.class, correspondingModel.toType()));

        } else {
            method.setReturnType(moduleMethod.getReturnType());
        }
        method.setReturnDescription("one page of "
                                    + Utils.generateDocumentationString(correspondingModel.getName(), true));
        method.setAsOverride(true);
        codeFormat.append("return ");
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
                if (p.getType().isListOptions()) {
                    method.addParameter(new Parameter(p.getName(), "list options", null, listOptions.toType(), null,
                                                      null, null));
                    codeFormat.append("$L");
                    values.add(p.getName());
                } else {
                    codeFormat.append("$L");
                    values.add("null");
                    method.needsCustomCode(true);
                }
            }
        }
        codeFormat.append(")");
        method.getCode().addStatement(codeFormat.toString(), values.toArray());
    }

    @Override
    protected void generateOtherIntantiationMethods() {
        final TypeParameter daoModelType = correspondingDao.toType();
        final TypeParameter daoModelClassType = new TypeClass(daoModelType);
        final TypeParameter listOptionsType = listOptions.toType();
        try {
            daoModelClassType.translate();
            listOptionsType.translate();
            daoModelType.translate();
        } catch (TranslationException exception) {
            // Nothing to do
            exception.printStackTrace();
        }
        addInstantiationMethods(AbstractModelListDao.METHOD_INSTANTIATE_LIST_OPTIONS, listOptionsType,
                                "return new $T()",
                                Arrays.asList(listOptionsType.hasClass() ? listOptionsType.getClazz()
                                                                         : listOptionsType.getTypeName()),
                                Utils.generateDocumentationString(listOptions.getName()), false);
        addInstantiationMethods(AbstractModelListDao.METHOD_GET_CORRESPONDING_MODEL_DAO_DEFINITION, daoModelClassType,
                                "return $T.class",
                                Arrays.asList(daoModelType.hasClass() ? daoModelType.getClazz()
                                                                      : daoModelType.getTypeName()),
                                Utils.generateDocumentationString(correspondingDao.getName()) + " class", true);
        addInstantiationMethods(AbstractModelListDao.METHOD_GET_CORRESPONDING_MODEL_DAO_INSTANCE, daoModelType,
                                "return new $T().$L($L())",
                                Arrays.asList(daoModelType.hasClass() ? daoModelType.getClazz()
                                                                      : daoModelType.getTypeName(),
                                              AbstractModelListDao.METHOD_CONFIGURE_AND_GET,
                                              AbstractModelListDao.METHOD_GETTER_MODULE),
                                Utils.generateDocumentationString(correspondingDao.getName()), true);
    }

    private void addInstantiationMethods(String methodName, TypeParameter returnType, String format,
                                         List<Object> values, String description, boolean setAsUnchecked) {
        final List<java.lang.reflect.Method> classMethods = getListDaoMethods();
        final List<Method> methods = classMethods.stream().filter(m -> methodName.equals(m.getName())).map(m -> {
            MethodOverloaded method = new MethodOverloaded(m, description, null, true, true, null);
            method.setAbstract(false);
            method.setInternal(true);
            method.setReturnDescription(description);
            method.setUnchecked(setAsUnchecked);
            return method;
        }).collect(Collectors.toList());
        for (Method m : methods) {
            if (m.hasReturn()) {
                m.setReturnType(returnType);
            }
            m.initialiseCodeBuilder();
            m.getCode().addStatement(format, values.toArray());
            addMethod(m);
        }
    }

    private List<java.lang.reflect.Method> getListDaoMethods() {
        final List<java.lang.reflect.Method> classMethods = new LinkedList<>(Arrays.asList(AbstractModelListDao.class.getDeclaredMethods()));
        classMethods.addAll(Arrays.asList(ModelListDao.class.getDeclaredMethods()));
        return classMethods.stream().sorted(Comparator.comparing(java.lang.reflect.Method::toGenericString))
                           .collect(java.util.stream.Collectors.toList());
    }

    @Override
    protected ModelDao instantiateDaoModel() {
        return new ModelDaoList(correspondingModel, correspondingModule, correspondingDao, listOptions,
                                needsCustomCode);
    }

    @Override
    protected TypeParameter generateSuperInterfaceType(Class<?> superinterface) {
        return new TypeModelDaoList(listOptions == null ? null : listOptions.toType(), correspondingModel.toType());
    }
}
