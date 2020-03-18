package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Data
public class Address extends BaseEntity {

    private String name;

}