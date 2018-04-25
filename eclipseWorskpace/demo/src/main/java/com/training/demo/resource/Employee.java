package com.training.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Employee {
	
	@GetMapping("/greeting")
	String getGreeting() {
		return "Hello World!";
	}
	
}
