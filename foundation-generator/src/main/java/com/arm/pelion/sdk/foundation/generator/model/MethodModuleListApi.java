package com.arm.pelion.sdk.foundation.generator.model;

import java.util.List;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.ApiUtils;
import com.arm.pelion.sdk.foundation.generator.util.TranslationException;

public class MethodModuleListApi extends MethodModuleCloudApi {
    private static final String PARAMETER_NAME_OPTIONS = "options";
    private final boolean isPaginatedList;
    private final ModelListOptionFetcher fetcher;

    public MethodModuleListApi(Model currentModel, String name, String description, String longDescription,
                               boolean needsCustomCode, boolean isPaginatedList,
                               ModelListOptionFetcher listOptionsFetcher, ModelAdapterFetcher adapterFetcher,
                               String endpointVariableName, List<Parameter> methodParameters, Renames parameterRenames,
                               Method lowLevelMethod) {
        super(currentModel, adapterFetcher, name, description, longDescription, needsCustomCode, endpointVariableName,
              methodParameters, parameterRenames, lowLevelMethod);
        this.isPaginatedList = isPaginatedList;
        this.fetcher = listOptionsFetcher;
    }

    @Override
    protected void determineParameters(List<Parameter> methodParameters) {
        final ModelListOption correspondingListOptions = determineListOptionModel();
        addParameter(new Parameter(PARAMETER_NAME_OPTIONS, "list options.", null, correspondingListOptions.toType(),
                                   null).setAsNullable(true));
        List<Parameter> otherParameters = methodParameters;
        if (otherParameters != null && !otherParameters.isEmpty()) {
            otherParameters = otherParameters.stream()
                                             .filter(p -> !correspondingListOptions.hasFieldInHierachy(p.getIdentifier()))
                                             .collect(Collectors.toList());
        }
        super.determineParameters(otherParameters);

    }

    @Override
    protected void determineReturnType(Model currentModel) {
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
    protected void generateVariableInitialisation() throws TranslationException {
        super.generateVariableInitialisation();
        if (!isPaginatedList) {
            return;
        }
        code.addStatement("final $T $L = ($L == null)? new $T() : $L", determineListOptionType(),
                          generateFinalVariable(PARAMETER_NAME_OPTIONS), PARAMETER_NAME_OPTIONS,
                          determineListOptionType(), PARAMETER_NAME_OPTIONS);
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

    private Object generateFinalVariable(String variableName) {
        return ApiUtils.convertSnakeToCamel("final_" + ApiUtils.convertCamelToSnake(variableName), false);
    }

    @Override
    protected void generateLowLevelCallCode(Method callMethod) {
        // TODO Auto-generated method stub
        super.generateLowLevelCallCode(callMethod);
    }

    @Override
    public String toString() {
        return "MethodModuleListApi [isPaginatedList=" + isPaginatedList + ", " + super.toString() + "]";
    }

}
