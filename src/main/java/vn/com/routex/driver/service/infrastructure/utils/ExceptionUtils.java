package vn.com.routex.driver.service.infrastructure.utils;

import vn.com.routex.driver.service.interfaces.models.result.ApiResult;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionUtils {

    public ApiResult buildResultResponse(String responseCode, String description) {
        return ApiResult.builder()
                .responseCode(responseCode)
                .description(description)
                .build();
    }
}
