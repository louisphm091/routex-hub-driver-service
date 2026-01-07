package com.ecommerce.server.application.facade;

import com.ecommerce.server.interfaces.models.product.request.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.request.UpdateProductRequest;
import com.ecommerce.server.interfaces.models.product.response.UpdateProductResponse;
import com.ecommerce.server.interfaces.models.product.response.UploadProductResponse;
import com.ecommerce.server.interfaces.models.product.response.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.product.request.UploadProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductFacade {

    // Get All Products
    ResponseEntity<ProductDetailResponse> getAllProducts(ProductDetailRequest request);
    ResponseEntity<UploadProductResponse> uploadNewProduct(UploadProductRequest request);
    ResponseEntity<ProductDetailResponse> getProductById(ProductDetailRequest request);
    ResponseEntity<UpdateProductResponse> updateProduct(UpdateProductRequest request);
}
