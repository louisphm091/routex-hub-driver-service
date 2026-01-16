package vn.com.routex.driver.service.interfaces.models.product.response;

import vn.com.routex.driver.service.interfaces.models.request.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project routex-hub-driver-service
 **/

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ProductDetailResponse extends BaseResponse<List<ProductDetailResponse.ProductDetailResponseData>> {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class ProductDetailResponseData {
        private String productId;
        private String productName;
        private String description;
        private BigDecimal price;
        private boolean isNewArrival;
        private String categoryId;
        private String thumbnail;
        private String slug;
        private Set<CategoryList> categoryLists;
        private List<ProductVariantDetail> variants;
        private List<ProductResourceDetail> productResources;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class CategoryList {
        private String categoryId;
        private String categoryName;
        private String categoryTypeId;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class ProductVariantDetail {
        private String id;
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
    public static class ProductResourceDetail {
        private String id;
        private String name;
        private String url;
        private String type;
        private Boolean isPrimary;
    }

}

