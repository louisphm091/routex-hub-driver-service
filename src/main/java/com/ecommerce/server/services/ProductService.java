package com.ecommerce.server.services;

import com.ecommerce.server.dto.ProductDto;
import com.ecommerce.server.dto.product.ProductDetailRequest;
import com.ecommerce.server.dto.request.product.ProductDetailResponse;
import com.ecommerce.server.entities.Product;

import java.util.List;
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

    Product updateProduct(ProductDetailResponse productDto, UUID id);

    Product fetchProductById(UUID uuid) throws Exception;
}
