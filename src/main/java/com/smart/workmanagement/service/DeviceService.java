package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Device;

import java.util.List;

public interface DeviceService {

    List<Device> getAllDevice();

    Device getById(Long id);

    void create(Device device);

    void delete(Long id);
}
