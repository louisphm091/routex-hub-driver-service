package vn.com.routex.driver.service.interfaces.models.driver.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.interfaces.models.base.BaseResponse;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateProfileResponse extends BaseResponse {
    private UpdateProfileResponseData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateProfileResponseData {
        private String driverCode;
        private String vehicleCode;
        private String employeeCode;
        private String depotId;
        private String emergencyContactName;
        private String emergencyContactPhone;
        private String phoneNumber;
        private String email;
        private DriverStatus status = DriverStatus.INACTIVE;
        private UpdateProfileResponseAdditional additional;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateProfileResponseAdditional {
        private String licenseNumber;
        private String licenseClass;
        private LocalDate licenseIssueDate;
        private LocalDate licenseExpiryDate;
        private Integer pointsDelta;
        private String pointsReason;
        private String nationalId;
        private LocalDate dob;
        private Boolean kycVerified;
        private Boolean trainingCompleted;

    }
}
