package com.arm.mbed.cloud.sdk.common;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "APIs connection options/configuration")
public class ConnectionOptions implements Cloneable {
    private String apiKey;
    private String host;
    private CallLogLevel clientLogLevel;
    private TimePeriod requestTimeout;

    /**
     * Constructor.
     * 
     * @param apiKey
     *            API key to use.
     * @param host
     *            Arm Mbed Cloud URL
     */
    public ConnectionOptions(String apiKey, String host) {
        super();
        setApiKey(apiKey);
        setHost(host);
        setClientLogLevel(CallLogLevel.NONE);
    }

    /**
     * Gets the API key in use.
     * 
     * @return the apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the API key to use to contact the cloud.
     * 
     * @param apiKey
     *            the apiKey to set
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * States whether the API key has been specified or not.
     * 
     * @return true if the API key has not been set. false otherwise.
     */
    public boolean isApiKeyEmpty() {
        return apiKey == null || apiKey.isEmpty();
    }

    /**
     * States whether the host to contact has been specified or not.
     * 
     * @return true if the host has not been set. false otherwise.
     */
    public boolean isHostEmpty() {
        return host == null || host.isEmpty();
    }

    /**
     * Gets the Arm Mbed Cloud Host to contact.
     * 
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the Arm Mbed Cloud Host to contact.
     * 
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
     * Gets the current logging level of the client.
     * 
     * @see CallLogLevel
     * @return the clientLogLevel
     */
    public CallLogLevel getClientLogLevel() {
        return clientLogLevel;
    }

    /**
     * Sets the logging level of the client to use.
     * 
     * @see CallLogLevel
     * @param clientLogLevel
     *            the clientLogLevel to set
     */
    public void setClientLogLevel(CallLogLevel clientLogLevel) {
        this.clientLogLevel = clientLogLevel;
    }

    /**
     * Gets the custom HTTP client request timeout.
     * 
     * @return the requestTimeout
     */
    public TimePeriod getRequestTimeout() {
        return requestTimeout;
    }

    /**
     * Sets a HTTP client request timeout different from default setting.
     * 
     * @param requestTimeout
     *            the requestTimeout to set
     */
    public void setRequestTimeout(TimePeriod requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    /**
     * States whether a request timeout has been set.
     * 
     * @return true if a request timeout different from client default has been set. false otherwise.
     */
    public boolean hasCustomRequestTimeout() {
        return requestTimeout != null;
    }

    /**
     * Clones the connection options.
     * 
     * @return a clone.
     */
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
