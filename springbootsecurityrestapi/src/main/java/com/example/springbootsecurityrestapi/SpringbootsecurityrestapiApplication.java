package com.example.springbootsecurityrestapi;

import javax.crypto.SecretKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class SpringbootsecurityrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootsecurityrestapiApplication.class, args);

		System.out.println("======================================================");
		System.out.println("======================================================");
		System.out.println("======================================================");
		
	}

}
