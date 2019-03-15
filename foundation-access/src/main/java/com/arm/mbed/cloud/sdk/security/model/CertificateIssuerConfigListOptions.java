// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.security.model;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.Order;
import com.arm.mbed.cloud.sdk.common.listing.IncludeField;
import com.arm.mbed.cloud.sdk.common.listing.ListOptions;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filter;
import com.arm.mbed.cloud.sdk.common.listing.filtering.Filters;
import java.util.List;

/**
 * Options to use when listing certificate issuer configs.
 * <p>
 * Note:
 * <p>
 * <ul>
 * <li>Filters:
 * <p>
 * The list can be filtered server-side on some of the fields of a certificate issuer config.
 * <p>
 * The following filters are currently supported:
 * <p>
 * <table style="border: 2px solid navy; width:100%; border-collapse:collapse;border-spacing:0" summary="Available
 * filters">
 * <caption>Server-side filters</caption>
 * <tr>
 * <th style="background-color:#cbcefb;border-color:inherit;text-align:center" rowspan="2">Field</th>
 * <th style="background-color:#cbcefb;border-color:inherit;text-align:center" rowspan="2">Tag</th>
 * <th style="background-color:#cbcefb;border-color:inherit;text-align:center" colspan="7">Filters</th>
 * </tr>
 * <tr>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">not equal to</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">equal to</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">greater than</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">less than</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">like</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">in</td>
 * <td style="background-color:#dae8fc;text-align:center;" width="10%">not in</td>
 * </tr>
 * <tr>
 * <td style="border-color:inherit;text-align:left;padding-left:15px;padding-right:15px">certificateReference</td>
 * <td style=
 * "border-color:inherit;text-align:left;padding-left:15px;padding-right:15px;font-weight:bold">TAG_FILTER_BY_CERTIFICATE_REFERENCE</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold">&bull;</td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * <td style="border-color:inherit;text-align:center;font-weight:bold"></td>
 * </tr>
 * </table>
 * </li>
 * </ul>
 */
@Preamble(description = "Options to use when listing certificate issuer configs.")
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class CertificateIssuerConfigListOptions extends ListOptions {
    /**
     * Tag for filter by certificateReference.
     */
    public static final String TAG_FILTER_BY_CERTIFICATE_REFERENCE = "certificateReference";

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #CertificateIssuerConfigListOptions()} instead.
     * 
     * @param pageSize
     *            value.
     * @param maxResults
     *            value.
     * @param order
     *            enumerator value.
     * @param after
     *            value.
     * @param include
     *            value.
     * @param filter
     *            value.
     */
    @Internal
    public CertificateIssuerConfigListOptions(Integer pageSize, Long maxResults, Order order, String after,
                                              List<IncludeField> include, Filters filter) {
        super();
        this.pageSize = pageSize;
        this.maxResults = maxResults;
        this.order = order;
        this.after = after;
        this.include = include;
        this.filter = filter;
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #CertificateIssuerConfigListOptions()} instead.
     * 
     * @param certificateIssuerConfigListOptions
     *            a certificate issuer config list options.
     */
    @Internal
    public CertificateIssuerConfigListOptions(CertificateIssuerConfigListOptions certificateIssuerConfigListOptions) {
        this();
        setOptions(certificateIssuerConfigListOptions);
    }

    /**
     * Constructor.
     */
    public CertificateIssuerConfigListOptions() {
        super();
        setDefault();
    }

    /**
     * Internal constructor.
     * <p>
     * Note: Should not be used. Use {@link #CertificateIssuerConfigListOptions()} instead.
     * 
     * @param after
     *            value.
     * @param include
     *            value.
     * @param filter
     *            value.
     */
    @Internal
    public CertificateIssuerConfigListOptions(String after, List<IncludeField> include, Filters filter) {
        this(Integer.valueOf(0), Long.valueOf(0L), Order.getDefault(), after, include, filter);
    }

    /**
     * Gets all the filters defined on field {@code certificateReference}.
     * 
     * @return All the filters by {@code certificateReference}
     */
    public List<Filter> getCertificateReferenceFilters() {
        return fetchFilters(TAG_FILTER_BY_CERTIFICATE_REFERENCE);
    }

    /**
     * Sets "an equal to" filter by {@code certificateReference}.
     * 
     * @param filterByCertificateReference
     *            filter value.
     */
    public void addEqualToCertificateReferenceFilter(String filterByCertificateReference) {
        addEqualFilter(TAG_FILTER_BY_CERTIFICATE_REFERENCE, filterByCertificateReference);
    }

    /**
     * Sets "an equal to" filter by {@code certificateReference}.
     * <p>
     * Similar to
     * {@link com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfigListOptions#addEqualToCertificateReferenceFilter(String)}
     * 
     * @param filterByCertificateReference
     *            filter value.
     * @return These list options
     */
    @SuppressWarnings("unchecked")
    public <T extends CertificateIssuerConfigListOptions> T
           equalToCertificateReference(String filterByCertificateReference) {
        addEqualToCertificateReferenceFilter(filterByCertificateReference);
        return (T) this;
    }

    /**
     * Method to ensure {@link #equals(Object)} is correct.
     * <p>
     * Note: see this article: <a href="https://www.artima.com/lejava/articles/equality.html">canEqual()</a>
     * 
     * @param other
     *            another object.
     * @return true if the other object is an instance of the class in which canEqual is (re)defined, false otherwise.
     */
    protected boolean canEqual(Object other) {
        return other instanceof CertificateIssuerConfigListOptions;
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * 
     * @see java.lang.Object#toString()
     * @return the string representation
     */
    @Override
    public String toString() {
        return "CertificateIssuerConfigListOptions [pageSize=" + pageSize + ", maxResults=" + maxResults + ", order="
               + order + ", after=" + after + ", include=" + encodeInclude() + ", filter=" + retrieveFilterAsJson()
               + "]";
    }

    /**
     * Clones this instance.
     * <p>
     * 
     * @see java.lang.Object#clone()
     * @return a cloned instance
     */
    @Override
    public CertificateIssuerConfigListOptions clone() {
        final CertificateIssuerConfigListOptions opt = new CertificateIssuerConfigListOptions();
        opt.setOptions(this);
        return opt;
    }
}
