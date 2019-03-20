package com.arm.mbed.cloud.sdk.common.dao;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicReference;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.common.ApiClientWrapper;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.NotImplementedException;
import com.arm.mbed.cloud.sdk.common.SdkContext;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.listing.IdListResponse;
import com.arm.mbed.cloud.sdk.common.listing.IdPageRequester;
import com.arm.mbed.cloud.sdk.common.listing.IdPaginator;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.PageRequester;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

public abstract class AbstractModelListDao<T extends SdkModel, U extends ListOptions> extends AbstractCloudDao
                                          implements ModelListDao<T, U> {
    public static final String METHOD_REQUEST_ONE_PAGE = "requestOnePage";
    public static final String METHOD_REQUEST_ONE_PAGE_OF_IDS = "requestOnePageOfIds";
    public static final String METHOD_INSTANTIATE_LIST_OPTIONS = "instantiateListOptions";
    private final AtomicReference<U> options;

    /**
     * Constructor.
     * 
     * @throws MbedCloudException
     *             if an error happens during instantiation.
     */
    public AbstractModelListDao() throws MbedCloudException {
        options = new AtomicReference<>();
        setListOptions(null);
    }

    /**
     * Constructor.
     * 
     * @param options
     *            options to use.
     * @throws MbedCloudException
     */
    public AbstractModelListDao(ConnectionOptions options) throws MbedCloudException {
        super(options);
        this.options = new AtomicReference<>();
        setListOptions(null);
    }

    /**
     * Constructor.
     * 
     * @param client
     *            client to use.
     * @throws MbedCloudException
     *             if an error happens during instantiation.
     */
    public AbstractModelListDao(ApiClientWrapper client) throws MbedCloudException {
        super(client);
        this.options = new AtomicReference<>();
        setListOptions(null);
    }

    /**
     * Constructor.
     * 
     * @param sdkContext
     *            SDK context.
     * @throws MbedCloudException
     *             if an error happens during instantiation.
     */
    public AbstractModelListDao(SdkContext sdkContext) throws MbedCloudException {
        super(sdkContext);
        this.options = new AtomicReference<>();
        setListOptions(null);
    }

    @Override
    public void setListOptions(U options) throws MbedCloudException {
        this.options.set(options == null ? instantiateListOptions() : options);
    }

    @Override
    public ModelListDao<T, U> options(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return this;
    }

    @Override
    public U getListOptions() throws MbedCloudException {
        return options.get();
    }

    @Override
    public ListResponse<T> getOnePage(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return getOnePage();
    }

    @Override
    public ListResponse<T> getOnePage() throws MbedCloudException {
        return requestOnePage(getListOptions());
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
    public IdListResponse idsPage(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return idsPage();
    }

    @Override
    public IdListResponse idsPage() throws MbedCloudException {
        return requestOnePageOfIds(getListOptions());
    }

    @Override
    public Paginator<T> getPaginator(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return getPaginator();
    }

    @Override
    public Paginator<T> getPaginator() throws MbedCloudException {
        final U finalOptions = getListOptions();
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

    @Override
    public Paginator<T> list(U options) throws MbedCloudException {
        return getPaginator(options);
    }

    @Override
    public Paginator<T> list() throws MbedCloudException {
        return getPaginator();
    }

    @Override
    public IdPaginator idsPaginator(U listOptions) throws MbedCloudException {
        setListOptions(listOptions);
        return idsPaginator();
    }

    @Override
    public IdPaginator idsPaginator() throws MbedCloudException {
        final U finalOptions = getListOptions();
        return new IdPaginator(finalOptions, getIdPageRequester());
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

    private IdPageRequester getIdPageRequester() {
        return new IdPageRequester() {

            @SuppressWarnings("unchecked")
            @Override
            public IdListResponse requestNewPage(ListOptions listOptions) throws MbedCloudException {
                return requestOnePageOfIds((U) listOptions);
            }
        };
    }

    /**
     * Placeholder for instantiating the underlying list options. This method currently uses reflection. It should be
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

    // FIXME implement when the APIs allow this mechanism.
    protected IdListResponse requestOnePageOfIds(U listOptions) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("No mechanism is currently in place in the APIs to only list IDs",
                                                new NotImplementedException());
    }

    protected abstract ListResponse<T> requestOnePage(U listOptions) throws MbedCloudException,
                                                                     UnsupportedOperationException;

}
