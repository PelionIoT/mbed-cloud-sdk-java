// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.accounts.adapters;

import com.arm.mbed.cloud.sdk.accounts.model.Policy;
import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.FeaturePolicy;
import java.util.List;

/**
 * Adapter for policies.
 */
@Preamble(description = "Adapter for policies.")
@Internal
@SuppressWarnings("checkstyle:LineLength")
public final class PolicyAdapter {
    /**
     * Constructor.
     */
    private PolicyAdapter() {
        super();
        // Nothing to do;
    }

    /**
     * Maps a feature policy into a policy.
     * 
     * @param toBeMapped
     *            a feature policy.
     * @return mapped a policy
     */
    @Internal
    public static Policy map(FeaturePolicy toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final Policy policy = new Policy();
        policy.setAction(toBeMapped.getAction());
        policy.setAllow(TranslationUtils.toBool(toBeMapped.isAllow()));
        policy.setFeature(toBeMapped.getFeature());
        policy.setInherited(TranslationUtils.toBool(toBeMapped.isInherited()));
        policy.setResource(toBeMapped.getResource());
        return policy;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<FeaturePolicy, Policy> getMapper() {
        return new GenericAdapter.Mapper<FeaturePolicy, Policy>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public Policy map(FeaturePolicy toBeMapped) {
                return PolicyAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a list into a list.
     * 
     * @param toBeMapped
     *            a list.
     * @return mapped simple list
     */
    @Internal
    public static List<Policy> mapSimpleList(List<FeaturePolicy> toBeMapped) {
        return GenericAdapter.mapList(toBeMapped, PolicyAdapter.getMapper());
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<List<FeaturePolicy>, List<Policy>> getSimpleListMapper() {
        return new GenericAdapter.Mapper<List<FeaturePolicy>, List<Policy>>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public List<Policy> map(List<FeaturePolicy> toBeMapped) {
                return PolicyAdapter.mapSimpleList(toBeMapped);
            }
        };
    }
}
