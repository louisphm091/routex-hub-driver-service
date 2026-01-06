package com.ecommerce.server.infrastructure.utils;

import com.ecommerce.server.interfaces.models.result.ApiResult;
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
