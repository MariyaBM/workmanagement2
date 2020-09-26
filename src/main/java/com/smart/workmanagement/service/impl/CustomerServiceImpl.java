package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Customer;
import com.smart.workmanagement.model.Status;
import com.smart.workmanagement.repo.AddressRepo;
import com.smart.workmanagement.repo.CustomerRepo;
import com.smart.workmanagement.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Customer customer = customerRepo.findById(id).orElse(null);
        if (customer == null) {
            log.warn("IN findById - no customer found by id: {}", id);
            return null;
        }
        log.info("IN findById - customer found by id: {}", customer);
        return customer;
    }

    @Override
    public void create(Customer customer) {
        customer.setCreatedDate(LocalDateTime.now());
        customer.setStatus(Status.ACTIVE);
        Customer createdCustomer = customerRepo.save(customer);
        log.info("IN create - customer: {} successfully registered", createdCustomer);
    }

    @Override
    public void delete(Long id) {
        customerRepo.deleteById(id);
        log.info("IN delete - customer with id: {} successfully deleted", id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerRepo.findAll();
        log.info("IN getAll - {} orders found", customers.size());
        return customers;
    }
}