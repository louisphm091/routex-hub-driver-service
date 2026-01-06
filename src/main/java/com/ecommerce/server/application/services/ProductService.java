package com.ecommerce.server.application.services;

import com.ecommerce.server.interfaces.models.product.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.UploadProductResponse;
import com.ecommerce.server.interfaces.models.request.product.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.request.product.UploadProductRequest;
import com.ecommerce.server.domain.product.Product;

import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/
public interface ProductService {

    Product addProduct(ProductDetailResponse product);
    ProductDetailResponse getAllProducts(ProductDetailRequest request);

    ProductDetailResponse getProductBySlug(String slug);

    ProductDetailResponse getProductById(UUID id);

    UploadProductResponse uploadProduct(UploadProductRequest request);
    Product updateProduct(ProductDetailResponse productDto, UUID id);

    Product fetchProductById(UUID uuid) throws Exception;
}
