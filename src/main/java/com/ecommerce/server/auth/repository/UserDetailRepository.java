package com.ecommerce.server.auth.repository;

import com.ecommerce.server.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bao Pham
 * @created 07/04/2025
 * @project e-commerce application
 **/


@Repository
public interface UserDetailRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
