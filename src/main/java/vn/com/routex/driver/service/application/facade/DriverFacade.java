package vn.com.routex.driver.service.application.facade;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import vn.com.routex.driver.service.interfaces.models.driver.request.CreateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DeleteProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateDriverStatusRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.CreateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DeleteProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateDriverStatusResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;

public interface DriverFacade {

    ResponseEntity<UpdateProfileResponse> updateDriverProfile(UpdateProfileRequest request);

    ResponseEntity<CreateProfileResponse> createDriverProfile(CreateProfileRequest request);

    ResponseEntity<DriverProfileResponse> getDriverProfile(DriverProfileRequest driverId);

    ResponseEntity<DeleteProfileResponse> deleteDriverProfile(DeleteProfileRequest request);

    ResponseEntity<UpdateDriverStatusResponse> updateDriverStatus(UpdateDriverStatusRequest request);
}