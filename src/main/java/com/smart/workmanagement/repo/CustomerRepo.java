package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
