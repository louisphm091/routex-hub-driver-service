package com.ecommerce.server.domain.auth.repository;

import com.ecommerce.server.domain.auth.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Bao Pham
 * @created 07/04/2025
 * @project ecom-hub-product-service
 **/

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
    Authority findByRoleCode(String user);
}
