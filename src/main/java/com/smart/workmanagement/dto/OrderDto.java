package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Order;
import com.smart.workmanagement.model.Status;
import com.smart.workmanagement.model.User;
import com.smart.workmanagement.model.WorkGroup;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    private Long id;
    private String extId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;
    private String status;
    private UserDto author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    private WorkGroup workGroup;
    private String customer;
    private String contact;
    private String address;
    private String workDescription;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date verificationDate;
    private UserDto verificationName;

    public Order toOrder() {
        Order order = new Order();
        User user = new User();
        order.setId(id);
        order.setExtId(extId);
        order.setCreatedDate(createdDate);
        order.setUpdatedDate(updatedDate);
        order.setStatus(Status.valueOf(status));
        order.setAuthor(UserDto.fromUser(user).toUser());
        order.setStartDate(startDate);
        order.setWorkGroup(workGroup);
        order.setCustomer(customer);
        order.setContact(contact);
        order.setAddress(address);
        order.setWorkDescription(workDescription);
        order.setEndDate(endDate);
        order.setVerificationDate(verificationDate);
        order.setVerificationName(UserDto.fromUser(user).toUser());

        return order;
    }

    public static OrderDto fromOrder(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setExtId(order.getExtId());
        orderDto.setCreatedDate(order.getCreatedDate());
        orderDto.setUpdatedDate(order.getUpdatedDate());
        orderDto.setStatus(order.getStatus().name());
        orderDto.setAuthor(UserDto.fromUser(order.getAuthor()));
        orderDto.setStartDate(order.getStartDate());
        orderDto.setWorkGroup(order.getWorkGroup());
        orderDto.setCustomer(order.getCustomer());
        orderDto.setContact(order.getContact());
        orderDto.setAddress(order.getAddress());
        orderDto.setWorkDescription(order.getWorkDescription());
        orderDto.setEndDate(order.getEndDate());
        orderDto.setVerificationDate(order.getVerificationDate());

        if (order.getVerificationName() != null) {
            orderDto.setVerificationName(UserDto.fromUser(order.getVerificationName()));
        }

        return orderDto;
    }

    public static List<OrderDto> orderDtoList(List<Order> orders) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        orders.forEach(order -> orderDtoList.add(fromOrder(order)));

        return orderDtoList;
    }

}
