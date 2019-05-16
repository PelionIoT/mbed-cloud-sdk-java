package com.arm.pelion.sdk.foundation.generator.cli;

import java.util.Locale;

import com.jcabi.manifests.Manifests;

import picocli.CommandLine.IVersionProvider;

public class GeneratorVersion implements IVersionProvider {
    private static final String GENERATOR_IDENTIFIER = "foundation";
    private static final String DEFAULT_VERSION = "unknown_dev";
    private static final String IMPLEMENTATION_TITLE_ATTRIBUTE = "Implementation-Title";
    private static final String IMPLEMENTATION_VERSION_ATTRIBUTE = "Implementation-Version";

    private String version;

    public GeneratorVersion() {
        version = null;
        fetchVersion();
    }

    @Override
    public String[] getVersion() throws Exception {
        return new String[] { version };
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void fetchVersion() {
        boolean foundCorrectInformationInManifest = false;
        if (Manifests.exists(IMPLEMENTATION_TITLE_ATTRIBUTE)) {
            final String description = Manifests.read(IMPLEMENTATION_TITLE_ATTRIBUTE);
            if (description.toLowerCase(Locale.getDefault()).contains(GENERATOR_IDENTIFIER)) {
                foundCorrectInformationInManifest = true;
            }

            if (Manifests.exists(IMPLEMENTATION_VERSION_ATTRIBUTE)) {
                if (foundCorrectInformationInManifest) {
                    setVersion(Manifests.read(IMPLEMENTATION_VERSION_ATTRIBUTE));
                } else {
                    setVersion(DEFAULT_VERSION);
                }
            } else {
                setVersion(DEFAULT_VERSION);
            }

        }
    }
}
