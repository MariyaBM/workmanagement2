package com.smart.workmanagement.controller;


import com.smart.workmanagement.dto.OrderDto;
import com.smart.workmanagement.model.Order;
import com.smart.workmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/order/")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> listOrders() {
        List<Order> orders = orderService.getAllOrders();

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(OrderDto.orderDtoList(orders), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name = "id") Long id) {
        Order order = orderService.getById(id);

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        OrderDto result = OrderDto.fromOrder(order);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
