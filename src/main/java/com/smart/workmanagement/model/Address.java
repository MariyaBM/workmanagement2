package com.smart.workmanagement.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "building_id")
//    private Building building;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "addresses_buildings",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "building_id"))
    private List<Building> buildings;

}
