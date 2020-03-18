package com.smart.workmanagement.service;

import com.smart.workmanagement.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAllUsers();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
