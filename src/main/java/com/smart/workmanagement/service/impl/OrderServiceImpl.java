package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Customer;
import com.smart.workmanagement.model.Order;
import com.smart.workmanagement.model.User;
import com.smart.workmanagement.repo.CustomerRepo;
import com.smart.workmanagement.repo.OrderRepo;
import com.smart.workmanagement.repo.UserRepo;
import com.smart.workmanagement.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final UserRepo userRepo;


    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, CustomerRepo customerRepo, UserRepo userRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = orderRepo.findAll();
        log.info("IN getAll - {} orders found", orders.size());
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
    public Order create(Order order, @AuthenticationPrincipal User user, Customer customer) {
        order.setCreationDate(LocalDateTime.now());

        order.setAuthor(user);

        order.setCustomer(customer);

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
