package com.example.socialmediaapprestapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmediaapprestapi.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}