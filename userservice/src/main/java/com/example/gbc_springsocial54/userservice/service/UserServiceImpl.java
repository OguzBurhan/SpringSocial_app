package com.example.gbc_springsocial54.userservice.service;

import com.example.gbc_springsocial54.userservice.model.user;
import com.example.gbc_springsocial54.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<user> findAll() {
        return userRepository.findAll();
    }

    @Override
    public user findById(String id) {
        Optional<user> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public user save(user user) {
        return userRepository.save(user);
    }

    @Override
    public user update(String id, user user) {
        if(userRepository.existsById(id)) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


