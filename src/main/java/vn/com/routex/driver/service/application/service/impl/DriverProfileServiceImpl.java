package vn.com.routex.driver.service.application.service.impl;

import jdk.dynalink.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.service.DriverProfileService;
import vn.com.routex.driver.service.domain.driver.DriverProfile;
import vn.com.routex.driver.service.domain.driver.DriverProfileRepository;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.domain.driver.OperationStatus;
import vn.com.routex.driver.service.domain.user.User;
import vn.com.routex.driver.service.domain.user.UserRepository;
import vn.com.routex.driver.service.infrastructure.persistence.exceptions.BusinessException;
import vn.com.routex.driver.service.infrastructure.utils.ExceptionUtils;
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
import vn.com.routex.driver.service.interfaces.models.result.ApiResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.DRIVER_NOT_FOUND_MESSAGE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.DUPLICATE_ERROR;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.RECORD_EXISTS;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.RECORD_NOT_FOUND;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.RECORD_NOT_FOUND_MESSAGE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SUCCESS_CODE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SUCCESS_MESSAGE;

@Service
@RequiredArgsConstructor
public class DriverProfileServiceImpl implements DriverProfileService {

    private final DriverProfileRepository driverProfileRepository;
    private final UserRepository userRepository;


    @Override
    public UpdateProfileResponse updateDriverProfile(UpdateProfileRequest request) {
        DriverProfile profile = driverProfileRepository.findById(request.getData().getDriverId())
                .orElseThrow(() -> new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, RECORD_NOT_FOUND_MESSAGE)));
        profile.setEmployeeCode(request.getData().getEmployeeCode());
        profile.setEmergencyContactName(request.getData().getEmergencyContactName());
        profile.setEmergencyContactPhone(request.getData().getEmergencyContactPhone());
        profile.setLicenseNumber(request.getData().getLicenseNumber());
        profile.setLicenseClass(request.getData().getLicenseClass());
        profile.setLicenseIssueDate(LocalDate.parse(request.getData().getLicenseIssueDate()));
        profile.setLicenseExpiryDate(LocalDate.parse(request.getData().getLicenseExpiryDate()));
        profile.setPointsDelta(request.getData().getPointsDelta());
        profile.setPointsReason(request.getData().getPointsReason());
        profile.setKycVerified(request.getData().getKycVerified());
        profile.setTrainingCompleted(request.getData().getTrainingCompleted());
        profile.setNote(request.getData().getNote());
        profile.setStatus(DriverStatus.valueOf(request.getData().getStatus()));
        driverProfileRepository.save(profile);
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
                        .driverId(request.getData().getDriverId())
                        .employeeCode(request.getData().getEmployeeCode())
                        .emergencyContactName(request.getData().getEmergencyContactName())
                        .emergencyContactPhone(request.getData().getEmergencyContactPhone())
                        .status(DriverStatus.valueOf(request.getData().getStatus()))
                        .licenseClass(request.getData().getLicenseClass())
                        .licenseNumber(request.getData().getLicenseNumber())
                        .licenseIssueDate(LocalDate.parse(request.getData().getLicenseIssueDate()))
                        .licenseExpiryDate(LocalDate.parse(request.getData().getLicenseExpiryDate()))
                        .pointsDelta(request.getData().getPointsDelta())
                        .pointsReason(request.getData().getPointsReason())
                        .kycVerified(request.getData().getKycVerified())
                        .trainingCompleted(request.getData().getTrainingCompleted())
                        .note(request.getData().getNote())
                        .build())
                .build();
    }

    @Override
    public CreateProfileResponse createDriverProfile(CreateProfileRequest request) {
        Optional<DriverProfile> profile = driverProfileRepository.findByUserId(request.getData().getUserId());
        if (profile.isPresent()) {
            throw new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                    ExceptionUtils.buildResultResponse(DUPLICATE_ERROR, RECORD_EXISTS));
        }

        CreateProfileRequest.CreateProfileRequestData data = request.getData();

        DriverProfile driver = DriverProfile.builder()
                .id(UUID.randomUUID().toString())
                .userId(data.getUserId())
                .currentRouteId(data.getCurrentRouteId() != null ? data.getCurrentRouteId() : "")
                .employeeCode(data.getEmployeeCode())
                .emergencyContactName(data.getEmergencyContactName())
                .emergencyContactPhone(data.getEmergencyContactPhone())
                .status(DriverStatus.valueOf(data.getStatus()))
                .operationStatus(OperationStatus.AVAILABLE)
                .rating(data.getRating())
                .totalTrips(data.getTotalTrips())
                .licenseClass(data.getLicenseClass())
                .licenseNumber(data.getLicenseNumber())
                .licenseIssueDate(LocalDate.parse(data.getLicenseIssueDate()))
                .licenseExpiryDate(LocalDate.parse(data.getLicenseExpiryDate()))
                .pointsDelta(data.getPointsDelta())
                .pointsReason(data.getPointsReason() != null ? data.getPointsReason() : "")
                .kycVerified(data.isKycVerified())
                .trainingCompleted(data.isTrainingCompleted())
                .note(data.getNote() != null ? data.getNote() : "")
                .build();

        driverProfileRepository.save(driver);

        return CreateProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(ApiResult.builder()
                        .responseCode(SUCCESS_CODE)
                        .description(SUCCESS_MESSAGE)
                        .build())
                .data(CreateProfileResponse.CreateProfileResponseData.builder()
                        .userId(data.getUserId())
                        // Create Procedure and Sequence for DriverCode;
                        .currentRouteId(data.getCurrentRouteId() != null ? data.getCurrentRouteId() : "")
                        .employeeCode(data.getEmployeeCode())
                        .emergencyContactName(data.getEmergencyContactName())
                        .emergencyContactPhone(data.getEmergencyContactPhone())
                        .status(data.getStatus())
                        .operationStatus(OperationStatus.AVAILABLE.name())
                        .rating(data.getRating())
                        .totalTrips(data.getTotalTrips())
                        .licenseClass(data.getLicenseClass())
                        .licenseNumber(data.getLicenseNumber())
                        .licenseIssueDate(data.getLicenseIssueDate())
                        .licenseExpiryDate(data.getLicenseExpiryDate())
                        .pointsDelta(data.getPointsDelta())
                        .pointsReason(data.getPointsReason() != null ? data.getPointsReason() : "")
                        .kycVerified(data.isKycVerified())
                        .trainingCompleted(data.isTrainingCompleted())
                        .note(data.getNote() != null ? data.getNote() : "")
                        .build())
                .build();
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
                        .operationStatus(profile.getOperationStatus())
                        .points(profile.getPointsDelta())
                        .createdAt(profile.getCreatedAt())
                        .updatedAt(profile.getUpdatedAt())
                        .build())
                .build();
    }

    @Override
    public DeleteProfileResponse deleteDriverProfile(DeleteProfileRequest request) {
        DriverProfile profile = driverProfileRepository.findById(request.getData().getDriverId())
                .orElseThrow(() -> new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, RECORD_NOT_FOUND_MESSAGE)));

        if (DriverStatus.DELETED.equals(profile.getStatus())) {
            return DeleteProfileResponse.builder()
                    .requestId(request.getRequestId())
                    .requestDateTime(request.getRequestDateTime())
                    .channel(request.getChannel())
                    .result(ApiResult.builder()
                            .responseCode(SUCCESS_CODE)
                            .description(SUCCESS_MESSAGE)
                            .build())
                    .data(DeleteProfileResponse.DeleteProfileResponseData.builder()
                            .driverId(request.getData().getDriverId())
                            .status(DriverStatus.DELETED)
                            .operationStatus(OperationStatus.NOT_AVAILABLE)
                            .build())
                    .build();
        }

        profile.setStatus(DriverStatus.DELETED);
        profile.setOperationStatus(OperationStatus.NOT_AVAILABLE);
        profile.setUpdatedAt(LocalDateTime.now());
        driverProfileRepository.save(profile);

        return DeleteProfileResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(ApiResult.builder()
                        .responseCode(SUCCESS_CODE)
                        .description(SUCCESS_MESSAGE)
                        .build())
                .data(DeleteProfileResponse.DeleteProfileResponseData.builder()
                        .driverId(request.getData().getDriverId())
                        .status(DriverStatus.DELETED)
                        .operationStatus(OperationStatus.NOT_AVAILABLE)
                        .build())
                .build();
    }

    @Override
    public UpdateDriverStatusResponse updateDriverStatus(UpdateDriverStatusRequest request) {
        DriverProfile profile = driverProfileRepository.findById(request.getData().getDriverId())
                .orElseThrow(() -> new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                        ExceptionUtils.buildResultResponse(RECORD_NOT_FOUND, RECORD_NOT_FOUND_MESSAGE)));

        String status = request.getData().getStatus();
        String operationStatus = request.getData().getOperationStatus();

        if(status != null)
            profile.setStatus(DriverStatus.valueOf(request.getData().getStatus()));

        if(operationStatus != null)
            profile.setOperationStatus(OperationStatus.valueOf(request.getData().getOperationStatus()));

        profile.setUpdatedAt(LocalDateTime.now());

        return UpdateDriverStatusResponse.builder()
                .requestId(request.getRequestId())
                .requestDateTime(request.getRequestDateTime())
                .channel(request.getChannel())
                .result(ApiResult.builder()
                        .responseCode(SUCCESS_CODE)
                        .description(SUCCESS_MESSAGE)
                        .build())
                .data(UpdateDriverStatusResponse.UpdateDriverStatusResponseData.builder()
                        .driverId(request.getData().getDriverId())
                        .status(status != null ? DriverStatus.valueOf(request.getData().getStatus()) : profile.getStatus())
                        .operationStatus(operationStatus != null ? OperationStatus.valueOf(request.getData().getOperationStatus()) : profile.getOperationStatus())
                        .build())
                .build();
    }
}
