package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.pelion.sdk.foundation.generator.TranslationException;
import com.squareup.javapoet.CodeBlock;

public class MethodMapper extends Method {

    private static final String UNKNOWN = "Unknown";
    protected static final String PARAMETER_NAME = "toBeMapped";

    protected boolean isFromModel;
    protected final Model fromTo;
    protected final Model currentModel;
    protected final Map<String, String> toFromRenames;
    private final ModelAdapterFetcher fetcher;

    public MethodMapper(String name, boolean isAccessible, Model currentModel, Model fromTo, boolean isFromModel,
                        Map<String, String> toFromRenames, ModelAdapterFetcher fetcher) {
        super(false, name, generateDescription(currentModel, fromTo, isFromModel), null, true, isAccessible, false,
              false, false, true, false, false);
        setReturn(currentModel, fromTo, isFromModel);
        defineParameter(currentModel, fromTo, isFromModel);
        initialiseCodeBuilder();
        this.isFromModel = isFromModel;
        this.fromTo = fromTo;
        this.currentModel = currentModel;
        this.toFromRenames = toFromRenames;
        this.fetcher = fetcher;
    }

    protected void setReturn(Model currentModel, Model fromTo, boolean isFromModel) {
        setReturnType(isFromModel ? fromTo == null ? null : fromTo.toType()
                                  : currentModel == null ? null : currentModel.toType());
        setReturnDescription("mapped " + (isFromModel ? generateModelDescription(fromTo)
                                                      : generateModelDescription(currentModel)));
    }

    protected void defineParameter(Model currentModel, Model fromTo, boolean isFromModel) {
        if (currentModel == null || fromTo == null) {
            return;
        }
        addParameter(isFromModel ? currentModel.toParameter(PARAMETER_NAME) : fromTo.toParameter(PARAMETER_NAME));
    }

    private static String generateDescription(Model currentModel, Model fromTo, boolean isFromModel) {
        final String modelname = generateModelDescription(currentModel);
        final String otherName = generateModelDescription(fromTo);
        final String from = isFromModel ? modelname : otherName;
        final String to = isFromModel ? otherName : modelname;
        return "Maps a " + from + " into " + to + ".";
    }

    protected static String generateModelDescription(Model currentModel) {
        return currentModel == null ? UNKNOWN
                                    : ApiUtils.convertCamelToSnake(currentModel.getName()).replaceAll("_", " ");
    }

    protected void translateCode() throws TranslationException {
        code.beginControlFlow("$L == null", PARAMETER_NAME);
        code.addStatement("return null");
        code.endControlFlow();
        final String variableName = ApiUtils.convertSnakeToCamel(ApiUtils.convertCamelToSnake(isFromModel ? fromTo.getName()
                                                                                                          : currentModel.getName()),
                                                                 false);
        generateCode(code, isFromModel ? currentModel : fromTo, isFromModel ? fromTo : currentModel, variableName,
                     PARAMETER_NAME, toFromRenames, name, fetcher);
    }

