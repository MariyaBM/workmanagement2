package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepo extends JpaRepository<Work, Long> {
}
