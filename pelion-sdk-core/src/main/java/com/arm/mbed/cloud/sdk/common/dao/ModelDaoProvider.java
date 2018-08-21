package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Utilities for fetching DAOs corresponding to a certain Model using reflection")
public final class ModelDaoProvider {

    private static final String UNCHECKED = "unchecked";
    private static final String DAO_SUFFIX = "Dao";
    private static final String LIST_DAO_SUFFIX = "List" + DAO_SUFFIX;

    private ModelDaoProvider() {
        // Nothing to do.
    }

    /**
     * Gets the class of the Model DAO corresponding to {@code modelType}.
     *
     * @param modelType
     *            type of the data model
     * @param <T>
     *            model type
     * @return the class of the corresponding DAO; null if no DAO was found for this data model type
     */
    @SuppressWarnings({ UNCHECKED, "static-access" })
    public @Nullable static <T extends SdkModel> Class<? extends ModelDao<T>> getCorrespondingDao(Class<T> modelType) {
        try {
            return modelType == null ? null
                                     : (Class<? extends ModelDao<T>>) ModelDaoProvider.class.forName(modelType.getName()
                                                                                                     + DAO_SUFFIX);
        } catch (ClassNotFoundException exception) {
            return null;
        }
    }

    /**
     * Gets an instance of the Model DAO corresponding to this {@code model}.
     *
     * @param model
     *            data model
     * @param <T>
     *            model type
     * @param <U>
     *            model DAO type
     * @return an instance of the corresponding DAO; null if no DAO was found for this data model
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    public @Nullable static <T extends SdkModel, U extends ModelDao<T>> U
           getCorrespondingDao(T model) throws MbedCloudException {
        if (model == null) {
            return null;
        }
        @SuppressWarnings(UNCHECKED)
        final Class<U> daoClass = (Class<U>) getCorrespondingDao(model.getClass());
        if (daoClass == null) {
            return null;
        }
        try {
            final U dao = daoClass.newInstance();
            dao.setModel(model);
            return dao;
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }
    }

    /**
     * Gets the class of the Model List DAO corresponding to {@code modelType}.
     *
     * @param modelType
     *            type of the data model
     * @param <T>
     *            model type
     * @return the class of the corresponding Model List DAO; null if no Model List DAO was found for this data model
     *         type
     */
    @SuppressWarnings({ "static-access", UNCHECKED })
    public @Nullable static <T extends SdkModel> Class<? extends ModelListDao<T, ? extends ListOptions>>
           getCorrespondingListDao(Class<T> modelType) {
        try {
            return modelType == null ? null
                                     : (Class<? extends ModelListDao<T,
                                                                     ? extends ListOptions>>) ModelDaoProvider.class.forName(modelType.getName()
                                                                                                                             + LIST_DAO_SUFFIX);
        } catch (ClassNotFoundException exception) {
            return null;
        }
    }

    /**
     * Gets an instance of the Model List DAO corresponding to this {@code modelType}.
     *
     * @param modelType
     *            data model type
     * @param <T>
     *            model type
     * @param <U>
     *            list options type
     * @param <V>
     *            list DAO type
     * @param options
     *            list options
     * @return an instance of the corresponding Model List DAO; null if no Model List DAO was found for this data model
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    public @Nullable static <T extends SdkModel, U extends ListOptions, V extends ModelListDao<T, U>> V
           getCorrespondingListDao(Class<T> modelType, @Nullable U options) throws MbedCloudException {
        if (modelType == null) {
            return null;
        }
        @SuppressWarnings(UNCHECKED)
        final Class<V> listDaoClass = (Class<V>) getCorrespondingListDao(modelType);
        if (listDaoClass == null) {
            return null;
        }
        try {
            final V listDao = listDaoClass.newInstance();
            listDao.setListOptions(options);
            return listDao;
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }
    }

}
