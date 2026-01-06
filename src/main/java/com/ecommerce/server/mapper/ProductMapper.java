package com.ecommerce.server.mapper;

import com.ecommerce.server.dto.request.product.ProductDetailResponse;
import com.ecommerce.server.entities.Category;
import com.ecommerce.server.entities.Product;
import com.ecommerce.server.entities.ProductVariant;
import com.ecommerce.server.entities.Resources;
import com.ecommerce.server.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bao Pham
 * @created 05/04/2025
 * @project e-commerce application
 **/

@Component
public class ProductMapper {

    @Autowired
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
        if(list == null) return List.of();

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

        if (variants == null) return List.of();

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

        if (resources == null) return List.of();

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
