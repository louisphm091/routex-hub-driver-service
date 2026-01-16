package vn.com.routex.driver.service.infrastructure.persistence.exceptions;

import vn.com.routex.driver.service.interfaces.models.result.ApiResult;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class BusinessException extends BaseException {

    public BusinessException(String requestId, String requestDateTime, String channel, ApiResult result) {
        super(requestId, requestDateTime, channel, result);
    }

    public BusinessException(ApiResult result) { super(result); }
}
