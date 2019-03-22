// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.devices.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.AbstractEndpoints;
import com.arm.mbed.cloud.sdk.common.ServiceRegistry;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.CertificateRenewalApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.DefaultApi;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api.PublicApiApi;

/**
 * Endpoints for Devices APIs module.
 */
@Preamble(description = "Endpoints for Devices APIs module.")
@Internal
public class DevicesEndpoints extends AbstractEndpoints {
    /**
     * Low level endpoints for default apis.
     */
    @Internal
    private final DefaultApi defaultApi;

    /**
     * Low level endpoints for certificate renewal apis.
     */
    @Internal
    private final CertificateRenewalApi certificateRenewalApi;

    /**
     * Low level endpoints for public api apis.
     */
    @Internal
    private final PublicApiApi publicApiApi;

    /**
     * Constructor.
     * 
     * @param services
     *            created services {@link ServiceRegistry}.
     */
    public DevicesEndpoints(ServiceRegistry services) {
        super(services);
        this.defaultApi = initialiseService(DefaultApi.class);
        this.certificateRenewalApi = initialiseService(CertificateRenewalApi.class);
        this.publicApiApi = initialiseService(PublicApiApi.class);
    }

    /**
     * Gets low level endpoints for default apis.
     * 
     * @return defaultApi
     */
    @Internal
    public DefaultApi getDefaultApi() {
        return defaultApi;
    }

    /**
     * Gets low level endpoints for certificate renewal apis.
     * 
     * @return certificateRenewalApi
     */
    @Internal
    public CertificateRenewalApi getCertificateRenewalApi() {
        return certificateRenewalApi;
    }

    /**
     * Clones this instance.
     * 
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public DevicesEndpoints clone() {
        return new DevicesEndpoints(getRegistryClone());
    }

    /**
     * Gets low level endpoints for public api apis.
     * 
     * @return publicApiApi
     */
    @Internal
    public PublicApiApi getPublicApiApi() {
        return publicApiApi;
    }
}
