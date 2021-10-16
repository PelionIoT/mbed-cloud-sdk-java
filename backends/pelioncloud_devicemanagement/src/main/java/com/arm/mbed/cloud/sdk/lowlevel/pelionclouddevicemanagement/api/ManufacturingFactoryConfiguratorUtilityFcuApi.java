package com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.api;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.ArchiveInfoResponse;

public interface ManufacturingFactoryConfiguratorUtilityFcuApi {
    /**
     * Download the Factory Configurator Utility archive. Downloads the Factory Configurator Utility (FCU) archive .zip
     * file for the account ID associated with the access token. &lt;br&gt; **Example:** &lt;br&gt; &#x60;&#x60;&#x60;
     * curl -X GET https://api.us-east-1.mbedcloud.com/downloads/fcu/factory_configurator_utility.zip \\ -H
     * &#39;Authorization: Bearer &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @GET("downloads/fcu/factory_configurator_utility.zip")
    Call<Void> downloadFactoryTool();

    /**
     * Download information about the Factory Configurator Utility archive. Returns information about the Factory
     * Configurator Utility (FCU) archive. &lt;br&gt; **Example:** &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/downloads/fcu/inf \\ -H &#39;Authorization: Bearer &lt;access_key&gt;&#39;
     * &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;ArchiveInfoResponse&gt;
     */
    @GET("downloads/fcu/info")
    Call<ArchiveInfoResponse> getFactoryToolInfo();

    /**
     * Download Factory Configurator Utility release notes. Downloads the Factory Configurator Utility (FCU) release
     * notes. &lt;br&gt; **Example:** &lt;br&gt; &#x60;&#x60;&#x60; curl -X GET
     * https://api.us-east-1.mbedcloud.com/downloads/fcu/release_notes \\ -H &#39;Authorization: Bearer
     * &lt;access_key&gt;&#39; &#x60;&#x60;&#x60;
     * 
     * @return Call&lt;Void&gt;
     */
    @GET("downloads/fcu/release_notes")
    Call<Void> getFactoryToolReleaseNotes();

}
