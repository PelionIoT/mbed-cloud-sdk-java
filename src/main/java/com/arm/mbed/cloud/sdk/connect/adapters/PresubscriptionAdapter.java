package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.internal.mds.model.PresubscriptionArray;

@Preamble(description = "Adapter for presubscription model")
public class PresubscriptionAdapter {

    private PresubscriptionAdapter() {
        super();
    }

    public static Presubscription map(com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription apiPresubscription) {
        if (apiPresubscription == null) {
            return null;
        }
        Presubscription presubscription = new Presubscription();
        presubscription.setDeviceId(apiPresubscription.getEndpointName());
        presubscription.setDeviceType(apiPresubscription.getEndpointType());
        presubscription.setResourcePaths(apiPresubscription.getResourcePath());
        return presubscription;
    }

    public static com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription reverseMap(
            Presubscription presubscription) {
        if (presubscription == null) {
            return null;
        }
        com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription apiPresubscription = new com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription();
        apiPresubscription.setEndpointName(presubscription.getDeviceId());
        apiPresubscription.setEndpointType(presubscription.getDeviceType());
        apiPresubscription.setResourcePath(presubscription.getResourcePaths());
        return apiPresubscription;
    }

    public static Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription, Presubscription> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription, Presubscription>() {

            @Override
            public Presubscription map(com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription toBeMapped) {
                return PresubscriptionAdapter.map(toBeMapped);
            }

        };
    }

    public static Mapper<Presubscription, com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription> getReverseMapper() {
        return new Mapper<Presubscription, com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription>() {

            @Override
            public com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription map(Presubscription toBeMapped) {
                return PresubscriptionAdapter.reverseMap(toBeMapped);
            }

        };
    }

    public static List<Presubscription> mapList(PresubscriptionArray list) {
        if (list == null) {
            return null;
        }
        return GenericAdapter.mapList(list, getMapper());
    }

    public static PresubscriptionArray reverseMapList(List<Presubscription> list) {
        return (PresubscriptionArray) GenericAdapter.mapList(list, new PresubscriptionArray(), getReverseMapper());
    }

    public static Mapper<PresubscriptionArray, List<Presubscription>> getListMapper() {
        return new Mapper<PresubscriptionArray, List<Presubscription>>() {

            @Override
            public List<Presubscription> map(PresubscriptionArray toBeMapped) {
                return PresubscriptionAdapter.mapList(toBeMapped);
            }

        };
    }

}
