package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "APIs connection options/configuration")
public class ConnectionOptions implements Cloneable {
    private String apiKey;
    private String host;
    private CallLogLevel clientLogLevel;
    private TimePeriod requestTimeout;

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
        final StringBuilder sb = new StringBuilder();
        if (host != null) {
            sb.append(host.trim());
            if (!host.endsWith("/")) {
                sb.append('/');
            }
        }

        this.host = sb.toString();
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

    /**
     * @return the requestTimeout
     */
    public TimePeriod getRequestTimeout() {
        return requestTimeout;
    }

    /**
     * @param requestTimeout
     *            the requestTimeout to set
     */
    public void setRequestTimeout(TimePeriod requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public boolean hasCustomRequestTimeout() {
        return requestTimeout != null;
    }

    @Override
    public ConnectionOptions clone() {
        final ConnectionOptions options = new ConnectionOptions(apiKey, host);
        options.setClientLogLevel(clientLogLevel);
        if (hasCustomRequestTimeout()) {
            options.setRequestTimeout(requestTimeout.clone());
        }
        return options;
    }

}
