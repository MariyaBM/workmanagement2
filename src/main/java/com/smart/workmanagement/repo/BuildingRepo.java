package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepo extends JpaRepository<Building, Long> {
}
