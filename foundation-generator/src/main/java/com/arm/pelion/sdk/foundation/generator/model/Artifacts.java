package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.PackageInfo;
import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;

public class Artifacts {

    private final ModelDefinitionStore<Model> rawModels;
    private final ArtifactFetcher<Model> modelFetcher;
    private final ModelDefinitionStore<ModelAdapter> adapterModels;
    private final ModelAdapterFetcher adapterFetcher;
    private final List<Model> processedModels;
    private final List<ModelTest> unitTests;
    private final Map<String, List<ModelEndpoints>> rawEndpoints;
    private final List<ModelEndpoints> processedEndpoints;

    // private final DAOs
    private final Map<String, PackageInfo> packagesInfo;

    /**
     *
     */
    public Artifacts() {
        super();
        rawModels = new ModelDefinitionStore<>();
        adapterModels = new ModelDefinitionStore<>();
        processedModels = new LinkedList<>();
        unitTests = new LinkedList<>();
        packagesInfo = new HashMap<>();
        rawEndpoints = new HashMap<>();
        processedEndpoints = new LinkedList<>();
        modelFetcher = new ArtifactFetcher<>(rawModels);
        adapterFetcher = new ModelAdapterFetcher(adapterModels, modelFetcher);
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
        if (endpoints != null && endpoints.getGroup() != null) {
            List<ModelEndpoints> list = rawEndpoints.get(endpoints.getGroup());
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(endpoints);
            rawEndpoints.put(endpoints.getGroup(), list);
        }
    }

    public ArtifactFetcher<Model> getModelFetcher() {
        return modelFetcher;
    }

    public ModelAdapterFetcher getAdapterFetcher() {
        return adapterFetcher;
    }

    public void process() {
        processedModels.clear();
        processedEndpoints.clear();
        unitTests.clear();
        // Processed models
        rawModels.getModels().forEach(m -> {
            storePackageInfo(m);
            processedModels.addAll(m.getProcessedModels());
        });
        // Add adapter packages
        adapterModels.getModels().forEach(m -> storePackageInfo(m));
        // Unit tests
        // TODO implement unit tests for enums.
        processedModels.stream().filter(m -> !m.isAbstract() && !(m instanceof ModelEnum))
                       .forEach(m -> unitTests.add(new ModelTest(m)));
        // Process Endpoints
        rawEndpoints.values().stream().forEach(l -> processedEndpoints.add(Utils.merge(l)));
    }

    /**
     * @return the rawModels
     */
    public List<Model> getRawModels() {
        return rawModels.getModels();
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
