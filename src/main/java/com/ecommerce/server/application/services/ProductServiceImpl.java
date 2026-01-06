package com.ecommerce.server.application.services;

import com.ecommerce.server.domain.product.Product;
import com.ecommerce.server.infrastructure.persistence.adapter.ProductGateway;
import com.ecommerce.server.infrastructure.persistence.mapper.ProductMapper;
import com.ecommerce.server.interfaces.models.product.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.UploadProductResponse;
import com.ecommerce.server.interfaces.models.request.product.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.request.product.UploadProductRequest;
import com.ecommerce.server.interfaces.records.ProductFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductGateway productGateway;
    private CategoryService categoryService;
    private ProductMapper productMapper;

    @Override
    public Product addProduct(ProductDetailResponse product) {
        return null;
    }

    @Override
    public ProductDetailResponse getAllProducts(ProductDetailRequest request) {
        ProductFilter filter = new ProductFilter(
                request.getData().getCategoryId(),
                request.getData().getTypeId()
        );
        List<Product> productList = productGateway.findAllProductByFilter(filter);
        return productMapper.mapToProductDetailResponse(productList);
    }

    @Override
    public ProductDetailResponse getProductBySlug(String slug) {
        return null;
    }

    @Override
    public ProductDetailResponse getProductById(UUID id) {
        return null;
    }

    @Override
    public UploadProductResponse uploadProduct(UploadProductRequest request) {
        return null;
    }

    @Override
    public Product updateProduct(ProductDetailResponse productDto, UUID id) {
        return null;
    }

    @Override
    public Product fetchProductById(UUID id) throws Exception {
//        return productRepository.findById(id).orElseThrow(BadRequestException::new);
        return null;
    }


}