package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;

}
