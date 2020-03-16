package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Customer;
import com.smart.workmanagement.model.Order;
import com.smart.workmanagement.model.User;

import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order getById(Long id);

    Order create(Order order, User user, Customer customer);

    void delete(Long id);
}
