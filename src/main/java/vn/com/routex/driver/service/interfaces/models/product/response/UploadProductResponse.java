package vn.com.routex.driver.service.interfaces.models.product.response;


import vn.com.routex.driver.service.interfaces.models.request.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class UploadProductResponse extends BaseResponse<UploadProductResponse.UploadProductResponseData> {

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
