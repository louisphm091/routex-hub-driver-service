package vn.com.routex.driver.service.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.routex.driver.service.domain.route.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {
}
