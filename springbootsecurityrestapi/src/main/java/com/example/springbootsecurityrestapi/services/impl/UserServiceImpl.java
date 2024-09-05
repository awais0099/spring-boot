package com.example.springbootsecurityrestapi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springbootsecurityrestapi.auth.AuthenticationResponse;
import com.example.springbootsecurityrestapi.auth.RegisterRequest;
import com.example.springbootsecurityrestapi.entities.Role;
import com.example.springbootsecurityrestapi.entities.User;
import com.example.springbootsecurityrestapi.repository.UserRepository;
import com.example.springbootsecurityrestapi.services.JWTService;
import com.example.springbootsecurityrestapi.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	JWTService jwtService;
	
	private List<User> store = new ArrayList<User>();
	
	public UserServiceImpl() {
		User user = new User();
		user.setFirstname("f name");
		user.setSecondname("s name");
		user.setEmail("test@gmail.com");
		user.setRole(Role.ADMIN);
		this.store.add(user);
	}

	@Override
	public List<User> getUsers() {
		return this.store;
	}
	
	public AuthenticationResponse register(RegisterRequest registerRequest) {
		System.out.println("2: UserService imp register()");
		var user = User.builder()
			.firstname(registerRequest.getFirstname())
			.secondname(registerRequest.getSecondname())
			.email(registerRequest.getEmail())
			.password(registerRequest.getPassword())
			.role(registerRequest.getRole())
			.build();
		
		var savedUser = this.userRepository.save(user);
		String token = jwtService.generateToken(user);
		
		return AuthenticationResponse.builder().accessToken(token).build();
	}
}
