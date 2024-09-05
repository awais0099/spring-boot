package com.example.springbootsecurityrestapi.services;

import com.example.springbootsecurityrestapi.entities.User;

public interface JWTService {
	
	public String generateToken(User user);
}
