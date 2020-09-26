package com.smart.workmanagement.controller;

import com.smart.workmanagement.dto.CustomerDto;
import com.smart.workmanagement.model.Customer;
import com.smart.workmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listCustomers() {
        List<Customer> customers = customerService.getAllCustomer();

        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(CustomerDto.customerDtoList(customers), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable(name = "id") Long id) {
        Customer customer = customerService.getById(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        CustomerDto result = CustomerDto.fromCustomer(customer);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody @Valid Customer customer) {

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        customerService.create(customer);
        return new ResponseEntity<>(CustomerDto.fromCustomer(customer), HttpStatus.OK);

    }
}
