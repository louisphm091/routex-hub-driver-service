package vn.com.routex.driver.service.application.facade;

import org.springframework.http.ResponseEntity;
import vn.com.routex.driver.service.interfaces.models.base.BaseResponse;
import vn.com.routex.driver.service.interfaces.models.driver.request.CreateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DeleteProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.CreateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;

public interface DriverFacade {

    ResponseEntity<UpdateProfileResponse> updateDriverProfile(UpdateProfileRequest request);

    ResponseEntity<CreateProfileResponse> createDriverProfile(CreateProfileRequest request);

    ResponseEntity<DriverProfileResponse> getDriverProfile(DriverProfileRequest driverId);

    ResponseEntity<BaseResponse> deleteDriverProfile(DeleteProfileRequest request);
}