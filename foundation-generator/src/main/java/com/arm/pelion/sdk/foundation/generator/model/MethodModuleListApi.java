package com.arm.pelion.sdk.foundation.generator.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModuleListApi extends MethodModuleCloudApi {
    private static final String PARAMETER_NAME_OPTIONS = "options";
    private final boolean isPaginatedList;
    private final ModelListOptionFetcher fetcher;

    public MethodModuleListApi(Model currentModel, String name, String description, String longDescription,
                               boolean needsCustomCode, boolean isPaginatedList,
                               ModelListOptionFetcher listOptionsFetcher, ModelAdapterFetcher adapterFetcher,
                               ModelEndpoints endpoints, String endpointVariableName, Class<?> lowLevelModule,
                               List<Parameter> methodParameters, List<Parameter> allParameters,
                               Renames parameterRenames, Method lowLevelMethod, boolean enforceModelValidity) {
        super(currentModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpoints,
              endpointVariableName, lowLevelModule, methodParameters, allParameters, parameterRenames, lowLevelMethod,
              enforceModelValidity);
        this.isPaginatedList = isPaginatedList;
        this.fetcher = listOptionsFetcher;
    }

    @Override
    protected List<Parameter> extendParameterList(List<Parameter> methodParameters, List<Parameter> allParameters,
                                                  Method lowLevelMethod, Renames parameterRenames, Model currentModel) {
        List<Parameter> otherParameters = super.extendParameterList(methodParameters, allParameters, lowLevelMethod,
                                                                    parameterRenames, currentModel);
        if (isPaginatedList) {
            final ModelListOption correspondingListOptions = determineListOptionModel();
            if (otherParameters == null) {
                otherParameters = new LinkedList<>();
            }
            otherParameters.add(new Parameter(PARAMETER_NAME_OPTIONS, "list options.", null,
                                              correspondingListOptions.toType(), null).setAsNullable(true));
            otherParameters = otherParameters.stream()
                                             .filter(p -> !correspondingListOptions.hasFieldInHierachy(p.getIdentifier()))
                                             .collect(Collectors.toList());
        }
        return otherParameters;
    }

    @Override
    protected boolean shouldCheckModelValidity(Parameter p) {
        return super.shouldCheckModelValidity(p) && !PARAMETER_NAME_OPTIONS.equals(p.getIdentifier());
    }

    @Override
    protected void determineReturnType(Model currentModel, Method lowLevelMethod) {
        TypeListResponse returnType = new TypeListResponse();
        returnType.setContentType(currentModel.toType());
        setReturnType(returnType);
        setReturnDescription("the list of " + ApiUtils.convertCamelToSnake(currentModel.getName()).replace("_", " ")
                             + "s corresponding to filter options (One page).");
    }

    @Override
    protected String getMappingMethod() {
        return isPaginatedList ? ModelAdapter.FUNCTION_NAME_GET_LIST_MAPPER
                               : ModelAdapter.FUNCTION_NAME_GET_SIMPLE_LIST_MAPPER;
    }

    @Override
    protected void generateVariableInitialisation(List<Parameter> methodParameters) throws TranslationException {
        if (methodParameters == null || methodParameters.isEmpty()) {
            return;
        }
        for (Parameter p : methodParameters) {
            if (PARAMETER_NAME_OPTIONS.equals(p.getIdentifier())) {
                code.addStatement("final $T $L = ($L == null)? new $T() : $L", determineListOptionType(),
                                  generateFinalVariable(p.getName()), p.getName(), determineListOptionType(),
                                  p.getName());
            } else {
                generateParameterInitialisation(p);
            }
        }
    }

    @Override
    protected void translateParameter(String parameterName, TypeParameter type, StringBuilder builder,
                                      List<Object> callElements, boolean isExternalParameter) {
        if (isPaginatedList) {
            // FIXME refactor the following when filters are supported.
            final ModelListOption correspondingListOptions = determineListOptionModel();
            if (correspondingListOptions.hasFieldInHierachy(parameterName)) {
                switch (parameterName) {
                    case ListOptions.FIELD_NAME_INCLUDE:
                        builder.append("$L.$L()");
                        callElements.add(generateFinalVariable(PARAMETER_NAME_OPTIONS));
                        callElements.add(ListOptions.METHOD_INCLUDE_TO_STRING);
                        break;
                    case ListOptions.FIELD_NAME_FILTER:
                        // FIXME encode filters when filters are supported.
                        builder.append("$L");
                        callElements.add("null");
                        break;
                    default:
                        builder.append("$L.$L()");
                        callElements.add(generateFinalVariable(PARAMETER_NAME_OPTIONS));
                        callElements.add(MethodGetter.getCorrespondingGetterMethodName(parameterName,
                                                                                       type.isBoolean()));
                }
            } else {
                super.translateParameter(parameterName, type, builder, callElements, isExternalParameter);
            }

        } else {
            super.translateParameter(parameterName, type, builder, callElements, isExternalParameter);
        }
    }

    public Object determineListOptionType() throws TranslationException {
        final ModelListOption correspondingListOptions = determineListOptionModel();
        final TypeParameter type = correspondingListOptions.toType();
        type.translate();
        return type.hasClass() ? type.getClazz() : type.getTypeName();
    }

    public ModelListOption determineListOptionModel() {
        ModelListOption correspondingListOptions = fetcher == null ? null
                                                                   : fetcher.fetchFromAssociatedModel(currentModel.toType());

        if (correspondingListOptions == null) {
            correspondingListOptions = new ModelListOption();
        }
        return correspondingListOptions;
    }

    @Override
    public String toString() {
        return "MethodModuleListApi [isPaginatedList=" + isPaginatedList + ", " + super.toString() + "]";
    }

}
