package com.smart.workmanagement.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "departament")
@Data
public class Departament extends BaseEntity {
    private String name;


}
