package vn.com.routex.driver.service.application.facade;

import vn.com.routex.driver.service.interfaces.models.product.request.ProductDetailRequest;
import vn.com.routex.driver.service.interfaces.models.product.request.UpdateProductRequest;
import vn.com.routex.driver.service.interfaces.models.product.response.UpdateProductResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.UploadProductResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.ProductDetailResponse;
import vn.com.routex.driver.service.interfaces.models.product.request.UploadProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductFacade {

    // Get All Products
    ResponseEntity<ProductDetailResponse> getAllProducts(ProductDetailRequest request);
    ResponseEntity<UploadProductResponse> uploadNewProduct(UploadProductRequest request);
    ResponseEntity<ProductDetailResponse> getProductById(ProductDetailRequest request);
    ResponseEntity<UpdateProductResponse> updateProduct(UpdateProductRequest request);
}
