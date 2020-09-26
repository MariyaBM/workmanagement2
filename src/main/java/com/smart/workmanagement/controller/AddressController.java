package com.smart.workmanagement.controller;

import com.smart.workmanagement.dto.AddressDto;
import com.smart.workmanagement.model.Address;
import com.smart.workmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/address/")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> listAddresses() {
        List<Address> addresses = addressService.getAllAddress();

        if (addresses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(AddressDto.addressDtoList(addresses), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable(name = "id") Long id) {
        Address address = addressService.getById(id);

        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AddressDto result = AddressDto.fromAddress(address);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> saveAddress(@RequestBody @Valid Address address) {

        if (address == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        addressService.create(address);
        return new ResponseEntity<>(AddressDto.fromAddress(address), HttpStatus.OK);

    }
}
