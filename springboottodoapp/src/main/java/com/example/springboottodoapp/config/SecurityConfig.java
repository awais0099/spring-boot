package com.example.springboottodoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

		UserDetails user = User
				.withUsername("user")
				.password(passwordEncoder().encode("123"))
				.roles("USER")
				.authorities("read")
				.build();

		UserDetails admin = User
				.withUsername("admin")
				.password(passwordEncoder().encode("123"))
				.roles("ADMIN")
				.build();

		userDetailsManager.createUser(user);
		userDetailsManager.createUser(admin);
		
		// return new InMemoryUserDetailsManager(user, admin);
        return userDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> 
			auth
			.requestMatchers("/h2-console/**").permitAll()
			.anyRequest().authenticated()
		);
		http.formLogin();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}
