package com.arm.mbed.cloud.sdk.common;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import io.github.cdimascio.dotenv.Dotenv;

import com.arm.mbed.cloud.sdk.annotations.DefaultValue;
import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "APIs connection options/configuration")
public class ConnectionOptions implements Cloneable, Serializable {
    /**
     * Environment variable for setting Mbed Cloud host.
     */
    public static final String ENVIRONMENT_VARIABLE_HOST = "MBED_CLOUD_SDK_HOST";
    /**
     * Environment variable for setting the level of HTTP logs when communicating to Mbed Cloud.
     *
     * @see CallLogLevel for more details about the possible values.
     */
    public static final String ENVIRONMENT_VARIABLE_HTTP_LOG_LEVEL = "MBED_CLOUD_SDK_LOG_LEVEL";
    /**
     * Environment variable for setting the API Key to use for Mbed Cloud.
     */
    public static final String ENVIRONMENT_VARIABLE_API_KEY = "MBED_CLOUD_SDK_API_KEY";
    /**
     * Environment variable for forcing the removal of notification channels on start.
     * <p>
     * Warning: this can destroy existing channels so should not be used in development, but useful for production
     * deployments where service restarts should be automated.
     */
    public static final String ENVIRONMENT_VARIABLE_NOTIFICATION_CHANNEL_FORCE_CLEAR = "NOTIFICATION_CHANNEL_FORCE_CLEAR";
    /**
     * Environment variable for skipping any clean-up regarding notifications on exit.
     * <p>
     * Warning: this will leave residual state for channels and subscriptions so should be used with care in
     * development, but useful for production deployments to reduce the overhead or restart the service.
     */
    public static final String ENVIRONMENT_VARIABLE_NOTIFICATION_CHANNEL_SKIP_CLEANUP = "NOTIFICATION_CHANNEL_SKIP_CLEANUP";
    /**
     * Environment variable for starting automatically notification listening daemon threads.
     * <p>
     * Note: for systems using server initiated notification mode, this should be disabled.
     */
    public static final String ENVIRONMENT_VARIABLE_NOTIFICATION_CHANNEL_AUTOSTART = "NOTIFICATION_CHANNEL_AUTOSTART";

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
    @DefaultValue(value = "FALSE")
    private boolean forceClear;
    @DefaultValue(value = "FALSE")
    private boolean skipCleanup;
    private final transient Dotenv dotenv;

