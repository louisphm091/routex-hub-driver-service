package com.ecommerce.server.dto.product;


import com.ecommerce.server.dto.base.BaseRequest;
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
public class ProductDetailRequest extends BaseRequest {

    private ProductDetailRequestData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class ProductDetailRequestData {
        private String categoryId;
        private String typeId;
        private boolean slug;
    }
}
