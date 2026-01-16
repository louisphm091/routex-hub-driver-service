package vn.com.routex.driver.service.application.services;

import vn.com.routex.driver.service.domain.product.Product;
import vn.com.routex.driver.service.infrastructure.persistence.adapter.ProductGateway;
import vn.com.routex.driver.service.infrastructure.persistence.mapper.ProductMapper;
import vn.com.routex.driver.service.interfaces.models.product.request.ProductDetailRequest;
import vn.com.routex.driver.service.interfaces.models.product.request.UpdateProductRequest;
import vn.com.routex.driver.service.interfaces.models.product.response.UpdateProductResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.UploadProductResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.ProductDetailResponse;
import vn.com.routex.driver.service.interfaces.models.product.request.UploadProductRequest;
import vn.com.routex.driver.service.interfaces.records.ProductFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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