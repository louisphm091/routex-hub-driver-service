package com.ecommerce.server.exceptions;

import com.ecommerce.server.dto.result.ApiResult;
import com.smart.pay.transaction.service.interfaces.model.ApiResult;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private String requestId;
    private String requestDateTime;
    private String channel;
    private ApiResult result;

    public BaseException(String requestId, String requestDateTime, String channel, ApiResult result) {
        this.requestId = requestId;
        this.requestDateTime = requestDateTime;
        this.channel = channel;
        this.result = result;
    }

    public BaseException(ApiResult result) {
        this.result = result;
    }
}
