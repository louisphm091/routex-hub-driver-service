package com.ecommerce.server.infrastructure.persistence.repository;

import com.ecommerce.server.domain.auth.entities.User;
import com.ecommerce.server.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findByUser(User user);
}
