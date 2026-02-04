package vn.com.routex.driver.service.interfaces.models.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import vn.com.routex.driver.service.interfaces.models.result.ApiResult;

@Getter
@Setter
@SuperBuilder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private String requestId;
    private String requestDateTime;
    private String channel;
    private ApiResult result;
}
