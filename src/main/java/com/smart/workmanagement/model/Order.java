package com.smart.workmanagement.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@ToString
public class Order extends BaseEntity {

    private String extId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    private Date startDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_group_id")
    private WorkGroup workGroup;

    private String customer;
    private String contact;
    private String address;
    private String workDescription;
    private Date endDate;
    private Date verificationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "verification_name_id")
    private User verificationName;
}
