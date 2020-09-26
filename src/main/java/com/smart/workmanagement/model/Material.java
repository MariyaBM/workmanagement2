package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "material")
@Data
public class Material extends BaseEntity {

    private String name;

    private String dimension;

    private double price;

    private String note;
}
