package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "work_group")
@Data
public class WorkGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupList;
}
