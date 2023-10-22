package com.example.gbc_springsocial54.userservice.repository;

import com.example.gbc_springsocial54.userservice.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<user, String>{
    user findByUsername(String username);

}
