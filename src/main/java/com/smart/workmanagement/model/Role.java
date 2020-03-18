package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {

    private String roles;

//    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
//    private List<User> users;

}
