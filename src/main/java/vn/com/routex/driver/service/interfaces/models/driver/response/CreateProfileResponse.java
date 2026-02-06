package vn.com.routex.driver.service.interfaces.models.driver.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.interfaces.models.base.BaseResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateProfileResponse extends BaseResponse {

    private CreateProfileResponseData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class CreateProfileResponseData {
        private String userId;
        private String driverCode;
        private String employeeCode;
        private String currentRouteId;
        private String emergencyContactName;
        private String emergencyContactPhone;
        private String status;
        private double rating;
        private int totalTrips;
        private String licenseClass;
        private String licenseNumber;
        private String licenseIssueDate;
        private String licenseExpiryDate;
        private long pointsDelta;
        private String pointsReason;
        private boolean kycVerified;
        private boolean trainingCompleted;
        private String note;
    }
}
