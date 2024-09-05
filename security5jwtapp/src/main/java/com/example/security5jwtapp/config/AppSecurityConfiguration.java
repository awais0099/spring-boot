package com.example.security5jwtapp.config;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfiguration {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
			requests
			.requestMatchers("/h2-console/**").permitAll()
			.anyRequest().authenticated()
		);
		
		http.csrf(csrf -> csrf.disable());
		
		http.headers(
				headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
		);
		
		http.sessionManagement(session 
				-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));	
		http.httpBasic(withDefaults());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withUsername("user").password(passwordEncoder().encode("123")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("123")).roles("ADMIN").build();
		
		UserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(admin);
		
		return userDetailsManager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
