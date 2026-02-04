package vn.com.routex.driver.service.application.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.service.DriverProfileService;
import vn.com.routex.driver.service.infrastructure.persistence.exceptions.BusinessException;
import vn.com.routex.driver.service.infrastructure.utils.ExceptionUtils;
import vn.com.routex.driver.service.interfaces.models.driver.request.CreateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.CreateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.TIMEOUT_ERROR;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.TIMEOUT_ERROR_MESSAGE;

@Service
@RequiredArgsConstructor
public class DriverFacadeImpl implements DriverFacade {

    private final DriverProfileService driverProfileService;

    @Override
    public ResponseEntity<UpdateProfileResponse> updateDriverProfile(UpdateProfileRequest request) {
        UpdateProfileResponse response = driverProfileService.processDriverProfile(request);
        if (response == null) {
            throw new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                    ExceptionUtils.buildResultResponse(TIMEOUT_ERROR, TIMEOUT_ERROR_MESSAGE));
        }
        response.setRequestId(request.getRequestId());
        response.setRequestDateTime(request.getRequestDateTime());
        response.setChannel(request.getChannel());
        if (response.getData() == null) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateProfileResponse> createDriverProfile(CreateProfileRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<DriverProfileResponse> getDriverProfile(DriverProfileRequest request) {
        DriverProfileResponse response = driverProfileService.getDriverProfile(request);
        if(response == null) {
            throw new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                    ExceptionUtils.buildResultResponse(TIMEOUT_ERROR, TIMEOUT_ERROR_MESSAGE));
        }
        response.setRequestId(request.getRequestId());
        response.setRequestDateTime(request.getRequestDateTime());
        response.setChannel(request.getChannel());
        if(response.getData() == null) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
