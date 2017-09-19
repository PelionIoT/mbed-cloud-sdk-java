package com.arm.mbed.cloud.sdk.common.listing;

import java.util.Iterator;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.MbedCloudException;
import com.arm.mbed.cloud.sdk.common.PageRequester;
import com.arm.mbed.cloud.sdk.common.SdkLogger;

@Preamble(description = "Iterator over an entire result set of a truncated API operation")
public class Paginator<T> implements Iterator<T>, Iterable<T> {

    private final PageRequester<T> requester;
    private ListResponse<T> currentPage;
    private Iterator<T> currentIterator;

    /**
     * Constructor.
     * 
     * @param requester
     *            page requester.
     * @throws MbedCloudException
     *             if an error occurs during page request.
     */
    public Paginator(PageRequester<T> requester) throws MbedCloudException {
        super();
        this.requester = requester;
        fetchNewPage();
    }

    /**
     * Gets current page.
     * 
     * @return the currentPage
     */
    public ListResponse<T> getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets current page.
     * 
     * @param currentPage
     *            the currentPage to set
     */
    private void setCurrentPage(ListResponse<T> currentPage) {
        if (currentPage == null) {
            this.currentPage = null;
            this.currentIterator = null;
        } else {
            this.currentPage = currentPage;
            this.currentIterator = this.currentPage.iterator();
        }
    }

    private void fetchNewPage() throws MbedCloudException {
        if (requester == null) {
            return;
        }
        if (currentPage == null || currentPage.hasMore()) {
            setCurrentPage(requester.requestNewPage());
        }
    }

    /**
     * Gets page requester.
     * 
     * @return the requester
     */
    public PageRequester<T> getRequester() {
        return requester;
    }

    /**
     * Gets an iterator (itself).
     * 
     */
    @Override
    public Iterator<T> iterator() {
        return this;
    }

    /**
     * States whether there are more records to fetch.
     */
    @Override
    public boolean hasNext() {
        if (currentIterator == null || currentPage == null) {
            return false;
        }
        return currentIterator.hasNext() ? true : currentPage.hasMore();
    }

    /**
     * Gets next page.
     */
    @Override
    public T next() {
        if (currentIterator == null || !currentIterator.hasNext()) {
            try {
                fetchNewPage();
            } catch (MbedCloudException exception) {
                SdkLogger.getLogger().logError("Error occurred when requesting next page", exception);
                return null;
            }
        }
        if (currentIterator != null && currentIterator.hasNext()) {
            return currentIterator.next();
        }
        return null;
    }

}
