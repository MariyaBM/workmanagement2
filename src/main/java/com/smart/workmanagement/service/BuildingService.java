package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Address;
import com.smart.workmanagement.model.Building;

import java.util.List;

public interface BuildingService {

    List<Building> getAllBuilding();

    Building findById(Long id);
}
