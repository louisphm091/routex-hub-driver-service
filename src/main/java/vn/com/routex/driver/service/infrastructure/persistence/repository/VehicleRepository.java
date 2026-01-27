package vn.com.routex.driver.service.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.domain.vehicle.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
