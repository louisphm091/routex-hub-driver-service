package vn.com.routex.driver.service.application.services;

import vn.com.routex.driver.service.interfaces.models.product.request.ProductDetailRequest;
import vn.com.routex.driver.service.interfaces.models.product.request.UpdateProductRequest;
import vn.com.routex.driver.service.interfaces.models.product.request.UploadProductRequest;
import vn.com.routex.driver.service.interfaces.models.product.response.ProductDetailResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.UpdateProductResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.UploadProductResponse;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project routex-hub-driver-service
 **/

public interface ProductService {

    ProductDetailResponse getAllProducts(ProductDetailRequest request);

    ProductDetailResponse getProductById(ProductDetailRequest request);

    UploadProductResponse uploadProduct(UploadProductRequest request);

    UpdateProductResponse updateProduct(UpdateProductRequest request);
}
