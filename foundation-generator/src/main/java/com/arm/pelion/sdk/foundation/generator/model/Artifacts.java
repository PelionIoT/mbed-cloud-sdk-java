package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.arm.pelion.sdk.foundation.generator.util.MergeableModelDefinitionStore;
import com.arm.pelion.sdk.foundation.generator.util.ModelDefinitionStore;
import com.arm.pelion.sdk.foundation.generator.util.SimpleModelDefinitionStore;

public class Artifacts {

    private final ModelDefinitionStore<Model> rawModels;
    private final ModelDefinitionStore<Model> listOptionModels;
    private final ModelDefinitionStore<Model> daoModels;
    private final ModelDefinitionStore<Model> factoryModels;
    private final ArtifactFetcher<Model> modelFetcher;
    private final ModelListOptionFetcher listOptionFetcher;
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
        listOptionModels = new SimpleModelDefinitionStore<>();
        daoModels = new SimpleModelDefinitionStore<>();
        factoryModels = new SimpleModelDefinitionStore<>();
        processedModels = new LinkedList<>();
        unitTests = new LinkedList<>();
        packagesInfo = new HashMap<>();
        rawEndpoints = new MergeableModelDefinitionStore<>();
        processedEndpoints = new LinkedList<>();
        rawModules = new MergeableModelDefinitionStore<>();
        processedModules = new LinkedList<>();
        modelFetcher = new ArtifactFetcher<>(rawModels);
        listOptionFetcher = new ModelListOptionFetcher(listOptionModels);
        adapterFetcher = new ModelAdapterFetcher(adapterModels, modelFetcher);
        endpointsFetcher = new ModelEndpointsFetcher(rawEndpoints);
    }

    /**
     * @param rawModels
     */
    public Artifacts(List<Model> rawModels) {
        this();
        addModels(rawModels);
    }

    public <T extends Model> void addModels(List<T> models) {
        if (models == null || models.isEmpty()) {
            return;
        }
        models.forEach(m -> addModel(m));
    }

    public void addModel(Model model) {
        this.rawModels.store(model);
    }

    public void addListOption(ModelListOption listOptionModel) {
        this.listOptionModels.store(listOptionModel);
    }

    public void addDao(ModelDao daoModel) {
        daoModels.store(daoModel);
    }

    public void addFactory(Model factory) {
        factoryModels.store(factory);
    }

    public <T extends ModelListOption> void addListOptions(List<T> models) {
        if (models == null || models.isEmpty()) {
            return;
        }
        models.forEach(m -> addListOption(m));
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

    public ModelListOptionFetcher getListOptionFetcher() {
        return listOptionFetcher;
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
        // List options processed models
        listOptionModels.getModels().forEach(m -> {
            storePackageInfo(m);
            m.generateMethods();
            processedModels.addAll(m.getProcessedModels());
        });
        // Add adapter packages and generate methods.
        adapterModels.getModels().forEach(m -> {
            storePackageInfo(m);
            m.generateMethods();
        });
        // Process Endpoints
        rawEndpoints.getModels().forEach(m -> {
            storePackageInfo(m);
            m.generateMethods();
            processedEndpoints.addAll(m.getProcessedModels().stream().map(e -> (ModelEndpoints) e)
                                       .collect(Collectors.toList()));
        });
        // Process Modules
        rawModules.getModels().forEach(m -> {
            storePackageInfo(m);
            m.generateMethods();
            processedModules.addAll(m.getProcessedModels().stream().map(c -> (ModelModule) c)
                                     .collect(Collectors.toList()));
        });
        // DAO processed models
        daoModels.getModels().forEach(m -> {
            storePackageInfo(m);
            m.generateMethods();
            processedModels.addAll(m.getProcessedModels());
        });
        // Factory processed models
        factoryModels.getModels().forEach(m -> {
            storePackageInfo(m);
            m.generateMethods();
            processedModels.addAll(m.getProcessedModels());
        });

        // Unit tests
        processedModels.stream().filter(m -> !m.isAbstract()).forEach(m -> unitTests.add(new ModelTest(m)));
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
        raw.addAll(listOptionModels.getModels());
        raw.addAll(daoModels.getModels());
        raw.addAll(factoryModels.getModels());
        raw.addAll(rawEndpoints.getModels());
        raw.addAll(rawModules.getModels());
        // TODO add missing
        return raw;
    }

    /**
     * @return the processedModels
     */
    private List<Model> getProcessedModels() {
        return processedModels;
    }

    public List<Model> getProcessedPojoModels() {
        return getProcessedModels().stream().filter(m -> m instanceof ModelPojo).collect(Collectors.toList());
    }

    public List<Model> getModuleFactory() {
        return getProcessedModels().stream().filter(m -> m instanceof ModelModuleFactory).collect(Collectors.toList());
    }

    public List<Model> getProcessedNonPojoModels() {
        return getProcessedModels().stream()
                                   .filter(m -> !(m instanceof ModelPojo) && !(m instanceof ModelModuleFactory))
                                   .collect(Collectors.toList());
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

    private List<PackageInfo> getPackagesInfo() {
        return new ArrayList<>(packagesInfo.values());
    }

    public List<PackageInfo> getModelPackagesInfo() {
        return getPackagesInfo().stream().filter(p -> p instanceof PackageInfoModel).collect(Collectors.toList());
    }

    public List<PackageInfo> getNonModelPackagesInfo() {
        return getPackagesInfo().stream().filter(p -> !(p instanceof PackageInfoModel)).collect(Collectors.toList());
    }

    /**
     * @return the unitTests
     */
    private List<ModelTest> getUnitTests() {
        return unitTests;
    }

    public List<ModelTest> getModuleFactoryUnitTests() {
        return getUnitTests().stream().filter(m -> m.getModelUnderTest() instanceof ModelModuleFactory)
                             .collect(Collectors.toList());
    }

    public List<ModelTest> getPojoUnitTests() {
        return getUnitTests().stream().filter(m -> m.getModelUnderTest() instanceof ModelPojo)
                             .collect(Collectors.toList());
    }

    public List<ModelTest> getNonPojoUnitTests() {
        return getUnitTests().stream()
                             .filter(m -> !(m.getModelUnderTest() instanceof ModelPojo)
                                          && !(m.getModelUnderTest() instanceof ModelModuleFactory))
                             .collect(Collectors.toList());
    }

    private void storePackageInfo(Model m) {
        final String packageName = m.getPackageName().trim();
        PackageInfo info = null;
        if (!packagesInfo.containsKey(packageName)) {
            if (m instanceof ModelPojo) {
                info = new PackageInfoModel(packageName, m.getGroup());
            } else if (m instanceof ModelAdapter) {
                info = new PackageInfoAdapter(packageName, m.getGroup());
            } else if (m instanceof ModelModule) {
                info = new PackageInfoModule(packageName, m.getGroup());
            } else {
                info = new PackageInfo(packageName, "Foundation package", null, m.getGroup());
            }
            packagesInfo.put(packageName, info);
        }
    }

}
