// This file was generated by the Pelion SDK foundation code generator.
// This is an autogenerated class. Do not modify its content as modifications will be lost at next code generation.
package com.arm.mbed.cloud.sdk.branding.adapters;

import com.arm.mbed.cloud.sdk.annotations.Internal;
import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.branding.model.LightThemeImage;
import com.arm.mbed.cloud.sdk.branding.model.LightThemeImageReference;
import com.arm.mbed.cloud.sdk.common.GenericAdapter;
import com.arm.mbed.cloud.sdk.common.TranslationUtils;
import com.arm.mbed.cloud.sdk.common.listing.ListResponse;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImage;
import com.arm.mbed.cloud.sdk.lowlevel.pelionclouddevicemanagement.model.BrandingImageList;
import java.util.List;

/**
 * Adapter for light theme images.
 */
@Preamble(description = "Adapter for light theme images.")
@Internal
@SuppressWarnings("checkstyle:LineLength")
public final class LightThemeImageAdapter {
    /**
     * Constructor.
     */
    private LightThemeImageAdapter() {
        super();
        // Nothing to do;
    }

    /**
     * Maps a branding image list into a light theme image.
     * 
     * @param toBeMapped
     *            a branding image list.
     * @return mapped list response
     */
    @Internal
    public static ListResponse<LightThemeImage> mapList(BrandingImageList toBeMapped) {
        final BrandingImageList finalList = toBeMapped;
        final GenericAdapter.RespList<BrandingImage> respList = new GenericAdapter.RespList<BrandingImage>() {
            /**
             * Executes getAfter.
             * 
             * @return something
             */
            @Override
            public String getAfter() {
                return (finalList == null) ? null : finalList.getAfter();
            }

            /**
             * Executes getContinuationMarker.
             * 
             * @return something
             */
            @Override
            public String getContinuationMarker() {
                return null;
            }

            /**
             * Executes getData.
             * 
             * @return something
             */
            @Override
            public List<BrandingImage> getData() {
                return (finalList == null) ? null : finalList.getData();
            }

            /**
             * Executes getHasMore.
             * 
             * @return something
             */
            @Override
            public Boolean getHasMore() {
                return (finalList == null) ? null : finalList.isHasMore();
            }

            /**
             * Executes getLimit.
             * 
             * @return something
             */
            @Override
            public Integer getLimit() {
                return (finalList == null) ? null : finalList.getLimit();
            }

            /**
             * Executes getOrder.
             * 
             * @return something
             */
            @Override
            public String getOrder() {
                return (finalList == null) ? null : finalList.getOrder().toString();
            }

            /**
             * Executes getTotalCount.
             * 
             * @return something
             */
            @Override
            public Integer getTotalCount() {
                return (finalList == null) ? null : finalList.getTotalCount();
            }
        };
        return GenericAdapter.mapList(respList, LightThemeImageAdapter.getMapper());
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<BrandingImageList, ListResponse<LightThemeImage>> getListMapper() {
        return new GenericAdapter.Mapper<BrandingImageList, ListResponse<LightThemeImage>>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public ListResponse<LightThemeImage> map(BrandingImageList toBeMapped) {
                return LightThemeImageAdapter.mapList(toBeMapped);
            }
        };
    }

    /**
     * Maps a branding image into a light theme image.
     * 
     * @param toBeMapped
     *            a branding image.
     * @return mapped a light theme image
     */
    @Internal
    public static LightThemeImage map(BrandingImage toBeMapped) {
        if (toBeMapped == null) {
            return null;
        }
        final LightThemeImage lightThemeImage = new LightThemeImage(toBeMapped.getStaticUri(),
                                                                    TranslationUtils.toDate(toBeMapped.getUpdatedAt()));
        lightThemeImage.setReference(translateToLightThemeImageReference(toBeMapped.getReference()));
        return lightThemeImage;
    }

    /**
     * Gets a mapper.
     * 
     * @return a mapper
     */
    @Internal
    public static GenericAdapter.Mapper<BrandingImage, LightThemeImage> getMapper() {
        return new GenericAdapter.Mapper<BrandingImage, LightThemeImage>() {
            /**
             * Maps.
             * 
             * @param toBeMapped
             *            model to be mapped.
             * @return a mapped object
             */
            @Override
            public LightThemeImage map(BrandingImage toBeMapped) {
                return LightThemeImageAdapter.map(toBeMapped);
            }
        };
    }

