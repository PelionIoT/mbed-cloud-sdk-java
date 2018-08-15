package com.arm.mbed.cloud.sdk.common.dao;

import java.lang.reflect.ParameterizedType;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

public abstract class AbstractModelListDao<T extends SdkModel, U extends ListOptions> extends AbstractCloudDao
                                          implements ModelListDao<T, U> {
    protected U options;

    public AbstractModelListDao() throws MbedCloudException {
        setListOptions(null);
    }

    @Override
    public void setListOptions(U options) throws MbedCloudException {
        this.options = options == null ? instantiateListOptions() : options;
    }

    @Override
    public ModelListDao<T, U> options(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return this;
    }

    @Override
    public U getListOptions() throws MbedCloudException {
        return options;
    }

    @Override
    public ListResponse<T> getOnePage(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return getOnePage();
    }

    @Override
    public ListResponse<T> getOnePage() throws MbedCloudException {
        return requestOnePage(options);
    }

    @Override
    public ListResponse<T> onePage(U listOptions) throws MbedCloudException {
        return getOnePage(listOptions);
    }

    @Override
    public ListResponse<T> onePage() throws MbedCloudException {
        return getOnePage();
    }

    @Override
    public Paginator<T> getPaginator(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return getPaginator();
    }

    @Override
    public Paginator<T> getPaginator() throws MbedCloudException {
        final U finalOptions = options;
        return new Paginator<>(finalOptions, getPageRequester());
    }

    @Override
    public Paginator<T> paginator(U listOptions) throws MbedCloudException {
        return getPaginator(listOptions);
    }

    @Override
    public Paginator<T> paginator() throws MbedCloudException {
        return getPaginator();
    }

    private PageRequester<T> getPageRequester() {
        return new PageRequester<T>() {

            @SuppressWarnings("unchecked")
            @Override
            public ListResponse<T> requestNewPage(ListOptions listOptions) throws MbedCloudException {
                return requestOnePage((U) listOptions);
            }

        };
    }

    /**
     * Placeholder for instantiating the underlying list options. This method currently use reflection. It should be
     * overridden by each DAO with direct call to the list options empty constructor.
     *
     * @return an instance of the model.
     */
    @Internal
    protected U instantiateListOptions() {
        try {
            @SuppressWarnings("unchecked")
            final Class<U> modelClass = (Class<U>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            return modelClass.newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }
    }

    protected abstract ListResponse<T> requestOnePage(U listOptions);
}
