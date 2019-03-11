package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelListOption extends Model {

    public static final String MODEL_NAME_SUFFIX = ListOptions.class.getSimpleName();
    private static final String FIELD_NAME_FORMER_PAGE_SIZE = "limit";

    private final List<Filter> filters;

    public ModelListOption(Model model, String description, boolean needsCustomCode) {
        super(model.getPackageName(), generateName(model.getName()), model.getGroup(),
              generateDescription(model.getName(), description), null, needsCustomCode, false);
        setSuperClassType(TypeFactory.getCorrespondingType(ListOptions.class));
        filters = new LinkedList<>();
    }

    public ModelListOption() {
        this(new Model(ListOptions.class), "Default list options", false);
    }

    private static String generateDescription(String name, String description) {
        return description == null ? "Options to use when listing " + Utils.generateDocumentationString(name, true)
                                   : description;
    }

    public static String generateName(String name) {
        return Utils.combineNames(true, name, name == null || !name.equals(MODEL_NAME_SUFFIX) ? MODEL_NAME_SUFFIX : "");
    }

    @Override
    protected boolean hasSuperInterface() {
        return false;
    }

    @Override
    protected boolean isSerialisable() {
        return false;
    }

    public void addFilter(Filter filter) {
        if (filter != null) {
            filters.add(filter);
        }
    }

    public List<Filter> getFilters() {
        return filters;
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        filters.forEach(f -> addFilterMethods(f));

    }

    private void addFilterMethods(Filter filter) {
        if (filter == null) {
            return;
        }
        addConstant(filter.getTag());
        addMethod(new MethodFilterGet(filter, containsCustomCode));
        if (filter.canHaveMultipleInputTypes()) {
            addMultipleMethodFilters(filter, containsCustomCode);
        } else {
            final MethodOverloaded setMethod = new MethodFilterSet(filter, containsCustomCode);
            addMethod(setMethod);
            final MethodOverloaded fluentMethod = new MethodFilterSetFluent(filter, this, setMethod,
                                                                            containsCustomCode);
            addMethod(fluentMethod);
        }

    }

    private void addMultipleMethodFilters(Filter filter, boolean containsCustomCode) {
        Arrays.asList(TypeFactory.getCorrespondingType(String.class), new TypeList(filter.getFieldType()),
                      new TypeArray(filter.getFieldType()))
              .forEach(t -> {
                  final MethodOverloaded setMethod = new MethodFilterSet(filter, t, containsCustomCode);
                  addMethod(setMethod);
                  addMethod(new MethodFilterSetFluent(filter, t, this, setMethod, containsCustomCode));
              });
    }

    // FIXME remove when limit is renamed pageSize in intermediate config file.
    @Override
    public boolean hasFieldInSuperclass(String identifier) {
        if (FIELD_NAME_FORMER_PAGE_SIZE.equals(identifier)) {
            return true;
        }
        return super.hasFieldInSuperclass(identifier);
    }

    @Override
    public boolean hasFieldInHierachy(String identifier) {
        if (super.hasFieldInHierachy(identifier)) {
            return true;
        }
        return isFilterParameter(identifier);
    }

    public boolean isFilterParameter(String identifier) {
        if (identifier == null) {
            return false;
        }
        return getFilters().stream().anyMatch(f -> f.correspondsToParameter(identifier));
    }

    public Filter getCorrespondingFilter(String identifier) {
        if (identifier == null) {
            return null;
        }
        return getFilters().stream().filter(f -> f.correspondsToParameter(identifier)).findFirst().orElseGet(null);
    }

    @Override
    protected void generateMethodsDependingOnParents(Model theParent) {
        super.generateMethodsDependingOnParents(theParent);
        generateSetDefault(theParent);
        generateSetOptions(theParent);
        overrideMethodIfExist((new MethodListOptionsConstructorFromObject(this, theParent)));
        overrideMethodIfExist((new MethodListOptionsConstructorEmpty(this, theParent)));
    }

    private void generateSetOptions(Model theParent) {
        if (hasFields()) {
            overrideMethodIfExist(new MethodListOptionsSetOptions(this, theParent));
        }

    }

    private void generateSetDefault(Model theParent) {
        if (hasFields()) {
            overrideMethodIfExist(new MethodListOptionsSetDefault(this, theParent));
        }
    }

    @Override
    protected void generateToString(Model theParent) {
        overrideMethodIfExist(new MethodListOptionsToString(this, theParent));
    }

    @Override
    protected MethodClone instantiateCloneMethod(Model theParent) {
        return new MethodListOptionsClone(this, theParent);
    }

    @Override
    protected void generateIsValid(Model theParent) {
        // Nothing to do
    }
}
