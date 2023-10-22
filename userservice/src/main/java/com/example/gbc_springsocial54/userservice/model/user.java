package com.example.gbc_springsocial54.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") // MongoDB collection
public class user {
	@Id
	private String id;
	private String username;
	private String password;
	// Getters and setters (You can generate them manually)
}
