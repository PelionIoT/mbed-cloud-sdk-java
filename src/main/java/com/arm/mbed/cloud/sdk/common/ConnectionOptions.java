package com.arm.mbed.cloud.sdk.common;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "APIs connection options/configuration")
public class ConnectionOptions implements Cloneable, Serializable {
    /**
     * Serialisation Id.
     */
    private static final long serialVersionUID = -7143679922351151624L;
    private static final String ARM_MBED_CLOUD_DEFAULT_HOST = "https://api.us-east-1.mbedcloud.com";
    private String apiKey;
    private String host;
    private CallLogLevel clientLogLevel;
    private TimePeriod requestTimeout;
    @DefaultValue(value = "TRUE")
    private boolean autostartDaemon;

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
        setAutostartDaemon(true);
        setClientLogLevel(CallLogLevel.NONE);
    }

    /**
     * Generates a new Mbed Cloud connection configuration.
     *
     * @param apiKey
     *            API key to use.
     * @return corresponding configuration.
     */
    public static ConnectionOptions newConfiguration(String apiKey) {
        return new ConnectionOptions(apiKey);
    }

    /**
     *
     * Generates a new Mbed Cloud connection configuration.
     *
     * @param apiKey
     *            API key to use.
     * @param host
     *            Host address of the Cloud to use. The host does not need to be specified and will default to Arm Mbed
     *            Cloud production system.
     * @return corresponding configuration
     */
    public static ConnectionOptions newConfiguration(String apiKey, String host) {
        return newConfiguration(apiKey).host(host);
    }

    /**
     * Constructor for communications to Arm Mbed Cloud.
     *
     * @param apiKey
     *            API key to use. The host does not need to be specified and will default to Arm Mbed Cloud production
     *            system.
     *
     */
    public ConnectionOptions(String apiKey) {
        this(apiKey, null);
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
     * States whether the current connection options are valid or not.
     *
     * @return true if it is the case. false otherwise.
     */
    public boolean isValid() {
        try {
            return !isApiKeyEmpty() && !isHostEmpty() && new URL(getHost()).getHost() != null;
        } catch (MalformedURLException exception) {
            return false;
        }
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
        String cloudHost = (host == null) ? null : host.trim();
        if (cloudHost == null || cloudHost.isEmpty()) {
            cloudHost = ARM_MBED_CLOUD_DEFAULT_HOST;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(cloudHost);
        if (!cloudHost.endsWith("/")) {
            sb.append('/');
        }
        this.host = sb.toString();
    }

    /**
     * Sets host.
     * <p>
     * Note: Similar to {@link #setHost(String)}
     *
     * @param cloudHost
     *            host to contact
     * @return these connection options
     */
    public ConnectionOptions host(String cloudHost) {
        setHost(cloudHost);
        return this;
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
     * Sets the log level to apply.
     * <p>
     * Note: Similar to {@link #setClientLogLevel(CallLogLevel)}
     *
     * @param logLevelOfTheHttpClient
     *            log level to set
     * @return these connection options.
     */
    public ConnectionOptions logLevel(CallLogLevel logLevelOfTheHttpClient) {
        setClientLogLevel(logLevelOfTheHttpClient);
        return this;
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
     * States whether daemons should autostart when needed.
     *
     * @return true if the daemon will autostart when necessary.
     */
    public boolean isAutostartDaemon() {
        return autostartDaemon;
    }

    /**
     * Sets whether daemon should autostart when needed. If set to false, an exception will be raised if a daemon is
     * required but not started.
     *
     * @param autostartDaemon
     *            autostart mode for the daemon.
     */
    public void setAutostartDaemon(boolean autostartDaemon) {
        this.autostartDaemon = autostartDaemon;
    }

    /**
     * Sets autostart daemon mode.
     * <p>
     * Note: Similar to {@link #setAutostartDaemon(boolean)}
     *
     * @param autostartDaemonMode
     *            mode to apply.
     * @return these connection options.
     */
    public ConnectionOptions autostartDaemon(boolean autostartDaemonMode) {
        setAutostartDaemon(autostartDaemonMode);
        return this;
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
        options.setAutostartDaemon(autostartDaemon);
        if (hasCustomRequestTimeout()) {
            options.setRequestTimeout(requestTimeout.clone());
        }
        return options;
    }

}
