package com.arm.mbed.cloud.sdk.common.dao;

import com.arm.mbed.cloud.sdk.annotations.NonNull;
import com.arm.mbed.cloud.sdk.annotations.Nullable;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.common.listing.Paginator;

/**
 * Data access object definition for listing models using
 * <a href="https://en.wikipedia.org/wiki/Pagination">pagination</a>.
 *
 * @param <T>
 *            Data model type
 * @param <U>
 *            list options type
 */
@Preamble(description = "Data Access Object definition for listing data models")
public interface ModelListDao<T extends SdkModel, U extends ListOptions> extends CloudDao {
    /**
     * Sets the {@link ListOptions} this DAO should use for listing models.
     * <p>
     * Note: the size of the pages received can be configured using @link {@link ListOptions#setPageSize(Integer)} and
     * the maximum number of returned results can be configured using the {@code options}. see
     * {@link ListOptions#setMaxResults(Long)}.
     *
     * @param options
     *            list options. If null, the default options will be considered.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    void setListOptions(@Nullable U options) throws MbedCloudException;

    /**
     * Sets the {@link ListOptions} this DAO should use for listing models.
     * <p>
     * Note: Similar to {@link #setListOptions(ListOptions)}
     *
     * @param options
     *            list options.
     * @return this.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @NonNull
    ModelListDao<T, U> options(@Nullable U options) throws MbedCloudException;

    /**
     * Gets the {@link ListOptions}, this DAO was set with.
     *
     * @return the list options.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @Nullable
    U getListOptions() throws MbedCloudException;

    /**
     * Gets one page of models.
     * <p>
     * Note: the page size can be configured using the {@code options}. see {@link ListOptions#setPageSize(Integer)}
     *
     * @param options
     *            list options to use.
     * @return one page worth of models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @Nullable
    ListResponse<T> getOnePage(@Nullable U options) throws MbedCloudException;

    /**
     * Gets one page of models.
     * <p>
     * Note: Similar to {@link #getOnePage(ListOptions)} but the underlying options set using
     * {@link #setListOptions(ListOptions)} will be used instead.
     *
     * @return one page worth of models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @Nullable
    ListResponse<T> getOnePage() throws MbedCloudException;

    /**
     * Gets one page of models.
     * <p>
     * Note: Similar to {@link #getOnePage(ListOptions)}
     *
     * @param options
     *            list options.
     * @return one page worth of models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @Nullable
    ListResponse<T> onePage(@Nullable U options) throws MbedCloudException;

    /**
     * Gets one page of models.
     * <p>
     * Note: Similar to {@link #getOnePage()}
     *
     * @return one page worth of models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @Nullable
    ListResponse<T> onePage() throws MbedCloudException;

    /**
     * Gets a paginator over the whole collection of data models present in the Cloud.
     * <p>
     * Note: the maximum number of returned results can be configured using the {@code options}. see
     * {@link ListOptions#setMaxResults(Long)}.
     *
     * @param options
     *            list options.
     * @return a paginator over the whole collection of data models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @NonNull
    Paginator<T> getPaginator(@Nullable U options) throws MbedCloudException;

    /**
     * Gets a paginator over the whole collection of data models present in the Cloud.
     * <p>
     * Note: Similar to {@link #getPaginator(ListOptions)} but the underlying options set using
     * {@link #setListOptions(ListOptions)} will be used instead.
     *
     * @return a paginator over the whole collection of data models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @NonNull
    Paginator<T> getPaginator() throws MbedCloudException;

    /**
     * Gets a paginator over the whole collection of data models present in the Cloud.
     * <p>
     * Note: Similar to {@link #getPaginator(ListOptions)}
     *
     * @param options
     *            list options.
     * @return a paginator over the whole collection of data models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @NonNull
    Paginator<T> paginator(@Nullable U options) throws MbedCloudException;

    /**
     * Gets a paginator over the whole collection of data models present in the Cloud.
     * <p>
     * Note: Similar to {@link #getPaginator()}
     *
     * @return a paginator over the whole collection of data models.
     * @throws MbedCloudException
     *             if an error occurs during the process
     */
    @NonNull
    Paginator<T> paginator() throws MbedCloudException;
}
