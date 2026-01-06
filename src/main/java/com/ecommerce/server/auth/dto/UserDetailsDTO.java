package com.ecommerce.server.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ecommerce.server.entities.Address;

import java.util.List;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 08/04/2025
 * @project e-commerce application
 **/


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Object authorityList;
    private List<Address> addressList;
}
