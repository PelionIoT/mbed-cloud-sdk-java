package com.arm.mbed.cloud.sdk.subscribe.model;

import java.util.LinkedList;
import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.listing.FilterOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FiltersEvaluator;
import com.arm.mbed.cloud.sdk.connect.model.Resource;
import com.arm.mbed.cloud.sdk.devicedirectory.model.Device;

@Preamble(description = "Options to filter notifications")
public class SubscriptionFilterOptions extends FilterOptions {
    /**
     * Tag of filter by device id.
     */
    public static final String DEVICE_ID_FILTER = "deviceId";
    /**
     * Tag of filter by device state.
     */
    public static final String DEVICE_TYPE_FILTER = "deviceType";
    /**
     * Tag of filter by resource path.
     */
    public static final String RESOURCE_PATH_FILTER = "resourcePath";

    /**
     * Creates a new filter.
     *
     * @return a newly created filter.
     */
    public static SubscriptionFilterOptions newFilter() {
        return new SubscriptionFilterOptions();
    }

    /**
     * Constructor.
     */
    public SubscriptionFilterOptions() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param filter
     *            the filter to set
     */
    public SubscriptionFilterOptions(Filters filter) {
        super(filter);
    }

    /**
     * Adds a "Like" filter on device ids.
     *
     * @see #addLikeFilter(String, Object)
     * @param deviceIdlike
     *            like filter on device Id: it can be a substring, a Java Regex or an SQL like entry
     */
    public void addLikeDeviceFilter(@Nullable String deviceIdlike) {
        addLikeFilter(DEVICE_ID_FILTER, deviceIdlike == null ? null : deviceIdlike);
    }

    /**
     * Creates a "Like" filter on device ids.
     *
     * @see #addLikeFilter(String, Object)
     * @param deviceIdlike
     *            like filter on device Id: it can be a substring, a Java Regex or an SQL like entry
     * @return this filter
     */
    public SubscriptionFilterOptions likeDevice(@Nullable String deviceIdlike) {
        addLikeDeviceFilter(deviceIdlike);
        return this;
    }

