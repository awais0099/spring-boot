package com.example.springbootsecurityrestapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.springbootsecurityrestapi.auth.AuthenticationResponse;
import com.example.springbootsecurityrestapi.auth.RegisterRequest;
import com.example.springbootsecurityrestapi.entities.User;

public interface UserService {
	List<User> getUsers();
	AuthenticationResponse register(RegisterRequest registerRequest);
}
