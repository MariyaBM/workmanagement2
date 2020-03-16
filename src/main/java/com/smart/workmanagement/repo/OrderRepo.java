package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