    /**
     * Adds an "Equal" filter related to a device id.
     *
     * @param deviceId
     *            device id to consider.
     */
    public void addEqualDeviceFilter(@Nullable String deviceId) {
        addEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    /**
     * Adds an "Equal" filter related to a device.
     * <p>
     * Similar to {@link #addEqualDeviceFilter(String)}
     *
     * @param device
     *            device to consider.
     */
    public void addEqualDeviceFilter(@Nullable Device device) {
        addEqualDeviceFilter(device == null ? null : device.getId());
    }

    /**
     * Creates an "Equal" filter related to a device.
     * <p>
     * Similar to {@link #addEqualDeviceFilter(String)}
     *
     * @param deviceId
     *            device id to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions equalDevice(@Nullable String deviceId) {
        addEqualDeviceFilter(deviceId);
        return this;
    }

    /**
     * Creates an "Equal" filter related to a device.
     *
     * Similar to {@link #addEqualDeviceFilter(Device)}
     *
     * @param device
     *            device to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions equalDevice(@Nullable Device device) {
        addEqualDeviceFilter(device);
        return this;
    }

    /**
     * Adds a "Not equal" filter related to a device id.
     *
     * @param deviceId
     *            device id to consider.
     */
    public void addNotEqualDeviceFilter(@Nullable String deviceId) {
        addNotEqualFilter(DEVICE_ID_FILTER, deviceId == null ? null : deviceId);
    }

    /**
     * Adds a "Not equal" filter related to a device.
     *
     * Similar to {@link #addNotEqualDeviceFilter(String)}
     *
     * @param device
     *            device to consider.
     */
    public void addNotEqualDeviceFilter(@Nullable Device device) {
        addNotEqualDeviceFilter(device == null ? null : device.getId());
    }

    /**
     * Creates a "Not equal" filter related to a device. *
     * <p>
     * Similar to {@link #addNotEqualDeviceFilter(String)}
     *
     * @param deviceId
     *            device id to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notEqualDevice(@Nullable String deviceId) {
        addNotEqualDeviceFilter(deviceId);
        return this;
    }

    /**
     * Creates a "Not equal" filter related to a device. *
     * <p>
     * Similar to {@link #addNotEqualDeviceFilter(Device)}
     *
     * @param device
     *            device to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notEqualDevice(@Nullable Device device) {
        addNotEqualDeviceFilter(device);
        return this;
    }

    /**
     * Adds an "In" filter related to device ids.
     *
     * @param deviceIds
     *            device ids to consider.
     */
    public void addInDeviceIdsFilter(@NonNull List<String> deviceIds) {
        addInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    /**
     * Adds an "In" filter related to devices.
     *
     * @param devices
     *            devices to consider.
     */
    public void addInDevicesFilter(@NonNull List<Device> devices) {
        if (devices == null) {
            return;
        }
        final List<String> values = new LinkedList<>();
        for (final Device device : devices) {
            values.add(device.getId());
        }
        addInDeviceIdsFilter(values);
    }

    /**
     * Adds an "In" filter related to device ids.
     *
     * @param deviceIds
     *            comma separated list of device ids.
     */
    public void addInDevicesFilter(@NonNull String deviceIds) {
        addInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    /**
     * Creates an "In" filter related to device ids.
     * <p>
     * Similar to {@link #addInDeviceIdsFilter(List)}
     *
     * @param deviceIds
     *            device ids to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions inDeviceIds(@NonNull List<String> deviceIds) {
        addInDeviceIdsFilter(deviceIds);
        return this;
    }

    /**
     * Creates an "In" filter related to device ids.
     *
     * @see #addInDevicesFilter(String)
     *
     * @param deviceIds
     *            comma separated list of device ids.
     * @return this filter
     */
    public SubscriptionFilterOptions inDeviceIds(@NonNull String deviceIds) {
        addInDevicesFilter(deviceIds);
        return this;
    }

    /**
     * Creates an "In" filter related to devices.
     * <p>
     * Similar to {@link #addInDevicesFilter(List)}
     *
     * @param devices
     *            devices to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions inDevices(@NonNull List<Device> devices) {
        addInDevicesFilter(devices);
        return this;
    }

    /**
     * Adds a "Not in" filter related to device ids.
     *
     * @param deviceIds
     *            device ids to consider.
     */
    public void addNotInDeviceIdsFilter(@NonNull List<String> deviceIds) {
        addNotInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    /**
     * Adds a "Not in" filter related to devices.
     *
     * @param devices
     *            devices to consider.
     */
    public void addNotInDevicesFilter(@NonNull List<Device> devices) {
        if (devices == null) {
            return;
        }
        final List<String> values = new LinkedList<>();
        for (final Device device : devices) {
            values.add(device.getId());
        }
        addNotInDeviceIdsFilter(values);
    }

    /**
     * Adds a "Not in" filter related to devices.
     *
     * @param deviceIds
     *            deviceIds comma separated list of device ids.
     */
    public void addNotInDevicesFilter(@NonNull String deviceIds) {
        addNotInFilter(DEVICE_ID_FILTER, deviceIds);
    }

    /**
     * Creates a "Not in" filter related to device ids.
     * <p>
     * Similar to {@link #addNotInDeviceIdsFilter(List)}
     *
     * @param deviceIds
     *            device ids to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notInDeviceIds(@NonNull List<String> deviceIds) {
        addNotInDeviceIdsFilter(deviceIds);
        return this;
    }

    /**
     * Creates a "Not in" filter related to devices.
     *
     * @see #addNotInDevicesFilter(String)
     *
     * @param deviceIds
     *            comma separated list of device ids.
     * @return this filter
     */
    public SubscriptionFilterOptions notInDeviceIds(@NonNull String deviceIds) {
        addNotInDevicesFilter(deviceIds);
        return this;
    }

    /**
     * Creates a "Not in" filter related to devices.
     * <p>
     * Similar to {@link #addNotInDevicesFilter(List)}
     *
     * @param devices
     *            devices to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notInDevices(@NonNull List<Device> devices) {
        addNotInDevicesFilter(devices);
        return this;
    }

    // TODO device type
    /**
     * Adds a "Like" filter on resource path.
     *
     * @see #addLikeFilter(String, Object)
     * @param resourcePath
     *            like filter on resource path: it can be a substring, a Java Regex or an SQL like entry
     */
    public void addLikeResourcePathFilter(@Nullable String resourcePath) {
        addLikeFilter(RESOURCE_PATH_FILTER, resourcePath == null ? null : resourcePath);
    }

    /**
     * Creates a "Like" filter on resource path.
     *
     * <p>
     * Similar to {@link #addLikeResourcePathFilter(String)}
     *
     * @param resourcePath
     *            like filter on resource path: it can be a substring, a Java Regex or an SQL like entry
     * @return this filter
     */
    public SubscriptionFilterOptions likeResourcePath(@Nullable String resourcePath) {
        addLikeResourcePathFilter(resourcePath);
        return this;
    }

    /**
     * Adds a "Like" filter on multiple resource paths.
     *
     * <p>
     * Similar to {@link #addLikeResourcePathFilter(String)} but applied to multiple filters.
     *
     * @param resourcePaths
     *            list of like filters on resource path: it can be a list of substrings, a list of Java Regexes, a list
     *            of SQL like entries or any combination of them. the filter behaves like an OR of LIKE filters
     */
    public void addLikeResourcePathsFilter(@NonNull List<String> resourcePaths) {
        addLikeFilter(RESOURCE_PATH_FILTER, resourcePaths);
    }

    /**
     * Creates a "Like" filter on multiple resource paths.
     *
     *
     * Similar to {@link #addLikeResourcePathsFilter(List)}
     *
     * @param resourcePaths
     *            list of like filters on resource path: it can be a list of substrings, a list of Java Regexes, a list
     *            of SQL like entries or any combination of them. the filter behaves like an OR of LIKE filters.
     * @return this filter
     */
    public SubscriptionFilterOptions likeResourcePaths(@NonNull List<String> resourcePaths) {
        addLikeResourcePathsFilter(resourcePaths);
        return this;
    }

    /**
     * Adds an "Equal" filter related to a resource path.
     *
     * @param resourcePath
     *            resource path to consider.
     */
    public void addEqualResourcePathFilter(@Nullable String resourcePath) {
        addEqualFilter(RESOURCE_PATH_FILTER, resourcePath == null ? null : resourcePath);
    }

    /**
     * Adds an "Equal" filter related to a resource.
     *
     * Similar to {@link #addEqualDeviceFilter(String)} AND {@link #addEqualResourcePathFilter(String)}
     *
     * @param resource
     *            resource to consider.
     */
    public void addEqualResourceFilter(@Nullable Resource resource) {
        addEqualDeviceFilter(resource == null ? null : resource.getDeviceId());
        addEqualResourcePathFilter(resource == null ? null : resource.getPath());
    }

    /**
     * Creates an "Equal" filter related to a resource path.
     *
     * Similar to {@link #addEqualResourcePathFilter(String)}
     *
     * @param resourcePath
     *            resource path to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions equalResourcePath(@Nullable String resourcePath) {
        addEqualResourcePathFilter(resourcePath);
        return this;
    }

    /**
     * Creates an "Equal" filter related to a resource.
     *
     * Similar to {@link #addEqualResourceFilter(Resource)}
     *
     * @param resource
     *            resource to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions equalResource(@Nullable Resource resource) {
        addEqualResourceFilter(resource);
        return this;
    }

    /**
     * Adds an "Not equal" filter related to a resource path.
     *
     * @param resourcePath
     *            resource path to consider.
     */
    public void addNotEqualResourcePathFilter(@Nullable String resourcePath) {
        addNotEqualFilter(RESOURCE_PATH_FILTER, resourcePath == null ? null : resourcePath);
    }

    /**
     * Adds a "Not equal" filter related to a resource.
     * <p>
     * Similar to {@link #addNotEqualDeviceFilter(String)} AND {@link #addNotEqualResourcePathFilter(String)}
     *
     * @param resource
     *            resource to consider.
     */
    public void addNotEqualResourceFilter(@Nullable Resource resource) {
        addNotEqualDeviceFilter(resource == null ? null : resource.getDeviceId());
        addNotEqualResourcePathFilter(resource == null ? null : resource.getPath());
    }

    /**
     * Creates an "Not equal" filter related to a resource path.
     *
     * Similar to {@link #addNotEqualResourcePathFilter(String)}
     *
     * @param resourcePath
     *            resource path to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notEqualResourcePath(@Nullable String resourcePath) {
        addNotEqualResourcePathFilter(resourcePath);
        return this;
    }

    /**
     * Creates an "Not equal" filter related to a resouce.
     *
     * Similar to {@link #addNotEqualResourceFilter(Resource)}
     *
     * @param resource
     *            resource to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notEqualResource(@Nullable Resource resource) {
        addNotEqualResourceFilter(resource);
        return this;
    }

    /**
     * Adds an "In" filter related to resource paths.
     *
     * @param resourcePaths
     *            resource paths to consider.
     */
    public void addInResourcePathsFilter(@NonNull List<String> resourcePaths) {
        addInFilter(RESOURCE_PATH_FILTER, resourcePaths);
    }

    /**
     * Adds an "In" filter related to resource paths.
     *
     * @param resourcePaths
     *            comma separated list of resource paths.
     */
    public void addInResourcePathsFilter(@NonNull String resourcePaths) {
        addInFilter(RESOURCE_PATH_FILTER, resourcePaths);
    }

    /**
     * Adds an "In" filter related to resources.
     * <p>
     * Similar to {@link #addInDeviceIdsFilter(List)} AND {@link #addInResourcePathsFilter(List)}.
     * <p>
     * Warning: this filter would be verified for any resource which has a device Id and a resource path present in the
     * pool of device ids and resource paths defined by the list of resources. Therefore, this is not exactly a filter
     * "IN resources present in the list defined below".
     *
     * @param resources
     *            resources to consider.
     */
    public void addInResourcesFilter(@NonNull List<Resource> resources) {
        if (resources == null) {
            return;
        }
        final List<String> deviceIds = new LinkedList<>();
        final List<String> resourcePaths = new LinkedList<>();
        for (final Resource resource : resources) {
            deviceIds.add(resource.getDeviceId());
            resourcePaths.add(resource.getPath());
        }
        addInDeviceIdsFilter(deviceIds);
        addInResourcePathsFilter(resourcePaths);
    }

    /**
     * Creates an "In" filter related to resource paths.
     * <p>
     * Similar to {@link #addInResourcePathsFilter(List)}
     *
     * @param resourcePaths
     *            resource paths to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions inResourcePaths(@NonNull List<String> resourcePaths) {
        addInResourcePathsFilter(resourcePaths);
        return this;
    }

    /**
     * Creates an "In" filter related to resource paths.
     * <p>
     * Similar to {@link #addInResourcePathsFilter(String)}
     *
     * @param resourcePaths
     *            comma separated list of resource paths.
     * @return this filter
     */
    public SubscriptionFilterOptions inResourcePaths(@NonNull String resourcePaths) {
        addInResourcePathsFilter(resourcePaths);
        return this;
    }

    /**
     * Creates an "In" filter related to resources.
     * <p>
     * Similar to {@link #addInResourcesFilter(List)} *
     * <p>
     * Equivalent to {@link #addInDeviceIdsFilter(List)} AND {@link #addInResourcePathsFilter(List)}.
     * <p>
     * Warning: this filter would be verified for any resource which has a device Id and a resource path present in the
     * pool of device ids and resource paths defined by the list of resources. Therefore, this is not exactly a filter
     * "IN resources present in the list defined below".
     *
     * @param resources
     *            resources to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions inResources(@NonNull List<Resource> resources) {
        addInResourcesFilter(resources);
        return this;
    }

    /**
     * Adds a "Not in" filter related to resource paths.
     *
     * @param resourcePaths
     *            resource paths to consider.
     */
    public void addNotInResourcePathsFilter(@NonNull List<String> resourcePaths) {
        addNotInFilter(RESOURCE_PATH_FILTER, resourcePaths);
    }

    /**
     * Adds a "Not in" filter related to resource paths.
     *
     * @param resourcePaths
     *            comma separated list of resource paths.
     */
    public void addNotInResourcePathsFilter(@NonNull String resourcePaths) {
        addNotInFilter(RESOURCE_PATH_FILTER, resourcePaths);
    }

    /**
     * Adds a "Not in" filter related to resources. *
     * <p>
     * Similar to {@link #addNotInDeviceIdsFilter(List)} AND {@link #addNotInResourcePathsFilter(List)}.
     * <p>
     * Warning: this filter would be verified for any resource which has a device Id and a resource path which are both
     * not present in the pool of device ids and resource paths defined by the list of resources below. Therefore, this
     * is not exactly a filter " NOT IN resources present in the list defined below".
     *
     * @param resources
     *            resources to consider.
     */
    public void addNotInResourcesFilter(@NonNull List<Resource> resources) {
        if (resources == null) {
            return;
        }
        final List<String> deviceIds = new LinkedList<>();
        final List<String> resourcePaths = new LinkedList<>();
        for (final Resource resource : resources) {
            deviceIds.add(resource.getDeviceId());
            resourcePaths.add(resource.getPath());
        }
        addNotInDeviceIdsFilter(deviceIds);
        addNotInResourcePathsFilter(resourcePaths);
    }

    /**
     * Creates a "Not in" filter related to resource paths.
     * <p>
     * Similar to {@link #addNotInResourcePathsFilter(List)}
     *
     * @param resourcePaths
     *            resource paths to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notInResourcePaths(@NonNull List<String> resourcePaths) {
        addNotInResourcePathsFilter(resourcePaths);
        return this;
    }

    /**
     * Creates a "Not in" filter related to resource paths.
     *
     * @see #addNotInResourcePathsFilter(String)
     *
     * @param resourcePaths
     *            comma separated list of resource paths.
     * @return this filter
     */
    public SubscriptionFilterOptions notInResourcePaths(@NonNull String resourcePaths) {
        addNotInResourcePathsFilter(resourcePaths);
        return this;
    }

    /**
     * Creates a "Not in" filter related to resources.
     * <p>
     * Similar to {@link #addNotInResourcesFilter(List)} *
     * <p>
     * Equivalent to {@link #addNotInDeviceIdsFilter(List)} AND {@link #addNotInResourcePathsFilter(List)}.
     * <p>
     * Warning: this filter would be verified for any resource which has a device Id and a resource path which are both
     * not present in the pool of device ids and resource paths defined by the list of resources below. Therefore, this
     * is not exactly a filter " NOT IN resources present in the list defined below".
     *
     * @param resources
     *            resources to consider.
     * @return this filter
     */
    public SubscriptionFilterOptions notInResources(@NonNull List<Resource> resources) {
        addNotInResourcesFilter(resources);
        return this;
    }

    /**
     * States whether the notification message verifies the filter created or not.
     *
     * @param notification
     *            a notification.
     * @return True if the filter is verified by this notification. False otherwise.
     */
    public boolean isVerified(ResourceValueNotification notification) {
        if (notification == null) {
            return false;
        }
        return evaluateResource(notification.getResource());// TODO && evaluateDeviceType(notification.);
    }

    /**
     * States whether any resource in the list verifies the filter created or not.
     *
     * @param resources
     *            resources to check
     * @return True if at least one resource of the list verifies the filter. False otherwise.
     */
    public boolean isVerified(List<Resource> resources) {
        if (resources == null) {
            return false;
        }
        for (final Resource resource : resources) {
            if (evaluateResource(resource)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the subset of resources which verify the filter.
     *
     * @param resources
     *            resources to check
     * @return subset of resources verifying the filter.
     */
    public List<Resource> getVerifiedResources(List<Resource> resources) {
        if (resources == null) {
            return null;
        }
        final List<Resource> verifiedResources = new LinkedList<>();
        for (final Resource resource : resources) {
            if (evaluateResource(resource)) {
                verifiedResources.add(resource);
            }
        }
        return verifiedResources.isEmpty() ? null : verifiedResources;
    }

    private boolean evaluateResource(Resource resource) {
        if (resource == null) {
            return false;
        }
        return evaluateDeviceId(resource.getDeviceId()) && evaluateResourcePath(resource.getPath());
    }

    private boolean evaluateDeviceId(String deviceId) {
        return FiltersEvaluator.isVerified(filter, DEVICE_ID_FILTER, deviceId);
    }

    private boolean evaluateResourcePath(String resourcePath) {
        return FiltersEvaluator.isVerified(filter, RESOURCE_PATH_FILTER, resourcePath);
    }

    // TODO
    // private boolean evaluateDeviceType(String deviceType) {
    // return FiltersEvaluator.isVerified(filter, DEVICE_TYPE_FILTER, deviceType);
    // }
}
