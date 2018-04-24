package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.internal.mds.model.PresubscriptionArray;

@Preamble(description = "Adapter for presubscription model")
public final class PresubscriptionAdapter {

    private PresubscriptionAdapter() {
        super();
    }

    /**
     * Maps presubscription.
     *
     * @param apiPresubscription
     *            presubscription to map
     * @return mapped presubscription
     */
    public static Presubscription map(com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription apiPresubscription) {
        if (apiPresubscription == null) {
            return null;
        }
        final Presubscription presubscription = new Presubscription();
        presubscription.setDeviceId(apiPresubscription.getEndpointName());
        presubscription.setDeviceType(apiPresubscription.getEndpointType());
        presubscription.setResourcePaths(apiPresubscription.getResourcePath());
        return presubscription;
    }

    /**
     * Reverses mapping of a presubscription.
     *
     * @param presubscription
     *            presubscription
     * @return presubscription
     */
    public static com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription reverseMap(
            Presubscription presubscription) {
        if (presubscription == null) {
            return null;
        }
        final com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription apiPresubscription = new com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription();
        apiPresubscription.setEndpointName(presubscription.getDeviceId());
        apiPresubscription.setEndpointType(presubscription.getDeviceType());
        apiPresubscription.setResourcePath(presubscription.getResourcePaths());
        return apiPresubscription;
    }

    /**
     * Gets mapper.
     *
     * @return mapper
     */
    public static Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription, Presubscription> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription, Presubscription>() {

            @Override
            public Presubscription map(com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription toBeMapped) {
                return PresubscriptionAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Gets reverse mapper.
     *
     * @return reverse mapper
     */
    public static Mapper<Presubscription, com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription> getReverseMapper() {
        return new Mapper<Presubscription, com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription>() {

            @Override
            public com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription map(Presubscription toBeMapped) {
                return PresubscriptionAdapter.reverseMap(toBeMapped);
            }

        };
    }

    /**
     * Maps list of presubscriptions.
     *
     * @param list
     *            of presubscription.
     * @return list of presubscription
     */
    public static List<Presubscription> mapList(PresubscriptionArray list) {
        if (list == null) {
            return null;
        }
        return GenericAdapter.mapList(list, getMapper());
    }

    /**
     * Maps list of presubscriptions to a registry.
     *
     * @param list
     *            of presubscription.
     * @return a registry of presubscription
     */
    public static GenericAdapter.MappedObjectRegistry<Presubscription> mapListToRegistry(PresubscriptionArray list) {
        return new GenericAdapter.MappedObjectRegistry<>(list, getMapper());
    }

    /**
     * Reverses mapping of a list of presubscriptions.
     *
     * @param list
     *            of presubscription.
     * @return list of presubscription
     */
    public static PresubscriptionArray reverseMapList(List<Presubscription> list) {
        return (PresubscriptionArray) GenericAdapter.mapList(list, new PresubscriptionArray(), getReverseMapper());
    }

    /**
     * Gets list mapper.
     *
     * @return a list mapper
     */
    public static Mapper<PresubscriptionArray, List<Presubscription>> getListMapper() {
        return new Mapper<PresubscriptionArray, List<Presubscription>>() {

            @Override
            public List<Presubscription> map(PresubscriptionArray toBeMapped) {
                return PresubscriptionAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Gets list to registry mapper.
     *
     * @return a list to registry mapper
     */
    public static Mapper<PresubscriptionArray, GenericAdapter.MappedObjectRegistry<Presubscription>> getListToRegistryMapper() {
        return new Mapper<PresubscriptionArray, GenericAdapter.MappedObjectRegistry<Presubscription>>() {

            @Override
            public GenericAdapter.MappedObjectRegistry<Presubscription> map(PresubscriptionArray toBeMapped) {
                return PresubscriptionAdapter.mapListToRegistry(toBeMapped);
            }

        };
    }

    /**
     * Gets a list of resource path from a string.
     *
     * @param list
     *            string containing resource paths.
     * @return list of resource paths
     */
    public static List<String> mapResourcePathList(String list) {
        if (list == null) {
            return null;
        }
        final String listString = list.replace("\r", "");
        return TranslationUtils.parseList(listString, "\n");
    }

    /**
     * Gets resource path list mapper.
     *
     * @return a list of resource path
     */
    public static Mapper<String, List<String>> getResourcePathListMapper() {
        return new Mapper<String, List<String>>() {

            @Override
            public List<String> map(String toBeMapped) {
                return mapResourcePathList(toBeMapped);
            }

        };
    }

}
