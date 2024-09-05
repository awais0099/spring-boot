package com.example.security4app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "(security4app), the spring boot app implemented with the spring security. the goal is to know how the database (mysql) authentication works";
	}
}
