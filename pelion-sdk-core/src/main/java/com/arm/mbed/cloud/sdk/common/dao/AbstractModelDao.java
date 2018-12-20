package com.arm.mbed.cloud.sdk.common.dao;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicReference;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 *
 * Abstract definition of a Model Data Access Object.
 *
 */
@Preamble(description = "Abstract Model DAO")
public abstract class AbstractModelDao<T extends SdkModel> extends AbstractCloudDao implements ModelDao<T> {
    public static final String METHOD_INSTANTIATE_MODEL = "instantiateModel";
    public static final String METHOD_SET_MODEL = "setModel";
    public static final String METHOD_GET_MODEL = "getModel";
    private final AtomicReference<T> model;

    public AbstractModelDao() throws MbedCloudException {
        super();
        model = new AtomicReference<>();
        setModel(null);
    }

    @Override
    public void setModel(T model) throws MbedCloudException {
        this.model.set(model == null ? instantiateModel() : model);
    }

    @Override
    public void setId(String id) throws MbedCloudException {
        synchronized (model) {
            if (model.get() == null) {
                setModel(instantiateModel());
            }
            model.get().setId(id);
        }
    }

    @Override
    public String getId() throws MbedCloudException {
        final T dataModel = model.get();
        if (dataModel != null) {
            return dataModel.getId();
        }
        synchronized (model) {
            final T dataModel2 = model.get();
            if (dataModel2 != null) {
                return dataModel2.getId();
            }
            setModel(instantiateModel());
            return getModel().getId();
        }
    }

    @Override
    public T getModel() throws MbedCloudException {
        return model.get();
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
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }
    }
}
