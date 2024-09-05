package com.example.springbootsecurityrestapi.auth;

import com.example.springbootsecurityrestapi.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String secondname;
    private String email;
    private String password;
    private Role role;
}