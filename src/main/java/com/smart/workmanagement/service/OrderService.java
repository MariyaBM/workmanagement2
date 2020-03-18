package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrder();

    Order getById(Long id);

    Order create(Order order);

    void delete(Long id);
}
