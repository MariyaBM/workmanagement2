package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Address;
import com.smart.workmanagement.repo.AddressRepo;
import com.smart.workmanagement.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    @Autowired
    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public List<Address> getAllAddress() {
        List<Address> addresses = addressRepo.findAll();
        log.info("IN getAllAddress - {} addresses found", addresses.size());
        return addresses;
    }

    @Override
    public Address findById(Long id) {
        Address address = addressRepo.findById(id).orElse(null);

        if (address == null) {
            log.warn("IN findById - no address found by id: {}", id);
            return null;
        }
        log.info("IN findById - address found by id: {}", address);
        return address;
    }
}
