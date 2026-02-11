package vn.com.routex.driver.service.interfaces.models.driver.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.interfaces.models.base.BaseResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateDriverStatusResponse extends BaseResponse {

    private UpdateDriverStatusResponseData data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    public static class UpdateDriverStatusResponseData {
        private String driverId;
        private DriverStatus status;
    }
}
