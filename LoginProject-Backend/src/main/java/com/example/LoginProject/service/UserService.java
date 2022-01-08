package com.example.LoginProject.service;

import com.example.LoginProject.domain.Role;
import com.example.LoginProject.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
