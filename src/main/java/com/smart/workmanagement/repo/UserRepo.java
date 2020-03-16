package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
