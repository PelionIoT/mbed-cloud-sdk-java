package com.arm.mbed.cloud.sdk.security.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.Mapper;
import com.arm.mbed.cloud.sdk.common.GenericAdapter.RespList;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigListResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigRequest;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CertificateIssuerConfigResponse;
import com.arm.mbed.cloud.sdk.internal.externalca.model.CreateCertificateIssuerConfig;
import com.arm.mbed.cloud.sdk.security.model.CertificateIssuerConfig;

@Preamble(description = "Adapter for certificate issuer config")
@Internal
public final class CertificateIssuerConfigAdapter {
    /**
     * Constructor.
     */
    private CertificateIssuerConfigAdapter() {
        super();
        // Nothing to do
    }

    /**
     * Maps a certificate issuer config.
     * 
     * @param toBeMapped
     *            response to be mapped.
     * @return mapped certificate issuer config.
     */
    public static CertificateIssuerConfig map(CertificateIssuerConfigResponse toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final CertificateIssuerConfig finalIssuerConfig = new CertificateIssuerConfig();
        finalIssuerConfig.setId(toBeMapped.getId());
        finalIssuerConfig.setCertificateIssuerId(toBeMapped.getCertificateIssuerId());
        finalIssuerConfig.setCreatedAt(TranslationUtils.toDate(toBeMapped.getCreatedAt()));
        finalIssuerConfig.setReference(toBeMapped.getReference());
        finalIssuerConfig.setUpdatedAt(TranslationUtils.toDate(toBeMapped.getUpdatedAt()));
        return finalIssuerConfig;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper.
     */
    public static Mapper<CertificateIssuerConfigResponse, CertificateIssuerConfig> getMapper() {
        return new Mapper<CertificateIssuerConfigResponse, CertificateIssuerConfig>() {

            @Override
            public CertificateIssuerConfig map(CertificateIssuerConfigResponse toBeMapped) {
                return CertificateIssuerConfigAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps a certificate issuer config for creation.
     * 
     * @param finalCertificateIssuerConfig
     *            issuer config
     * @return mapped request body.
     */
    public static CreateCertificateIssuerConfig reverseAddMap(CertificateIssuerConfig finalCertificateIssuerConfig) {
        if (finalCertificateIssuerConfig == null) {
            return null;
        }

        final CreateCertificateIssuerConfig addedIssuerConfig = new CreateCertificateIssuerConfig();
        addedIssuerConfig.setCertificateIssuerId(finalCertificateIssuerConfig.getCertificateIssuerId());
        addedIssuerConfig.setReference(finalCertificateIssuerConfig.getReference());
        return addedIssuerConfig;
    }

    /**
     * Maps a certificate issuer config for update.
     * 
     * @param finalCertificateIssuerConfig
     *            issuer config
     * @return mapped request body.
     */
    public static CertificateIssuerConfigRequest
           reverseUpdateMap(CertificateIssuerConfig finalCertificateIssuerConfig) {
        if (finalCertificateIssuerConfig == null) {
            return null;
        }

        final CertificateIssuerConfigRequest updatedIssuerConfig = new CertificateIssuerConfigRequest();
        updatedIssuerConfig.setCertificateIssuerId(finalCertificateIssuerConfig.getCertificateIssuerId());
        return updatedIssuerConfig;
    }

    /**
     * Maps a list of certificate issuer configurations.
     *
     * @param list
     *            list of certificate issuer configurations.
     * @return list of certificate issuer configurations.
     */
    public static ListResponse<CertificateIssuerConfig> mapList(CertificateIssuerConfigListResponse list) {

        final CertificateIssuerConfigListResponse finalList = list;
        final RespList<CertificateIssuerConfigResponse> respList = new RespList<CertificateIssuerConfigResponse>() {

            @Override
            public Boolean getHasMore() {
                // FIXME return correct value when fixed.
                return false;
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
            public List<CertificateIssuerConfigResponse> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            @Override
            public String getContinuationMarker() {
                return null;
            }

        };
        return GenericAdapter.mapList(respList, CertificateIssuerConfigAdapter.getMapper());
    }

    /**
     * Gets a list mapper.
     * 
     * @return a list mapper.
     */
    public static Mapper<CertificateIssuerConfigListResponse, ListResponse<CertificateIssuerConfig>> getListMapper() {
        return new Mapper<CertificateIssuerConfigListResponse, ListResponse<CertificateIssuerConfig>>() {

            @Override
            public ListResponse<CertificateIssuerConfig> map(CertificateIssuerConfigListResponse toBeMapped) {
                return CertificateIssuerConfigAdapter.mapList(toBeMapped);
            }
        };
    }

}
