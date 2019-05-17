package com.arm.pelion.sdk.foundation.generator.model;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.pelion.sdk.foundation.generator.util.Logger;
import com.arm.pelion.sdk.foundation.generator.util.Utils;

public class ModelListOption extends Model {

    public static final String MODEL_NAME_SUFFIX = ListOptions.class.getSimpleName();
    private static final String FIELD_NAME_FORMER_PAGE_SIZE = "limit";

    private final List<Filter> filters;
    private final Model correspondingModel;
    private final ArtifactFetcher<Model> modelFetcher;

    public ModelListOption(Model model, ArtifactFetcher<Model> modelFetcher, String description,
                           boolean needsCustomCode) {
        super(model.getPackageName(), generateName(model.getName()), model.getGroup(),
              generateDescription(model.getName(), description), null, needsCustomCode, false);
        setSuperClassType(TypeFactory.getCorrespondingType(ListOptions.class));
        filters = new LinkedList<>();
        correspondingModel = model;
        this.modelFetcher = modelFetcher;
        setIgnoreLiteralDuplicate(true);
    }

    public ModelListOption() {
        this(new Model(ListOptions.class), null, "Default list options", false);
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
        return filters.stream().filter(f -> f.isVerified()).collect(Collectors.toList());
    }

    public boolean hasFilters() {
        return filters.stream().anyMatch(f -> f.isVerified());
    }

    @Override
    protected void generateOtherMethods() {
        super.generateOtherMethods();
        verifyFilters();
        getFilters().forEach(f -> addFilterMethods(f));
        addFilterDocumentation();
    }

    private void verifyFilters() {
        // fetching latest version of the model

        final Model relatedModel = modelFetcher == null ? correspondingModel
                                                        : modelFetcher.has(correspondingModel.toType()) ? modelFetcher.fetch(correspondingModel.toType())
                                                                                                        : correspondingModel;
        filters.stream().filter(f -> !f.isVerified()).collect(Collectors.toList()).forEach(f -> {
            final Field field = relatedModel.fetchField(f.getFieldName());
            if (field == null) {
                // FIXME: throw an exception in the future rather than just logging it
                Logger.getLogger()
                      .logError("Error in filter definition",
                                new IllegalArgumentException("No filter can be applied to \"" + f.getFieldName()
                                                             + "\" as there is no such field in " + relatedModel));
                return;
            }
            f.setVerified(true);
            f.setFieldName(field.getName());
            f.setFieldType(field.getType());
        });
    }

    private void addFilterDocumentation() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Note:");
        builder.append("<ul>").append("<li>").append(System.lineSeparator());
        builder.append("Filters:").append(Utils.generateNewDocumentationLine());
        builder.append("The list can be filtered server-side on some of the fields of ")
               .append(Utils.generateDocumentationString(correspondingModel.getName())).append(".")
               .append(Utils.generateNewDocumentationLine());
        builder.append("The following filters are currently supported:").append(System.lineSeparator());
        builder.append(generateFilterTable(getFilters()));
        builder.append("</li>").append("</ul>").append(System.lineSeparator());
        setLongDescription(builder.toString());
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
            final MethodOverloaded fluentMethod = new MethodFilterSetFluent(filter, this, setMethod, containsCustomCode,
                                                                            false);
            addMethod(fluentMethod);
        }

    }

    private void addMultipleMethodFilters(Filter filter, boolean containsCustomCode) {
        final Map<TypeParameter, Method> table = new LinkedHashMap<>();
        Arrays.asList(TypeFactory.stringType(), new TypeList(filter.getFieldType()),
                      new TypeArray(filter.getFieldType()))
              .forEach(t -> {
                  final MethodOverloaded setMethod = new MethodFilterSet(filter, t, containsCustomCode, true);
                  if (t.isString()) {
                      setMethod.setLongDescription("Note: In this case, the filter is a string corresponding to a list of values separated by a comma");
                  }
                  addMethod(setMethod);
                  table.put(t, setMethod);

              });
        table.entrySet().forEach(e -> addMethod(new MethodFilterSetFluent(filter, e.getKey(), this, e.getValue(),
                                                                          containsCustomCode, true)));
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

    @Override
    protected void generateHashCodeAndEquals(Model theParent) {
        super.generateHashCodeAndEquals(theParent);
        generateHashCode(theParent);
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

    private static String generateFilterTable(List<Filter> filters) {
        final List<FilterOperator> availableFilterOperators = Arrays.asList(FilterOperator.values()).stream()
                                                                    .filter(f -> !f.isUnknownValue())
                                                                    .collect(Collectors.toList());
        final StringBuilder builder = new StringBuilder();
        builder.append("<table style=\"border: 2px solid navy; width:100%; border-collapse:collapse;border-spacing:0\" summary=\"Available filters\">")
               .append(System.lineSeparator());
        builder.append("<caption>Server-side filters</caption>").append(System.lineSeparator());
        builder.append("<tr>").append(System.lineSeparator());
        builder.append("<th style=\"background-color:#cbcefb;border-color:inherit;text-align:center\" rowspan=\"2\">Field</th>")
               .append(System.lineSeparator());
        builder.append("<th style=\"background-color:#cbcefb;border-color:inherit;text-align:center\" rowspan=\"2\">Tag</th>")
               .append(System.lineSeparator());
        builder.append("<th style=\"background-color:#cbcefb;border-color:inherit;text-align:center\" colspan=\"7\">Filters</th>")
               .append(System.lineSeparator());
        builder.append("</tr>").append(System.lineSeparator());
        builder.append("<tr>").append(System.lineSeparator());

        for (FilterOperator op : availableFilterOperators) {
            builder.append("<td style=\"background-color:#dae8fc;text-align:center;width:")
                   .append(70 / availableFilterOperators.size()).append("%;\">").append(op.getString()).append("</td>")
                   .append(System.lineSeparator());
        }
        builder.append("</tr>").append(System.lineSeparator());
        final Map<String, List<Filter>> sortedFilters = new Hashtable<>();
        for (final Filter f : filters) {
            sortedFilters.put(f.getFieldName(),
                              filters.stream().filter(af -> af.getFieldName().equals(f.getFieldName()))
                                     .collect(Collectors.toList()));
        }
        for (final String field : sortedFilters.keySet()) {
            builder.append("<tr>").append(System.lineSeparator());
            builder.append("<td style=\"border-color:inherit;text-align:left;padding-left:15px;padding-right:15px\">")
                   .append(field).append("</td>").append(System.lineSeparator());
            final List<Filter> filterList = sortedFilters.get(field);
            builder.append("<td style=\"border-color:inherit;text-align:left;padding-left:15px;padding-right:15px;font-weight:bold\">")
                   .append(filterList.stream().findFirst().get().getTag().getName()).append("</td>")
                   .append(System.lineSeparator());
            for (FilterOperator op : availableFilterOperators) {
                builder.append("<td style=\"border-color:inherit;text-align:center;font-weight:bold\">")
                       .append(filterList.stream().anyMatch(f -> f.correspondsToOperator(op)) ? "&bull;" : "")
                       .append("</td>").append(System.lineSeparator());
            }
            builder.append("</tr>").append(System.lineSeparator());
        }
        builder.append("</table>").append(System.lineSeparator());
        // builder.append("</p>").append(System.lineSeparator());
        return builder.toString();
    }
}
