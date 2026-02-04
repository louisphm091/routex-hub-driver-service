package vn.com.routex.driver.service.application.service;

import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;

public interface DriverProfileService {

    UpdateProfileResponse processDriverProfile(UpdateProfileRequest request);

    DriverProfileResponse getDriverProfile(DriverProfileRequest driverId);
}
