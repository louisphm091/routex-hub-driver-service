package vn.com.routex.driver.service.infrastructure.persistence.repository;
import vn.com.routex.driver.service.domain.customer.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
