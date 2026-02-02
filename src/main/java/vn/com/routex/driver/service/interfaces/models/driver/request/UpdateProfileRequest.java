package vn.com.routex.driver.service.interfaces.models.driver.request;

import jakarta.persistence.Lob;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.interfaces.models.base.BaseRequest;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateProfileRequest extends BaseRequest {

    @Valid
    @NotNull
    private UpdateProfileRequestData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateProfileRequestData {

        @NotBlank
        @NotNull
        private String userId;
        @NotBlank
        @NotNull
        private String driverName;
        private String driverCode;
        private String vehicleCode;
        private String employeeCode;
        private String depotId;
        private String shiftId;
        @NotBlank
        @NotNull
        private String emergencyContactName;
        @NotBlank
        @NotNull
        private String emergencyContactPhone;
        @NotBlank
        @NotNull
        private String phoneNumber;
        @NotBlank
        @NotNull
        private String email;
        private String profileUrl;
        private String status;
        private UpdateProfileRequestAdditional additional;
        @Lob
        private String note;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateProfileRequestAdditional {

        @NotBlank
        @NotNull
        private String licenseNumber;

        @NotBlank
        @NotNull
        private String licenseClass;

        @NotBlank
        @NotNull
        private LocalDate licenseIssueDate;

        @NotBlank
        @NotNull
        private LocalDate licenseExpiryDate;
        private Integer pointsDelta;
        private String pointsReason;

        @NotBlank
        @NotNull
        private String nationalId;

        @NotBlank
        @NotNull
        private LocalDate dob;

        @NotBlank
        @NotNull
        private Boolean kycVerified;

        @NotBlank
        @NotNull
        private Boolean trainingCompleted;

    }
}
