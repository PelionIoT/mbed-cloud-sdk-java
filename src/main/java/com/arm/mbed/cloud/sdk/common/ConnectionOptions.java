package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "APIs connection options/configuration")
public class ConnectionOptions {
    private String apiKey;
    private String host;
    private CallLogLevel clientLogLevel;

    public ConnectionOptions(String apiKey, String host) {
        super();
        setApiKey(apiKey);
        setHost(host);
        setClientLogLevel(CallLogLevel.NONE);
    }

    /**
     * @return the apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @param apiKey
     *            the apiKey to set
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isApiKeyEmpty() {
        return apiKey == null || apiKey.isEmpty();
    }

    public boolean isHostEmpty() {
        return host == null || host.isEmpty();
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     *            the host to set
     */
    public void setHost(String host) {
        if (host != null && !host.endsWith("/")) {
            host = host + "/";
        }
        this.host = host;
    }

    /**
     * @return the clientLogLevel
     */
    public CallLogLevel getClientLogLevel() {
        return clientLogLevel;
    }

    /**
     * @param clientLogLevel
     *            the clientLogLevel to set
     */
    public void setClientLogLevel(CallLogLevel clientLogLevel) {
        this.clientLogLevel = clientLogLevel;
    }

}
