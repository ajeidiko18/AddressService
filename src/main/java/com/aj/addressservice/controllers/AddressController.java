package com.aj.addressservice.controllers;

import com.aj.addressservice.response.AddressResponse;
import com.aj.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {


    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {

        List<AddressResponse> response = addressService.getAllAddresses();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id) {

        AddressResponse addressResponse = addressService.getAddressById(id);

        if (addressResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);


    }
}
