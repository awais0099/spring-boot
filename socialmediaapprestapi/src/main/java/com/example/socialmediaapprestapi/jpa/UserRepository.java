package com.example.socialmediaapprestapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmediaapprestapi.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
