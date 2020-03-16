package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Customer;
import com.smart.workmanagement.repo.AddressRepo;
import com.smart.workmanagement.repo.CustomerRepo;
import com.smart.workmanagement.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final AddressRepo addressRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, AddressRepo addressRepo) {
        this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
    }

    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerRepo.findAll();
        log.info("IN getAll - {} orders found", customers.size());
        return customers;
    }
}
