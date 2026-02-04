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

    private String userId;
    private String driverCode;
    private String emloyeeCode;
}
