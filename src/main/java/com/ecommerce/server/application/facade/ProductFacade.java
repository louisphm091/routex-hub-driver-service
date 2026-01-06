package com.ecommerce.server.application.facade;

import com.ecommerce.server.interfaces.models.product.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.UploadProductResponse;
import com.ecommerce.server.interfaces.models.request.product.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.request.product.UploadProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductFacade {

    // Get All Products
    ResponseEntity<ProductDetailResponse> getAllProducts(ProductDetailRequest request);
    ResponseEntity<UploadProductResponse> uploadNewProduct(UploadProductRequest request);
}
