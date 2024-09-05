package com.example.security5jwtapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "(security5jwtapp), the spring boot app implemented with the spring security. the goal is how to database (H2) authentication works";
	}
}

