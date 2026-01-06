package com.ecommerce.server.infrastructure.persistence.adapter;

import com.ecommerce.server.domain.product.Product;
import com.ecommerce.server.infrastructure.persistence.repository.ProductRepository;
import com.ecommerce.server.interfaces.records.ProductFilter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class ProductGatewayAdapter implements ProductGateway {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProductByFilter(ProductFilter filter) {
        return productRepository.findProductByFilter(filter.categoryId(), filter.typeId());
    }
}
