package vn.com.routex.driver.service.interfaces.models.driver;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.interfaces.models.result.ApiResult;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateProfileResponse {

    private String requestId;
    private String requestDateTime;
    private String channel;

    private ApiResult result;
    private UpdateProfileResponseData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateProfileResponseData {
        private String driverName;
        private String driverCode;
        private String vehicleCode;
        private String employeeCode;
        private String depotId;
        private String shiftId;
        private String emergencyContactName;
        private String emergencyContactPhone;
        private String phoneNumber;
        private String email;
        private String avatarUrl;
        private DriverStatus status = DriverStatus.INACTIVE;
        private UpdateProfileResponse.UpdateProfileResponseAdditional additional;
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
