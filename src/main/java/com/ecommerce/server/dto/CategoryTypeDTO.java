package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project e-commerce application
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryTypeDTO {


    private UUID id;
    private String name;
    private String code;
    private String description;
}
