package com.severinu.jwttest.service;

import com.severinu.jwttest.domain.Role;
import com.severinu.jwttest.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
