package com.eureka.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
@RequestMapping("/payment")
public class AppOneController {
	@GetMapping("/data")
	public String getStatus()
	{
		return "Payment Service";
	}

}
