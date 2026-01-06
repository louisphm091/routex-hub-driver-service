package com.ecommerce.server.infrastructure.persistence.repository;
import com.ecommerce.server.domain.customer.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
