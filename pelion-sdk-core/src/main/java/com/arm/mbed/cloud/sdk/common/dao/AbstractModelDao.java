package com.arm.mbed.cloud.sdk.common.dao;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicReference;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 *
 * Abstract definition of a Model Data Access Object.
 *
 */
@Preamble(description = "Abstract Model DAO")
public abstract class AbstractModelDao<T extends SdkModel> extends AbstractCloudDao implements ModelDao<T> {
    public static final String METHOD_INSTANTIATE_MODEL = "instantiateModel";
    public static final String METHOD_SET_AND_GET_MODEL = "setAndGetModel";
    private final AtomicReference<T> model;

    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error happens during instantiation.
     */
    public AbstractModelDao() throws MbedCloudException {
        super();
        model = new AtomicReference<>();
        setModel(null);
    }

    /**
     * Constructor.
     * 
     * @param options
     *            options to use.
     * 
     * @throws MbedCloudException
     *             if an error happens during instantiation.
     */
    public AbstractModelDao(ConnectionOptions options) throws MbedCloudException {
        super(options);
        model = new AtomicReference<>();
        setModel(null);
    }

    /**
     * Constructor.
     * 
     * @param client
     *            client to use.
     * @throws MbedCloudException
     *             if an error happens during instantiation.
     */
    public AbstractModelDao(ApiClientWrapper client) throws MbedCloudException {
        super(client);
        model = new AtomicReference<>();
        setModel(null);
    }

    /**
     * Constructor.
     * 
     * @param sdkContext
     *            SDK context.
     * @throws MbedCloudException
     *             if an error happens during instantiation.
     */
    public AbstractModelDao(SdkContext sdkContext) throws MbedCloudException {
        super(sdkContext);
        model = new AtomicReference<>();
        setModel(null);
    }

    @Override
    public void setModel(T model) {
        setAndGetModel(model);
    }

    @Override
    public void setId(String id) {
        getModelOrNew().setId(id);
    }

    @Override
    public String getId() {
        return getModelOrNew().getId();
    }

    @Override
    public T getModel() {
        return model.get();
    }

    @Override
    public T getModelOrNew() {
        final T currentModel = getModel();
        if (currentModel == null) {
            final T newModel = instantiateModel();
            model.compareAndSet(null, newModel);
            final T modelToCheck = getModel();
            if (modelToCheck == null) {
                synchronized (model) {
                    model.set(newModel);
                    return getModel();
                }
            }
            return modelToCheck;
        }
        return currentModel;
    }

    protected T setAndGetModel(T model) {
        T prev = null;
        final T next = model;
        do {
            prev = getModel();
        } while (!this.model.compareAndSet(prev, next));
        return next;
    }

    @Override
    public boolean hasModel() {
        return getModel() != null;
    }

    /**
     * Placeholder for instantiating the underlying model. This method currently uses reflection. It should be
     * overridden by each DAO with direct call to the model empty constructor.
     *
     * @return an instance of the model.
     */
    @Internal
    protected T instantiateModel() {
        try {
            @SuppressWarnings("unchecked")
            final Class<T> modelClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return modelClass.newInstance();
        } catch (@SuppressWarnings("unused") InstantiationException | IllegalAccessException exception) {
            return null;
        }
    }
}
