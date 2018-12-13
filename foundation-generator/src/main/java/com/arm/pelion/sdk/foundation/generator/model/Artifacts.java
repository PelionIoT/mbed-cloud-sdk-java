package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.util.MergeableModelDefinitionStore;
import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;
import com.arm.pelion.sdk.foundation.generator.util.SimpleModelDefinitionStore;

public class Artifacts {

    private final ModelDefinitionStore<Model> rawModels;
    private final ArtifactFetcher<Model> modelFetcher;
    private final ModelDefinitionStore<ModelAdapter> adapterModels;
    private final ModelAdapterFetcher adapterFetcher;
    private final List<Model> processedModels;
    private final List<ModelTest> unitTests;
    private final ModelDefinitionStore<ModelEndpoints> rawEndpoints;
    private final ModelEndpointsFetcher endpointsFetcher;
    private final List<ModelEndpoints> processedEndpoints;
    private final ModelDefinitionStore<ModelModule> rawModules;
    private final List<ModelModule> processedModules;

    // private final DAOs
    private final Map<String, PackageInfo> packagesInfo;

    /**
     *
     */
    public Artifacts() {
        super();
        rawModels = new SimpleModelDefinitionStore<>();
        adapterModels = new SimpleModelDefinitionStore<>();
        processedModels = new LinkedList<>();
        unitTests = new LinkedList<>();
        packagesInfo = new HashMap<>();
        rawEndpoints = new MergeableModelDefinitionStore<>();
        processedEndpoints = new LinkedList<>();
        rawModules = new MergeableModelDefinitionStore<>();
        processedModules = new LinkedList<>();
        modelFetcher = new ArtifactFetcher<>(rawModels);
        adapterFetcher = new ModelAdapterFetcher(adapterModels, modelFetcher);
        endpointsFetcher = new ModelEndpointsFetcher(rawEndpoints);
    }

    /**
     * @param rawModels
     */
    public Artifacts(List<Model> rawModels) {
        this();
        if (rawModels != null) {
            rawModels.forEach(m -> addModel(m));
        }
    }

    public void addModel(Model model) {
        this.rawModels.store(model);
    }

    public void addAdapter(ModelAdapter adapter) {
        this.adapterModels.store(adapter);
    }

    public void addEndpoint(ModelEndpoints endpoints) {
        this.rawEndpoints.store(endpoints);
    }

    public void addModule(ModelModule module) {
        this.rawModules.store(module);
    }

    public ArtifactFetcher<Model> getModelFetcher() {
        return modelFetcher;
    }

    public ModelAdapterFetcher getAdapterFetcher() {
        return adapterFetcher;
    }

    public ModelEndpointsFetcher getEndpointsFetcher() {
        return endpointsFetcher;
    }

    public void process() {
        processedModels.clear();
        processedEndpoints.clear();
        processedModules.clear();
        unitTests.clear();
        // Processed models
        rawModels.getModels().forEach(m -> {
            storePackageInfo(m);
            processedModels.addAll(m.getProcessedModels());
        });
        // Add adapter packages and generate methods.
        adapterModels.getModels().forEach(m -> {
            storePackageInfo(m);
            m.generateMethods();
        });
        // Unit tests
        // TODO implement unit tests for enums.
        processedModels.stream().filter(m -> !m.isAbstract() && !(m instanceof ModelEnum))
                       .forEach(m -> unitTests.add(new ModelTest(m)));
        // Process Endpoints
        processedModels.addAll(rawEndpoints.getModels());
        // Process Modules
        processedModules.addAll(rawModules.getModels());
    }

    /**
     * @return the rawModels
     */
    public List<Model> getRawModels() {
        return rawModels.getModels();
    }

    public List<Model> getAllRawModels() {
        final List<Model> raw = new ArrayList<>(rawModels.getModels());
        raw.addAll(adapterModels.getModels());
        raw.addAll(rawEndpoints.getModels());
        raw.addAll(rawModules.getModels());
        // TODO add missing
        return raw;
    }

    /**
     * @return the processedModels
     */
    public List<Model> getProcessedModels() {
        return processedModels;
    }

    public List<ModelEndpoints> getProcessedEndpoints() {
        return processedEndpoints;
    }

    public List<ModelModule> getProcessedModules() {
        return processedModules;
    }

    public List<ModelAdapter> getAdapterModels() {
        return adapterModels.getModels();
    }

    public List<PackageInfo> getPackagesInfo() {
        return new ArrayList<>(packagesInfo.values());
    }

    /**
     * @return the unitTests
     */
    public List<ModelTest> getUnitTests() {
        return unitTests;
    }

    private void storePackageInfo(Model m) {
        final String packageName = m.getPackageName().trim();
        if (!packagesInfo.containsKey(packageName)) {
            packagesInfo.put(packageName, new ModelPackageInfo(packageName, m.getGroup()));
        }
    }

}
