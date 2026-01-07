package com.ecommerce.server.interfaces.models.product.request;


import com.ecommerce.server.interfaces.models.base.BaseRequest;
import com.ecommerce.server.interfaces.models.product.response.ProductDetailResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UploadProductRequest extends BaseRequest {
    private String productName;
    private String description;
    private String categoryId;
    private String categoryTypeId;
    @NotNull
    private BigDecimal costPrice;
    @NotNull
    private BigDecimal sellingPrice;
    @NotNull
    private BigDecimal originalPrice;
    private boolean isVisible;
    private boolean newArrival;
    private String slug;
    private List<ProductDetailResponse.ProductVariantDetail> variants;
    private List<ProductDetailResponse.ProductResourceDetail> resourceDetails;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UploadProductVariant {
        private String variantName;
        private String size;
        private int stockQuantity;
        private String status;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UploadProductResource {
        private String name;
        private String url;
        private String type;
        private Boolean isPrimary;
    }
}
