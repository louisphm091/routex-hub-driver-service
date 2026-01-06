package com.ecommerce.server.utils;

import com.ecommerce.server.dto.result.ApiResult;
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
