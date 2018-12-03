package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.PackageInfo;

public class Artifacts {

    private final List<Model> rawModels;
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
        rawModels = new LinkedList<>();
        processedModels = new LinkedList<>();
        unitTests = new LinkedList<>();
        packagesInfo = new HashMap<>();
        rawEndpoints = new HashMap<>();
        processedEndpoints = new LinkedList<>();
    }

    /**
     * @param rawModels
     */
    public Artifacts(List<Model> rawModels) {
        this();
        if (rawModels != null) {
            this.rawModels.addAll(rawModels);
        }
    }

    public void addModel(Model model) {
        if (model != null) {
            rawModels.add(model);
        }
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

    public void process() {
        processedModels.clear();
        processedEndpoints.clear();
        unitTests.clear();
        // Processed models
        rawModels.forEach(m -> {
            storePackageInfo(m);
            processedModels.addAll(m.getProcessedModels());
        });
        // Unit tests
        // TODO implement unit tests for enums.
        processedModels.stream().filter(m -> !m.isAbstract() && !(m instanceof Enum))
                       .forEach(m -> unitTests.add(new ModelTest(m)));
        // Process Endpoints
        rawEndpoints.values().stream().forEach(l -> processedEndpoints.add(Utils.merge(l)));
    }

    /**
     * @return the rawModels
     */
    public List<Model> getRawModels() {
        return rawModels;
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
