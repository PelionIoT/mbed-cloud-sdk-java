package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;

@Preamble(description = "Utilities for fetching DAOs corresponding to a certain Model using reflection")
public final class DaoProvider {

    private static final String UNCHECKED = "unchecked";
    /**
     * Naming convention within the SDK is that the corresponding DAO of a model is named "model name" + DAO_SUFFIX.
     */
    public static final String DAO_SUFFIX = "Dao";
    /**
     * Naming convention within the SDK is that the corresponding List DAO of a model is named "model name" +
     * LIST_DAO_SUFFIX.
     */
    public static final String LIST_DAO_SUFFIX = "List" + DAO_SUFFIX;

    private final SdkContext context;

    /**
     * Constructor.
     * 
     * @param context
     *            context to use.
     */
    protected DaoProvider(SdkContext context) {
        this.context = context;
    }

    /**
     * States whether the underlying SDK context is defined or not.
     * 
     * @return true if underlying context is specified. False otherwise.
     */
    public boolean isContextSpecified() {
        return context != null;
    }

    /**
     * States whether an underlying Cloud client is defined or not.
     * 
     * @return true if underlying client is specified. False otherwise.
     */
    public boolean isClientSpecified() {
        return isContextSpecified() && context.getClient() != null;
    }

    /**
     * Gets provider underlying SDK context.
     * 
     * @return underlying context.
     */
    public @Nullable SdkContext getContext() {
        return context;
    }

    /**
     * Gets provider underlying Cloud client.
     * 
     * @return underlying cloud client.
     */
    public @Nullable ApiClientWrapper getClient() {
        return isContextSpecified() ? context.getClient() : null;
    }

    /**
     * Gets the name of the corresponding DAO.
     * 
     * @param modelName
     *            name of the model of interest.
     * @return corresponding DAO name
     */
    public static @Nullable String getCorrespondingDaoName(String modelName) {
        return modelName == null || modelName.trim().isEmpty() ? null : modelName.trim() + DAO_SUFFIX;
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
                                     : (Class<? extends ModelDao<T>>) DaoProvider.class.forName(getCorrespondingDaoName(modelType.getName()));
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
    public @Nullable <T extends SdkModel, U extends ModelDao<T>> U
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
            specifyDaoClient(dao);
            dao.setModel(model);
            return dao;
        } catch (InstantiationException | IllegalAccessException exception) {
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
           getCorrespondingGlobalDao(T model) throws MbedCloudException {
        return newGlobalProvider().getCorrespondingDao(model);
    }

    /**
     * Gets the name of the corresponding List DAO.
     * 
     * @param modelName
     *            name of the model of interest.
     * @return corresponding List DAO name
     */
    public static @Nullable String getCorrespondingListDaoName(String modelName) {
        return modelName == null || modelName.trim().isEmpty() ? null : modelName.trim() + LIST_DAO_SUFFIX;
    }

    /**
     * Gets the class of the Model List DAO corresponding to {@code modelType}.
     * <p>
     * Note: this method defers from {@link #getCorrespondingDao(SdkModel)} by the fact that the context is not passed
     * to the returned DAO and hence, connection to the Cloud is based on global {@link ConnectionOptions}.
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
                                                                     ? extends ListOptions>>) DaoProvider.class.forName(getCorrespondingListDaoName(modelType.getName()));
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
    public @Nullable <T extends SdkModel, U extends ListOptions, V extends ModelListDao<T, U>> V
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
            specifyDaoClient(listDao);
            listDao.setListOptions(options);
            return listDao;
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }
    }

    /**
     * Gets an instance of the Model List DAO corresponding to this {@code modelType}.
     * <p>
     * Note: this method defers from {@link #getCorrespondingListDao(Class, ListOptions)} by the fact that the context
     * is not passed to the returned DAO and hence, connection to the Cloud is based on global
     * {@link ConnectionOptions}.
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
           getCorrespondingGlobalListDao(Class<T> modelType, @Nullable U options) throws MbedCloudException {
        return newGlobalProvider().getCorrespondingListDao(modelType, options);
    }

    /**
     * Gets a global DAO provider instance.
     * <p>
     * Note: this provider only returns DAO which are initialised using global {@link ConnectionOptions}.
     * 
     * @return a new global DAO provider instance.
     */
    protected static DaoProvider newGlobalProvider() {
        return new DaoProvider(null);
    }

    private <T extends CloudDao> void specifyDaoClient(T dao) throws MbedCloudException {
        if (isContextSpecified()) {
            dao.configure(context);
        }
    }

}
