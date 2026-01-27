package vn.com.routex.driver.service.domain.route;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.routex.driver.service.domain.auditing.AbstractAuditingEntity;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROUTE")
public class Route extends AbstractAuditingEntity {

    @Id
    private String id;
    private String routeCode;
    private String origin;
    private String destination;
    private OffsetDateTime plannedStartTime;
    private OffsetDateTime plannedEndTime;
    private OffsetDateTime actualStartTime;
    private OffsetDateTime actualEndTime;
    @Enumerated(EnumType.STRING)
    private RouteStatus status;
    private String vehicleId;
    private String driverId;
}
