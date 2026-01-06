package com.ecommerce.server.infrastructure.persistence.repository;

import com.ecommerce.server.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findBySlug(String slug);

    @Query(
            value = """
            SELECT DISTINCT p.*
            FROM product p
            JOIN category c ON c.product_id = p.product_id
            WHERE (:categoryId IS NULL OR c.category_id = :categoryId)
              AND (:typeId IS NULL OR c.category_type_id = :typeId)
        """,
            nativeQuery = true
    )
    List<Product> findProductByFilter(
            @Param("categoryId") String categoryId,
            @Param("typeId") String typeId
    );
}
