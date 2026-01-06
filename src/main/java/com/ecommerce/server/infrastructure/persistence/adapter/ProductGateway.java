package com.ecommerce.server.infrastructure.persistence.adapter;

import com.ecommerce.server.domain.product.Product;
import com.ecommerce.server.interfaces.records.ProductFilter;

import java.util.List;

public interface ProductGateway {

    List<Product> findAllProductByFilter(ProductFilter filter);
}
