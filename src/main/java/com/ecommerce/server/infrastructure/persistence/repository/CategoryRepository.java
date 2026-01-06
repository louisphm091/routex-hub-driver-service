package com.ecommerce.server.infrastructure.persistence.repository;

import com.ecommerce.server.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
