package com.arm.mbed.cloud.sdk.connect.adapters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.filtering.FilterOperator;
import com.arm.mbed.cloud.sdk.connect.model.Presubscription;
import com.arm.mbed.cloud.sdk.internal.mds.model.PresubscriptionArray;
import com.arm.mbed.cloud.sdk.subscribe.model.SubscriptionFilterOptions;

@Preamble(description = "Adapter for presubscription model")
public final class PresubscriptionAdapter {

    private static final Pattern RESOURCE_PATH_ACCEPTED_LIKE_FILTER_PATTERN = Pattern
            .compile("[\\p{Alnum}\\\\/]+((\\.?\\*)|[_%\\?])?");
    private static final Pattern DEVICE_ID_ACCEPTED_LIKE_FILTER_PATTERN = Pattern
            .compile("[\\p{Alnum} \\.-]+((\\.?\\*)|[_%\\?])?");

    private PresubscriptionAdapter() {
        super();
    }

    /**
     * Maps a subscription filter to corresponding pre-subscriptions.
     *
     * @param options
     *            filter options
     * @return corresponding pre-subscriptions.
     */
    public static List<Presubscription> mapSubscriptionFilter(SubscriptionFilterOptions options) {
        if (options == null) {
            return null;
        }
        final List<Presubscription> list = new LinkedList<>();
        boolean hadEnpointNameFilter = false;
        if (options.hasFilter(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.IN)) {
            hadEnpointNameFilter = true;
            mapDeviceIn(options, list);
        }
        if (options.hasFilter(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.EQUAL)) {
            hadEnpointNameFilter = true;
            mapDeviceEqual(options, list);

        }
        if (options.hasFilter(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.LIKE)) {
            hadEnpointNameFilter = true;
            mapDeviceLike(options, list);
        }

        if (!hadEnpointNameFilter && options.hasFilters(SubscriptionFilterOptions.RESOURCE_PATH_FILTER)) {
            mapResourcePath(options, list);
        }
        // TODO endpoint type

        if (list.isEmpty()) {
            list.add(Presubscription.TO_EVERYTHING);
        }
        return list;

    }

    private static void mapResourcePath(SubscriptionFilterOptions options, final List<Presubscription> list) {
        final Presubscription presubscription = new Presubscription();
        mapPresubscriptionResourcePath(options, presubscription);
        if (presubscription.isValid()) {
            list.add(presubscription);
        }
    }

    private static void mapDeviceLike(SubscriptionFilterOptions options, final List<Presubscription> list) {
        final Presubscription presubscription = new Presubscription();
        mapPresubscriptionResourcePath(options, presubscription);
        presubscription.setDeviceId(mapLikeDeviceIdPath((String) options
                .fetchSpecificFilterValue(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.LIKE)));
        if (presubscription.isValid()) {
            list.add(presubscription);
        }
    }

    private static void mapDeviceEqual(SubscriptionFilterOptions options, final List<Presubscription> list) {
        final Presubscription presubscription = new Presubscription();
        presubscription.setDeviceId((String) options
                .fetchSpecificFilterValue(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.EQUAL));
        mapPresubscriptionResourcePath(options, presubscription);
        list.add(presubscription);
    }

    private static void mapDeviceIn(SubscriptionFilterOptions options, final List<Presubscription> list) {
        final Presubscription presubscription = new Presubscription();
        mapPresubscriptionResourcePath(options, presubscription);
        @SuppressWarnings("unchecked")
        final List<String> deviceIds = (List<String>) options
                .fetchSpecificFilterValue(SubscriptionFilterOptions.DEVICE_ID_FILTER, FilterOperator.IN);
        for (final String deviceId : deviceIds) {
            list.add(presubscription.clone().deviceId(deviceId));
        }
    }

