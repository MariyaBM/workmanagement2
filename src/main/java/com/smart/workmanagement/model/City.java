package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id")
//    private Address address;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cities_addreses",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;
}
