package com.smart.workmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "positions")
@Data
public class Position extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "positions")
    private List<User> users;
}
