package com.example.gbc_springsocial54.userservice.service;


import com.example.gbc_springsocial54.userservice.model.user;
import java.util.List;

public interface UserService {
    List<user> findAll();
    user findById(String id);
    user save(user user);
    user update(String id, user user);
    boolean delete(String id);
}

