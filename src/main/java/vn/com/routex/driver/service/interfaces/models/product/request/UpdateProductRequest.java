package vn.com.routex.driver.service.interfaces.models.product.request;


import vn.com.routex.driver.service.interfaces.models.base.BaseRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UpdateProductRequest extends BaseRequest {

    @NotNull
    private String productId;
    private String name;
    private String description;
    private String price;
    private String categoryId;
    private String status;
}
