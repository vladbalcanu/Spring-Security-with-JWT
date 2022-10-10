package com.example.test.service;

import com.example.test.domain.AppUser;
import com.example.test.domain.Role;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser>getUsers();
}
