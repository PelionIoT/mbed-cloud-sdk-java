package com.arm.mbed.cloud.sdk;

import com.arm.mbed.cloud.sdk.annotations.API;
import com.arm.mbed.cloud.sdk.annotations.Module;
import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.bootstrap.adapters.PreSharedKeyAdapter;
import com.arm.mbed.cloud.sdk.bootstrap.model.EndPoints;
import com.arm.mbed.cloud.sdk.bootstrap.model.PreSharedKey;
import com.arm.mbed.cloud.sdk.common.AbstractApi;
import com.arm.mbed.cloud.sdk.common.CloudCaller;
import com.arm.mbed.cloud.sdk.common.CloudCaller.CloudCall;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.internal.connectorbootstrap.model.PreSharedKeyWithoutSecret;

import retrofit2.Call;

@Preamble(description = "Specifies Bootstrap API")
@Module
/**
 * API exposing functionality for dealing with bootstrap.
 */
public class Bootstrap extends AbstractApi {

    private final EndPoints endpoint;
    private static final String TAG_KEY = "key";
    private static final String TAG_KEY_ID = "key Id";

    /**
     * Bootstrap module constructor.
     *
     * @param options
     *            connection options @see {@link ConnectionOptions}.
     */
    public Bootstrap(@NonNull ConnectionOptions options) {
        super(options);
        endpoint = new EndPoints(this.client);
    }

    /**
     * Uploads a pre-shared key (PSK) for a device to allow it to bootstrap.
     * <p>
     * Note: The existing key will not be overwritten but needs to be deleted first in case of re-setting PSK for a
     * device.
     * <p>
     * Warning: The PSK APIs are available only to accounts that have this feature enabled.
     *
     * @param key
     *            key to upload
     * @return uploaded key
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public PreSharedKey uploadPreSharedKey(@NonNull PreSharedKey key) throws MbedCloudException {
        checkNotNull(key, TAG_KEY);
        checkModelValidity(key, TAG_KEY);
        final PreSharedKey finalkey = key;
        CloudCaller.call(this, "uploadPreSharedKey()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getPresharedKeys().uploadPreSharedKey(PreSharedKeyAdapter.reverseMap(finalkey));
            }
        });
        return finalkey;
    }

    /**
     * Uploads a pre-shared key (PSK) for a device to allow it to bootstrap.
     * <p>
     * Note: Similar to {@link #uploadPreSharedKey(PreSharedKey)}
     *
     * @param key
     *            key to upload
     * @return uploaded key
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public PreSharedKey addPsk(@NonNull PreSharedKey key) throws MbedCloudException {
        return uploadPreSharedKey(key);
    }

    /**
     * Checks whether a pre-shared key exists or not.
     *
     * @param key
     *            key to verify the existence of.
     * @return True if the key exists. False otherwise.
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public boolean checkIfPreSharedKeyExists(@NonNull PreSharedKey key) throws MbedCloudException {
        checkNotNull(key, TAG_KEY);
        checkModelValidity(key, TAG_KEY);
        final PreSharedKey finalkey = key;
        try {
            CloudCaller.call(this, "checkIfPreSharedKeyExists()", null, new CloudCall<PreSharedKeyWithoutSecret>() {

                @Override
                public Call<PreSharedKeyWithoutSecret> call() {
                    return endpoint.getPresharedKeys().getPreSharedKey(finalkey.getId());
                }
            }, true);
            return true;
        } catch (MbedCloudException exception) {
            return false;
        }
    }

    /**
     * Checks whether a pre-shared key exists or not.
     *
     * @param key
     *            key to verify the existence of.
     * @return True if the key exists. False otherwise.
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public boolean checkIfPreSharedKeyExists(@NonNull String key) throws MbedCloudException {
        checkNotNull(key, TAG_KEY_ID);
        return checkIfPreSharedKeyExists(new PreSharedKey(key));
    }

    /**
     * Gets a pre-shared key existing in the cloud.
     *
     * @param key
     *            key to retrieve.
     * @return the corresponding key or null if not existing in the cloud.
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    @Nullable
    public PreSharedKey getPreSharedKey(@NonNull PreSharedKey key) throws MbedCloudException {
        checkNotNull(key, TAG_KEY);
        checkModelValidity(key, TAG_KEY);
        final PreSharedKey finalkey = key;
        return CloudCaller.call(this, "getPreSharedKey()", PreSharedKeyAdapter.getMapper(),
                new CloudCall<PreSharedKeyWithoutSecret>() {

                    @Override
                    public Call<PreSharedKeyWithoutSecret> call() {
                        return endpoint.getPresharedKeys().getPreSharedKey(finalkey.getId());
                    }
                }, false);
    }

    /**
     * Gets a pre-shared key existing in the cloud.
     *
     * @param key
     *            key to get.
     * @return the corresponding key or null if not existing in the cloud.
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    @Nullable
    public PreSharedKey getPreSharedKey(@NonNull String key) throws MbedCloudException {
        checkNotNull(key, TAG_KEY_ID);
        return getPreSharedKey(new PreSharedKey(key));
    }

    /**
     * Gets a pre-shared key existing in the cloud.
     * <p>
     * Note: Similar to {@link #getPreSharedKey(PreSharedKey)}
     *
     * @param key
     *            key to verify the existence of.
     * @return the corresponding key or null if not existing in the cloud.
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    @Nullable
    public PreSharedKey getPsk(@NonNull PreSharedKey key) throws MbedCloudException {
        return getPreSharedKey(key);
    }

    /**
     * Gets a pre-shared key existing in the cloud.
     * <p>
     * Note: Similar to {@link #getPreSharedKey(String)}
     *
     * @param key
     *            key to get.
     * @return the corresponding key or null if not existing in the cloud.
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    @Nullable
    public PreSharedKey getPsk(@NonNull String key) throws MbedCloudException {
        return getPreSharedKey(key);
    }

    /**
     * Deletes pre-shared key.
     *
     * @param key
     *            key to delete
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public void deletePreSharedKey(@NonNull String key) throws MbedCloudException {
        checkNotNull(key, TAG_KEY_ID);
        final String finalKey = key;
        CloudCaller.call(this, "deletePreSharedKey()", null, new CloudCall<Void>() {

            @Override
            public Call<Void> call() {
                return endpoint.getPresharedKeys().deletePreSharedKey(finalKey);
            }
        });

    }

    /**
     * Deletes pre-shared key.
     *
     * @param key
     *            key to delete
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public void deletePreSharedKey(@NonNull PreSharedKey key) throws MbedCloudException {
        checkNotNull(key, TAG_KEY);
        final String finalKey = key.getId();
        deletePreSharedKey(finalKey);
    }

    /**
     * // * Deletes pre-shared key.
     * <p>
     * Note: Similar to {@link #deletePreSharedKey(String)}
     *
     * @param key
     *            key to delete
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public void deletePsk(@NonNull String key) throws MbedCloudException {
        deletePreSharedKey(key);

    }

    /**
     * Deletes pre-shared key.
     * <p>
     * Note: Similar to {@link #deletePreSharedKey(PreSharedKey)}
     *
     * @param key
     *            key to delete
     * @throws MbedCloudException
     *             if an error occurred during the process
     */
    @API
    public void deletePsk(@NonNull PreSharedKey key) throws MbedCloudException {
        deletePreSharedKey(key);
    }

    /**
     * Retrieves module name.
     *
     * @return module name.
     */
    @Override
    public String getModuleName() {
        return "Bootstrap";
    }
}
