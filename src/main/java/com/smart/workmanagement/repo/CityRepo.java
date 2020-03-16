package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}
