package com.ecommerce.server.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bao Pham
 * @created 07/04/2025
 * @project ecom-hub-product-service
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationResponse {
    private int code;
    private String message;
}
