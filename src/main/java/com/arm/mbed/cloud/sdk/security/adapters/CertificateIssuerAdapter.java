package com.arm.mbed.cloud.sdk.security.adapters;

import java.util.List;
import java.util.Map;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerInfo;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerInfoListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerRequest;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerRequest.IssuerTypeEnum;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerUpdateRequest;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuer;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerType;

@Preamble(description = "Adapter for certificate issuer")
@Internal
public final class CertificateIssuerAdapter {
    /**
     * Constructor.
     */
    private CertificateIssuerAdapter() {
        super();
        // Nothing to do
    }

    /**
     * Maps certificate issuer.
     * 
     * @param toBeMapped
     *            certificate issuer to be mapped
     * @return mapped certificate issuer
     */
    public static CertificateIssuer map(CertificateIssuerInfo toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final CertificateIssuer certificateIssuer = new CertificateIssuer();
        certificateIssuer.setId(toBeMapped.getId());
        certificateIssuer.setCreatedAt(TranslationUtils.toDate(toBeMapped.getCreatedAt()));
        certificateIssuer.setDescription(toBeMapped.getDescription());
        certificateIssuer.setIssuerAttributes(toBeMapped.getIssuerAttributes());
        certificateIssuer.setIssuerType(toIssuerType(toBeMapped.getIssuerType()));
        certificateIssuer.setName(toBeMapped.getName());

        return certificateIssuer;
    }

    private static CertificateIssuerType toIssuerType(CertificateIssuerInfo.IssuerTypeEnum type) {
        if (type == null) {
            return CertificateIssuerType.getUnknownEnum();
        }
        switch (type) {
            case CFSSL_AUTH:
                return CertificateIssuerType.CFSSL_AUTH;
            case GLOBAL_SIGN:
                return CertificateIssuerType.GLOBAL_SIGN;
            default:
                return CertificateIssuerType.getUnknownEnum();
        }
    }

    private static IssuerTypeEnum toIssuerTypeReverseAdd(CertificateIssuerType issuerType) {
        if (issuerType == null) {
            return null;
        }
        switch (issuerType) {
            case CFSSL_AUTH:
                return IssuerTypeEnum.CFSSL_AUTH;
            case GLOBAL_SIGN:
                return IssuerTypeEnum.GLOBAL_SIGN;
            default:
                return null;
        }
    }

    // FIXME
    // private static Object toIssuerTypeReverseUpdate(CertificateIssuerType issuerType) {
    // // TODO Auto-generated method stub
    // return null;
    // }

    /**
     * Gets a mapper.
     * 
     * @return a mapper.
     */
    public static Mapper<CertificateIssuerInfo, CertificateIssuer> getMapper() {
        return new Mapper<CertificateIssuerInfo, CertificateIssuer>() {

            @Override
            public CertificateIssuer map(CertificateIssuerInfo toBeMapped) {
                return CertificateIssuerAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a certificate issuer for creation.
     * 
     * @param issuerCredentials
     *            issuer credentials
     * @param finalCertificateIssuer
     *            issuer
     * @return mapped request body.
     */
    public static CertificateIssuerRequest reverseAddMap(Map<String, String> issuerCredentials,
                                                         CertificateIssuer finalCertificateIssuer) {
        if (finalCertificateIssuer == null) {
            return null;
        }
        final CertificateIssuerRequest request = new CertificateIssuerRequest();
        request.setDescription(finalCertificateIssuer.getDescription());
        request.setIssuerAttributes(finalCertificateIssuer.getIssuerAttributes());
        request.setIssuerCredentials(issuerCredentials);
        request.setIssuerType(toIssuerTypeReverseAdd(finalCertificateIssuer.getIssuerType()));
        request.setName(finalCertificateIssuer.getName());
        return request;
    }

    /**
     * Maps a certificate issuer for update.
     * 
     * @param issuerCredentials
     *            issuer credentials
     * @param finalCertificateIssuer
     *            issuer
     * @return mapped request body.
     */
    public static CertificateIssuerUpdateRequest reverseUpdateMap(Map<String, String> issuerCredentials,
                                                                  CertificateIssuer finalCertificateIssuer) {
        if (finalCertificateIssuer == null) {
            return null;
        }
        final CertificateIssuerUpdateRequest request = new CertificateIssuerUpdateRequest();
        request.setDescription(finalCertificateIssuer.getDescription());
        request.setIssuerAttributes(finalCertificateIssuer.getIssuerAttributes());
        request.setIssuerCredentials(issuerCredentials);
        // FIXME
        // request.setIssuerType(toIssuerTypeReverseUpdate(finalCertificateIssuer.getIssuerType()));
        request.setName(finalCertificateIssuer.getName());
        return request;
    }

    /**
     * Maps a list of certificate issuers.
     *
     * @param list
     *            list of certificate issuers.
     * @return list of certificate issuers.
     */
    public static ListResponse<CertificateIssuer> mapList(CertificateIssuerInfoListResponse list) {

        final CertificateIssuerInfoListResponse finalList = list;
        final RespList<CertificateIssuerInfo> respList = new RespList<CertificateIssuerInfo>() {

            @Override
            public Boolean getHasMore() {
                return (finalList == null) ? false : finalList.isHasMore();
            }

            @Override
            public Integer getTotalCount() {
                return (finalList == null) ? null : finalList.getTotalCount();
            }

            @Override
            public String getAfter() {
                return (finalList == null) ? null : finalList.getAfter();
            }

            @Override
            public Integer getLimit() {
                return (finalList == null) ? null : finalList.getLimit();
            }

            @Override
            public String getOrder() {
                return (finalList == null) ? null : finalList.getOrder().toString();
            }

            @Override
            public List<CertificateIssuerInfo> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

        };
        return GenericAdapter.mapList(respList, CertificateIssuerAdapter.getMapper());
    }

    /**
     * Gets a list mapper.
     * 
     * @return a list mapper.
     */
    public static Mapper<CertificateIssuerInfoListResponse, ListResponse<CertificateIssuer>> getListMapper() {
        return new Mapper<CertificateIssuerInfoListResponse, ListResponse<CertificateIssuer>>() {

            @Override
            public ListResponse<CertificateIssuer> map(CertificateIssuerInfoListResponse toBeMapped) {
                return CertificateIssuerAdapter.mapList(toBeMapped);
            }
        };
    }

}
