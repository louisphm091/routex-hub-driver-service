package vn.com.routex.driver.service.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.domain.driver.DriverProfile;

import java.util.Optional;

@Repository
public interface DriverProfileRepository extends JpaRepository<DriverProfile, String> {

    boolean existsByUserId(String userId);
    Optional<DriverProfile> findByUserId(String userId);
}