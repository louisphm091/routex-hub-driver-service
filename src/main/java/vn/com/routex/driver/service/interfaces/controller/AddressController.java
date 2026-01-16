package vn.com.routex.driver.service.interfaces.controller;

import vn.com.routex.driver.service.interfaces.models.AddressRequest;
import vn.com.routex.driver.service.domain.customer.Address;
import vn.com.routex.driver.service.application.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

/**
 * @author Bao Pham
 * @created 08/04/2025
 * @project routex-hub-driver-service
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
