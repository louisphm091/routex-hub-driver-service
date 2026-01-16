package vn.com.routex.driver.service.infrastructure.persistence.mapper;

import vn.com.routex.driver.service.interfaces.models.product.response.ProductDetailResponse;
import vn.com.routex.driver.service.domain.category.Category;
import vn.com.routex.driver.service.domain.product.Product;
import vn.com.routex.driver.service.domain.product.ProductVariant;
import vn.com.routex.driver.service.domain.product.Resources;
import vn.com.routex.driver.service.application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Bao Pham
 * @created 05/04/2025
 * @project routex-hub-driver-service
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
                        .categoryLists(mapCategoryList(tx.getCategories()))
                        .variants(mapVariants(tx.getVariantList()))
                        .productResources(mapResources(tx.getResourcesList()))
                        .build())
                .collect(Collectors.toList());
        response.setData(data);
        return response;
    }

    private Set<ProductDetailResponse.CategoryList> mapCategoryList(Set<Category> list) {
        if(list == null) {
            throw new RuntimeException("CategoryList returns null");
        }

        return list.stream()
                .map(l -> ProductDetailResponse.CategoryList.builder()
                        .categoryId(l.getCategoryId())
                        .categoryName(l.getCategoryName())
                        .categoryTypeId(l.getCategoryTypeId())
                        .build())
                .collect(Collectors.toSet());
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
