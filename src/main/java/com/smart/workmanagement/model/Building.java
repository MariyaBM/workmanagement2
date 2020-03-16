package com.smart.workmanagement.model;


import liquibase.pro.packaged.S;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "building")
@Data
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String building;
    private String office;
}