package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello! This is Spring Security";
	}
	
	@GetMapping("/user/hello")
	public String helloUser()
	{
		return "Hello User";
	}
	
	@GetMapping("/admin/hello")
	public String helloAdmin()
	{
		return "Hello Admin";
	}
}
