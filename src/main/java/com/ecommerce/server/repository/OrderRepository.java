package com.ecommerce.server.repository;

import com.ecommerce.server.auth.entities.User;
import com.ecommerce.server.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import org.devlearn.lvshopserver.entities.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findByUser(User user);
}
