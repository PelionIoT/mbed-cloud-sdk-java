package utils;

import static org.junit.Assert.fail;

import com.arm.mbed.cloud.sdk.common.CallLogLevel;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class Configuration {
    private static final String ENVVAR_MBED_CLOUD_HOST = "MBED_CLOUD_HOST";
    private static final String ENVVAR_MBED_CLOUD_API_KEY = "MBED_CLOUD_API_KEY";
    private static final String ENVVAR_HTTP_LOG_LEVEL = "HTTP_LOG_LEVEL";

    private ConnectionOptions config;

    public static ConnectionOptions get() {
        return ConfigurationHolder.INSTANCE.config;
    }

    private static class ConfigurationHolder {
        public static final Configuration INSTANCE = new Configuration();
    }

    private Configuration() {
        config = new ConnectionOptions(System.getenv(ENVVAR_MBED_CLOUD_API_KEY), System.getenv(ENVVAR_MBED_CLOUD_HOST));
        config.setClientLogLevel(CallLogLevel.getLevel(System.getenv(ENVVAR_HTTP_LOG_LEVEL)));
        if (config.isApiKeyEmpty()) {
            logError("Unable to find " + String.valueOf(ENVVAR_MBED_CLOUD_API_KEY) + " environment variable");
        }
    }

    private void logError(String message) {
        fail(message);
    }

}
