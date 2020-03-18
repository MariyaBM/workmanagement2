package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Order;
import com.smart.workmanagement.repo.OrderRepo;
import com.smart.workmanagement.repo.UserRepo;
import com.smart.workmanagement.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;


    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = orderRepo.findAll();
        log.info("IN getAllOrder - {} orders found", orders.size());
        return orders;
    }

    @Override
    public Order getById(Long id) {
        Order order = orderRepo.findById(id).orElse(null);

        if (order == null) {
            log.warn("IN findById - no order found by id: {}", id);
            return null;
        }
        log.info("IN findById - order found by id: {}", order);
        return order;
    }

    @Override
    public Order create(Order order) {
        order.setCreatedDate(LocalDateTime.now());

        Order createdOrder = orderRepo.save(order);
        log.info("IN create - order: {} successfully registered", createdOrder);
        return createdOrder;
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
        log.info("IN delete - order with id: {} successfully deleted", id);
    }
}
