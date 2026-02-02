package vn.com.routex.driver.service.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.routex.driver.service.application.service.DriverProfileService;
import vn.com.routex.driver.service.domain.driver.DriverProfile;
import vn.com.routex.driver.service.domain.driver.DriverStatus;
import vn.com.routex.driver.service.infrastructure.persistence.repository.DriverProfileRepository;
import vn.com.routex.driver.service.interfaces.models.driver.UpdateProfileResponse;
import vn.com.routex.driver.service.interfaces.models.driver.UpdateProfileResponse.UpdateProfileResponseAdditional;
import vn.com.routex.driver.service.interfaces.models.driver.UpdateProfileResponse.UpdateProfileResponseData;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest;
import vn.com.routex.driver.service.interfaces.models.driver.request.UpdateProfileRequest.UpdateProfileRequestData;
import vn.com.routex.driver.service.interfaces.models.result.ApiResult;

import java.util.UUID;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SUCCESS_CODE;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SUCCESS_MESSAGE;

@Service
@RequiredArgsConstructor
public class DriverProfileServiceImpl implements DriverProfileService {

    private final DriverProfileRepository driverProfileRepository;

    @Override
    public UpdateProfileResponse processDriverProfile(UpdateProfileRequest request) {

        UpdateProfileRequestData data = request.getData();
        DriverProfile profile = driverProfileRepository.findByDriverCode(data.getDriverCode())
                .orElseGet(() -> DriverProfile.builder()
                        .id(UUID.randomUUID().toString())
                        .driverCode(data.getDriverCode())
                        .userId(data.getUserId())
                        .status(DriverStatus.INACTIVE)
                        .build());

        applyPathRequest(profile, data);
        driverProfileRepository.save(profile);
        return buildResponse(request);
    }

    private void applyPathRequest(DriverProfile p, UpdateProfileRequestData d) {
        setIfNotNull(d.getVehicleCode(), p::setVehicleCode);
        setIfNotNull(d.getDepotId(), p::setDepotId);
        setIfNotNull(d.getShiftId(), p::setShiftId);
        setIfNotNull(d.getEmployeeCode(), p::setEmployeeCode);
        setIfNotNull(d.getEmergencyContactName(), p::setEmergencyContactName);
        setIfNotNull(d.getEmergencyContactPhone(), p::setEmergencyContactPhone);
        setIfNotNull(d.getPhoneNumber(), p::setPhoneNumber);
        setIfNotNull(d.getEmail(), p::setEmail);
        setIfNotNull(d.getProfileUrl(), p::setProfielUrl);
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
            setIfNotNull(a.getNationalId(), p::setNationalId);
            setIfNotNull(a.getDob(), p::setDob);
            setIfNotNull(a.getKycVerified(), p::setKycVerified);
            setIfNotNull(a.getTrainingCompleted(), p::setTrainingCompleted);
        }
    }

    private <T> void setIfNotNull(T value, java.util.function.Consumer<T> setter) {
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
                .data(UpdateProfileResponseData
                        .builder()
                        .additional(UpdateProfileResponseAdditional.builder()
                                .licenseClass(request.getData().getAdditional().getLicenseClass())
                                .licenseNumber(request.getData().getAdditional().getLicenseNumber())
                                .licenseIssueDate(request.getData().getAdditional().getLicenseIssueDate())
                                .licenseExpiryDate(request.getData().getAdditional().getLicenseExpiryDate())
                                .pointsDelta(request.getData().getAdditional().getPointsDelta())
                                .pointsReason(request.getData().getAdditional().getPointsReason())
                                .nationalId(request.getData().getAdditional().getNationalId())
                                .dob(request.getData().getAdditional().getDob())
                                .kycVerified(request.getData().getAdditional().getKycVerified())
                                .trainingCompleted(request.getData().getAdditional().getTrainingCompleted())
                                .build()
                        )
                        .build())
                .build();
    }
}
