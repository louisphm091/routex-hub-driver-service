package vn.com.routex.driver.service.interfaces.models.driver.response;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.interfaces.models.base.BaseResponse;
import vn.com.routex.driver.service.interfaces.models.result.ApiResult;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DriverProfileResponse extends BaseResponse {

    @Valid
    @NotNull
    private DriverProfileResponseData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class DriverProfileResponseData {
        private String driverId;
        private String driverCode;
        private String userId;
        private String fullName;
        private String phone;
        private String email;
        private DriverStatus status;
        private String availability;
        private String vehicleCode;
        private String routeId;
        private String shiftId;
        private String depotId;
        private String avatarUrl;
        private Integer points;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

}
