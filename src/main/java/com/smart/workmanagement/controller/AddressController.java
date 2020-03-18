package com.smart.workmanagement.controller;

import com.smart.workmanagement.dto.AddressDto;
import com.smart.workmanagement.model.Address;
import com.smart.workmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/address/")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    public ResponseEntity<List<AddressDto>> listAddresses() {
        List<Address> addresses = addressService.getAllAddress();

        if (addresses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(AddressDto.addressDtoList(addresses), HttpStatus.OK);
    }
}
