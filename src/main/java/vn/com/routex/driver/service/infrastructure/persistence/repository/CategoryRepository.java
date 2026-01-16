package vn.com.routex.driver.service.infrastructure.persistence.repository;

import vn.com.routex.driver.service.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project ecom-hub-product-service
 **/

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
