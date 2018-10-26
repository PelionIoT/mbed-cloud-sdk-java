package utils;

import static org.junit.Assert.fail;

import com.arm.mbed.cloud.sdk.common.ConnectionOptions;

public class Configuration {
    private ConnectionOptions config;
    private final boolean isIncomplete;

    public static ConnectionOptions get() {
        if (ConfigurationHolder.INSTANCE.isIncomplete) {
            thowException();
        }
        return ConfigurationHolder.INSTANCE.config;
    }

    private static class ConfigurationHolder {
        public static final Configuration INSTANCE = new Configuration();
    }

    private Configuration() {
        config = ConnectionOptions.newConfiguration();
        isIncomplete = config.isApiKeyEmpty();
    }

    private static void thowException() {
        fail("Unable to find " + ConnectionOptions.ENVIRONMENT_VARIABLE_API_KEY + " environment variable");
    }

}
