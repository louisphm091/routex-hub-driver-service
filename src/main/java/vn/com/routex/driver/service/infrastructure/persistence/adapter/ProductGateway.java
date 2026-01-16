package vn.com.routex.driver.service.infrastructure.persistence.adapter;

import vn.com.routex.driver.service.domain.product.Product;
import vn.com.routex.driver.service.interfaces.records.ProductFilter;
import vn.com.routex.driver.service.interfaces.records.ProductIdFilter;

import java.util.List;

public interface ProductGateway {

    List<Product> findAllProductByFilter(ProductFilter filter);
    Product findById(ProductIdFilter filter);
}
