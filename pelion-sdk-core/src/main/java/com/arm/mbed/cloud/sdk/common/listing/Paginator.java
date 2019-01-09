package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.SdkModel;

/**
 * Iterator over all the elements of a list without requiring the developer to create and process all the individual
 * requests. This Paginator should be used as the primary way of listing entities. Paginators can be configured to
 * return only a maximum number of results if existing (i.e. parameter {@code maxResult}) or to set the page size in
 * order to tweak underlying http communications (i.e. parameter {@code pageSize}).
 * <P>
 * Note: This paginator is an iterator over models.
 *
 *
 * @param <T>
 *            model type.
 */
@Preamble(description = "Model iterator over an entire result set of a truncated/paginated API operation.")
public class Paginator<T extends SdkModel> extends AbstractPaginator<T, ListResponse<T>, PageRequester<T>> {

    public Paginator(ListOptions options, PageRequester<T> requester) throws MbedCloudException {
        super(options, requester);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Paginator<T> clone() throws CloneNotSupportedException {
        try {
            final Paginator<T> clone = new Paginator<>(cloneListOptions(), getRequester());
            clone.setProperties(this);
            return clone;
        } catch (MbedCloudException exception) {
            // Nothing to do
        }
        throw new CloneNotSupportedException();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T cloneCurrentElement() {
        final T currentElement = current();
        return (currentElement == null) ? null : (T) currentElement.clone();
    }

    @Override
    protected String fetchAfterId(T last) {
        if (last == null) {
            return null;
        }
        return last.getId();
    }

}
