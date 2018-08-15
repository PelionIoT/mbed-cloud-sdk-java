package com.arm.pelion.sdk.foundation.generator;

import java.io.File;

public class PackageInfoGenerator extends AbstractGenerator {

    private final PackageInfo packageInfo;

    public PackageInfoGenerator(File destinationDirectory, PackageInfo packageInfo) {
        super(destinationDirectory, null);
        this.packageInfo = packageInfo;
    }

    @Override
    public void generate() throws TranslationException {
        if (packageInfo == null) {
            return;
        }

        packageInfo.translate();
        logger.logInfo("Generating package info [" + packageInfo.getPackageName() + "]");

    }

    /*
     * (non-Javadoc)
     *
     * @see com.arm.pelion.sdk.foundation.generator.AbstractGenerator#clean()
     */
    // TODO
    @Override
    public void clean() {
        // TODO Auto-generated method stub

    }

}
