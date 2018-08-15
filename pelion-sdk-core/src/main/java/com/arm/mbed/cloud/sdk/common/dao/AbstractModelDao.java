package com.arm.mbed.cloud.sdk.common.dao;

import java.lang.reflect.ParameterizedType;

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

    protected T model;

    public AbstractModelDao() throws MbedCloudException {
        super();
        setModel(null);
    }

    @Override
    public void setModel(T model) throws MbedCloudException {
        this.model = model == null ? instantiateModel() : model;

    }

    @Override
    public void setId(String id) throws MbedCloudException {
        model.setId(id);
    }

    @Override
    public String getId() throws MbedCloudException {
        return model.getId();
    }

    @Override
    public T getModel() throws MbedCloudException {
        return model;
    }

    /**
     * Placeholder for instantiating the underlying model. This method currently use reflection. It should be overridden
     * by each DAO with direct call to the model empty constructor.
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
