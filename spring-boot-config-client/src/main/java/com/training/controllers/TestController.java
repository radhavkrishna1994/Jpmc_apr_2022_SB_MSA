package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.config.MyConfiguration;

@RestController
public class TestController {

	@Autowired
	private MyConfiguration config;
	
	@GetMapping("/message")
	public String getMessage()
	{
		return config.getMessage();
	}
}
