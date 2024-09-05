package com.example.security5jwtapp.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("#{spring.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("#{spring.app.jwtExpiration}")
	private String jwtExpiration;
	
	public String getJwtFromHeader(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		logger.debug("Authorization Header: {}", bearerToken);
		
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		
		return null;
	}
	
	public String generateToken(UserDetails userDetails) {
		String username = userDetails.getUsername();
		
		var mytoken = Jwts
				.builder()
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + jwtExpiration))
				.signWith(getSignatureKey()).compact();
		
		return mytoken;
	}
	
	private Key getSignatureKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(jwtSecret));
	}
	
	public String getUserNameFromToken(String token) {
		return Jwts
				.parser()
				.verifyWith((SecretKey) getSignatureKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
		System.out.println("Validate");
		try {
			Jwts.parser().verifyWith((SecretKey) getSignatureKey()).build().parseSignedClaims(authToken);
			return true;
		} catch (Exception e) {
			logger.error("Invalid jwt token: {}", e.getMessage());
		}
		
		return false;
	}
}
