package com.example.springboottodoapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		final int a = 23;
		
		System.out.println(str1.equals(str2)); // true, same content

		return "This is simple hello";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHellohtml() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<!DOCTYPE html>\n"
				+ "		<html lang=\"en\">");
		sb.append("<head>");
		sb.append("<title>My first html Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
