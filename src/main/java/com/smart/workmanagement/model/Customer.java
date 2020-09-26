package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer extends BaseEntity{


    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customers_contacts",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<Contact> contacts;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customers_addresses",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;




}
