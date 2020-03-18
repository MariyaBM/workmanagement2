package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "contact")
@Data
public class Contact extends BaseEntity {

    private String name;
    private String phone;

}
