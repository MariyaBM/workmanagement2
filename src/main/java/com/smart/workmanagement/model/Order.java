package com.smart.workmanagement.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity {

    private String extId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    private Date startDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_group_id")
    private WorkGroup workGroup;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_executors",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "executor_id"))
    private List<User> executors;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    private String workDescription;
    private Date endDate;
    private Date verificationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "verification_name_id")
    private User verificationName;
}
