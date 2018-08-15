package com.arm.pelion.sdk.foundation.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.arm.pelion.sdk.foundation.generator.PackageInfo;

public class Models {

    private final List<Model> rawModels;
    private final List<Model> processedModels;
    private final List<ModelTest> unitTests;
    private final Map<String, PackageInfo> packagesInfo;

    /**
     *
     */
    public Models() {
        super();
        rawModels = new LinkedList<>();
        processedModels = new LinkedList<>();
        unitTests = new LinkedList<>();
        packagesInfo = new HashMap<>();
    }

    /**
     * @param rawModels
     */
    public Models(List<Model> rawModels) {
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

    public void process() {
        processedModels.clear();
        rawModels.forEach(m -> {
            storePackageInfo(m);
            processedModels.addAll(m.getProcessedModels());
        });
        processedModels.stream().filter(m -> !m.isAbstract()).forEach(m -> unitTests.add(new ModelTest(m)));
        // processedModels.
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
