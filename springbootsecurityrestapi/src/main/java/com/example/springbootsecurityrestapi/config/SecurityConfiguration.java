package com.example.springbootsecurityrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("* securityFilterChain");
		
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req -> 
					req.requestMatchers("/home/register").permitAll()
						.requestMatchers("/home/hello").permitAll()
						.anyRequest()
						.authenticated()
				)
				.build();
	}
}
