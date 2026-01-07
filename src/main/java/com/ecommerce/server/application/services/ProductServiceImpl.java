package com.ecommerce.server.application.services;

import com.ecommerce.server.domain.product.Product;
import com.ecommerce.server.infrastructure.persistence.adapter.ProductGateway;
import com.ecommerce.server.infrastructure.persistence.mapper.ProductMapper;
import com.ecommerce.server.interfaces.models.product.request.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.request.UpdateProductRequest;
import com.ecommerce.server.interfaces.models.product.response.UpdateProductResponse;
import com.ecommerce.server.interfaces.models.product.response.UploadProductResponse;
import com.ecommerce.server.interfaces.models.product.response.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.product.request.UploadProductRequest;
import com.ecommerce.server.interfaces.records.ProductFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project ecom-hub-product-service
 **/

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductGateway productGateway;
    private CategoryService categoryService;
    private ProductMapper productMapper;

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
    public ProductDetailResponse getProductById(ProductDetailRequest id) {
        return null;
    }

    @Override
    public UploadProductResponse uploadProduct(UploadProductRequest request) {
        return null;
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        return null;
    }


}