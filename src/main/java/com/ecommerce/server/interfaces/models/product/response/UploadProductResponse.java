package com.ecommerce.server.interfaces.models.product.response;


import com.ecommerce.server.interfaces.models.request.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UploadProductResponse extends BaseResponse {

    private UploadProductResponseResult result;
    private UploadProductResponseData data;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UploadProductResponseResult {
        private String responseCode;
        private String description;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UploadProductResponseData {
        private List<UploadProductResponseVariant> variantList;
        private List<UploadProductResponseResource> resources;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UploadProductResponseVariant {
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
    public static class UploadProductResponseResource {
        private String name;
        private String url;
        private String type;
        private Boolean isPrimary;
    }
}
