package com.ecommerce.server.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bao Pham
 * @created 07/04/2025
 * @project e-commerce application
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationResponse {
    private int code;
    private String message;
}
