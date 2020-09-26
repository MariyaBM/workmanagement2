package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    void create(Customer customer);

    void delete(Long id);

    List<Customer> getAllCustomer();
}
