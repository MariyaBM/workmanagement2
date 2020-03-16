package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.WorkGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkGroupRepo extends JpaRepository<WorkGroup, Long> {
}