    /**
     * Maps the enum value.
     * 
     * @param toBeMapped
     *            a reference enum.
     * @return mapped enum value
     */
    @Internal
    @SuppressWarnings("PMD.CyclomaticComplexity")
    protected static LightThemeImageReference
              translateToLightThemeImageReference(BrandingImage.ReferenceEnum toBeMapped) {
        if (toBeMapped == null) {
            return LightThemeImageReference.getUnknownEnum();
        }
        switch (toBeMapped) {
            case BRAND_LOGO_PORTRAIT:
                return LightThemeImageReference.BRAND_LOGO_PORTRAIT;
            case BRAND_LOGO_SQUARE:
                return LightThemeImageReference.BRAND_LOGO_SQUARE;
            case BRAND_LOGO_LANDSCAPE:
                return LightThemeImageReference.BRAND_LOGO_LANDSCAPE;
            case BRAND_LOGO_EMAIL:
                return LightThemeImageReference.BRAND_LOGO_EMAIL;
            case APP_LOGO_LANDSCAPE:
                return LightThemeImageReference.APP_LOGO_LANDSCAPE;
            case APP_LOGO_PORTRAIT:
                return LightThemeImageReference.APP_LOGO_PORTRAIT;
            case APP_LOGO_SQUARE:
                return LightThemeImageReference.APP_LOGO_SQUARE;
            case DESKTOP_BACKGROUND_LANDSCAPE:
                return LightThemeImageReference.DESKTOP_BACKGROUND_LANDSCAPE;
            case DESKTOP_BACKGROUND_SQUARE:
                return LightThemeImageReference.DESKTOP_BACKGROUND_SQUARE;
            case DESKTOP_BACKGROUND_PORTRAIT:
                return LightThemeImageReference.DESKTOP_BACKGROUND_PORTRAIT;
            case CAROUSEL_IMAGE_PORTRAIT_0:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_0;
            case CAROUSEL_IMAGE_PORTRAIT_1:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_1;
            case CAROUSEL_IMAGE_PORTRAIT_2:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_2;
            case CAROUSEL_IMAGE_PORTRAIT_3:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_3;
            case CAROUSEL_IMAGE_PORTRAIT_4:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_4;
            case CAROUSEL_IMAGE_PORTRAIT_5:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_5;
            case CAROUSEL_IMAGE_PORTRAIT_6:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_6;
            case CAROUSEL_IMAGE_PORTRAIT_7:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_7;
            case CAROUSEL_IMAGE_PORTRAIT_8:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_8;
            case CAROUSEL_IMAGE_PORTRAIT_9:
                return LightThemeImageReference.CAROUSEL_IMAGE_PORTRAIT_9;
            case CAROUSEL_IMAGE_SQUARE_0:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_0;
            case CAROUSEL_IMAGE_SQUARE_1:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_1;
            case CAROUSEL_IMAGE_SQUARE_2:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_2;
            case CAROUSEL_IMAGE_SQUARE_3:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_3;
            case CAROUSEL_IMAGE_SQUARE_4:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_4;
            case CAROUSEL_IMAGE_SQUARE_5:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_5;
            case CAROUSEL_IMAGE_SQUARE_6:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_6;
            case CAROUSEL_IMAGE_SQUARE_7:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_7;
            case CAROUSEL_IMAGE_SQUARE_8:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_8;
            case CAROUSEL_IMAGE_SQUARE_9:
                return LightThemeImageReference.CAROUSEL_IMAGE_SQUARE_9;
            case CAROUSEL_IMAGE_LANDSCAPE_0:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_0;
            case CAROUSEL_IMAGE_LANDSCAPE_1:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_1;
            case CAROUSEL_IMAGE_LANDSCAPE_2:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_2;
            case CAROUSEL_IMAGE_LANDSCAPE_3:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_3;
            case CAROUSEL_IMAGE_LANDSCAPE_4:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_4;
            case CAROUSEL_IMAGE_LANDSCAPE_5:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_5;
            case CAROUSEL_IMAGE_LANDSCAPE_6:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_6;
            case CAROUSEL_IMAGE_LANDSCAPE_7:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_7;
            case CAROUSEL_IMAGE_LANDSCAPE_8:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_8;
            case CAROUSEL_IMAGE_LANDSCAPE_9:
                return LightThemeImageReference.CAROUSEL_IMAGE_LANDSCAPE_9;
            default:
                return LightThemeImageReference.getUnknownEnum();
        }
    }
}
