package com.example.security4app.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUser implements UserDetails{
	
	private User u;

	public LoginUser(User u) {
		this.u = u;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("READ_ONLY"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return u.getPassword();
	}

	@Override
	public String getUsername() {
		return u.getUsername();
	}
}
