package com.ecommerce.server.infrastructure.persistence.mapper;

import com.ecommerce.server.interfaces.models.request.product.ProductDetailResponse;
import com.ecommerce.server.domain.category.Category;
import com.ecommerce.server.domain.product.Product;
import com.ecommerce.server.domain.product.ProductVariant;
import com.ecommerce.server.domain.product.Resources;
import com.ecommerce.server.application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bao Pham
 * @created 05/04/2025
 * @project e-commerce application
 **/

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private CategoryService categoryService;


    public ProductDetailResponse mapToProductDetailResponse(List<Product> product) {
        ProductDetailResponse response = new ProductDetailResponse();
        List<ProductDetailResponse.ProductDetailResponseData> data = product
                .stream()
                .map(tx -> ProductDetailResponse.ProductDetailResponseData
                        .builder()
                        .productId(tx.getProductId())
                        .productName(tx.getProductName())
                        .description(tx.getDescription())
                        .price(tx.getSellingPrice())
                        .isNewArrival(tx.isNewArrival())
                        .thumbnail(tx.getThumbnail())
                        .slug(tx.getSlug())
                        .categoryLists(mapCategoryList(tx.getCategoryList()))
                        .variants(mapVariants(tx.getVariantList()))
                        .productResources(mapResources(tx.getResourcesList()))
                        .build())
                .collect(Collectors.toList());
        response.setData(data);
        return response;
    }

    private List<ProductDetailResponse.CategoryList> mapCategoryList(List<Category> list) {
        if(list == null) {
            throw new RuntimeException("CategoryList returns null");
        }

        return list.stream()
                .map(l -> ProductDetailResponse.CategoryList.builder()
                        .categoryId(l.getCategoryId())
                        .categoryName(l.getCategoryName())
                        .categoryTypeId(l.getCategoryTypeId())
                        .build())
                .collect(Collectors.toList());
    }

    private List<ProductDetailResponse.ProductVariantDetail> mapVariants(
            List<ProductVariant> variants) {

        if (variants == null) {
            throw new RuntimeException("Variants returns null");
        }

        return variants.stream()
                .map(v -> ProductDetailResponse.ProductVariantDetail.builder()
                        .id(v.getVariantId())
                        .size(v.getSize())
                        .stockQuantity(Integer.parseInt(v.getStockQuantity()))
                        .build()
                )
                .collect(Collectors.toList());
    }

    private static List<ProductDetailResponse.ProductResourceDetail> mapResources(
            List<Resources> resources) {

        if (resources == null) {
            throw new RuntimeException("Resources returns null");
        }

        return resources.stream()
                .map(r -> ProductDetailResponse.ProductResourceDetail.builder()
                        .id(r.getId())
                        .type(r.getType())
                        .url(r.getUrl())
                        .isPrimary(r.getIsPrimary())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
