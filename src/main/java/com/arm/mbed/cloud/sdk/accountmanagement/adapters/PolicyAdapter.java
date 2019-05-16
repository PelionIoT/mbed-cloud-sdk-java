package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.accountmanagement.model.Policy;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FeaturePolicy;

@Preamble(description = "Adapter for policy model")
@Internal
public final class PolicyAdapter {

    private PolicyAdapter() {
        super();
    }

    /**
     * Maps policy objects.
     * 
     * @param featurePolicy
     *            featurePolicy.
     * @return a policy.
     */
    public static Policy map(FeaturePolicy featurePolicy) {
        if (featurePolicy == null) {
            return null;
        }
        return new Policy(featurePolicy.getAction(), featurePolicy.getResource(), featurePolicy.getFeature(),
                          TranslationUtils.toBool(featurePolicy.isAllow(), false));
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper for this policy.
     */
    public static Mapper<FeaturePolicy, Policy> getMapper() {
        return new Mapper<FeaturePolicy, Policy>() {

            @Override
            public Policy map(FeaturePolicy toBeMapped) {
                return PolicyAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a list of policies.
     * 
     * @param list
     *            policies list
     * @return list of policies
     */
    public static List<Policy> mapList(List<FeaturePolicy> list) {
        return GenericAdapter.mapList(list, getMapper());
    }
}
