package com.example.security4app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security4app.entities.User;

@Repository
public interface LoginUserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
