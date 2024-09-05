package com.example.springbootsecurityrestapi.services.impl;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.springbootsecurityrestapi.entities.User;
import com.example.springbootsecurityrestapi.services.JWTService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTServiceImpl implements JWTService {
	
	private final String SECRET_KEY = "55082cc799f41bfb926968aaf93ce0a1539e0bdaa93c8eb453501e5a430caef1";
	
	public String generateToken(User user) {
		System.out.println("* generateToken");
		
		var mytoken = Jwts
				.builder()
				.setSubject(user.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 86400000))
				.signWith(getSignatureKey(), SignatureAlgorithm.HS256).compact();
		
		System.out.println("mytoken");
		System.out.println(mytoken);
		return mytoken;
	}

	private SecretKey getSignatureKey() {
		System.out.println("* getSignatureKey");
		byte[] key = Decoders.BASE64URL.decode(SECRET_KEY);
		
		System.out.println("key");
		System.out.println(key);
		System.out.println(Keys.hmacShaKeyFor(key));
		
		return Keys.hmacShaKeyFor(key);
	}
	
}