    @SuppressWarnings("unchecked")
    protected static void mapPresubscriptionResourcePath(SubscriptionFilterOptions options,
            Presubscription presubscription) {
        if (options.hasFilters(SubscriptionFilterOptions.RESOURCE_PATH_FILTER)) {
            if (options.hasFilter(SubscriptionFilterOptions.RESOURCE_PATH_FILTER, FilterOperator.IN)) {
                final List<String> resourcePaths = (List<String>) options
                        .fetchSpecificFilterValue(SubscriptionFilterOptions.RESOURCE_PATH_FILTER, FilterOperator.IN);
                for (final String resourcePath : resourcePaths) {
                    presubscription.addResourcePath(resourcePath);
                }
            }
            if (options.hasFilter(SubscriptionFilterOptions.RESOURCE_PATH_FILTER, FilterOperator.EQUAL)) {
                presubscription.addResourcePath((String) options.fetchSpecificFilterValue(
                        SubscriptionFilterOptions.RESOURCE_PATH_FILTER, FilterOperator.EQUAL));
            }
            if (options.hasFilter(SubscriptionFilterOptions.RESOURCE_PATH_FILTER, FilterOperator.LIKE)) {
                mapPresubscriptionLikeResourcePath(options, presubscription);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void mapPresubscriptionLikeResourcePath(SubscriptionFilterOptions options,
            Presubscription presubscription) {
        final Object filterValue = options.fetchSpecificFilterValue(SubscriptionFilterOptions.RESOURCE_PATH_FILTER,
                FilterOperator.LIKE);
        if (filterValue instanceof List) {
            mapLikeResourcePaths(presubscription, (List<String>) filterValue);
        } else if (filterValue.getClass().isArray()) {
            mapLikeResourcePaths(presubscription, Arrays.asList((String[]) filterValue));
        } else {
            final String likeFilter = mapLikeResourcePath((String) filterValue);
            if (likeFilter != null) {
                presubscription.addResourcePath(likeFilter);
            }

        }
    }

    protected static void mapLikeResourcePaths(final Presubscription presubscription, final List<String> filterValues) {
        boolean needsSpecifying = true;
        final List<String> likeFilters = new LinkedList<>();
        for (final String value : filterValues) {
            final String correspondingPresubscriptionEntry = mapLikeResourcePath(value);
            if (correspondingPresubscriptionEntry == null) {
                needsSpecifying = false;
            } else {
                likeFilters.add(correspondingPresubscriptionEntry);
            }
        }
        if (needsSpecifying) {
            for (final String correspondingPresubscriptionEntry : likeFilters) {
                presubscription.addResourcePath(correspondingPresubscriptionEntry);
            }
        }
    }

    protected static String mapLikeResourcePath(String filterValueString) {
        return mapLikeField(filterValueString, RESOURCE_PATH_ACCEPTED_LIKE_FILTER_PATTERN);
    }

    protected static String mapLikeDeviceIdPath(String filterValueString) {
        return mapLikeField(filterValueString, DEVICE_ID_ACCEPTED_LIKE_FILTER_PATTERN);
    }

    protected static String mapLikeField(String filterValueString, Pattern resourcePathSubstringPattern) {
        String presubscriptionValueString = null;
        if (resourcePathSubstringPattern.matcher(filterValueString).matches()) {
            presubscriptionValueString = filterValueString.replace(".*", "*").replace(".", "*").replace("_", "*")
                    .replace("%", "*").replace("?", "*");
            if (!presubscriptionValueString.contains("*")) {
                final StringBuffer buffer = new StringBuffer();
                buffer.append(presubscriptionValueString).append('*');
                presubscriptionValueString = buffer.toString();
            }
        }
        return presubscriptionValueString;
    }

    /**
     * Maps presubscription.
     *
     * @param apiPresubscription
     *            presubscription to map
     * @return mapped presubscription
     */
    public static Presubscription map(com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription apiPresubscription) {
        if (apiPresubscription == null) {
            return null;
        }
        final Presubscription presubscription = new Presubscription();
        presubscription.setDeviceId(apiPresubscription.getEndpointName());
        presubscription.setDeviceType(apiPresubscription.getEndpointType());
        presubscription.setResourcePaths(apiPresubscription.getResourcePath());
        return presubscription;
    }

    /**
     * Reverses mapping of a presubscription.
     *
     * @param presubscription
     *            presubscription
     * @return presubscription
     */
    public static com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription reverseMap(
            Presubscription presubscription) {
        if (presubscription == null) {
            return null;
        }
        final com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription apiPresubscription = new com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription();
        apiPresubscription.setEndpointName(presubscription.getDeviceId());
        apiPresubscription.setEndpointType(presubscription.getDeviceType());
        apiPresubscription.setResourcePath(presubscription.getResourcePaths());
        return apiPresubscription;
    }

    /**
     * Gets mapper.
     *
     * @return mapper
     */
    public static Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription, Presubscription> getMapper() {
        return new Mapper<com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription, Presubscription>() {

            @Override
            public Presubscription map(com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription toBeMapped) {
                return PresubscriptionAdapter.map(toBeMapped);
            }

        };
    }

    /**
     * Gets reverse mapper.
     *
     * @return reverse mapper
     */
    public static Mapper<Presubscription, com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription> getReverseMapper() {
        return new Mapper<Presubscription, com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription>() {

            @Override
            public com.arm.mbed.cloud.sdk.internal.mds.model.Presubscription map(Presubscription toBeMapped) {
                return PresubscriptionAdapter.reverseMap(toBeMapped);
            }

        };
    }

    /**
     * Maps list of presubscriptions.
     *
     * @param list
     *            of presubscription.
     * @return list of presubscription
     */
    public static List<Presubscription> mapList(PresubscriptionArray list) {
        if (list == null) {
            return null;
        }
        return GenericAdapter.mapList(list, PresubscriptionAdapter.getMapper());
    }

    /**
     * Maps list of presubscriptions to a registry.
     *
     * @param list
     *            of presubscription.
     * @return a registry of presubscription
     */
    public static GenericAdapter.MappedObjectRegistry<Presubscription> mapListToRegistry(PresubscriptionArray list) {
        return new GenericAdapter.MappedObjectRegistry<>(list, PresubscriptionAdapter.getMapper());
    }

    /**
     * Reverses mapping of a list of presubscriptions.
     *
     * @param list
     *            of presubscription.
     * @return list of presubscription
     */
    public static PresubscriptionArray reverseMapList(List<Presubscription> list) {
        return (PresubscriptionArray) GenericAdapter.mapList(list, new PresubscriptionArray(), getReverseMapper());
    }

    /**
     * Gets list mapper.
     *
     * @return a list mapper
     */
    public static Mapper<PresubscriptionArray, List<Presubscription>> getListMapper() {
        return new Mapper<PresubscriptionArray, List<Presubscription>>() {

            @Override
            public List<Presubscription> map(PresubscriptionArray toBeMapped) {
                return PresubscriptionAdapter.mapList(toBeMapped);
            }

        };
    }

    /**
     * Gets list to registry mapper.
     *
     * @return a list to registry mapper
     */
    public static Mapper<PresubscriptionArray, GenericAdapter.MappedObjectRegistry<Presubscription>> getListToRegistryMapper() {
        return new Mapper<PresubscriptionArray, GenericAdapter.MappedObjectRegistry<Presubscription>>() {

            @Override
            public GenericAdapter.MappedObjectRegistry<Presubscription> map(PresubscriptionArray toBeMapped) {
                return PresubscriptionAdapter.mapListToRegistry(toBeMapped);
            }

        };
    }

    /**
     * Gets a list of resource path from a string.
     *
     * @param list
     *            string containing resource paths.
     * @return list of resource paths
     */
    public static List<String> mapResourcePathList(String list) {
        if (list == null) {
            return null;
        }
        final String listString = list.replace("\r", "");
        return TranslationUtils.parseList(listString, "\n");
    }

    /**
     * Gets resource path list mapper.
     *
     * @return a list of resource path
     */
    public static Mapper<String, List<String>> getResourcePathListMapper() {
        return new Mapper<String, List<String>>() {

            @Override
            public List<String> map(String toBeMapped) {
                return mapResourcePathList(toBeMapped);
            }

        };
    }

}
