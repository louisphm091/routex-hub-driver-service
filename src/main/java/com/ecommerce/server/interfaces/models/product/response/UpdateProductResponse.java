package com.ecommerce.server.interfaces.models.product.response;


import com.ecommerce.server.interfaces.models.request.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateProductResponse extends BaseResponse {
    private UpdateProductResponseResult result;
    private UpdateProductResponseData data;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateProductResponseResult {
        private String responseCode;
        private String description;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateProductResponseData {
        private String productId;
        private String categoryId;
        private String oldDescription;
        private String newDescription;
        private String oldPrice;
        private String newPrice;
        private String oldStatus;
        private String newStatus;
    }
}
