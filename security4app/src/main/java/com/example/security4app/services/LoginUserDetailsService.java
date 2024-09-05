package com.example.security4app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.security4app.entities.LoginUser;
import com.example.security4app.entities.User;
import com.example.security4app.repositories.LoginUserRepository;

public class LoginUserDetailsService implements UserDetailsService {
	
	@Autowired
	LoginUserRepository loginUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User current_user = loginUserRepository.findByUsername(username);
		System.out.println("* ================================================ *");
		System.out.println(current_user);
		return new LoginUser(current_user);
	}
}
