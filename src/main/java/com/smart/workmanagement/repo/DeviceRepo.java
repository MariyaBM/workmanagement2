package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<Device, Long> {
}
