package vn.com.routex.driver.service.application.facade;

import org.springframework.http.ResponseEntity;
import vn.com.routex.driver.service.interfaces.models.driver.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;

public interface DriverFacade {

    ResponseEntity<UpdateProfileResponse> updateDriverProfile(UpdateProfileRequest request);
}
