package com.ecommerce.server.facade;

import com.ecommerce.server.dto.product.ProductDetailRequest;
import com.ecommerce.server.dto.request.product.ProductDetailResponse;
import org.springframework.http.ResponseEntity;

public interface ProductFacade {

    // Get All Products
    ResponseEntity<ProductDetailResponse> getAllProducts(ProductDetailRequest requesst);
}