    private static void generateCode(CodeBlock.Builder code, Model from, Model to, String variableName,
                                     String fromVariableName, Map<String, String> toFromRenames, String mapFunction,
                                     ModelAdapterFetcher fetcher) throws TranslationException {
        StringBuilder statementString = new StringBuilder("final $T $L = new $T(");
        final ParameterType fromType = from.toType();
        final ParameterType toType = to.toType();
        fromType.translate();
        toType.translate();
        final List<Object> values = Arrays.asList(toType.hasClass() ? toType.getClazz() : toType.getTypeName(),
                                                  variableName,
                                                  toType.hasClass() ? toType.getClazz() : toType.getTypeName());
        List<Field> settableFields = null;
        boolean toIsLowLevelModel = toType.isLowLevelModel();
        if (!toIsLowLevelModel && to.hasConstructor(MethodConstructorReadOnly.IDENTIFIER)) {
            final MethodConstructorReadOnly constructor = (MethodConstructorReadOnly) to.fetchMethod((MethodConstructorReadOnly.IDENTIFIER));
            if (constructor != null) {
                settableFields = constructor.getSettableFieldList();
                final List<Field> constructorFields = constructor.getFieldList();
                boolean start = true;
                for (Field f : constructorFields) {
                    if (start) {
                        start = false;
                    } else {
                        statementString.append(",");
                    }
                    final ParameterType fType = f.getType();
                    final String toFieldName = f.getName();
                    final String fromFieldName = toFromRenames.containsKey(toFieldName) ? toFromRenames.get(toFieldName)
                                                                                        : toFieldName;
                    final Field fromField = to.fetchField(fromFieldName);
                    final ParameterType fromFieldType = fromField.getType();
                    fType.translate();
                    fromFieldType.translate();
                    if (needsTranslation(fromFieldType, fType)) {
                        if (!doesTypeNeedTranslation(fType)) {
                            statementString.append("$L.$L()");
                            values.addAll(Arrays.asList(fromVariableName,
                                                        MethodGetter.getCorrespondingGetterMethodName(fromFieldName,
                                                                                                      fType.isBoolean())));
                        } else if (f.hasDefaultValue()) {
                            statementString.append("$T.$L($L.$L(),$L)");
                            values.addAll(Arrays.asList(fromVariableName, TranslationUtils.class,
                                                        getTranslationMethod(fType, fromFieldType),
                                                        MethodGetter.getCorrespondingGetterMethodName(fromFieldName,
                                                                                                      fType.isBoolean()),
                                                        f.getDefaultValue()));
                        } else {
                            statementString.append("$T.$L($L.$L())");
                            values.addAll(Arrays.asList(fromVariableName, TranslationUtils.class,
                                                        getTranslationMethod(fType, fromFieldType),
                                                        MethodGetter.getCorrespondingGetterMethodName(fromFieldName,
                                                                                                      fType.isBoolean())));
                        }
                    } else if (fType.isEnum()) {
                        statementString.append("$L($L.$L())");
                        values.addAll(Arrays.asList(MethodMapperEnum.generateName(toIsLowLevelModel ? fromField : f,
                                                                                  toIsLowLevelModel ? f : fromField,
                                                                                  toIsLowLevelModel),
                                                    fromVariableName,
                                                    MethodGetter.getCorrespondingGetterMethodName(fromFieldName,
                                                                                                  fType.isBoolean())));

                    } else if (fType.isLowLevelModel() || fType.isModel()) {
                        final ParameterType modelAdapterType = fetchAdapterType(fetcher, fType, fromFieldType).toType();
                        modelAdapterType.translate();
                        statementString.append("$T.$L($L.$L())");
                        values.addAll(Arrays.asList(modelAdapterType.hasClass() ? modelAdapterType.getClazz()
                                                                                : modelAdapterType.getTypeName(),
                                                    mapFunction, fromVariableName,
                                                    MethodGetter.getCorrespondingGetterMethodName(fromFieldName,
                                                                                                  fType.isBoolean())));
                    } else {
                        statementString.append("$L.$L()");
                        values.addAll(Arrays.asList(fromVariableName,
                                                    MethodGetter.getCorrespondingGetterMethodName(fromFieldName,
                                                                                                  fType.isBoolean())));
                    }

                }
            }
        }
        statementString.append(")");
        code.addStatement(statementString.toString(), values.toArray());
        if (settableFields == null) {
            if (!toIsLowLevelModel) {
                final MethodConstructorAllFields constructor = (MethodConstructorAllFields) to.fetchMethod((MethodConstructorAllFields.IDENTIFIER));
                settableFields = constructor == null ? new ArrayList<>() : constructor.getAllFields();
            } else {
                settableFields = to.getFieldList();
            }
        }
        // Not using stream so that exception is thrown
        for (Field f : settableFields) {
            final ParameterType fType = f.getType();
            final String toFieldName = f.getName();
            final String fromFieldName = toFromRenames.containsKey(toFieldName) ? toFromRenames.get(toFieldName)
                                                                                : toFieldName;
            final Field fromField = to.fetchField(fromFieldName);
            final ParameterType fromFieldType = fromField.getType();
            fType.translate();
            fromFieldType.translate();
            if (needsTranslation(fromFieldType, fType)) {
                if (!doesTypeNeedTranslation(fType)) {
                    code.addStatement("$L.$L($L.$L())", variableName,
                                      MethodSetter.getCorrespondingSetterMethodName(toFieldName), fromVariableName,
                                      MethodGetter.getCorrespondingGetterMethodName(fromFieldName, fType.isBoolean()));
                } else if (f.hasDefaultValue()) {
                    code.addStatement("$L.$L($T.$L($L.$L(),$L))", variableName,
                                      MethodSetter.getCorrespondingSetterMethodName(toFieldName), fromVariableName,
                                      TranslationUtils.class, getTranslationMethod(fType, fromFieldType),
                                      MethodGetter.getCorrespondingGetterMethodName(fromFieldName, fType.isBoolean()),
                                      f.getDefaultValue());
                } else {
                    code.addStatement("$L.$L($T.$L($L.$L()))", variableName,
                                      MethodSetter.getCorrespondingSetterMethodName(toFieldName), fromVariableName,
                                      TranslationUtils.class, getTranslationMethod(fType, fromFieldType),
                                      MethodGetter.getCorrespondingGetterMethodName(fromFieldName, fType.isBoolean()));
                }
            } else if (fType.isEnum()) {
                code.addStatement("$L.$L($L($L.$L()))", variableName,
                                  MethodSetter.getCorrespondingSetterMethodName(toFieldName),
                                  MethodMapperEnum.generateName(toIsLowLevelModel ? fromField : f,
                                                                toIsLowLevelModel ? f : fromField, toIsLowLevelModel),
                                  fromVariableName,
                                  MethodGetter.getCorrespondingGetterMethodName(fromFieldName, fType.isBoolean()));
            } else if (fType.isLowLevelModel() || fType.isModel()) {
                final ParameterType modelAdapterType = fetchAdapterType(fetcher, fType, fromFieldType).toType();
                modelAdapterType.translate();
                code.addStatement("$L.$L($T.$L($L.$L()))", variableName,
                                  MethodSetter.getCorrespondingSetterMethodName(toFieldName),
                                  modelAdapterType.hasClass() ? modelAdapterType.getClazz()
                                                              : modelAdapterType.getTypeName(),
                                  mapFunction, fromVariableName,
                                  MethodGetter.getCorrespondingGetterMethodName(fromFieldName, fType.isBoolean()));
            } else {
                code.addStatement("$L.$L($L.$L())", variableName,
                                  MethodSetter.getCorrespondingSetterMethodName(toFieldName), fromVariableName,
                                  MethodGetter.getCorrespondingGetterMethodName(fromFieldName, fType.isBoolean()));
            }

        }
        code.add("return $L", variableName);
    }

