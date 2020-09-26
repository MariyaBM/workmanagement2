package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Device;
import com.smart.workmanagement.model.Status;
import com.smart.workmanagement.repo.DeviceRepo;
import com.smart.workmanagement.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepo deviceRepo;

    @Autowired
    public DeviceServiceImpl(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }


    @Override
    public List<Device> getAllDevice() {
        List<Device> devices = deviceRepo.findAll();
        log.info("IN getAllDevices - {} devices found", devices.size());
        return devices;
    }

    @Override
    public Device getById(Long id) {
        Device device = deviceRepo.findById(id).orElse(null);
        if (device == null) {
            log.warn("IN findById - no device found by id: {}", id);
            return null;
        }
        log.info("IN findById - device found by id: {}", device);
        return device;
    }

    @Override
    public void create(Device device) {
        device.setCreatedDate(LocalDateTime.now());
        device.setStatus(Status.ACTIVE);
        Device createdDevice = deviceRepo.save(device);
        log.info("IN create - device: {} successfully registered", createdDevice);

    }

    @Override
    public void delete(Long id) {
        Device device = deviceRepo.findById(id).orElse(null);
        if (device == null) {
            log.warn("IN findById - no device found by id: {}", id);
        } else {
            device.setStatus(Status.DELETED);
        }
        deviceRepo.deleteById(id);

    }
}
