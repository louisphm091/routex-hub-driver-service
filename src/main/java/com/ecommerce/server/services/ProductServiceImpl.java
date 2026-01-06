package com.ecommerce.server.services;

import com.ecommerce.server.dto.ProductDto;
import com.ecommerce.server.dto.product.ProductDetailRequest;
import com.ecommerce.server.dto.request.product.ProductDetailResponse;
import com.ecommerce.server.entities.Product;
import lombok.RequiredArgsConstructor;
import org.devlearn.lvshopserver.entities.*;
import com.ecommerce.server.exceptions.ResourceNotFoundEx;
import com.ecommerce.server.mapper.ProductMapper;
import com.ecommerce.server.repository.ProductRepository;
import com.ecommerce.server.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import org.apache.coyote.BadRequestException;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryService categoryService;
    private ProductMapper productMapper;
    
    @Override
    public ProductDetailResponse getAllProducts(ProductDetailRequest request) {

        Specification<Product> productSpecification= Specification.where(null);

        if(null != request.getData().getCategoryId()){
            productSpecification = productSpecification.and(ProductSpecification.hasCategoryID(request.getData().getCategoryId()));
        }
        if(null != request.getData().getTypeId()){
            productSpecification = productSpecification.and(ProductSpecification.hasCategoryTypeID(request.getData().getTypeId()));
        }

        List<Product> products = productRepository.findAll(productSpecification);
        return productMapper.getProductDtos(products);
    }

    @Override
    public ProductDetailResponse getProductBySlug(String slug) {
        Product product= productRepository.findBySlug(slug);
        if(null == product){
            throw new ResourceNotFoundEx("Product Not Found!");
        }
        ProductDetailResponse productDto = productMapper.mapProductToDto(product);
        productDto.getData().setCategoryId(product.getCategory().getId());
        productDto.getData().setCategoryTypeId(product.getCategoryType().getId());
        productDto.setVariants(productMapper.mapProductVariantListToDto(product.getProductVariants()));
        productDto.setProductResources(productMapper.mapProductResourcesListDto(product.getResources()));
        return productDto;
    }

    @Override
    public ProductDetailResponse getProductById(UUID id) {
        Product product= productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundEx("Product Not Found!"));
        ProductDetailResponse productDto = productMapper.mapProductToDto(product);
        productDto.getData().setCategoryId(product.getCategory().getId());
        productDto.getData().setCategoryTypeId(product.getCategoryType().getId());
        productDto.setVariants(productMapper.mapProductVariantListToDto(product.getProductVariants()));
        productDto.setProductResources(productMapper.mapProductResourcesListDto(product.getResources()));
        return productDto;
    }

    @Override
    public Product addProduct(ProductDetailResponse productDto) {
        Product product = productMapper.mapToProductEntity(productDto);
        return productRepository.save(product);
    }
    @Override
    public Product updateProduct(ProductDetailResponse productDto, UUID id) {
        Product product= productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundEx("Product Not Found!"));
        productDto.getData().setId(product.getId());
        return productRepository.save(productMapper.mapToProductEntity(productDto));
    }

    @Override
    public Product fetchProductById(UUID id) throws Exception {
        return productRepository.findById(id).orElseThrow(BadRequestException::new);
    }


}