    private static ModelAdapter fetchAdapterType(ModelAdapterFetcher fetcher, ParameterType toFieldType,
                                                 ParameterType fromFieldType) {
        return fetcher.fetch(fromFieldType, toFieldType);
    }

    private static String getTranslationMethod(ParameterType fType,
                                               ParameterType fromFieldType) throws TranslationException {
        if (fType.isDate()) {
            if (fromFieldType.isJodaDate() || fromFieldType.isJodaTime() || fromFieldType.isCalendar()
                || fromFieldType.isNumber()) {
                return TranslationUtils.METHOD_CONVERT_OTHER_TO_DATE;
            }
            if (fromFieldType.isString()) {
                return TranslationUtils.METHOD_CONVERT_STRING_TO_DATE;
            }
        }
        if (fType.isJodaDate()) {
            if (fromFieldType.isDate()) {
                return TranslationUtils.METHOD_CONVERT_DATE_TO_LOCALDATE;
            }
        }
        if (fType.isJodaTime()) {
            if (fromFieldType.isDate()) {
                return TranslationUtils.METHOD_CONVERT_DATE_TO_DATETIME;
            }
        }
        if (fType.isUrl()) {
            if (fromFieldType.isString()) {
                return TranslationUtils.METHOD_CONVERT_STRING_TO_URL;
            }
        }
        if (fType.isBoolean()) {
            if (fromFieldType.isBoolean() || fromFieldType.isString()) {
                return TranslationUtils.METHOD_CONVERT_BOOL_TO_BOOL;
            }
        }
        if (fType.isNumber()) {
            if (fromFieldType.isNumber() || fromFieldType.isString()) {
                return fType.isInteger() ? TranslationUtils.METHOD_CONVERT_NUMBER_TO_INT
                                         : TranslationUtils.METHOD_CONVERT_NUMBER_TO_LONG;
                // TODO handle floating point numbers if needed
            }
        }
        if (fType.isString() && !fromFieldType.isString()) {
            return fromFieldType.isDate() ? TranslationUtils.METHOD_CONVERT_DATE_TO_STRING
                                          : TranslationUtils.METHOD_CONVERT_ANY_TO_STRING;
        }

        throw new TranslationException("Could not find an appropriate translation method in "
                                       + TranslationUtils.class.getName() + " for conversion from " + fromFieldType
                                       + " to " + fType);
    }

    private static boolean needsTranslation(ParameterType from, ParameterType to) {
        if (from.hasClazz() && (from.getClazz() == to.getClazz())) {
            return false;
        }
        if (!from.hasClazz() && (from.getTypeName() == to.getTypeName())) {
            return false;
        }
        if (to.isString()) {
            return true;
        }
        return doesTypeNeedTranslation(from) || doesTypeNeedTranslation(to);
    }

    protected static boolean doesTypeNeedTranslation(ParameterType type) {
        return type.isDate() || type.isJodaDate() || type.isJodaTime() || type.isPrimitive() || type.isUrl();
    }

}
