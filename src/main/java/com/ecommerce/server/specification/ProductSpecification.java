package com.ecommerce.server.specification;

import com.ecommerce.server.entities.Product;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Bao Pham
 * @created 02/04/2025
 * @project e-commerce application
 **/
public class ProductSpecification {


    public static Specification<Product> hasCategoryID(String categoryID) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category").get("id"), categoryID);
    }

    public static Specification<Product> hasCategoryTypeID(String typeID) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("categoryType").get("id"), typeID);
    }
}
