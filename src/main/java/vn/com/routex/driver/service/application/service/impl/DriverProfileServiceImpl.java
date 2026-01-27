package vn.com.routex.driver.service.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.service.DriverProfileService;
import vn.com.routex.driver.service.domain.driver.DriverProfile;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.infrastructure.persistence.exceptions.BusinessException;
import vn.com.routex.driver.service.infrastructure.persistence.repository.DriverProfileRepository;
import vn.com.routex.driver.service.infrastructure.utils.ExceptionUtils;
import vn.com.routex.driver.service.interfaces.models.driver.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;

import java.util.UUID;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.RECORD_NOT_FOUND;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.RECORD_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class DriverProfileServiceImpl implements DriverProfileService {

    private final DriverProfileRepository driverProfileRepository;

    @Override
    public UpdateProfileResponse processDriverProfile(UpdateProfileRequest request) {
        boolean isExists = driverProfileRepository.existsByUserId(request.getData().getDriverCode());
        if(isExists)
            return updateDriverProfile(request);
        return createDriverProfile(request);
    }

    private UpdateProfileResponse createDriverProfile(UpdateProfileRequest request) {
        DriverProfile driverProfile = DriverProfile.builder()
                .id(UUID.randomUUID().toString())
                .userId(request.getData().getUserId())
                .status(DriverStatus.INACTIVE)
                .build();
        driverProfileRepository.save(driverProfile);

        return buildResponse();

    }

    private UpdateProfileResponse updateDriverProfile(UpdateProfileRequest request) {
        DriverProfile driverProfile = driverProfileRepository.findByUserId(request.getData().getUserId())
                .orElseThrow(() -> new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, RECORD_NOT_FOUND_MESSAGE)));

        UpdateProfileRequest.UpdateProfileRequestData data = request.getData();
        driverProfile.setDriverCode(data.getDriverCode());
        driverProfile.setVehicleCode(data.getVehicleCode());
        driverProfile.setDepotId(data.getDepotId());
        driverProfile.setShiftId(data.getShiftId());
        driverProfile.setEmployeeCode(data.getEmployeeCode());
        driverProfile.setEmergencyContactName(data.getEmergencyContactName());
        driverProfile.setEmergencyContactPhone(data.getEmergencyContactPhone());
        driverProfile.setPhoneNumber(data.getPhoneNumber());
        driverProfile.setEmail(data.getEmail());
        driverProfile.setProfielUrl(data.getProfileUrl());
        driverProfile.setStatus(DriverStatus.valueOf(data.getStatus()));
        driverProfile.setNote(data.getNote());
        driverProfile.setLicenseClass(data.getAdditional().getLicenseClass());
        driverProfile.setLicenseNumber(data.getAdditional().getLicenseNumber());
        driverProfile.setLicenseExpiryDate(data.getAdditional().getLicenseExpiryDate());
        driverProfile.setLicenseIssueDate(data.getAdditional().getLicenseIssueDate());
        driverProfile.setPointsDelta(data.getAdditional().getPointsDelta());
        driverProfile.setPointsReason(data.getAdditional().getPointsReason());
        driverProfile.setNationalId(data.getAdditional().getNationalId());
        driverProfile.setDob(data.getAdditional().getDob());
        driverProfile.setKycVerified(data.getAdditional().getKycVerified());
        driverProfile.setTrainingCompleted(data.getAdditional().getTrainingCompleted());

        return buildResponse();
    }

    private UpdateProfileResponse buildResponse() {
        return null;
    }
}
