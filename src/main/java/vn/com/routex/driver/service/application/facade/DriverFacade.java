package vn.com.routex.driver.service.application.facade;

import org.springframework.http.ResponseEntity;
import vn.com.routex.driver.service.interfaces.models.driver.request.CreateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.CreateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;

public interface DriverFacade {

    ResponseEntity<UpdateProfileResponse> updateDriverProfile(UpdateProfileRequest request);

    ResponseEntity<CreateProfileResponse> createDriverProfile(CreateProfileRequest request);

    ResponseEntity<DriverProfileResponse> getDriverProfile(DriverProfileRequest driverId);
}