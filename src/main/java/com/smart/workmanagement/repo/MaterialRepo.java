package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepo extends JpaRepository<Material, Long> {
}
