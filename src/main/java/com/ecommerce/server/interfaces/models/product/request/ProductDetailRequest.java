package com.ecommerce.server.interfaces.models.product.request;


import com.ecommerce.server.interfaces.models.base.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

        @NotNull
        @NotBlank
        private String categoryId;
        private String typeId;
        private boolean slug;
    }
}
