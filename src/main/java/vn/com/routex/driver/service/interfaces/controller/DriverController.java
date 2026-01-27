package vn.com.routex.driver.service.interfaces.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.routex.driver.service.application.facade.DriverFacade;
import vn.com.routex.driver.service.interfaces.models.driver.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_PATH;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_VERSION;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.DRIVER_PREFIX;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.PROFILE;

@RestController
@RequestMapping(API_PATH + API_VERSION + DRIVER_PREFIX)
@RequiredArgsConstructor
public class DriverController {

    private final DriverFacade driverFacade;

    @PostMapping(PROFILE)
    public ResponseEntity<UpdateProfileResponse> updateDriverProfile(@Valid @RequestBody UpdateProfileRequest request) {
        return driverFacade.updateDriverProfile(request);
    }
}
