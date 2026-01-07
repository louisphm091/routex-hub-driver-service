package com.ecommerce.server.interfaces.controller;

import com.ecommerce.server.interfaces.models.AddressRequest;
import com.ecommerce.server.domain.customer.Address;
import com.ecommerce.server.application.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 08/04/2025
 * @project ecom-hub-product-service
 **/


@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest, Principal principal){
        Address address = addressService.createAddress(addressRequest,principal);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable UUID id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
