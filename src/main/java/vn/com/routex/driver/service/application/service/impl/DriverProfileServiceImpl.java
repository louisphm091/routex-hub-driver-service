package vn.com.routex.driver.service.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.service.DriverProfileService;
import vn.com.routex.driver.service.domain.driver.DriverProfile;
import vn.com.routex.driver.service.domain.driver.DriverProfileRepository;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.domain.user.User;
import vn.com.routex.driver.service.domain.user.UserRepository;
import vn.com.routex.driver.service.infrastructure.persistence.exceptions.BusinessException;
import vn.com.routex.driver.service.infrastructure.utils.ExceptionUtils;
import vn.com.routex.driver.service.interfaces.models.driver.request.DriverProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.response.UpdateProfileResponse.UpdateProfileResponseAdditional;
import vn.com.routex.driver.service.interfaces.models.result.ApiResult;

import java.util.UUID;
import java.util.function.Consumer;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.DRIVER_NOT_FOUND_MESSAGE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.RECORD_NOT_FOUND;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SUCCESS_CODE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SUCCESS_MESSAGE;

@Service
@RequiredArgsConstructor
public class DriverProfileServiceImpl implements DriverProfileService {

    private final DriverProfileRepository driverProfileRepository;
    private final UserRepository userRepository;


    @Override
    public UpdateProfileResponse processDriverProfile(UpdateProfileRequest request) {

        UpdateProfileRequest.UpdateProfileRequestData data = request.getData();
        DriverProfile profile = driverProfileRepository.findByUserId(request.getData().getUserId())
                .orElseGet(() -> DriverProfile.builder()
                        .id(UUID.randomUUID().toString())
                        .userId(data.getUserId())
                        .status(DriverStatus.INACTIVE)
                        .build());

        applyPathRequest(profile, data);
        driverProfileRepository.save(profile);
        return buildResponse(request);
    }

    @Override
    public DriverProfileResponse getDriverProfile(DriverProfileRequest request) {
        DriverProfile profile = driverProfileRepository.findById(request.getData().getDriverId())
                .orElseThrow(() -> new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, DRIVER_NOT_FOUND_MESSAGE)));

        User user = userRepository.findById(profile.getUserId())
                .orElseThrow(() -> new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, DRIVER_NOT_FOUND_MESSAGE)));

        return DriverProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .data(DriverProfileResponse.DriverProfileResponseData.builder()
                        .driverId(profile.getId())
                        .userId(profile.getUserId())
                        .fullName(user.getFullName())
                        .phone(user.getPhoneNumber())
                        .email(user.getEmail())
                        .status(profile.getStatus())
                        .points(profile.getPointsDelta())
                        .createdAt(profile.getCreatedAt())
                        .updatedAt(profile.getUpdatedAt())
                        .build())
                .build();
    }

    private void applyPathRequest(DriverProfile p, UpdateProfileRequest.UpdateProfileRequestData d) {
        setIfNotNull(d.getEmployeeCode(), p::setEmployeeCode);
        setIfNotNull(d.getEmergencyContactName(), p::setEmergencyContactName);
        setIfNotNull(d.getEmergencyContactPhone(), p::setEmergencyContactPhone);
        setIfNotNull(d.getNote(), p::setNote);

        setIfNotNull(d.getStatus(), s -> p.setStatus(DriverStatus.valueOf(s)));

        if (d.getAdditional() != null) {
            var a = d.getAdditional();
            setIfNotNull(a.getLicenseClass(), p::setLicenseClass);
            setIfNotNull(a.getLicenseNumber(), p::setLicenseNumber);
            setIfNotNull(a.getLicenseExpiryDate(), p::setLicenseExpiryDate);
            setIfNotNull(a.getLicenseIssueDate(), p::setLicenseIssueDate);
            setIfNotNull(a.getPointsDelta(), p::setPointsDelta);
            setIfNotNull(a.getPointsReason(), p::setPointsReason);
            setIfNotNull(a.getKycVerified(), p::setKycVerified);
            setIfNotNull(a.getTrainingCompleted(), p::setTrainingCompleted);
        }
    }

    private <T> void setIfNotNull(T value, Consumer<T> setter) {
        if (value != null) setter.accept(value);
    }

    private UpdateProfileResponse buildResponse(UpdateProfileRequest request) {
        return UpdateProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(ApiResult
                        .builder()
                        .responseCode(SUCCESS_CODE)
                        .description(SUCCESS_MESSAGE)
                        .build())
                .data(UpdateProfileResponse.UpdateProfileResponseData
                        .builder()
                        .employeeCode(request.getData().getEmployeeCode())
                        .emergencyContactName(request.getData().getEmergencyContactName())
                        .emergencyContactPhone(request.getData().getEmergencyContactPhone())
                        .additional(UpdateProfileResponseAdditional.builder()
                                .licenseClass(request.getData().getAdditional().getLicenseClass())
                                .licenseNumber(request.getData().getAdditional().getLicenseNumber())
                                .licenseIssueDate(request.getData().getAdditional().getLicenseIssueDate())
                                .licenseExpiryDate(request.getData().getAdditional().getLicenseExpiryDate())
                                .pointsDelta(request.getData().getAdditional().getPointsDelta())
                                .pointsReason(request.getData().getAdditional().getPointsReason())
                                .kycVerified(request.getData().getAdditional().getKycVerified())
                                .trainingCompleted(request.getData().getAdditional().getTrainingCompleted())
                                .build()
                        )
                        .build())
                .build();
    }
}
