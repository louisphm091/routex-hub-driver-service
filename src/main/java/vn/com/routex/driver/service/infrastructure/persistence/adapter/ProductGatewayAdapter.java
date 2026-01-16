package vn.com.routex.driver.service.infrastructure.persistence.adapter;

import vn.com.routex.driver.service.domain.product.Product;
import vn.com.routex.driver.service.infrastructure.persistence.repository.ProductRepository;
import vn.com.routex.driver.service.interfaces.records.ProductFilter;
import vn.com.routex.driver.service.interfaces.records.ProductIdFilter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class ProductGatewayAdapter implements ProductGateway {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProductByFilter(ProductFilter filter) {
        return productRepository.findProductByFilter(filter.categoryId(), filter.typeId());
    }

    @Override
    public Product findById(ProductIdFilter filter) {
        return productRepository.findByProductId(filter.productId());
    }
}
