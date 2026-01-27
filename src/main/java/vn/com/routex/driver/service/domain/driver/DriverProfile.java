package vn.com.routex.driver.service.domain.driver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.auditing.AbstractAuditingEntity;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "DRIVER_PROFILE")
public class DriverProfile extends AbstractAuditingEntity {

    @Id
    private String id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "DRIVER_CODE")
    private String driverCode;

    @Column(name = "VEHICLE_CODE")
    private String vehicleCode;

    @Column(name = "DEPOT_ID")
    private String depotId;

    @Column(name = "SHIFT_ID")
    private String shiftId;

    @Column(name = "EMPLOYEE_CODE")
    private String employeeCode;

    @Column(name = "EMERGENCY_CONTACT_NAME")
    private String emergencyContactName;

    @Column(name = "EMERGENCEY_CONTACT_PHONE")
    private String emergencyContactPhone;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PROFILE_URL")
    private String profielUrl;

    @Column(name = "POINTS", nullable = false)
    private Integer points = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private DriverStatus status;

    @Column(name = "RATING")
    private Double rating;

    @Column(name = "TOTAL_TRIPS", nullable = false)
    private Long totalTrips = 0L;

    private String licenseClass;
    private String licenseNumber;
    private LocalDate licenseIssueDate;
    private LocalDate licenseExpiryDate;
    private Integer pointsDelta;
    private String pointsReason;
    private String nationalId;
    private LocalDate dob;
    private Boolean kycVerified;
    private Boolean trainingCompleted;
    private String note;
}
