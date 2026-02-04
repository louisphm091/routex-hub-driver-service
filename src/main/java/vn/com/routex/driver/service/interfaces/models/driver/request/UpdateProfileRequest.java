package vn.com.routex.driver.service.interfaces.models.driver.request;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.interfaces.models.base.BaseRequest;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateProfileRequest extends BaseRequest {

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

        // Generate if empty or null;
        private String employeeCode;
        @NotBlank
        @NotNull
        private String emergencyContactName;
        @NotBlank
        @NotNull
        private String emergencyContactPhone;
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
        private Boolean kycVerified;

        @NotBlank
        @NotNull
        private Boolean trainingCompleted;

    }
}
