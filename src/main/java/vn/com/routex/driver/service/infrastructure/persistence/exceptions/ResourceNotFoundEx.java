package vn.com.routex.driver.service.infrastructure.persistence.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project ecom-hub-product-service
 **/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundEx extends RuntimeException {
    public ResourceNotFoundEx(String s) {
        super(s);
    }


    public ResourceNotFoundEx(String s, Throwable cause) {
        super(s, cause);
    }
}
