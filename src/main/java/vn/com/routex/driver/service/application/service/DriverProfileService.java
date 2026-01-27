package vn.com.routex.driver.service.application.service;

import vn.com.routex.driver.service.interfaces.models.driver.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;

public interface DriverProfileService {

    UpdateProfileResponse processDriverProfile(UpdateProfileRequest request);
}
