package vn.com.routex.driver.service.application.service;

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

public interface DriverProfileService {

    UpdateProfileResponse updateDriverProfile(UpdateProfileRequest request);

    CreateProfileResponse createDriverProfile(CreateProfileRequest request);

    DriverProfileResponse getDriverProfile(DriverProfileRequest request);

    DeleteProfileResponse deleteDriverProfile(DeleteProfileRequest request);

    UpdateDriverStatusResponse updateDriverStatus(UpdateDriverStatusRequest request);
}