    /**
     * Constructor for communications to Arm Mbed Cloud.
     * <p>
     * Note: the API key will be read from environment variables or .env file. {@link #ENVIRONMENT_VARIABLE_API_KEY} is
     * required to be set.
     *
     */
    public ConnectionOptions() {
        this(null);
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
     * Constructor.
     *
     * @param apiKey
     *            API key to use.
     * @param host
     *            Arm Mbed Cloud URL
     */
    public ConnectionOptions(String apiKey, String host) {
        super();
        dotenv = Dotenv.configure().ignoreIfMissing().load();
        setApiKey(apiKey);
        setHost(host);
        setAutostartDaemon(true);
        setForceClear(false);
        setSkipCleanup(false);
        setClientLogLevel((String) null);
    }

    /**
     * Generates a new Mbed Cloud connection configuration.
     * <p>
     * Note: the API key will be read from environment variables or .env file.
     * <p>
     * This is similar to {@link #ConnectionOptions()}
     *
     * @return corresponding configuration.
     */
    public static ConnectionOptions newConfiguration() {
        return new ConnectionOptions();
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
        String key = (apiKey == null) ? null : apiKey.trim();
        if (isEntryEmpty(key)) {
            key = dotenv.get(ENVIRONMENT_VARIABLE_API_KEY);
        }
        this.apiKey = key;
    }

    /**
     * States whether the API key has been specified or not.
     *
     * @return true if the API key has not been set. false otherwise.
     */
    public boolean isApiKeyEmpty() {
        return isEntryEmpty(apiKey);
    }

    /**
     * States whether the host to contact has been specified or not.
     *
     * @return true if the host has not been set. false otherwise.
     */
    public boolean isHostEmpty() {
        return isEntryEmpty(host);
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
     * Gets Pelion Cloud Host to contact.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Gets Pelion Cloud Host URL to use.
     * 
     * @return the host URL.
     * @throws MalformedURLException
     *             if exception arises.
     */
    public URL getHostUrl() throws MalformedURLException {
        return new URL(getHost());
    }

    /**
     * Sets the Arm Mbed Cloud Host to contact.
     *
     * @param host
     *            the host to set
     */
    public void setHost(String host) {
        String cloudHost = host;
        if (isEntryEmpty(cloudHost)) {
            cloudHost = dotenv.get(ENVIRONMENT_VARIABLE_HOST);
            if (isEntryEmpty(cloudHost)) {
                cloudHost = ARM_MBED_CLOUD_DEFAULT_HOST;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(cloudHost.trim());
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
     * Sets the logging level of the client to use.
     *
     * @see CallLogLevel
     * @param clientLogLevel
     *            the clientLogLevel to set
     */
    public void setClientLogLevel(String clientLogLevel) {
        String logLevel = clientLogLevel;
        if (isEntryEmpty(logLevel)) {
            logLevel = dotenv.get(ENVIRONMENT_VARIABLE_HTTP_LOG_LEVEL);
        }
        if (isEntryEmpty(logLevel)) {
            setClientLogLevel(CallLogLevel.NONE);
        } else {
            setClientLogLevel(CallLogLevel.getLevel(logLevel.trim()));
        }
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
    public void setAutostartDaemon(@DefaultValue(value = "TRUE") boolean autostartDaemon) {
        if (!autostartDaemon) {
            this.autostartDaemon = autostartDaemon;
            return;
        }
        final String autoStartEnv = dotenv.get(ENVIRONMENT_VARIABLE_NOTIFICATION_CHANNEL_AUTOSTART);
        if (autoStartEnv == null) {
            this.autostartDaemon = autostartDaemon;
            return;
        }
        this.autostartDaemon = Boolean.parseBoolean(autoStartEnv.trim());
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
    public ConnectionOptions autostartDaemon(@DefaultValue(value = "TRUE") boolean autostartDaemonMode) {
        setAutostartDaemon(autostartDaemonMode);
        return this;
    }

    /**
     * Sets autostart daemon mode to true.
     * <p>
     * Note: Similar to {@link #autostartDaemon(boolean)}
     *
     * @return these connection options.
     */
    public ConnectionOptions autostartDaemon() {
        return autostartDaemon(true);
    }

    /**
     * States whether any existing notification channel should be cleared before a new one is created.
     *
     * @return True if the channel will be cleared. False otherwise.
     */
    public boolean isForceClear() {
        return forceClear;
    }

    /**
     * Sets whether any existing notification channel should be cleared before a new one is created.
     * <p>
     * Warning: This flag should only be set to True with caution and in automated environments such as server-side
     * applications where service restart is automated. It will indeed remove any existing notification channel.
     * 
     * @param forceClear
     *            True if the channel should be cleared. False otherwise.
     */
    public void setForceClear(@DefaultValue(value = "FALSE") boolean forceClear) {
        if (forceClear) {
            this.forceClear = forceClear;
            return;
        }
        final String forceClearEnv = dotenv.get(ENVIRONMENT_VARIABLE_NOTIFICATION_CHANNEL_FORCE_CLEAR);
        if (forceClearEnv == null) {
            this.forceClear = forceClear;
            return;
        }
        this.forceClear = Boolean.parseBoolean(forceClearEnv.trim());
    }

    /**
     * Ensures that any notification channel is cleared before one is created.
     * <p>
     * Warning: this flag should only be used with caution in automated/production environments such as server-side
     * applications where service restart is automated.
     * 
     * @return these connection options.
     */
    public ConnectionOptions forceClear() {
        return forceClear(true);
    }

    /**
     * Sets whether any existing notification channel should be cleared before a new one is created.
     * <p>
     * Note: Similar to {@link ConnectionOptions#setForceClear(boolean)}
     * 
     * @param forceClear
     *            True if the channel should be cleared. False otherwise.
     * @return these connection options.
     */
    public ConnectionOptions forceClear(@DefaultValue(value = "FALSE") boolean forceClear) {
        setForceClear(forceClear);
        return this;
    }

    /**
     * States whether any existing notification channel and subscriptions will not be cleared on SDK exit.
     * 
     * @return True if the clean-up will be skipped. False otherwise.
     */
    public boolean isSkipCleanup() {
        return skipCleanup;
    }

    /**
     * Sets whether any existing notification channel and subscriptions should not be cleared on SDK exit.
     * <p>
     * Warning: This flag should only be set to True with caution and in automated environments such as server-side
     * applications where service restart is automated. Cleanup on exit would indeed create some overhead on restart.
     * 
     * @param skipCleanup
     *            True if clean-up should be skipped. False otherwise.
     */
    public void setSkipCleanup(@DefaultValue(value = "FALSE") boolean skipCleanup) {
        if (skipCleanup) {
            this.skipCleanup = skipCleanup;
            return;
        }
        final String skipCleanupEnv = dotenv.get(ENVIRONMENT_VARIABLE_NOTIFICATION_CHANNEL_SKIP_CLEANUP);
        if (skipCleanupEnv == null) {
            this.skipCleanup = skipCleanup;
            return;
        }
        this.skipCleanup = Boolean.parseBoolean(skipCleanupEnv.trim());
    }

    /**
     * Sets whether any existing notification channel and subscriptions should not be cleared on SDK exit.
     * 
     * <p>
     * Note: Similar to {@link #setSkipCleanup(boolean)}
     * 
     * @param skipCleanup
     *            True if clean-up should be skipped. False otherwise.
     * @return these connection options.
     */
    public ConnectionOptions skipCleanup(@DefaultValue(value = "FALSE") boolean skipCleanup) {
        setSkipCleanup(skipCleanup);
        return this;
    }

    /**
     * Ensures that any clean-up is skipped on SDK exit.
     * <p>
     * Warning: this flag should only be used with caution in automated/production environments such as server-side
     * applications where service restart is automated.
     * 
     * @return these connection options.
     */
    public ConnectionOptions skipCleanup() {
        return skipCleanup(true);
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
        options.setForceClear(forceClear);
        options.setSkipCleanup(skipCleanup);
        if (hasCustomRequestTimeout()) {
            options.setRequestTimeout(requestTimeout.clone());
        }
        return options;
    }

    protected static boolean isEntryEmpty(String entry) {
        if (entry == null || entry.isEmpty()) {
            return true;
        }
        return entry.replace("\'", "").replace("\"", "").trim().isEmpty();

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
        result = prime * result + (autostartDaemon ? 1231 : 1237);
        result = prime * result + (forceClear ? 1231 : 1237);
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result = prime * result + (skipCleanup ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ConnectionOptions)) {
            return false;
        }
        final ConnectionOptions other = (ConnectionOptions) obj;
        if (apiKey == null) {
            if (other.apiKey != null) {
                return false;
            }
        } else if (!apiKey.equals(other.apiKey)) {
            return false;
        }
        if (autostartDaemon != other.autostartDaemon) {
            return false;
        }
        if (forceClear != other.forceClear) {
            return false;
        }
        if (host == null) {
            if (other.host != null) {
                return false;
            }
        } else if (!host.equals(other.host)) {
            return false;
        }
        if (skipCleanup != other.skipCleanup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectionOptions [host=" + host + ", clientLogLevel=" + clientLogLevel + ", requestTimeout="
               + requestTimeout + ", autostartDaemon=" + autostartDaemon + ", forceClear=" + forceClear
               + ", skipCleanup=" + skipCleanup + "]";
    }

}
