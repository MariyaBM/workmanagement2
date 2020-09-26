package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "work")
@Data
public class Work extends BaseEntity {

    private String name;

    private String dimension;

    private double price;

    private String note;
}
