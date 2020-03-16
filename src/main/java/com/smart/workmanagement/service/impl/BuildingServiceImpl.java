package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Building;
import com.smart.workmanagement.repo.BuildingRepo;
import com.smart.workmanagement.service.BuildingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepo buildingRepo;

    @Autowired
    public BuildingServiceImpl(BuildingRepo buildingRepo) {
        this.buildingRepo = buildingRepo;
    }

    @Override
    public List<Building> getAllBuilding() {
        List<Building> buildings = buildingRepo.findAll();
        log.info("IN getAllBuilding - {} buildings found", buildings.size());
        return buildings;
    }

    @Override
    public Building findById(Long id) {
        Building building = buildingRepo.findById(id).orElse(null);
        if (building == null) {
            log.warn("IN findById - no building found by id: {}", id);
            return null;
        }
        log.info("IN findById - building found by id: {}", building);
        return building;
    }
}
