package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {

    private String roles;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
