package com.arm.mbed.cloud.sdk.common;

import java.util.Iterator;

import com.arm.mbed.cloud.sdk.annotations.Preamble;

@Preamble(description = "Iterator over an entire result set of a truncated API operation")
public class Paginator<T> implements Iterator<T>, Iterable<T> {

	private final PageRequester<T> requester;
	private ListResponse<T> currentPage;
	private Iterator<T> currentIterator;

	public Paginator(PageRequester<T> requester) throws MbedCloudException {
		super();
		this.requester = requester;
		fetchNewPage();
	}

	/**
	 * @return the currentPage
	 */
	public ListResponse<T> getCurrentPage() {
		return currentPage;
	}

	/**
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
	 * @return the requester
	 */
	public PageRequester<T> getRequester() {
		return requester;
	}

	@Override
	public Iterator<T> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		if (currentIterator == null || currentPage == null) {
			return false;
		}
		return (currentIterator.hasNext()) ? true : currentPage.hasMore();
	}

	@Override
	public T next() {
		if (currentIterator == null || !currentIterator.hasNext()) {
			try {
				fetchNewPage();
			} catch (MbedCloudException e) {
				e.printStackTrace();
				return null;
			}
		}
		if (currentIterator != null && currentIterator.hasNext()) {
			return currentIterator.next();
		}
		return null;
	}

}
