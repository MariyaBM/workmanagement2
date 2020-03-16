package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    Address findById(Long id);
}
