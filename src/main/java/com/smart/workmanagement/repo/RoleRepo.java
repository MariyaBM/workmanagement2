package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoles(String roles);
}
