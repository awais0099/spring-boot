package com.example.socialmediaapprestapi;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping("/hello-wold")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/hello-wold-internationalized")
	public String helloInternationalized() {
		Locale local = LocaleContextHolder.getLocale();
		System.out.println(local);
		return messageSource.getMessage("good.morning.message", null, "Default message", local);
	}
}
