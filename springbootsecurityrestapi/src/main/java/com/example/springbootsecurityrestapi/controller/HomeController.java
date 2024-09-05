package com.example.springbootsecurityrestapi.controller;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootsecurityrestapi.auth.AuthenticationRequest;
import com.example.springbootsecurityrestapi.auth.AuthenticationResponse;
import com.example.springbootsecurityrestapi.auth.RegisterRequest;
import com.example.springbootsecurityrestapi.entities.User;
import com.example.springbootsecurityrestapi.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	UserService userService;

	@GetMapping("/user")
	public List<User> getUser() {
		System.out.println("** getUser ");

		return this.userService.getUsers();
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
		System.out.println("1: /register");
		System.out.println(registerRequest);
		AuthenticationResponse token = this.userService.register(registerRequest);
		
		System.out.println(token);
		
		return ResponseEntity.ok(token);
	}

	@GetMapping("/hello")
	public String hello() {
		AuthenticationResponse authResponse = new AuthenticationResponse();
		
		return "";
	}
}
