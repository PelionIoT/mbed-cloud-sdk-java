package com.arm.mbed.cloud.sdk.common.listing;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;

/**
 * Iterator over all the elements of a list without requiring the developer to create and process all the individual
 * requests. This Paginator should be used as the primary way of listing entities. Paginators can be configured to
 * return only a maximum number of results if existing (i.e. parameter {@code maxResult}) or to set the page size in
 * order to tweak underlying http communications (i.e. parameter {@code pageSize}).
 * <P>
 * Note: This paginator is an iterator over IDs.
 *
 */
@Preamble(description = "ID iterator over an entire result set of a truncated/paginated API operation.")
public class IdPaginator extends AbstractPaginator<String, IdListResponse, IdPageRequester> {

    public IdPaginator(ListOptions options, IdPageRequester requester) throws MbedCloudException {
        super(options, requester);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public IdPaginator clone() throws CloneNotSupportedException {
        try {
            final IdPaginator clone = new IdPaginator(cloneListOptions(), getRequester());
            clone.setProperties(this);
            return clone;
        } catch (MbedCloudException exception) {
            // Nothing to do
        }
        throw new CloneNotSupportedException();
    }

    @Override
    protected String cloneCurrentElement() {
        final String currentElement = current();
        return (currentElement == null) ? null : String.valueOf(currentElement);
    }

    @Override
    protected String fetchAfterId(String last) {
        return last;
    }

}
