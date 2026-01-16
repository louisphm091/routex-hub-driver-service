package vn.com.routex.driver.service.interfaces.models.product.response;


import vn.com.routex.driver.service.interfaces.models.request.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UpdateProductResponse extends BaseResponse<UpdateProductResponse.UpdateProductResponseData> {

    @Getter
    @Setter
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
